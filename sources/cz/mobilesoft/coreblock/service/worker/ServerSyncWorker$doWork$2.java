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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.worker.ServerSyncWorker$doWork$2", f = "ServerSyncWorker.kt", l = {62, 64}, m = "invokeSuspend", v = 1)
final class ServerSyncWorker$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f123952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ServerSyncWorker f123953b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ServerSyncWorker$doWork$2(ServerSyncWorker serverSyncWorker, Continuation continuation) {
        super(2, continuation);
        this.f123953b = serverSyncWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ServerSyncWorker$doWork$2(this.f123953b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ServerSyncWorker$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0060, code lost:
    
        if (r7.p(r6) == r0) goto L15;
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
            int r1 = r6.f123952a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r7)
            goto L63
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            kotlin.ResultKt.b(r7)
            goto L58
        L1e:
            kotlin.ResultKt.b(r7)
            java.lang.Class<cz.mobilesoft.coreblock.service.worker.ServerSyncWorker> r7 = cz.mobilesoft.coreblock.service.worker.ServerSyncWorker.class
            java.lang.String r7 = r7.getSimpleName()
            java.lang.String r1 = "getSimpleName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            r1 = 0
            java.lang.String r1 = d.qFm.sECyKyO.KqA
            android.util.Log.d(r7, r1)
            cz.mobilesoft.coreblock.service.worker.CampaignCheckWorker$Companion r7 = cz.mobilesoft.coreblock.service.worker.CampaignCheckWorker.f123877g
            cz.mobilesoft.coreblock.service.worker.ServerSyncWorker r1 = r6.f123953b
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r4 = "getApplicationContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            cz.mobilesoft.coreblock.service.worker.ServerSyncWorker r4 = r6.f123953b
            cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore r4 = r4.m()
            cz.mobilesoft.coreblock.service.worker.ServerSyncWorker r5 = r6.f123953b
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2 r5 = cz.mobilesoft.coreblock.service.worker.ServerSyncWorker.j(r5)
            cz.mobilesoft.coreblock.enums.PremiumState r5 = r5.J()
            r6.f123952a = r3
            java.lang.Object r7 = r7.d(r1, r4, r5, r6)
            if (r7 != r0) goto L58
            goto L62
        L58:
            cz.mobilesoft.coreblock.service.worker.ServerSyncWorker r7 = r6.f123953b
            r6.f123952a = r2
            java.lang.Object r7 = cz.mobilesoft.coreblock.service.worker.ServerSyncWorker.l(r7, r6)
            if (r7 != r0) goto L63
        L62:
            return r0
        L63:
            androidx.work.ListenableWorker$Result r7 = androidx.work.ListenableWorker.Result.c()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.worker.ServerSyncWorker$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
