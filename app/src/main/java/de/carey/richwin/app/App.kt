package de.carey.richwin.app

import android.app.Application
import com.avos.avoscloud.AVOSCloud
import de.carey.richwin.util.delegate.NotNullSingleValueVar

class App : Application() {

    companion object {
        var instance: App by NotNullSingleValueVar.DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        // 放在 SDK 初始化语句 AVOSCloud.initialize() 后面，只需要调用一次即可
        AVOSCloud.setDebugLogEnabled(true)
        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this, "9O6y1kgyR9cUF2qpEvAyDKza-gzGzoHsz", "BOa5KlCxKU2syG5cFL6QPE5P")
    }
}