package com.google.android.gms.ads.internal.util;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f70265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f70266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f70267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f70268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f70269e;

    public zzbd(String str, double d3, double d4, double d5, int i3) {
        this.f70265a = str;
        this.f70267c = d3;
        this.f70266b = d4;
        this.f70268d = d5;
        this.f70269e = i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbd)) {
            return false;
        }
        zzbd zzbdVar = (zzbd) obj;
        return Objects.b(this.f70265a, zzbdVar.f70265a) && this.f70266b == zzbdVar.f70266b && this.f70267c == zzbdVar.f70267c && this.f70269e == zzbdVar.f70269e && Double.compare(this.f70268d, zzbdVar.f70268d) == 0;
    }

    public final int hashCode() {
        return Objects.c(this.f70265a, Double.valueOf(this.f70266b), Double.valueOf(this.f70267c), Double.valueOf(this.f70268d), Integer.valueOf(this.f70269e));
    }

    public final String toString() {
        return Objects.d(this).a("name", this.f70265a).a("minBound", Double.valueOf(this.f70267c)).a("maxBound", Double.valueOf(this.f70266b)).a("percent", Double.valueOf(this.f70268d)).a("count", Integer.valueOf(this.f70269e)).toString();
    }
}
