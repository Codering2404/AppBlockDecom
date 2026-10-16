package com.google.android.gms.analytics;

import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzh f70911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzr f70912b;

    zzl(zzr zzrVar, zzh zzhVar) {
        this.f70912b = zzrVar;
        this.f70911a = zzhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzh zzhVar = this.f70911a;
        zzhVar.d().a(zzhVar);
        Iterator it = this.f70912b.f70918b.iterator();
        while (it.hasNext()) {
            ((zzs) it.next()).zza();
        }
        zzh zzhVar2 = this.f70911a;
        Preconditions.l("deliver should be called from worker thread");
        Preconditions.b(zzhVar2.m(), "Measurement must be submitted");
        List<zzt> listF = zzhVar2.f();
        if (listF.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (zzt zztVar : listF) {
            Uri uriZzb = zztVar.zzb();
            if (!hashSet.contains(uriZzb)) {
                hashSet.add(uriZzb);
                zztVar.a(zzhVar2);
            }
        }
    }
}
