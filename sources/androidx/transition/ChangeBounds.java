package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public class ChangeBounds extends Transition {
    private static final Property T;
    private static final Property U;
    private static final Property V;
    private static final Property W;
    private static final Property X;
    private boolean R = false;
    private static final String[] S = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final RectEvaluator Y = new RectEvaluator();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static class ClipListener extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f53353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f53354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f53355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Rect f53356d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f53357f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f53358g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f53359h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f53360i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f53361j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f53362k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final int f53363l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final int f53364m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final int f53365n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f53366o;

        ClipListener(View view, Rect rect, boolean z2, Rect rect2, boolean z3, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            this.f53353a = view;
            this.f53354b = rect;
            this.f53355c = z2;
            this.f53356d = rect2;
            this.f53357f = z3;
            this.f53358g = i3;
            this.f53359h = i4;
            this.f53360i = i5;
            this.f53361j = i6;
            this.f53362k = i7;
            this.f53363l = i8;
            this.f53364m = i9;
            this.f53365n = i10;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void b(Transition transition) {
            View view = this.f53353a;
            int i3 = R.id.f53458e;
            Rect rect = (Rect) view.getTag(i3);
            this.f53353a.setTag(i3, null);
            this.f53353a.setClipBounds(rect);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void d(Transition transition) {
            this.f53353a.setTag(R.id.f53458e, this.f53353a.getClipBounds());
            this.f53353a.setClipBounds(this.f53357f ? null : this.f53356d);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void g(Transition transition) {
            this.f53366o = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            onAnimationStart(animator, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z2) {
            if (this.f53366o) {
                return;
            }
            Rect rect = null;
            if (z2) {
                if (!this.f53355c) {
                    rect = this.f53354b;
                }
            } else if (!this.f53357f) {
                rect = this.f53356d;
            }
            this.f53353a.setClipBounds(rect);
            if (z2) {
                ViewUtils.e(this.f53353a, this.f53358g, this.f53359h, this.f53360i, this.f53361j);
            } else {
                ViewUtils.e(this.f53353a, this.f53362k, this.f53363l, this.f53364m, this.f53365n);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z2) {
            int iMax = Math.max(this.f53360i - this.f53358g, this.f53364m - this.f53362k);
            int iMax2 = Math.max(this.f53361j - this.f53359h, this.f53365n - this.f53363l);
            int i3 = z2 ? this.f53362k : this.f53358g;
            int i4 = z2 ? this.f53363l : this.f53359h;
            ViewUtils.e(this.f53353a, i3, i4, iMax + i3, iMax2 + i4);
            this.f53353a.setClipBounds(z2 ? this.f53356d : this.f53354b);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void c(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void f(Transition transition) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static class SuppressLayoutListener extends TransitionListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f53367a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ViewGroup f53368b;

        SuppressLayoutListener(ViewGroup viewGroup) {
            this.f53368b = viewGroup;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void b(Transition transition) {
            ViewGroupUtils.c(this.f53368b, true);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void d(Transition transition) {
            ViewGroupUtils.c(this.f53368b, false);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void f(Transition transition) {
            if (!this.f53367a) {
                ViewGroupUtils.c(this.f53368b, false);
            }
            transition.b0(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void g(Transition transition) {
            ViewGroupUtils.c(this.f53368b, false);
            this.f53367a = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static class ViewBounds {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f53369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f53370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f53371c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f53372d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final View f53373e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f53374f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f53375g;

        ViewBounds(View view) {
            this.f53373e = view;
        }

        private void b() {
            ViewUtils.e(this.f53373e, this.f53369a, this.f53370b, this.f53371c, this.f53372d);
            this.f53374f = 0;
            this.f53375g = 0;
        }

        void a(PointF pointF) {
            this.f53371c = Math.round(pointF.x);
            this.f53372d = Math.round(pointF.y);
            int i3 = this.f53375g + 1;
            this.f53375g = i3;
            if (this.f53374f == i3) {
                b();
            }
        }

        void c(PointF pointF) {
            this.f53369a = Math.round(pointF.x);
            this.f53370b = Math.round(pointF.y);
            int i3 = this.f53374f + 1;
            this.f53374f = i3;
            if (i3 == this.f53375g) {
                b();
            }
        }
    }

    static {
        Class<PointF> cls = PointF.class;
        String str = "topLeft";
        T = new Property<ViewBounds, PointF>(cls, str) { // from class: androidx.transition.ChangeBounds.1
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.c(pointF);
            }
        };
        String str2 = "bottomRight";
        U = new Property<ViewBounds, PointF>(cls, str2) { // from class: androidx.transition.ChangeBounds.2
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.a(pointF);
            }
        };
        V = new Property<View, PointF>(cls, str2) { // from class: androidx.transition.ChangeBounds.3
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public PointF get(View view) {
                return null;
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void set(View view, PointF pointF) {
                ViewUtils.e(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
            }
        };
        W = new Property<View, PointF>(cls, str) { // from class: androidx.transition.ChangeBounds.4
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public PointF get(View view) {
                return null;
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void set(View view, PointF pointF) {
                ViewUtils.e(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
            }
        };
        X = new Property<View, PointF>(cls, "position") { // from class: androidx.transition.ChangeBounds.5
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public PointF get(View view) {
                return null;
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void set(View view, PointF pointF) {
                int iRound = Math.round(pointF.x);
                int iRound2 = Math.round(pointF.y);
                ViewUtils.e(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
            }
        };
    }

    @Override // androidx.transition.Transition
    public String[] K() {
        return S;
    }

    @Override // androidx.transition.Transition
    public void h(TransitionValues transitionValues) {
        p0(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void k(TransitionValues transitionValues) {
        Rect rect;
        p0(transitionValues);
        if (!this.R || (rect = (Rect) transitionValues.f53546b.getTag(R.id.f53458e)) == null) {
            return;
        }
        transitionValues.f53545a.put("android:changeBounds:clip", rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.transition.Transition
    public Animator q(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i3;
        int i4;
        int i5;
        int i6;
        ObjectAnimator objectAnimatorA;
        int i7;
        Rect rect;
        ObjectAnimator objectAnimatorOfObject;
        Animator animatorC;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Map map = transitionValues.f53545a;
        Map map2 = transitionValues2.f53545a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view = transitionValues2.f53546b;
        Rect rect2 = (Rect) transitionValues.f53545a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) transitionValues2.f53545a.get("android:changeBounds:bounds");
        int i8 = rect2.left;
        int i9 = rect3.left;
        int i10 = rect2.top;
        int i11 = rect3.top;
        int i12 = rect2.right;
        int i13 = rect3.right;
        int i14 = rect2.bottom;
        int i15 = rect3.bottom;
        int i16 = i12 - i8;
        int i17 = i14 - i10;
        int i18 = i13 - i9;
        int i19 = i15 - i11;
        Rect rect4 = (Rect) transitionValues.f53545a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) transitionValues2.f53545a.get("android:changeBounds:clip");
        if ((i16 == 0 || i17 == 0) && (i18 == 0 || i19 == 0)) {
            i3 = 0;
        } else {
            i3 = (i8 == i9 && i10 == i11) ? 0 : 1;
            if (i12 != i13 || i14 != i15) {
                i3++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i3++;
        }
        int i20 = i3;
        if (i20 <= 0) {
            return null;
        }
        if (this.R) {
            ViewUtils.e(view, i8, i10, Math.max(i16, i18) + i8, i10 + Math.max(i17, i19));
            if (i8 == i9 && i10 == i11) {
                objectAnimatorA = null;
                i4 = i15;
                i6 = i9;
                i5 = i13;
            } else {
                i4 = i15;
                i5 = i13;
                i6 = i9;
                objectAnimatorA = ObjectAnimatorUtils.a(view, X, z().a(i8, i10, i9, i11));
            }
            boolean z2 = rect4 == null;
            if (z2) {
                i7 = 0;
                rect = new Rect(0, 0, i16, i17);
            } else {
                i7 = 0;
                rect = rect4;
            }
            int i21 = rect5 == null ? 1 : i7;
            Rect rect6 = i21 != 0 ? new Rect(i7, i7, i18, i19) : rect5;
            if (rect.equals(rect6)) {
                objectAnimatorOfObject = null;
            } else {
                view.setClipBounds(rect);
                objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", Y, rect, rect6);
                ClipListener clipListener = new ClipListener(view, rect, z2, rect6, i21, i8, i10, i12, i14, i6, i11, i5, i4);
                objectAnimatorOfObject.addListener(clipListener);
                a(clipListener);
            }
            animatorC = TransitionUtils.c(objectAnimatorA, objectAnimatorOfObject);
        } else {
            ViewUtils.e(view, i8, i10, i12, i14);
            if (i20 != 2) {
                animatorC = (i8 == i9 && i10 == i11) ? ObjectAnimatorUtils.a(view, V, z().a(i12, i14, i13, i15)) : ObjectAnimatorUtils.a(view, W, z().a(i8, i10, i9, i11));
            } else if (i16 == i18 && i17 == i19) {
                animatorC = ObjectAnimatorUtils.a(view, X, z().a(i8, i10, i9, i11));
            } else {
                ViewBounds viewBounds = new ViewBounds(view);
                ObjectAnimator objectAnimatorA2 = ObjectAnimatorUtils.a(viewBounds, T, z().a(i8, i10, i9, i11));
                ObjectAnimator objectAnimatorA3 = ObjectAnimatorUtils.a(viewBounds, U, z().a(i12, i14, i13, i15));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                animatorSet.addListener(new AnimatorListenerAdapter(viewBounds) { // from class: androidx.transition.ChangeBounds.6

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ ViewBounds f53351a;
                    private final ViewBounds mViewBounds;

                    {
                        this.f53351a = viewBounds;
                        this.mViewBounds = viewBounds;
                    }
                });
                animatorC = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            ViewGroupUtils.c(viewGroup4, true);
            B().a(new SuppressLayoutListener(viewGroup4));
        }
        return animatorC;
    }

    private void p0(TransitionValues transitionValues) {
        View view = transitionValues.f53546b;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        transitionValues.f53545a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        transitionValues.f53545a.put(cJfnYMIyomoWf.yRkiHBLaERJlbi, transitionValues.f53546b.getParent());
        if (this.R) {
            transitionValues.f53545a.put("android:changeBounds:clip", view.getClipBounds());
        }
    }
}
