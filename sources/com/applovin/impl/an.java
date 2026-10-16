package com.applovin.impl;

import com.applovin.impl.tm;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class an extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final WeakReference f58466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f58467i;

    protected an(fi fiVar, Object obj, String str, com.applovin.impl.sdk.j jVar) {
        super(str, jVar);
        this.f58466h = new WeakReference(fiVar);
        this.f58467i = obj;
    }

    public static void a(long j3, fi fiVar, Object obj, String str, com.applovin.impl.sdk.j jVar) {
        if (j3 <= 0) {
            return;
        }
        jVar.i0().a(new an(fiVar, obj, str, jVar), tm.b.TIMEOUT, j3);
    }

    @Override // java.lang.Runnable
    public void run() {
        fi fiVar = (fi) this.f58466h.get();
        if (fiVar == null || fiVar.c()) {
            return;
        }
        this.f65231a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f65231a.I().d(this.f65232b, "Attempting to timeout pending task " + fiVar.b() + " with " + this.f58467i);
        }
        fiVar.a(this.f58467i);
    }
}
