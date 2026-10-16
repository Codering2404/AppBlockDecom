package cz.mobilesoft.coreblock.scene.streaks;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class StreakPauseAnalyticsResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StreakPauseAnalyticsResult[] $VALUES;
    public static final Companion Companion;
    private final String analyticsKey;
    public static final StreakPauseAnalyticsResult LOST_BY_PAUSE = new StreakPauseAnalyticsResult("LOST_BY_PAUSE", 0, "lost_by_pause");
    public static final StreakPauseAnalyticsResult ALREADY_BROKEN = new StreakPauseAnalyticsResult("ALREADY_BROKEN", 1, "already_broken");
    public static final StreakPauseAnalyticsResult INTACT_AFTER_PAUSE = new StreakPauseAnalyticsResult("INTACT_AFTER_PAUSE", 2, "intact_after_pause");
    public static final StreakPauseAnalyticsResult UNAVAILABLE = new StreakPauseAnalyticsResult("UNAVAILABLE", 3, "unavailable");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StreakPauseAnalyticsResult a(Boolean bool, Boolean bool2) {
            return (bool == null || bool2 == null) ? StreakPauseAnalyticsResult.UNAVAILABLE : bool.booleanValue() ? StreakPauseAnalyticsResult.ALREADY_BROKEN : bool2.booleanValue() ? StreakPauseAnalyticsResult.LOST_BY_PAUSE : StreakPauseAnalyticsResult.INTACT_AFTER_PAUSE;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ StreakPauseAnalyticsResult[] $values() {
        return new StreakPauseAnalyticsResult[]{LOST_BY_PAUSE, ALREADY_BROKEN, INTACT_AFTER_PAUSE, UNAVAILABLE};
    }

    static {
        StreakPauseAnalyticsResult[] streakPauseAnalyticsResultArr$values = $values();
        $VALUES = streakPauseAnalyticsResultArr$values;
        $ENTRIES = EnumEntriesKt.a(streakPauseAnalyticsResultArr$values);
        Companion = new Companion(null);
    }

    private StreakPauseAnalyticsResult(String str, int i3, String str2) {
        this.analyticsKey = str2;
    }

    public static EnumEntries<StreakPauseAnalyticsResult> getEntries() {
        return $ENTRIES;
    }

    public static StreakPauseAnalyticsResult valueOf(String str) {
        return (StreakPauseAnalyticsResult) Enum.valueOf(StreakPauseAnalyticsResult.class, str);
    }

    public static StreakPauseAnalyticsResult[] values() {
        return (StreakPauseAnalyticsResult[]) $VALUES.clone();
    }

    public final String getAnalyticsKey() {
        return this.analyticsKey;
    }
}
