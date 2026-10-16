package androidx.transition;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class VisibilityPropagation extends TransitionPropagation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f53594a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    private static int d(TransitionValues transitionValues, int i3) {
        int[] iArr;
        if (transitionValues == null || (iArr = (int[]) transitionValues.f53545a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i3];
    }

    @Override // androidx.transition.TransitionPropagation
    public void a(TransitionValues transitionValues) {
        View view = transitionValues.f53546b;
        Integer numValueOf = (Integer) transitionValues.f53545a.get("android:visibility:visibility");
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(view.getVisibility());
        }
        transitionValues.f53545a.put("android:visibilityPropagation:visibility", numValueOf);
        int[] iArr = {iRound, 0};
        view.getLocationOnScreen(iArr);
        int iRound = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = iRound + (view.getWidth() / 2);
        int iRound2 = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iRound2;
        iArr[1] = iRound2 + (view.getHeight() / 2);
        transitionValues.f53545a.put("android:visibilityPropagation:center", iArr);
    }

    @Override // androidx.transition.TransitionPropagation
    public String[] b() {
        return f53594a;
    }

    public int e(TransitionValues transitionValues) {
        Integer num;
        if (transitionValues == null || (num = (Integer) transitionValues.f53545a.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int f(TransitionValues transitionValues) {
        return d(transitionValues, 0);
    }

    public int g(TransitionValues transitionValues) {
        return d(transitionValues, 1);
    }
}
