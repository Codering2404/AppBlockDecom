package cz.mobilesoft.coreblock.enums;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
public final class PermissionUsageAccessReason {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PermissionUsageAccessReason[] $VALUES;
    public static final PermissionUsageAccessReason AppBlocking = new PermissionUsageAccessReason("AppBlocking", 0);
    public static final PermissionUsageAccessReason Statistics = new PermissionUsageAccessReason("Statistics", 1);
    public static final PermissionUsageAccessReason StrictMode = new PermissionUsageAccessReason("StrictMode", 2);
    public static final PermissionUsageAccessReason UsageLimits = new PermissionUsageAccessReason("UsageLimits", 3);

    private static final /* synthetic */ PermissionUsageAccessReason[] $values() {
        return new PermissionUsageAccessReason[]{AppBlocking, Statistics, StrictMode, UsageLimits};
    }

    static {
        PermissionUsageAccessReason[] permissionUsageAccessReasonArr$values = $values();
        $VALUES = permissionUsageAccessReasonArr$values;
        $ENTRIES = EnumEntriesKt.a(permissionUsageAccessReasonArr$values);
    }

    private PermissionUsageAccessReason(String str, int i3) {
    }

    public static EnumEntries<PermissionUsageAccessReason> getEntries() {
        return $ENTRIES;
    }

    public static PermissionUsageAccessReason valueOf(String str) {
        return (PermissionUsageAccessReason) Enum.valueOf(PermissionUsageAccessReason.class, str);
    }

    public static PermissionUsageAccessReason[] values() {
        return (PermissionUsageAccessReason[]) $VALUES.clone();
    }
}
