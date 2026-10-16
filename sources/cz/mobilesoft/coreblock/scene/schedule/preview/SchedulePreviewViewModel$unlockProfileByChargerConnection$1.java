package cz.mobilesoft.coreblock.scene.schedule.preview;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$unlockProfileByChargerConnection$1", f = "SchedulePreviewViewModel.kt", l = {377, 382}, m = "invokeSuspend", v = 1)
final class SchedulePreviewViewModel$unlockProfileByChargerConnection$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f117566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f117567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SchedulePreviewViewModel f117568c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SchedulePreviewViewModel$unlockProfileByChargerConnection$1(SchedulePreviewViewModel schedulePreviewViewModel, Continuation continuation) {
        super(2, continuation);
        this.f117568c = schedulePreviewViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SchedulePreviewViewModel$unlockProfileByChargerConnection$1(this.f117568c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0064, code lost:
    
        if (r1.p(r7, r6) == r0) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f117567b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r6.f117566a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r0 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r0
            kotlin.ResultKt.b(r7)
            goto L67
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1e:
            kotlin.ResultKt.b(r7)
            goto L3e
        L22:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel r7 = r6.f117568c
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r7 = cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.a1(r7)
            cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel r1 = r6.f117568c
            cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r1 = cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.b1(r1)
            long r4 = r1.k()
            r6.f117567b = r3
            java.lang.Object r7 = r7.e(r4, r6)
            if (r7 != r0) goto L3e
            goto L66
        L3e:
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r7 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r7
            if (r7 != 0) goto L45
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L45:
            boolean r1 = r7.L()
            if (r1 != 0) goto L4e
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L4e:
            r1 = 0
            r7.j0(r1)
            cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel r1 = r6.f117568c
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r1 = cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.a1(r1)
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r6.f117566a = r3
            r6.f117567b = r2
            java.lang.Object r7 = r1.p(r7, r6)
            if (r7 != r0) goto L67
        L66:
            return r0
        L67:
            cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel r7 = r6.f117568c
            cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.n1(r7)
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$unlockProfileByChargerConnection$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SchedulePreviewViewModel$unlockProfileByChargerConnection$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
