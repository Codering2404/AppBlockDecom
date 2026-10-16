package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CircularPropagation extends VisibilityPropagation {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f53407b;

    private static float h(float f3, float f4, float f5, float f6) {
        float f7 = f5 - f3;
        float f8 = f6 - f4;
        return (float) Math.sqrt((f7 * f7) + (f8 * f8));
    }

    @Override // androidx.transition.TransitionPropagation
    public long c(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i3;
        int iRound;
        int iCenterX;
        if (transitionValues == null && transitionValues2 == null) {
            return 0L;
        }
        if (transitionValues2 == null || e(transitionValues) == 0) {
            i3 = -1;
        } else {
            transitionValues = transitionValues2;
            i3 = 1;
        }
        int iF = f(transitionValues);
        int iG = g(transitionValues);
        Rect rectU = transition.u();
        if (rectU != null) {
            iCenterX = rectU.centerX();
            iRound = rectU.centerY();
        } else {
            viewGroup.getLocationOnScreen(new int[2]);
            int iRound2 = Math.round(r5[0] + (viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
            iRound = Math.round(r5[1] + (viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
            iCenterX = iRound2;
        }
        float fH = h(iF, iG, iCenterX, iRound) / h(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long jT = transition.t();
        if (jT < 0) {
            jT = 300;
        }
        return Math.round(((jT * ((long) i3)) / this.f53407b) * fH);
    }
}
