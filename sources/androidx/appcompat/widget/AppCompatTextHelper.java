package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class AppCompatTextHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f1883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TintInfo f1884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TintInfo f1885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TintInfo f1886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TintInfo f1887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TintInfo f1888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TintInfo f1889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TintInfo f1890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppCompatTextViewAutoSizeHelper f1891i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f1892j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1893k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Typeface f1894l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f1895m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {
        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api26Impl {
        static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static void b(TextView textView, int i3, int i4, int i5, int i6) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i3, i4, i5, i6);
        }

        static void c(TextView textView, int[] iArr, int i3) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i3);
        }

        static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api28Impl {
        static Typeface a(Typeface typeface, int i3, boolean z2) {
            return Typeface.create(typeface, i3, z2);
        }
    }

    AppCompatTextHelper(TextView textView) {
        this.f1883a = textView;
        this.f1891i = new AppCompatTextViewAutoSizeHelper(textView);
    }

    private void B(int i3, float f3) {
        this.f1891i.t(i3, f3);
    }

    private void C(Context context, TintTypedArray tintTypedArray) {
        String strO;
        this.f1892j = tintTypedArray.k(R.styleable.f3, this.f1892j);
        int iK = tintTypedArray.k(R.styleable.i3, -1);
        this.f1893k = iK;
        if (iK != -1) {
            this.f1892j &= 2;
        }
        int i3 = R.styleable.h3;
        if (!tintTypedArray.s(i3) && !tintTypedArray.s(R.styleable.j3)) {
            int i4 = R.styleable.e3;
            if (tintTypedArray.s(i4)) {
                this.f1895m = false;
                int iK2 = tintTypedArray.k(i4, 1);
                if (iK2 == 1) {
                    this.f1894l = Typeface.SANS_SERIF;
                    return;
                } else if (iK2 == 2) {
                    this.f1894l = Typeface.SERIF;
                    return;
                } else {
                    if (iK2 != 3) {
                        return;
                    }
                    this.f1894l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f1894l = null;
        int i5 = R.styleable.j3;
        if (tintTypedArray.s(i5)) {
            i3 = i5;
        }
        final int i6 = this.f1893k;
        final int i7 = this.f1892j;
        if (!context.isRestricted()) {
            final WeakReference weakReference = new WeakReference(this.f1883a);
            try {
                Typeface typefaceJ = tintTypedArray.j(i3, this.f1892j, new ResourcesCompat.FontCallback() { // from class: androidx.appcompat.widget.AppCompatTextHelper.1
                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    public void onFontRetrieved(Typeface typeface) {
                        int i8 = i6;
                        if (i8 != -1) {
                            typeface = Api28Impl.a(typeface, i8, (i7 & 2) != 0);
                        }
                        AppCompatTextHelper.this.n(weakReference, typeface);
                    }

                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    public void onFontRetrievalFailed(int i8) {
                    }
                });
                if (typefaceJ != null) {
                    if (this.f1893k != -1) {
                        this.f1894l = Api28Impl.a(Typeface.create(typefaceJ, 0), this.f1893k, (this.f1892j & 2) != 0);
                    } else {
                        this.f1894l = typefaceJ;
                    }
                }
                this.f1895m = this.f1894l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f1894l != null || (strO = tintTypedArray.o(i3)) == null) {
            return;
        }
        if (this.f1893k != -1) {
            this.f1894l = Api28Impl.a(Typeface.create(strO, 0), this.f1893k, (this.f1892j & 2) != 0);
        } else {
            this.f1894l = Typeface.create(strO, this.f1892j);
        }
    }

    private void a(Drawable drawable, TintInfo tintInfo) {
        if (drawable == null || tintInfo == null) {
            return;
        }
        AppCompatDrawableManager.i(drawable, tintInfo, this.f1883a.getDrawableState());
    }

    private static TintInfo d(Context context, AppCompatDrawableManager appCompatDrawableManager, int i3) {
        ColorStateList colorStateListF = appCompatDrawableManager.f(context, i3);
        if (colorStateListF == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.f2244d = true;
        tintInfo.f2241a = colorStateListF;
        return tintInfo;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.f1883a.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            TextView textView = this.f1883a;
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.f1883a.getCompoundDrawablesRelative();
        Drawable drawable7 = compoundDrawablesRelative2[0];
        if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            this.f1883a.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f1883a.getCompoundDrawables();
        TextView textView2 = this.f1883a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void z() {
        TintInfo tintInfo = this.f1890h;
        this.f1884b = tintInfo;
        this.f1885c = tintInfo;
        this.f1886d = tintInfo;
        this.f1887e = tintInfo;
        this.f1888f = tintInfo;
        this.f1889g = tintInfo;
    }

    void A(int i3, float f3) {
        if (ViewUtils.f2355c || l()) {
            return;
        }
        B(i3, f3);
    }

    void b() {
        if (this.f1884b != null || this.f1885c != null || this.f1886d != null || this.f1887e != null) {
            Drawable[] compoundDrawables = this.f1883a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1884b);
            a(compoundDrawables[1], this.f1885c);
            a(compoundDrawables[2], this.f1886d);
            a(compoundDrawables[3], this.f1887e);
        }
        if (this.f1888f == null && this.f1889g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f1883a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f1888f);
        a(compoundDrawablesRelative[2], this.f1889g);
    }

    void c() {
        this.f1891i.a();
    }

    int e() {
        return this.f1891i.f();
    }

    int f() {
        return this.f1891i.g();
    }

    int g() {
        return this.f1891i.h();
    }

    int[] h() {
        return this.f1891i.i();
    }

    int i() {
        return this.f1891i.j();
    }

    ColorStateList j() {
        TintInfo tintInfo = this.f1890h;
        if (tintInfo != null) {
            return tintInfo.f2241a;
        }
        return null;
    }

    PorterDuff.Mode k() {
        TintInfo tintInfo = this.f1890h;
        if (tintInfo != null) {
            return tintInfo.f2242b;
        }
        return null;
    }

    boolean l() {
        return this.f1891i.n();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m(android.util.AttributeSet r18, int r19) {
        /*
            Method dump skipped, instruction units count: 636
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextHelper.m(android.util.AttributeSet, int):void");
    }

    void n(WeakReference weakReference, final Typeface typeface) {
        if (this.f1895m) {
            this.f1894l = typeface;
            final TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                if (!textView.isAttachedToWindow()) {
                    textView.setTypeface(typeface, this.f1892j);
                } else {
                    final int i3 = this.f1892j;
                    textView.post(new Runnable() { // from class: androidx.appcompat.widget.AppCompatTextHelper.2
                        @Override // java.lang.Runnable
                        public void run() {
                            textView.setTypeface(typeface, i3);
                        }
                    });
                }
            }
        }
    }

    void o(boolean z2, int i3, int i4, int i5, int i6) {
        if (ViewUtils.f2355c) {
            return;
        }
        c();
    }

    void p() {
        b();
    }

    void q(Context context, int i3) {
        String strO;
        TintTypedArray tintTypedArrayT = TintTypedArray.t(context, i3, R.styleable.c3);
        int i4 = R.styleable.l3;
        if (tintTypedArrayT.s(i4)) {
            s(tintTypedArrayT.a(i4, false));
        }
        int i5 = R.styleable.d3;
        if (tintTypedArrayT.s(i5) && tintTypedArrayT.f(i5, -1) == 0) {
            this.f1883a.setTextSize(0, 0.0f);
        }
        C(context, tintTypedArrayT);
        int i6 = R.styleable.k3;
        if (tintTypedArrayT.s(i6) && (strO = tintTypedArrayT.o(i6)) != null) {
            Api26Impl.d(this.f1883a, strO);
        }
        tintTypedArrayT.x();
        Typeface typeface = this.f1894l;
        if (typeface != null) {
            this.f1883a.setTypeface(typeface, this.f1892j);
        }
    }

    void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        EditorInfoCompat.e(editorInfo, textView.getText());
    }

    void s(boolean z2) {
        this.f1883a.setAllCaps(z2);
    }

    void t(int i3, int i4, int i5, int i6) {
        this.f1891i.p(i3, i4, i5, i6);
    }

    void u(int[] iArr, int i3) {
        this.f1891i.q(iArr, i3);
    }

    void v(int i3) {
        this.f1891i.r(i3);
    }

    void w(ColorStateList colorStateList) {
        if (this.f1890h == null) {
            this.f1890h = new TintInfo();
        }
        TintInfo tintInfo = this.f1890h;
        tintInfo.f2241a = colorStateList;
        tintInfo.f2244d = colorStateList != null;
        z();
    }

    void x(PorterDuff.Mode mode) {
        if (this.f1890h == null) {
            this.f1890h = new TintInfo();
        }
        TintInfo tintInfo = this.f1890h;
        tintInfo.f2242b = mode;
        tintInfo.f2243c = mode != null;
        z();
    }
}
