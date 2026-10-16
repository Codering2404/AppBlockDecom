package cz.mobilesoft.coreblock.enums;

import android.content.Context;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefConverter;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.statistics.model.RecordType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class StatisticsUsageTypeFilter {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StatisticsUsageTypeFilter[] $VALUES;
    public static final Companion Companion;
    private static final Lazy<StatisticsUsageTypeFilter[]> legacyValues$delegate;
    private static final Lazy<Map<Integer, StatisticsUsageTypeFilter>> valuesById$delegate;
    private static final Lazy<StatisticsUsageTypeFilter[]> valuesBySDK$delegate;
    private final int filterId;
    private final int stringRes;
    public static final StatisticsUsageTypeFilter USAGE_TIME = new StatisticsUsageTypeFilter("USAGE_TIME", 0, R.string.KF, 0);
    public static final StatisticsUsageTypeFilter UNLOCKS = new StatisticsUsageTypeFilter("UNLOCKS", 1, R.string.pF, 2);
    public static final StatisticsUsageTypeFilter LAUNCH_COUNT = new StatisticsUsageTypeFilter("LAUNCH_COUNT", 2, R.string.Bi, 1);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map c() {
            return (Map) StatisticsUsageTypeFilter.valuesById$delegate.getValue();
        }

        public final StatisticsUsageTypeFilter a(int i3) {
            StatisticsUsageTypeFilter statisticsUsageTypeFilter = (StatisticsUsageTypeFilter) c().get(Integer.valueOf(i3));
            return statisticsUsageTypeFilter == null ? StatisticsUsageTypeFilter.USAGE_TIME : statisticsUsageTypeFilter;
        }

        public final StatisticsUsageTypeFilter[] b() {
            return (StatisticsUsageTypeFilter[]) StatisticsUsageTypeFilter.legacyValues$delegate.getValue();
        }

        public final StatisticsUsageTypeFilter[] d() {
            return (StatisticsUsageTypeFilter[]) StatisticsUsageTypeFilter.valuesBySDK$delegate.getValue();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Converter implements PrefConverter<StatisticsUsageTypeFilter, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Converter f97044a = new Converter();

        private Converter() {
        }

        @Override // cz.mobilesoft.coreblock.storage.sharedprefs.PrefConverter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer getId(StatisticsUsageTypeFilter value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return Integer.valueOf(value.getFilterId());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f97045a;

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
            f97045a = iArr;
        }
    }

    private static final /* synthetic */ StatisticsUsageTypeFilter[] $values() {
        return new StatisticsUsageTypeFilter[]{USAGE_TIME, UNLOCKS, LAUNCH_COUNT};
    }

    static {
        StatisticsUsageTypeFilter[] statisticsUsageTypeFilterArr$values = $values();
        $VALUES = statisticsUsageTypeFilterArr$values;
        $ENTRIES = EnumEntriesKt.a(statisticsUsageTypeFilterArr$values);
        Companion = new Companion(null);
        valuesBySDK$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.v0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StatisticsUsageTypeFilter.valuesBySDK_delegate$lambda$0();
            }
        });
        legacyValues$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.w0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StatisticsUsageTypeFilter.legacyValues_delegate$lambda$0();
            }
        });
        valuesById$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.x0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StatisticsUsageTypeFilter.valuesById_delegate$lambda$0();
            }
        });
    }

    private StatisticsUsageTypeFilter(String str, int i3, int i4, int i5) {
        this.stringRes = i4;
        this.filterId = i5;
    }

    @JvmStatic
    public static final StatisticsUsageTypeFilter getById(int i3) {
        return Companion.a(i3);
    }

    public static EnumEntries<StatisticsUsageTypeFilter> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StatisticsUsageTypeFilter[] legacyValues_delegate$lambda$0() {
        StatisticsUsageTypeFilter[] statisticsUsageTypeFilterArrValues = values();
        ArrayList arrayList = new ArrayList();
        for (StatisticsUsageTypeFilter statisticsUsageTypeFilter : statisticsUsageTypeFilterArrValues) {
            if (statisticsUsageTypeFilter != UNLOCKS) {
                arrayList.add(statisticsUsageTypeFilter);
            }
        }
        return (StatisticsUsageTypeFilter[]) arrayList.toArray(new StatisticsUsageTypeFilter[0]);
    }

    public static StatisticsUsageTypeFilter valueOf(String str) {
        return (StatisticsUsageTypeFilter) Enum.valueOf(StatisticsUsageTypeFilter.class, str);
    }

    public static StatisticsUsageTypeFilter[] values() {
        return (StatisticsUsageTypeFilter[]) $VALUES.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map valuesById_delegate$lambda$0() {
        StatisticsUsageTypeFilter[] statisticsUsageTypeFilterArrValues = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(statisticsUsageTypeFilterArrValues.length), 16));
        for (StatisticsUsageTypeFilter statisticsUsageTypeFilter : statisticsUsageTypeFilterArrValues) {
            linkedHashMap.put(Integer.valueOf(statisticsUsageTypeFilter.filterId), statisticsUsageTypeFilter);
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StatisticsUsageTypeFilter[] valuesBySDK_delegate$lambda$0() {
        return (StatisticsUsageTypeFilter[]) getEntries().toArray(new StatisticsUsageTypeFilter[0]);
    }

    public final int getFilterId() {
        return this.filterId;
    }

    public final RecordType getUsageRecordType() {
        int i3 = WhenMappings.f97045a[ordinal()];
        if (i3 == 1) {
            return RecordType.f133740a;
        }
        if (i3 == 2 || i3 == 3) {
            return RecordType.f133741b;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String toString(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(this.stringRes);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return StringHelperExtKt.c(string);
    }

    @Override // java.lang.Enum
    public String toString() {
        String string = LockieApplication.g().getString(this.stringRes);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return StringHelperExtKt.c(string);
    }
}
