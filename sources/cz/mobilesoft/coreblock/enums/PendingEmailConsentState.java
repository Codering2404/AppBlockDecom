package cz.mobilesoft.coreblock.enums;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PendingEmailConsentState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PendingEmailConsentState[] $VALUES;
    public static final Companion Companion;
    public static final PendingEmailConsentState NONE = new PendingEmailConsentState("NONE", 0);
    public static final PendingEmailConsentState CONSENTED = new PendingEmailConsentState("CONSENTED", 1);
    public static final PendingEmailConsentState REFUSED = new PendingEmailConsentState("REFUSED", 2);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PendingEmailConsentState a(int i3) {
            PendingEmailConsentState pendingEmailConsentState = (PendingEmailConsentState) CollectionsKt.getOrNull(PendingEmailConsentState.getEntries(), i3);
            return pendingEmailConsentState == null ? PendingEmailConsentState.NONE : pendingEmailConsentState;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ PendingEmailConsentState[] $values() {
        return new PendingEmailConsentState[]{NONE, CONSENTED, REFUSED};
    }

    static {
        PendingEmailConsentState[] pendingEmailConsentStateArr$values = $values();
        $VALUES = pendingEmailConsentStateArr$values;
        $ENTRIES = EnumEntriesKt.a(pendingEmailConsentStateArr$values);
        Companion = new Companion(null);
    }

    private PendingEmailConsentState(String str, int i3) {
    }

    public static EnumEntries<PendingEmailConsentState> getEntries() {
        return $ENTRIES;
    }

    public static PendingEmailConsentState valueOf(String str) {
        return (PendingEmailConsentState) Enum.valueOf(PendingEmailConsentState.class, str);
    }

    public static PendingEmailConsentState[] values() {
        return (PendingEmailConsentState[]) $VALUES.clone();
    }
}
