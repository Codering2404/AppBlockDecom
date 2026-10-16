package androidx.datastore.core;

import androidx.datastore.core.DataStoreImpl;
import com.facebook.internal.FacebookRequestErrorClassification;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
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
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1", f = "DataStoreImpl.kt", l = {437, FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 546, 468}, m = "invokeSuspend")
final class DataStoreImpl$InitDataStore$doRun$initData$1<T> extends SuspendLambda implements Function1<Continuation<? super Data<T>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f35558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f35559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f35560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f35561d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f35562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f35563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f35564h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ DataStoreImpl f35565i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ DataStoreImpl.InitDataStore f35566j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataStoreImpl$InitDataStore$doRun$initData$1(DataStoreImpl dataStoreImpl, DataStoreImpl.InitDataStore initDataStore, Continuation continuation) {
        super(1, continuation);
        this.f35565i = dataStoreImpl;
        this.f35566j = initDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new DataStoreImpl$InitDataStore$doRun$initData$1(this.f35565i, this.f35566j, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((DataStoreImpl$InitDataStore$doRun$initData$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
