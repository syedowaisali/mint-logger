package net.crystalapps.mint.logger.library.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Syed Owais Ali on 5/10/2018.
 */

public interface Printer {

    void addAdapter(@NonNull LogAdapter adapter);
    void clearLogAdapters();

    void d(@NonNull String message, @Nullable Object... args);
    void d(@Nullable String tag, @NonNull String message, @Nullable Object... args);
    void d(@NonNull Object object);
    void d(@Nullable String tag, @NonNull Object object);

    void e(@NonNull String message, @Nullable Object... args);
    void e(@Nullable String tag, @NonNull String message, @Nullable Object... args);
    void e(@Nullable Throwable throwable, @NonNull String message, @Nullable Object... args);
    void e(@Nullable String tag, @Nullable Throwable throwable, @NonNull String message, @Nullable Object... args);

    void w(@NonNull String message, @Nullable Object... args);
    void w(@Nullable String tag, @NonNull String message, @Nullable Object... args);

    void i(@NonNull String message, @Nullable Object... args);
    void i(@Nullable String tag, @NonNull String message, @Nullable Object... args);

    void v(@NonNull String message, @Nullable Object... args);
    void v(@Nullable String tag, @NonNull String message, @Nullable Object... args);

    void wtf(@NonNull String message, @Nullable Object... args);
    void wtf(@Nullable String tag, @NonNull String message, @Nullable Object... args);

    void log(int priority, @Nullable String tag, @NonNull String message, @Nullable Throwable throwable);

}
