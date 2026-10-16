package androidx.compose.material;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.GestureCancellationException;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
@DebugMetadata(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$1", f = "Slider.kt", l = {919}, m = "invokeSuspend")
final class SliderKt$sliderTapModifier$2$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f14030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f14031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f14032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ float f14033d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f14034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ State f14035g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f14036h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ DraggableState f14037i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ State f14038j;

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$1$1", f = "Slider.kt", l = {924}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f14040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ long f14041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f14042d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f14043f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ MutableState f14044g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ State f14045h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z2, float f3, MutableState mutableState, State state, Continuation continuation) {
            super(3, continuation);
            this.f14042d = z2;
            this.f14043f = f3;
            this.f14044g = mutableState;
            this.f14045h = state;
        }

        public final Object h(PressGestureScope pressGestureScope, long j3, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f14042d, this.f14043f, this.f14044g, this.f14045h, continuation);
            anonymousClass1.f14040b = pressGestureScope;
            anonymousClass1.f14041c = j3;
            return anonymousClass1.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return h((PressGestureScope) obj, ((Offset) obj2).u(), (Continuation) obj3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f14039a;
            try {
                if (i3 == 0) {
                    ResultKt.b(obj);
                    PressGestureScope pressGestureScope = (PressGestureScope) this.f14040b;
                    long j3 = this.f14041c;
                    this.f14044g.setValue(Boxing.c((this.f14042d ? this.f14043f - Offset.m(j3) : Offset.m(j3)) - ((Number) this.f14045h.getValue()).floatValue()));
                    this.f14039a = 1;
                    if (pressGestureScope.m1(this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
            } catch (GestureCancellationException unused) {
                this.f14044g.setValue(Boxing.c(0.0f));
            }
            return Unit.f139807a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SliderKt$sliderTapModifier$2$1$1(boolean z2, float f3, MutableState mutableState, State state, CoroutineScope coroutineScope, DraggableState draggableState, State state2, Continuation continuation) {
        super(2, continuation);
        this.f14032c = z2;
        this.f14033d = f3;
        this.f14034f = mutableState;
        this.f14035g = state;
        this.f14036h = coroutineScope;
        this.f14037i = draggableState;
        this.f14038j = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SliderKt$sliderTapModifier$2$1$1 sliderKt$sliderTapModifier$2$1$1 = new SliderKt$sliderTapModifier$2$1$1(this.f14032c, this.f14033d, this.f14034f, this.f14035g, this.f14036h, this.f14037i, this.f14038j, continuation);
        sliderKt$sliderTapModifier$2$1$1.f14031b = obj;
        return sliderKt$sliderTapModifier$2$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        return ((SliderKt$sliderTapModifier$2$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f14030a;
        if (i3 == 0) {
            ResultKt.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.f14031b;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f14032c, this.f14033d, this.f14034f, this.f14035g, null);
            final CoroutineScope coroutineScope = this.f14036h;
            final DraggableState draggableState = this.f14037i;
            final State state = this.f14038j;
            Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.material.SliderKt$sliderTapModifier$2$1$1.2

                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$1$2$1", f = "Slider.kt", l = {931}, m = "invokeSuspend")
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    int f14049a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ DraggableState f14050b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ State f14051c;

                    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$1$2$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$1$2$1$1", f = "Slider.kt", l = {}, m = "invokeSuspend")
                    static final class C00441 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        int f14052a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        private /* synthetic */ Object f14053b;

                        C00441(Continuation continuation) {
                            super(2, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            C00441 c00441 = new C00441(continuation);
                            c00441.f14053b = obj;
                            return c00441;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                        public final Object invoke(DragScope dragScope, Continuation continuation) {
                            return ((C00441) create(dragScope, continuation)).invokeSuspend(Unit.f139807a);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            IntrinsicsKt.f();
                            if (this.f14052a != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                            ((DragScope) this.f14053b).a(0.0f);
                            return Unit.f139807a;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(DraggableState draggableState, State state, Continuation continuation) {
                        super(2, continuation);
                        this.f14050b = draggableState;
                        this.f14051c = state;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        return new AnonymousClass1(this.f14050b, this.f14051c, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.f14049a;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            DraggableState draggableState = this.f14050b;
                            MutatePriority mutatePriority = MutatePriority.f5072b;
                            C00441 c00441 = new C00441(null);
                            this.f14049a = 1;
                            if (draggableState.a(mutatePriority, c00441, this) == objF) {
                                return objF;
                            }
                        } else {
                            if (i3 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                        }
                        ((Function1) this.f14051c.getValue()).invoke(Boxing.c(0.0f));
                        return Unit.f139807a;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(long j3) {
                    BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass1(draggableState, state, null), 3, null);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    c(((Offset) obj2).u());
                    return Unit.f139807a;
                }
            };
            this.f14030a = 1;
            if (TapGestureDetectorKt.m(pointerInputScope, null, null, anonymousClass1, function1, this, 3, null) == objF) {
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
}
