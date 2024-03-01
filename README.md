# EasyFood
EasyFood is an app that makes making food easier and gives you full information about the selected meal including instructions of how to make that meal provided by a video.

## Libraries and technologies used
**Navigation component** : one activity contains multiple fragments instead of creating multiple activites

**Retrofit** : making HTTP connection with the rest API and convert meal json file to Kotlin/Java object.

**Room** : Save meals in local database.

**MVVM & LiveData** : Separate logic code from views and save the state in case the screen configuration changes.

**Coroutines** : do some code in the background.

**view binding** : instead of inflating views manually view binding will take care of that.

**Glide** : Catch images and load them in imageView.
