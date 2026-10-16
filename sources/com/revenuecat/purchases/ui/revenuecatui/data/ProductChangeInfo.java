package com.revenuecat.purchases.ui.revenuecatui.data;

import com.revenuecat.purchases.models.StoreReplacementMode;
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
public final class ProductChangeInfo {
    public static final int $stable = 8;
    private final String oldProductId;
    private final StoreReplacementMode replacementMode;

    public ProductChangeInfo(String oldProductId, StoreReplacementMode replacementMode) {
        Intrinsics.checkNotNullParameter(oldProductId, "oldProductId");
        Intrinsics.checkNotNullParameter(replacementMode, "replacementMode");
        this.oldProductId = oldProductId;
        this.replacementMode = replacementMode;
    }

    public static /* synthetic */ ProductChangeInfo copy$default(ProductChangeInfo productChangeInfo, String str, StoreReplacementMode storeReplacementMode, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = productChangeInfo.oldProductId;
        }
        if ((i3 & 2) != 0) {
            storeReplacementMode = productChangeInfo.replacementMode;
        }
        return productChangeInfo.copy(str, storeReplacementMode);
    }

    public final String component1() {
        return this.oldProductId;
    }

    public final StoreReplacementMode component2() {
        return this.replacementMode;
    }

    public final ProductChangeInfo copy(String oldProductId, StoreReplacementMode replacementMode) {
        Intrinsics.checkNotNullParameter(oldProductId, "oldProductId");
        Intrinsics.checkNotNullParameter(replacementMode, "replacementMode");
        return new ProductChangeInfo(oldProductId, replacementMode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductChangeInfo)) {
            return false;
        }
        ProductChangeInfo productChangeInfo = (ProductChangeInfo) obj;
        return Intrinsics.areEqual(this.oldProductId, productChangeInfo.oldProductId) && Intrinsics.areEqual(this.replacementMode, productChangeInfo.replacementMode);
    }

    public final String getOldProductId() {
        return this.oldProductId;
    }

    public final StoreReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public int hashCode() {
        return (this.oldProductId.hashCode() * 31) + this.replacementMode.hashCode();
    }

    public String toString() {
        return "ProductChangeInfo(oldProductId=" + this.oldProductId + ", replacementMode=" + this.replacementMode + ')';
    }
}
