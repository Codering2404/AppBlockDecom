package cz.mobilesoft.coreblock.scene.onboarding;

import android.content.Context;
import android.content.Intent;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.scene.email_consent.EmailCommunicationConsentActivity;
import cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity;
import cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareFlowScenario;
import cz.mobilesoft.coreblock.scene.more.signin.SignInConfig;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewCommandV2;
import cz.mobilesoft.coreblock.scene.premium.utils.IntroPremiumScreenHelperKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2$CommandProcessor$1$1", f = "OnboardingActivityV2.kt", l = {}, m = "invokeSuspend", v = 1)
final class OnboardingActivityV2$CommandProcessor$1$1 extends SuspendLambda implements Function2<OnboardingViewCommandV2, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f110885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f110886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ OnboardingViewModelV2 f110887d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ NavHostController f110888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function1 f110889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f110890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ OnboardingActivityV2 f110891i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f110892j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f110893k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f110894l;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2$CommandProcessor$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2$CommandProcessor$1$1$1", f = "OnboardingActivityV2.kt", l = {225}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f110895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f110896b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OnboardingViewCommandV2 f110897c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, OnboardingViewCommandV2 onboardingViewCommandV2, Continuation continuation) {
            super(2, continuation);
            this.f110896b = scaffoldState;
            this.f110897c = onboardingViewCommandV2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f110896b, this.f110897c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f110895a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f110896b.b();
                String strA = ((OnboardingViewCommandV2.ShowGuestPassIneligibleSnackbar) this.f110897c).a();
                this.f110895a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, strA, null, null, this, 6, null) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2$CommandProcessor$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2$CommandProcessor$1$1$2", f = "OnboardingActivityV2.kt", l = {230}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f110898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f110899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OnboardingActivityV2 f110900c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ManagedActivityResultLauncher f110901d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ NavHostController f110902f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(OnboardingActivityV2 onboardingActivityV2, ManagedActivityResultLauncher managedActivityResultLauncher, NavHostController navHostController, Continuation continuation) {
            super(2, continuation);
            this.f110900c = onboardingActivityV2;
            this.f110901d = managedActivityResultLauncher;
            this.f110902f = navHostController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f110900c, this.f110901d, this.f110902f, continuation);
            anonymousClass2.f110899b = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AnonymousClass2 anonymousClass2;
            CoroutineScope coroutineScope = (CoroutineScope) this.f110899b;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f110898a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Context applicationContext = this.f110900c.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                this.f110899b = coroutineScope;
                this.f110898a = 1;
                anonymousClass2 = this;
                obj = IntroPremiumScreenHelperKt.c(applicationContext, null, true, false, true, anonymousClass2, 1, null);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                anonymousClass2 = this;
            }
            Intent intent = (Intent) obj;
            if (intent != null) {
                anonymousClass2.f110901d.b(intent);
            } else {
                NavController.P(anonymousClass2.f110902f, OnboardingActivityV2.OnboardingNavItem.FirstFocusSplash.getRoute(), null, null, 6, null);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingActivityV2$CommandProcessor$1$1(Context context, OnboardingViewModelV2 onboardingViewModelV2, NavHostController navHostController, Function1 function1, ManagedActivityResultLauncher managedActivityResultLauncher, OnboardingActivityV2 onboardingActivityV2, CoroutineScope coroutineScope, ScaffoldState scaffoldState, ManagedActivityResultLauncher managedActivityResultLauncher2, Continuation continuation) {
        super(2, continuation);
        this.f110886c = context;
        this.f110887d = onboardingViewModelV2;
        this.f110888f = navHostController;
        this.f110889g = function1;
        this.f110890h = managedActivityResultLauncher;
        this.f110891i = onboardingActivityV2;
        this.f110892j = coroutineScope;
        this.f110893k = scaffoldState;
        this.f110894l = managedActivityResultLauncher2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        OnboardingActivityV2$CommandProcessor$1$1 onboardingActivityV2$CommandProcessor$1$1 = new OnboardingActivityV2$CommandProcessor$1$1(this.f110886c, this.f110887d, this.f110888f, this.f110889g, this.f110890h, this.f110891i, this.f110892j, this.f110893k, this.f110894l, continuation);
        onboardingActivityV2$CommandProcessor$1$1.f110885b = obj;
        return onboardingActivityV2$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(OnboardingViewCommandV2 onboardingViewCommandV2, Continuation continuation) {
        return ((OnboardingActivityV2$CommandProcessor$1$1) create(onboardingViewCommandV2, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        OnboardingViewCommandV2 onboardingViewCommandV2 = (OnboardingViewCommandV2) this.f110885b;
        IntrinsicsKt.f();
        if (this.f110884a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (Intrinsics.areEqual(onboardingViewCommandV2, OnboardingViewCommandV2.NavigateToPhonePickUpScreen.f110934a) || Intrinsics.areEqual(onboardingViewCommandV2, OnboardingViewCommandV2.NavigateToStatsPermissionScreen.f110936a)) {
            if (PermissionHelper.k(this.f110886c)) {
                this.f110887d.x1();
                NavController.P(this.f110888f, OnboardingActivityV2.OnboardingNavItem.Statistics.getRoute(), null, null, 6, null);
            } else {
                NavController.P(this.f110888f, OnboardingActivityV2.OnboardingNavItem.StatsPermission.getRoute(), null, null, 6, null);
            }
        } else if (onboardingViewCommandV2 instanceof OnboardingViewCommandV2.NavigateToFinishRegistration) {
            this.f110889g.invoke(new SignInConfig(SignInEntryPoint.ONBOARDING, null, false, false, false, false, true, false, false, true, ((OnboardingViewCommandV2.NavigateToFinishRegistration) onboardingViewCommandV2).a(), 446, null));
        } else if (onboardingViewCommandV2 instanceof OnboardingViewCommandV2.OnOnboardingSkipped) {
            if (((OnboardingViewCommandV2.OnOnboardingSkipped) onboardingViewCommandV2).a()) {
                this.f110890h.b(EmailCommunicationConsentActivity.f101711g.a(this.f110886c, "onboarding"));
            } else {
                this.f110891i.x2(this.f110886c);
            }
        } else if (Intrinsics.areEqual(onboardingViewCommandV2, OnboardingViewCommandV2.LaunchGuestPassActivation.f110932a)) {
            Context context = this.f110886c;
            context.startActivity(GuestPassShareActivity.f107428g.a(context, GuestPassShareFlowScenario.ActivateOnly));
        } else if (onboardingViewCommandV2 instanceof OnboardingViewCommandV2.ShowGuestPassIneligibleSnackbar) {
            BuildersKt__Builders_commonKt.d(this.f110892j, null, null, new AnonymousClass1(this.f110893k, onboardingViewCommandV2, null), 3, null);
        } else {
            if (!Intrinsics.areEqual(onboardingViewCommandV2, OnboardingViewCommandV2.NavigateToSoftPaywallPremium.f110935a)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(this.f110892j, null, null, new AnonymousClass2(this.f110891i, this.f110894l, this.f110888f, null), 3, null);
        }
        return Unit.f139807a;
    }
}
