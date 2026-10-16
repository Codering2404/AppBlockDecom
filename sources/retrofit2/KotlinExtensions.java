package retrofit2;

import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class KotlinExtensions {
    public static final Object a(final Call call, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        cancellableContinuationImpl.m(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f139807a;
            }

            public final void invoke(Throwable th) {
                call.cancel();
            }
        });
        call.A0(new Callback<Object>() { // from class: retrofit2.KotlinExtensions$await$2$2
            @Override // retrofit2.Callback
            public void a(Call call2, Throwable t2) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(t2, "t");
                CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.f139772b;
                cancellableContinuation.resumeWith(Result.b(ResultKt.a(t2)));
            }

            @Override // retrofit2.Callback
            public void b(Call call2, Response response) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.e()) {
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.f139772b;
                    cancellableContinuation.resumeWith(Result.b(ResultKt.a(new HttpException(response))));
                    return;
                }
                Object objA = response.a();
                if (objA != null) {
                    cancellableContinuationImpl.resumeWith(Result.b(objA));
                    return;
                }
                Object objJ = call2.l().j(Invocation.class);
                Intrinsics.checkNotNull(objJ);
                Invocation invocation = (Invocation) objJ;
                KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException("Response from " + invocation.b().getName() + '.' + invocation.a().getName() + " was null but response body type was declared as non-null");
                CancellableContinuation cancellableContinuation2 = cancellableContinuationImpl;
                Result.Companion companion2 = Result.f139772b;
                cancellableContinuation2.resumeWith(Result.b(ResultKt.a(kotlinNullPointerException)));
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static final Object b(final Call call, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        cancellableContinuationImpl.m(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$4$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f139807a;
            }

            public final void invoke(Throwable th) {
                call.cancel();
            }
        });
        call.A0(new Callback<Object>() { // from class: retrofit2.KotlinExtensions$await$4$2
            @Override // retrofit2.Callback
            public void a(Call call2, Throwable t2) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(t2, "t");
                CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.f139772b;
                cancellableContinuation.resumeWith(Result.b(ResultKt.a(t2)));
            }

            @Override // retrofit2.Callback
            public void b(Call call2, Response response) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.e()) {
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.f139772b;
                    cancellableContinuation.resumeWith(Result.b(response.a()));
                } else {
                    CancellableContinuation cancellableContinuation2 = cancellableContinuationImpl;
                    Result.Companion companion2 = Result.f139772b;
                    cancellableContinuation2.resumeWith(Result.b(ResultKt.a(new HttpException(response))));
                }
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static final Object c(final Call call, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        cancellableContinuationImpl.m(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f139807a;
            }

            public final void invoke(Throwable th) {
                call.cancel();
            }
        });
        call.A0(new Callback<Object>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
            @Override // retrofit2.Callback
            public void a(Call call2, Throwable t2) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(t2, "t");
                CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.f139772b;
                cancellableContinuation.resumeWith(Result.b(ResultKt.a(t2)));
            }

            @Override // retrofit2.Callback
            public void b(Call call2, Response response) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                cancellableContinuationImpl.resumeWith(Result.b(response));
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static final Object d(Call call, Continuation continuation) {
        Intrinsics.checkNotNull(call, "null cannot be cast to non-null type retrofit2.Call<kotlin.Unit?>");
        return b(call, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object e(final java.lang.Throwable r4, kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.f146867c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f146867c = r1
            goto L18
        L13:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f146866b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f146867c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2d:
            java.lang.Object r4 = r0.f146865a
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            kotlin.ResultKt.b(r5)
            goto L5c
        L35:
            kotlin.ResultKt.b(r5)
            r0.f146865a = r4
            r0.f146867c = r3
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.a()
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            retrofit2.KotlinExtensions$suspendAndThrow$2$1 r3 = new retrofit2.KotlinExtensions$suspendAndThrow$2$1
            r3.<init>()
            r5.M(r2, r3)
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r4 != r5) goto L59
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L59:
            if (r4 != r1) goto L5c
            return r1
        L5c:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.e(java.lang.Throwable, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
