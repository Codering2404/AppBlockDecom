package com.applovin.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class bo extends e2 implements Handler.Callback {
    private int A;
    private long B;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Handler f58739n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ao f58740o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ql f58741p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final f9 f58742q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f58743r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f58744s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f58745t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f58746u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private e9 f58747v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ol f58748w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private rl f58749x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private sl f58750y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private sl f58751z;

    public bo(ao aoVar, Looper looper) {
        this(aoVar, looper, ql.f62647a);
    }

    private long A() {
        if (this.A == -1) {
            return Long.MAX_VALUE;
        }
        b1.a(this.f58750y);
        if (this.A >= this.f58750y.a()) {
            return Long.MAX_VALUE;
        }
        return this.f58750y.a(this.A);
    }

    private void B() {
        this.f58745t = true;
        this.f58748w = this.f58741p.b((e9) b1.a(this.f58747v));
    }

    private void C() {
        this.f58749x = null;
        this.A = -1;
        sl slVar = this.f58750y;
        if (slVar != null) {
            slVar.g();
            this.f58750y = null;
        }
        sl slVar2 = this.f58751z;
        if (slVar2 != null) {
            slVar2.g();
            this.f58751z = null;
        }
    }

    private void D() {
        C();
        ((ol) b1.a(this.f58748w)).a();
        this.f58748w = null;
        this.f58746u = 0;
    }

    private void E() {
        D();
        B();
    }

    private void a(pl plVar) {
        oc.a("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.f58747v, plVar);
        z();
        E();
    }

    private void b(List list) {
        Handler handler = this.f58739n;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            a(list);
        }
    }

    private void z() {
        b(Collections.EMPTY_LIST);
    }

    @Override // com.applovin.impl.qi
    public boolean c() {
        return this.f58744s;
    }

    @Override // com.applovin.impl.qi
    public boolean d() {
        return true;
    }

    @Override // com.applovin.impl.qi, com.applovin.impl.ri
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        a((List) message.obj);
        return true;
    }

    @Override // com.applovin.impl.e2
    protected void v() {
        this.f58747v = null;
        this.B = -9223372036854775807L;
        z();
        D();
    }

    public bo(ao aoVar, Looper looper, ql qlVar) {
        super(3);
        this.f58740o = (ao) b1.a(aoVar);
        this.f58739n = looper == null ? null : xp.a(looper, (Handler.Callback) this);
        this.f58741p = qlVar;
        this.f58742q = new f9();
        this.B = -9223372036854775807L;
    }

    public void c(long j3) {
        b1.b(k());
        this.B = j3;
    }

    private void a(List list) {
        this.f58740o.a(list);
    }

    @Override // com.applovin.impl.e2
    protected void a(long j3, boolean z2) {
        z();
        this.f58743r = false;
        this.f58744s = false;
        this.B = -9223372036854775807L;
        if (this.f58746u != 0) {
            E();
        } else {
            C();
            ((ol) b1.a(this.f58748w)).b();
        }
    }

    @Override // com.applovin.impl.e2
    protected void a(e9[] e9VarArr, long j3, long j4) {
        this.f58747v = e9VarArr[0];
        if (this.f58748w != null) {
            this.f58746u = 1;
        } else {
            B();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00ab  */
    @Override // com.applovin.impl.qi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(long r9, long r11) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.bo.a(long, long):void");
    }

    @Override // com.applovin.impl.ri
    public int a(e9 e9Var) {
        if (this.f58741p.a(e9Var)) {
            return ri.a(e9Var.F == 0 ? 4 : 2);
        }
        if (hf.h(e9Var.f59394m)) {
            return ri.a(1);
        }
        return ri.a(0);
    }
}
