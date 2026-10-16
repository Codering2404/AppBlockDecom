package com.google.android.gms.fido.u2f.api.common;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class Error {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ErrorCode f72715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f72716b;

    public String toString() {
        if (this.f72716b == null) {
            return String.format(Locale.ENGLISH, "{errorCode: %d}", Integer.valueOf(this.f72715a.c()));
        }
        return String.format(Locale.ENGLISH, "{errorCode: %d, errorMessage: %s}", Integer.valueOf(this.f72715a.c()), this.f72716b);
    }
}
