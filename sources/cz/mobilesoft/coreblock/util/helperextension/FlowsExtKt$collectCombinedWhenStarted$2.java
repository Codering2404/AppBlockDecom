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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$2", f = "FlowsExt.kt", l = {48}, m = "invokeSuspend", v = 1)
final class FlowsExtKt$collectCombinedWhenStarted$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LifecycleOwner f128545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow f128546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Flow f128547d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Flow f128548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function3 f128549g;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$2$1", f = "FlowsExt.kt", l = {53}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f128550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Flow f128551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Flow f128552c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Flow f128553d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function3 f128554f;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$2$1$1", f = "FlowsExt.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class C03071 extends SuspendLambda implements Function3<Object, Object, Continuation<? super Pair<Object, Object>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f128555a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f128556b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f128557c;

            C03071(Continuation continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, Object obj2, Continuation continuation) {
                C03071 c03071 = new C03071(continuation);
                c03071.f128556b = obj;
                c03071.f128557c = obj2;
                return c03071.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object obj2 = this.f128556b;
                Object obj3 = this.f128557c;
                IntrinsicsKt.f();
                if (this.f128555a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return TuplesKt.a(obj2, obj3);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$2$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$collectCombinedWhenStarted$2$1$2", f = "FlowsExt.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function3<Pair<Object, Object>, Object, Continuation<? super Triple<Object, Object, Object>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f128558a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f128559b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f128560c;

            AnonymousClass2(Continuation continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Pair pair, Object obj, Continuation continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
                anonymousClass2.f128559b = pair;
                anonymousClass2.f128560c = obj;
                return anonymousClass2.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Pair pair = (Pair) this.f128559b;
                Object obj2 = this.f128560c;
                IntrinsicsKt.f();
                if (this.f128558a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return new Triple(pair.e(), pair.f(), obj2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Flow flow, Flow flow2, Flow flow3, Function3 function3, Continuation continuation) {
            super(2, continuation);
            this.f128551b = flow;
            this.f128552c = flow2;
            this.f128553d = flow3;
            this.f128554f = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f128551b, this.f128552c, this.f128553d, this.f128554f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f128550a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowJ = FlowKt.J(FlowKt.J(this.f128551b, this.f128552c, new C03071(null)), this.f128553d, new AnonymousClass2(null));
                final Function3 function3 = this.f128554f;
                FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt.collectCombinedWhenStarted.2.1.3
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object emit(Triple triple, Continuation continuation) {
                        function3.invoke(triple.d(), triple.e(), triple.f());
                        return Unit.f139807a;
                    }
                };
                this.f128550a = 1;
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
    FlowsExtKt$collectCombinedWhenStarted$2(LifecycleOwner lifecycleOwner, Flow flow, Flow flow2, Flow flow3, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f128545b = lifecycleOwner;
        this.f128546c = flow;
        this.f128547d = flow2;
        this.f128548f = flow3;
        this.f128549g = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FlowsExtKt$collectCombinedWhenStarted$2(this.f128545b, this.f128546c, this.f128547d, this.f128548f, this.f128549g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f128544a;
        if (i3 == 0) {
            ResultKt.b(obj);
            LifecycleOwner lifecycleOwner = this.f128545b;
            Lifecycle.State state = Lifecycle.State.f39950d;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f128546c, this.f128547d, this.f128548f, this.f128549g, null);
            this.f128544a = 1;
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
        return ((FlowsExtKt$collectCombinedWhenStarted$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
