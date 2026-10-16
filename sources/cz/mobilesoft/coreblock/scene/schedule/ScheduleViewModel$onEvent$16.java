package cz.mobilesoft.coreblock.scene.schedule;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onEvent$16", f = "ScheduleViewModel.kt", l = {1071, 1072, 1075}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onEvent$16 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f114817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f114818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f114819d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f114820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114821g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onEvent$16(ScheduleViewModel scheduleViewModel, Continuation continuation) {
        super(2, continuation);
        this.f114821g = scheduleViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$onEvent$16(this.f114821g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0089, code lost:
    
        if (r11.P0(r1, r10) != r0) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.f114820f
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L33
            if (r1 == r5) goto L27
            if (r1 == r4) goto L1f
            if (r1 != r3) goto L17
            kotlin.ResultKt.b(r11)
            goto L8c
        L17:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1f:
            java.lang.Object r1 = r10.f114816a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r1 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r1
            kotlin.ResultKt.b(r11)
            goto L7c
        L27:
            int r1 = r10.f114818c
            long r5 = r10.f114817b
            java.lang.Object r7 = r10.f114816a
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r7 = (cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel) r7
            kotlin.ResultKt.b(r11)
            goto L5d
        L33:
            kotlin.ResultKt.b(r11)
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r11 = r10.f114821g
            cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r11 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.p1(r11)
            java.lang.Long r11 = r11.o()
            if (r11 == 0) goto L7c
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r7 = r10.f114821g
            long r8 = r11.longValue()
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r11 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.O1(r7)
            r10.f114816a = r7
            r10.f114817b = r8
            r10.f114818c = r2
            r10.f114820f = r5
            java.lang.Object r11 = r11.e(r8, r10)
            if (r11 != r0) goto L5b
            goto L8b
        L5b:
            r1 = r2
            r5 = r8
        L5d:
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r11 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r11
            if (r11 == 0) goto L7c
            cz.mobilesoft.coreblock.repository.ScheduleRepository r8 = cz.mobilesoft.coreblock.repository.ScheduleRepository.f97962a
            android.content.Context r7 = r7.A0()
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r10.f114816a = r9
            r10.f114817b = r5
            r10.f114818c = r1
            r10.f114819d = r2
            r10.f114820f = r4
            java.lang.Object r11 = r8.u(r7, r11, r10)
            if (r11 != r0) goto L7c
            goto L8b
        L7c:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r11 = r10.f114821g
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$FinishActivity r1 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand.FinishActivity.f114503a
            r2 = 0
            r10.f114816a = r2
            r10.f114820f = r3
            java.lang.Object r11 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.w2(r11, r1, r10)
            if (r11 != r0) goto L8c
        L8b:
            return r0
        L8c:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onEvent$16.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$onEvent$16) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
