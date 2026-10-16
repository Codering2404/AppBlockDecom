package cz.mobilesoft.coreblock.enums;

import android.content.Context;
import cz.mobilesoft.coreblock.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
public final class OnboardingHearAboutUs {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ OnboardingHearAboutUs[] $VALUES;
    private final String analyticsKey;
    public static final OnboardingHearAboutUs GooglePlay = new OnboardingHearAboutUs("GooglePlay", 0, "google_play");
    public static final OnboardingHearAboutUs SearchEngine = new OnboardingHearAboutUs("SearchEngine", 1, "search_engine");
    public static final OnboardingHearAboutUs Friend = new OnboardingHearAboutUs("Friend", 2, "friend");
    public static final OnboardingHearAboutUs Blog = new OnboardingHearAboutUs("Blog", 3, "blog");
    public static final OnboardingHearAboutUs YouTube = new OnboardingHearAboutUs("YouTube", 4, "youtube");
    public static final OnboardingHearAboutUs Meta = new OnboardingHearAboutUs("Meta", 5, "meta");
    public static final OnboardingHearAboutUs Twitter = new OnboardingHearAboutUs("Twitter", 6, "twitter");
    public static final OnboardingHearAboutUs TikTok = new OnboardingHearAboutUs("TikTok", 7, "tiktok");
    public static final OnboardingHearAboutUs LinkedIn = new OnboardingHearAboutUs("LinkedIn", 8, "linkedin");
    public static final OnboardingHearAboutUs Influencer = new OnboardingHearAboutUs("Influencer", 9, "influencer");
    public static final OnboardingHearAboutUs iOS = new OnboardingHearAboutUs("iOS", 10, "iOS");
    public static final OnboardingHearAboutUs Other = new OnboardingHearAboutUs("Other", 11, "other");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f96991a;

        static {
            int[] iArr = new int[OnboardingHearAboutUs.values().length];
            try {
                iArr[OnboardingHearAboutUs.GooglePlay.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OnboardingHearAboutUs.SearchEngine.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OnboardingHearAboutUs.Friend.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OnboardingHearAboutUs.Blog.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[OnboardingHearAboutUs.YouTube.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[OnboardingHearAboutUs.Meta.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[OnboardingHearAboutUs.Twitter.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[OnboardingHearAboutUs.TikTok.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[OnboardingHearAboutUs.LinkedIn.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[OnboardingHearAboutUs.Influencer.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[OnboardingHearAboutUs.iOS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[OnboardingHearAboutUs.Other.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            f96991a = iArr;
        }
    }

    private static final /* synthetic */ OnboardingHearAboutUs[] $values() {
        return new OnboardingHearAboutUs[]{GooglePlay, SearchEngine, Friend, Blog, YouTube, Meta, Twitter, TikTok, LinkedIn, Influencer, iOS, Other};
    }

    static {
        OnboardingHearAboutUs[] onboardingHearAboutUsArr$values = $values();
        $VALUES = onboardingHearAboutUsArr$values;
        $ENTRIES = EnumEntriesKt.a(onboardingHearAboutUsArr$values);
    }

    private OnboardingHearAboutUs(String str, int i3, String str2) {
        this.analyticsKey = str2;
    }

    public static EnumEntries<OnboardingHearAboutUs> getEntries() {
        return $ENTRIES;
    }

    public static OnboardingHearAboutUs valueOf(String str) {
        return (OnboardingHearAboutUs) Enum.valueOf(OnboardingHearAboutUs.class, str);
    }

    public static OnboardingHearAboutUs[] values() {
        return (OnboardingHearAboutUs[]) $VALUES.clone();
    }

    public final String getAnalyticsKey() {
        return this.analyticsKey;
    }

    public final String getTitle(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        switch (WhenMappings.f96991a[ordinal()]) {
            case 1:
                return "Google Play";
            case 2:
                String string = context.getString(R.string.zf);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            case 3:
                String string2 = context.getString(R.string.wf);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            case 4:
                String string3 = context.getString(R.string.vf);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
            case 5:
                return "YouTube";
            case 6:
                return "Facebook / Instagram";
            case 7:
                return "X (Twitter)";
            case 8:
                return "TikTok";
            case 9:
                return "LinkedIn";
            case 10:
                String string4 = context.getString(R.string.xf);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                return string4;
            case 11:
                String string5 = context.getString(R.string.yf);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
            case 12:
                String string6 = context.getString(R.string.Ql);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                return string6;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
