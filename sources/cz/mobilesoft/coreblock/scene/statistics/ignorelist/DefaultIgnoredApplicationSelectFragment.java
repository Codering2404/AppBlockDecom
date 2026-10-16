package cz.mobilesoft.coreblock.scene.statistics.ignorelist;

import android.R;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.Utility;
import cz.mobilesoft.coreblock.base.fragment.BaseFragment;
import cz.mobilesoft.coreblock.databinding.FragmentDefaultApplicationIgnoreListBinding;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.scene.statistics.ignorelist.DefaultIgnoredApplicationSelectFragment;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import cz.mobilesoft.coreblock.view.badge.BadgeView;
import java.io.Serializable;
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
public final class DefaultIgnoredApplicationSelectFragment extends BaseFragment<FragmentDefaultApplicationIgnoreListBinding> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f119938d = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f119939f = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DefaultApplicationAdapter f119940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f119941c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DefaultIgnoredApplicationSelectFragment a(ArrayList selectedApplications) {
            Intrinsics.checkNotNullParameter(selectedApplications, "selectedApplications");
            DefaultIgnoredApplicationSelectFragment defaultIgnoredApplicationSelectFragment = new DefaultIgnoredApplicationSelectFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("APPLICATIONS", selectedApplications);
            defaultIgnoredApplicationSelectFragment.setArguments(bundle);
            return defaultIgnoredApplicationSelectFragment;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class DefaultApplicationAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private PackageManager f119942i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List f119943j;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public final class ViewHolder extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final BadgeView f119945b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final TextView f119946c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final CheckBox f119947d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ DefaultApplicationAdapter f119948e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(DefaultApplicationAdapter defaultApplicationAdapter, View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.f119948e = defaultApplicationAdapter;
                View viewFindViewById = itemView.findViewById(R.id.icon);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                this.f119945b = (BadgeView) viewFindViewById;
                View viewFindViewById2 = itemView.findViewById(R.id.text1);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                this.f119946c = (TextView) viewFindViewById2;
                View viewFindViewById3 = itemView.findViewById(R.id.checkbox);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                this.f119947d = (CheckBox) viewFindViewById3;
            }

            public final CheckBox b() {
                return this.f119947d;
            }

            public final BadgeView c() {
                return this.f119945b;
            }

            public final TextView d() {
                return this.f119946c;
            }
        }

        public DefaultApplicationAdapter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(DefaultIgnoredApplicationSelectFragment defaultIgnoredApplicationSelectFragment, IgnoredStatisticsItem ignoredStatisticsItem, CompoundButton buttonView, boolean z2) {
            Intrinsics.checkNotNullParameter(buttonView, "buttonView");
            if (!z2) {
                defaultIgnoredApplicationSelectFragment.C().N0().remove(ignoredStatisticsItem.c());
            } else {
                if (defaultIgnoredApplicationSelectFragment.C().N0().contains(ignoredStatisticsItem.c())) {
                    return;
                }
                defaultIgnoredApplicationSelectFragment.C().N0().add(ignoredStatisticsItem.c());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List list = this.f119943j;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(ViewHolder holder, int i3) {
            final IgnoredStatisticsItem ignoredStatisticsItem;
            Intrinsics.checkNotNullParameter(holder, "holder");
            List list = this.f119943j;
            if (list == null || (ignoredStatisticsItem = (IgnoredStatisticsItem) CollectionsKt.getOrNull(list, i3)) == null) {
                return;
            }
            final DefaultIgnoredApplicationSelectFragment defaultIgnoredApplicationSelectFragment = DefaultIgnoredApplicationSelectFragment.this;
            if (ignoredStatisticsItem.d() == UsageAccess.Type.APPLICATION) {
                String strC = ignoredStatisticsItem.c();
                try {
                    PackageManager packageManager = this.f119942i;
                    PackageManager packageManager2 = null;
                    if (packageManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("packageManager");
                        packageManager = null;
                    }
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(strC, Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
                    BadgeView badgeViewC = holder.c();
                    PackageManager packageManager3 = this.f119942i;
                    if (packageManager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("packageManager");
                        packageManager3 = null;
                    }
                    badgeViewC.setImageDrawable(packageManager3.getApplicationIcon(applicationInfo));
                    TextView textViewD = holder.d();
                    PackageManager packageManager4 = this.f119942i;
                    if (packageManager4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("packageManager");
                    } else {
                        packageManager2 = packageManager4;
                    }
                    textViewD.setText(packageManager2.getApplicationLabel(applicationInfo));
                } catch (PackageManager.NameNotFoundException e3) {
                    e3.printStackTrace();
                    holder.d().setText(strC);
                    holder.c().setImageResource(cz.mobilesoft.coreblock.R.drawable.f95516g2);
                }
                holder.b().setChecked(defaultIgnoredApplicationSelectFragment.C().N0().contains(ignoredStatisticsItem.c()));
                holder.b().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.f
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                        DefaultIgnoredApplicationSelectFragment.DefaultApplicationAdapter.i(defaultIgnoredApplicationSelectFragment, ignoredStatisticsItem, compoundButton, z2);
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public ViewHolder onCreateViewHolder(ViewGroup parent, int i3) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(cz.mobilesoft.coreblock.R.layout.R, parent, false);
            PackageManager packageManager = parent.getContext().getApplicationContext().getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
            this.f119942i = packageManager;
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }

        public final void k(List list) {
            this.f119943j = list;
        }
    }

    public DefaultIgnoredApplicationSelectFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.DefaultIgnoredApplicationSelectFragment$special$$inlined$viewModel$default$1
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
        this.f119941c = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<DefaultApplicationSelectFragmentViewModel>() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.DefaultIgnoredApplicationSelectFragment$special$$inlined$viewModel$default$2
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
                return GetViewModelKt.b(Reflection.b(DefaultApplicationSelectFragmentViewModel.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
    }

    private final void D() {
        this.f119940b = new DefaultApplicationAdapter();
        RecyclerView recyclerView = ((FragmentDefaultApplicationIgnoreListBinding) w()).f96633b;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.f119940b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(DefaultIgnoredApplicationSelectFragment defaultIgnoredApplicationSelectFragment, List list) {
        DefaultApplicationAdapter defaultApplicationAdapter = defaultIgnoredApplicationSelectFragment.f119940b;
        if (defaultApplicationAdapter != null) {
            defaultApplicationAdapter.k(list);
            defaultApplicationAdapter.notifyDataSetChanged();
        }
        return Unit.f139807a;
    }

    private final void I(MenuItem menuItem, boolean z2) {
        if (z2) {
            menuItem.setTitle(getString(cz.mobilesoft.coreblock.R.string.J9));
        } else {
            menuItem.setTitle(getString(cz.mobilesoft.coreblock.R.string.Iv));
        }
        menuItem.setChecked(z2);
    }

    public final ArrayList B() {
        return C().N0();
    }

    public final DefaultApplicationSelectFragmentViewModel C() {
        return (DefaultApplicationSelectFragmentViewModel) this.f119941c.getValue();
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public void x(FragmentDefaultApplicationIgnoreListBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.x(binding);
        C().K0().j(getViewLifecycleOwner(), new DefaultIgnoredApplicationSelectFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DefaultIgnoredApplicationSelectFragment.F(this.f120008a, (List) obj);
            }
        }));
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void y(FragmentDefaultApplicationIgnoreListBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            DefaultApplicationSelectFragmentViewModel defaultApplicationSelectFragmentViewModelC = C();
            Serializable serializable = arguments.getSerializable("APPLICATIONS");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
            defaultApplicationSelectFragmentViewModelC.O0((ArrayList) serializable);
        }
        D();
        RecyclerView defaultApplicationRecyclerView = binding.f96633b;
        Intrinsics.checkNotNullExpressionValue(defaultApplicationRecyclerView, "defaultApplicationRecyclerView");
        ViewHelperExtKt.r(this, defaultApplicationRecyclerView);
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public FragmentDefaultApplicationIgnoreListBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentDefaultApplicationIgnoreListBinding fragmentDefaultApplicationIgnoreListBindingC = FragmentDefaultApplicationIgnoreListBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentDefaultApplicationIgnoreListBindingC, "inflate(...)");
        return fragmentDefaultApplicationIgnoreListBindingC;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        inflater.inflate(cz.mobilesoft.coreblock.R.menu.f95736d, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != cz.mobilesoft.coreblock.R.id.f95644n2) {
            return super.onOptionsItemSelected(item);
        }
        I(item, !item.isChecked());
        C().P0(item.isChecked());
        DefaultApplicationAdapter defaultApplicationAdapter = this.f119940b;
        if (defaultApplicationAdapter != null) {
            defaultApplicationAdapter.notifyDataSetChanged();
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        int size = menu.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = menu.getItem(i3);
            if (item.getItemId() == cz.mobilesoft.coreblock.R.id.f95644n2) {
                I(item, C().J0());
            }
        }
    }
}
