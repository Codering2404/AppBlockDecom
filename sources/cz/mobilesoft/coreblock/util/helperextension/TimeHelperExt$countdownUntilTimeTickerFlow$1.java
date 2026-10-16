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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt$countdownUntilTimeTickerFlow$1", f = "TimeHelperExt.kt", l = {243, 249, 252}, m = "invokeSuspend", v = 1)
final class TimeHelperExt$countdownUntilTimeTickerFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Long>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f128670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f128671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f128672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f128673d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f128674f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimeHelperExt$countdownUntilTimeTickerFlow$1(long j3, long j4, Continuation continuation) {
        super(2, continuation);
        this.f128673d = j3;
        this.f128674f = j4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TimeHelperExt$countdownUntilTimeTickerFlow$1 timeHelperExt$countdownUntilTimeTickerFlow$1 = new TimeHelperExt$countdownUntilTimeTickerFlow$1(this.f128673d, this.f128674f, continuation);
        timeHelperExt$countdownUntilTimeTickerFlow$1.f128672c = obj;
        return timeHelperExt$countdownUntilTimeTickerFlow$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
    
        if (r0.emit(null, r12) == r1) goto L28;
     */
    /* JADX WARN: Path cross not found for [B:4:0x0011, B:12:0x002d], limit reached: 29 */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0084 -> B:19:0x004e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = r12.f128672c
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r12.f128671b
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L2d
            if (r2 == r5) goto L29
            if (r2 == r4) goto L23
            if (r2 != r3) goto L1b
            kotlin.ResultKt.b(r13)
            goto L4e
        L1b:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L23:
            long r8 = r12.f128670a
            kotlin.ResultKt.b(r13)
            goto L74
        L29:
            kotlin.ResultKt.b(r13)
            goto L4b
        L2d:
            kotlin.ResultKt.b(r13)
            long r8 = r12.f128673d
            long r10 = java.lang.System.currentTimeMillis()
            long r8 = r8 - r10
            int r13 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r13 >= 0) goto L4e
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r12.f128672c = r13
            r12.f128671b = r5
            r13 = 0
            java.lang.Object r13 = r0.emit(r13, r12)
            if (r13 != r1) goto L4b
            goto L86
        L4b:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        L4e:
            kotlin.coroutines.CoroutineContext r13 = r12.getContext()
            boolean r13 = kotlinx.coroutines.JobKt.p(r13)
            if (r13 == 0) goto L87
            long r8 = r12.f128673d
            long r10 = java.lang.System.currentTimeMillis()
            long r8 = r8 - r10
            long r8 = kotlin.ranges.RangesKt.g(r8, r6)
            java.lang.Long r13 = kotlin.coroutines.jvm.internal.Boxing.e(r8)
            r12.f128672c = r0
            r12.f128670a = r8
            r12.f128671b = r4
            java.lang.Object r13 = r0.emit(r13, r12)
            if (r13 != r1) goto L74
            goto L86
        L74:
            int r13 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r13 == 0) goto L87
            long r10 = r12.f128674f
            r12.f128672c = r0
            r12.f128670a = r8
            r12.f128671b = r3
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.b(r10, r12)
            if (r13 != r1) goto L4e
        L86:
            return r1
        L87:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt$countdownUntilTimeTickerFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((TimeHelperExt$countdownUntilTimeTickerFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
