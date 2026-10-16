package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Explode extends Visibility {
    private static final TimeInterpolator U = new DecelerateInterpolator();
    private static final TimeInterpolator V = new AccelerateInterpolator();
    private int[] T;

    private void p0(TransitionValues transitionValues) {
        View view = transitionValues.f53546b;
        view.getLocationOnScreen(this.T);
        int[] iArr = this.T;
        int i3 = iArr[0];
        int i4 = iArr[1];
        transitionValues.f53545a.put("android:explode:screenBounds", new Rect(i3, i4, view.getWidth() + i3, view.getHeight() + i4));
    }

    private static float w0(float f3, float f4) {
        return (float) Math.sqrt((f3 * f3) + (f4 * f4));
    }

    private static float x0(View view, int i3, int i4) {
        return w0(Math.max(i3, view.getWidth() - i3), Math.max(i4, view.getHeight() - i4));
    }

    private void y0(View view, Rect rect, int[] iArr) {
        int iCenterY;
        int width;
        view.getLocationOnScreen(this.T);
        int[] iArr2 = this.T;
        int i3 = iArr2[0];
        int i4 = iArr2[1];
        Rect rectU = u();
        if (rectU == null) {
            width = (view.getWidth() / 2) + i3 + Math.round(view.getTranslationX());
            iCenterY = (view.getHeight() / 2) + i4 + Math.round(view.getTranslationY());
        } else {
            int iCenterX = rectU.centerX();
            iCenterY = rectU.centerY();
            width = iCenterX;
        }
        float fCenterX = rect.centerX() - width;
        float fCenterY = rect.centerY() - iCenterY;
        if (fCenterX == 0.0f && fCenterY == 0.0f) {
            fCenterX = ((float) (Math.random() * 2.0d)) - 1.0f;
            fCenterY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float fW0 = w0(fCenterX, fCenterY);
        float fX0 = x0(view, width - i3, iCenterY - i4);
        iArr[0] = Math.round((fCenterX / fW0) * fX0);
        iArr[1] = Math.round(fX0 * (fCenterY / fW0));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void h(TransitionValues transitionValues) {
        super.h(transitionValues);
        p0(transitionValues);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void k(TransitionValues transitionValues) {
        super.k(transitionValues);
        p0(transitionValues);
    }

    @Override // androidx.transition.Visibility
    public Animator r0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.f53545a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        y0(viewGroup, rect, this.T);
        int[] iArr = this.T;
        return TranslationAnimationCreator.a(view, transitionValues2, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, U, this);
    }

    @Override // androidx.transition.Visibility
    public Animator t0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f3;
        float f4;
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.f53545a.get("android:explode:screenBounds");
        int i3 = rect.left;
        int i4 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.f53546b.getTag(R.id.f53462i);
        if (iArr != null) {
            f3 = (r7 - rect.left) + translationX;
            f4 = (r0 - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f3 = translationX;
            f4 = translationY;
        }
        y0(viewGroup, rect, this.T);
        int[] iArr2 = this.T;
        return TranslationAnimationCreator.a(view, transitionValues, i3, i4, translationX, translationY, f3 + iArr2[0], f4 + iArr2[1], V, this);
    }
}
