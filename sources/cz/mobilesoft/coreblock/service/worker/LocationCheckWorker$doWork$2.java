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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.worker.LocationCheckWorker$doWork$2", f = "LocationCheckWorker.kt", l = {79, 81, 87, 95, 96}, m = "invokeSuspend", v = 1)
final class LocationCheckWorker$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f123932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f123933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f123934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f123935d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f123936f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ LocationCheckWorker f123937g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocationCheckWorker$doWork$2(LocationCheckWorker locationCheckWorker, Continuation continuation) {
        super(2, continuation);
        this.f123937g = locationCheckWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LocationCheckWorker$doWork$2(this.f123937g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
    
        if (cz.mobilesoft.coreblock.util.location.LocationCheckHelper.Companion.b(r1, false, r17, 1, null) == r6) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x010e, code lost:
    
        if (r7.d2(r4, r17) != r6) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cc  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.worker.LocationCheckWorker$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LocationCheckWorker$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
