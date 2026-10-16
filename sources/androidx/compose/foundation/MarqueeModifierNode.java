package androidx.compose.foundation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
final class MarqueeModifierNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, FocusEventModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f5043d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableIntState f5044f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableIntState f5045g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableState f5046h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Job f5047i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private GraphicsLayer f5048j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableState f5049k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MutableState f5050l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Animatable f5051m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final State f5052n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5053a;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.f30001a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.f30002b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f5053a = iArr;
        }
    }

    public /* synthetic */ MarqueeModifierNode(int i3, int i4, int i5, int i6, MarqueeSpacing marqueeSpacing, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, i5, i6, marqueeSpacing, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float A2() {
        float fSignum = Math.signum(this.f5043d);
        int i3 = WhenMappings.f5053a[DelegatableNodeKt.n(this).ordinal()];
        int i4 = 1;
        if (i3 != 1) {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i4 = -1;
        }
        return fSignum * i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean B2() {
        return ((Boolean) this.f5046h.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int C2() {
        return ((Number) this.f5052n.getValue()).intValue();
    }

    private final void D2() {
        Job job = this.f5047i;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        if (isAttached()) {
            this.f5047i = BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new MarqueeModifierNode$restartAnimation$1(job, this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object E2(Continuation continuation) {
        if (this.f5040a <= 0) {
            return Unit.f139807a;
        }
        Object objG = BuildersKt.g(FixedMotionDurationScale.f4917a, new MarqueeModifierNode$runAnimation$2(this, null), continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    private final void G2(int i3) {
        this.f5045g.a(i3);
    }

    private final void H2(int i3) {
        this.f5044f.a(i3);
    }

    private final void I2(boolean z2) {
        this.f5046h.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int y2() {
        return this.f5045g.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int z2() {
        return this.f5044f.g();
    }

    public final void F2(int i3) {
        this.f5050l.setValue(MarqueeAnimationMode.b(i3));
    }

    public final void J2(MarqueeSpacing marqueeSpacing) {
        this.f5049k.setValue(marqueeSpacing);
    }

    public final void K2(int i3, int i4, int i5, int i6, MarqueeSpacing marqueeSpacing, float f3) {
        J2(marqueeSpacing);
        F2(i4);
        if (this.f5040a == i3 && this.f5041b == i5 && this.f5042c == i6 && Dp.i(this.f5043d, f3)) {
            return;
        }
        this.f5040a = i3;
        this.f5041b = i5;
        this.f5042c = i6;
        this.f5043d = f3;
        D2();
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public void O(FocusState focusState) {
        I2(focusState.b());
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(final ContentDrawScope contentDrawScope) {
        float fFloatValue = ((Number) this.f5051m.n()).floatValue() * A2();
        boolean z2 = A2() != 1.0f ? ((Number) this.f5051m.n()).floatValue() < ((float) y2()) : ((Number) this.f5051m.n()).floatValue() < ((float) z2());
        boolean z3 = A2() != 1.0f ? ((Number) this.f5051m.n()).floatValue() > ((float) C2()) : ((Number) this.f5051m.n()).floatValue() > ((float) ((z2() + C2()) - y2()));
        float fZ2 = A2() == 1.0f ? z2() + C2() : (-z2()) - C2();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (contentDrawScope.b() & 4294967295L));
        GraphicsLayer graphicsLayer = this.f5048j;
        if (graphicsLayer != null) {
            contentDrawScope.D1(graphicsLayer, IntSize.c((((long) z2()) << 32) | (((long) MathKt.d(fIntBitsToFloat)) & 4294967295L)), new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.MarqueeModifierNode$draw$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((DrawScope) obj);
                    return Unit.f139807a;
                }

                public final void invoke(DrawScope drawScope) {
                    contentDrawScope.i2();
                }
            });
        }
        float fY2 = fFloatValue + y2();
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (4294967295L & contentDrawScope.b()));
        int iB = ClipOp.f25711b.b();
        DrawContext drawContextQ1 = contentDrawScope.Q1();
        long jB = drawContextQ1.b();
        drawContextQ1.g().t();
        try {
            drawContextQ1.e().c(fFloatValue, 0.0f, fY2, fIntBitsToFloat2, iB);
            GraphicsLayer graphicsLayer2 = this.f5048j;
            if (graphicsLayer2 != null) {
                if (z2) {
                    GraphicsLayerKt.a(contentDrawScope, graphicsLayer2);
                }
                if (z3) {
                    contentDrawScope.Q1().e().e(fZ2, 0.0f);
                    try {
                        GraphicsLayerKt.a(contentDrawScope, graphicsLayer2);
                        contentDrawScope.Q1().e().e(-fZ2, -0.0f);
                    } finally {
                    }
                }
            } else {
                if (z2) {
                    contentDrawScope.i2();
                }
                if (z3) {
                    contentDrawScope.Q1().e().e(fZ2, 0.0f);
                    try {
                        contentDrawScope.i2();
                        contentDrawScope.Q1().e().e(-fZ2, -0.0f);
                    } finally {
                    }
                }
            }
            drawContextQ1.g().k();
            drawContextQ1.h(jB);
        } catch (Throwable th) {
            drawContextQ1.g().k();
            drawContextQ1.h(jB);
            throw th;
        }
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return intrinsicMeasurable.I(Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return intrinsicMeasurable.l0(i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        final Placeable placeableN0 = measurable.n0(Constraints.d(j3, 0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, 0, 13, null));
        G2(ConstraintsKt.g(j3, placeableN0.X0()));
        H2(placeableN0.X0());
        return MeasureScope.B0(measureScope, y2(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.MarqueeModifierNode$measure$1
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
                Placeable.PlacementScope.w(placementScope, placeableN0, MathKt.d((-((Number) this.f5051m.n()).floatValue()) * this.A2()), 0, 0.0f, null, 12, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return intrinsicMeasurable.d0(Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return 0;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        GraphicsLayer graphicsLayer = this.f5048j;
        GraphicsContext graphicsContextL = DelegatableNodeKt.l(this);
        if (graphicsLayer != null) {
            graphicsContextL.b(graphicsLayer);
        }
        this.f5048j = graphicsContextL.a();
        D2();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        Job job = this.f5047i;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f5047i = null;
        GraphicsLayer graphicsLayer = this.f5048j;
        if (graphicsLayer != null) {
            DelegatableNodeKt.l(this).b(graphicsLayer);
            this.f5048j = null;
        }
    }

    public final int x2() {
        return ((MarqueeAnimationMode) this.f5050l.getValue()).h();
    }

    private MarqueeModifierNode(int i3, int i4, int i5, int i6, final MarqueeSpacing marqueeSpacing, float f3) {
        this.f5040a = i3;
        this.f5041b = i5;
        this.f5042c = i6;
        this.f5043d = f3;
        this.f5044f = SnapshotIntStateKt.a(0);
        this.f5045g = SnapshotIntStateKt.a(0);
        this.f5046h = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
        this.f5049k = SnapshotStateKt__SnapshotStateKt.e(marqueeSpacing, null, 2, null);
        this.f5050l = SnapshotStateKt__SnapshotStateKt.e(MarqueeAnimationMode.b(i4), null, 2, null);
        this.f5051m = AnimatableKt.b(0.0f, 0.0f, 2, null);
        this.f5052n = SnapshotStateKt.e(new Function0<Integer>() { // from class: androidx.compose.foundation.MarqueeModifierNode$spacingPx$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                MarqueeSpacing marqueeSpacing2 = marqueeSpacing;
                MarqueeModifierNode marqueeModifierNode = this;
                return Integer.valueOf(marqueeSpacing2.a(DelegatableNodeKt.k(marqueeModifierNode), marqueeModifierNode.z2(), marqueeModifierNode.y2()));
            }
        });
    }
}
