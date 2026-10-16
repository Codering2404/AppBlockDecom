package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class GravityCompat {
    public static void a(int i3, int i4, int i5, Rect rect, Rect rect2, int i6) {
        Gravity.apply(i3, i4, i5, rect, rect2, i6);
    }

    public static int b(int i3, int i4) {
        return Gravity.getAbsoluteGravity(i3, i4);
    }
}
