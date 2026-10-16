package cz.mobilesoft.coreblock.scene.streaks;

import com.facebook.appevents.integrity.IntegrityManager;
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
public final class StreakLossReason {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StreakLossReason[] $VALUES;
    public static final Companion Companion;
    public static final StreakLossReason NONE = new StreakLossReason("NONE", 0, 0, IntegrityManager.INTEGRITY_TYPE_NONE);
    public static final StreakLossReason PAUSE_TOO_LONG = new StreakLossReason("PAUSE_TOO_LONG", 1, 2, "pause_too_long");
    public static final StreakLossReason TOO_MANY_PAUSES = new StreakLossReason("TOO_MANY_PAUSES", 2, 3, "too_many_pauses");
    private static final Lazy<Map<Integer, StreakLossReason>> allById$delegate;
    private final String analyticsKey;
    private final int id;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map a() {
            return (Map) StreakLossReason.allById$delegate.getValue();
        }

        public final StreakLossReason b(int i3) {
            StreakLossReason streakLossReason = (StreakLossReason) a().get(Integer.valueOf(i3));
            return streakLossReason == null ? StreakLossReason.NONE : streakLossReason;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Converter {
        public final StreakLossReason a(int i3) {
            return StreakLossReason.Companion.b(i3);
        }

        public final int b(StreakLossReason reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return reason.getId();
        }
    }

    private static final /* synthetic */ StreakLossReason[] $values() {
        return new StreakLossReason[]{NONE, PAUSE_TOO_LONG, TOO_MANY_PAUSES};
    }

    static {
        StreakLossReason[] streakLossReasonArr$values = $values();
        $VALUES = streakLossReasonArr$values;
        $ENTRIES = EnumEntriesKt.a(streakLossReasonArr$values);
        Companion = new Companion(null);
        allById$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StreakLossReason.allById_delegate$lambda$0();
            }
        });
    }

    private StreakLossReason(String str, int i3, int i4, String str2) {
        this.id = i4;
        this.analyticsKey = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map allById_delegate$lambda$0() {
        EnumEntries<StreakLossReason> entries = getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
        for (StreakLossReason streakLossReason : entries) {
            linkedHashMap.put(Integer.valueOf(streakLossReason.id), streakLossReason);
        }
        return linkedHashMap;
    }

    public static EnumEntries<StreakLossReason> getEntries() {
        return $ENTRIES;
    }

    public static StreakLossReason valueOf(String str) {
        return (StreakLossReason) Enum.valueOf(StreakLossReason.class, str);
    }

    public static StreakLossReason[] values() {
        return (StreakLossReason[]) $VALUES.clone();
    }

    public final String getAnalyticsKey() {
        return this.analyticsKey;
    }

    public final int getId() {
        return this.id;
    }
}
