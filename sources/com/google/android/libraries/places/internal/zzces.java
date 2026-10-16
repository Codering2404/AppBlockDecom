package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzces extends zzceo {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AtomicInteger f77730m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private zzbln f77731n;

    public zzces(zzblg zzblgVar) {
        super(zzblgVar);
        this.f77730m = new AtomicInteger(new Random().nextInt());
        this.f77731n = new zzblf(zzbli.d());
    }

    private final void l(zzbjn zzbjnVar, zzbln zzblnVar) {
        if (zzbjnVar == this.f77724j && zzblnVar.equals(this.f77731n)) {
            return;
        }
        g().b(zzbjnVar, zzblnVar);
        this.f77724j = zzbjnVar;
        this.f77731n = zzblnVar;
    }

    private final zzbln m(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzcem) it.next()).e());
        }
        return new zzcer(arrayList, this.f77730m);
    }

    @Override // com.google.android.libraries.places.internal.zzceo
    protected final void e() {
        List listI = i();
        if (!listI.isEmpty()) {
            l(zzbjn.READY, m(listI));
            return;
        }
        Iterator it = h().iterator();
        while (it.hasNext()) {
            zzbjn zzbjnVarF = ((zzcem) it.next()).f();
            zzbjn zzbjnVar = zzbjn.CONNECTING;
            if (zzbjnVarF == zzbjnVar || zzbjnVarF == zzbjn.IDLE) {
                l(zzbjnVar, new zzblf(zzbli.d()));
                return;
            }
        }
        l(zzbjn.TRANSIENT_FAILURE, m(h()));
    }

    @Override // com.google.android.libraries.places.internal.zzceo
    protected final zzcem f(Object obj) {
        return new zzceq(this, obj, this.f77723i);
    }
}
