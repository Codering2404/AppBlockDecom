package cz.mobilesoft.coreblock.util.helperextension;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$1", f = "FlowsExt.kt", l = {36}, m = "invokeSuspend", v = 1)
final class FlowsExtKt$collectCombinedWhenStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LifecycleOwner f128532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow f128533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Flow f128534d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function2 f128535f;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$1$1", f = "FlowsExt.kt", l = {39}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f128536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Flow f128537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Flow f128538c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2 f128539d;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$1$1$1", f = "FlowsExt.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class C03061 extends SuspendLambda implements Function3<Object, Object, Continuation<? super Pair<Object, Object>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f128540a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f128541b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f128542c;

            C03061(Continuation continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, Object obj2, Continuation continuation) {
                C03061 c03061 = new C03061(continuation);
                c03061.f128541b = obj;
                c03061.f128542c = obj2;
                return c03061.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object obj2 = this.f128541b;
                Object obj3 = this.f128542c;
                IntrinsicsKt.f();
                if (this.f128540a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return TuplesKt.a(obj2, obj3);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Flow flow, Flow flow2, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.f128537b = flow;
            this.f128538c = flow2;
            this.f128539d = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f128537b, this.f128538c, this.f128539d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f128536a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowJ = FlowKt.J(this.f128537b, this.f128538c, new C03061(null));
                final Function2 function2 = this.f128539d;
                FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt.collectCombinedWhenStarted.1.1.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object emit(Pair pair, Continuation continuation) {
                        function2.invoke(pair.e(), pair.f());
                        return Unit.f139807a;
                    }
                };
                this.f128536a = 1;
                if (flowJ.collect(flowCollector, this) == objF) {
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
    FlowsExtKt$collectCombinedWhenStarted$1(LifecycleOwner lifecycleOwner, Flow flow, Flow flow2, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f128532b = lifecycleOwner;
        this.f128533c = flow;
        this.f128534d = flow2;
        this.f128535f = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FlowsExtKt$collectCombinedWhenStarted$1(this.f128532b, this.f128533c, this.f128534d, this.f128535f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f128531a;
        if (i3 == 0) {
            ResultKt.b(obj);
            LifecycleOwner lifecycleOwner = this.f128532b;
            Lifecycle.State state = Lifecycle.State.f39950d;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f128533c, this.f128534d, this.f128535f, null);
            this.f128531a = 1;
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
        return ((FlowsExtKt$collectCombinedWhenStarted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
