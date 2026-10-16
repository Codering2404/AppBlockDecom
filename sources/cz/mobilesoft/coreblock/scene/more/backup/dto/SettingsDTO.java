package cz.mobilesoft.coreblock.scene.more.backup.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;
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
public final class SettingsDTO {

    @SerializedName("appIcon")
    private final int appIcon;

    @SerializedName("blockPopupWindows")
    private final Boolean blockPopupWindows;

    @SerializedName("blockScreenMessage")
    private final String blockScreenMessage;

    @SerializedName("blockScreenSettings")
    private final BlockScreenSettingsDTO blockScreenSettings;

    @SerializedName("blockScreenTimeout")
    private final int blockScreenTimeout;

    @SerializedName("checkAppUpdates")
    private final boolean checkAppUpdates;

    @SerializedName("enableSchedulePause")
    private final boolean enableSchedulePause;

    @SerializedName("excludedUnsupportedBrowsers")
    private final List<String> excludedUnsupportedBrowsers;

    @SerializedName("notifications")
    private final NotificationsDTO notifications;

    @SerializedName("quickBlockEnabled")
    private final boolean quickBlockEnabled;

    @SerializedName("showAvailableSettings")
    private final boolean showAvailableSettings;

    @SerializedName("whenLocationUnavailable")
    private final boolean whenLocationUnavailable;

    public SettingsDTO(NotificationsDTO notifications, boolean z2, String blockScreenMessage, int i3, int i4, boolean z3, boolean z4, boolean z5, boolean z6, List excludedUnsupportedBrowsers, BlockScreenSettingsDTO blockScreenSettingsDTO, Boolean bool) {
        Intrinsics.checkNotNullParameter(notifications, "notifications");
        Intrinsics.checkNotNullParameter(blockScreenMessage, "blockScreenMessage");
        Intrinsics.checkNotNullParameter(excludedUnsupportedBrowsers, "excludedUnsupportedBrowsers");
        this.notifications = notifications;
        this.enableSchedulePause = z2;
        this.blockScreenMessage = blockScreenMessage;
        this.blockScreenTimeout = i3;
        this.appIcon = i4;
        this.quickBlockEnabled = z3;
        this.whenLocationUnavailable = z4;
        this.showAvailableSettings = z5;
        this.checkAppUpdates = z6;
        this.excludedUnsupportedBrowsers = excludedUnsupportedBrowsers;
        this.blockScreenSettings = blockScreenSettingsDTO;
        this.blockPopupWindows = bool;
    }

    public final int a() {
        return this.appIcon;
    }

    public final Boolean b() {
        return this.blockPopupWindows;
    }

    public final String c() {
        return this.blockScreenMessage;
    }

    public final BlockScreenSettingsDTO d() {
        return this.blockScreenSettings;
    }

    public final int e() {
        return this.blockScreenTimeout;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettingsDTO)) {
            return false;
        }
        SettingsDTO settingsDTO = (SettingsDTO) obj;
        return Intrinsics.areEqual(this.notifications, settingsDTO.notifications) && this.enableSchedulePause == settingsDTO.enableSchedulePause && Intrinsics.areEqual(this.blockScreenMessage, settingsDTO.blockScreenMessage) && this.blockScreenTimeout == settingsDTO.blockScreenTimeout && this.appIcon == settingsDTO.appIcon && this.quickBlockEnabled == settingsDTO.quickBlockEnabled && this.whenLocationUnavailable == settingsDTO.whenLocationUnavailable && this.showAvailableSettings == settingsDTO.showAvailableSettings && this.checkAppUpdates == settingsDTO.checkAppUpdates && Intrinsics.areEqual(this.excludedUnsupportedBrowsers, settingsDTO.excludedUnsupportedBrowsers) && Intrinsics.areEqual(this.blockScreenSettings, settingsDTO.blockScreenSettings) && Intrinsics.areEqual(this.blockPopupWindows, settingsDTO.blockPopupWindows);
    }

    public final boolean f() {
        return this.checkAppUpdates;
    }

    public final boolean g() {
        return this.enableSchedulePause;
    }

    public final List h() {
        return this.excludedUnsupportedBrowsers;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((this.notifications.hashCode() * 31) + Boolean.hashCode(this.enableSchedulePause)) * 31) + this.blockScreenMessage.hashCode()) * 31) + Integer.hashCode(this.blockScreenTimeout)) * 31) + Integer.hashCode(this.appIcon)) * 31) + Boolean.hashCode(this.quickBlockEnabled)) * 31) + Boolean.hashCode(this.whenLocationUnavailable)) * 31) + Boolean.hashCode(this.showAvailableSettings)) * 31) + Boolean.hashCode(this.checkAppUpdates)) * 31) + this.excludedUnsupportedBrowsers.hashCode()) * 31;
        BlockScreenSettingsDTO blockScreenSettingsDTO = this.blockScreenSettings;
        int iHashCode2 = (iHashCode + (blockScreenSettingsDTO == null ? 0 : blockScreenSettingsDTO.hashCode())) * 31;
        Boolean bool = this.blockPopupWindows;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public final NotificationsDTO i() {
        return this.notifications;
    }

    public final boolean j() {
        return this.quickBlockEnabled;
    }

    public final boolean k() {
        return this.showAvailableSettings;
    }

    public final boolean l() {
        return this.whenLocationUnavailable;
    }

    public String toString() {
        return "SettingsDTO(notifications=" + this.notifications + ", enableSchedulePause=" + this.enableSchedulePause + ", blockScreenMessage=" + this.blockScreenMessage + ", blockScreenTimeout=" + this.blockScreenTimeout + ", appIcon=" + this.appIcon + ", quickBlockEnabled=" + this.quickBlockEnabled + ", whenLocationUnavailable=" + this.whenLocationUnavailable + ", showAvailableSettings=" + this.showAvailableSettings + ", checkAppUpdates=" + this.checkAppUpdates + ", excludedUnsupportedBrowsers=" + this.excludedUnsupportedBrowsers + ", blockScreenSettings=" + this.blockScreenSettings + ", blockPopupWindows=" + this.blockPopupWindows + ")";
    }
}
