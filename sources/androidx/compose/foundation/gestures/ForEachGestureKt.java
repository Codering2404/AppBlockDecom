package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ForEachGestureKt {
    public static final boolean a(AwaitPointerEventScope awaitPointerEventScope) {
        List listC = awaitPointerEventScope.U0().c();
        int size = listC.size();
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            if (((PointerInputChange) listC.get(i3)).i()) {
                z2 = true;
                break;
            }
            i3++;
        }
        return !z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
    
        if (a(r7) == false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004f -> B:19:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, androidx.compose.ui.input.pointer.PointerEventPass r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 r0 = (androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3) r0
            int r1 = r0.f5945d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5945d = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 r0 = new androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f5944c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f5945d
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.f5943b
            androidx.compose.ui.input.pointer.PointerEventPass r7 = (androidx.compose.ui.input.pointer.PointerEventPass) r7
            java.lang.Object r8 = r0.f5942a
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.b(r9)
            r6 = r8
            r8 = r7
            r7 = r6
            goto L52
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            kotlin.ResultKt.b(r9)
            boolean r9 = a(r7)
            if (r9 != 0) goto L72
        L45:
            r0.f5942a = r7
            r0.f5943b = r8
            r0.f5945d = r3
            java.lang.Object r9 = r7.T0(r8, r0)
            if (r9 != r1) goto L52
            return r1
        L52:
            androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
            java.util.List r9 = r9.c()
            r2 = r9
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
            r4 = 0
        L60:
            if (r4 >= r2) goto L72
            java.lang.Object r5 = r9.get(r4)
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            boolean r5 = r5.i()
            if (r5 == 0) goto L6f
            goto L45
        L6f:
            int r4 = r4 + 1
            goto L60
        L72:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ForEachGestureKt.b(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object c(PointerInputScope pointerInputScope, Continuation continuation) {
        Object objC0 = pointerInputScope.c0(new ForEachGestureKt$awaitAllPointersUp$2(null), continuation);
        return objC0 == IntrinsicsKt.f() ? objC0 : Unit.f139807a;
    }

    public static /* synthetic */ Object d(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            pointerEventPass = PointerEventPass.f26832c;
        }
        return b(awaitPointerEventScope, pointerEventPass, continuation);
    }

    public static final Object e(PointerInputScope pointerInputScope, Function2 function2, Continuation continuation) {
        Object objC0 = pointerInputScope.c0(new ForEachGestureKt$awaitEachGesture$2(continuation.getContext(), function2, null), continuation);
        return objC0 == IntrinsicsKt.f() ? objC0 : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0091, code lost:
    
        if (r10 != r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ab, code lost:
    
        if (r10 == r1) goto L40;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.ui.input.pointer.PointerInputScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.ui.input.pointer.PointerInputScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.compose.ui.input.pointer.PointerInputScope] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0091 -> B:18:0x0052). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ab -> B:18:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object f(androidx.compose.ui.input.pointer.PointerInputScope r8, kotlin.jvm.functions.Function2 r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1 r0 = (androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1) r0
            int r1 = r0.f5954f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5954f = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1 r0 = new androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f5953d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f5954f
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L67
            if (r2 == r5) goto L57
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r8 = r0.f5952c
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            java.lang.Object r9 = r0.f5951b
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            java.lang.Object r2 = r0.f5950a
            androidx.compose.ui.input.pointer.PointerInputScope r2 = (androidx.compose.ui.input.pointer.PointerInputScope) r2
            kotlin.ResultKt.b(r10)
            goto L52
        L3b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L43:
            java.lang.Object r8 = r0.f5952c
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            java.lang.Object r9 = r0.f5951b
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            java.lang.Object r2 = r0.f5950a
            androidx.compose.ui.input.pointer.PointerInputScope r2 = (androidx.compose.ui.input.pointer.PointerInputScope) r2
            kotlin.ResultKt.b(r10)     // Catch: java.util.concurrent.CancellationException -> L55
        L52:
            r10 = r8
            r8 = r2
            goto L6e
        L55:
            r10 = move-exception
            goto L99
        L57:
            java.lang.Object r8 = r0.f5952c
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            java.lang.Object r9 = r0.f5951b
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            java.lang.Object r2 = r0.f5950a
            androidx.compose.ui.input.pointer.PointerInputScope r2 = (androidx.compose.ui.input.pointer.PointerInputScope) r2
            kotlin.ResultKt.b(r10)     // Catch: java.util.concurrent.CancellationException -> L55
            goto L85
        L67:
            kotlin.ResultKt.b(r10)
            kotlin.coroutines.CoroutineContext r10 = r0.getContext()
        L6e:
            boolean r2 = kotlinx.coroutines.JobKt.p(r10)
            if (r2 == 0) goto Laf
            r0.f5950a = r8     // Catch: java.util.concurrent.CancellationException -> L94
            r0.f5951b = r9     // Catch: java.util.concurrent.CancellationException -> L94
            r0.f5952c = r10     // Catch: java.util.concurrent.CancellationException -> L94
            r0.f5954f = r5     // Catch: java.util.concurrent.CancellationException -> L94
            java.lang.Object r2 = r9.invoke(r8, r0)     // Catch: java.util.concurrent.CancellationException -> L94
            if (r2 != r1) goto L83
            goto Lad
        L83:
            r2 = r8
            r8 = r10
        L85:
            r0.f5950a = r2     // Catch: java.util.concurrent.CancellationException -> L55
            r0.f5951b = r9     // Catch: java.util.concurrent.CancellationException -> L55
            r0.f5952c = r8     // Catch: java.util.concurrent.CancellationException -> L55
            r0.f5954f = r4     // Catch: java.util.concurrent.CancellationException -> L55
            java.lang.Object r10 = c(r2, r0)     // Catch: java.util.concurrent.CancellationException -> L55
            if (r10 != r1) goto L52
            goto Lad
        L94:
            r2 = move-exception
            r7 = r2
            r2 = r8
            r8 = r10
            r10 = r7
        L99:
            boolean r6 = kotlinx.coroutines.JobKt.p(r8)
            if (r6 == 0) goto Lae
            r0.f5950a = r2
            r0.f5951b = r9
            r0.f5952c = r8
            r0.f5954f = r3
            java.lang.Object r10 = c(r2, r0)
            if (r10 != r1) goto L52
        Lad:
            return r1
        Lae:
            throw r10
        Laf:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ForEachGestureKt.f(androidx.compose.ui.input.pointer.PointerInputScope, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
