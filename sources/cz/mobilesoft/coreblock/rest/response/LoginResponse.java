package cz.mobilesoft.coreblock.rest.response;

import com.facebook.AuthenticationTokenClaims;
import com.google.gson.annotations.SerializedName;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
public final class LoginResponse {
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

    @SerializedName("refreshToken")
    private final String refreshToken;

    @SerializedName("registeredAt")
    private final String registeredAt;

    @SerializedName("jwt")
    private final String token;

    public LoginResponse(String token, String str, String email, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(email, "email");
        this.token = token;
        this.refreshToken = str;
        this.email = email;
        this.nickname = str2;
        this.customerId = str3;
        this.registeredAt = str4;
        this.picture = str5;
        this.emailConsent = str6;
    }

    public static /* synthetic */ LoginResponse copy$default(LoginResponse loginResponse, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = loginResponse.token;
        }
        if ((i3 & 2) != 0) {
            str2 = loginResponse.refreshToken;
        }
        if ((i3 & 4) != 0) {
            str3 = loginResponse.email;
        }
        if ((i3 & 8) != 0) {
            str4 = loginResponse.nickname;
        }
        if ((i3 & 16) != 0) {
            str5 = loginResponse.customerId;
        }
        if ((i3 & 32) != 0) {
            str6 = loginResponse.registeredAt;
        }
        if ((i3 & 64) != 0) {
            str7 = loginResponse.picture;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            str8 = loginResponse.emailConsent;
        }
        String str9 = str7;
        String str10 = str8;
        String str11 = str5;
        String str12 = str6;
        return loginResponse.copy(str, str2, str3, str4, str11, str12, str9, str10);
    }

    public final String component1() {
        return this.token;
    }

    public final String component2() {
        return this.refreshToken;
    }

    public final String component3() {
        return this.email;
    }

    public final String component4() {
        return this.nickname;
    }

    public final String component5() {
        return this.customerId;
    }

    public final String component6() {
        return this.registeredAt;
    }

    public final String component7() {
        return this.picture;
    }

    public final String component8() {
        return this.emailConsent;
    }

    public final LoginResponse copy(String token, String str, String email, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(email, "email");
        return new LoginResponse(token, str, email, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoginResponse)) {
            return false;
        }
        LoginResponse loginResponse = (LoginResponse) obj;
        return Intrinsics.areEqual(this.token, loginResponse.token) && Intrinsics.areEqual(this.refreshToken, loginResponse.refreshToken) && Intrinsics.areEqual(this.email, loginResponse.email) && Intrinsics.areEqual(this.nickname, loginResponse.nickname) && Intrinsics.areEqual(this.customerId, loginResponse.customerId) && Intrinsics.areEqual(this.registeredAt, loginResponse.registeredAt) && Intrinsics.areEqual(this.picture, loginResponse.picture) && Intrinsics.areEqual(this.emailConsent, loginResponse.emailConsent);
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

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final String getRegisteredAt() {
        return this.registeredAt;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        int iHashCode = this.token.hashCode() * 31;
        String str = this.refreshToken;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.email.hashCode()) * 31;
        String str2 = this.nickname;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.customerId;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.registeredAt;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.picture;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.emailConsent;
        return iHashCode6 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "LoginResponse(token=" + this.token + ", refreshToken=" + this.refreshToken + ", email=" + this.email + ", nickname=" + this.nickname + ", customerId=" + this.customerId + ", registeredAt=" + this.registeredAt + ", picture=" + this.picture + ", emailConsent=" + this.emailConsent + ")";
    }
}
