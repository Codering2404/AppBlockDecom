package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class bl implements fd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l3 f58715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f58716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f58717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f58718d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ph f58719f = ph.f62438d;

    public bl(l3 l3Var) {
        this.f58715a = l3Var;
    }

    @Override // com.applovin.impl.fd
    public ph a() {
        return this.f58719f;
    }

    public void b() {
        if (this.f58716b) {
            return;
        }
        this.f58718d = this.f58715a.c();
        this.f58716b = true;
    }

    public void c() {
        if (this.f58716b) {
            a(p());
            this.f58716b = false;
        }
    }

    @Override // com.applovin.impl.fd
    public long p() {
        long j3 = this.f58717c;
        if (!this.f58716b) {
            return j3;
        }
        long jC = this.f58715a.c() - this.f58718d;
        ph phVar = this.f58719f;
        return j3 + (phVar.f62440a == 1.0f ? t2.a(jC) : phVar.a(jC));
    }

    public void a(long j3) {
        this.f58717c = j3;
        if (this.f58716b) {
            this.f58718d = this.f58715a.c();
        }
    }

    @Override // com.applovin.impl.fd
    public void a(ph phVar) {
        if (this.f58716b) {
            a(p());
        }
        this.f58719f = phVar;
    }
}
