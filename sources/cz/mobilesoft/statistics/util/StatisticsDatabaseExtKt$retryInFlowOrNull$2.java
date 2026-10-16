package cz.mobilesoft.statistics.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.statistics.util.StatisticsDatabaseExtKt$retryInFlowOrNull$2", f = "StatisticsDatabaseExt.kt", l = {79, 79}, m = "invokeSuspend", v = 1)
final class StatisticsDatabaseExtKt$retryInFlowOrNull$2 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f133852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f133853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f133854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f133855d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatisticsDatabaseExtKt$retryInFlowOrNull$2(Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f133855d = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StatisticsDatabaseExtKt$retryInFlowOrNull$2 statisticsDatabaseExtKt$retryInFlowOrNull$2 = new StatisticsDatabaseExtKt$retryInFlowOrNull$2(this.f133855d, continuation);
        statisticsDatabaseExtKt$retryInFlowOrNull$2.f133854c = obj;
        return statisticsDatabaseExtKt$retryInFlowOrNull$2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
    
        if (r2.emit(r6, r5) == r1) goto L16;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f133854c
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r5.f133853b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L26
            if (r2 == r4) goto L1e
            if (r2 != r3) goto L16
            kotlin.ResultKt.b(r6)
            goto L4f
        L16:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1e:
            java.lang.Object r2 = r5.f133852a
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.b(r6)
            goto L3d
        L26:
            kotlin.ResultKt.b(r6)
            kotlin.jvm.functions.Function1 r6 = r5.f133855d
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r5.f133854c = r2
            r5.f133852a = r0
            r5.f133853b = r4
            java.lang.Object r6 = r6.invoke(r5)
            if (r6 != r1) goto L3c
            goto L4e
        L3c:
            r2 = r0
        L3d:
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r5.f133854c = r0
            r0 = 0
            r5.f133852a = r0
            r5.f133853b = r3
            java.lang.Object r6 = r2.emit(r6, r5)
            if (r6 != r1) goto L4f
        L4e:
            return r1
        L4f:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.statistics.util.StatisticsDatabaseExtKt$retryInFlowOrNull$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((StatisticsDatabaseExtKt$retryInFlowOrNull$2) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
