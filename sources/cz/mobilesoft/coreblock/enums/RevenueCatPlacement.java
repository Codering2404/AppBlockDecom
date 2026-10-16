package cz.mobilesoft.coreblock.enums;

import cz.mobilesoft.coreblock.storage.sharedprefs.PrefConverter;
import dev.doubledot.doki.api.extensions.ConstantsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
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
public final class RevenueCatPlacement {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RevenueCatPlacement[] $VALUES;
    public static final RevenueCatPlacement BottomBar;
    public static final RevenueCatPlacement Campaign;
    public static final Companion Companion;
    public static final RevenueCatPlacement Discount20;
    public static final RevenueCatPlacement Discount50;
    public static final RevenueCatPlacement General;
    public static final RevenueCatPlacement LimitScreen;
    public static final RevenueCatPlacement Onboarding;
    public static final RevenueCatPlacement PremiumBenefits;
    public static final RevenueCatPlacement PremiumScreen;
    public static final RevenueCatPlacement ReceivedGuestPass;
    public static final RevenueCatPlacement SharedGuestPass;
    public static final RevenueCatPlacement TrialHeadsUp;
    public static final RevenueCatPlacement TrialRetention;
    public static final RevenueCatPlacement TrialToggle;
    private static final Lazy<List<RevenueCatPlacement>> discountedPlacements$delegate;
    private final boolean forcePlacementOffering;
    private final String id;
    private final boolean isDiscount;
    public static final RevenueCatPlacement RenewPremium = new RevenueCatPlacement("RenewPremium", 4, "renewPremium", true, false, 4, null);
    public static final RevenueCatPlacement PromoTrialUpgrade = new RevenueCatPlacement("PromoTrialUpgrade", 5, "promoTrialUpgrade", true, true);
    public static final RevenueCatPlacement PremiumRetention = new RevenueCatPlacement("PremiumRetention", 6, "premiumRetention", true, false, 4, null);
    public static final RevenueCatPlacement ReferralReceived = new RevenueCatPlacement("ReferralReceived", 9, "referralReceived", true, false, 4, null);
    public static final RevenueCatPlacement ReferralSent = new RevenueCatPlacement("ReferralSent", 10, "referralSent", true, false, 4, null);
    public static final RevenueCatPlacement OnetimeToSub = new RevenueCatPlacement("OnetimeToSub", 11, "onetimeToSub", true, false, 4, null);
    public static final RevenueCatPlacement ExSubscribers = new RevenueCatPlacement("ExSubscribers", 12, "ex-subscribers", true, false, 4, null);
    public static final RevenueCatPlacement ExitDiscount = new RevenueCatPlacement("ExitDiscount", 16, "exitDiscount", true, false, 4, null);
    public static final RevenueCatPlacement Discount30 = new RevenueCatPlacement("Discount30", 18, "discount30", true, false, 4, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RevenueCatPlacement a(String str) {
            RevenueCatPlacement next;
            Iterator<RevenueCatPlacement> it = RevenueCatPlacement.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.getId(), str)) {
                    break;
                }
            }
            return next;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Converter implements PrefConverter<RevenueCatPlacement, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Converter f97039a = new Converter();

        private Converter() {
        }

        @Override // cz.mobilesoft.coreblock.storage.sharedprefs.PrefConverter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String getId(RevenueCatPlacement revenueCatPlacement) {
            if (revenueCatPlacement != null) {
                return revenueCatPlacement.name();
            }
            return null;
        }
    }

    private static final /* synthetic */ RevenueCatPlacement[] $values() {
        return new RevenueCatPlacement[]{General, Onboarding, LimitScreen, BottomBar, RenewPremium, PromoTrialUpgrade, PremiumRetention, TrialRetention, PremiumBenefits, ReferralReceived, ReferralSent, OnetimeToSub, ExSubscribers, Campaign, PremiumScreen, TrialHeadsUp, ExitDiscount, Discount20, Discount30, Discount50, SharedGuestPass, ReceivedGuestPass, TrialToggle};
    }

    static {
        boolean z2 = false;
        General = new RevenueCatPlacement("General", 0, ConstantsKt.DONT_KILL_MY_APP_FALLBACK_MANUFACTURER, false, z2, 6, null);
        boolean z3 = false;
        Onboarding = new RevenueCatPlacement("Onboarding", 1, "onboarding", z2, z3, 6, null);
        boolean z4 = false;
        LimitScreen = new RevenueCatPlacement("LimitScreen", 2, "limitScreen", z3, z4, 6, null);
        BottomBar = new RevenueCatPlacement("BottomBar", 3, "bottomBar", z4, false, 6, null);
        boolean z5 = false;
        TrialRetention = new RevenueCatPlacement("TrialRetention", 7, "trialRetention", true, z5, 4, null);
        DefaultConstructorMarker defaultConstructorMarker = null;
        PremiumBenefits = new RevenueCatPlacement("PremiumBenefits", 8, "premiumBenefits", z5, false, 6, defaultConstructorMarker);
        boolean z6 = false;
        Campaign = new RevenueCatPlacement("Campaign", 13, "campaign", true, z6, 4, null);
        boolean z7 = false;
        PremiumScreen = new RevenueCatPlacement("PremiumScreen", 14, "premiumInAccount", z6, z7, 6, null);
        TrialHeadsUp = new RevenueCatPlacement("TrialHeadsUp", 15, "trialHeadsUp", z7, false, 6, null);
        Discount20 = new RevenueCatPlacement("Discount20", 17, "discount20", true, false, 4, defaultConstructorMarker);
        boolean z8 = false;
        Discount50 = new RevenueCatPlacement("Discount50", 19, "discount50", true, z8, 4, null);
        boolean z9 = false;
        SharedGuestPass = new RevenueCatPlacement("SharedGuestPass", 20, "guestPass", z8, z9, 6, null);
        boolean z10 = false;
        ReceivedGuestPass = new RevenueCatPlacement("ReceivedGuestPass", 21, "receivedGuessPass", z9, z10, 6, null);
        TrialToggle = new RevenueCatPlacement("TrialToggle", 22, "trial_toggle", z10, false, 6, null);
        RevenueCatPlacement[] revenueCatPlacementArr$values = $values();
        $VALUES = revenueCatPlacementArr$values;
        $ENTRIES = EnumEntriesKt.a(revenueCatPlacementArr$values);
        Companion = new Companion(null);
        discountedPlacements$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.i0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RevenueCatPlacement.discountedPlacements_delegate$lambda$0();
            }
        });
    }

    private RevenueCatPlacement(String str, int i3, String str2, boolean z2, boolean z3) {
        this.id = str2;
        this.isDiscount = z2;
        this.forcePlacementOffering = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List discountedPlacements_delegate$lambda$0() {
        EnumEntries<RevenueCatPlacement> entries = getEntries();
        ArrayList arrayList = new ArrayList();
        for (RevenueCatPlacement revenueCatPlacement : entries) {
            if (revenueCatPlacement.isDiscount) {
                arrayList.add(revenueCatPlacement);
            }
        }
        return arrayList;
    }

    public static EnumEntries<RevenueCatPlacement> getEntries() {
        return $ENTRIES;
    }

    public static RevenueCatPlacement valueOf(String str) {
        return (RevenueCatPlacement) Enum.valueOf(RevenueCatPlacement.class, str);
    }

    public static RevenueCatPlacement[] values() {
        return (RevenueCatPlacement[]) $VALUES.clone();
    }

    public final boolean getForcePlacementOffering() {
        return this.forcePlacementOffering;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean isDiscount() {
        return this.isDiscount;
    }

    /* synthetic */ RevenueCatPlacement(String str, int i3, String str2, boolean z2, boolean z3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, str2, (i4 & 2) != 0 ? false : z2, (i4 & 4) != 0 ? false : z3);
    }
}
