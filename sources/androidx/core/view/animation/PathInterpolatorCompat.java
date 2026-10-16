package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PathInterpolatorCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {
        static Interpolator a(float f3, float f4, float f5, float f6) {
            return new PathInterpolator(f3, f4, f5, f6);
        }

        static Interpolator b(Path path) {
            return new PathInterpolator(path);
        }
    }

    public static Interpolator a(float f3, float f4, float f5, float f6) {
        return Api21Impl.a(f3, f4, f5, f6);
    }

    public static Interpolator b(Path path) {
        return Api21Impl.b(path);
    }
}
