package com.google.android.ump;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FormError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f83211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f83212b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
        public static final int INTERNAL_ERROR = 1;
        public static final int INTERNET_ERROR = 2;
        public static final int INVALID_OPERATION = 3;
        public static final int TIME_OUT = 4;
    }

    public FormError(int i3, String str) {
        this.f83211a = i3;
        this.f83212b = str;
    }

    public int getErrorCode() {
        return this.f83211a;
    }

    public String getMessage() {
        return this.f83212b;
    }
}
