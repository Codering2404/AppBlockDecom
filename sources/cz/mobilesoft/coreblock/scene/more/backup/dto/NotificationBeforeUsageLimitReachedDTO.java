package cz.mobilesoft.coreblock.scene.more.backup.dto;

import com.facebook.GraphRequest;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class NotificationBeforeUsageLimitReachedDTO {

    @SerializedName(GraphRequest.BATCH_METHOD_PARAM)
    private final int method;

    @SerializedName("timer")
    private final int timer;

    public NotificationBeforeUsageLimitReachedDTO(int i3, int i4) {
        this.timer = i3;
        this.method = i4;
    }

    public final int a() {
        return this.method;
    }

    public final int b() {
        return this.timer;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationBeforeUsageLimitReachedDTO)) {
            return false;
        }
        NotificationBeforeUsageLimitReachedDTO notificationBeforeUsageLimitReachedDTO = (NotificationBeforeUsageLimitReachedDTO) obj;
        return this.timer == notificationBeforeUsageLimitReachedDTO.timer && this.method == notificationBeforeUsageLimitReachedDTO.method;
    }

    public int hashCode() {
        return (Integer.hashCode(this.timer) * 31) + Integer.hashCode(this.method);
    }

    public String toString() {
        return "NotificationBeforeUsageLimitReachedDTO(timer=" + this.timer + ", method=" + this.method + ")";
    }
}
