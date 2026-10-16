package cz.mobilesoft.coreblock.scene.more.help;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment;
import cz.mobilesoft.coreblock.databinding.FragmentHelpV2Binding;
import cz.mobilesoft.coreblock.enums.HelpItem;
import cz.mobilesoft.coreblock.enums.HelpItemResultLauncher;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.scene.more.help.HelpViewModel;
import cz.mobilesoft.coreblock.scene.permission.adapter.PermissionStackAdapter;
import cz.mobilesoft.coreblock.scene.permission.old.BasePermissionFragment;
import cz.mobilesoft.coreblock.service.CheckGrantedPermissionService;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.LiveDataExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import cz.mobilesoft.coreblock.view.viewholder.PermissionsCardSimpleViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class HelpFragment extends BasePermissionFragment<FragmentHelpV2Binding> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Companion f107725p = new Companion(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f107726q = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f107727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ConcatAdapter f107728i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private PermissionStackAdapter f107729j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PermissionHelpHeaderAdapter f107730k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private SectionHeaderAdapter f107731l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private HelpStackAdapter f107732m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private HelpItemResultLauncher f107733n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f107734o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HelpFragment a() {
            return new HelpFragment();
        }

        private Companion() {
        }
    }

    public HelpFragment() {
        final Function0<FragmentActivity> function0 = new Function0<FragmentActivity>() { // from class: cz.mobilesoft.coreblock.scene.more.help.HelpFragment$special$$inlined$activityViewModel$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final FragmentActivity invoke() {
                FragmentActivity fragmentActivityRequireActivity = this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                return fragmentActivityRequireActivity;
            }
        };
        final Qualifier qualifier = null;
        final Function0 function02 = null;
        final Function0 function03 = null;
        this.f107727h = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<HelpViewModel>() { // from class: cz.mobilesoft.coreblock.scene.more.help.HelpFragment$special$$inlined$activityViewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                Fragment fragment = this;
                Qualifier qualifier2 = qualifier;
                Function0 function04 = function0;
                Function0 function05 = function02;
                Function0 function06 = function03;
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function04.invoke()).getViewModelStore();
                if (function05 == null || (defaultViewModelCreationExtras = (CreationExtras) function05.invoke()) == null) {
                    defaultViewModelCreationExtras = fragment.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                return GetViewModelKt.b(Reflection.b(HelpViewModel.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
        this.f107734o = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.help.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(HelpFragment.d0(this.f107804a));
            }
        });
    }

    private final int U() {
        return ((Number) this.f107734o.getValue()).intValue();
    }

    private final HelpViewModel V() {
        return (HelpViewModel) this.f107727h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(HelpFragment helpFragment, HelpItem helpItem, ActivityResult activityResult) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(helpItem, "helpItem");
        Intrinsics.checkNotNullParameter(activityResult, "activityResult");
        if (helpItem == HelpItem.RESTORE_PURCHASES && activityResult.d() == -1 && (activity = helpFragment.getActivity()) != null) {
            activity.finish();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(HelpFragment helpFragment, final FragmentHelpV2Binding fragmentHelpV2Binding, HelpViewModel.HelpDTO helpDTO) {
        if (helpDTO.b().isEmpty()) {
            ConcatAdapter concatAdapter = helpFragment.f107728i;
            if (concatAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
                concatAdapter = null;
            }
            PermissionHelpHeaderAdapter permissionHelpHeaderAdapter = helpFragment.f107730k;
            if (permissionHelpHeaderAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("permissionHeaderAdapter");
                permissionHelpHeaderAdapter = null;
            }
            concatAdapter.k(permissionHelpHeaderAdapter);
            ConcatAdapter concatAdapter2 = helpFragment.f107728i;
            if (concatAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
                concatAdapter2 = null;
            }
            PermissionStackAdapter permissionStackAdapter = helpFragment.f107729j;
            if (permissionStackAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("permissionStackAdapter");
                permissionStackAdapter = null;
            }
            concatAdapter2.k(permissionStackAdapter);
            ConcatAdapter concatAdapter3 = helpFragment.f107728i;
            if (concatAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
                concatAdapter3 = null;
            }
            SectionHeaderAdapter sectionHeaderAdapter = helpFragment.f107731l;
            if (sectionHeaderAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helpHeaderAdapter");
                sectionHeaderAdapter = null;
            }
            concatAdapter3.k(sectionHeaderAdapter);
            RecyclerView recyclerView = fragmentHelpV2Binding.f96640b;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            recyclerView.setPadding(recyclerView.getPaddingLeft(), helpFragment.U(), recyclerView.getPaddingRight(), recyclerView.getPaddingBottom());
        } else {
            ConcatAdapter concatAdapter4 = helpFragment.f107728i;
            if (concatAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
                concatAdapter4 = null;
            }
            List listI = concatAdapter4.i();
            Intrinsics.checkNotNullExpressionValue(listI, "getAdapters(...)");
            List list = listI;
            PermissionHelpHeaderAdapter permissionHelpHeaderAdapter2 = helpFragment.f107730k;
            if (permissionHelpHeaderAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("permissionHeaderAdapter");
                permissionHelpHeaderAdapter2 = null;
            }
            if (!CollectionsKt.contains(list, permissionHelpHeaderAdapter2)) {
                ConcatAdapter concatAdapter5 = helpFragment.f107728i;
                if (concatAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
                    concatAdapter5 = null;
                }
                PermissionHelpHeaderAdapter permissionHelpHeaderAdapter3 = helpFragment.f107730k;
                if (permissionHelpHeaderAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("permissionHeaderAdapter");
                    permissionHelpHeaderAdapter3 = null;
                }
                concatAdapter5.g(0, permissionHelpHeaderAdapter3);
                ConcatAdapter concatAdapter6 = helpFragment.f107728i;
                if (concatAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
                    concatAdapter6 = null;
                }
                PermissionStackAdapter permissionStackAdapter2 = helpFragment.f107729j;
                if (permissionStackAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("permissionStackAdapter");
                    permissionStackAdapter2 = null;
                }
                concatAdapter6.g(1, permissionStackAdapter2);
                ConcatAdapter concatAdapter7 = helpFragment.f107728i;
                if (concatAdapter7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
                    concatAdapter7 = null;
                }
                SectionHeaderAdapter sectionHeaderAdapter2 = helpFragment.f107731l;
                if (sectionHeaderAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("helpHeaderAdapter");
                    sectionHeaderAdapter2 = null;
                }
                concatAdapter7.g(2, sectionHeaderAdapter2);
                RecyclerView recyclerView2 = fragmentHelpV2Binding.f96640b;
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
                recyclerView2.setPadding(recyclerView2.getPaddingLeft(), 0, recyclerView2.getPaddingRight(), recyclerView2.getPaddingBottom());
                fragmentHelpV2Binding.f96640b.post(new Runnable() { // from class: cz.mobilesoft.coreblock.scene.more.help.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        HelpFragment.Z(fragmentHelpV2Binding);
                    }
                });
            }
        }
        HelpStackAdapter helpStackAdapter = helpFragment.f107732m;
        if (helpStackAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helpStackAdapter");
            helpStackAdapter = null;
        }
        helpStackAdapter.i(helpDTO.a());
        List listB = helpDTO.b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listB) {
            if (!((PermissionDTO) obj).c()) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            ConcatAdapter concatAdapter8 = helpFragment.f107728i;
            if (concatAdapter8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
                concatAdapter8 = null;
            }
            SectionHeaderAdapter sectionHeaderAdapter3 = helpFragment.f107731l;
            if (sectionHeaderAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helpHeaderAdapter");
                sectionHeaderAdapter3 = null;
            }
            concatAdapter8.k(sectionHeaderAdapter3);
        }
        PermissionStackAdapter permissionStackAdapter3 = helpFragment.f107729j;
        if (permissionStackAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionStackAdapter");
            permissionStackAdapter3 = null;
        }
        permissionStackAdapter3.i(size == 0 ? CollectionsKt.emptyList() : helpDTO.b());
        PermissionHelpHeaderAdapter permissionHelpHeaderAdapter4 = helpFragment.f107730k;
        if (permissionHelpHeaderAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionHeaderAdapter");
            permissionHelpHeaderAdapter4 = null;
        }
        if (size == 0) {
            permissionHelpHeaderAdapter4.t();
            PermissionsCardSimpleViewHolder.f133471e.a(true);
        } else {
            String quantityString = helpFragment.getResources().getQuantityString(R.plurals.f95755p, size, Integer.valueOf(size));
            Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
            PermissionHelpHeaderAdapter.v(permissionHelpHeaderAdapter4, quantityString, null, 2, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(FragmentHelpV2Binding fragmentHelpV2Binding) {
        fragmentHelpV2Binding.f96640b.u1(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(HelpFragment helpFragment, PermissionDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        helpFragment.I(it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(HelpFragment helpFragment, HelpItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AnswersHelper.f128199a.X1(it);
        if (it.isBlockedByStrictMode() && helpFragment.V().P0()) {
            ViewHelperExtKt.u(helpFragment, StrictModeTitleAlternatives.Companion.a());
        } else {
            Function1<HelpItemResultLauncher, Boolean> action = it.getAction();
            HelpItemResultLauncher helpItemResultLauncher = helpFragment.f107733n;
            if (helpItemResultLauncher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemLauncher");
                helpItemResultLauncher = null;
            }
            if (!((Boolean) action.invoke(helpItemResultLauncher)).booleanValue()) {
                ViewHelperExtKt.u(helpFragment, R.string.bi);
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d0(HelpFragment helpFragment) {
        return helpFragment.getResources().getDimensionPixelSize(R.dimen.f95482p);
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public void x(final FragmentHelpV2Binding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.x(binding);
        HelpItemResultLauncher.Companion companion = HelpItemResultLauncher.f96984d;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        this.f107733n = companion.c(fragmentActivityRequireActivity, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.help.c
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return HelpFragment.X(this.f107801a, (HelpItem) obj, (ActivityResult) obj2);
            }
        });
        LiveDataExtKt.c(this, V().N0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.help.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HelpFragment.Y(this.f107802a, binding, (HelpViewModel.HelpDTO) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public void y(FragmentHelpV2Binding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        RecyclerView recyclerView = binding.f96640b;
        this.f107729j = new PermissionStackAdapter(R.color.f95455j, new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.help.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HelpFragment.b0(this.f107805a, (PermissionDTO) obj);
            }
        });
        PermissionHelpHeaderAdapter permissionHelpHeaderAdapter = new PermissionHelpHeaderAdapter();
        this.f107730k = permissionHelpHeaderAdapter;
        String quantityString = recyclerView.getResources().getQuantityString(R.plurals.f95755p, V().M0().b().size(), Integer.valueOf(V().M0().b().size()));
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        String string = getString(R.string.Xn, getString(R.string.f95790f1));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        permissionHelpHeaderAdapter.u(quantityString, string);
        SectionHeaderAdapter sectionHeaderAdapter = new SectionHeaderAdapter();
        this.f107731l = sectionHeaderAdapter;
        String string2 = getString(R.string.ID);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        sectionHeaderAdapter.t(string2);
        HelpStackAdapter helpStackAdapter = new HelpStackAdapter(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.help.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HelpFragment.c0(this.f107806a, (HelpItem) obj);
            }
        });
        this.f107732m = helpStackAdapter;
        this.f107728i = new ConcatAdapter(helpStackAdapter);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).R(false);
        ConcatAdapter concatAdapter = this.f107728i;
        if (concatAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
            concatAdapter = null;
        }
        recyclerView.setAdapter(concatAdapter);
        recyclerView.n(new RecyclerView.OnScrollListener() { // from class: cz.mobilesoft.coreblock.scene.more.help.HelpFragment$initViews$1$3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void b(RecyclerView recyclerView2, int i3, int i4) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                KeyEventDispatcher.Component activity = this.f107735a.getActivity();
                BaseScrollViewFragment.OnScrollStateChangedListener onScrollStateChangedListener = activity instanceof BaseScrollViewFragment.OnScrollStateChangedListener ? (BaseScrollViewFragment.OnScrollStateChangedListener) activity : null;
                if (onScrollStateChangedListener != null) {
                    onScrollStateChangedListener.e(!recyclerView2.canScrollVertically(-1));
                }
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public FragmentHelpV2Binding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentHelpV2Binding fragmentHelpV2BindingC = FragmentHelpV2Binding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentHelpV2BindingC, "inflate(...)");
        return fragmentHelpV2BindingC;
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() throws Throwable {
        super.onResume();
        CheckGrantedPermissionService.Companion companion = CheckGrantedPermissionService.f123093j;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        companion.d(contextRequireContext);
        HelpViewModel.T0(V(), false, 1, null);
    }
}
