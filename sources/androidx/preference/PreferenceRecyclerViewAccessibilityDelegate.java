package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class PreferenceRecyclerViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final RecyclerView f50947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final AccessibilityDelegateCompat f50948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AccessibilityDelegateCompat f50949h;

    public PreferenceRecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        super(recyclerView);
        this.f50948g = super.n();
        this.f50949h = new AccessibilityDelegateCompat() { // from class: androidx.preference.PreferenceRecyclerViewAccessibilityDelegate.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                Preference preferenceJ;
                PreferenceRecyclerViewAccessibilityDelegate.this.f50948g.g(view, accessibilityNodeInfoCompat);
                int iK0 = PreferenceRecyclerViewAccessibilityDelegate.this.f50947f.k0(view);
                RecyclerView.Adapter adapter = PreferenceRecyclerViewAccessibilityDelegate.this.f50947f.getAdapter();
                if ((adapter instanceof PreferenceGroupAdapter) && (preferenceJ = ((PreferenceGroupAdapter) adapter).j(iK0)) != null) {
                    preferenceJ.V(accessibilityNodeInfoCompat);
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean j(View view, int i3, Bundle bundle) {
                return PreferenceRecyclerViewAccessibilityDelegate.this.f50948g.j(view, i3, bundle);
            }
        };
        this.f50947f = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
    public AccessibilityDelegateCompat n() {
        return this.f50949h;
    }
}
