package com.revenuecat.purchases.ui.revenuecatui;

import com.revenuecat.purchases.ReplacementMode;
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
public final class ProductChange {
    public static final int $stable = 8;
    private final String oldProductId;
    private final ReplacementMode replacementMode;

    public ProductChange(String oldProductId, ReplacementMode replacementMode) {
        Intrinsics.checkNotNullParameter(oldProductId, "oldProductId");
        this.oldProductId = oldProductId;
        this.replacementMode = replacementMode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductChange)) {
            return false;
        }
        ProductChange productChange = (ProductChange) obj;
        return Intrinsics.areEqual(this.oldProductId, productChange.oldProductId) && Intrinsics.areEqual(this.replacementMode, productChange.replacementMode);
    }

    public final String getOldProductId() {
        return this.oldProductId;
    }

    public final ReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public int hashCode() {
        int iHashCode = this.oldProductId.hashCode() * 31;
        ReplacementMode replacementMode = this.replacementMode;
        return iHashCode + (replacementMode == null ? 0 : replacementMode.hashCode());
    }

    public String toString() {
        return "ProductChange(oldProductId=" + this.oldProductId + ", replacementMode=" + this.replacementMode + ')';
    }
}
