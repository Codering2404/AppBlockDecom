package cz.mobilesoft.coreblock.util.permissions;

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
public final class PermissionHeader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f129003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f129004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f129005c;

    public PermissionHeader(String str, String str2, boolean z2) {
        this.f129003a = str;
        this.f129004b = str2;
        this.f129005c = z2;
    }

    public static /* synthetic */ PermissionHeader b(PermissionHeader permissionHeader, String str, String str2, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = permissionHeader.f129003a;
        }
        if ((i3 & 2) != 0) {
            str2 = permissionHeader.f129004b;
        }
        if ((i3 & 4) != 0) {
            z2 = permissionHeader.f129005c;
        }
        return permissionHeader.a(str, str2, z2);
    }

    public final PermissionHeader a(String str, String str2, boolean z2) {
        return new PermissionHeader(str, str2, z2);
    }

    public final String c() {
        return this.f129004b;
    }

    public final boolean d() {
        return this.f129005c;
    }

    public final String e() {
        return this.f129003a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermissionHeader)) {
            return false;
        }
        PermissionHeader permissionHeader = (PermissionHeader) obj;
        return Intrinsics.areEqual(this.f129003a, permissionHeader.f129003a) && Intrinsics.areEqual(this.f129004b, permissionHeader.f129004b) && this.f129005c == permissionHeader.f129005c;
    }

    public int hashCode() {
        String str = this.f129003a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f129004b;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Boolean.hashCode(this.f129005c);
    }

    public String toString() {
        return "PermissionHeader(title=" + this.f129003a + ", description=" + this.f129004b + ", showSuccess=" + this.f129005c + ")";
    }

    public /* synthetic */ PermissionHeader(String str, String str2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? false : z2);
    }
}
