package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.facebook.internal.NativeProtocol;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Downsampler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Option f66851f = Option.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.f66228c);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Option f66852g = Option.e("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Option f66853h = DownsampleStrategy.f66846h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Option f66854i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Option f66855j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Set f66856k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final DecodeCallbacks f66857l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Set f66858m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Queue f66859n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BitmapPool f66860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DisplayMetrics f66861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayPool f66862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f66863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HardwareConfigState f66864e = HardwareConfigState.b();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface DecodeCallbacks {
        void a(BitmapPool bitmapPool, Bitmap bitmap);

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f66854i = Option.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f66855j = Option.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f66856k = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f66857l = new DecodeCallbacks() { // from class: com.bumptech.glide.load.resource.bitmap.Downsampler.1
            @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
            public void b() {
            }

            @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
            public void a(BitmapPool bitmapPool, Bitmap bitmap) {
            }
        };
        f66858m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f66859n = Util.g(0);
    }

    public Downsampler(List list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f66863d = list;
        this.f66861b = (DisplayMetrics) Preconditions.e(displayMetrics);
        this.f66860a = (BitmapPool) Preconditions.e(bitmapPool);
        this.f66862c = (ArrayPool) Preconditions.e(arrayPool);
    }

    private static int a(double d3) {
        int iL = l(d3);
        int iX = x(((double) iL) * d3);
        return x((d3 / ((double) (iX / iL))) * ((double) iX));
    }

    private void b(ImageReader imageReader, DecodeFormat decodeFormat, boolean z2, boolean z3, BitmapFactory.Options options, int i3, int i4) {
        boolean zHasAlpha;
        if (this.f66864e.g(i3, i4, options, z2, z3)) {
            return;
        }
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            zHasAlpha = imageReader.e().hasAlpha();
        } catch (IOException e3) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e3);
            }
            zHasAlpha = false;
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private static void c(ImageHeaderParser.ImageType imageType, ImageReader imageReader, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i3, int i4, int i5, int i6, int i7, BitmapFactory.Options options) {
        int i8;
        int i9;
        int i10;
        int iFloor;
        int iFloor2;
        if (i4 <= 0 || i5 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i6 + "x" + i7 + "]");
                return;
            }
            return;
        }
        if (r(i3)) {
            i9 = i4;
            i8 = i5;
        } else {
            i8 = i4;
            i9 = i5;
        }
        float fB = downsampleStrategy.b(i8, i9, i6, i7);
        if (fB <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + downsampleStrategy + ", source: [" + i4 + "x" + i5 + "], target: [" + i6 + "x" + i7 + "]");
        }
        DownsampleStrategy.SampleSizeRounding sampleSizeRoundingA = downsampleStrategy.a(i8, i9, i6, i7);
        if (sampleSizeRoundingA == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f3 = i8;
        float f4 = i9;
        int i11 = i8;
        int i12 = i9;
        int iX = i11 / x(fB * f3);
        int iX2 = i12 / x(fB * f4);
        DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
        int iMax = Math.max(1, Integer.highestOneBit(sampleSizeRoundingA == sampleSizeRounding ? Math.max(iX, iX2) : Math.min(iX, iX2)));
        if (sampleSizeRoundingA == sampleSizeRounding && iMax < 1.0f / fB) {
            iMax <<= 1;
        }
        options.inSampleSize = iMax;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(iMax, 8);
            i10 = 0;
            iFloor = (int) Math.ceil(f3 / fMin);
            iFloor2 = (int) Math.ceil(f4 / fMin);
            int i13 = iMax / 8;
            if (i13 > 0) {
                iFloor /= i13;
                iFloor2 /= i13;
            }
        } else {
            i10 = 0;
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f5 = iMax;
                iFloor = (int) Math.floor(f3 / f5);
                iFloor2 = (int) Math.floor(f4 / f5);
            } else if (imageType.isWebp()) {
                float f6 = iMax;
                iFloor = Math.round(f3 / f6);
                iFloor2 = Math.round(f4 / f6);
            } else if (i11 % iMax == 0 && i12 % iMax == 0) {
                iFloor = i11 / iMax;
                iFloor2 = i12 / iMax;
            } else {
                int[] iArrM = m(imageReader, options, decodeCallbacks, bitmapPool);
                iFloor = iArrM[0];
                iFloor2 = iArrM[1];
            }
        }
        double dB = downsampleStrategy.b(iFloor, iFloor2, i6, i7);
        options.inTargetDensity = a(dB);
        options.inDensity = l(dB);
        if (s(options)) {
            options.inScaled = true;
        } else {
            int i14 = i10;
            options.inTargetDensity = i14;
            options.inDensity = i14;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i4 + "x" + i5 + "], degreesToRotate: " + i3 + ", target: [" + i6 + "x" + i7 + "], power of two scaled: [" + iFloor + "x" + iFloor2 + "], exact scale factor: " + fB + ", power of 2 sample size: " + iMax + ", adjusted scale factor: " + dB + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private Resource e(ImageReader imageReader, int i3, int i4, Options options, DecodeCallbacks decodeCallbacks) {
        byte[] bArr = (byte[]) this.f66862c.c(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, byte[].class);
        BitmapFactory.Options optionsK = k();
        optionsK.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options.c(f66851f);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.c(f66852g);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.c(DownsampleStrategy.f66846h);
        boolean zBooleanValue = ((Boolean) options.c(f66854i)).booleanValue();
        Option option = f66855j;
        try {
            return BitmapResource.d(h(imageReader, optionsK, downsampleStrategy, decodeFormat, preferredColorSpace, options.c(option) != null && ((Boolean) options.c(option)).booleanValue(), i3, i4, zBooleanValue, decodeCallbacks), this.f66860a);
        } finally {
            v(optionsK);
            this.f66862c.put(bArr);
        }
    }

    private Bitmap h(ImageReader imageReader, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z2, int i3, int i4, boolean z3, DecodeCallbacks decodeCallbacks) {
        int i5;
        String str;
        ColorSpace colorSpace;
        int iRound;
        int i6;
        long jB = LogTime.b();
        int[] iArrM = m(imageReader, options, decodeCallbacks, this.f66860a);
        int i7 = iArrM[0];
        int i8 = iArrM[1];
        String str2 = options.outMimeType;
        boolean z4 = (i7 == -1 || i8 == -1) ? false : z2;
        int iD = imageReader.d();
        int iJ = TransformationUtils.j(iD);
        boolean zM = TransformationUtils.m(iD);
        int i9 = i3;
        if (i9 != Integer.MIN_VALUE) {
            i5 = i4;
        } else if (r(iJ)) {
            i5 = i4;
            i9 = i8;
        } else {
            i5 = i4;
            i9 = i7;
        }
        if (i5 == Integer.MIN_VALUE) {
            i5 = r(iJ) ? i7 : i8;
        }
        ImageHeaderParser.ImageType imageTypeE = imageReader.e();
        c(imageTypeE, imageReader, decodeCallbacks, this.f66860a, downsampleStrategy, iJ, i7, i8, i9, i5, options);
        int i10 = i9;
        int i11 = i5;
        b(imageReader, decodeFormat, z4, zM, options, i10, i11);
        if (z(imageTypeE)) {
            if (i7 < 0 || i8 < 0 || !z3) {
                float f3 = s(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i12 = options.inSampleSize;
                float f4 = i7;
                float f5 = i12;
                int iCeil = (int) Math.ceil(f4 / f5);
                int iCeil2 = (int) Math.ceil(i8 / f5);
                int iRound2 = Math.round(iCeil * f3);
                iRound = Math.round(iCeil2 * f3);
                str = "Downsampler";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Calculated target [");
                    sb.append(iRound2);
                    sb.append("x");
                    sb.append(iRound);
                    i6 = iRound2;
                    sb.append("] for source [");
                    sb.append(i7);
                    sb.append("x");
                    sb.append(i8);
                    sb.append("], sampleSize: ");
                    sb.append(i12);
                    sb.append(", targetDensity: ");
                    sb.append(options.inTargetDensity);
                    sb.append(", density: ");
                    sb.append(options.inDensity);
                    sb.append(", density multiplier: ");
                    sb.append(f3);
                    Log.v(str, sb.toString());
                } else {
                    i6 = iRound2;
                }
                i10 = i6;
            } else {
                str = "Downsampler";
                iRound = i11;
            }
            if (i10 > 0 && iRound > 0) {
                y(options, this.f66860a, i10, iRound);
            }
        } else {
            str = "Downsampler";
        }
        if (preferredColorSpace != null) {
            options.inPreferredColorSpace = ColorSpace.get((preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        }
        Bitmap bitmapI = i(imageReader, options, decodeCallbacks, this.f66860a);
        decodeCallbacks.a(this.f66860a, bitmapI);
        if (Log.isLoggable(str, 2)) {
            t(i7, i8, str2, options, bitmapI, i3, i4, jB);
        }
        if (bitmapI == null) {
            return null;
        }
        bitmapI.setDensity(this.f66861b.densityDpi);
        Bitmap bitmapO = TransformationUtils.o(this.f66860a, bitmapI, iD);
        if (!bitmapI.equals(bitmapO)) {
            this.f66860a.c(bitmapI);
        }
        return bitmapO;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap i(com.bumptech.glide.load.resource.bitmap.ImageReader r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r7, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r8) {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto Lc
            r7.b()
            r5.c()
        Lc:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.i()
            r4.lock()
            android.graphics.Bitmap r5 = r5.a(r6)     // Catch: java.lang.IllegalArgumentException -> L25 java.lang.Throwable -> L47
        L1d:
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.i()
            r6.unlock()
            return r5
        L25:
            r4 = move-exception
            java.io.IOException r1 = u(r4, r1, r2, r3, r6)     // Catch: java.lang.Throwable -> L47
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L36
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch: java.lang.Throwable -> L47
        L36:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L46
            r8.c(r0)     // Catch: java.io.IOException -> L45 java.lang.Throwable -> L47
            r0 = 0
            r6.inBitmap = r0     // Catch: java.io.IOException -> L45 java.lang.Throwable -> L47
            android.graphics.Bitmap r5 = i(r5, r6, r7, r8)     // Catch: java.io.IOException -> L45 java.lang.Throwable -> L47
            goto L1d
        L45:
            throw r1     // Catch: java.lang.Throwable -> L47
        L46:
            throw r1     // Catch: java.lang.Throwable -> L47
        L47:
            r5 = move-exception
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.i()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.i(com.bumptech.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    private static String j(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options options;
        Queue queue = f66859n;
        synchronized (queue) {
            options = (BitmapFactory.Options) queue.poll();
        }
        if (options == null) {
            options = new BitmapFactory.Options();
            w(options);
        }
        return options;
    }

    private static int l(double d3) {
        if (d3 > 1.0d) {
            d3 = 1.0d / d3;
        }
        return (int) Math.round(d3 * 2.147483647E9d);
    }

    private static int[] m(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) {
        options.inJustDecodeBounds = true;
        i(imageReader, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    private static boolean r(int i3) {
        return i3 == 90 || i3 == 270;
    }

    private static boolean s(BitmapFactory.Options options) {
        int i3;
        int i4 = options.inTargetDensity;
        return i4 > 0 && (i3 = options.inDensity) > 0 && i4 != i3;
    }

    private static void t(int i3, int i4, String str, BitmapFactory.Options options, Bitmap bitmap, int i5, int i6, long j3) {
        Log.v("Downsampler", "Decoded " + j(bitmap) + " from [" + i3 + "x" + i4 + "] " + str + " with inBitmap " + n(options) + " for [" + i5 + "x" + i6 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.a(j3));
    }

    private static IOException u(IllegalArgumentException illegalArgumentException, int i3, int i4, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i3 + ", outHeight: " + i4 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    private static void v(BitmapFactory.Options options) {
        w(options);
        Queue queue = f66859n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.inPreferredColorSpace = null;
        options.outColorSpace = null;
        options.outConfig = null;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int x(double d3) {
        return (int) (d3 + 0.5d);
    }

    private static void y(BitmapFactory.Options options, BitmapPool bitmapPool, int i3, int i4) {
        Bitmap.Config config = options.inPreferredConfig;
        if (config == Bitmap.Config.HARDWARE) {
            return;
        }
        Bitmap.Config config2 = options.outConfig;
        if (config2 != null) {
            config = config2;
        }
        options.inBitmap = bitmapPool.e(i3, i4, config);
    }

    private boolean z(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public Resource d(ParcelFileDescriptor parcelFileDescriptor, int i3, int i4, Options options) {
        return e(new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.f66863d, this.f66862c), i3, i4, options, f66857l);
    }

    public Resource f(InputStream inputStream, int i3, int i4, Options options, DecodeCallbacks decodeCallbacks) {
        return e(new ImageReader.InputStreamImageReader(inputStream, this.f66863d, this.f66862c), i3, i4, options, decodeCallbacks);
    }

    public Resource g(ByteBuffer byteBuffer, int i3, int i4, Options options) {
        return e(new ImageReader.ByteBufferReader(byteBuffer, this.f66863d, this.f66862c), i3, i4, options, f66857l);
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }
}
