package com.superwall.sdk.permissions;

import androidx.glance.session.ecY.lisODU;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PermissionStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PermissionStatus[] $VALUES;
    public static final Companion Companion;
    private final String rawValue;
    public static final PermissionStatus GRANTED = new PermissionStatus("GRANTED", 0, "granted");
    public static final PermissionStatus DENIED = new PermissionStatus("DENIED", 1, "denied");
    public static final PermissionStatus UNSUPPORTED = new PermissionStatus("UNSUPPORTED", 2, "unsupported");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PermissionStatus fromRaw(String str) {
            Intrinsics.checkNotNullParameter(str, lisODU.QVDZSL);
            for (PermissionStatus permissionStatus : PermissionStatus.values()) {
                if (Intrinsics.areEqual(permissionStatus.getRawValue(), str)) {
                    return permissionStatus;
                }
            }
            return null;
        }
    }

    private static final /* synthetic */ PermissionStatus[] $values() {
        return new PermissionStatus[]{GRANTED, DENIED, UNSUPPORTED};
    }

    static {
        PermissionStatus[] permissionStatusArr$values = $values();
        $VALUES = permissionStatusArr$values;
        $ENTRIES = EnumEntriesKt.a(permissionStatusArr$values);
        Companion = new Companion(null);
    }

    private PermissionStatus(String str, int i3, String str2) {
        this.rawValue = str2;
    }

    public static EnumEntries<PermissionStatus> getEntries() {
        return $ENTRIES;
    }

    public static PermissionStatus valueOf(String str) {
        return (PermissionStatus) Enum.valueOf(PermissionStatus.class, str);
    }

    public static PermissionStatus[] values() {
        return (PermissionStatus[]) $VALUES.clone();
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
