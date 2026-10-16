package cz.mobilesoft.coreblock.dto.diagnostic;

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
public final class RecentNetworkErrorsDTO {

    @SerializedName("code")
    private final int code;

    @SerializedName("endpoint")
    private final String endpoint;

    @SerializedName("message")
    private final String message;

    @SerializedName("timestamp")
    private final long timestamp;

    public RecentNetworkErrorsDTO(long j3, String endpoint, String message, int i3) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(message, "message");
        this.timestamp = j3;
        this.endpoint = endpoint;
        this.message = message;
        this.code = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecentNetworkErrorsDTO)) {
            return false;
        }
        RecentNetworkErrorsDTO recentNetworkErrorsDTO = (RecentNetworkErrorsDTO) obj;
        return this.timestamp == recentNetworkErrorsDTO.timestamp && Intrinsics.areEqual(this.endpoint, recentNetworkErrorsDTO.endpoint) && Intrinsics.areEqual(this.message, recentNetworkErrorsDTO.message) && this.code == recentNetworkErrorsDTO.code;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.timestamp) * 31) + this.endpoint.hashCode()) * 31) + this.message.hashCode()) * 31) + Integer.hashCode(this.code);
    }

    public String toString() {
        return "RecentNetworkErrorsDTO(timestamp=" + this.timestamp + ", endpoint=" + this.endpoint + ", message=" + this.message + ", code=" + this.code + ")";
    }
}
