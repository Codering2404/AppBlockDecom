package com.superwall.sdk.permissions;

import android.os.Build;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class PermissionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PermissionType[] $VALUES;
    public static final Companion Companion;
    private final String rawValue;
    public static final PermissionType NOTIFICATION = new PermissionType("NOTIFICATION", 0, "notification");
    public static final PermissionType LOCATION = new PermissionType("LOCATION", 1, "location");
    public static final PermissionType BACKGROUND_LOCATION = new PermissionType("BACKGROUND_LOCATION", 2, "background_location");
    public static final PermissionType READ_IMAGES = new PermissionType("READ_IMAGES", 3, "read_images");
    public static final PermissionType CONTACTS = new PermissionType("CONTACTS", 4, "contacts");
    public static final PermissionType READ_VIDEO = new PermissionType("READ_VIDEO", 5, "read_video");
    public static final PermissionType CAMERA = new PermissionType("CAMERA", 6, "camera");
    public static final PermissionType MICROPHONE = new PermissionType("MICROPHONE", 7, "microphone");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PermissionType fromRaw(String raw) {
            Intrinsics.checkNotNullParameter(raw, "raw");
            for (PermissionType permissionType : PermissionType.values()) {
                if (Intrinsics.areEqual(permissionType.getRawValue(), raw)) {
                    return permissionType;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PermissionType.values().length];
            try {
                iArr[PermissionType.NOTIFICATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PermissionType.LOCATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PermissionType.BACKGROUND_LOCATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PermissionType.READ_IMAGES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PermissionType.CONTACTS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PermissionType.READ_VIDEO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PermissionType.CAMERA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PermissionType.MICROPHONE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ PermissionType[] $values() {
        return new PermissionType[]{NOTIFICATION, LOCATION, BACKGROUND_LOCATION, READ_IMAGES, CONTACTS, READ_VIDEO, CAMERA, MICROPHONE};
    }

    static {
        PermissionType[] permissionTypeArr$values = $values();
        $VALUES = permissionTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(permissionTypeArr$values);
        Companion = new Companion(null);
    }

    private PermissionType(String str, int i3, String str2) {
        this.rawValue = str2;
    }

    public static EnumEntries<PermissionType> getEntries() {
        return $ENTRIES;
    }

    public static PermissionType valueOf(String str) {
        return (PermissionType) Enum.valueOf(PermissionType.class, str);
    }

    public static PermissionType[] values() {
        return (PermissionType[]) $VALUES.clone();
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public final String toManifestPermission() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                if (Build.VERSION.SDK_INT >= 33) {
                    return "android.permission.POST_NOTIFICATIONS";
                }
                return null;
            case 2:
                return "android.permission.ACCESS_FINE_LOCATION";
            case 3:
                if (Build.VERSION.SDK_INT >= 29) {
                    return "android.permission.ACCESS_BACKGROUND_LOCATION";
                }
                return null;
            case 4:
                return Build.VERSION.SDK_INT >= 33 ? "android.permission.READ_MEDIA_IMAGES" : "android.permission.READ_EXTERNAL_STORAGE";
            case 5:
                return "android.permission.READ_CONTACTS";
            case 6:
                return Build.VERSION.SDK_INT >= 33 ? "android.permission.READ_MEDIA_VIDEO" : "android.permission.READ_EXTERNAL_STORAGE";
            case 7:
                return "android.permission.CAMERA";
            case 8:
                return "android.permission.RECORD_AUDIO";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
