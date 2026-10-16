package androidx.viewbinding;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ViewBindings {
    public static View a(View view, int i3) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View viewFindViewById = viewGroup.getChildAt(i4).findViewById(i3);
            if (viewFindViewById != null) {
                return viewFindViewById;
            }
        }
        return null;
    }
}
