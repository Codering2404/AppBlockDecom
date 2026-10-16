package cz.mobilesoft.coreblock.scene.insights.settings;

import android.graphics.drawable.Drawable;
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
final class ExcludedAppInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f103425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Drawable f103426b;

    public ExcludedAppInfo(String appName, Drawable drawable) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        this.f103425a = appName;
        this.f103426b = drawable;
    }

    public final Drawable a() {
        return this.f103426b;
    }

    public final String b() {
        return this.f103425a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExcludedAppInfo)) {
            return false;
        }
        ExcludedAppInfo excludedAppInfo = (ExcludedAppInfo) obj;
        return Intrinsics.areEqual(this.f103425a, excludedAppInfo.f103425a) && Intrinsics.areEqual(this.f103426b, excludedAppInfo.f103426b);
    }

    public int hashCode() {
        int iHashCode = this.f103425a.hashCode() * 31;
        Drawable drawable = this.f103426b;
        return iHashCode + (drawable == null ? 0 : drawable.hashCode());
    }

    public String toString() {
        return "ExcludedAppInfo(appName=" + this.f103425a + ", appIcon=" + this.f103426b + ")";
    }
}
