package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class aa extends t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ IBinder f83159g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ad f83160h;

    aa(ad adVar, IBinder iBinder) {
        this.f83160h = adVar;
        this.f83159g = iBinder;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void b() {
        this.f83160h.f83162a.f83177n = (IInterface) this.f83160h.f83162a.f83172i.a(this.f83159g);
        ae.r(this.f83160h.f83162a);
        this.f83160h.f83162a.f83170g = false;
        Iterator it = this.f83160h.f83162a.f83167d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f83160h.f83162a.f83167d.clear();
    }
}
