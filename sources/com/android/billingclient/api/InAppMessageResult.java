package com.android.billingclient.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class InAppMessageResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f57251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f57252b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InAppMessageResponseCode {
    }

    public InAppMessageResult(int i3, String str) {
        this.f57251a = i3;
        this.f57252b = str;
    }

    public int a() {
        return this.f57251a;
    }
}
