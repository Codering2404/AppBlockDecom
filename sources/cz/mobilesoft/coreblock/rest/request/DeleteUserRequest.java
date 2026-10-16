package cz.mobilesoft.coreblock.rest.request;

import com.facebook.AccessToken;
import com.google.gson.annotations.SerializedName;
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
public final class DeleteUserRequest {
    public static final int $stable = 0;

    @SerializedName("provider")
    private final String provider;

    @SerializedName(AccessToken.TOKEN_KEY)
    private final String token;

    public DeleteUserRequest(String str, String str2) {
        this.token = str;
        this.provider = str2;
    }

    public static /* synthetic */ DeleteUserRequest copy$default(DeleteUserRequest deleteUserRequest, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = deleteUserRequest.token;
        }
        if ((i3 & 2) != 0) {
            str2 = deleteUserRequest.provider;
        }
        return deleteUserRequest.copy(str, str2);
    }

    public final String component1() {
        return this.token;
    }

    public final String component2() {
        return this.provider;
    }

    public final DeleteUserRequest copy(String str, String str2) {
        return new DeleteUserRequest(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteUserRequest)) {
            return false;
        }
        DeleteUserRequest deleteUserRequest = (DeleteUserRequest) obj;
        return Intrinsics.areEqual(this.token, deleteUserRequest.token) && Intrinsics.areEqual(this.provider, deleteUserRequest.provider);
    }

    public final String getProvider() {
        return this.provider;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        String str = this.token;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.provider;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DeleteUserRequest(token=" + this.token + ", provider=" + this.provider + ")";
    }
}
