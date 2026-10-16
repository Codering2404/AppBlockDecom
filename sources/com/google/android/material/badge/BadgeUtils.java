package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.internal.ToolbarUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class BadgeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f80041a = false;

    /* JADX INFO: renamed from: com.google.android.material.badge.BadgeUtils$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Toolbar f80042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f80043b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BadgeDrawable f80044c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameLayout f80045d;

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuItemView actionMenuItemViewA = ToolbarUtils.a(this.f80042a, this.f80043b);
            if (actionMenuItemViewA != null) {
                BadgeUtils.h(this.f80044c, this.f80042a.getResources());
                BadgeUtils.c(this.f80044c, actionMenuItemViewA, this.f80045d);
                BadgeUtils.b(this.f80044c, actionMenuItemViewA);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.badge.BadgeUtils$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass4 extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.g(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.m0(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final BadgeDrawable badgeDrawable, View view) {
        if (Build.VERSION.SDK_INT < 29 || !ViewCompat.M(view)) {
            ViewCompat.m0(view, new AccessibilityDelegateCompat() { // from class: com.google.android.material.badge.BadgeUtils.3
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void g(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.g(view2, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.m0(badgeDrawable.i());
                }
            });
        } else {
            ViewCompat.m0(view, new AccessibilityDelegateCompat(view.getAccessibilityDelegate()) { // from class: com.google.android.material.badge.BadgeUtils.2
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void g(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.g(view2, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.m0(badgeDrawable.i());
                }
            });
        }
    }

    public static void c(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        g(badgeDrawable, view, frameLayout);
        if (badgeDrawable.j() != null) {
            badgeDrawable.j().setForeground(badgeDrawable);
        } else {
            if (f80041a) {
                throw new IllegalArgumentException("Trying to reference null customBadgeParent");
            }
            view.getOverlay().add(badgeDrawable);
        }
    }

    public static SparseArray d(Context context, ParcelableSparseArray parcelableSparseArray) {
        SparseArray sparseArray = new SparseArray(parcelableSparseArray.size());
        for (int i3 = 0; i3 < parcelableSparseArray.size(); i3++) {
            int iKeyAt = parcelableSparseArray.keyAt(i3);
            BadgeState.State state = (BadgeState.State) parcelableSparseArray.valueAt(i3);
            sparseArray.put(iKeyAt, state != null ? BadgeDrawable.e(context, state) : null);
        }
        return sparseArray;
    }

    public static ParcelableSparseArray e(SparseArray sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            int iKeyAt = sparseArray.keyAt(i3);
            BadgeDrawable badgeDrawable = (BadgeDrawable) sparseArray.valueAt(i3);
            parcelableSparseArray.put(iKeyAt, badgeDrawable != null ? badgeDrawable.t() : null);
        }
        return parcelableSparseArray;
    }

    public static void f(BadgeDrawable badgeDrawable, View view) {
        if (badgeDrawable == null) {
            return;
        }
        if (f80041a || badgeDrawable.j() != null) {
            badgeDrawable.j().setForeground(null);
        } else {
            view.getOverlay().remove(badgeDrawable);
        }
    }

    public static void g(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.S(view, frameLayout);
    }

    static void h(BadgeDrawable badgeDrawable, Resources resources) {
        badgeDrawable.O(resources.getDimensionPixelOffset(R.dimen.f79571i0));
        badgeDrawable.P(resources.getDimensionPixelOffset(R.dimen.f79573j0));
    }

    public static void i(Rect rect, float f3, float f4, float f5, float f6) {
        rect.set((int) (f3 - f5), (int) (f4 - f6), (int) (f3 + f5), (int) (f4 + f6));
    }
}
