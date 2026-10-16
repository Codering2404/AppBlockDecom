package cz.mobilesoft.coreblock.scene.premium.enums;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class PremiumOfferSelectionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PremiumOfferSelectionType[] $VALUES;
    public static final Companion Companion;
    private final String id;
    public static final PremiumOfferSelectionType Selection = new PremiumOfferSelectionType("Selection", 0, "A");
    public static final PremiumOfferSelectionType BottomSheet = new PremiumOfferSelectionType("BottomSheet", 1, "B");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PremiumOfferSelectionType a(String id) {
            PremiumOfferSelectionType next;
            Intrinsics.checkNotNullParameter(id, "id");
            Iterator<PremiumOfferSelectionType> it = PremiumOfferSelectionType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.getId(), id)) {
                    break;
                }
            }
            PremiumOfferSelectionType premiumOfferSelectionType = next;
            return premiumOfferSelectionType == null ? PremiumOfferSelectionType.Selection : premiumOfferSelectionType;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ PremiumOfferSelectionType[] $values() {
        return new PremiumOfferSelectionType[]{Selection, BottomSheet};
    }

    static {
        PremiumOfferSelectionType[] premiumOfferSelectionTypeArr$values = $values();
        $VALUES = premiumOfferSelectionTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(premiumOfferSelectionTypeArr$values);
        Companion = new Companion(null);
    }

    private PremiumOfferSelectionType(String str, int i3, String str2) {
        this.id = str2;
    }

    public static EnumEntries<PremiumOfferSelectionType> getEntries() {
        return $ENTRIES;
    }

    public static PremiumOfferSelectionType valueOf(String str) {
        return (PremiumOfferSelectionType) Enum.valueOf(PremiumOfferSelectionType.class, str);
    }

    public static PremiumOfferSelectionType[] values() {
        return (PremiumOfferSelectionType[]) $VALUES.clone();
    }

    public final String getId() {
        return this.id;
    }
}
