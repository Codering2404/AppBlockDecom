package cz.mobilesoft.coreblock.scene.more.guestpassshare;

import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.navigation.NavHostController;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PurchaseSuccessDTO;
import cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity$RootCompose$2$1", f = "GuestPassShareActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class GuestPassShareActivity$RootCompose$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f107449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PremiumScreenViewState f107450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f107451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f107452d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ GuestPassShareActivity f107453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ NavHostController f107454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ List f107455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Function1 f107456i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GuestPassShareActivity$RootCompose$2$1(PremiumScreenViewState premiumScreenViewState, Context context, ManagedActivityResultLauncher managedActivityResultLauncher, GuestPassShareActivity guestPassShareActivity, NavHostController navHostController, List list, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f107450b = premiumScreenViewState;
        this.f107451c = context;
        this.f107452d = managedActivityResultLauncher;
        this.f107453f = guestPassShareActivity;
        this.f107454g = navHostController;
        this.f107455h = list;
        this.f107456i = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new GuestPassShareActivity$RootCompose$2$1(this.f107450b, this.f107451c, this.f107452d, this.f107453f, this.f107454g, this.f107455h, this.f107456i, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f107449a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        PurchaseSuccessDTO purchaseSuccessDTOY = this.f107450b.y();
        if (purchaseSuccessDTOY == null) {
            return Unit.f139807a;
        }
        if (!this.f107450b.R() || purchaseSuccessDTOY.a()) {
            this.f107453f.Z0(this.f107454g, this.f107455h, this.f107456i);
        } else {
            this.f107452d.b(SubscriptionOnboardingActivity.f122709g.a(this.f107451c, purchaseSuccessDTOY.b(), this.f107450b.Q()));
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((GuestPassShareActivity$RootCompose$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
