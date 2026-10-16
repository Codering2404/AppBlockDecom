package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzato {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbnp f75874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f75875b;

    private zzato(int i3, zzbnp zzbnpVar) {
        this.f75875b = i3;
        this.f75874a = zzbnpVar;
    }

    static zzato b(int i3) {
        Preconditions.z(true);
        return new zzato(i3, null);
    }

    static zzato c(int i3, zzbnp zzbnpVar) {
        if (i3 != 4) {
            i3 = 5;
        }
        Preconditions.z(true);
        return new zzato(i3, (zzbnp) Preconditions.t(zzbnpVar));
    }

    final /* synthetic */ zzbnp a() {
        return this.f75874a;
    }

    final /* synthetic */ int d() {
        return this.f75875b;
    }
}
