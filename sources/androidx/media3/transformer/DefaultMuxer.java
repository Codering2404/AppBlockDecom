package androidx.media3.transformer;

import android.media.MediaCodec;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.transformer.FrameworkMuxer;
import androidx.media3.transformer.Muxer;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultMuxer implements Muxer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f48092b = FrameworkMuxer.f48248h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Muxer f48093a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements Muxer.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FrameworkMuxer.Factory f48094a = new FrameworkMuxer.Factory();

        @Override // androidx.media3.transformer.Muxer.Factory
        public Muxer a(String str) {
            return new DefaultMuxer(this.f48094a.a(str));
        }

        @Override // androidx.media3.transformer.Muxer.Factory
        public ImmutableList b(int i3) {
            return this.f48094a.b(i3);
        }
    }

    @Override // androidx.media3.transformer.Muxer
    public void a(Metadata.Entry entry) {
        this.f48093a.a(entry);
    }

    @Override // androidx.media3.transformer.Muxer
    public void b(int i3, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        this.f48093a.b(i3, byteBuffer, bufferInfo);
    }

    @Override // androidx.media3.transformer.Muxer
    public int c(Format format) {
        return this.f48093a.c(format);
    }

    @Override // androidx.media3.transformer.Muxer
    public void close() {
        this.f48093a.close();
    }

    private DefaultMuxer(Muxer muxer) {
        this.f48093a = muxer;
    }
}
