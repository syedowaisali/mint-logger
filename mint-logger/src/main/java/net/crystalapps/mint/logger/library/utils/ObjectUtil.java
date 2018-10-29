package net.crystalapps.mint.logger.library.utils;

/**
 * Created by Syed Owais Ali on 5/3/2018.
 */

@SuppressWarnings("WeakerAccess")
public class ObjectUtil {

    public static <T> T requireNonNull(T obj) {
        return requireNonNull(obj, null);
    }

    public static <T> T requireNonNull(T obj, String message) {
        if (obj == null)
            throw new NullPointerException(message);
        return obj;
    }
}
