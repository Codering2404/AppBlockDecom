package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class AnimateLayoutChangeDetector {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f53823b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinearLayoutManager f53824a;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f53823b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    AnimateLayoutChangeDetector(LinearLayoutManager linearLayoutManager) {
        this.f53824a = linearLayoutManager;
    }

    private boolean a() {
        int top;
        int i3;
        int bottom;
        int i4;
        int iP = this.f53824a.P();
        if (iP == 0) {
            return true;
        }
        boolean z2 = this.f53824a.q2() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iP, 2);
        for (int i5 = 0; i5 < iP; i5++) {
            View viewO = this.f53824a.O(i5);
            if (viewO == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = viewO.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f53823b;
            int[] iArr2 = iArr[i5];
            if (z2) {
                top = viewO.getLeft();
                i3 = marginLayoutParams.leftMargin;
            } else {
                top = viewO.getTop();
                i3 = marginLayoutParams.topMargin;
            }
            iArr2[0] = top - i3;
            int[] iArr3 = iArr[i5];
            if (z2) {
                bottom = viewO.getRight();
                i4 = marginLayoutParams.rightMargin;
            } else {
                bottom = viewO.getBottom();
                i4 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i4;
        }
        Arrays.sort(iArr, new Comparator<int[]>() { // from class: androidx.viewpager2.widget.AnimateLayoutChangeDetector.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(int[] iArr4, int[] iArr5) {
                return iArr4[0] - iArr5[0];
            }
        });
        for (int i6 = 1; i6 < iP; i6++) {
            if (iArr[i6 - 1][1] != iArr[i6][0]) {
                return false;
            }
        }
        int[] iArr4 = iArr[0];
        int i7 = iArr4[1];
        int i8 = iArr4[0];
        return i8 <= 0 && iArr[iP - 1][1] >= i7 - i8;
    }

    private boolean b() {
        int iP = this.f53824a.P();
        for (int i3 = 0; i3 < iP; i3++) {
            if (c(this.f53824a.O(i3))) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (c(viewGroup.getChildAt(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean d() {
        return (!a() || this.f53824a.P() <= 1) && b();
    }
}
