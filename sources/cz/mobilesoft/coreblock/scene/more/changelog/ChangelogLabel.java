package cz.mobilesoft.coreblock.scene.more.changelog;

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
public final class ChangelogLabel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ChangelogLabel[] $VALUES;
    public static final ChangelogLabel FIXED;
    public static final ChangelogLabel IMPROVED;
    public static final ChangelogLabel NEW;
    public static final ChangelogLabel SUBS_ONLY;
    private final int backgroundColor;
    private final int textColorRes;
    private final int title;

    private static final /* synthetic */ ChangelogLabel[] $values() {
        return new ChangelogLabel[]{NEW, SUBS_ONLY, IMPROVED, FIXED};
    }

    static {
        int i3 = R.string.b7;
        int i4 = R.color.f95463r;
        int i5 = R.color.f95466u;
        NEW = new ChangelogLabel("NEW", 0, i3, i4, i5);
        SUBS_ONLY = new ChangelogLabel("SUBS_ONLY", 1, R.string.c7, R.color.f95465t, R.color.f95464s);
        IMPROVED = new ChangelogLabel("IMPROVED", 2, R.string.a7, R.color.f95446a, i5);
        FIXED = new ChangelogLabel("FIXED", 3, R.string.Z6, R.color.f95460o, R.color.f95462q);
        ChangelogLabel[] changelogLabelArr$values = $values();
        $VALUES = changelogLabelArr$values;
        $ENTRIES = EnumEntriesKt.a(changelogLabelArr$values);
    }

    private ChangelogLabel(String str, int i3, int i4, int i5, int i6) {
        this.title = i4;
        this.backgroundColor = i5;
        this.textColorRes = i6;
    }

    public static EnumEntries<ChangelogLabel> getEntries() {
        return $ENTRIES;
    }

    public static ChangelogLabel valueOf(String str) {
        return (ChangelogLabel) Enum.valueOf(ChangelogLabel.class, str);
    }

    public static ChangelogLabel[] values() {
        return (ChangelogLabel[]) $VALUES.clone();
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getTextColorRes() {
        return this.textColorRes;
    }

    public final int getTitle() {
        return this.title;
    }
}
