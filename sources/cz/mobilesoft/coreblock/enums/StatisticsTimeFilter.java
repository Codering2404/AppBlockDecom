package cz.mobilesoft.coreblock.enums;

import android.content.Context;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefConverter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
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
public final class StatisticsTimeFilter {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StatisticsTimeFilter[] $VALUES;
    public static final Companion Companion;
    public static final StatisticsTimeFilter DAY = new StatisticsTimeFilter("DAY", 0, R.string.b9, 1);
    public static final StatisticsTimeFilter WEEK = new StatisticsTimeFilter("WEEK", 1, R.string.lG, 0);
    private static final Lazy<Map<Integer, StatisticsTimeFilter>> valuesById$delegate;
    private final int filterId;
    private final int stringRes;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map b() {
            return (Map) StatisticsTimeFilter.valuesById$delegate.getValue();
        }

        public final StatisticsTimeFilter a(int i3) {
            StatisticsTimeFilter statisticsTimeFilter = (StatisticsTimeFilter) b().get(Integer.valueOf(i3));
            return statisticsTimeFilter == null ? StatisticsTimeFilter.WEEK : statisticsTimeFilter;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Converter implements PrefConverter<StatisticsTimeFilter, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Converter f97042a = new Converter();

        private Converter() {
        }

        @Override // cz.mobilesoft.coreblock.storage.sharedprefs.PrefConverter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer getId(StatisticsTimeFilter value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return Integer.valueOf(value.getFilterId());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f97043a;

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
            f97043a = iArr;
        }
    }

    private static final /* synthetic */ StatisticsTimeFilter[] $values() {
        return new StatisticsTimeFilter[]{DAY, WEEK};
    }

    static {
        StatisticsTimeFilter[] statisticsTimeFilterArr$values = $values();
        $VALUES = statisticsTimeFilterArr$values;
        $ENTRIES = EnumEntriesKt.a(statisticsTimeFilterArr$values);
        Companion = new Companion(null);
        valuesById$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.u0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StatisticsTimeFilter.valuesById_delegate$lambda$0();
            }
        });
    }

    private StatisticsTimeFilter(String str, int i3, int i4, int i5) {
        this.stringRes = i4;
        this.filterId = i5;
    }

    @JvmStatic
    public static final StatisticsTimeFilter getById(int i3) {
        return Companion.a(i3);
    }

    public static EnumEntries<StatisticsTimeFilter> getEntries() {
        return $ENTRIES;
    }

    public static StatisticsTimeFilter valueOf(String str) {
        return (StatisticsTimeFilter) Enum.valueOf(StatisticsTimeFilter.class, str);
    }

    public static StatisticsTimeFilter[] values() {
        return (StatisticsTimeFilter[]) $VALUES.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map valuesById_delegate$lambda$0() {
        StatisticsTimeFilter[] statisticsTimeFilterArrValues = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(statisticsTimeFilterArrValues.length), 16));
        for (StatisticsTimeFilter statisticsTimeFilter : statisticsTimeFilterArrValues) {
            linkedHashMap.put(Integer.valueOf(statisticsTimeFilter.filterId), statisticsTimeFilter);
        }
        return linkedHashMap;
    }

    public final int getFilterId() {
        return this.filterId;
    }

    public final Pair<Long, Long> getPreviousInterval(long j3) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        long millis = j3 - timeUnit.toMillis(7L);
        int i3 = WhenMappings.f97043a[ordinal()];
        if (i3 == 1) {
            return new Pair<>(Long.valueOf(millis), Long.valueOf(timeUnit.toMillis(1L) + millis));
        }
        if (i3 == 2) {
            return new Pair<>(Long.valueOf(millis), Long.valueOf(j3));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String toString(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(this.stringRes);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // java.lang.Enum
    public String toString() {
        String string = LockieApplication.g().getString(this.stringRes);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
