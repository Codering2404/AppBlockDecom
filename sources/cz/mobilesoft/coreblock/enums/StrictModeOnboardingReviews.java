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
public final class StrictModeOnboardingReviews {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StrictModeOnboardingReviews[] $VALUES;
    public static final StrictModeOnboardingReviews Review1 = new StrictModeOnboardingReviews("Review1", 0, "Loreen Dawn Pal", R.string.az);
    public static final StrictModeOnboardingReviews Review2 = new StrictModeOnboardingReviews("Review2", 1, "Archie", R.string.bz);
    public static final StrictModeOnboardingReviews Review3 = new StrictModeOnboardingReviews("Review3", 2, "K A", R.string.f95778cz);
    public static final StrictModeOnboardingReviews Review4 = new StrictModeOnboardingReviews("Review4", 3, "Samuel Landon", R.string.dz);
    public static final StrictModeOnboardingReviews Review5 = new StrictModeOnboardingReviews("Review5", 4, "Camilia BASTOS", R.string.ez);
    private final String authorName;
    private final int review;

    private static final /* synthetic */ StrictModeOnboardingReviews[] $values() {
        return new StrictModeOnboardingReviews[]{Review1, Review2, Review3, Review4, Review5};
    }

    static {
        StrictModeOnboardingReviews[] strictModeOnboardingReviewsArr$values = $values();
        $VALUES = strictModeOnboardingReviewsArr$values;
        $ENTRIES = EnumEntriesKt.a(strictModeOnboardingReviewsArr$values);
    }

    private StrictModeOnboardingReviews(String str, int i3, String str2, int i4) {
        this.authorName = str2;
        this.review = i4;
    }

    public static EnumEntries<StrictModeOnboardingReviews> getEntries() {
        return $ENTRIES;
    }

    public static StrictModeOnboardingReviews valueOf(String str) {
        return (StrictModeOnboardingReviews) Enum.valueOf(StrictModeOnboardingReviews.class, str);
    }

    public static StrictModeOnboardingReviews[] values() {
        return (StrictModeOnboardingReviews[]) $VALUES.clone();
    }

    public final String getAuthorName() {
        return this.authorName;
    }

    public final int getReview() {
        return this.review;
    }
}
