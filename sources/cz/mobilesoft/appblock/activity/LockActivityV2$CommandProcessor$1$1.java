package cz.mobilesoft.appblock.activity;

import android.content.Context;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.appblock.util.ServiceHelper;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity;
import cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewCommand;
import cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenActivityActions;
import cz.mobilesoft.coreblock.util.CrashHelper;
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
import kotlin.jvm.functions.Function0;
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
@DebugMetadata(c = "cz.mobilesoft.appblock.activity.LockActivityV2$CommandProcessor$1$1", f = "LockActivityV2.kt", l = {}, m = "invokeSuspend", v = 1)
final class LockActivityV2$CommandProcessor$1$1 extends SuspendLambda implements Function2<LockViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f93946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f93947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LockActivityV2 f93948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f93949d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Context f93950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function0 f93951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutableState f93952h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f93953i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f93954j;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.activity.LockActivityV2$CommandProcessor$1$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.activity.LockActivityV2$CommandProcessor$1$1$3", f = "LockActivityV2.kt", l = {238}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f93955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f93956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LockViewCommand f93957c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ScaffoldState scaffoldState, LockViewCommand lockViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f93956b = scaffoldState;
            this.f93957c = lockViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass3(this.f93956b, this.f93957c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f93955a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f93956b.b();
                String strA = ((LockViewCommand.ShowSnackBar) this.f93957c).a();
                this.f93955a = 1;
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
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockActivityV2$CommandProcessor$1$1(LockActivityV2 lockActivityV2, MutableState mutableState, Context context, Function0 function0, MutableState mutableState2, CoroutineScope coroutineScope, ScaffoldState scaffoldState, Continuation continuation) {
        super(2, continuation);
        this.f93948c = lockActivityV2;
        this.f93949d = mutableState;
        this.f93950f = context;
        this.f93951g = function0;
        this.f93952h = mutableState2;
        this.f93953i = coroutineScope;
        this.f93954j = scaffoldState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LockActivityV2$CommandProcessor$1$1 lockActivityV2$CommandProcessor$1$1 = new LockActivityV2$CommandProcessor$1$1(this.f93948c, this.f93949d, this.f93950f, this.f93951g, this.f93952h, this.f93953i, this.f93954j, continuation);
        lockActivityV2$CommandProcessor$1$1.f93947b = obj;
        return lockActivityV2$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(LockViewCommand lockViewCommand, Continuation continuation) {
        return ((LockActivityV2$CommandProcessor$1$1) create(lockViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        LockViewCommand lockViewCommand = (LockViewCommand) this.f93947b;
        IntrinsicsKt.f();
        if (this.f93946a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (lockViewCommand instanceof LockViewCommand.CloseCommand) {
            LockViewCommand.CloseCommand closeCommand = (LockViewCommand.CloseCommand) lockViewCommand;
            ContactReason contactReasonA = closeCommand.a();
            if (contactReasonA != null) {
                Context contextG = LockieApplication.g();
                Intrinsics.checkNotNullExpressionValue(contextG, "getContext(...)");
                RunnabilityHelper.V(contextG, 0, Boxing.d(268468224), false, contactReasonA, false, "lock_screen", 42, null);
            } else {
                LockActivityV2 lockActivityV2 = this.f93948c;
                Function0 function0 = this.f93951g;
                if (closeCommand.d()) {
                    try {
                        ServiceHelper.f95139a.b(lockActivityV2);
                        RatingDialogActivity.f95979p.i(lockActivityV2, false, RatingTriggerSource.LockScreen, null);
                    } catch (Exception e3) {
                        CrashHelper.j(e3);
                    }
                }
                function0.invoke();
            }
        } else if (Intrinsics.areEqual(lockViewCommand, LockViewCommand.ShowAvailableSettingsDialog.f105447a)) {
            this.f93949d.setValue(Boxing.a(true));
        } else if (!Intrinsics.areEqual(lockViewCommand, LockViewCommand.ShowAllowAppBottomSheet.f105446a)) {
            if (Intrinsics.areEqual(lockViewCommand, LockViewCommand.ShowInterstitialAd.f105455a)) {
                LockScreenActivityActions.f105773a.e(this.f93950f, InterstitialAdActivity.class);
            } else if (lockViewCommand instanceof LockViewCommand.ShowInAppUpdateCommand) {
                LockScreenActivityActions.f105773a.d(this.f93950f, ((LockViewCommand.ShowInAppUpdateCommand) lockViewCommand).a());
            } else if (lockViewCommand instanceof LockViewCommand.ShowPremiumDiscountCommand) {
                LockViewCommand.ShowPremiumDiscountCommand showPremiumDiscountCommand = (LockViewCommand.ShowPremiumDiscountCommand) lockViewCommand;
                LockScreenActivityActions.f105773a.g(this.f93950f, showPremiumDiscountCommand.b(), showPremiumDiscountCommand.a());
            } else if (lockViewCommand instanceof LockViewCommand.ShowCampaignActivityCommand) {
                LockViewCommand.ShowCampaignActivityCommand showCampaignActivityCommand = (LockViewCommand.ShowCampaignActivityCommand) lockViewCommand;
                LockScreenActivityActions.f105773a.b(this.f93950f, showCampaignActivityCommand.b(), showCampaignActivityCommand.a(), showCampaignActivityCommand.c());
            } else if (Intrinsics.areEqual(lockViewCommand, LockViewCommand.ShowIntroScheduleCommand.f105456a)) {
                LockScreenActivityActions.f105773a.f(this.f93950f);
            } else if (Intrinsics.areEqual(lockViewCommand, LockViewCommand.ShowCustomBlockingScreen.f105452a)) {
                LockScreenActivityActions.f105773a.c(this.f93950f);
                this.f93951g.invoke();
            } else if (Intrinsics.areEqual(lockViewCommand, LockViewCommand.ShowBackdoorCodeDialog.f105448a)) {
                this.f93952h.setValue(Boxing.a(true));
            } else if (lockViewCommand instanceof LockViewCommand.ShowFeedbackFormCommand) {
                RunnabilityHelper.V(this.f93948c, 0, Boxing.d(268468224), false, ((LockViewCommand.ShowFeedbackFormCommand) lockViewCommand).a(), false, "lock_screen", 42, null);
            } else {
                if (!(lockViewCommand instanceof LockViewCommand.ShowSnackBar)) {
                    throw new NoWhenBranchMatchedException();
                }
                BuildersKt__Builders_commonKt.d(this.f93953i, null, null, new AnonymousClass3(this.f93954j, lockViewCommand, null), 3, null);
            }
        }
        return Unit.f139807a;
    }
}
