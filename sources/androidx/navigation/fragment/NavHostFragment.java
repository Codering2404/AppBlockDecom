package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelStore;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.savedstate.SavedStateRegistry;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public class NavHostFragment extends Fragment implements NavHost {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f49281f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f49282a = LazyKt.b(new Function0() { // from class: androidx.navigation.fragment.k
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NavHostFragment.C(this.f49311a);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f49283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f49284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f49285d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavHostFragment b(Companion companion, int i3, Bundle bundle, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                bundle = null;
            }
            return companion.a(i3, bundle);
        }

        public final NavHostFragment a(int i3, Bundle bundle) {
            Bundle bundle2;
            if (i3 != 0) {
                bundle2 = new Bundle();
                bundle2.putInt("android-support-nav:fragment:graphId", i3);
            } else {
                bundle2 = null;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putBundle("android-support-nav:fragment:startDestinationArgs", bundle);
            }
            NavHostFragment navHostFragment = new NavHostFragment();
            if (bundle2 != null) {
                navHostFragment.setArguments(bundle2);
            }
            return navHostFragment;
        }

        public final NavController c(Fragment fragment) {
            Dialog dialog;
            Window window;
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            for (Fragment parentFragment = fragment; parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
                if (parentFragment instanceof NavHostFragment) {
                    return ((NavHostFragment) parentFragment).B();
                }
                Fragment fragmentI0 = parentFragment.getParentFragmentManager().I0();
                if (fragmentI0 instanceof NavHostFragment) {
                    return ((NavHostFragment) fragmentI0).B();
                }
            }
            View view = fragment.getView();
            if (view != null) {
                return Navigation.c(view);
            }
            View decorView = null;
            DialogFragment dialogFragment = fragment instanceof DialogFragment ? (DialogFragment) fragment : null;
            if (dialogFragment != null && (dialog = dialogFragment.getDialog()) != null && (window = dialog.getWindow()) != null) {
                decorView = window.getDecorView();
            }
            if (decorView != null) {
                return Navigation.c(decorView);
            }
            throw new IllegalStateException("Fragment " + fragment + " does not have a NavController set");
        }

        private Companion() {
        }
    }

    private final int A() {
        int id = getId();
        return (id == 0 || id == -1) ? R.id.f49287a : id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavHostController C(final NavHostFragment navHostFragment) {
        Context context = navHostFragment.getContext();
        if (context == null) {
            throw new IllegalStateException("NavController cannot be created before the fragment is attached");
        }
        final NavHostController navHostController = new NavHostController(context);
        navHostController.c0(navHostFragment);
        ViewModelStore viewModelStore = navHostFragment.getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "<get-viewModelStore>(...)");
        navHostController.d0(viewModelStore);
        navHostFragment.G(navHostController);
        Bundle bundleA = navHostFragment.getSavedStateRegistry().a("android-support-nav:fragment:navControllerState");
        if (bundleA != null) {
            navHostController.X(bundleA);
        }
        navHostFragment.getSavedStateRegistry().c("android-support-nav:fragment:navControllerState", new SavedStateRegistry.SavedStateProvider() { // from class: androidx.navigation.fragment.l
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle a() {
                return NavHostFragment.D(navHostController);
            }
        });
        Bundle bundleA2 = navHostFragment.getSavedStateRegistry().a("android-support-nav:fragment:graphId");
        if (bundleA2 != null) {
            navHostFragment.f49284c = bundleA2.getInt("android-support-nav:fragment:graphId");
        }
        navHostFragment.getSavedStateRegistry().c("android-support-nav:fragment:graphId", new SavedStateRegistry.SavedStateProvider() { // from class: androidx.navigation.fragment.m
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle a() {
                return NavHostFragment.E(this.f49313a);
            }
        });
        int i3 = navHostFragment.f49284c;
        if (i3 != 0) {
            navHostController.Z(i3);
            return navHostController;
        }
        Bundle arguments = navHostFragment.getArguments();
        int i4 = arguments != null ? arguments.getInt("android-support-nav:fragment:graphId") : 0;
        Bundle bundle = arguments != null ? arguments.getBundle("android-support-nav:fragment:startDestinationArgs") : null;
        if (i4 != 0) {
            navHostController.a0(i4, bundle);
        }
        return navHostController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle D(NavHostController navHostController) {
        Bundle bundleY = navHostController.Y();
        if (bundleY != null) {
            return bundleY;
        }
        Bundle EMPTY = Bundle.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        return EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle E(NavHostFragment navHostFragment) {
        int i3 = navHostFragment.f49284c;
        if (i3 != 0) {
            return BundleKt.b(TuplesKt.a("android-support-nav:fragment:graphId", Integer.valueOf(i3)));
        }
        Bundle bundle = Bundle.EMPTY;
        Intrinsics.checkNotNull(bundle);
        return bundle;
    }

    public final NavHostController B() {
        return (NavHostController) this.f49282a.getValue();
    }

    protected void F(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        NavigatorProvider navigatorProviderA = navController.A();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        navigatorProviderA.b(new DialogFragmentNavigator(contextRequireContext, childFragmentManager));
        navController.A().b(z());
    }

    protected void G(NavHostController navHostController) {
        Intrinsics.checkNotNullParameter(navHostController, "navHostController");
        F(navHostController);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (this.f49285d) {
            getParentFragmentManager().q().w(this).j();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        B();
        if (bundle != null && bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
            this.f49285d = true;
            getParentFragmentManager().q().w(this).j();
        }
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        fragmentContainerView.setId(A());
        return fragmentContainerView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View view = this.f49283b;
        if (view != null && Navigation.c(view) == B()) {
            Navigation.h(view, null);
        }
        this.f49283b = null;
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
            this.f49284c = resourceId;
        }
        Unit unit = Unit.f139807a;
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attrs, R.styleable.f49294e);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes2, "obtainStyledAttributes(...)");
        if (typedArrayObtainStyledAttributes2.getBoolean(R.styleable.f49295f, false)) {
            this.f49285d = true;
        }
        typedArrayObtainStyledAttributes2.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        if (this.f49285d) {
            outState.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (!(view instanceof ViewGroup)) {
            throw new IllegalStateException(("created host view " + view + " is not a ViewGroup").toString());
        }
        Navigation.h(view, B());
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getParent() != null) {
            Object parent = viewGroup.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            View view2 = (View) parent;
            this.f49283b = view2;
            Intrinsics.checkNotNull(view2);
            if (view2.getId() == getId()) {
                View view3 = this.f49283b;
                Intrinsics.checkNotNull(view3);
                Navigation.h(view3, B());
            }
        }
    }

    protected Navigator z() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        return new FragmentNavigator(contextRequireContext, childFragmentManager, A());
    }
}
