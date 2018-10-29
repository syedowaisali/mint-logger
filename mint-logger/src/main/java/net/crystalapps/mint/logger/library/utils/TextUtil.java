package net.crystalapps.mint.logger.library.utils;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

/**
 * Created by Syed Owais Ali on 5/4/2018.
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public class TextUtil {

    public static boolean isEmpty(CharSequence text) {
        return !(text != null && text.toString().trim().length() > 0);
    }

    public static boolean isNotEmpty(CharSequence text) {
        return !isEmpty(text);
    }

    public static boolean isValidEmail(String emailAddress) {
        return TextUtil.isNotEmpty(emailAddress) && isValidWithRegex(emailAddress, Pattern.compile("^[\\w-+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", Pattern.CASE_INSENSITIVE));
    }

    public static boolean isValidURL(String url) {
        return TextUtil.isNotEmpty(url) && isValidWithRegex(url, Pattern.compile("^(http://www\\.|https://www\\.|http://|https://)?[a-z0-9]+([\\-.][a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(/.*)?$", Pattern.CASE_INSENSITIVE));
    }

    public static boolean isValidWithRegex(CharSequence text, String regex) {
        return isValidWithRegex(text, Pattern.compile(regex));
    }

    public static boolean isValidWithRegex(CharSequence text, Pattern pattern) {
        return pattern.matcher(text).find();
    }

    public static void addDelayWatcher(EditText editText, final long delay, OnDelayListener delayListener) {

        ObjectUtil.requireNonNull(editText, "EditText cannot be null");
        ObjectUtil.requireNonNull(delayListener, "Listener cannot be null");
        if (delay < 0)  throw new IllegalArgumentException("delay cannot be negative");

        final Handler handler = new Handler();
        final Runnable runnable = () -> delayListener.onCompleted(editText.getText());

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, delay);
            }
        });
    }

    public static boolean equals(CharSequence a, CharSequence b) {
        return equals(a, b, false);
    }

    public static boolean equals(CharSequence a, CharSequence b, boolean ignoreCase) {

        if (ignoreCase) {
            a = ((String) a).toLowerCase();
            b = ((String) b).toLowerCase();
        }

        if (a == b) return true;
        if (a != null && b != null) {
            int length = a.length();
            if (length == b.length()) {
                if (a instanceof String && b instanceof String) {
                    return a.equals(b);
                } else {
                    for (int i = 0; i < length; i++) {
                        if (a.charAt(i) != b.charAt(i)) return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static String getStackTraceString(Throwable tr) {
        if (tr == null) {
            return "";
        }

        // This is to reduce the amount of log spew that apps do in the non-error
        // condition of the network being unavailable.
        Throwable t = tr;
        while (t != null) {
            if (t instanceof UnknownHostException) {
                return "";
            }
            t = t.getCause();
        }

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        tr.printStackTrace(pw);
        pw.flush();
        return sw.toString();
    }

    public interface OnDelayListener {
        void onCompleted(CharSequence text);
    }
}