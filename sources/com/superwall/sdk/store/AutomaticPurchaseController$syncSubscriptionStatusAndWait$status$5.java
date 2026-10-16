package com.superwall.sdk.store;

import com.superwall.sdk.config.models.ConfigurationStatus;
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
@DebugMetadata(c = "com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatusAndWait$status$5", f = "AutomaticPurchaseController.kt", l = {}, m = "invokeSuspend")
final class AutomaticPurchaseController$syncSubscriptionStatusAndWait$status$5 extends SuspendLambda implements Function2<ConfigurationStatus, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    AutomaticPurchaseController$syncSubscriptionStatusAndWait$status$5(Continuation<? super AutomaticPurchaseController$syncSubscriptionStatusAndWait$status$5> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AutomaticPurchaseController$syncSubscriptionStatusAndWait$status$5 automaticPurchaseController$syncSubscriptionStatusAndWait$status$5 = new AutomaticPurchaseController$syncSubscriptionStatusAndWait$status$5(continuation);
        automaticPurchaseController$syncSubscriptionStatusAndWait$status$5.L$0 = obj;
        return automaticPurchaseController$syncSubscriptionStatusAndWait$status$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ConfigurationStatus configurationStatus, Continuation<? super Boolean> continuation) {
        return ((AutomaticPurchaseController$syncSubscriptionStatusAndWait$status$5) create(configurationStatus, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return Boxing.a(!(((ConfigurationStatus) this.L$0) instanceof ConfigurationStatus.Pending));
    }
}
