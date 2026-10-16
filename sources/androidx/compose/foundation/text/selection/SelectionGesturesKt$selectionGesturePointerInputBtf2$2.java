package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
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
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGesturePointerInputBtf2$2", f = "SelectionGestures.kt", l = {209, 217, 220, 221}, m = "invokeSuspend")
final class SelectionGesturesKt$selectionGesturePointerInputBtf2$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f11341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f11342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ClicksCounter f11343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MouseSelectionObserver f11344d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ TextDragObserver f11345f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectionGesturesKt$selectionGesturePointerInputBtf2$2(ClicksCounter clicksCounter, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation continuation) {
        super(2, continuation);
        this.f11343c = clicksCounter;
        this.f11344d = mouseSelectionObserver;
        this.f11345f = textDragObserver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SelectionGesturesKt$selectionGesturePointerInputBtf2$2 selectionGesturesKt$selectionGesturePointerInputBtf2$2 = new SelectionGesturesKt$selectionGesturePointerInputBtf2$2(this.f11343c, this.f11344d, this.f11345f, continuation);
        selectionGesturesKt$selectionGesturePointerInputBtf2$2.f11342b = obj;
        return selectionGesturesKt$selectionGesturePointerInputBtf2$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
        return ((SelectionGesturesKt$selectionGesturePointerInputBtf2$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x007f, code lost:
    
        if (androidx.compose.foundation.text.selection.SelectionGesturesKt.l(r1, r2, r3, r13, r12) == r0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0096, code lost:
    
        if (androidx.compose.foundation.text.selection.SelectionGesturesKt.p(r1, r2, r13, r12) == r0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a3, code lost:
    
        if (androidx.compose.foundation.text.selection.SelectionGesturesKt.q(r1, r3, r13, r12) == r0) goto L37;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.f11341a
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2a
            if (r1 == r5) goto L22
            if (r1 == r4) goto L1d
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            goto L1d
        L15:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1d:
            kotlin.ResultKt.b(r13)
            goto La6
        L22:
            java.lang.Object r1 = r12.f11342b
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.b(r13)
            goto L3d
        L2a:
            kotlin.ResultKt.b(r13)
            java.lang.Object r13 = r12.f11342b
            r1 = r13
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            r12.f11342b = r1
            r12.f11341a = r5
            java.lang.Object r13 = androidx.compose.foundation.text.selection.SelectionGesturesKt.a(r1, r12)
            if (r13 != r0) goto L3d
            goto La5
        L3d:
            androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
            androidx.compose.foundation.text.selection.ClicksCounter r6 = r12.f11343c
            r6.d(r13)
            boolean r6 = androidx.compose.foundation.text.selection.SelectionGesturesKt.j(r13)
            r7 = 0
            if (r6 == 0) goto L82
            int r8 = r13.b()
            boolean r8 = androidx.compose.ui.input.pointer.PointerEvent_androidKt.c(r8)
            if (r8 == 0) goto L82
            java.util.List r8 = r13.c()
            r9 = r8
            java.util.Collection r9 = (java.util.Collection) r9
            int r9 = r9.size()
            r10 = 0
        L61:
            if (r10 >= r9) goto L73
            java.lang.Object r11 = r8.get(r10)
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.p()
            if (r11 == 0) goto L70
            goto L82
        L70:
            int r10 = r10 + 1
            goto L61
        L73:
            androidx.compose.foundation.text.selection.MouseSelectionObserver r2 = r12.f11344d
            androidx.compose.foundation.text.selection.ClicksCounter r3 = r12.f11343c
            r12.f11342b = r7
            r12.f11341a = r4
            java.lang.Object r13 = androidx.compose.foundation.text.selection.SelectionGesturesKt.d(r1, r2, r3, r13, r12)
            if (r13 != r0) goto La6
            goto La5
        L82:
            if (r6 != 0) goto La6
            androidx.compose.foundation.text.selection.ClicksCounter r4 = r12.f11343c
            int r4 = r4.a()
            if (r4 != r5) goto L99
            androidx.compose.foundation.text.TextDragObserver r2 = r12.f11345f
            r12.f11342b = r7
            r12.f11341a = r3
            java.lang.Object r13 = androidx.compose.foundation.text.selection.SelectionGesturesKt.f(r1, r2, r13, r12)
            if (r13 != r0) goto La6
            goto La5
        L99:
            androidx.compose.foundation.text.TextDragObserver r3 = r12.f11345f
            r12.f11342b = r7
            r12.f11341a = r2
            java.lang.Object r13 = androidx.compose.foundation.text.selection.SelectionGesturesKt.g(r1, r3, r13, r12)
            if (r13 != r0) goto La6
        La5:
            return r0
        La6:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGesturePointerInputBtf2$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
