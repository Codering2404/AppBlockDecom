package androidx.datastore.core;

import androidx.datastore.core.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$updateData$2", f = "DataStoreImpl.kt", l = {169}, m = "invokeSuspend")
final class DataStoreImpl$updateData$2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f35669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f35670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DataStoreImpl f35671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function2 f35672d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataStoreImpl$updateData$2(DataStoreImpl dataStoreImpl, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f35671c = dataStoreImpl;
        this.f35672d = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DataStoreImpl$updateData$2 dataStoreImpl$updateData$2 = new DataStoreImpl$updateData$2(this.f35671c, this.f35672d, continuation);
        dataStoreImpl$updateData$2.f35670b = obj;
        return dataStoreImpl$updateData$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f35669a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.f35670b;
        CompletableDeferred completableDeferredB = CompletableDeferredKt.b(null, 1, null);
        this.f35671c.f35551l.e(new Message.Update(this.f35672d, completableDeferredB, this.f35671c.f35547h.a(), coroutineScope.getCoroutineContext()));
        this.f35669a = 1;
        Object objAwait = completableDeferredB.await(this);
        return objAwait == objF ? objF : objAwait;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DataStoreImpl$updateData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
