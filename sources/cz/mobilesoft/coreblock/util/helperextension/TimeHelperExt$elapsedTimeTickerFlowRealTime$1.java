package cz.mobilesoft.coreblock.util.helperextension;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt$elapsedTimeTickerFlowRealTime$1", f = "TimeHelperExt.kt", l = {283, 287}, m = "invokeSuspend", v = 1)
final class TimeHelperExt$elapsedTimeTickerFlowRealTime$1 extends SuspendLambda implements Function2<FlowCollector<? super Long>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f128680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f128681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f128682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f128683d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Object f128684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ long f128685g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ long f128686h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimeHelperExt$elapsedTimeTickerFlowRealTime$1(long j3, long j4, Continuation continuation) {
        super(2, continuation);
        this.f128685g = j3;
        this.f128686h = j4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TimeHelperExt$elapsedTimeTickerFlowRealTime$1 timeHelperExt$elapsedTimeTickerFlowRealTime$1 = new TimeHelperExt$elapsedTimeTickerFlowRealTime$1(this.f128685g, this.f128686h, continuation);
        timeHelperExt$elapsedTimeTickerFlowRealTime$1.f128684f = obj;
        return timeHelperExt$elapsedTimeTickerFlowRealTime$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x006d -> B:12:0x002f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.lang.Object r0 = r13.f128684f
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r13.f128683d
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L26
            if (r2 == r4) goto L20
            if (r2 != r3) goto L18
            kotlin.ResultKt.b(r14)
            goto L2f
        L18:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L20:
            long r7 = r13.f128680a
            kotlin.ResultKt.b(r14)
            goto L55
        L26:
            kotlin.ResultKt.b(r14)
            long r7 = r13.f128685g
            int r14 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r14 <= 0) goto L73
        L2f:
            kotlin.coroutines.CoroutineContext r14 = r13.getContext()
            boolean r14 = kotlinx.coroutines.JobKt.p(r14)
            if (r14 == 0) goto L70
            long r7 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.c()
            long r9 = r13.f128686h
            long r7 = r7 - r9
            long r7 = kotlin.ranges.RangesKt.g(r7, r5)
            java.lang.Long r14 = kotlin.coroutines.jvm.internal.Boxing.e(r7)
            r13.f128684f = r0
            r13.f128680a = r7
            r13.f128683d = r4
            java.lang.Object r14 = r0.emit(r14, r13)
            if (r14 != r1) goto L55
            goto L6f
        L55:
            long r9 = r13.f128685g
            long r11 = r7 % r9
            int r14 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r14 != 0) goto L5e
            goto L5f
        L5e:
            long r9 = r9 - r11
        L5f:
            r13.f128684f = r0
            r13.f128680a = r7
            r13.f128681b = r11
            r13.f128682c = r9
            r13.f128683d = r3
            java.lang.Object r14 = kotlinx.coroutines.DelayKt.b(r9, r13)
            if (r14 != r1) goto L2f
        L6f:
            return r1
        L70:
            kotlin.Unit r14 = kotlin.Unit.f139807a
            return r14
        L73:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "frequency must be > 0"
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt$elapsedTimeTickerFlowRealTime$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((TimeHelperExt$elapsedTimeTickerFlowRealTime$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
