package cz.mobilesoft.coreblock.rest.request;

import com.facebook.AuthenticationTokenClaims;
import com.google.gson.annotations.SerializedName;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ResetPasswordRequest {
    public static final int $stable = 8;

    @SerializedName("code")
    private String code;

    @SerializedName(AuthenticationTokenClaims.JSON_KEY_EMAIL)
    private final String email;

    @SerializedName("newPassword")
    private String password;

    public ResetPasswordRequest(String email, String code, String str) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(code, "code");
        this.email = email;
        this.code = code;
        this.password = str;
    }

    public static /* synthetic */ ResetPasswordRequest copy$default(ResetPasswordRequest resetPasswordRequest, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = resetPasswordRequest.email;
        }
        if ((i3 & 2) != 0) {
            str2 = resetPasswordRequest.code;
        }
        if ((i3 & 4) != 0) {
            str3 = resetPasswordRequest.password;
        }
        return resetPasswordRequest.copy(str, str2, str3);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.code;
    }

    public final String component3() {
        return this.password;
    }

    public final ResetPasswordRequest copy(String email, String code, String str) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(code, "code");
        return new ResetPasswordRequest(email, code, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResetPasswordRequest)) {
            return false;
        }
        ResetPasswordRequest resetPasswordRequest = (ResetPasswordRequest) obj;
        return Intrinsics.areEqual(this.email, resetPasswordRequest.email) && Intrinsics.areEqual(this.code, resetPasswordRequest.code) && Intrinsics.areEqual(this.password, resetPasswordRequest.password);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPassword() {
        return this.password;
    }

    public int hashCode() {
        int iHashCode = ((this.email.hashCode() * 31) + this.code.hashCode()) * 31;
        String str = this.password;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.code = str;
    }

    public final void setPassword(String str) {
        this.password = str;
    }

    public String toString() {
        return "ResetPasswordRequest(email=" + this.email + ", code=" + this.code + ", password=" + this.password + ")";
    }

    public /* synthetic */ ResetPasswordRequest(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? null : str3);
    }
}
