package cz.mobilesoft.coreblock.scene.permission.permissions.success;

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
final class CheckMarkState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CheckMarkState[] $VALUES;
    public static final CheckMarkState Hidden = new CheckMarkState("Hidden", 0);
    public static final CheckMarkState Visible = new CheckMarkState("Visible", 1);

    private static final /* synthetic */ CheckMarkState[] $values() {
        return new CheckMarkState[]{Hidden, Visible};
    }

    static {
        CheckMarkState[] checkMarkStateArr$values = $values();
        $VALUES = checkMarkStateArr$values;
        $ENTRIES = EnumEntriesKt.a(checkMarkStateArr$values);
    }

    private CheckMarkState(String str, int i3) {
    }

    public static EnumEntries<CheckMarkState> getEntries() {
        return $ENTRIES;
    }

    public static CheckMarkState valueOf(String str) {
        return (CheckMarkState) Enum.valueOf(CheckMarkState.class, str);
    }

    public static CheckMarkState[] values() {
        return (CheckMarkState[]) $VALUES.clone();
    }
}
