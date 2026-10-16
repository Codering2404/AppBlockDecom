package cz.mobilesoft.coreblock.scene.statistics.adapter;

import android.util.LongSparseArray;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.enums.StatisticsRecordType;
import cz.mobilesoft.coreblock.enums.StatisticsTimeFilter;
import cz.mobilesoft.coreblock.enums.StatisticsUsageTypeFilter;
import cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel;
import cz.mobilesoft.coreblock.scene.statistics.StatisticsIntervalConfig;
import cz.mobilesoft.coreblock.util.helperextension.CollectionsExtKt;
import cz.mobilesoft.statistics.scene.graph.AbstractGraphFragment;
import cz.mobilesoft.statistics.scene.graph.DailyGraphFragment;
import cz.mobilesoft.statistics.scene.graph.WeeklyGraphFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StatisticsGraphViewPagerAdapter extends FragmentStateAdapter {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List f119778r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List f119779s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final List f119780t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final LongSparseArray f119781u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Integer[] f119782v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private StatisticsTimeFilter f119783w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private StatisticsIntervalConfig f119784x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private StatisticsUsageTypeFilter f119785y;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f119786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f119787b;

        static {
            int[] iArr = new int[StatisticsTimeFilter.values().length];
            try {
                iArr[StatisticsTimeFilter.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StatisticsTimeFilter.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f119786a = iArr;
            int[] iArr2 = new int[StatisticsRecordType.values().length];
            try {
                iArr2[StatisticsRecordType.WEBS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[StatisticsRecordType.APPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[StatisticsRecordType.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f119787b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatisticsGraphViewPagerAdapter(Fragment fragment, StatisticsUsageTypeFilter usageType, StatisticsTimeFilter intervalType, StatisticsIntervalConfig intervalConfig, List list, List list2) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(usageType, "usageType");
        Intrinsics.checkNotNullParameter(intervalType, "intervalType");
        Intrinsics.checkNotNullParameter(intervalConfig, "intervalConfig");
        this.f119778r = list;
        this.f119779s = list2;
        this.f119780t = new ArrayList();
        this.f119781u = new LongSparseArray();
        this.f119783w = intervalType;
        this.f119784x = intervalConfig;
        this.f119785y = usageType;
    }

    private final Pair A(int i3) {
        Calendar calendar = Calendar.getInstance();
        int i4 = WhenMappings.f119786a[this.f119783w.ordinal()];
        if (i4 == 1) {
            calendar.setTimeInMillis(this.f119784x.a());
            calendar.add(6, i3);
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(6, 1);
            return new Pair(Long.valueOf(timeInMillis), Long.valueOf(calendar.getTimeInMillis()));
        }
        if (i4 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        calendar.setTimeInMillis(this.f119784x.b());
        calendar.add(3, i3);
        long timeInMillis2 = calendar.getTimeInMillis();
        calendar.add(3, 1);
        return new Pair(Long.valueOf(timeInMillis2), Long.valueOf(calendar.getTimeInMillis()));
    }

    private final long B(Pair pair) {
        return (((long) 31) * (((Number) pair.e()).longValue() ^ (((Number) pair.e()).longValue() >>> 32))) + (((Number) pair.f()).longValue() ^ (((Number) pair.f()).longValue() >>> 32));
    }

    public final Pair C(int i3) {
        if (i3 < 0 || i3 >= this.f119781u.size()) {
            return A(i3);
        }
        Object objValueAt = this.f119781u.valueAt(i3);
        Intrinsics.checkNotNull(objValueAt);
        return (Pair) objValueAt;
    }

    public final int D(Pair interval, boolean z2) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        int iC = CollectionsExtKt.c(this.f119781u, interval, z2);
        return iC > -1 ? iC : getItemCount() - 1;
    }

    public final void E(BaseStatisticsFragmentViewModel.BaseStatisticsFilter filter) {
        Integer[] numArr;
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (filter.d() != StatisticsUsageTypeFilter.UNLOCKS) {
            int i3 = WhenMappings.f119787b[filter.c().ordinal()];
            if (i3 == 1) {
                numArr = new Integer[]{Integer.valueOf(UsageAccess.Type.WEBSITE.getTypeId())};
            } else if (i3 == 2) {
                numArr = new Integer[]{Integer.valueOf(UsageAccess.Type.APPLICATION.getTypeId())};
            } else {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                numArr = new Integer[]{Integer.valueOf(UsageAccess.Type.APPLICATION.getTypeId()), Integer.valueOf(UsageAccess.Type.WEBSITE.getTypeId())};
            }
        } else {
            numArr = new Integer[]{Integer.valueOf(UsageAccess.Type.UNLOCK.getTypeId())};
        }
        this.f119782v = numArr;
        Iterator it = this.f119780t.iterator();
        while (it.hasNext()) {
            AbstractGraphFragment abstractGraphFragment = (AbstractGraphFragment) ((WeakReference) it.next()).get();
            if (abstractGraphFragment != null && abstractGraphFragment.isAdded()) {
                abstractGraphFragment.T(this.f119782v, filter.d().getUsageRecordType());
            }
        }
    }

    public final void F(List list) {
        if (list != null) {
            this.f119778r = list;
        }
        Iterator it = this.f119780t.iterator();
        while (it.hasNext()) {
            AbstractGraphFragment abstractGraphFragment = (AbstractGraphFragment) ((WeakReference) it.next()).get();
            if (abstractGraphFragment != null && abstractGraphFragment.isAdded()) {
                List list2 = this.f119778r;
                abstractGraphFragment.U(list2 != null ? (String[]) list2.toArray(new String[0]) : null);
            }
        }
    }

    public final void G() {
        this.f119781u.clear();
        int itemCount = getItemCount();
        for (int i3 = 0; i3 < itemCount; i3++) {
            Pair pairA = A(i3);
            this.f119781u.put(B(pairA), pairA);
        }
        notifyDataSetChanged();
    }

    public final void H(StatisticsIntervalConfig value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f119784x = value;
        G();
    }

    public final void I(StatisticsTimeFilter value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f119783w = value;
        G();
    }

    public final void J(StatisticsUsageTypeFilter value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f119785y = value;
        G();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i3 = WhenMappings.f119786a[this.f119783w.ordinal()];
        if (i3 == 1) {
            return this.f119784x.c();
        }
        if (i3 == 2) {
            return this.f119784x.d();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        if (i3 < 0 || i3 >= this.f119781u.size()) {
            return -1L;
        }
        return this.f119781u.keyAt(i3);
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public boolean h(long j3) {
        return this.f119781u.indexOfKey(j3) >= 0;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment i(int i3) {
        Pair pairC = C(i3);
        AbstractGraphFragment.Builder builder = new AbstractGraphFragment.Builder();
        builder.j(((Number) pairC.e()).longValue());
        builder.f(((Number) pairC.f()).longValue());
        builder.e(R.color.f95447b, R.color.f95446a);
        builder.d(R.color.f95456k);
        builder.g(R.color.f95457l);
        builder.k(this.f119785y.getUsageRecordType());
        List list = this.f119779s;
        if (list != null) {
            builder.i((String[]) list.toArray(new String[0]));
        }
        List list2 = this.f119778r;
        if (list2 != null) {
            builder.h((String[]) list2.toArray(new String[0]));
        }
        builder.l(this.f119782v);
        int i4 = WhenMappings.f119786a[this.f119783w.ordinal()];
        if (i4 == 1) {
            DailyGraphFragment dailyGraphFragmentA = builder.a();
            this.f119780t.add(new WeakReference(dailyGraphFragmentA));
            return dailyGraphFragmentA;
        }
        if (i4 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        WeeklyGraphFragment weeklyGraphFragmentB = builder.b();
        this.f119780t.add(new WeakReference(weeklyGraphFragmentB));
        return weeklyGraphFragmentB;
    }

    public /* synthetic */ StatisticsGraphViewPagerAdapter(Fragment fragment, StatisticsUsageTypeFilter statisticsUsageTypeFilter, StatisticsTimeFilter statisticsTimeFilter, StatisticsIntervalConfig statisticsIntervalConfig, List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, statisticsUsageTypeFilter, statisticsTimeFilter, statisticsIntervalConfig, (i3 & 16) != 0 ? null : list, (i3 & 32) != 0 ? null : list2);
    }
}
