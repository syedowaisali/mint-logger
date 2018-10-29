package net.crystalapps.mint.logger.library.formats;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import net.crystalapps.mint.logger.library.core.FormatStrategy;
import net.crystalapps.mint.logger.library.core.LogStrategy;
import net.crystalapps.mint.logger.library.utils.ObjectUtil;

/**
 * Created by Syed Owais Ali on 5/10/2018.
 */

@SuppressWarnings({"ConstantConditions", "WeakerAccess"})
public class StyleLogFormatStrategy implements FormatStrategy {

    public static final String BLOCK = "▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇";

    @NonNull private final LogStrategy logStrategy;
    @Nullable private final String tag;

    private StyleLogFormatStrategy(@NonNull Builder builder) {
        logStrategy = builder.logStrategy;
        tag = builder.tag;
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder().logStrategy(new LogcatLogStrategy()).tag(":: MINT LOGGER :");
    }

    @Override
    public void log(int priority, @Nullable String tag, @NonNull String message) {

        if (tag == null) tag = this.tag;

        logChunk(priority, tag, BLOCK);
        logChunk(priority, tag, "★ " + message + " ★");
        logChunk(priority, tag, BLOCK);
    }


    private void logChunk(int priority, @Nullable String tag, @NonNull String chunk) {
        logStrategy.log(priority, tag, chunk);
    }

    public static class Builder {

        @Nullable LogStrategy logStrategy;
        @Nullable String tag;

        private Builder() {}

        @NonNull
        public Builder logStrategy(@Nullable LogStrategy logStrategy) {
            this.logStrategy = logStrategy;
            return this;
        }

        @NonNull
        public Builder tag(@Nullable String tag) {
            this.tag = tag;
            return this;
        }

        @NonNull
        public StyleLogFormatStrategy build() {

            ObjectUtil.requireNonNull(logStrategy);
            ObjectUtil.requireNonNull(tag);

            return new StyleLogFormatStrategy(this);
        }
    }

}
