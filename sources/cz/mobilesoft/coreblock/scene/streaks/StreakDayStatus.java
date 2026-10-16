package cz.mobilesoft.coreblock.scene.streaks;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StreakDayStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StreakDayStatus[] $VALUES;
    public static final Companion Companion;
    private static final Lazy<Map<Integer, StreakDayStatus>> allById$delegate;
    private final int id;
    public static final StreakDayStatus INACTIVE = new StreakDayStatus("INACTIVE", 0, 0);
    public static final StreakDayStatus REST = new StreakDayStatus("REST", 1, 1);
    public static final StreakDayStatus OBTAINED = new StreakDayStatus("OBTAINED", 2, 2);
    public static final StreakDayStatus LOST = new StreakDayStatus("LOST", 3, 3);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map a() {
            return (Map) StreakDayStatus.allById$delegate.getValue();
        }

        public final StreakDayStatus b(int i3) {
            StreakDayStatus streakDayStatus = (StreakDayStatus) a().get(Integer.valueOf(i3));
            return streakDayStatus == null ? StreakDayStatus.INACTIVE : streakDayStatus;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Converter {
        public final StreakDayStatus a(int i3) {
            return StreakDayStatus.Companion.b(i3);
        }

        public final int b(StreakDayStatus status) {
            Intrinsics.checkNotNullParameter(status, "status");
            return status.getId();
        }
    }

    private static final /* synthetic */ StreakDayStatus[] $values() {
        return new StreakDayStatus[]{INACTIVE, REST, OBTAINED, LOST};
    }

    static {
        StreakDayStatus[] streakDayStatusArr$values = $values();
        $VALUES = streakDayStatusArr$values;
        $ENTRIES = EnumEntriesKt.a(streakDayStatusArr$values);
        Companion = new Companion(null);
        allById$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StreakDayStatus.allById_delegate$lambda$0();
            }
        });
    }

    private StreakDayStatus(String str, int i3, int i4) {
        this.id = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map allById_delegate$lambda$0() {
        EnumEntries<StreakDayStatus> entries = getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
        for (StreakDayStatus streakDayStatus : entries) {
            linkedHashMap.put(Integer.valueOf(streakDayStatus.id), streakDayStatus);
        }
        return linkedHashMap;
    }

    public static EnumEntries<StreakDayStatus> getEntries() {
        return $ENTRIES;
    }

    public static StreakDayStatus valueOf(String str) {
        return (StreakDayStatus) Enum.valueOf(StreakDayStatus.class, str);
    }

    public static StreakDayStatus[] values() {
        return (StreakDayStatus[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
