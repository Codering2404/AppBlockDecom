package com.applovin.impl;

import com.applovin.impl.p1;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class b9 extends z1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f58603i = Float.floatToIntBits(Float.NaN);

    b9() {
    }

    @Override // com.applovin.impl.p1
    public void a(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferA;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i3 = iLimit - iPosition;
        int i4 = this.f65285b.f62404c;
        if (i4 == 536870912) {
            byteBufferA = a((i3 / 3) * 4);
            while (iPosition < iLimit) {
                a(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), byteBufferA);
                iPosition += 3;
            }
        } else {
            if (i4 != 805306368) {
                throw new IllegalStateException();
            }
            byteBufferA = a(i3);
            while (iPosition < iLimit) {
                a((byteBuffer.get(iPosition) & 255) | ((byteBuffer.get(iPosition + 1) & 255) << 8) | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), byteBufferA);
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferA.flip();
    }

    @Override // com.applovin.impl.z1
    public p1.a b(p1.a aVar) throws p1.b {
        int i3 = aVar.f62404c;
        if (xp.f(i3)) {
            return i3 != 4 ? new p1.a(aVar.f62402a, aVar.f62403b, 4) : p1.a.f62401e;
        }
        throw new p1.b(aVar);
    }

    private static void a(int i3, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (((double) i3) * 4.656612875245797E-10d));
        if (iFloatToIntBits == f58603i) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }
}
