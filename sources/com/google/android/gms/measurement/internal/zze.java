package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zze {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzji f73562a;

    zze(zzji zzjiVar) {
        this.f73562a = zzjiVar;
    }

    static zze c(String str) {
        return new zze((TextUtils.isEmpty(str) || str.length() > 1) ? zzji.UNINITIALIZED : zzjl.j(str.charAt(0)));
    }

    final zzji a() {
        return this.f73562a;
    }

    final String b() {
        return String.valueOf(zzjl.m(this.f73562a));
    }
}
