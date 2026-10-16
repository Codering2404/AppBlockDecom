package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.widget.LinearLayoutCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Interpolator f2080l = new DecelerateInterpolator();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Runnable f2081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TabClickListener f2082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    LinearLayoutCompat f2083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Spinner f2084d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f2086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f2087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2089j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected ViewPropertyAnimator f2090k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class TabAdapter extends BaseAdapter {
        TabAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.f2083c.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return ((TabView) ScrollingTabContainerView.this.f2083c.getChildAt(i3)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.c((ActionBar.Tab) getItem(i3), true);
            }
            ((TabView) view).a((ActionBar.Tab) getItem(i3));
            return view;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class TabClickListener implements View.OnClickListener {
        TabClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((TabView) view).b().f();
            int childCount = ScrollingTabContainerView.this.f2083c.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = ScrollingTabContainerView.this.f2083c.getChildAt(i3);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class TabView extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f2095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ActionBar.Tab f2096b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TextView f2097c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ImageView f2098d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f2099f;

        /* JADX WARN: Illegal instructions before constructor call */
        public TabView(Context context, ActionBar.Tab tab, boolean z2) {
            int i3 = R.attr.f637d;
            super(context, null, i3);
            int[] iArr = {android.R.attr.background};
            this.f2095a = iArr;
            this.f2096b = tab;
            TintTypedArray tintTypedArrayV = TintTypedArray.v(context, null, iArr, i3, 0);
            if (tintTypedArrayV.s(0)) {
                setBackgroundDrawable(tintTypedArrayV.g(0));
            }
            tintTypedArrayV.x();
            if (z2) {
                setGravity(8388627);
            }
            c();
        }

        public void a(ActionBar.Tab tab) {
            this.f2096b = tab;
            c();
        }

        public ActionBar.Tab b() {
            return this.f2096b;
        }

        public void c() {
            ActionBar.Tab tab = this.f2096b;
            View viewB = tab.b();
            if (viewB != null) {
                ViewParent parent = viewB.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewB);
                    }
                    addView(viewB);
                }
                this.f2099f = viewB;
                TextView textView = this.f2097c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f2098d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f2098d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f2099f;
            if (view != null) {
                removeView(view);
                this.f2099f = null;
            }
            Drawable drawableC = tab.c();
            CharSequence charSequenceE = tab.e();
            if (drawableC != null) {
                if (this.f2098d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f2098d = appCompatImageView;
                }
                this.f2098d.setImageDrawable(drawableC);
                this.f2098d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f2098d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f2098d.setImageDrawable(null);
                }
            }
            boolean zIsEmpty = TextUtils.isEmpty(charSequenceE);
            if (zIsEmpty) {
                TextView textView2 = this.f2097c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f2097c.setText((CharSequence) null);
                }
            } else {
                if (this.f2097c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R.attr.f639e);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f2097c = appCompatTextView;
                }
                this.f2097c.setText(charSequenceE);
                this.f2097c.setVisibility(0);
            }
            ImageView imageView3 = this.f2098d;
            if (imageView3 != null) {
                imageView3.setContentDescription(tab.a());
            }
            TooltipCompat.a(this, zIsEmpty ? tab.a() : null);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i3, int i4) {
            super.onMeasure(i3, i4);
            if (ScrollingTabContainerView.this.f2086g > 0) {
                int measuredWidth = getMeasuredWidth();
                int i5 = ScrollingTabContainerView.this.f2086g;
                if (measuredWidth > i5) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), i4);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z2) {
            boolean z3 = isSelected() != z2;
            super.setSelected(z2);
            if (z3 && z2) {
                sendAccessibilityEvent(4);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected class VisibilityAnimListener extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2102b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ScrollingTabContainerView f2103c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2101a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2101a) {
                return;
            }
            ScrollingTabContainerView scrollingTabContainerView = this.f2103c;
            scrollingTabContainerView.f2090k = null;
            scrollingTabContainerView.setVisibility(this.f2102b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f2103c.setVisibility(0);
            this.f2101a = false;
        }
    }

    private Spinner b() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.f645h);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private boolean d() {
        Spinner spinner = this.f2084d;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (d()) {
            return;
        }
        if (this.f2084d == null) {
            this.f2084d = b();
        }
        removeView(this.f2083c);
        addView(this.f2084d, new ViewGroup.LayoutParams(-2, -1));
        if (this.f2084d.getAdapter() == null) {
            this.f2084d.setAdapter((SpinnerAdapter) new TabAdapter());
        }
        Runnable runnable = this.f2081a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f2081a = null;
        }
        this.f2084d.setSelection(this.f2089j);
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f2084d);
        addView(this.f2083c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f2084d.getSelectedItemPosition());
        return false;
    }

    public void a(int i3) {
        final View childAt = this.f2083c.getChildAt(i3);
        Runnable runnable = this.f2081a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: androidx.appcompat.widget.ScrollingTabContainerView.1
            @Override // java.lang.Runnable
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.f2081a = null;
            }
        };
        this.f2081a = runnable2;
        post(runnable2);
    }

    TabView c(ActionBar.Tab tab, boolean z2) {
        TabView tabView = new TabView(getContext(), tab, z2);
        if (z2) {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.f2088i));
            return tabView;
        }
        tabView.setFocusable(true);
        if (this.f2082b == null) {
            this.f2082b = new TabClickListener();
        }
        tabView.setOnClickListener(this.f2082b);
        return tabView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f2081a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarPolicy actionBarPolicyB = ActionBarPolicy.b(getContext());
        setContentHeight(actionBarPolicyB.f());
        this.f2087h = actionBarPolicyB.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f2081a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
        ((TabView) view).b().f();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f2083c.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f2086g = -1;
        } else {
            if (childCount > 2) {
                this.f2086g = (int) (View.MeasureSpec.getSize(i3) * 0.4f);
            } else {
                this.f2086g = View.MeasureSpec.getSize(i3) / 2;
            }
            this.f2086g = Math.min(this.f2086g, this.f2087h);
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f2088i, 1073741824);
        if (z2 || !this.f2085f) {
            f();
        } else {
            this.f2083c.measure(0, iMakeMeasureSpec);
            if (this.f2083c.getMeasuredWidth() > View.MeasureSpec.getSize(i3)) {
                e();
            } else {
                f();
            }
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i3, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z2 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f2089j);
    }

    public void setAllowCollapse(boolean z2) {
        this.f2085f = z2;
    }

    public void setContentHeight(int i3) {
        this.f2088i = i3;
        requestLayout();
    }

    public void setTabSelected(int i3) {
        this.f2089j = i3;
        int childCount = this.f2083c.getChildCount();
        int i4 = 0;
        while (i4 < childCount) {
            View childAt = this.f2083c.getChildAt(i4);
            boolean z2 = i4 == i3;
            childAt.setSelected(z2);
            if (z2) {
                a(i3);
            }
            i4++;
        }
        Spinner spinner = this.f2084d;
        if (spinner == null || i3 < 0) {
            return;
        }
        spinner.setSelection(i3);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
    }
}
