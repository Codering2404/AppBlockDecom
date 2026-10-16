package com.applovin.impl;

import android.net.Uri;
import java.io.EOFException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class q2 implements zh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n8 f62555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j8 f62556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private k8 f62557c;

    public q2(n8 n8Var) {
        this.f62555a = n8Var;
    }

    @Override // com.applovin.impl.zh
    public void a(f5 f5Var, Uri uri, Map map, long j3, long j4, l8 l8Var) throws rp {
        a6 a6Var = new a6(f5Var, j3, j4);
        this.f62557c = a6Var;
        if (this.f62556b != null) {
            return;
        }
        j8[] j8VarArrA = this.f62555a.a(uri, map);
        if (j8VarArrA.length == 1) {
            this.f62556b = j8VarArrA[0];
        } else {
            int length = j8VarArrA.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                j8 j8Var = j8VarArrA[i3];
                try {
                    if (j8Var.a(a6Var)) {
                        this.f62556b = j8Var;
                        b1.b(true);
                        a6Var.b();
                        break;
                    }
                    b1.b(this.f62556b != null || a6Var.f() == j3);
                    a6Var.b();
                } catch (EOFException unused) {
                    b1.b(this.f62556b != null || a6Var.f() == j3);
                    a6Var.b();
                } catch (Throwable th) {
                    b1.b(this.f62556b != null || a6Var.f() == j3);
                    a6Var.b();
                    throw th;
                }
                i3++;
            }
            if (this.f62556b == null) {
                throw new rp("None of the available extractors (" + xp.b(j8VarArrA) + ") could read the stream.", (Uri) b1.a(uri));
            }
        }
        this.f62556b.a(l8Var);
    }

    @Override // com.applovin.impl.zh
    public long b() {
        k8 k8Var = this.f62557c;
        if (k8Var != null) {
            return k8Var.f();
        }
        return -1L;
    }

    @Override // com.applovin.impl.zh
    public void c() {
        j8 j8Var = this.f62556b;
        if (j8Var instanceof nf) {
            ((nf) j8Var).c();
        }
    }

    @Override // com.applovin.impl.zh
    public int a(th thVar) {
        return ((j8) b1.a(this.f62556b)).a((k8) b1.a(this.f62557c), thVar);
    }

    @Override // com.applovin.impl.zh
    public void a() {
        j8 j8Var = this.f62556b;
        if (j8Var != null) {
            j8Var.a();
            this.f62556b = null;
        }
        this.f62557c = null;
    }

    @Override // com.applovin.impl.zh
    public void a(long j3, long j4) {
        ((j8) b1.a(this.f62556b)).a(j3, j4);
    }
}
