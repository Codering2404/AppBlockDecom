package com.applovin.impl;

import com.applovin.impl.qo;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class h7 implements qo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f60141a = new byte[4096];

    @Override // com.applovin.impl.qo
    public void a(long j3, int i3, int i4, int i5, qo.a aVar) {
    }

    @Override // com.applovin.impl.qo
    public void a(e9 e9Var) {
    }

    @Override // com.applovin.impl.qo
    public int a(f5 f5Var, int i3, boolean z2, int i4) throws EOFException {
        int iA = f5Var.a(this.f60141a, 0, Math.min(this.f60141a.length, i3));
        if (iA != -1) {
            return iA;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.applovin.impl.qo
    public void a(ah ahVar, int i3, int i4) {
        ahVar.g(i3);
    }
}
