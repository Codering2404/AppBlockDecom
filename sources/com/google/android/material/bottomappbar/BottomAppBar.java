package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private Integer V;
    private final MaterialShapeDrawable W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private Animator f80081a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private Animator f80082b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private int f80083c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f80084d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private int f80085e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private final int f80086f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private int f80087g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private int f80088h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private final boolean f80089i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f80090j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final boolean f80091k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private final boolean f80092l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private final boolean f80093m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private int f80094n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private ArrayList f80095o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f80096p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private boolean f80097q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private boolean f80098r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private Behavior f80099s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private int f80100t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private int f80101u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private int f80102v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    AnimatorListenerAdapter f80103w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    TransformationCallback f80104x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private static final int f80079y0 = R.style.C;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private static final int f80080z0 = R.attr.V;
    private static final int A0 = R.attr.f79487f0;

    /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomAppBar f80105a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f80105a.f80097q0) {
                return;
            }
            BottomAppBar bottomAppBar = this.f80105a;
            bottomAppBar.P0(bottomAppBar.f80083c0, this.f80105a.f80098r0);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements TransformationCallback<FloatingActionButton> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomAppBar f80106a;

        @Override // com.google.android.material.animation.TransformationCallback
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(FloatingActionButton floatingActionButton) {
            this.f80106a.W.b0((floatingActionButton.getVisibility() == 0 && this.f80106a.f80085e0 == 1) ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // com.google.android.material.animation.TransformationCallback
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(FloatingActionButton floatingActionButton) {
            if (this.f80106a.f80085e0 != 1) {
                return;
            }
            float translationX = floatingActionButton.getTranslationX();
            if (this.f80106a.getTopEdgeTreatment().j() != translationX) {
                this.f80106a.getTopEdgeTreatment().r(translationX);
                this.f80106a.W.invalidateSelf();
            }
            float fMax = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (this.f80106a.getTopEdgeTreatment().c() != fMax) {
                this.f80106a.getTopEdgeTreatment().k(fMax);
                this.f80106a.W.invalidateSelf();
            }
            this.f80106a.W.b0(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.bottomappbar.BottomAppBar$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 implements ViewUtils.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomAppBar f80107a;

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
            boolean z2;
            if (this.f80107a.f80091k0) {
                this.f80107a.f80100t0 = windowInsetsCompat.j();
            }
            boolean z3 = false;
            if (this.f80107a.f80092l0) {
                z2 = this.f80107a.f80102v0 != windowInsetsCompat.k();
                this.f80107a.f80102v0 = windowInsetsCompat.k();
            } else {
                z2 = false;
            }
            if (this.f80107a.f80093m0) {
                boolean z4 = this.f80107a.f80101u0 != windowInsetsCompat.l();
                this.f80107a.f80101u0 = windowInsetsCompat.l();
                z3 = z4;
            }
            if (!z2 && !z3) {
                return windowInsetsCompat;
            }
            this.f80107a.E0();
            this.f80107a.U0();
            this.f80107a.T0();
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface AnimationListener {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAlignmentMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnchorMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnimationMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface MenuAlignmentMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomappbar.BottomAppBar.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f80128c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f80129d;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f80128c);
            parcel.writeInt(this.f80129d ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f80128c = parcel.readInt();
            this.f80129d = parcel.readInt() != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(FloatingActionButton floatingActionButton) {
        floatingActionButton.e(this.f80103w0);
        floatingActionButton.f(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BottomAppBar.this.f80103w0.onAnimationStart(animator);
                FloatingActionButton floatingActionButtonK0 = BottomAppBar.this.K0();
                if (floatingActionButtonK0 != null) {
                    floatingActionButtonK0.setTranslationX(BottomAppBar.this.getFabTranslationX());
                }
            }
        });
        floatingActionButton.g(this.f80104x0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        Animator animator = this.f80082b0;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f80081a0;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void G0(int i3, List list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(K0(), "translationX", N0(i3));
        objectAnimatorOfFloat.setDuration(getFabAlignmentAnimationDuration());
        list.add(objectAnimatorOfFloat);
    }

    private void H0(final int i3, final boolean z2, List list) {
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        objectAnimatorOfFloat.setDuration((long) (0.8f * fabAlignmentAnimationDuration));
        if (Math.abs(actionMenuView.getTranslationX() - M0(actionMenuView, i3, z2)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(objectAnimatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            objectAnimatorOfFloat2.setDuration((long) (fabAlignmentAnimationDuration * 0.2f));
            objectAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.7

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public boolean f80113a;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.f80113a = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.f80113a) {
                        return;
                    }
                    boolean z3 = BottomAppBar.this.f80096p0 != 0;
                    BottomAppBar bottomAppBar = BottomAppBar.this;
                    bottomAppBar.S0(bottomAppBar.f80096p0);
                    BottomAppBar.this.Y0(actionMenuView, i3, z2, z3);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(objectAnimatorOfFloat2, objectAnimatorOfFloat);
            list.add(animatorSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        ArrayList arrayList;
        int i3 = this.f80094n0 - 1;
        this.f80094n0 = i3;
        if (i3 != 0 || (arrayList = this.f80095o0) == null) {
            return;
        }
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            ((AnimationListener) obj).a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        ArrayList arrayList;
        int i3 = this.f80094n0;
        this.f80094n0 = i3 + 1;
        if (i3 != 0 || (arrayList = this.f80095o0) == null) {
            return;
        }
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            ((AnimationListener) obj).b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton K0() {
        View viewL0 = L0();
        if (viewL0 instanceof FloatingActionButton) {
            return (FloatingActionButton) viewL0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View L0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).w(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float N0(int i3) {
        boolean zO = ViewUtils.o(this);
        if (i3 != 1) {
            return 0.0f;
        }
        return ((getMeasuredWidth() / 2) - ((zO ? this.f80102v0 : this.f80101u0) + ((this.f80087g0 == -1 || L0() == null) ? this.f80086f0 : (r6.getMeasuredWidth() / 2) + this.f80087g0))) * (zO ? -1 : 1);
    }

    private boolean O0() {
        FloatingActionButton floatingActionButtonK0 = K0();
        return floatingActionButtonK0 != null && floatingActionButtonK0.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(int i3, boolean z2) {
        if (!ViewCompat.R(this)) {
            this.f80097q0 = false;
            S0(this.f80096p0);
            return;
        }
        Animator animator = this.f80082b0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!O0()) {
            i3 = 0;
            z2 = false;
        }
        H0(i3, z2, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f80082b0 = animatorSet;
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                BottomAppBar.this.I0();
                BottomAppBar.this.f80097q0 = false;
                BottomAppBar.this.f80082b0 = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                BottomAppBar.this.J0();
            }
        });
        this.f80082b0.start();
    }

    private void Q0(int i3) {
        if (this.f80083c0 == i3 || !ViewCompat.R(this)) {
            return;
        }
        Animator animator = this.f80081a0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.f80084d0 == 1) {
            G0(i3, arrayList);
        } else {
            F0(i3, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.setInterpolator(MotionUtils.g(getContext(), A0, AnimationUtils.f79849a));
        this.f80081a0 = animatorSet;
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                BottomAppBar.this.I0();
                BottomAppBar.this.f80081a0 = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                BottomAppBar.this.J0();
            }
        });
        this.f80081a0.start();
    }

    private Drawable R0(Drawable drawable) {
        if (drawable == null || this.V == null) {
            return drawable;
        }
        Drawable drawableR = DrawableCompat.r(drawable.mutate());
        DrawableCompat.n(drawableR, this.V.intValue());
        return drawableR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.f80082b0 != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (O0()) {
            X0(actionMenuView, this.f80083c0, this.f80098r0);
        } else {
            X0(actionMenuView, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        getTopEdgeTreatment().r(getFabTranslationX());
        this.W.b0((this.f80098r0 && O0() && this.f80085e0 == 1) ? 1.0f : 0.0f);
        View viewL0 = L0();
        if (viewL0 != null) {
            viewL0.setTranslationY(getFabTranslationY());
            viewL0.setTranslationX(getFabTranslationX());
        }
    }

    private void X0(ActionMenuView actionMenuView, int i3, boolean z2) {
        Y0(actionMenuView, i3, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0(final ActionMenuView actionMenuView, final int i3, final boolean z2, boolean z3) {
        Runnable runnable = new Runnable() { // from class: com.google.android.material.bottomappbar.BottomAppBar.8
            @Override // java.lang.Runnable
            public void run() {
                actionMenuView.setTranslationX(BottomAppBar.this.M0(r0, i3, z2));
            }
        };
        if (z3) {
            actionMenuView.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Z0(BottomAppBar bottomAppBar, View view) {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        layoutParams.f33466d = 17;
        int i3 = bottomAppBar.f80085e0;
        if (i3 == 1) {
            layoutParams.f33466d = 17 | 48;
        }
        if (i3 == 0) {
            layoutParams.f33466d |= 80;
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.f80100t0;
    }

    private int getFabAlignmentAnimationDuration() {
        return MotionUtils.f(getContext(), f80080z0, 300);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return N0(this.f80083c0);
    }

    private float getFabTranslationY() {
        if (this.f80085e0 == 1) {
            return -getTopEdgeTreatment().c();
        }
        return L0() != null ? (-((getMeasuredHeight() + getBottomInset()) - r0.getMeasuredHeight())) / 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.f80102v0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.f80101u0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (BottomAppBarTopEdgeTreatment) this.W.getShapeAppearanceModel().p();
    }

    protected void F0(final int i3, List list) {
        FloatingActionButton floatingActionButtonK0 = K0();
        if (floatingActionButtonK0 == null || floatingActionButtonK0.p()) {
            return;
        }
        J0();
        floatingActionButtonK0.n(new FloatingActionButton.OnVisibilityChangedListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.5
            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
            public void a(FloatingActionButton floatingActionButton) {
                floatingActionButton.setTranslationX(BottomAppBar.this.N0(i3));
                floatingActionButton.u(new FloatingActionButton.OnVisibilityChangedListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.5.1
                    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
                    public void b(FloatingActionButton floatingActionButton2) {
                        BottomAppBar.this.I0();
                    }
                });
            }
        });
    }

    protected int M0(ActionMenuView actionMenuView, int i3, boolean z2) {
        int dimensionPixelOffset = 0;
        if (this.f80088h0 != 1 && (i3 != 1 || !z2)) {
            return 0;
        }
        boolean zO = ViewUtils.o(this);
        int measuredWidth = zO ? getMeasuredWidth() : 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).f900a & 8388615) == 8388611) {
                measuredWidth = zO ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = zO ? actionMenuView.getRight() : actionMenuView.getLeft();
        int i5 = zO ? this.f80101u0 : -this.f80102v0;
        if (getNavigationIcon() == null) {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.f79596v);
            if (!zO) {
                dimensionPixelOffset = -dimensionPixelOffset;
            }
        }
        return measuredWidth - ((right + i5) + dimensionPixelOffset);
    }

    public void S0(int i3) {
        if (i3 != 0) {
            this.f80096p0 = 0;
            getMenu().clear();
            x(i3);
        }
    }

    public void V0(int i3, int i4) {
        this.f80096p0 = i4;
        this.f80097q0 = true;
        P0(i3, this.f80098r0);
        Q0(i3);
        this.f80083c0 = i3;
    }

    boolean W0(int i3) {
        float f3 = i3;
        if (f3 == getTopEdgeTreatment().i()) {
            return false;
        }
        getTopEdgeTreatment().q(f3);
        this.W.invalidateSelf();
        return true;
    }

    public ColorStateList getBackgroundTint() {
        return this.W.H();
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().c();
    }

    public int getFabAlignmentMode() {
        return this.f80083c0;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.f80087g0;
    }

    public int getFabAnchorMode() {
        return this.f80085e0;
    }

    public int getFabAnimationMode() {
        return this.f80084d0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().g();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().h();
    }

    public boolean getHideOnScroll() {
        return this.f80090j0;
    }

    public int getMenuAlignmentMode() {
        return this.f80088h0;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.f(this, this.W);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        if (z2) {
            E0();
            U0();
            final View viewL0 = L0();
            if (viewL0 != null && ViewCompat.R(viewL0)) {
                viewL0.post(new Runnable() { // from class: com.google.android.material.bottomappbar.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        viewL0.requestLayout();
                    }
                });
            }
        }
        T0();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.c());
        this.f80083c0 = savedState.f80128c;
        this.f80098r0 = savedState.f80129d;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f80128c = this.f80083c0;
        savedState.f80129d = this.f80098r0;
        return savedState;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        DrawableCompat.o(this.W, colorStateList);
    }

    public void setCradleVerticalOffset(float f3) {
        if (f3 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().k(f3);
            this.W.invalidateSelf();
            U0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        this.W.Z(f3);
        getBehavior().O(this, this.W.D() - this.W.C());
    }

    public void setFabAlignmentMode(int i3) {
        V0(i3, 0);
    }

    public void setFabAlignmentModeEndMargin(int i3) {
        if (this.f80087g0 != i3) {
            this.f80087g0 = i3;
            U0();
        }
    }

    public void setFabAnchorMode(int i3) {
        this.f80085e0 = i3;
        U0();
        View viewL0 = L0();
        if (viewL0 != null) {
            Z0(this, viewL0);
            viewL0.requestLayout();
            this.W.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int i3) {
        this.f80084d0 = i3;
    }

    void setFabCornerSize(float f3) {
        if (f3 != getTopEdgeTreatment().e()) {
            getTopEdgeTreatment().m(f3);
            this.W.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f3) {
        if (f3 != getFabCradleMargin()) {
            getTopEdgeTreatment().o(f3);
            this.W.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f3) {
        if (f3 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().p(f3);
            this.W.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z2) {
        this.f80090j0 = z2;
    }

    public void setMenuAlignmentMode(int i3) {
        if (this.f80088h0 != i3) {
            this.f80088h0 = i3;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                X0(actionMenuView, this.f80083c0, O0());
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(R0(drawable));
    }

    public void setNavigationIconTint(int i3) {
        this.V = Integer.valueOf(i3);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public Behavior getBehavior() {
        if (this.f80099s0 == null) {
            this.f80099s0 = new Behavior();
        }
        return this.f80099s0;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final Rect f80123n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private WeakReference f80124o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f80125p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final View.OnLayoutChangeListener f80126q;

        public Behavior() {
            this.f80126q = new View.OnLayoutChangeListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.Behavior.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                    BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f80124o.get();
                    if (bottomAppBar == null || !((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                        view.removeOnLayoutChangeListener(this);
                        return;
                    }
                    int height = view.getHeight();
                    if (view instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                        floatingActionButton.j(Behavior.this.f80123n);
                        int iHeight = Behavior.this.f80123n.height();
                        bottomAppBar.W0(iHeight);
                        bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.f80123n)));
                        height = iHeight;
                    }
                    CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                    if (Behavior.this.f80125p == 0) {
                        if (bottomAppBar.f80085e0 == 1) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.f79575k0) - ((view.getMeasuredHeight() - height) / 2));
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                        if (ViewUtils.o(view)) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.f80086f0;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.f80086f0;
                        }
                    }
                    bottomAppBar.U0();
                }
            };
            this.f80123n = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
        public boolean r(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i3) {
            this.f80124o = new WeakReference(bottomAppBar);
            View viewL0 = bottomAppBar.L0();
            if (viewL0 != null && !ViewCompat.R(viewL0)) {
                BottomAppBar.Z0(bottomAppBar, viewL0);
                this.f80125p = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) viewL0.getLayoutParams())).bottomMargin;
                if (viewL0 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewL0;
                    if (bottomAppBar.f80085e0 == 0 && bottomAppBar.f80089i0) {
                        ViewCompat.u0(floatingActionButton, 0.0f);
                        floatingActionButton.setCompatElevation(0.0f);
                    }
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(R.animator.f79473f);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(R.animator.f79472e);
                    }
                    bottomAppBar.D0(floatingActionButton);
                }
                viewL0.addOnLayoutChangeListener(this.f80126q);
                bottomAppBar.U0();
            }
            coordinatorLayout.M(bottomAppBar, i3);
            return super.r(coordinatorLayout, bottomAppBar, i3);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
        public boolean G(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i3, int i4) {
            return bottomAppBar.getHideOnScroll() && super.G(coordinatorLayout, bottomAppBar, view, view2, i3, i4);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f80126q = new View.OnLayoutChangeListener() { // from class: com.google.android.material.bottomappbar.BottomAppBar.Behavior.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                    BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f80124o.get();
                    if (bottomAppBar == null || !((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                        view.removeOnLayoutChangeListener(this);
                        return;
                    }
                    int height = view.getHeight();
                    if (view instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                        floatingActionButton.j(Behavior.this.f80123n);
                        int iHeight = Behavior.this.f80123n.height();
                        bottomAppBar.W0(iHeight);
                        bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.f80123n)));
                        height = iHeight;
                    }
                    CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                    if (Behavior.this.f80125p == 0) {
                        if (bottomAppBar.f80085e0 == 1) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.f79575k0) - ((view.getMeasuredHeight() - height) / 2));
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                        if (ViewUtils.o(view)) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.f80086f0;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.f80086f0;
                        }
                    }
                    bottomAppBar.U0();
                }
            };
            this.f80123n = new Rect();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
