package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends AbsActionBarView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f1576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f1577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f1578l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f1579m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private View f1580n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private LinearLayout f1581o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f1582p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f1583q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f1584r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f1585s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f1586t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f1587u;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    private void j() {
        if (this.f1581o == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.f759a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1581o = linearLayout;
            this.f1582p = (TextView) linearLayout.findViewById(R.id.f737e);
            this.f1583q = (TextView) this.f1581o.findViewById(R.id.f736d);
            if (this.f1584r != 0) {
                this.f1582p.setTextAppearance(getContext(), this.f1584r);
            }
            if (this.f1585s != 0) {
                this.f1583q.setTextAppearance(getContext(), this.f1585s);
            }
        }
        this.f1582p.setText(this.f1576j);
        this.f1583q.setText(this.f1577k);
        boolean zIsEmpty = TextUtils.isEmpty(this.f1576j);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f1577k);
        this.f1583q.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f1581o.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f1581o.getParent() == null) {
            addView(this.f1581o);
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat f(int i3, long j3) {
        return super.f(i3, j3);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean g() {
        ActionMenuPresenter actionMenuPresenter = this.f1556d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.N();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1577k;
    }

    public CharSequence getTitle() {
        return this.f1576j;
    }

    public void h() {
        if (this.f1578l == null) {
            l();
        }
    }

    public void i(final ActionMode actionMode) {
        View view = this.f1578l;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f1587u, (ViewGroup) this, false);
            this.f1578l = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f1578l);
        }
        View viewFindViewById = this.f1578l.findViewById(R.id.f741i);
        this.f1579m = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ActionBarContextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                actionMode.c();
            }
        });
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.e();
        ActionMenuPresenter actionMenuPresenter = this.f1556d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.B();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f1556d = actionMenuPresenter2;
        actionMenuPresenter2.M(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder.c(this.f1556d, this.f1554b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f1556d.r(this);
        this.f1555c = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.f1555c, layoutParams);
    }

    public boolean k() {
        return this.f1586t;
    }

    public void l() {
        removeAllViews();
        this.f1580n = null;
        this.f1555c = null;
        this.f1556d = null;
        View view = this.f1579m;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f1556d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.E();
            this.f1556d.F();
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        boolean zB = ViewUtils.b(this);
        int paddingRight = zB ? (i5 - i3) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i6 - i4) - getPaddingTop()) - getPaddingBottom();
        View view = this.f1578l;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1578l.getLayoutParams();
            int i7 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i8 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iD = AbsActionBarView.d(paddingRight, i7, zB);
            paddingRight = AbsActionBarView.d(iD + e(this.f1578l, iD, paddingTop, paddingTop2, zB), i8, zB);
        }
        int iE = paddingRight;
        LinearLayout linearLayout = this.f1581o;
        if (linearLayout != null && this.f1580n == null && linearLayout.getVisibility() != 8) {
            iE += e(this.f1581o, iE, paddingTop, paddingTop2, zB);
        }
        View view2 = this.f1580n;
        if (view2 != null) {
            e(view2, iE, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i5 - i3) - getPaddingRight();
        ActionMenuView actionMenuView = this.f1555c;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zB);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        if (View.MeasureSpec.getMode(i3) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i4) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i3);
        int size2 = this.f1557f;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i4);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f1578l;
        if (view != null) {
            int iC = c(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1578l.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f1555c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f1555c, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f1581o;
        if (linearLayout != null && this.f1580n == null) {
            if (this.f1586t) {
                this.f1581o.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f1581o.getMeasuredWidth();
                boolean z2 = measuredWidth <= paddingLeft;
                if (z2) {
                    paddingLeft -= measuredWidth;
                }
                this.f1581o.setVisibility(z2 ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f1580n;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i5 = layoutParams.width;
            int i6 = i5 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i5 >= 0) {
                paddingLeft = Math.min(i5, paddingLeft);
            }
            int i7 = layoutParams.height;
            int i8 = i7 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i7 >= 0) {
                iMin = Math.min(i7, iMin);
            }
            this.f1580n.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(iMin, i8));
        }
        if (this.f1557f > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            int measuredHeight = getChildAt(i10).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i9) {
                i9 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i9);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public void setContentHeight(int i3) {
        this.f1557f = i3;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f1580n;
        if (view2 != null) {
            removeView(view2);
        }
        this.f1580n = view;
        if (view != null && (linearLayout = this.f1581o) != null) {
            removeView(linearLayout);
            this.f1581o = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1577k = charSequence;
        j();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1576j = charSequence;
        j();
        ViewCompat.p0(this, charSequence);
    }

    public void setTitleOptional(boolean z2) {
        if (z2 != this.f1586t) {
            requestLayout();
        }
        this.f1586t = z2;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i3) {
        super.setVisibility(i3);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f651k);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TintTypedArray tintTypedArrayV = TintTypedArray.v(context, attributeSet, R.styleable.f894y, i3, 0);
        setBackground(tintTypedArrayV.g(R.styleable.f897z));
        this.f1584r = tintTypedArrayV.n(R.styleable.D, 0);
        this.f1585s = tintTypedArrayV.n(R.styleable.C, 0);
        this.f1557f = tintTypedArrayV.m(R.styleable.B, 0);
        this.f1587u = tintTypedArrayV.n(R.styleable.A, R.layout.f762d);
        tintTypedArrayV.x();
    }
}
