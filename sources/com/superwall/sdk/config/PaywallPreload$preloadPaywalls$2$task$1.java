package com.superwall.sdk.config;

import com.superwall.sdk.paywall.manager.PaywallManager;
import com.superwall.sdk.paywall.request.PaywallRequest;
import com.superwall.sdk.paywall.request.ResponseIdentifiers;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@DebugMetadata(c = "com.superwall.sdk.config.PaywallPreload$preloadPaywalls$2$task$1", f = "PaywallPreload.kt", l = {164}, m = "invokeSuspend")
final class PaywallPreload$preloadPaywalls$2$task$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ String $identifier;
    int label;
    final /* synthetic */ PaywallPreload this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallPreload$preloadPaywalls$2$task$1(PaywallPreload paywallPreload, String str, Continuation<? super PaywallPreload$preloadPaywalls$2$task$1> continuation) {
        super(2, continuation);
        this.this$0 = paywallPreload;
        this.$identifier = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaywallPreload$preloadPaywalls$2$task$1(this.this$0, this.$identifier, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            PaywallRequest paywallRequestMakePaywallRequest = this.this$0.getFactory().makePaywallRequest(null, new ResponseIdentifiers(this.$identifier, null), null, false, null);
            PaywallManager paywallManager = this.this$0.getPaywallManager();
            this.label = 1;
            Object paywallView = paywallManager.getPaywallView(paywallRequestMakePaywallRequest, true, true, null, this);
            return paywallView == objF ? objF : paywallView;
        } catch (Exception unused) {
            return Unit.f139807a;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((PaywallPreload$preloadPaywalls$2$task$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
