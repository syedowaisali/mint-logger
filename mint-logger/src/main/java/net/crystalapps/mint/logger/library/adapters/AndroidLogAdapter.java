package net.crystalapps.mint.logger.library.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import net.crystalapps.mint.logger.library.core.FormatStrategy;
import net.crystalapps.mint.logger.library.core.LogAdapter;
import net.crystalapps.mint.logger.library.formats.StyleLogFormatStrategy;
import net.crystalapps.mint.logger.library.utils.ObjectUtil;


/**
 * Created by Syed Owais Ali on 5/10/2018.
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public class AndroidLogAdapter implements LogAdapter {

    @NonNull
    private final FormatStrategy formatStrategy;

    public AndroidLogAdapter() {
        this(StyleLogFormatStrategy.newBuilder().build());
    }

    public AndroidLogAdapter(@NonNull FormatStrategy formatStrategy) {
        this.formatStrategy = ObjectUtil.requireNonNull(formatStrategy);
    }

    @Override
    public boolean isLoggable(int priority, @Nullable String tag) {
        return true;
    }

    @Override
    public void log(int priority, @Nullable String tag, @NonNull String message) {
        formatStrategy.log(priority, tag, message);
    }
}
