package cz.mobilesoft.coreblock.storage.room.dto.blocking;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class BrowserConfigJson {

    @SerializedName("clearUrl")
    private final Boolean clearUrl;

    @SerializedName("clickToOpenUrlBarViewId")
    private final String clickToOpenUrlBarViewId;

    @SerializedName("detectionMethod")
    private final String detectionMethod;

    @SerializedName("extractionMethod")
    private final String extractionMethod;

    @SerializedName("packageName")
    private final String packageName;

    @SerializedName("showLocalHtml")
    private final Boolean showLocalHtml;

    @SerializedName("viewId")
    private final String viewId;

    public BrowserConfigJson(String str, String str2, Boolean bool, Boolean bool2, String str3, String str4, String str5) {
        this.packageName = str;
        this.viewId = str2;
        this.clearUrl = bool;
        this.showLocalHtml = bool2;
        this.detectionMethod = str3;
        this.extractionMethod = str4;
        this.clickToOpenUrlBarViewId = str5;
    }

    public final Boolean a() {
        return this.clearUrl;
    }

    public final String b() {
        return this.clickToOpenUrlBarViewId;
    }

    public final String c() {
        return this.detectionMethod;
    }

    public final String d() {
        return this.extractionMethod;
    }

    public final String e() {
        return this.packageName;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrowserConfigJson)) {
            return false;
        }
        BrowserConfigJson browserConfigJson = (BrowserConfigJson) obj;
        return Intrinsics.areEqual(this.packageName, browserConfigJson.packageName) && Intrinsics.areEqual(this.viewId, browserConfigJson.viewId) && Intrinsics.areEqual(this.clearUrl, browserConfigJson.clearUrl) && Intrinsics.areEqual(this.showLocalHtml, browserConfigJson.showLocalHtml) && Intrinsics.areEqual(this.detectionMethod, browserConfigJson.detectionMethod) && Intrinsics.areEqual(this.extractionMethod, browserConfigJson.extractionMethod) && Intrinsics.areEqual(this.clickToOpenUrlBarViewId, browserConfigJson.clickToOpenUrlBarViewId);
    }

    public final Boolean f() {
        return this.showLocalHtml;
    }

    public final String g() {
        return this.viewId;
    }

    public int hashCode() {
        String str = this.packageName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.viewId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.clearUrl;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.showLocalHtml;
        int iHashCode4 = (iHashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str3 = this.detectionMethod;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.extractionMethod;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.clickToOpenUrlBarViewId;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "BrowserConfigJson(packageName=" + this.packageName + ", viewId=" + this.viewId + ", clearUrl=" + this.clearUrl + ", showLocalHtml=" + this.showLocalHtml + ", detectionMethod=" + this.detectionMethod + ", extractionMethod=" + this.extractionMethod + ", clickToOpenUrlBarViewId=" + this.clickToOpenUrlBarViewId + ")";
    }

    public /* synthetic */ BrowserConfigJson(String str, String str2, Boolean bool, Boolean bool2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? null : bool, (i3 & 8) != 0 ? null : bool2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4, (i3 & 64) != 0 ? null : str5);
    }
}
