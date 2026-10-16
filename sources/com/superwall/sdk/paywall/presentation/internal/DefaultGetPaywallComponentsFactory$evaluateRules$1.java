package com.superwall.sdk.paywall.presentation.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.DefaultGetPaywallComponentsFactory", f = "GetPaywallComponentsFactory.kt", l = {68}, m = "evaluateRules-gIAlu-s")
final class DefaultGetPaywallComponentsFactory$evaluateRules$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultGetPaywallComponentsFactory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultGetPaywallComponentsFactory$evaluateRules$1(DefaultGetPaywallComponentsFactory defaultGetPaywallComponentsFactory, Continuation<? super DefaultGetPaywallComponentsFactory$evaluateRules$1> continuation) {
        super(continuation);
        this.this$0 = defaultGetPaywallComponentsFactory;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo1326evaluateRulesgIAlus = this.this$0.mo1326evaluateRulesgIAlus(null, this);
        return objMo1326evaluateRulesgIAlus == IntrinsicsKt.f() ? objMo1326evaluateRulesgIAlus : Result.a(objMo1326evaluateRulesgIAlus);
    }
}
