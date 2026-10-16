package cz.mobilesoft.coreblock.scene.dashboard.blocking.pause;

import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$pauseProfile$1", f = "PauseBlockingViewModel.kt", l = {236, 238, 240, 255, 261, 266, 272, 284, 288}, m = "invokeSuspend", v = 1)
final class PauseBlockingViewModel$pauseProfile$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f100146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f100147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f100148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f100149d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f100150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f100151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f100152h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f100153i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f100154j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ PauseBlockingViewModel f100155k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ PauseBlockingViewState.PauseBlockingType f100156l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ Profile.PausedUntil f100157m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PauseBlockingViewModel$pauseProfile$1(PauseBlockingViewModel pauseBlockingViewModel, PauseBlockingViewState.PauseBlockingType pauseBlockingType, Profile.PausedUntil pausedUntil, Continuation continuation) {
        super(1, continuation);
        this.f100155k = pauseBlockingViewModel;
        this.f100156l = pauseBlockingType;
        this.f100157m = pausedUntil;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new PauseBlockingViewModel$pauseProfile$1(this.f100155k, this.f100156l, this.f100157m, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0302, code lost:
    
        if (r0.P0(r1, r4) != r9) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0122 A[PHI: r0 r1
      0x0122: PHI (r0v8 java.lang.Boolean) = (r0v6 java.lang.Boolean), (r0v58 java.lang.Boolean) binds: [B:34:0x011e, B:17:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x0122: PHI (r1v5 java.lang.Object) = (r1v4 java.lang.Object), (r1v37 java.lang.Object) binds: [B:34:0x011e, B:17:0x00b5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0202 A[PHI: r3 r4 r12 r13 r14 r15
      0x0202: PHI (r3v6 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile$PausedUntil) = 
      (r3v4 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile$PausedUntil)
      (r3v21 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile$PausedUntil)
     binds: [B:54:0x01fe, B:14:0x0064] A[DONT_GENERATE, DONT_INLINE]
      0x0202: PHI (r4v3 cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$pauseProfile$1) = 
      (r4v2 cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$pauseProfile$1)
      (r4v0 cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$pauseProfile$1)
     binds: [B:54:0x01fe, B:14:0x0064] A[DONT_GENERATE, DONT_INLINE]
      0x0202: PHI (r12v7 int) = (r12v6 int), (r12v11 int) binds: [B:54:0x01fe, B:14:0x0064] A[DONT_GENERATE, DONT_INLINE]
      0x0202: PHI (r13v4 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) = 
      (r13v3 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile)
      (r13v7 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile)
     binds: [B:54:0x01fe, B:14:0x0064] A[DONT_GENERATE, DONT_INLINE]
      0x0202: PHI (r14v3 cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel) = 
      (r14v1 cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel)
      (r14v7 cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel)
     binds: [B:54:0x01fe, B:14:0x0064] A[DONT_GENERATE, DONT_INLINE]
      0x0202: PHI (r15v4 java.lang.Boolean) = (r15v2 java.lang.Boolean), (r15v8 java.lang.Boolean) binds: [B:54:0x01fe, B:14:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0236 A[PHI: r4 r12 r13 r14 r15
      0x0236: PHI (r4v5 cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$pauseProfile$1) = 
      (r4v3 cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$pauseProfile$1)
      (r4v6 cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$pauseProfile$1)
     binds: [B:57:0x0204, B:62:0x0232] A[DONT_GENERATE, DONT_INLINE]
      0x0236: PHI (r12v8 int) = (r12v7 int), (r12v9 int) binds: [B:57:0x0204, B:62:0x0232] A[DONT_GENERATE, DONT_INLINE]
      0x0236: PHI (r13v5 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) = 
      (r13v4 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile)
      (r13v6 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile)
     binds: [B:57:0x0204, B:62:0x0232] A[DONT_GENERATE, DONT_INLINE]
      0x0236: PHI (r14v4 cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel) = 
      (r14v3 cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel)
      (r14v5 cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel)
     binds: [B:57:0x0204, B:62:0x0232] A[DONT_GENERATE, DONT_INLINE]
      0x0236: PHI (r15v5 java.lang.Boolean) = (r15v4 java.lang.Boolean), (r15v6 java.lang.Boolean) binds: [B:57:0x0204, B:62:0x0232] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0259 A[PHI: r0 r4
      0x0259: PHI (r0v23 java.lang.Boolean) = (r0v8 java.lang.Boolean), (r0v21 java.lang.Boolean), (r0v66 java.lang.Boolean) binds: [B:37:0x0124, B:66:0x0258, B:12:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x0259: PHI (r4v7 cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$pauseProfile$1) = 
      (r4v0 cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$pauseProfile$1)
      (r4v5 cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$pauseProfile$1)
      (r4v0 cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$pauseProfile$1)
     binds: [B:37:0x0124, B:66:0x0258, B:12:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02cf  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 800
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewModel$pauseProfile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((PauseBlockingViewModel$pauseProfile$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
