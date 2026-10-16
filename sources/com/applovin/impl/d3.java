package com.applovin.impl;

import com.applovin.impl.p1;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class d3 extends z1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f59062i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f59063j;

    d3() {
    }

    @Override // com.applovin.impl.p1
    public void a(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) b1.a(this.f59063j);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferA = a(((iLimit - iPosition) / this.f65285b.f62405d) * this.f65286c.f62405d);
        while (iPosition < iLimit) {
            for (int i3 : iArr) {
                byteBufferA.putShort(byteBuffer.getShort((i3 * 2) + iPosition));
            }
            iPosition += this.f65285b.f62405d;
        }
        byteBuffer.position(iLimit);
        byteBufferA.flip();
    }

    @Override // com.applovin.impl.z1
    public p1.a b(p1.a aVar) throws p1.b {
        int[] iArr = this.f59062i;
        if (iArr == null) {
            return p1.a.f62401e;
        }
        if (aVar.f62404c != 2) {
            throw new p1.b(aVar);
        }
        boolean z2 = aVar.f62403b != iArr.length;
        int i3 = 0;
        while (i3 < iArr.length) {
            int i4 = iArr[i3];
            if (i4 >= aVar.f62403b) {
                throw new p1.b(aVar);
            }
            z2 |= i4 != i3;
            i3++;
        }
        return z2 ? new p1.a(aVar.f62402a, iArr.length, 2) : p1.a.f62401e;
    }

    @Override // com.applovin.impl.z1
    protected void g() {
        this.f59063j = this.f59062i;
    }

    @Override // com.applovin.impl.z1
    protected void i() {
        this.f59063j = null;
        this.f59062i = null;
    }

    public void a(int[] iArr) {
        this.f59062i = iArr;
    }
}
