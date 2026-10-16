package cz.mobilesoft.coreblock.view.compose.slider;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final class StyledSliderKt$rangeSliderPressDragModifier$1 implements PointerInputEventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MutableInteractionSource f132085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableInteractionSource f132086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ State f132087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ State f132088d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ State f132089f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f132090g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ float f132091h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ State f132092i;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$rangeSliderPressDragModifier$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$rangeSliderPressDragModifier$1$1", f = "StyledSlider.kt", l = {602}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f132093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f132094b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PointerInputScope f132095c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f132096d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f132097f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ RangeSliderLogic f132098g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ State f132099h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ State f132100i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ State f132101j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ State f132102k;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$rangeSliderPressDragModifier$1$1$1", f = "StyledSlider.kt", l = {603, 613, 632}, m = "invokeSuspend", v = 1)
        static final class C03121 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f132103a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f132104b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f132105c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f132106d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f132107f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            int f132108g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private /* synthetic */ Object f132109h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ boolean f132110i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ float f132111j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            final /* synthetic */ RangeSliderLogic f132112k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            final /* synthetic */ State f132113l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            final /* synthetic */ CoroutineScope f132114m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            final /* synthetic */ State f132115n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            final /* synthetic */ State f132116o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            final /* synthetic */ State f132117p;

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$rangeSliderPressDragModifier$1$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$rangeSliderPressDragModifier$1$1$1$2", f = "StyledSlider.kt", l = {649}, m = "invokeSuspend", v = 1)
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f132118a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ RangeSliderLogic f132119b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ Ref.BooleanRef f132120c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ DragInteraction f132121d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(RangeSliderLogic rangeSliderLogic, Ref.BooleanRef booleanRef, DragInteraction dragInteraction, Continuation continuation) {
                    super(2, continuation);
                    this.f132119b = rangeSliderLogic;
                    this.f132120c = booleanRef;
                    this.f132121d = dragInteraction;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass2(this.f132119b, this.f132120c, this.f132121d, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f132118a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        MutableInteractionSource mutableInteractionSourceA = this.f132119b.a(this.f132120c.f140137a);
                        DragInteraction dragInteraction = this.f132121d;
                        this.f132118a = 1;
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
            C03121(boolean z2, float f3, RangeSliderLogic rangeSliderLogic, State state, CoroutineScope coroutineScope, State state2, State state3, State state4, Continuation continuation) {
                super(2, continuation);
                this.f132110i = z2;
                this.f132111j = f3;
                this.f132112k = rangeSliderLogic;
                this.f132113l = state;
                this.f132114m = coroutineScope;
                this.f132115n = state2;
                this.f132116o = state3;
                this.f132117p = state4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit q(State state, Ref.BooleanRef booleanRef, boolean z2, PointerInputChange pointerInputChange) {
                float fIntBitsToFloat = Float.intBitsToFloat((int) (PointerEventKt.g(pointerInputChange) >> 32));
                Function2 function2 = (Function2) state.getValue();
                Boolean boolValueOf = Boolean.valueOf(booleanRef.f140137a);
                if (z2) {
                    fIntBitsToFloat = -fIntBitsToFloat;
                }
                function2.invoke(boolValueOf, Float.valueOf(fIntBitsToFloat));
                return Unit.f139807a;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                C03121 c03121 = new C03121(this.f132110i, this.f132111j, this.f132112k, this.f132113l, this.f132114m, this.f132115n, this.f132116o, this.f132117p, continuation);
                c03121.f132109h = obj;
                return c03121;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
                return ((C03121) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:51:0x018f, code lost:
            
                if (r0 != r6) goto L53;
             */
            /* JADX WARN: Removed duplicated region for block: B:35:0x00e9  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 471
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$rangeSliderPressDragModifier$1.AnonymousClass1.C03121.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PointerInputScope pointerInputScope, boolean z2, float f3, RangeSliderLogic rangeSliderLogic, State state, State state2, State state3, State state4, Continuation continuation) {
            super(2, continuation);
            this.f132095c = pointerInputScope;
            this.f132096d = z2;
            this.f132097f = f3;
            this.f132098g = rangeSliderLogic;
            this.f132099h = state;
            this.f132100i = state2;
            this.f132101j = state3;
            this.f132102k = state4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f132095c, this.f132096d, this.f132097f, this.f132098g, this.f132099h, this.f132100i, this.f132101j, this.f132102k, continuation);
            anonymousClass1.f132094b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineScope coroutineScope = (CoroutineScope) this.f132094b;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f132093a;
            if (i3 == 0) {
                ResultKt.b(obj);
                PointerInputScope pointerInputScope = this.f132095c;
                C03121 c03121 = new C03121(this.f132096d, this.f132097f, this.f132098g, this.f132099h, coroutineScope, this.f132100i, this.f132101j, this.f132102k, null);
                this.f132094b = SpillingKt.a(coroutineScope);
                this.f132093a = 1;
                if (ForEachGestureKt.e(pointerInputScope, c03121, this) == objF) {
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

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
        Object objF = CoroutineScopeKt.f(new AnonymousClass1(pointerInputScope, this.f132090g, this.f132091h, new RangeSliderLogic(this.f132085a, this.f132086b, this.f132087c, this.f132088d, this.f132089f), this.f132087c, this.f132092i, this.f132088d, this.f132089f, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }
}
