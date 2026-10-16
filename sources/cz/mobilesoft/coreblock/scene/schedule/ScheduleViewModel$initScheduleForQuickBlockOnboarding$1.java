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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initScheduleForQuickBlockOnboarding$1", f = "ScheduleViewModel.kt", l = {463, 472}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$initScheduleForQuickBlockOnboarding$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f114698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f114699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ Object f114700d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114701f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$initScheduleForQuickBlockOnboarding$1(ScheduleViewModel scheduleViewModel, Continuation continuation) {
        super(2, continuation);
        this.f114701f = scheduleViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState q(ScheduleViewState scheduleViewState) {
        return ScheduleViewState.b(scheduleViewState, ScheduleViewState.DetailViewState.b(scheduleViewState.g(), new FailedWithError(null, null, null, null, 15, null), null, null, false, false, null, null, null, false, null, null, null, null, false, false, null, false, false, false, false, false, false, false, null, null, null, 67108862, null), null, false, null, false, false, false, false, null, null, null, null, null, false, null, null, null, 131070, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ScheduleViewModel$initScheduleForQuickBlockOnboarding$1 scheduleViewModel$initScheduleForQuickBlockOnboarding$1 = new ScheduleViewModel$initScheduleForQuickBlockOnboarding$1(this.f114701f, continuation);
        scheduleViewModel$initScheduleForQuickBlockOnboarding$1.f114700d = obj;
        return scheduleViewModel$initScheduleForQuickBlockOnboarding$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
    
        if (r3.x3(r13, r12) == r1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0081, code lost:
    
        if (r13.P0(r4, r12) == r1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0083, code lost:
    
        return r1;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = r12.f114700d
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r12.f114699c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L27
            if (r2 == r4) goto L1f
            if (r2 != r3) goto L17
            java.lang.Object r0 = r12.f114697a
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            goto L23
        L17:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1f:
            java.lang.Object r0 = r12.f114697a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r0 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r0
        L23:
            kotlin.ResultKt.b(r13)
            goto L84
        L27:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r13 = r12.f114701f
            cz.mobilesoft.coreblock.repository.QuickBlockRepository r13 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.Q1(r13)
            cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO r13 = r13.q()
            r2 = 0
            if (r13 == 0) goto L52
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r13 = r13.h()
            if (r13 == 0) goto L52
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r3 = r12.f114701f
            r12.f114700d = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
            r12.f114697a = r0
            r12.f114698b = r2
            r12.f114699c = r4
            java.lang.Object r13 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.g2(r3, r13, r12)
            if (r13 != r1) goto L84
            goto L83
        L52:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r13 = r12.f114701f
            cz.mobilesoft.coreblock.scene.schedule.q3 r4 = new cz.mobilesoft.coreblock.scene.schedule.q3
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
            r12.f114700d = r5
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r12.f114697a = r0
            r12.f114698b = r2
            r12.f114699c = r3
            java.lang.Object r13 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.w2(r13, r4, r12)
            if (r13 != r1) goto L84
        L83:
            return r1
        L84:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initScheduleForQuickBlockOnboarding$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$initScheduleForQuickBlockOnboarding$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
