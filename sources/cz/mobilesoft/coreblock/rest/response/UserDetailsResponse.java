package cz.mobilesoft.coreblock.rest.response;

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
public final class UserDetailsResponse {
    public static final int $stable = 0;

    @SerializedName("customerId")
    private final String customerId;

    @SerializedName(AuthenticationTokenClaims.JSON_KEY_EMAIL)
    private final String email;

    @SerializedName("emailConsent")
    private final String emailConsent;

    @SerializedName("nickname")
    private final String nickname;

    @SerializedName("picture")
    private final String picture;

    @SerializedName("registeredAt")
    private final String registeredAt;

    public UserDetailsResponse(String email, String str, String customerId, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(customerId, "customerId");
        this.email = email;
        this.nickname = str;
        this.customerId = customerId;
        this.registeredAt = str2;
        this.picture = str3;
        this.emailConsent = str4;
    }

    public static /* synthetic */ UserDetailsResponse copy$default(UserDetailsResponse userDetailsResponse, String str, String str2, String str3, String str4, String str5, String str6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = userDetailsResponse.email;
        }
        if ((i3 & 2) != 0) {
            str2 = userDetailsResponse.nickname;
        }
        if ((i3 & 4) != 0) {
            str3 = userDetailsResponse.customerId;
        }
        if ((i3 & 8) != 0) {
            str4 = userDetailsResponse.registeredAt;
        }
        if ((i3 & 16) != 0) {
            str5 = userDetailsResponse.picture;
        }
        if ((i3 & 32) != 0) {
            str6 = userDetailsResponse.emailConsent;
        }
        String str7 = str5;
        String str8 = str6;
        return userDetailsResponse.copy(str, str2, str3, str4, str7, str8);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.nickname;
    }

    public final String component3() {
        return this.customerId;
    }

    public final String component4() {
        return this.registeredAt;
    }

    public final String component5() {
        return this.picture;
    }

    public final String component6() {
        return this.emailConsent;
    }

    public final UserDetailsResponse copy(String email, String str, String customerId, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(customerId, "customerId");
        return new UserDetailsResponse(email, str, customerId, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserDetailsResponse)) {
            return false;
        }
        UserDetailsResponse userDetailsResponse = (UserDetailsResponse) obj;
        return Intrinsics.areEqual(this.email, userDetailsResponse.email) && Intrinsics.areEqual(this.nickname, userDetailsResponse.nickname) && Intrinsics.areEqual(this.customerId, userDetailsResponse.customerId) && Intrinsics.areEqual(this.registeredAt, userDetailsResponse.registeredAt) && Intrinsics.areEqual(this.picture, userDetailsResponse.picture) && Intrinsics.areEqual(this.emailConsent, userDetailsResponse.emailConsent);
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getEmailConsent() {
        return this.emailConsent;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final String getRegisteredAt() {
        return this.registeredAt;
    }

    public int hashCode() {
        int iHashCode = this.email.hashCode() * 31;
        String str = this.nickname;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.customerId.hashCode()) * 31;
        String str2 = this.registeredAt;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.picture;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.emailConsent;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "UserDetailsResponse(email=" + this.email + ", nickname=" + this.nickname + ", customerId=" + this.customerId + ", registeredAt=" + this.registeredAt + ", picture=" + this.picture + ", emailConsent=" + this.emailConsent + ")";
    }
}
