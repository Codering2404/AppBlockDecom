package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1", f = "LoadedPaywallComponents.kt", l = {86}, m = "invokeSuspend")
final class LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PaywallAction.External, Continuation<? super Unit>, Object> $clickHandler;
    final /* synthetic */ PaywallComponentInteractionTracker $componentInteractionTracker;
    final /* synthetic */ PaywallState.Loaded.Components $state;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1(PaywallState.Loaded.Components components, Function2<? super PaywallAction.External, ? super Continuation<? super Unit>, ? extends Object> function2, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Continuation<? super LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1> continuation) {
        super(2, continuation);
        this.$state = components;
        this.$clickHandler = function2;
        this.$componentInteractionTracker = paywallComponentInteractionTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1 loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1 = new LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1(this.$state, this.$clickHandler, this.$componentInteractionTracker, continuation);
        loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1.L$0 = obj;
        return loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
        return ((LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1) create(paywallAction, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            PaywallAction paywallAction = (PaywallAction) this.L$0;
            PaywallState.Loaded.Components components = this.$state;
            Function2<PaywallAction.External, Continuation<? super Unit>, Object> function2 = this.$clickHandler;
            PaywallComponentInteractionTracker paywallComponentInteractionTracker = this.$componentInteractionTracker;
            this.label = 1;
            if (LoadedPaywallComponentsKt.handleClick(paywallAction, components, function2, paywallComponentInteractionTracker, this) == objF) {
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
