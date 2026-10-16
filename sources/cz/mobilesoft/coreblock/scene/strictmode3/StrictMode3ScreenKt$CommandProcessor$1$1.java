package cz.mobilesoft.coreblock.scene.strictmode3;

import android.content.Context;
import android.content.Intent;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.scene.email_consent.EmailCommunicationConsentActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInConfig;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.strictmode.passcode.StrictModePassCodeActivity;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewCommand;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel;
import cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessActivity;
import cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectActivity;
import cz.mobilesoft.coreblock.scene.strictmode3.learnmore.LearnMoreActivity;
import cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsActivity;
import cz.mobilesoft.coreblock.scene.timer.TimeSelectActivity;
import cz.mobilesoft.coreblock.view.compose.ActivityLauncher;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ScreenKt$CommandProcessor$1$1", f = "StrictMode3Screen.kt", l = {}, m = "invokeSuspend", v = 1)
final class StrictMode3ScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<StrictMode3ViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f121124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f121125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f121126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f121127d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ActivityLauncher f121128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f121129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f121130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f121131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f121132j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ MutableState f121133k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ MutableState f121134l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ MutableState f121135m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f121136n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ MutableState f121137o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final /* synthetic */ MutableState f121138p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f121139q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f121140r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f121141s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f121142t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ MutableState f121143u;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ScreenKt$CommandProcessor$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ScreenKt$CommandProcessor$1$1$2", f = "StrictMode3Screen.kt", l = {372}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f121144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f121145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f121146c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ StrictMode3ViewCommand f121147d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ScaffoldState scaffoldState, Context context, StrictMode3ViewCommand strictMode3ViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f121145b = scaffoldState;
            this.f121146c = context;
            this.f121147d = strictMode3ViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f121145b, this.f121146c, this.f121147d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f121144a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f121145b.b();
                String string = this.f121146c.getResources().getString(R.string.PB, Boxing.d(((StrictMode3ViewCommand.ShowMaximumTimerValueReached) this.f121147d).a()));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                this.f121144a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, string, null, null, this, 6, null) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ScreenKt$CommandProcessor$1$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ScreenKt$CommandProcessor$1$1$3", f = "StrictMode3Screen.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f121148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MutableState f121149b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(MutableState mutableState, Continuation continuation) {
            super(2, continuation);
            this.f121149b = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass3(this.f121149b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f121148a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f121149b.setValue(Boxing.a(true));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ScreenKt$CommandProcessor$1$1(Context context, ManagedActivityResultLauncher managedActivityResultLauncher, ActivityLauncher activityLauncher, MutableState mutableState, ManagedActivityResultLauncher managedActivityResultLauncher2, ManagedActivityResultLauncher managedActivityResultLauncher3, ManagedActivityResultLauncher managedActivityResultLauncher4, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, CoroutineScope coroutineScope, MutableState mutableState5, MutableState mutableState6, ManagedActivityResultLauncher managedActivityResultLauncher5, ManagedActivityResultLauncher managedActivityResultLauncher6, ManagedActivityResultLauncher managedActivityResultLauncher7, ScaffoldState scaffoldState, MutableState mutableState7, Continuation continuation) {
        super(2, continuation);
        this.f121126c = context;
        this.f121127d = managedActivityResultLauncher;
        this.f121128f = activityLauncher;
        this.f121129g = mutableState;
        this.f121130h = managedActivityResultLauncher2;
        this.f121131i = managedActivityResultLauncher3;
        this.f121132j = managedActivityResultLauncher4;
        this.f121133k = mutableState2;
        this.f121134l = mutableState3;
        this.f121135m = mutableState4;
        this.f121136n = coroutineScope;
        this.f121137o = mutableState5;
        this.f121138p = mutableState6;
        this.f121139q = managedActivityResultLauncher5;
        this.f121140r = managedActivityResultLauncher6;
        this.f121141s = managedActivityResultLauncher7;
        this.f121142t = scaffoldState;
        this.f121143u = mutableState7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StrictMode3ScreenKt$CommandProcessor$1$1 strictMode3ScreenKt$CommandProcessor$1$1 = new StrictMode3ScreenKt$CommandProcessor$1$1(this.f121126c, this.f121127d, this.f121128f, this.f121129g, this.f121130h, this.f121131i, this.f121132j, this.f121133k, this.f121134l, this.f121135m, this.f121136n, this.f121137o, this.f121138p, this.f121139q, this.f121140r, this.f121141s, this.f121142t, this.f121143u, continuation);
        strictMode3ScreenKt$CommandProcessor$1$1.f121125b = obj;
        return strictMode3ScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(StrictMode3ViewCommand strictMode3ViewCommand, Continuation continuation) {
        return ((StrictMode3ScreenKt$CommandProcessor$1$1) create(strictMode3ViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        StrictMode3ViewCommand strictMode3ViewCommand = (StrictMode3ViewCommand) this.f121125b;
        IntrinsicsKt.f();
        if (this.f121124a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (Intrinsics.areEqual(strictMode3ViewCommand, StrictMode3ViewCommand.ShowAccessMethodsScreen.f121166a)) {
            this.f121127d.b(StrictModeAccessActivity.f121510f.a(this.f121126c));
        } else if (strictMode3ViewCommand instanceof StrictMode3ViewCommand.ShowOptionsScreen) {
            this.f121126c.startActivity(StrictModeOptionsActivity.f122286g.a(this.f121126c, ((StrictMode3ViewCommand.ShowOptionsScreen) strictMode3ViewCommand).a()));
        } else if (strictMode3ViewCommand instanceof StrictMode3ViewCommand.ShowPermissionActivity) {
            StrictMode3ViewCommand.ShowPermissionActivity showPermissionActivity = (StrictMode3ViewCommand.ShowPermissionActivity) strictMode3ViewCommand;
            this.f121128f.a().setValue(showPermissionActivity.b());
            this.f121128f.b().b(PermissionActivity.Companion.b(PermissionActivity.f111772j, this.f121126c, showPermissionActivity.a(), false, false, false, null, null, 116, null));
        } else if (strictMode3ViewCommand instanceof StrictMode3ViewCommand.ShowPinCodeScreen) {
            StrictMode3ViewCommand.ShowPinCodeScreen showPinCodeScreen = (StrictMode3ViewCommand.ShowPinCodeScreen) strictMode3ViewCommand;
            this.f121129g.setValue(new StrictMode3ViewModel.PinCodeParams(showPinCodeScreen.a(), showPinCodeScreen.b()));
            this.f121130h.b(StrictModePassCodeActivity.f121048f.a(this.f121126c, showPinCodeScreen.a().getPassCodeType()));
        } else {
            if (strictMode3ViewCommand instanceof StrictMode3ViewCommand.OpenAccessMethod) {
                StrictMode3ViewCommand.OpenAccessMethod openAccessMethod = (StrictMode3ViewCommand.OpenAccessMethod) strictMode3ViewCommand;
                AccessMethodConfiguration accessMethodConfigurationC = openAccessMethod.c();
                if (accessMethodConfigurationC instanceof AccessMethodConfiguration.Timer) {
                    ManagedActivityResultLauncher managedActivityResultLauncher = this.f121131i;
                    TimeSelectActivity.Companion companion = TimeSelectActivity.f122957f;
                    Context context = this.f121126c;
                    Long lE = Boxing.e(((AccessMethodConfiguration.Timer) openAccessMethod.c()).b());
                    lE.longValue();
                    Long l3 = openAccessMethod.a() != StrictModeState.Active ? lE : null;
                    managedActivityResultLauncher.b(companion.a(context, l3 != null ? l3.longValue() : 0L, Boxing.e(openAccessMethod.d()), new TimePickerConfig(new TimePickerConfig.TimePickerType.Minutes(0L, 0L, 3, null), new TimePickerConfig.TimePickerType.Hours(0L, 0L, 3, null), new TimePickerConfig.TimePickerType.Days(0L, 99L), false, null, false, 56, null), true));
                } else if (accessMethodConfigurationC instanceof AccessMethodConfiguration.Schedules) {
                    this.f121132j.b(ScheduleSelectActivity.f122020f.a(this.f121126c, openAccessMethod.b(), ((AccessMethodConfiguration.Schedules) accessMethodConfigurationC).c(), openAccessMethod.a() == StrictModeState.Inactive));
                } else if (accessMethodConfigurationC instanceof AccessMethodConfiguration.Cooldown) {
                    this.f121133k.setValue(Boxing.a(true));
                }
            } else if (strictMode3ViewCommand instanceof StrictMode3ViewCommand.ShowLimitScreen) {
                StrictMode3ViewCommand.ShowLimitScreen showLimitScreen = (StrictMode3ViewCommand.ShowLimitScreen) strictMode3ViewCommand;
                this.f121126c.startActivity(Paywall.c(Paywall.f113165a, this.f121126c, new PaywallTarget.LimitScreen(showLimitScreen.c()), showLimitScreen.a(), showLimitScreen.b(), false, false, false, null, 240, null));
            } else if (strictMode3ViewCommand instanceof StrictMode3ViewCommand.ShowInfoDialog) {
                StrictMode3ViewCommand.ShowInfoDialog showInfoDialog = (StrictMode3ViewCommand.ShowInfoDialog) strictMode3ViewCommand;
                this.f121134l.setValue(TuplesKt.a(showInfoDialog.b(), showInfoDialog.a()));
                this.f121135m.setValue(Boxing.a(true));
            } else if (strictMode3ViewCommand instanceof StrictMode3ViewCommand.ShowMaximumTimerValueReached) {
                BuildersKt__Builders_commonKt.d(this.f121136n, null, null, new AnonymousClass2(this.f121142t, this.f121126c, strictMode3ViewCommand, null), 3, null);
            } else if (Intrinsics.areEqual(strictMode3ViewCommand, StrictMode3ViewCommand.ShowLearnMoreScreen.f121174a)) {
                this.f121126c.startActivity(new Intent(this.f121126c, (Class<?>) LearnMoreActivity.class));
            } else if (Intrinsics.areEqual(strictMode3ViewCommand, StrictMode3ViewCommand.ShowApprovalEmailBottomSheet.f121167a)) {
                this.f121137o.setValue(Boxing.a(true));
            } else if (Intrinsics.areEqual(strictMode3ViewCommand, StrictMode3ViewCommand.ShowApprovalRequestUnblockBottomSheet.f121168a)) {
                BuildersKt__Builders_commonKt.d(this.f121136n, null, null, new AnonymousClass3(this.f121143u, null), 3, null);
            } else if (strictMode3ViewCommand instanceof StrictMode3ViewCommand.ShowSignInBeforeActivate) {
                StrictMode3ViewCommand.ShowSignInBeforeActivate showSignInBeforeActivate = (StrictMode3ViewCommand.ShowSignInBeforeActivate) strictMode3ViewCommand;
                this.f121138p.setValue(Boxing.a(showSignInBeforeActivate.a()));
                if (showSignInBeforeActivate.b()) {
                    this.f121139q.b(SignInActivity.f110366h.a(this.f121126c, new SignInConfig(SignInEntryPoint.SM_APPROVAL, null, false, false, false, false, true, false, false, false, null, 1982, null)));
                }
                if (showSignInBeforeActivate.a() && !showSignInBeforeActivate.b()) {
                    this.f121140r.b(Paywall.c(Paywall.f113165a, this.f121126c, new PaywallTarget.LimitScreen(PremiumFeature.STRICT_MODE_APPROVAL), "strict_mode_setup", "by_approval_button", false, false, false, null, 240, null));
                }
            } else if (Intrinsics.areEqual(strictMode3ViewCommand, StrictMode3ViewCommand.ShowEmailConsentScreen.f121171a)) {
                Context context2 = this.f121126c;
                context2.startActivity(EmailCommunicationConsentActivity.f101711g.a(context2, "strict_mode"));
            } else {
                if (!(strictMode3ViewCommand instanceof StrictMode3ViewCommand.ShowCommitmentDeactivationScreen)) {
                    throw new NoWhenBranchMatchedException();
                }
                StrictMode3ViewCommand.ShowCommitmentDeactivationScreen showCommitmentDeactivationScreen = (StrictMode3ViewCommand.ShowCommitmentDeactivationScreen) strictMode3ViewCommand;
                this.f121141s.b(StrictMode3DeactivationCommitmentActivity.f121099g.a(this.f121126c, showCommitmentDeactivationScreen.b(), showCommitmentDeactivationScreen.a()));
            }
        }
        return Unit.f139807a;
    }
}
