package cz.mobilesoft.coreblock.util.permissions;

import kotlin.Metadata;

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
public final class PermissionStateDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f129019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f129020b;

    public PermissionStateDTO(boolean z2, boolean z3) {
        this.f129019a = z2;
        this.f129020b = z3;
    }

    public final boolean a() {
        return this.f129019a;
    }

    public final boolean b() {
        return this.f129020b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermissionStateDTO)) {
            return false;
        }
        PermissionStateDTO permissionStateDTO = (PermissionStateDTO) obj;
        return this.f129019a == permissionStateDTO.f129019a && this.f129020b == permissionStateDTO.f129020b;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f129019a) * 31) + Boolean.hashCode(this.f129020b);
    }

    public String toString() {
        return "PermissionStateDTO(shouldSkip=" + this.f129019a + ", isMalfunctioning=" + this.f129020b + ")";
    }
}
