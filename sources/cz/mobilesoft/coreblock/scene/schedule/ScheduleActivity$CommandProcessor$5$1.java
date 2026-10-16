package cz.mobilesoft.coreblock.scene.schedule;

import android.content.Context;
import android.content.Intent;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarDuration;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.scene.email_consent.EmailCommunicationConsentActivity;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroActivity;
import cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectActivity;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.view.compose.ActivityLauncher;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity$CommandProcessor$5$1", f = "ScheduleActivity.kt", l = {965}, m = "invokeSuspend", v = 1)
final class ScheduleActivity$CommandProcessor$5$1 extends SuspendLambda implements Function2<ScheduleViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f114391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ NavHostController f114392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f114393d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f114394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Context f114395g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ActivityLauncher f114396h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ MutableState f114397i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f114398j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ ScheduleActivity f114399k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ MutableState f114400l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ MutableState f114401m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ MutableState f114402n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ MutableState f114403o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final /* synthetic */ MutableState f114404p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final /* synthetic */ MutableState f114405q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final /* synthetic */ MutableState f114406r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final /* synthetic */ ModalBottomSheetState f114407s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ Function1 f114408t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ MutableState f114409u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final /* synthetic */ MutableState f114410v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final /* synthetic */ MutableState f114411w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f114412x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f114413y;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity$CommandProcessor$5$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity$CommandProcessor$5$1$1", f = "ScheduleActivity.kt", l = {919}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f114414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f114415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ScheduleViewCommand f114416c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, ScheduleViewCommand scheduleViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f114415b = scaffoldState;
            this.f114416c = scheduleViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f114415b, this.f114416c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f114414a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f114415b.b();
                String strA = ((ScheduleViewCommand.ShowSnackBar) this.f114416c).a();
                SnackbarDuration snackbarDuration = SnackbarDuration.Short;
                this.f114414a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, strA, null, snackbarDuration, this, 2, null) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity$CommandProcessor$5$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity$CommandProcessor$5$1$2", f = "ScheduleActivity.kt", l = {951}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f114417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f114418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ScheduleViewCommand f114419c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ScaffoldState scaffoldState, ScheduleViewCommand scheduleViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f114418b = scaffoldState;
            this.f114419c = scheduleViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f114418b, this.f114419c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f114417a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f114418b.b();
                String strA = ((ScheduleViewCommand.ShowInvalidForSavingDialog) this.f114419c).a();
                SnackbarDuration snackbarDuration = SnackbarDuration.Short;
                this.f114417a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, strA, null, snackbarDuration, this, 2, null) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleActivity$CommandProcessor$5$1(NavHostController navHostController, Function1 function1, MutableState mutableState, Context context, ActivityLauncher activityLauncher, MutableState mutableState2, CoroutineScope coroutineScope, ScheduleActivity scheduleActivity, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, MutableState mutableState8, MutableState mutableState9, ModalBottomSheetState modalBottomSheetState, Function1 function12, MutableState mutableState10, MutableState mutableState11, MutableState mutableState12, ManagedActivityResultLauncher managedActivityResultLauncher, ScaffoldState scaffoldState, Continuation continuation) {
        super(2, continuation);
        this.f114392c = navHostController;
        this.f114393d = function1;
        this.f114394f = mutableState;
        this.f114395g = context;
        this.f114396h = activityLauncher;
        this.f114397i = mutableState2;
        this.f114398j = coroutineScope;
        this.f114399k = scheduleActivity;
        this.f114400l = mutableState3;
        this.f114401m = mutableState4;
        this.f114402n = mutableState5;
        this.f114403o = mutableState6;
        this.f114404p = mutableState7;
        this.f114405q = mutableState8;
        this.f114406r = mutableState9;
        this.f114407s = modalBottomSheetState;
        this.f114408t = function12;
        this.f114409u = mutableState10;
        this.f114410v = mutableState11;
        this.f114411w = mutableState12;
        this.f114412x = managedActivityResultLauncher;
        this.f114413y = scaffoldState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ScheduleActivity$CommandProcessor$5$1 scheduleActivity$CommandProcessor$5$1 = new ScheduleActivity$CommandProcessor$5$1(this.f114392c, this.f114393d, this.f114394f, this.f114395g, this.f114396h, this.f114397i, this.f114398j, this.f114399k, this.f114400l, this.f114401m, this.f114402n, this.f114403o, this.f114404p, this.f114405q, this.f114406r, this.f114407s, this.f114408t, this.f114409u, this.f114410v, this.f114411w, this.f114412x, this.f114413y, continuation);
        scheduleActivity$CommandProcessor$5$1.f114391b = obj;
        return scheduleActivity$CommandProcessor$5$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ScheduleViewCommand scheduleViewCommand, Continuation continuation) {
        return ((ScheduleActivity$CommandProcessor$5$1) create(scheduleViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ScheduleViewCommand scheduleViewCommand = (ScheduleViewCommand) this.f114391b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f114390a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (scheduleViewCommand instanceof ScheduleViewCommand.NavigateBack) {
                Boxing.a(this.f114392c.R());
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.CloseScreen) {
                this.f114393d.invoke(((ScheduleViewCommand.CloseScreen) scheduleViewCommand).a());
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.ShowApplicationSelection) {
                this.f114394f.setValue(Boxing.a(false));
                NavController.P(this.f114392c, ScheduleActivity.NavItem.ApplicationSelect.getRoute(), null, null, 6, null);
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.ShowPermissionActivity) {
                ScheduleViewCommand.ShowPermissionActivity showPermissionActivity = (ScheduleViewCommand.ShowPermissionActivity) scheduleViewCommand;
                Intent intentB = PermissionActivity.Companion.b(PermissionActivity.f111772j, this.f114395g, showPermissionActivity.b(), false, false, false, null, null, 116, null);
                this.f114396h.a().setValue(showPermissionActivity.a());
                this.f114396h.b().b(intentB);
            } else if (Intrinsics.areEqual(scheduleViewCommand, ScheduleViewCommand.ShowUnsavedChangesDialog.f114537a)) {
                this.f114397i.setValue(Boxing.a(true));
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.ShowSnackBar) {
                BuildersKt__Builders_commonKt.d(this.f114398j, null, null, new AnonymousClass1(this.f114413y, scheduleViewCommand, null), 3, null);
            } else if (Intrinsics.areEqual(scheduleViewCommand, ScheduleViewCommand.ShowConditionSelection.f114517a)) {
                NavController.P(this.f114392c, ScheduleActivity.NavItem.Conditions.getRoute(), null, null, 6, null);
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.ShowConflictingSchedules) {
                NavController.P(this.f114392c, ScheduleActivity.NavItem.ConflictingSchedules.getRoute() + "?withContinueButton=" + ((ScheduleViewCommand.ShowConflictingSchedules) scheduleViewCommand).a(), null, null, 6, null);
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.ShowConditionDetail) {
                ScheduleViewCommand.ShowConditionDetail showConditionDetail = (ScheduleViewCommand.ShowConditionDetail) scheduleViewCommand;
                this.f114399k.S3(this.f114392c, showConditionDetail.b(), showConditionDetail.a());
            } else if (Intrinsics.areEqual(scheduleViewCommand, ScheduleViewCommand.ShowScheduleDetail.f114530a)) {
                NavController.P(this.f114392c, ScheduleActivity.NavItem.Detail.getRoute(), null, null, 6, null);
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.ShowInfoDialog) {
                ScheduleViewCommand.ShowInfoDialog showInfoDialog = (ScheduleViewCommand.ShowInfoDialog) scheduleViewCommand;
                this.f114400l.setValue(TuplesKt.a(showInfoDialog.b(), showInfoDialog.a()));
                this.f114401m.setValue(Boxing.a(true));
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.ShowChargerLockConfirmDialog) {
                this.f114402n.setValue(Boxing.a(((ScheduleViewCommand.ShowChargerLockConfirmDialog) scheduleViewCommand).a()));
                this.f114403o.setValue(Boxing.a(true));
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.ShowInvalidForSavingDialog) {
                BuildersKt__Builders_commonKt.d(this.f114398j, null, null, new AnonymousClass2(this.f114413y, scheduleViewCommand, null), 3, null);
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.ShowTimeLockSelector) {
                this.f114404p.setValue(Boxing.a(true));
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.ShowUnsavedChangesBeforeLockingDialog) {
                ScheduleViewCommand.ShowUnsavedChangesBeforeLockingDialog showUnsavedChangesBeforeLockingDialog = (ScheduleViewCommand.ShowUnsavedChangesBeforeLockingDialog) scheduleViewCommand;
                this.f114405q.setValue(Boxing.d(showUnsavedChangesBeforeLockingDialog.a()));
                this.f114406r.setValue(showUnsavedChangesBeforeLockingDialog.b());
            } else if (Intrinsics.areEqual(scheduleViewCommand, ScheduleViewCommand.ShowDetailSettingsBottomSheet.f114519a)) {
                ModalBottomSheetState modalBottomSheetState = this.f114407s;
                this.f114391b = SpillingKt.a(scheduleViewCommand);
                this.f114390a = 1;
                if (modalBottomSheetState.l(this) == objF) {
                    return objF;
                }
            } else if (Intrinsics.areEqual(scheduleViewCommand, ScheduleViewCommand.ShowBlockingModeSettings.f114513a)) {
                NavController.P(this.f114392c, ScheduleActivity.NavItem.BlockingModeSettings.getRoute(), null, null, 6, null);
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.ShowPremiumFeatureScreen) {
                this.f114399k.startActivity(Paywall.c(Paywall.f113165a, this.f114395g, new PaywallTarget.LimitScreen(((ScheduleViewCommand.ShowPremiumFeatureScreen) scheduleViewCommand).a()), this.f114399k.P3() instanceof ScheduleDescriptor.ScheduleId ? "schedule_edit" : "schedule_create", "allow_list", false, false, false, null, 240, null));
            } else if (Intrinsics.areEqual(scheduleViewCommand, ScheduleViewCommand.ShowPremiumOneTimeToSubScreen.f114529a)) {
                ScheduleActivity scheduleActivity = this.f114399k;
                Paywall paywall = Paywall.f113165a;
                Context context = this.f114395g;
                String string = this.f114395g.getString(R.string.r2);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                scheduleActivity.startActivity(Paywall.c(paywall, context, new PaywallTarget.OneTimeToSub(string), this.f114399k.P3() instanceof ScheduleDescriptor.ScheduleId ? "schedule_edit" : "schedule_create", "allow_list", false, false, false, null, 240, null));
            } else if (Intrinsics.areEqual(scheduleViewCommand, ScheduleViewCommand.ShowEmojiEditScreen.f114521a)) {
                NavController.P(this.f114392c, ScheduleActivity.NavItem.EmojiPicker.getRoute(), null, null, 6, null);
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.PremiumFeatureForUsageLimitRequired) {
                ScheduleActivity scheduleActivity2 = this.f114399k;
                scheduleActivity2.startActivity(Paywall.c(Paywall.f113165a, scheduleActivity2, new PaywallTarget.LimitScreen(PremiumFeature.USAGE_LIMIT_UNLIMITED), this.f114399k.P3() instanceof ScheduleDescriptor.ScheduleId ? "schedule_edit" : "schedule_create", ((ScheduleViewCommand.PremiumFeatureForUsageLimitRequired) scheduleViewCommand).a() == UsageLimit.PeriodType.DAILY ? "daily_usage_limit" : "hourly_usage_limit", false, false, false, null, 240, null));
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.PremiumFeatureForLaunchCountRequired) {
                ScheduleActivity scheduleActivity3 = this.f114399k;
                scheduleActivity3.startActivity(Paywall.c(Paywall.f113165a, scheduleActivity3, new PaywallTarget.LimitScreen(PremiumFeature.LAUNCH_COUNT_UNLIMITED), this.f114399k.P3() instanceof ScheduleDescriptor.ScheduleId ? "schedule_edit" : "schedule_create", ((ScheduleViewCommand.PremiumFeatureForLaunchCountRequired) scheduleViewCommand).a() == UsageLimit.PeriodType.DAILY ? "daily_launch_count" : "hourly_launch_count", false, false, false, null, 240, null));
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.OnProfileUsageLimitSave) {
                ScheduleViewCommand.OnProfileUsageLimitSave onProfileUsageLimitSave = (ScheduleViewCommand.OnProfileUsageLimitSave) scheduleViewCommand;
                this.f114408t.invoke(new ScheduleViewEvent.OnConditionSet(new ConditionDTO.UsageLimitDTO(onProfileUsageLimitSave.b(), null, 0L, onProfileUsageLimitSave.a(), null, 22, null), false, 2, null));
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.ShowTimeSelectScreen) {
                this.f114395g.startActivity(QuickBlockTimeSelectActivity.f114243g.a(this.f114395g, ((ScheduleViewCommand.ShowTimeSelectScreen) scheduleViewCommand).a(), true));
                this.f114399k.finish();
            } else if (Intrinsics.areEqual(scheduleViewCommand, ScheduleViewCommand.ShowPomodoroScreen.f114527a)) {
                this.f114395g.startActivity(PomodoroActivity.Companion.b(PomodoroActivity.f114048f, this.f114395g, false, 2, null));
                this.f114399k.finish();
            } else if (Intrinsics.areEqual(scheduleViewCommand, ScheduleViewCommand.ShowAddToFollowSchedulesDialog.f114511a)) {
                this.f114409u.setValue(Boxing.a(true));
            } else if (Intrinsics.areEqual(scheduleViewCommand, ScheduleViewCommand.ShowScheduleSummaryScreen.f114531a)) {
                NavController.P(this.f114392c, ScheduleActivity.NavItem.Summary.getRoute(), null, null, 6, null);
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.ShowDisabledDialog) {
                this.f114410v.setValue(((ScheduleViewCommand.ShowDisabledDialog) scheduleViewCommand).a());
                this.f114411w.setValue(Boxing.a(true));
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.OpenEmailConsentActivity) {
                Context context2 = this.f114395g;
                context2.startActivity(EmailCommunicationConsentActivity.f101711g.a(context2, ((ScheduleViewCommand.OpenEmailConsentActivity) scheduleViewCommand).a()));
            } else if (scheduleViewCommand instanceof ScheduleViewCommand.HandleOnboardingFinished) {
                if (((ScheduleViewCommand.HandleOnboardingFinished) scheduleViewCommand).a()) {
                    this.f114412x.b(EmailCommunicationConsentActivity.f101711g.a(this.f114395g, KLAQHFCRAUejH.OZghDeZLhgSZi));
                } else {
                    NavController.P(this.f114392c, ScheduleActivity.NavItem.OnboardingExitScreen.getRoute(), null, null, 6, null);
                }
            } else {
                if (!Intrinsics.areEqual(scheduleViewCommand, ScheduleViewCommand.FinishActivity.f114503a)) {
                    throw new NoWhenBranchMatchedException();
                }
                this.f114399k.finish();
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }
}
