package com.superwall.sdk.misc;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

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
public final class Task_RetryingKt {

    /* JADX INFO: renamed from: com.superwall.sdk.misc.Task_RetryingKt$retryOrNull$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.misc.Task_RetryingKt", f = "Task+Retrying.kt", l = {17, 19}, m = "retryOrNull")
    static final class AnonymousClass1<T> extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Task_RetryingKt.retryOrNull(0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.misc.Task_RetryingKt$retrying$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.misc.Task_RetryingKt", f = "Task+Retrying.kt", l = {34, 41, 43, 47}, m = "retrying")
    static final class C28151<T> extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C28151(Continuation<? super C28151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Task_RetryingKt.retrying(0, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007a -> B:33:0x00a1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x009b -> B:32:0x009e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object retryOrNull(int r8, kotlin.jvm.functions.Function1<? super java.lang.Integer, java.lang.Long> r9, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r10, kotlin.coroutines.Continuation<? super T> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof com.superwall.sdk.misc.Task_RetryingKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            com.superwall.sdk.misc.Task_RetryingKt$retryOrNull$1 r0 = (com.superwall.sdk.misc.Task_RetryingKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.misc.Task_RetryingKt$retryOrNull$1 r0 = new com.superwall.sdk.misc.Task_RetryingKt$retryOrNull$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L56
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$1
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.b(r11)
            goto L9e
        L39:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L41:
            int r8 = r0.I$2
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r5 = r0.L$0
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L53
            return r11
        L53:
            r11 = r2
            r2 = r5
            goto L78
        L56:
            kotlin.ResultKt.b(r11)
            r11 = 0
            r7 = r9
            r9 = r8
            r8 = r11
            r11 = r10
            r10 = r7
        L5f:
            if (r8 >= r9) goto La6
            r0.L$0 = r10     // Catch: java.lang.Throwable -> L75
            r0.L$1 = r11     // Catch: java.lang.Throwable -> L75
            r0.I$0 = r9     // Catch: java.lang.Throwable -> L75
            r0.I$1 = r8     // Catch: java.lang.Throwable -> L75
            r0.I$2 = r8     // Catch: java.lang.Throwable -> L75
            r0.label = r4     // Catch: java.lang.Throwable -> L75
            java.lang.Object r8 = r11.invoke(r0)     // Catch: java.lang.Throwable -> L75
            if (r8 != r1) goto L74
            goto L9a
        L74:
            return r8
        L75:
            r2 = r10
            r10 = r9
            r9 = r8
        L78:
            int r5 = r10 + (-1)
            if (r8 >= r5) goto La1
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.d(r8)
            java.lang.Object r8 = r2.invoke(r8)
            java.lang.Number r8 = (java.lang.Number) r8
            long r5 = r8.longValue()
            r0.L$0 = r2
            r0.L$1 = r11
            r0.I$0 = r10
            r0.I$1 = r9
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r5, r0)
            if (r8 != r1) goto L9b
        L9a:
            return r1
        L9b:
            r8 = r9
            r9 = r10
            r10 = r11
        L9e:
            r11 = r10
            r10 = r9
            r9 = r8
        La1:
            int r8 = r9 + 1
            r9 = r10
            r10 = r2
            goto L5f
        La6:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.misc.Task_RetryingKt.retryOrNull(int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object retryOrNull$default(int i3, Function1 function1, Function1 function12, Continuation continuation, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            function1 = new Function1() { // from class: com.superwall.sdk.misc.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Long.valueOf(Task_RetryingKt.retryOrNull$lambda$0(((Integer) obj2).intValue()));
                }
            };
        }
        return retryOrNull(i3, function1, function12, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long retryOrNull$lambda$0(int i3) {
        return ((long) (i3 + 1)) * 1000;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00eb, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(r9, r2) == r1) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0100, code lost:
    
        if (r15 != r1) goto L46;
     */
    /* JADX WARN: Path cross not found for [B:33:0x00b9, B:36:0x00cc], limit reached: 49 */
    /* JADX WARN: Path cross not found for [B:36:0x00cc, B:33:0x00b9], limit reached: 49 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f1 A[PHI: r0 r2 r15
      0x00f1: PHI (r0v9 kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<? extends T, com.superwall.sdk.network.NetworkError>>, ? extends java.lang.Object>) = 
      (r0v5 kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<? extends T, com.superwall.sdk.network.NetworkError>>, ? extends java.lang.Object>)
      (r0v10 kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<? extends T, com.superwall.sdk.network.NetworkError>>, ? extends java.lang.Object>)
     binds: [B:42:0x00f0, B:24:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x00f1: PHI (r2v8 com.superwall.sdk.misc.Task_RetryingKt$retrying$1) = (r2v4 com.superwall.sdk.misc.Task_RetryingKt$retrying$1), (r2v9 com.superwall.sdk.misc.Task_RetryingKt$retrying$1) binds: [B:42:0x00f0, B:24:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x00f1: PHI (r15v10 kotlinx.coroutines.CompletableJob) = (r15v5 kotlinx.coroutines.CompletableJob), (r15v12 kotlinx.coroutines.CompletableJob) binds: [B:42:0x00f0, B:24:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00eb -> B:18:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object retrying(int r12, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r13, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<? extends T, com.superwall.sdk.network.NetworkError>>, ? extends java.lang.Object> r14, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<? extends T, com.superwall.sdk.network.NetworkError>> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.misc.Task_RetryingKt.retrying(int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
