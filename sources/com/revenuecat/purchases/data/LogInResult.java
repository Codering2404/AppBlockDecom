package com.revenuecat.purchases.data;

import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import com.revenuecat.purchases.CustomerInfo;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class LogInResult {
    private final boolean created;
    private final CustomerInfo customerInfo;

    public LogInResult(CustomerInfo customerInfo, boolean z2) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        this.customerInfo = customerInfo;
        this.created = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogInResult)) {
            return false;
        }
        LogInResult logInResult = (LogInResult) obj;
        return Intrinsics.areEqual(this.customerInfo, logInResult.customerInfo) && this.created == logInResult.created;
    }

    public final boolean getCreated() {
        return this.created;
    }

    public final CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    public int hashCode() {
        return (this.customerInfo.hashCode() * 31) + Boolean.hashCode(this.created);
    }

    public String toString() {
        return jlWo.dXSR + this.customerInfo + ", created=" + this.created + ')';
    }
}
