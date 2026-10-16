package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
abstract class AbsActionBarView extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final VisibilityAnimListener f1553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f1554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected ActionMenuView f1555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected ActionMenuPresenter f1556d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f1557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected ViewPropertyAnimatorCompat f1558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1560i;

    /* JADX INFO: renamed from: androidx.appcompat.widget.AbsActionBarView$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbsActionBarView f1561a;

        @Override // java.lang.Runnable
        public void run() {
            this.f1561a.g();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected class VisibilityAnimListener implements ViewPropertyAnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1562a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1563b;

        protected VisibilityAnimListener() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void a(View view) {
            this.f1562a = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void b(View view) {
            if (this.f1562a) {
                return;
            }
            AbsActionBarView absActionBarView = AbsActionBarView.this;
            absActionBarView.f1558g = null;
            AbsActionBarView.super.setVisibility(this.f1563b);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void c(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.f1562a = false;
        }

        public VisibilityAnimListener d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i3) {
            AbsActionBarView.this.f1558g = viewPropertyAnimatorCompat;
            this.f1563b = i3;
            return this;
        }
    }

    AbsActionBarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1553a = new VisibilityAnimListener();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.f631a, typedValue, true) || typedValue.resourceId == 0) {
            this.f1554b = context;
        } else {
            this.f1554b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int d(int i3, int i4, boolean z2) {
        return z2 ? i3 - i4 : i3 + i4;
    }

    protected int c(View view, int i3, int i4, int i5) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE), i4);
        return Math.max(0, (i3 - view.getMeasuredWidth()) - i5);
    }

    protected int e(View view, int i3, int i4, int i5, boolean z2) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i6 = i4 + ((i5 - measuredHeight) / 2);
        if (z2) {
            view.layout(i3 - measuredWidth, i6, i3, measuredHeight + i6);
        } else {
            view.layout(i3, i6, i3 + measuredWidth, measuredHeight + i6);
        }
        return z2 ? -measuredWidth : measuredWidth;
    }

    public ViewPropertyAnimatorCompat f(int i3, long j3) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1558g;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.c();
        }
        if (i3 != 0) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatB = ViewCompat.e(this).b(0.0f);
            viewPropertyAnimatorCompatB.e(j3);
            viewPropertyAnimatorCompatB.g(this.f1553a.d(viewPropertyAnimatorCompatB, i3));
            return viewPropertyAnimatorCompatB;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatB2 = ViewCompat.e(this).b(1.0f);
        viewPropertyAnimatorCompatB2.e(j3);
        viewPropertyAnimatorCompatB2.g(this.f1553a.d(viewPropertyAnimatorCompatB2, i3));
        return viewPropertyAnimatorCompatB2;
    }

    public boolean g() {
        ActionMenuPresenter actionMenuPresenter = this.f1556d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.N();
        }
        return false;
    }

    public int getAnimatedVisibility() {
        return this.f1558g != null ? this.f1553a.f1563b : getVisibility();
    }

    public int getContentHeight() {
        return this.f1557f;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.f805a, R.attr.f635c, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.f841j, 0));
        typedArrayObtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f1556d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.I(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1560i = false;
        }
        if (!this.f1560i) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f1560i = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1560i = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1559h = false;
        }
        if (!this.f1559h) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f1559h = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1559h = false;
        }
        return true;
    }

    public void setContentHeight(int i3) {
        this.f1557f = i3;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        if (i3 != getVisibility()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1558g;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.c();
            }
            super.setVisibility(i3);
        }
    }
}
