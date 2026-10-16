package cz.mobilesoft.coreblock.scene.premium.premium_expiring;

import cz.mobilesoft.coreblock.R;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PremiumFeature {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PremiumFeature[] $VALUES;
    private final int textRes;
    public static final PremiumFeature Schedules = new PremiumFeature("Schedules", 0, R.string.Np);
    public static final PremiumFeature StrictMode = new PremiumFeature("StrictMode", 1, R.string.Op);
    public static final PremiumFeature QuickBlock = new PremiumFeature("QuickBlock", 2, R.string.Mp);
    public static final PremiumFeature Insights = new PremiumFeature("Insights", 3, R.string.Lp);
    public static final PremiumFeature ExtraOptions = new PremiumFeature("ExtraOptions", 4, R.string.Kp);

    private static final /* synthetic */ PremiumFeature[] $values() {
        return new PremiumFeature[]{Schedules, StrictMode, QuickBlock, Insights, ExtraOptions};
    }

    static {
        PremiumFeature[] premiumFeatureArr$values = $values();
        $VALUES = premiumFeatureArr$values;
        $ENTRIES = EnumEntriesKt.a(premiumFeatureArr$values);
    }

    private PremiumFeature(String str, int i3, int i4) {
        this.textRes = i4;
    }

    public static EnumEntries<PremiumFeature> getEntries() {
        return $ENTRIES;
    }

    public static PremiumFeature valueOf(String str) {
        return (PremiumFeature) Enum.valueOf(PremiumFeature.class, str);
    }

    public static PremiumFeature[] values() {
        return (PremiumFeature[]) $VALUES.clone();
    }

    public final int getTextRes() {
        return this.textRes;
    }
}
