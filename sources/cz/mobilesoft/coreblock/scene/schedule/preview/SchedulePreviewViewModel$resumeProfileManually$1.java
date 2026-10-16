package cz.mobilesoft.coreblock.scene.schedule.preview;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$resumeProfileManually$1", f = "SchedulePreviewViewModel.kt", l = {534, 537, 556, 558, 562, 564}, m = "invokeSuspend", v = 1)
final class SchedulePreviewViewModel$resumeProfileManually$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f117512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f117513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f117514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f117515d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ SchedulePreviewViewModel f117516f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SchedulePreviewViewModel$resumeProfileManually$1(SchedulePreviewViewModel schedulePreviewViewModel, Continuation continuation) {
        super(1, continuation);
        this.f117516f = schedulePreviewViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new SchedulePreviewViewModel$resumeProfileManually$1(this.f117516f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a8, code lost:
    
        if (r14.P0(r1, r13) == r0) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011d A[PHI: r1 r3 r4
      0x011d: PHI (r1v19 int) = (r1v17 int), (r1v20 int) binds: [B:39:0x0119, B:8:0x0030] A[DONT_GENERATE, DONT_INLINE]
      0x011d: PHI (r3v6 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) = 
      (r3v3 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile)
      (r3v8 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile)
     binds: [B:39:0x0119, B:8:0x0030] A[DONT_GENERATE, DONT_INLINE]
      0x011d: PHI (r4v5 cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel) = 
      (r4v2 cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel)
      (r4v7 cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel)
     binds: [B:39:0x0119, B:8:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0145 A[PHI: r1 r3 r4 r10
      0x0145: PHI (r1v21 int) = (r1v19 int), (r1v23 int) binds: [B:42:0x0142, B:7:0x0020] A[DONT_GENERATE, DONT_INLINE]
      0x0145: PHI (r3v9 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) = 
      (r3v6 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile)
      (r3v12 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile)
     binds: [B:42:0x0142, B:7:0x0020] A[DONT_GENERATE, DONT_INLINE]
      0x0145: PHI (r4v8 cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel) = 
      (r4v5 cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel)
      (r4v10 cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel)
     binds: [B:42:0x0142, B:7:0x0020] A[DONT_GENERATE, DONT_INLINE]
      0x0145: PHI (r10v3 cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$resumeProfileManually$1) = 
      (r10v2 cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$resumeProfileManually$1)
      (r10v4 cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$resumeProfileManually$1)
     binds: [B:42:0x0142, B:7:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0172  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$resumeProfileManually$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((SchedulePreviewViewModel$resumeProfileManually$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
