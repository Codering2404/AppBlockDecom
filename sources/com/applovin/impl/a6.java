package com.applovin.impl;

import com.facebook.internal.NativeProtocol;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class a6 implements k8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f5 f58208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f58209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f58210d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f58212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f58213g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f58211e = new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f58207a = new byte[4096];

    public a6(f5 f5Var, long j3, long j4) {
        this.f58208b = f5Var;
        this.f58210d = j3;
        this.f58209c = j4;
    }

    private void d(int i3) {
        if (i3 != -1) {
            this.f58210d += (long) i3;
        }
    }

    private void e(int i3) {
        int i4 = this.f58212f + i3;
        byte[] bArr = this.f58211e;
        if (i4 > bArr.length) {
            this.f58211e = Arrays.copyOf(this.f58211e, xp.a(bArr.length * 2, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + i4, i4 + 524288));
        }
    }

    private void g(int i3) {
        int i4 = this.f58213g - i3;
        this.f58213g = i4;
        this.f58212f = 0;
        byte[] bArr = this.f58211e;
        byte[] bArr2 = i4 < bArr.length - 524288 ? new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + i4] : bArr;
        System.arraycopy(bArr, i3, bArr2, 0, i4);
        this.f58211e = bArr2;
    }

    @Override // com.applovin.impl.k8
    public boolean a(int i3, boolean z2) throws EOFException, InterruptedIOException {
        e(i3);
        int iA = this.f58213g - this.f58212f;
        while (iA < i3) {
            int i4 = i3;
            boolean z3 = z2;
            iA = a(this.f58211e, this.f58212f, i4, iA, z3);
            if (iA == -1) {
                return false;
            }
            this.f58213g = this.f58212f + iA;
            i3 = i4;
            z2 = z3;
        }
        this.f58212f += i3;
        return true;
    }

    @Override // com.applovin.impl.k8
    public int b(byte[] bArr, int i3, int i4) throws EOFException, InterruptedIOException {
        a6 a6Var;
        int iMin;
        e(i4);
        int i5 = this.f58213g;
        int i6 = this.f58212f;
        int i7 = i5 - i6;
        if (i7 == 0) {
            a6Var = this;
            iMin = a6Var.a(this.f58211e, i6, i4, 0, true);
            if (iMin == -1) {
                return -1;
            }
            a6Var.f58213g += iMin;
        } else {
            a6Var = this;
            iMin = Math.min(i4, i7);
        }
        System.arraycopy(a6Var.f58211e, a6Var.f58212f, bArr, i3, iMin);
        a6Var.f58212f += iMin;
        return iMin;
    }

    @Override // com.applovin.impl.k8
    public void c(int i3) throws EOFException, InterruptedIOException {
        a(i3, false);
    }

    @Override // com.applovin.impl.k8
    public long f() {
        return this.f58210d;
    }

    private int f(int i3) {
        int iMin = Math.min(this.f58213g, i3);
        g(iMin);
        return iMin;
    }

    @Override // com.applovin.impl.k8
    public void c(byte[] bArr, int i3, int i4) {
        b(bArr, i3, i4, false);
    }

    @Override // com.applovin.impl.k8
    public long d() {
        return this.f58210d + ((long) this.f58212f);
    }

    @Override // com.applovin.impl.k8
    public void d(byte[] bArr, int i3, int i4) throws EOFException, InterruptedIOException {
        a(bArr, i3, i4, false);
    }

    private int e(byte[] bArr, int i3, int i4) {
        int i5 = this.f58213g;
        if (i5 == 0) {
            return 0;
        }
        int iMin = Math.min(i5, i4);
        System.arraycopy(this.f58211e, 0, bArr, i3, iMin);
        g(iMin);
        return iMin;
    }

    @Override // com.applovin.impl.k8
    public long a() {
        return this.f58209c;
    }

    @Override // com.applovin.impl.k8, com.applovin.impl.f5
    public int a(byte[] bArr, int i3, int i4) throws EOFException, InterruptedIOException {
        int iE = e(bArr, i3, i4);
        if (iE == 0) {
            iE = a(bArr, i3, i4, 0, true);
        }
        d(iE);
        return iE;
    }

    @Override // com.applovin.impl.k8
    public boolean b(byte[] bArr, int i3, int i4, boolean z2) {
        if (!a(i4, z2)) {
            return false;
        }
        System.arraycopy(this.f58211e, this.f58212f - i4, bArr, i3, i4);
        return true;
    }

    @Override // com.applovin.impl.k8
    public boolean a(byte[] bArr, int i3, int i4, boolean z2) throws EOFException, InterruptedIOException {
        int iE = e(bArr, i3, i4);
        while (iE < i4 && iE != -1) {
            iE = a(bArr, i3, i4, iE, z2);
        }
        d(iE);
        return iE != -1;
    }

    @Override // com.applovin.impl.k8
    public void b() {
        this.f58212f = 0;
    }

    @Override // com.applovin.impl.k8
    public int b(int i3) throws EOFException, InterruptedIOException {
        int iF = f(i3);
        if (iF == 0) {
            byte[] bArr = this.f58207a;
            iF = a(bArr, 0, Math.min(i3, bArr.length), 0, true);
        }
        d(iF);
        return iF;
    }

    @Override // com.applovin.impl.k8
    public void a(int i3) throws EOFException, InterruptedIOException {
        b(i3, false);
    }

    private int a(byte[] bArr, int i3, int i4, int i5, boolean z2) throws EOFException, InterruptedIOException {
        if (!Thread.interrupted()) {
            int iA = this.f58208b.a(bArr, i3 + i5, i4 - i5);
            if (iA != -1) {
                return i5 + iA;
            }
            if (i5 == 0 && z2) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedIOException();
    }

    public boolean b(int i3, boolean z2) throws EOFException, InterruptedIOException {
        int iF = f(i3);
        while (iF < i3 && iF != -1) {
            iF = a(this.f58207a, -iF, Math.min(i3, this.f58207a.length + iF), iF, z2);
        }
        d(iF);
        return iF != -1;
    }
}
