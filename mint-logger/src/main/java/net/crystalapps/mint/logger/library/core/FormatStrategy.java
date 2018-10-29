package net.crystalapps.mint.logger.library.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Syed Owais Ali on 5/10/2018.
 */

public interface FormatStrategy {

    void log(int priority, @Nullable String tag, @NonNull String message);
}
