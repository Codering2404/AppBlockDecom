package androidx.compose.material;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

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
@DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1", f = "Slider.kt", l = {992}, m = "invokeSuspend")
final class SliderKt$rangeSliderPressDragModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f13962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f13963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableInteractionSource f13964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableInteractionSource f13965d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ State f13966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ State f13967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ State f13968h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f13969i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ float f13970j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ State f13971k;

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1", f = "Slider.kt", l = {993}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f13973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PointerInputScope f13974c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f13975d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f13976f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ RangeSliderLogic f13977g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ State f13978h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ State f13979i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ State f13980j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ State f13981k;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1", f = "Slider.kt", l = {994, 1004, 1023}, m = "invokeSuspend")
        static final class C00431 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f13982a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f13983b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f13984c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f13985d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f13986f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private /* synthetic */ Object f13987g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ boolean f13988h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ float f13989i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ RangeSliderLogic f13990j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            final /* synthetic */ State f13991k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            final /* synthetic */ CoroutineScope f13992l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            final /* synthetic */ State f13993m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            final /* synthetic */ State f13994n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            final /* synthetic */ State f13995o;

            /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$2", f = "Slider.kt", l = {1040}, m = "invokeSuspend")
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f13996a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ RangeSliderLogic f13997b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ Ref.BooleanRef f13998c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ DragInteraction f13999d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(RangeSliderLogic rangeSliderLogic, Ref.BooleanRef booleanRef, DragInteraction dragInteraction, Continuation continuation) {
                    super(2, continuation);
                    this.f13997b = rangeSliderLogic;
                    this.f13998c = booleanRef;
                    this.f13999d = dragInteraction;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass2(this.f13997b, this.f13998c, this.f13999d, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f13996a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        MutableInteractionSource mutableInteractionSourceA = this.f13997b.a(this.f13998c.f140137a);
                        DragInteraction dragInteraction = this.f13999d;
                        this.f13996a = 1;
                        if (mutableInteractionSourceA.a(dragInteraction, this) == objF) {
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
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00431(boolean z2, float f3, RangeSliderLogic rangeSliderLogic, State state, CoroutineScope coroutineScope, State state2, State state3, State state4, Continuation continuation) {
                super(2, continuation);
                this.f13988h = z2;
                this.f13989i = f3;
                this.f13990j = rangeSliderLogic;
                this.f13991k = state;
                this.f13992l = coroutineScope;
                this.f13993m = state2;
                this.f13994n = state3;
                this.f13995o = state4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                C00431 c00431 = new C00431(this.f13988h, this.f13989i, this.f13990j, this.f13991k, this.f13992l, this.f13993m, this.f13994n, this.f13995o, continuation);
                c00431.f13987g = obj;
                return c00431;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
                return ((C00431) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:52:0x0172, code lost:
            
                if (r1 != r6) goto L54;
             */
            /* JADX WARN: Removed duplicated region for block: B:36:0x00df  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 437
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1.AnonymousClass1.C00431.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PointerInputScope pointerInputScope, boolean z2, float f3, RangeSliderLogic rangeSliderLogic, State state, State state2, State state3, State state4, Continuation continuation) {
            super(2, continuation);
            this.f13974c = pointerInputScope;
            this.f13975d = z2;
            this.f13976f = f3;
            this.f13977g = rangeSliderLogic;
            this.f13978h = state;
            this.f13979i = state2;
            this.f13980j = state3;
            this.f13981k = state4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f13974c, this.f13975d, this.f13976f, this.f13977g, this.f13978h, this.f13979i, this.f13980j, this.f13981k, continuation);
            anonymousClass1.f13973b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f13972a;
            if (i3 == 0) {
                ResultKt.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f13973b;
                PointerInputScope pointerInputScope = this.f13974c;
                C00431 c00431 = new C00431(this.f13975d, this.f13976f, this.f13977g, this.f13978h, coroutineScope, this.f13979i, this.f13980j, this.f13981k, null);
                this.f13972a = 1;
                if (ForEachGestureKt.e(pointerInputScope, c00431, this) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SliderKt$rangeSliderPressDragModifier$1(MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State state, State state2, State state3, boolean z2, float f3, State state4, Continuation continuation) {
        super(2, continuation);
        this.f13964c = mutableInteractionSource;
        this.f13965d = mutableInteractionSource2;
        this.f13966f = state;
        this.f13967g = state2;
        this.f13968h = state3;
        this.f13969i = z2;
        this.f13970j = f3;
        this.f13971k = state4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SliderKt$rangeSliderPressDragModifier$1 sliderKt$rangeSliderPressDragModifier$1 = new SliderKt$rangeSliderPressDragModifier$1(this.f13964c, this.f13965d, this.f13966f, this.f13967g, this.f13968h, this.f13969i, this.f13970j, this.f13971k, continuation);
        sliderKt$rangeSliderPressDragModifier$1.f13963b = obj;
        return sliderKt$rangeSliderPressDragModifier$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        return ((SliderKt$rangeSliderPressDragModifier$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f13962a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1((PointerInputScope) this.f13963b, this.f13969i, this.f13970j, new RangeSliderLogic(this.f13964c, this.f13965d, this.f13966f, this.f13967g, this.f13968h), this.f13966f, this.f13971k, this.f13967g, this.f13968h, null);
            this.f13962a = 1;
            if (CoroutineScopeKt.f(anonymousClass1, this) == objF) {
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
