package cz.mobilesoft.coreblock.scene.statistics.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.facebook.internal.Utility;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.adapter.BaseViewHolder;
import cz.mobilesoft.coreblock.databinding.ItemListAppsWebsBinding;
import cz.mobilesoft.coreblock.dto.AppWebWrapper;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.StatisticsUsageTypeFilter;
import cz.mobilesoft.coreblock.scene.statistics.adapter.AppsWebsAdapter;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.util.view.ViewHelper;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import cz.mobilesoft.coreblock.view.PremiumFeatureCardView;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public class AppsWebsAdapter extends ListAdapter<AppWebWrapper, BaseViewHolder<AppWebWrapper>> implements KoinComponent {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Companion f119752v = new Companion(null);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f119753w = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Context f119754k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Function2 f119755l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Function1 f119756m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Function0 f119757n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f119758o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Function2 f119759p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f119760q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f119761r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f119762s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final PackageManager f119763t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private LayoutInflater f119764u;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public class ItemViewHolder extends BaseViewHolder<AppWebWrapper> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ItemListAppsWebsBinding f119765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AppsWebsAdapter f119766c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f119767a;

            static {
                int[] iArr = new int[StatisticsUsageTypeFilter.values().length];
                try {
                    iArr[StatisticsUsageTypeFilter.USAGE_TIME.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[StatisticsUsageTypeFilter.LAUNCH_COUNT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[StatisticsUsageTypeFilter.UNLOCKS.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f119767a = iArr;
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public ItemViewHolder(AppsWebsAdapter appsWebsAdapter, ItemListAppsWebsBinding binding) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f119766c = appsWebsAdapter;
            ConstraintLayout root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            super(root);
            this.f119765b = binding;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(Function2 function2, AppWebWrapper appWebWrapper, View view) {
            AggregatedItemRecord aggregatedItemRecordA = appWebWrapper.a();
            ArrayList arrayList = null;
            Object objE = aggregatedItemRecordA != null ? aggregatedItemRecordA.e() : null;
            ArrayList arrayListF = appWebWrapper.f();
            if (arrayListF != null) {
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayListF, 10));
                int size = arrayListF.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayListF.get(i3);
                    i3++;
                    arrayList.add(((AggregatedItemRecord) obj).e());
                }
            }
            function2.invoke(objE, arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(final AppWebWrapper appWebWrapper, final AppsWebsAdapter appsWebsAdapter, final Function1 function1, View view) {
            String strE;
            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
            popupMenu.inflate(R.menu.f95738f);
            AggregatedItemRecord aggregatedItemRecordA = appWebWrapper.a();
            if (aggregatedItemRecordA != null && (strE = aggregatedItemRecordA.e()) != null && ((Boolean) BuildersKt__BuildersKt.b(null, new AppsWebsAdapter$ItemViewHolder$bind$1$3$1$1$1(appsWebsAdapter, strE, null), 1, null)).booleanValue()) {
                popupMenu.getMenu().removeItem(R.id.f95609f);
            }
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.adapter.c
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return AppsWebsAdapter.ItemViewHolder.i(appWebWrapper, function1, appsWebsAdapter, menuItem);
                }
            });
            popupMenu.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean i(AppWebWrapper appWebWrapper, Function1 function1, AppsWebsAdapter appsWebsAdapter, MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            int i3 = 0;
            if (itemId == R.id.N0) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayListF = appWebWrapper.f();
                if (arrayListF != null) {
                    int size = arrayListF.size();
                    while (i3 < size) {
                        Object obj = arrayListF.get(i3);
                        i3++;
                        arrayList.add(new Pair(((AggregatedItemRecord) obj).e(), UsageAccess.Type.WEBSITE));
                    }
                }
                AggregatedItemRecord aggregatedItemRecordA = appWebWrapper.a();
                if (aggregatedItemRecordA != null) {
                    arrayList.add(new Pair(aggregatedItemRecordA.e(), UsageAccess.Type.APPLICATION));
                }
                function1.invoke(arrayList);
                return true;
            }
            if (itemId != R.id.f95609f) {
                return false;
            }
            Function2 function2P = appsWebsAdapter.p();
            if (function2P != null) {
                AggregatedItemRecord aggregatedItemRecordA2 = appWebWrapper.a();
                ArrayList arrayList2 = null;
                String strE = aggregatedItemRecordA2 != null ? aggregatedItemRecordA2.e() : null;
                ArrayList arrayListF2 = appWebWrapper.f();
                if (arrayListF2 != null) {
                    arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayListF2, 10));
                    int size2 = arrayListF2.size();
                    while (i3 < size2) {
                        Object obj2 = arrayListF2.get(i3);
                        i3++;
                        arrayList2.add(((AggregatedItemRecord) obj2).e());
                    }
                }
                function2P.invoke(strE, arrayList2);
            }
            return true;
        }

        @Override // cz.mobilesoft.coreblock.base.adapter.BaseViewHolder
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(final AppWebWrapper item, int i3) {
            String strC;
            ArrayList arrayListF;
            AggregatedItemRecord aggregatedItemRecord;
            Integer numH;
            String strE;
            Intrinsics.checkNotNullParameter(item, "item");
            ItemListAppsWebsBinding itemListAppsWebsBinding = this.f119765b;
            final AppsWebsAdapter appsWebsAdapter = this.f119766c;
            final Function2 function2Q = appsWebsAdapter.q();
            if (function2Q != null) {
                itemListAppsWebsBinding.f96721c.setClickable(true);
                itemListAppsWebsBinding.f96721c.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.adapter.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AppsWebsAdapter.ItemViewHolder.g(function2Q, item, view);
                    }
                });
            } else {
                itemListAppsWebsBinding.f96721c.setClickable(false);
            }
            final Function1 function1R = appsWebsAdapter.r();
            if (function1R != null) {
                itemListAppsWebsBinding.f96723e.setVisibility(0);
                itemListAppsWebsBinding.f96723e.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.adapter.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AppsWebsAdapter.ItemViewHolder.h(item, appsWebsAdapter, function1R, view);
                    }
                });
            }
            itemListAppsWebsBinding.f96725g.setVisibility(0);
            TextView textView = itemListAppsWebsBinding.f96725g;
            int i4 = WhenMappings.f119767a[item.d().ordinal()];
            if (i4 == 1) {
                strC = DateHelper.c(Long.valueOf(item.c()));
            } else {
                if (i4 != 2 && i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                strC = item.b() + "x";
            }
            textView.setText(strC);
            AggregatedItemRecord aggregatedItemRecordA = item.a();
            if (aggregatedItemRecordA == null || (strE = aggregatedItemRecordA.e()) == null) {
                ArrayList arrayListF2 = item.f();
                String strE2 = (arrayListF2 == null || (aggregatedItemRecord = (AggregatedItemRecord) CollectionsKt.first((List) arrayListF2)) == null) ? null : aggregatedItemRecord.e();
                if (appsWebsAdapter.t() || ((arrayListF = item.f()) != null && arrayListF.size() == 1)) {
                    itemListAppsWebsBinding.f96724f.setText(strE2);
                    ViewHelper.f(itemListAppsWebsBinding.f96722d, strE2);
                } else {
                    String strX = StringHelper.x(strE2);
                    itemListAppsWebsBinding.f96724f.setText(strX);
                    ViewHelper.f(itemListAppsWebsBinding.f96722d, strX);
                }
            } else {
                try {
                    ApplicationInfo applicationInfo = appsWebsAdapter.f119763t.getApplicationInfo(strE, Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
                    itemListAppsWebsBinding.f96722d.setImageDrawable(appsWebsAdapter.f119763t.getApplicationIcon(applicationInfo));
                    itemListAppsWebsBinding.f96724f.setText(appsWebsAdapter.f119763t.getApplicationLabel(applicationInfo));
                } catch (PackageManager.NameNotFoundException e3) {
                    e3.printStackTrace();
                    itemListAppsWebsBinding.f96724f.setText(strE);
                    itemListAppsWebsBinding.f96722d.setImageResource(R.drawable.f95516g2);
                }
            }
            itemListAppsWebsBinding.f96720b.setVisibility(0);
            AggregatedItemRecord aggregatedItemRecordA2 = item.a();
            float fO = 0.0f;
            float fIntValue = (aggregatedItemRecordA2 == null || (numH = aggregatedItemRecordA2.h(item.d().getUsageRecordType())) == null) ? 0.0f : numH.intValue() / appsWebsAdapter.o();
            ArrayList arrayListF3 = item.f();
            if (arrayListF3 != null) {
                int size = arrayListF3.size();
                int iIntValue = 0;
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayListF3.get(i5);
                    i5++;
                    Integer numH2 = ((AggregatedItemRecord) obj).h(item.d().getUsageRecordType());
                    iIntValue += numH2 != null ? numH2.intValue() : 0;
                }
                fO = iIntValue / appsWebsAdapter.o();
            }
            itemListAppsWebsBinding.f96720b.setWidth(fIntValue + fO);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class PremiumViewHolder extends BaseViewHolder<AppWebWrapper> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PremiumFeatureCardView f119771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AppsWebsAdapter f119772c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PremiumViewHolder(AppsWebsAdapter appsWebsAdapter, PremiumFeatureCardView cardView) {
            super(cardView);
            Intrinsics.checkNotNullParameter(cardView, "cardView");
            this.f119772c = appsWebsAdapter;
            this.f119771b = cardView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(Function0 function0, View view) {
            function0.invoke();
        }

        @Override // cz.mobilesoft.coreblock.base.adapter.BaseViewHolder
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(AppWebWrapper item, int i3) {
            Intrinsics.checkNotNullParameter(item, "item");
            PremiumFeatureCardView premiumFeatureCardView = this.f119771b;
            AppsWebsAdapter appsWebsAdapter = this.f119772c;
            int itemCount = AppsWebsAdapter.super.getItemCount() - Limit.STATISTICS_LIMIT.getLimitValue();
            premiumFeatureCardView.setTitleText(StringHelper.h(premiumFeatureCardView.getContext().getResources().getQuantityString(R.plurals.f95742c, itemCount, Integer.valueOf(itemCount))));
            final Function0 function0S = appsWebsAdapter.s();
            if (function0S != null) {
                this.f119771b.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.adapter.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AppsWebsAdapter.PremiumViewHolder.e(function0S, view);
                    }
                });
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppsWebsAdapter(Context context, Function2 function2, Function1 function1, Function0 function0, boolean z2, Function2 function22) {
        super(new DiffUtil.ItemCallback<AppWebWrapper>() { // from class: cz.mobilesoft.coreblock.scene.statistics.adapter.AppsWebsAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public boolean a(AppWebWrapper old, AppWebWrapper appWebWrapper) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(appWebWrapper, "new");
                return Intrinsics.areEqual(old, appWebWrapper);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public boolean b(AppWebWrapper old, AppWebWrapper appWebWrapper) {
                String strE;
                String strE2;
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(appWebWrapper, "new");
                AggregatedItemRecord aggregatedItemRecordA = old.a();
                if (aggregatedItemRecordA != null && (strE = aggregatedItemRecordA.e()) != null) {
                    AggregatedItemRecord aggregatedItemRecordA2 = appWebWrapper.a();
                    Boolean boolValueOf = (aggregatedItemRecordA2 == null || (strE2 = aggregatedItemRecordA2.e()) == null) ? null : Boolean.valueOf(Intrinsics.areEqual(strE, strE2));
                    if (boolValueOf != null) {
                        return boolValueOf.booleanValue();
                    }
                }
                return a(old, appWebWrapper);
            }
        });
        Intrinsics.checkNotNullParameter(context, "context");
        this.f119754k = context;
        this.f119755l = function2;
        this.f119756m = function1;
        this.f119757n = function0;
        this.f119758o = z2;
        this.f119759p = function22;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f119760q = LazyKt.a(lazyThreadSafetyModeB, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.scene.statistics.adapter.AppsWebsAdapter$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), qualifier, objArr);
            }
        });
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        this.f119763t = packageManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplicationDao m() {
        return (ApplicationDao) this.f119760q.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void w(java.util.List r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L4c
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
            boolean r0 = r6.hasNext()
            r1 = 0
            if (r0 != 0) goto L11
            r0 = r1
            goto L38
        L11:
            java.lang.Object r0 = r6.next()
            boolean r2 = r6.hasNext()
            if (r2 != 0) goto L1c
            goto L38
        L1c:
            r2 = r0
            cz.mobilesoft.coreblock.dto.AppWebWrapper r2 = (cz.mobilesoft.coreblock.dto.AppWebWrapper) r2
            int r2 = r2.e()
        L23:
            java.lang.Object r3 = r6.next()
            r4 = r3
            cz.mobilesoft.coreblock.dto.AppWebWrapper r4 = (cz.mobilesoft.coreblock.dto.AppWebWrapper) r4
            int r4 = r4.e()
            if (r2 >= r4) goto L32
            r0 = r3
            r2 = r4
        L32:
            boolean r3 = r6.hasNext()
            if (r3 != 0) goto L23
        L38:
            if (r0 == 0) goto L44
            cz.mobilesoft.coreblock.dto.AppWebWrapper r0 = (cz.mobilesoft.coreblock.dto.AppWebWrapper) r0
            int r6 = r0.e()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
        L44:
            if (r1 == 0) goto L4c
            int r6 = r1.intValue()
            float r6 = (float) r6
            goto L4d
        L4c:
            r6 = 0
        L4d:
            r5.f119761r = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.statistics.adapter.AppsWebsAdapter.w(java.util.List):void");
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        this.f119762s = true;
        return super.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return (this.f119762s || i3 < Limit.STATISTICS_LIMIT.getLimitValue()) ? 99 : 98;
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void i(List list) {
        w(list);
        super.i(list);
    }

    protected AppWebWrapper n(int i3) {
        if (getItemViewType(i3) != 99) {
            return new AppWebWrapper(null, null, null, 4, null);
        }
        Object objG = super.g(i3);
        Intrinsics.checkNotNull(objG);
        return (AppWebWrapper) objG;
    }

    protected final float o() {
        return this.f119761r;
    }

    protected final Function2 p() {
        return this.f119759p;
    }

    protected final Function2 q() {
        return this.f119755l;
    }

    protected final Function1 r() {
        return this.f119756m;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    protected final Function0 s() {
        return this.f119757n;
    }

    protected final boolean t() {
        return this.f119758o;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder holder, int i3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.b(n(i3), i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int i3) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = this.f119764u;
        if (layoutInflaterFrom == null) {
            layoutInflaterFrom = LayoutInflater.from(parent.getContext());
            this.f119764u = layoutInflaterFrom;
        }
        if (i3 == 99) {
            ItemListAppsWebsBinding itemListAppsWebsBindingC = ItemListAppsWebsBinding.c(layoutInflaterFrom, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemListAppsWebsBindingC, "inflate(...)");
            return new ItemViewHolder(this, itemListAppsWebsBindingC);
        }
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        PremiumFeatureCardView premiumFeatureCardView = new PremiumFeatureCardView(context, null, 2, null);
        ViewHelperExtKt.x(premiumFeatureCardView);
        return new PremiumViewHolder(this, premiumFeatureCardView);
    }
}
