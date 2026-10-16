package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Option f66930d = Option.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new Option.CacheKeyUpdater<Long>() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f66937a = ByteBuffer.allocate(8);

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Long l3, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f66937a) {
                this.f66937a.position(0);
                messageDigest.update(this.f66937a.putLong(l3.longValue()).array());
            }
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Option f66931e = Option.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new Option.CacheKeyUpdater<Integer>() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.2

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f66938a = ByteBuffer.allocate(4);

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f66938a) {
                this.f66938a.position(0);
                messageDigest.update(this.f66938a.putInt(num.intValue()).array());
            }
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final MediaMetadataRetrieverFactory f66932f = new MediaMetadataRetrieverFactory();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final List f66933g = Collections.unmodifiableList(Arrays.asList("TP1A", "TD1A.220804.031"));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaInitializer f66934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BitmapPool f66935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MediaMetadataRetrieverFactory f66936c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AssetFileDescriptorInitializer implements MediaInitializer<AssetFileDescriptor> {
        private AssetFileDescriptorInitializer() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(MediaExtractor mediaExtractor, AssetFileDescriptor assetFileDescriptor) throws IOException {
            mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ByteBufferInitializer implements MediaInitializer<ByteBuffer> {
        ByteBufferInitializer() {
        }

        private MediaDataSource c(final ByteBuffer byteBuffer) {
            return new MediaDataSource() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.ByteBufferInitializer.1
                @Override // android.media.MediaDataSource
                public long getSize() {
                    return byteBuffer.limit();
                }

                @Override // android.media.MediaDataSource
                public int readAt(long j3, byte[] bArr, int i3, int i4) {
                    if (j3 >= byteBuffer.limit()) {
                        return -1;
                    }
                    byteBuffer.position((int) j3);
                    int iMin = Math.min(i4, byteBuffer.remaining());
                    byteBuffer.get(bArr, i3, iMin);
                    return iMin;
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(MediaExtractor mediaExtractor, ByteBuffer byteBuffer) throws IOException {
            mediaExtractor.setDataSource(c(byteBuffer));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(c(byteBuffer));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface MediaInitializer<T> {
        void a(MediaExtractor mediaExtractor, Object obj);

        void b(MediaMetadataRetriever mediaMetadataRetriever, Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MediaMetadataRetrieverFactory {
        MediaMetadataRetrieverFactory() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ParcelFileDescriptorInitializer implements MediaInitializer<ParcelFileDescriptor> {
        ParcelFileDescriptorInitializer() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(MediaExtractor mediaExtractor, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
            mediaExtractor.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class VideoDecoderException extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    VideoDecoder(BitmapPool bitmapPool, MediaInitializer mediaInitializer) {
        this(bitmapPool, mediaInitializer, f66932f);
    }

    public static ResourceDecoder c(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new AssetFileDescriptorInitializer());
    }

    public static ResourceDecoder d(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new ByteBufferInitializer());
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, Bitmap bitmap) {
        if (j()) {
            try {
                if (i(mediaMetadataRetriever)) {
                    if (Math.abs(Integer.parseInt(mediaMetadataRetriever.extractMetadata(24))) != 180) {
                        return bitmap;
                    }
                    if (Log.isLoggable("VideoDecoder", 3)) {
                        Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
                    }
                    Matrix matrix = new Matrix();
                    matrix.postRotate(180.0f, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
                    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                }
            } catch (NumberFormatException unused) {
                if (!Log.isLoggable("VideoDecoder", 3)) {
                    return bitmap;
                }
                Log.d("VideoDecoder", "Exception trying to extract HDR transfer function or rotation");
                return bitmap;
            }
        }
        return bitmap;
    }

    private Bitmap f(Object obj, MediaMetadataRetriever mediaMetadataRetriever, long j3, int i3, int i4, int i5, DownsampleStrategy downsampleStrategy) {
        if (l(obj, mediaMetadataRetriever)) {
            throw new IllegalStateException("Cannot decode VP8 video on CrOS.");
        }
        Bitmap bitmapH = (i4 == Integer.MIN_VALUE || i5 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f66844f) ? null : h(mediaMetadataRetriever, j3, i3, i4, i5, downsampleStrategy);
        if (bitmapH == null) {
            bitmapH = g(mediaMetadataRetriever, j3, i3);
        }
        Bitmap bitmapE = e(mediaMetadataRetriever, bitmapH);
        if (bitmapE != null) {
            return bitmapE;
        }
        throw new VideoDecoderException();
    }

    private static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j3, int i3) {
        return mediaMetadataRetriever.getFrameAtTime(j3, i3);
    }

    private static Bitmap h(MediaMetadataRetriever mediaMetadataRetriever, long j3, int i3, int i4, int i5, DownsampleStrategy downsampleStrategy) {
        try {
            int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i7 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i8 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i8 == 90 || i8 == 270) {
                i7 = i6;
                i6 = i7;
            }
            float fB = downsampleStrategy.b(i6, i7, i4, i5);
            return mediaMetadataRetriever.getScaledFrameAtTime(j3, i3, Math.round(i6 * fB), Math.round(fB * i7));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
            return null;
        }
    }

    private static boolean i(MediaMetadataRetriever mediaMetadataRetriever) {
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(36);
        String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(35);
        int i3 = Integer.parseInt(strExtractMetadata);
        return (i3 == 7 || i3 == 6) && Integer.parseInt(strExtractMetadata2) == 6;
    }

    static boolean j() {
        if (Build.MODEL.startsWith("Pixel") && Build.VERSION.SDK_INT == 33) {
            return k();
        }
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= 30 && i3 < 33;
    }

    private static boolean k() {
        Iterator it = f66933g.iterator();
        while (it.hasNext()) {
            if (Build.ID.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059 A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #2 {all -> 0x005f, blocks: (B:23:0x0053, B:25:0x0059), top: B:40:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean l(java.lang.Object r6, android.media.MediaMetadataRetriever r7) {
        /*
            r5 = this;
            java.lang.String r0 = "VideoDecoder"
            java.lang.String r1 = android.os.Build.DEVICE
            r2 = 0
            if (r1 == 0) goto L6d
            java.lang.String r3 = ".+_cheets|cheets_.+"
            boolean r1 = r1.matches(r3)
            if (r1 == 0) goto L6d
            r1 = 12
            r3 = 0
            java.lang.String r7 = r7.extractMetadata(r1)     // Catch: java.lang.Throwable -> L51
            java.lang.String r1 = "video/webm"
            boolean r7 = r1.equals(r7)     // Catch: java.lang.Throwable -> L51
            if (r7 != 0) goto L1f
            return r2
        L1f:
            android.media.MediaExtractor r7 = new android.media.MediaExtractor     // Catch: java.lang.Throwable -> L51
            r7.<init>()     // Catch: java.lang.Throwable -> L51
            com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaInitializer r1 = r5.f66934a     // Catch: java.lang.Throwable -> L4a
            r1.a(r7, r6)     // Catch: java.lang.Throwable -> L4a
            int r6 = r7.getTrackCount()     // Catch: java.lang.Throwable -> L4a
            r1 = r2
        L2e:
            if (r1 >= r6) goto L4d
            android.media.MediaFormat r3 = r7.getTrackFormat(r1)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r4 = "mime"
            java.lang.String r3 = r3.getString(r4)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r4 = "video/x-vnd.on2.vp8"
            boolean r3 = r4.equals(r3)     // Catch: java.lang.Throwable -> L4a
            if (r3 == 0) goto L47
            r7.release()
            r6 = 1
            return r6
        L47:
            int r1 = r1 + 1
            goto L2e
        L4a:
            r6 = move-exception
            r3 = r7
            goto L52
        L4d:
            r7.release()
            goto L66
        L51:
            r6 = move-exception
        L52:
            r7 = 3
            boolean r7 = android.util.Log.isLoggable(r0, r7)     // Catch: java.lang.Throwable -> L5f
            if (r7 == 0) goto L61
            java.lang.String r7 = "Exception trying to extract track info for a webm video on CrOS."
            android.util.Log.d(r0, r7, r6)     // Catch: java.lang.Throwable -> L5f
            goto L61
        L5f:
            r6 = move-exception
            goto L67
        L61:
            if (r3 == 0) goto L66
            r3.release()
        L66:
            return r2
        L67:
            if (r3 == 0) goto L6c
            r3.release()
        L6c:
            throw r6
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.VideoDecoder.l(java.lang.Object, android.media.MediaMetadataRetriever):boolean");
    }

    public static ResourceDecoder m(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new ParcelFileDescriptorInitializer());
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean a(Object obj, Options options) {
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource b(Object obj, int i3, int i4, Options options) throws Exception {
        long jLongValue = ((Long) options.c(f66930d)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) options.c(f66931e);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.c(DownsampleStrategy.f66846h);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.f66845g;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever mediaMetadataRetrieverA = this.f66936c.a();
        try {
            this.f66934a.b(mediaMetadataRetrieverA, obj);
            try {
                Bitmap bitmapF = f(obj, mediaMetadataRetrieverA, jLongValue, num.intValue(), i3, i4, downsampleStrategy2);
                if (Build.VERSION.SDK_INT >= 29) {
                    f.a.a(mediaMetadataRetrieverA);
                } else {
                    mediaMetadataRetrieverA.release();
                }
                return BitmapResource.d(bitmapF, this.f66935b);
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                if (Build.VERSION.SDK_INT >= 29) {
                    f.a.a(mediaMetadataRetrieverA);
                    throw th2;
                }
                mediaMetadataRetrieverA.release();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    VideoDecoder(BitmapPool bitmapPool, MediaInitializer mediaInitializer, MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory) {
        this.f66935b = bitmapPool;
        this.f66934a = mediaInitializer;
        this.f66936c = mediaMetadataRetrieverFactory;
    }
}
