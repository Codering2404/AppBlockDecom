package cz.mobilesoft.coreblock.scene.premium.host;

import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity;
import cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource;
import cz.mobilesoft.coreblock.enums.LoginAfterPurchase;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.scene.more.signin.SignInActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInConfig;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PurchaseSuccessDTO;
import cz.mobilesoft.coreblock.scene.premium.trial_notifications.TrialRemindersActivity;
import cz.mobilesoft.coreblock.util.SessionManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$PremiumScreenInitialize$3$1", f = "PaywallHostActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class PaywallHostActivity$PremiumScreenInitialize$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f113225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PremiumScreenViewState f113226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f113227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f113228d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Context f113229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f113230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f113231h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ PaywallHostActivity f113232i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallHostActivity$PremiumScreenInitialize$3$1(PremiumScreenViewState premiumScreenViewState, MutableState mutableState, MutableState mutableState2, Context context, ManagedActivityResultLauncher managedActivityResultLauncher, ManagedActivityResultLauncher managedActivityResultLauncher2, PaywallHostActivity paywallHostActivity, Continuation continuation) {
        super(2, continuation);
        this.f113226b = premiumScreenViewState;
        this.f113227c = mutableState;
        this.f113228d = mutableState2;
        this.f113229f = context;
        this.f113230g = managedActivityResultLauncher;
        this.f113231h = managedActivityResultLauncher2;
        this.f113232i = paywallHostActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PaywallHostActivity$PremiumScreenInitialize$3$1(this.f113226b, this.f113227c, this.f113228d, this.f113229f, this.f113230g, this.f113231h, this.f113232i, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f113225a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        PurchaseSuccessDTO purchaseSuccessDTOY = this.f113226b.y();
        if (purchaseSuccessDTOY != null) {
            MutableState mutableState = this.f113227c;
            MutableState mutableState2 = this.f113228d;
            PremiumScreenViewState premiumScreenViewState = this.f113226b;
            Context context = this.f113229f;
            ManagedActivityResultLauncher managedActivityResultLauncher = this.f113230g;
            ManagedActivityResultLauncher managedActivityResultLauncher2 = this.f113231h;
            PaywallHostActivity paywallHostActivity = this.f113232i;
            if (purchaseSuccessDTOY.b()) {
                mutableState.setValue(Boxing.a(true));
                mutableState2.setValue(Boxing.a(premiumScreenViewState.J()));
            } else if (premiumScreenViewState.K()) {
                RatingDialogActivity.f95979p.i(context, true, RatingTriggerSource.Purchase, null);
            }
            if (premiumScreenViewState.r() != LoginAfterPurchase.None && !SessionManager.f127910a.r()) {
                managedActivityResultLauncher.b(SignInActivity.f110366h.a(context, new SignInConfig(SignInEntryPoint.PREMIUM, null, false, premiumScreenViewState.r() == LoginAfterPurchase.Optional, false, false, false, true, false, false, null, 1910, null)));
            } else if (purchaseSuccessDTOY.b()) {
                managedActivityResultLauncher2.b(TrialRemindersActivity.Companion.b(TrialRemindersActivity.f113891h, context, premiumScreenViewState.Q(), false, 4, null));
            } else {
                paywallHostActivity.a2(purchaseSuccessDTOY.b(), premiumScreenViewState.R(), purchaseSuccessDTOY.a(), premiumScreenViewState.I(), premiumScreenViewState.Q());
            }
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PaywallHostActivity$PremiumScreenInitialize$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
