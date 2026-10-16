package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlRect;
import androidx.media3.common.util.Size;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ByteBufferGlEffect<T> implements GlEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Processor f42222a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Image {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f42223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f42224b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ByteBuffer f42225c;

        Image(int i3, int i4, ByteBuffer byteBuffer) {
            Assertions.a(byteBuffer.capacity() == (i3 * i4) * 4);
            this.f42223a = i3;
            this.f42224b = i4;
            this.f42225c = byteBuffer;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Processor<T> {
        void a(GlTextureInfo glTextureInfo, long j3, Object obj);

        Size c(int i3, int i4);

        GlRect d(long j3);

        ListenableFuture e(Image image, long j3);
    }

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram a(Context context, boolean z2) {
        Assertions.b(!z2, "HDR support not yet implemented.");
        return new QueuingGlShaderProgram(z2, 6, new ByteBufferConcurrentEffect(1, this.f42222a));
    }
}
