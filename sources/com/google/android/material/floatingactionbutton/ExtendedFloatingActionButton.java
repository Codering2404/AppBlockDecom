package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    private static final int K = R.style.L;
    static final Property L;
    static final Property M;
    static final Property N;
    static final Property O;
    private final int A;
    private int B;
    private int C;
    private final CoordinatorLayout.Behavior D;
    private boolean E;
    private boolean F;
    private boolean G;
    protected ColorStateList H;
    private int I;
    private int J;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f80995v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final MotionStrategy f80996w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final MotionStrategy f80997x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final MotionStrategy f80998y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final MotionStrategy f80999z;

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Size {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExtendedFloatingActionButton f81000a;

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int a() {
            return this.f81000a.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int b() {
            return this.f81000a.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getHeight() {
            return this.f81000a.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(getWidth(), getHeight());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getWidth() {
            return this.f81000a.getCollapsedSize();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements Size {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExtendedFloatingActionButton f81001a;

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int a() {
            return this.f81001a.C;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int b() {
            return this.f81001a.B;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getHeight() {
            return this.f81001a.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getWidth() {
            return (this.f81001a.getMeasuredWidth() - (this.f81001a.getCollapsedPadding() * 2)) + this.f81001a.B + this.f81001a.C;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 implements Size {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Size f81002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ExtendedFloatingActionButton f81003b;

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int a() {
            return this.f81003b.C;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int b() {
            return this.f81003b.B;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getHeight() {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            if (this.f81003b.J != -1) {
                return (this.f81003b.J == 0 || this.f81003b.J == -2) ? this.f81002a.getHeight() : this.f81003b.J;
            }
            if (!(this.f81003b.getParent() instanceof View)) {
                return this.f81002a.getHeight();
            }
            View view = (View) this.f81003b.getParent();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.height != -2) {
                return (view.getHeight() - ((!(this.f81003b.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f81003b.getLayoutParams()) == null) ? 0 : marginLayoutParams.topMargin + marginLayoutParams.bottomMargin)) - (view.getPaddingTop() + view.getPaddingBottom());
            }
            return this.f81002a.getHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(-1, this.f81003b.J == 0 ? -2 : this.f81003b.J);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getWidth() {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            if (!(this.f81003b.getParent() instanceof View)) {
                return this.f81002a.getWidth();
            }
            View view = (View) this.f81003b.getParent();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.width != -2) {
                return (view.getWidth() - ((!(this.f81003b.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f81003b.getLayoutParams()) == null) ? 0 : marginLayoutParams.leftMargin + marginLayoutParams.rightMargin)) - (view.getPaddingLeft() + view.getPaddingRight());
            }
            return this.f81002a.getWidth();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass4 implements Size {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Size f81004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Size f81005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ExtendedFloatingActionButton f81006c;

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int a() {
            return this.f81006c.C;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int b() {
            return this.f81006c.B;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getHeight() {
            return this.f81006c.J == -1 ? this.f81004a.getHeight() : (this.f81006c.J == 0 || this.f81006c.J == -2) ? this.f81005b.getHeight() : this.f81006c.J;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(this.f81006c.I == 0 ? -2 : this.f81006c.I, this.f81006c.J != 0 ? this.f81006c.J : -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getWidth() {
            return this.f81006c.I == -1 ? this.f81004a.getWidth() : (this.f81006c.I == 0 || this.f81006c.I == -2) ? this.f81005b.getWidth() : this.f81006c.I;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class ChangeSizeStrategy extends BaseMotionStrategy {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Size f81011g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f81012h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ ExtendedFloatingActionButton f81013i;

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void a() {
            this.f81013i.E = this.f81012h;
            ViewGroup.LayoutParams layoutParams = this.f81013i.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            if (!this.f81012h) {
                this.f81013i.I = layoutParams.width;
                this.f81013i.J = layoutParams.height;
            }
            layoutParams.width = this.f81011g.getLayoutParams().width;
            layoutParams.height = this.f81011g.getLayoutParams().height;
            ViewCompat.D0(this.f81013i, this.f81011g.b(), this.f81013i.getPaddingTop(), this.f81011g.a(), this.f81013i.getPaddingBottom());
            this.f81013i.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean d() {
            return this.f81012h == this.f81013i.E || this.f81013i.getIcon() == null || TextUtils.isEmpty(this.f81013i.getText());
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int f() {
            return this.f81012h ? R.animator.f79469b : R.animator.f79468a;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void g() {
            super.g();
            this.f81013i.F = false;
            this.f81013i.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = this.f81013i.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f81011g.getLayoutParams().width;
            layoutParams.height = this.f81011g.getLayoutParams().height;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public AnimatorSet i() {
            MotionSpec motionSpecM = m();
            if (motionSpecM.j(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
                PropertyValuesHolder[] propertyValuesHolderArrG = motionSpecM.g(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                propertyValuesHolderArrG[0].setFloatValues(this.f81013i.getWidth(), this.f81011g.getWidth());
                motionSpecM.l(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, propertyValuesHolderArrG);
            }
            if (motionSpecM.j(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
                PropertyValuesHolder[] propertyValuesHolderArrG2 = motionSpecM.g(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                propertyValuesHolderArrG2[0].setFloatValues(this.f81013i.getHeight(), this.f81011g.getHeight());
                motionSpecM.l(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, propertyValuesHolderArrG2);
            }
            if (motionSpecM.j("paddingStart")) {
                PropertyValuesHolder[] propertyValuesHolderArrG3 = motionSpecM.g("paddingStart");
                propertyValuesHolderArrG3[0].setFloatValues(ViewCompat.D(this.f81013i), this.f81011g.b());
                motionSpecM.l("paddingStart", propertyValuesHolderArrG3);
            }
            if (motionSpecM.j("paddingEnd")) {
                PropertyValuesHolder[] propertyValuesHolderArrG4 = motionSpecM.g("paddingEnd");
                propertyValuesHolderArrG4[0].setFloatValues(ViewCompat.C(this.f81013i), this.f81011g.a());
                motionSpecM.l("paddingEnd", propertyValuesHolderArrG4);
            }
            if (motionSpecM.j("labelOpacity")) {
                PropertyValuesHolder[] propertyValuesHolderArrG5 = motionSpecM.g("labelOpacity");
                boolean z2 = this.f81012h;
                propertyValuesHolderArrG5[0].setFloatValues(z2 ? 0.0f : 1.0f, z2 ? 1.0f : 0.0f);
                motionSpecM.l("labelOpacity", propertyValuesHolderArrG5);
            }
            return super.l(motionSpecM);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void j(OnChangedCallback onChangedCallback) {
            if (onChangedCallback == null) {
                return;
            }
            if (this.f81012h) {
                onChangedCallback.a(this.f81013i);
            } else {
                onChangedCallback.d(this.f81013i);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f81013i.E = this.f81012h;
            this.f81013i.F = true;
            this.f81013i.setHorizontallyScrolling(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class HideStrategy extends BaseMotionStrategy {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f81019g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ ExtendedFloatingActionButton f81020h;

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void a() {
            this.f81020h.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean d() {
            return this.f81020h.w();
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void e() {
            super.e();
            this.f81019g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int f() {
            return R.animator.f79470c;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void g() {
            super.g();
            this.f81020h.f80995v = 0;
            if (this.f81019g) {
                return;
            }
            this.f81020h.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void j(OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.b(this.f81020h);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f81019g = false;
            this.f81020h.setVisibility(0);
            this.f81020h.f80995v = 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class ShowStrategy extends BaseMotionStrategy {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ExtendedFloatingActionButton f81021g;

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void a() {
            this.f81021g.setVisibility(0);
            this.f81021g.setAlpha(1.0f);
            this.f81021g.setScaleY(1.0f);
            this.f81021g.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean d() {
            return this.f81021g.x();
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int f() {
            return R.animator.f79471d;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void g() {
            super.g();
            this.f81021g.f80995v = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void j(OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.c(this.f81021g);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f81021g.setVisibility(0);
            this.f81021g.f80995v = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Size {
        int a();

        int b();

        int getHeight();

        ViewGroup.LayoutParams getLayoutParams();

        int getWidth();
    }

    static {
        Class<Float> cls = Float.class;
        L = new Property<View, Float>(cls, ViewHierarchyConstants.DIMENSION_WIDTH_KEY) { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.6
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float get(View view) {
                return Float.valueOf(view.getLayoutParams().width);
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void set(View view, Float f3) {
                view.getLayoutParams().width = f3.intValue();
                view.requestLayout();
            }
        };
        M = new Property<View, Float>(cls, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY) { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.7
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float get(View view) {
                return Float.valueOf(view.getLayoutParams().height);
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void set(View view, Float f3) {
                view.getLayoutParams().height = f3.intValue();
                view.requestLayout();
            }
        };
        N = new Property<View, Float>(cls, "paddingStart") { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.8
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float get(View view) {
                return Float.valueOf(ViewCompat.D(view));
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void set(View view, Float f3) {
                ViewCompat.D0(view, f3.intValue(), view.getPaddingTop(), ViewCompat.C(view), view.getPaddingBottom());
            }
        };
        O = new Property<View, Float>(cls, "paddingEnd") { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.9
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float get(View view) {
                return Float.valueOf(ViewCompat.C(view));
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void set(View view, Float f3) {
                ViewCompat.D0(view, ViewCompat.D(view), view.getPaddingTop(), f3.intValue(), view.getPaddingBottom());
            }
        };
    }

    private boolean A() {
        return (ViewCompat.R(this) || (!x() && this.G)) && !isInEditMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        return getVisibility() == 0 ? this.f80995v == 1 : this.f80995v != 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        return getVisibility() != 0 ? this.f80995v == 2 : this.f80995v != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i3, final OnChangedCallback onChangedCallback) {
        final MotionStrategy motionStrategy;
        if (i3 == 0) {
            motionStrategy = this.f80998y;
        } else if (i3 == 1) {
            motionStrategy = this.f80999z;
        } else if (i3 == 2) {
            motionStrategy = this.f80996w;
        } else {
            if (i3 != 3) {
                throw new IllegalStateException("Unknown strategy type: " + i3);
            }
            motionStrategy = this.f80997x;
        }
        if (motionStrategy.d()) {
            return;
        }
        if (!A()) {
            motionStrategy.a();
            motionStrategy.j(onChangedCallback);
            return;
        }
        if (i3 == 2) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                this.I = layoutParams.width;
                this.J = layoutParams.height;
            } else {
                this.I = getWidth();
                this.J = getHeight();
            }
        }
        measure(0, 0);
        AnimatorSet animatorSetI = motionStrategy.i();
        animatorSetI.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.5

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f81007a;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.f81007a = true;
                motionStrategy.e();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                motionStrategy.g();
                if (this.f81007a) {
                    return;
                }
                motionStrategy.j(onChangedCallback);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                motionStrategy.onAnimationStart(animator);
                this.f81007a = false;
            }
        });
        Iterator it = motionStrategy.b().iterator();
        while (it.hasNext()) {
            animatorSetI.addListener((Animator.AnimatorListener) it.next());
        }
        animatorSetI.start();
    }

    private void z() {
        this.H = getTextColors();
    }

    protected void B(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.D;
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    int getCollapsedSize() {
        int i3 = this.A;
        return i3 < 0 ? (Math.min(ViewCompat.D(this), ViewCompat.C(this)) * 2) + getIconSize() : i3;
    }

    public MotionSpec getExtendMotionSpec() {
        return this.f80997x.c();
    }

    public MotionSpec getHideMotionSpec() {
        return this.f80999z.c();
    }

    public MotionSpec getShowMotionSpec() {
        return this.f80998y.c();
    }

    public MotionSpec getShrinkMotionSpec() {
        return this.f80996w.c();
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.E && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.E = false;
            this.f80996w.a();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z2) {
        this.G = z2;
    }

    public void setExtendMotionSpec(MotionSpec motionSpec) {
        this.f80997x.h(motionSpec);
    }

    public void setExtendMotionSpecResource(int i3) {
        setExtendMotionSpec(MotionSpec.d(getContext(), i3));
    }

    public void setExtended(boolean z2) {
        if (this.E == z2) {
            return;
        }
        MotionStrategy motionStrategy = z2 ? this.f80997x : this.f80996w;
        if (motionStrategy.d()) {
            return;
        }
        motionStrategy.a();
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        this.f80999z.h(motionSpec);
    }

    public void setHideMotionSpecResource(int i3) {
        setHideMotionSpec(MotionSpec.d(getContext(), i3));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i3, int i4, int i5, int i6) {
        super.setPadding(i3, i4, i5, i6);
        if (!this.E || this.F) {
            return;
        }
        this.B = ViewCompat.D(this);
        this.C = ViewCompat.C(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i3, int i4, int i5, int i6) {
        super.setPaddingRelative(i3, i4, i5, i6);
        if (!this.E || this.F) {
            return;
        }
        this.B = i3;
        this.C = i5;
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        this.f80998y.h(motionSpec);
    }

    public void setShowMotionSpecResource(int i3) {
        setShowMotionSpec(MotionSpec.d(getContext(), i3));
    }

    public void setShrinkMotionSpec(MotionSpec motionSpec) {
        this.f80996w.h(motionSpec);
    }

    public void setShrinkMotionSpecResource(int i3) {
        setShrinkMotionSpec(MotionSpec.d(getContext(), i3));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i3) {
        super.setTextColor(i3);
        z();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Rect f81014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private OnChangedCallback f81015b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private OnChangedCallback f81016c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f81017d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f81018f;

        public ExtendedFloatingActionButtonBehavior() {
            this.f81017d = false;
            this.f81018f = true;
        }

        private static boolean M(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean P(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f81017d || this.f81018f) && ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).e() == view.getId();
        }

        private boolean R(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!P(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f81014a == null) {
                this.f81014a = new Rect();
            }
            Rect rect = this.f81014a;
            DescendantOffsetUtils.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                Q(extendedFloatingActionButton);
                return true;
            }
            K(extendedFloatingActionButton);
            return true;
        }

        private boolean S(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!P(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                Q(extendedFloatingActionButton);
                return true;
            }
            K(extendedFloatingActionButton);
            return true;
        }

        protected void K(ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z2 = this.f81018f;
            extendedFloatingActionButton.y(z2 ? 3 : 0, z2 ? this.f81016c : this.f81015b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.h(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
        public boolean n(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                R(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!M(view)) {
                return false;
            }
            S(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public boolean r(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i3) {
            List listV = coordinatorLayout.v(extendedFloatingActionButton);
            int size = listV.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = (View) listV.get(i4);
                if (!(view instanceof AppBarLayout)) {
                    if (M(view) && S(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (R(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.M(extendedFloatingActionButton, i3);
            return true;
        }

        protected void Q(ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z2 = this.f81018f;
            extendedFloatingActionButton.y(z2 ? 2 : 1, z2 ? this.f81016c : this.f81015b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void m(CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.f33470h == 0) {
                layoutParams.f33470h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.N2);
            this.f81017d = typedArrayObtainStyledAttributes.getBoolean(R.styleable.O2, false);
            this.f81018f = typedArrayObtainStyledAttributes.getBoolean(R.styleable.P2, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        z();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class OnChangedCallback {
        public void a(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void b(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void c(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void d(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }
    }
}
