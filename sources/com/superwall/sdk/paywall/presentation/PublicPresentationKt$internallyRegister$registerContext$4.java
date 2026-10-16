package com.superwall.sdk.paywall.presentation;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.paywall.presentation.internal.InternalPresentationKt;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.MutableSharedFlow;

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
@DebugMetadata(c = "com.superwall.sdk.paywall.presentation.PublicPresentationKt$internallyRegister$registerContext$4", f = "PublicPresentation.kt", l = {325}, m = "invokeSuspend")
final class PublicPresentationKt$internallyRegister$registerContext$4 extends SuspendLambda implements Function3<PresentationRequest, MutableSharedFlow<PaywallState>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Superwall $this_internallyRegister;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PublicPresentationKt$internallyRegister$registerContext$4(Superwall superwall, Continuation<? super PublicPresentationKt$internallyRegister$registerContext$4> continuation) {
        super(3, continuation);
        this.$this_internallyRegister = superwall;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PresentationRequest presentationRequest, MutableSharedFlow<PaywallState> mutableSharedFlow, Continuation<? super Unit> continuation) {
        PublicPresentationKt$internallyRegister$registerContext$4 publicPresentationKt$internallyRegister$registerContext$4 = new PublicPresentationKt$internallyRegister$registerContext$4(this.$this_internallyRegister, continuation);
        publicPresentationKt$internallyRegister$registerContext$4.L$0 = presentationRequest;
        publicPresentationKt$internallyRegister$registerContext$4.L$1 = mutableSharedFlow;
        return publicPresentationKt$internallyRegister$registerContext$4.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            PresentationRequest presentationRequest = (PresentationRequest) this.L$0;
            MutableSharedFlow mutableSharedFlow = (MutableSharedFlow) this.L$1;
            Superwall superwall = this.$this_internallyRegister;
            this.L$0 = null;
            this.label = 1;
            if (InternalPresentationKt.internallyPresent(superwall, presentationRequest, mutableSharedFlow, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }
}
