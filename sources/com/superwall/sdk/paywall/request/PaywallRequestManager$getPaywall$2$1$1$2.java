package com.superwall.sdk.paywall.request;

import com.superwall.sdk.models.paywall.Paywall;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywall$2$1$1$2", f = "PaywallRequestManager.kt", l = {170, 183, 185}, m = "invokeSuspend")
final class PaywallRequestManager$getPaywall$2$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CancellableContinuation<Paywall> $continuation;
    final /* synthetic */ CompletableDeferred<Paywall> $deferredTask;
    final /* synthetic */ boolean $isPreloading;
    final /* synthetic */ PaywallRequest $request;
    final /* synthetic */ String $requestHash;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PaywallRequestManager this$0;

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywall$2$1$1$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywall$2$1$1$2$1", f = "PaywallRequestManager.kt", l = {186, 187}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Paywall, Continuation<? super Unit>, Object> {
        final /* synthetic */ CancellableContinuation<Paywall> $continuation;
        final /* synthetic */ CompletableDeferred<Paywall> $deferredTask;
        final /* synthetic */ long $fetchGeneration;
        final /* synthetic */ PaywallRequest $request;
        final /* synthetic */ String $requestHash;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PaywallRequestManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(PaywallRequestManager paywallRequestManager, PaywallRequest paywallRequest, String str, CompletableDeferred<Paywall> completableDeferred, long j3, CancellableContinuation<? super Paywall> cancellableContinuation, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = paywallRequestManager;
            this.$request = paywallRequest;
            this.$requestHash = str;
            this.$deferredTask = completableDeferred;
            this.$fetchGeneration = j3;
            this.$continuation = cancellableContinuation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$request, this.$requestHash, this.$deferredTask, this.$fetchGeneration, this.$continuation, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Paywall paywall, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(paywall, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AnonymousClass1 anonymousClass1;
            Paywall paywall;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Paywall paywall2 = (Paywall) this.L$0;
                PaywallRequestManager paywallRequestManager = this.this$0;
                PaywallRequest paywallRequest = this.$request;
                this.label = 1;
                obj = paywallRequestManager.addProducts(paywall2, paywallRequest, this);
                if (obj == objF) {
                }
                return objF;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                paywall = (Paywall) this.L$0;
                ResultKt.b(obj);
                anonymousClass1 = this;
                anonymousClass1.$deferredTask.J(paywall);
                anonymousClass1.$continuation.resumeWith(Result.b(paywall));
                return Unit.f139807a;
            }
            ResultKt.b(obj);
            Paywall paywall3 = (Paywall) obj;
            PaywallRequestManager paywallRequestManager2 = this.this$0;
            String str = this.$requestHash;
            CompletableDeferred<Paywall> completableDeferred = this.$deferredTask;
            boolean zIsDebuggerLaunched = this.$request.isDebuggerLaunched();
            long j3 = this.$fetchGeneration;
            this.L$0 = paywall3;
            this.label = 2;
            anonymousClass1 = this;
            if (paywallRequestManager2.saveRequestHash(str, completableDeferred, paywall3, zIsDebuggerLaunched, j3, anonymousClass1) != objF) {
                paywall = paywall3;
                anonymousClass1.$deferredTask.J(paywall);
                anonymousClass1.$continuation.resumeWith(Result.b(paywall));
                return Unit.f139807a;
            }
            return objF;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PaywallRequestManager$getPaywall$2$1$1$2(CancellableContinuation<? super Paywall> cancellableContinuation, CompletableDeferred<Paywall> completableDeferred, PaywallRequestManager paywallRequestManager, String str, PaywallRequest paywallRequest, boolean z2, Continuation<? super PaywallRequestManager$getPaywall$2$1$1$2> continuation) {
        super(2, continuation);
        this.$continuation = cancellableContinuation;
        this.$deferredTask = completableDeferred;
        this.this$0 = paywallRequestManager;
        this.$requestHash = str;
        this.$request = paywallRequest;
        this.$isPreloading = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaywallRequestManager$getPaywall$2$1$1$2(this.$continuation, this.$deferredTask, this.this$0, this.$requestHash, this.$request, this.$isPreloading, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00da, code lost:
    
        if (r13 != r0) goto L45;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x006c -> B:31:0x006f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywall$2$1$1$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaywallRequestManager$getPaywall$2$1$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
