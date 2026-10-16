package cz.mobilesoft.coreblock.scene.dashboard.blocking;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$resumeProfileManually$1", f = "BlockingScreenViewModel.kt", l = {1079, 1082, 1089, 1106, 1108, 1119}, m = "invokeSuspend", v = 1)
final class BlockingScreenViewModel$resumeProfileManually$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f99771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f99772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f99773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f99774d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f99775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewModel f99776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ long f99777h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingScreenViewModel$resumeProfileManually$1(BlockingScreenViewModel blockingScreenViewModel, long j3, Continuation continuation) {
        super(1, continuation);
        this.f99776g = blockingScreenViewModel;
        this.f99777h = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BlockingScreenViewModel$resumeProfileManually$1(this.f99776g, this.f99777h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a3, code lost:
    
        if (r5.P0(r11, r10) == r0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00cd, code lost:
    
        if (r5.P0(r11, r10) == r0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0164, code lost:
    
        if (cz.mobilesoft.coreblock.scene.streaks.StreakPauseTracker.h(r2, r3, 0, r10, 2, null) != r0) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0118 A[PHI: r1 r2 r4 r5
      0x0118: PHI (r1v7 int) = (r1v4 int), (r1v8 int) binds: [B:41:0x0115, B:9:0x002d] A[DONT_GENERATE, DONT_INLINE]
      0x0118: PHI (r2v6 long) = (r2v3 long), (r2v7 long) binds: [B:41:0x0115, B:9:0x002d] A[DONT_GENERATE, DONT_INLINE]
      0x0118: PHI (r4v6 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) = 
      (r4v2 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile)
      (r4v8 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile)
     binds: [B:41:0x0115, B:9:0x002d] A[DONT_GENERATE, DONT_INLINE]
      0x0118: PHI (r5v5 cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel) = 
      (r5v1 cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel)
      (r5v7 cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel)
     binds: [B:41:0x0115, B:9:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029 A[PHI: r1 r2 r4 r5
      0x0029: PHI (r1v9 int) = (r1v7 int), (r1v10 int) binds: [B:44:0x012b, B:7:0x001a] A[DONT_GENERATE, DONT_INLINE]
      0x0029: PHI (r2v8 long) = (r2v6 long), (r2v13 long) binds: [B:44:0x012b, B:7:0x001a] A[DONT_GENERATE, DONT_INLINE]
      0x0029: PHI (r4v9 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) = 
      (r4v6 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile)
      (r4v11 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile)
     binds: [B:44:0x012b, B:7:0x001a] A[DONT_GENERATE, DONT_INLINE]
      0x0029: PHI (r5v8 cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel) = 
      (r5v5 cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel)
      (r5v11 cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel)
     binds: [B:44:0x012b, B:7:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$resumeProfileManually$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BlockingScreenViewModel$resumeProfileManually$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
