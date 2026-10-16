package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
final class FlowMeasureLazyPolicy implements FlowLineMeasurePolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Arrangement.Horizontal f6906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Arrangement.Vertical f6907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f6908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CrossAxisAlignment f6909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f6910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f6911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f6912h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f6913i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final FlowLayoutOverflowState f6914j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f6915k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Function4 f6916l;

    public /* synthetic */ FlowMeasureLazyPolicy(boolean z2, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f3, CrossAxisAlignment crossAxisAlignment, float f4, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState, List list, Function4 function4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, horizontal, vertical, f3, crossAxisAlignment, f4, i3, i4, i5, flowLayoutOverflowState, list, function4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MeasureResult q(final SubcomposeMeasureScope subcomposeMeasureScope, long j3) {
        if (this.f6911g <= 0 || this.f6912h == 0 || this.f6913i == 0 || (Constraints.k(j3) == 0 && this.f6914j.l() != FlowLayoutOverflow.OverflowType.f6866a)) {
            return MeasureScope.B0(subcomposeMeasureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowMeasureLazyPolicy$measure$1
                public final void invoke(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.f139807a;
                }
            }, 4, null);
        }
        ContextualFlowItemIterator contextualFlowItemIterator = new ContextualFlowItemIterator(this.f6911g, new Function2<Integer, FlowLineInfo, List<? extends Measurable>>() { // from class: androidx.compose.foundation.layout.FlowMeasureLazyPolicy$measure$measurablesIterator$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final List c(final int i3, final FlowLineInfo flowLineInfo) {
                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                Integer numValueOf = Integer.valueOf(i3);
                final FlowMeasureLazyPolicy flowMeasureLazyPolicy = this;
                return subcomposeMeasureScope2.V(numValueOf, ComposableLambdaKt.c(-195060736, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowMeasureLazyPolicy$measure$measurablesIterator$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer, int i4) {
                        if (!composer.r((i4 & 3) != 2, i4 & 1)) {
                            composer.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(-195060736, i4, -1, "androidx.compose.foundation.layout.FlowMeasureLazyPolicy.measure.<anonymous>.<anonymous> (ContextualFlowLayout.kt:496)");
                        }
                        flowMeasureLazyPolicy.f6916l.invoke(Integer.valueOf(i3), flowLineInfo, composer, 0);
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return c(((Number) obj).intValue(), (FlowLineInfo) obj2);
            }
        });
        this.f6914j.m(this.f6911g);
        this.f6914j.q(this, j3, new Function2<Boolean, Integer, Measurable>() { // from class: androidx.compose.foundation.layout.FlowMeasureLazyPolicy$measure$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final Measurable c(boolean z2, int i3) {
                Function2 function2 = (Function2) CollectionsKt.getOrNull(this.f6919a.f6915k, !z2 ? 1 : 0);
                if (function2 == null) {
                    return null;
                }
                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                FlowMeasureLazyPolicy flowMeasureLazyPolicy = this.f6919a;
                StringBuilder sb = new StringBuilder();
                sb.append(z2);
                sb.append(flowMeasureLazyPolicy.f6911g);
                sb.append(i3);
                return (Measurable) CollectionsKt.getOrNull(subcomposeMeasureScope2.V(sb.toString(), function2), 0);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return c(((Boolean) obj).booleanValue(), ((Number) obj2).intValue());
            }
        });
        return FlowLayoutKt.f(subcomposeMeasureScope, this, contextualFlowItemIterator, this.f6908d, this.f6910f, OrientationIndependentConstraints.c(j3, b() ? LayoutOrientation.f6996a : LayoutOrientation.f6997b), this.f6913i, this.f6912h, this.f6914j);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public boolean b() {
        return this.f6905a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowMeasureLazyPolicy)) {
            return false;
        }
        FlowMeasureLazyPolicy flowMeasureLazyPolicy = (FlowMeasureLazyPolicy) obj;
        return this.f6905a == flowMeasureLazyPolicy.f6905a && Intrinsics.areEqual(this.f6906b, flowMeasureLazyPolicy.f6906b) && Intrinsics.areEqual(this.f6907c, flowMeasureLazyPolicy.f6907c) && Dp.i(this.f6908d, flowMeasureLazyPolicy.f6908d) && Intrinsics.areEqual(this.f6909e, flowMeasureLazyPolicy.f6909e) && Dp.i(this.f6910f, flowMeasureLazyPolicy.f6910f) && this.f6911g == flowMeasureLazyPolicy.f6911g && this.f6912h == flowMeasureLazyPolicy.f6912h && this.f6913i == flowMeasureLazyPolicy.f6913i && Intrinsics.areEqual(this.f6914j, flowMeasureLazyPolicy.f6914j) && Intrinsics.areEqual(this.f6915k, flowMeasureLazyPolicy.f6915k) && Intrinsics.areEqual(this.f6916l, flowMeasureLazyPolicy.f6916l);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public CrossAxisAlignment g() {
        return this.f6909e;
    }

    public int hashCode() {
        return (((((((((((((((((((((Boolean.hashCode(this.f6905a) * 31) + this.f6906b.hashCode()) * 31) + this.f6907c.hashCode()) * 31) + Dp.j(this.f6908d)) * 31) + this.f6909e.hashCode()) * 31) + Dp.j(this.f6910f)) * 31) + Integer.hashCode(this.f6911g)) * 31) + Integer.hashCode(this.f6912h)) * 31) + Integer.hashCode(this.f6913i)) * 31) + this.f6914j.hashCode()) * 31) + this.f6915k.hashCode()) * 31) + this.f6916l.hashCode();
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public Arrangement.Horizontal i() {
        return this.f6906b;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public Arrangement.Vertical j() {
        return this.f6907c;
    }

    public final Function2 p() {
        return new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.layout.FlowMeasureLazyPolicy$getMeasurePolicy$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return m46invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).r());
            }

            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
            public final MeasureResult m46invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j3) {
                return this.f6917a.q(subcomposeMeasureScope, j3);
            }
        };
    }

    public String toString() {
        return "FlowMeasureLazyPolicy(isHorizontal=" + this.f6905a + ", horizontalArrangement=" + this.f6906b + ", verticalArrangement=" + this.f6907c + ", mainAxisSpacing=" + ((Object) Dp.k(this.f6908d)) + ", crossAxisAlignment=" + this.f6909e + ", crossAxisArrangementSpacing=" + ((Object) Dp.k(this.f6910f)) + ", itemCount=" + this.f6911g + ", maxLines=" + this.f6912h + ", maxItemsInMainAxis=" + this.f6913i + ", overflow=" + this.f6914j + ", overflowComposables=" + this.f6915k + ", getComposable=" + this.f6916l + ')';
    }

    private FlowMeasureLazyPolicy(boolean z2, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f3, CrossAxisAlignment crossAxisAlignment, float f4, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState, List list, Function4 function4) {
        this.f6905a = z2;
        this.f6906b = horizontal;
        this.f6907c = vertical;
        this.f6908d = f3;
        this.f6909e = crossAxisAlignment;
        this.f6910f = f4;
        this.f6911g = i3;
        this.f6912h = i4;
        this.f6913i = i5;
        this.f6914j = flowLayoutOverflowState;
        this.f6915k = list;
        this.f6916l = function4;
    }
}
