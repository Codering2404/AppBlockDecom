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
public final class StrictModeState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StrictModeState[] $VALUES;
    public static final StrictModeState Inactive = new StrictModeState("Inactive", 0);
    public static final StrictModeState Standby = new StrictModeState("Standby", 1);
    public static final StrictModeState Active = new StrictModeState("Active", 2);
    public static final StrictModeState Paused = new StrictModeState("Paused", 3);

    private static final /* synthetic */ StrictModeState[] $values() {
        return new StrictModeState[]{Inactive, Standby, Active, Paused};
    }

    static {
        StrictModeState[] strictModeStateArr$values = $values();
        $VALUES = strictModeStateArr$values;
        $ENTRIES = EnumEntriesKt.a(strictModeStateArr$values);
    }

    private StrictModeState(String str, int i3) {
    }

    public static EnumEntries<StrictModeState> getEntries() {
        return $ENTRIES;
    }

    public static StrictModeState valueOf(String str) {
        return (StrictModeState) Enum.valueOf(StrictModeState.class, str);
    }

    public static StrictModeState[] values() {
        return (StrictModeState[]) $VALUES.clone();
    }
}
