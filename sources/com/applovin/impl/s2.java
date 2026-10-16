package com.applovin.impl;

import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f62955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f62956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f62957c;

    s2() {
    }

    private long a(long j3) {
        return this.f62955a + Math.max(0L, ((this.f62956b - 529) * 1000000) / j3);
    }

    public long a(e9 e9Var) {
        return a(e9Var.A);
    }

    public void a() {
        this.f62955a = 0L;
        this.f62956b = 0L;
        this.f62957c = false;
    }

    public long a(e9 e9Var, o5 o5Var) {
        if (this.f62956b == 0) {
            this.f62955a = o5Var.f62185f;
        }
        if (this.f62957c) {
            return o5Var.f62185f;
        }
        ByteBuffer byteBuffer = (ByteBuffer) b1.a(o5Var.f62183c);
        int i3 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            i3 = (i3 << 8) | (byteBuffer.get(i4) & 255);
        }
        int iD = sf.d(i3);
        if (iD == -1) {
            this.f62957c = true;
            this.f62956b = 0L;
            this.f62955a = o5Var.f62185f;
            oc.d("C2Mp3TimestampTracker", FptyjHFU.TCe);
            return o5Var.f62185f;
        }
        long jA = a(e9Var.A);
        this.f62956b += (long) iD;
        return jA;
    }
}
