package coil;

import coil.request.ImageRequest;
import coil.request.ImageResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@DebugMetadata(c = "coil.RealImageLoader$execute$2$job$1", f = "RealImageLoader.kt", l = {133}, m = "invokeSuspend")
final class RealImageLoader$execute$2$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f55464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RealImageLoader f55465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ImageRequest f55466c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RealImageLoader$execute$2$job$1(RealImageLoader realImageLoader, ImageRequest imageRequest, Continuation continuation) {
        super(2, continuation);
        this.f55465b = realImageLoader;
        this.f55466c = imageRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RealImageLoader$execute$2$job$1(this.f55465b, this.f55466c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f55464a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        RealImageLoader realImageLoader = this.f55465b;
        ImageRequest imageRequest = this.f55466c;
        this.f55464a = 1;
        Object objG = realImageLoader.g(imageRequest, 1, this);
        return objG == objF ? objF : objG;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RealImageLoader$execute$2$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
