package cz.mobilesoft.coreblock.scene.strictmode3.access;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AccessNavigation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AccessNavigation[] $VALUES;
    private final String route;
    public static final AccessNavigation Selection = new AccessNavigation("Selection", 0, "selection");
    public static final AccessNavigation PinCode = new AccessNavigation("PinCode", 1, "pin_code");
    public static final AccessNavigation Timer = new AccessNavigation("Timer", 2, "timer");
    public static final AccessNavigation Cooldown = new AccessNavigation("Cooldown", 3, "cooldown");
    public static final AccessNavigation FollowSchedules = new AccessNavigation("FollowSchedules", 4, "follow_schedules");

    private static final /* synthetic */ AccessNavigation[] $values() {
        return new AccessNavigation[]{Selection, PinCode, Timer, Cooldown, FollowSchedules};
    }

    static {
        AccessNavigation[] accessNavigationArr$values = $values();
        $VALUES = accessNavigationArr$values;
        $ENTRIES = EnumEntriesKt.a(accessNavigationArr$values);
    }

    private AccessNavigation(String str, int i3, String str2) {
        this.route = str2;
    }

    public static EnumEntries<AccessNavigation> getEntries() {
        return $ENTRIES;
    }

    public static AccessNavigation valueOf(String str) {
        return (AccessNavigation) Enum.valueOf(AccessNavigation.class, str);
    }

    public static AccessNavigation[] values() {
        return (AccessNavigation[]) $VALUES.clone();
    }

    public final String getRoute() {
        return this.route;
    }
}
