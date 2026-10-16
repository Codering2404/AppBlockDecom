package com.applovin.impl;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class fl implements h5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h5 f59712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f59713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f59714c = Uri.EMPTY;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map f59715d = Collections.EMPTY_MAP;

    public fl(h5 h5Var) {
        this.f59712a = (h5) b1.a(h5Var);
    }

    @Override // com.applovin.impl.h5
    public void a(xo xoVar) {
        b1.a(xoVar);
        this.f59712a.a(xoVar);
    }

    @Override // com.applovin.impl.h5
    public Uri c() {
        return this.f59712a.c();
    }

    @Override // com.applovin.impl.h5
    public void close() {
        this.f59712a.close();
    }

    @Override // com.applovin.impl.h5
    public Map e() {
        return this.f59712a.e();
    }

    public long g() {
        return this.f59713b;
    }

    public Uri h() {
        return this.f59714c;
    }

    public Map i() {
        return this.f59715d;
    }

    @Override // com.applovin.impl.h5
    public long a(k5 k5Var) {
        this.f59714c = k5Var.f60912a;
        this.f59715d = Collections.EMPTY_MAP;
        long jA = this.f59712a.a(k5Var);
        this.f59714c = (Uri) b1.a(c());
        this.f59715d = e();
        return jA;
    }

    @Override // com.applovin.impl.f5
    public int a(byte[] bArr, int i3, int i4) {
        int iA = this.f59712a.a(bArr, i3, i4);
        if (iA != -1) {
            this.f59713b += (long) iA;
        }
        return iA;
    }
}
