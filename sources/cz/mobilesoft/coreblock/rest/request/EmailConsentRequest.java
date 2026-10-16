package cz.mobilesoft.coreblock.rest.request;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

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
public final class EmailConsentRequest {
    public static final int $stable = 0;

    @SerializedName("consent")
    private final boolean consent;

    public EmailConsentRequest(boolean z2) {
        this.consent = z2;
    }

    public static /* synthetic */ EmailConsentRequest copy$default(EmailConsentRequest emailConsentRequest, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = emailConsentRequest.consent;
        }
        return emailConsentRequest.copy(z2);
    }

    public final boolean component1() {
        return this.consent;
    }

    public final EmailConsentRequest copy(boolean z2) {
        return new EmailConsentRequest(z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EmailConsentRequest) && this.consent == ((EmailConsentRequest) obj).consent;
    }

    public final boolean getConsent() {
        return this.consent;
    }

    public int hashCode() {
        return Boolean.hashCode(this.consent);
    }

    public String toString() {
        return "EmailConsentRequest(consent=" + this.consent + ")";
    }
}
