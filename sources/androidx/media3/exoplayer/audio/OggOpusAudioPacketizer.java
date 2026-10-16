package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.extractor.OpusUtil;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class OggOpusAudioPacketizer {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f43869d = {79, 103, 103, 83, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Ascii.FS, -43, -59, -9, 1, 19, 79, 112, 117, 115, 72, 101, 97, 100, 1, 2, 56, 1, -128, -69, 0, 0, 0, 0, 0};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f43870e = {79, 103, 103, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, Ascii.VT, -103, 87, 83, 1, Ascii.DLE, 79, 112, 117, 115, 84, 97, 103, 115, 0, 0, 0, 0, 0, 0, 0, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ByteBuffer f43871a = AudioProcessor.f41285a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f43873c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f43872b = 2;

    private ByteBuffer b(ByteBuffer byteBuffer, byte[] bArr) {
        int i3;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i4 = iLimit - iPosition;
        int i5 = (i4 + 255) / 255;
        int length = i5 + 27 + i4;
        if (this.f43872b == 2) {
            int length2 = bArr != null ? bArr.length + 28 : f43869d.length;
            length += f43870e.length + length2;
            i3 = length2;
        } else {
            i3 = 0;
        }
        ByteBuffer byteBufferC = c(length);
        if (this.f43872b == 2) {
            if (bArr != null) {
                e(byteBufferC, bArr);
            } else {
                byteBufferC.put(f43869d);
            }
            byteBufferC.put(f43870e);
        }
        int iJ = this.f43873c + OpusUtil.j(byteBuffer);
        this.f43873c = iJ;
        f(byteBufferC, iJ, this.f43872b, i5, false);
        for (int i6 = 0; i6 < i5; i6++) {
            if (i4 >= 255) {
                byteBufferC.put((byte) -1);
                i4 -= 255;
            } else {
                byteBufferC.put((byte) i4);
                i4 = 0;
            }
        }
        while (iPosition < iLimit) {
            byteBufferC.put(byteBuffer.get(iPosition));
            iPosition++;
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferC.flip();
        if (this.f43872b == 2) {
            byte[] bArrArray = byteBufferC.array();
            int iArrayOffset = byteBufferC.arrayOffset() + i3;
            byte[] bArr2 = f43870e;
            byteBufferC.putInt(i3 + bArr2.length + 22, Util.z(bArrArray, iArrayOffset + bArr2.length, byteBufferC.limit() - byteBufferC.position(), 0));
        } else {
            byteBufferC.putInt(22, Util.z(byteBufferC.array(), byteBufferC.arrayOffset(), byteBufferC.limit() - byteBufferC.position(), 0));
        }
        this.f43872b++;
        return byteBufferC;
    }

    private ByteBuffer c(int i3) {
        if (this.f43871a.capacity() < i3) {
            this.f43871a = ByteBuffer.allocate(i3).order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f43871a.clear();
        }
        return this.f43871a;
    }

    private void e(ByteBuffer byteBuffer, byte[] bArr) {
        f(byteBuffer, 0L, 0, 1, true);
        byteBuffer.put(UnsignedBytes.a(bArr.length));
        byteBuffer.put(bArr);
        byteBuffer.putInt(22, Util.z(byteBuffer.array(), byteBuffer.arrayOffset(), bArr.length + 28, 0));
        byteBuffer.position(bArr.length + 28);
    }

    private void f(ByteBuffer byteBuffer, long j3, int i3, int i4, boolean z2) {
        byteBuffer.put((byte) 79);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 83);
        byteBuffer.put((byte) 0);
        byteBuffer.put(z2 ? (byte) 2 : (byte) 0);
        byteBuffer.putLong(j3);
        byteBuffer.putInt(0);
        byteBuffer.putInt(i3);
        byteBuffer.putInt(0);
        byteBuffer.put(UnsignedBytes.a(i4));
    }

    public void a(DecoderInputBuffer decoderInputBuffer, List list) {
        Assertions.e(decoderInputBuffer.f42138d);
        if (decoderInputBuffer.f42138d.limit() - decoderInputBuffer.f42138d.position() == 0) {
            return;
        }
        this.f43871a = b(decoderInputBuffer.f42138d, (this.f43872b == 2 && (list.size() == 1 || list.size() == 3)) ? (byte[]) list.get(0) : null);
        decoderInputBuffer.f();
        decoderInputBuffer.p(this.f43871a.remaining());
        decoderInputBuffer.f42138d.put(this.f43871a);
        decoderInputBuffer.q();
    }

    public void d() {
        this.f43871a = AudioProcessor.f41285a;
        this.f43873c = 0;
        this.f43872b = 2;
    }
}
