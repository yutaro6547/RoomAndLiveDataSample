package www.rozkey59.tokyo.roomsample

import android.app.Application
import com.facebook.stetho.Stetho

class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()

        Stetho.initialize(
            Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build()
        )
    }

}