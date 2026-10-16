package cz.mobilesoft.coreblock.util.permissions;

import android.content.Context;
import cz.mobilesoft.coreblock.enums.Permission;
import java.io.Serializable;
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
public final class PermissionDTO implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Permission f129000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f129001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f129002c;

    public PermissionDTO(Permission permission, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        this.f129000a = permission;
        this.f129001b = z2;
        this.f129002c = z3;
    }

    public static /* synthetic */ PermissionDTO b(PermissionDTO permissionDTO, Permission permission, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            permission = permissionDTO.f129000a;
        }
        if ((i3 & 2) != 0) {
            z2 = permissionDTO.f129001b;
        }
        if ((i3 & 4) != 0) {
            z3 = permissionDTO.f129002c;
        }
        return permissionDTO.a(permission, z2, z3);
    }

    public final PermissionDTO a(Permission permission, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        return new PermissionDTO(permission, z2, z3);
    }

    public final boolean c() {
        return this.f129001b;
    }

    public final String d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Permission.e(this.f129000a, context, this.f129002c, false, 4, null);
    }

    public final Permission e() {
        return this.f129000a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermissionDTO)) {
            return false;
        }
        PermissionDTO permissionDTO = (PermissionDTO) obj;
        return Intrinsics.areEqual(this.f129000a, permissionDTO.f129000a) && this.f129001b == permissionDTO.f129001b && this.f129002c == permissionDTO.f129002c;
    }

    public final boolean f() {
        return this.f129002c;
    }

    public int hashCode() {
        return (((this.f129000a.hashCode() * 31) + Boolean.hashCode(this.f129001b)) * 31) + Boolean.hashCode(this.f129002c);
    }

    public String toString() {
        return "PermissionDTO(permission=" + this.f129000a + ", animateSuccess=" + this.f129001b + ", isMalfunction=" + this.f129002c + ")";
    }

    public /* synthetic */ PermissionDTO(Permission permission, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(permission, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? false : z3);
    }
}
