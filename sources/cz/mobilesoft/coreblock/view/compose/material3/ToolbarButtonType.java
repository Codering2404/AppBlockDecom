package cz.mobilesoft.coreblock.view.compose.material3;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ToolbarButtonType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ToolbarButtonType[] $VALUES;
    private final int iconRes;
    public static final ToolbarButtonType Close = new ToolbarButtonType("Close", 0, R.drawable.C1);
    public static final ToolbarButtonType Back = new ToolbarButtonType("Back", 1, R.drawable.f95577x1);

    private static final /* synthetic */ ToolbarButtonType[] $values() {
        return new ToolbarButtonType[]{Close, Back};
    }

    static {
        ToolbarButtonType[] toolbarButtonTypeArr$values = $values();
        $VALUES = toolbarButtonTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(toolbarButtonTypeArr$values);
    }

    private ToolbarButtonType(String str, int i3, int i4) {
        this.iconRes = i4;
    }

    public static EnumEntries<ToolbarButtonType> getEntries() {
        return $ENTRIES;
    }

    public static ToolbarButtonType valueOf(String str) {
        return (ToolbarButtonType) Enum.valueOf(ToolbarButtonType.class, str);
    }

    public static ToolbarButtonType[] values() {
        return (ToolbarButtonType[]) $VALUES.clone();
    }

    public final int getIconRes() {
        return this.iconRes;
    }
}
