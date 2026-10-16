package cz.mobilesoft.coreblock.scene.intro;

import android.content.Context;
import android.content.Intent;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.intro.OnboardingViewCommand;
import cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity;
import cz.mobilesoft.coreblock.scene.premium.utils.IntroPremiumScreenHelperKt;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.OnboardingActivity$CommandProcessor$1$1", f = "OnboardingActivity.kt", l = {119}, m = "invokeSuspend", v = 1)
final class OnboardingActivity$CommandProcessor$1$1 extends SuspendLambda implements Function2<OnboardingViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f104488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f104489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ NavHostController f104490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ OnboardingActivity f104491d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingActivity$CommandProcessor$1$1(NavHostController navHostController, OnboardingActivity onboardingActivity, Continuation continuation) {
        super(2, continuation);
        this.f104490c = navHostController;
        this.f104491d = onboardingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        OnboardingActivity$CommandProcessor$1$1 onboardingActivity$CommandProcessor$1$1 = new OnboardingActivity$CommandProcessor$1$1(this.f104490c, this.f104491d, continuation);
        onboardingActivity$CommandProcessor$1$1.f104489b = obj;
        return onboardingActivity$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(OnboardingViewCommand onboardingViewCommand, Continuation continuation) {
        return ((OnboardingActivity$CommandProcessor$1$1) create(onboardingViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        OnboardingActivity$CommandProcessor$1$1 onboardingActivity$CommandProcessor$1$1;
        OnboardingViewCommand onboardingViewCommand = (OnboardingViewCommand) this.f104489b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f104488a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (onboardingViewCommand instanceof OnboardingViewCommand.NavigateToExplanation1) {
                NavController.P(this.f104490c, ((OnboardingViewCommand.NavigateToExplanation1) onboardingViewCommand).a().c().getRoute(), null, null, 6, null);
            } else if (Intrinsics.areEqual(onboardingViewCommand, OnboardingViewCommand.NavigateToPrivacyExplanation.f104506a)) {
                NavController.P(this.f104490c, OnboardingNavItem.PrivacyExplanation.getRoute(), null, null, 6, null);
            } else if (Intrinsics.areEqual(onboardingViewCommand, OnboardingViewCommand.NavigateToReport.f104507a)) {
                NavController.P(this.f104490c, OnboardingNavItem.StatsReport.getRoute(), null, null, 6, null);
            } else if (Intrinsics.areEqual(onboardingViewCommand, OnboardingViewCommand.NavigateToStatsQuestion2.f104509a)) {
                NavController.P(this.f104490c, OnboardingNavItem.StatsQuestion2.getRoute(), null, null, 6, null);
            } else if (Intrinsics.areEqual(onboardingViewCommand, OnboardingViewCommand.NavigateToStatsExplanation1.f104508a)) {
                NavController.P(this.f104490c, OnboardingNavItem.StatsExplanation1.getRoute(), null, null, 6, null);
            } else if (Intrinsics.areEqual(onboardingViewCommand, OnboardingViewCommand.NavigateToFeaturesOverview.f104505a)) {
                NavController.P(this.f104490c, OnboardingNavItem.FeaturesOverview.getRoute(), null, null, 6, null);
            } else if (onboardingViewCommand instanceof OnboardingViewCommand.OpenQuickBlockSetup) {
                Intent intentB = ScheduleActivity.Companion.b(ScheduleActivity.f114377m, this.f104491d, new ScheduleDescriptor.QuickBlockOnboarding(((OnboardingViewCommand.OpenQuickBlockSetup) onboardingViewCommand).a()), false, false, 12, null);
                intentB.setFlags(268468224);
                this.f104491d.startActivity(intentB);
            } else if (Intrinsics.areEqual(onboardingViewCommand, OnboardingViewCommand.OpenScheduleSetup.f104513a)) {
                OnboardingActivity onboardingActivity = this.f104491d;
                onboardingActivity.startActivity(IntroScheduleActivity.f104813g.a(onboardingActivity, true));
            } else if (Intrinsics.areEqual(onboardingViewCommand, OnboardingViewCommand.OpenDashboard.f104510a)) {
                DashboardActivity.Companion companion = DashboardActivity.f99133o;
                Context applicationContext = this.f104491d.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                Intent intentC = DashboardActivity.Companion.c(companion, applicationContext, null, null, 6, null);
                intentC.setFlags(268468224);
                this.f104491d.startActivity(intentC);
            } else {
                if (!Intrinsics.areEqual(onboardingViewCommand, OnboardingViewCommand.OpenNewIntroPremiumScreen.f104511a)) {
                    throw new NoWhenBranchMatchedException();
                }
                Context applicationContext2 = this.f104491d.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                this.f104489b = SpillingKt.a(onboardingViewCommand);
                this.f104488a = 1;
                onboardingActivity$CommandProcessor$1$1 = this;
                obj = IntroPremiumScreenHelperKt.c(applicationContext2, null, true, false, false, onboardingActivity$CommandProcessor$1$1, 13, null);
                if (obj == objF) {
                    return objF;
                }
            }
            return Unit.f139807a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        onboardingActivity$CommandProcessor$1$1 = this;
        Intent intent = (Intent) obj;
        if (intent != null) {
            intent.setFlags(268468224);
        }
        onboardingActivity$CommandProcessor$1$1.f104491d.startActivity(intent);
        return Unit.f139807a;
    }
}
