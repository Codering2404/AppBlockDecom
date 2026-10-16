package com.superwall.sdk.misc.primitives;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public class StateActor<Context, S> implements StateStore<S>, Actor<Context, S> {
    private final MutableStateFlow<S> _state;
    private List<? extends Function2<Object, ? super Function0<Unit>, Unit>> actionInterceptors;
    private List<? extends Function3<Object, ? super Function1<? super Continuation<? super Unit>, ? extends Object>, ? super Continuation<? super Unit>, ? extends Object>> asyncActionInterceptors;
    private final CoroutineScope scope;
    private final StateFlow<S> state;
    private Function1<? super Reducer<S>, Unit> updateChain;

    /* JADX INFO: renamed from: com.superwall.sdk.misc.primitives.StateActor$executeAction$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.misc.primitives.StateActor$executeAction$2", f = "StateActor.kt", l = {157}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TypedAction<Ctx> $action;
        final /* synthetic */ Ctx $ctx;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TypedAction<Ctx> typedAction, Ctx ctx, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$action = typedAction;
            this.$ctx = ctx;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$action, this.$ctx, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function2 execute = this.$action.getExecute();
                Object obj2 = this.$ctx;
                this.label = 1;
                if (execute.invoke(obj2, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.misc.primitives.StateActor$immediateUntil$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.misc.primitives.StateActor$immediateUntil$2", f = "StateActor.kt", l = {}, m = "invokeSuspend")
    static final class C28162 extends SuspendLambda implements Function2<S, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<S, Boolean> $until;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C28162(Function1<? super S, Boolean> function1, Continuation<? super C28162> continuation) {
            super(2, continuation);
            this.$until = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C28162 c28162 = new C28162(this.$until, continuation);
            c28162.L$0 = obj;
            return c28162;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return this.$until.invoke(this.L$0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(S s2, Continuation<? super Boolean> continuation) {
            return ((C28162) create(s2, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.misc.primitives.StateActor$runAsyncInterceptorChain$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.misc.primitives.StateActor$runAsyncInterceptorChain$2", f = "StateActor.kt", l = {171}, m = "invokeSuspend")
    static final class C28172 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $action;
        final /* synthetic */ Function3<Object, Function1<? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> $interceptor;
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $next;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C28172(Function3<Object, ? super Function1<? super Continuation<? super Unit>, ? extends Object>, ? super Continuation<? super Unit>, ? extends Object> function3, Object obj, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super C28172> continuation) {
            super(1, continuation);
            this.$interceptor = function3;
            this.$action = obj;
            this.$next = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C28172(this.$interceptor, this.$action, this.$next, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function3<Object, Function1<? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> function3 = this.$interceptor;
                Object obj2 = this.$action;
                Function1<Continuation<? super Unit>, Object> function1 = this.$next;
                this.label = 1;
                if (function3.invoke(obj2, function1, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C28172) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public StateActor(S s2, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        MutableStateFlow<S> mutableStateFlowA = StateFlowKt.a(s2);
        this._state = mutableStateFlowA;
        this.state = FlowKt.c(mutableStateFlowA);
        this.updateChain = new Function1() { // from class: com.superwall.sdk.misc.primitives.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateActor.updateChain$lambda$1(this.f93596a, (Reducer) obj);
            }
        };
        this.actionInterceptors = CollectionsKt.emptyList();
        this.asyncActionInterceptors = CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit effect$lambda$3(StateActor stateActor, Object obj, TypedAction typedAction) {
        BuildersKt__Builders_commonKt.d(stateActor.scope, null, null, new StateActor$effect$execute$1$1(stateActor, obj, typedAction, null), 3, null);
        return Unit.f139807a;
    }

    static /* synthetic */ <Context, S, Ctx> Object executeAction$suspendImpl(StateActor<Context, S> stateActor, Ctx ctx, TypedAction<Ctx> typedAction, Continuation<? super Unit> continuation) {
        Object objRunAsyncInterceptorChain = stateActor.runAsyncInterceptorChain(typedAction, new AnonymousClass2(typedAction, ctx, null), continuation);
        return objRunAsyncInterceptorChain == IntrinsicsKt.f() ? objRunAsyncInterceptorChain : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit immediate$lambda$4(Ref.BooleanRef booleanRef) {
        booleanRef.f140137a = true;
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit immediate$lambda$5(Function2 function2, TypedAction typedAction, Function0 function0) {
        function2.invoke(typedAction, function0);
        return Unit.f139807a;
    }

    static /* synthetic */ <Context, S, Ctx> Object immediate$suspendImpl(StateActor<Context, S> stateActor, Ctx ctx, final TypedAction<Ctx> typedAction, Continuation<? super Unit> continuation) {
        Function0 function0;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.f140137a = true;
        if (!((StateActor) stateActor).actionInterceptors.isEmpty()) {
            booleanRef.f140137a = false;
            final Function0 function02 = new Function0() { // from class: com.superwall.sdk.misc.primitives.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StateActor.immediate$lambda$4(booleanRef);
                }
            };
            int size = ((StateActor) stateActor).actionInterceptors.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i3 = size - 1;
                    final Function2<Object, ? super Function0<Unit>, Unit> function2 = ((StateActor) stateActor).actionInterceptors.get(size);
                    function0 = new Function0() { // from class: com.superwall.sdk.misc.primitives.i
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return StateActor.immediate$lambda$5(function2, typedAction, function02);
                        }
                    };
                    if (i3 < 0) {
                        break;
                    }
                    size = i3;
                    function02 = function0;
                }
                function02 = function0;
            }
            function02.invoke();
        }
        if (!booleanRef.f140137a) {
            return Unit.f139807a;
        }
        Object objExecuteAction = stateActor.executeAction(ctx, typedAction, continuation);
        return objExecuteAction == IntrinsicsKt.f() ? objExecuteAction : Unit.f139807a;
    }

    static /* synthetic */ <Context, S, Ctx> Object immediateUntil$suspendImpl(StateActor<Context, S> stateActor, Ctx ctx, TypedAction<Ctx> typedAction, Function1<? super S, Boolean> function1, Continuation<? super S> continuation) {
        stateActor.effect(ctx, typedAction);
        return FlowKt.E(stateActor.getState(), new C28162(function1, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onUpdate$lambda$2(Function2 function2, Function1 function1, Reducer reducer) {
        Intrinsics.checkNotNullParameter(reducer, "reducer");
        function2.invoke(reducer, function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runInterceptorChain$lambda$6(Function2 function2, Object obj, Function0 function0) {
        function2.invoke(obj, function0);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateChain$lambda$1(StateActor stateActor, Reducer reducer) {
        Object value;
        Intrinsics.checkNotNullParameter(reducer, "reducer");
        MutableStateFlow<S> mutableStateFlow = stateActor._state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, reducer.getReduce().invoke(value)));
        return Unit.f139807a;
    }

    public <Ctx> void effect(final Ctx ctx, final TypedAction<Ctx> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        runInterceptorChain(action, new Function0() { // from class: com.superwall.sdk.misc.primitives.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StateActor.effect$lambda$3(this.f93588a, ctx, action);
            }
        });
    }

    protected <Ctx> Object executeAction(Ctx ctx, TypedAction<Ctx> typedAction, Continuation<? super Unit> continuation) {
        return executeAction$suspendImpl(this, ctx, typedAction, continuation);
    }

    public final CoroutineScope getScope$superwall_release() {
        return this.scope;
    }

    @Override // com.superwall.sdk.misc.primitives.StateStore
    public StateFlow<S> getState() {
        return this.state;
    }

    @Override // com.superwall.sdk.misc.primitives.Actor
    public <Ctx> Object immediate(Ctx ctx, TypedAction<Ctx> typedAction, Continuation<? super Unit> continuation) {
        return immediate$suspendImpl(this, ctx, typedAction, continuation);
    }

    @Override // com.superwall.sdk.misc.primitives.Actor
    public <Ctx> Object immediateUntil(Ctx ctx, TypedAction<Ctx> typedAction, Function1<? super S, Boolean> function1, Continuation<? super S> continuation) {
        return immediateUntil$suspendImpl(this, ctx, typedAction, function1, continuation);
    }

    public final void onAction(Function2<Object, ? super Function0<Unit>, Unit> interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this.actionInterceptors = CollectionsKt.plus((Collection<? extends Function2<Object, ? super Function0<Unit>, Unit>>) this.actionInterceptors, interceptor);
    }

    public final void onActionExecution(Function3<Object, ? super Function1<? super Continuation<? super Unit>, ? extends Object>, ? super Continuation<? super Unit>, ? extends Object> interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this.asyncActionInterceptors = CollectionsKt.plus((Collection<? extends Function3<Object, ? super Function1<? super Continuation<? super Unit>, ? extends Object>, ? super Continuation<? super Unit>, ? extends Object>>) this.asyncActionInterceptors, interceptor);
    }

    public final void onUpdate(final Function2<? super Reducer<S>, ? super Function1<? super Reducer<S>, Unit>, Unit> interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        final Function1<? super Reducer<S>, Unit> function1 = this.updateChain;
        this.updateChain = new Function1() { // from class: com.superwall.sdk.misc.primitives.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateActor.onUpdate$lambda$2(interceptor, function1, (Reducer) obj);
            }
        };
    }

    protected final Object runAsyncInterceptorChain(Object obj, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        C28172 c28172;
        if (this.asyncActionInterceptors.isEmpty()) {
            Object objInvoke = function1.invoke(continuation);
            return objInvoke == IntrinsicsKt.f() ? objInvoke : Unit.f139807a;
        }
        int size = this.asyncActionInterceptors.size() - 1;
        if (size >= 0) {
            while (true) {
                int i3 = size - 1;
                c28172 = new C28172(this.asyncActionInterceptors.get(size), obj, function1, null);
                if (i3 < 0) {
                    break;
                }
                size = i3;
                function1 = c28172;
            }
            function1 = c28172;
        }
        Object objInvoke2 = function1.invoke(continuation);
        return objInvoke2 == IntrinsicsKt.f() ? objInvoke2 : Unit.f139807a;
    }

    protected final void runInterceptorChain(final Object action, final Function0<Unit> terminal) {
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(terminal, "terminal");
        if (this.actionInterceptors.isEmpty()) {
            terminal.invoke();
            return;
        }
        int size = this.actionInterceptors.size() - 1;
        if (size >= 0) {
            while (true) {
                int i3 = size - 1;
                final Function2<Object, ? super Function0<Unit>, Unit> function2 = this.actionInterceptors.get(size);
                function0 = new Function0() { // from class: com.superwall.sdk.misc.primitives.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StateActor.runInterceptorChain$lambda$6(function2, action, terminal);
                    }
                };
                if (i3 < 0) {
                    break;
                }
                size = i3;
                terminal = function0;
            }
            terminal = function0;
        }
        terminal.invoke();
    }

    @Override // com.superwall.sdk.misc.primitives.StateStore
    public void update(Reducer<S> reducer) {
        Intrinsics.checkNotNullParameter(reducer, "reducer");
        this.updateChain.invoke(reducer);
    }
}
