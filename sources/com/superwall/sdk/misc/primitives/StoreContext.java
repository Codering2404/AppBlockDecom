package com.superwall.sdk.misc.primitives;

import com.superwall.sdk.misc.primitives.StoreContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlow;

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
public interface StoreContext<S, Self extends StoreContext<S, Self>> extends StateStore<S> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static <S, Self extends StoreContext<S, Self>> void effect(StoreContext<S, Self> storeContext, TypedAction<Self> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            StateActor<Self, S> actor = storeContext.getActor();
            Intrinsics.checkNotNull(storeContext, "null cannot be cast to non-null type Self of com.superwall.sdk.misc.primitives.StoreContext");
            actor.effect(storeContext, action);
        }

        public static <S, Self extends StoreContext<S, Self>> StateFlow<S> getState(StoreContext<S, Self> storeContext) {
            return storeContext.getActor().getState();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <S, Self extends StoreContext<S, Self>> Object immediate(StoreContext<S, Self> storeContext, TypedAction<Self> typedAction, Continuation<? super Unit> continuation) {
            StateActor<Self, S> actor = storeContext.getActor();
            Intrinsics.checkNotNull(storeContext, "null cannot be cast to non-null type Self of com.superwall.sdk.misc.primitives.StoreContext");
            Object objImmediate = actor.immediate(storeContext, typedAction, continuation);
            return objImmediate == IntrinsicsKt.f() ? objImmediate : Unit.f139807a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <S, Self extends StoreContext<S, Self>> Object immediateUntil(StoreContext<S, Self> storeContext, TypedAction<Self> typedAction, Function1<? super S, Boolean> function1, Continuation<? super Unit> continuation) {
            StateActor<Self, S> actor = storeContext.getActor();
            Intrinsics.checkNotNull(storeContext, "null cannot be cast to non-null type Self of com.superwall.sdk.misc.primitives.StoreContext");
            Object objImmediateUntil = actor.immediateUntil(storeContext, typedAction, function1, continuation);
            return objImmediateUntil == IntrinsicsKt.f() ? objImmediateUntil : Unit.f139807a;
        }

        public static <S, Self extends StoreContext<S, Self>> void sideEffect(StoreContext<S, Self> storeContext, Function1<? super Continuation<? super Unit>, ? extends Object> what) {
            Intrinsics.checkNotNullParameter(what, "what");
            BuildersKt__Builders_commonKt.d(storeContext.getScope(), null, null, new AnonymousClass1(what, null), 3, null);
        }

        public static <S, Self extends StoreContext<S, Self>> void update(StoreContext<S, Self> storeContext, Reducer<S> reducer) {
            Intrinsics.checkNotNullParameter(reducer, "reducer");
            storeContext.getActor().update(reducer);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.misc.primitives.StoreContext$sideEffect$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.misc.primitives.StoreContext$sideEffect$1", f = "StoreContext.kt", l = {52}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $what;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$what = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$what, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function1<Continuation<? super Unit>, Object> function1 = this.$what;
                this.label = 1;
                if (function1.invoke(this) == objF) {
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
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    void effect(TypedAction<Self> typedAction);

    StateActor<Self, S> getActor();

    CoroutineScope getScope();

    @Override // com.superwall.sdk.misc.primitives.StateStore
    StateFlow<S> getState();

    Object immediate(TypedAction<Self> typedAction, Continuation<? super Unit> continuation);

    Object immediateUntil(TypedAction<Self> typedAction, Function1<? super S, Boolean> function1, Continuation<? super Unit> continuation);

    void sideEffect(Function1<? super Continuation<? super Unit>, ? extends Object> function1);

    @Override // com.superwall.sdk.misc.primitives.StateStore
    void update(Reducer<S> reducer);
}
