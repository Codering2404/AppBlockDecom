package com.superwall.sdk.store;

import com.superwall.sdk.delegate.PurchaseResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "com.superwall.sdk.store.AutomaticPurchaseController$purchase$value$1", f = "AutomaticPurchaseController.kt", l = {}, m = "invokeSuspend")
final class AutomaticPurchaseController$purchase$value$1 extends SuspendLambda implements Function2<PurchaseResult, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    AutomaticPurchaseController$purchase$value$1(Continuation<? super AutomaticPurchaseController$purchase$value$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AutomaticPurchaseController$purchase$value$1 automaticPurchaseController$purchase$value$1 = new AutomaticPurchaseController$purchase$value$1(continuation);
        automaticPurchaseController$purchase$value$1.L$0 = obj;
        return automaticPurchaseController$purchase$value$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PurchaseResult purchaseResult, Continuation<? super Boolean> continuation) {
        return ((AutomaticPurchaseController$purchase$value$1) create(purchaseResult, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return Boxing.a(((PurchaseResult) this.L$0) != null);
    }
}
