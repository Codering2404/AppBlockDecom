package cz.mobilesoft.coreblock.scene.streaks;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$truncateRunningSession$2", f = "StreakActivityTracker.kt", l = {158, 158}, m = "invokeSuspend", v = 1)
final class StreakActivityTracker$truncateRunningSession$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f120186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f120187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StreakActivityTracker f120188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f120189d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakActivityTracker$truncateRunningSession$2(StreakActivityTracker streakActivityTracker, long j3, Continuation continuation) {
        super(1, continuation);
        this.f120188c = streakActivityTracker;
        this.f120189d = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new StreakActivityTracker$truncateRunningSession$2(this.f120188c, this.f120189d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
    
        if (r1.s((cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakActivitySessionEntity) r7, r3, r6) == r0) goto L15;
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
            int r1 = r6.f120187b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r7)
            goto L48
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            java.lang.Object r1 = r6.f120186a
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker r1 = (cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker) r1
            kotlin.ResultKt.b(r7)
            goto L38
        L22:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker r1 = r6.f120188c
            cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao r7 = cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.c(r1)
            long r4 = r6.f120189d
            r6.f120186a = r1
            r6.f120187b = r3
            java.lang.Object r7 = r7.M(r4, r6)
            if (r7 != r0) goto L38
            goto L47
        L38:
            cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakActivitySessionEntity r7 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakActivitySessionEntity) r7
            long r3 = r6.f120189d
            r5 = 0
            r6.f120186a = r5
            r6.f120187b = r2
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.h(r1, r7, r3, r6)
            if (r7 != r0) goto L48
        L47:
            return r0
        L48:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$truncateRunningSession$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((StreakActivityTracker$truncateRunningSession$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
