package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", l = {90}, m = "invokeSuspend")
final class FlowExtKt$flowWithLifecycle$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f39920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f39921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Lifecycle f39922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Lifecycle.State f39923d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Flow f39924f;

    /* JADX INFO: renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", l = {90}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f39925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Flow f39926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ProducerScope f39927c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Flow flow, ProducerScope producerScope, Continuation continuation) {
            super(2, continuation);
            this.f39926b = flow;
            this.f39927c = producerScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f39926b, this.f39927c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f39925a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flow = this.f39926b;
                final ProducerScope producerScope = this.f39927c;
                FlowCollector flowCollector = new FlowCollector() { // from class: androidx.lifecycle.FlowExtKt.flowWithLifecycle.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj2, Continuation continuation) {
                        Object objY = producerScope.y(obj2, continuation);
                        return objY == IntrinsicsKt.f() ? objY : Unit.f139807a;
                    }
                };
                this.f39925a = 1;
                if (flow.collect(flowCollector, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowExtKt$flowWithLifecycle$1(Lifecycle lifecycle, Lifecycle.State state, Flow flow, Continuation continuation) {
        super(2, continuation);
        this.f39922c = lifecycle;
        this.f39923d = state;
        this.f39924f = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlowExtKt$flowWithLifecycle$1 flowExtKt$flowWithLifecycle$1 = new FlowExtKt$flowWithLifecycle$1(this.f39922c, this.f39923d, this.f39924f, continuation);
        flowExtKt$flowWithLifecycle$1.f39921b = obj;
        return flowExtKt$flowWithLifecycle$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((FlowExtKt$flowWithLifecycle$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ProducerScope producerScope;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f39920a;
        if (i3 == 0) {
            ResultKt.b(obj);
            ProducerScope producerScope2 = (ProducerScope) this.f39921b;
            Lifecycle lifecycle = this.f39922c;
            Lifecycle.State state = this.f39923d;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f39924f, producerScope2, null);
            this.f39921b = producerScope2;
            this.f39920a = 1;
            if (RepeatOnLifecycleKt.a(lifecycle, state, anonymousClass1, this) == objF) {
                return objF;
            }
            producerScope = producerScope2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            producerScope = (ProducerScope) this.f39921b;
            ResultKt.b(obj);
        }
        SendChannel.DefaultImpls.a(producerScope, null, 1, null);
        return Unit.f139807a;
    }
}
