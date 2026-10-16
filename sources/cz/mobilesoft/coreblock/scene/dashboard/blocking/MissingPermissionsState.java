package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MissingPermissionsState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f99950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f99951b;

    public MissingPermissionsState(List missingPermissions, boolean z2) {
        Intrinsics.checkNotNullParameter(missingPermissions, "missingPermissions");
        this.f99950a = missingPermissions;
        this.f99951b = z2;
    }

    public static /* synthetic */ MissingPermissionsState b(MissingPermissionsState missingPermissionsState, List list, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = missingPermissionsState.f99950a;
        }
        if ((i3 & 2) != 0) {
            z2 = missingPermissionsState.f99951b;
        }
        return missingPermissionsState.a(list, z2);
    }

    public final MissingPermissionsState a(List missingPermissions, boolean z2) {
        Intrinsics.checkNotNullParameter(missingPermissions, "missingPermissions");
        return new MissingPermissionsState(missingPermissions, z2);
    }

    public final boolean c() {
        return this.f99951b;
    }

    public final List d() {
        return this.f99950a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MissingPermissionsState)) {
            return false;
        }
        MissingPermissionsState missingPermissionsState = (MissingPermissionsState) obj;
        return Intrinsics.areEqual(this.f99950a, missingPermissionsState.f99950a) && this.f99951b == missingPermissionsState.f99951b;
    }

    public int hashCode() {
        return (this.f99950a.hashCode() * 31) + Boolean.hashCode(this.f99951b);
    }

    public String toString() {
        return "MissingPermissionsState(missingPermissions=" + this.f99950a + ", animateCheckMark=" + this.f99951b + ")";
    }

    public /* synthetic */ MissingPermissionsState(List list, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? false : z2);
    }
}
