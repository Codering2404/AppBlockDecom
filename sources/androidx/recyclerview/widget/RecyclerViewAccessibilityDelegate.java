package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final RecyclerView f51996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ItemDelegate f51997e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ItemDelegate extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final RecyclerViewAccessibilityDelegate f51998d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map f51999e = new WeakHashMap();

        public ItemDelegate(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            this.f51998d = recyclerViewAccessibilityDelegate;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f51999e.get(view);
            return accessibilityDelegateCompat != null ? accessibilityDelegateCompat.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public AccessibilityNodeProviderCompat b(View view) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f51999e.get(view);
            return accessibilityDelegateCompat != null ? accessibilityDelegateCompat.b(view) : super.b(view);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f51999e.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.f51998d.o() || this.f51998d.f51996d.getLayoutManager() == null) {
                super.g(view, accessibilityNodeInfoCompat);
                return;
            }
            this.f51998d.f51996d.getLayoutManager().T0(view, accessibilityNodeInfoCompat);
            AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f51999e.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.g(view, accessibilityNodeInfoCompat);
            } else {
                super.g(view, accessibilityNodeInfoCompat);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f51999e.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f51999e.get(viewGroup);
            return accessibilityDelegateCompat != null ? accessibilityDelegateCompat.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean j(View view, int i3, Bundle bundle) {
            if (this.f51998d.o() || this.f51998d.f51996d.getLayoutManager() == null) {
                return super.j(view, i3, bundle);
            }
            AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f51999e.get(view);
            if (accessibilityDelegateCompat != null) {
                if (accessibilityDelegateCompat.j(view, i3, bundle)) {
                    return true;
                }
            } else if (super.j(view, i3, bundle)) {
                return true;
            }
            return this.f51998d.f51996d.getLayoutManager().n1(view, i3, bundle);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void l(View view, int i3) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f51999e.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.l(view, i3);
            } else {
                super.l(view, i3);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void m(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f51999e.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        AccessibilityDelegateCompat n(View view) {
            return (AccessibilityDelegateCompat) this.f51999e.remove(view);
        }

        void o(View view) {
            AccessibilityDelegateCompat accessibilityDelegateCompatK = ViewCompat.k(view);
            if (accessibilityDelegateCompatK == null || accessibilityDelegateCompatK == this) {
                return;
            }
            this.f51999e.put(view, accessibilityDelegateCompatK);
        }
    }

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        this.f51996d = recyclerView;
        AccessibilityDelegateCompat accessibilityDelegateCompatN = n();
        if (accessibilityDelegateCompatN == null || !(accessibilityDelegateCompatN instanceof ItemDelegate)) {
            this.f51997e = new ItemDelegate(this);
        } else {
            this.f51997e = (ItemDelegate) accessibilityDelegateCompatN;
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().P0(accessibilityEvent);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.g(view, accessibilityNodeInfoCompat);
        if (o() || this.f51996d.getLayoutManager() == null) {
            return;
        }
        this.f51996d.getLayoutManager().R0(accessibilityNodeInfoCompat);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean j(View view, int i3, Bundle bundle) {
        if (super.j(view, i3, bundle)) {
            return true;
        }
        if (o() || this.f51996d.getLayoutManager() == null) {
            return false;
        }
        return this.f51996d.getLayoutManager().l1(i3, bundle);
    }

    public AccessibilityDelegateCompat n() {
        return this.f51997e;
    }

    boolean o() {
        return this.f51996d.v0();
    }
}
