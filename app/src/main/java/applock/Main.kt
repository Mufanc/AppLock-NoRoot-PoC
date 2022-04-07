package applock

import android.os.ServiceManager
import miui.process.ProcessCloudData
import miui.process.ProcessManagerNative

object Main {  // run deploy.sh
    @JvmStatic
    fun main(args: Array<String>) {
        val service = ProcessManagerNative.asInterface(ServiceManager.getService("ProcessManager"))
        val data = ProcessCloudData()
        val list = emptyList<String>()
//        val list = listOf("com.netease.cloudmusic")
        data.setCloudWhiteList(list)
        service.updateCloudData(data)
        println(list)
        println("done.")
    }
}