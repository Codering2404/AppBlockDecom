package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
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
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.PressDownGestureKt$detectPressDownGesture$2", f = "PressDownGesture.kt", l = {31, 37}, m = "invokeSuspend")
final class PressDownGestureKt$detectPressDownGesture$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f10709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f10710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f10711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TapOnPosition f10712d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function0 f10713f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PressDownGestureKt$detectPressDownGesture$2(TapOnPosition tapOnPosition, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f10712d = tapOnPosition;
        this.f10713f = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PressDownGestureKt$detectPressDownGesture$2 pressDownGestureKt$detectPressDownGesture$2 = new PressDownGestureKt$detectPressDownGesture$2(this.f10712d, this.f10713f, continuation);
        pressDownGestureKt$detectPressDownGesture$2.f10711c = obj;
        return pressDownGestureKt$detectPressDownGesture$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
        return ((PressDownGestureKt$detectPressDownGesture$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
    
        if (r14 != r0) goto L20;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0061 -> B:20:0x0064). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r13.f10710b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2c
            if (r1 == r3) goto L23
            if (r1 != r2) goto L1b
            java.lang.Object r1 = r13.f10709a
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            java.lang.Object r4 = r13.f10711c
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
            kotlin.ResultKt.b(r14)
            r7 = r13
            goto L64
        L1b:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L23:
            java.lang.Object r1 = r13.f10711c
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.b(r14)
            r7 = r13
            goto L45
        L2c:
            kotlin.ResultKt.b(r14)
            java.lang.Object r14 = r13.f10711c
            r4 = r14
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
            r13.f10711c = r4
            r13.f10710b = r3
            r5 = 0
            r6 = 0
            r8 = 2
            r9 = 0
            r7 = r13
            java.lang.Object r14 = androidx.compose.foundation.gestures.TapGestureDetectorKt.f(r4, r5, r6, r7, r8, r9)
            if (r14 != r0) goto L44
            goto L63
        L44:
            r1 = r4
        L45:
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            androidx.compose.foundation.text.input.internal.selection.TapOnPosition r4 = r7.f10712d
            long r5 = r14.h()
            r4.a(r5)
            kotlin.jvm.functions.Function0 r4 = r7.f10713f
            if (r4 == 0) goto L97
            r4 = r1
            r1 = r14
        L56:
            r7.f10711c = r4
            r7.f10709a = r1
            r7.f10710b = r2
            r14 = 0
            java.lang.Object r14 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.e0(r4, r14, r13, r3, r14)
            if (r14 != r0) goto L64
        L63:
            return r0
        L64:
            androidx.compose.ui.input.pointer.PointerEvent r14 = (androidx.compose.ui.input.pointer.PointerEvent) r14
            java.util.List r14 = r14.c()
            r5 = r14
            java.util.Collection r5 = (java.util.Collection) r5
            int r5 = r5.size()
            r6 = 0
        L72:
            if (r6 >= r5) goto L92
            java.lang.Object r8 = r14.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            long r9 = r8.f()
            long r11 = r1.f()
            boolean r9 = androidx.compose.ui.input.pointer.PointerId.c(r9, r11)
            if (r9 == 0) goto L8f
            boolean r8 = r8.i()
            if (r8 == 0) goto L8f
            goto L56
        L8f:
            int r6 = r6 + 1
            goto L72
        L92:
            kotlin.jvm.functions.Function0 r14 = r7.f10713f
            r14.invoke()
        L97:
            kotlin.Unit r14 = kotlin.Unit.f139807a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.PressDownGestureKt$detectPressDownGesture$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
