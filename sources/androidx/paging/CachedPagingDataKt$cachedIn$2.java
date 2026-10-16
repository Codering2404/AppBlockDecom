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
@DebugMetadata(c = "androidx.paging.CachedPagingDataKt$cachedIn$2", f = "CachedPagingData.kt", l = {104}, m = "invokeSuspend")
final class CachedPagingDataKt$cachedIn$2 extends SuspendLambda implements Function3<MulticastedPagingData<Object>, MulticastedPagingData<Object>, Continuation<? super MulticastedPagingData<Object>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f49629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f49630c;

    CachedPagingDataKt$cachedIn$2(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(MulticastedPagingData multicastedPagingData, MulticastedPagingData multicastedPagingData2, Continuation continuation) {
        CachedPagingDataKt$cachedIn$2 cachedPagingDataKt$cachedIn$2 = new CachedPagingDataKt$cachedIn$2(continuation);
        cachedPagingDataKt$cachedIn$2.f49629b = multicastedPagingData;
        cachedPagingDataKt$cachedIn$2.f49630c = multicastedPagingData2;
        return cachedPagingDataKt$cachedIn$2.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f49628a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            MulticastedPagingData multicastedPagingData = (MulticastedPagingData) this.f49629b;
            ResultKt.b(obj);
            return multicastedPagingData;
        }
        ResultKt.b(obj);
        MulticastedPagingData multicastedPagingData2 = (MulticastedPagingData) this.f49629b;
        MulticastedPagingData multicastedPagingData3 = (MulticastedPagingData) this.f49630c;
        this.f49629b = multicastedPagingData3;
        this.f49628a = 1;
        return multicastedPagingData2.c(this) == objF ? objF : multicastedPagingData3;
    }
}
