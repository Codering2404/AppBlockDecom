package com.superwall.sdk.paywall.presentation.internal.operators;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.MutableSharedFlow;

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
public final class CheckDebuggerPresentationKt {

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.CheckDebuggerPresentationKt$innerCheckDebuggerPresentation$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.CheckDebuggerPresentationKt", f = "CheckDebuggerPresentation.kt", l = {43}, m = "innerCheckDebuggerPresentation")
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
            return CheckDebuggerPresentationKt.innerCheckDebuggerPresentation(null, null, this);
        }
    }

    public static final Object checkDebuggerPresentation(Superwall superwall, PresentationRequest presentationRequest, MutableSharedFlow<PaywallState> mutableSharedFlow, Continuation<? super Unit> continuation) throws Throwable {
        Object objInnerCheckDebuggerPresentation = innerCheckDebuggerPresentation(presentationRequest, mutableSharedFlow, continuation);
        return objInnerCheckDebuggerPresentation == IntrinsicsKt.f() ? objInnerCheckDebuggerPresentation : Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object innerCheckDebuggerPresentation(com.superwall.sdk.paywall.presentation.internal.PresentationRequest r6, kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof com.superwall.sdk.paywall.presentation.internal.operators.CheckDebuggerPresentationKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.superwall.sdk.paywall.presentation.internal.operators.CheckDebuggerPresentationKt$innerCheckDebuggerPresentation$1 r0 = (com.superwall.sdk.paywall.presentation.internal.operators.CheckDebuggerPresentationKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.presentation.internal.operators.CheckDebuggerPresentationKt$innerCheckDebuggerPresentation$1 r0 = new com.superwall.sdk.paywall.presentation.internal.operators.CheckDebuggerPresentationKt$innerCheckDebuggerPresentation$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2d:
            kotlin.ResultKt.b(r8)
            goto L6f
        L31:
            kotlin.ResultKt.b(r8)
            com.superwall.sdk.paywall.presentation.internal.PresentationRequest$Flags r8 = r6.getFlags()
            boolean r8 = r8.isDebuggerLaunched()
            if (r8 == 0) goto L75
            java.lang.ref.WeakReference r6 = r6.getPresenter()
            if (r6 == 0) goto L4b
            java.lang.Object r6 = r6.get()
            android.app.Activity r6 = (android.app.Activity) r6
            goto L4c
        L4b:
            r6 = 0
        L4c:
            boolean r6 = r6 instanceof com.superwall.sdk.debug.DebugViewActivity
            if (r6 == 0) goto L51
            goto L75
        L51:
            com.superwall.sdk.paywall.presentation.internal.InternalPresentationLogic r6 = com.superwall.sdk.paywall.presentation.internal.InternalPresentationLogic.INSTANCE
            java.lang.String r8 = "Debugger Is Presented"
            java.lang.String r2 = "Trying to present paywall when debugger is launched."
            java.lang.String r4 = "SWPresentationError"
            r5 = 101(0x65, float:1.42E-43)
            java.lang.Throwable r6 = r6.presentationError(r4, r5, r8, r2)
            com.superwall.sdk.paywall.presentation.internal.state.PaywallState$PresentationError r8 = new com.superwall.sdk.paywall.presentation.internal.state.PaywallState$PresentationError
            r8.<init>(r6)
            if (r7 == 0) goto L6f
            r0.label = r3
            java.lang.Object r6 = r7.emit(r8, r0)
            if (r6 != r1) goto L6f
            return r1
        L6f:
            com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason$DebuggerPresented r6 = new com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason$DebuggerPresented
            r6.<init>()
            throw r6
        L75:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.operators.CheckDebuggerPresentationKt.innerCheckDebuggerPresentation(com.superwall.sdk.paywall.presentation.internal.PresentationRequest, kotlinx.coroutines.flow.MutableSharedFlow, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
