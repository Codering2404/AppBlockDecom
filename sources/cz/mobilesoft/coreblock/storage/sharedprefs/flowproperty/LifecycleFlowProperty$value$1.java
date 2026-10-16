package cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.LifecycleFlowProperty$value$1", f = "LifecycleFlowProperty.kt", l = {37}, m = "invokeSuspend", v = 1)
final class LifecycleFlowProperty$value$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f126916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LifecycleFlowProperty f126917b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.LifecycleFlowProperty$value$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.LifecycleFlowProperty$value$1$1", f = "LifecycleFlowProperty.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Object, Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f126918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f126919b;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.f126919b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object obj2 = this.f126919b;
            IntrinsicsKt.f();
            if (this.f126918a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Boxing.a(obj2 != null);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation continuation) {
            return ((AnonymousClass1) create(obj, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LifecycleFlowProperty$value$1(LifecycleFlowProperty lifecycleFlowProperty, Continuation continuation) {
        super(2, continuation);
        this.f126917b = lifecycleFlowProperty;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LifecycleFlowProperty$value$1(this.f126917b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f126916a;
        if (i3 == 0) {
            ResultKt.b(obj);
            MutableStateFlow mutableStateFlow = this.f126917b.f126907a;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.f126916a = 1;
            obj = FlowKt.E(mutableStateFlow, anonymousClass1, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        Intrinsics.checkNotNull(obj);
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LifecycleFlowProperty$value$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
