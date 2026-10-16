package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbve implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbvl f76942a;

    zzbve(zzbvl zzbvlVar) {
        Objects.requireNonNull(zzbvlVar);
        this.f76942a = zzbvlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        zzbvl zzbvlVar = this.f76942a;
        if (zzbvlVar.j().get() == zzbvr.f76981j0) {
            zzbvlVar.j().set(null);
        }
        zzbvr zzbvrVar = zzbvlVar.f76957d;
        if (zzbvrVar.p() != null) {
            Iterator it = zzbvrVar.p().iterator();
            while (it.hasNext()) {
                ((zzbvk) it.next()).e("Channel is forcefully shutdown", null);
            }
        }
        zzbvq zzbvqVarT = zzbvrVar.t();
        zzbnp zzbnpVar = zzbvr.f76977f0;
        zzbvqVarT.a(zzbnpVar);
        synchronized (zzbvqVarT.f76972a) {
            arrayList = new ArrayList(zzbvqVarT.f76973b);
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((zzbpl) arrayList.get(i3)).c(zzbnpVar);
        }
        zzbvqVarT.f76975d.s().c(zzbnpVar);
    }
}
