package cz.mobilesoft.coreblock.enums;

import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.intro.HelpItemWithExplanation;
import cz.mobilesoft.coreblock.scene.intro.OnboardingHelpItem;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
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
public final class Review {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Review[] $VALUES;
    public static final Companion Companion;
    public static final Review Focus6;
    public static final Review PhoneUsage2;
    public static final Review PhoneUsage3;
    public static final Review Sleep2;
    public static final Review Statistics1;
    public static final Review TimerAndStatistics;
    private static final Lazy<List<Review>> focusReviews$delegate;
    private static final Lazy<List<Review>> gamingReviews$delegate;
    private static final Lazy<List<Review>> mentalHealthReviews$delegate;
    private static final Lazy<List<Review>> otherReviews$delegate;
    private static final Lazy<List<Review>> phoneUsageReviews$delegate;
    private static final Lazy<List<Review>> pornReviews$delegate;
    private static final Lazy<List<Review>> sleepReviews$delegate;
    private final int rating;
    private final int review;
    private final String userName;
    public static final Review Generic1 = new Review("Generic1", 0, "Andrea Schneiber", R.string.et, 0, 4, null);
    public static final Review Generic2 = new Review("Generic2", 1, "Pedro Lopéz", R.string.ft, 0, 4, null);
    public static final Review Generic3 = new Review("Generic3", 2, "Joe Bennett", R.string.gt, 0, 4, null);
    public static final Review Generic4 = new Review("Generic4", 3, "Rafael Borges", R.string.ht, 0, 4, null);
    public static final Review Generic5 = new Review("Generic5", 4, "Danya Samara", R.string.jt, 0, 4, null);
    public static final Review Generic6 = new Review("Generic6", 5, "Avram", R.string.kt, 0, 4, null);
    public static final Review Academy1 = new Review("Academy1", 6, "Jabril Raymond", R.string.Ls, 0, 4, null);
    public static final Review Academy2 = new Review("Academy2", 7, "Gerald Noor", R.string.Ms, 0, 4, null);
    public static final Review Statistics2 = new Review("Statistics2", 9, "Jazlyn Azhar", R.string.Gt, 0, 4, null);
    public static final Review ProfilesCount1 = new Review("ProfilesCount1", 10, "Des Keely", R.string.tt, 0, 4, null);
    public static final Review ProfilesCount2 = new Review("ProfilesCount2", 11, "Rene Ranya", R.string.ut, 0, 4, null);
    public static final Review ProfilesCount3 = new Review("ProfilesCount3", 12, "Corey River", R.string.vt, 0, 4, null);
    public static final Review ProfilesAndAppCount = new Review("ProfilesAndAppCount", 13, "Nick Chambers", R.string.st, 0, 4, null);
    public static final Review SmTimer1 = new Review("SmTimer1", 14, "Danne Delgado", R.string.Et, 0, 4, null);
    public static final Review Timer1 = new Review("Timer1", 15, "Dinesh Kulkarni", R.string.Ht, 0, 4, null);
    public static final Review Timer2 = new Review("Timer2", 16, "Cristen Lorinda", R.string.It, 0, 4, null);
    public static final Review SmAndAnia = new Review("SmAndAnia", 18, "Rajendra", R.string.Dt, 0, 4, null);
    public static final Review Ania1 = new Review("Ania1", 19, "Jim Hastings", R.string.Ns, 0, 4, null);
    public static final Review Focus1 = new Review("Focus1", 20, "Nancy Jaramillo", R.string.Ys, 0, 4, null);
    public static final Review Focus2 = new Review("Focus2", 21, "Mimo", R.string.Xs, 0, 4, null);
    public static final Review Focus3 = new Review("Focus3", 22, "Vishwajit Lokhare", R.string.at, 0, 4, null);
    public static final Review Focus4 = new Review("Focus4", 23, "Nguyễn Phương Ngân", R.string.Zs, 0, 4, null);
    public static final Review Focus5 = new Review("Focus5", 24, "Addison Bartlett", R.string.Ts, 4);
    public static final Review Focus7 = new Review("Focus7", 26, "Graziely Monique Gimenes", R.string.Vs, 5);
    public static final Review Focus8 = new Review("Focus8", 27, "Jokha Al zakwani", R.string.Ws, 0, 4, null);
    public static final Review MentalHealth1 = new Review("MentalHealth1", 28, "J. J.", R.string.mt, 0, 4, null);
    public static final Review MentalHealth2 = new Review("MentalHealth2", 29, "Allison", R.string.lt, 0, 4, null);
    public static final Review MentalHealth3 = new Review("MentalHealth3", 30, "Kate Culhane", R.string.nt, 0, 4, null);
    public static final Review MentalHealth4 = new Review("MentalHealth4", 31, "Kelsey Spoelman", R.string.ot, 0, 4, null);
    public static final Review PhoneUsage1 = new Review("PhoneUsage1", 32, "D", R.string.Qs, 4);
    public static final Review PhoneUsage4 = new Review("PhoneUsage4", 35, "Aryan Kumar Jha", R.string.Ps, 0, 4, null);
    public static final Review PhoneUsage5 = new Review("PhoneUsage5", 36, "G T", R.string.Rs, 0, 4, null);
    public static final Review Porn1 = new Review("Porn1", 37, "Druid 896", R.string.qt, 0, 4, null);
    public static final Review Porn2 = new Review("Porn2", 38, "Sudais Jan", R.string.rt, 0, 4, null);
    public static final Review Gaming1 = new Review("Gaming1", 39, "Prashant Gadge", R.string.dt, 0, 4, null);
    public static final Review Gaming2 = new Review("Gaming2", 40, "Michael Pettinger", R.string.ct, 0, 4, null);
    public static final Review Gaming3 = new Review("Gaming3", 41, "Davic Miscnx", R.string.bt, 0, 4, null);
    public static final Review Sleep1 = new Review("Sleep1", 42, "Arun Kumar", R.string.zt, 0, 4, null);
    public static final Review Sleep3 = new Review("Sleep3", 44, "Heather Miracle", R.string.Bt, 0, 4, null);
    public static final Review Sleep4 = new Review("Sleep4", 45, "Errol Phalo de Jesus", R.string.At, 0, 4, null);
    public static final Review RcTrial1 = new Review("RcTrial1", 46, "Marat Ryndin", R.string.wt, 0, 4, null);
    public static final Review RcTrial2 = new Review("RcTrial2", 47, "Abbas358336", R.string.xt, 0, 4, null);
    public static final Review RcTrial3 = new Review("RcTrial3", 48, "OmarEwen", R.string.yt, 0, 4, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f97040a;

            static {
                int[] iArr = new int[PremiumFeature.values().length];
                try {
                    iArr[PremiumFeature.ACADEMY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PremiumFeature.STATISTICS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PremiumFeature.STATISTICS_IGNORE_UNLIMITED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[PremiumFeature.STATISTICS_SCREEN_UNLOCKS.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[PremiumFeature.STATISTICS_LAUNCH_COUNT.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[PremiumFeature.QUICK_BLOCK_TIMER.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[PremiumFeature.PROFILES_UNLIMITED.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[PremiumFeature.QUICK_BLOCK_APPS_UNLIMITED.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[PremiumFeature.PROFILES_APPS_UNLIMITED.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[PremiumFeature.STRICT_MODE_PROFILES.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[PremiumFeature.STRICT_MODE_TIMER.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[PremiumFeature.ADD_NEWLY_INSTALLED_APPS.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                f97040a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List a() {
            return (List) Review.focusReviews$delegate.getValue();
        }

        private final List c() {
            return (List) Review.gamingReviews$delegate.getValue();
        }

        private final List e() {
            return (List) Review.mentalHealthReviews$delegate.getValue();
        }

        private final List f() {
            return (List) Review.otherReviews$delegate.getValue();
        }

        private final List g() {
            return (List) Review.phoneUsageReviews$delegate.getValue();
        }

        private final List h() {
            return (List) Review.pornReviews$delegate.getValue();
        }

        private final List k() {
            return (List) Review.sleepReviews$delegate.getValue();
        }

        public final List b(OnboardingHelpItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (Intrinsics.areEqual(item, HelpItemWithExplanation.Focus.f104478j)) {
                return a();
            }
            if (Intrinsics.areEqual(item, HelpItemWithExplanation.Gaming.f104479j)) {
                return c();
            }
            if (Intrinsics.areEqual(item, HelpItemWithExplanation.MentalHealth.f104480j)) {
                return e();
            }
            if (Intrinsics.areEqual(item, HelpItemWithExplanation.PhoneUsage.f104481j)) {
                return g();
            }
            if (Intrinsics.areEqual(item, HelpItemWithExplanation.Porn.f104482j)) {
                return h();
            }
            if (Intrinsics.areEqual(item, HelpItemWithExplanation.Sleep.f104483j)) {
                return k();
            }
            if (Intrinsics.areEqual(item, OnboardingHelpItem.Other.f104503g)) {
                return f();
            }
            throw new NoWhenBranchMatchedException();
        }

        public final List d() {
            return CollectionsKt.listOf((Object[]) new Review[]{Review.Generic1, Review.Generic2, Review.Generic5, Review.Generic4});
        }

        public final List i() {
            return CollectionsKt.listOf((Object[]) new Review[]{Review.RcTrial1, Review.RcTrial2, Review.RcTrial3});
        }

        public final List j(PremiumFeature premiumFeature) {
            switch (premiumFeature == null ? -1 : WhenMappings.f97040a[premiumFeature.ordinal()]) {
                case 1:
                    return CollectionsKt.listOf((Object[]) new Review[]{Review.Academy1, Review.Academy2, Review.Generic1});
                case 2:
                case 3:
                case 4:
                case 5:
                    return CollectionsKt.listOf((Object[]) new Review[]{Review.Statistics1, Review.Statistics2, Review.TimerAndStatistics});
                case 6:
                    return CollectionsKt.listOf((Object[]) new Review[]{Review.Timer2, Review.TimerAndStatistics, Review.Generic5});
                case 7:
                    return CollectionsKt.listOf((Object[]) new Review[]{Review.ProfilesCount1, Review.ProfilesCount2, Review.ProfilesCount3});
                case 8:
                case 9:
                    return CollectionsKt.listOf((Object[]) new Review[]{Review.ProfilesAndAppCount, Review.Generic5, Review.Generic6});
                case 10:
                    return CollectionsKt.listOf((Object[]) new Review[]{Review.SmTimer1, Review.Timer1, Review.SmAndAnia});
                case 11:
                    return CollectionsKt.listOf((Object[]) new Review[]{Review.SmTimer1, Review.Timer1, Review.Timer2});
                case 12:
                    return CollectionsKt.listOf((Object[]) new Review[]{Review.SmAndAnia, Review.Ania1, Review.Generic5});
                default:
                    return d();
            }
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ Review[] $values() {
        return new Review[]{Generic1, Generic2, Generic3, Generic4, Generic5, Generic6, Academy1, Academy2, Statistics1, Statistics2, ProfilesCount1, ProfilesCount2, ProfilesCount3, ProfilesAndAppCount, SmTimer1, Timer1, Timer2, TimerAndStatistics, SmAndAnia, Ania1, Focus1, Focus2, Focus3, Focus4, Focus5, Focus6, Focus7, Focus8, MentalHealth1, MentalHealth2, MentalHealth3, MentalHealth4, PhoneUsage1, PhoneUsage2, PhoneUsage3, PhoneUsage4, PhoneUsage5, Porn1, Porn2, Gaming1, Gaming2, Gaming3, Sleep1, Sleep2, Sleep3, Sleep4, RcTrial1, RcTrial2, RcTrial3};
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        Statistics1 = new Review("Statistics1", 8, "Anastasia Vidal", R.string.Ft, 0, 4, defaultConstructorMarker);
        TimerAndStatistics = new Review("TimerAndStatistics", 17, "Sampath Patil", R.string.Jt, 0, 4, defaultConstructorMarker);
        int i3 = 4;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        Focus6 = new Review("Focus6", 25, "Gaaziya Fathima", R.string.Us, 0, i3, defaultConstructorMarker2);
        PhoneUsage2 = new Review("PhoneUsage2", 33, "Imtiaz Khan", R.string.Ss, 0, i3, defaultConstructorMarker2);
        PhoneUsage3 = new Review("PhoneUsage3", 34, "Adam Van Stone", R.string.Os, 0, 4, defaultConstructorMarker);
        Sleep2 = new Review("Sleep2", 43, "Helen Jeffrey-Bourne", R.string.Ct, 0, 4, defaultConstructorMarker);
        Review[] reviewArr$values = $values();
        $VALUES = reviewArr$values;
        $ENTRIES = EnumEntriesKt.a(reviewArr$values);
        Companion = new Companion(null);
        otherReviews$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.j0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Review.otherReviews_delegate$lambda$0();
            }
        });
        focusReviews$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.k0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Review.focusReviews_delegate$lambda$0();
            }
        });
        mentalHealthReviews$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.l0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Review.mentalHealthReviews_delegate$lambda$0();
            }
        });
        phoneUsageReviews$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.m0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Review.phoneUsageReviews_delegate$lambda$0();
            }
        });
        pornReviews$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.n0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Review.pornReviews_delegate$lambda$0();
            }
        });
        gamingReviews$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.o0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Review.gamingReviews_delegate$lambda$0();
            }
        });
        sleepReviews$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.p0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Review.sleepReviews_delegate$lambda$0();
            }
        });
    }

    private Review(String str, int i3, String str2, int i4, int i5) {
        this.userName = str2;
        this.review = i4;
        this.rating = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List focusReviews_delegate$lambda$0() {
        return CollectionsKt.listOf((Object[]) new Review[]{Focus1, Focus2, Focus8});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List gamingReviews_delegate$lambda$0() {
        return CollectionsKt.listOf((Object[]) new Review[]{Gaming1, Gaming2, Gaming3});
    }

    public static EnumEntries<Review> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List mentalHealthReviews_delegate$lambda$0() {
        return CollectionsKt.listOf((Object[]) new Review[]{MentalHealth1, MentalHealth2, MentalHealth3});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List otherReviews_delegate$lambda$0() {
        return CollectionsKt.listOf((Object[]) new Review[]{Generic3, Generic5, Generic6});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List phoneUsageReviews_delegate$lambda$0() {
        return CollectionsKt.listOf((Object[]) new Review[]{PhoneUsage3, PhoneUsage4, PhoneUsage5});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List pornReviews_delegate$lambda$0() {
        return CollectionsKt.listOf((Object[]) new Review[]{Porn1, Porn2});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List sleepReviews_delegate$lambda$0() {
        return CollectionsKt.listOf((Object[]) new Review[]{Sleep2, Sleep3, Sleep4});
    }

    public static Review valueOf(String str) {
        return (Review) Enum.valueOf(Review.class, str);
    }

    public static Review[] values() {
        return (Review[]) $VALUES.clone();
    }

    public final int getRating() {
        return this.rating;
    }

    public final int getReview() {
        return this.review;
    }

    public final String getUserName() {
        return this.userName;
    }

    /* synthetic */ Review(String str, int i3, String str2, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, str2, i4, (i6 & 4) != 0 ? 5 : i5);
    }
}
