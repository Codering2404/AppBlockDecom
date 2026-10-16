package com.facebook.stetho.common.android;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.Spinner;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.internal.Utility;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AccessibilityUtil {
    private AccessibilityUtil() {
    }

    public static boolean hasFocusableAncestor(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        if (accessibilityNodeInfoCompat == null || view == null) {
            return false;
        }
        Object objE = ViewCompat.E(view);
        if (!(objE instanceof View)) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatV = AccessibilityNodeInfoCompat.V();
        try {
            ViewCompat.Z((View) objE, accessibilityNodeInfoCompatV);
            if (accessibilityNodeInfoCompatV == null) {
                return false;
            }
            if (isAccessibilityFocusable(accessibilityNodeInfoCompatV, (View) objE)) {
                return true;
            }
            return hasFocusableAncestor(accessibilityNodeInfoCompatV, (View) objE);
        } finally {
            accessibilityNodeInfoCompatV.Z();
        }
    }

    public static boolean hasNonActionableSpeakingDescendants(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        if (accessibilityNodeInfoCompat != null && view != null && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != null) {
                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompatV = AccessibilityNodeInfoCompat.V();
                    try {
                        ViewCompat.Z(childAt, accessibilityNodeInfoCompatV);
                        if (!isAccessibilityFocusable(accessibilityNodeInfoCompatV, childAt) && isSpeakingNode(accessibilityNodeInfoCompatV, childAt)) {
                            accessibilityNodeInfoCompatV.Z();
                            return true;
                        }
                    } finally {
                        accessibilityNodeInfoCompatV.Z();
                    }
                }
            }
        }
        return false;
    }

    public static boolean hasText(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (accessibilityNodeInfoCompat == null) {
            return false;
        }
        return (TextUtils.isEmpty(accessibilityNodeInfoCompat.y()) && TextUtils.isEmpty(accessibilityNodeInfoCompat.r())) ? false : true;
    }

    public static boolean isAccessibilityFocusable(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        if (accessibilityNodeInfoCompat == null || view == null || !accessibilityNodeInfoCompat.U()) {
            return false;
        }
        if (isActionableForAccessibility(accessibilityNodeInfoCompat)) {
            return true;
        }
        return isTopLevelScrollItem(accessibilityNodeInfoCompat, view) && isSpeakingNode(accessibilityNodeInfoCompat, view);
    }

    public static boolean isActionableForAccessibility(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (accessibilityNodeInfoCompat == null) {
            return false;
        }
        if (!accessibilityNodeInfoCompat.H() && !accessibilityNodeInfoCompat.O() && !accessibilityNodeInfoCompat.K()) {
            List listG = accessibilityNodeInfoCompat.g();
            if (!listG.contains(16) && !listG.contains(32) && !listG.contains(1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSpeakingNode(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        int iW;
        if (accessibilityNodeInfoCompat == null || view == null || !accessibilityNodeInfoCompat.U() || (iW = ViewCompat.w(view)) == 4 || (iW == 2 && accessibilityNodeInfoCompat.n() <= 0)) {
            return false;
        }
        return accessibilityNodeInfoCompat.F() || hasText(accessibilityNodeInfoCompat) || hasNonActionableSpeakingDescendants(accessibilityNodeInfoCompat, view);
    }

    public static boolean isTopLevelScrollItem(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        View view2;
        if (accessibilityNodeInfoCompat == null || view == null || (view2 = (View) ViewCompat.E(view)) == null) {
            return false;
        }
        if (accessibilityNodeInfoCompat.Q()) {
            return true;
        }
        List listG = accessibilityNodeInfoCompat.g();
        if (!listG.contains(4096) && !listG.contains(Integer.valueOf(Utility.DEFAULT_STREAM_BUFFER_SIZE))) {
            if (view2 instanceof Spinner) {
                return false;
            }
            if (!(view2 instanceof AdapterView) && !(view2 instanceof ScrollView) && !(view2 instanceof HorizontalScrollView)) {
                return false;
            }
        }
        return true;
    }
}
