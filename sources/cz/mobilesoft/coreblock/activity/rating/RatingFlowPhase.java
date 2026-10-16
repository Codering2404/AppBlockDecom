package cz.mobilesoft.coreblock.activity.rating;

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
public final class RatingFlowPhase {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RatingFlowPhase[] $VALUES;
    public static final RatingFlowPhase Onboarding = new RatingFlowPhase("Onboarding", 0, "onboarding");
    public static final RatingFlowPhase Review = new RatingFlowPhase("Review", 1, "review");
    private final String analyticsValue;

    private static final /* synthetic */ RatingFlowPhase[] $values() {
        return new RatingFlowPhase[]{Onboarding, Review};
    }

    static {
        RatingFlowPhase[] ratingFlowPhaseArr$values = $values();
        $VALUES = ratingFlowPhaseArr$values;
        $ENTRIES = EnumEntriesKt.a(ratingFlowPhaseArr$values);
    }

    private RatingFlowPhase(String str, int i3, String str2) {
        this.analyticsValue = str2;
    }

    public static EnumEntries<RatingFlowPhase> getEntries() {
        return $ENTRIES;
    }

    public static RatingFlowPhase valueOf(String str) {
        return (RatingFlowPhase) Enum.valueOf(RatingFlowPhase.class, str);
    }

    public static RatingFlowPhase[] values() {
        return (RatingFlowPhase[]) $VALUES.clone();
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
