package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.BitmapUtil;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.image.ImageDecoder;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class BitmapFactoryImageDecoder extends SimpleDecoder<DecoderInputBuffer, ImageOutputBuffer, ImageDecoderException> implements ImageDecoder {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final BitmapDecoder f44145o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface BitmapDecoder {
        Bitmap a(byte[] bArr, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements ImageDecoder.Factory {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BitmapDecoder f44147b = new BitmapDecoder() { // from class: androidx.media3.exoplayer.image.a
            @Override // androidx.media3.exoplayer.image.BitmapFactoryImageDecoder.BitmapDecoder
            public final Bitmap a(byte[] bArr, int i3) {
                return BitmapFactoryImageDecoder.B(bArr, i3);
            }
        };

        @Override // androidx.media3.exoplayer.image.ImageDecoder.Factory
        public int a(Format format) {
            String str = format.f40632o;
            return (str == null || !MimeTypes.o(str)) ? RendererCapabilities.u(0) : Util.A0(format.f40632o) ? RendererCapabilities.u(4) : RendererCapabilities.u(1);
        }

        @Override // androidx.media3.exoplayer.image.ImageDecoder.Factory
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public BitmapFactoryImageDecoder b() {
            return new BitmapFactoryImageDecoder(this.f44147b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap B(byte[] bArr, int i3) throws ImageDecoderException {
        try {
            return BitmapUtil.a(bArr, i3, null, -1);
        } catch (ParserException e3) {
            throw new ImageDecoderException("Could not decode image data with BitmapFactory. (data.length = " + bArr.length + ", input length = " + i3 + ")", e3);
        } catch (IOException e4) {
            throw new ImageDecoderException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public ImageDecoderException k(Throwable th) {
        return new ImageDecoderException("Unexpected decode error", th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public ImageDecoderException l(DecoderInputBuffer decoderInputBuffer, ImageOutputBuffer imageOutputBuffer, boolean z2) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.e(decoderInputBuffer.f42138d);
            Assertions.g(byteBuffer.hasArray());
            Assertions.a(byteBuffer.arrayOffset() == 0);
            imageOutputBuffer.f44159f = this.f44145o.a(byteBuffer.array(), byteBuffer.remaining());
            imageOutputBuffer.f42146b = decoderInputBuffer.f42140g;
            return null;
        } catch (ImageDecoderException e3) {
            return e3;
        }
    }

    @Override // androidx.media3.decoder.SimpleDecoder, androidx.media3.decoder.Decoder
    public /* bridge */ /* synthetic */ ImageOutputBuffer a() {
        return (ImageOutputBuffer) super.a();
    }

    @Override // androidx.media3.decoder.Decoder
    public String getName() {
        return "BitmapFactoryImageDecoder";
    }

    @Override // androidx.media3.decoder.SimpleDecoder
    protected DecoderInputBuffer i() {
        return new DecoderInputBuffer(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.decoder.SimpleDecoder
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public ImageOutputBuffer j() {
        return new ImageOutputBuffer() { // from class: androidx.media3.exoplayer.image.BitmapFactoryImageDecoder.1
            @Override // androidx.media3.decoder.DecoderOutputBuffer
            public void o() {
                BitmapFactoryImageDecoder.this.t(this);
            }
        };
    }

    private BitmapFactoryImageDecoder(BitmapDecoder bitmapDecoder) {
        super(new DecoderInputBuffer[1], new ImageOutputBuffer[1]);
        this.f44145o = bitmapDecoder;
    }
}
