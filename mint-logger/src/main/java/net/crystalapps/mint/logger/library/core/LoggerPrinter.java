package net.crystalapps.mint.logger.library.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import net.crystalapps.mint.logger.library.utils.TextUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Syed Owais Ali on 5/10/2018.
 */

@SuppressWarnings("WeakerAccess")
public class LoggerPrinter implements Printer {

    private final List<LogAdapter> logAdapters;

    public LoggerPrinter() {
        logAdapters = new LinkedList<>();
    }

    @Override
    public void addAdapter(@NonNull LogAdapter adapter) {
        logAdapters.add(adapter);
    }

    @Override
    public void clearLogAdapters() {
        logAdapters.clear();
    }

    @Override
    public void d(@NonNull String message, @Nullable Object... args) {
        d(null, message, args);
    }

    @Override
    public void d(@Nullable String tag, @NonNull String message, @Nullable Object... args) {
        log(MintLog.DEBUG, null, tag, message, args);
    }

    @Override
    public void d(@Nullable Object object) {
        d(null, object);
    }

    @Override
    public void d(@Nullable String tag, @Nullable Object object) {
        log(MintLog.DEBUG, null, tag, toString(object));
    }

    @Override
    public void e(@NonNull String message, @Nullable Object... args) {
        e(null, null, message, args);
    }

    @Override
    public void e(@Nullable String tag, @NonNull String message, @Nullable Object... args) {
        e(tag, null, message, args);
    }

    @Override
    public void e(@Nullable Throwable throwable, @NonNull String message, @Nullable Object... args) {
        e(null, throwable, message, args);
    }

    @Override
    public void e(@Nullable String tag, @Nullable Throwable throwable, @NonNull String message, @Nullable Object... args) {
        log(MintLog.ERROR, throwable, tag, message, args);
    }

    @Override
    public void w(@NonNull String message, @Nullable Object... args) {
        w(null, message, args);
    }

    @Override
    public void w(@Nullable String tag, @NonNull String message, @Nullable Object... args) {
        log(MintLog.WARN, null, tag, message, args);
    }

    @Override
    public void i(@NonNull String message, @Nullable Object... args) {
        i(null, message, args);
    }

    @Override
    public void i(@Nullable String tag, @NonNull String message, @Nullable Object... args) {
        log(MintLog.INFO, null, tag, message, args);
    }

    @Override
    public void v(@NonNull String message, @Nullable Object... args) {
        v(null, message, args);
    }

    @Override
    public void v(@Nullable String tag, @NonNull String message, @Nullable Object... args) {
        log(MintLog.VERBOSE, null, tag, message, args);
    }

    @Override
    public void wtf(@NonNull String message, @Nullable Object... args) {
        wtf(null, message, args);
    }

    @Override
    public void wtf(@Nullable String tag, @NonNull String message, @Nullable Object... args) {
        log(MintLog.ASSERT, null, tag, message, args);
    }

    @Override
    public void log(int priority, @Nullable String tag, @NonNull String message, @Nullable Throwable throwable) {

        if (throwable != null) {
            message += " : " + TextUtil.getStackTraceString(throwable);
        }

        if (TextUtil.isEmpty(message)) {
            message = "NotEmpty Message";
        }

        for (LogAdapter logAdapter : logAdapters) {
            if (logAdapter.isLoggable(priority, tag)) {
                logAdapter.log(priority, tag, message);
            }
        }
    }

    private void log(int priority, @Nullable Throwable throwable, @Nullable String tag, @NonNull String message, @Nullable Object... args) {
        log(priority, tag, createMessage(message, args), throwable);
    }

    @NonNull
    private String createMessage(@NonNull String message, @Nullable Object... args) {
        return args == null || args.length == 0 ? message : String.format(message, args);
    }

    private static String toString(Object object) {
        if (object == null) {
            return "null";
        }
        if (!object.getClass().isArray()) {
            return object.toString();
        }
        if (object instanceof boolean[]) {
            return Arrays.toString((boolean[]) object);
        }
        if (object instanceof byte[]) {
            return Arrays.toString((byte[]) object);
        }
        if (object instanceof char[]) {
            return Arrays.toString((char[]) object);
        }
        if (object instanceof short[]) {
            return Arrays.toString((short[]) object);
        }
        if (object instanceof int[]) {
            return Arrays.toString((int[]) object);
        }
        if (object instanceof long[]) {
            return Arrays.toString((long[]) object);
        }
        if (object instanceof float[]) {
            return Arrays.toString((float[]) object);
        }
        if (object instanceof double[]) {
            return Arrays.toString((double[]) object);
        }
        if (object instanceof Object[]) {
            return Arrays.deepToString((Object[]) object);
        }
        return "Couldn't find a correct type for the object";
    }
}
