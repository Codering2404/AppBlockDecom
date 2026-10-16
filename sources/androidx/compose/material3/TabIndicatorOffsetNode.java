package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TabIndicatorOffsetNode extends Modifier.Node implements LayoutModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private State f20476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f20477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f20478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Animatable f20479d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Animatable f20480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Dp f20481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Dp f20482h;

    public TabIndicatorOffsetNode(State state, int i3, boolean z2) {
        this.f20476a = state;
        this.f20477b = i3;
        this.f20478c = z2;
    }

    public final void m2(boolean z2) {
        this.f20478c = z2;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j3) {
        if (((List) this.f20476a.getValue()).isEmpty()) {
            return MeasureScope.B0(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabIndicatorOffsetNode$measure$1
                public final void invoke(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.f139807a;
                }
            }, 4, null);
        }
        float fA = this.f20478c ? ((TabPosition) ((List) this.f20476a.getValue()).get(this.f20477b)).a() : ((TabPosition) ((List) this.f20476a.getValue()).get(this.f20477b)).d();
        if (this.f20482h != null) {
            Animatable animatable = this.f20480f;
            if (animatable == null) {
                Dp dp = this.f20482h;
                Intrinsics.checkNotNull(dp);
                Animatable animatable2 = new Animatable(dp, VectorConvertersKt.e(Dp.f29970b), null, null, 12, null);
                this.f20480f = animatable2;
                animatable = animatable2;
            }
            if (!Dp.i(fA, ((Dp) animatable.l()).l())) {
                BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new TabIndicatorOffsetNode$measure$2(animatable, fA, null), 3, null);
            }
        } else {
            this.f20482h = Dp.d(fA);
        }
        float fB = ((TabPosition) ((List) this.f20476a.getValue()).get(this.f20477b)).b();
        if (this.f20481g != null) {
            Animatable animatable3 = this.f20479d;
            if (animatable3 == null) {
                Dp dp2 = this.f20481g;
                Intrinsics.checkNotNull(dp2);
                Animatable animatable4 = new Animatable(dp2, VectorConvertersKt.e(Dp.f29970b), null, null, 12, null);
                this.f20479d = animatable4;
                animatable3 = animatable4;
            }
            if (!Dp.i(fB, ((Dp) animatable3.l()).l())) {
                BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new TabIndicatorOffsetNode$measure$3(animatable3, fB, null), 3, null);
            }
        } else {
            this.f20481g = Dp.d(fB);
        }
        Animatable animatable5 = this.f20479d;
        if (animatable5 != null) {
            fB = ((Dp) animatable5.n()).l();
        }
        Animatable animatable6 = this.f20480f;
        if (animatable6 != null) {
            fA = ((Dp) animatable6.n()).l();
        }
        final Placeable placeableN0 = measurable.n0(Constraints.d(j3, measureScope.z0(fA), measureScope.z0(fA), 0, 0, 12, null));
        final float f3 = fB;
        return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabIndicatorOffsetNode$measure$4
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
                Placeable.PlacementScope.i(placementScope, placeableN0, measureScope.z0(f3), 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    public final void n2(int i3) {
        this.f20477b = i3;
    }

    public final void o2(State state) {
        this.f20476a = state;
    }
}
