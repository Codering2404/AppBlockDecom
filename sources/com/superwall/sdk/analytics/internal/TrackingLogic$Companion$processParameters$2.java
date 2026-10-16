package com.superwall.sdk.analytics.internal;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.superwall.sdk.analytics.internal.trackable.Trackable;
import com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
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
@DebugMetadata(c = "com.superwall.sdk.analytics.internal.TrackingLogic$Companion$processParameters$2", f = "TrackingLogic.kt", l = {44}, m = "invokeSuspend")
final class TrackingLogic$Companion$processParameters$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TrackingParameters>, Object> {
    final /* synthetic */ String $appSessionId;
    final /* synthetic */ Trackable $trackableEvent;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TrackingLogic$Companion$processParameters$2(Trackable trackable, String str, Continuation<? super TrackingLogic$Companion$processParameters$2> continuation) {
        super(2, continuation);
        this.$trackableEvent = trackable;
        this.$appSessionId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrackingLogic$Companion$processParameters$2(this.$trackableEvent, this.$appSessionId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            Trackable trackable = this.$trackableEvent;
            this.label = 1;
            obj = trackable.getSuperwallParameters(this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        Map mutableMap = MapsKt.toMutableMap((Map) obj);
        mutableMap.put(DiagnosticsEntry.APP_SESSION_ID_KEY, this.$appSessionId);
        Map<String, Object> audienceFilterParams = this.$trackableEvent.getAudienceFilterParams();
        String rawName = this.$trackableEvent.getRawName();
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.a("is_superwall", Boxing.a(true)));
        Map mapMutableMapOf2 = MapsKt.mutableMapOf(TuplesKt.a("$is_standard_event", Boxing.a(this.$trackableEvent instanceof TrackableSuperwallEvent)), TuplesKt.a("$event_name", rawName), TuplesKt.a("event_name", rawName));
        for (Map.Entry entry : mutableMap.entrySet()) {
            String str = (String) entry.getKey();
            Object objClean = TrackingLogic.Companion.clean(entry.getValue());
            if (objClean != null) {
                mapMutableMapOf2.put("$" + str, objClean);
                mapMutableMapOf.put(str, objClean);
            }
        }
        for (Map.Entry<String, Object> entry2 : audienceFilterParams.entrySet()) {
            String key = entry2.getKey();
            Object objClean2 = TrackingLogic.Companion.clean(entry2.getValue());
            if (objClean2 != null && !StringsKt.U(key, "$", false, 2, null)) {
                mapMutableMapOf.put(key, objClean2);
                mapMutableMapOf2.put(key, objClean2);
            }
        }
        return new TrackingParameters(mapMutableMapOf, mapMutableMapOf2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super TrackingParameters> continuation) {
        return ((TrackingLogic$Companion$processParameters$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
