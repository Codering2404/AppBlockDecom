package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

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
@DebugMetadata(c = "androidx.paging.PagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1", f = "PagingDataTransforms.kt", l = {}, m = "invokeSuspend")
final class PagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1 extends SuspendLambda implements Function3<Object, Object, Continuation<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f50406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Object f50407c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1(Object obj, Continuation continuation) {
        super(3, continuation);
        this.f50407c = obj;
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Object obj, Object obj2, Continuation continuation) {
        PagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1 pagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1 = new PagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1(this.f50407c, continuation);
        pagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1.f50406b = obj;
        return pagingDataTransforms__PagingDataTransformsKt$insertHeaderItem$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f50405a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (this.f50406b == null) {
            return this.f50407c;
        }
        return null;
    }
}
