package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2", f = "TapGestureDetector.kt", l = {247}, m = "invokeSuspend")
final class TapGestureDetectorKt$detectTapAndPress$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f6203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f6204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PointerInputScope f6205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function3 f6206d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function1 f6207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ PressGestureScopeImpl f6208g;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1", f = "TapGestureDetector.kt", l = {251, 257}, m = "invokeSuspend")
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f6209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f6211c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ CoroutineScope f6212d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function3 f6213f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function1 f6214g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ PressGestureScopeImpl f6215h;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1", f = "TapGestureDetector.kt", l = {254}, m = "invokeSuspend")
        static final class C00141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f6216a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function3 f6217b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ PressGestureScopeImpl f6218c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ PointerInputChange f6219d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00141(Function3 function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation continuation) {
                super(2, continuation);
                this.f6217b = function3;
                this.f6218c = pressGestureScopeImpl;
                this.f6219d = pointerInputChange;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C00141(this.f6217b, this.f6218c, this.f6219d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f6216a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Function3 function3 = this.f6217b;
                    PressGestureScopeImpl pressGestureScopeImpl = this.f6218c;
                    Offset offsetD = Offset.d(this.f6219d.h());
                    this.f6216a = 1;
                    if (function3.invoke(pressGestureScopeImpl, offsetD, this) == objF) {
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
                return ((C00141) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f6220a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ PressGestureScopeImpl f6221b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(PressGestureScopeImpl pressGestureScopeImpl, Continuation continuation) {
                super(2, continuation);
                this.f6221b = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass2(this.f6221b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f6220a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.f6221b.m();
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f6222a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ PressGestureScopeImpl f6223b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(PressGestureScopeImpl pressGestureScopeImpl, Continuation continuation) {
                super(2, continuation);
                this.f6223b = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass3(this.f6223b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f6222a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.f6223b.p();
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CoroutineScope coroutineScope, Function3 function3, Function1 function1, PressGestureScopeImpl pressGestureScopeImpl, Continuation continuation) {
            super(2, continuation);
            this.f6212d = coroutineScope;
            this.f6213f = function3;
            this.f6214g = function1;
            this.f6215h = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f6212d, this.f6213f, this.f6214g, this.f6215h, continuation);
            anonymousClass1.f6211c = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x008a, code lost:
        
            if (r0 == r6) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
            /*
                r16 = this;
                r3 = r16
                java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r0 = r3.f6210b
                r7 = 2
                r8 = 1
                r9 = 0
                if (r0 == 0) goto L35
                if (r0 == r8) goto L25
                if (r0 != r7) goto L1d
                java.lang.Object r0 = r3.f6211c
                kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
                kotlin.ResultKt.b(r17)
                r11 = r0
                r0 = r17
                goto L8d
            L1d:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L25:
                java.lang.Object r0 = r3.f6209a
                kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
                java.lang.Object r1 = r3.f6211c
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.b(r17)
                r11 = r0
                r0 = r1
                r1 = r17
                goto L62
            L35:
                kotlin.ResultKt.b(r17)
                java.lang.Object r0 = r3.f6211c
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r0 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r0
                kotlinx.coroutines.CoroutineScope r10 = r3.f6212d
                kotlinx.coroutines.CoroutineStart r12 = androidx.compose.foundation.gestures.TapGestureDetectorKt.c()
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$resetJob$1 r13 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$resetJob$1
                androidx.compose.foundation.gestures.PressGestureScopeImpl r1 = r3.f6215h
                r13.<init>(r1, r9)
                r14 = 1
                r15 = 0
                r11 = 0
                kotlinx.coroutines.Job r10 = kotlinx.coroutines.BuildersKt.d(r10, r11, r12, r13, r14, r15)
                r3.f6211c = r0
                r3.f6209a = r10
                r3.f6210b = r8
                r1 = 0
                r2 = 0
                r4 = 3
                r5 = 0
                java.lang.Object r1 = androidx.compose.foundation.gestures.TapGestureDetectorKt.f(r0, r1, r2, r3, r4, r5)
                if (r1 != r6) goto L61
                goto L8c
            L61:
                r11 = r10
            L62:
                androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
                r1.a()
                kotlin.jvm.functions.Function3 r2 = r3.f6213f
                kotlin.jvm.functions.Function3 r4 = androidx.compose.foundation.gestures.TapGestureDetectorKt.d()
                if (r2 == r4) goto L80
                kotlinx.coroutines.CoroutineScope r10 = r3.f6212d
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1 r13 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1
                kotlin.jvm.functions.Function3 r2 = r3.f6213f
                androidx.compose.foundation.gestures.PressGestureScopeImpl r4 = r3.f6215h
                r13.<init>(r2, r4, r1, r9)
                r14 = 2
                r15 = 0
                r12 = 0
                androidx.compose.foundation.gestures.TapGestureDetectorKt.r(r10, r11, r12, r13, r14, r15)
            L80:
                r3.f6211c = r11
                r3.f6209a = r9
                r3.f6210b = r7
                java.lang.Object r0 = androidx.compose.foundation.gestures.TapGestureDetectorKt.v(r0, r9, r3, r8, r9)
                if (r0 != r6) goto L8d
            L8c:
                return r6
            L8d:
                androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0
                if (r0 != 0) goto La1
                kotlinx.coroutines.CoroutineScope r10 = r3.f6212d
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2 r13 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2
                androidx.compose.foundation.gestures.PressGestureScopeImpl r0 = r3.f6215h
                r13.<init>(r0, r9)
                r14 = 2
                r15 = 0
                r12 = 0
                androidx.compose.foundation.gestures.TapGestureDetectorKt.r(r10, r11, r12, r13, r14, r15)
                goto Lc2
            La1:
                r0.a()
                kotlinx.coroutines.CoroutineScope r10 = r3.f6212d
                androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3 r13 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3
                androidx.compose.foundation.gestures.PressGestureScopeImpl r1 = r3.f6215h
                r13.<init>(r1, r9)
                r14 = 2
                r15 = 0
                r12 = 0
                androidx.compose.foundation.gestures.TapGestureDetectorKt.r(r10, r11, r12, r13, r14, r15)
                kotlin.jvm.functions.Function1 r1 = r3.f6214g
                if (r1 == 0) goto Lc2
                long r4 = r0.h()
                androidx.compose.ui.geometry.Offset r0 = androidx.compose.ui.geometry.Offset.d(r4)
                r1.invoke(r0)
            Lc2:
                kotlin.Unit r0 = kotlin.Unit.f139807a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TapGestureDetectorKt$detectTapAndPress$2(PointerInputScope pointerInputScope, Function3 function3, Function1 function1, PressGestureScopeImpl pressGestureScopeImpl, Continuation continuation) {
        super(2, continuation);
        this.f6205c = pointerInputScope;
        this.f6206d = function3;
        this.f6207f = function1;
        this.f6208g = pressGestureScopeImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TapGestureDetectorKt$detectTapAndPress$2 tapGestureDetectorKt$detectTapAndPress$2 = new TapGestureDetectorKt$detectTapAndPress$2(this.f6205c, this.f6206d, this.f6207f, this.f6208g, continuation);
        tapGestureDetectorKt$detectTapAndPress$2.f6204b = obj;
        return tapGestureDetectorKt$detectTapAndPress$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f6203a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f6204b;
            PointerInputScope pointerInputScope = this.f6205c;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(coroutineScope, this.f6206d, this.f6207f, this.f6208g, null);
            this.f6203a = 1;
            if (ForEachGestureKt.e(pointerInputScope, anonymousClass1, this) == objF) {
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
        return ((TapGestureDetectorKt$detectTapAndPress$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
