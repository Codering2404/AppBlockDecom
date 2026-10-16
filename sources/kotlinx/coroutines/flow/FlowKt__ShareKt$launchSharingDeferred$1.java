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
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", l = {336}, m = "invokeSuspend")
final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f141922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f141923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow f141924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CompletableDeferred f141925d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__ShareKt$launchSharingDeferred$1(Flow flow, CompletableDeferred completableDeferred, Continuation continuation) {
        super(2, continuation);
        this.f141924c = flow;
        this.f141925d = completableDeferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.f141924c, this.f141925d, continuation);
        flowKt__ShareKt$launchSharingDeferred$1.f141923b = obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f141922a;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.f141923b;
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Flow flow = this.f141924c;
                final CompletableDeferred completableDeferred = this.f141925d;
                FlowCollector flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj2, Continuation continuation) {
                        Ref.ObjectRef objectRef2 = objectRef;
                        MutableStateFlow mutableStateFlow = (MutableStateFlow) objectRef2.f140144a;
                        if (mutableStateFlow != null) {
                            mutableStateFlow.setValue(obj2);
                        } else {
                            CoroutineScope coroutineScope2 = coroutineScope;
                            CompletableDeferred completableDeferred2 = completableDeferred;
                            MutableStateFlow mutableStateFlowA = StateFlowKt.a(obj2);
                            completableDeferred2.J(new ReadonlyStateFlow(mutableStateFlowA, JobKt.m(coroutineScope2.getCoroutineContext())));
                            objectRef2.f140144a = mutableStateFlowA;
                        }
                        return Unit.f139807a;
                    }
                };
                this.f141922a = 1;
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
        } catch (Throwable th) {
            this.f141925d.a(th);
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
