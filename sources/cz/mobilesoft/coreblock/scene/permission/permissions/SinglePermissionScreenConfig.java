package cz.mobilesoft.coreblock.scene.permission.permissions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class SinglePermissionScreenConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function3 f112137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2 f112138b;

    public SinglePermissionScreenConfig(Function3 content, Function2 bottomBar) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(bottomBar, "bottomBar");
        this.f112137a = content;
        this.f112138b = bottomBar;
    }

    public final Function2 a() {
        return this.f112138b;
    }

    public final Function3 b() {
        return this.f112137a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SinglePermissionScreenConfig)) {
            return false;
        }
        SinglePermissionScreenConfig singlePermissionScreenConfig = (SinglePermissionScreenConfig) obj;
        return Intrinsics.areEqual(this.f112137a, singlePermissionScreenConfig.f112137a) && Intrinsics.areEqual(this.f112138b, singlePermissionScreenConfig.f112138b);
    }

    public int hashCode() {
        return (this.f112137a.hashCode() * 31) + this.f112138b.hashCode();
    }

    public String toString() {
        return "SinglePermissionScreenConfig(content=" + this.f112137a + ", bottomBar=" + this.f112138b + ")";
    }
}
