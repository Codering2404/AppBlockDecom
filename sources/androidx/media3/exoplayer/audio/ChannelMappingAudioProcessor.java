package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ChannelMappingAudioProcessor extends androidx.media3.common.audio.BaseAudioProcessor {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f43756i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f43757j;

    ChannelMappingAudioProcessor() {
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void d(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) Assertions.e(this.f43757j);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferL = l(((iLimit - iPosition) / this.f41292b.f41290d) * this.f41293c.f41290d);
        while (iPosition < iLimit) {
            for (int i3 : iArr) {
                int iT = (Util.T(this.f41292b.f41289c) * i3) + iPosition;
                int i4 = this.f41292b.f41289c;
                if (i4 == 2) {
                    byteBufferL.putShort(byteBuffer.getShort(iT));
                } else {
                    if (i4 != 4) {
                        throw new IllegalStateException("Unexpected encoding: " + this.f41292b.f41289c);
                    }
                    byteBufferL.putFloat(byteBuffer.getFloat(iT));
                }
            }
            iPosition += this.f41292b.f41290d;
        }
        byteBuffer.position(iLimit);
        byteBufferL.flip();
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat h(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int[] iArr = this.f43756i;
        if (iArr == null) {
            return AudioProcessor.AudioFormat.f41286e;
        }
        int i3 = audioFormat.f41289c;
        if (i3 != 2 && i3 != 4) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        boolean z2 = audioFormat.f41288b != iArr.length;
        int i4 = 0;
        while (i4 < iArr.length) {
            int i5 = iArr[i4];
            if (i5 >= audioFormat.f41288b) {
                throw new AudioProcessor.UnhandledAudioFormatException("Channel map (" + Arrays.toString(iArr) + ") trying to access non-existent input channel.", audioFormat);
            }
            z2 |= i5 != i4;
            i4++;
        }
        return z2 ? new AudioProcessor.AudioFormat(audioFormat.f41287a, iArr.length, audioFormat.f41289c) : AudioProcessor.AudioFormat.f41286e;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    protected void i() {
        this.f43757j = this.f43756i;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    protected void k() {
        this.f43757j = null;
        this.f43756i = null;
    }

    public void m(int[] iArr) {
        this.f43756i = iArr;
    }
}
