package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.image.ImageDecoder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ExternallyLoadedImageDecoder implements ImageDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BitmapResolver f44148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DecoderInputBuffer f44149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImageOutputBuffer f44150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ListenableFuture f44151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f44152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f44153f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface BitmapResolver {
        ListenableFuture a(ExternalImageRequest externalImageRequest);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ExternalImageRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f44155a;

        public ExternalImageRequest(Uri uri) {
            this.f44155a = uri;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements ImageDecoder.Factory {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BitmapResolver f44156b;

        @Override // androidx.media3.exoplayer.image.ImageDecoder.Factory
        public int a(Format format) {
            return RendererCapabilities.u(Objects.equals(format.f40632o, "application/x-image-uri") ? 4 : MimeTypes.o(format.f40632o) ? 1 : 0);
        }

        @Override // androidx.media3.exoplayer.image.ImageDecoder.Factory
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public ExternallyLoadedImageDecoder b() {
            return new ExternallyLoadedImageDecoder(this.f44156b);
        }
    }

    private void h() {
        ListenableFuture listenableFuture = this.f44151d;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
            this.f44151d = null;
        }
        this.f44153f = false;
        this.f44150c.o();
    }

    @Override // androidx.media3.exoplayer.image.ImageDecoder, androidx.media3.decoder.Decoder
    /* JADX INFO: renamed from: d */
    public void b(DecoderInputBuffer decoderInputBuffer) {
        if (decoderInputBuffer.i()) {
            this.f44153f = true;
            decoderInputBuffer.f();
            return;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.e(decoderInputBuffer.f42138d);
        Assertions.g(byteBuffer.hasArray());
        this.f44151d = this.f44148a.a(new ExternalImageRequest(Uri.parse(new String(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.remaining(), StandardCharsets.UTF_8))));
        this.f44152e = decoderInputBuffer.f42140g;
        decoderInputBuffer.f();
    }

    @Override // androidx.media3.decoder.Decoder
    public void flush() {
        h();
    }

    @Override // androidx.media3.decoder.Decoder
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public DecoderInputBuffer f() {
        if (this.f44151d == null) {
            return this.f44149b;
        }
        return null;
    }

    @Override // androidx.media3.decoder.Decoder
    public String getName() {
        return "externallyLoadedImageDecoder";
    }

    @Override // androidx.media3.decoder.Decoder
    public void release() {
        h();
    }

    private ExternallyLoadedImageDecoder(BitmapResolver bitmapResolver) {
        this.f44148a = bitmapResolver;
        this.f44149b = new DecoderInputBuffer(1);
        this.f44150c = new ImageOutputBuffer() { // from class: androidx.media3.exoplayer.image.ExternallyLoadedImageDecoder.1
            @Override // androidx.media3.decoder.DecoderOutputBuffer
            public void o() {
                f();
            }
        };
    }

    @Override // androidx.media3.exoplayer.image.ImageDecoder, androidx.media3.decoder.Decoder
    public ImageOutputBuffer a() {
        if (this.f44153f) {
            this.f44150c.e(4);
            this.f44153f = false;
            return this.f44150c;
        }
        ListenableFuture listenableFuture = this.f44151d;
        if (listenableFuture != null) {
            try {
                if (listenableFuture.isDone()) {
                    try {
                        this.f44150c.f44159f = (Bitmap) Futures.c(this.f44151d);
                        ImageOutputBuffer imageOutputBuffer = this.f44150c;
                        imageOutputBuffer.f42146b = this.f44152e;
                        return imageOutputBuffer;
                    } catch (CancellationException e3) {
                        throw new ImageDecoderException(e3);
                    } catch (ExecutionException e4) {
                        throw new ImageDecoderException(e4.getCause());
                    }
                }
            } finally {
                this.f44151d = null;
            }
        }
        return null;
    }

    @Override // androidx.media3.decoder.Decoder
    public void e(long j3) {
    }
}
