package net.crystalapps.mint.logger.library.formats;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import net.crystalapps.mint.logger.library.core.LogStrategy;

/**
 * Created by Syed Owais Ali on 5/10/2018.
 */

public class LogcatLogStrategy implements LogStrategy {

    @Override
    public void log(int priority, @Nullable String tag, @NonNull String message) {
        Log.println(priority, tag == null ? "MINT_LOG" : tag, message);
    }
}
