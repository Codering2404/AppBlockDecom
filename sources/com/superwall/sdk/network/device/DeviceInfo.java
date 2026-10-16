package com.superwall.sdk.network.device;

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
public final class DeviceInfo {
    private final String appInstalledAtString;
    private final String locale;

    public DeviceInfo(String appInstalledAtString, String locale) {
        Intrinsics.checkNotNullParameter(appInstalledAtString, "appInstalledAtString");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.appInstalledAtString = appInstalledAtString;
        this.locale = locale;
    }

    public static /* synthetic */ DeviceInfo copy$default(DeviceInfo deviceInfo, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = deviceInfo.appInstalledAtString;
        }
        if ((i3 & 2) != 0) {
            str2 = deviceInfo.locale;
        }
        return deviceInfo.copy(str, str2);
    }

    public final String component1() {
        return this.appInstalledAtString;
    }

    public final String component2() {
        return this.locale;
    }

    public final DeviceInfo copy(String appInstalledAtString, String locale) {
        Intrinsics.checkNotNullParameter(appInstalledAtString, "appInstalledAtString");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new DeviceInfo(appInstalledAtString, locale);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return Intrinsics.areEqual(this.appInstalledAtString, deviceInfo.appInstalledAtString) && Intrinsics.areEqual(this.locale, deviceInfo.locale);
    }

    public final String getAppInstalledAtString() {
        return this.appInstalledAtString;
    }

    public final String getLocale() {
        return this.locale;
    }

    public int hashCode() {
        return (this.appInstalledAtString.hashCode() * 31) + this.locale.hashCode();
    }

    public String toString() {
        return "DeviceInfo(appInstalledAtString=" + this.appInstalledAtString + ", locale=" + this.locale + ")";
    }
}
