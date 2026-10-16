package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbtp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbnp f76862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbua f76863b;

    zzbtp(zzbua zzbuaVar, zzbnp zzbnpVar) {
        this.f76862a = zzbnpVar;
        Objects.requireNonNull(zzbuaVar);
        this.f76863b = zzbuaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = new ArrayList(this.f76863b.N());
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((zzbwd) arrayList.get(i3)).c(this.f76862a);
        }
    }
}
