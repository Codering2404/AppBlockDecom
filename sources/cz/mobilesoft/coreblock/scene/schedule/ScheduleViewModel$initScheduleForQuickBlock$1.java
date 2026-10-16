package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.util.FailedWithError;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initScheduleForQuickBlock$1", f = "ScheduleViewModel.kt", l = {436, 439, 448}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$initScheduleForQuickBlock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f114691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f114692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f114693d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Object f114694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f114696h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$initScheduleForQuickBlock$1(ScheduleViewModel scheduleViewModel, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f114695g = scheduleViewModel;
        this.f114696h = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState q(ScheduleViewState scheduleViewState) {
        return ScheduleViewState.b(scheduleViewState, ScheduleViewState.DetailViewState.b(scheduleViewState.g(), new FailedWithError(null, null, null, null, 15, null), null, null, false, false, null, null, null, false, null, null, null, null, false, false, null, false, false, false, false, false, false, false, null, null, null, 67108862, null), null, false, null, false, false, false, false, null, null, null, null, null, false, null, null, null, 131070, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ScheduleViewModel$initScheduleForQuickBlock$1 scheduleViewModel$initScheduleForQuickBlock$1 = new ScheduleViewModel$initScheduleForQuickBlock$1(this.f114695g, this.f114696h, continuation);
        scheduleViewModel$initScheduleForQuickBlock$1.f114694f = obj;
        return scheduleViewModel$initScheduleForQuickBlock$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0086, code lost:
    
        if (r3.x3(r13, r12) == r1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b8, code lost:
    
        if (r13.P0(r4, r12) == r1) goto L29;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = r12.f114694f
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r12.f114693d
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L39
            if (r2 == r5) goto L2b
            if (r2 == r4) goto L22
            if (r2 != r3) goto L1a
            java.lang.Object r0 = r12.f114690a
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            goto L26
        L1a:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L22:
            java.lang.Object r0 = r12.f114690a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r0 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r0
        L26:
            kotlin.ResultKt.b(r13)
            goto Lbb
        L2b:
            int r2 = r12.f114692c
            java.lang.Object r3 = r12.f114691b
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r3 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r3
            java.lang.Object r5 = r12.f114690a
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r5 = (cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel) r5
            kotlin.ResultKt.b(r13)
            goto L71
        L39:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r13 = r12.f114695g
            cz.mobilesoft.coreblock.repository.QuickBlockRepository r13 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.Q1(r13)
            cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO r13 = r13.q()
            r2 = 0
            if (r13 == 0) goto L89
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r13 = r13.h()
            if (r13 == 0) goto L89
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r3 = r12.f114695g
            boolean r6 = r12.f114696h
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.C2(r3, r6)
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile$BlockingMode r6 = r13.o()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile$BlockingMode r7 = cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile.BlockingMode.Blocklist
            if (r6 != r7) goto L73
            r12.f114694f = r0
            r12.f114690a = r3
            r12.f114691b = r13
            r12.f114692c = r2
            r12.f114693d = r5
            java.lang.Object r5 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.f2(r3, r12)
            if (r5 != r1) goto L6f
            goto Lba
        L6f:
            r5 = r3
            r3 = r13
        L71:
            r13 = r3
            r3 = r5
        L73:
            r12.f114694f = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
            r12.f114690a = r0
            r0 = 0
            r12.f114691b = r0
            r12.f114692c = r2
            r12.f114693d = r4
            java.lang.Object r13 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.g2(r3, r13, r12)
            if (r13 != r1) goto Lbb
            goto Lba
        L89:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r13 = r12.f114695g
            cz.mobilesoft.coreblock.scene.schedule.p3 r4 = new cz.mobilesoft.coreblock.scene.schedule.p3
            r4.<init>()
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.I2(r13, r4)
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$CloseScreen r4 = new cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$CloseScreen
            cz.mobilesoft.coreblock.scene.schedule.ScheduleResult r5 = new cz.mobilesoft.coreblock.scene.schedule.ScheduleResult
            r10 = 15
            r11 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r4.<init>(r5)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r12.f114694f = r5
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r12.f114690a = r0
            r12.f114692c = r2
            r12.f114693d = r3
            java.lang.Object r13 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.w2(r13, r4, r12)
            if (r13 != r1) goto Lbb
        Lba:
            return r1
        Lbb:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initScheduleForQuickBlock$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$initScheduleForQuickBlock$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
