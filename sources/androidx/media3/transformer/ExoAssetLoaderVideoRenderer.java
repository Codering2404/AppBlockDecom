package androidx.media3.transformer;

import android.media.MediaCodec;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.transformer.AssetLoader;
import androidx.media3.transformer.Codec;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ExoAssetLoaderVideoRenderer extends ExoAssetLoaderBaseRenderer {
    private final boolean E;
    private final Codec.DecoderFactory F;
    private final int G;
    private final List H;
    private SefSlowMotionFlattener I;
    private int J;

    public ExoAssetLoaderVideoRenderer(boolean z2, Codec.DecoderFactory decoderFactory, int i3, TransformerMediaClock transformerMediaClock, AssetLoader.Listener listener) {
        super(2, transformerMediaClock, listener);
        this.E = z2;
        this.F = decoderFactory;
        this.G = i3;
        this.H = new ArrayList();
        this.J = -1;
    }

    private boolean E0(long j3) {
        int size = this.H.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((Long) this.H.get(i3)).longValue() == j3) {
                this.H.remove(i3);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    protected Format A0(Format format) {
        return format.b().T(TransformerUtil.c(TransformerUtil.h(format.C), this.G == 1)).N();
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    protected boolean D0(DecoderInputBuffer decoderInputBuffer) {
        if (decoderInputBuffer.i()) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.e(decoderInputBuffer.f42138d);
        if (this.I != null) {
            long jB0 = b0();
            if (this.I.a(byteBuffer, decoderInputBuffer.f42140g - jB0)) {
                byteBuffer.clear();
                return true;
            }
            decoderInputBuffer.f42140g = jB0 + this.I.e();
        }
        if (this.f48143u == null) {
            decoderInputBuffer.f42140g -= this.f48141s;
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public long E(long j3, long j4) {
        int i3 = this.J;
        if (i3 == -1) {
            return 10000L;
        }
        return ((long) i3) * 2000;
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public String getName() {
        return "ExoAssetLoaderVideoRenderer";
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    protected boolean t0() {
        if (this.f48143u.b()) {
            this.f48142t.h();
            this.f48144v = true;
            return false;
        }
        MediaCodec.BufferInfo bufferInfoG = this.f48143u.g();
        if (bufferInfoG == null) {
            return false;
        }
        long j3 = bufferInfoG.presentationTimeUs;
        long j4 = j3 - this.f48141s;
        if (j4 < 0 || E0(j3)) {
            this.f48143u.h(false);
            return true;
        }
        if (this.f48142t.d() == this.J || !this.f48142t.i(j4)) {
            return false;
        }
        this.f48143u.f(j4);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void w0(androidx.media3.common.Format r4) {
        /*
            r3 = this;
            androidx.media3.transformer.SampleConsumer r0 = r3.f48142t
            androidx.media3.common.util.Assertions.i(r0)
            androidx.media3.common.ColorInfo r0 = r4.C
            boolean r0 = androidx.media3.common.ColorInfo.l(r0)
            if (r0 == 0) goto L13
            int r0 = r3.G
            r1 = 1
            if (r0 != r1) goto L13
            goto L14
        L13:
            r1 = 0
        L14:
            androidx.media3.transformer.Codec$DecoderFactory r0 = r3.F
            androidx.media3.transformer.SampleConsumer r2 = r3.f48142t
            android.view.Surface r2 = r2.a()
            java.lang.Object r2 = androidx.media3.common.util.Assertions.e(r2)
            android.view.Surface r2 = (android.view.Surface) r2
            androidx.media3.transformer.Codec r4 = r0.b(r4, r2, r1)
            r3.f48143u = r4
            int r4 = r4.k()
            r3.J = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.transformer.ExoAssetLoaderVideoRenderer.w0(androidx.media3.common.Format):void");
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    protected void x0(DecoderInputBuffer decoderInputBuffer) {
        if (decoderInputBuffer.f42140g < Y()) {
            this.H.add(Long.valueOf(decoderInputBuffer.f42140g));
        }
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    protected void y0(Format format) {
        if (this.E) {
            this.I = new SefSlowMotionFlattener(format);
        }
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    protected Format z0(Format format) {
        return (this.G == 3 && ColorInfo.l(format.C)) ? format.b().T(ColorInfo.f40546h).N() : format;
    }
}
