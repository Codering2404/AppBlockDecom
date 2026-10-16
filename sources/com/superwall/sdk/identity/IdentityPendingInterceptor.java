package com.superwall.sdk.identity;

import com.superwall.sdk.identity.IdentityState;
import com.superwall.sdk.misc.primitives.StateActor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

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
public final class IdentityPendingInterceptor {
    public static final IdentityPendingInterceptor INSTANCE = new IdentityPendingInterceptor();

    /* JADX INFO: renamed from: com.superwall.sdk.identity.IdentityPendingInterceptor$install$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.identity.IdentityPendingInterceptor$install$2", f = "IdentityPendingInterceptor.kt", l = {18}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function3<Object, Function1<? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> {
        final /* synthetic */ StateActor<IdentityContext, IdentityState> $actor;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(StateActor<IdentityContext, IdentityState> stateActor, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.$actor = stateActor;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0080  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r0 = r4.L$0
                kotlin.ResultKt.b(r5)     // Catch: java.lang.Throwable -> L11
                goto L30
            L11:
                r5 = move-exception
                goto L64
            L13:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1b:
                kotlin.ResultKt.b(r5)
                java.lang.Object r5 = r4.L$0
                java.lang.Object r1 = r4.L$1
                kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
                r4.L$0 = r5     // Catch: java.lang.Throwable -> L60
                r4.label = r2     // Catch: java.lang.Throwable -> L60
                java.lang.Object r1 = r1.invoke(r4)     // Catch: java.lang.Throwable -> L60
                if (r1 != r0) goto L2f
                return r0
            L2f:
                r0 = r5
            L30:
                boolean r5 = r0 instanceof com.superwall.sdk.identity.IdentityState.Actions.Identify
                if (r5 == 0) goto L46
                com.superwall.sdk.misc.primitives.StateActor<com.superwall.sdk.identity.IdentityContext, com.superwall.sdk.identity.IdentityState> r5 = r4.$actor
                com.superwall.sdk.identity.IdentityState$Updates$EndIdentify r1 = new com.superwall.sdk.identity.IdentityState$Updates$EndIdentify
                com.superwall.sdk.identity.IdentityState$Actions$Identify r0 = (com.superwall.sdk.identity.IdentityState.Actions.Identify) r0
                java.lang.String r0 = r0.getUserId()
                r1.<init>(r0)
                r5.update(r1)
                goto L5d
            L46:
                boolean r5 = r0 instanceof com.superwall.sdk.identity.IdentityState.Actions.MergeAttributes
                if (r5 == 0) goto L52
                com.superwall.sdk.misc.primitives.StateActor<com.superwall.sdk.identity.IdentityContext, com.superwall.sdk.identity.IdentityState> r5 = r4.$actor
                com.superwall.sdk.identity.IdentityState$Updates$EndAttributes r0 = com.superwall.sdk.identity.IdentityState.Updates.EndAttributes.INSTANCE
                r5.update(r0)
                goto L5d
            L52:
                boolean r5 = r0 instanceof com.superwall.sdk.identity.IdentityState.Actions.FullReset
                if (r5 == 0) goto L5d
                com.superwall.sdk.misc.primitives.StateActor<com.superwall.sdk.identity.IdentityContext, com.superwall.sdk.identity.IdentityState> r5 = r4.$actor
                com.superwall.sdk.identity.IdentityState$Updates$EndReset r0 = com.superwall.sdk.identity.IdentityState.Updates.EndReset.INSTANCE
                r5.update(r0)
            L5d:
                kotlin.Unit r5 = kotlin.Unit.f139807a
                return r5
            L60:
                r0 = move-exception
                r3 = r0
                r0 = r5
                r5 = r3
            L64:
                boolean r1 = r0 instanceof com.superwall.sdk.identity.IdentityState.Actions.Identify
                if (r1 != 0) goto L80
                boolean r1 = r0 instanceof com.superwall.sdk.identity.IdentityState.Actions.MergeAttributes
                if (r1 != 0) goto L78
                boolean r0 = r0 instanceof com.superwall.sdk.identity.IdentityState.Actions.FullReset
                if (r0 == 0) goto L90
                com.superwall.sdk.misc.primitives.StateActor<com.superwall.sdk.identity.IdentityContext, com.superwall.sdk.identity.IdentityState> r0 = r4.$actor
                com.superwall.sdk.identity.IdentityState$Updates$EndReset r1 = com.superwall.sdk.identity.IdentityState.Updates.EndReset.INSTANCE
                r0.update(r1)
                goto L90
            L78:
                com.superwall.sdk.misc.primitives.StateActor<com.superwall.sdk.identity.IdentityContext, com.superwall.sdk.identity.IdentityState> r0 = r4.$actor
                com.superwall.sdk.identity.IdentityState$Updates$EndAttributes r1 = com.superwall.sdk.identity.IdentityState.Updates.EndAttributes.INSTANCE
                r0.update(r1)
                goto L90
            L80:
                com.superwall.sdk.misc.primitives.StateActor<com.superwall.sdk.identity.IdentityContext, com.superwall.sdk.identity.IdentityState> r1 = r4.$actor
                com.superwall.sdk.identity.IdentityState$Updates$EndIdentify r2 = new com.superwall.sdk.identity.IdentityState$Updates$EndIdentify
                com.superwall.sdk.identity.IdentityState$Actions$Identify r0 = (com.superwall.sdk.identity.IdentityState.Actions.Identify) r0
                java.lang.String r0 = r0.getUserId()
                r2.<init>(r0)
                r1.update(r2)
            L90:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.identity.IdentityPendingInterceptor.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$actor, continuation);
            anonymousClass2.L$0 = obj;
            anonymousClass2.L$1 = function1;
            return anonymousClass2.invokeSuspend(Unit.f139807a);
        }
    }

    private IdentityPendingInterceptor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit install$lambda$0(StateActor stateActor, Object action, Function0 next) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof IdentityState.Actions.Identify) {
            stateActor.update(new IdentityState.Updates.BeginIdentify(((IdentityState.Actions.Identify) action).getUserId()));
        } else if (action instanceof IdentityState.Actions.MergeAttributes) {
            stateActor.update(IdentityState.Updates.BeginAttributes.INSTANCE);
        } else if (action instanceof IdentityState.Actions.FullReset) {
            stateActor.update(IdentityState.Updates.BeginReset.INSTANCE);
        }
        next.invoke();
        return Unit.f139807a;
    }

    public final void install(final StateActor<IdentityContext, IdentityState> actor) {
        Intrinsics.checkNotNullParameter(actor, "actor");
        actor.onAction(new Function2() { // from class: com.superwall.sdk.identity.c
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return IdentityPendingInterceptor.install$lambda$0(actor, obj, (Function0) obj2);
            }
        });
        actor.onActionExecution(new AnonymousClass2(actor, null));
    }
}
