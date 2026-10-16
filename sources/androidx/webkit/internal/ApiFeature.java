package androidx.webkit.internal;

import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ApiFeature implements ConditionallySupportedFeature {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set f53917c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f53918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f53919b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class LAZY_HOLDER {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Set f53920a = new HashSet(Arrays.asList(WebViewGlueCommunicator.d().a()));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class M extends ApiFeature {
        M(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean c() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class N extends ApiFeature {
        N(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean c() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class NoFramework extends ApiFeature {
        NoFramework(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean c() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class O extends ApiFeature {
        O(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean c() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class O_MR1 extends ApiFeature {
        O_MR1(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean c() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class P extends ApiFeature {
        P(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean c() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Q extends ApiFeature {
        Q(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class T extends ApiFeature {
        T(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }

    ApiFeature(String str, String str2) {
        this.f53918a = str;
        this.f53919b = str2;
        f53917c.add(this);
    }

    public static Set e() {
        return Collections.unmodifiableSet(f53917c);
    }

    @Override // androidx.webkit.internal.ConditionallySupportedFeature
    public boolean a() {
        return c() || d();
    }

    @Override // androidx.webkit.internal.ConditionallySupportedFeature
    public String b() {
        return this.f53918a;
    }

    public abstract boolean c();

    public boolean d() {
        return BoundaryInterfaceReflectionUtil.b(LAZY_HOLDER.f53920a, this.f53919b);
    }
}
