package com.google.android.play.core.review.internal;

import android.os.IBinder;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzp extends zzj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IBinder f83119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzr f83120c;

    zzp(zzr zzrVar, IBinder iBinder) {
        this.f83119b = iBinder;
        this.f83120c = zzrVar;
    }

    @Override // com.google.android.play.core.review.internal.zzj
    public final void a() {
        this.f83120c.f83122a.f83136m = zze.h5(this.f83119b);
        zzt.q(this.f83120c.f83122a);
        this.f83120c.f83122a.f83130g = false;
        Iterator it = this.f83120c.f83122a.f83127d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f83120c.f83122a.f83127d.clear();
    }
}
