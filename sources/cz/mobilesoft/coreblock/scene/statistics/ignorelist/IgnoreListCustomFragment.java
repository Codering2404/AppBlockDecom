package cz.mobilesoft.coreblock.scene.statistics.ignorelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.FragmentIgnoreListBinding;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.scene.selection.ignorelist.IgnoreListSelectActivity;
import cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragment;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.LiveDataExtKt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class IgnoreListCustomFragment extends BaseIgnoreListFragment<IgnoreListCustomFragmentViewModel> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f119959i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f119960j = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList f119961d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList f119962f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList f119963g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f119964h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IgnoreListCustomFragment a() {
            return new IgnoreListCustomFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f119965a;

        static {
            int[] iArr = new int[UsageAccess.Type.values().length];
            try {
                iArr[UsageAccess.Type.APPLICATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UsageAccess.Type.WEBSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f119965a = iArr;
        }
    }

    public IgnoreListCustomFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.IgnoreListCustomFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Fragment invoke() {
                return this;
            }
        };
        final Qualifier qualifier = null;
        final Function0 function02 = null;
        final Function0 function03 = null;
        this.f119964h = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<IgnoreListCustomFragmentViewModel>() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.IgnoreListCustomFragment$special$$inlined$viewModel$default$2
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
                return GetViewModelKt.b(Reflection.b(IgnoreListCustomFragmentViewModel.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(IgnoreListCustomFragment ignoreListCustomFragment, View view) {
        AnswersHelper.f128199a.P6();
        List<IgnoredStatisticsItem> list = (List) ignoreListCustomFragment.H().L0().f();
        if (list != null) {
            for (IgnoredStatisticsItem ignoredStatisticsItem : list) {
                int i3 = WhenMappings.f119965a[ignoredStatisticsItem.d().ordinal()];
                if (i3 == 1) {
                    ignoreListCustomFragment.f119961d.add(ignoredStatisticsItem.c());
                } else if (i3 == 2) {
                    ignoreListCustomFragment.f119963g.add(new WebsiteDTO(ignoredStatisticsItem.c(), WebsiteProfileRelation.BlockingType.DOMAIN, false, false, 12, null));
                }
                ignoreListCustomFragment.f119962f = new ArrayList(ignoreListCustomFragment.H().S0(ignoreListCustomFragment.f119961d));
            }
        }
        ArrayList arrayList = new ArrayList(ignoreListCustomFragment.H().T0());
        IgnoreListSelectActivity.Companion companion = IgnoreListSelectActivity.f119109g;
        FragmentActivity fragmentActivityRequireActivity = ignoreListCustomFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        ignoreListCustomFragment.startActivityForResult(companion.a(fragmentActivityRequireActivity, ignoreListCustomFragment.f119962f, ignoreListCustomFragment.f119963g, arrayList), 904);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(IgnoreListCustomFragment ignoreListCustomFragment, List ignoredItems) {
        Intrinsics.checkNotNullParameter(ignoredItems, "ignoredItems");
        BaseIgnoreListFragment.IgnoreListAdapter ignoreListAdapterG = ignoreListCustomFragment.G();
        if (ignoreListAdapterG != null) {
            ignoreListAdapterG.k(ignoredItems);
            ignoreListAdapterG.notifyDataSetChanged();
            ignoreListCustomFragment.Q();
        }
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragment
    public void I(FragmentIgnoreListBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        P(new BaseIgnoreListFragment.IgnoreListAdapter());
        RecyclerView recyclerView = binding.f96644d;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(G());
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragment
    public void J(FragmentIgnoreListBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        binding.f96643c.t();
        binding.f96643c.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IgnoreListCustomFragment.W(this.f120012a, view);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragment, cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: L */
    public void x(FragmentIgnoreListBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.x(binding);
        LiveDataExtKt.c(this, H().L0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IgnoreListCustomFragment.X(this.f120011a, (List) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragment, cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: N */
    public void y(FragmentIgnoreListBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        binding.f96642b.f96781d.setText(R.string.Tk);
        binding.f96642b.f96780c.setText(R.string.Uk);
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragment, cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: R */
    public FragmentIgnoreListBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentIgnoreListBinding fragmentIgnoreListBindingC = FragmentIgnoreListBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentIgnoreListBindingC, "inflate(...)");
        return fragmentIgnoreListBindingC;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragment
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public IgnoreListCustomFragmentViewModel H() {
        return (IgnoreListCustomFragmentViewModel) this.f119964h.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        if (i3 != 904) {
            super.onActivityResult(i3, i4, intent);
            return;
        }
        if (i4 == -1 && intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("APPLICATIONS");
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type java.util.ArrayList<cz.mobilesoft.coreblock.storage.room.entity.blocking.Application>");
            ArrayList arrayList = (ArrayList) serializableExtra;
            Serializable serializableExtra2 = intent.getSerializableExtra("WEBSITES");
            Intrinsics.checkNotNull(serializableExtra2, "null cannot be cast to non-null type java.util.ArrayList<cz.mobilesoft.coreblock.dto.WebsiteDTO>");
            ArrayList arrayList2 = (ArrayList) serializableExtra2;
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            int size = arrayList.size();
            boolean z2 = false;
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    break;
                }
                Object obj = arrayList.get(i5);
                i5++;
                Application application = (Application) obj;
                Pair pair = this.f119961d.contains(application.d()) ? null : new Pair(application.d(), UsageAccess.Type.APPLICATION);
                if (pair != null) {
                    arrayList3.add(pair);
                }
            }
            ArrayList arrayList6 = this.f119963g;
            ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
            int size2 = arrayList6.size();
            int i6 = 0;
            while (i6 < size2) {
                Object obj2 = arrayList6.get(i6);
                i6++;
                arrayList7.add(((WebsiteDTO) obj2).a());
            }
            int size3 = arrayList2.size();
            int i7 = 0;
            while (i7 < size3) {
                Object obj3 = arrayList2.get(i7);
                i7++;
                WebsiteDTO websiteDTO = (WebsiteDTO) obj3;
                Pair pair2 = arrayList7.contains(websiteDTO.a()) ? null : new Pair(websiteDTO.a(), UsageAccess.Type.WEBSITE);
                if (pair2 != null) {
                    arrayList3.add(pair2);
                }
            }
            ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            int size4 = arrayList.size();
            int i8 = 0;
            while (i8 < size4) {
                Object obj4 = arrayList.get(i8);
                i8++;
                arrayList8.add(((Application) obj4).d());
            }
            ArrayList arrayList9 = this.f119962f;
            int size5 = arrayList9.size();
            int i9 = 0;
            while (i9 < size5) {
                Object obj5 = arrayList9.get(i9);
                i9++;
                Application application2 = (Application) obj5;
                String strD = arrayList8.contains(application2.d()) ? null : application2.d();
                if (strD != null) {
                    arrayList4.add(strD);
                }
            }
            ArrayList arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            int size6 = arrayList2.size();
            int i10 = 0;
            while (i10 < size6) {
                Object obj6 = arrayList2.get(i10);
                i10++;
                arrayList10.add(((WebsiteDTO) obj6).a());
            }
            ArrayList arrayList11 = this.f119963g;
            int size7 = arrayList11.size();
            int i11 = 0;
            while (i11 < size7) {
                Object obj7 = arrayList11.get(i11);
                i11++;
                WebsiteDTO websiteDTO2 = (WebsiteDTO) obj7;
                String strA = arrayList10.contains(websiteDTO2.a()) ? null : websiteDTO2.a();
                if (strA != null) {
                    arrayList5.add(strA);
                }
            }
            boolean z3 = true;
            if (!arrayList3.isEmpty()) {
                H().O0(arrayList3);
                z2 = true;
            }
            if (!arrayList4.isEmpty()) {
                H().Q0(arrayList4, UsageAccess.Type.APPLICATION);
                z2 = true;
            }
            if (arrayList5.isEmpty()) {
                z3 = z2;
            } else {
                H().Q0(arrayList5, UsageAccess.Type.WEBSITE);
            }
            if (z3) {
                AnswersHelper.f128199a.Q6("ignore_list");
                Fragment targetFragment = getTargetFragment();
                if (targetFragment != null) {
                    targetFragment.onActivityResult(getTargetRequestCode(), i4, new Intent().putExtra("SOURCE", IgnoredStatisticsItem.ItemSourceType.CUSTOM));
                }
            }
        }
        this.f119961d.clear();
        this.f119963g.clear();
    }
}
