package cz.mobilesoft.coreblock.scene.dashboard;

import android.net.Uri;
import androidx.compose.runtime.MutableState;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.NavHostController;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.scene.auto_trial.AutoTrialActivity;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardViewCommand;
import cz.mobilesoft.coreblock.scene.premium.enums.DiscountSource;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringActivity;
import cz.mobilesoft.coreblock.util.helperextension.NumberExtKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$CommandProcessor$1$1", f = "DashboardActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class DashboardActivity$CommandProcessor$1$1 extends SuspendLambda implements Function2<DashboardViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f99150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f99151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DashboardActivity f99152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ NavHostController f99153d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function1 f99154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f99155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutableState f99156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ MutableState f99157i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DashboardActivity$CommandProcessor$1$1(DashboardActivity dashboardActivity, NavHostController navHostController, Function1 function1, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Continuation continuation) {
        super(2, continuation);
        this.f99152c = dashboardActivity;
        this.f99153d = navHostController;
        this.f99154f = function1;
        this.f99155g = mutableState;
        this.f99156h = mutableState2;
        this.f99157i = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DashboardActivity$CommandProcessor$1$1 dashboardActivity$CommandProcessor$1$1 = new DashboardActivity$CommandProcessor$1$1(this.f99152c, this.f99153d, this.f99154f, this.f99155g, this.f99156h, this.f99157i, continuation);
        dashboardActivity$CommandProcessor$1$1.f99151b = obj;
        return dashboardActivity$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(DashboardViewCommand dashboardViewCommand, Continuation continuation) {
        return ((DashboardActivity$CommandProcessor$1$1) create(dashboardViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        DashboardViewCommand dashboardViewCommand = (DashboardViewCommand) this.f99151b;
        IntrinsicsKt.f();
        if (this.f99150a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (dashboardViewCommand instanceof DashboardViewCommand.NavigateTo) {
            this.f99152c.M2(this.f99153d, ((DashboardViewCommand.NavigateTo) dashboardViewCommand).a(), this.f99154f);
        } else if (Intrinsics.areEqual(dashboardViewCommand, DashboardViewCommand.CheckAdConsent.f99231a)) {
            this.f99152c.B2();
        } else if (Intrinsics.areEqual(dashboardViewCommand, DashboardViewCommand.ShowReferralDiscountScreen.f99241a)) {
            this.f99152c.startActivity(Paywall.c(Paywall.f113165a, this.f99152c, new PaywallTarget.Discount(RevenueCatPlacement.ReferralReceived, DiscountSource.REFERRAL_RECEIVER, false, null), "blocking_tab", null, false, false, false, null, 248, null));
        } else if (dashboardViewCommand instanceof DashboardViewCommand.ShowCampaignOfferScreen) {
            DashboardViewCommand.ShowCampaignOfferScreen showCampaignOfferScreen = (DashboardViewCommand.ShowCampaignOfferScreen) dashboardViewCommand;
            this.f99152c.startActivity(Paywall.c(Paywall.f113165a, this.f99152c, new PaywallTarget.Campaign(showCampaignOfferScreen.a(), showCampaignOfferScreen.b(), "dashboard"), "blocking_tab", "blocking_tab", false, false, false, null, 240, null));
        } else if (dashboardViewCommand instanceof DashboardViewCommand.ShowProfileDisabledSuggestStrictModeDialog) {
            DashboardViewCommand.ShowProfileDisabledSuggestStrictModeDialog showProfileDisabledSuggestStrictModeDialog = (DashboardViewCommand.ShowProfileDisabledSuggestStrictModeDialog) dashboardViewCommand;
            this.f99155g.setValue(Boxing.a(NumberExtKt.c(showProfileDisabledSuggestStrictModeDialog.b())));
            this.f99156h.setValue(Boxing.a(showProfileDisabledSuggestStrictModeDialog.a()));
            this.f99157i.setValue(Boxing.a(true));
        } else if (Intrinsics.areEqual(dashboardViewCommand, DashboardViewCommand.ShowTrialRetention.f99242a)) {
            this.f99152c.startActivity(Paywall.c(Paywall.f113165a, this.f99152c, PaywallTarget.TrialRetention.INSTANCE, "blocking_tab", "blocking_tab", false, false, false, null, 240, null));
        } else if (Intrinsics.areEqual(dashboardViewCommand, DashboardViewCommand.ShowPremiumExpiringFlow.f99238a)) {
            this.f99152c.startActivity(PremiumExpiringActivity.Companion.b(PremiumExpiringActivity.f113543g, this.f99152c, "app_start", "renewal_screen", null, 8, null));
        } else if (Intrinsics.areEqual(dashboardViewCommand, DashboardViewCommand.ShowAutoTrialFlow.f99235a)) {
            DashboardActivity dashboardActivity = this.f99152c;
            dashboardActivity.startActivity(AutoTrialActivity.f98899g.a(dashboardActivity));
        } else if (Intrinsics.areEqual(dashboardViewCommand, DashboardViewCommand.ShowAutoTrialExpiredPaywall.f99234a)) {
            DashboardActivity dashboardActivity2 = this.f99152c;
            dashboardActivity2.startActivity(Paywall.c(Paywall.f113165a, dashboardActivity2, new PaywallTarget.AutoTrialPromo(true), "app_start", "auto_trial_label", false, false, false, null, 240, null));
        } else {
            if (!(dashboardViewCommand instanceof DashboardViewCommand.HandleDeeplink)) {
                throw new NoWhenBranchMatchedException();
            }
            Boxing.a(this.f99152c.F2().o(this.f99152c, Uri.parse(((DashboardViewCommand.HandleDeeplink) dashboardViewCommand).a()), LifecycleOwnerKt.a(this.f99152c)));
        }
        return Unit.f139807a;
    }
}
