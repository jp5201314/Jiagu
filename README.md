# # Jiagu
需要在工程的build.gradle中配置Jcenter仓库和配置插件classpath
```
buildscript {
    repositories{
            maven  {
                jcenter()
             }
         }
    dependencies {
        classpath 'com.enjoy:jiagu:1.0.0' 
    }
}
```
然后到应用工程的build.gradle中
```
apply plugin:'com.enjoy.jiagu'
```
### 例 Library/360jiagubao_mac/jiagu/jiagu.jar  360加固应用目录
```
jiagu {
    userName  '360加固账号'
    password '360加固密码'
    jiaguTools '360加固应用目录' 
}
```
这个配置后Gradle侧窗中就会出现jiagu这个插件了，一键加固Dubug包或者Release包

在加固之前需要在app工程下的build/outputs/apk目录中生成待加固的apk
