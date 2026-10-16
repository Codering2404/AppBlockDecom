package cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.LifecycleFlowProperty$1$1", f = "LifecycleFlowProperty.kt", l = {44}, m = "invokeSuspend", v = 1)
final class LifecycleFlowProperty$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f126908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LifecycleOwner f126909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow f126910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LifecycleFlowProperty f126911d;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.LifecycleFlowProperty$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.LifecycleFlowProperty$1$1$1", f = "LifecycleFlowProperty.kt", l = {45}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f126912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Flow f126913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LifecycleFlowProperty f126914c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Flow flow, LifecycleFlowProperty lifecycleFlowProperty, Continuation continuation) {
            super(2, continuation);
            this.f126913b = flow;
            this.f126914c = lifecycleFlowProperty;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f126913b, this.f126914c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f126912a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flow = this.f126913b;
                final LifecycleFlowProperty lifecycleFlowProperty = this.f126914c;
                FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.LifecycleFlowProperty.1.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj2, Continuation continuation) {
                        Object objEmit = lifecycleFlowProperty.f126907a.emit(obj2, continuation);
                        return objEmit == IntrinsicsKt.f() ? objEmit : Unit.f139807a;
                    }
                };
                this.f126912a = 1;
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
    LifecycleFlowProperty$1$1(LifecycleOwner lifecycleOwner, Flow flow, LifecycleFlowProperty lifecycleFlowProperty, Continuation continuation) {
        super(2, continuation);
        this.f126909b = lifecycleOwner;
        this.f126910c = flow;
        this.f126911d = lifecycleFlowProperty;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LifecycleFlowProperty$1$1(this.f126909b, this.f126910c, this.f126911d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f126908a;
        if (i3 == 0) {
            ResultKt.b(obj);
            LifecycleOwner lifecycleOwner = this.f126909b;
            Lifecycle.State state = Lifecycle.State.f39949c;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f126910c, this.f126911d, null);
            this.f126908a = 1;
            if (RepeatOnLifecycleKt.b(lifecycleOwner, state, anonymousClass1, this) == objF) {
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
        return ((LifecycleFlowProperty$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
