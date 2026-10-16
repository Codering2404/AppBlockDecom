package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class QC extends AccessibilityNodeProvider {
    public final /* synthetic */ QD A00;

    public QC(QD qd) {
        this.A00 = qd;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i3) {
        return (AccessibilityNodeInfo) this.A00.A5G(i3);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i3) {
        return this.A00.A6Y(str, i3);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i3) {
        return (AccessibilityNodeInfo) this.A00.A6Z(i3);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i3, int i4, Bundle bundle) {
        return this.A00.AGv(i3, i4, bundle);
    }
}
