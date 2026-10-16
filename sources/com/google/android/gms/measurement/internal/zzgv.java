package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f73739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f73740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f73741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f73742d;

    public zzgv(String str, String str2, Bundle bundle, long j3) {
        this.f73739a = str;
        this.f73740b = str2;
        this.f73742d = bundle;
        this.f73741c = j3;
    }

    public static zzgv a(zzbg zzbgVar) {
        return new zzgv(zzbgVar.f73484a, zzbgVar.f73486c, zzbgVar.f73485b.w0(), zzbgVar.f73487d);
    }

    public final zzbg b() {
        return new zzbg(this.f73739a, new zzbe(new Bundle(this.f73742d)), this.f73740b, this.f73741c);
    }

    public final String toString() {
        String str = this.f73740b;
        String string = this.f73742d.toString();
        int length = String.valueOf(str).length();
        String str2 = this.f73739a;
        StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + string.length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(string);
        return sb.toString();
    }
}
