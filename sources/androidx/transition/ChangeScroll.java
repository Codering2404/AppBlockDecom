package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ChangeScroll extends Transition {
    private static final String[] R = {"android:changeScroll:x", "android:changeScroll:y"};

    private void p0(TransitionValues transitionValues) {
        transitionValues.f53545a.put("android:changeScroll:x", Integer.valueOf(transitionValues.f53546b.getScrollX()));
        transitionValues.f53545a.put("android:changeScroll:y", Integer.valueOf(transitionValues.f53546b.getScrollY()));
    }

    @Override // androidx.transition.Transition
    public String[] K() {
        return R;
    }

    @Override // androidx.transition.Transition
    public void h(TransitionValues transitionValues) {
        p0(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void k(TransitionValues transitionValues) {
        p0(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator q(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ObjectAnimator objectAnimatorOfInt;
        ObjectAnimator objectAnimatorOfInt2 = null;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        View view = transitionValues2.f53546b;
        int iIntValue = ((Integer) transitionValues.f53545a.get("android:changeScroll:x")).intValue();
        int iIntValue2 = ((Integer) transitionValues2.f53545a.get("android:changeScroll:x")).intValue();
        int iIntValue3 = ((Integer) transitionValues.f53545a.get("android:changeScroll:y")).intValue();
        int iIntValue4 = ((Integer) transitionValues2.f53545a.get("android:changeScroll:y")).intValue();
        if (iIntValue != iIntValue2) {
            view.setScrollX(iIntValue);
            objectAnimatorOfInt = ObjectAnimator.ofInt(view, "scrollX", iIntValue, iIntValue2);
        } else {
            objectAnimatorOfInt = null;
        }
        if (iIntValue3 != iIntValue4) {
            view.setScrollY(iIntValue3);
            objectAnimatorOfInt2 = ObjectAnimator.ofInt(view, "scrollY", iIntValue3, iIntValue4);
        }
        return TransitionUtils.c(objectAnimatorOfInt, objectAnimatorOfInt2);
    }
}
