package cz.mobilesoft.coreblock.scene.selection.components;

import cz.mobilesoft.coreblock.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TabItem {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TabItem[] $VALUES;
    public static final Companion Companion;
    private final int index;
    private final int titleRes;
    public static final TabItem Apps = new TabItem("Apps", 0, 0, R.string.M1);
    public static final TabItem Webs = new TabItem("Webs", 1, 1, R.string.gG);
    public static final TabItem Keywords = new TabItem("Keywords", 2, 2, R.string.oi);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TabItem[] a() {
            return new TabItem[]{TabItem.Apps};
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ TabItem[] $values() {
        return new TabItem[]{Apps, Webs, Keywords};
    }

    static {
        TabItem[] tabItemArr$values = $values();
        $VALUES = tabItemArr$values;
        $ENTRIES = EnumEntriesKt.a(tabItemArr$values);
        Companion = new Companion(null);
    }

    private TabItem(String str, int i3, int i4, int i5) {
        this.index = i4;
        this.titleRes = i5;
    }

    public static EnumEntries<TabItem> getEntries() {
        return $ENTRIES;
    }

    public static TabItem valueOf(String str) {
        return (TabItem) Enum.valueOf(TabItem.class, str);
    }

    public static TabItem[] values() {
        return (TabItem[]) $VALUES.clone();
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }
}
