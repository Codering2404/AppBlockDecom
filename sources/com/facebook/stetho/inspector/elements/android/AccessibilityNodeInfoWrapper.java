package com.facebook.stetho.inspector.elements.android;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.stetho.common.android.AccessibilityUtil;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AccessibilityNodeInfoWrapper {
    public static AccessibilityNodeInfoCompat createNodeInfoFromView(View view) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatV = AccessibilityNodeInfoCompat.V();
        ViewCompat.Z(view, accessibilityNodeInfoCompatV);
        return accessibilityNodeInfoCompatV;
    }

    public static String getActions(View view) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatCreateNodeInfoFromView = createNodeInfoFromView(view);
        try {
            StringBuilder sb = new StringBuilder();
            for (AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat : accessibilityNodeInfoCompatCreateNodeInfoFromView.g()) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                int iB = accessibilityActionCompat.b();
                if (iB == 1) {
                    sb.append("focus");
                } else if (iB != 2) {
                    switch (iB) {
                        case 4:
                            sb.append("select");
                            break;
                        case 8:
                            sb.append("clear-selection");
                            break;
                        case 16:
                            sb.append("click");
                            break;
                        case 32:
                            sb.append("long-click");
                            break;
                        case 64:
                            sb.append("accessibility-focus");
                            break;
                        case ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD /* 128 */:
                            sb.append("clear-accessibility-focus");
                            break;
                        case Function.MAX_NARGS /* 256 */:
                            sb.append("next-at-movement-granularity");
                            break;
                        case 512:
                            sb.append("previous-at-movement-granularity");
                            break;
                        case 1024:
                            sb.append("next-html-element");
                            break;
                        case 2048:
                            sb.append("previous-html-element");
                            break;
                        case 4096:
                            sb.append("scroll-forward");
                            break;
                        case Utility.DEFAULT_STREAM_BUFFER_SIZE /* 8192 */:
                            sb.append("scroll-backward");
                            break;
                        case 16384:
                            sb.append("copy");
                            break;
                        case 32768:
                            sb.append("paste");
                            break;
                        case NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST /* 65536 */:
                            sb.append("cut");
                            break;
                        case 131072:
                            sb.append("set-selection");
                            break;
                        default:
                            CharSequence charSequenceC = accessibilityActionCompat.c();
                            if (charSequenceC != null) {
                                sb.append(charSequenceC);
                            } else {
                                sb.append("unknown");
                            }
                            break;
                    }
                } else {
                    sb.append("clear-focus");
                }
            }
            String string = sb.length() > 0 ? sb.toString() : null;
            accessibilityNodeInfoCompatCreateNodeInfoFromView.Z();
            return string;
        } catch (Throwable th) {
            accessibilityNodeInfoCompatCreateNodeInfoFromView.Z();
            throw th;
        }
    }

    public static CharSequence getDescription(View view) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatCreateNodeInfoFromView = createNodeInfoFromView(view);
        try {
            CharSequence charSequenceR = accessibilityNodeInfoCompatCreateNodeInfoFromView.r();
            CharSequence charSequenceY = accessibilityNodeInfoCompatCreateNodeInfoFromView.y();
            boolean zIsEmpty = TextUtils.isEmpty(charSequenceY);
            boolean z2 = view instanceof EditText;
            if (!TextUtils.isEmpty(charSequenceR) && (!z2 || zIsEmpty)) {
                accessibilityNodeInfoCompatCreateNodeInfoFromView.Z();
                return charSequenceR;
            }
            if (!zIsEmpty) {
                accessibilityNodeInfoCompatCreateNodeInfoFromView.Z();
                return charSequenceY;
            }
            if (!(view instanceof ViewGroup)) {
                accessibilityNodeInfoCompatCreateNodeInfoFromView.Z();
                return null;
            }
            StringBuilder sb = new StringBuilder();
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                AccessibilityNodeInfoCompat accessibilityNodeInfoCompatV = AccessibilityNodeInfoCompat.V();
                ViewCompat.Z(childAt, accessibilityNodeInfoCompatV);
                CharSequence description = (!AccessibilityUtil.isSpeakingNode(accessibilityNodeInfoCompatV, childAt) || AccessibilityUtil.isAccessibilityFocusable(accessibilityNodeInfoCompatV, childAt)) ? null : getDescription(childAt);
                if (!TextUtils.isEmpty(description)) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(description);
                }
                accessibilityNodeInfoCompatV.Z();
            }
            String string = sb.length() > 0 ? sb.toString() : null;
            accessibilityNodeInfoCompatCreateNodeInfoFromView.Z();
            return string;
        } catch (Throwable th) {
            accessibilityNodeInfoCompatCreateNodeInfoFromView.Z();
            throw th;
        }
    }

    public static String getFocusableReasons(View view) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatCreateNodeInfoFromView = createNodeInfoFromView(view);
        try {
            boolean zHasText = AccessibilityUtil.hasText(accessibilityNodeInfoCompatCreateNodeInfoFromView);
            boolean zF = accessibilityNodeInfoCompatCreateNodeInfoFromView.F();
            boolean zHasNonActionableSpeakingDescendants = AccessibilityUtil.hasNonActionableSpeakingDescendants(accessibilityNodeInfoCompatCreateNodeInfoFromView, view);
            if (AccessibilityUtil.isActionableForAccessibility(accessibilityNodeInfoCompatCreateNodeInfoFromView)) {
                if (accessibilityNodeInfoCompatCreateNodeInfoFromView.n() <= 0) {
                    return "View is actionable and has no children.";
                }
                if (zHasText) {
                    return "View is actionable and has a description.";
                }
                if (zF) {
                    return "View is actionable and checkable.";
                }
                if (zHasNonActionableSpeakingDescendants) {
                    return "View is actionable and has non-actionable descendants with descriptions.";
                }
            }
            if (AccessibilityUtil.isTopLevelScrollItem(accessibilityNodeInfoCompatCreateNodeInfoFromView, view)) {
                if (zHasText) {
                    return "View is a direct child of a scrollable container and has a description.";
                }
                if (zF) {
                    return "View is a direct child of a scrollable container and is checkable.";
                }
                if (zHasNonActionableSpeakingDescendants) {
                    return "View is a direct child of a scrollable container and has non-actionable descendants with descriptions.";
                }
            }
            if (zHasText) {
                return "View has a description and is not actionable, but has no actionable ancestor.";
            }
            accessibilityNodeInfoCompatCreateNodeInfoFromView.Z();
            return null;
        } finally {
            accessibilityNodeInfoCompatCreateNodeInfoFromView.Z();
        }
    }

    public static boolean getIgnored(View view) {
        int iW = ViewCompat.w(view);
        if (iW == 2 || iW == 4) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (ViewCompat.w((View) parent) == 4) {
                return true;
            }
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatCreateNodeInfoFromView = createNodeInfoFromView(view);
        try {
            if (!accessibilityNodeInfoCompatCreateNodeInfoFromView.U()) {
                return true;
            }
            if (!AccessibilityUtil.isAccessibilityFocusable(accessibilityNodeInfoCompatCreateNodeInfoFromView, view)) {
                return AccessibilityUtil.hasFocusableAncestor(accessibilityNodeInfoCompatCreateNodeInfoFromView, view) || !AccessibilityUtil.hasText(accessibilityNodeInfoCompatCreateNodeInfoFromView);
            }
            if (accessibilityNodeInfoCompatCreateNodeInfoFromView.n() <= 0) {
                return false;
            }
            return !AccessibilityUtil.isSpeakingNode(accessibilityNodeInfoCompatCreateNodeInfoFromView, view);
        } finally {
            accessibilityNodeInfoCompatCreateNodeInfoFromView.Z();
        }
    }

    public static String getIgnoredReasons(View view) {
        int iW = ViewCompat.w(view);
        if (iW == 2) {
            return "View has importantForAccessibility set to 'NO'.";
        }
        if (iW == 4) {
            return "View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'.";
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (ViewCompat.w((View) parent) == 4) {
                return "An ancestor View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'.";
            }
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatCreateNodeInfoFromView = createNodeInfoFromView(view);
        try {
            return !accessibilityNodeInfoCompatCreateNodeInfoFromView.U() ? "View is not visible." : AccessibilityUtil.isAccessibilityFocusable(accessibilityNodeInfoCompatCreateNodeInfoFromView, view) ? "View is actionable, but has no description." : AccessibilityUtil.hasText(accessibilityNodeInfoCompatCreateNodeInfoFromView) ? "View is not actionable, and an ancestor View has co-opted its description." : "View is not actionable and has no description.";
        } finally {
            accessibilityNodeInfoCompatCreateNodeInfoFromView.Z();
        }
    }

    public static boolean getIsAccessibilityFocused(View view) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatCreateNodeInfoFromView = createNodeInfoFromView(view);
        boolean zE = accessibilityNodeInfoCompatCreateNodeInfoFromView.E();
        accessibilityNodeInfoCompatCreateNodeInfoFromView.Z();
        return zE;
    }
}
