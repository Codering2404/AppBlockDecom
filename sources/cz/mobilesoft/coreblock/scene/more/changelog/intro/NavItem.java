package cz.mobilesoft.coreblock.scene.more.changelog.intro;

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
public final class NavItem {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NavItem[] $VALUES;
    public static final NavItem NAV_FIRST = new NavItem("NAV_FIRST", 0);
    public static final NavItem NAV_SECOND = new NavItem("NAV_SECOND", 1);
    public static final NavItem NAV_THIRD = new NavItem("NAV_THIRD", 2);

    private static final /* synthetic */ NavItem[] $values() {
        return new NavItem[]{NAV_FIRST, NAV_SECOND, NAV_THIRD};
    }

    static {
        NavItem[] navItemArr$values = $values();
        $VALUES = navItemArr$values;
        $ENTRIES = EnumEntriesKt.a(navItemArr$values);
    }

    private NavItem(String str, int i3) {
    }

    public static EnumEntries<NavItem> getEntries() {
        return $ENTRIES;
    }

    public static NavItem valueOf(String str) {
        return (NavItem) Enum.valueOf(NavItem.class, str);
    }

    public static NavItem[] values() {
        return (NavItem[]) $VALUES.clone();
    }
}
