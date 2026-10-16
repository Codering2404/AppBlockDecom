package cz.mobilesoft.coreblock.rest.response;

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
public final class TokenResponse {
    public static final int $stable = 0;

    @SerializedName("refreshToken")
    private final String refreshToken;

    @SerializedName("jwt")
    private final String token;

    public TokenResponse(String token, String str) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.token = token;
        this.refreshToken = str;
    }

    public static /* synthetic */ TokenResponse copy$default(TokenResponse tokenResponse, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = tokenResponse.token;
        }
        if ((i3 & 2) != 0) {
            str2 = tokenResponse.refreshToken;
        }
        return tokenResponse.copy(str, str2);
    }

    public final String component1() {
        return this.token;
    }

    public final String component2() {
        return this.refreshToken;
    }

    public final TokenResponse copy(String token, String str) {
        Intrinsics.checkNotNullParameter(token, "token");
        return new TokenResponse(token, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenResponse)) {
            return false;
        }
        TokenResponse tokenResponse = (TokenResponse) obj;
        return Intrinsics.areEqual(this.token, tokenResponse.token) && Intrinsics.areEqual(this.refreshToken, tokenResponse.refreshToken);
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        int iHashCode = this.token.hashCode() * 31;
        String str = this.refreshToken;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "TokenResponse(token=" + this.token + ", refreshToken=" + this.refreshToken + ")";
    }

    public /* synthetic */ TokenResponse(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2);
    }
}
