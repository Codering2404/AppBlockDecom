package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.preference.PreferenceFragmentCompat;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import kotlin.Metadata;
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
public abstract class PreferenceHeaderFragmentCompat extends Fragment implements PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OnBackPressedCallback f50928a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class InnerOnBackPressedCallback extends OnBackPressedCallback implements SlidingPaneLayout.PanelSlideListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PreferenceHeaderFragmentCompat f50929a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InnerOnBackPressedCallback(PreferenceHeaderFragmentCompat caller) {
            super(true);
            Intrinsics.checkNotNullParameter(caller, "caller");
            this.f50929a = caller;
            caller.z().a(this);
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void a(View panel) {
            Intrinsics.checkNotNullParameter(panel, "panel");
            setEnabled(true);
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void b(View panel) {
            Intrinsics.checkNotNullParameter(panel, "panel");
            setEnabled(false);
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void c(View panel, float f3) {
            Intrinsics.checkNotNullParameter(panel, "panel");
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            this.f50929a.z().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(PreferenceHeaderFragmentCompat this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnBackPressedCallback onBackPressedCallback = this$0.f50928a;
        Intrinsics.checkNotNull(onBackPressedCallback);
        onBackPressedCallback.setEnabled(this$0.getChildFragmentManager().w0() == 0);
    }

    private final void D(Intent intent) {
        if (intent == null) {
            return;
        }
        startActivity(intent);
    }

    private final void E(Preference preference) {
        if (preference.k() == null) {
            D(preference.n());
            return;
        }
        String strK = preference.k();
        Fragment fragmentA = strK == null ? null : getChildFragmentManager().B0().a(requireContext().getClassLoader(), strK);
        if (fragmentA != null) {
            fragmentA.setArguments(preference.i());
        }
        if (getChildFragmentManager().w0() > 0) {
            FragmentManager.BackStackEntry backStackEntryV0 = getChildFragmentManager().v0(0);
            Intrinsics.checkNotNullExpressionValue(backStackEntryV0, "childFragmentManager.getBackStackEntryAt(0)");
            getChildFragmentManager().g1(backStackEntryV0.getId(), 1);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionQ = childFragmentManager.q();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionQ, "beginTransaction()");
        fragmentTransactionQ.x(true);
        int i3 = R.id.f50973b;
        Intrinsics.checkNotNull(fragmentA);
        fragmentTransactionQ.s(i3, fragmentA);
        if (z().m()) {
            fragmentTransactionQ.y(4099);
        }
        z().q();
        fragmentTransactionQ.j();
    }

    private final SlidingPaneLayout y(LayoutInflater layoutInflater) {
        SlidingPaneLayout slidingPaneLayout = new SlidingPaneLayout(layoutInflater.getContext());
        slidingPaneLayout.setId(R.id.f50975d);
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView.setId(R.id.f50974c);
        SlidingPaneLayout.LayoutParams layoutParams = new SlidingPaneLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.f50970b), -1);
        layoutParams.f53152a = getResources().getInteger(R.integer.f50982b);
        slidingPaneLayout.addView(fragmentContainerView, layoutParams);
        FragmentContainerView fragmentContainerView2 = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView2.setId(R.id.f50973b);
        SlidingPaneLayout.LayoutParams layoutParams2 = new SlidingPaneLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.f50969a), -1);
        layoutParams2.f53152a = getResources().getInteger(R.integer.f50981a);
        slidingPaneLayout.addView(fragmentContainerView2, layoutParams2);
        return slidingPaneLayout;
    }

    public Fragment A() {
        Fragment fragmentM0 = getChildFragmentManager().m0(R.id.f50974c);
        if (fragmentM0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.preference.PreferenceFragmentCompat");
        }
        PreferenceFragmentCompat preferenceFragmentCompat = (PreferenceFragmentCompat) fragmentM0;
        if (preferenceFragmentCompat.z().I0() <= 0) {
            return null;
        }
        int iI0 = preferenceFragmentCompat.z().I0();
        int i3 = 0;
        while (true) {
            if (i3 >= iI0) {
                break;
            }
            int i4 = i3 + 1;
            Preference preferenceH0 = preferenceFragmentCompat.z().H0(i3);
            Intrinsics.checkNotNullExpressionValue(preferenceH0, "headerFragment.preferenc…reen.getPreference(index)");
            if (preferenceH0.k() == null) {
                i3 = i4;
            } else {
                String strK = preferenceH0.k();
                fragmentA = strK != null ? getChildFragmentManager().B0().a(requireContext().getClassLoader(), strK) : null;
                if (fragmentA == null) {
                    return fragmentA;
                }
                fragmentA.setArguments(preferenceH0.i());
            }
        }
        return fragmentA;
    }

    public abstract PreferenceFragmentCompat B();

    @Override // androidx.preference.PreferenceFragmentCompat.OnPreferenceStartFragmentCallback
    public boolean k(PreferenceFragmentCompat caller, Preference pref) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        Intrinsics.checkNotNullParameter(pref, "pref");
        if (caller.getId() == R.id.f50974c) {
            E(pref);
            return true;
        }
        int id = caller.getId();
        int i3 = R.id.f50973b;
        if (id != i3) {
            return false;
        }
        FragmentFactory fragmentFactoryB0 = getChildFragmentManager().B0();
        ClassLoader classLoader = requireContext().getClassLoader();
        String strK = pref.k();
        Intrinsics.checkNotNull(strK);
        Fragment fragmentA = fragmentFactoryB0.a(classLoader, strK);
        Intrinsics.checkNotNullExpressionValue(fragmentA, "childFragmentManager.fra….fragment!!\n            )");
        fragmentA.setArguments(pref.i());
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionQ = childFragmentManager.q();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionQ, "beginTransaction()");
        fragmentTransactionQ.x(true);
        fragmentTransactionQ.s(i3, fragmentA);
        fragmentTransactionQ.y(4099);
        fragmentTransactionQ.h(null);
        fragmentTransactionQ.j();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        FragmentTransaction fragmentTransactionQ = parentFragmentManager.q();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionQ, "beginTransaction()");
        fragmentTransactionQ.w(this);
        fragmentTransactionQ.j();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        SlidingPaneLayout slidingPaneLayoutY = y(inflater);
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i3 = R.id.f50974c;
        if (childFragmentManager.m0(i3) == null) {
            PreferenceFragmentCompat preferenceFragmentCompatB = B();
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
            FragmentTransaction fragmentTransactionQ = childFragmentManager2.q();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionQ, "beginTransaction()");
            fragmentTransactionQ.x(true);
            fragmentTransactionQ.b(i3, preferenceFragmentCompatB);
            fragmentTransactionQ.j();
        }
        slidingPaneLayoutY.setLockMode(3);
        return slidingPaneLayoutY;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.f50928a = new InnerOnBackPressedCallback(this);
        SlidingPaneLayout slidingPaneLayoutZ = z();
        if (!ViewCompat.R(slidingPaneLayoutZ) || slidingPaneLayoutZ.isLayoutRequested()) {
            slidingPaneLayoutZ.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.preference.PreferenceHeaderFragmentCompat$onViewCreated$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                    Intrinsics.checkParameterIsNotNull(view2, "view");
                    view2.removeOnLayoutChangeListener(this);
                    OnBackPressedCallback onBackPressedCallback = this.f50930a.f50928a;
                    Intrinsics.checkNotNull(onBackPressedCallback);
                    onBackPressedCallback.setEnabled(this.f50930a.z().n() && this.f50930a.z().m());
                }
            });
        } else {
            OnBackPressedCallback onBackPressedCallback = this.f50928a;
            Intrinsics.checkNotNull(onBackPressedCallback);
            onBackPressedCallback.setEnabled(z().n() && z().m());
        }
        getChildFragmentManager().l(new FragmentManager.OnBackStackChangedListener() { // from class: androidx.preference.a
            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final void onBackStackChanged() {
                PreferenceHeaderFragmentCompat.C(this.f51069a);
            }
        });
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwnerA = ViewTreeOnBackPressedDispatcherOwner.a(view);
        if (onBackPressedDispatcherOwnerA == null || (onBackPressedDispatcher = onBackPressedDispatcherOwnerA.getOnBackPressedDispatcher()) == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        OnBackPressedCallback onBackPressedCallback2 = this.f50928a;
        Intrinsics.checkNotNull(onBackPressedCallback2);
        onBackPressedDispatcher.i(viewLifecycleOwner, onBackPressedCallback2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        Fragment fragmentA;
        super.onViewStateRestored(bundle);
        if (bundle != null || (fragmentA = A()) == null) {
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionQ = childFragmentManager.q();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionQ, "beginTransaction()");
        fragmentTransactionQ.x(true);
        fragmentTransactionQ.s(R.id.f50973b, fragmentA);
        fragmentTransactionQ.j();
    }

    public final SlidingPaneLayout z() {
        return (SlidingPaneLayout) requireView();
    }
}
