package cz.mobilesoft.coreblock.util.monetization;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class PremiumEntitlement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f128904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f128905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f128906c;

    public PremiumEntitlement(String productId, String storeName, boolean z2) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(storeName, "storeName");
        this.f128904a = productId;
        this.f128905b = storeName;
        this.f128906c = z2;
    }

    public final String a() {
        return this.f128904a;
    }

    public final String b() {
        return this.f128905b;
    }

    public final boolean c() {
        return this.f128906c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PremiumEntitlement)) {
            return false;
        }
        PremiumEntitlement premiumEntitlement = (PremiumEntitlement) obj;
        return Intrinsics.areEqual(this.f128904a, premiumEntitlement.f128904a) && Intrinsics.areEqual(this.f128905b, premiumEntitlement.f128905b) && this.f128906c == premiumEntitlement.f128906c;
    }

    public int hashCode() {
        return (((this.f128904a.hashCode() * 31) + this.f128905b.hashCode()) * 31) + Boolean.hashCode(this.f128906c);
    }

    public String toString() {
        return "PremiumEntitlement(productId=" + this.f128904a + ", storeName=" + this.f128905b + ", isPlayStore=" + this.f128906c + ")";
    }
}
