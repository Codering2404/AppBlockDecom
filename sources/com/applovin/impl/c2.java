package com.applovin.impl;

import android.os.Handler;
import android.os.Looper;
import com.applovin.impl.ae;
import com.applovin.impl.be;
import com.applovin.impl.z6;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c2 implements ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f58808a = new ArrayList(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashSet f58809b = new HashSet(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final be.a f58810c = new be.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final z6.a f58811d = new z6.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Looper f58812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private fo f58813f;

    @Override // com.applovin.impl.ae
    public final void a(Handler handler, z6 z6Var) {
        b1.a(handler);
        b1.a(z6Var);
        this.f58811d.a(handler, z6Var);
    }

    protected abstract void a(xo xoVar);

    protected final be.a b(ae.a aVar) {
        return this.f58810c.a(0, aVar, 0L);
    }

    @Override // com.applovin.impl.ae
    public final void c(ae.b bVar) {
        this.f58808a.remove(bVar);
        if (!this.f58808a.isEmpty()) {
            a(bVar);
            return;
        }
        this.f58812e = null;
        this.f58813f = null;
        this.f58809b.clear();
        h();
    }

    protected final boolean g() {
        return !this.f58809b.isEmpty();
    }

    protected abstract void h();

    @Override // com.applovin.impl.ae
    public final void b(ae.b bVar) {
        b1.a(this.f58812e);
        boolean zIsEmpty = this.f58809b.isEmpty();
        this.f58809b.add(bVar);
        if (zIsEmpty) {
            f();
        }
    }

    @Override // com.applovin.impl.ae
    public final void a(Handler handler, be beVar) {
        b1.a(handler);
        b1.a(beVar);
        this.f58810c.a(handler, beVar);
    }

    protected final z6.a a(int i3, ae.a aVar) {
        return this.f58811d.a(i3, aVar);
    }

    protected final z6.a a(ae.a aVar) {
        return this.f58811d.a(0, aVar);
    }

    protected final be.a a(int i3, ae.a aVar, long j3) {
        return this.f58810c.a(i3, aVar, j3);
    }

    @Override // com.applovin.impl.ae
    public final void a(ae.b bVar) {
        boolean zIsEmpty = this.f58809b.isEmpty();
        this.f58809b.remove(bVar);
        if (zIsEmpty || !this.f58809b.isEmpty()) {
            return;
        }
        e();
    }

    @Override // com.applovin.impl.ae
    public final void a(ae.b bVar, xo xoVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.f58812e;
        b1.a(looper == null || looper == looperMyLooper);
        fo foVar = this.f58813f;
        this.f58808a.add(bVar);
        if (this.f58812e == null) {
            this.f58812e = looperMyLooper;
            this.f58809b.add(bVar);
            a(xoVar);
        } else if (foVar != null) {
            b(bVar);
            bVar.a(this, foVar);
        }
    }

    protected void e() {
    }

    protected void f() {
    }

    protected final void a(fo foVar) {
        this.f58813f = foVar;
        ArrayList arrayList = this.f58808a;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((ae.b) obj).a(this, foVar);
        }
    }

    @Override // com.applovin.impl.ae
    public final void a(z6 z6Var) {
        this.f58811d.e(z6Var);
    }

    @Override // com.applovin.impl.ae
    public final void a(be beVar) {
        this.f58810c.a(beVar);
    }
}
