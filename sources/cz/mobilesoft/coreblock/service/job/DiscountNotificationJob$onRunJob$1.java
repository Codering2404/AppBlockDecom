package cz.mobilesoft.coreblock.service.job;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.job.DiscountNotificationJob$onRunJob$1", f = "DiscountNotificationJob.kt", l = {217, 51, 52, 53, 54, 70, 76, 86, 87}, m = "invokeSuspend", v = 1)
final class DiscountNotificationJob$onRunJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f123262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f123263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f123264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f123265d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f123266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f123267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f123268h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f123269i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f123270j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f123271k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f123272l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ DiscountNotificationJob f123273m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DiscountNotificationJob$onRunJob$1(DiscountNotificationJob discountNotificationJob, Continuation continuation) {
        super(2, continuation);
        this.f123273m = discountNotificationJob;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DiscountNotificationJob$onRunJob$1(this.f123273m, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x024a, code lost:
    
        if (r6.G1(r9, r18) == r0) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x024e, code lost:
    
        r14 = r2;
        r2 = r14;
        r15 = r13;
        r13 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0275, code lost:
    
        if (r6.R1(r9, r18) == r0) goto L101;
     */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x00c6: MOVE (r9 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]) (LINE:199), block:B:30:0x00c5 */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0060: MOVE (r9 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]) (LINE:97), block:B:17:0x005f */
    /* JADX WARN: Removed duplicated region for block: B:108:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0331 A[Catch: all -> 0x032e, TRY_ENTER, TryCatch #9 {all -> 0x032e, blocks: (B:119:0x0336, B:99:0x02d7, B:118:0x0331, B:42:0x0121), top: B:141:0x0121 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01c1 A[Catch: all -> 0x0349, PHI: r2 r3 r4 r8 r10 r11 r12 r13
      0x01c1: PHI (r2v21 int) = (r2v16 int), (r2v23 int) binds: [B:65:0x01bd, B:28:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x01c1: PHI (r3v5 int) = (r3v2 int), (r3v7 int) binds: [B:65:0x01bd, B:28:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x01c1: PHI (r4v3 int) = (r4v1 int), (r4v5 int) binds: [B:65:0x01bd, B:28:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x01c1: PHI (r8v11 long) = (r8v8 long), (r8v13 long) binds: [B:65:0x01bd, B:28:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x01c1: PHI (r10v12 int) = (r10v8 int), (r10v13 int) binds: [B:65:0x01bd, B:28:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x01c1: PHI (r11v11 cz.mobilesoft.coreblock.service.job.DiscountNotificationJob) = 
      (r11v7 cz.mobilesoft.coreblock.service.job.DiscountNotificationJob)
      (r11v14 cz.mobilesoft.coreblock.service.job.DiscountNotificationJob)
     binds: [B:65:0x01bd, B:28:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x01c1: PHI (r12v21 java.lang.Object) = (r12v16 java.lang.Object), (r12v27 java.lang.Object) binds: [B:65:0x01bd, B:28:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x01c1: PHI (r13v13 kotlinx.coroutines.sync.Mutex) = (r13v8 kotlinx.coroutines.sync.Mutex), (r13v14 kotlinx.coroutines.sync.Mutex) binds: [B:65:0x01bd, B:28:0x00bf] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {all -> 0x0349, blocks: (B:71:0x01f3, B:75:0x01fe, B:84:0x0254, B:67:0x01c1, B:64:0x01a4), top: B:132:0x01a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0254 A[Catch: all -> 0x0349, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0349, blocks: (B:71:0x01f3, B:75:0x01fe, B:84:0x0254, B:67:0x01c1, B:64:0x01a4), top: B:132:0x01a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02a1 A[Catch: all -> 0x02ad, TRY_LEAVE, TryCatch #7 {all -> 0x02ad, blocks: (B:87:0x0279, B:89:0x02a1, B:95:0x02b2), top: B:140:0x0279 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02b2 A[Catch: all -> 0x02ad, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x02ad, blocks: (B:87:0x0279, B:89:0x02a1, B:95:0x02b2), top: B:140:0x0279 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02d7 A[Catch: all -> 0x032e, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x032e, blocks: (B:119:0x0336, B:99:0x02d7, B:118:0x0331, B:42:0x0121), top: B:141:0x0121 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 878
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.job.DiscountNotificationJob$onRunJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DiscountNotificationJob$onRunJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
