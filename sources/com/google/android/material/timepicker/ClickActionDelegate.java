package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class ClickActionDelegate extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AccessibilityNodeInfoCompat.AccessibilityActionCompat f82411d;

    public ClickActionDelegate(Context context, int i3) {
        this.f82411d = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, context.getString(i3));
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.g(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.b(this.f82411d);
    }
}
