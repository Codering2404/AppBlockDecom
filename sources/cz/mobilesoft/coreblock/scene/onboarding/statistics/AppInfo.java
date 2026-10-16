package cz.mobilesoft.coreblock.scene.onboarding.statistics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final class AppInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Drawable f111357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f111358b;

    public AppInfo(Drawable drawable, long j3) {
        this.f111357a = drawable;
        this.f111358b = j3;
    }

    public final long a() {
        return this.f111358b;
    }

    public final Drawable b() {
        return this.f111357a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppInfo)) {
            return false;
        }
        AppInfo appInfo = (AppInfo) obj;
        return Intrinsics.areEqual(this.f111357a, appInfo.f111357a) && this.f111358b == appInfo.f111358b;
    }

    public int hashCode() {
        Drawable drawable = this.f111357a;
        return ((drawable == null ? 0 : drawable.hashCode()) * 31) + Long.hashCode(this.f111358b);
    }

    public String toString() {
        return "AppInfo(icon=" + this.f111357a + ", duration=" + this.f111358b + ")";
    }
}
