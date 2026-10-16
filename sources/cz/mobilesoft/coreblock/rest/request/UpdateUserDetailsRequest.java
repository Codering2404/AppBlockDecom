package cz.mobilesoft.coreblock.rest.request;

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
public final class UpdateUserDetailsRequest {
    public static final int $stable = 0;

    @SerializedName("nickname")
    private final String nickname;

    public UpdateUserDetailsRequest(String nickname) {
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        this.nickname = nickname;
    }

    public static /* synthetic */ UpdateUserDetailsRequest copy$default(UpdateUserDetailsRequest updateUserDetailsRequest, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = updateUserDetailsRequest.nickname;
        }
        return updateUserDetailsRequest.copy(str);
    }

    public final String component1() {
        return this.nickname;
    }

    public final UpdateUserDetailsRequest copy(String nickname) {
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        return new UpdateUserDetailsRequest(nickname);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UpdateUserDetailsRequest) && Intrinsics.areEqual(this.nickname, ((UpdateUserDetailsRequest) obj).nickname);
    }

    public final String getNickname() {
        return this.nickname;
    }

    public int hashCode() {
        return this.nickname.hashCode();
    }

    public String toString() {
        return "UpdateUserDetailsRequest(nickname=" + this.nickname + ")";
    }
}
