package com.google.android.libraries.places.internal;

import java.util.LinkedHashMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzath {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f75830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashMap f75831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f75832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzatk f75833d;

    /* synthetic */ zzath(zzatk zzatkVar, Object obj, byte[] bArr) {
        Objects.requireNonNull(zzatkVar);
        this.f75833d = zzatkVar;
        this.f75831b = new LinkedHashMap();
        this.f75830a = obj;
    }

    final boolean a() {
        return this.f75831b.isEmpty() && this.f75832c == this.f75833d.u().d();
    }

    final boolean b() {
        return this.f75831b.isEmpty() && this.f75832c == this.f75833d.u().f() + 1;
    }

    final /* synthetic */ Object c() {
        return this.f75830a;
    }

    final /* synthetic */ LinkedHashMap d() {
        return this.f75831b;
    }

    final /* synthetic */ int e() {
        return this.f75832c;
    }

    final /* synthetic */ void f(int i3) {
        this.f75832c = i3;
    }
}
