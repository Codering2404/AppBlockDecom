package com.superwall.sdk.paywall.presentation.internal.operators;

import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.dependencies.DependencyContainer;
import com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatus;
import com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$1$1", f = "WaitForSubsStatusAndConfig.kt", l = {101}, m = "invokeSuspend")
final class WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DependencyContainer $dependencyContainer;
    final /* synthetic */ PresentationRequest $request;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$1$1(PresentationRequest presentationRequest, DependencyContainer dependencyContainer, Continuation<? super WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$1$1> continuation) {
        super(2, continuation);
        this.$request = presentationRequest;
        this.$dependencyContainer = dependencyContainer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$1$1(this.$request, this.$dependencyContainer, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            InternalSuperwallEvent.PresentationRequest presentationRequest = new InternalSuperwallEvent.PresentationRequest(this.$request.getPresentationInfo().getEventData(), this.$request.getFlags().getType(), PaywallPresentationRequestStatus.Timeout.INSTANCE, new PaywallPresentationRequestStatusReason.SubscriptionStatusTimeout(null, 1, null), this.$dependencyContainer, null, 32, null);
            DependencyContainer dependencyContainer = this.$dependencyContainer;
            this.label = 1;
            if (dependencyContainer.mo1271trackgIAlus(presentationRequest, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            ((Result) obj).j();
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
