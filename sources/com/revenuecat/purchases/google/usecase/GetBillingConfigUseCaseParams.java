package com.revenuecat.purchases.google.usecase;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class GetBillingConfigUseCaseParams implements UseCaseParams {
    private final boolean appInBackground;

    public GetBillingConfigUseCaseParams(boolean z2) {
        this.appInBackground = z2;
    }

    public static /* synthetic */ GetBillingConfigUseCaseParams copy$default(GetBillingConfigUseCaseParams getBillingConfigUseCaseParams, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = getBillingConfigUseCaseParams.appInBackground;
        }
        return getBillingConfigUseCaseParams.copy(z2);
    }

    public final boolean component1() {
        return this.appInBackground;
    }

    public final GetBillingConfigUseCaseParams copy(boolean z2) {
        return new GetBillingConfigUseCaseParams(z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetBillingConfigUseCaseParams) && this.appInBackground == ((GetBillingConfigUseCaseParams) obj).appInBackground;
    }

    @Override // com.revenuecat.purchases.google.usecase.UseCaseParams
    public boolean getAppInBackground() {
        return this.appInBackground;
    }

    public int hashCode() {
        return Boolean.hashCode(this.appInBackground);
    }

    public String toString() {
        return "GetBillingConfigUseCaseParams(appInBackground=" + this.appInBackground + ')';
    }
}
