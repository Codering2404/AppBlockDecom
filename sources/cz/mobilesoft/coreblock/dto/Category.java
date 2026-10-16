package cz.mobilesoft.coreblock.dto;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
@Metadata
public final class Category {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Category[] $VALUES;
    public static final Category CREATIVITY;
    public static final Companion Companion;
    public static final Category EDUCATION;
    public static final Category ENTERTAINMENT;
    public static final Category GAMES;
    public static final Category HEALTH;
    public static final Category NEWS;
    public static final Category NOT_FOUND;
    public static final Category OTHER;
    public static final Category PRODUCTIVITY;
    public static final Category SHOPPING;
    public static final Category SOCIAL;
    public static final Category TRAVEL;
    public static final Category UTILITIES;
    private final AppDistractionType appDistractionType;
    private final int iconRes;
    private final int mask;
    private final int titleRes;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(List categories) {
            Intrinsics.checkNotNullParameter(categories, "categories");
            List<Category> list = categories;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Category category : list) {
                if (category == Category.NOT_FOUND) {
                    category = Category.OTHER;
                }
                arrayList.add(category);
            }
            Iterator it = CollectionsKt.distinct(arrayList).iterator();
            int mask = 0;
            while (it.hasNext()) {
                mask |= ((Category) it.next()).getMask();
            }
            return mask;
        }

        public final Category b(String str) {
            Category next;
            Iterator<Category> it = Category.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.name(), str)) {
                    break;
                }
            }
            Category category = next;
            return category == null ? Category.NOT_FOUND : category;
        }

        public final List c(int i3) {
            EnumEntries<Category> entries = Category.getEntries();
            ArrayList arrayList = new ArrayList();
            for (Category category : entries) {
                Category category2 = category;
                if (category2.getMask() != 0 && (category2.getMask() & i3) == category2.getMask()) {
                    arrayList.add(category);
                }
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ Category[] $values() {
        return new Category[]{SOCIAL, GAMES, ENTERTAINMENT, CREATIVITY, EDUCATION, HEALTH, PRODUCTIVITY, NEWS, SHOPPING, TRAVEL, UTILITIES, OTHER, NOT_FOUND};
    }

    static {
        int i3 = R.string.Y4;
        int i4 = R.drawable.j7;
        AppDistractionType appDistractionType = AppDistractionType.Distractive;
        SOCIAL = new Category("SOCIAL", 0, 1, i3, i4, appDistractionType);
        GAMES = new Category("GAMES", 1, 2, R.string.T4, R.drawable.d7, appDistractionType);
        ENTERTAINMENT = new Category("ENTERTAINMENT", 2, 4, R.string.S4, R.drawable.c7, null, 8, null);
        int i5 = R.string.Q4;
        int i6 = R.drawable.a7;
        AppDistractionType appDistractionType2 = AppDistractionType.Productive;
        CREATIVITY = new Category("CREATIVITY", 3, 8, i5, i6, appDistractionType2);
        EDUCATION = new Category("EDUCATION", 4, 16, R.string.R4, R.drawable.b7, appDistractionType2);
        HEALTH = new Category("HEALTH", 5, 32, R.string.U4, R.drawable.e7, null, 8, null);
        PRODUCTIVITY = new Category("PRODUCTIVITY", 6, 64, R.string.W4, R.drawable.h7, null, 8, null);
        NEWS = new Category("NEWS", 7, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, R.string.V4, R.drawable.f7, appDistractionType2);
        SHOPPING = new Category("SHOPPING", 8, Function.MAX_NARGS, R.string.X4, R.drawable.i7, appDistractionType);
        TRAVEL = new Category("TRAVEL", 9, 512, R.string.Z4, R.drawable.k7, null, 8, null);
        UTILITIES = new Category("UTILITIES", 10, 1024, R.string.a5, R.drawable.l7, appDistractionType2);
        int i7 = R.string.HD;
        int i8 = R.drawable.g7;
        OTHER = new Category("OTHER", 11, 2048, i7, i8, null, 8, null);
        NOT_FOUND = new Category("NOT_FOUND", 12, 4096, i7, i8, null, 8, null);
        Category[] categoryArr$values = $values();
        $VALUES = categoryArr$values;
        $ENTRIES = EnumEntriesKt.a(categoryArr$values);
        Companion = new Companion(null);
    }

    private Category(String str, int i3, int i4, int i5, int i6, AppDistractionType appDistractionType) {
        this.mask = i4;
        this.titleRes = i5;
        this.iconRes = i6;
        this.appDistractionType = appDistractionType;
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

    public final AppDistractionType getAppDistractionType() {
        return this.appDistractionType;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getMask() {
        return this.mask;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    /* synthetic */ Category(String str, int i3, int i4, int i5, int i6, AppDistractionType appDistractionType, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i4, i5, i6, (i7 & 8) != 0 ? AppDistractionType.Neutral : appDistractionType);
    }
}
