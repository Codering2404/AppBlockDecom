package cz.mobilesoft.coreblock.rest.request;

import com.facebook.AuthenticationTokenClaims;
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
public final class RegisterRequest {
    public static final int $stable = 0;

    @SerializedName(AuthenticationTokenClaims.JSON_KEY_EMAIL)
    private final String email;

    @SerializedName("password")
    private final String password;

    public RegisterRequest(String email, String password) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        this.email = email;
        this.password = password;
    }

    public static /* synthetic */ RegisterRequest copy$default(RegisterRequest registerRequest, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = registerRequest.email;
        }
        if ((i3 & 2) != 0) {
            str2 = registerRequest.password;
        }
        return registerRequest.copy(str, str2);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.password;
    }

    public final RegisterRequest copy(String email, String password) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        return new RegisterRequest(email, password);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterRequest)) {
            return false;
        }
        RegisterRequest registerRequest = (RegisterRequest) obj;
        return Intrinsics.areEqual(this.email, registerRequest.email) && Intrinsics.areEqual(this.password, registerRequest.password);
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPassword() {
        return this.password;
    }

    public int hashCode() {
        return (this.email.hashCode() * 31) + this.password.hashCode();
    }

    public String toString() {
        return "RegisterRequest(email=" + this.email + ", password=" + this.password + ")";
    }
}
