package cz.mobilesoft.coreblock.scene.more.backup.dto;

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
public final class QuickBlockNotificationsDTO {

    @SerializedName("afterEnd")
    private final boolean afterEnd;

    @SerializedName("pomodoro")
    private final boolean pomodoro;

    @SerializedName("showBlockedNotifications")
    private final boolean showBlockedNotifications;

    public QuickBlockNotificationsDTO(boolean z2, boolean z3, boolean z4) {
        this.afterEnd = z2;
        this.showBlockedNotifications = z3;
        this.pomodoro = z4;
    }

    public final boolean a() {
        return this.afterEnd;
    }

    public final boolean b() {
        return this.pomodoro;
    }

    public final boolean c() {
        return this.showBlockedNotifications;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuickBlockNotificationsDTO)) {
            return false;
        }
        QuickBlockNotificationsDTO quickBlockNotificationsDTO = (QuickBlockNotificationsDTO) obj;
        return this.afterEnd == quickBlockNotificationsDTO.afterEnd && this.showBlockedNotifications == quickBlockNotificationsDTO.showBlockedNotifications && this.pomodoro == quickBlockNotificationsDTO.pomodoro;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.afterEnd) * 31) + Boolean.hashCode(this.showBlockedNotifications)) * 31) + Boolean.hashCode(this.pomodoro);
    }

    public String toString() {
        return "QuickBlockNotificationsDTO(afterEnd=" + this.afterEnd + ", showBlockedNotifications=" + this.showBlockedNotifications + ", pomodoro=" + this.pomodoro + ")";
    }
}
