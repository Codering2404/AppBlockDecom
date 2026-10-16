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

/* JADX INFO: Add missing generic type declarations: [T] */
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.ScopedFlowProperty$value$1", f = "ScopedFlowProperty.kt", l = {30}, m = "invokeSuspend", v = 1)
final class ScopedFlowProperty$value$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f126922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScopedFlowProperty f126923b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.ScopedFlowProperty$value$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.ScopedFlowProperty$value$1$1", f = "ScopedFlowProperty.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<T, Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f126924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f126925b;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.f126925b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object obj2 = this.f126925b;
            IntrinsicsKt.f();
            if (this.f126924a != 0) {
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
    ScopedFlowProperty$value$1(ScopedFlowProperty scopedFlowProperty, Continuation continuation) {
        super(2, continuation);
        this.f126923b = scopedFlowProperty;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScopedFlowProperty$value$1(this.f126923b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f126922a;
        if (i3 == 0) {
            ResultKt.b(obj);
            MutableStateFlow mutableStateFlow = this.f126923b.f126920a;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.f126922a = 1;
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
        return ((ScopedFlowProperty$value$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
