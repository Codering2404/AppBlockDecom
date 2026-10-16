package cz.mobilesoft.coreblock.util.compose;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.compose.FlowExtKt$CollectAsEffect$1$1", f = "FlowExt.kt", l = {}, m = "invokeSuspend", v = 1)
final class FlowExtKt$CollectAsEffect$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f128232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow f128233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LifecycleOwner f128234d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function2 f128235f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowExtKt$CollectAsEffect$1$1(Flow flow, LifecycleOwner lifecycleOwner, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f128233c = flow;
        this.f128234d = lifecycleOwner;
        this.f128235f = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlowExtKt$CollectAsEffect$1$1 flowExtKt$CollectAsEffect$1$1 = new FlowExtKt$CollectAsEffect$1$1(this.f128233c, this.f128234d, this.f128235f, continuation);
        flowExtKt$CollectAsEffect$1$1.f128232b = obj;
        return flowExtKt$CollectAsEffect$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineScope coroutineScope = (CoroutineScope) this.f128232b;
        IntrinsicsKt.f();
        if (this.f128231a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        FlowKt.Q(FlowKt.V(androidx.lifecycle.FlowExtKt.a(this.f128233c, this.f128234d.getLifecycle(), Lifecycle.State.f39950d), this.f128235f), CoroutineScopeKt.i(coroutineScope, CoroutinesHelperExtKt.b()));
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((FlowExtKt$CollectAsEffect$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
