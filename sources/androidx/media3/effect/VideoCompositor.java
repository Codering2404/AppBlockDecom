package androidx.media3.effect;

import androidx.media3.common.ColorInfo;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface VideoCompositor extends GlTextureProducer {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void a(VideoFrameProcessingException videoFrameProcessingException);

        void b();
    }

    void b(int i3, GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, ColorInfo colorInfo, long j3);

    void e(int i3);

    void f(int i3);

    void release();
}
