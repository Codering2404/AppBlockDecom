package com.applovin.impl;

import com.applovin.mediation.MaxError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class yj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zj f65218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f65219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f65220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f65221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MaxError f65222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f65223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f65224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f65225h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(yj yjVar);
    }

    private yj(zj zjVar, com.applovin.impl.mediation.g gVar, String str, MaxError maxError, long j3, long j4) {
        this(zjVar, str, maxError, j3, j4, gVar != null ? gVar.i() : null, gVar != null ? gVar.b() : null, false);
    }

    public static yj a(zj zjVar, com.applovin.impl.mediation.g gVar, MaxError maxError, long j3, long j4) {
        if (zjVar != null) {
            return new yj(zjVar, gVar, null, maxError, j3, j4);
        }
        throw new IllegalArgumentException("No spec specified");
    }

    public long b() {
        return this.f65224g;
    }

    public MaxError c() {
        return this.f65222e;
    }

    public String d() {
        return this.f65219b;
    }

    public String e() {
        return this.f65221d;
    }

    public zj f() {
        return this.f65218a;
    }

    public boolean g() {
        return this.f65225h;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SignalCollectionResult{mSignalProviderSpec=");
        sb.append(this.f65218a);
        sb.append(", mSdkVersion='");
        sb.append(this.f65219b);
        sb.append('\'');
        sb.append(", mAdapterVersion='");
        sb.append(this.f65220c);
        sb.append('\'');
        sb.append(", mSignalDataLength='");
        String str = this.f65221d;
        sb.append(str != null ? str.length() : 0);
        sb.append('\'');
        sb.append(", mErrorMessage=");
        MaxError maxError = this.f65222e;
        sb.append(maxError != null ? maxError.getMessage() : "");
        sb.append('}');
        return sb.toString();
    }

    public static yj a(zj zjVar, MaxError maxError) {
        return a(zjVar, (com.applovin.impl.mediation.g) null, maxError, -1L, -1L);
    }

    private yj(zj zjVar, String str, MaxError maxError, long j3, long j4, String str2, String str3, boolean z2) {
        this.f65218a = zjVar;
        this.f65221d = str;
        this.f65222e = maxError;
        this.f65223f = j3;
        this.f65224g = j4;
        this.f65219b = str2;
        this.f65220c = str3;
        this.f65225h = z2;
    }

    public static yj a(zj zjVar, com.applovin.impl.mediation.g gVar, String str, long j3, long j4) {
        if (zjVar == null) {
            throw new IllegalArgumentException("No spec specified");
        }
        if (gVar != null) {
            return new yj(zjVar, gVar, str, null, j3, j4);
        }
        throw new IllegalArgumentException("No adapterWrapper specified");
    }

    public String a() {
        return this.f65220c;
    }

    public static yj a(yj yjVar) {
        return new yj(yjVar.f(), yjVar.e(), yjVar.c(), yjVar.f65223f, yjVar.f65224g, yjVar.d(), yjVar.a(), true);
    }
}
