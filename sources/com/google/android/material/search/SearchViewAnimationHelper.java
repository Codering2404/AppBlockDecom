package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.BackEventCompat;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.FadeThroughUpdateListener;
import com.google.android.material.internal.MultiViewUpdateListener;
import com.google.android.material.internal.RectEvaluator;
import com.google.android.material.internal.ReversableAnimatedValueInterpolator;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialMainContainerBackHelper;
import com.google.android.material.search.SearchView;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class SearchViewAnimationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SearchView f81694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f81695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ClippableRoundedCornerLayout f81696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FrameLayout f81697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FrameLayout f81698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Toolbar f81699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Toolbar f81700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TextView f81701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final EditText f81702i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ImageButton f81703j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final View f81704k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final TouchObserverFrameLayout f81705l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MaterialMainContainerBackHelper f81706m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private AnimatorSet f81707n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private SearchBar f81708o;

    private Animator A(boolean z2) {
        return K(z2, true, this.f81702i);
    }

    private AnimatorSet B(final boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (this.f81707n == null) {
            animatorSet.playTogether(s(z2), t(z2));
        }
        animatorSet.playTogether(H(z2), G(z2), u(z2), w(z2), F(z2), z(z2), q(z2), A(z2), I(z2));
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.search.SearchViewAnimationHelper.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SearchViewAnimationHelper.this.P(z2 ? 1.0f : 0.0f);
                SearchViewAnimationHelper.this.f81696c.a();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.this.P(z2 ? 0.0f : 1.0f);
            }
        });
        return animatorSet;
    }

    private int C(View view) {
        int iA = MarginLayoutParamsCompat.a((ViewGroup.MarginLayoutParams) view.getLayoutParams());
        return ViewUtils.o(this.f81708o) ? this.f81708o.getLeft() - iA : (this.f81708o.getRight() - this.f81694a.getWidth()) + iA;
    }

    private int D(View view) {
        int iB = MarginLayoutParamsCompat.b((ViewGroup.MarginLayoutParams) view.getLayoutParams());
        int iD = ViewCompat.D(this.f81708o);
        return ViewUtils.o(this.f81708o) ? ((this.f81708o.getWidth() - this.f81708o.getRight()) + iB) - iD : (this.f81708o.getLeft() - iB) + iD;
    }

    private int E() {
        return ((this.f81708o.getTop() + this.f81708o.getBottom()) / 2) - ((this.f81698e.getTop() + this.f81698e.getBottom()) / 2);
    }

    private Animator F(boolean z2) {
        return K(z2, false, this.f81697d);
    }

    private Animator G(boolean z2) {
        Rect rectM = this.f81706m.m();
        Rect rectL = this.f81706m.l();
        if (rectM == null) {
            rectM = ViewUtils.d(this.f81694a);
        }
        if (rectL == null) {
            rectL = ViewUtils.c(this.f81696c, this.f81708o);
        }
        final Rect rect = new Rect(rectL);
        final float cornerSize = this.f81708o.getCornerSize();
        final float fMax = Math.max(this.f81696c.getCornerRadius(), this.f81706m.k());
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new RectEvaluator(rect), rectL, rectM);
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SearchViewAnimationHelper.b(this.f81719a, cornerSize, fMax, rect, valueAnimator);
            }
        });
        valueAnimatorOfObject.setDuration(z2 ? 300L : 250L);
        valueAnimatorOfObject.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f79850b));
        return valueAnimatorOfObject;
    }

    private Animator H(boolean z2) {
        TimeInterpolator timeInterpolator = z2 ? AnimationUtils.f79849a : AnimationUtils.f79850b;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(z2 ? 300L : 250L);
        valueAnimatorOfFloat.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, timeInterpolator));
        valueAnimatorOfFloat.addUpdateListener(MultiViewUpdateListener.e(this.f81695b));
        return valueAnimatorOfFloat;
    }

    private Animator I(boolean z2) {
        return K(z2, true, this.f81701h);
    }

    private AnimatorSet J(boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(L());
        k(animatorSet);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f79850b));
        animatorSet.setDuration(z2 ? 350L : 300L);
        return animatorSet;
    }

    private Animator K(boolean z2, boolean z3, View view) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(z3 ? D(view) : C(view), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(MultiViewUpdateListener.k(view));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(E(), 0.0f);
        valueAnimatorOfFloat2.addUpdateListener(MultiViewUpdateListener.l(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        animatorSet.setDuration(z2 ? 300L : 250L);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f79850b));
        return animatorSet;
    }

    private Animator L() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f81696c.getHeight(), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(MultiViewUpdateListener.l(this.f81696c));
        return valueAnimatorOfFloat;
    }

    private void O(float f3) {
        ActionMenuView actionMenuViewB;
        if (!this.f81694a.p() || (actionMenuViewB = ToolbarUtils.b(this.f81699f)) == null) {
            return;
        }
        actionMenuViewB.setAlpha(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(float f3) {
        this.f81703j.setAlpha(f3);
        this.f81704k.setAlpha(f3);
        this.f81705l.setAlpha(f3);
        O(f3);
    }

    private void Q(Drawable drawable) {
        if (drawable instanceof DrawerArrowDrawable) {
            ((DrawerArrowDrawable) drawable).setProgress(1.0f);
        }
        if (drawable instanceof FadeThroughDrawable) {
            ((FadeThroughDrawable) drawable).a(1.0f);
        }
    }

    private void R(Toolbar toolbar) {
        ActionMenuView actionMenuViewB = ToolbarUtils.b(toolbar);
        if (actionMenuViewB != null) {
            for (int i3 = 0; i3 < actionMenuViewB.getChildCount(); i3++) {
                View childAt = actionMenuViewB.getChildAt(i3);
                childAt.setClickable(false);
                childAt.setFocusable(false);
                childAt.setFocusableInTouchMode(false);
            }
        }
    }

    private void T() {
        Menu menu = this.f81700g.getMenu();
        if (menu != null) {
            menu.clear();
        }
        if (this.f81708o.getMenuResId() == -1 || !this.f81694a.p()) {
            this.f81700g.setVisibility(8);
            return;
        }
        this.f81700g.x(this.f81708o.getMenuResId());
        R(this.f81700g);
        this.f81700g.setVisibility(0);
    }

    private AnimatorSet W() {
        if (this.f81694a.m()) {
            this.f81694a.k();
        }
        AnimatorSet animatorSetB = B(false);
        animatorSetB.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.search.SearchViewAnimationHelper.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SearchViewAnimationHelper.this.f81696c.setVisibility(8);
                if (!SearchViewAnimationHelper.this.f81694a.m()) {
                    SearchViewAnimationHelper.this.f81694a.k();
                }
                SearchViewAnimationHelper.this.f81694a.setTransitionState(SearchView.TransitionState.HIDDEN);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.this.f81694a.setTransitionState(SearchView.TransitionState.HIDING);
            }
        });
        animatorSetB.start();
        return animatorSetB;
    }

    private AnimatorSet X() {
        if (this.f81694a.m()) {
            this.f81694a.k();
        }
        AnimatorSet animatorSetJ = J(false);
        animatorSetJ.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.search.SearchViewAnimationHelper.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SearchViewAnimationHelper.this.f81696c.setVisibility(8);
                if (!SearchViewAnimationHelper.this.f81694a.m()) {
                    SearchViewAnimationHelper.this.f81694a.k();
                }
                SearchViewAnimationHelper.this.f81694a.setTransitionState(SearchView.TransitionState.HIDDEN);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.this.f81694a.setTransitionState(SearchView.TransitionState.HIDING);
            }
        });
        animatorSetJ.start();
        return animatorSetJ;
    }

    private void Y() {
        if (this.f81694a.m()) {
            this.f81694a.t();
        }
        this.f81694a.setTransitionState(SearchView.TransitionState.SHOWING);
        T();
        this.f81702i.setText(this.f81708o.getText());
        EditText editText = this.f81702i;
        editText.setSelection(editText.getText().length());
        this.f81696c.setVisibility(4);
        this.f81696c.post(new Runnable() { // from class: com.google.android.material.search.l
            @Override // java.lang.Runnable
            public final void run() {
                SearchViewAnimationHelper.d(this.f81725a);
            }
        });
    }

    private void Z() {
        if (this.f81694a.m()) {
            final SearchView searchView = this.f81694a;
            Objects.requireNonNull(searchView);
            searchView.postDelayed(new Runnable() { // from class: com.google.android.material.search.m
                @Override // java.lang.Runnable
                public final void run() {
                    searchView.t();
                }
            }, 150L);
        }
        this.f81696c.setVisibility(4);
        this.f81696c.post(new Runnable() { // from class: com.google.android.material.search.n
            @Override // java.lang.Runnable
            public final void run() {
                SearchViewAnimationHelper.a(this.f81727a);
            }
        });
    }

    public static /* synthetic */ void a(SearchViewAnimationHelper searchViewAnimationHelper) {
        searchViewAnimationHelper.f81696c.setTranslationY(r0.getHeight());
        AnimatorSet animatorSetJ = searchViewAnimationHelper.J(true);
        animatorSetJ.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.search.SearchViewAnimationHelper.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!SearchViewAnimationHelper.this.f81694a.m()) {
                    SearchViewAnimationHelper.this.f81694a.t();
                }
                SearchViewAnimationHelper.this.f81694a.setTransitionState(SearchView.TransitionState.SHOWN);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.this.f81696c.setVisibility(0);
                SearchViewAnimationHelper.this.f81694a.setTransitionState(SearchView.TransitionState.SHOWING);
            }
        });
        animatorSetJ.start();
    }

    public static /* synthetic */ void b(SearchViewAnimationHelper searchViewAnimationHelper, float f3, float f4, Rect rect, ValueAnimator valueAnimator) {
        searchViewAnimationHelper.getClass();
        searchViewAnimationHelper.f81696c.c(rect, AnimationUtils.a(f3, f4, valueAnimator.getAnimatedFraction()));
    }

    public static /* synthetic */ void d(SearchViewAnimationHelper searchViewAnimationHelper) {
        AnimatorSet animatorSetB = searchViewAnimationHelper.B(true);
        animatorSetB.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.search.SearchViewAnimationHelper.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!SearchViewAnimationHelper.this.f81694a.m()) {
                    SearchViewAnimationHelper.this.f81694a.t();
                }
                SearchViewAnimationHelper.this.f81694a.setTransitionState(SearchView.TransitionState.SHOWN);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.this.f81696c.setVisibility(0);
                SearchViewAnimationHelper.this.f81708o.c0();
            }
        });
        animatorSetB.start();
    }

    private void j(AnimatorSet animatorSet) {
        ActionMenuView actionMenuViewB = ToolbarUtils.b(this.f81699f);
        if (actionMenuViewB == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(C(actionMenuViewB), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(MultiViewUpdateListener.k(actionMenuViewB));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(E(), 0.0f);
        valueAnimatorOfFloat2.addUpdateListener(MultiViewUpdateListener.l(actionMenuViewB));
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
    }

    private void k(AnimatorSet animatorSet) {
        ImageButton imageButtonE = ToolbarUtils.e(this.f81699f);
        if (imageButtonE == null) {
            return;
        }
        Drawable drawableQ = DrawableCompat.q(imageButtonE.getDrawable());
        if (!this.f81694a.n()) {
            Q(drawableQ);
        } else {
            m(animatorSet, drawableQ);
            n(animatorSet, drawableQ);
        }
    }

    private void l(AnimatorSet animatorSet) {
        ImageButton imageButtonE = ToolbarUtils.e(this.f81699f);
        if (imageButtonE == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(D(imageButtonE), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(MultiViewUpdateListener.k(imageButtonE));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(E(), 0.0f);
        valueAnimatorOfFloat2.addUpdateListener(MultiViewUpdateListener.l(imageButtonE));
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
    }

    private void m(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof DrawerArrowDrawable) {
            final DrawerArrowDrawable drawerArrowDrawable = (DrawerArrowDrawable) drawable;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.j
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    drawerArrowDrawable.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            animatorSet.playTogether(valueAnimatorOfFloat);
        }
    }

    private void n(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof FadeThroughDrawable) {
            final FadeThroughDrawable fadeThroughDrawable = (FadeThroughDrawable) drawable;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.k
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    fadeThroughDrawable.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            animatorSet.playTogether(valueAnimatorOfFloat);
        }
    }

    private Animator q(boolean z2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(z2 ? 300L : 250L);
        valueAnimatorOfFloat.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f79850b));
        if (this.f81694a.p()) {
            valueAnimatorOfFloat.addUpdateListener(new FadeThroughUpdateListener(ToolbarUtils.b(this.f81700g), ToolbarUtils.b(this.f81699f)));
        }
        return valueAnimatorOfFloat;
    }

    private AnimatorSet s(boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        k(animatorSet);
        animatorSet.setDuration(z2 ? 300L : 250L);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f79850b));
        return animatorSet;
    }

    private AnimatorSet t(boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        l(animatorSet);
        j(animatorSet);
        animatorSet.setDuration(z2 ? 300L : 250L);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f79850b));
        return animatorSet;
    }

    private Animator u(boolean z2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(z2 ? 50L : 42L);
        valueAnimatorOfFloat.setStartDelay(z2 ? 250L : 0L);
        valueAnimatorOfFloat.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f79849a));
        valueAnimatorOfFloat.addUpdateListener(MultiViewUpdateListener.e(this.f81703j));
        return valueAnimatorOfFloat;
    }

    private Animator v(boolean z2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(z2 ? 150L : 83L);
        valueAnimatorOfFloat.setStartDelay(z2 ? 75L : 0L);
        valueAnimatorOfFloat.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f79849a));
        valueAnimatorOfFloat.addUpdateListener(MultiViewUpdateListener.e(this.f81704k, this.f81705l));
        return valueAnimatorOfFloat;
    }

    private Animator w(boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(v(z2), y(z2), x(z2));
        return animatorSet;
    }

    private Animator x(boolean z2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.95f, 1.0f);
        valueAnimatorOfFloat.setDuration(z2 ? 300L : 250L);
        valueAnimatorOfFloat.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f79850b));
        valueAnimatorOfFloat.addUpdateListener(MultiViewUpdateListener.f(this.f81705l));
        return valueAnimatorOfFloat;
    }

    private Animator y(boolean z2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat((this.f81705l.getHeight() * 0.050000012f) / 2.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(z2 ? 300L : 250L);
        valueAnimatorOfFloat.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f79850b));
        valueAnimatorOfFloat.addUpdateListener(MultiViewUpdateListener.l(this.f81704k));
        return valueAnimatorOfFloat;
    }

    private Animator z(boolean z2) {
        return K(z2, false, this.f81700g);
    }

    AnimatorSet M() {
        return this.f81708o != null ? W() : X();
    }

    public BackEventCompat N() {
        return this.f81706m.c();
    }

    void S(SearchBar searchBar) {
        this.f81708o = searchBar;
    }

    void U() {
        if (this.f81708o != null) {
            Y();
        } else {
            Z();
        }
    }

    void V(BackEventCompat backEventCompat) {
        this.f81706m.s(backEventCompat, this.f81708o);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void a0(BackEventCompat backEventCompat) {
        if (backEventCompat.a() <= 0.0f) {
            return;
        }
        MaterialMainContainerBackHelper materialMainContainerBackHelper = this.f81706m;
        SearchBar searchBar = this.f81708o;
        materialMainContainerBackHelper.u(backEventCompat, searchBar, searchBar.getCornerSize());
        AnimatorSet animatorSet = this.f81707n;
        if (animatorSet != null) {
            animatorSet.setCurrentPlayTime((long) (backEventCompat.a() * this.f81707n.getDuration()));
            return;
        }
        if (this.f81694a.m()) {
            this.f81694a.k();
        }
        if (this.f81694a.n()) {
            AnimatorSet animatorSetS = s(false);
            this.f81707n = animatorSetS;
            animatorSetS.start();
            this.f81707n.pause();
        }
    }

    public void o() {
        this.f81706m.g(this.f81708o);
        AnimatorSet animatorSet = this.f81707n;
        if (animatorSet != null) {
            animatorSet.reverse();
        }
        this.f81707n = null;
    }

    public void p() {
        this.f81706m.j(M().getTotalDuration(), this.f81708o);
        if (this.f81707n != null) {
            t(false).start();
            this.f81707n.resume();
        }
        this.f81707n = null;
    }

    MaterialMainContainerBackHelper r() {
        return this.f81706m;
    }
}
