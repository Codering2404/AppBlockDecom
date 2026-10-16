package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

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
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2", f = "CursorAnimationState.kt", l = {}, m = "invokeSuspend")
final class CursorAnimationState$snapToVisibleAndAnimate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f10312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f10313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CursorAnimationState f10314c;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1", f = "CursorAnimationState.kt", l = {72, 77, 79, 81}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Job f10316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ CursorAnimationState f10317c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Job job, CursorAnimationState cursorAnimationState, Continuation continuation) {
            super(2, continuation);
            this.f10316b = job;
            this.f10317c = cursorAnimationState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f10316b, this.f10317c, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0073, code lost:
        
            if (kotlinx.coroutines.DelayKt.b(500, r10) != r0) goto L36;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0068 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:8:0x0019, B:36:0x0076, B:30:0x005f, B:33:0x0068, B:14:0x0027, B:15:0x002b, B:28:0x0059, B:29:0x005e, B:23:0x0043, B:25:0x0050), top: B:40:0x000f }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0073 -> B:36:0x0076). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r10.f10315a
                r2 = 0
                r3 = 500(0x1f4, double:2.47E-321)
                r5 = 1065353216(0x3f800000, float:1.0)
                r6 = 4
                r7 = 3
                r8 = 2
                r9 = 1
                if (r1 == 0) goto L33
                if (r1 == r9) goto L2f
                if (r1 == r8) goto L2b
                if (r1 == r7) goto L27
                if (r1 != r6) goto L1f
                kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L1d
                goto L76
            L1d:
                r11 = move-exception
                goto L7c
            L1f:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L27:
                kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L1d
                goto L68
            L2b:
                kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L1d
                goto L59
            L2f:
                kotlin.ResultKt.b(r11)
                goto L43
            L33:
                kotlin.ResultKt.b(r11)
                kotlinx.coroutines.Job r11 = r10.f10316b
                if (r11 == 0) goto L43
                r10.f10315a = r9
                java.lang.Object r11 = kotlinx.coroutines.JobKt.g(r11, r10)
                if (r11 != r0) goto L43
                goto L75
            L43:
                androidx.compose.foundation.text.input.internal.CursorAnimationState r11 = r10.f10317c     // Catch: java.lang.Throwable -> L1d
                androidx.compose.foundation.text.input.internal.CursorAnimationState.b(r11, r5)     // Catch: java.lang.Throwable -> L1d
                androidx.compose.foundation.text.input.internal.CursorAnimationState r11 = r10.f10317c     // Catch: java.lang.Throwable -> L1d
                boolean r11 = r11.d()     // Catch: java.lang.Throwable -> L1d
                if (r11 != 0) goto L5f
                r10.f10315a = r8     // Catch: java.lang.Throwable -> L1d
                java.lang.Object r11 = kotlinx.coroutines.DelayKt.a(r10)     // Catch: java.lang.Throwable -> L1d
                if (r11 != r0) goto L59
                goto L75
            L59:
                kotlin.KotlinNothingValueException r11 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L1d
                r11.<init>()     // Catch: java.lang.Throwable -> L1d
                throw r11     // Catch: java.lang.Throwable -> L1d
            L5f:
                r10.f10315a = r7     // Catch: java.lang.Throwable -> L1d
                java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r3, r10)     // Catch: java.lang.Throwable -> L1d
                if (r11 != r0) goto L68
                goto L75
            L68:
                androidx.compose.foundation.text.input.internal.CursorAnimationState r11 = r10.f10317c     // Catch: java.lang.Throwable -> L1d
                androidx.compose.foundation.text.input.internal.CursorAnimationState.b(r11, r2)     // Catch: java.lang.Throwable -> L1d
                r10.f10315a = r6     // Catch: java.lang.Throwable -> L1d
                java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r3, r10)     // Catch: java.lang.Throwable -> L1d
                if (r11 != r0) goto L76
            L75:
                return r0
            L76:
                androidx.compose.foundation.text.input.internal.CursorAnimationState r11 = r10.f10317c     // Catch: java.lang.Throwable -> L1d
                androidx.compose.foundation.text.input.internal.CursorAnimationState.b(r11, r5)     // Catch: java.lang.Throwable -> L1d
                goto L5f
            L7c:
                androidx.compose.foundation.text.input.internal.CursorAnimationState r0 = r10.f10317c
                androidx.compose.foundation.text.input.internal.CursorAnimationState.b(r0, r2)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CursorAnimationState$snapToVisibleAndAnimate$2(CursorAnimationState cursorAnimationState, Continuation continuation) {
        super(2, continuation);
        this.f10314c = cursorAnimationState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        CursorAnimationState$snapToVisibleAndAnimate$2 cursorAnimationState$snapToVisibleAndAnimate$2 = new CursorAnimationState$snapToVisibleAndAnimate$2(this.f10314c, continuation);
        cursorAnimationState$snapToVisibleAndAnimate$2.f10313b = obj;
        return cursorAnimationState$snapToVisibleAndAnimate$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f10312a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return Boxing.a(androidx.compose.animation.core.h.a(this.f10314c.f10310b, null, BuildersKt__Builders_commonKt.d((CoroutineScope) this.f10313b, null, null, new AnonymousClass1((Job) this.f10314c.f10310b.getAndSet(null), this.f10314c, null), 3, null)));
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CursorAnimationState$snapToVisibleAndAnimate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
