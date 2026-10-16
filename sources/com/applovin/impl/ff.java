package com.applovin.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ff extends e2 implements Handler.Callback {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final cf f59690n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ef f59691o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Handler f59692p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final df f59693q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private bf f59694r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f59695s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f59696t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f59697u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f59698v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private af f59699w;

    public ff(ef efVar, Looper looper) {
        this(efVar, looper, cf.f58903a);
    }

    private void a(af afVar, List list) {
        for (int i3 = 0; i3 < afVar.c(); i3++) {
            e9 e9VarB = afVar.a(i3).b();
            if (e9VarB == null || !this.f59690n.a(e9VarB)) {
                list.add(afVar.a(i3));
            } else {
                bf bfVarB = this.f59690n.b(e9VarB);
                byte[] bArr = (byte[]) b1.a(afVar.a(i3).a());
                this.f59693q.b();
                this.f59693q.g(bArr.length);
                ((ByteBuffer) xp.a(this.f59693q.f62183c)).put(bArr);
                this.f59693q.g();
                af afVarA = bfVarB.a(this.f59693q);
                if (afVarA != null) {
                    a(afVarA, list);
                }
            }
        }
    }

    private void b(af afVar) {
        this.f59691o.a(afVar);
    }

    private void z() {
        if (this.f59695s || this.f59699w != null) {
            return;
        }
        this.f59693q.b();
        f9 f9VarR = r();
        int iA = a(f9VarR, this.f59693q, 0);
        if (iA != -4) {
            if (iA == -5) {
                this.f59697u = ((e9) b1.a(f9VarR.f59641b)).f59398q;
                return;
            }
            return;
        }
        if (this.f59693q.e()) {
            this.f59695s = true;
            return;
        }
        df dfVar = this.f59693q;
        dfVar.f59210j = this.f59697u;
        dfVar.g();
        af afVarA = ((bf) xp.a(this.f59694r)).a(this.f59693q);
        if (afVarA != null) {
            ArrayList arrayList = new ArrayList(afVarA.c());
            a(afVarA, arrayList);
            if (arrayList.isEmpty()) {
                return;
            }
            this.f59699w = new af(arrayList);
            this.f59698v = this.f59693q.f62185f;
        }
    }

    @Override // com.applovin.impl.qi
    public boolean c() {
        return this.f59696t;
    }

    @Override // com.applovin.impl.qi
    public boolean d() {
        return true;
    }

    @Override // com.applovin.impl.qi, com.applovin.impl.ri
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        b((af) message.obj);
        return true;
    }

    @Override // com.applovin.impl.e2
    protected void v() {
        this.f59699w = null;
        this.f59698v = -9223372036854775807L;
        this.f59694r = null;
    }

    public ff(ef efVar, Looper looper, cf cfVar) {
        super(5);
        this.f59691o = (ef) b1.a(efVar);
        this.f59692p = looper == null ? null : xp.a(looper, (Handler.Callback) this);
        this.f59690n = (cf) b1.a(cfVar);
        this.f59693q = new df();
        this.f59698v = -9223372036854775807L;
    }

    private boolean c(long j3) {
        boolean z2;
        af afVar = this.f59699w;
        if (afVar == null || this.f59698v > j3) {
            z2 = false;
        } else {
            a(afVar);
            this.f59699w = null;
            this.f59698v = -9223372036854775807L;
            z2 = true;
        }
        if (this.f59695s && this.f59699w == null) {
            this.f59696t = true;
        }
        return z2;
    }

    private void a(af afVar) {
        Handler handler = this.f59692p;
        if (handler != null) {
            handler.obtainMessage(0, afVar).sendToTarget();
        } else {
            b(afVar);
        }
    }

    @Override // com.applovin.impl.e2
    protected void a(long j3, boolean z2) {
        this.f59699w = null;
        this.f59698v = -9223372036854775807L;
        this.f59695s = false;
        this.f59696t = false;
    }

    @Override // com.applovin.impl.e2
    protected void a(e9[] e9VarArr, long j3, long j4) {
        this.f59694r = this.f59690n.b(e9VarArr[0]);
    }

    @Override // com.applovin.impl.qi
    public void a(long j3, long j4) {
        boolean zC = true;
        while (zC) {
            z();
            zC = c(j3);
        }
    }

    @Override // com.applovin.impl.ri
    public int a(e9 e9Var) {
        if (this.f59690n.a(e9Var)) {
            return ri.a(e9Var.F == 0 ? 4 : 2);
        }
        return ri.a(0);
    }
}
