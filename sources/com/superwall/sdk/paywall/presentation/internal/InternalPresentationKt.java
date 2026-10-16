package com.superwall.sdk.paywall.presentation.internal;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.paywall.presentation.PaywallCloseReason;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallResult;
import com.superwall.sdk.paywall.view.PaywallView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

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
public final class InternalPresentationKt {

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.InternalPresentationKt$dismiss$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.InternalPresentationKt$dismiss$2", f = "InternalPresentation.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PaywallCloseReason $closeReason;
        final /* synthetic */ Function0<Unit> $completion;
        final /* synthetic */ PaywallView $paywallView;
        final /* synthetic */ PaywallResult $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PaywallView paywallView, PaywallResult paywallResult, PaywallCloseReason paywallCloseReason, Function0<Unit> function0, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$paywallView = paywallView;
            this.$result = paywallResult;
            this.$closeReason = paywallCloseReason;
            this.$completion = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$paywallView, this.$result, this.$closeReason, this.$completion, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.$paywallView.dismiss$superwall_release(this.$result, this.$closeReason, this.$completion);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.InternalPresentationKt$dismissAfterPaymentSheet$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.InternalPresentationKt$dismissAfterPaymentSheet$2", f = "InternalPresentation.kt", l = {}, m = "invokeSuspend")
    static final class C28452 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PaywallCloseReason $closeReason;
        final /* synthetic */ Function0<Unit> $completion;
        final /* synthetic */ PaywallView $paywallView;
        final /* synthetic */ PaywallResult $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28452(PaywallView paywallView, PaywallResult paywallResult, PaywallCloseReason paywallCloseReason, Function0<Unit> function0, Continuation<? super C28452> continuation) {
            super(2, continuation);
            this.$paywallView = paywallView;
            this.$result = paywallResult;
            this.$closeReason = paywallCloseReason;
            this.$completion = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28452(this.$paywallView, this.$result, this.$closeReason, this.$completion, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.$paywallView.dismiss$superwall_release(this.$result, this.$closeReason, this.$completion);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28452) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.InternalPresentationKt$internallyPresent$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.InternalPresentationKt", f = "InternalPresentation.kt", l = {29, 31, 44, 54}, m = "internallyPresent")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InternalPresentationKt.internallyPresent(null, null, null, this);
        }
    }

    public static final Object dismiss(PaywallView paywallView, PaywallResult paywallResult, PaywallCloseReason paywallCloseReason, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Object objG = BuildersKt.g(Dispatchers.c(), new AnonymousClass2(paywallView, paywallResult, paywallCloseReason, function0, null), continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    public static /* synthetic */ Object dismiss$default(PaywallView paywallView, PaywallResult paywallResult, PaywallCloseReason paywallCloseReason, Function0 function0, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            paywallCloseReason = PaywallCloseReason.SystemLogic.INSTANCE;
        }
        if ((i3 & 8) != 0) {
            function0 = null;
        }
        return dismiss(paywallView, paywallResult, paywallCloseReason, function0, continuation);
    }

    public static final Object dismissAfterPaymentSheet(Superwall superwall, PaywallView paywallView, PaywallResult paywallResult, PaywallCloseReason paywallCloseReason, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Object objG = BuildersKt.g(Dispatchers.c(), new C28452(paywallView, paywallResult, paywallCloseReason, function0, null), continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    public static /* synthetic */ Object dismissAfterPaymentSheet$default(Superwall superwall, PaywallView paywallView, PaywallResult paywallResult, PaywallCloseReason paywallCloseReason, Function0 function0, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            paywallCloseReason = PaywallCloseReason.SystemLogic.INSTANCE;
        }
        PaywallCloseReason paywallCloseReason2 = paywallCloseReason;
        if ((i3 & 8) != 0) {
            function0 = null;
        }
        return dismissAfterPaymentSheet(superwall, paywallView, paywallResult, paywallCloseReason2, function0, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f9, code lost:
    
        if (com.superwall.sdk.paywall.presentation.internal.operators.LogErrorsKt.logErrors(r15, r9, r0, r12) == r3) goto L54;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ba A[Catch: all -> 0x00e1, TryCatch #0 {all -> 0x00e1, blocks: (B:41:0x00af, B:43:0x00ba, B:48:0x00e3, B:49:0x00ea), top: B:57:0x00af }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e3 A[Catch: all -> 0x00e1, TryCatch #0 {all -> 0x00e1, blocks: (B:41:0x00af, B:43:0x00ba, B:48:0x00e3, B:49:0x00ea), top: B:57:0x00af }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Type inference failed for: r15v11, types: [com.superwall.sdk.Superwall] */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object internallyPresent(com.superwall.sdk.Superwall r15, com.superwall.sdk.paywall.presentation.internal.PresentationRequest r16, kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState> r17, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.InternalPresentationKt.internallyPresent(com.superwall.sdk.Superwall, com.superwall.sdk.paywall.presentation.internal.PresentationRequest, kotlinx.coroutines.flow.MutableSharedFlow, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
