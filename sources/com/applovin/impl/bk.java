package com.applovin.impl;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class bk implements l5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread f58701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f58702b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque f58703c = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayDeque f58704d = new ArrayDeque();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final o5[] f58705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final yg[] f58706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f58707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f58708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private o5 f58709i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private n5 f58710j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f58711k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f58712l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f58713m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends Thread {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            bk.this.m();
        }
    }

    protected bk(o5[] o5VarArr, yg[] ygVarArr) {
        this.f58705e = o5VarArr;
        this.f58707g = o5VarArr.length;
        for (int i3 = 0; i3 < this.f58707g; i3++) {
            this.f58705e[i3] = f();
        }
        this.f58706f = ygVarArr;
        this.f58708h = ygVarArr.length;
        for (int i4 = 0; i4 < this.f58708h; i4++) {
            this.f58706f[i4] = g();
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.f58701a = aVar;
        aVar.start();
    }

    private boolean e() {
        return !this.f58703c.isEmpty() && this.f58708h > 0;
    }

    private boolean h() {
        n5 n5VarA;
        synchronized (this.f58702b) {
            while (!this.f58712l && !e()) {
                try {
                    this.f58702b.wait();
                } finally {
                }
            }
            if (this.f58712l) {
                return false;
            }
            o5 o5Var = (o5) this.f58703c.removeFirst();
            yg[] ygVarArr = this.f58706f;
            int i3 = this.f58708h - 1;
            this.f58708h = i3;
            yg ygVar = ygVarArr[i3];
            boolean z2 = this.f58711k;
            this.f58711k = false;
            if (o5Var.e()) {
                ygVar.b(4);
            } else {
                if (o5Var.d()) {
                    ygVar.b(Integer.MIN_VALUE);
                }
                try {
                    n5VarA = a(o5Var, ygVar, z2);
                } catch (OutOfMemoryError e3) {
                    n5VarA = a((Throwable) e3);
                } catch (RuntimeException e4) {
                    n5VarA = a((Throwable) e4);
                }
                if (n5VarA != null) {
                    synchronized (this.f58702b) {
                        this.f58710j = n5VarA;
                    }
                    return false;
                }
            }
            synchronized (this.f58702b) {
                try {
                    if (this.f58711k) {
                        ygVar.g();
                    } else if (ygVar.d()) {
                        this.f58713m++;
                        ygVar.g();
                    } else {
                        ygVar.f65213c = this.f58713m;
                        this.f58713m = 0;
                        this.f58704d.addLast(ygVar);
                    }
                    b(o5Var);
                } finally {
                }
            }
            return true;
        }
    }

    private void k() {
        if (e()) {
            this.f58702b.notify();
        }
    }

    private void l() throws n5 {
        n5 n5Var = this.f58710j;
        if (n5Var != null) {
            throw n5Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        do {
            try {
            } catch (InterruptedException e3) {
                throw new IllegalStateException(e3);
            }
        } while (h());
    }

    protected abstract n5 a(o5 o5Var, yg ygVar, boolean z2);

    protected abstract n5 a(Throwable th);

    @Override // com.applovin.impl.l5
    public final void b() {
        synchronized (this.f58702b) {
            try {
                this.f58711k = true;
                this.f58713m = 0;
                o5 o5Var = this.f58709i;
                if (o5Var != null) {
                    b(o5Var);
                    this.f58709i = null;
                }
                while (!this.f58703c.isEmpty()) {
                    b((o5) this.f58703c.removeFirst());
                }
                while (!this.f58704d.isEmpty()) {
                    ((yg) this.f58704d.removeFirst()).g();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected abstract o5 f();

    protected abstract yg g();

    @Override // com.applovin.impl.l5
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final o5 d() {
        o5 o5Var;
        synchronized (this.f58702b) {
            l();
            b1.b(this.f58709i == null);
            int i3 = this.f58707g;
            if (i3 == 0) {
                o5Var = null;
            } else {
                o5[] o5VarArr = this.f58705e;
                int i4 = i3 - 1;
                this.f58707g = i4;
                o5Var = o5VarArr[i4];
            }
            this.f58709i = o5Var;
        }
        return o5Var;
    }

    @Override // com.applovin.impl.l5
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final yg c() {
        synchronized (this.f58702b) {
            try {
                l();
                if (this.f58704d.isEmpty()) {
                    return null;
                }
                return (yg) this.f58704d.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.applovin.impl.l5
    public final void a(o5 o5Var) {
        synchronized (this.f58702b) {
            l();
            b1.a(o5Var == this.f58709i);
            this.f58703c.addLast(o5Var);
            k();
            this.f58709i = null;
        }
    }

    @Override // com.applovin.impl.l5
    public void a() {
        synchronized (this.f58702b) {
            this.f58712l = true;
            this.f58702b.notify();
        }
        try {
            this.f58701a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    private void b(o5 o5Var) {
        o5Var.b();
        o5[] o5VarArr = this.f58705e;
        int i3 = this.f58707g;
        this.f58707g = i3 + 1;
        o5VarArr[i3] = o5Var;
    }

    private void b(yg ygVar) {
        ygVar.b();
        yg[] ygVarArr = this.f58706f;
        int i3 = this.f58708h;
        this.f58708h = i3 + 1;
        ygVarArr[i3] = ygVar;
    }

    protected void a(yg ygVar) {
        synchronized (this.f58702b) {
            b(ygVar);
            k();
        }
    }

    protected final void a(int i3) {
        b1.b(this.f58707g == this.f58705e.length);
        for (o5 o5Var : this.f58705e) {
            o5Var.g(i3);
        }
    }
}
