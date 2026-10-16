package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ToFloatPcmAudioProcessor extends androidx.media3.common.audio.BaseAudioProcessor {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f43898i = Float.floatToIntBits(Float.NaN);

    ToFloatPcmAudioProcessor() {
    }

    private static void m(int i3, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (((double) i3) * 4.656612875245797E-10d));
        if (iFloatToIntBits == f43898i) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void d(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferL;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i3 = iLimit - iPosition;
        int i4 = this.f41292b.f41289c;
        if (i4 == 21) {
            byteBufferL = l((i3 / 3) * 4);
            while (iPosition < iLimit) {
                m(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), byteBufferL);
                iPosition += 3;
            }
        } else if (i4 == 22) {
            byteBufferL = l(i3);
            while (iPosition < iLimit) {
                m((byteBuffer.get(iPosition) & 255) | ((byteBuffer.get(iPosition + 1) & 255) << 8) | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), byteBufferL);
                iPosition += 4;
            }
        } else if (i4 == 1342177280) {
            byteBufferL = l((i3 / 3) * 4);
            while (iPosition < iLimit) {
                m(((byteBuffer.get(iPosition + 2) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferL);
                iPosition += 3;
            }
        } else {
            if (i4 != 1610612736) {
                throw new IllegalStateException();
            }
            byteBufferL = l(i3);
            while (iPosition < iLimit) {
                m((byteBuffer.get(iPosition + 3) & 255) | ((byteBuffer.get(iPosition + 2) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferL);
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferL.flip();
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat h(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i3 = audioFormat.f41289c;
        if (Util.B0(i3)) {
            return i3 != 4 ? new AudioProcessor.AudioFormat(audioFormat.f41287a, audioFormat.f41288b, 4) : AudioProcessor.AudioFormat.f41286e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }
}
