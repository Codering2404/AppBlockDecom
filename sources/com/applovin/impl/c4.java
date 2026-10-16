package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l3 f58818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f58819b;

    public c4() {
        this(l3.f61106a);
    }

    public synchronized void a() {
        while (!this.f58819b) {
            wait();
        }
    }

    public synchronized void b() {
        boolean z2 = false;
        while (!this.f58819b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z2 = true;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean c() {
        boolean z2;
        z2 = this.f58819b;
        this.f58819b = false;
        return z2;
    }

    public synchronized boolean d() {
        return this.f58819b;
    }

    public synchronized boolean e() {
        if (this.f58819b) {
            return false;
        }
        this.f58819b = true;
        notifyAll();
        return true;
    }

    public c4(l3 l3Var) {
        this.f58818a = l3Var;
    }
}
