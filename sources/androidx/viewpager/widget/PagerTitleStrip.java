package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@ViewPager.DecorView
public class PagerTitleStrip extends ViewGroup {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int[] f53754p = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int[] f53755q = {R.attr.textAllCaps};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ViewPager f53756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    TextView f53757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    TextView f53758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    TextView f53759d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f53760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f53761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f53762h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f53763i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f53764j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f53765k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final PageListener f53766l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private WeakReference f53767m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f53768n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f53769o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f53770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PagerTitleStrip f53771b;

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void a(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            this.f53771b.a(pagerAdapter, pagerAdapter2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = this.f53771b;
            pagerTitleStrip.b(pagerTitleStrip.f53756a.getCurrentItem(), this.f53771b.f53756a.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = this.f53771b;
            float f3 = pagerTitleStrip2.f53761g;
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            pagerTitleStrip2.c(pagerTitleStrip2.f53756a.getCurrentItem(), f3, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            this.f53770a = i3;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f3, int i4) {
            if (f3 > 0.5f) {
                i3++;
            }
            this.f53771b.c(i3, f3, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            if (this.f53770a == 0) {
                PagerTitleStrip pagerTitleStrip = this.f53771b;
                pagerTitleStrip.b(pagerTitleStrip.f53756a.getCurrentItem(), this.f53771b.f53756a.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = this.f53771b;
                float f3 = pagerTitleStrip2.f53761g;
                if (f3 < 0.0f) {
                    f3 = 0.0f;
                }
                pagerTitleStrip2.c(pagerTitleStrip2.f53756a.getCurrentItem(), f3, true);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Locale f53772a;

        SingleLineAllCapsTransform(Context context) {
            this.f53772a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f53772a);
            }
            return null;
        }
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new SingleLineAllCapsTransform(textView.getContext()));
    }

    void a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.f53766l);
            this.f53767m = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.f53766l);
            this.f53767m = new WeakReference(pagerAdapter2);
        }
        ViewPager viewPager = this.f53756a;
        if (viewPager != null) {
            this.f53760f = -1;
            this.f53761g = -1.0f;
            b(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    void b(int i3, PagerAdapter pagerAdapter) {
        int count = pagerAdapter != null ? pagerAdapter.getCount() : 0;
        this.f53764j = true;
        CharSequence pageTitle = null;
        this.f53757b.setText((i3 < 1 || pagerAdapter == null) ? null : pagerAdapter.getPageTitle(i3 - 1));
        this.f53758c.setText((pagerAdapter == null || i3 >= count) ? null : pagerAdapter.getPageTitle(i3));
        int i4 = i3 + 1;
        if (i4 < count && pagerAdapter != null) {
            pageTitle = pagerAdapter.getPageTitle(i4);
        }
        this.f53759d.setText(pageTitle);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f53757b.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f53758c.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f53759d.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f53760f = i3;
        if (!this.f53765k) {
            c(i3, this.f53761g, false);
        }
        this.f53764j = false;
    }

    void c(int i3, float f3, boolean z2) {
        int i4;
        int i5;
        int i6;
        int i7;
        if (i3 != this.f53760f) {
            b(i3, this.f53756a.getAdapter());
        } else if (!z2 && f3 == this.f53761g) {
            return;
        }
        this.f53765k = true;
        int measuredWidth = this.f53757b.getMeasuredWidth();
        int measuredWidth2 = this.f53758c.getMeasuredWidth();
        int measuredWidth3 = this.f53759d.getMeasuredWidth();
        int i8 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i9 = paddingRight + i8;
        int i10 = (width - (paddingLeft + i8)) - i9;
        float f4 = 0.5f + f3;
        if (f4 > 1.0f) {
            f4 -= 1.0f;
        }
        int i11 = ((width - i9) - ((int) (i10 * f4))) - i8;
        int i12 = measuredWidth2 + i11;
        int baseline = this.f53757b.getBaseline();
        int baseline2 = this.f53758c.getBaseline();
        int baseline3 = this.f53759d.getBaseline();
        int iMax = Math.max(Math.max(baseline, baseline2), baseline3);
        int i13 = iMax - baseline;
        int i14 = iMax - baseline2;
        int i15 = iMax - baseline3;
        int iMax2 = Math.max(Math.max(this.f53757b.getMeasuredHeight() + i13, this.f53758c.getMeasuredHeight() + i14), this.f53759d.getMeasuredHeight() + i15);
        int i16 = this.f53763i & 112;
        if (i16 == 16) {
            i4 = (((height - paddingTop) - paddingBottom) - iMax2) / 2;
        } else {
            if (i16 != 80) {
                i5 = i13 + paddingTop;
                i6 = i14 + paddingTop;
                i7 = paddingTop + i15;
                TextView textView = this.f53758c;
                textView.layout(i11, i6, i12, textView.getMeasuredHeight() + i6);
                int iMin = Math.min(paddingLeft, (i11 - this.f53762h) - measuredWidth);
                TextView textView2 = this.f53757b;
                textView2.layout(iMin, i5, iMin + measuredWidth, textView2.getMeasuredHeight() + i5);
                int iMax3 = Math.max((width - paddingRight) - measuredWidth3, i12 + this.f53762h);
                TextView textView3 = this.f53759d;
                textView3.layout(iMax3, i7, iMax3 + measuredWidth3, textView3.getMeasuredHeight() + i7);
                this.f53761g = f3;
                this.f53765k = false;
            }
            i4 = (height - paddingBottom) - iMax2;
        }
        i5 = i13 + i4;
        i6 = i14 + i4;
        i7 = i4 + i15;
        TextView textView4 = this.f53758c;
        textView4.layout(i11, i6, i12, textView4.getMeasuredHeight() + i6);
        int iMin2 = Math.min(paddingLeft, (i11 - this.f53762h) - measuredWidth);
        TextView textView22 = this.f53757b;
        textView22.layout(iMin2, i5, iMin2 + measuredWidth, textView22.getMeasuredHeight() + i5);
        int iMax32 = Math.max((width - paddingRight) - measuredWidth3, i12 + this.f53762h);
        TextView textView32 = this.f53759d;
        textView32.layout(iMax32, i7, iMax32 + measuredWidth3, textView32.getMeasuredHeight() + i7);
        this.f53761g = f3;
        this.f53765k = false;
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f53762h;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        PagerAdapter adapter = viewPager.getAdapter();
        viewPager.setInternalPageChangeListener(this.f53766l);
        viewPager.addOnAdapterChangeListener(this.f53766l);
        this.f53756a = viewPager;
        WeakReference weakReference = this.f53767m;
        a(weakReference != null ? (PagerAdapter) weakReference.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f53756a;
        if (viewPager != null) {
            a(viewPager.getAdapter(), null);
            this.f53756a.setInternalPageChangeListener(null);
            this.f53756a.removeOnAdapterChangeListener(this.f53766l);
            this.f53756a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        if (this.f53756a != null) {
            float f3 = this.f53761g;
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            c(this.f53760f, f3, true);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int iMax;
        if (View.MeasureSpec.getMode(i3) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i3);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, (int) (size * 0.2f), -2);
        this.f53757b.measure(childMeasureSpec2, childMeasureSpec);
        this.f53758c.measure(childMeasureSpec2, childMeasureSpec);
        this.f53759d.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i4) == 1073741824) {
            iMax = View.MeasureSpec.getSize(i4);
        } else {
            iMax = Math.max(getMinHeight(), this.f53758c.getMeasuredHeight() + paddingTop);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(iMax, i4, this.f53758c.getMeasuredState() << 16));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f53764j) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i3) {
        this.f53763i = i3;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f3) {
        int i3 = ((int) (f3 * 255.0f)) & 255;
        this.f53768n = i3;
        int i4 = (i3 << 24) | (this.f53769o & 16777215);
        this.f53757b.setTextColor(i4);
        this.f53759d.setTextColor(i4);
    }

    public void setTextColor(int i3) {
        this.f53769o = i3;
        this.f53758c.setTextColor(i3);
        int i4 = (this.f53768n << 24) | (this.f53769o & 16777215);
        this.f53757b.setTextColor(i4);
        this.f53759d.setTextColor(i4);
    }

    public void setTextSpacing(int i3) {
        this.f53762h = i3;
        requestLayout();
    }
}
