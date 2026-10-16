package androidx.constraintlayout.compose;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.constraintlayout.compose.MotionDragHandlerKt$detectDragGesturesWhenNeeded$2", f = "MotionDragHandler.kt", l = {166, 174, 183}, m = "invokeSuspend")
final class MotionDragHandlerKt$detectDragGesturesWhenNeeded$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f30718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f30719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f30720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ Object f30721d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function1 f30722f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function1 f30723g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function2 f30724h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Function0 f30725i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Function0 f30726j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MotionDragHandlerKt$detectDragGesturesWhenNeeded$2(Function1 function1, Function1 function12, Function2 function2, Function0 function0, Function0 function02, Continuation continuation) {
        super(2, continuation);
        this.f30722f = function1;
        this.f30723g = function12;
        this.f30724h = function2;
        this.f30725i = function0;
        this.f30726j = function02;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MotionDragHandlerKt$detectDragGesturesWhenNeeded$2 motionDragHandlerKt$detectDragGesturesWhenNeeded$2 = new MotionDragHandlerKt$detectDragGesturesWhenNeeded$2(this.f30722f, this.f30723g, this.f30724h, this.f30725i, this.f30726j, continuation);
        motionDragHandlerKt$detectDragGesturesWhenNeeded$2.f30721d = obj;
        return motionDragHandlerKt$detectDragGesturesWhenNeeded$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
        return ((MotionDragHandlerKt$detectDragGesturesWhenNeeded$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d2, code lost:
    
        if (r12 == r0) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0096 A[PHI: r1 r4 r5 r8 r12
      0x0096: PHI (r1v5 kotlin.jvm.internal.Ref$LongRef) = (r1v4 kotlin.jvm.internal.Ref$LongRef), (r1v12 kotlin.jvm.internal.Ref$LongRef) binds: [B:22:0x0093, B:10:0x001f] A[DONT_GENERATE, DONT_INLINE]
      0x0096: PHI (r4v8 androidx.compose.ui.input.pointer.PointerInputChange) = 
      (r4v7 androidx.compose.ui.input.pointer.PointerInputChange)
      (r4v11 androidx.compose.ui.input.pointer.PointerInputChange)
     binds: [B:22:0x0093, B:10:0x001f] A[DONT_GENERATE, DONT_INLINE]
      0x0096: PHI (r5v8 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
      (r5v7 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
      (r5v10 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
     binds: [B:22:0x0093, B:10:0x001f] A[DONT_GENERATE, DONT_INLINE]
      0x0096: PHI (r8v3 androidx.constraintlayout.compose.MotionDragHandlerKt$detectDragGesturesWhenNeeded$2) = 
      (r8v2 androidx.constraintlayout.compose.MotionDragHandlerKt$detectDragGesturesWhenNeeded$2)
      (r8v6 androidx.constraintlayout.compose.MotionDragHandlerKt$detectDragGesturesWhenNeeded$2)
     binds: [B:22:0x0093, B:10:0x001f] A[DONT_GENERATE, DONT_INLINE]
      0x0096: PHI (r12v8 java.lang.Object) = (r12v7 java.lang.Object), (r12v0 java.lang.Object) binds: [B:22:0x0093, B:10:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0093 -> B:24:0x0096). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionDragHandlerKt$detectDragGesturesWhenNeeded$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
