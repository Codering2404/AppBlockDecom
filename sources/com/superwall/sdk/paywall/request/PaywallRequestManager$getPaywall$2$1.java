package com.superwall.sdk.paywall.request;

import com.superwall.sdk.models.paywall.Paywall;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywall$2$1", f = "PaywallRequestManager.kt", l = {115, 122, 131, 133, 524, 215}, m = "invokeSuspend")
final class PaywallRequestManager$getPaywall$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Paywall>, Object> {
    final /* synthetic */ boolean $isPreloading;
    final /* synthetic */ PaywallRequest $request;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    final /* synthetic */ PaywallRequestManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallRequestManager$getPaywall$2$1(PaywallRequestManager paywallRequestManager, PaywallRequest paywallRequest, boolean z2, Continuation<? super PaywallRequestManager$getPaywall$2$1> continuation) {
        super(2, continuation);
        this.this$0 = paywallRequestManager;
        this.$request = paywallRequest;
        this.$isPreloading = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaywallRequestManager$getPaywall$2$1(this.this$0, this.$request, this.$isPreloading, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x02c4, code lost:
    
        if (r2 == r0) goto L102;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0297  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 740
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.request.PaywallRequestManager$getPaywall$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Paywall> continuation) {
        return ((PaywallRequestManager$getPaywall$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
