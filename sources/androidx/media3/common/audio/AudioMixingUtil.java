package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AudioMixingUtil {
    public static boolean a(AudioProcessor.AudioFormat audioFormat) {
        if (audioFormat.f41287a == -1 || audioFormat.f41288b == -1) {
            return false;
        }
        int i3 = audioFormat.f41289c;
        return i3 == 2 || i3 == 4;
    }

    public static boolean b(AudioProcessor.AudioFormat audioFormat, AudioProcessor.AudioFormat audioFormat2) {
        return audioFormat.f41287a == audioFormat2.f41287a && a(audioFormat) && a(audioFormat2);
    }

    private static float c(float f3) {
        return Util.q(f3 * (f3 < 0.0f ? 32768 : 32767), -32768.0f, 32767.0f);
    }

    private static float d(ByteBuffer byteBuffer, boolean z2, boolean z3) {
        return z3 ? z2 ? byteBuffer.getShort() : c(byteBuffer.getFloat()) : z2 ? e(byteBuffer.getShort()) : byteBuffer.getFloat();
    }

    private static float e(short s2) {
        return s2 / (s2 < 0 ? 32768 : 32767);
    }

    public static ByteBuffer f(ByteBuffer byteBuffer, AudioProcessor.AudioFormat audioFormat, ByteBuffer byteBuffer2, AudioProcessor.AudioFormat audioFormat2, ChannelMixingMatrix channelMixingMatrix, int i3, boolean z2, boolean z3) {
        boolean z4 = audioFormat.f41289c == 2;
        boolean z5 = audioFormat2.f41289c == 2;
        int iD = channelMixingMatrix.d();
        int iF = channelMixingMatrix.f();
        float[] fArr = new float[iD];
        float[] fArr2 = new float[iF];
        for (int i4 = 0; i4 < i3; i4++) {
            if (z2) {
                int iPosition = byteBuffer2.position();
                for (int i5 = 0; i5 < iF; i5++) {
                    fArr2[i5] = d(byteBuffer2, z5, z5);
                }
                byteBuffer2.position(iPosition);
            }
            for (int i6 = 0; i6 < iD; i6++) {
                fArr[i6] = d(byteBuffer, z4, z5);
            }
            for (int i7 = 0; i7 < iF; i7++) {
                for (int i8 = 0; i8 < iD; i8++) {
                    fArr2[i7] = fArr2[i7] + (fArr[i8] * channelMixingMatrix.e(i8, i7));
                }
                if (z5) {
                    byteBuffer2.putShort((short) Util.q(fArr2[i7], -32768.0f, 32767.0f));
                } else {
                    byteBuffer2.putFloat(z3 ? Util.q(fArr2[i7], -1.0f, 1.0f) : fArr2[i7]);
                }
                fArr2[i7] = 0.0f;
            }
        }
        return byteBuffer2;
    }
}
