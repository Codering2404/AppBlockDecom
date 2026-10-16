package cz.mobilesoft.coreblock.scene.more.backup.dto;

import com.google.gson.annotations.SerializedName;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class BlockScreenConfigDTO {

    @SerializedName("buttonTitle")
    private final String buttonTitle;

    @SerializedName("colorHex")
    private final String colorHex;

    @SerializedName("created")
    private final String created;

    @SerializedName("customId")
    private final String customId;

    @SerializedName("emojiId")
    private final Integer emojiId;

    @SerializedName("showBlockedBy")
    private final boolean showBlockedBy;

    @SerializedName("showCounter")
    private final boolean showCounter;

    @SerializedName("subtitle")
    private final String subtitle;

    @SerializedName("timeout")
    private final Integer timeout;

    @SerializedName("title")
    private final String title;

    @SerializedName("typeValue")
    private final int typeValue;

    public BlockScreenConfigDTO(int i3, String str, boolean z2, boolean z3, String str2, Integer num, String str3, String str4, String str5, String str6, Integer num2) {
        this.typeValue = i3;
        this.customId = str;
        this.showCounter = z2;
        this.showBlockedBy = z3;
        this.subtitle = str2;
        this.emojiId = num;
        this.colorHex = str3;
        this.title = str4;
        this.buttonTitle = str5;
        this.created = str6;
        this.timeout = num2;
    }

    public final CustomBlockingScreenConfigEntity a() {
        String str;
        String str2;
        String str3 = this.customId;
        String str4 = str3 == null ? "" : str3;
        Object[] array = ConfigType.getEntries().toArray(new ConfigType[0]);
        int i3 = this.typeValue;
        ConfigType configType = (ConfigType) ((i3 < 0 || i3 >= array.length) ? ConfigType.CUSTOM : array[i3]);
        ConfigType configType2 = ConfigType.CUSTOM;
        if (i3 == configType2.ordinal() || (str = this.subtitle) == null) {
            str = "";
        }
        boolean z2 = this.showBlockedBy;
        Integer num = this.timeout;
        int iIntValue = num != null ? num.intValue() : 0;
        boolean z3 = this.showCounter;
        Integer num2 = this.emojiId;
        int iIntValue2 = num2 != null ? num2.intValue() : ScheduleEmoji.CustomBlockingAppIcon.getId();
        String str5 = this.title;
        String str6 = str5 == null ? "" : str5;
        String str7 = (this.typeValue != configType2.ordinal() || (str2 = this.subtitle) == null) ? "" : str2;
        String str8 = this.buttonTitle;
        String str9 = str8 == null ? "" : str8;
        String str10 = this.colorHex;
        return new CustomBlockingScreenConfigEntity(str4, configType, str, z2, iIntValue, z3, iIntValue2, str6, str7, str9, str10 == null ? "" : str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockScreenConfigDTO)) {
            return false;
        }
        BlockScreenConfigDTO blockScreenConfigDTO = (BlockScreenConfigDTO) obj;
        return this.typeValue == blockScreenConfigDTO.typeValue && Intrinsics.areEqual(this.customId, blockScreenConfigDTO.customId) && this.showCounter == blockScreenConfigDTO.showCounter && this.showBlockedBy == blockScreenConfigDTO.showBlockedBy && Intrinsics.areEqual(this.subtitle, blockScreenConfigDTO.subtitle) && Intrinsics.areEqual(this.emojiId, blockScreenConfigDTO.emojiId) && Intrinsics.areEqual(this.colorHex, blockScreenConfigDTO.colorHex) && Intrinsics.areEqual(this.title, blockScreenConfigDTO.title) && Intrinsics.areEqual(this.buttonTitle, blockScreenConfigDTO.buttonTitle) && Intrinsics.areEqual(this.created, blockScreenConfigDTO.created) && Intrinsics.areEqual(this.timeout, blockScreenConfigDTO.timeout);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.typeValue) * 31;
        String str = this.customId;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.showCounter)) * 31) + Boolean.hashCode(this.showBlockedBy)) * 31;
        String str2 = this.subtitle;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.emojiId;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.colorHex;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.title;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.buttonTitle;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.created;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num2 = this.timeout;
        return iHashCode8 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "BlockScreenConfigDTO(typeValue=" + this.typeValue + ", customId=" + this.customId + ", showCounter=" + this.showCounter + ", showBlockedBy=" + this.showBlockedBy + ", subtitle=" + this.subtitle + ", emojiId=" + this.emojiId + ", colorHex=" + this.colorHex + ", title=" + this.title + ", buttonTitle=" + this.buttonTitle + ", created=" + this.created + ", timeout=" + this.timeout + ")";
    }
}
