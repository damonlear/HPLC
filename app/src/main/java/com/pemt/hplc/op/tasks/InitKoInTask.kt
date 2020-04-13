package com.pemt.hplc.op.tasks

import com.fmt.launch.starter.task.Task
import com.pemt.hplc.op.di.appModule
import org.koin.core.context.startKoin

class InitKoInTask : Task() {

    override fun run() {
        startKoin {
            modules(appModule)
        }
    }
}