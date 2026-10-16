package com.revenuecat.purchases.ui.revenuecatui.components.pkg;

import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.components.style.PackageComponentStyle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
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
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.pkg.PackageComponentViewKt$PackageComponentView$4$1", f = "PackageComponentView.kt", l = {36}, m = "invokeSuspend")
public final class PackageComponentViewKt$PackageComponentView$4$1 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PaywallAction, Continuation<? super Unit>, Object> $clickHandler;
    final /* synthetic */ PackageComponentStyle $style;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PackageComponentViewKt$PackageComponentView$4$1(PackageComponentStyle packageComponentStyle, Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super PackageComponentViewKt$PackageComponentView$4$1> continuation) {
        super(2, continuation);
        this.$style = packageComponentStyle;
        this.$clickHandler = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PackageComponentViewKt$PackageComponentView$4$1 packageComponentViewKt$PackageComponentView$4$1 = new PackageComponentViewKt$PackageComponentView$4$1(this.$style, this.$clickHandler, continuation);
        packageComponentViewKt$PackageComponentView$4$1.L$0 = obj;
        return packageComponentViewKt$PackageComponentView$4$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
        return ((PackageComponentViewKt$PackageComponentView$4$1) create(paywallAction, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            PaywallAction paywallAction = (PaywallAction) this.L$0;
            if (!this.$style.isSelectable()) {
                Function2<PaywallAction, Continuation<? super Unit>, Object> function2 = this.$clickHandler;
                this.label = 1;
                if (function2.invoke(paywallAction, this) == objF) {
                    return objF;
                }
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
