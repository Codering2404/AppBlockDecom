package com.applovin.impl;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class sa implements h5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h5 f63007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f63008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f63009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f63010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f63011e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(ah ahVar);
    }

    public sa(h5 h5Var, int i3, a aVar) {
        b1.a(i3 > 0);
        this.f63007a = h5Var;
        this.f63008b = i3;
        this.f63009c = aVar;
        this.f63010d = new byte[1];
        this.f63011e = i3;
    }

    private boolean g() {
        if (this.f63007a.a(this.f63010d, 0, 1) == -1) {
            return false;
        }
        int i3 = (this.f63010d[0] & 255) << 4;
        if (i3 == 0) {
            return true;
        }
        byte[] bArr = new byte[i3];
        int i4 = i3;
        int i5 = 0;
        while (i4 > 0) {
            int iA = this.f63007a.a(bArr, i5, i4);
            if (iA == -1) {
                return false;
            }
            i5 += iA;
            i4 -= iA;
        }
        while (i3 > 0 && bArr[i3 - 1] == 0) {
            i3--;
        }
        if (i3 > 0) {
            this.f63009c.a(new ah(bArr, i3));
        }
        return true;
    }

    @Override // com.applovin.impl.h5
    public void a(xo xoVar) {
        b1.a(xoVar);
        this.f63007a.a(xoVar);
    }

    @Override // com.applovin.impl.h5
    public Uri c() {
        return this.f63007a.c();
    }

    @Override // com.applovin.impl.h5
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // com.applovin.impl.h5
    public Map e() {
        return this.f63007a.e();
    }

    @Override // com.applovin.impl.f5
    public int a(byte[] bArr, int i3, int i4) {
        if (this.f63011e == 0) {
            if (!g()) {
                return -1;
            }
            this.f63011e = this.f63008b;
        }
        int iA = this.f63007a.a(bArr, i3, Math.min(this.f63011e, i4));
        if (iA != -1) {
            this.f63011e -= iA;
        }
        return iA;
    }

    @Override // com.applovin.impl.h5
    public long a(k5 k5Var) {
        throw new UnsupportedOperationException();
    }
}
