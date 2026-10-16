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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$9", f = "DragGestureDetector.kt", l = {245, 251, 1061, 1101, 278, 1148, 1190, 1202}, m = "invokeSuspend")
final class DragGestureDetectorKt$detectDragGestures$9 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f5747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f5748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f5749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f5750d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f5751f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f5752g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f5753h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f5754i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f5755j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private /* synthetic */ Object f5756k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ Function0 f5757l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ Ref.LongRef f5758m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ Orientation f5759n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ Function3 f5760o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final /* synthetic */ Function2 f5761p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final /* synthetic */ Function0 f5762q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final /* synthetic */ Function1 f5763r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$detectDragGestures$9(Function0 function0, Ref.LongRef longRef, Orientation orientation, Function3 function3, Function2 function2, Function0 function02, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f5757l = function0;
        this.f5758m = longRef;
        this.f5759n = orientation;
        this.f5760o = function3;
        this.f5761p = function2;
        this.f5762q = function02;
        this.f5763r = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DragGestureDetectorKt$detectDragGestures$9 dragGestureDetectorKt$detectDragGestures$9 = new DragGestureDetectorKt$detectDragGestures$9(this.f5757l, this.f5758m, this.f5759n, this.f5760o, this.f5761p, this.f5762q, this.f5763r, continuation);
        dragGestureDetectorKt$detectDragGestures$9.f5756k = obj;
        return dragGestureDetectorKt$detectDragGestures$9;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
        return ((DragGestureDetectorKt$detectDragGestures$9) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:164:0x04b8, code lost:
    
        if (androidx.compose.foundation.gestures.DragGestureDetectorKt.v(r2.U0(), r0) != false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x04e0, code lost:
    
        if (r9 != r6) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x056d, code lost:
    
        if (r8 == false) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02fb, code lost:
    
        if (r4 == r6) goto L169;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:182:0x051a, B:193:0x0546], limit reached: 221 */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03c0 A[PHI: r0 r1 r2 r4 r7 r9 r10 r11 r16 r18
      0x03c0: PHI (r0v21 float) = (r0v19 float), (r0v22 float) binds: [B:8:0x0065, B:116:0x03bc] A[DONT_GENERATE, DONT_INLINE]
      0x03c0: PHI (r1v36 androidx.compose.ui.input.pointer.PointerInputChange) = 
      (r1v34 androidx.compose.ui.input.pointer.PointerInputChange)
      (r1v38 androidx.compose.ui.input.pointer.PointerInputChange)
     binds: [B:8:0x0065, B:116:0x03bc] A[DONT_GENERATE, DONT_INLINE]
      0x03c0: PHI (r2v26 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
      (r2v24 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
      (r2v29 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
     binds: [B:8:0x0065, B:116:0x03bc] A[DONT_GENERATE, DONT_INLINE]
      0x03c0: PHI (r4v19 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
      (r4v17 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
      (r4v20 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
     binds: [B:8:0x0065, B:116:0x03bc] A[DONT_GENERATE, DONT_INLINE]
      0x03c0: PHI (r7v30 androidx.compose.foundation.gestures.TouchSlopDetector) = 
      (r7v28 androidx.compose.foundation.gestures.TouchSlopDetector)
      (r7v32 androidx.compose.foundation.gestures.TouchSlopDetector)
     binds: [B:8:0x0065, B:116:0x03bc] A[DONT_GENERATE, DONT_INLINE]
      0x03c0: PHI (r9v13 java.lang.Object) = (r9v12 java.lang.Object), (r9v21 java.lang.Object) binds: [B:8:0x0065, B:116:0x03bc] A[DONT_GENERATE, DONT_INLINE]
      0x03c0: PHI (r10v9 kotlin.jvm.internal.Ref$LongRef) = (r10v7 kotlin.jvm.internal.Ref$LongRef), (r10v10 kotlin.jvm.internal.Ref$LongRef) binds: [B:8:0x0065, B:116:0x03bc] A[DONT_GENERATE, DONT_INLINE]
      0x03c0: PHI (r11v20 kotlin.jvm.internal.Ref$LongRef) = (r11v18 kotlin.jvm.internal.Ref$LongRef), (r11v21 kotlin.jvm.internal.Ref$LongRef) binds: [B:8:0x0065, B:116:0x03bc] A[DONT_GENERATE, DONT_INLINE]
      0x03c0: PHI (r16v16 long) = (r16v14 long), (r16v17 long) binds: [B:8:0x0065, B:116:0x03bc] A[DONT_GENERATE, DONT_INLINE]
      0x03c0: PHI (r18v12 long) = (r18v10 long), (r18v13 long) binds: [B:8:0x0065, B:116:0x03bc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03f0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0215 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01e6 A[PHI: r0 r1 r2 r4 r5 r7 r8 r9 r11 r16 r18
      0x01e6: PHI (r0v10 float) = (r0v9 float), (r0v11 float) binds: [B:11:0x00e7, B:31:0x01e2] A[DONT_GENERATE, DONT_INLINE]
      0x01e6: PHI (r1v18 androidx.compose.ui.input.pointer.PointerInputChange) = 
      (r1v17 androidx.compose.ui.input.pointer.PointerInputChange)
      (r1v20 androidx.compose.ui.input.pointer.PointerInputChange)
     binds: [B:11:0x00e7, B:31:0x01e2] A[DONT_GENERATE, DONT_INLINE]
      0x01e6: PHI (r2v8 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
      (r2v7 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
      (r2v11 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
     binds: [B:11:0x00e7, B:31:0x01e2] A[DONT_GENERATE, DONT_INLINE]
      0x01e6: PHI (r4v5 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
      (r4v4 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
      (r4v6 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
     binds: [B:11:0x00e7, B:31:0x01e2] A[DONT_GENERATE, DONT_INLINE]
      0x01e6: PHI (r5v5 androidx.compose.foundation.gestures.TouchSlopDetector) = 
      (r5v4 androidx.compose.foundation.gestures.TouchSlopDetector)
      (r5v6 androidx.compose.foundation.gestures.TouchSlopDetector)
     binds: [B:11:0x00e7, B:31:0x01e2] A[DONT_GENERATE, DONT_INLINE]
      0x01e6: PHI (r7v7 java.lang.Object) = (r7v6 java.lang.Object), (r7v17 java.lang.Object) binds: [B:11:0x00e7, B:31:0x01e2] A[DONT_GENERATE, DONT_INLINE]
      0x01e6: PHI (r8v4 kotlin.jvm.internal.Ref$LongRef) = (r8v3 kotlin.jvm.internal.Ref$LongRef), (r8v6 kotlin.jvm.internal.Ref$LongRef) binds: [B:11:0x00e7, B:31:0x01e2] A[DONT_GENERATE, DONT_INLINE]
      0x01e6: PHI (r9v2 kotlin.jvm.internal.Ref$LongRef) = (r9v1 kotlin.jvm.internal.Ref$LongRef), (r9v3 kotlin.jvm.internal.Ref$LongRef) binds: [B:11:0x00e7, B:31:0x01e2] A[DONT_GENERATE, DONT_INLINE]
      0x01e6: PHI (r11v1 int) = (r11v0 int), (r11v14 int) binds: [B:11:0x00e7, B:31:0x01e2] A[DONT_GENERATE, DONT_INLINE]
      0x01e6: PHI (r16v6 long) = (r16v5 long), (r16v7 long) binds: [B:11:0x00e7, B:31:0x01e2] A[DONT_GENERATE, DONT_INLINE]
      0x01e6: PHI (r18v2 long) = (r18v1 long), (r18v3 long) binds: [B:11:0x00e7, B:31:0x01e2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02d6  */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v30, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v32, types: [kotlin.jvm.functions.Function3] */
    /* JADX WARN: Type inference failed for: r0v33, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v55 */
    /* JADX WARN: Type inference failed for: r0v56 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v10, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v9, types: [androidx.compose.ui.input.pointer.PointerEventPass, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20, types: [androidx.compose.ui.input.pointer.PointerInputChange] */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v46, types: [androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v49 */
    /* JADX WARN: Type inference failed for: r7v64 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x0389 -> B:113:0x038b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:127:0x03f7 -> B:113:0x038b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:148:0x044c -> B:81:0x02be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:150:0x0453 -> B:115:0x03a4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:154:0x0473 -> B:155:0x0475). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:160:0x0485 -> B:81:0x02be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:168:0x04e0 -> B:170:0x04e3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x01b2 -> B:74:0x02a4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x021d -> B:43:0x021e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x026f -> B:74:0x02a4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0297 -> B:71:0x029a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x0333 -> B:89:0x02e3). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$9.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
