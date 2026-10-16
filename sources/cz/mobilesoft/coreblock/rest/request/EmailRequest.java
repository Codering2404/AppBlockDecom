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
public final class EmailRequest {
    public static final int $stable = 0;

    @SerializedName(AuthenticationTokenClaims.JSON_KEY_EMAIL)
    private final String email;

    public EmailRequest(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        this.email = email;
    }

    public static /* synthetic */ EmailRequest copy$default(EmailRequest emailRequest, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = emailRequest.email;
        }
        return emailRequest.copy(str);
    }

    public final String component1() {
        return this.email;
    }

    public final EmailRequest copy(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        return new EmailRequest(email);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EmailRequest) && Intrinsics.areEqual(this.email, ((EmailRequest) obj).email);
    }

    public final String getEmail() {
        return this.email;
    }

    public int hashCode() {
        return this.email.hashCode();
    }

    public String toString() {
        return "EmailRequest(email=" + this.email + ")";
    }
}
