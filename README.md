# HaoLin_Component_Sample -- 组件化Demo

 ## 关于组件化
- 组件化建立

  ① 在项目中newMoudle选择 Phone & Table Moudle
  
  ② 可以单独运行每一个新建的该moudle
  
  ③ 项目在开发时该moudle作为Application出现，在打包出APK时作为Lib出现
  
  ④ 建立该moudle的同时，必须再建一个Andorid Lib，可互相引用调用该moudle
  

- 全局配置gradle环境

  ① 在gradle.properties加入全局变量
    ```xml

          compile_sdk_version = 28
          min_sdk_version = 19
          target_sdk_version = 28
          support_version = 28.0.0
          constraint_layout = 1.1.3

          配置某个组件可否独立运行 此处必须得注意 最终打包APK的时候必须得改为false
          loginRunAlone = false
          mineRunAlone = false
    ```
   ② 在Phone Moudle 中 以 LoginComPonent为例 build.gradle中
   ```xml
            如果可以单独运行 表明是Application 否则为lib
            if (loginRunAlone.toBoolean()) {
                apply plugin: 'com.android.application'
            } else {
                apply plugin: 'com.android.library'
            }

            android {
                //全局引用变量 可为Phone Moudle 以及主APP的 bulde.gradle 做统一修改
                compileSdkVersion compile_sdk_version.toInteger()

                defaultConfig {

                    if (loginRunAlone.toBoolean()) {
                        applicationId "com.haolin.logincomponent"
                    }
                    minSdkVersion min_sdk_version.toInteger()
                    targetSdkVersion target_sdk_version.toInteger()
                    versionCode 1
                    versionName "1.0"

                    testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"

                }

                buildTypes {
                    release {
                        minifyEnabled false
                        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
                    }
                }

                sourceSets{
                    main{
                        if (loginRunAlone.toBoolean()){ //如果可单独 不可单独运行 加载不同的 manifest 文件
                            manifest.srcFile "src/main/manifest/AndroidManifest.xml"
                        }else {
                            manifest.srcFile "src/main/AndroidManifest.xml"
                        }
                    }
                }
            }

            dependencies {
                implementation fileTree(include: ['*.jar'], dir: 'libs')
                implementation 'com.android.support:appcompat-v7:28.0.0'
                testImplementation 'junit:junit:4.12'
                implementation project(':HaoLinConentLibrary')
            }


   ```