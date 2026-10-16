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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$recordPlannedSession$2", f = "StreakActivityTracker.kt", l = {121, 123, 125}, m = "invokeSuspend", v = 1)
final class StreakActivityTracker$recordPlannedSession$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f120172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StreakActivityTracker f120173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f120174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f120175d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Long f120176f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakActivityTracker$recordPlannedSession$2(StreakActivityTracker streakActivityTracker, long j3, long j4, Long l3, Continuation continuation) {
        super(1, continuation);
        this.f120173b = streakActivityTracker;
        this.f120174c = j3;
        this.f120175d = j4;
        this.f120176f = l3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new StreakActivityTracker$recordPlannedSession$2(this.f120173b, this.f120174c, this.f120175d, this.f120176f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x008e, code lost:
    
        if (r2.n(r4, r16) == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0072  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            r16 = this;
            r0 = r16
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120172a
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L2c
            if (r2 == r5) goto L26
            if (r2 == r4) goto L20
            if (r2 != r3) goto L18
            kotlin.ResultKt.b(r17)
            goto L91
        L18:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L20:
            kotlin.ResultKt.b(r17)
            r2 = r17
            goto L67
        L26:
            kotlin.ResultKt.b(r17)
            r2 = r17
            goto L3e
        L2c:
            kotlin.ResultKt.b(r17)
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker r2 = r0.f120173b
            cz.mobilesoft.coreblock.scene.streaks.StreakAvailability r2 = cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.a(r2)
            r0.f120172a = r5
            java.lang.Object r2 = r2.a(r0)
            if (r2 != r1) goto L3e
            goto L90
        L3e:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L49
            kotlin.Unit r1 = kotlin.Unit.f139807a
            return r1
        L49:
            long r5 = r0.f120174c
            long r7 = r0.f120175d
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 > 0) goto L54
            kotlin.Unit r1 = kotlin.Unit.f139807a
            return r1
        L54:
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker r2 = r0.f120173b
            cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao r2 = cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.c(r2)
            java.lang.Long r5 = r0.f120176f
            long r6 = r0.f120175d
            r0.f120172a = r4
            java.lang.Object r2 = r2.K(r5, r6, r0)
            if (r2 != r1) goto L67
            goto L90
        L67:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L72
            kotlin.Unit r1 = kotlin.Unit.f139807a
            return r1
        L72:
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker r2 = r0.f120173b
            cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao r2 = cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.c(r2)
            cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakActivitySessionEntity r4 = new cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakActivitySessionEntity
            java.lang.Long r7 = r0.f120176f
            long r8 = r0.f120175d
            long r10 = r0.f120174c
            r14 = 1
            r15 = 0
            r5 = 0
            r12 = r8
            r4.<init>(r5, r7, r8, r10, r12, r14, r15)
            r0.f120172a = r3
            java.lang.Object r2 = r2.n(r4, r0)
            if (r2 != r1) goto L91
        L90:
            return r1
        L91:
            kotlin.Unit r1 = kotlin.Unit.f139807a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$recordPlannedSession$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((StreakActivityTracker$recordPlannedSession$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
