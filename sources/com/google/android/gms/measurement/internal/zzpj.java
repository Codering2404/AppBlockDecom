package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f74468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.gms.internal.measurement.zzib f74469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f74470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f74471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzls f74472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f74473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f74474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f74475h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f74476i;

    /* synthetic */ zzpj(long j3, com.google.android.gms.internal.measurement.zzib zzibVar, String str, Map map, zzls zzlsVar, long j4, long j5, long j6, int i3, byte[] bArr) {
        this.f74468a = j3;
        this.f74469b = zzibVar;
        this.f74470c = str;
        this.f74471d = map;
        this.f74472e = zzlsVar;
        this.f74473f = j4;
        this.f74474g = j5;
        this.f74475h = j6;
        this.f74476i = i3;
    }

    public final zzot a() {
        return new zzot(this.f74470c, this.f74471d, this.f74472e, null);
    }

    public final zzom b() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f74471d.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        long j3 = this.f74468a;
        com.google.android.gms.internal.measurement.zzib zzibVar = this.f74469b;
        String str = this.f74470c;
        zzls zzlsVar = this.f74472e;
        return new zzom(j3, zzibVar.zzcc(), str, bundle, zzlsVar.zza(), this.f74474g, "");
    }

    public final long c() {
        return this.f74468a;
    }

    public final com.google.android.gms.internal.measurement.zzib d() {
        return this.f74469b;
    }

    public final String e() {
        return this.f74470c;
    }

    public final zzls f() {
        return this.f74472e;
    }

    public final long g() {
        return this.f74473f;
    }

    public final long h() {
        return this.f74475h;
    }

    public final int i() {
        return this.f74476i;
    }
}
