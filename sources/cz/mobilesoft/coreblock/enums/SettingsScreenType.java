package cz.mobilesoft.coreblock.enums;

import cz.mobilesoft.coreblock.R;
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
public final class SettingsScreenType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SettingsScreenType[] $VALUES;
    private final int titleResId;
    public static final SettingsScreenType OVERVIEW = new SettingsScreenType("OVERVIEW", 0, R.string.Ee);
    public static final SettingsScreenType BLOCKING_PREFERENCES = new SettingsScreenType("BLOCKING_PREFERENCES", 1, R.string.ow);
    public static final SettingsScreenType NOTIFICATION = new SettingsScreenType("NOTIFICATION", 2, R.string.GD);
    public static final SettingsScreenType STATISTICS = new SettingsScreenType("STATISTICS", 3, R.string.OD);
    public static final SettingsScreenType PREMIUM = new SettingsScreenType("PREMIUM", 4, R.string.JD);
    public static final SettingsScreenType TIME_NUDGE = new SettingsScreenType("TIME_NUDGE", 5, R.string.pD);

    private static final /* synthetic */ SettingsScreenType[] $values() {
        return new SettingsScreenType[]{OVERVIEW, BLOCKING_PREFERENCES, NOTIFICATION, STATISTICS, PREMIUM, TIME_NUDGE};
    }

    static {
        SettingsScreenType[] settingsScreenTypeArr$values = $values();
        $VALUES = settingsScreenTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(settingsScreenTypeArr$values);
    }

    private SettingsScreenType(String str, int i3, int i4) {
        this.titleResId = i4;
    }

    public static EnumEntries<SettingsScreenType> getEntries() {
        return $ENTRIES;
    }

    public static SettingsScreenType valueOf(String str) {
        return (SettingsScreenType) Enum.valueOf(SettingsScreenType.class, str);
    }

    public static SettingsScreenType[] values() {
        return (SettingsScreenType[]) $VALUES.clone();
    }

    public final int getTitleResId() {
        return this.titleResId;
    }
}
