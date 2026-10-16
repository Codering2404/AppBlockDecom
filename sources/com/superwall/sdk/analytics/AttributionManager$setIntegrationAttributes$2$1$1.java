package com.superwall.sdk.analytics;

import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent;
import java.util.Map;
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
@DebugMetadata(c = "com.superwall.sdk.analytics.AttributionManager$setIntegrationAttributes$2$1$1", f = "AttributionManager.kt", l = {65}, m = "invokeSuspend")
final class AttributionManager$setIntegrationAttributes$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $merged;
    int label;
    final /* synthetic */ AttributionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AttributionManager$setIntegrationAttributes$2$1$1(AttributionManager attributionManager, Map<String, String> map, Continuation<? super AttributionManager$setIntegrationAttributes$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = attributionManager;
        this.$merged = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AttributionManager$setIntegrationAttributes$2$1$1(this.this$0, this.$merged, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> track = this.this$0.getTrack();
            InternalSuperwallEvent.IntegrationAttributes integrationAttributes = new InternalSuperwallEvent.IntegrationAttributes(this.$merged);
            this.label = 1;
            if (track.invoke(integrationAttributes, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.this$0.getRedeemAfterSetting().invoke();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AttributionManager$setIntegrationAttributes$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
