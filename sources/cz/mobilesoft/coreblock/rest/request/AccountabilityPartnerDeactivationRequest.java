package cz.mobilesoft.coreblock.rest.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;

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
public final class AccountabilityPartnerDeactivationRequest {
    public static final int $stable = 0;
    private final String id;

    public AccountabilityPartnerDeactivationRequest(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
    }

    public static /* synthetic */ AccountabilityPartnerDeactivationRequest copy$default(AccountabilityPartnerDeactivationRequest accountabilityPartnerDeactivationRequest, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = accountabilityPartnerDeactivationRequest.id;
        }
        return accountabilityPartnerDeactivationRequest.copy(str);
    }

    public final String component1() {
        return this.id;
    }

    public final AccountabilityPartnerDeactivationRequest copy(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new AccountabilityPartnerDeactivationRequest(id);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AccountabilityPartnerDeactivationRequest) && Intrinsics.areEqual(this.id, ((AccountabilityPartnerDeactivationRequest) obj).id);
    }

    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        return "AccountabilityPartnerDeactivationRequest(id=" + this.id + ")";
    }

    @Serializable
    public static /* synthetic */ void getId$annotations() {
    }
}
