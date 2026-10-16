package androidx.core.view;

import android.graphics.Insets;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.core.util.ObjectsCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DisplayCutoutCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DisplayCutout f34407a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api28Impl {
        static int a(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        static int b(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        static int c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        static int d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api30Impl {
        static Insets a(DisplayCutout displayCutout) {
            return displayCutout.getWaterfallInsets();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api31Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api33Impl {
    }

    private DisplayCutoutCompat(DisplayCutout displayCutout) {
        this.f34407a = displayCutout;
    }

    static DisplayCutoutCompat f(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new DisplayCutoutCompat(displayCutout);
    }

    public int a() {
        return Api28Impl.a(this.f34407a);
    }

    public int b() {
        return Api28Impl.b(this.f34407a);
    }

    public int c() {
        return Api28Impl.c(this.f34407a);
    }

    public int d() {
        return Api28Impl.d(this.f34407a);
    }

    public androidx.core.graphics.Insets e() {
        return Build.VERSION.SDK_INT >= 30 ? androidx.core.graphics.Insets.d(Api30Impl.a(this.f34407a)) : androidx.core.graphics.Insets.f33963e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DisplayCutoutCompat.class != obj.getClass()) {
            return false;
        }
        return ObjectsCompat.a(this.f34407a, ((DisplayCutoutCompat) obj).f34407a);
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.f34407a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f34407a + "}";
    }
}
