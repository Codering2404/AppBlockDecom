package com.google.firebase.sessions;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class ApplicationInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f89868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f89869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f89870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f89871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LogEnvironment f89872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AndroidApplicationInfo f89873f;

    public ApplicationInfo(String appId, String deviceModel, String sessionSdkVersion, String osVersion, LogEnvironment logEnvironment, AndroidApplicationInfo androidAppInfo) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(sessionSdkVersion, "sessionSdkVersion");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(logEnvironment, "logEnvironment");
        Intrinsics.checkNotNullParameter(androidAppInfo, "androidAppInfo");
        this.f89868a = appId;
        this.f89869b = deviceModel;
        this.f89870c = sessionSdkVersion;
        this.f89871d = osVersion;
        this.f89872e = logEnvironment;
        this.f89873f = androidAppInfo;
    }

    public final AndroidApplicationInfo a() {
        return this.f89873f;
    }

    public final String b() {
        return this.f89868a;
    }

    public final String c() {
        return this.f89869b;
    }

    public final LogEnvironment d() {
        return this.f89872e;
    }

    public final String e() {
        return this.f89871d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApplicationInfo)) {
            return false;
        }
        ApplicationInfo applicationInfo = (ApplicationInfo) obj;
        return Intrinsics.areEqual(this.f89868a, applicationInfo.f89868a) && Intrinsics.areEqual(this.f89869b, applicationInfo.f89869b) && Intrinsics.areEqual(this.f89870c, applicationInfo.f89870c) && Intrinsics.areEqual(this.f89871d, applicationInfo.f89871d) && this.f89872e == applicationInfo.f89872e && Intrinsics.areEqual(this.f89873f, applicationInfo.f89873f);
    }

    public final String f() {
        return this.f89870c;
    }

    public int hashCode() {
        return (((((((((this.f89868a.hashCode() * 31) + this.f89869b.hashCode()) * 31) + this.f89870c.hashCode()) * 31) + this.f89871d.hashCode()) * 31) + this.f89872e.hashCode()) * 31) + this.f89873f.hashCode();
    }

    public String toString() {
        return "ApplicationInfo(appId=" + this.f89868a + ", deviceModel=" + this.f89869b + ", sessionSdkVersion=" + this.f89870c + ", osVersion=" + this.f89871d + ", logEnvironment=" + this.f89872e + ", androidAppInfo=" + this.f89873f + ')';
    }
}
