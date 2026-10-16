package cz.mobilesoft.coreblock.scene.schedule;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initScheduleForEdit$1", f = "ScheduleViewModel.kt", l = {303, RCHTTPStatusCodes.NOT_MODIFIED, 307, 318}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$initScheduleForEdit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f114672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f114673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f114674d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Object f114675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ long f114677h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$initScheduleForEdit$1(ScheduleViewModel scheduleViewModel, long j3, Continuation continuation) {
        super(2, continuation);
        this.f114676g = scheduleViewModel;
        this.f114677h = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState q(ScheduleViewState scheduleViewState) {
        return ScheduleViewState.b(scheduleViewState, ScheduleViewState.DetailViewState.b(scheduleViewState.g(), new FailedWithError(null, null, null, null, 15, null), null, null, false, false, null, null, null, false, null, null, null, null, false, false, null, false, false, false, false, false, false, false, null, null, null, 67108862, null), null, false, null, false, false, false, false, null, null, null, null, null, false, null, null, null, 131070, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ScheduleViewModel$initScheduleForEdit$1 scheduleViewModel$initScheduleForEdit$1 = new ScheduleViewModel$initScheduleForEdit$1(this.f114676g, this.f114677h, continuation);
        scheduleViewModel$initScheduleForEdit$1.f114675f = obj;
        return scheduleViewModel$initScheduleForEdit$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x008b, code lost:
    
        if (r6.v3(r13) == r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bf, code lost:
    
        if (r14.P0(r5, r13) == r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.lang.Object r0 = r13.f114675f
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r13.f114674d
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L41
            if (r2 == r7) goto L3d
            if (r2 == r6) goto L2f
            if (r2 == r5) goto L26
            if (r2 != r4) goto L1e
            java.lang.Object r0 = r13.f114671a
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            goto L2a
        L1e:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L26:
            java.lang.Object r0 = r13.f114671a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r0 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r0
        L2a:
            kotlin.ResultKt.b(r14)
            goto Lc2
        L2f:
            int r2 = r13.f114673c
            java.lang.Object r4 = r13.f114672b
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r4 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r4
            java.lang.Object r6 = r13.f114671a
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r6 = (cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel) r6
            kotlin.ResultKt.b(r14)
            goto L71
        L3d:
            kotlin.ResultKt.b(r14)
            goto L57
        L41:
            kotlin.ResultKt.b(r14)
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r14 = r13.f114676g
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r14 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.O1(r14)
            long r8 = r13.f114677h
            r13.f114675f = r0
            r13.f114674d = r7
            java.lang.Object r14 = r14.e(r8, r13)
            if (r14 != r1) goto L57
            goto Lc1
        L57:
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r14 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r14
            r2 = 0
            if (r14 == 0) goto L8e
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r4 = r13.f114676g
            r13.f114675f = r0
            r13.f114671a = r4
            r13.f114672b = r14
            r13.f114673c = r2
            r13.f114674d = r6
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.g2(r4, r14, r13)
            if (r6 != r1) goto L6f
            goto Lc1
        L6f:
            r6 = r4
            r4 = r14
        L71:
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile$BlockingMode r14 = r4.o()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile$BlockingMode r7 = cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile.BlockingMode.Blocklist
            if (r14 != r7) goto Lc2
            r13.f114675f = r0
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
            r13.f114671a = r14
            r13.f114672b = r3
            r13.f114673c = r2
            r13.f114674d = r5
            java.lang.Object r14 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.f2(r6, r13)
            if (r14 != r1) goto Lc2
            goto Lc1
        L8e:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r14 = r13.f114676g
            cz.mobilesoft.coreblock.scene.schedule.n3 r5 = new cz.mobilesoft.coreblock.scene.schedule.n3
            r5.<init>()
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.I2(r14, r5)
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$CloseScreen r5 = new cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$CloseScreen
            cz.mobilesoft.coreblock.scene.schedule.ScheduleResult r6 = new cz.mobilesoft.coreblock.scene.schedule.ScheduleResult
            r11 = 15
            r12 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r5.<init>(r6)
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r13.f114675f = r6
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r13.f114671a = r0
            r13.f114672b = r3
            r13.f114673c = r2
            r13.f114674d = r4
            java.lang.Object r14 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.w2(r14, r5, r13)
            if (r14 != r1) goto Lc2
        Lc1:
            return r1
        Lc2:
            kotlin.Unit r14 = kotlin.Unit.f139807a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initScheduleForEdit$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$initScheduleForEdit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
