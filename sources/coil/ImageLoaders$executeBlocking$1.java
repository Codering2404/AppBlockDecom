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
@DebugMetadata(c = "coil.ImageLoaders$executeBlocking$1", f = "ImageLoaders.kt", l = {26}, m = "invokeSuspend")
final class ImageLoaders$executeBlocking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f55438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ImageLoader f55439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ImageRequest f55440c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ImageLoaders$executeBlocking$1(ImageLoader imageLoader, ImageRequest imageRequest, Continuation continuation) {
        super(2, continuation);
        this.f55439b = imageLoader;
        this.f55440c = imageRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ImageLoaders$executeBlocking$1(this.f55439b, this.f55440c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f55438a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        ImageLoader imageLoader = this.f55439b;
        ImageRequest imageRequest = this.f55440c;
        this.f55438a = 1;
        Object objC = imageLoader.c(imageRequest, this);
        return objC == objF ? objF : objC;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ImageLoaders$executeBlocking$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
