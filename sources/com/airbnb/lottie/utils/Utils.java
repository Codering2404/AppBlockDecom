package com.airbnb.lottie.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Utils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f57103a = new ThreadLocal<PathMeasure>() { // from class: com.airbnb.lottie.utils.Utils.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f57104b = new ThreadLocal<Path>() { // from class: com.airbnb.lottie.utils.Utils.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ThreadLocal f57105c = new ThreadLocal<Path>() { // from class: com.airbnb.lottie.utils.Utils.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ThreadLocal f57106d = new ThreadLocal<float[]>() { // from class: com.airbnb.lottie.utils.Utils.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public float[] initialValue() {
            return new float[4];
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f57107e = (float) (Math.sqrt(2.0d) / 2.0d);

    public static void a(Path path, float f3, float f4, float f5) {
        L.a("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = (PathMeasure) f57103a.get();
        Path path2 = (Path) f57104b.get();
        Path path3 = (Path) f57105c.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f3 == 1.0f && f4 == 0.0f) {
            L.b("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f4 - f3) - 1.0f) < 0.01d) {
            L.b("applyTrimPathIfNeeded");
            return;
        }
        float f6 = f3 * length;
        float f7 = f4 * length;
        float f8 = f5 * length;
        float fMin = Math.min(f6, f7) + f8;
        float fMax = Math.max(f6, f7) + f8;
        if (fMin >= length && fMax >= length) {
            fMin = MiscUtils.f(fMin, length);
            fMax = MiscUtils.f(fMax, length);
        }
        if (fMin < 0.0f) {
            fMin = MiscUtils.f(fMin, length);
        }
        if (fMax < 0.0f) {
            fMax = MiscUtils.f(fMax, length);
        }
        if (fMin == fMax) {
            path.reset();
            L.b("applyTrimPathIfNeeded");
            return;
        }
        if (fMin >= fMax) {
            fMin -= length;
        }
        path2.reset();
        pathMeasure.getSegment(fMin, fMax, path2, true);
        if (fMax > length) {
            path3.reset();
            pathMeasure.getSegment(0.0f, fMax % length, path3, true);
            path2.addPath(path3);
        } else if (fMin < 0.0f) {
            path3.reset();
            pathMeasure.getSegment(fMin + length, length, path3, true);
            path2.addPath(path3);
        }
        path.set(path2);
        L.b("applyTrimPathIfNeeded");
    }

    public static void b(Path path, TrimPathContent trimPathContent) {
        if (trimPathContent == null || trimPathContent.l()) {
            return;
        }
        a(path, ((FloatKeyframeAnimation) trimPathContent.j()).p() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.e()).p() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.h()).p() / 360.0f);
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static Path d(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
            return path;
        }
        float f3 = pointF.x + pointF3.x;
        float f4 = pointF.y + pointF3.y;
        float f5 = pointF2.x;
        float f6 = f5 + pointF4.x;
        float f7 = pointF2.y;
        path.cubicTo(f3, f4, f6, f7 + pointF4.y, f5, f7);
        return path;
    }

    public static float e() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float f(Matrix matrix) {
        float[] fArr = (float[]) f57106d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f3 = f57107e;
        fArr[2] = f3;
        fArr[3] = f3;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static boolean g(Matrix matrix) {
        float[] fArr = (float[]) f57106d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static int h(float f3, float f4, float f5, float f6) {
        int i3 = f3 != 0.0f ? (int) (527 * f3) : 17;
        if (f4 != 0.0f) {
            i3 = (int) (i3 * 31 * f4);
        }
        if (f5 != 0.0f) {
            i3 = (int) (i3 * 31 * f5);
        }
        return f6 != 0.0f ? (int) (i3 * 31 * f6) : i3;
    }

    public static boolean i(int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i3 < i6) {
            return false;
        }
        if (i3 > i6) {
            return true;
        }
        if (i4 < i7) {
            return false;
        }
        return i4 > i7 || i5 >= i8;
    }

    public static boolean j(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    public static Bitmap k(Bitmap bitmap, int i3, int i4) {
        if (bitmap.getWidth() == i3 && bitmap.getHeight() == i4) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i3, i4, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }

    public static void l(Canvas canvas, RectF rectF, Paint paint) {
        m(canvas, rectF, paint, 31);
    }

    public static void m(Canvas canvas, RectF rectF, Paint paint, int i3) {
        L.a("Utils#saveLayer");
        canvas.saveLayer(rectF, paint);
        L.b("Utils#saveLayer");
    }
}
