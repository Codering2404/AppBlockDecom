package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class AnimatedContentTransitionScopeImpl<S> implements AnimatedContentTransitionScope<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Transition f3247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Alignment f3248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LayoutDirection f3249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f3250d = SnapshotStateKt__SnapshotStateKt.e(IntSize.b(IntSize.f29998b.a()), null, 2, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableScatterMap f3251e = ScatterMapKt.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private State f3252f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    private static final class SizeModifierElement<S> extends ModifierNodeElement<SizeModifierNode<S>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Transition.DeferredAnimation f3254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final State f3255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AnimatedContentTransitionScopeImpl f3256c;

        public SizeModifierElement(Transition.DeferredAnimation deferredAnimation, State state, AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl) {
            this.f3254a = deferredAnimation;
            this.f3255b = state;
            this.f3256c = animatedContentTransitionScopeImpl;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SizeModifierNode create() {
            return new SizeModifierNode(this.f3254a, this.f3255b, this.f3256c);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void update(SizeModifierNode sizeModifierNode) {
            sizeModifierNode.r2(this.f3254a);
            sizeModifierNode.s2(this.f3255b);
            sizeModifierNode.q2(this.f3256c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SizeModifierElement)) {
                return false;
            }
            SizeModifierElement sizeModifierElement = (SizeModifierElement) obj;
            return Intrinsics.areEqual(sizeModifierElement.f3254a, this.f3254a) && Intrinsics.areEqual(sizeModifierElement.f3255b, this.f3255b);
        }

        public int hashCode() {
            int iHashCode = this.f3256c.hashCode() * 31;
            Transition.DeferredAnimation deferredAnimation = this.f3254a;
            return ((iHashCode + (deferredAnimation != null ? deferredAnimation.hashCode() : 0)) * 31) + this.f3255b.hashCode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.d("sizeTransform");
            inspectorInfo.b().c(wgbAZXYjrv.IsKWhF, this.f3254a);
            inspectorInfo.b().c("sizeTransform", this.f3255b);
            inspectorInfo.b().c("scope", this.f3256c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class SizeModifierNode<S> extends LayoutModifierNodeWithPassThroughIntrinsics {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Transition.DeferredAnimation f3257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private State f3258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private AnimatedContentTransitionScopeImpl f3259c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f3260d = AnimatedContentKt.f3187a;

        public SizeModifierNode(Transition.DeferredAnimation deferredAnimation, State state, AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl) {
            this.f3257a = deferredAnimation;
            this.f3258b = state;
            this.f3259c = animatedContentTransitionScopeImpl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long p2(long j3) {
            return IntSize.e(this.f3260d, AnimatedContentKt.f3187a) ? j3 : this.f3260d;
        }

        @Override // androidx.compose.ui.node.LayoutModifierNode
        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
        public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
            final long j4;
            final Placeable placeableN0 = measurable.n0(j3);
            if (measureScope.q0()) {
                j4 = IntSize.c((((long) placeableN0.X0()) << 32) | (((long) placeableN0.O0()) & 4294967295L));
            } else if (this.f3257a == null) {
                j4 = IntSize.c((((long) placeableN0.X0()) << 32) | (((long) placeableN0.O0()) & 4294967295L));
                this.f3260d = IntSize.c((((long) placeableN0.X0()) << 32) | (((long) placeableN0.O0()) & 4294967295L));
            } else {
                final long jC = IntSize.c((((long) placeableN0.X0()) << 32) | (((long) placeableN0.O0()) & 4294967295L));
                Transition.DeferredAnimation deferredAnimation = this.f3257a;
                Intrinsics.checkNotNull(deferredAnimation);
                State stateA = deferredAnimation.a(new Function1<Transition.Segment<S>, FiniteAnimationSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifierNode$measure$size$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final FiniteAnimationSpec invoke(Transition.Segment segment) {
                        long j5;
                        FiniteAnimationSpec finiteAnimationSpecB;
                        if (Intrinsics.areEqual(segment.c(), this.f3264a.n2().c())) {
                            j5 = this.f3264a.p2(jC);
                        } else {
                            State state = (State) this.f3264a.n2().n().e(segment.c());
                            j5 = state != null ? ((IntSize) state.getValue()).j() : IntSize.f29998b.a();
                        }
                        State state2 = (State) this.f3264a.n2().n().e(segment.a());
                        long j6 = state2 != null ? ((IntSize) state2.getValue()).j() : IntSize.f29998b.a();
                        SizeTransform sizeTransform = (SizeTransform) this.f3264a.o2().getValue();
                        return (sizeTransform == null || (finiteAnimationSpecB = sizeTransform.b(j5, j6)) == null) ? AnimationSpecKt.l(0.0f, 400.0f, null, 5, null) : finiteAnimationSpecB;
                    }
                }, new Function1<S, IntSize>() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifierNode$measure$size$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final long c(Object obj) {
                        if (Intrinsics.areEqual(obj, this.f3266a.n2().c())) {
                            return this.f3266a.p2(jC);
                        }
                        State state = (State) this.f3266a.n2().n().e(obj);
                        return state != null ? ((IntSize) state.getValue()).j() : IntSize.f29998b.a();
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return IntSize.b(c(obj));
                    }
                });
                this.f3259c.p(stateA);
                j4 = ((IntSize) stateA.getValue()).j();
                this.f3260d = ((IntSize) stateA.getValue()).j();
            }
            return MeasureScope.B0(measureScope, (int) (j4 >> 32), (int) (j4 & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifierNode$measure$1
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
                    Placeable.PlacementScope.k(placementScope, placeableN0, this.f3261a.n2().k().a(IntSize.c((((long) placeableN0.X0()) << 32) | (((long) placeableN0.O0()) & 4294967295L)), j4, LayoutDirection.f30001a), 0.0f, 2, null);
                }
            }, 4, null);
        }

        public final AnimatedContentTransitionScopeImpl n2() {
            return this.f3259c;
        }

        public final State o2() {
            return this.f3258b;
        }

        @Override // androidx.compose.ui.Modifier.Node
        public void onReset() {
            super.onReset();
            this.f3260d = AnimatedContentKt.f3187a;
        }

        public final void q2(AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl) {
            this.f3259c = animatedContentTransitionScopeImpl;
        }

        public final void r2(Transition.DeferredAnimation deferredAnimation) {
            this.f3257a = deferredAnimation;
        }

        public final void s2(State state) {
            this.f3258b = state;
        }
    }

    public AnimatedContentTransitionScopeImpl(Transition transition, Alignment alignment, LayoutDirection layoutDirection) {
        this.f3247a = transition;
        this.f3248b = alignment;
        this.f3249c = layoutDirection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long g(long j3, long j4) {
        return k().a(j3, j4, LayoutDirection.f30001a);
    }

    private static final boolean i(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void j(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long l() {
        State state = this.f3252f;
        return state != null ? ((IntSize) state.getValue()).j() : m();
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public Object a() {
        return this.f3247a.o().a();
    }

    @Override // androidx.compose.animation.AnimatedContentTransitionScope
    public ContentTransform b(ContentTransform contentTransform, SizeTransform sizeTransform) {
        contentTransform.e(sizeTransform);
        return contentTransform;
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public Object c() {
        return this.f3247a.o().c();
    }

    public final Modifier h(ContentTransform contentTransform, Composer composer, int i3) {
        Modifier modifier;
        if (ComposerKt.M()) {
            ComposerKt.U(93755870, i3, -1, "androidx.compose.animation.AnimatedContentTransitionScopeImpl.createSizeAnimationModifier (AnimatedContent.kt:556)");
        }
        boolean Z = composer.Z(this);
        Object objG = composer.G();
        Transition.DeferredAnimation deferredAnimationE = null;
        if (Z || objG == Composer.f23746a.a()) {
            objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
            composer.w(objG);
        }
        MutableState mutableState = (MutableState) objG;
        State stateP = SnapshotStateKt.p(contentTransform.b(), composer, 0);
        if (Intrinsics.areEqual(this.f3247a.i(), this.f3247a.q())) {
            j(mutableState, false);
        } else if (stateP.getValue() != null) {
            j(mutableState, true);
        }
        if (i(mutableState)) {
            composer.a0(249676467);
            deferredAnimationE = androidx.compose.animation.core.TransitionKt.e(this.f3247a, VectorConvertersKt.h(IntSize.f29998b), null, composer, 0, 2);
            boolean Z2 = composer.Z(deferredAnimationE);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                SizeTransform sizeTransform = (SizeTransform) stateP.getValue();
                objG2 = (sizeTransform == null || sizeTransform.a()) ? ClipKt.b(Modifier.b8) : Modifier.b8;
                composer.w(objG2);
            }
            modifier = (Modifier) objG2;
            composer.U();
        } else {
            composer.a0(249942509);
            composer.U();
            this.f3252f = null;
            modifier = Modifier.b8;
        }
        Modifier modifierThen = modifier.then(new SizeModifierElement(deferredAnimationE, stateP, this));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return modifierThen;
    }

    public Alignment k() {
        return this.f3248b;
    }

    public final long m() {
        return ((IntSize) this.f3250d.getValue()).j();
    }

    public final MutableScatterMap n() {
        return this.f3251e;
    }

    public final Transition o() {
        return this.f3247a;
    }

    public final void p(State state) {
        this.f3252f = state;
    }

    public void q(Alignment alignment) {
        this.f3248b = alignment;
    }

    public final void r(LayoutDirection layoutDirection) {
        this.f3249c = layoutDirection;
    }

    public final void s(long j3) {
        this.f3250d.setValue(IntSize.b(j3));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ChildData implements ParentDataModifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MutableState f3253a;

        public ChildData(boolean z2) {
            this.f3253a = SnapshotStateKt__SnapshotStateKt.e(Boolean.valueOf(z2), null, 2, null);
        }

        public final boolean a() {
            return ((Boolean) this.f3253a.getValue()).booleanValue();
        }

        public final void b(boolean z2) {
            this.f3253a.setValue(Boolean.valueOf(z2));
        }

        @Override // androidx.compose.ui.layout.ParentDataModifier
        public Object H(Density density, Object obj) {
            return this;
        }
    }
}
