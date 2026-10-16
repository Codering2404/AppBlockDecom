package cz.mobilesoft.coreblock.scene.sharing.intents;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.comparisons.xn.YvFRmou;
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
public final class ShareableAppInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f119456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Drawable f119457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f119458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f119459d;

    public final String a() {
        return this.f119459d;
    }

    public final String b() {
        return this.f119456a;
    }

    public final Drawable c() {
        return this.f119457b;
    }

    public final String d() {
        return this.f119458c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShareableAppInfo)) {
            return false;
        }
        ShareableAppInfo shareableAppInfo = (ShareableAppInfo) obj;
        return Intrinsics.areEqual(this.f119456a, shareableAppInfo.f119456a) && Intrinsics.areEqual(this.f119457b, shareableAppInfo.f119457b) && Intrinsics.areEqual(this.f119458c, shareableAppInfo.f119458c) && Intrinsics.areEqual(this.f119459d, shareableAppInfo.f119459d);
    }

    public int hashCode() {
        return (((((this.f119456a.hashCode() * 31) + this.f119457b.hashCode()) * 31) + this.f119458c.hashCode()) * 31) + this.f119459d.hashCode();
    }

    public String toString() {
        return "ShareableAppInfo(appName=" + this.f119456a + ", icon=" + this.f119457b + ", packageName=" + this.f119458c + ", activityName=" + this.f119459d + ")";
    }

    public ShareableAppInfo(String appName, Drawable icon, String packageName, String str) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(str, YvFRmou.XUIPg);
        this.f119456a = appName;
        this.f119457b = icon;
        this.f119458c = packageName;
        this.f119459d = str;
    }
}
