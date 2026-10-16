package cz.mobilesoft.coreblock.scene.strictmode;

import android.content.Context;
import android.content.Intent;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.strictmode.StrictModeInfoActivity;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StrictModeInfoActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f121042h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f121043i = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f121044f = LazyKt.b(new Function0() { // from class: x1.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return StrictModeInfoActivity.H0(this.f147557a);
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f121045g = LazyKt.b(new Function0() { // from class: x1.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return StrictModeInfoActivity.E0(this.f147558a);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, List infoList, List advancedInfoList) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(infoList, "infoList");
            Intrinsics.checkNotNullParameter(advancedInfoList, "advancedInfoList");
            Intent intent = new Intent(context, (Class<?>) StrictModeInfoActivity.class);
            intent.putExtra("SHOW_STRICT_MODE_INFO_LIST", CollectionsKt.toIntArray(infoList));
            intent.putExtra("SHOW_STRICT_MODE_ADVANCED_INFO_LIST", CollectionsKt.toIntArray(advancedInfoList));
            return intent;
        }

        private Companion() {
        }
    }

    private final void A0(final String str, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-1268772717);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(str) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1268772717, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode.StrictModeInfoActivity.SMInfoItem (StrictModeInfoActivity.kt:155)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(f3)), Alignment.f25072a.i(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.a6, composerK, 6), null, SizeKt.v(companion, Dp.g(24)), ComposeColorsKt.j(composerK, 0).a0(), composerK, 432, 0);
            composer2 = composerK;
            TextKt.c(str, null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composer2, i4 & 14, 0, 65530);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: x1.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeInfoActivity.B0(this.f147575a, str, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(StrictModeInfoActivity strictModeInfoActivity, String str, int i3, Composer composer, int i4) {
        strictModeInfoActivity.A0(str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void C0(final List list, Composer composer, final int i3) {
        Object obj;
        float f3;
        Composer composerK = composer.k(-75746635);
        int i4 = 2;
        int i5 = (i3 & 6) == 0 ? (composerK.I(list) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(this) ? 32 : 16;
        }
        int i6 = i5;
        if (composerK.r((i6 & 19) != 18, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-75746635, i6, -1, "cz.mobilesoft.coreblock.scene.strictmode.StrictModeInfoActivity.SMInfoList (StrictModeInfoActivity.kt:130)");
            }
            Object obj2 = null;
            float f4 = 16;
            Modifier modifierC = BackgroundKt.c(SizeKt.h(Modifier.b8, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).l0(), RoundedCornerShapeKt.d(Dp.g(f4)));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierC);
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            composerK.a0(206943214);
            int i7 = 0;
            for (Object obj3 : list) {
                int i8 = i7 + 1;
                if (i7 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str = (String) obj3;
                if (i7 != 0) {
                    composerK.a0(280167736);
                    f3 = f4;
                    obj = null;
                    DividerKt.b(PaddingKt.k(Modifier.b8, Dp.g(f4), 0.0f, i4, obj2), Dp.g(1), ComposeColorsKt.j(composerK, 0).N(), composerK, 54, 0);
                } else {
                    obj = obj2;
                    f3 = f4;
                    composerK.a0(274995665);
                }
                composerK.U();
                A0(str, composerK, i6 & 112);
                i7 = i8;
                obj2 = obj;
                f4 = f3;
                i4 = 2;
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: x1.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    return StrictModeInfoActivity.D0(this.f147572a, list, i3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(StrictModeInfoActivity strictModeInfoActivity, List list, int i3, Composer composer, int i4) {
        strictModeInfoActivity.C0(list, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List E0(StrictModeInfoActivity strictModeInfoActivity) {
        List<Integer> list;
        int[] intArrayExtra = strictModeInfoActivity.getIntent().getIntArrayExtra("SHOW_STRICT_MODE_ADVANCED_INFO_LIST");
        return (intArrayExtra == null || (list = ArraysKt.toList(intArrayExtra)) == null) ? CollectionsKt.emptyList() : list;
    }

    private final List F0() {
        return (List) this.f121045g.getValue();
    }

    private final List G0() {
        return (List) this.f121044f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List H0(StrictModeInfoActivity strictModeInfoActivity) {
        List<Integer> list;
        int[] intArrayExtra = strictModeInfoActivity.getIntent().getIntArrayExtra("SHOW_STRICT_MODE_INFO_LIST");
        return (intArrayExtra == null || (list = ArraysKt.toList(intArrayExtra)) == null) ? CollectionsKt.emptyList() : list;
    }

    private final void u0(Modifier modifier, final List list, final List list2, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        Composer composer2;
        final Modifier modifier3;
        Composer composerK = composer.k(1743802627);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(list) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(list2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(this) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(1743802627, i5, -1, "cz.mobilesoft.coreblock.scene.strictmode.StrictModeInfoActivity.InfoListContent (StrictModeInfoActivity.kt:85)");
            }
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(ScrollKt.g(SizeKt.h(modifier4, 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), Dp.g(f3));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifier5 = modifier4;
            int i7 = i5;
            TextKt.c(StringResources_androidKt.b(R.string.Pz, composerK, 0), SizeKt.h(companion2, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).f(), composerK, 48, 0, 65528);
            composer2 = composerK;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer2, 6);
            int i8 = i7 >> 6;
            C0(list, composer2, ((i7 >> 3) & 14) | (i8 & 112));
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer2, 6);
            if (list2.isEmpty()) {
                composer2.a0(-1094437451);
            } else {
                composer2.a0(-1090124824);
                TextKt.c(StringResources_androidKt.b(R.string.Hx, composer2, 0), SizeKt.h(companion2, 0.0f, 1, null), ComposeColorsKt.j(composer2, 0).P(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).a(), composer2, 48, 0, 65528);
                composer2 = composer2;
                SpacerKt.a(SizeKt.i(companion2, Dp.g(8)), composer2, 6);
                C0(list2, composer2, i8 & 126);
            }
            composer2.U();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier5;
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: x1.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeInfoActivity.v0(this.f147565a, modifier3, list, list2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(StrictModeInfoActivity strictModeInfoActivity, Modifier modifier, List list, List list2, int i3, int i4, Composer composer, int i5) {
        strictModeInfoActivity.u0(modifier, list, list2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(final StrictModeInfoActivity strictModeInfoActivity, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-90600651, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode.StrictModeInfoActivity.RootCompose.<anonymous> (StrictModeInfoActivity.kt:61)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            Modifier modifierF2 = BoxScopeInstance.f6642a.f(companion, companion2.o());
            boolean zI = composer.I(strictModeInfoActivity);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: x1.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeInfoActivity.x0(this.f147571a);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.o0(modifierF2, null, 0, (Function0) objG, composer, 0, 6);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(StrictModeInfoActivity strictModeInfoActivity) {
        strictModeInfoActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(StrictModeInfoActivity strictModeInfoActivity, PaddingValues paddingValues, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-24208914, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode.StrictModeInfoActivity.RootCompose.<anonymous> (StrictModeInfoActivity.kt:71)");
            }
            Modifier modifierH = PaddingKt.h(Modifier.b8, paddingValues);
            composer.a0(-1789924760);
            List listG0 = strictModeInfoActivity.G0();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listG0, 10));
            Iterator it2 = listG0.iterator();
            while (it2.hasNext()) {
                arrayList.add(StringResources_androidKt.b(((Number) it2.next()).intValue(), composer, 0));
            }
            composer.U();
            composer.a0(-1789921848);
            List listF0 = strictModeInfoActivity.F0();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listF0, 10));
            Iterator it3 = listF0.iterator();
            while (it3.hasNext()) {
                arrayList2.add(StringResources_androidKt.b(((Number) it3.next()).intValue(), composer, 0));
            }
            composer.U();
            strictModeInfoActivity.u0(modifierH, arrayList, arrayList2, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(StrictModeInfoActivity strictModeInfoActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        strictModeInfoActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-1830069584);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(this) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1830069584, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode.StrictModeInfoActivity.RootCompose (StrictModeInfoActivity.kt:58)");
            }
            composer2 = composerK;
            ScaffoldKt.a(null, null, ComposableLambdaKt.e(-90600651, true, new Function2() { // from class: x1.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeInfoActivity.w0(this.f147559a, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-24208914, true, new Function3() { // from class: x1.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StrictModeInfoActivity.y0(this.f147560a, paddingValues, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 384, 12582912, 131067);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: x1.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeInfoActivity.z0(this.f147562a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
