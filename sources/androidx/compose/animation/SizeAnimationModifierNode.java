package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

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
final class SizeAnimationModifierNode extends LayoutModifierNodeWithPassThroughIntrinsics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AnimationSpec f3717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Alignment f3718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function2 f3719c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3722g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f3720d = AnimationModifierKt.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f3721f = ConstraintsKt.b(0, 0, 0, 0, 15, null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableState f3723h = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnimData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Animatable f3724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f3725b;

        public /* synthetic */ AnimData(Animatable animatable, long j3, DefaultConstructorMarker defaultConstructorMarker) {
            this(animatable, j3);
        }

        public final Animatable a() {
            return this.f3724a;
        }

        public final long b() {
            return this.f3725b;
        }

        public final void c(long j3) {
            this.f3725b = j3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnimData)) {
                return false;
            }
            AnimData animData = (AnimData) obj;
            return Intrinsics.areEqual(this.f3724a, animData.f3724a) && IntSize.e(this.f3725b, animData.f3725b);
        }

        public int hashCode() {
            return (this.f3724a.hashCode() * 31) + IntSize.h(this.f3725b);
        }

        public String toString() {
            return "AnimData(anim=" + this.f3724a + ", startSize=" + ((Object) IntSize.i(this.f3725b)) + ')';
        }

        private AnimData(Animatable animatable, long j3) {
            this.f3724a = animatable;
            this.f3725b = j3;
        }
    }

    public SizeAnimationModifierNode(AnimationSpec animationSpec, Alignment alignment, Function2 function2) {
        this.f3717a = animationSpec;
        this.f3718b = alignment;
        this.f3719c = function2;
    }

    private final void v2(long j3) {
        this.f3721f = j3;
        this.f3722g = true;
    }

    private final long w2(long j3) {
        return this.f3722g ? this.f3721f : j3;
    }

    public final long m2(long j3) {
        AnimData animDataO2 = o2();
        if (animDataO2 != null) {
            boolean z2 = (IntSize.e(j3, ((IntSize) animDataO2.a().n()).j()) || animDataO2.a().q()) ? false : true;
            if (!IntSize.e(j3, ((IntSize) animDataO2.a().l()).j()) || z2) {
                animDataO2.c(((IntSize) animDataO2.a().n()).j());
                BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new SizeAnimationModifierNode$animateTo$data$1$1(animDataO2, j3, this, null), 3, null);
            }
        } else {
            long j4 = 1;
            animDataO2 = new AnimData(new Animatable(IntSize.b(j3), VectorConvertersKt.h(IntSize.f29998b), IntSize.b(IntSize.c((j4 & 4294967295L) | (j4 << 32))), null, 8, null), j3, null);
        }
        s2(animDataO2);
        return ((IntSize) animDataO2.a().n()).j();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j3) {
        Placeable placeableN0;
        long jD;
        if (measureScope.q0()) {
            v2(j3);
            placeableN0 = measurable.n0(j3);
        } else {
            placeableN0 = measurable.n0(w2(j3));
        }
        final Placeable placeable = placeableN0;
        final long jC = IntSize.c((((long) placeable.X0()) << 32) | (((long) placeable.O0()) & 4294967295L));
        if (measureScope.q0()) {
            this.f3720d = jC;
            jD = jC;
        } else {
            jD = ConstraintsKt.d(j3, m2(AnimationModifierKt.d(this.f3720d) ? this.f3720d : jC));
        }
        final int i3 = (int) (jD >> 32);
        final int i4 = (int) (jD & 4294967295L);
        return MeasureScope.B0(measureScope, i3, i4, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SizeAnimationModifierNode$measure$2
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
                Placeable.PlacementScope.k(placementScope, placeable, this.f3730a.n2().a(jC, IntSize.c((((long) i3) << 32) | (((long) i4) & 4294967295L)), measureScope.getLayoutDirection()), 0.0f, 2, null);
            }
        }, 4, null);
    }

    public final Alignment n2() {
        return this.f3718b;
    }

    public final AnimData o2() {
        return (AnimData) this.f3723h.getValue();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        this.f3720d = AnimationModifierKt.c();
        this.f3722g = false;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        super.onReset();
        s2(null);
    }

    public final AnimationSpec p2() {
        return this.f3717a;
    }

    public final Function2 q2() {
        return this.f3719c;
    }

    public final void r2(Alignment alignment) {
        this.f3718b = alignment;
    }

    public final void s2(AnimData animData) {
        this.f3723h.setValue(animData);
    }

    public final void t2(AnimationSpec animationSpec) {
        this.f3717a = animationSpec;
    }

    public final void u2(Function2 function2) {
        this.f3719c = function2;
    }
}
