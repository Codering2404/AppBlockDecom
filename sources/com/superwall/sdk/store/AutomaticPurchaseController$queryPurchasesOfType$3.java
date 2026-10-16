package com.superwall.sdk.store;

import com.android.billingclient.api.Purchase;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
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
@DebugMetadata(c = "com.superwall.sdk.store.AutomaticPurchaseController$queryPurchasesOfType$3", f = "AutomaticPurchaseController.kt", l = {455}, m = "invokeSuspend")
final class AutomaticPurchaseController$queryPurchasesOfType$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends Purchase>>>, Object> {
    final /* synthetic */ CompletableDeferred<Result<List<Purchase>>> $deferred;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutomaticPurchaseController$queryPurchasesOfType$3(CompletableDeferred<Result<List<Purchase>>> completableDeferred, Continuation<? super AutomaticPurchaseController$queryPurchasesOfType$3> continuation) {
        super(2, continuation);
        this.$deferred = completableDeferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AutomaticPurchaseController$queryPurchasesOfType$3(this.$deferred, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        CompletableDeferred<Result<List<Purchase>>> completableDeferred = this.$deferred;
        this.label = 1;
        Object objAwait = completableDeferred.await(this);
        return objAwait == objF ? objF : objAwait;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends List<? extends Purchase>>> continuation) {
        return ((AutomaticPurchaseController$queryPurchasesOfType$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
