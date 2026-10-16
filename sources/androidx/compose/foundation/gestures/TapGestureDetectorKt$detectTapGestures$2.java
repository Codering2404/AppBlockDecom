package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
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
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", f = "TapGestureDetector.kt", l = {104}, m = "invokeSuspend")
final class TapGestureDetectorKt$detectTapGestures$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f6226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f6227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PointerInputScope f6228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function3 f6229d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function1 f6230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function1 f6231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function1 f6232h;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", f = "TapGestureDetector.kt", l = {105, 116, 119, 122, 149, 167, 169, SensibleDefaults.X_OFFSET}, m = "invokeSuspend")
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f6233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f6234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f6235c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f6236d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f6237f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ CoroutineScope f6238g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function3 f6239h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Function1 f6240i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ Function1 f6241j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ Function1 f6242k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ PressGestureScopeImpl f6243l;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1", f = "TapGestureDetector.kt", l = {110}, m = "invokeSuspend")
        static final class C00151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f6244a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function3 f6245b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ PressGestureScopeImpl f6246c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ PointerInputChange f6247d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00151(Function3 function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation continuation) {
                super(2, continuation);
                this.f6245b = function3;
                this.f6246c = pressGestureScopeImpl;
                this.f6247d = pointerInputChange;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C00151(this.f6245b, this.f6246c, this.f6247d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f6244a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Function3 function3 = this.f6245b;
                    PressGestureScopeImpl pressGestureScopeImpl = this.f6246c;
                    Offset offsetD = Offset.d(this.f6247d.h());
                    this.f6244a = 1;
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
                return ((C00151) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f6248a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ PressGestureScopeImpl f6249b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(PressGestureScopeImpl pressGestureScopeImpl, Continuation continuation) {
                super(2, continuation);
                this.f6249b = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass2(this.f6249b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f6248a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.f6249b.p();
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f6250a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ PressGestureScopeImpl f6251b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(PressGestureScopeImpl pressGestureScopeImpl, Continuation continuation) {
                super(2, continuation);
                this.f6251b = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass3(this.f6251b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f6250a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.f6251b.m();
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f6252a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ PressGestureScopeImpl f6253b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(PressGestureScopeImpl pressGestureScopeImpl, Continuation continuation) {
                super(2, continuation);
                this.f6253b = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass4(this.f6253b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f6252a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.f6253b.p();
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5", f = "TapGestureDetector.kt", l = {157, 158}, m = "invokeSuspend")
        static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f6254a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Job f6255b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ PressGestureScopeImpl f6256c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(Job job, PressGestureScopeImpl pressGestureScopeImpl, Continuation continuation) {
                super(2, continuation);
                this.f6255b = job;
                this.f6256c = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass5(this.f6255b, this.f6256c, continuation);
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
            
                if (r5.u(r4) == r0) goto L15;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
                /*
                    r4 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r1 = r4.f6254a
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L1e
                    if (r1 == r3) goto L1a
                    if (r1 != r2) goto L12
                    kotlin.ResultKt.b(r5)
                    goto L37
                L12:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r0)
                    throw r5
                L1a:
                    kotlin.ResultKt.b(r5)
                    goto L2c
                L1e:
                    kotlin.ResultKt.b(r5)
                    kotlinx.coroutines.Job r5 = r4.f6255b
                    r4.f6254a = r3
                    java.lang.Object r5 = r5.join(r4)
                    if (r5 != r0) goto L2c
                    goto L36
                L2c:
                    androidx.compose.foundation.gestures.PressGestureScopeImpl r5 = r4.f6256c
                    r4.f6254a = r2
                    java.lang.Object r5 = r5.u(r4)
                    if (r5 != r0) goto L37
                L36:
                    return r0
                L37:
                    kotlin.Unit r5 = kotlin.Unit.f139807a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass5.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6", f = "TapGestureDetector.kt", l = {161}, m = "invokeSuspend")
        static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f6257a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function3 f6258b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ PressGestureScopeImpl f6259c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ PointerInputChange f6260d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass6(Function3 function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation continuation) {
                super(2, continuation);
                this.f6258b = function3;
                this.f6259c = pressGestureScopeImpl;
                this.f6260d = pointerInputChange;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass6(this.f6258b, this.f6259c, this.f6260d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f6257a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Function3 function3 = this.f6258b;
                    PressGestureScopeImpl pressGestureScopeImpl = this.f6259c;
                    Offset offsetD = Offset.d(this.f6260d.h());
                    this.f6257a = 1;
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
                return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f6261a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ PressGestureScopeImpl f6262b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass7(PressGestureScopeImpl pressGestureScopeImpl, Continuation continuation) {
                super(2, continuation);
                this.f6262b = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass7(this.f6262b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f6261a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.f6262b.p();
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f6263a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ PressGestureScopeImpl f6264b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass8(PressGestureScopeImpl pressGestureScopeImpl, Continuation continuation) {
                super(2, continuation);
                this.f6264b = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass8(this.f6264b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f6263a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.f6264b.m();
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CoroutineScope coroutineScope, Function3 function3, Function1 function1, Function1 function12, Function1 function13, PressGestureScopeImpl pressGestureScopeImpl, Continuation continuation) {
            super(2, continuation);
            this.f6238g = coroutineScope;
            this.f6239h = function3;
            this.f6240i = function1;
            this.f6241j = function12;
            this.f6242k = function13;
            this.f6243l = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f6238g, this.f6239h, this.f6240i, this.f6241j, this.f6242k, this.f6243l, continuation);
            anonymousClass1.f6237f = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x00ee, code lost:
        
            if (r1 == r6) goto L80;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x012b, code lost:
        
            if (androidx.compose.foundation.gestures.TapGestureDetectorKt.j(r2, r22) == r6) goto L80;
         */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00e3  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00f6  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0141  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0154  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0165  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x017a  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x01a4  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x01b5  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0229  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x025c  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0273  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0293  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 728
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TapGestureDetectorKt$detectTapGestures$2(PointerInputScope pointerInputScope, Function3 function3, Function1 function1, Function1 function12, Function1 function13, Continuation continuation) {
        super(2, continuation);
        this.f6228c = pointerInputScope;
        this.f6229d = function3;
        this.f6230f = function1;
        this.f6231g = function12;
        this.f6232h = function13;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TapGestureDetectorKt$detectTapGestures$2 tapGestureDetectorKt$detectTapGestures$2 = new TapGestureDetectorKt$detectTapGestures$2(this.f6228c, this.f6229d, this.f6230f, this.f6231g, this.f6232h, continuation);
        tapGestureDetectorKt$detectTapGestures$2.f6227b = obj;
        return tapGestureDetectorKt$detectTapGestures$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f6226a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f6227b;
            PressGestureScopeImpl pressGestureScopeImpl = new PressGestureScopeImpl(this.f6228c);
            PointerInputScope pointerInputScope = this.f6228c;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(coroutineScope, this.f6229d, this.f6230f, this.f6231g, this.f6232h, pressGestureScopeImpl, null);
            this.f6226a = 1;
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
        return ((TapGestureDetectorKt$detectTapGestures$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
