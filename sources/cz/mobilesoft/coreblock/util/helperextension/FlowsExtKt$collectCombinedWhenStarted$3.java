package cz.mobilesoft.coreblock.util.helperextension;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$3", f = "FlowsExt.kt", l = {62}, m = "invokeSuspend", v = 1)
final class FlowsExtKt$collectCombinedWhenStarted$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LifecycleOwner f128563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow f128564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Flow f128565d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Flow f128566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Flow f128567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function4 f128568h;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$3$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$3$1", f = "FlowsExt.kt", l = {69}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f128569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Flow f128570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Flow f128571c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Flow f128572d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Flow f128573f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function4 f128574g;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$3$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$3$1$1", f = "FlowsExt.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class C03081 extends SuspendLambda implements Function3<Object, Object, Continuation<? super Pair<Object, Object>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f128575a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f128576b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f128577c;

            C03081(Continuation continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, Object obj2, Continuation continuation) {
                C03081 c03081 = new C03081(continuation);
                c03081.f128576b = obj;
                c03081.f128577c = obj2;
                return c03081.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object obj2 = this.f128576b;
                Object obj3 = this.f128577c;
                IntrinsicsKt.f();
                if (this.f128575a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return TuplesKt.a(obj2, obj3);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$3$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$3$1$2", f = "FlowsExt.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function3<Pair<Object, Object>, Object, Continuation<? super Triple<Object, Object, Object>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f128578a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f128579b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f128580c;

            AnonymousClass2(Continuation continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Pair pair, Object obj, Continuation continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
                anonymousClass2.f128579b = pair;
                anonymousClass2.f128580c = obj;
                return anonymousClass2.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Pair pair = (Pair) this.f128579b;
                Object obj2 = this.f128580c;
                IntrinsicsKt.f();
                if (this.f128578a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return new Triple(pair.e(), pair.f(), obj2);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$3$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$3$1$3", f = "FlowsExt.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass3 extends SuspendLambda implements Function3<Triple<Object, Object, Object>, Object, Continuation<? super Quadruple<Object, Object, Object, Object>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f128581a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f128582b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f128583c;

            AnonymousClass3(Continuation continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Triple triple, Object obj, Continuation continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                anonymousClass3.f128582b = triple;
                anonymousClass3.f128583c = obj;
                return anonymousClass3.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Triple triple = (Triple) this.f128582b;
                Object obj2 = this.f128583c;
                IntrinsicsKt.f();
                if (this.f128581a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return new Quadruple(triple.d(), triple.e(), triple.f(), obj2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Flow flow, Flow flow2, Flow flow3, Flow flow4, Function4 function4, Continuation continuation) {
            super(2, continuation);
            this.f128570b = flow;
            this.f128571c = flow2;
            this.f128572d = flow3;
            this.f128573f = flow4;
            this.f128574g = function4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f128570b, this.f128571c, this.f128572d, this.f128573f, this.f128574g, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f128569a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowJ = FlowKt.J(FlowKt.J(FlowKt.J(this.f128570b, this.f128571c, new C03081(null)), this.f128572d, new AnonymousClass2(null)), this.f128573f, new AnonymousClass3(null));
                final Function4 function4 = this.f128574g;
                FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt.collectCombinedWhenStarted.3.1.4
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object emit(Quadruple quadruple, Continuation continuation) {
                        function4.invoke(quadruple.a(), quadruple.c(), quadruple.d(), quadruple.b());
                        return Unit.f139807a;
                    }
                };
                this.f128569a = 1;
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
    FlowsExtKt$collectCombinedWhenStarted$3(LifecycleOwner lifecycleOwner, Flow flow, Flow flow2, Flow flow3, Flow flow4, Function4 function4, Continuation continuation) {
        super(2, continuation);
        this.f128563b = lifecycleOwner;
        this.f128564c = flow;
        this.f128565d = flow2;
        this.f128566f = flow3;
        this.f128567g = flow4;
        this.f128568h = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FlowsExtKt$collectCombinedWhenStarted$3(this.f128563b, this.f128564c, this.f128565d, this.f128566f, this.f128567g, this.f128568h, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f128562a;
        if (i3 == 0) {
            ResultKt.b(obj);
            LifecycleOwner lifecycleOwner = this.f128563b;
            Lifecycle.State state = Lifecycle.State.f39950d;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f128564c, this.f128565d, this.f128566f, this.f128567g, this.f128568h, null);
            this.f128562a = 1;
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
        return ((FlowsExtKt$collectCombinedWhenStarted$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
