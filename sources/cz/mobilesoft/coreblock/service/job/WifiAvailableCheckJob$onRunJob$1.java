package cz.mobilesoft.coreblock.service.job;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.job.WifiAvailableCheckJob$onRunJob$1", f = "WifiAvailableCheckJob.kt", l = {28, 35, 47}, m = "invokeSuspend", v = 1)
final class WifiAvailableCheckJob$onRunJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f123516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f123517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f123518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f123519d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ WifiAvailableCheckJob f123520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f123521g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WifiAvailableCheckJob$onRunJob$1(WifiAvailableCheckJob wifiAvailableCheckJob, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f123520f = wifiAvailableCheckJob;
        this.f123521g = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new WifiAvailableCheckJob$onRunJob$1(this.f123520f, this.f123521g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b0, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(cz.mobilesoft.coreblock.service.job.WifiAvailableCheckJob.f123512p, r1.getSSID()) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f0, code lost:
    
        if (r15 == r0) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fb  */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.job.WifiAvailableCheckJob$onRunJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((WifiAvailableCheckJob$onRunJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
