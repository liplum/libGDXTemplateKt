# libGDX Template

### *With Gradle Kotlin DSL*

## How to use
### Clone this repo
First, clone this repository.
You'd better not to hit the green button, `Use this template`, because it will create a new repository referencing to this
repo.

```shell
git clone --depth 1 https://github.com/liplum/libGDXTemplateGame.git
```

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