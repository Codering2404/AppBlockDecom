package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.R;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class GradientColorInflaterCompat {
    private static ColorStops a(ColorStops colorStops, int i3, int i4, boolean z2, int i5) {
        return colorStops != null ? colorStops : z2 ? new ColorStops(i3, i5, i4) : new ColorStops(i3, i4);
    }

    static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayQ = TypedArrayUtils.q(resources, theme, attributeSet, R.styleable.B);
        float fJ = TypedArrayUtils.j(typedArrayQ, xmlPullParser, "startX", R.styleable.K, 0.0f);
        float fJ2 = TypedArrayUtils.j(typedArrayQ, xmlPullParser, "startY", R.styleable.L, 0.0f);
        float fJ3 = TypedArrayUtils.j(typedArrayQ, xmlPullParser, "endX", R.styleable.M, 0.0f);
        float fJ4 = TypedArrayUtils.j(typedArrayQ, xmlPullParser, "endY", R.styleable.N, 0.0f);
        float fJ5 = TypedArrayUtils.j(typedArrayQ, xmlPullParser, "centerX", R.styleable.F, 0.0f);
        float fJ6 = TypedArrayUtils.j(typedArrayQ, xmlPullParser, "centerY", R.styleable.G, 0.0f);
        int iK = TypedArrayUtils.k(typedArrayQ, xmlPullParser, "type", R.styleable.E, 0);
        int iF = TypedArrayUtils.f(typedArrayQ, xmlPullParser, "startColor", R.styleable.C, 0);
        boolean zP = TypedArrayUtils.p(xmlPullParser, "centerColor");
        int iF2 = TypedArrayUtils.f(typedArrayQ, xmlPullParser, "centerColor", R.styleable.J, 0);
        int iF3 = TypedArrayUtils.f(typedArrayQ, xmlPullParser, "endColor", R.styleable.D, 0);
        int iK2 = TypedArrayUtils.k(typedArrayQ, xmlPullParser, "tileMode", R.styleable.I, 0);
        float fJ7 = TypedArrayUtils.j(typedArrayQ, xmlPullParser, "gradientRadius", R.styleable.H, 0.0f);
        typedArrayQ.recycle();
        ColorStops colorStopsA = a(c(resources, xmlPullParser, attributeSet, theme), iF, iF3, zP, iF2);
        if (iK != 1) {
            return iK != 2 ? new LinearGradient(fJ, fJ2, fJ3, fJ4, colorStopsA.f33905a, colorStopsA.f33906b, d(iK2)) : new SweepGradient(fJ5, fJ6, colorStopsA.f33905a, colorStopsA.f33906b);
        }
        if (fJ7 > 0.0f) {
            return new RadialGradient(fJ5, fJ6, fJ7, colorStopsA.f33905a, colorStopsA.f33906b, d(iK2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
    
        if (r4.size() <= 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
    
        return new androidx.core.content.res.GradientColorInflaterCompat.ColorStops(r4, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.core.content.res.GradientColorInflaterCompat.ColorStops c(android.content.res.Resources r9, org.xmlpull.v1.XmlPullParser r10, android.util.AttributeSet r11, android.content.res.Resources.Theme r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r10.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r10.next()
            if (r3 == r1) goto L81
            int r5 = r10.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L81
        L21:
            r6 = 2
            if (r3 == r6) goto L25
            goto L12
        L25:
            if (r5 > r0) goto L12
            java.lang.String r3 = r10.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L34
            goto L12
        L34:
            int[] r3 = androidx.core.R.styleable.O
            android.content.res.TypedArray r3 = androidx.core.content.res.TypedArrayUtils.q(r9, r12, r11, r3)
            int r5 = androidx.core.R.styleable.P
            boolean r6 = r3.hasValue(r5)
            int r7 = androidx.core.R.styleable.Q
            boolean r8 = r3.hasValue(r7)
            if (r6 == 0) goto L66
            if (r8 == 0) goto L66
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            r6 = 0
            float r6 = r3.getFloat(r7, r6)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L66:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r11.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L81:
            int r9 = r4.size()
            if (r9 <= 0) goto L8d
            androidx.core.content.res.GradientColorInflaterCompat$ColorStops r9 = new androidx.core.content.res.GradientColorInflaterCompat$ColorStops
            r9.<init>(r4, r2)
            return r9
        L8d:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.GradientColorInflaterCompat.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.core.content.res.GradientColorInflaterCompat$ColorStops");
    }

    private static Shader.TileMode d(int i3) {
        return i3 != 1 ? i3 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ColorStops {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f33905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float[] f33906b;

        ColorStops(List list, List list2) {
            int size = list.size();
            this.f33905a = new int[size];
            this.f33906b = new float[size];
            for (int i3 = 0; i3 < size; i3++) {
                this.f33905a[i3] = ((Integer) list.get(i3)).intValue();
                this.f33906b[i3] = ((Float) list2.get(i3)).floatValue();
            }
        }

        ColorStops(int i3, int i4) {
            this.f33905a = new int[]{i3, i4};
            this.f33906b = new float[]{0.0f, 1.0f};
        }

        ColorStops(int i3, int i4, int i5) {
            this.f33905a = new int[]{i3, i4, i5};
            this.f33906b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
