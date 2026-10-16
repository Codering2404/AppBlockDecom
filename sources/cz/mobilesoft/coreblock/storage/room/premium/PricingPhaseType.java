package cz.mobilesoft.coreblock.storage.room.premium;

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
public final class PricingPhaseType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PricingPhaseType[] $VALUES;
    public static final Companion Companion;
    private final int id;
    public static final PricingPhaseType UNKNOWN = new PricingPhaseType("UNKNOWN", 0, 0);
    public static final PricingPhaseType BASE = new PricingPhaseType("BASE", 1, 1);
    public static final PricingPhaseType INTRO = new PricingPhaseType("INTRO", 2, 2);
    public static final PricingPhaseType TRIAL = new PricingPhaseType("TRIAL", 3, 3);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ PricingPhaseType[] $values() {
        return new PricingPhaseType[]{UNKNOWN, BASE, INTRO, TRIAL};
    }

    static {
        PricingPhaseType[] pricingPhaseTypeArr$values = $values();
        $VALUES = pricingPhaseTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(pricingPhaseTypeArr$values);
        Companion = new Companion(null);
    }

    private PricingPhaseType(String str, int i3, int i4) {
        this.id = i4;
    }

    public static EnumEntries<PricingPhaseType> getEntries() {
        return $ENTRIES;
    }

    public static PricingPhaseType valueOf(String str) {
        return (PricingPhaseType) Enum.valueOf(PricingPhaseType.class, str);
    }

    public static PricingPhaseType[] values() {
        return (PricingPhaseType[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
