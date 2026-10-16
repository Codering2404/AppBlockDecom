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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$truncateSessionsForProfile$2", f = "StreakActivityTracker.kt", l = {172, 172}, m = "invokeSuspend", v = 1)
final class StreakActivityTracker$truncateSessionsForProfile$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f120201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f120202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f120203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f120204d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f120205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f120206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f120207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f120208i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f120209j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ StreakActivityTracker f120210k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ long f120211l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ long f120212m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakActivityTracker$truncateSessionsForProfile$2(StreakActivityTracker streakActivityTracker, long j3, long j4, Continuation continuation) {
        super(1, continuation);
        this.f120210k = streakActivityTracker;
        this.f120211l = j3;
        this.f120212m = j4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new StreakActivityTracker$truncateSessionsForProfile$2(this.f120210k, this.f120211l, this.f120212m, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
    
        if (r13 == r0) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.f120209j
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L35
            if (r1 == r4) goto L30
            if (r1 != r3) goto L28
            int r1 = r12.f120207h
            long r4 = r12.f120206g
            java.lang.Object r6 = r12.f120205f
            cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakActivitySessionEntity r6 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakActivitySessionEntity) r6
            java.lang.Object r6 = r12.f120203c
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r7 = r12.f120202b
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker r7 = (cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker) r7
            java.lang.Object r8 = r12.f120201a
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            kotlin.ResultKt.b(r13)
            r10 = r12
            goto L59
        L28:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L30:
            kotlin.ResultKt.b(r13)
            r10 = r12
            goto L4c
        L35:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker r13 = r12.f120210k
            cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao r5 = cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.c(r13)
            long r6 = r12.f120211l
            long r8 = r12.f120212m
            r12.f120209j = r4
            r10 = r12
            java.lang.Object r13 = r5.N(r6, r8, r10)
            if (r13 != r0) goto L4c
            goto L8a
        L4c:
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker r1 = r10.f120210k
            long r4 = r10.f120212m
            java.util.Iterator r6 = r13.iterator()
            r8 = r13
            r7 = r1
            r1 = r2
        L59:
            boolean r13 = r6.hasNext()
            if (r13 == 0) goto L8b
            java.lang.Object r13 = r6.next()
            r9 = r13
            cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakActivitySessionEntity r9 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakActivitySessionEntity) r9
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r10.f120201a = r11
            r10.f120202b = r7
            r10.f120203c = r6
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
            r10.f120204d = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r10.f120205f = r13
            r10.f120206g = r4
            r10.f120207h = r1
            r10.f120208i = r2
            r10.f120209j = r3
            java.lang.Object r13 = cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.h(r7, r9, r4, r12)
            if (r13 != r0) goto L59
        L8a:
            return r0
        L8b:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker$truncateSessionsForProfile$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((StreakActivityTracker$truncateSessionsForProfile$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
