package com.revenuecat.purchases;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CreateSupportTicketResult {
    private final boolean success;

    public CreateSupportTicketResult(boolean z2) {
        this.success = z2;
    }

    public static /* synthetic */ CreateSupportTicketResult copy$default(CreateSupportTicketResult createSupportTicketResult, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = createSupportTicketResult.success;
        }
        return createSupportTicketResult.copy(z2);
    }

    public final boolean component1() {
        return this.success;
    }

    public final CreateSupportTicketResult copy(boolean z2) {
        return new CreateSupportTicketResult(z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CreateSupportTicketResult) && this.success == ((CreateSupportTicketResult) obj).success;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        return Boolean.hashCode(this.success);
    }

    public String toString() {
        return "CreateSupportTicketResult(success=" + this.success + ')';
    }
}
