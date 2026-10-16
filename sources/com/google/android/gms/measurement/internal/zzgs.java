package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f73722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f73723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f73724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzgu f73725d;

    zzgs(zzgu zzguVar, int i3, boolean z2, boolean z3) {
        Objects.requireNonNull(zzguVar);
        this.f73725d = zzguVar;
        this.f73722a = i3;
        this.f73723b = z2;
        this.f73724c = z3;
    }

    public final void a(String str) {
        this.f73725d.y(this.f73722a, this.f73723b, this.f73724c, str, null, null, null);
    }

    public final void b(String str, Object obj) {
        this.f73725d.y(this.f73722a, this.f73723b, this.f73724c, str, obj, null, null);
    }

    public final void c(String str, Object obj, Object obj2) {
        this.f73725d.y(this.f73722a, this.f73723b, this.f73724c, str, obj, obj2, null);
    }

    public final void d(String str, Object obj, Object obj2, Object obj3) {
        this.f73725d.y(this.f73722a, this.f73723b, this.f73724c, str, obj, obj2, obj3);
    }
}
