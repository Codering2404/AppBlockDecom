package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.ConstraintsKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class InsetsPaddingModifier implements LayoutModifier, ModifierLocalConsumer, ModifierLocalProvider<WindowInsets> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WindowInsets f6964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f6965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f6966c;

    public InsetsPaddingModifier(WindowInsets windowInsets) {
        this.f6964a = windowInsets;
        this.f6965b = SnapshotStateKt__SnapshotStateKt.e(windowInsets, null, 2, null);
        this.f6966c = SnapshotStateKt__SnapshotStateKt.e(windowInsets, null, 2, null);
    }

    private final WindowInsets a() {
        return (WindowInsets) this.f6966c.getValue();
    }

    private final WindowInsets b() {
        return (WindowInsets) this.f6965b.getValue();
    }

    private final void d(WindowInsets windowInsets) {
        this.f6966c.setValue(windowInsets);
    }

    private final void e(WindowInsets windowInsets) {
        this.f6965b.setValue(windowInsets);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public WindowInsets getValue() {
        return a();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InsetsPaddingModifier) {
            return Intrinsics.areEqual(((InsetsPaddingModifier) obj).f6964a, this.f6964a);
        }
        return false;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal getKey() {
        return WindowInsetsPaddingKt.b();
    }

    public int hashCode() {
        return this.f6964a.hashCode();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void l1(ModifierLocalReadScope modifierLocalReadScope) {
        WindowInsets windowInsets = (WindowInsets) modifierLocalReadScope.u(WindowInsetsPaddingKt.b());
        e(WindowInsetsKt.h(this.f6964a, windowInsets));
        d(WindowInsetsKt.j(windowInsets, this.f6964a));
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo45measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        final int iD = b().d(measureScope, measureScope.getLayoutDirection());
        final int iA = b().a(measureScope);
        int iB = b().b(measureScope, measureScope.getLayoutDirection()) + iD;
        int iC = b().c(measureScope) + iA;
        final Placeable placeableN0 = measurable.n0(ConstraintsKt.i(j3, -iB, -iC));
        return MeasureScope.B0(measureScope, ConstraintsKt.g(j3, placeableN0.X0() + iB), ConstraintsKt.f(j3, placeableN0.O0() + iC), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.InsetsPaddingModifier$measure$1
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
                Placeable.PlacementScope.i(placementScope, placeableN0, iD, iA, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
