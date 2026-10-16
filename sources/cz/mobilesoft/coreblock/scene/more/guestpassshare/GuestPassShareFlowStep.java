package cz.mobilesoft.coreblock.scene.more.guestpassshare;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class GuestPassShareFlowStep {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GuestPassShareFlowStep[] $VALUES;
    public static final GuestPassShareFlowStep ActivateReceivedGuestPass;
    public static final GuestPassShareFlowStep ActivateSharedGuestPass;
    public static final GuestPassShareFlowStep GuestPassActivated;
    public static final GuestPassShareFlowStep GuestPassEligibleShare;
    public static final GuestPassShareFlowStep OnboardingShare;
    public static final GuestPassShareFlowStep ShareWithActivePremium;
    public static final GuestPassShareFlowStep ThanksForSharing;
    private final GuestPassShareBottomButtonState bottomButtonState;
    private final boolean navigatesImmediately;
    private final Function1<Activity, PremiumScreenViewEvent> primaryActionEvent;
    private final String route;
    private final Integer secondaryButtonText;
    private final boolean showCloseButton;
    private final String subtitle;
    private final String title;

    private static final /* synthetic */ GuestPassShareFlowStep[] $values() {
        return new GuestPassShareFlowStep[]{GuestPassEligibleShare, ActivateSharedGuestPass, ActivateReceivedGuestPass, GuestPassActivated, ShareWithActivePremium, ThanksForSharing, OnboardingShare};
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        String string = LockieApplication.g().getString(R.string.cf);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = LockieApplication.g().getString(R.string.af, 14);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        GuestPassShareBottomButtonState guestPassShareBottomButtonState = GuestPassShareBottomButtonState.ShareReferralLink;
        GuestPassEligibleShare = new GuestPassShareFlowStep("GuestPassEligibleShare", 0, "guest_pass_eligible_share", string, string2, guestPassShareBottomButtonState, true, new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.m0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GuestPassShareFlowStep._init_$lambda$0((Activity) obj);
            }
        }, false, null, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, null);
        Context contextG = LockieApplication.g();
        int i3 = R.string.f95854w;
        Context contextG2 = LockieApplication.g();
        int i4 = R.string.yl;
        String string3 = contextG.getString(i3, contextG2.getString(i4, 14));
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        Context contextG3 = LockieApplication.g();
        int i5 = R.string.jf;
        Resources resources = LockieApplication.g().getResources();
        int i6 = R.plurals.f95748i;
        String string4 = contextG3.getString(i5, resources.getQuantityString(i6, 14, 14));
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        GuestPassShareBottomButtonState guestPassShareBottomButtonState2 = GuestPassShareBottomButtonState.ActivateGuestPass;
        ActivateSharedGuestPass = new GuestPassShareFlowStep("ActivateSharedGuestPass", 1, "guest_pass_activate", string3, string4, guestPassShareBottomButtonState2, true, new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.n0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GuestPassShareFlowStep._init_$lambda$1((Activity) obj);
            }
        }, false, null, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, null);
        String string5 = LockieApplication.g().getString(i3, LockieApplication.g().getString(i4, 14));
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        String string6 = LockieApplication.g().getString(R.string.f95851v, LockieApplication.g().getResources().getQuantityString(i6, 14, 14));
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        ActivateReceivedGuestPass = new GuestPassShareFlowStep("ActivateReceivedGuestPass", 2, "guest_pass_activate", string5, string6, guestPassShareBottomButtonState2, true, new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.o0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GuestPassShareFlowStep._init_$lambda$2((Activity) obj);
            }
        }, false, null, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, null);
        String string7 = LockieApplication.g().getString(R.string.hf, LockieApplication.g().getString(i4, 14));
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        String string8 = LockieApplication.g().getString(R.string.gf);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        boolean z2 = false;
        GuestPassActivated = new GuestPassShareFlowStep("GuestPassActivated", 3, "guest_pass_activated", string7, string8, GuestPassShareBottomButtonState.LetsGo, z2, new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.p0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GuestPassShareFlowStep._init_$lambda$3((Activity) obj);
            }
        }, false, null, 192, null);
        Context contextG4 = LockieApplication.g();
        int i7 = R.string.df;
        String string9 = contextG4.getString(i7);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        Context contextG5 = LockieApplication.g();
        int i8 = R.string.bf;
        String string10 = contextG5.getString(i8, 14);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
        ShareWithActivePremium = new GuestPassShareFlowStep("ShareWithActivePremium", 4, "guest_pass_share_with_active_premium", string9, string10, guestPassShareBottomButtonState, true, new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.q0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GuestPassShareFlowStep._init_$lambda$4((Activity) obj);
            }
        }, false, null, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, null);
        String string11 = LockieApplication.g().getString(R.string.ff);
        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
        String string12 = LockieApplication.g().getString(R.string.ef);
        Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
        ThanksForSharing = new GuestPassShareFlowStep("ThanksForSharing", 5, "guest_pass_thanks_for_sharing", string11, string12, GuestPassShareBottomButtonState.Thanks, false, new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.r0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GuestPassShareFlowStep._init_$lambda$5((Activity) obj);
            }
        }, z2, null, 192, null == true ? 1 : 0);
        String string13 = LockieApplication.g().getString(i7);
        Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
        String string14 = LockieApplication.g().getString(i8, 14);
        Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
        OnboardingShare = new GuestPassShareFlowStep("OnboardingShare", 6, "guest_pass_onboarding_share", string13, string14, guestPassShareBottomButtonState, false, new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.s0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GuestPassShareFlowStep._init_$lambda$6((Activity) obj);
            }
        }, false, Integer.valueOf(R.string.Ij));
        GuestPassShareFlowStep[] guestPassShareFlowStepArr$values = $values();
        $VALUES = guestPassShareFlowStepArr$values;
        $ENTRIES = EnumEntriesKt.a(guestPassShareFlowStepArr$values);
    }

    private GuestPassShareFlowStep(String str, int i3, String str2, String str3, String str4, GuestPassShareBottomButtonState guestPassShareBottomButtonState, boolean z2, Function1 function1, boolean z3, Integer num) {
        this.route = str2;
        this.title = str3;
        this.subtitle = str4;
        this.bottomButtonState = guestPassShareBottomButtonState;
        this.showCloseButton = z2;
        this.primaryActionEvent = function1;
        this.navigatesImmediately = z3;
        this.secondaryButtonText = num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewEvent _init_$lambda$0(Activity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return PremiumScreenViewEvent.OnShareReferralLinkClicked.f112360a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewEvent _init_$lambda$1(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new PremiumScreenViewEvent.OnPurchase(activity, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewEvent _init_$lambda$2(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new PremiumScreenViewEvent.OnPurchase(activity, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewEvent _init_$lambda$3(Activity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return PremiumScreenViewEvent.OnFinishClicked.f112352a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewEvent _init_$lambda$4(Activity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return PremiumScreenViewEvent.OnShareReferralLinkClicked.f112360a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewEvent _init_$lambda$5(Activity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return PremiumScreenViewEvent.OnFinishClicked.f112352a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewEvent _init_$lambda$6(Activity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return PremiumScreenViewEvent.OnShareReferralLinkClicked.f112360a;
    }

    public static EnumEntries<GuestPassShareFlowStep> getEntries() {
        return $ENTRIES;
    }

    public static GuestPassShareFlowStep valueOf(String str) {
        return (GuestPassShareFlowStep) Enum.valueOf(GuestPassShareFlowStep.class, str);
    }

    public static GuestPassShareFlowStep[] values() {
        return (GuestPassShareFlowStep[]) $VALUES.clone();
    }

    public final GuestPassShareBottomButtonState getBottomButtonState() {
        return this.bottomButtonState;
    }

    public final boolean getNavigatesImmediately() {
        return this.navigatesImmediately;
    }

    public final Function1<Activity, PremiumScreenViewEvent> getPrimaryActionEvent() {
        return this.primaryActionEvent;
    }

    public final String getRoute() {
        return this.route;
    }

    public final Integer getSecondaryButtonText() {
        return this.secondaryButtonText;
    }

    public final boolean getShowCloseButton() {
        return this.showCloseButton;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    /* synthetic */ GuestPassShareFlowStep(String str, int i3, String str2, String str3, String str4, GuestPassShareBottomButtonState guestPassShareBottomButtonState, boolean z2, Function1 function1, boolean z3, Integer num, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, str2, str3, str4, guestPassShareBottomButtonState, z2, function1, (i4 & 64) != 0 ? true : z3, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : num);
    }
}
