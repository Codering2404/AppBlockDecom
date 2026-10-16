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
public final class SelectableIconCategory {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SelectableIconCategory[] $VALUES;
    private final int iconResId;
    private final int id;
    private final int order;
    private final int titleResId;
    public static final SelectableIconCategory Basic = new SelectableIconCategory("Basic", 0, 0, R.string.ag, R.drawable.n6, 0);
    public static final SelectableIconCategory Blocking = new SelectableIconCategory("Blocking", 1, 1, R.string.bg, R.drawable.f95582z0, 1);
    public static final SelectableIconCategory WorkAndFocus = new SelectableIconCategory("WorkAndFocus", 2, 2, R.string.gg, R.drawable.j6, 2);
    public static final SelectableIconCategory Wellbeing = new SelectableIconCategory("Wellbeing", 3, 3, R.string.fg, R.drawable.x2, 3);
    public static final SelectableIconCategory FamilyAndKids = new SelectableIconCategory("FamilyAndKids", 4, 4, R.string.cg, R.drawable.I2, 4);
    public static final SelectableIconCategory SchoolAndStudy = new SelectableIconCategory("SchoolAndStudy", 5, 5, R.string.eg, R.drawable.D2, 5);
    public static final SelectableIconCategory Activities = new SelectableIconCategory("Activities", 6, 6, R.string.Zf, R.drawable.R0, 6);
    public static final SelectableIconCategory Others = new SelectableIconCategory("Others", 7, 7, R.string.dg, R.drawable.M3, 7);

    private static final /* synthetic */ SelectableIconCategory[] $values() {
        return new SelectableIconCategory[]{Basic, Blocking, WorkAndFocus, Wellbeing, FamilyAndKids, SchoolAndStudy, Activities, Others};
    }

    static {
        SelectableIconCategory[] selectableIconCategoryArr$values = $values();
        $VALUES = selectableIconCategoryArr$values;
        $ENTRIES = EnumEntriesKt.a(selectableIconCategoryArr$values);
    }

    private SelectableIconCategory(String str, int i3, int i4, int i5, int i6, int i7) {
        this.id = i4;
        this.titleResId = i5;
        this.iconResId = i6;
        this.order = i7;
    }

    public static EnumEntries<SelectableIconCategory> getEntries() {
        return $ENTRIES;
    }

    public static SelectableIconCategory valueOf(String str) {
        return (SelectableIconCategory) Enum.valueOf(SelectableIconCategory.class, str);
    }

    public static SelectableIconCategory[] values() {
        return (SelectableIconCategory[]) $VALUES.clone();
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final int getId() {
        return this.id;
    }

    public final int getOrder() {
        return this.order;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }
}
