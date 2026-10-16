package com.superwall.sdk.paywall.presentation.internal.operators;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
public final class CheckNoPaywallAlreadyPresentedKt {

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.CheckNoPaywallAlreadyPresentedKt$checkNoPaywallAlreadyPresented$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.CheckNoPaywallAlreadyPresentedKt", f = "CheckNoPaywallAlreadyPresented.kt", l = {31}, m = "checkNoPaywallAlreadyPresented")
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CheckNoPaywallAlreadyPresentedKt.checkNoPaywallAlreadyPresented(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object checkNoPaywallAlreadyPresented(com.superwall.sdk.paywall.presentation.internal.PresentationRequest r12, kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState> r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) throws java.lang.Throwable {
        /*
            boolean r0 = r14 instanceof com.superwall.sdk.paywall.presentation.internal.operators.CheckNoPaywallAlreadyPresentedKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r14
            com.superwall.sdk.paywall.presentation.internal.operators.CheckNoPaywallAlreadyPresentedKt$checkNoPaywallAlreadyPresented$1 r0 = (com.superwall.sdk.paywall.presentation.internal.operators.CheckNoPaywallAlreadyPresentedKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.presentation.internal.operators.CheckNoPaywallAlreadyPresentedKt$checkNoPaywallAlreadyPresented$1 r0 = new com.superwall.sdk.paywall.presentation.internal.operators.CheckNoPaywallAlreadyPresentedKt$checkNoPaywallAlreadyPresented$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L2d:
            kotlin.ResultKt.b(r14)
            goto L75
        L31:
            kotlin.ResultKt.b(r14)
            com.superwall.sdk.paywall.presentation.internal.PresentationRequest$Flags r12 = r12.getFlags()
            boolean r12 = r12.isPaywallPresented()
            if (r12 == 0) goto L7b
            com.superwall.sdk.logger.Logger r4 = com.superwall.sdk.logger.Logger.INSTANCE
            com.superwall.sdk.logger.LogLevel r5 = com.superwall.sdk.logger.LogLevel.error
            com.superwall.sdk.logger.LogScope r6 = com.superwall.sdk.logger.LogScope.paywallPresentation
            java.lang.String r12 = "message"
            java.lang.String r14 = "Superwall.instance.isPaywallPresented is true"
            kotlin.Pair r12 = kotlin.TuplesKt.a(r12, r14)
            java.util.Map r8 = kotlin.collections.MapsKt.mapOf(r12)
            r10 = 16
            r11 = 0
            java.lang.String r7 = "Paywall Already Presented"
            r9 = 0
            com.superwall.sdk.logger.Logger.debug$default(r4, r5, r6, r7, r8, r9, r10, r11)
            com.superwall.sdk.paywall.presentation.internal.InternalPresentationLogic r12 = com.superwall.sdk.paywall.presentation.internal.InternalPresentationLogic.INSTANCE
            java.lang.String r14 = "Paywall Already Presented"
            java.lang.String r2 = "You can only present one paywall at a time."
            java.lang.String r4 = "SWPresentationError"
            r5 = 102(0x66, float:1.43E-43)
            java.lang.Throwable r12 = r12.presentationError(r4, r5, r14, r2)
            com.superwall.sdk.paywall.presentation.internal.state.PaywallState$PresentationError r14 = new com.superwall.sdk.paywall.presentation.internal.state.PaywallState$PresentationError
            r14.<init>(r12)
            r0.label = r3
            java.lang.Object r12 = r13.emit(r14, r0)
            if (r12 != r1) goto L75
            return r1
        L75:
            com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason$PaywallAlreadyPresented r12 = new com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason$PaywallAlreadyPresented
            r12.<init>()
            throw r12
        L7b:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.operators.CheckNoPaywallAlreadyPresentedKt.checkNoPaywallAlreadyPresented(com.superwall.sdk.paywall.presentation.internal.PresentationRequest, kotlinx.coroutines.flow.MutableSharedFlow, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
