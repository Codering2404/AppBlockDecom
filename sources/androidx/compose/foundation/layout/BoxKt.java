package androidx.compose.foundation.layout;

import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class BoxKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final MutableScatterMap f6619a = d(true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final MutableScatterMap f6620b = d(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final MeasurePolicy f6621c = new BoxMeasurePolicy(Alignment.f25072a.o(), false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final MeasurePolicy f6622d = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.BoxKt$EmptyBoxMeasurePolicy$1
        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* JADX INFO: renamed from: measure-3p2s80s */
        public final MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
            return MeasureScope.B0(measureScope, Constraints.n(j3), Constraints.m(j3), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$EmptyBoxMeasurePolicy$1.1
                public final void invoke(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.f139807a;
                }
            }, 4, null);
        }
    };

    public static final void a(final Modifier modifier, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-211209833);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-211209833, i4, -1, "androidx.compose.foundation.layout.Box (Box.kt:232)");
            }
            MeasurePolicy measurePolicy = f6622d;
            int iA = ComposablesKt.a(composerK, 0);
            Modifier modifierF = ComposedModifierKt.f(composerK, modifier);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicy, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Updater.e(composerA, modifierF, companion.f());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$Box$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    BoxKt.a(modifier, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final MutableScatterMap d(boolean z2) {
        MutableScatterMap mutableScatterMap = new MutableScatterMap(9);
        Alignment.Companion companion = Alignment.f25072a;
        mutableScatterMap.x(companion.o(), new BoxMeasurePolicy(companion.o(), z2));
        mutableScatterMap.x(companion.m(), new BoxMeasurePolicy(companion.m(), z2));
        mutableScatterMap.x(companion.n(), new BoxMeasurePolicy(companion.n(), z2));
        mutableScatterMap.x(companion.h(), new BoxMeasurePolicy(companion.h(), z2));
        mutableScatterMap.x(companion.e(), new BoxMeasurePolicy(companion.e(), z2));
        mutableScatterMap.x(companion.f(), new BoxMeasurePolicy(companion.f(), z2));
        mutableScatterMap.x(companion.d(), new BoxMeasurePolicy(companion.d(), z2));
        mutableScatterMap.x(companion.b(), new BoxMeasurePolicy(companion.b(), z2));
        mutableScatterMap.x(companion.c(), new BoxMeasurePolicy(companion.c(), z2));
        return mutableScatterMap;
    }

    private static final BoxChildDataNode e(Measurable measurable) {
        Object objP = measurable.p();
        if (objP instanceof BoxChildDataNode) {
            return (BoxChildDataNode) objP;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(Measurable measurable) {
        BoxChildDataNode boxChildDataNodeE = e(measurable);
        if (boxChildDataNodeE != null) {
            return boxChildDataNodeE.n2();
        }
        return false;
    }

    public static final MeasurePolicy g(Alignment alignment, boolean z2) {
        MeasurePolicy measurePolicy = (MeasurePolicy) (z2 ? f6619a : f6620b).e(alignment);
        return measurePolicy == null ? new BoxMeasurePolicy(alignment, z2) : measurePolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Placeable.PlacementScope placementScope, Placeable placeable, Measurable measurable, LayoutDirection layoutDirection, int i3, int i4, Alignment alignment) {
        Alignment alignmentM2;
        BoxChildDataNode boxChildDataNodeE = e(measurable);
        Placeable.PlacementScope.k(placementScope, placeable, ((boxChildDataNodeE == null || (alignmentM2 = boxChildDataNodeE.m2()) == null) ? alignment : alignmentM2).a(IntSize.c((((long) placeable.X0()) << 32) | (((long) placeable.O0()) & 4294967295L)), IntSize.c((((long) i4) & 4294967295L) | (((long) i3) << 32)), layoutDirection), 0.0f, 2, null);
    }

    public static final MeasurePolicy i(Alignment alignment, boolean z2, Composer composer, int i3) {
        MeasurePolicy measurePolicy;
        if (ComposerKt.M()) {
            ComposerKt.U(56522820, i3, -1, "androidx.compose.foundation.layout.rememberBoxMeasurePolicy (Box.kt:109)");
        }
        if (!Intrinsics.areEqual(alignment, Alignment.f25072a.o()) || z2) {
            composer.a0(-1709737635);
            boolean z3 = ((((i3 & 14) ^ 6) > 4 && composer.Z(alignment)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.b(z2)) || (i3 & 48) == 32);
            Object objG = composer.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new BoxMeasurePolicy(alignment, z2);
                composer.w(objG);
            }
            measurePolicy = (BoxMeasurePolicy) objG;
            composer.U();
        } else {
            composer.a0(-1709785313);
            composer.U();
            measurePolicy = f6621c;
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return measurePolicy;
    }
}
