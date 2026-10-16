package com.google.firebase.sessions;

import java.util.List;
import kotlin.Metadata;
import kotlin.experimental.kJ.HcgZcEUYo;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class AndroidApplicationInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f89862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f89863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f89864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f89865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ProcessDetails f89866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f89867f;

    public AndroidApplicationInfo(String packageName, String versionName, String appBuildVersion, String deviceManufacturer, ProcessDetails currentProcessDetails, List appProcessDetails) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(appBuildVersion, "appBuildVersion");
        Intrinsics.checkNotNullParameter(deviceManufacturer, "deviceManufacturer");
        Intrinsics.checkNotNullParameter(currentProcessDetails, "currentProcessDetails");
        Intrinsics.checkNotNullParameter(appProcessDetails, "appProcessDetails");
        this.f89862a = packageName;
        this.f89863b = versionName;
        this.f89864c = appBuildVersion;
        this.f89865d = deviceManufacturer;
        this.f89866e = currentProcessDetails;
        this.f89867f = appProcessDetails;
    }

    public final String a() {
        return this.f89864c;
    }

    public final List b() {
        return this.f89867f;
    }

    public final ProcessDetails c() {
        return this.f89866e;
    }

    public final String d() {
        return this.f89865d;
    }

    public final String e() {
        return this.f89862a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidApplicationInfo)) {
            return false;
        }
        AndroidApplicationInfo androidApplicationInfo = (AndroidApplicationInfo) obj;
        return Intrinsics.areEqual(this.f89862a, androidApplicationInfo.f89862a) && Intrinsics.areEqual(this.f89863b, androidApplicationInfo.f89863b) && Intrinsics.areEqual(this.f89864c, androidApplicationInfo.f89864c) && Intrinsics.areEqual(this.f89865d, androidApplicationInfo.f89865d) && Intrinsics.areEqual(this.f89866e, androidApplicationInfo.f89866e) && Intrinsics.areEqual(this.f89867f, androidApplicationInfo.f89867f);
    }

    public final String f() {
        return this.f89863b;
    }

    public int hashCode() {
        return (((((((((this.f89862a.hashCode() * 31) + this.f89863b.hashCode()) * 31) + this.f89864c.hashCode()) * 31) + this.f89865d.hashCode()) * 31) + this.f89866e.hashCode()) * 31) + this.f89867f.hashCode();
    }

    public String toString() {
        return HcgZcEUYo.rUcbiTkEPx + this.f89862a + ", versionName=" + this.f89863b + ", appBuildVersion=" + this.f89864c + ", deviceManufacturer=" + this.f89865d + ", currentProcessDetails=" + this.f89866e + ", appProcessDetails=" + this.f89867f + ')';
    }
}
