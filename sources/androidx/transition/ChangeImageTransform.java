package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.Transition;
import androidx.transition.TransitionUtils;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ChangeImageTransform extends Transition {
    private static final String[] R = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
    private static final TypeEvaluator S = new TypeEvaluator<Matrix>() { // from class: androidx.transition.ChangeImageTransform.1
        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f3, Matrix matrix, Matrix matrix2) {
            return null;
        }
    };
    private static final Property T = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") { // from class: androidx.transition.ChangeImageTransform.2
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix get(ImageView imageView) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(ImageView imageView, Matrix matrix) {
            ImageViewUtils.a(imageView, matrix);
        }
    };

    /* JADX INFO: renamed from: androidx.transition.ChangeImageTransform$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f53379a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f53379a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f53379a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Listener extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImageView f53380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Matrix f53381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Matrix f53382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f53383d = true;

        Listener(ImageView imageView, Matrix matrix, Matrix matrix2) {
            this.f53380a = imageView;
            this.f53381b = matrix;
            this.f53382c = matrix2;
        }

        private void a() {
            ImageView imageView = this.f53380a;
            int i3 = R.id.f53460g;
            Matrix matrix = (Matrix) imageView.getTag(i3);
            if (matrix != null) {
                ImageViewUtils.a(this.f53380a, matrix);
                this.f53380a.setTag(i3, null);
            }
        }

        private void i(Matrix matrix) {
            this.f53380a.setTag(R.id.f53460g, matrix);
            ImageViewUtils.a(this.f53380a, this.f53382c);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void b(Transition transition) {
            a();
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void d(Transition transition) {
            if (this.f53383d) {
                i(this.f53381b);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z2) {
            this.f53383d = z2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            i((Matrix) ((ObjectAnimator) animator).getAnimatedValue());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z2) {
            this.f53383d = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f53383d = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f53383d = false;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void c(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void f(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void g(Transition transition) {
        }
    }

    private void p0(TransitionValues transitionValues, boolean z2) {
        View view = transitionValues.f53546b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            Map map = transitionValues.f53545a;
            map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            Matrix matrixR0 = z2 ? (Matrix) imageView.getTag(R.id.f53460g) : null;
            if (matrixR0 == null) {
                matrixR0 = r0(imageView);
            }
            map.put("android:changeImageTransform:matrix", matrixR0);
        }
    }

    private static Matrix q0(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = imageView.getWidth();
        float f3 = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = imageView.getHeight();
        float f4 = intrinsicHeight;
        float fMax = Math.max(width / f3, height / f4);
        int iRound = Math.round((width - (f3 * fMax)) / 2.0f);
        int iRound2 = Math.round((height - (f4 * fMax)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(fMax, fMax);
        matrix.postTranslate(iRound, iRound2);
        return matrix;
    }

    private static Matrix r0(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            return new Matrix(imageView.getImageMatrix());
        }
        int i3 = AnonymousClass3.f53379a[imageView.getScaleType().ordinal()];
        return i3 != 1 ? i3 != 2 ? new Matrix(imageView.getImageMatrix()) : q0(imageView) : u0(imageView);
    }

    private ObjectAnimator s0(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) T, new TransitionUtils.MatrixEvaluator(), matrix, matrix2);
    }

    private ObjectAnimator t0(ImageView imageView) {
        Property property = T;
        TypeEvaluator typeEvaluator = S;
        Matrix matrix = MatrixUtils.f53444a;
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) property, typeEvaluator, matrix, matrix);
    }

    private static Matrix u0(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(imageView.getWidth() / drawable.getIntrinsicWidth(), imageView.getHeight() / drawable.getIntrinsicHeight());
        return matrix;
    }

    @Override // androidx.transition.Transition
    public String[] K() {
        return R;
    }

    @Override // androidx.transition.Transition
    public void h(TransitionValues transitionValues) {
        p0(transitionValues, false);
    }

    @Override // androidx.transition.Transition
    public void k(TransitionValues transitionValues) {
        p0(transitionValues, true);
    }

    @Override // androidx.transition.Transition
    public Animator q(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.f53545a.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) transitionValues2.f53545a.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) transitionValues.f53545a.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) transitionValues2.f53545a.get("android:changeImageTransform:matrix");
        boolean z2 = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z2) {
            return null;
        }
        ImageView imageView = (ImageView) transitionValues2.f53546b;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return t0(imageView);
        }
        if (matrix == null) {
            matrix = MatrixUtils.f53444a;
        }
        if (matrix2 == null) {
            matrix2 = MatrixUtils.f53444a;
        }
        T.set(imageView, matrix);
        ObjectAnimator objectAnimatorS0 = s0(imageView, matrix, matrix2);
        Listener listener = new Listener(imageView, matrix, matrix2);
        objectAnimatorS0.addListener(listener);
        objectAnimatorS0.addPauseListener(listener);
        a(listener);
        return objectAnimatorS0;
    }
}
