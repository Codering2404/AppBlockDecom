package com.superwall.sdk.paywall.presentation.internal.operators;

import com.superwall.sdk.config.models.ConfigState;
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
import kotlinx.coroutines.flow.StateFlow;

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
@DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$configResult$1", f = "WaitForSubsStatusAndConfig.kt", l = {84}, m = "invokeSuspend")
final class WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$configResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ StateFlow<ConfigState> $configState;
    final /* synthetic */ int $retries;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$configResult$1(StateFlow<? extends ConfigState> stateFlow, int i3, Continuation<? super WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$configResult$1> continuation) {
        super(2, continuation);
        this.$configState = stateFlow;
        this.$retries = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$configResult$1 waitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$configResult$1 = new WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$configResult$1(this.$configState, this.$retries, continuation);
        waitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$configResult$1.L$0 = obj;
        return waitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$configResult$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow<ConfigState> stateFlow = this.$configState;
                int i4 = this.$retries;
                Result.Companion companion = Result.f139772b;
                this.label = 1;
                if (WaitForSubsStatusAndConfigKt.configOrThrow(stateFlow, i4, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            objB = Result.b(Unit.f139807a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f139772b;
            objB = Result.b(ResultKt.a(th));
        }
        return Result.a(objB);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((WaitForSubsStatusAndConfigKt$waitForEntitlementsAndConfig$2$configResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
