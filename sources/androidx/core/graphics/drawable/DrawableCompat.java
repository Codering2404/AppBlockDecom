package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DrawableCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {
        static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        static void e(Drawable drawable, float f3, float f4) {
            drawable.setHotspot(f3, f4);
        }

        static void f(Drawable drawable, int i3, int i4, int i5, int i6) {
            drawable.setHotspotBounds(i3, i4, i5, i6);
        }

        static void g(Drawable drawable, int i3) {
            drawable.setTint(i3);
        }

        static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api23Impl {
        static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        static boolean b(Drawable drawable, int i3) {
            return drawable.setLayoutDirection(i3);
        }
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        Api21Impl.a(drawable, theme);
    }

    public static boolean b(Drawable drawable) {
        return Api21Impl.b(drawable);
    }

    public static void c(Drawable drawable) {
        drawable.clearColorFilter();
    }

    public static int d(Drawable drawable) {
        return drawable.getAlpha();
    }

    public static ColorFilter e(Drawable drawable) {
        return Api21Impl.c(drawable);
    }

    public static int f(Drawable drawable) {
        return Api23Impl.a(drawable);
    }

    public static void g(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Api21Impl.d(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean h(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static void i(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void j(Drawable drawable, boolean z2) {
        drawable.setAutoMirrored(z2);
    }

    public static void k(Drawable drawable, float f3, float f4) {
        Api21Impl.e(drawable, f3, f4);
    }

    public static void l(Drawable drawable, int i3, int i4, int i5, int i6) {
        Api21Impl.f(drawable, i3, i4, i5, i6);
    }

    public static boolean m(Drawable drawable, int i3) {
        return Api23Impl.b(drawable, i3);
    }

    public static void n(Drawable drawable, int i3) {
        Api21Impl.g(drawable, i3);
    }

    public static void o(Drawable drawable, ColorStateList colorStateList) {
        Api21Impl.h(drawable, colorStateList);
    }

    public static void p(Drawable drawable, PorterDuff.Mode mode) {
        Api21Impl.i(drawable, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Drawable q(Drawable drawable) {
        return drawable instanceof WrappedDrawable ? ((WrappedDrawable) drawable).a() : drawable;
    }

    public static Drawable r(Drawable drawable) {
        return drawable;
    }
}
