package androidx.core.view;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class MarginLayoutParamsCompat {
    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginEnd();
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginStart();
    }

    public static void c(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.setMarginEnd(i3);
    }

    public static void d(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.setMarginStart(i3);
    }
}
