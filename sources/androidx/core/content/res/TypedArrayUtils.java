package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class TypedArrayUtils {
    public static int a(Context context, int i3, int i4) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i3, typedValue, true);
        return typedValue.resourceId != 0 ? i3 : i4;
    }

    public static boolean b(TypedArray typedArray, int i3, int i4, boolean z2) {
        return typedArray.getBoolean(i3, typedArray.getBoolean(i4, z2));
    }

    public static Drawable c(TypedArray typedArray, int i3, int i4) {
        Drawable drawable = typedArray.getDrawable(i3);
        return drawable == null ? typedArray.getDrawable(i4) : drawable;
    }

    public static int d(TypedArray typedArray, int i3, int i4, int i5) {
        return typedArray.getInt(i3, typedArray.getInt(i4, i5));
    }

    public static boolean e(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i3, boolean z2) {
        return !p(xmlPullParser, str) ? z2 : typedArray.getBoolean(i3, z2);
    }

    public static int f(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i3, int i4) {
        return !p(xmlPullParser, str) ? i4 : typedArray.getColor(i3, i4);
    }

    public static ColorStateList g(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i3) {
        if (!p(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i3, typedValue);
        int i4 = typedValue.type;
        if (i4 != 2) {
            return (i4 < 28 || i4 > 31) ? ColorStateListInflaterCompat.d(typedArray.getResources(), typedArray.getResourceId(i3, 0), theme) : h(typedValue);
        }
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + i3 + ": " + typedValue);
    }

    private static ColorStateList h(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static ComplexColorCompat i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i3, int i4) {
        if (p(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i3, typedValue);
            int i5 = typedValue.type;
            if (i5 >= 28 && i5 <= 31) {
                return ComplexColorCompat.b(typedValue.data);
            }
            ComplexColorCompat complexColorCompatG = ComplexColorCompat.g(typedArray.getResources(), typedArray.getResourceId(i3, 0), theme);
            if (complexColorCompatG != null) {
                return complexColorCompatG;
            }
        }
        return ComplexColorCompat.b(i4);
    }

    public static float j(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i3, float f3) {
        return !p(xmlPullParser, str) ? f3 : typedArray.getFloat(i3, f3);
    }

    public static int k(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i3, int i4) {
        return !p(xmlPullParser, str) ? i4 : typedArray.getInt(i3, i4);
    }

    public static int l(TypedArray typedArray, int i3, int i4, int i5) {
        return typedArray.getResourceId(i3, typedArray.getResourceId(i4, i5));
    }

    public static String m(TypedArray typedArray, int i3, int i4) {
        String string = typedArray.getString(i3);
        return string == null ? typedArray.getString(i4) : string;
    }

    public static CharSequence n(TypedArray typedArray, int i3, int i4) {
        CharSequence text = typedArray.getText(i3);
        return text == null ? typedArray.getText(i4) : text;
    }

    public static CharSequence[] o(TypedArray typedArray, int i3, int i4) {
        CharSequence[] textArray = typedArray.getTextArray(i3);
        return textArray == null ? typedArray.getTextArray(i4) : textArray;
    }

    public static boolean p(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static TypedArray q(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
