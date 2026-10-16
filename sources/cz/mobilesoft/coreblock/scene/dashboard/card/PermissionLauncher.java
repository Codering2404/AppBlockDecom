package cz.mobilesoft.coreblock.scene.dashboard.card;

import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.runtime.MutableState;
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
public final class PermissionLauncher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f100419c = ManagedActivityResultLauncher.f461c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ManagedActivityResultLauncher f100420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f100421b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermissionLauncher)) {
            return false;
        }
        PermissionLauncher permissionLauncher = (PermissionLauncher) obj;
        return Intrinsics.areEqual(this.f100420a, permissionLauncher.f100420a) && Intrinsics.areEqual(this.f100421b, permissionLauncher.f100421b);
    }

    public int hashCode() {
        return (this.f100420a.hashCode() * 31) + this.f100421b.hashCode();
    }

    public String toString() {
        return "PermissionLauncher(launcher=" + this.f100420a + ", presetTime=" + this.f100421b + ")";
    }
}
