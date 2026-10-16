package cz.mobilesoft.coreblock.scene.premium.dto;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PurchaseSuccessDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f113069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f113070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f113071c;

    public PurchaseSuccessDTO(long j3, boolean z2, boolean z3) {
        this.f113069a = j3;
        this.f113070b = z2;
        this.f113071c = z3;
    }

    public final boolean a() {
        return this.f113071c;
    }

    public final boolean b() {
        return this.f113070b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchaseSuccessDTO)) {
            return false;
        }
        PurchaseSuccessDTO purchaseSuccessDTO = (PurchaseSuccessDTO) obj;
        return this.f113069a == purchaseSuccessDTO.f113069a && this.f113070b == purchaseSuccessDTO.f113070b && this.f113071c == purchaseSuccessDTO.f113071c;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f113069a) * 31) + Boolean.hashCode(this.f113070b)) * 31) + Boolean.hashCode(this.f113071c);
    }

    public String toString() {
        return "PurchaseSuccessDTO(purchaseSuccessTime=" + this.f113069a + ", wasTrialPurchased=" + this.f113070b + ", alreadyOwned=" + this.f113071c + ")";
    }
}
