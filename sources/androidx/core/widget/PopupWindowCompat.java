package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PopupWindowCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api23Impl {
        static void a(PopupWindow popupWindow, boolean z2) {
            popupWindow.setOverlapAnchor(z2);
        }

        static void b(PopupWindow popupWindow, int i3) {
            popupWindow.setWindowLayoutType(i3);
        }
    }

    public static void a(PopupWindow popupWindow, boolean z2) {
        Api23Impl.a(popupWindow, z2);
    }

    public static void b(PopupWindow popupWindow, int i3) {
        Api23Impl.b(popupWindow, i3);
    }

    public static void c(PopupWindow popupWindow, View view, int i3, int i4, int i5) {
        popupWindow.showAsDropDown(view, i3, i4, i5);
    }
}
