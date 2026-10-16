package com.applovin.impl;

import com.applovin.impl.p1;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ak extends z1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f58450i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f58451j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final short f58452k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f58453l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f58454m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte[] f58455n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private byte[] f58456o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f58457p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f58458q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f58459r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f58460s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f58461t;

    public ak() {
        this(150000L, 20000L, (short) 1024);
    }

    private int a(long j3) {
        return (int) ((j3 * ((long) this.f65285b.f62402a)) / 1000000);
    }

    private int b(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        do {
            iLimit -= 2;
            if (iLimit < byteBuffer.position()) {
                return byteBuffer.position();
            }
        } while (Math.abs((int) byteBuffer.getShort(iLimit)) <= this.f58452k);
        int i3 = this.f58453l;
        return ((iLimit / i3) * i3) + i3;
    }

    private int c(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position(); iPosition < byteBuffer.limit(); iPosition += 2) {
            if (Math.abs((int) byteBuffer.getShort(iPosition)) > this.f58452k) {
                int i3 = this.f58453l;
                return i3 * (iPosition / i3);
            }
        }
        return byteBuffer.limit();
    }

    private void d(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        a(iRemaining).put(byteBuffer).flip();
        if (iRemaining > 0) {
            this.f58460s = true;
        }
    }

    private void e(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iC = c(byteBuffer);
        int iPosition = iC - byteBuffer.position();
        byte[] bArr = this.f58455n;
        int length = bArr.length;
        int i3 = this.f58458q;
        int i4 = length - i3;
        if (iC < iLimit && iPosition < i4) {
            a(bArr, i3);
            this.f58458q = 0;
            this.f58457p = 0;
            return;
        }
        int iMin = Math.min(iPosition, i4);
        byteBuffer.limit(byteBuffer.position() + iMin);
        byteBuffer.get(this.f58455n, this.f58458q, iMin);
        int i5 = this.f58458q + iMin;
        this.f58458q = i5;
        byte[] bArr2 = this.f58455n;
        if (i5 == bArr2.length) {
            if (this.f58460s) {
                a(bArr2, this.f58459r);
                this.f58461t += (long) ((this.f58458q - (this.f58459r * 2)) / this.f58453l);
            } else {
                this.f58461t += (long) ((i5 - this.f58459r) / this.f58453l);
            }
            a(byteBuffer, this.f58455n, this.f58458q);
            this.f58458q = 0;
            this.f58457p = 2;
        }
        byteBuffer.limit(iLimit);
    }

    @Override // com.applovin.impl.z1, com.applovin.impl.p1
    public boolean f() {
        return this.f58454m;
    }

    @Override // com.applovin.impl.z1
    protected void g() {
        if (this.f58454m) {
            this.f58453l = this.f65285b.f62405d;
            int iA = a(this.f58450i) * this.f58453l;
            if (this.f58455n.length != iA) {
                this.f58455n = new byte[iA];
            }
            int iA2 = a(this.f58451j) * this.f58453l;
            this.f58459r = iA2;
            if (this.f58456o.length != iA2) {
                this.f58456o = new byte[iA2];
            }
        }
        this.f58457p = 0;
        this.f58461t = 0L;
        this.f58458q = 0;
        this.f58460s = false;
    }

    @Override // com.applovin.impl.z1
    protected void h() {
        int i3 = this.f58458q;
        if (i3 > 0) {
            a(this.f58455n, i3);
        }
        if (this.f58460s) {
            return;
        }
        this.f58461t += (long) (this.f58459r / this.f58453l);
    }

    @Override // com.applovin.impl.z1
    protected void i() {
        this.f58454m = false;
        this.f58459r = 0;
        byte[] bArr = xp.f65032f;
        this.f58455n = bArr;
        this.f58456o = bArr;
    }

    public long j() {
        return this.f58461t;
    }

    public ak(long j3, long j4, short s2) {
        b1.a(j4 <= j3);
        this.f58450i = j3;
        this.f58451j = j4;
        this.f58452k = s2;
        byte[] bArr = xp.f65032f;
        this.f58455n = bArr;
        this.f58456o = bArr;
    }

    private void a(byte[] bArr, int i3) {
        a(i3).put(bArr, 0, i3).flip();
        if (i3 > 0) {
            this.f58460s = true;
        }
    }

    private void f(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.f58455n.length));
        int iB = b(byteBuffer);
        if (iB == byteBuffer.position()) {
            this.f58457p = 1;
        } else {
            byteBuffer.limit(iB);
            d(byteBuffer);
        }
        byteBuffer.limit(iLimit);
    }

    @Override // com.applovin.impl.p1
    public void a(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !a()) {
            int i3 = this.f58457p;
            if (i3 == 0) {
                f(byteBuffer);
            } else if (i3 == 1) {
                e(byteBuffer);
            } else if (i3 == 2) {
                g(byteBuffer);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override // com.applovin.impl.z1
    public p1.a b(p1.a aVar) throws p1.b {
        if (aVar.f62404c == 2) {
            return this.f58454m ? aVar : p1.a.f62401e;
        }
        throw new p1.b(aVar);
    }

    public void a(boolean z2) {
        this.f58454m = z2;
    }

    private void a(ByteBuffer byteBuffer, byte[] bArr, int i3) {
        int iMin = Math.min(byteBuffer.remaining(), this.f58459r);
        int i4 = this.f58459r - iMin;
        System.arraycopy(bArr, i3 - i4, this.f58456o, 0, i4);
        byteBuffer.position(byteBuffer.limit() - iMin);
        byteBuffer.get(this.f58456o, i4, iMin);
    }

    private void g(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iC = c(byteBuffer);
        byteBuffer.limit(iC);
        this.f58461t += (long) (byteBuffer.remaining() / this.f58453l);
        a(byteBuffer, this.f58456o, this.f58459r);
        if (iC < iLimit) {
            a(this.f58456o, this.f58459r);
            this.f58457p = 0;
            byteBuffer.limit(iLimit);
        }
    }
}
