package cz.mobilesoft.appblock.service;

import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.appblock.activity.InterstitialAdActivity;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewCommand;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel;
import cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenActivityActions;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.OverlayServiceV2$CommandProcessor$1$1", f = "OverlayServiceV2.kt", l = {}, m = "invokeSuspend", v = 1)
final class OverlayServiceV2$CommandProcessor$1$1 extends SuspendLambda implements Function2<LockViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f94651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ OverlayServiceV2 f94652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LockViewModel f94653d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f94654f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f94655g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutableState f94656h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f94657i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f94658j;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.OverlayServiceV2$CommandProcessor$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.OverlayServiceV2$CommandProcessor$1$1$1", f = "OverlayServiceV2.kt", l = {598}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f94660b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LockViewCommand f94661c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, LockViewCommand lockViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f94660b = scaffoldState;
            this.f94661c = lockViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f94660b, this.f94661c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f94659a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f94660b.b();
                String strA = ((LockViewCommand.ShowSnackBar) this.f94661c).a();
                this.f94659a = 1;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OverlayServiceV2$CommandProcessor$1$1(OverlayServiceV2 overlayServiceV2, LockViewModel lockViewModel, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, CoroutineScope coroutineScope, ScaffoldState scaffoldState, Continuation continuation) {
        super(2, continuation);
        this.f94652c = overlayServiceV2;
        this.f94653d = lockViewModel;
        this.f94654f = mutableState;
        this.f94655g = mutableState2;
        this.f94656h = mutableState3;
        this.f94657i = coroutineScope;
        this.f94658j = scaffoldState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        OverlayServiceV2$CommandProcessor$1$1 overlayServiceV2$CommandProcessor$1$1 = new OverlayServiceV2$CommandProcessor$1$1(this.f94652c, this.f94653d, this.f94654f, this.f94655g, this.f94656h, this.f94657i, this.f94658j, continuation);
        overlayServiceV2$CommandProcessor$1$1.f94651b = obj;
        return overlayServiceV2$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(LockViewCommand lockViewCommand, Continuation continuation) {
        return ((OverlayServiceV2$CommandProcessor$1$1) create(lockViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        LockViewCommand lockViewCommand = (LockViewCommand) this.f94651b;
        IntrinsicsKt.f();
        if (this.f94650a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (lockViewCommand instanceof LockViewCommand.CloseCommand) {
            LockViewCommand.CloseCommand closeCommand = (LockViewCommand.CloseCommand) lockViewCommand;
            this.f94652c.J(this.f94653d.Z0(), false, closeCommand.a(), closeCommand.d(), closeCommand.c(), closeCommand.b());
        } else if (Intrinsics.areEqual(lockViewCommand, LockViewCommand.ShowAvailableSettingsDialog.f105447a)) {
            this.f94654f.setValue(Boxing.a(true));
        } else if (Intrinsics.areEqual(lockViewCommand, LockViewCommand.ShowAllowAppBottomSheet.f105446a)) {
            this.f94655g.setValue(Boxing.a(true));
        } else if (Intrinsics.areEqual(lockViewCommand, LockViewCommand.ShowInterstitialAd.f105455a)) {
            LockScreenActivityActions.f105773a.e(this.f94652c, InterstitialAdActivity.class);
        } else if (lockViewCommand instanceof LockViewCommand.ShowInAppUpdateCommand) {
            LockScreenActivityActions.f105773a.d(this.f94652c, ((LockViewCommand.ShowInAppUpdateCommand) lockViewCommand).a());
        } else if (lockViewCommand instanceof LockViewCommand.ShowPremiumDiscountCommand) {
            LockViewCommand.ShowPremiumDiscountCommand showPremiumDiscountCommand = (LockViewCommand.ShowPremiumDiscountCommand) lockViewCommand;
            LockScreenActivityActions.f105773a.g(this.f94652c, showPremiumDiscountCommand.b(), showPremiumDiscountCommand.a());
        } else if (lockViewCommand instanceof LockViewCommand.ShowCampaignActivityCommand) {
            LockViewCommand.ShowCampaignActivityCommand showCampaignActivityCommand = (LockViewCommand.ShowCampaignActivityCommand) lockViewCommand;
            LockScreenActivityActions.f105773a.b(this.f94652c, showCampaignActivityCommand.b(), showCampaignActivityCommand.a(), showCampaignActivityCommand.c());
        } else if (Intrinsics.areEqual(lockViewCommand, LockViewCommand.ShowIntroScheduleCommand.f105456a)) {
            LockScreenActivityActions.f105773a.f(this.f94652c);
        } else if (Intrinsics.areEqual(lockViewCommand, LockViewCommand.ShowCustomBlockingScreen.f105452a)) {
            LockScreenActivityActions.f105773a.c(this.f94652c);
            OverlayServiceV2.K(this.f94652c, this.f94653d.Z0(), true, null, false, false, false, 60, null);
        } else if (Intrinsics.areEqual(lockViewCommand, LockViewCommand.ShowBackdoorCodeDialog.f105448a)) {
            this.f94656h.setValue(Boxing.a(true));
        } else if (lockViewCommand instanceof LockViewCommand.ShowFeedbackFormCommand) {
            RunnabilityHelper.V(this.f94652c, 0, Boxing.d(268468224), false, ((LockViewCommand.ShowFeedbackFormCommand) lockViewCommand).a(), false, "lock_screen", 42, null);
        } else {
            if (!(lockViewCommand instanceof LockViewCommand.ShowSnackBar)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(this.f94657i, null, null, new AnonymousClass1(this.f94658j, lockViewCommand, null), 3, null);
        }
        return Unit.f139807a;
    }
}
