package com.google.android.gms.ads;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AdInspectorError extends AdError {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdInspectorErrorCode {
    }

    public AdInspectorError(int i3, String str, String str2) {
        super(i3, str, str2);
    }

    @Override // com.google.android.gms.ads.AdError
    public int a() {
        return super.a();
    }
}
