package cz.mobilesoft.coreblock.util;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$saveWithProgressAnimation$2$loadingJob$1", f = "AdultContentDownloadWorker.kt", l = {193}, m = "invokeSuspend", v = 1)
final class AdultContentDownloadWorker$saveWithProgressAnimation$2$loadingJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f127761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f127762b;

    AdultContentDownloadWorker$saveWithProgressAnimation$2$loadingJob$1(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AdultContentDownloadWorker$saveWithProgressAnimation$2$loadingJob$1 adultContentDownloadWorker$saveWithProgressAnimation$2$loadingJob$1 = new AdultContentDownloadWorker$saveWithProgressAnimation$2$loadingJob$1(continuation);
        adultContentDownloadWorker$saveWithProgressAnimation$2$loadingJob$1.f127762b = obj;
        return adultContentDownloadWorker$saveWithProgressAnimation$2$loadingJob$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002e -> B:14:0x0031). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f127762b
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r6.f127761a
            r3 = 1
            if (r2 == 0) goto L1b
            if (r2 != r3) goto L13
            kotlin.ResultKt.b(r7)
            goto L31
        L13:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1b:
            kotlin.ResultKt.b(r7)
        L1e:
            boolean r7 = kotlinx.coroutines.CoroutineScopeKt.h(r0)
            if (r7 == 0) goto L63
            r6.f127762b = r0
            r6.f127761a = r3
            r4 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r4, r6)
            if (r7 != r1) goto L31
            return r1
        L31:
            cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$Companion r7 = cz.mobilesoft.coreblock.util.AdultContentDownloadWorker.f127702i
            kotlinx.coroutines.flow.MutableStateFlow r2 = cz.mobilesoft.coreblock.util.AdultContentDownloadWorker.Companion.a(r7)
            java.lang.Object r2 = r2.getValue()
            cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$AdultContentSyncState r2 = (cz.mobilesoft.coreblock.util.AdultContentDownloadWorker.AdultContentSyncState) r2
            float r2 = r2.c()
            r4 = 1065017672(0x3f7ae148, float:0.98)
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 >= 0) goto L1e
            kotlinx.coroutines.flow.MutableStateFlow r4 = cz.mobilesoft.coreblock.util.AdultContentDownloadWorker.Companion.a(r7)
            kotlinx.coroutines.flow.MutableStateFlow r7 = cz.mobilesoft.coreblock.util.AdultContentDownloadWorker.Companion.a(r7)
            java.lang.Object r7 = r7.getValue()
            cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$AdultContentSyncState r7 = (cz.mobilesoft.coreblock.util.AdultContentDownloadWorker.AdultContentSyncState) r7
            r5 = 1008981770(0x3c23d70a, float:0.01)
            float r2 = r2 + r5
            r5 = 0
            cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$AdultContentSyncState r7 = cz.mobilesoft.coreblock.util.AdultContentDownloadWorker.AdultContentSyncState.b(r7, r5, r2, r3, r5)
            r4.setValue(r7)
            goto L1e
        L63:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.AdultContentDownloadWorker$saveWithProgressAnimation$2$loadingJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AdultContentDownloadWorker$saveWithProgressAnimation$2$loadingJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
