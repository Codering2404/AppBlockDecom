package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
final class EnterExitTransitionModifierNode extends LayoutModifierNodeWithPassThroughIntrinsics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Transition f3533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Transition.DeferredAnimation f3534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Transition.DeferredAnimation f3535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Transition.DeferredAnimation f3536d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private EnterTransition f3537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ExitTransition f3538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Function0 f3539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private GraphicsLayerBlockForEnterExit f3540i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3541j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Alignment f3544m;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f3542k = AnimationModifierKt.c();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f3543l = ConstraintsKt.b(0, 0, 0, 0, 15, null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Function1 f3545n = new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$sizeTransitionSpec$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final FiniteAnimationSpec invoke(Transition.Segment segment) {
            EnterExitState enterExitState = EnterExitState.f3475a;
            EnterExitState enterExitState2 = EnterExitState.f3476b;
            FiniteAnimationSpec finiteAnimationSpecB = null;
            if (segment.d(enterExitState, enterExitState2)) {
                ChangeSize changeSizeA = this.f3561a.n2().b().a();
                if (changeSizeA != null) {
                    finiteAnimationSpecB = changeSizeA.b();
                }
            } else if (segment.d(enterExitState2, EnterExitState.f3477c)) {
                ChangeSize changeSizeA2 = this.f3561a.o2().b().a();
                if (changeSizeA2 != null) {
                    finiteAnimationSpecB = changeSizeA2.b();
                }
            } else {
                finiteAnimationSpecB = EnterExitTransitionKt.f3491d;
            }
            return finiteAnimationSpecB == null ? EnterExitTransitionKt.f3491d : finiteAnimationSpecB;
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Function1 f3546o = new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$slideSpec$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final FiniteAnimationSpec invoke(Transition.Segment segment) {
            FiniteAnimationSpec finiteAnimationSpecA;
            FiniteAnimationSpec finiteAnimationSpecA2;
            EnterExitState enterExitState = EnterExitState.f3475a;
            EnterExitState enterExitState2 = EnterExitState.f3476b;
            if (segment.d(enterExitState, enterExitState2)) {
                Slide slideF = this.f3562a.n2().b().f();
                return (slideF == null || (finiteAnimationSpecA2 = slideF.a()) == null) ? EnterExitTransitionKt.f3490c : finiteAnimationSpecA2;
            }
            if (!segment.d(enterExitState2, EnterExitState.f3477c)) {
                return EnterExitTransitionKt.f3490c;
            }
            Slide slideF2 = this.f3562a.o2().b().f();
            return (slideF2 == null || (finiteAnimationSpecA = slideF2.a()) == null) ? EnterExitTransitionKt.f3490c : finiteAnimationSpecA;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3547a;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            try {
                iArr[EnterExitState.f3476b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnterExitState.f3475a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnterExitState.f3477c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f3547a = iArr;
        }
    }

    public EnterExitTransitionModifierNode(Transition transition, Transition.DeferredAnimation deferredAnimation, Transition.DeferredAnimation deferredAnimation2, Transition.DeferredAnimation deferredAnimation3, EnterTransition enterTransition, ExitTransition exitTransition, Function0 function0, GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit) {
        this.f3533a = transition;
        this.f3534b = deferredAnimation;
        this.f3535c = deferredAnimation2;
        this.f3536d = deferredAnimation3;
        this.f3537f = enterTransition;
        this.f3538g = exitTransition;
        this.f3539h = function0;
        this.f3540i = graphicsLayerBlockForEnterExit;
    }

    private final void t2(long j3) {
        this.f3541j = true;
        this.f3543l = j3;
    }

    public final long A2(EnterExitState enterExitState, long j3) {
        if (this.f3544m == null) {
            return IntOffset.f29988b.b();
        }
        if (m2() == null) {
            return IntOffset.f29988b.b();
        }
        if (Intrinsics.areEqual(this.f3544m, m2())) {
            return IntOffset.f29988b.b();
        }
        int i3 = WhenMappings.f3547a[enterExitState.ordinal()];
        if (i3 == 1) {
            return IntOffset.f29988b.b();
        }
        if (i3 == 2) {
            return IntOffset.f29988b.b();
        }
        if (i3 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        ChangeSize changeSizeA = this.f3538g.b().a();
        if (changeSizeA == null) {
            return IntOffset.f29988b.b();
        }
        long j4 = ((IntSize) changeSizeA.d().invoke(IntSize.b(j3))).j();
        Alignment alignmentM2 = m2();
        Intrinsics.checkNotNull(alignmentM2);
        LayoutDirection layoutDirection = LayoutDirection.f30001a;
        long jA = alignmentM2.a(j3, j4, layoutDirection);
        Alignment alignment = this.f3544m;
        Intrinsics.checkNotNull(alignment);
        return IntOffset.n(jA, alignment.a(j3, j4, layoutDirection));
    }

    public final Alignment m2() {
        Alignment alignmentA;
        Alignment alignmentA2;
        if (this.f3533a.o().d(EnterExitState.f3475a, EnterExitState.f3476b)) {
            ChangeSize changeSizeA = this.f3537f.b().a();
            if (changeSizeA != null && (alignmentA2 = changeSizeA.a()) != null) {
                return alignmentA2;
            }
            ChangeSize changeSizeA2 = this.f3538g.b().a();
            if (changeSizeA2 != null) {
                return changeSizeA2.a();
            }
            return null;
        }
        ChangeSize changeSizeA3 = this.f3538g.b().a();
        if (changeSizeA3 != null && (alignmentA = changeSizeA3.a()) != null) {
            return alignmentA;
        }
        ChangeSize changeSizeA4 = this.f3537f.b().a();
        if (changeSizeA4 != null) {
            return changeSizeA4.a();
        }
        return null;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        State stateA;
        State stateA2;
        if (this.f3533a.i() == this.f3533a.q()) {
            this.f3544m = null;
        } else if (this.f3544m == null) {
            Alignment alignmentM2 = m2();
            if (alignmentM2 == null) {
                alignmentM2 = Alignment.f25072a.o();
            }
            this.f3544m = alignmentM2;
        }
        if (measureScope.q0()) {
            final Placeable placeableN0 = measurable.n0(j3);
            long jC = IntSize.c((((long) placeableN0.X0()) << 32) | (((long) placeableN0.O0()) & 4294967295L));
            this.f3542k = jC;
            t2(j3);
            return MeasureScope.B0(measureScope, (int) (jC >> 32), (int) (jC & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.f139807a;
                }

                public final void invoke(Placeable.PlacementScope placementScope) {
                    Placeable.PlacementScope.i(placementScope, placeableN0, 0, 0, 0.0f, 4, null);
                }
            }, 4, null);
        }
        if (!((Boolean) this.f3539h.invoke()).booleanValue()) {
            final Placeable placeableN02 = measurable.n0(j3);
            return MeasureScope.B0(measureScope, placeableN02.X0(), placeableN02.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$3$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.f139807a;
                }

                public final void invoke(Placeable.PlacementScope placementScope) {
                    Placeable.PlacementScope.i(placementScope, placeableN02, 0, 0, 0.0f, 4, null);
                }
            }, 4, null);
        }
        final Function1 function1Init = this.f3540i.init();
        final Placeable placeableN03 = measurable.n0(j3);
        long jC2 = IntSize.c((((long) placeableN03.X0()) << 32) | (((long) placeableN03.O0()) & 4294967295L));
        final long j4 = AnimationModifierKt.d(this.f3542k) ? this.f3542k : jC2;
        Transition.DeferredAnimation deferredAnimation = this.f3534b;
        State stateA3 = deferredAnimation != null ? deferredAnimation.a(this.f3545n, new Function1<EnterExitState, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$animSize$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final long c(EnterExitState enterExitState) {
                return this.f3554a.y2(enterExitState, j4);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntSize.b(c((EnterExitState) obj));
            }
        }) : null;
        if (stateA3 != null) {
            jC2 = ((IntSize) stateA3.getValue()).j();
        }
        long jD = ConstraintsKt.d(j3, jC2);
        Transition.DeferredAnimation deferredAnimation2 = this.f3535c;
        long jB = (deferredAnimation2 == null || (stateA2 = deferredAnimation2.a(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$offsetDelta$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final FiniteAnimationSpec invoke(Transition.Segment segment) {
                return EnterExitTransitionKt.f3490c;
            }
        }, new Function1<EnterExitState, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$offsetDelta$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final long c(EnterExitState enterExitState) {
                return this.f3557a.A2(enterExitState, j4);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntOffset.c(c((EnterExitState) obj));
            }
        })) == null) ? IntOffset.f29988b.b() : ((IntOffset) stateA2.getValue()).r();
        Transition.DeferredAnimation deferredAnimation3 = this.f3536d;
        long jB2 = (deferredAnimation3 == null || (stateA = deferredAnimation3.a(this.f3546o, new Function1<EnterExitState, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$slideOffset$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final long c(EnterExitState enterExitState) {
                return this.f3559a.z2(enterExitState, j4);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntOffset.c(c((EnterExitState) obj));
            }
        })) == null) ? IntOffset.f29988b.b() : ((IntOffset) stateA.getValue()).r();
        Alignment alignment = this.f3544m;
        final long jO = IntOffset.o(alignment != null ? alignment.a(j4, jD, LayoutDirection.f30001a) : IntOffset.f29988b.b(), jB2);
        final long j5 = jB;
        return MeasureScope.B0(measureScope, (int) (jD >> 32), (int) (jD & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionModifierNode$measure$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                placementScope.v(placeableN03, IntOffset.k(j5) + IntOffset.k(jO), IntOffset.l(j5) + IntOffset.l(jO), 0.0f, function1Init);
            }
        }, 4, null);
    }

    public final EnterTransition n2() {
        return this.f3537f;
    }

    public final ExitTransition o2() {
        return this.f3538g;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        this.f3541j = false;
        this.f3542k = AnimationModifierKt.c();
    }

    public final void p2(Function0 function0) {
        this.f3539h = function0;
    }

    public final void q2(EnterTransition enterTransition) {
        this.f3537f = enterTransition;
    }

    public final void r2(ExitTransition exitTransition) {
        this.f3538g = exitTransition;
    }

    public final void s2(GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit) {
        this.f3540i = graphicsLayerBlockForEnterExit;
    }

    public final void u2(Transition.DeferredAnimation deferredAnimation) {
        this.f3535c = deferredAnimation;
    }

    public final void v2(Transition.DeferredAnimation deferredAnimation) {
        this.f3534b = deferredAnimation;
    }

    public final void w2(Transition.DeferredAnimation deferredAnimation) {
        this.f3536d = deferredAnimation;
    }

    public final void x2(Transition transition) {
        this.f3533a = transition;
    }

    public final long y2(EnterExitState enterExitState, long j3) {
        Function1 function1D;
        Function1 function1D2;
        int i3 = WhenMappings.f3547a[enterExitState.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                ChangeSize changeSizeA = this.f3537f.b().a();
                if (changeSizeA != null && (function1D = changeSizeA.d()) != null) {
                    return ((IntSize) function1D.invoke(IntSize.b(j3))).j();
                }
            } else {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                ChangeSize changeSizeA2 = this.f3538g.b().a();
                if (changeSizeA2 != null && (function1D2 = changeSizeA2.d()) != null) {
                    return ((IntSize) function1D2.invoke(IntSize.b(j3))).j();
                }
            }
        }
        return j3;
    }

    public final long z2(EnterExitState enterExitState, long j3) {
        Function1 function1B;
        Function1 function1B2;
        Slide slideF = this.f3537f.b().f();
        long jB = (slideF == null || (function1B2 = slideF.b()) == null) ? IntOffset.f29988b.b() : ((IntOffset) function1B2.invoke(IntSize.b(j3))).r();
        Slide slideF2 = this.f3538g.b().f();
        long jB2 = (slideF2 == null || (function1B = slideF2.b()) == null) ? IntOffset.f29988b.b() : ((IntOffset) function1B.invoke(IntSize.b(j3))).r();
        int i3 = WhenMappings.f3547a[enterExitState.ordinal()];
        if (i3 == 1) {
            return IntOffset.f29988b.b();
        }
        if (i3 == 2) {
            return jB;
        }
        if (i3 == 3) {
            return jB2;
        }
        throw new NoWhenBranchMatchedException();
    }
}
