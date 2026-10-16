package androidx.core.graphics;

import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PaintCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f33968a = new ThreadLocal();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api23Impl {
        static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
    }

    public static boolean a(Paint paint, String str) {
        return Api23Impl.a(paint, str);
    }
}
