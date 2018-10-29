package net.crystalapps.mint.logger.library.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static net.crystalapps.mint.logger.library.utils.ObjectUtil.requireNonNull;


/**
 * Created by Syed Owais Ali on 5/10/2018.
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public class MintLog{

    public static final int VERBOSE = 2;
    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;
    public static final int ASSERT = 7;

    @NonNull private static Printer printer = new LoggerPrinter();

    public static void addAdapter(@NonNull LogAdapter adapter) {
        printer.addAdapter(requireNonNull(adapter));
    }

    public static void clearLogAdapters() {
        printer.clearLogAdapters();
    }

    public static void changePrinter(@NonNull Printer printer) {
        MintLog.printer = requireNonNull(printer);
    }

    public static void d(@NonNull String message, @Nullable Object... args) {
        printer.d(requireNonNull(message), args);
    }

    public static void d(@Nullable String tag, @NonNull String message, @Nullable Object... args) {
        printer.d(tag, requireNonNull(message), args);
    }

    public static void d(@NonNull Object object) {
        printer.d(requireNonNull(object));
    }

    public static void d(@Nullable String tag, @NonNull Object object) {
        printer.d(tag, requireNonNull(object));
    }

    public static void e(@NonNull String message, @Nullable Object... args) {
        printer.e(requireNonNull(message), args);
    }

    public static void e(@Nullable String tag, @NonNull String message, @Nullable Object... args) {
        printer.e(tag, requireNonNull(message), args);
    }

    public static void e(@Nullable Throwable throwable, @NonNull String message, @Nullable Object... args) {
        printer.e(throwable, requireNonNull(message), args);
    }

    public static void e(@Nullable String tag, @Nullable Throwable throwable, @NonNull String message, @Nullable Object... args) {
        printer.e(tag, throwable, requireNonNull(message), args);
    }

    public static void w(@NonNull String message, @Nullable Object... args) {
        printer.w(requireNonNull(message), args);
    }

    public static void w(@Nullable String tag, @NonNull String message, @Nullable Object... args) {
        printer.w(tag, requireNonNull(message), args);
    }

    public static void i(@NonNull String message, @Nullable Object... args) {
        printer.i(requireNonNull(message), args);
    }

    public static void i(@Nullable String tag, @NonNull String message, @Nullable Object... args) {
        printer.i(tag, requireNonNull(message), args);
    }

    public static void v(@NonNull String message, @Nullable Object... args) {
        printer.v(requireNonNull(message), args);
    }

    public static void v(@Nullable String tag, @NonNull String message, @Nullable Object... args) {
        printer.v(tag, requireNonNull(message), args);
    }

    public static void wtf(@NonNull String message, @Nullable Object... args) {
        printer.wtf(requireNonNull(message), args);
    }

    public static void wtf(@Nullable String tag, @NonNull String message, @Nullable Object... args) {
        printer.wtf(tag, requireNonNull(message), args);
    }

    public static void log(int priority, @Nullable String tag, @NonNull String message, @Nullable Throwable throwable) {
        printer.log(priority, tag, requireNonNull(message), throwable);
    }
}