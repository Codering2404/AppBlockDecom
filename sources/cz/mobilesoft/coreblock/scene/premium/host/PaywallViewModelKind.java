package cz.mobilesoft.coreblock.scene.premium.host;

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
public final class PaywallViewModelKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PaywallViewModelKind[] $VALUES;
    public static final PaywallViewModelKind Plain = new PaywallViewModelKind("Plain", 0);
    public static final PaywallViewModelKind Campaign = new PaywallViewModelKind("Campaign", 1);
    public static final PaywallViewModelKind MySubscription = new PaywallViewModelKind("MySubscription", 2);
    public static final PaywallViewModelKind Discount = new PaywallViewModelKind("Discount", 3);

    private static final /* synthetic */ PaywallViewModelKind[] $values() {
        return new PaywallViewModelKind[]{Plain, Campaign, MySubscription, Discount};
    }

    static {
        PaywallViewModelKind[] paywallViewModelKindArr$values = $values();
        $VALUES = paywallViewModelKindArr$values;
        $ENTRIES = EnumEntriesKt.a(paywallViewModelKindArr$values);
    }

    private PaywallViewModelKind(String str, int i3) {
    }

    public static EnumEntries<PaywallViewModelKind> getEntries() {
        return $ENTRIES;
    }

    public static PaywallViewModelKind valueOf(String str) {
        return (PaywallViewModelKind) Enum.valueOf(PaywallViewModelKind.class, str);
    }

    public static PaywallViewModelKind[] values() {
        return (PaywallViewModelKind[]) $VALUES.clone();
    }
}
