package com.google.android.gms.ads;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AdValue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f69664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f69665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f69666c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface PrecisionType {
    }

    private AdValue(int i3, String str, long j3) {
        this.f69664a = i3;
        this.f69665b = str;
        this.f69666c = j3;
    }

    public static AdValue a(int i3, String str, long j3) {
        return new AdValue(i3, str, j3);
    }
}
