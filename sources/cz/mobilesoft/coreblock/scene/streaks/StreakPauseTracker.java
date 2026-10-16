package cz.mobilesoft.coreblock.scene.streaks;

import cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

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
public final class StreakPauseTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StreakPauseRecordDao f120389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StreakAvailability f120390b;

    public StreakPauseTracker(StreakPauseRecordDao pauseRecordDao, StreakAvailability availability) {
        Intrinsics.checkNotNullParameter(pauseRecordDao, "pauseRecordDao");
        Intrinsics.checkNotNullParameter(availability, "availability");
        this.f120389a = pauseRecordDao;
        this.f120390b = availability;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007b, code lost:
    
        if (r1.J(r2, r7, r6) == r0) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(long r10, long r12, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r14 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakPauseTracker$closeOpenRecord$1
            if (r0 == 0) goto L14
            r0 = r14
            cz.mobilesoft.coreblock.scene.streaks.StreakPauseTracker$closeOpenRecord$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakPauseTracker$closeOpenRecord$1) r0
            int r1 = r0.f120396g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f120396g = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.scene.streaks.StreakPauseTracker$closeOpenRecord$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakPauseTracker$closeOpenRecord$1
            r0.<init>(r9, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.f120394d
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f120396g
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L42
            if (r1 == r3) goto L3a
            if (r1 != r2) goto L32
            java.lang.Object r10 = r6.f120393c
            cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakPauseRecordEntity r10 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakPauseRecordEntity) r10
            kotlin.ResultKt.b(r14)
            goto L7e
        L32:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3a:
            long r12 = r6.f120392b
            long r10 = r6.f120391a
            kotlin.ResultKt.b(r14)
            goto L54
        L42:
            kotlin.ResultKt.b(r14)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao r14 = r9.f120389a
            r6.f120391a = r10
            r6.f120392b = r12
            r6.f120396g = r3
            java.lang.Object r14 = r14.L(r10, r6)
            if (r14 != r0) goto L54
            goto L7d
        L54:
            cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakPauseRecordEntity r14 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakPauseRecordEntity) r14
            if (r14 != 0) goto L5b
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        L5b:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao r1 = r9.f120389a
            r4 = r2
            long r2 = r14.d()
            long r7 = r14.e()
            long r7 = java.lang.Math.min(r12, r7)
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.a(r14)
            r6.f120393c = r14
            r6.f120391a = r10
            r6.f120392b = r12
            r6.f120396g = r4
            r4 = r7
            java.lang.Object r10 = r1.J(r2, r4, r6)
            if (r10 != r0) goto L7e
        L7d:
            return r0
        L7e:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakPauseTracker.d(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object f(StreakPauseTracker streakPauseTracker, long j3, Profile.PausedUntil pausedUntil, long j4, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            j4 = TimeHelperExt.f128663a.f();
        }
        return streakPauseTracker.e(j3, pausedUntil, j4, continuation);
    }

    public static /* synthetic */ Object h(StreakPauseTracker streakPauseTracker, long j3, long j4, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j4 = TimeHelperExt.f128663a.f();
        }
        return streakPauseTracker.g(j3, j4, continuation);
    }

    public final Object e(long j3, Profile.PausedUntil pausedUntil, long j4, Continuation continuation) throws Throwable {
        Object objA = StreakWriteKt.a(new StreakPauseTracker$onPaused$2(this, pausedUntil, j3, j4, null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    public final Object g(long j3, long j4, Continuation continuation) throws Throwable {
        Object objA = StreakWriteKt.a(new StreakPauseTracker$onResumed$2(this, j3, j4, null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }
}
