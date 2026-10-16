package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final View.AccessibilityDelegate f34376c = new View.AccessibilityDelegate();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View.AccessibilityDelegate f34377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View.AccessibilityDelegate f34378b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AccessibilityDelegateAdapter extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AccessibilityDelegateCompat f34379a;

        AccessibilityDelegateAdapter(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            this.f34379a = accessibilityDelegateCompat;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f34379a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            AccessibilityNodeProviderCompat accessibilityNodeProviderCompatB = this.f34379a.b(view);
            if (accessibilityNodeProviderCompatB != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProviderCompatB.e();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f34379a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatZ0 = AccessibilityNodeInfoCompat.Z0(accessibilityNodeInfo);
            accessibilityNodeInfoCompatZ0.J0(ViewCompat.U(view));
            accessibilityNodeInfoCompatZ0.u0(ViewCompat.P(view));
            accessibilityNodeInfoCompatZ0.D0(ViewCompat.n(view));
            accessibilityNodeInfoCompatZ0.P0(ViewCompat.G(view));
            this.f34379a.g(view, accessibilityNodeInfoCompatZ0);
            accessibilityNodeInfoCompatZ0.e(accessibilityNodeInfo.getText(), view);
            List listC = AccessibilityDelegateCompat.c(view);
            for (int i3 = 0; i3 < listC.size(); i3++) {
                accessibilityNodeInfoCompatZ0.b((AccessibilityNodeInfoCompat.AccessibilityActionCompat) listC.get(i3));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f34379a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f34379a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            return this.f34379a.j(view, i3, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i3) {
            this.f34379a.l(view, i3);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f34379a.m(view, accessibilityEvent);
        }
    }

    public AccessibilityDelegateCompat() {
        this(f34376c);
    }

    static List c(View view) {
        List list = (List) view.getTag(R.id.H);
        return list == null ? Collections.EMPTY_LIST : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrP = AccessibilityNodeInfoCompat.p(view.createAccessibilityNodeInfo().getText());
            for (int i3 = 0; clickableSpanArrP != null && i3 < clickableSpanArrP.length; i3++) {
                if (clickableSpan.equals(clickableSpanArrP[i3])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean k(int i3, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.I);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i3)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f34377a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public AccessibilityNodeProviderCompat b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f34377a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return null;
    }

    View.AccessibilityDelegate d() {
        return this.f34378b;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f34377a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.f34377a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.Y0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f34377a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f34377a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i3, Bundle bundle) {
        List listC = c(view);
        boolean zPerformAccessibilityAction = false;
        int i4 = 0;
        while (true) {
            if (i4 >= listC.size()) {
                break;
            }
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = (AccessibilityNodeInfoCompat.AccessibilityActionCompat) listC.get(i4);
            if (accessibilityActionCompat.b() == i3) {
                zPerformAccessibilityAction = accessibilityActionCompat.d(view, bundle);
                break;
            }
            i4++;
        }
        if (!zPerformAccessibilityAction) {
            zPerformAccessibilityAction = this.f34377a.performAccessibilityAction(view, i3, bundle);
        }
        return (zPerformAccessibilityAction || i3 != R.id.f33497a || bundle == null) ? zPerformAccessibilityAction : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(View view, int i3) {
        this.f34377a.sendAccessibilityEvent(view, i3);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f34377a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public AccessibilityDelegateCompat(View.AccessibilityDelegate accessibilityDelegate) {
        this.f34377a = accessibilityDelegate;
        this.f34378b = new AccessibilityDelegateAdapter(this);
    }
}
