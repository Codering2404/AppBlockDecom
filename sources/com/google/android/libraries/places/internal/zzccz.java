package com.google.android.libraries.places.internal;

import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzccz {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzcfj f77622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zzcfj f77623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzcfj f77624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzcfj f77625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final zzcfj f77626h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzcfj f77627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzcfj f77628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f77629c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public zzccz(String str, String str2) {
        this(zzcfi.a(str), zzcfi.a(str2));
        zzcfj zzcfjVar = zzcfj.f77742d;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzccz) {
            zzccz zzcczVar = (zzccz) obj;
            if (this.f77627a.equals(zzcczVar.f77627a) && this.f77628b.equals(zzcczVar.f77628b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f77627a.hashCode() + 527) * 31) + this.f77628b.hashCode();
    }

    public final String toString() {
        return String.format("%s: %s", this.f77627a.e(), this.f77628b.e());
    }

    static {
        zzcfj zzcfjVar = zzcfj.f77742d;
        f77622d = zzcfi.a(":status");
        f77623e = zzcfi.a(":method");
        f77624f = zzcfi.a(":path");
        f77625g = zzcfi.a(":scheme");
        f77626h = zzcfi.a(KLAQHFCRAUejH.dqY);
        zzcfi.a(":host");
        zzcfi.a(":version");
    }

    public zzccz(zzcfj zzcfjVar, zzcfj zzcfjVar2) {
        this.f77627a = zzcfjVar;
        this.f77628b = zzcfjVar2;
        this.f77629c = zzcfjVar.j() + 32 + zzcfjVar2.j();
    }
}
