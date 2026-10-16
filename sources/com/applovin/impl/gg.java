package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class gg implements j8 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n8 f59973d = new n8() { // from class: com.applovin.impl.lx
        @Override // com.applovin.impl.n8
        public final j8[] a() {
            return gg.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l8 f59974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private gl f59975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f59976c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ j8[] b() {
        return new j8[]{new gg()};
    }

    @Override // com.applovin.impl.j8
    public void a() {
    }

    private boolean b(k8 k8Var) {
        ig igVar = new ig();
        if (igVar.a(k8Var, true) && (igVar.f60447b & 2) == 2) {
            int iMin = Math.min(igVar.f60454i, 8);
            ah ahVar = new ah(iMin);
            k8Var.c(ahVar.c(), 0, iMin);
            if (x8.c(a(ahVar))) {
                this.f59975b = new x8();
            } else if (er.c(a(ahVar))) {
                this.f59975b = new er();
            } else if (sg.b(a(ahVar))) {
                this.f59975b = new sg();
            }
            return true;
        }
        return false;
    }

    @Override // com.applovin.impl.j8
    public void a(l8 l8Var) {
        this.f59974a = l8Var;
    }

    @Override // com.applovin.impl.j8
    public int a(k8 k8Var, th thVar) throws ch {
        b1.b(this.f59974a);
        if (this.f59975b == null) {
            if (b(k8Var)) {
                k8Var.b();
            } else {
                throw ch.a("Failed to determine bitstream type", null);
            }
        }
        if (!this.f59976c) {
            qo qoVarA = this.f59974a.a(0, 1);
            this.f59974a.c();
            this.f59975b.a(this.f59974a, qoVarA);
            this.f59976c = true;
        }
        return this.f59975b.a(k8Var, thVar);
    }

    private static ah a(ah ahVar) {
        ahVar.f(0);
        return ahVar;
    }

    @Override // com.applovin.impl.j8
    public void a(long j3, long j4) {
        gl glVar = this.f59975b;
        if (glVar != null) {
            glVar.a(j3, j4);
        }
    }

    @Override // com.applovin.impl.j8
    public boolean a(k8 k8Var) {
        try {
            return b(k8Var);
        } catch (ch unused) {
            return false;
        }
    }
}
