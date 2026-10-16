package androidx.fragment.app.strictmode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class FragmentStrictMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FragmentStrictMode f37492a = new FragmentStrictMode();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Policy f37493b = Policy.f37505e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_WRONG_NESTED_HIERARCHY,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface OnViolationListener {
        void a(Violation violation);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Policy {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Companion f37504d = new Companion(null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Policy f37505e = new Policy(SetsKt.emptySet(), null, MapsKt.emptyMap());

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set f37506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OnViolationListener f37507b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map f37508c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Builder {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public Policy(Set flags, OnViolationListener onViolationListener, Map allowedViolations) {
            Intrinsics.checkNotNullParameter(flags, "flags");
            Intrinsics.checkNotNullParameter(allowedViolations, "allowedViolations");
            this.f37506a = flags;
            this.f37507b = onViolationListener;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : allowedViolations.entrySet()) {
                linkedHashMap.put((String) entry.getKey(), (Set) entry.getValue());
            }
            this.f37508c = linkedHashMap;
        }

        public final Set a() {
            return this.f37506a;
        }

        public final OnViolationListener b() {
            return this.f37507b;
        }

        public final Map c() {
            return this.f37508c;
        }
    }

    private FragmentStrictMode() {
    }

    private final Policy c(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.K0() != null) {
                    Policy policyK0 = parentFragmentManager.K0();
                    Intrinsics.checkNotNull(policyK0);
                    return policyK0;
                }
            }
            fragment = fragment.getParentFragment();
        }
        return f37493b;
    }

    private final void d(final Policy policy, final Violation violation) {
        Fragment fragmentA = violation.a();
        final String name = fragmentA.getClass().getName();
        if (policy.a().contains(Flag.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in " + name, violation);
        }
        if (policy.b() != null) {
            r(fragmentA, new Runnable() { // from class: d.a
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentStrictMode.e(policy, violation);
                }
            });
        }
        if (policy.a().contains(Flag.PENALTY_DEATH)) {
            r(fragmentA, new Runnable() { // from class: d.b
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentStrictMode.f(name, violation);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Policy policy, Violation violation) {
        Intrinsics.checkNotNullParameter(policy, "$policy");
        Intrinsics.checkNotNullParameter(violation, "$violation");
        policy.b().a(violation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String str, Violation violation) {
        Intrinsics.checkNotNullParameter(violation, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    private final void g(Violation violation) {
        if (FragmentManager.R0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + violation.a().getClass().getName(), violation);
        }
    }

    public static final void h(Fragment fragment, String previousFragmentId) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(previousFragmentId, "previousFragmentId");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, previousFragmentId);
        FragmentStrictMode fragmentStrictMode = f37492a;
        fragmentStrictMode.g(fragmentReuseViolation);
        Policy policyC = fragmentStrictMode.c(fragment);
        if (policyC.a().contains(Flag.DETECT_FRAGMENT_REUSE) && fragmentStrictMode.s(policyC, fragment.getClass(), fragmentReuseViolation.getClass())) {
            fragmentStrictMode.d(policyC, fragmentReuseViolation);
        }
    }

    public static final void i(Fragment fragment, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = f37492a;
        fragmentStrictMode.g(fragmentTagUsageViolation);
        Policy policyC = fragmentStrictMode.c(fragment);
        if (policyC.a().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && fragmentStrictMode.s(policyC, fragment.getClass(), fragmentTagUsageViolation.getClass())) {
            fragmentStrictMode.d(policyC, fragmentTagUsageViolation);
        }
    }

    public static final void j(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        GetRetainInstanceUsageViolation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f37492a;
        fragmentStrictMode.g(getRetainInstanceUsageViolation);
        Policy policyC = fragmentStrictMode.c(fragment);
        if (policyC.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.s(policyC, fragment.getClass(), getRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.d(policyC, getRetainInstanceUsageViolation);
        }
    }

    public static final void k(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f37492a;
        fragmentStrictMode.g(getTargetFragmentRequestCodeUsageViolation);
        Policy policyC = fragmentStrictMode.c(fragment);
        if (policyC.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.s(policyC, fragment.getClass(), getTargetFragmentRequestCodeUsageViolation.getClass())) {
            fragmentStrictMode.d(policyC, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    public static final void l(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f37492a;
        fragmentStrictMode.g(getTargetFragmentUsageViolation);
        Policy policyC = fragmentStrictMode.c(fragment);
        if (policyC.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.s(policyC, fragment.getClass(), getTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.d(policyC, getTargetFragmentUsageViolation);
        }
    }

    public static final void m(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f37492a;
        fragmentStrictMode.g(setRetainInstanceUsageViolation);
        Policy policyC = fragmentStrictMode.c(fragment);
        if (policyC.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.s(policyC, fragment.getClass(), setRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.d(policyC, setRetainInstanceUsageViolation);
        }
    }

    public static final void n(Fragment violatingFragment, Fragment targetFragment, int i3) {
        Intrinsics.checkNotNullParameter(violatingFragment, "violatingFragment");
        Intrinsics.checkNotNullParameter(targetFragment, "targetFragment");
        SetTargetFragmentUsageViolation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(violatingFragment, targetFragment, i3);
        FragmentStrictMode fragmentStrictMode = f37492a;
        fragmentStrictMode.g(setTargetFragmentUsageViolation);
        Policy policyC = fragmentStrictMode.c(violatingFragment);
        if (policyC.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.s(policyC, violatingFragment.getClass(), setTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.d(policyC, setTargetFragmentUsageViolation);
        }
    }

    public static final void o(Fragment fragment, boolean z2) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, z2);
        FragmentStrictMode fragmentStrictMode = f37492a;
        fragmentStrictMode.g(setUserVisibleHintViolation);
        Policy policyC = fragmentStrictMode.c(fragment);
        if (policyC.a().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && fragmentStrictMode.s(policyC, fragment.getClass(), setUserVisibleHintViolation.getClass())) {
            fragmentStrictMode.d(policyC, setUserVisibleHintViolation);
        }
    }

    public static final void p(Fragment fragment, ViewGroup container) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(container, "container");
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, container);
        FragmentStrictMode fragmentStrictMode = f37492a;
        fragmentStrictMode.g(wrongFragmentContainerViolation);
        Policy policyC = fragmentStrictMode.c(fragment);
        if (policyC.a().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && fragmentStrictMode.s(policyC, fragment.getClass(), wrongFragmentContainerViolation.getClass())) {
            fragmentStrictMode.d(policyC, wrongFragmentContainerViolation);
        }
    }

    public static final void q(Fragment fragment, Fragment expectedParentFragment, int i3) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(expectedParentFragment, "expectedParentFragment");
        WrongNestedHierarchyViolation wrongNestedHierarchyViolation = new WrongNestedHierarchyViolation(fragment, expectedParentFragment, i3);
        FragmentStrictMode fragmentStrictMode = f37492a;
        fragmentStrictMode.g(wrongNestedHierarchyViolation);
        Policy policyC = fragmentStrictMode.c(fragment);
        if (policyC.a().contains(Flag.DETECT_WRONG_NESTED_HIERARCHY) && fragmentStrictMode.s(policyC, fragment.getClass(), wrongNestedHierarchyViolation.getClass())) {
            fragmentStrictMode.d(policyC, wrongNestedHierarchyViolation);
        }
    }

    private final void r(Fragment fragment, Runnable runnable) {
        if (!fragment.isAdded()) {
            runnable.run();
            return;
        }
        Handler handlerG = fragment.getParentFragmentManager().E0().g();
        Intrinsics.checkNotNullExpressionValue(handlerG, "fragment.parentFragmentManager.host.handler");
        if (Intrinsics.areEqual(handlerG.getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            handlerG.post(runnable);
        }
    }

    private final boolean s(Policy policy, Class cls, Class cls2) {
        Set set = (Set) policy.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (Intrinsics.areEqual(cls2.getSuperclass(), Violation.class) || !CollectionsKt.contains(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
