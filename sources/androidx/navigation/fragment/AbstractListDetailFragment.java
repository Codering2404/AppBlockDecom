package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.fragment.NavHostFragment;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import kotlin.Metadata;
import kotlin.Unit;
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
public abstract class AbstractListDetailFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OnBackPressedCallback f49249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NavHostFragment f49250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f49251c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class InnerOnBackPressedCallback extends OnBackPressedCallback implements SlidingPaneLayout.PanelSlideListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SlidingPaneLayout f49252a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InnerOnBackPressedCallback(SlidingPaneLayout slidingPaneLayout) {
            super(true);
            Intrinsics.checkNotNullParameter(slidingPaneLayout, "slidingPaneLayout");
            this.f49252a = slidingPaneLayout;
            slidingPaneLayout.a(this);
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
            this.f49252a.b();
        }
    }

    public void A(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        NavHostFragment navHostFragmentY;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (bundle != null) {
            this.f49251c = bundle.getInt("android-support-nav:fragment:graphId");
        }
        final SlidingPaneLayout slidingPaneLayout = new SlidingPaneLayout(inflater.getContext());
        slidingPaneLayout.setId(R.id.f49289c);
        View viewZ = z(inflater, slidingPaneLayout, bundle);
        if (!Intrinsics.areEqual(viewZ, slidingPaneLayout) && !Intrinsics.areEqual(viewZ.getParent(), slidingPaneLayout)) {
            slidingPaneLayout.addView(viewZ);
        }
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        int i3 = R.id.f49288b;
        fragmentContainerView.setId(i3);
        SlidingPaneLayout.LayoutParams layoutParams = new SlidingPaneLayout.LayoutParams(inflater.getContext().getResources().getDimensionPixelSize(R.dimen.f49286a), -1);
        layoutParams.f53152a = 1.0f;
        slidingPaneLayout.addView(fragmentContainerView, layoutParams);
        Fragment fragmentM0 = getChildFragmentManager().m0(i3);
        if (fragmentM0 != null) {
            navHostFragmentY = (NavHostFragment) fragmentM0;
        } else {
            navHostFragmentY = y();
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            FragmentTransaction fragmentTransactionQ = childFragmentManager.q();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionQ, "beginTransaction()");
            fragmentTransactionQ.x(true);
            fragmentTransactionQ.b(i3, navHostFragmentY);
            fragmentTransactionQ.j();
        }
        this.f49250b = navHostFragmentY;
        this.f49249a = new InnerOnBackPressedCallback(slidingPaneLayout);
        if (!slidingPaneLayout.isLaidOut() || slidingPaneLayout.isLayoutRequested()) {
            slidingPaneLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.navigation.fragment.AbstractListDetailFragment$onCreateView$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    view.removeOnLayoutChangeListener(this);
                    OnBackPressedCallback onBackPressedCallback = this.f49253a.f49249a;
                    Intrinsics.checkNotNull(onBackPressedCallback);
                    onBackPressedCallback.setEnabled(slidingPaneLayout.n() && slidingPaneLayout.m());
                }
            });
        } else {
            OnBackPressedCallback onBackPressedCallback = this.f49249a;
            Intrinsics.checkNotNull(onBackPressedCallback);
            onBackPressedCallback.setEnabled(slidingPaneLayout.n() && slidingPaneLayout.m());
        }
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        OnBackPressedCallback onBackPressedCallback2 = this.f49249a;
        Intrinsics.checkNotNull(onBackPressedCallback2);
        onBackPressedDispatcher.i(viewLifecycleOwner, onBackPressedCallback2);
        return slidingPaneLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Context context, AttributeSet attrs, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        super.onInflate(context, attrs, bundle);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, androidx.navigation.R.styleable.f49003g);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.R.styleable.f49004h, 0);
        if (resourceId != 0) {
            this.f49251c = resourceId;
        }
        Unit unit = Unit.f139807a;
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        int i3 = this.f49251c;
        if (i3 != 0) {
            outState.putInt("android-support-nav:fragment:graphId", i3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View childAt = x().getChildAt(0);
        Intrinsics.checkNotNull(childAt);
        A(childAt, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        OnBackPressedCallback onBackPressedCallback = this.f49249a;
        Intrinsics.checkNotNull(onBackPressedCallback);
        onBackPressedCallback.setEnabled(x().n() && x().m());
    }

    public final SlidingPaneLayout x() {
        View viewRequireView = requireView();
        Intrinsics.checkNotNull(viewRequireView, "null cannot be cast to non-null type androidx.slidingpanelayout.widget.SlidingPaneLayout");
        return (SlidingPaneLayout) viewRequireView;
    }

    public NavHostFragment y() {
        int i3 = this.f49251c;
        return i3 != 0 ? NavHostFragment.Companion.b(NavHostFragment.f49281f, i3, null, 2, null) : new NavHostFragment();
    }

    public abstract View z(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);
}
