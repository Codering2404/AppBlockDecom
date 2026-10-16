package androidx.media3.transformer;

import android.media.MediaCodec;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.transformer.AssetLoader;
import androidx.media3.transformer.Codec;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ExoAssetLoaderAudioRenderer extends ExoAssetLoaderBaseRenderer {
    private final Codec.DecoderFactory E;
    private boolean F;

    public ExoAssetLoaderAudioRenderer(Codec.DecoderFactory decoderFactory, TransformerMediaClock transformerMediaClock, AssetLoader.Listener listener) {
        super(1, transformerMediaClock, listener);
        this.E = decoderFactory;
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    protected boolean D0(DecoderInputBuffer decoderInputBuffer) {
        if (decoderInputBuffer.i()) {
            return false;
        }
        long j3 = decoderInputBuffer.f42140g - this.f48141s;
        decoderInputBuffer.f42140g = j3;
        if (this.f48143u == null || j3 >= 0) {
            return false;
        }
        decoderInputBuffer.f();
        return true;
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public String getName() {
        return "ExoAssetLoaderAudioRenderer";
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    protected boolean t0() {
        DecoderInputBuffer decoderInputBufferF = this.f48142t.f();
        if (decoderInputBufferF == null) {
            return false;
        }
        if (!this.F) {
            if (this.f48143u.b()) {
                ((ByteBuffer) Assertions.e(decoderInputBufferF.f42138d)).limit(0);
                decoderInputBufferF.e(4);
                this.f48144v = this.f48142t.c();
                return false;
            }
            ByteBuffer byteBufferJ = this.f48143u.j();
            if (byteBufferJ == null) {
                return false;
            }
            decoderInputBufferF.p(byteBufferJ.limit());
            decoderInputBufferF.f42138d.put(byteBufferJ).flip();
            MediaCodec.BufferInfo bufferInfo = (MediaCodec.BufferInfo) Assertions.e(this.f48143u.g());
            decoderInputBufferF.f42140g = bufferInfo.presentationTimeUs;
            decoderInputBufferF.n(bufferInfo.flags);
            this.f48143u.h(false);
            this.F = true;
        }
        if (!this.f48142t.c()) {
            return false;
        }
        this.F = false;
        return true;
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    protected void w0(Format format) {
        this.f48143u = this.E.a(format);
    }
}
