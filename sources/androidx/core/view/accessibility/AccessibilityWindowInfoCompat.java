package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.os.LocaleList;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.core.os.LocaleListCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class AccessibilityWindowInfoCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f34601a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api21Impl {
        static void a(AccessibilityWindowInfo accessibilityWindowInfo, Rect rect) {
            accessibilityWindowInfo.getBoundsInScreen(rect);
        }

        static int b(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getChildCount();
        }

        static int c(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getId();
        }

        static int d(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLayer();
        }

        static AccessibilityWindowInfo e(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getParent();
        }

        static int f(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getType();
        }

        static boolean g(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isActive();
        }

        static boolean h(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isFocused();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api24Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api26Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api30Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api33Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api34Impl {
        static LocaleList a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLocales();
        }

        public static long b(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getTransitionTimeMillis();
        }
    }

    private AccessibilityWindowInfoCompat(Object obj) {
        this.f34601a = obj;
    }

    private static String k(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? "<UNKNOWN>" : "TYPE_ACCESSIBILITY_OVERLAY" : "TYPE_SYSTEM" : "TYPE_INPUT_METHOD" : "TYPE_APPLICATION";
    }

    static AccessibilityWindowInfoCompat l(Object obj) {
        if (obj != null) {
            return new AccessibilityWindowInfoCompat(obj);
        }
        return null;
    }

    public void a(Rect rect) {
        Api21Impl.a((AccessibilityWindowInfo) this.f34601a, rect);
    }

    public int b() {
        return Api21Impl.b((AccessibilityWindowInfo) this.f34601a);
    }

    public int c() {
        return Api21Impl.c((AccessibilityWindowInfo) this.f34601a);
    }

    public int d() {
        return Api21Impl.d((AccessibilityWindowInfo) this.f34601a);
    }

    public LocaleListCompat e() {
        return Build.VERSION.SDK_INT >= 34 ? LocaleListCompat.k(Api34Impl.a((AccessibilityWindowInfo) this.f34601a)) : LocaleListCompat.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityWindowInfoCompat)) {
            return false;
        }
        AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (AccessibilityWindowInfoCompat) obj;
        Object obj2 = this.f34601a;
        return obj2 == null ? accessibilityWindowInfoCompat.f34601a == null : obj2.equals(accessibilityWindowInfoCompat.f34601a);
    }

    public AccessibilityWindowInfoCompat f() {
        return l(Api21Impl.e((AccessibilityWindowInfo) this.f34601a));
    }

    public long g() {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.b((AccessibilityWindowInfo) this.f34601a);
        }
        return 0L;
    }

    public int h() {
        return Api21Impl.f((AccessibilityWindowInfo) this.f34601a);
    }

    public int hashCode() {
        Object obj = this.f34601a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean i() {
        return Api21Impl.g((AccessibilityWindowInfo) this.f34601a);
    }

    public boolean j() {
        return Api21Impl.h((AccessibilityWindowInfo) this.f34601a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Rect rect = new Rect();
        a(rect);
        sb.append("AccessibilityWindowInfo[");
        sb.append("id=");
        sb.append(c());
        sb.append(", type=");
        sb.append(k(h()));
        sb.append(", layer=");
        sb.append(d());
        sb.append(", bounds=");
        sb.append(rect);
        sb.append(", focused=");
        sb.append(j());
        sb.append(", active=");
        sb.append(i());
        sb.append(", hasParent=");
        sb.append(f() != null);
        sb.append(", hasChildren=");
        sb.append(b() > 0);
        sb.append(", transitionTime=");
        sb.append(g());
        sb.append(", locales=");
        sb.append(e());
        sb.append(']');
        return sb.toString();
    }
}
