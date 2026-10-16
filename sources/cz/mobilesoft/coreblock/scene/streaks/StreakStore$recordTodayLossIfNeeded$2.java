package cz.mobilesoft.coreblock.scene.streaks;

import java.time.ZoneId;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.StreakStore$recordTodayLossIfNeeded$2", f = "StreakStore.kt", l = {176, 219, 178}, m = "invokeSuspend", v = 1)
final class StreakStore$recordTodayLossIfNeeded$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f120561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f120562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f120563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f120564d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f120565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f120566g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f120567h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ StreakStore f120568i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ long f120569j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ ZoneId f120570k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakStore$recordTodayLossIfNeeded$2(StreakStore streakStore, long j3, ZoneId zoneId, Continuation continuation) {
        super(1, continuation);
        this.f120568i = streakStore;
        this.f120569j = j3;
        this.f120570k = zoneId;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new StreakStore$recordTodayLossIfNeeded$2(this.f120568i, this.f120569j, this.f120570k, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0091  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.f120567h
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r1 == 0) goto L40
            if (r1 == r5) goto L3c
            if (r1 == r4) goto L27
            if (r1 != r3) goto L1f
            java.lang.Object r0 = r12.f120561a
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.b(r13)     // Catch: java.lang.Throwable -> L1c
            goto L92
        L1c:
            r13 = move-exception
            goto L9e
        L1f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L27:
            int r1 = r12.f120565f
            long r4 = r12.f120564d
            java.lang.Object r7 = r12.f120563c
            java.time.ZoneId r7 = (java.time.ZoneId) r7
            java.lang.Object r8 = r12.f120562b
            cz.mobilesoft.coreblock.scene.streaks.StreakStore r8 = (cz.mobilesoft.coreblock.scene.streaks.StreakStore) r8
            java.lang.Object r9 = r12.f120561a
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            kotlin.ResultKt.b(r13)
            r13 = r9
            goto L7e
        L3c:
            kotlin.ResultKt.b(r13)
            goto L52
        L40:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.coreblock.scene.streaks.StreakStore r13 = r12.f120568i
            cz.mobilesoft.coreblock.scene.streaks.StreakAvailability r13 = cz.mobilesoft.coreblock.scene.streaks.StreakStore.a(r13)
            r12.f120567h = r5
            java.lang.Object r13 = r13.a(r12)
            if (r13 != r0) goto L52
            goto L90
        L52:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L5d
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        L5d:
            cz.mobilesoft.coreblock.scene.streaks.StreakStore r13 = r12.f120568i
            kotlinx.coroutines.sync.Mutex r13 = cz.mobilesoft.coreblock.scene.streaks.StreakStore.b(r13)
            cz.mobilesoft.coreblock.scene.streaks.StreakStore r8 = r12.f120568i
            long r9 = r12.f120569j
            java.time.ZoneId r7 = r12.f120570k
            r12.f120561a = r13
            r12.f120562b = r8
            r12.f120563c = r7
            r12.f120564d = r9
            r12.f120565f = r2
            r12.f120567h = r4
            java.lang.Object r1 = r13.f(r6, r12)
            if (r1 != r0) goto L7c
            goto L90
        L7c:
            r1 = r2
            r4 = r9
        L7e:
            r12.f120561a = r13     // Catch: java.lang.Throwable -> L9a
            r12.f120562b = r6     // Catch: java.lang.Throwable -> L9a
            r12.f120563c = r6     // Catch: java.lang.Throwable -> L9a
            r12.f120565f = r1     // Catch: java.lang.Throwable -> L9a
            r12.f120566g = r2     // Catch: java.lang.Throwable -> L9a
            r12.f120567h = r3     // Catch: java.lang.Throwable -> L9a
            java.lang.Object r1 = cz.mobilesoft.coreblock.scene.streaks.StreakStore.d(r8, r4, r7, r12)     // Catch: java.lang.Throwable -> L9a
            if (r1 != r0) goto L91
        L90:
            return r0
        L91:
            r0 = r13
        L92:
            kotlin.Unit r13 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L1c
            r0.i(r6)
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        L9a:
            r0 = move-exception
            r11 = r0
            r0 = r13
            r13 = r11
        L9e:
            r0.i(r6)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakStore$recordTodayLossIfNeeded$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((StreakStore$recordTodayLossIfNeeded$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
