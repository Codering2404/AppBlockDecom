package cz.mobilesoft.coreblock.scene.insights.settings;

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
public final class ExcludedAppsSections {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ExcludedAppsSections[] $VALUES;
    public static final ExcludedAppsSections Custom = new ExcludedAppsSections("Custom", 0, R.string.N8);
    public static final ExcludedAppsSections Default = new ExcludedAppsSections("Default", 1, R.string.n9);
    private final int titleRes;

    private static final /* synthetic */ ExcludedAppsSections[] $values() {
        return new ExcludedAppsSections[]{Custom, Default};
    }

    static {
        ExcludedAppsSections[] excludedAppsSectionsArr$values = $values();
        $VALUES = excludedAppsSectionsArr$values;
        $ENTRIES = EnumEntriesKt.a(excludedAppsSectionsArr$values);
    }

    private ExcludedAppsSections(String str, int i3, int i4) {
        this.titleRes = i4;
    }

    public static EnumEntries<ExcludedAppsSections> getEntries() {
        return $ENTRIES;
    }

    public static ExcludedAppsSections valueOf(String str) {
        return (ExcludedAppsSections) Enum.valueOf(ExcludedAppsSections.class, str);
    }

    public static ExcludedAppsSections[] values() {
        return (ExcludedAppsSections[]) $VALUES.clone();
    }

    public final int getTitleRes() {
        return this.titleRes;
    }
}
