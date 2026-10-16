package com.revenuecat.purchases;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public class PurchasesException extends Exception {
    private final PurchasesError error;
    private final String overridenMessage;

    public /* synthetic */ PurchasesException(PurchasesError purchasesError, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(purchasesError, (i3 & 2) != 0 ? null : str);
    }

    public final PurchasesErrorCode getCode() {
        return this.error.getCode();
    }

    public final PurchasesError getError() {
        return this.error;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str = this.overridenMessage;
        return str == null ? this.error.getMessage() : str;
    }

    public final String getOverridenMessage$purchases_defaultsBc8Release() {
        return this.overridenMessage;
    }

    public final String getUnderlyingErrorMessage() {
        return this.error.getUnderlyingErrorMessage();
    }

    public PurchasesException(PurchasesError error, String str) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.error = error;
        this.overridenMessage = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PurchasesException(PurchasesError error) {
        this(error, null);
        Intrinsics.checkNotNullParameter(error, "error");
    }
}
