package cz.mobilesoft.coreblock.dto.diagnostic;

import com.google.gson.annotations.SerializedName;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WifiNetwork;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ProfileWifiNetworkDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f96974a = new Companion(null);

    @SerializedName("ssid")
    private final String ssid;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProfileWifiNetworkDTO a(WifiNetwork wifi) {
            Intrinsics.checkNotNullParameter(wifi, "wifi");
            return new ProfileWifiNetworkDTO(wifi.c());
        }

        private Companion() {
        }
    }

    public ProfileWifiNetworkDTO(String ssid) {
        Intrinsics.checkNotNullParameter(ssid, "ssid");
        this.ssid = ssid;
    }

    public final String a() {
        return this.ssid;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ProfileWifiNetworkDTO) && Intrinsics.areEqual(this.ssid, ((ProfileWifiNetworkDTO) obj).ssid);
    }

    public int hashCode() {
        return this.ssid.hashCode();
    }

    public String toString() {
        return "ProfileWifiNetworkDTO(ssid=" + this.ssid + ")";
    }
}
