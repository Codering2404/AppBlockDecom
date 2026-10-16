package cz.mobilesoft.coreblock.enums;

import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
@Metadata
public final class Category {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Category[] $VALUES;
    public static final Companion Companion;
    private static final Lazy<Map<String, Category>> allByTag$delegate;
    private final String tag;
    public static final Category SOCIAL = new Category("SOCIAL", 0, "social");
    public static final Category DATING = new Category("DATING", 1, "dating");
    public static final Category MUSIC = new Category("MUSIC", 2, "music");
    public static final Category VIDEO = new Category(ShareConstants.VIDEO_URL, 3, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO);
    public static final Category SHOPPING = new Category("SHOPPING", 4, "shopping");
    public static final Category COMMUNICATION = new Category("COMMUNICATION", 5, "communication");
    public static final Category NONE = new Category("NONE", 6, IntegrityManager.INTEGRITY_TYPE_NONE);
    public static final Category TOOLS = new Category("TOOLS", 7, "tools");
    public static final Category TRAVEL = new Category("TRAVEL", 8, "travel");
    public static final Category GAMES = new Category("GAMES", 9, "games");
    public static final Category PHOTO = new Category("PHOTO", 10, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
    public static final Category EDUCATION = new Category("EDUCATION", 11, "education");
    public static final Category NEWS = new Category("NEWS", 12, "news");
    public static final Category BROWSERS = new Category("BROWSERS", 13, "browsers");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map a() {
            return (Map) Category.allByTag$delegate.getValue();
        }

        public final Category b(String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Category category = (Category) a().get(tag);
            return category == null ? Category.NONE : category;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Converter {
        public final Category a(String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            return Category.Companion.b(tag);
        }

        public final String b(Category category) {
            Intrinsics.checkNotNullParameter(category, "category");
            return category.getTag();
        }
    }

    private static final /* synthetic */ Category[] $values() {
        return new Category[]{SOCIAL, DATING, MUSIC, VIDEO, SHOPPING, COMMUNICATION, NONE, TOOLS, TRAVEL, GAMES, PHOTO, EDUCATION, NEWS, BROWSERS};
    }

    static {
        Category[] categoryArr$values = $values();
        $VALUES = categoryArr$values;
        $ENTRIES = EnumEntriesKt.a(categoryArr$values);
        Companion = new Companion(null);
        allByTag$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Category.allByTag_delegate$lambda$0();
            }
        });
    }

    private Category(String str, int i3, String str2) {
        this.tag = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map allByTag_delegate$lambda$0() {
        Category[] categoryArrValues = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(categoryArrValues.length), 16));
        for (Category category : categoryArrValues) {
            linkedHashMap.put(category.tag, category);
        }
        return linkedHashMap;
    }

    @JvmStatic
    public static final Category getByTag(String str) {
        return Companion.b(str);
    }

    public static EnumEntries<Category> getEntries() {
        return $ENTRIES;
    }

    public static Category valueOf(String str) {
        return (Category) Enum.valueOf(Category.class, str);
    }

    public static Category[] values() {
        return (Category[]) $VALUES.clone();
    }

    public final String getTag() {
        return this.tag;
    }
}
