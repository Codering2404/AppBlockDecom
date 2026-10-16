package com.superwall.sdk.store.abstractions.product.receipt;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class InAppPurchase {
    private String fullIdentifier;
    private String productIdentifier;

    public InAppPurchase(String productIdentifier, String fullIdentifier) {
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(fullIdentifier, "fullIdentifier");
        this.productIdentifier = productIdentifier;
        this.fullIdentifier = fullIdentifier;
    }

    public static /* synthetic */ InAppPurchase copy$default(InAppPurchase inAppPurchase, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = inAppPurchase.productIdentifier;
        }
        if ((i3 & 2) != 0) {
            str2 = inAppPurchase.fullIdentifier;
        }
        return inAppPurchase.copy(str, str2);
    }

    public final String component1() {
        return this.productIdentifier;
    }

    public final String component2() {
        return this.fullIdentifier;
    }

    public final InAppPurchase copy(String productIdentifier, String fullIdentifier) {
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(fullIdentifier, "fullIdentifier");
        return new InAppPurchase(productIdentifier, fullIdentifier);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InAppPurchase)) {
            return false;
        }
        InAppPurchase inAppPurchase = (InAppPurchase) obj;
        return Intrinsics.areEqual(this.productIdentifier, inAppPurchase.productIdentifier) && Intrinsics.areEqual(this.fullIdentifier, inAppPurchase.fullIdentifier);
    }

    public final String getFullIdentifier() {
        return this.fullIdentifier;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public int hashCode() {
        return (this.productIdentifier.hashCode() * 31) + this.fullIdentifier.hashCode();
    }

    public final void setFullIdentifier(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fullIdentifier = str;
    }

    public String toString() {
        return "InAppPurchase(productIdentifier=" + this.productIdentifier + ", fullIdentifier=" + this.fullIdentifier + ")";
    }

    public final void setProductIdentifier(String str) {
        Intrinsics.checkNotNullParameter(str, QaXmqxvjHhxVy.TRFMoWWE);
        this.productIdentifier = str;
    }
}
