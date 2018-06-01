package vironit.pavelnovak.myappvironit.utils.exceptions;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

public class VironitSocialNetworkException extends Exception {

    private ErrorStatus status;

    @Nullable
    @StringRes
    private Integer resId;

    @Nullable
    public ErrorStatus getStatus() {
        return status;
    }

    @Nullable
    public Integer getResId() {
        return resId;
    }

    public VironitSocialNetworkException(@NonNull ErrorStatus status) {
        this.status = status;
        resId = null;
    }

    public VironitSocialNetworkException(@NonNull Integer resId) {
        this.resId = resId;
    }

    public VironitSocialNetworkException(@NonNull Throwable cause,
                                         @NonNull ErrorStatus status) {
        super(cause);
        this.status = status;
        resId = null;
    }

    public VironitSocialNetworkException(@NonNull String message,
                                         @NonNull Throwable cause,
                                         @NonNull ErrorStatus status) {
        super(message, cause);
        this.status = status;
        resId = null;
    }

    public VironitSocialNetworkException(@NonNull Throwable cause,
                                         @NonNull Integer resId) {
        super(cause);
        this.resId = resId;
    }

    public VironitSocialNetworkException(@NonNull String message,
                                         @NonNull Throwable cause,
                                         @NonNull Integer resId) {
        super(message);
        this.status = status;
    }
}
