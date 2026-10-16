package cz.mobilesoft.coreblock.service.worker;

import androidx.work.ListenableWorker;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.worker.StreakSyncWorker$doWork$2", f = "StreakSyncWorker.kt", l = {33, 34, 35}, m = "invokeSuspend", v = 1)
final class StreakSyncWorker$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f123988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StreakSyncWorker f123989b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakSyncWorker$doWork$2(StreakSyncWorker streakSyncWorker, Continuation continuation) {
        super(2, continuation);
        this.f123989b = streakSyncWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StreakSyncWorker$doWork$2(this.f123989b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0065, code lost:
    
        if (cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync.k(r4, 0, null, r8, 3, null) != r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.f123988a
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L27
            if (r1 == r4) goto L22
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.b(r13)
            goto L68
        L15:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1d:
            kotlin.ResultKt.b(r13)
            r8 = r12
            goto L54
        L22:
            kotlin.ResultKt.b(r13)
            r8 = r12
            goto L40
        L27:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.coreblock.service.worker.StreakSyncWorker r13 = r12.f123989b
            cz.mobilesoft.coreblock.scene.streaks.StreakStore r5 = cz.mobilesoft.coreblock.service.worker.StreakSyncWorker.j(r13)
            r12.f123988a = r4
            r6 = 0
            r8 = 0
            r10 = 3
            r11 = 0
            r9 = r12
            java.lang.Object r13 = cz.mobilesoft.coreblock.scene.streaks.StreakStore.n(r5, r6, r8, r9, r10, r11)
            r8 = r9
            if (r13 != r0) goto L40
            goto L67
        L40:
            cz.mobilesoft.coreblock.service.worker.StreakSyncWorker r13 = r8.f123989b
            cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync r4 = cz.mobilesoft.coreblock.service.worker.StreakSyncWorker.i(r13)
            r8.f123988a = r3
            r5 = 0
            r7 = 0
            r9 = 3
            r10 = 0
            java.lang.Object r13 = cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync.f(r4, r5, r7, r8, r9, r10)
            if (r13 != r0) goto L54
            goto L67
        L54:
            cz.mobilesoft.coreblock.service.worker.StreakSyncWorker r13 = r8.f123989b
            cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync r4 = cz.mobilesoft.coreblock.service.worker.StreakSyncWorker.i(r13)
            r8.f123988a = r2
            r5 = 0
            r7 = 0
            r9 = 3
            r10 = 0
            java.lang.Object r13 = cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync.k(r4, r5, r7, r8, r9, r10)
            if (r13 != r0) goto L68
        L67:
            return r0
        L68:
            androidx.work.ListenableWorker$Result r13 = androidx.work.ListenableWorker.Result.c()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.worker.StreakSyncWorker$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StreakSyncWorker$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
