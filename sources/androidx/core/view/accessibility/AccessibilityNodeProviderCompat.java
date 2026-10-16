package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class AccessibilityNodeProviderCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f34597a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AccessibilityNodeProviderCompat f34598a;

        AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            this.f34598a = accessibilityNodeProviderCompat;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i3) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatB = this.f34598a.b(i3);
            if (accessibilityNodeInfoCompatB == null) {
                return null;
            }
            return accessibilityNodeInfoCompatB.Y0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List findAccessibilityNodeInfosByText(String str, int i3) {
            List listC = this.f34598a.c(str, i3);
            if (listC == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listC.size();
            for (int i4 = 0; i4 < size; i4++) {
                arrayList.add(((AccessibilityNodeInfoCompat) listC.get(i4)).Y0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i3) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatD = this.f34598a.d(i3);
            if (accessibilityNodeInfoCompatD == null) {
                return null;
            }
            return accessibilityNodeInfoCompatD.Y0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i3, int i4, Bundle bundle) {
            return this.f34598a.f(i3, i4, bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderApi19 {
        AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i3, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f34598a.a(i3, AccessibilityNodeInfoCompat.Z0(accessibilityNodeInfo), str, bundle);
        }
    }

    public AccessibilityNodeProviderCompat() {
        this.f34597a = new AccessibilityNodeProviderApi26(this);
    }

    public AccessibilityNodeInfoCompat b(int i3) {
        return null;
    }

    public List c(String str, int i3) {
        return null;
    }

    public AccessibilityNodeInfoCompat d(int i3) {
        return null;
    }

    public Object e() {
        return this.f34597a;
    }

    public boolean f(int i3, int i4, Bundle bundle) {
        return false;
    }

    public AccessibilityNodeProviderCompat(Object obj) {
        this.f34597a = obj;
    }

    public void a(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
    }
}
