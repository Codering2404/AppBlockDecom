package cz.mobilesoft.coreblock.scene.premium.host;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PaywallOnOpen {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PaywallOnOpen[] $VALUES;
    private final boolean runsOnEveryCreate;
    public static final PaywallOnOpen Nothing = new PaywallOnOpen("Nothing", 0, false, 1, null);
    public static final PaywallOnOpen ClearExpiredSubOfferMarker = new PaywallOnOpen("ClearExpiredSubOfferMarker", 1, true);
    public static final PaywallOnOpen CancelScheduledDiscountNotification = new PaywallOnOpen("CancelScheduledDiscountNotification", 2, false, 1, null);
    public static final PaywallOnOpen ClearCampaignRequest = new PaywallOnOpen("ClearCampaignRequest", 3, false, 1, null);

    private static final /* synthetic */ PaywallOnOpen[] $values() {
        return new PaywallOnOpen[]{Nothing, ClearExpiredSubOfferMarker, CancelScheduledDiscountNotification, ClearCampaignRequest};
    }

    static {
        PaywallOnOpen[] paywallOnOpenArr$values = $values();
        $VALUES = paywallOnOpenArr$values;
        $ENTRIES = EnumEntriesKt.a(paywallOnOpenArr$values);
    }

    private PaywallOnOpen(String str, int i3, boolean z2) {
        this.runsOnEveryCreate = z2;
    }

    public static EnumEntries<PaywallOnOpen> getEntries() {
        return $ENTRIES;
    }

    public static PaywallOnOpen valueOf(String str) {
        return (PaywallOnOpen) Enum.valueOf(PaywallOnOpen.class, str);
    }

    public static PaywallOnOpen[] values() {
        return (PaywallOnOpen[]) $VALUES.clone();
    }

    public final boolean getRunsOnEveryCreate() {
        return this.runsOnEveryCreate;
    }

    /* synthetic */ PaywallOnOpen(String str, int i3, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i4 & 1) != 0 ? false : z2);
    }
}
