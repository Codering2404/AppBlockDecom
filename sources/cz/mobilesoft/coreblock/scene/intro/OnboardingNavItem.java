package cz.mobilesoft.coreblock.scene.intro;

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
public final class OnboardingNavItem {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ OnboardingNavItem[] $VALUES;
    private final String route;
    public static final OnboardingNavItem Welcome = new OnboardingNavItem("Welcome", 0, "welcome");
    public static final OnboardingNavItem SignIn = new OnboardingNavItem("SignIn", 1, "sign_in");
    public static final OnboardingNavItem Question1 = new OnboardingNavItem("Question1", 2, "question1");
    public static final OnboardingNavItem Explanation1Other = new OnboardingNavItem("Explanation1Other", 3, "answer_other");
    public static final OnboardingNavItem Explanation1Focus = new OnboardingNavItem("Explanation1Focus", 4, "answer_focus");
    public static final OnboardingNavItem Explanation1MentalHealth = new OnboardingNavItem("Explanation1MentalHealth", 5, "answer_mental_health");
    public static final OnboardingNavItem Explanation1PhoneUsage = new OnboardingNavItem("Explanation1PhoneUsage", 6, "answer_phone_usage");
    public static final OnboardingNavItem Explanation1Porn = new OnboardingNavItem("Explanation1Porn", 7, "answer_porn");
    public static final OnboardingNavItem Explanation1Gaming = new OnboardingNavItem("Explanation1Gaming", 8, "answer_gaming");
    public static final OnboardingNavItem Explanation1Sleep = new OnboardingNavItem("Explanation1Sleep", 9, "answer_sleep");
    public static final OnboardingNavItem Explanation2 = new OnboardingNavItem("Explanation2", 10, "explanation2");
    public static final OnboardingNavItem Reviews = new OnboardingNavItem("Reviews", 11, "reviews");
    public static final OnboardingNavItem StatsQuestion1 = new OnboardingNavItem("StatsQuestion1", 12, "stats_question1");
    public static final OnboardingNavItem StatsQuestion2 = new OnboardingNavItem("StatsQuestion2", 13, "stats_question2");
    public static final OnboardingNavItem PrivacyExplanation = new OnboardingNavItem("PrivacyExplanation", 14, "privacy_explanation");
    public static final OnboardingNavItem StatsPermission = new OnboardingNavItem("StatsPermission", 15, "stats_permission");
    public static final OnboardingNavItem StatsReport = new OnboardingNavItem("StatsReport", 16, "stats_report");
    public static final OnboardingNavItem StatsExplanation1 = new OnboardingNavItem("StatsExplanation1", 17, "stats_explanation1");
    public static final OnboardingNavItem StatsExplanation2 = new OnboardingNavItem("StatsExplanation2", 18, "stats_explanation2");
    public static final OnboardingNavItem StatsExplanation3 = new OnboardingNavItem("StatsExplanation3", 19, "stats_explanation3");
    public static final OnboardingNavItem FeaturesOverview = new OnboardingNavItem("FeaturesOverview", 20, "features_overview");
    public static final OnboardingNavItem QuickBlockAbout = new OnboardingNavItem("QuickBlockAbout", 21, "quick_block_about");
    public static final OnboardingNavItem StrictModeAbout = new OnboardingNavItem("StrictModeAbout", 22, "strict_mode_about");

    private static final /* synthetic */ OnboardingNavItem[] $values() {
        return new OnboardingNavItem[]{Welcome, SignIn, Question1, Explanation1Other, Explanation1Focus, Explanation1MentalHealth, Explanation1PhoneUsage, Explanation1Porn, Explanation1Gaming, Explanation1Sleep, Explanation2, Reviews, StatsQuestion1, StatsQuestion2, PrivacyExplanation, StatsPermission, StatsReport, StatsExplanation1, StatsExplanation2, StatsExplanation3, FeaturesOverview, QuickBlockAbout, StrictModeAbout};
    }

    static {
        OnboardingNavItem[] onboardingNavItemArr$values = $values();
        $VALUES = onboardingNavItemArr$values;
        $ENTRIES = EnumEntriesKt.a(onboardingNavItemArr$values);
    }

    private OnboardingNavItem(String str, int i3, String str2) {
        this.route = str2;
    }

    public static EnumEntries<OnboardingNavItem> getEntries() {
        return $ENTRIES;
    }

    public static OnboardingNavItem valueOf(String str) {
        return (OnboardingNavItem) Enum.valueOf(OnboardingNavItem.class, str);
    }

    public static OnboardingNavItem[] values() {
        return (OnboardingNavItem[]) $VALUES.clone();
    }

    public final String getRoute() {
        return this.route;
    }
}
