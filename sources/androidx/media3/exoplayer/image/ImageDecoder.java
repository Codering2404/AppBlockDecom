package androidx.media3.exoplayer.image;

import androidx.media3.common.Format;
import androidx.media3.decoder.Decoder;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.image.BitmapFactoryImageDecoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface ImageDecoder extends Decoder<DecoderInputBuffer, ImageOutputBuffer, ImageDecoderException> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Factory f44157a = new BitmapFactoryImageDecoder.Factory();

        int a(Format format);

        ImageDecoder b();
    }

    @Override // androidx.media3.decoder.Decoder
    ImageOutputBuffer a();

    @Override // androidx.media3.decoder.Decoder
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    void b(DecoderInputBuffer decoderInputBuffer);
}
