package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.ExceptionPassthroughInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Downsampler f66915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayPool f66916b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class UntrustedCallbacks implements Downsampler.DecodeCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RecyclableBufferedInputStream f66917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ExceptionPassthroughInputStream f66918b;

        UntrustedCallbacks(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionPassthroughInputStream exceptionPassthroughInputStream) {
            this.f66917a = recyclableBufferedInputStream;
            this.f66918b = exceptionPassthroughInputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void a(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
            IOException iOExceptionA = this.f66918b.a();
            if (iOExceptionA != null) {
                if (bitmap == null) {
                    throw iOExceptionA;
                }
                bitmapPool.c(bitmap);
                throw iOExceptionA;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void b() {
            this.f66917a.b();
        }
    }

    public StreamBitmapDecoder(Downsampler downsampler, ArrayPool arrayPool) {
        this.f66915a = downsampler;
        this.f66916b = arrayPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Resource b(InputStream inputStream, int i3, int i4, Options options) {
        boolean z2;
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z2 = false;
        } else {
            z2 = true;
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f66916b);
        }
        ExceptionPassthroughInputStream exceptionPassthroughInputStreamB = ExceptionPassthroughInputStream.b(recyclableBufferedInputStream);
        try {
            Resource resourceF = this.f66915a.f(new MarkEnforcingInputStream(exceptionPassthroughInputStreamB), i3, i4, options, new UntrustedCallbacks(recyclableBufferedInputStream, exceptionPassthroughInputStreamB));
            exceptionPassthroughInputStreamB.c();
            if (z2) {
                recyclableBufferedInputStream.c();
            }
            return resourceF;
        } finally {
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, Options options) {
        return this.f66915a.p(inputStream);
    }
}
