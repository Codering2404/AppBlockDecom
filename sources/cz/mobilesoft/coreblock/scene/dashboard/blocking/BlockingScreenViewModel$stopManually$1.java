package cz.mobilesoft.coreblock.scene.dashboard.blocking;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$stopManually$1", f = "BlockingScreenViewModel.kt", l = {760, 762, 767, 771}, m = "invokeSuspend", v = 1)
final class BlockingScreenViewModel$stopManually$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f99864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f99865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewModel f99866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ProfileViewDTO f99867d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingScreenViewModel$stopManually$1(BlockingScreenViewModel blockingScreenViewModel, ProfileViewDTO profileViewDTO, Continuation continuation) {
        super(2, continuation);
        this.f99866c = blockingScreenViewModel;
        this.f99867d = profileViewDTO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingScreenViewModel$stopManually$1(this.f99866c, this.f99867d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a4, code lost:
    
        if (cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.y(r3, r4, 0, r11, 2, null) != r0) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0084 A[PHI: r1
      0x0084: PHI (r1v6 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) = 
      (r1v5 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile)
      (r1v10 cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile)
     binds: [B:26:0x0081, B:11:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.f99865b
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L39
            if (r1 == r5) goto L35
            if (r1 == r4) goto L2d
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r0 = r11.f99864a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r0 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r0
            kotlin.ResultKt.b(r12)
            goto La7
        L1d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L25:
            java.lang.Object r1 = r11.f99864a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r1 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r1
            kotlin.ResultKt.b(r12)
            goto L84
        L2d:
            java.lang.Object r1 = r11.f99864a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r1 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r1
            kotlin.ResultKt.b(r12)
            goto L66
        L35:
            kotlin.ResultKt.b(r12)
            goto L51
        L39:
            kotlin.ResultKt.b(r12)
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r12 = r11.f99866c
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r12 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.n1(r12)
            cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r1 = r11.f99867d
            long r6 = r1.k()
            r11.f99865b = r5
            java.lang.Object r12 = r12.e(r6, r11)
            if (r12 != r0) goto L51
            goto La6
        L51:
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r12 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r12
            if (r12 != 0) goto L58
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        L58:
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r1 = r11.f99866c
            r11.f99864a = r12
            r11.f99865b = r4
            java.lang.Object r1 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.A1(r1, r12, r11)
            if (r1 != r0) goto L65
            goto La6
        L65:
            r1 = r12
        L66:
            r4 = 0
            r1.m0(r4)
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r1.h0(r4)
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r12 = r11.f99866c
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r12 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.n1(r12)
            r11.f99864a = r1
            r11.f99865b = r3
            java.lang.Object r12 = r12.p(r1, r11)
            if (r12 != r0) goto L84
            goto La6
        L84:
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r12 = r11.f99866c
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.E1(r12)
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r12 = r11.f99866c
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker r3 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.q1(r12)
            long r4 = r1.r()
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r11.f99864a = r12
            r11.f99865b = r2
            r6 = 0
            r9 = 2
            r10 = 0
            r8 = r11
            java.lang.Object r12 = cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.y(r3, r4, r6, r8, r9, r10)
            if (r12 != r0) goto La7
        La6:
            return r0
        La7:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$stopManually$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingScreenViewModel$stopManually$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
