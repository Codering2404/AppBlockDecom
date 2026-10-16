package coil.intercept;

import coil.ComponentRegistry;
import coil.EventListener;
import coil.fetch.SourceResult;
import coil.intercept.EngineInterceptor;
import coil.request.ImageRequest;
import coil.request.Options;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
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
@DebugMetadata(c = "coil.intercept.EngineInterceptor$execute$executeResult$1", f = "EngineInterceptor.kt", l = {127}, m = "invokeSuspend")
final class EngineInterceptor$execute$executeResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super EngineInterceptor.ExecuteResult>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f55889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ EngineInterceptor f55890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f55891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f55892d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ImageRequest f55893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Object f55894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f55895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ EventListener f55896i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EngineInterceptor$execute$executeResult$1(EngineInterceptor engineInterceptor, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, ImageRequest imageRequest, Object obj, Ref.ObjectRef objectRef3, EventListener eventListener, Continuation continuation) {
        super(2, continuation);
        this.f55890b = engineInterceptor;
        this.f55891c = objectRef;
        this.f55892d = objectRef2;
        this.f55893f = imageRequest;
        this.f55894g = obj;
        this.f55895h = objectRef3;
        this.f55896i = eventListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new EngineInterceptor$execute$executeResult$1(this.f55890b, this.f55891c, this.f55892d, this.f55893f, this.f55894g, this.f55895h, this.f55896i, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f55889a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        EngineInterceptor engineInterceptor = this.f55890b;
        SourceResult sourceResult = (SourceResult) this.f55891c.f140144a;
        ComponentRegistry componentRegistry = (ComponentRegistry) this.f55892d.f140144a;
        ImageRequest imageRequest = this.f55893f;
        Object obj2 = this.f55894g;
        Options options = (Options) this.f55895h.f140144a;
        EventListener eventListener = this.f55896i;
        this.f55889a = 1;
        Object objG = engineInterceptor.g(sourceResult, componentRegistry, imageRequest, obj2, options, eventListener, this);
        return objG == objF ? objF : objG;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((EngineInterceptor$execute$executeResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
