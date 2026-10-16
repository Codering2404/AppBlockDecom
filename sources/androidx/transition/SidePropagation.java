package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SidePropagation extends VisibilityPropagation {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f53467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f53468c;

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int h(android.view.View r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14) {
        /*
            r5 = this;
            int r0 = r5.f53468c
            r1 = 8388611(0x800003, float:1.1754948E-38)
            r2 = 1
            r3 = 3
            r4 = 5
            if (r0 != r1) goto L14
            int r6 = r6.getLayoutDirection()
            if (r6 != r2) goto L12
        L10:
            r0 = r4
            goto L20
        L12:
            r0 = r3
            goto L20
        L14:
            r1 = 8388613(0x800005, float:1.175495E-38)
            if (r0 != r1) goto L20
            int r6 = r6.getLayoutDirection()
            if (r6 != r2) goto L10
            goto L12
        L20:
            if (r0 == r3) goto L46
            if (r0 == r4) goto L3e
            r6 = 48
            if (r0 == r6) goto L36
            r6 = 80
            if (r0 == r6) goto L2e
            r6 = 0
            return r6
        L2e:
            int r8 = r8 - r12
            int r9 = r9 - r7
            int r6 = java.lang.Math.abs(r9)
            int r8 = r8 + r6
            return r8
        L36:
            int r14 = r14 - r8
            int r9 = r9 - r7
            int r6 = java.lang.Math.abs(r9)
            int r14 = r14 + r6
            return r14
        L3e:
            int r7 = r7 - r11
            int r10 = r10 - r8
            int r6 = java.lang.Math.abs(r10)
            int r7 = r7 + r6
            return r7
        L46:
            int r13 = r13 - r7
            int r10 = r10 - r8
            int r6 = java.lang.Math.abs(r10)
            int r13 = r13 + r6
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.SidePropagation.h(android.view.View, int, int, int, int, int, int, int, int):int");
    }

    private int i(ViewGroup viewGroup) {
        int i3 = this.f53468c;
        return (i3 == 3 || i3 == 5 || i3 == 8388611 || i3 == 8388613) ? viewGroup.getWidth() : viewGroup.getHeight();
    }

    @Override // androidx.transition.TransitionPropagation
    public long c(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i3;
        int i4;
        int iCenterY;
        int i5;
        ViewGroup viewGroup2;
        int i6;
        TransitionValues transitionValues3 = transitionValues;
        if (transitionValues3 == null && transitionValues2 == null) {
            return 0L;
        }
        Rect rectU = transition.u();
        if (transitionValues2 == null || e(transitionValues3) == 0) {
            i3 = -1;
        } else {
            transitionValues3 = transitionValues2;
            i3 = 1;
        }
        int iF = f(transitionValues3);
        int iG = g(transitionValues3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int iRound = iArr[0] + Math.round(viewGroup.getTranslationX());
        int iRound2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = viewGroup.getWidth() + iRound;
        int height = viewGroup.getHeight() + iRound2;
        if (rectU != null) {
            int iCenterX = rectU.centerX();
            i5 = iG;
            viewGroup2 = viewGroup;
            i6 = iRound2;
            iCenterY = rectU.centerY();
            i4 = iCenterX;
        } else {
            i4 = (iRound + width) / 2;
            iCenterY = (iRound2 + height) / 2;
            i5 = iG;
            viewGroup2 = viewGroup;
            i6 = iRound2;
        }
        float fH = h(viewGroup2, iF, i5, i4, iCenterY, iRound, i6, width, height) / i(viewGroup);
        long jT = transition.t();
        if (jT < 0) {
            jT = 300;
        }
        return Math.round(((jT * ((long) i3)) / this.f53467b) * fH);
    }
}
