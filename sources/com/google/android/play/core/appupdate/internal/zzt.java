package com.google.android.play.core.appupdate.internal;

import android.os.IBinder;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzt extends zzn {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IBinder f82877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzw f82878c;

    zzt(zzw zzwVar, IBinder iBinder) {
        this.f82878c = zzwVar;
        this.f82877b = iBinder;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void a() {
        this.f82878c.f82880a.f82894m = zze.h5(this.f82877b);
        zzx.q(this.f82878c.f82880a);
        this.f82878c.f82880a.f82888g = false;
        Iterator it = this.f82878c.f82880a.f82885d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f82878c.f82880a.f82885d.clear();
    }
}
