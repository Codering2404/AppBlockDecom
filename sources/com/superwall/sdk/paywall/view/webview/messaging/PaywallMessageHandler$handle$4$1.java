package com.superwall.sdk.paywall.view.webview.messaging;

import com.superwall.sdk.models.paywall.Paywall;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handle$4$1", f = "PaywallMessageHandler.kt", l = {264}, m = "invokeSuspend")
final class PaywallMessageHandler$handle$4$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Date $loadedAt;
    final /* synthetic */ Paywall $paywall;
    int label;
    final /* synthetic */ PaywallMessageHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallMessageHandler$handle$4$1(PaywallMessageHandler paywallMessageHandler, Paywall paywall, Date date, Continuation<? super PaywallMessageHandler$handle$4$1> continuation) {
        super(1, continuation);
        this.this$0 = paywallMessageHandler;
        this.$paywall = paywall;
        this.$loadedAt = date;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new PaywallMessageHandler$handle$4$1(this.this$0, this.$paywall, this.$loadedAt, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            PaywallMessageHandler paywallMessageHandler = this.this$0;
            Paywall paywall = this.$paywall;
            Date date = this.$loadedAt;
            this.label = 1;
            if (paywallMessageHandler.didLoadWebView(paywall, date, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((PaywallMessageHandler$handle$4$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
