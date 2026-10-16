package com.google.android.material.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class DrawableUtils {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class OutlineCompatL {
        static void a(Outline outline, Path path) {
            outline.setConvexPath(path);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class OutlineCompatR {
        static void a(Outline outline, Path path) {
            outline.setPath(path);
        }
    }

    public static Drawable a(Drawable drawable, Drawable drawable2) {
        return b(drawable, drawable2, -1, -1);
    }

    public static Drawable b(Drawable drawable, Drawable drawable2, int i3, int i4) {
        if (drawable == null) {
            return drawable2;
        }
        if (drawable2 == null) {
            return drawable;
        }
        if (i3 == -1) {
            i3 = i(drawable, drawable2);
        }
        if (i4 == -1) {
            i4 = h(drawable, drawable2);
        }
        if (i3 > drawable.getIntrinsicWidth() || i4 > drawable.getIntrinsicHeight()) {
            float f3 = i3 / i4;
            if (f3 >= drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                i4 = (int) (intrinsicWidth / f3);
                i3 = intrinsicWidth;
            } else {
                i4 = drawable.getIntrinsicHeight();
                i3 = (int) (f3 * i4);
            }
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
        layerDrawable.setLayerSize(1, i3, i4);
        layerDrawable.setLayerGravity(1, 17);
        return layerDrawable;
    }

    public static Drawable c(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        return e(drawable, colorStateList, mode, false);
    }

    public static Drawable d(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        return e(drawable, colorStateList, mode, false);
    }

    private static Drawable e(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode, boolean z2) {
        if (drawable == null) {
            return null;
        }
        if (colorStateList == null) {
            if (z2) {
                drawable.mutate();
            }
            return drawable;
        }
        Drawable drawableMutate = DrawableCompat.r(drawable).mutate();
        if (mode != null) {
            DrawableCompat.p(drawableMutate, mode);
        }
        return drawableMutate;
    }

    public static int[] f(int[] iArr) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            if (i4 == 16842912) {
                return iArr;
            }
            if (i4 == 0) {
                int[] iArr2 = (int[]) iArr.clone();
                iArr2[i3] = 16842912;
                return iArr2;
            }
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length + 1);
        iArrCopyOf[iArr.length] = 16842912;
        return iArrCopyOf;
    }

    public static ColorStateList g(Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !a.a(drawable)) {
            return null;
        }
        return b.a(drawable).getColorStateList();
    }

    private static int h(Drawable drawable, Drawable drawable2) {
        int intrinsicHeight = drawable2.getIntrinsicHeight();
        return intrinsicHeight != -1 ? intrinsicHeight : drawable.getIntrinsicHeight();
    }

    private static int i(Drawable drawable, Drawable drawable2) {
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        return intrinsicWidth != -1 ? intrinsicWidth : drawable.getIntrinsicWidth();
    }

    public static int[] j(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        int i3 = 0;
        for (int i4 : iArr) {
            if (i4 != 16842912) {
                iArr2[i3] = i4;
                i3++;
            }
        }
        return iArr2;
    }

    public static AttributeSet k(Context context, int i3, CharSequence charSequence) {
        int next;
        try {
            XmlResourceParser xml = context.getResources().getXml(i3);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            if (TextUtils.equals(xml.getName(), charSequence)) {
                return Xml.asAttributeSet(xml);
            }
            throw new XmlPullParserException("Must have a <" + ((Object) charSequence) + "> start tag");
        } catch (IOException e3) {
            e = e3;
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i3));
            notFoundException.initCause(e);
            throw notFoundException;
        } catch (XmlPullParserException e4) {
            e = e4;
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i3));
            notFoundException2.initCause(e);
            throw notFoundException2;
        }
    }

    public static void l(Outline outline, Path path) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            OutlineCompatR.a(outline, path);
            return;
        }
        if (i3 >= 29) {
            try {
                OutlineCompatL.a(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            OutlineCompatL.a(outline, path);
        }
    }

    public static void m(RippleDrawable rippleDrawable, int i3) {
        rippleDrawable.setRadius(i3);
    }

    public static void n(Drawable drawable, int i3) {
        if (i3 != 0) {
            DrawableCompat.n(drawable, i3);
        } else {
            DrawableCompat.o(drawable, null);
        }
    }

    public static PorterDuffColorFilter o(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }
}
