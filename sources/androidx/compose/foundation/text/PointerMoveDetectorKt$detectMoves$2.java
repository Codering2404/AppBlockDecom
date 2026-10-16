package androidx.compose.foundation.text;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2", f = "PointerMoveDetector.kt", l = {41}, m = "invokeSuspend")
final class PointerMoveDetectorKt$detectMoves$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f9866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PointerInputScope f9867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PointerEventPass f9868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f9869d;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1", f = "PointerMoveDetector.kt", l = {44}, m = "invokeSuspend")
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f9870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f9872c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ CoroutineContext f9873d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ PointerEventPass f9874f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function1 f9875g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CoroutineContext coroutineContext, PointerEventPass pointerEventPass, Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.f9873d = coroutineContext;
            this.f9874f = pointerEventPass;
            this.f9875g = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f9873d, this.f9874f, this.f9875g, continuation);
            anonymousClass1.f9872c = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00a3  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0040 -> B:14:0x0043). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r7.f9871b
                r2 = 1
                if (r1 == 0) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r7.f9870a
                kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                java.lang.Object r3 = r7.f9872c
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                kotlin.ResultKt.b(r8)
                goto L43
            L17:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1f:
                kotlin.ResultKt.b(r8)
                java.lang.Object r8 = r7.f9872c
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
                kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
                r1.<init>()
                r3 = r8
            L2c:
                kotlin.coroutines.CoroutineContext r8 = r7.f9873d
                boolean r8 = kotlinx.coroutines.JobKt.p(r8)
                if (r8 == 0) goto La3
                androidx.compose.ui.input.pointer.PointerEventPass r8 = r7.f9874f
                r7.f9872c = r3
                r7.f9870a = r1
                r7.f9871b = r2
                java.lang.Object r8 = r3.T0(r8, r7)
                if (r8 != r0) goto L43
                return r0
            L43:
                androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
                int r4 = r8.h()
                androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.f26835b
                int r6 = r5.c()
                boolean r6 = androidx.compose.ui.input.pointer.PointerEventType.j(r4, r6)
                if (r6 == 0) goto L57
                r6 = r2
                goto L5f
            L57:
                int r6 = r5.a()
                boolean r6 = androidx.compose.ui.input.pointer.PointerEventType.j(r4, r6)
            L5f:
                if (r6 == 0) goto L63
                r4 = r2
                goto L6b
            L63:
                int r5 = r5.b()
                boolean r4 = androidx.compose.ui.input.pointer.PointerEventType.j(r4, r5)
            L6b:
                if (r4 == 0) goto L2c
                java.util.List r8 = r8.c()
                java.lang.Object r8 = kotlin.collections.CollectionsKt.first(r8)
                androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
                long r4 = r8.h()
                androidx.compose.ui.geometry.Offset r8 = androidx.compose.ui.geometry.Offset.d(r4)
                long r4 = r8.u()
                java.lang.Object r6 = r1.f140144a
                boolean r4 = androidx.compose.ui.geometry.Offset.i(r4, r6)
                if (r4 != 0) goto L8c
                goto L8d
            L8c:
                r8 = 0
            L8d:
                if (r8 == 0) goto L2c
                kotlin.jvm.functions.Function1 r4 = r7.f9875g
                long r5 = r8.u()
                androidx.compose.ui.geometry.Offset r8 = androidx.compose.ui.geometry.Offset.d(r5)
                r1.f140144a = r8
                androidx.compose.ui.geometry.Offset r8 = androidx.compose.ui.geometry.Offset.d(r5)
                r4.invoke(r8)
                goto L2c
            La3:
                kotlin.Unit r8 = kotlin.Unit.f139807a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PointerMoveDetectorKt$detectMoves$2(PointerInputScope pointerInputScope, PointerEventPass pointerEventPass, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f9867b = pointerInputScope;
        this.f9868c = pointerEventPass;
        this.f9869d = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PointerMoveDetectorKt$detectMoves$2(this.f9867b, this.f9868c, this.f9869d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f9866a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoroutineContext context = getContext();
            PointerInputScope pointerInputScope = this.f9867b;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(context, this.f9868c, this.f9869d, null);
            this.f9866a = 1;
            if (pointerInputScope.c0(anonymousClass1, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PointerMoveDetectorKt$detectMoves$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
