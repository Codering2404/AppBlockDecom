package com.superwall.sdk;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.utilities.ErrorTrackingKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.superwall.sdk.Superwall$setup$1$1$1", f = "Superwall.kt", l = {723}, m = "invokeSuspend")
final class Superwall$setup$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Superwall this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Superwall$setup$1$1$1(Superwall superwall, Continuation<? super Superwall$setup$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = superwall;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Superwall$setup$1$1$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Either failure;
        Object objB;
        Object objF;
        Object objF2 = IntrinsicsKt.f();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                Superwall superwall = this.this$0;
                superwall.getDependencyContainer$superwall_release().getStorage().recordAppInstall(new Superwall$setup$1$1$1$1$1(superwall, null));
                Superwall$setup$1$1$1$1$2 superwall$setup$1$1$1$1$2 = new Superwall$setup$1$1$1$1$2(superwall, null);
                this.label = 1;
                objF = CoroutineScopeKt.f(superwall$setup$1$1$1$1$2, this);
                if (objF == objF2) {
                    return objF2;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                objF = obj;
            }
            failure = new Either.Success((List) objF);
        } catch (Throwable th) {
            if (ErrorTrackingKt.shouldLog(th)) {
                Superwall.Companion companion = Superwall.Companion;
                if (companion.getInitialized()) {
                    ErrorTrackingKt.trackError(companion.getInstance(), th);
                }
            }
            failure = new Either.Failure(th);
        }
        if (failure instanceof Either.Success) {
            Result.Companion companion2 = Result.f139772b;
            objB = Result.b(((Either.Success) failure).getValue());
        } else {
            if (!(failure instanceof Either.Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            Result.Companion companion3 = Result.f139772b;
            objB = Result.b(ResultKt.a(((Either.Failure) failure).getError()));
        }
        Superwall superwall2 = this.this$0;
        Throwable thE = Result.e(objB);
        if (thE == null) {
            BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), null, null, new Superwall$setup$1$1$1$2$1(superwall2, null), 3, null);
        } else {
            BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), null, null, new Superwall$setup$1$1$1$3$1(superwall2, thE, null), 3, null);
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.superwallCore, "Superwall SDK failed to initialize - " + thE.getMessage(), (Map) null, thE, 8, (Object) null);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Superwall$setup$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
