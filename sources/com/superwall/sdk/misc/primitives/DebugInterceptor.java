package com.superwall.sdk.misc.primitives;

import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

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
public final class DebugInterceptor {
    public static final DebugInterceptor INSTANCE = new DebugInterceptor();

    /* JADX INFO: renamed from: com.superwall.sdk.misc.primitives.DebugInterceptor$install$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.misc.primitives.DebugInterceptor$install$3", f = "DebugInterceptor.kt", l = {66}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements Function3<Object, Function1<? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> {
        final /* synthetic */ LogLevel $level;
        final /* synthetic */ String $name;
        final /* synthetic */ LogScope $scope;
        long J$0;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(LogLevel logLevel, LogScope logScope, String str, Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
            this.$level = logLevel;
            this.$scope = logScope;
            this.$name = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String str;
            long j3;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Object obj2 = this.L$0;
                Function1 function1 = (Function1) this.L$1;
                String strLabelOf = DebugInterceptor.INSTANCE.labelOf(obj2);
                long jNanoTime = System.nanoTime();
                this.L$0 = strLabelOf;
                this.J$0 = jNanoTime;
                this.label = 1;
                if (function1.invoke(this) == objF) {
                    return objF;
                }
                str = strLabelOf;
                j3 = jNanoTime;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j3 = this.J$0;
                str = (String) this.L$0;
                ResultKt.b(obj);
            }
            long jNanoTime2 = (System.nanoTime() - j3) / ((long) 1000000);
            Logger.debug$default(Logger.INSTANCE, this.$level, this.$scope, "Interceptor: [" + this.$name + "] action ✓ " + str + " | " + jNanoTime2 + "ms", (Map) null, (Throwable) null, 24, (Object) null);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$level, this.$scope, this.$name, continuation);
            anonymousClass3.L$0 = obj;
            anonymousClass3.L$1 = function1;
            return anonymousClass3.invokeSuspend(Unit.f139807a);
        }
    }

    private DebugInterceptor() {
    }

    public static /* synthetic */ void install$default(DebugInterceptor debugInterceptor, StateActor stateActor, String str, LogScope logScope, LogLevel logLevel, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            logScope = LogScope.superwallCore;
        }
        if ((i3 & 8) != 0) {
            logLevel = LogLevel.debug;
        }
        debugInterceptor.install(stateActor, str, logScope, logLevel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit install$lambda$0(LogLevel logLevel, LogScope logScope, String str, Reducer reducer, Function1 next) {
        Intrinsics.checkNotNullParameter(reducer, "reducer");
        Intrinsics.checkNotNullParameter(next, "next");
        String strLabelOf = INSTANCE.labelOf(reducer);
        long jNanoTime = System.nanoTime();
        next.invoke(reducer);
        long jNanoTime2 = (System.nanoTime() - jNanoTime) / ((long) 1000000);
        Logger.debug$default(Logger.INSTANCE, logLevel, logScope, "Interceptor: [" + str + "] update → " + strLabelOf + " | " + jNanoTime2 + "ms", (Map) null, (Throwable) null, 24, (Object) null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit install$lambda$1(LogLevel logLevel, LogScope logScope, String str, Object action, Function0 next) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        String strLabelOf = INSTANCE.labelOf(action);
        Logger.debug$default(Logger.INSTANCE, logLevel, logScope, "Interceptor: [" + str + "] action → " + strLabelOf, (Map) null, (Throwable) null, 24, (Object) null);
        next.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String labelOf(Object obj) {
        KClass kClassB = Reflection.b(obj.getClass());
        String strM = kClassB.m();
        if (strM == null && (strM = kClassB.h()) == null) {
            strM = "anonymous";
        }
        String string = obj.toString();
        return StringsKt.U(string, strM, false, 2, null) ? string : strM;
    }

    public final <Ctx, S> void install(StateActor<Ctx, S> actor, final String name, final LogScope scope, final LogLevel level) {
        Intrinsics.checkNotNullParameter(actor, "actor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(level, "level");
        actor.onUpdate(new Function2() { // from class: com.superwall.sdk.misc.primitives.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DebugInterceptor.install$lambda$0(level, scope, name, (Reducer) obj, (Function1) obj2);
            }
        });
        actor.onAction(new Function2() { // from class: com.superwall.sdk.misc.primitives.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DebugInterceptor.install$lambda$1(level, scope, name, obj, (Function0) obj2);
            }
        });
        actor.onActionExecution(new AnonymousClass3(level, scope, name, null));
    }
}
