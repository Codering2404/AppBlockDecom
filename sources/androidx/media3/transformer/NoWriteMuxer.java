package androidx.media3.transformer;

import android.media.MediaCodec;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.transformer.Muxer;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class NoWriteMuxer implements Muxer {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements Muxer.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableList f48337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ImmutableList f48338b;

        @Override // androidx.media3.transformer.Muxer.Factory
        public Muxer a(String str) {
            return new NoWriteMuxer();
        }

        @Override // androidx.media3.transformer.Muxer.Factory
        public ImmutableList b(int i3) {
            return i3 == 1 ? this.f48337a : i3 == 2 ? this.f48338b : ImmutableList.y();
        }
    }

    NoWriteMuxer() {
    }

    @Override // androidx.media3.transformer.Muxer
    public int c(Format format) {
        return 0;
    }

    @Override // androidx.media3.transformer.Muxer
    public void close() {
    }

    @Override // androidx.media3.transformer.Muxer
    public void a(Metadata.Entry entry) {
    }

    @Override // androidx.media3.transformer.Muxer
    public void b(int i3, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
    }
}
