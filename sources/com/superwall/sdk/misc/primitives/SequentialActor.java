package com.superwall.sdk.misc.primitives;

import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

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
public final class SequentialActor<Context, S> extends StateActor<Context, S> {
    private final Channel<Function1<Continuation<? super Unit>, Object>> queue;

    /* JADX INFO: renamed from: com.superwall.sdk.misc.primitives.SequentialActor$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.misc.primitives.SequentialActor$1", f = "ActorTypes.kt", l = {39, 40}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ SequentialActor<Context, S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SequentialActor<Context, S> sequentialActor, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = sequentialActor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
        
            if (r8.invoke(r7) == r0) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0080  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0059 -> B:25:0x005c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L28
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L16
                goto L5c
            L16:
                r8 = move-exception
                goto L65
            L18:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L20:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.b(r8)
                goto L43
            L28:
                kotlin.ResultKt.b(r8)
                com.superwall.sdk.misc.primitives.SequentialActor<Context, S> r8 = r7.this$0
                kotlinx.coroutines.channels.Channel r8 = com.superwall.sdk.misc.primitives.SequentialActor.access$getQueue$p(r8)
                kotlinx.coroutines.channels.ChannelIterator r8 = r8.iterator()
            L35:
                r7.L$0 = r8
                r7.label = r3
                java.lang.Object r1 = r8.a(r7)
                if (r1 != r0) goto L40
                goto L5b
            L40:
                r6 = r1
                r1 = r8
                r8 = r6
            L43:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L80
                java.lang.Object r8 = r1.next()
                kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
                r7.L$0 = r1     // Catch: java.lang.Throwable -> L16
                r7.label = r2     // Catch: java.lang.Throwable -> L16
                java.lang.Object r8 = r8.invoke(r7)     // Catch: java.lang.Throwable -> L16
                if (r8 != r0) goto L5c
            L5b:
                return r0
            L5c:
                kotlin.Unit r8 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L16
                com.superwall.sdk.misc.Either$Success r4 = new com.superwall.sdk.misc.Either$Success     // Catch: java.lang.Throwable -> L16
                r4.<init>(r8)     // Catch: java.lang.Throwable -> L16
            L63:
                r8 = r1
                goto L35
            L65:
                boolean r4 = com.superwall.sdk.utilities.ErrorTrackingKt.shouldLog(r8)
                if (r4 == 0) goto L7a
                com.superwall.sdk.Superwall$Companion r4 = com.superwall.sdk.Superwall.Companion
                boolean r5 = r4.getInitialized()
                if (r5 == 0) goto L7a
                com.superwall.sdk.Superwall r4 = r4.getInstance()
                com.superwall.sdk.utilities.ErrorTrackingKt.trackError(r4, r8)
            L7a:
                com.superwall.sdk.misc.Either$Failure r4 = new com.superwall.sdk.misc.Either$Failure
                r4.<init>(r8)
                goto L63
            L80:
                kotlin.Unit r8 = kotlin.Unit.f139807a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.misc.primitives.SequentialActor.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class OwnerElement extends AbstractCoroutineContextElement {
        public static final Key Key = new Key(null);
        private final Object actor;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Key implements CoroutineContext.Key<OwnerElement> {
            public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Key() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OwnerElement(Object actor) {
            super(Key);
            Intrinsics.checkNotNullParameter(actor, "actor");
            this.actor = actor;
        }

        public final Object getActor() {
            return this.actor;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.misc.primitives.SequentialActor$executeAction$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.misc.primitives.SequentialActor$executeAction$2", f = "ActorTypes.kt", l = {57}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TypedAction<Ctx> $action;
        final /* synthetic */ Ctx $ctx;
        final /* synthetic */ CompletableDeferred<Unit> $done;
        int label;
        final /* synthetic */ SequentialActor<Context, S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SequentialActor<Context, S> sequentialActor, Ctx ctx, TypedAction<Ctx> typedAction, CompletableDeferred<Unit> completableDeferred, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.this$0 = sequentialActor;
            this.$ctx = ctx;
            this.$action = typedAction;
            this.$done = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$ctx, this.$action, this.$done, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            try {
                if (i3 == 0) {
                    ResultKt.b(obj);
                    SequentialActor<Context, S> sequentialActor = this.this$0;
                    Ctx ctx = this.$ctx;
                    TypedAction<Ctx> typedAction = this.$action;
                    this.label = 1;
                    if (SequentialActor.super.executeAction(ctx, typedAction, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                this.$done.J(Unit.f139807a);
            } catch (Throwable th) {
                this.$done.a(th);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public /* synthetic */ SequentialActor(Object obj, CoroutineScope coroutineScope, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i3 & 2) != 0 ? CoroutineScopeKt.a(Dispatchers.b()) : coroutineScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit effect$lambda$0(SequentialActor sequentialActor, TypedAction typedAction, Object obj) {
        sequentialActor.queue.h(new SequentialActor$effect$1$1(sequentialActor, typedAction, obj, null));
        return Unit.f139807a;
    }

    public final void close() {
        SendChannel.DefaultImpls.a(this.queue, null, 1, null);
    }

    @Override // com.superwall.sdk.misc.primitives.StateActor, com.superwall.sdk.misc.primitives.Actor
    public <Ctx> void effect(final Ctx ctx, final TypedAction<Ctx> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        runInterceptorChain(action, new Function0() { // from class: com.superwall.sdk.misc.primitives.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SequentialActor.effect$lambda$0(this.f93585a, action, ctx);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.superwall.sdk.misc.primitives.StateActor
    public <Ctx> Object executeAction(Ctx ctx, TypedAction<Ctx> typedAction, Continuation<? super Unit> continuation) {
        OwnerElement ownerElement = (OwnerElement) continuation.getContext().get(OwnerElement.Key);
        if ((ownerElement != null ? ownerElement.getActor() : null) == this) {
            Object objExecuteAction = super.executeAction(ctx, typedAction, continuation);
            return objExecuteAction == IntrinsicsKt.f() ? objExecuteAction : Unit.f139807a;
        }
        CompletableDeferred completableDeferredB = CompletableDeferredKt.b(null, 1, null);
        this.queue.h(new AnonymousClass2(this, ctx, typedAction, completableDeferredB, null));
        Object objAwait = completableDeferredB.await(continuation);
        return objAwait == IntrinsicsKt.f() ? objAwait : Unit.f139807a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequentialActor(S s2, CoroutineScope scope) {
        super(s2, scope);
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.queue = ChannelKt.b(Api.BaseClientBuilder.API_PRIORITY_OTHER, null, null, 6, null);
        BuildersKt__Builders_commonKt.d(scope, new OwnerElement(this), null, new AnonymousClass1(this, null), 2, null);
    }
}
