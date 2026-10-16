package cz.mobilesoft.coreblock.enums;

import cz.mobilesoft.coreblock.enums.Permission;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class PermissionKt {
    public static final String a(Permission permission) {
        Intrinsics.checkNotNullParameter(permission, "<this>");
        if (permission instanceof Permission.USAGE_ACCESS) {
            return "USAGE_ACCESS";
        }
        if (permission instanceof Permission.ACCESSIBILITY) {
            return "ACCESSIBILITY";
        }
        if (Intrinsics.areEqual(permission, Permission.NOTIFICATION_ACCESS.f97001d)) {
            return "NOTIFICATION_ACCESS";
        }
        if (Intrinsics.areEqual(permission, Permission.SYSTEM_OVERLAY.f97003d)) {
            return "SYSTEM_OVERLAY";
        }
        if (Intrinsics.areEqual(permission, Permission.MIUI_11_POP_UP.f97000d)) {
            return "MIUI_11_POP_UP";
        }
        if (Intrinsics.areEqual(permission, Permission.LOCATION.f96999d)) {
            return "LOCATION";
        }
        if (Intrinsics.areEqual(permission, Permission.DEVICE_ADMIN.f96998d)) {
            return "DEVICE_ADMIN";
        }
        if (Intrinsics.areEqual(permission, Permission.ALARM_EXACT.f96997d)) {
            return "ALARM_EXACT";
        }
        if (permission instanceof Permission.POST_NOTIFICATIONS) {
            return "POST_NOTIFICATIONS";
        }
        throw new NoWhenBranchMatchedException();
    }
}
