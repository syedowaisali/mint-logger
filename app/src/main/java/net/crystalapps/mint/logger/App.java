package net.crystalapps.mint.logger;

import android.app.Application;
import android.support.annotation.Nullable;

import net.crystalapps.mint.logger.library.adapters.AndroidLogAdapter;
import net.crystalapps.mint.logger.library.core.MintLog;

/**
 * Created by Syed Owais Ali on 10/29/2018.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        setupLogger();
    }

    private void setupLogger() {
        MintLog.addAdapter(new AndroidLogAdapter(){
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }
}
