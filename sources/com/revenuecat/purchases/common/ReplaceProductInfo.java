package com.revenuecat.purchases.common;

import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.models.StoreTransaction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class ReplaceProductInfo {
    private final StoreTransaction oldPurchase;
    private final ReplacementMode replacementMode;

    public ReplaceProductInfo(StoreTransaction oldPurchase, ReplacementMode replacementMode) {
        Intrinsics.checkNotNullParameter(oldPurchase, "oldPurchase");
        this.oldPurchase = oldPurchase;
        this.replacementMode = replacementMode;
    }

    public static /* synthetic */ ReplaceProductInfo copy$default(ReplaceProductInfo replaceProductInfo, StoreTransaction storeTransaction, ReplacementMode replacementMode, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            storeTransaction = replaceProductInfo.oldPurchase;
        }
        if ((i3 & 2) != 0) {
            replacementMode = replaceProductInfo.replacementMode;
        }
        return replaceProductInfo.copy(storeTransaction, replacementMode);
    }

    public final StoreTransaction component1() {
        return this.oldPurchase;
    }

    public final ReplacementMode component2() {
        return this.replacementMode;
    }

    public final ReplaceProductInfo copy(StoreTransaction oldPurchase, ReplacementMode replacementMode) {
        Intrinsics.checkNotNullParameter(oldPurchase, "oldPurchase");
        return new ReplaceProductInfo(oldPurchase, replacementMode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReplaceProductInfo)) {
            return false;
        }
        ReplaceProductInfo replaceProductInfo = (ReplaceProductInfo) obj;
        return Intrinsics.areEqual(this.oldPurchase, replaceProductInfo.oldPurchase) && Intrinsics.areEqual(this.replacementMode, replaceProductInfo.replacementMode);
    }

    public final StoreTransaction getOldPurchase() {
        return this.oldPurchase;
    }

    public final ReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public int hashCode() {
        int iHashCode = this.oldPurchase.hashCode() * 31;
        ReplacementMode replacementMode = this.replacementMode;
        return iHashCode + (replacementMode == null ? 0 : replacementMode.hashCode());
    }

    public String toString() {
        return "ReplaceProductInfo(oldPurchase=" + this.oldPurchase + ", replacementMode=" + this.replacementMode + ')';
    }

    public /* synthetic */ ReplaceProductInfo(StoreTransaction storeTransaction, ReplacementMode replacementMode, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeTransaction, (i3 & 2) != 0 ? null : replacementMode);
    }
}
