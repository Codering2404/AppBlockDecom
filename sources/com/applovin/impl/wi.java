package com.applovin.impl;

import com.applovin.impl.p1;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class wi extends z1 {
    wi() {
    }

    @Override // com.applovin.impl.p1
    public void a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i3 = iLimit - iPosition;
        int i4 = this.f65285b.f62404c;
        if (i4 == 3) {
            i3 *= 2;
        } else if (i4 == 4) {
            i3 /= 2;
        } else if (i4 != 268435456) {
            if (i4 != 536870912) {
                if (i4 != 805306368) {
                    throw new IllegalStateException();
                }
                i3 /= 2;
            } else {
                i3 /= 3;
                i3 *= 2;
            }
        }
        ByteBuffer byteBufferA = a(i3);
        int i5 = this.f65285b.f62404c;
        if (i5 == 3) {
            while (iPosition < iLimit) {
                byteBufferA.put((byte) 0);
                byteBufferA.put((byte) ((byteBuffer.get(iPosition) & 255) - 128));
                iPosition++;
            }
        } else if (i5 == 4) {
            while (iPosition < iLimit) {
                short sA = (short) (xp.a(byteBuffer.getFloat(iPosition), -1.0f, 1.0f) * 32767.0f);
                byteBufferA.put((byte) (sA & 255));
                byteBufferA.put((byte) ((sA >> 8) & 255));
                iPosition += 4;
            }
        } else if (i5 == 268435456) {
            while (iPosition < iLimit) {
                byteBufferA.put(byteBuffer.get(iPosition + 1));
                byteBufferA.put(byteBuffer.get(iPosition));
                iPosition += 2;
            }
        } else if (i5 == 536870912) {
            while (iPosition < iLimit) {
                byteBufferA.put(byteBuffer.get(iPosition + 1));
                byteBufferA.put(byteBuffer.get(iPosition + 2));
                iPosition += 3;
            }
        } else {
            if (i5 != 805306368) {
                throw new IllegalStateException();
            }
            while (iPosition < iLimit) {
                byteBufferA.put(byteBuffer.get(iPosition + 2));
                byteBufferA.put(byteBuffer.get(iPosition + 3));
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferA.flip();
    }

    @Override // com.applovin.impl.z1
    public p1.a b(p1.a aVar) throws p1.b {
        int i3 = aVar.f62404c;
        if (i3 == 3 || i3 == 2 || i3 == 268435456 || i3 == 536870912 || i3 == 805306368 || i3 == 4) {
            return i3 != 2 ? new p1.a(aVar.f62402a, aVar.f62403b, 2) : p1.a.f62401e;
        }
        throw new p1.b(aVar);
    }
}
