package com.superwall.sdk.billing;

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
public final class ConsumePurchaseUseCaseParams implements UseCaseParams {
    private final boolean appInBackground;
    private final String purchaseToken;

    public ConsumePurchaseUseCaseParams(String purchaseToken, boolean z2) {
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        this.purchaseToken = purchaseToken;
        this.appInBackground = z2;
    }

    public static /* synthetic */ ConsumePurchaseUseCaseParams copy$default(ConsumePurchaseUseCaseParams consumePurchaseUseCaseParams, String str, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = consumePurchaseUseCaseParams.purchaseToken;
        }
        if ((i3 & 2) != 0) {
            z2 = consumePurchaseUseCaseParams.appInBackground;
        }
        return consumePurchaseUseCaseParams.copy(str, z2);
    }

    public final String component1() {
        return this.purchaseToken;
    }

    public final boolean component2() {
        return this.appInBackground;
    }

    public final ConsumePurchaseUseCaseParams copy(String purchaseToken, boolean z2) {
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        return new ConsumePurchaseUseCaseParams(purchaseToken, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsumePurchaseUseCaseParams)) {
            return false;
        }
        ConsumePurchaseUseCaseParams consumePurchaseUseCaseParams = (ConsumePurchaseUseCaseParams) obj;
        return Intrinsics.areEqual(this.purchaseToken, consumePurchaseUseCaseParams.purchaseToken) && this.appInBackground == consumePurchaseUseCaseParams.appInBackground;
    }

    @Override // com.superwall.sdk.billing.UseCaseParams
    public boolean getAppInBackground() {
        return this.appInBackground;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public int hashCode() {
        return (this.purchaseToken.hashCode() * 31) + Boolean.hashCode(this.appInBackground);
    }

    public String toString() {
        return "ConsumePurchaseUseCaseParams(purchaseToken=" + this.purchaseToken + ", appInBackground=" + this.appInBackground + ")";
    }
}
