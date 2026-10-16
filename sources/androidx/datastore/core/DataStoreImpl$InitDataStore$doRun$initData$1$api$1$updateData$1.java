package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1", f = "DataStoreImpl.kt", l = {544, 447, 449}, m = "updateData")
final class DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f35571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f35572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f35573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f35574d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f35575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    /* synthetic */ Object f35576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ DataStoreImpl$InitDataStore$doRun$initData$1$api$1 f35577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f35578i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1(DataStoreImpl$InitDataStore$doRun$initData$1$api$1 dataStoreImpl$InitDataStore$doRun$initData$1$api$1, Continuation continuation) {
        super(continuation);
        this.f35577h = dataStoreImpl$InitDataStore$doRun$initData$1$api$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f35576g = obj;
        this.f35578i |= Integer.MIN_VALUE;
        return this.f35577h.a(null, this);
    }
}
