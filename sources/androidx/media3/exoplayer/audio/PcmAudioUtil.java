package androidx.media3.exoplayer.audio;

import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PcmAudioUtil {
    public static ByteBuffer a(ByteBuffer byteBuffer, int i3, int i4, int i5, int i6) {
        ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(byteBuffer.remaining()).order(ByteOrder.nativeOrder());
        int iPosition = byteBuffer.position();
        while (byteBuffer.hasRemaining() && i5 < i6) {
            c(byteBufferOrder, (int) ((((long) b(byteBuffer, i3)) * ((long) i5)) / ((long) i6)), i3);
            if (byteBuffer.position() == iPosition + i4) {
                i5++;
                iPosition = byteBuffer.position();
            }
        }
        byteBufferOrder.put(byteBuffer);
        byteBufferOrder.flip();
        return byteBufferOrder;
    }

    public static int b(ByteBuffer byteBuffer, int i3) {
        if (i3 == 2) {
            return ((byteBuffer.get() & 255) << 24) | ((byteBuffer.get() & 255) << 16);
        }
        if (i3 == 3) {
            return (byteBuffer.get() & 255) << 24;
        }
        if (i3 == 4) {
            float fQ = Util.q(byteBuffer.getFloat(), -1.0f, 1.0f);
            return fQ < 0.0f ? (int) ((-fQ) * (-2.1474836E9f)) : (int) (fQ * 2.1474836E9f);
        }
        if (i3 == 21) {
            return ((byteBuffer.get() & 255) << 24) | ((byteBuffer.get() & 255) << 8) | ((byteBuffer.get() & 255) << 16);
        }
        if (i3 == 22) {
            return ((byteBuffer.get() & 255) << 24) | (byteBuffer.get() & 255) | ((byteBuffer.get() & 255) << 8) | ((byteBuffer.get() & 255) << 16);
        }
        if (i3 == 268435456) {
            return ((byteBuffer.get() & 255) << 16) | ((byteBuffer.get() & 255) << 24);
        }
        if (i3 == 1342177280) {
            return ((byteBuffer.get() & 255) << 8) | ((byteBuffer.get() & 255) << 24) | ((byteBuffer.get() & 255) << 16);
        }
        if (i3 == 1610612736) {
            return (byteBuffer.get() & 255) | ((byteBuffer.get() & 255) << 24) | ((byteBuffer.get() & 255) << 16) | ((byteBuffer.get() & 255) << 8);
        }
        throw new IllegalStateException();
    }

    public static void c(ByteBuffer byteBuffer, int i3, int i4) {
        if (i4 == 2) {
            byteBuffer.put((byte) (i3 >> 16));
            byteBuffer.put((byte) (i3 >> 24));
            return;
        }
        if (i4 == 3) {
            byteBuffer.put((byte) (i3 >> 24));
            return;
        }
        if (i4 == 4) {
            if (i3 < 0) {
                byteBuffer.putFloat((-i3) / (-2.1474836E9f));
                return;
            } else {
                byteBuffer.putFloat(i3 / 2.1474836E9f);
                return;
            }
        }
        if (i4 == 21) {
            byteBuffer.put((byte) (i3 >> 8));
            byteBuffer.put((byte) (i3 >> 16));
            byteBuffer.put((byte) (i3 >> 24));
            return;
        }
        if (i4 == 22) {
            byteBuffer.put((byte) i3);
            byteBuffer.put((byte) (i3 >> 8));
            byteBuffer.put((byte) (i3 >> 16));
            byteBuffer.put((byte) (i3 >> 24));
            return;
        }
        if (i4 == 268435456) {
            byteBuffer.put((byte) (i3 >> 24));
            byteBuffer.put((byte) (i3 >> 16));
            return;
        }
        if (i4 == 1342177280) {
            byteBuffer.put((byte) (i3 >> 24));
            byteBuffer.put((byte) (i3 >> 16));
            byteBuffer.put((byte) (i3 >> 8));
        } else {
            if (i4 != 1610612736) {
                throw new IllegalStateException();
            }
            byteBuffer.put((byte) (i3 >> 24));
            byteBuffer.put((byte) (i3 >> 16));
            byteBuffer.put((byte) (i3 >> 8));
            byteBuffer.put((byte) i3);
        }
    }
}
