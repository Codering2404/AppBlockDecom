package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5", f = "DragGestureDetector.kt", l = {510, 513, 521}, m = "invokeSuspend")
final class DragGestureDetectorKt$detectVerticalDragGestures$5 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f5789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f5790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f5791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f5792d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function2 f5793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function0 f5794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function0 f5795h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$detectVerticalDragGestures$5(Function1 function1, Function2 function2, Function0 function0, Function0 function02, Continuation continuation) {
        super(2, continuation);
        this.f5792d = function1;
        this.f5793f = function2;
        this.f5794g = function0;
        this.f5795h = function02;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DragGestureDetectorKt$detectVerticalDragGestures$5 dragGestureDetectorKt$detectVerticalDragGestures$5 = new DragGestureDetectorKt$detectVerticalDragGestures$5(this.f5792d, this.f5793f, this.f5794g, this.f5795h, continuation);
        dragGestureDetectorKt$detectVerticalDragGestures$5.f5791c = obj;
        return dragGestureDetectorKt$detectVerticalDragGestures$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
        return ((DragGestureDetectorKt$detectVerticalDragGestures$5) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a5, code lost:
    
        if (r13 == r0) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.f5790b
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L36
            if (r1 == r4) goto L2c
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            kotlin.ResultKt.b(r13)
            r8 = r12
            goto La8
        L17:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1f:
            java.lang.Object r1 = r12.f5789a
            kotlin.jvm.internal.Ref$FloatRef r1 = (kotlin.jvm.internal.Ref.FloatRef) r1
            java.lang.Object r3 = r12.f5791c
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
            kotlin.ResultKt.b(r13)
            r8 = r12
            goto L73
        L2c:
            java.lang.Object r1 = r12.f5791c
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.b(r13)
            r8 = r12
            r6 = r1
            goto L4f
        L36:
            kotlin.ResultKt.b(r13)
            java.lang.Object r13 = r12.f5791c
            r5 = r13
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            r12.f5791c = r5
            r12.f5790b = r4
            r6 = 0
            r7 = 0
            r9 = 2
            r10 = 0
            r8 = r12
            java.lang.Object r13 = androidx.compose.foundation.gestures.TapGestureDetectorKt.f(r5, r6, r7, r8, r9, r10)
            if (r13 != r0) goto L4e
            goto La7
        L4e:
            r6 = r5
        L4f:
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            kotlin.jvm.internal.Ref$FloatRef r1 = new kotlin.jvm.internal.Ref$FloatRef
            r1.<init>()
            r11 = r8
            long r7 = r13.f()
            int r9 = r13.n()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$drag$1 r10 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$drag$1
            r10.<init>()
            r11.f5791c = r6
            r11.f5789a = r1
            r11.f5790b = r3
            java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.k(r6, r7, r9, r10, r11)
            r8 = r11
            if (r13 != r0) goto L72
            goto La7
        L72:
            r3 = r6
        L73:
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            if (r13 == 0) goto Lbb
            kotlin.jvm.functions.Function1 r4 = r8.f5792d
            long r5 = r13.h()
            androidx.compose.ui.geometry.Offset r5 = androidx.compose.ui.geometry.Offset.d(r5)
            r4.invoke(r5)
            kotlin.jvm.functions.Function2 r4 = r8.f5793f
            float r1 = r1.f140141a
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.c(r1)
            r4.invoke(r13, r1)
            long r4 = r13.f()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$1 r13 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$1
            kotlin.jvm.functions.Function2 r1 = r8.f5793f
            r13.<init>()
            r1 = 0
            r8.f5791c = r1
            r8.f5789a = r1
            r8.f5790b = r2
            java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.x(r3, r4, r13, r12)
            if (r13 != r0) goto La8
        La7:
            return r0
        La8:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto Lb6
            kotlin.jvm.functions.Function0 r13 = r8.f5794g
            r13.invoke()
            goto Lbb
        Lb6:
            kotlin.jvm.functions.Function0 r13 = r8.f5795h
            r13.invoke()
        Lbb:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
