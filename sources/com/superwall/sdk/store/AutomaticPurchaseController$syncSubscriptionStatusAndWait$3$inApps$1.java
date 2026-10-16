package com.superwall.sdk.store;

import com.android.billingclient.api.Purchase;
import com.superwall.sdk.misc.Task_RetryingKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatusAndWait$3$inApps$1", f = "AutomaticPurchaseController.kt", l = {358}, m = "invokeSuspend")
final class AutomaticPurchaseController$syncSubscriptionStatusAndWait$3$inApps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Purchase>>, Object> {
    int label;
    final /* synthetic */ AutomaticPurchaseController this$0;

    /* JADX INFO: renamed from: com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatusAndWait$3$inApps$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.AutomaticPurchaseController$syncSubscriptionStatusAndWait$3$inApps$1$1", f = "AutomaticPurchaseController.kt", l = {358}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super List<? extends Purchase>>, Object> {
        int label;
        final /* synthetic */ AutomaticPurchaseController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AutomaticPurchaseController automaticPurchaseController, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.this$0 = automaticPurchaseController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM1341queryPurchasesOfTypegIAlus;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                AutomaticPurchaseController automaticPurchaseController = this.this$0;
                this.label = 1;
                objM1341queryPurchasesOfTypegIAlus = automaticPurchaseController.m1341queryPurchasesOfTypegIAlus("inapp", this);
                if (objM1341queryPurchasesOfTypegIAlus == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                objM1341queryPurchasesOfTypegIAlus = ((Result) obj).j();
            }
            ResultKt.b(objM1341queryPurchasesOfTypegIAlus);
            return objM1341queryPurchasesOfTypegIAlus;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super List<? extends Purchase>> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutomaticPurchaseController$syncSubscriptionStatusAndWait$3$inApps$1(AutomaticPurchaseController automaticPurchaseController, Continuation<? super AutomaticPurchaseController$syncSubscriptionStatusAndWait$3$inApps$1> continuation) {
        super(2, continuation);
        this.this$0 = automaticPurchaseController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AutomaticPurchaseController$syncSubscriptionStatusAndWait$3$inApps$1(this.this$0, continuation);
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
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        Object objRetryOrNull$default = Task_RetryingKt.retryOrNull$default(3, null, anonymousClass1, this, 2, null);
        return objRetryOrNull$default == objF ? objF : objRetryOrNull$default;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Purchase>> continuation) {
        return ((AutomaticPurchaseController$syncSubscriptionStatusAndWait$3$inApps$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
