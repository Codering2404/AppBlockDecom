package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.api.Api;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class AppCompatTextViewAutoSizeHelper {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final RectF f1917l = new RectF();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static ConcurrentHashMap f1918m = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1919a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1920b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f1921c = -1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f1922d = -1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f1923e = -1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f1924f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1925g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextPaint f1926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TextView f1927i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Context f1928j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Impl f1929k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api23Impl {
        static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i3, int i4, TextView textView, TextPaint textPaint, Impl impl) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i3);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i4 == -1) {
                i4 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            hyphenationFrequency.setMaxLines(i4);
            try {
                impl.a(builderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return builderObtain.build();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl23 extends Impl {
        Impl23() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl29 extends Impl23 {
        Impl29() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl23, androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    AppCompatTextViewAutoSizeHelper(TextView textView) {
        this.f1927i = textView;
        this.f1928j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1929k = new Impl29();
        } else {
            this.f1929k = new Impl23();
        }
    }

    private int[] b(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i3 : iArr) {
                if (i3 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i3)) < 0) {
                    arrayList.add(Integer.valueOf(i3));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i4 = 0; i4 < size; i4++) {
                    iArr2[i4] = ((Integer) arrayList.get(i4)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    private void c() {
        this.f1919a = 0;
        this.f1922d = -1.0f;
        this.f1923e = -1.0f;
        this.f1921c = -1.0f;
        this.f1924f = new int[0];
        this.f1920b = false;
    }

    private int e(RectF rectF) {
        int length = this.f1924f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i3 = 1;
        int i4 = length - 1;
        int i5 = 0;
        while (i3 <= i4) {
            int i6 = (i3 + i4) / 2;
            if (x(this.f1924f[i6], rectF)) {
                int i7 = i6 + 1;
                i5 = i3;
                i3 = i7;
            } else {
                i5 = i6 - 1;
                i4 = i5;
            }
        }
        return this.f1924f[i5];
    }

    private static Method k(String str) {
        try {
            Method declaredMethod = (Method) f1918m.get(str);
            if (declaredMethod != null || (declaredMethod = TextView.class.getDeclaredMethod(str, null)) == null) {
                return declaredMethod;
            }
            declaredMethod.setAccessible(true);
            f1918m.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e3) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e3);
            return null;
        }
    }

    static Object m(Object obj, String str, Object obj2) {
        try {
            return k(str).invoke(obj, null);
        } catch (Exception e3) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e3);
            return obj2;
        }
    }

    private void s(float f3) {
        if (f3 != this.f1927i.getPaint().getTextSize()) {
            this.f1927i.getPaint().setTextSize(f3);
            boolean zIsInLayout = this.f1927i.isInLayout();
            if (this.f1927i.getLayout() != null) {
                this.f1920b = false;
                try {
                    Method methodK = k("nullLayouts");
                    if (methodK != null) {
                        methodK.invoke(this.f1927i, null);
                    }
                } catch (Exception e3) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e3);
                }
                if (zIsInLayout) {
                    this.f1927i.forceLayout();
                } else {
                    this.f1927i.requestLayout();
                }
                this.f1927i.invalidate();
            }
        }
    }

    private boolean u() {
        if (y() && this.f1919a == 1) {
            if (!this.f1925g || this.f1924f.length == 0) {
                int iFloor = ((int) Math.floor((this.f1923e - this.f1922d) / this.f1921c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i3 = 0; i3 < iFloor; i3++) {
                    iArr[i3] = Math.round(this.f1922d + (i3 * this.f1921c));
                }
                this.f1924f = b(iArr);
            }
            this.f1920b = true;
        } else {
            this.f1920b = false;
        }
        return this.f1920b;
    }

    private void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = typedArray.getDimensionPixelSize(i3, -1);
            }
            this.f1924f = b(iArr);
            w();
        }
    }

    private boolean w() {
        boolean z2 = this.f1924f.length > 0;
        this.f1925g = z2;
        if (z2) {
            this.f1919a = 1;
            this.f1922d = r0[0];
            this.f1923e = r0[r1 - 1];
            this.f1921c = -1.0f;
        }
        return z2;
    }

    private boolean x(int i3, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1927i.getText();
        TransformationMethod transformationMethod = this.f1927i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f1927i)) != null) {
            text = transformation;
        }
        int maxLines = this.f1927i.getMaxLines();
        l(i3);
        StaticLayout staticLayoutD = d(text, (Layout.Alignment) m(this.f1927i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (staticLayoutD.getLineCount() <= maxLines && staticLayoutD.getLineEnd(staticLayoutD.getLineCount() - 1) == text.length())) && ((float) staticLayoutD.getHeight()) <= rectF.bottom;
    }

    private boolean y() {
        return !(this.f1927i instanceof AppCompatEditText);
    }

    private void z(float f3, float f4, float f5) {
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f3 + "px) is less or equal to (0px)");
        }
        if (f4 <= f3) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f4 + "px) is less or equal to minimum auto-size text size (" + f3 + "px)");
        }
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f5 + "px) is less or equal to (0px)");
        }
        this.f1919a = 1;
        this.f1922d = f3;
        this.f1923e = f4;
        this.f1921c = f5;
        this.f1925g = false;
    }

    void a() {
        if (n()) {
            if (this.f1920b) {
                if (this.f1927i.getMeasuredHeight() <= 0 || this.f1927i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f1929k.b(this.f1927i) ? 1048576 : (this.f1927i.getMeasuredWidth() - this.f1927i.getTotalPaddingLeft()) - this.f1927i.getTotalPaddingRight();
                int height = (this.f1927i.getHeight() - this.f1927i.getCompoundPaddingBottom()) - this.f1927i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f1917l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fE = e(rectF);
                        if (fE != this.f1927i.getTextSize()) {
                            t(0, fE);
                        }
                    } finally {
                    }
                }
            }
            this.f1920b = true;
        }
    }

    StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i3, int i4) {
        return Api23Impl.a(charSequence, alignment, i3, i4, this.f1927i, this.f1926h, this.f1929k);
    }

    int f() {
        return Math.round(this.f1923e);
    }

    int g() {
        return Math.round(this.f1922d);
    }

    int h() {
        return Math.round(this.f1921c);
    }

    int[] i() {
        return this.f1924f;
    }

    int j() {
        return this.f1919a;
    }

    void l(int i3) {
        TextPaint textPaint = this.f1926h;
        if (textPaint == null) {
            this.f1926h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1926h.set(this.f1927i.getPaint());
        this.f1926h.setTextSize(i3);
    }

    boolean n() {
        return y() && this.f1919a != 0;
    }

    void o(AttributeSet attributeSet, int i3) {
        int resourceId;
        Context context = this.f1928j;
        int[] iArr = R.styleable.f838i0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i3, 0);
        TextView textView = this.f1927i;
        ViewCompat.k0(textView, textView.getContext(), iArr, attributeSet, typedArrayObtainStyledAttributes, i3, 0);
        int i4 = R.styleable.f858n0;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            this.f1919a = typedArrayObtainStyledAttributes.getInt(i4, 0);
        }
        int i5 = R.styleable.f854m0;
        float dimension = typedArrayObtainStyledAttributes.hasValue(i5) ? typedArrayObtainStyledAttributes.getDimension(i5, -1.0f) : -1.0f;
        int i6 = R.styleable.f846k0;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(i6) ? typedArrayObtainStyledAttributes.getDimension(i6, -1.0f) : -1.0f;
        int i7 = R.styleable.f842j0;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(i7) ? typedArrayObtainStyledAttributes.getDimension(i7, -1.0f) : -1.0f;
        int i8 = R.styleable.f850l0;
        if (typedArrayObtainStyledAttributes.hasValue(i8) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i8, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!y()) {
            this.f1919a = 0;
            return;
        }
        if (this.f1919a == 1) {
            if (!this.f1925g) {
                DisplayMetrics displayMetrics = this.f1928j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                z(dimension2, dimension3, dimension);
            }
            u();
        }
    }

    void p(int i3, int i4, int i5, int i6) {
        if (y()) {
            DisplayMetrics displayMetrics = this.f1928j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i6, i3, displayMetrics), TypedValue.applyDimension(i6, i4, displayMetrics), TypedValue.applyDimension(i6, i5, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    void q(int[] iArr, int i3) {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i3 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1928j.getResources().getDisplayMetrics();
                    for (int i4 = 0; i4 < length; i4++) {
                        iArrCopyOf[i4] = Math.round(TypedValue.applyDimension(i3, iArr[i4], displayMetrics));
                    }
                }
                this.f1924f = b(iArrCopyOf);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1925g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    void r(int i3) {
        if (y()) {
            if (i3 == 0) {
                c();
                return;
            }
            if (i3 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i3);
            }
            DisplayMetrics displayMetrics = this.f1928j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        }
    }

    void t(int i3, float f3) {
        Context context = this.f1928j;
        s(TypedValue.applyDimension(i3, f3, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl {
        Impl() {
        }

        boolean b(TextView textView) {
            return ((Boolean) AppCompatTextViewAutoSizeHelper.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }

        void a(StaticLayout.Builder builder, TextView textView) {
        }
    }
}
