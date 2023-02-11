# libGDX Kotlin Template

To write your game in Kotlin with Gradle Kotlin DSL.

## How to use
### Clone this repo
You'd better not to hit the green button, `Use this template`, because it will create a new repository referencing to this
repo.

Run the shell script below in your terminal to clone this repo. It works on both Windows and Unix-like system, if you've installed git.
```shell
git clone --depth 1 https://github.com/liplum/libGDXTemplateKt.git
```
Then change directory to `libGDXTemplateGame` folder, or whatever you named, 
and delete the `.git` folder that contains git history from this repo. 

### Download release
Check the [release page](https://github.com/liplum/libGDXTemplateKt/releases) and find which one you want.

You can just download the source code, `.zip` or `.tar.gz`, to get an archive. 

When this template is changed due to an upgrade of libGDX, the release is considered a backup. 

### Rename to yours
Then, replace the strings or packages to yours in the following positions.

It's recommended to refactor/replace all with an IDE.

- `androidApplicationId=net.liplum.libGDXTemplateGame` in [gradle.properties](gradle.properties).
- `appName=libGDXTemplateGame` in [gradle.properties](gradle.properties).
- `package="net.liplum"` in [AndroidManifest.xml](android/src/main/AndroidManifest.xml).
- `android:name="net.liplum.AndroidLauncher"` in [AndroidManifest.xml](android/src/main/AndroidManifest.xml).
- The package of [`AndroidLanucher` class](android/src/main/kotlin/net/liplum/AndroidLauncher.kt) in `:android`.
- The package of [`LibGdxTemplateGame` class](core/src/net/liplum/LibGdxTemplateGame.java) in `:core`.
- The package of [`DesktopLauncher` class](desktop/src/net/liplum/DesktopLauncher.java) in `:desktop`.
- The package of [`IOSLauncher` class](ios/src/net/liplum/IOSLauncher.java) in `:ios`.
- `app.mainclass=net.liplum.IOSLauncher`, `app.id=net.liplum.libGDXTemplateGame` and `app.name=libGDXTemplateGame`
  in [robovm.properties](ios/robovm.properties) in `:ios`.