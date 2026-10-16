package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Gainmap;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapFactory;
import com.bumptech.glide.util.GlideSuppliers;
import com.bumptech.glide.util.Preconditions;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class GlideBitmapFactory {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class GainmapCopier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ColorMatrixColorFilter f66869a = new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 255.0f});

        public static Gainmap a(Gainmap gainmap) {
            Bitmap gainmapContents = gainmap.getGainmapContents();
            if (gainmapContents.getConfig() != Bitmap.Config.ALPHA_8) {
                return gainmap;
            }
            Gainmap gainmapA = i.a(b(gainmapContents));
            float[] ratioMin = gainmap.getRatioMin();
            gainmapA.setRatioMin(ratioMin[0], ratioMin[1], ratioMin[2]);
            float[] ratioMax = gainmap.getRatioMax();
            gainmapA.setRatioMax(ratioMax[0], ratioMax[1], ratioMax[2]);
            float[] gamma = gainmap.getGamma();
            gainmapA.setGamma(gamma[0], gamma[1], gamma[2]);
            float[] epsilonSdr = gainmap.getEpsilonSdr();
            gainmapA.setEpsilonSdr(epsilonSdr[0], epsilonSdr[1], epsilonSdr[2]);
            float[] epsilonHdr = gainmap.getEpsilonHdr();
            gainmapA.setEpsilonHdr(epsilonHdr[0], epsilonHdr[1], epsilonHdr[2]);
            gainmapA.setDisplayRatioForFullHdr(gainmap.getDisplayRatioForFullHdr());
            gainmapA.setMinDisplayRatioForHdrTransition(gainmap.getMinDisplayRatioForHdrTransition());
            return gainmapA;
        }

        private static Bitmap b(Bitmap bitmap) {
            Preconditions.a(bitmap.getConfig() == Bitmap.Config.ALPHA_8);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(f66869a);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            canvas.setBitmap(null);
            return bitmapCreateBitmap;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class GainmapDecoderWorkaroundStateCalculator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final GlideSuppliers.GlideSupplier f66870a = GlideSuppliers.a(new GlideSuppliers.GlideSupplier() { // from class: com.bumptech.glide.load.resource.bitmap.j
            @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
            public final Object get() {
                return Boolean.valueOf(GlideBitmapFactory.GainmapDecoderWorkaroundStateCalculator.c());
            }
        });

        private static boolean c() {
            if (Build.VERSION.SDK_INT != 34) {
                return false;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
            Bitmap bitmapCopy = bitmapCreateBitmap.copy(Bitmap.Config.HARDWARE, false);
            bitmapCreateBitmap.recycle();
            boolean z2 = bitmapCopy == null;
            if (Log.isLoggable("GainmapWorkaroundCalc", 2)) {
                Log.v("GainmapWorkaroundCalc", "calculateNeedsGainmapDecodeWorkaround=" + z2);
            }
            if (bitmapCopy != null) {
                bitmapCopy.recycle();
            }
            return z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean d(BitmapFactory.Options options) {
            if (Build.VERSION.SDK_INT == 34 && options.inPreferredConfig == Bitmap.Config.HARDWARE) {
                return ((Boolean) f66870a.get()).booleanValue();
            }
            return false;
        }
    }

    public static Bitmap a(byte[] bArr, BitmapFactory.Options options, ImageReader imageReader) {
        return (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.d(options) && d(imageReader)) ? g(bArr, options) : BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static Bitmap b(FileDescriptor fileDescriptor, BitmapFactory.Options options, ImageReader imageReader) {
        return (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.d(options) && d(imageReader)) ? e(fileDescriptor, options) : BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    public static Bitmap c(InputStream inputStream, BitmapFactory.Options options, ImageReader imageReader) {
        return (Build.VERSION.SDK_INT == 34 && GainmapDecoderWorkaroundStateCalculator.d(options) && d(imageReader)) ? f(inputStream, options) : BitmapFactory.decodeStream(inputStream, null, options);
    }

    private static boolean d(ImageReader imageReader) {
        try {
            boolean zB = imageReader.b();
            if (!Log.isLoggable("GlideBitmapFactory", 2)) {
                return zB;
            }
            Log.v("GlideBitmapFactory", "isLikelyToContainGainmap=" + zB);
            return zB;
        } catch (IOException e3) {
            if (!Log.isLoggable("GlideBitmapFactory", 2)) {
                return false;
            }
            Log.v("GlideBitmapFactory", "isLikelyToContainGainmap failed", e3);
            return false;
        }
    }

    private static Bitmap e(FileDescriptor fileDescriptor, BitmapFactory.Options options) throws Throwable {
        Throwable th;
        Bitmap bitmapDecodeFileDescriptor;
        Bitmap.Config config = options.inPreferredConfig;
        Bitmap.Config config2 = Bitmap.Config.HARDWARE;
        Preconditions.a(config == config2);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            if (bitmapDecodeFileDescriptor == null) {
                if (bitmapDecodeFileDescriptor != null) {
                    bitmapDecodeFileDescriptor.recycle();
                }
                options.inPreferredConfig = config2;
                return null;
            }
            try {
                Bitmap bitmapH = h(bitmapDecodeFileDescriptor);
                bitmapDecodeFileDescriptor.recycle();
                options.inPreferredConfig = config2;
                return bitmapH;
            } catch (Throwable th2) {
                th = th2;
                if (bitmapDecodeFileDescriptor != null) {
                    bitmapDecodeFileDescriptor.recycle();
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bitmapDecodeFileDescriptor = null;
        }
    }

    private static Bitmap f(InputStream inputStream, BitmapFactory.Options options) throws Throwable {
        Throwable th;
        Bitmap bitmapDecodeStream;
        Bitmap.Config config = options.inPreferredConfig;
        Bitmap.Config config2 = Bitmap.Config.HARDWARE;
        Preconditions.a(config == config2);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            if (bitmapDecodeStream == null) {
                if (bitmapDecodeStream != null) {
                    bitmapDecodeStream.recycle();
                }
                options.inPreferredConfig = config2;
                return null;
            }
            try {
                Bitmap bitmapH = h(bitmapDecodeStream);
                bitmapDecodeStream.recycle();
                options.inPreferredConfig = config2;
                return bitmapH;
            } catch (Throwable th2) {
                th = th2;
                if (bitmapDecodeStream != null) {
                    bitmapDecodeStream.recycle();
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bitmapDecodeStream = null;
        }
    }

    private static Bitmap g(byte[] bArr, BitmapFactory.Options options) throws Throwable {
        Throwable th;
        Bitmap bitmapDecodeByteArray;
        Bitmap.Config config = options.inPreferredConfig;
        Bitmap.Config config2 = Bitmap.Config.HARDWARE;
        Preconditions.a(config == config2);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray == null) {
                if (bitmapDecodeByteArray != null) {
                    bitmapDecodeByteArray.recycle();
                }
                options.inPreferredConfig = config2;
                return null;
            }
            try {
                Bitmap bitmapH = h(bitmapDecodeByteArray);
                bitmapDecodeByteArray.recycle();
                options.inPreferredConfig = config2;
                return bitmapH;
            } catch (Throwable th2) {
                th = th2;
                if (bitmapDecodeByteArray != null) {
                    bitmapDecodeByteArray.recycle();
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bitmapDecodeByteArray = null;
        }
    }

    private static Bitmap h(Bitmap bitmap) {
        Gainmap gainmap = bitmap.getGainmap();
        if (gainmap != null && gainmap.getGainmapContents().getConfig() == Bitmap.Config.ALPHA_8) {
            bitmap.setGainmap(GainmapCopier.a(gainmap));
        }
        return bitmap.copy(Bitmap.Config.HARDWARE, false);
    }
}
