package cz.mobilesoft.coreblock.dto;

import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.Product;
import kotlin.Metadata;

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
public final class PurchaseNotificationDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f96935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Product f96936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PremiumFeature f96937c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchaseNotificationDTO)) {
            return false;
        }
        PurchaseNotificationDTO purchaseNotificationDTO = (PurchaseNotificationDTO) obj;
        return this.f96935a == purchaseNotificationDTO.f96935a && this.f96936b == purchaseNotificationDTO.f96936b && this.f96937c == purchaseNotificationDTO.f96937c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f96935a) * 31) + this.f96936b.hashCode()) * 31) + this.f96937c.hashCode();
    }

    public String toString() {
        return "PurchaseNotificationDTO(size=" + this.f96935a + ", product=" + this.f96936b + ", premiumFeature=" + this.f96937c + ")";
    }
}
