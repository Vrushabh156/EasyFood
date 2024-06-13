package com.appsbit.easyfood.ui.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appsbit.easyfood.data.models.MealByCategoryList
import com.appsbit.easyfood.data.models.MealsByCategory
import com.appsbit.easyfood.data.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryMealsViewModel : ViewModel() {
    val mealsLiveData = MutableLiveData<List<MealsByCategory>>()
    private val snackbarMessage = MutableLiveData<String>()

    fun getMealsByCategory(categoryName: String) {
        RetrofitInstance.api.getMealsByCategory(categoryName)
            .enqueue(object : Callback<MealByCategoryList> {
                override fun onResponse(
                    call: Call<MealByCategoryList>,
                    response: Response<MealByCategoryList>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { mealsList ->
                            mealsLiveData.postValue(mealsList.meals)
                        } ?: run {
                            snackbarMessage.postValue("Response body is null.")
                        }
                    } else {
                        snackbarMessage.postValue(
                            "API call failed with code: ${response.code()}"
                        )
                    }
                }

                override fun onFailure(call: Call<MealByCategoryList>, t: Throwable) {
                    snackbarMessage.postValue(t.message)
                }
            })
    }

    fun observeMealsLiveData(): LiveData<List<MealsByCategory>> {
        return mealsLiveData
    }
    fun observeSnackbarMessage(): LiveData<String> = snackbarMessage
}