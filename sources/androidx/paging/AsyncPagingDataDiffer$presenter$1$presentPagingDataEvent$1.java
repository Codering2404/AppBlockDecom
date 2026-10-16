package androidx.paging;

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
@DebugMetadata(c = "androidx.paging.AsyncPagingDataDiffer$presenter$1", f = "AsyncPagingDataDiffer.kt", l = {182}, m = "presentPagingDataEvent")
final class AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f49561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f49562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f49563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f49564d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    /* synthetic */ Object f49565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ AsyncPagingDataDiffer$presenter$1 f49566g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f49567h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1(AsyncPagingDataDiffer$presenter$1 asyncPagingDataDiffer$presenter$1, Continuation continuation) {
        super(continuation);
        this.f49566g = asyncPagingDataDiffer$presenter$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49565f = obj;
        this.f49567h |= Integer.MIN_VALUE;
        return this.f49566g.s(null, this);
    }
}
