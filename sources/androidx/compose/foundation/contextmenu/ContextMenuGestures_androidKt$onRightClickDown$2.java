package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt$onRightClickDown$2", f = "ContextMenuGestures.android.kt", l = {58, 61}, m = "invokeSuspend")
final class ContextMenuGestures_androidKt$onRightClickDown$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f5256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f5257c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContextMenuGestures_androidKt$onRightClickDown$2(Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f5257c = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ContextMenuGestures_androidKt$onRightClickDown$2 contextMenuGestures_androidKt$onRightClickDown$2 = new ContextMenuGestures_androidKt$onRightClickDown$2(this.f5257c, continuation);
        contextMenuGestures_androidKt$onRightClickDown$2.f5256b = obj;
        return contextMenuGestures_androidKt$onRightClickDown$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
        return ((ContextMenuGestures_androidKt$onRightClickDown$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0050, code lost:
    
        if (r8 == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f5255a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r8)
            goto L53
        L12:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1a:
            java.lang.Object r1 = r7.f5256b
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.b(r8)
            goto L35
        L22:
            kotlin.ResultKt.b(r8)
            java.lang.Object r8 = r7.f5256b
            r1 = r8
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            r7.f5256b = r1
            r7.f5255a = r3
            java.lang.Object r8 = androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt.a(r1, r7)
            if (r8 != r0) goto L35
            goto L52
        L35:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            r8.a()
            kotlin.jvm.functions.Function1 r4 = r7.f5257c
            long r5 = r8.h()
            androidx.compose.ui.geometry.Offset r8 = androidx.compose.ui.geometry.Offset.d(r5)
            r4.invoke(r8)
            r8 = 0
            r7.f5256b = r8
            r7.f5255a = r2
            java.lang.Object r8 = androidx.compose.foundation.gestures.TapGestureDetectorKt.v(r1, r8, r7, r3, r8)
            if (r8 != r0) goto L53
        L52:
            return r0
        L53:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 == 0) goto L5a
            r8.a()
        L5a:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt$onRightClickDown$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
