package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbmg f75785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbis f75786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f75787c;

    private zzask(int i3, zzbml zzbmlVar, String str, zzbis zzbisVar, zzbmg zzbmgVar, String str2) {
        this.f75786b = zzbisVar;
        this.f75785a = zzbmgVar;
        this.f75787c = str2;
    }

    public static zzask a(zzbml zzbmlVar, zzbis zzbisVar, zzbmg zzbmgVar, String str) {
        return new zzask(2, (zzbml) Preconditions.t(zzbmlVar), null, (zzbis) Preconditions.t(zzbisVar), (zzbmg) Preconditions.t(zzbmgVar), (String) Preconditions.t(str));
    }

    public final zzbmg b() {
        return this.f75785a;
    }

    public final zzbis c() {
        return this.f75786b;
    }

    public final String d() {
        return this.f75787c;
    }
}
