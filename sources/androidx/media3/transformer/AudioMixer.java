package androidx.media3.transformer;

import androidx.media3.common.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface AudioMixer {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Factory {
        AudioMixer create();
    }

    int a(AudioProcessor.AudioFormat audioFormat, long j3);

    boolean b();

    ByteBuffer c();

    void d(int i3);

    boolean e(int i3);

    void f(int i3, ByteBuffer byteBuffer);

    void g(AudioProcessor.AudioFormat audioFormat, int i3, long j3);

    void reset();
}
