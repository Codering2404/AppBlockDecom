package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface GlShaderProgram {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ErrorListener {
        void a(VideoFrameProcessingException videoFrameProcessingException);
    }

    void c();

    void d(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j3);

    void flush();

    void g(Executor executor, ErrorListener errorListener);

    void k(OutputListener outputListener);

    void l(GlTextureInfo glTextureInfo);

    void m(InputListener inputListener);

    void release();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InputListener {
        default void b() {
        }

        default void f() {
        }

        default void e(GlTextureInfo glTextureInfo) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OutputListener {
        default void c() {
        }

        default void a(GlTextureInfo glTextureInfo, long j3) {
        }
    }
}
