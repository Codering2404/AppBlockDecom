package cz.mobilesoft.coreblock.scene.insights.trial_summary;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TrialSummaryScreenNavigation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TrialSummaryScreenNavigation[] $VALUES;
    private final String route;
    public static final TrialSummaryScreenNavigation Comparison = new TrialSummaryScreenNavigation("Comparison", 0, "comparison");
    public static final TrialSummaryScreenNavigation BlockingSessions = new TrialSummaryScreenNavigation("BlockingSessions", 1, "blocking_sessions");

    private static final /* synthetic */ TrialSummaryScreenNavigation[] $values() {
        return new TrialSummaryScreenNavigation[]{Comparison, BlockingSessions};
    }

    static {
        TrialSummaryScreenNavigation[] trialSummaryScreenNavigationArr$values = $values();
        $VALUES = trialSummaryScreenNavigationArr$values;
        $ENTRIES = EnumEntriesKt.a(trialSummaryScreenNavigationArr$values);
    }

    private TrialSummaryScreenNavigation(String str, int i3, String str2) {
        this.route = str2;
    }

    public static EnumEntries<TrialSummaryScreenNavigation> getEntries() {
        return $ENTRIES;
    }

    public static TrialSummaryScreenNavigation valueOf(String str) {
        return (TrialSummaryScreenNavigation) Enum.valueOf(TrialSummaryScreenNavigation.class, str);
    }

    public static TrialSummaryScreenNavigation[] values() {
        return (TrialSummaryScreenNavigation[]) $VALUES.clone();
    }

    public final String getRoute() {
        return this.route;
    }
}
