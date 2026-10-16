package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AccessibilityClickableSpanCompat extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f34560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AccessibilityNodeInfoCompat f34561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f34562c;

    public AccessibilityClickableSpanCompat(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int i4) {
        this.f34560a = i3;
        this.f34561b = accessibilityNodeInfoCompat;
        this.f34562c = i4;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f34560a);
        this.f34561b.Y(this.f34562c, bundle);
    }
}
