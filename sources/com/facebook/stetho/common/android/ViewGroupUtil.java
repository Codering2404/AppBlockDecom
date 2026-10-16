package com.facebook.stetho.common.android;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ViewGroupUtil {
    private ViewGroupUtil() {
    }

    public static int findChildIndex(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (viewGroup.getChildAt(i3) == view) {
                return i3;
            }
        }
        return -1;
    }
}
