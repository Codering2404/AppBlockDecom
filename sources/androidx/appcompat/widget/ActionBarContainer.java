package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f1567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f1568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f1569d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Drawable f1570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Drawable f1571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Drawable f1572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f1573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f1574j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1575k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api21Impl {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new ActionBarBackgroundDrawable(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f805a);
        this.f1570f = typedArrayObtainStyledAttributes.getDrawable(R.styleable.f809b);
        this.f1571g = typedArrayObtainStyledAttributes.getDrawable(R.styleable.f817d);
        this.f1575k = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.f841j, -1);
        boolean z2 = true;
        if (getId() == R.id.N) {
            this.f1573i = true;
            this.f1572h = typedArrayObtainStyledAttributes.getDrawable(R.styleable.f813c);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f1573i ? this.f1570f != null || this.f1571g != null : this.f1572h != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1570f;
        if (drawable != null && drawable.isStateful()) {
            this.f1570f.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1571g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1571g.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1572h;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f1572h.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f1567b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1570f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1571g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1572h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1568c = findViewById(R.id.f733a);
        this.f1569d = findViewById(R.id.f738f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1566a || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0049 A[PHI: r1
      0x0049: PHI (r1v8 boolean) = (r1v1 boolean), (r1v1 boolean), (r1v0 boolean) binds: [B:31:0x00a6, B:33:0x00aa, B:15:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        /*
            r5 = this;
            super.onLayout(r6, r7, r8, r9, r10)
            r6 = r5
            android.view.View r8 = r6.f1567b
            r10 = 8
            r0 = 1
            r1 = 0
            if (r8 == 0) goto L14
            int r2 = r8.getVisibility()
            if (r2 == r10) goto L14
            r2 = r0
            goto L15
        L14:
            r2 = r1
        L15:
            if (r8 == 0) goto L34
            int r3 = r8.getVisibility()
            if (r3 == r10) goto L34
            int r10 = r5.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r3 = r8.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r3 = (android.widget.FrameLayout.LayoutParams) r3
            int r4 = r8.getMeasuredHeight()
            int r4 = r10 - r4
            int r3 = r3.bottomMargin
            int r4 = r4 - r3
            int r10 = r10 - r3
            r8.layout(r7, r4, r9, r10)
        L34:
            boolean r7 = r6.f1573i
            if (r7 == 0) goto L4c
            android.graphics.drawable.Drawable r7 = r6.f1572h
            if (r7 == 0) goto L49
            int r8 = r5.getMeasuredWidth()
            int r9 = r5.getMeasuredHeight()
            r7.setBounds(r1, r1, r8, r9)
            goto Lbf
        L49:
            r0 = r1
            goto Lbf
        L4c:
            android.graphics.drawable.Drawable r7 = r6.f1570f
            if (r7 == 0) goto La4
            android.view.View r7 = r6.f1568c
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L76
            android.graphics.drawable.Drawable r7 = r6.f1570f
            android.view.View r9 = r6.f1568c
            int r9 = r9.getLeft()
            android.view.View r10 = r6.f1568c
            int r10 = r10.getTop()
            android.view.View r1 = r6.f1568c
            int r1 = r1.getRight()
            android.view.View r3 = r6.f1568c
            int r3 = r3.getBottom()
            r7.setBounds(r9, r10, r1, r3)
            goto La3
        L76:
            android.view.View r7 = r6.f1569d
            if (r7 == 0) goto L9e
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L9e
            android.graphics.drawable.Drawable r7 = r6.f1570f
            android.view.View r9 = r6.f1569d
            int r9 = r9.getLeft()
            android.view.View r10 = r6.f1569d
            int r10 = r10.getTop()
            android.view.View r1 = r6.f1569d
            int r1 = r1.getRight()
            android.view.View r3 = r6.f1569d
            int r3 = r3.getBottom()
            r7.setBounds(r9, r10, r1, r3)
            goto La3
        L9e:
            android.graphics.drawable.Drawable r7 = r6.f1570f
            r7.setBounds(r1, r1, r1, r1)
        La3:
            r1 = r0
        La4:
            r6.f1574j = r2
            if (r2 == 0) goto L49
            android.graphics.drawable.Drawable r7 = r6.f1571g
            if (r7 == 0) goto L49
            int r9 = r8.getLeft()
            int r10 = r8.getTop()
            int r1 = r8.getRight()
            int r8 = r8.getBottom()
            r7.setBounds(r9, r10, r1, r8)
        Lbf:
            if (r0 == 0) goto Lc4
            r5.invalidate()
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i4) {
        int i5;
        if (this.f1568c == null && View.MeasureSpec.getMode(i4) == Integer.MIN_VALUE && (i5 = this.f1575k) >= 0) {
            i4 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i4)), Integer.MIN_VALUE);
        }
        super.onMeasure(i3, i4);
        if (this.f1568c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i4);
        View view = this.f1567b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!b(this.f1568c) ? a(this.f1568c) : !b(this.f1569d) ? a(this.f1569d) : 0) + a(this.f1567b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i4) : Api.BaseClientBuilder.API_PRIORITY_OTHER));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1570f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1570f);
        }
        this.f1570f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1568c;
            if (view != null) {
                this.f1570f.setBounds(view.getLeft(), this.f1568c.getTop(), this.f1568c.getRight(), this.f1568c.getBottom());
            }
        }
        boolean z2 = false;
        if (!this.f1573i ? !(this.f1570f != null || this.f1571g != null) : this.f1572h == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        Api21Impl.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1572h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1572h);
        }
        this.f1572h = drawable;
        boolean z2 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1573i && (drawable2 = this.f1572h) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f1573i ? !(this.f1570f != null || this.f1571g != null) : this.f1572h == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        Api21Impl.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1571g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1571g);
        }
        this.f1571g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1574j && (drawable2 = this.f1571g) != null) {
                drawable2.setBounds(this.f1567b.getLeft(), this.f1567b.getTop(), this.f1567b.getRight(), this.f1567b.getBottom());
            }
        }
        boolean z2 = false;
        if (!this.f1573i ? !(this.f1570f != null || this.f1571g != null) : this.f1572h == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        Api21Impl.a(this);
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f1567b;
        if (view != null) {
            removeView(view);
        }
        this.f1567b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z2) {
        this.f1566a = z2;
        setDescendantFocusability(z2 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z2 = i3 == 0;
        Drawable drawable = this.f1570f;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
        Drawable drawable2 = this.f1571g;
        if (drawable2 != null) {
            drawable2.setVisible(z2, false);
        }
        Drawable drawable3 = this.f1572h;
        if (drawable3 != null) {
            drawable3.setVisible(z2, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (drawable == this.f1570f && !this.f1573i) {
            return true;
        }
        if (drawable == this.f1571g && this.f1574j) {
            return true;
        }
        return (drawable == this.f1572h && this.f1573i) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i3) {
        if (i3 != 0) {
            return super.startActionModeForChild(view, callback, i3);
        }
        return null;
    }
}
