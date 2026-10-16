package com.applovin.impl;

import android.os.Looper;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class rh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f62836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f62837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l3 f62838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final fo f62839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f62840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f62841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Looper f62842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f62843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f62844i = -9223372036854775807L;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f62845j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f62846k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f62847l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f62848m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f62849n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(rh rhVar);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a(int i3, Object obj);
    }

    public rh(a aVar, b bVar, fo foVar, int i3, l3 l3Var, Looper looper) {
        this.f62837b = aVar;
        this.f62836a = bVar;
        this.f62839d = foVar;
        this.f62842g = looper;
        this.f62838c = l3Var;
        this.f62843h = i3;
    }

    public synchronized boolean a(long j3) {
        boolean z2;
        try {
            b1.b(this.f62846k);
            b1.b(this.f62842g.getThread() != Thread.currentThread());
            long jC = this.f62838c.c() + j3;
            while (true) {
                z2 = this.f62848m;
                if (z2 || j3 <= 0) {
                    break;
                }
                this.f62838c.b();
                wait(j3);
                j3 = jC - this.f62838c.c();
            }
            if (!z2) {
                throw new TimeoutException("Message delivery timed out.");
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f62847l;
    }

    public Looper b() {
        return this.f62842g;
    }

    public Object c() {
        return this.f62841f;
    }

    public long d() {
        return this.f62844i;
    }

    public b e() {
        return this.f62836a;
    }

    public fo f() {
        return this.f62839d;
    }

    public int g() {
        return this.f62840e;
    }

    public int h() {
        return this.f62843h;
    }

    public synchronized boolean i() {
        return this.f62849n;
    }

    public rh j() {
        b1.b(!this.f62846k);
        if (this.f62844i == -9223372036854775807L) {
            b1.a(this.f62845j);
        }
        this.f62846k = true;
        this.f62837b.a(this);
        return this;
    }

    public boolean a() {
        return this.f62845j;
    }

    public synchronized void a(boolean z2) {
        this.f62847l = z2 | this.f62847l;
        this.f62848m = true;
        notifyAll();
    }

    public rh a(Object obj) {
        b1.b(!this.f62846k);
        this.f62841f = obj;
        return this;
    }

    public rh a(int i3) {
        b1.b(!this.f62846k);
        this.f62840e = i3;
        return this;
    }
}
