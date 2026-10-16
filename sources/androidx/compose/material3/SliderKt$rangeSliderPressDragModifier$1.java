package androidx.compose.material3;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
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
@DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1", f = "Slider.kt", l = {1651}, m = "invokeSuspend")
final class SliderKt$rangeSliderPressDragModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f20139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f20140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RangeSliderState f20141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableInteractionSource f20142d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableInteractionSource f20143f;

    /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1", f = "Slider.kt", l = {1652}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f20145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PointerInputScope f20146c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ RangeSliderState f20147d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ RangeSliderLogic f20148f;

        /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1", f = "Slider.kt", l = {1653, 1665, 1687}, m = "invokeSuspend")
        static final class C00611 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f20149a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f20150b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f20151c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f20152d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f20153f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private /* synthetic */ Object f20154g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ RangeSliderState f20155h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ RangeSliderLogic f20156i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ CoroutineScope f20157j;

            /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$2", f = "Slider.kt", l = {1705}, m = "invokeSuspend")
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f20158a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ RangeSliderLogic f20159b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ Ref.BooleanRef f20160c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ DragInteraction f20161d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(RangeSliderLogic rangeSliderLogic, Ref.BooleanRef booleanRef, DragInteraction dragInteraction, Continuation continuation) {
                    super(2, continuation);
                    this.f20159b = rangeSliderLogic;
                    this.f20160c = booleanRef;
                    this.f20161d = dragInteraction;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass2(this.f20159b, this.f20160c, this.f20161d, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f20158a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        MutableInteractionSource mutableInteractionSourceA = this.f20159b.a(this.f20160c.f140137a);
                        DragInteraction dragInteraction = this.f20161d;
                        this.f20158a = 1;
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
            C00611(RangeSliderState rangeSliderState, RangeSliderLogic rangeSliderLogic, CoroutineScope coroutineScope, Continuation continuation) {
                super(2, continuation);
                this.f20155h = rangeSliderState;
                this.f20156i = rangeSliderLogic;
                this.f20157j = coroutineScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                C00611 c00611 = new C00611(this.f20155h, this.f20156i, this.f20157j, continuation);
                c00611.f20154g = obj;
                return c00611;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
                return ((C00611) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:51:0x0166, code lost:
            
                if (r1 != r6) goto L53;
             */
            /* JADX WARN: Removed duplicated region for block: B:36:0x00e3  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 423
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1.AnonymousClass1.C00611.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PointerInputScope pointerInputScope, RangeSliderState rangeSliderState, RangeSliderLogic rangeSliderLogic, Continuation continuation) {
            super(2, continuation);
            this.f20146c = pointerInputScope;
            this.f20147d = rangeSliderState;
            this.f20148f = rangeSliderLogic;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f20146c, this.f20147d, this.f20148f, continuation);
            anonymousClass1.f20145b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f20144a;
            if (i3 == 0) {
                ResultKt.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f20145b;
                PointerInputScope pointerInputScope = this.f20146c;
                C00611 c00611 = new C00611(this.f20147d, this.f20148f, coroutineScope, null);
                this.f20144a = 1;
                if (ForEachGestureKt.e(pointerInputScope, c00611, this) == objF) {
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
    SliderKt$rangeSliderPressDragModifier$1(RangeSliderState rangeSliderState, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Continuation continuation) {
        super(2, continuation);
        this.f20141c = rangeSliderState;
        this.f20142d = mutableInteractionSource;
        this.f20143f = mutableInteractionSource2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SliderKt$rangeSliderPressDragModifier$1 sliderKt$rangeSliderPressDragModifier$1 = new SliderKt$rangeSliderPressDragModifier$1(this.f20141c, this.f20142d, this.f20143f, continuation);
        sliderKt$rangeSliderPressDragModifier$1.f20140b = obj;
        return sliderKt$rangeSliderPressDragModifier$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        return ((SliderKt$rangeSliderPressDragModifier$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f20139a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1((PointerInputScope) this.f20140b, this.f20141c, new RangeSliderLogic(this.f20141c, this.f20142d, this.f20143f), null);
            this.f20139a = 1;
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
