package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
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
final class DerivedWidthModifier extends InspectorValueInfo implements LayoutModifier, ModifierLocalConsumer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WindowInsets f6751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function3 f6752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f6753d;

    private final WindowInsets c() {
        return (WindowInsets) this.f6753d.getValue();
    }

    private final void d(WindowInsets windowInsets) {
        this.f6753d.setValue(windowInsets);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DerivedWidthModifier)) {
            return false;
        }
        DerivedWidthModifier derivedWidthModifier = (DerivedWidthModifier) obj;
        return Intrinsics.areEqual(this.f6751b, derivedWidthModifier.f6751b) && this.f6752c == derivedWidthModifier.f6752c;
    }

    public int hashCode() {
        return (this.f6751b.hashCode() * 31) + this.f6752c.hashCode();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void l1(ModifierLocalReadScope modifierLocalReadScope) {
        d(WindowInsetsKt.h(this.f6751b, (WindowInsets) modifierLocalReadScope.u(WindowInsetsPaddingKt.b())));
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo45measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        int iIntValue = ((Number) this.f6752c.invoke(c(), measureScope.getLayoutDirection(), measureScope)).intValue();
        if (iIntValue == 0) {
            return MeasureScope.B0(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.DerivedWidthModifier$measure$1
                public final void invoke(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.f139807a;
                }
            }, 4, null);
        }
        final Placeable placeableN0 = measurable.n0(Constraints.d(j3, iIntValue, iIntValue, 0, 0, 12, null));
        return MeasureScope.B0(measureScope, iIntValue, placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.DerivedWidthModifier$measure$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.m(placementScope, placeableN0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
