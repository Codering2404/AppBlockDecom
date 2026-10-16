package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", l = {236}, m = "invokeSuspend")
final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f141602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f141603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f141604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f141605d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ FlowCollector f141606f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1$3$2(Ref.ObjectRef objectRef, FlowCollector flowCollector, Continuation continuation) {
        super(2, continuation);
        this.f141605d = objectRef;
        this.f141606f = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.f141605d, this.f141606f, continuation);
        flowKt__DelayKt$debounceInternal$1$3$2.f141604c = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    public final Object h(Object obj, Continuation continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(ChannelResult.b(obj), continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return h(((ChannelResult) obj).m(), (Continuation) obj2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f141603b;
        if (i3 == 0) {
            ResultKt.b(obj);
            Object objM = ((ChannelResult) this.f141604c).m();
            objectRef = this.f141605d;
            boolean z2 = objM instanceof ChannelResult.Failed;
            if (!z2) {
                objectRef.f140144a = objM;
            }
            FlowCollector flowCollector = this.f141606f;
            if (z2) {
                Throwable thE = ChannelResult.e(objM);
                if (thE != null) {
                    throw thE;
                }
                Object obj2 = objectRef.f140144a;
                if (obj2 != null) {
                    if (obj2 == NullSurrogateKt.f142386a) {
                        obj2 = null;
                    }
                    this.f141604c = objM;
                    this.f141602a = objectRef;
                    this.f141603b = 1;
                    if (flowCollector.emit(obj2, this) == objF) {
                        return objF;
                    }
                    objectRef2 = objectRef;
                }
                objectRef.f140144a = NullSurrogateKt.f142388c;
            }
            return Unit.f139807a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef2 = (Ref.ObjectRef) this.f141602a;
        ResultKt.b(obj);
        objectRef = objectRef2;
        objectRef.f140144a = NullSurrogateKt.f142388c;
        return Unit.f139807a;
    }
}
