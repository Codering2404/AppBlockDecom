package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final GifDecoderFactory f66957f = new GifDecoderFactory();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final GifHeaderParserPool f66958g = new GifHeaderParserPool();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f66959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f66960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GifHeaderParserPool f66961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final GifDecoderFactory f66962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final GifBitmapProvider f66963e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class GifDecoderFactory {
        GifDecoderFactory() {
        }

        GifDecoder a(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i3) {
            return new StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class GifHeaderParserPool {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue f66964a = Util.g(0);

        GifHeaderParserPool() {
        }

        synchronized GifHeaderParser a(ByteBuffer byteBuffer) {
            GifHeaderParser gifHeaderParser;
            try {
                gifHeaderParser = (GifHeaderParser) this.f66964a.poll();
                if (gifHeaderParser == null) {
                    gifHeaderParser = new GifHeaderParser();
                }
            } catch (Throwable th) {
                throw th;
            }
            return gifHeaderParser.p(byteBuffer);
        }

        synchronized void b(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.a();
            this.f66964a.offer(gifHeaderParser);
        }
    }

    public ByteBufferGifDecoder(Context context, List list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, f66958g, f66957f);
    }

    private GifDrawableResource c(ByteBuffer byteBuffer, int i3, int i4, GifHeaderParser gifHeaderParser, Options options) {
        StringBuilder sb;
        long jB = LogTime.b();
        try {
            GifHeader gifHeaderC = gifHeaderParser.c();
            if (gifHeaderC.b() > 0 && gifHeaderC.c() == 0) {
                Bitmap.Config config = options.c(GifOptions.f67005a) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                GifDecoder gifDecoderA = this.f66962d.a(this.f66963e, gifHeaderC, byteBuffer, e(gifHeaderC, i3, i4));
                gifDecoderA.d(config);
                gifDecoderA.b();
                Bitmap bitmapA = gifDecoderA.a();
                if (bitmapA == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        sb = new StringBuilder();
                    }
                    return null;
                }
                GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.f66959a, gifDecoderA, UnitTransformation.c(), i3, i4, bitmapA));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.a(jB));
                }
                return gifDrawableResource;
            }
            if (!Log.isLoggable("BufferGifDecoder", 2)) {
                return null;
            }
            sb = new StringBuilder();
            sb.append("Decoded GIF from stream in ");
            sb.append(LogTime.a(jB));
            Log.v("BufferGifDecoder", sb.toString());
            return null;
        } catch (Throwable th) {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.a(jB));
            }
            throw th;
        }
    }

    private static int e(GifHeader gifHeader, int i3, int i4) {
        int iMin = Math.min(gifHeader.a() / i4, gifHeader.d() / i3);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i3 + "x" + i4 + "], actual dimens: [" + gifHeader.d() + "x" + gifHeader.a() + "]");
        }
        return iMax;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public GifDrawableResource b(ByteBuffer byteBuffer, int i3, int i4, Options options) {
        GifHeaderParser gifHeaderParserA = this.f66961c.a(byteBuffer);
        try {
            return c(byteBuffer, i3, i4, gifHeaderParserA, options);
        } finally {
            this.f66961c.b(gifHeaderParserA);
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(ByteBuffer byteBuffer, Options options) {
        return !((Boolean) options.c(GifOptions.f67006b)).booleanValue() && ImageHeaderParserUtils.g(this.f66960b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    ByteBufferGifDecoder(Context context, List list, BitmapPool bitmapPool, ArrayPool arrayPool, GifHeaderParserPool gifHeaderParserPool, GifDecoderFactory gifDecoderFactory) {
        this.f66959a = context.getApplicationContext();
        this.f66960b = list;
        this.f66962d = gifDecoderFactory;
        this.f66963e = new GifBitmapProvider(bitmapPool, arrayPool);
        this.f66961c = gifHeaderParserPool;
    }
}
