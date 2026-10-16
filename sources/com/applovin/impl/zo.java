package com.applovin.impl;

import com.applovin.impl.p1;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zo extends z1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f65473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f65474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f65475k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f65476l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private byte[] f65477m = xp.f65032f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f65478n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f65479o;

    @Override // com.applovin.impl.p1
    public void a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i3 = iLimit - iPosition;
        if (i3 == 0) {
            return;
        }
        int iMin = Math.min(i3, this.f65476l);
        this.f65479o += (long) (iMin / this.f65285b.f62405d);
        this.f65476l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.f65476l > 0) {
            return;
        }
        int i4 = i3 - iMin;
        int length = (this.f65478n + i4) - this.f65477m.length;
        ByteBuffer byteBufferA = a(length);
        int iA = xp.a(length, 0, this.f65478n);
        byteBufferA.put(this.f65477m, 0, iA);
        int iA2 = xp.a(length - iA, 0, i4);
        byteBuffer.limit(byteBuffer.position() + iA2);
        byteBufferA.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i5 = i4 - iA2;
        int i6 = this.f65478n - iA;
        this.f65478n = i6;
        byte[] bArr = this.f65477m;
        System.arraycopy(bArr, iA, bArr, 0, i6);
        byteBuffer.get(this.f65477m, this.f65478n, i5);
        this.f65478n += i5;
        byteBufferA.flip();
    }

    @Override // com.applovin.impl.z1
    public p1.a b(p1.a aVar) throws p1.b {
        if (aVar.f62404c != 2) {
            throw new p1.b(aVar);
        }
        this.f65475k = true;
        return (this.f65473i == 0 && this.f65474j == 0) ? p1.a.f62401e : aVar;
    }

    @Override // com.applovin.impl.z1, com.applovin.impl.p1
    public boolean c() {
        return super.c() && this.f65478n == 0;
    }

    @Override // com.applovin.impl.z1, com.applovin.impl.p1
    public ByteBuffer d() {
        int i3;
        if (super.c() && (i3 = this.f65478n) > 0) {
            a(i3).put(this.f65477m, 0, this.f65478n).flip();
            this.f65478n = 0;
        }
        return super.d();
    }

    @Override // com.applovin.impl.z1
    protected void g() {
        if (this.f65475k) {
            this.f65475k = false;
            int i3 = this.f65474j;
            int i4 = this.f65285b.f62405d;
            this.f65477m = new byte[i3 * i4];
            this.f65476l = this.f65473i * i4;
        }
        this.f65478n = 0;
    }

    @Override // com.applovin.impl.z1
    protected void h() {
        if (this.f65475k) {
            int i3 = this.f65478n;
            if (i3 > 0) {
                this.f65479o += (long) (i3 / this.f65285b.f62405d);
            }
            this.f65478n = 0;
        }
    }

    @Override // com.applovin.impl.z1
    protected void i() {
        this.f65477m = xp.f65032f;
    }

    public long j() {
        return this.f65479o;
    }

    public void k() {
        this.f65479o = 0L;
    }

    public void a(int i3, int i4) {
        this.f65473i = i3;
        this.f65474j = i4;
    }
}
