package com.superwall.sdk.misc;

import com.superwall.sdk.misc.Either;
import com.superwall.sdk.network.NetworkError;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [T] */
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
@DebugMetadata(c = "com.superwall.sdk.misc.Task_RetryingKt$retrying$2$1", f = "Task+Retrying.kt", l = {35}, m = "invokeSuspend")
final class Task_RetryingKt$retrying$2$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either.Success<T, NetworkError>>, Object> {
    final /* synthetic */ Function1<Continuation<? super Either<? extends T, NetworkError>>, Object> $operation;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    Task_RetryingKt$retrying$2$1(Function1<? super Continuation<? super Either<? extends T, NetworkError>>, ? extends Object> function1, Continuation<? super Task_RetryingKt$retrying$2$1> continuation) {
        super(2, continuation);
        this.$operation = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Task_RetryingKt$retrying$2$1(this.$operation, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            Function1<Continuation<? super Either<? extends T, NetworkError>>, Object> function1 = this.$operation;
            this.label = 1;
            obj = function1.invoke(this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        Either either = (Either) obj;
        if (either instanceof Either.Success) {
            return either;
        }
        if (either instanceof Either.Failure) {
            throw ((Either.Failure) either).getError();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either.Success<T, NetworkError>> continuation) {
        return ((Task_RetryingKt$retrying$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
