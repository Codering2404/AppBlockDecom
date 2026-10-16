package cz.mobilesoft.coreblock.scene.schedule;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onEvent$10", f = "ScheduleViewModel.kt", l = {1008, 1010, 1013, 1014, 1022}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onEvent$10 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f114792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f114793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f114794d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f114795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f114796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ScheduleViewEvent f114797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114798i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onEvent$10(ScheduleViewEvent scheduleViewEvent, ScheduleViewModel scheduleViewModel, Continuation continuation) {
        super(1, continuation);
        this.f114797h = scheduleViewEvent;
        this.f114798i = scheduleViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ScheduleViewModel$onEvent$10(this.f114797h, this.f114798i, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ac, code lost:
    
        if (r12.p(r15, r14) == r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0145, code lost:
    
        if (r15.P0(r1, r14) == r0) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cb A[PHI: r1 r2 r9 r15
      0x00cb: PHI (r1v5 int) = (r1v4 int), (r1v9 int) binds: [B:31:0x00c7, B:13:0x002f] A[DONT_GENERATE, DONT_INLINE]
      0x00cb: PHI (r2v3 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel) = 
      (r2v2 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel)
      (r2v11 cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel)
     binds: [B:31:0x00c7, B:13:0x002f] A[DONT_GENERATE, DONT_INLINE]
      0x00cb: PHI (r9v3 long) = (r9v2 long), (r9v6 long) binds: [B:31:0x00c7, B:13:0x002f] A[DONT_GENERATE, DONT_INLINE]
      0x00cb: PHI (r15v15 java.lang.Object) = (r15v14 java.lang.Object), (r15v0 java.lang.Object) binds: [B:31:0x00c7, B:13:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0148  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onEvent$10.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((ScheduleViewModel$onEvent$10) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
