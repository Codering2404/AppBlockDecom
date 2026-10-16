package com.revenuecat.purchases.ui.revenuecatui;

import android.app.Activity;
import android.content.Context;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$rememberPaywallActionHandler$1$1", f = "InternalPaywall.kt", l = {339, 344}, m = "invokeSuspend")
final class InternalPaywallKt$rememberPaywallActionHandler$1$1 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Context $context;
    final /* synthetic */ PaywallViewModel $viewModel;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InternalPaywallKt$rememberPaywallActionHandler$1$1(PaywallViewModel paywallViewModel, Activity activity, Context context, Continuation<? super InternalPaywallKt$rememberPaywallActionHandler$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = paywallViewModel;
        this.$activity = activity;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InternalPaywallKt$rememberPaywallActionHandler$1$1 internalPaywallKt$rememberPaywallActionHandler$1$1 = new InternalPaywallKt$rememberPaywallActionHandler$1$1(this.$viewModel, this.$activity, this.$context, continuation);
        internalPaywallKt$rememberPaywallActionHandler$1$1.L$0 = obj;
        return internalPaywallKt$rememberPaywallActionHandler$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
        return ((InternalPaywallKt$rememberPaywallActionHandler$1$1) create(external, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002f, code lost:
    
        if (r6.handleRestorePurchases(r5) == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        if (r3.handlePackagePurchase(r1, r4, r6, r5) == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$rememberPaywallActionHandler$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
