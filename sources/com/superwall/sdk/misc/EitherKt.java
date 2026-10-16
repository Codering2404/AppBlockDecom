package com.superwall.sdk.misc;

import com.superwall.sdk.misc.Either;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class EitherKt {

    /* JADX INFO: renamed from: com.superwall.sdk.misc.EitherKt$asEither$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.misc.EitherKt", f = "Either.kt", l = {137}, m = "asEither")
    static final class AnonymousClass1<T> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EitherKt.asEither(null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.misc.EitherKt$mapAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.misc.EitherKt", f = "Either.kt", l = {71}, m = "mapAsync")
    static final class C28111<In, Out, E extends Throwable> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C28111(Continuation<? super C28111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EitherKt.mapAsync(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.misc.EitherKt$onErrorAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.misc.EitherKt", f = "Either.kt", l = {94}, m = "onErrorAsync")
    static final class C28121<T, E extends Throwable> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C28121(Continuation<? super C28121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EitherKt.onErrorAsync(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.misc.EitherKt$then$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.misc.EitherKt", f = "Either.kt", l = {31}, m = "then")
    static final class C28131<In, E extends Throwable> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C28131(Continuation<? super C28131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EitherKt.then(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.misc.EitherKt$thenIf$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.misc.EitherKt", f = "Either.kt", l = {50}, m = "thenIf")
    static final class C28141<In, E extends Throwable> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C28141(Continuation<? super C28141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EitherKt.thenIf(null, false, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object asEither(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r4, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<? extends T, java.lang.Throwable>> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof com.superwall.sdk.misc.EitherKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            com.superwall.sdk.misc.EitherKt$asEither$1 r0 = (com.superwall.sdk.misc.EitherKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.misc.EitherKt$asEither$1 r0 = new com.superwall.sdk.misc.EitherKt$asEither$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)     // Catch: java.lang.Throwable -> L43
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r5)
            r0.label = r3     // Catch: java.lang.Throwable -> L43
            java.lang.Object r5 = r4.invoke(r0)     // Catch: java.lang.Throwable -> L43
            if (r5 != r1) goto L3d
            return r1
        L3d:
            com.superwall.sdk.misc.Either$Success r4 = new com.superwall.sdk.misc.Either$Success     // Catch: java.lang.Throwable -> L43
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L43
            return r4
        L43:
            r4 = move-exception
            com.superwall.sdk.misc.Either$Failure r5 = new com.superwall.sdk.misc.Either$Failure
            r5.<init>(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.misc.EitherKt.asEither(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final <T> Object asEither$$forInline(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super Either<? extends T, Throwable>> continuation) {
        try {
            return new Either.Success(function1.invoke(continuation));
        } catch (Throwable th) {
            return new Either.Failure(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: eitherWithTimeout-rnQQ1Ag, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T, E extends java.lang.Throwable> java.lang.Object m1275eitherWithTimeoutrnQQ1Ag(long r4, kotlin.jvm.functions.Function0<? extends E> r6, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<? extends T, E>>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<? extends T, E>> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof com.superwall.sdk.misc.EitherKt$eitherWithTimeout$1
            if (r0 == 0) goto L13
            r0 = r8
            com.superwall.sdk.misc.EitherKt$eitherWithTimeout$1 r0 = (com.superwall.sdk.misc.EitherKt$eitherWithTimeout$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.misc.EitherKt$eitherWithTimeout$1 r0 = new com.superwall.sdk.misc.EitherKt$eitherWithTimeout$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            r6 = r4
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L4d
            goto L4a
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.b(r8)
            com.superwall.sdk.misc.EitherKt$eitherWithTimeout$2 r8 = new com.superwall.sdk.misc.EitherKt$eitherWithTimeout$2     // Catch: java.lang.Throwable -> L4d
            r2 = 0
            r8.<init>(r7, r2)     // Catch: java.lang.Throwable -> L4d
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L4d
            r0.label = r3     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.d(r4, r8, r0)     // Catch: java.lang.Throwable -> L4d
            if (r8 != r1) goto L4a
            return r1
        L4a:
            com.superwall.sdk.misc.Either r8 = (com.superwall.sdk.misc.Either) r8     // Catch: java.lang.Throwable -> L4d
            return r8
        L4d:
            com.superwall.sdk.misc.Either$Failure r4 = new com.superwall.sdk.misc.Either$Failure
            java.lang.Object r5 = r6.invoke()
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r4.<init>(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.misc.EitherKt.m1275eitherWithTimeoutrnQQ1Ag(long, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, Out, E extends Throwable> Either<Out, E> flatMap(Either<? extends T, E> either, Function1<? super T, ? extends Either<? extends Out, E>> transform) {
        Intrinsics.checkNotNullParameter(either, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (either instanceof Either.Success) {
            return (Either) transform.invoke(((Either.Success) either).getValue());
        }
        if (either instanceof Either.Failure) {
            return either;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T, E extends Throwable> Object fold(Either<? extends T, E> either, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Function2<? super E, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super Unit> continuation) {
        if (either instanceof Either.Success) {
            Object objInvoke = function2.invoke(((Either.Success) either).getValue(), continuation);
            return objInvoke == IntrinsicsKt.f() ? objInvoke : Unit.f139807a;
        }
        if (!(either instanceof Either.Failure)) {
            throw new NoWhenBranchMatchedException();
        }
        Object objInvoke2 = function22.invoke(((Either.Failure) either).getError(), continuation);
        return objInvoke2 == IntrinsicsKt.f() ? objInvoke2 : Unit.f139807a;
    }

    private static final <T, E extends Throwable> Object fold$$forInline(Either<? extends T, E> either, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Function2<? super E, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super Unit> continuation) {
        if (either instanceof Either.Success) {
            function2.invoke(((Either.Success) either).getValue(), continuation);
            return Unit.f139807a;
        }
        if (!(either instanceof Either.Failure)) {
            throw new NoWhenBranchMatchedException();
        }
        function22.invoke(((Either.Failure) either).getError(), continuation);
        return Unit.f139807a;
    }

    public static final <T, E extends Throwable> Object into(Either<? extends T, E> either, Function2<? super Either<? extends T, E>, ? super Continuation<? super Either<? extends T, E>>, ? extends Object> function2, Continuation<? super Either<? extends T, E>> continuation) {
        return function2.invoke(either, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <In, Out, E extends Throwable> Either<Out, E> map(Either<? extends In, E> either, Function1<? super In, ? extends Out> transform) {
        Intrinsics.checkNotNullParameter(either, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (either instanceof Either.Success) {
            return new Either.Success(transform.invoke(((Either.Success) either).getValue()));
        }
        if (either instanceof Either.Failure) {
            return either;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <In, Out, E extends java.lang.Throwable> java.lang.Object mapAsync(com.superwall.sdk.misc.Either<? extends In, E> r4, kotlin.jvm.functions.Function2<? super In, ? super kotlin.coroutines.Continuation<? super Out>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<? extends Out, E>> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof com.superwall.sdk.misc.EitherKt.C28111
            if (r0 == 0) goto L13
            r0 = r6
            com.superwall.sdk.misc.EitherKt$mapAsync$1 r0 = (com.superwall.sdk.misc.EitherKt.C28111) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.misc.EitherKt$mapAsync$1 r0 = new com.superwall.sdk.misc.EitherKt$mapAsync$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L47
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r6)
            boolean r6 = r4 instanceof com.superwall.sdk.misc.Either.Success
            if (r6 == 0) goto L4d
            com.superwall.sdk.misc.Either$Success r4 = (com.superwall.sdk.misc.Either.Success) r4
            java.lang.Object r4 = r4.getValue()
            r0.label = r3
            java.lang.Object r6 = r5.invoke(r4, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            com.superwall.sdk.misc.Either$Success r4 = new com.superwall.sdk.misc.Either$Success
            r4.<init>(r6)
            return r4
        L4d:
            boolean r5 = r4 instanceof com.superwall.sdk.misc.Either.Failure
            if (r5 == 0) goto L52
            return r4
        L52:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.misc.EitherKt.mapAsync(com.superwall.sdk.misc.Either, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, E extends Throwable, F extends Throwable> Either<T, ?> mapError(Either<? extends T, E> either, Function1<? super E, ? extends F> transform) {
        Intrinsics.checkNotNullParameter(either, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (either instanceof Either.Success) {
            return either;
        }
        if (either instanceof Either.Failure) {
            return new Either.Failure((Throwable) transform.invoke(((Either.Failure) either).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, E extends Throwable> Either<T, E> onError(Either<? extends T, E> either, Function1<? super E, Unit> onError) {
        Intrinsics.checkNotNullParameter(either, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (either instanceof Either.Success) {
            return either;
        }
        if (!(either instanceof Either.Failure)) {
            throw new NoWhenBranchMatchedException();
        }
        onError.invoke(((Either.Failure) either).getError());
        return either;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T, E extends java.lang.Throwable> java.lang.Object onErrorAsync(com.superwall.sdk.misc.Either<? extends T, E> r4, kotlin.jvm.functions.Function2<? super E, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<? extends T, E>> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof com.superwall.sdk.misc.EitherKt.C28121
            if (r0 == 0) goto L13
            r0 = r6
            com.superwall.sdk.misc.EitherKt$onErrorAsync$1 r0 = (com.superwall.sdk.misc.EitherKt.C28121) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.misc.EitherKt$onErrorAsync$1 r0 = new com.superwall.sdk.misc.EitherKt$onErrorAsync$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.superwall.sdk.misc.Either r4 = (com.superwall.sdk.misc.Either) r4
            kotlin.ResultKt.b(r6)
            return r4
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.b(r6)
            boolean r6 = r4 instanceof com.superwall.sdk.misc.Either.Success
            if (r6 == 0) goto L3d
            return r4
        L3d:
            boolean r6 = r4 instanceof com.superwall.sdk.misc.Either.Failure
            if (r6 == 0) goto L54
            r6 = r4
            com.superwall.sdk.misc.Either$Failure r6 = (com.superwall.sdk.misc.Either.Failure) r6
            java.lang.Throwable r6 = r6.getError()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.invoke(r6, r0)
            if (r5 != r1) goto L53
            return r1
        L53:
            return r4
        L54:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.misc.EitherKt.onErrorAsync(com.superwall.sdk.misc.Either, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <In, E extends java.lang.Throwable> java.lang.Object then(com.superwall.sdk.misc.Either<? extends In, E> r4, kotlin.jvm.functions.Function2<? super In, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<? extends In, E>> r6) {
        /*
            boolean r0 = r6 instanceof com.superwall.sdk.misc.EitherKt.C28131
            if (r0 == 0) goto L13
            r0 = r6
            com.superwall.sdk.misc.EitherKt$then$1 r0 = (com.superwall.sdk.misc.EitherKt.C28131) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.misc.EitherKt$then$1 r0 = new com.superwall.sdk.misc.EitherKt$then$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.superwall.sdk.misc.Either r4 = (com.superwall.sdk.misc.Either) r4
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L4e
            goto L55
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.b(r6)
            boolean r6 = r4 instanceof com.superwall.sdk.misc.Either.Success
            if (r6 == 0) goto L56
            r6 = r4
            com.superwall.sdk.misc.Either$Success r6 = (com.superwall.sdk.misc.Either.Success) r6     // Catch: java.lang.Throwable -> L4e
            java.lang.Object r6 = r6.getValue()     // Catch: java.lang.Throwable -> L4e
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L4e
            r0.label = r3     // Catch: java.lang.Throwable -> L4e
            java.lang.Object r5 = r5.invoke(r6, r0)     // Catch: java.lang.Throwable -> L4e
            if (r5 != r1) goto L55
            return r1
        L4e:
            r4 = move-exception
            com.superwall.sdk.misc.Either$Failure r5 = new com.superwall.sdk.misc.Either$Failure
            r5.<init>(r4)
            r4 = r5
        L55:
            return r4
        L56:
            boolean r5 = r4 instanceof com.superwall.sdk.misc.Either.Failure
            if (r5 == 0) goto L5b
            return r4
        L5b:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.misc.EitherKt.then(com.superwall.sdk.misc.Either, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <In, E extends java.lang.Throwable> java.lang.Object thenIf(com.superwall.sdk.misc.Either<? extends In, E> r4, boolean r5, kotlin.jvm.functions.Function2<? super In, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r6, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<? extends In, E>> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.superwall.sdk.misc.EitherKt.C28141
            if (r0 == 0) goto L13
            r0 = r7
            com.superwall.sdk.misc.EitherKt$thenIf$1 r0 = (com.superwall.sdk.misc.EitherKt.C28141) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.misc.EitherKt$thenIf$1 r0 = new com.superwall.sdk.misc.EitherKt$thenIf$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.superwall.sdk.misc.Either r4 = (com.superwall.sdk.misc.Either) r4
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L50
            goto L57
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.b(r7)
            boolean r7 = r4 instanceof com.superwall.sdk.misc.Either.Success
            if (r7 == 0) goto L59
            if (r5 == 0) goto L57
            r5 = r4
            com.superwall.sdk.misc.Either$Success r5 = (com.superwall.sdk.misc.Either.Success) r5     // Catch: java.lang.Throwable -> L50
            java.lang.Object r5 = r5.getValue()     // Catch: java.lang.Throwable -> L50
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L50
            r0.label = r3     // Catch: java.lang.Throwable -> L50
            java.lang.Object r5 = r6.invoke(r5, r0)     // Catch: java.lang.Throwable -> L50
            if (r5 != r1) goto L57
            return r1
        L50:
            r4 = move-exception
            com.superwall.sdk.misc.Either$Failure r5 = new com.superwall.sdk.misc.Either$Failure
            r5.<init>(r4)
            goto L58
        L57:
            r5 = r4
        L58:
            return r5
        L59:
            boolean r5 = r4 instanceof com.superwall.sdk.misc.Either.Failure
            if (r5 == 0) goto L5e
            return r4
        L5e:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.misc.EitherKt.thenIf(com.superwall.sdk.misc.Either, boolean, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final <T, E extends Throwable> Object toResult(Either<? extends T, E> either) {
        Intrinsics.checkNotNullParameter(either, "<this>");
        if (either instanceof Either.Success) {
            Result.Companion companion = Result.f139772b;
            return Result.b(((Either.Success) either).getValue());
        }
        if (!(either instanceof Either.Failure)) {
            throw new NoWhenBranchMatchedException();
        }
        Result.Companion companion2 = Result.f139772b;
        return Result.b(ResultKt.a(((Either.Failure) either).getError()));
    }

    public static final <T> T unwrap(Either<? extends T, ? extends Throwable> either) throws Throwable {
        Intrinsics.checkNotNullParameter(either, "<this>");
        if (either instanceof Either.Success) {
            return (T) ((Either.Success) either).getValue();
        }
        if (either instanceof Either.Failure) {
            throw ((Either.Failure) either).getError();
        }
        throw new NoWhenBranchMatchedException();
    }
}
