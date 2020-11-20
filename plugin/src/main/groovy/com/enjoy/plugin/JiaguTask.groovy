package com.enjoy.plugin

import com.android.builder.model.SigningConfig
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction;

class JiaguTask extends DefaultTask {

    Jiagu jiagu
    SigningConfig signingConfig
    File apk

    JiaguTask() {
        group = "jiagu"
    }

    @TaskAction
    def run() {
        //调用命令行工具
        project.exec {
            // java -jar jiagu.jar -login user password
            it.commandLine("java", "-jar", jiagu.jiaguTools, "-login", jiagu.userName, jiagu.password)
        }

        if (signingConfig) {
            project.exec {
                // java -jar jiagu.jar -importsign  xxxx
                it.commandLine("java", "-jar", jiagu.jiaguTools, "-importsign", signingConfig.storeFile.absolutePath,
                        signingConfig.storePassword, signingConfig.keyAlias, signingConfig.keyPassword)
            }
        }
        project.exec {
            // java -jar jiagu.jar -jiagu  xxxx
            it.commandLine("java", "-jar", jiagu.jiaguTools, "-jiagu", apk.absolutePath,
                    apk.parent, "-autosign")
        }
    }
}
