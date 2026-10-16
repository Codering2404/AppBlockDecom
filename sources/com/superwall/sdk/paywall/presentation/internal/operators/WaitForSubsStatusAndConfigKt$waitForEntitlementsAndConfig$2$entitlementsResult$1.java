package com.superwall.sdk.paywall.presentation.internal.operators;

import com.superwall.sdk.models.entitlements.SubscriptionStatus;
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
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

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
@DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$entitlementsResult$1", f = "WaitForSubsStatusAndConfig.kt", l = {75}, m = "invokeSuspend")
final class WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$entitlementsResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends SubscriptionStatus>>, Object> {
    final /* synthetic */ PresentationRequest $request;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$entitlementsResult$1(PresentationRequest presentationRequest, Continuation<? super WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$entitlementsResult$1> continuation) {
        super(2, continuation);
        this.$request = presentationRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$entitlementsResult$1 waitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$entitlementsResult$1 = new WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$entitlementsResult$1(this.$request, continuation);
        waitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$entitlementsResult$1.L$0 = obj;
        return waitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$entitlementsResult$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                PresentationRequest presentationRequest = this.$request;
                Result.Companion companion = Result.f139772b;
                Duration.Companion companion2 = Duration.f140631b;
                long jS = DurationKt.s(5, DurationUnit.f140641f);
                WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$entitlementsResult$1$1$1 waitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$entitlementsResult$1$1$1 = new WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$entitlementsResult$1$1$1(presentationRequest, null);
                this.label = 1;
                obj = TimeoutKt.d(jS, waitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$entitlementsResult$1$1$1, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            objB = Result.b((SubscriptionStatus) obj);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.f139772b;
            objB = Result.b(ResultKt.a(th));
        }
        return Result.a(objB);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends SubscriptionStatus>> continuation) {
        return ((WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$entitlementsResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
