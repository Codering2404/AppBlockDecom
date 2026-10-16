package cz.mobilesoft.coreblock.enums;

import android.content.Context;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefConverter;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
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
public final class StatisticsRecordType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StatisticsRecordType[] $VALUES;
    public static final Companion Companion;
    private static final Lazy<Map<Integer, StatisticsRecordType>> valuesById$delegate;
    private final String analyticsName;
    private final int id;
    private final int stringRes;
    public static final StatisticsRecordType ALL = new StatisticsRecordType("ALL", 0, R.string.f95822n0, 0, "All");
    public static final StatisticsRecordType APPS = new StatisticsRecordType("APPS", 1, R.string.M1, 1, "Apps");
    public static final StatisticsRecordType WEBS = new StatisticsRecordType("WEBS", 2, R.string.gG, 2, "Web");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map b() {
            return (Map) StatisticsRecordType.valuesById$delegate.getValue();
        }

        public final StatisticsRecordType a(int i3) {
            StatisticsRecordType statisticsRecordType = (StatisticsRecordType) b().get(Integer.valueOf(i3));
            return statisticsRecordType == null ? StatisticsRecordType.APPS : statisticsRecordType;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Converter implements PrefConverter<StatisticsRecordType, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Converter f97041a = new Converter();

        private Converter() {
        }

        @Override // cz.mobilesoft.coreblock.storage.sharedprefs.PrefConverter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer getId(StatisticsRecordType value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return Integer.valueOf(value.getId());
        }
    }

    private static final /* synthetic */ StatisticsRecordType[] $values() {
        return new StatisticsRecordType[]{ALL, APPS, WEBS};
    }

    static {
        StatisticsRecordType[] statisticsRecordTypeArr$values = $values();
        $VALUES = statisticsRecordTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(statisticsRecordTypeArr$values);
        Companion = new Companion(null);
        valuesById$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.t0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StatisticsRecordType.valuesById_delegate$lambda$0();
            }
        });
    }

    private StatisticsRecordType(String str, int i3, int i4, int i5, String str2) {
        this.stringRes = i4;
        this.id = i5;
        this.analyticsName = str2;
    }

    @JvmStatic
    public static final StatisticsRecordType getById(int i3) {
        return Companion.a(i3);
    }

    public static EnumEntries<StatisticsRecordType> getEntries() {
        return $ENTRIES;
    }

    public static StatisticsRecordType valueOf(String str) {
        return (StatisticsRecordType) Enum.valueOf(StatisticsRecordType.class, str);
    }

    public static StatisticsRecordType[] values() {
        return (StatisticsRecordType[]) $VALUES.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map valuesById_delegate$lambda$0() {
        StatisticsRecordType[] statisticsRecordTypeArrValues = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(statisticsRecordTypeArrValues.length), 16));
        for (StatisticsRecordType statisticsRecordType : statisticsRecordTypeArrValues) {
            linkedHashMap.put(Integer.valueOf(statisticsRecordType.id), statisticsRecordType);
        }
        return linkedHashMap;
    }

    public final String getAnalyticsName() {
        return this.analyticsName;
    }

    public final int getId() {
        return this.id;
    }

    @Override // java.lang.Enum
    public String toString() {
        String string = LockieApplication.g().getString(this.stringRes);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return StringHelperExtKt.c(string);
    }

    public final String toString(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(this.stringRes);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return StringHelperExtKt.c(string);
    }
}
