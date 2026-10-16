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
public final class AccountabilityPartnerRequest {
    public static final int $stable = 0;

    @SerializedName("deviceId")
    private final String deviceId;

    @SerializedName(AuthenticationTokenClaims.JSON_KEY_EMAIL)
    private final String email;

    public AccountabilityPartnerRequest(String email, String deviceId) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        this.email = email;
        this.deviceId = deviceId;
    }

    public static /* synthetic */ AccountabilityPartnerRequest copy$default(AccountabilityPartnerRequest accountabilityPartnerRequest, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = accountabilityPartnerRequest.email;
        }
        if ((i3 & 2) != 0) {
            str2 = accountabilityPartnerRequest.deviceId;
        }
        return accountabilityPartnerRequest.copy(str, str2);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final AccountabilityPartnerRequest copy(String email, String deviceId) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        return new AccountabilityPartnerRequest(email, deviceId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountabilityPartnerRequest)) {
            return false;
        }
        AccountabilityPartnerRequest accountabilityPartnerRequest = (AccountabilityPartnerRequest) obj;
        return Intrinsics.areEqual(this.email, accountabilityPartnerRequest.email) && Intrinsics.areEqual(this.deviceId, accountabilityPartnerRequest.deviceId);
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getEmail() {
        return this.email;
    }

    public int hashCode() {
        return (this.email.hashCode() * 31) + this.deviceId.hashCode();
    }

    public String toString() {
        return "AccountabilityPartnerRequest(email=" + this.email + ", deviceId=" + this.deviceId + ")";
    }
}
