package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbqc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList f76640a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile zzbjn f76641b = zzbjn.IDLE;

    zzbqc() {
    }

    final void a(zzbjn zzbjnVar) {
        Preconditions.u(zzbjnVar, "newState");
        if (this.f76641b == zzbjnVar || this.f76641b == zzbjn.SHUTDOWN) {
            return;
        }
        this.f76641b = zzbjnVar;
        if (this.f76640a.isEmpty()) {
            return;
        }
        ArrayList arrayList = this.f76640a;
        this.f76640a = new ArrayList();
        if (arrayList.size() <= 0) {
            return;
        }
        throw null;
    }
}
