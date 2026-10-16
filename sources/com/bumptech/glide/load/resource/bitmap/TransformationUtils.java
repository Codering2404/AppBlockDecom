package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class TransformationUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Paint f66919a = new Paint(6);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Paint f66920b = new Paint(7);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Paint f66921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set f66922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Lock f66923e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface DrawRoundedCornerFn {
        void a(Canvas canvas, Paint paint, RectF rectF);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class NoLock implements Lock {
        NoLock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j3, TimeUnit timeUnit) {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        f66922d = hashSet;
        f66923e = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new NoLock();
        Paint paint = new Paint(7);
        f66921c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private static void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        Lock lock = f66923e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f66919a);
            e(canvas);
            lock.unlock();
        } catch (Throwable th) {
            f66923e.unlock();
            throw th;
        }
    }

    public static Bitmap b(BitmapPool bitmapPool, Bitmap bitmap, int i3, int i4) {
        float width;
        float height;
        if (bitmap.getWidth() == i3 && bitmap.getHeight() == i4) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width2 = 0.0f;
        if (bitmap.getWidth() * i4 > bitmap.getHeight() * i3) {
            width = i4 / bitmap.getHeight();
            width2 = (i3 - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i3 / bitmap.getWidth();
            height = (i4 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmapD = bitmapPool.d(i3, i4, k(bitmap));
        s(bitmap, bitmapD);
        a(bitmap, bitmapD, matrix);
        return bitmapD;
    }

    public static Bitmap c(BitmapPool bitmapPool, Bitmap bitmap, int i3, int i4) {
        if (bitmap.getWidth() > i3 || bitmap.getHeight() > i4) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return f(bitmapPool, bitmap, i3, i4);
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    public static Bitmap d(BitmapPool bitmapPool, Bitmap bitmap, int i3, int i4) {
        int iMin = Math.min(i3, i4);
        float f3 = iMin;
        float f4 = f3 / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float fMax = Math.max(f3 / width, f3 / height);
        float f5 = width * fMax;
        float f6 = fMax * height;
        float f7 = (f3 - f5) / 2.0f;
        float f8 = (f3 - f6) / 2.0f;
        RectF rectF = new RectF(f7, f8, f5 + f7, f6 + f8);
        Bitmap bitmapG = g(bitmapPool, bitmap);
        Bitmap bitmapD = bitmapPool.d(iMin, iMin, h(bitmap));
        bitmapD.setHasAlpha(true);
        Lock lock = f66923e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmapD);
            canvas.drawCircle(f4, f4, f4, f66920b);
            canvas.drawBitmap(bitmapG, (Rect) null, rectF, f66921c);
            e(canvas);
            lock.unlock();
            if (!bitmapG.equals(bitmap)) {
                bitmapPool.c(bitmapG);
            }
            return bitmapD;
        } catch (Throwable th) {
            f66923e.unlock();
            throw th;
        }
    }

    private static void e(Canvas canvas) {
        canvas.setBitmap(null);
    }

    public static Bitmap f(BitmapPool bitmapPool, Bitmap bitmap, int i3, int i4) {
        if (bitmap.getWidth() != i3 || bitmap.getHeight() != i4) {
            float fMin = Math.min(i3 / bitmap.getWidth(), i4 / bitmap.getHeight());
            int iRound = Math.round(bitmap.getWidth() * fMin);
            int iRound2 = Math.round(bitmap.getHeight() * fMin);
            if (bitmap.getWidth() != iRound || bitmap.getHeight() != iRound2) {
                Bitmap bitmapD = bitmapPool.d((int) (bitmap.getWidth() * fMin), (int) (bitmap.getHeight() * fMin), k(bitmap));
                s(bitmap, bitmapD);
                if (Log.isLoggable("TransformationUtils", 2)) {
                    Log.v("TransformationUtils", "request: " + i3 + "x" + i4);
                    Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
                    Log.v("TransformationUtils", "toReuse: " + bitmapD.getWidth() + "x" + bitmapD.getHeight());
                    StringBuilder sb = new StringBuilder();
                    sb.append("minPct:   ");
                    sb.append(fMin);
                    Log.v("TransformationUtils", sb.toString());
                }
                Matrix matrix = new Matrix();
                matrix.setScale(fMin, fMin);
                a(bitmap, bitmapD, matrix);
                return bitmapD;
            }
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
        } else if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size matches input, returning input");
            return bitmap;
        }
        return bitmap;
    }

    private static Bitmap g(BitmapPool bitmapPool, Bitmap bitmap) {
        Bitmap.Config configH = h(bitmap);
        if (configH.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap bitmapD = bitmapPool.d(bitmap.getWidth(), bitmap.getHeight(), configH);
        new Canvas(bitmapD).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return bitmapD;
    }

    private static Bitmap.Config h(Bitmap bitmap) {
        Bitmap.Config config = Bitmap.Config.RGBA_F16;
        return config.equals(bitmap.getConfig()) ? config : Bitmap.Config.ARGB_8888;
    }

    public static Lock i() {
        return f66923e;
    }

    public static int j(int i3) {
        switch (i3) {
            case 3:
            case 4:
                return SensibleDefaults.X_OFFSET;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    private static Bitmap.Config k(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    static void l(int i3, Matrix matrix) {
        switch (i3) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }

    public static boolean m(int i3) {
        switch (i3) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap n(Bitmap bitmap, int i3) {
        Bitmap bitmap2;
        Matrix matrix;
        if (i3 == 0) {
            return bitmap;
        }
        try {
            matrix = new Matrix();
            matrix.setRotate(i3);
            bitmap2 = bitmap;
        } catch (Exception e3) {
            e = e3;
            bitmap2 = bitmap;
        }
        try {
            return Bitmap.createBitmap(bitmap2, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception e4) {
            e = e4;
            Exception exc = e;
            if (!Log.isLoggable("TransformationUtils", 6)) {
                return bitmap2;
            }
            Log.e("TransformationUtils", "Exception when trying to orient image", exc);
            return bitmap2;
        }
    }

    public static Bitmap o(BitmapPool bitmapPool, Bitmap bitmap, int i3) {
        if (!m(i3)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        l(i3, matrix);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap p(BitmapPool bitmapPool, Bitmap bitmap, final float f3, final float f4, final float f5, final float f6) {
        return r(bitmapPool, bitmap, new DrawRoundedCornerFn() { // from class: com.bumptech.glide.load.resource.bitmap.TransformationUtils.2
            @Override // com.bumptech.glide.load.resource.bitmap.TransformationUtils.DrawRoundedCornerFn
            public void a(Canvas canvas, Paint paint, RectF rectF) {
                Path path = new Path();
                float f7 = f3;
                float f8 = f4;
                float f9 = f5;
                float f10 = f6;
                path.addRoundRect(rectF, new float[]{f7, f7, f8, f8, f9, f9, f10, f10}, Path.Direction.CW);
                canvas.drawPath(path, paint);
            }
        });
    }

    public static Bitmap q(BitmapPool bitmapPool, Bitmap bitmap, final int i3) {
        Preconditions.b(i3 > 0, "roundingRadius must be greater than 0.");
        return r(bitmapPool, bitmap, new DrawRoundedCornerFn() { // from class: com.bumptech.glide.load.resource.bitmap.TransformationUtils.1
            @Override // com.bumptech.glide.load.resource.bitmap.TransformationUtils.DrawRoundedCornerFn
            public void a(Canvas canvas, Paint paint, RectF rectF) {
                int i4 = i3;
                canvas.drawRoundRect(rectF, i4, i4, paint);
            }
        });
    }

    private static Bitmap r(BitmapPool bitmapPool, Bitmap bitmap, DrawRoundedCornerFn drawRoundedCornerFn) {
        Bitmap.Config configH = h(bitmap);
        Bitmap bitmapG = g(bitmapPool, bitmap);
        Bitmap bitmapD = bitmapPool.d(bitmapG.getWidth(), bitmapG.getHeight(), configH);
        bitmapD.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapG, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, bitmapD.getWidth(), bitmapD.getHeight());
        Lock lock = f66923e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmapD);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            drawRoundedCornerFn.a(canvas, paint, rectF);
            e(canvas);
            lock.unlock();
            if (!bitmapG.equals(bitmap)) {
                bitmapPool.c(bitmapG);
            }
            return bitmapD;
        } catch (Throwable th) {
            f66923e.unlock();
            throw th;
        }
    }

    public static void s(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
