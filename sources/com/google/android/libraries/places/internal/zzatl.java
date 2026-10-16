package com.google.android.libraries.places.internal;

import java.util.LinkedHashMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzatl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f75860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashMap f75861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f75862c;

    zzatl(zzatm zzatmVar, Object obj, int i3) {
        Objects.requireNonNull(zzatmVar);
        this.f75861b = new LinkedHashMap();
        this.f75860a = obj;
        this.f75862c = i3;
    }

    final boolean a() {
        return this.f75861b.isEmpty();
    }

    final boolean b() {
        return this.f75861b.isEmpty() && this.f75862c == 0;
    }

    final /* synthetic */ Object c() {
        return this.f75860a;
    }

    final /* synthetic */ int d() {
        return this.f75862c;
    }

    final /* synthetic */ void e(int i3) {
        this.f75862c = i3;
    }
}
