package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class zzk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzr f70908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final zzh f70909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f70910c;

    protected zzk(zzr zzrVar, Clock clock) {
        Preconditions.m(zzrVar);
        this.f70908a = zzrVar;
        this.f70910c = new ArrayList();
        zzh zzhVar = new zzh(this, clock);
        zzhVar.h();
        this.f70909b = zzhVar;
    }

    protected void a(zzh zzhVar) {
        throw null;
    }

    protected final zzr b() {
        return this.f70908a;
    }

    protected final void c(zzh zzhVar) {
        Iterator it = this.f70910c.iterator();
        while (it.hasNext()) {
            ((zzi) it.next()).zza();
        }
    }
}
