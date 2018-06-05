package vironit.pavelnovak.myappvironit.utils.exceptions;

import android.support.annotation.StringRes;

import static vironit.pavelnovak.myappvironit.constants.IAppConstants.NO_STRING_RES;

public enum ErrorStatus {
    ;
    final int SERVER_ERROR_CODE;

    final @StringRes int stringResId;

    ErrorStatus(int server_error_code, int stringResId) {
        this.SERVER_ERROR_CODE = server_error_code;
        this.stringResId = stringResId;

    }

    public boolean hasStringMessageInRes(){
        return this.stringResId != NO_STRING_RES;
    }
}
