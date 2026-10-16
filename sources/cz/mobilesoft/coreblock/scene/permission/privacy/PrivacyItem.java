package cz.mobilesoft.coreblock.scene.permission.privacy;

import cz.mobilesoft.coreblock.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PrivacyItem {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PrivacyItem[] $VALUES;
    private final List<Integer> descriptionPlaceholderResIds;
    private final int descriptionResId;
    private final int titleResId;
    public static final PrivacyItem StatisticsData = new PrivacyItem("StatisticsData", 0, R.string.xq, R.string.vq, CollectionsKt.listOf(Integer.valueOf(R.string.wq)));
    public static final PrivacyItem BlockingsData = new PrivacyItem("BlockingsData", 1, R.string.pq, R.string.oq, null, 4, null);
    public static final PrivacyItem LoginData = new PrivacyItem("LoginData", 2, R.string.sq, R.string.rq, CollectionsKt.listOf(Integer.valueOf(R.string.qq)));
    public static final PrivacyItem AnalyticsData = new PrivacyItem("AnalyticsData", 3, R.string.nq, R.string.mq, 0 == true ? 1 : 0, 4, null);

    private static final /* synthetic */ PrivacyItem[] $values() {
        return new PrivacyItem[]{StatisticsData, BlockingsData, LoginData, AnalyticsData};
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        PrivacyItem[] privacyItemArr$values = $values();
        $VALUES = privacyItemArr$values;
        $ENTRIES = EnumEntriesKt.a(privacyItemArr$values);
    }

    private PrivacyItem(String str, int i3, int i4, int i5, List list) {
        this.titleResId = i4;
        this.descriptionResId = i5;
        this.descriptionPlaceholderResIds = list;
    }

    public static EnumEntries<PrivacyItem> getEntries() {
        return $ENTRIES;
    }

    public static PrivacyItem valueOf(String str) {
        return (PrivacyItem) Enum.valueOf(PrivacyItem.class, str);
    }

    public static PrivacyItem[] values() {
        return (PrivacyItem[]) $VALUES.clone();
    }

    public final List<Integer> getDescriptionPlaceholderResIds() {
        return this.descriptionPlaceholderResIds;
    }

    public final int getDescriptionResId() {
        return this.descriptionResId;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    /* synthetic */ PrivacyItem(String str, int i3, int i4, int i5, List list, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i4, i5, (i6 & 4) != 0 ? CollectionsKt.emptyList() : list);
    }
}
