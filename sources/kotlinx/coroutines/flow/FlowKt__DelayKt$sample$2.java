package kotlinx.coroutines.flow;

import com.facebook.internal.FacebookRequestErrorClassification;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectImplementation;

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
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", l = {FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED}, m = "invokeSuspend")
final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f141617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f141618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f141619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ Object f141620d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    /* synthetic */ Object f141621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ long f141622g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Flow f141623h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$sample$2(long j3, Flow flow, Continuation continuation) {
        super(3, continuation);
        this.f141622g = j3;
        this.f141623h = flow;
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(CoroutineScope coroutineScope, FlowCollector flowCollector, Continuation continuation) {
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2 = new FlowKt__DelayKt$sample$2(this.f141622g, this.f141623h, continuation);
        flowKt__DelayKt$sample$2.f141620d = coroutineScope;
        flowKt__DelayKt$sample$2.f141621f = flowCollector;
        return flowKt__DelayKt$sample$2.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ReceiveChannel receiveChannel;
        ReceiveChannel receiveChannelH;
        Ref.ObjectRef objectRef;
        FlowCollector flowCollector;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f141619c;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f141620d;
            FlowCollector flowCollector2 = (FlowCollector) this.f141621f;
            ReceiveChannel receiveChannelD = ProduceKt.d(coroutineScope, null, -1, new FlowKt__DelayKt$sample$2$values$1(this.f141623h, null), 1, null);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            receiveChannel = receiveChannelD;
            receiveChannelH = FlowKt.H(coroutineScope, this.f141622g);
            objectRef = objectRef2;
            flowCollector = flowCollector2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            receiveChannelH = (ReceiveChannel) this.f141618b;
            objectRef = (Ref.ObjectRef) this.f141617a;
            receiveChannel = (ReceiveChannel) this.f141621f;
            flowCollector = (FlowCollector) this.f141620d;
            ResultKt.b(obj);
        }
        while (objectRef.f140144a != NullSurrogateKt.f142388c) {
            SelectImplementation selectImplementation = new SelectImplementation(getContext());
            selectImplementation.g(receiveChannel.q(), new FlowKt__DelayKt$sample$2$1$1(objectRef, receiveChannelH, null));
            selectImplementation.g(receiveChannelH.o(), new FlowKt__DelayKt$sample$2$1$2(objectRef, flowCollector, null));
            this.f141620d = flowCollector;
            this.f141621f = receiveChannel;
            this.f141617a = objectRef;
            this.f141618b = receiveChannelH;
            this.f141619c = 1;
            if (selectImplementation.p(this) == objF) {
                return objF;
            }
        }
        return Unit.f139807a;
    }
}
