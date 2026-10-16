package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ChangeTransform extends Transition {
    private static final String[] U = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    private static final Property V = new Property<PathAnimatorMatrix, float[]>(float[].class, "nonTranslations") { // from class: androidx.transition.ChangeTransform.1
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public float[] get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(PathAnimatorMatrix pathAnimatorMatrix, float[] fArr) {
            pathAnimatorMatrix.d(fArr);
        }
    };
    private static final Property W = new Property<PathAnimatorMatrix, PointF>(PointF.class, "translations") { // from class: androidx.transition.ChangeTransform.2
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(PathAnimatorMatrix pathAnimatorMatrix, PointF pointF) {
            pathAnimatorMatrix.c(pointF);
        }
    };
    private static final boolean X = true;
    boolean R;
    private boolean S;
    private Matrix T;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class GhostListener extends TransitionListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private View f53384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private GhostView f53385b;

        GhostListener(View view, GhostView ghostView) {
            this.f53384a = view;
            this.f53385b = ghostView;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void b(Transition transition) {
            this.f53385b.setVisibility(0);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void d(Transition transition) {
            this.f53385b.setVisibility(4);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void f(Transition transition) {
            transition.b0(this);
            GhostViewUtils.b(this.f53384a);
            this.f53384a.setTag(R.id.f53463j, null);
            this.f53384a.setTag(R.id.f53456c, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Listener extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f53386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Matrix f53387b = new Matrix();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f53388c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f53389d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final View f53390f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Transforms f53391g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final PathAnimatorMatrix f53392h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Matrix f53393i;

        Listener(View view, Transforms transforms, PathAnimatorMatrix pathAnimatorMatrix, Matrix matrix, boolean z2, boolean z3) {
            this.f53388c = z2;
            this.f53389d = z3;
            this.f53390f = view;
            this.f53391g = transforms;
            this.f53392h = pathAnimatorMatrix;
            this.f53393i = matrix;
        }

        private void a(Matrix matrix) {
            this.f53387b.set(matrix);
            this.f53390f.setTag(R.id.f53463j, this.f53387b);
            this.f53391g.a(this.f53390f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f53386a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f53386a) {
                if (this.f53388c && this.f53389d) {
                    a(this.f53393i);
                } else {
                    this.f53390f.setTag(R.id.f53463j, null);
                    this.f53390f.setTag(R.id.f53456c, null);
                }
            }
            ViewUtils.d(this.f53390f, null);
            this.f53391g.a(this.f53390f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            a(this.f53392h.a());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            ChangeTransform.t0(this.f53390f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PathAnimatorMatrix {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Matrix f53394a = new Matrix();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f53395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float[] f53396c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f53397d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f53398e;

        PathAnimatorMatrix(View view, float[] fArr) {
            this.f53395b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f53396c = fArr2;
            this.f53397d = fArr2[2];
            this.f53398e = fArr2[5];
            b();
        }

        private void b() {
            float[] fArr = this.f53396c;
            fArr[2] = this.f53397d;
            fArr[5] = this.f53398e;
            this.f53394a.setValues(fArr);
            ViewUtils.d(this.f53395b, this.f53394a);
        }

        Matrix a() {
            return this.f53394a;
        }

        void c(PointF pointF) {
            this.f53397d = pointF.x;
            this.f53398e = pointF.y;
            b();
        }

        void d(float[] fArr) {
            System.arraycopy(fArr, 0, this.f53396c, 0, fArr.length);
            b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Transforms {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f53399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f53400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final float f53401c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final float f53402d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final float f53403e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final float f53404f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final float f53405g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final float f53406h;

        Transforms(View view) {
            this.f53399a = view.getTranslationX();
            this.f53400b = view.getTranslationY();
            this.f53401c = ViewCompat.I(view);
            this.f53402d = view.getScaleX();
            this.f53403e = view.getScaleY();
            this.f53404f = view.getRotationX();
            this.f53405g = view.getRotationY();
            this.f53406h = view.getRotation();
        }

        public void a(View view) {
            ChangeTransform.v0(view, this.f53399a, this.f53400b, this.f53401c, this.f53402d, this.f53403e, this.f53404f, this.f53405g, this.f53406h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Transforms)) {
                return false;
            }
            Transforms transforms = (Transforms) obj;
            return transforms.f53399a == this.f53399a && transforms.f53400b == this.f53400b && transforms.f53401c == this.f53401c && transforms.f53402d == this.f53402d && transforms.f53403e == this.f53403e && transforms.f53404f == this.f53404f && transforms.f53405g == this.f53405g && transforms.f53406h == this.f53406h;
        }

        public int hashCode() {
            float f3 = this.f53399a;
            int iFloatToIntBits = (f3 != 0.0f ? Float.floatToIntBits(f3) : 0) * 31;
            float f4 = this.f53400b;
            int iFloatToIntBits2 = (iFloatToIntBits + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.f53401c;
            int iFloatToIntBits3 = (iFloatToIntBits2 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.f53402d;
            int iFloatToIntBits4 = (iFloatToIntBits3 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.f53403e;
            int iFloatToIntBits5 = (iFloatToIntBits4 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.f53404f;
            int iFloatToIntBits6 = (iFloatToIntBits5 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0)) * 31;
            float f9 = this.f53405g;
            int iFloatToIntBits7 = (iFloatToIntBits6 + (f9 != 0.0f ? Float.floatToIntBits(f9) : 0)) * 31;
            float f10 = this.f53406h;
            return iFloatToIntBits7 + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0);
        }
    }

    private void p0(TransitionValues transitionValues) {
        View view = transitionValues.f53546b;
        if (view.getVisibility() == 8) {
            return;
        }
        transitionValues.f53545a.put("android:changeTransform:parent", view.getParent());
        transitionValues.f53545a.put("android:changeTransform:transforms", new Transforms(view));
        Matrix matrix = view.getMatrix();
        transitionValues.f53545a.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.S) {
            Matrix matrix2 = new Matrix();
            ViewUtils.h((ViewGroup) view.getParent(), matrix2);
            matrix2.preTranslate(-r2.getScrollX(), -r2.getScrollY());
            transitionValues.f53545a.put("android:changeTransform:parentMatrix", matrix2);
            transitionValues.f53545a.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.f53463j));
            transitionValues.f53545a.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.f53456c));
        }
    }

    private void q0(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view = transitionValues2.f53546b;
        Matrix matrix = new Matrix((Matrix) transitionValues2.f53545a.get("android:changeTransform:parentMatrix"));
        ViewUtils.i(viewGroup, matrix);
        GhostView ghostViewA = GhostViewUtils.a(view, viewGroup, matrix);
        if (ghostViewA == null) {
            return;
        }
        ghostViewA.a((ViewGroup) transitionValues.f53545a.get("android:changeTransform:parent"), transitionValues.f53546b);
        Transition transition = this;
        while (true) {
            TransitionSet transitionSet = transition.f53499s;
            if (transitionSet == null) {
                break;
            } else {
                transition = transitionSet;
            }
        }
        transition.a(new GhostListener(view, ghostViewA));
        if (X) {
            View view2 = transitionValues.f53546b;
            if (view2 != transitionValues2.f53546b) {
                ViewUtils.f(view2, 0.0f);
            }
            ViewUtils.f(view, 1.0f);
        }
    }

    private ObjectAnimator r0(TransitionValues transitionValues, TransitionValues transitionValues2, boolean z2) {
        Matrix matrix = (Matrix) transitionValues.f53545a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) transitionValues2.f53545a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = MatrixUtils.f53444a;
        }
        if (matrix2 == null) {
            matrix2 = MatrixUtils.f53444a;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        Transforms transforms = (Transforms) transitionValues2.f53545a.get("android:changeTransform:transforms");
        View view = transitionValues2.f53546b;
        t0(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        PathAnimatorMatrix pathAnimatorMatrix = new PathAnimatorMatrix(view, fArr);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(pathAnimatorMatrix, PropertyValuesHolder.ofObject(V, new FloatArrayEvaluator(new float[9]), fArr, fArr2), PropertyValuesHolderUtils.a(W, z().a(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        Listener listener = new Listener(view, transforms, pathAnimatorMatrix, matrix3, z2, this.R);
        objectAnimatorOfPropertyValuesHolder.addListener(listener);
        objectAnimatorOfPropertyValuesHolder.addPauseListener(listener);
        return objectAnimatorOfPropertyValuesHolder;
    }

    private boolean s0(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (!O(viewGroup) || !O(viewGroup2)) {
            return viewGroup == viewGroup2;
        }
        TransitionValues transitionValuesX = x(viewGroup, true);
        return transitionValuesX != null && viewGroup2 == transitionValuesX.f53546b;
    }

    static void t0(View view) {
        v0(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    private void u0(TransitionValues transitionValues, TransitionValues transitionValues2) {
        Matrix matrix = (Matrix) transitionValues2.f53545a.get("android:changeTransform:parentMatrix");
        transitionValues2.f53546b.setTag(R.id.f53456c, matrix);
        Matrix matrix2 = this.T;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) transitionValues.f53545a.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            transitionValues.f53545a.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) transitionValues.f53545a.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }

    static void v0(View view, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        view.setTranslationX(f3);
        view.setTranslationY(f4);
        ViewCompat.J0(view, f5);
        view.setScaleX(f6);
        view.setScaleY(f7);
        view.setRotationX(f8);
        view.setRotationY(f9);
        view.setRotation(f10);
    }

    @Override // androidx.transition.Transition
    public String[] K() {
        return U;
    }

    @Override // androidx.transition.Transition
    public void h(TransitionValues transitionValues) {
        p0(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void k(TransitionValues transitionValues) {
        p0(transitionValues);
        if (X) {
            return;
        }
        ((ViewGroup) transitionValues.f53546b.getParent()).startViewTransition(transitionValues.f53546b);
    }

    @Override // androidx.transition.Transition
    public Animator q(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !transitionValues.f53545a.containsKey("android:changeTransform:parent") || !transitionValues2.f53545a.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) transitionValues.f53545a.get("android:changeTransform:parent");
        boolean z2 = this.S && !s0(viewGroup2, (ViewGroup) transitionValues2.f53545a.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) transitionValues.f53545a.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            transitionValues.f53545a.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) transitionValues.f53545a.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            transitionValues.f53545a.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z2) {
            u0(transitionValues, transitionValues2);
        }
        ObjectAnimator objectAnimatorR0 = r0(transitionValues, transitionValues2, z2);
        if (z2 && objectAnimatorR0 != null && this.R) {
            q0(viewGroup, transitionValues, transitionValues2);
            return objectAnimatorR0;
        }
        if (!X) {
            viewGroup2.endViewTransition(transitionValues.f53546b);
        }
        return objectAnimatorR0;
    }
}
