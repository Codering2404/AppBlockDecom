package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1", f = "Draggable.kt", l = {421, 423, 425, 432, 434, 437}, m = "invokeSuspend")
final class DragGestureNode$startListeningForEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f5868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f5869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f5870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ Object f5871d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ DragGestureNode f5872f;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1", f = "Draggable.kt", l = {428}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Function1<? super DragEvent.DragDelta, ? extends Unit>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f5873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f5874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f5875c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f5876d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ DragGestureNode f5877f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef objectRef, DragGestureNode dragGestureNode, Continuation continuation) {
            super(2, continuation);
            this.f5876d = objectRef;
            this.f5877f = dragGestureNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f5876d, this.f5877f, continuation);
            anonymousClass1.f5875c = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Function1 function1, Continuation continuation) {
            return ((AnonymousClass1) create(function1, continuation)).invokeSuspend(Unit.f139807a);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0049 -> B:25:0x005b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0055 -> B:24:0x0058). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r5.f5874b
                r2 = 1
                if (r1 == 0) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r5.f5873a
                kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                java.lang.Object r3 = r5.f5875c
                kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
                kotlin.ResultKt.b(r6)
                goto L58
            L17:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1f:
                kotlin.ResultKt.b(r6)
                java.lang.Object r6 = r5.f5875c
                kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
                r3 = r6
            L27:
                kotlin.jvm.internal.Ref$ObjectRef r6 = r5.f5876d
                java.lang.Object r6 = r6.f140144a
                boolean r1 = r6 instanceof androidx.compose.foundation.gestures.DragEvent.DragStopped
                if (r1 != 0) goto L5e
                boolean r1 = r6 instanceof androidx.compose.foundation.gestures.DragEvent.DragCancelled
                if (r1 != 0) goto L5e
                boolean r1 = r6 instanceof androidx.compose.foundation.gestures.DragEvent.DragDelta
                r4 = 0
                if (r1 == 0) goto L3b
                androidx.compose.foundation.gestures.DragEvent$DragDelta r6 = (androidx.compose.foundation.gestures.DragEvent.DragDelta) r6
                goto L3c
            L3b:
                r6 = r4
            L3c:
                if (r6 == 0) goto L41
                r3.invoke(r6)
            L41:
                kotlin.jvm.internal.Ref$ObjectRef r1 = r5.f5876d
                androidx.compose.foundation.gestures.DragGestureNode r6 = r5.f5877f
                kotlinx.coroutines.channels.Channel r6 = androidx.compose.foundation.gestures.DragGestureNode.s2(r6)
                if (r6 == 0) goto L5b
                r5.f5875c = r3
                r5.f5873a = r1
                r5.f5874b = r2
                java.lang.Object r6 = r6.v(r5)
                if (r6 != r0) goto L58
                return r0
            L58:
                r4 = r6
                androidx.compose.foundation.gestures.DragEvent r4 = (androidx.compose.foundation.gestures.DragEvent) r4
            L5b:
                r1.f140144a = r4
                goto L27
            L5e:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DragGestureNode$startListeningForEvents$1(DragGestureNode dragGestureNode, Continuation continuation) {
        super(2, continuation);
        this.f5872f = dragGestureNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DragGestureNode$startListeningForEvents$1 dragGestureNode$startListeningForEvents$1 = new DragGestureNode$startListeningForEvents$1(this.f5872f, continuation);
        dragGestureNode$startListeningForEvents$1.f5871d = obj;
        return dragGestureNode$startListeningForEvents$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00fb, code lost:
    
        if (r7.H2(r6) != r0) goto L11;
     */
    /* JADX WARN: Path cross not found for [B:44:0x00da, B:40:0x00c1], limit reached: 56 */
    /* JADX WARN: Path cross not found for [B:46:0x00de, B:19:0x005e], limit reached: 56 */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[PHI: r1 r3
      0x0034: PHI (r1v14 kotlin.jvm.internal.Ref$ObjectRef) = (r1v6 kotlin.jvm.internal.Ref$ObjectRef), (r1v19 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:13:0x0031, B:36:0x00b8] A[DONT_GENERATE, DONT_INLINE]
      0x0034: PHI (r3v8 kotlinx.coroutines.CoroutineScope) = (r3v5 kotlinx.coroutines.CoroutineScope), (r3v11 kotlinx.coroutines.CoroutineScope) binds: [B:13:0x0031, B:36:0x00b8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005e A[PHI: r4
      0x005e: PHI (r4v7 kotlinx.coroutines.CoroutineScope) = 
      (r4v0 kotlinx.coroutines.CoroutineScope)
      (r4v3 kotlinx.coroutines.CoroutineScope)
      (r4v3 kotlinx.coroutines.CoroutineScope)
      (r4v3 kotlinx.coroutines.CoroutineScope)
      (r4v5 kotlinx.coroutines.CoroutineScope)
      (r4v8 kotlinx.coroutines.CoroutineScope)
     binds: [B:18:0x0056, B:45:0x00dc, B:47:0x00eb, B:41:0x00d5, B:30:0x008e, B:11:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c1 A[Catch: CancellationException -> 0x00d8, TryCatch #2 {CancellationException -> 0x00d8, blocks: (B:38:0x00bb, B:40:0x00c1, B:44:0x00da, B:46:0x00de), top: B:59:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00da A[Catch: CancellationException -> 0x00d8, TryCatch #2 {CancellationException -> 0x00d8, blocks: (B:38:0x00bb, B:40:0x00c1, B:44:0x00da, B:46:0x00de), top: B:59:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fe  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x008e -> B:19:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00d5 -> B:19:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00dc -> B:19:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00eb -> B:19:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00fb -> B:11:0x0027). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DragGestureNode$startListeningForEvents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
