package dev.doubledot.doki.models;

import android.os.Build;
import dev.doubledot.doki.api.extensions.AndroidKt;
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
public final class Device {
    private String androidVersion;
    private String manufacturer;
    private String model;

    public Device() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Device copy$default(Device device, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = device.manufacturer;
        }
        if ((i3 & 2) != 0) {
            str2 = device.model;
        }
        if ((i3 & 4) != 0) {
            str3 = device.androidVersion;
        }
        return device.copy(str, str2, str3);
    }

    public final String component1() {
        return this.manufacturer;
    }

    public final String component2() {
        return this.model;
    }

    public final String component3() {
        return this.androidVersion;
    }

    public final Device copy(String manufacturer, String model, String androidVersion) {
        Intrinsics.checkParameterIsNotNull(manufacturer, "manufacturer");
        Intrinsics.checkParameterIsNotNull(model, "model");
        Intrinsics.checkParameterIsNotNull(androidVersion, "androidVersion");
        return new Device(manufacturer, model, androidVersion);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        return Intrinsics.areEqual(this.manufacturer, device.manufacturer) && Intrinsics.areEqual(this.model, device.model) && Intrinsics.areEqual(this.androidVersion, device.androidVersion);
    }

    public final String getAndroidVersion() {
        return this.androidVersion;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final String getModel() {
        return this.model;
    }

    public int hashCode() {
        String str = this.manufacturer;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.model;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.androidVersion;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setAndroidVersion(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.androidVersion = str;
    }

    public final void setManufacturer(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.manufacturer = str;
    }

    public final void setModel(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.model = str;
    }

    public String toString() {
        return "Device(manufacturer=" + this.manufacturer + ", model=" + this.model + ", androidVersion=" + this.androidVersion + ")";
    }

    public Device(String manufacturer, String model, String androidVersion) {
        Intrinsics.checkParameterIsNotNull(manufacturer, "manufacturer");
        Intrinsics.checkParameterIsNotNull(model, "model");
        Intrinsics.checkParameterIsNotNull(androidVersion, "androidVersion");
        this.manufacturer = manufacturer;
        this.model = model;
        this.androidVersion = androidVersion;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Device(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 1) != 0) {
            str = Build.MANUFACTURER;
            Intrinsics.checkExpressionValueIsNotNull(str, "Build.MANUFACTURER");
        }
        if ((i3 & 2) != 0) {
            str2 = Build.MODEL;
            Intrinsics.checkExpressionValueIsNotNull(str2, "Build.MODEL");
        }
        this(str, str2, (i3 & 4) != 0 ? AndroidKt.getFullAndroidVersion() : str3);
    }
}
