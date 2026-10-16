package cz.mobilesoft.coreblock.scene.premium.host;

import android.app.Activity;
import android.content.Context;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$PremiumScreenInitialize$4$1", f = "PaywallHostActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class PaywallHostActivity$PremiumScreenInitialize$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f113233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PremiumScreenViewState f113234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f113235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f113236d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallHostActivity$PremiumScreenInitialize$4$1(PremiumScreenViewState premiumScreenViewState, Context context, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f113234b = premiumScreenViewState;
        this.f113235c = context;
        this.f113236d = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PaywallHostActivity$PremiumScreenInitialize$4$1(this.f113234b, this.f113235c, this.f113236d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Activity activityB;
        IntrinsicsKt.f();
        if (this.f113233a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        ViewModelState viewModelStateC = this.f113234b.c();
        Success success = Success.f128020a;
        if (Intrinsics.areEqual(viewModelStateC, success) && Intrinsics.areEqual(this.f113234b.v(), success) && !this.f113234b.u().isEmpty() && this.f113234b.X() && (activityB = ContextExtKt.b(this.f113235c)) != null) {
            this.f113236d.invoke(new PremiumScreenViewEvent.OnPurchase(activityB, null, 2, null));
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PaywallHostActivity$PremiumScreenInitialize$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
