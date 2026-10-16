package cz.mobilesoft.coreblock.scene.statistics.ignorelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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
import cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragment;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.LiveDataExtKt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
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
public final class IgnoreListDefaultFragment extends BaseIgnoreListFragment<IgnoreListDefaultFragmentViewModel> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f119980h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f119981i = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList f119982d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList f119983f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f119984g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IgnoreListDefaultFragment a() {
            return new IgnoreListDefaultFragment();
        }

        private Companion() {
        }
    }

    public IgnoreListDefaultFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.IgnoreListDefaultFragment$special$$inlined$viewModel$default$1
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
        this.f119984g = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<IgnoreListDefaultFragmentViewModel>() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.IgnoreListDefaultFragment$special$$inlined$viewModel$default$2
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
                return GetViewModelKt.b(Reflection.b(IgnoreListDefaultFragmentViewModel.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(IgnoreListDefaultFragment ignoreListDefaultFragment, View view) {
        List list = (List) ignoreListDefaultFragment.H().L0().f();
        if (list != null) {
            ArrayList arrayList = ignoreListDefaultFragment.f119982d;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String strC = ((IgnoredStatisticsItem) it.next()).c();
                if (strC != null) {
                    arrayList.add(strC);
                }
            }
        }
        FragmentActivity activity = ignoreListDefaultFragment.getActivity();
        if (activity != null) {
            ignoreListDefaultFragment.startActivityForResult(DefaultIgnoredApplicationSelectActivity.f119934u.a(activity, ignoreListDefaultFragment.f119982d), 931);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(IgnoreListDefaultFragment ignoreListDefaultFragment, List ignoredItems) {
        Intrinsics.checkNotNullParameter(ignoredItems, "ignoredItems");
        BaseIgnoreListFragment.IgnoreListAdapter ignoreListAdapterG = ignoreListDefaultFragment.G();
        if (ignoreListAdapterG != null) {
            ignoreListAdapterG.k(ignoredItems);
            ignoreListAdapterG.notifyDataSetChanged();
            ignoreListDefaultFragment.Y();
            ignoreListDefaultFragment.Q();
        }
        return Unit.f139807a;
    }

    private final void Y() {
        if (H().J0()) {
            ((FragmentIgnoreListBinding) w()).f96643c.m();
        } else {
            ((FragmentIgnoreListBinding) w()).f96643c.t();
        }
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
        Y();
        binding.f96643c.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IgnoreListDefaultFragment.W(this.f120014a, view);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragment, cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: L */
    public void x(FragmentIgnoreListBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.x(binding);
        LiveDataExtKt.c(this, H().L0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IgnoreListDefaultFragment.X(this.f120013a, (List) obj);
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
        binding.f96642b.f96780c.setText(R.string.Sk);
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragment
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public IgnoreListDefaultFragmentViewModel H() {
        return (IgnoreListDefaultFragmentViewModel) this.f119984g.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        if (i3 != 931) {
            super.onActivityResult(i3, i4, intent);
            return;
        }
        if (i4 == -1 && intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("APPLICATIONS");
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
            ArrayList arrayList = (ArrayList) serializableExtra;
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int size = arrayList.size();
            boolean z2 = false;
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    break;
                }
                Object obj = arrayList.get(i5);
                i5++;
                String str = (String) obj;
                Pair pair = this.f119982d.contains(str) ? null : new Pair(str, UsageAccess.Type.APPLICATION);
                if (pair != null) {
                    arrayList2.add(pair);
                }
            }
            ArrayList arrayList4 = this.f119982d;
            int size2 = arrayList4.size();
            int i6 = 0;
            while (i6 < size2) {
                Object obj2 = arrayList4.get(i6);
                i6++;
                String str2 = (String) obj2;
                if (arrayList.contains(str2)) {
                    str2 = null;
                }
                if (str2 != null) {
                    arrayList3.add(str2);
                }
            }
            boolean z3 = true;
            if (!arrayList2.isEmpty()) {
                H().O0(arrayList2);
                z2 = true;
            }
            if (arrayList3.isEmpty()) {
                z3 = z2;
            } else {
                H().Q0(arrayList3, UsageAccess.Type.APPLICATION);
            }
            if (z3) {
                AnswersHelper.f128199a.Q6("ignore_list");
                Fragment targetFragment = getTargetFragment();
                if (targetFragment != null) {
                    targetFragment.onActivityResult(getTargetRequestCode(), i4, new Intent().putExtra("SOURCE", IgnoredStatisticsItem.ItemSourceType.DEFAULT));
                }
            }
        }
        this.f119982d.clear();
        this.f119983f.clear();
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
        inflater.inflate(R.menu.f95737e, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != R.id.M1) {
            return super.onOptionsItemSelected(item);
        }
        H().T0();
        return true;
    }
}
