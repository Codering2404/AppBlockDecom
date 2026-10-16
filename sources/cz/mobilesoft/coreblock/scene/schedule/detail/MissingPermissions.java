package cz.mobilesoft.coreblock.scene.schedule.detail;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;

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
public final class MissingPermissions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableList f116582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f116583b;

    public MissingPermissions(ImmutableList permissions, boolean z2) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.f116582a = permissions;
        this.f116583b = z2;
    }

    public static /* synthetic */ MissingPermissions b(MissingPermissions missingPermissions, ImmutableList immutableList, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            immutableList = missingPermissions.f116582a;
        }
        if ((i3 & 2) != 0) {
            z2 = missingPermissions.f116583b;
        }
        return missingPermissions.a(immutableList, z2);
    }

    public final MissingPermissions a(ImmutableList permissions, boolean z2) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        return new MissingPermissions(permissions, z2);
    }

    public final boolean c() {
        return this.f116583b;
    }

    public final ImmutableList d() {
        return this.f116582a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MissingPermissions)) {
            return false;
        }
        MissingPermissions missingPermissions = (MissingPermissions) obj;
        return Intrinsics.areEqual(this.f116582a, missingPermissions.f116582a) && this.f116583b == missingPermissions.f116583b;
    }

    public int hashCode() {
        return (this.f116582a.hashCode() * 31) + Boolean.hashCode(this.f116583b);
    }

    public String toString() {
        return "MissingPermissions(permissions=" + this.f116582a + ", animateCheckMark=" + this.f116583b + ")";
    }

    public /* synthetic */ MissingPermissions(ImmutableList immutableList, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ExtensionsKt.a() : immutableList, (i3 & 2) != 0 ? false : z2);
    }
}
