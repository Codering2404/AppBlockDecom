package androidx.media3.common.audio;

import android.util.SparseArray;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ChannelMixingAudioProcessor extends BaseAudioProcessor {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SparseArray f41299i = new SparseArray();

    @Override // androidx.media3.common.audio.AudioProcessor
    public void d(ByteBuffer byteBuffer) {
        ChannelMixingMatrix channelMixingMatrix = (ChannelMixingMatrix) Assertions.i((ChannelMixingMatrix) this.f41299i.get(this.f41292b.f41288b));
        int iRemaining = byteBuffer.remaining() / this.f41292b.f41290d;
        ByteBuffer byteBufferL = l(this.f41293c.f41290d * iRemaining);
        AudioMixingUtil.f(byteBuffer, this.f41292b, byteBufferL, this.f41293c, channelMixingMatrix, iRemaining, false, true);
        byteBufferL.flip();
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    protected AudioProcessor.AudioFormat h(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.f41289c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        ChannelMixingMatrix channelMixingMatrix = (ChannelMixingMatrix) this.f41299i.get(audioFormat.f41288b);
        if (channelMixingMatrix != null) {
            return channelMixingMatrix.h() ? AudioProcessor.AudioFormat.f41286e : new AudioProcessor.AudioFormat(audioFormat.f41287a, channelMixingMatrix.f(), 2);
        }
        throw new AudioProcessor.UnhandledAudioFormatException("No mixing matrix for input channel count", audioFormat);
    }

    public void m(ChannelMixingMatrix channelMixingMatrix) {
        this.f41299i.put(channelMixingMatrix.d(), channelMixingMatrix);
    }
}
