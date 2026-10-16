package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.AndroidMenu_androidKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.Shapes;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.util.compose.ComposeThemesKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposeDropdownKt {
    public static final void j(final MutableState dropdownShown, final ScaffoldState scaffoldState, final List items, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(dropdownShown, "dropdownShown");
        Intrinsics.checkNotNullParameter(items, "items");
        Composer composerK = composer.k(974155050);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(dropdownShown) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(items) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(974155050, i4, -1, "cz.mobilesoft.coreblock.view.compose.ComposeDropdown (ComposeDropdown.kt:48)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG;
            k(dropdownShown, ComposableLambdaKt.e(-703869535, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.l7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeDropdownKt.l(items, coroutineScope, scaffoldState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, (i4 & 14) | 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.m7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeDropdownKt.o(dropdownShown, scaffoldState, items, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void k(final MutableState dropdownShown, final Function2 content, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(dropdownShown, "dropdownShown");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerK = composer.k(-1097002678);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(dropdownShown) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(content) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1097002678, i4, -1, "cz.mobilesoft.coreblock.view.compose.ComposeDropdown (ComposeDropdown.kt:81)");
            }
            ComposeThemesKt.b(Shapes.b(MaterialTheme.f13091a.b(composerK, MaterialTheme.f13092b), null, RoundedCornerShapeKt.d(Dp.g(8)), null, 5, null), ComposableLambdaKt.e(-2041400263, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.p7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeDropdownKt.p(dropdownShown, content, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 48, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.q7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeDropdownKt.s(dropdownShown, content, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(List list, final CoroutineScope coroutineScope, final ScaffoldState scaffoldState, Composer composer, int i3) {
        final String strB;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-703869535, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposeDropdown.<anonymous> (ComposeDropdown.kt:52)");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final ComposeDropdownItem composeDropdownItem = (ComposeDropdownItem) it.next();
                if (composeDropdownItem.d() != null) {
                    composer.a0(-1989365413);
                    strB = StringResources_androidKt.b(composeDropdownItem.d().booleanValue() ? StrictModeTitleAlternatives.Companion.a() : R.string.iu, composer, 0);
                    composer.U();
                } else {
                    composer.a0(-1540644453);
                    composer.U();
                    strB = null;
                }
                Modifier modifierH = SizeKt.h(composeDropdownItem.e(), 0.0f, 1, null);
                boolean Z = composer.Z(composeDropdownItem) | composer.Z(strB) | composer.I(coroutineScope) | composer.Z(scaffoldState);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.n7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ComposeDropdownKt.m(composeDropdownItem, strB, coroutineScope, scaffoldState);
                        }
                    };
                    composer.w(objG);
                }
                AndroidMenu_androidKt.c((Function0) objG, modifierH, false, null, null, ComposableLambdaKt.e(-1686306235, true, new Function3() { // from class: cz.mobilesoft.coreblock.view.compose.o7
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ComposeDropdownKt.n(composeDropdownItem, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 196608, 28);
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(ComposeDropdownItem composeDropdownItem, String str, CoroutineScope coroutineScope, ScaffoldState scaffoldState) {
        if (composeDropdownItem.a()) {
            composeDropdownItem.f().invoke();
        } else if (str != null) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new ComposeDropdownKt$ComposeDropdown$1$1$1$1$1$1(scaffoldState, str, null), 3, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(ComposeDropdownItem composeDropdownItem, RowScope DropdownMenuItem, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(DropdownMenuItem, "$this$DropdownMenuItem");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1686306235, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposeDropdown.<anonymous>.<anonymous>.<anonymous> (ComposeDropdown.kt:73)");
            }
            t(composeDropdownItem, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(MutableState mutableState, ScaffoldState scaffoldState, List list, int i3, Composer composer, int i4) {
        j(mutableState, scaffoldState, list, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(final MutableState mutableState, final Function2 function2, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2041400263, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposeDropdown.<anonymous> (ComposeDropdown.kt:85)");
            }
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            boolean Z = composer.Z(mutableState);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.r7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeDropdownKt.q(mutableState);
                    }
                };
                composer.w(objG);
            }
            AndroidMenu_androidKt.a(zBooleanValue, (Function0) objG, BackgroundKt.d(Modifier.b8, ComposeColorsKt.j(composer, 0).X(), null, 2, null), 0L, null, null, ComposableLambdaKt.e(-1912601300, true, new Function3() { // from class: cz.mobilesoft.coreblock.view.compose.s7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ComposeDropdownKt.r(function2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572864, 56);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Function2 function2, ColumnScope DropdownMenu, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1912601300, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposeDropdown.<anonymous>.<anonymous> (ComposeDropdown.kt:92)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(MutableState mutableState, Function2 function2, int i3, Composer composer, int i4) {
        k(mutableState, function2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(final ComposeDropdownItem composeDropdownItem, Composer composer, final int i3) {
        int i4;
        long jS;
        long jS2;
        Modifier.Companion companion;
        Composer composerK = composer.k(1855077603);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(composeDropdownItem) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1855077603, i4, -1, "cz.mobilesoft.coreblock.view.compose.DropdownMenuItemContent (ComposeDropdown.kt:98)");
            }
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            Modifier.Companion companion2 = Modifier.b8;
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), verticalI, composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion2);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            if (composeDropdownItem.a()) {
                composerK.a0(370821238);
                Color colorH = composeDropdownItem.h();
                if (colorH == null) {
                    composerK.a0(704699411);
                    jS = ComposeColorsKt.j(composerK, 0).p();
                    composerK.U();
                } else {
                    composerK.a0(704698636);
                    composerK.U();
                    jS = colorH.B();
                }
                composerK.U();
            } else {
                composerK.a0(370874031);
                jS = ComposeColorsKt.j(composerK, 0).s();
                composerK.U();
            }
            long j3 = jS;
            if (composeDropdownItem.a()) {
                composerK.a0(370975556);
                Color colorC = composeDropdownItem.c();
                if (colorC == null) {
                    colorC = composeDropdownItem.h();
                }
                if (colorC == null) {
                    composerK.a0(704704947);
                    jS2 = ComposeColorsKt.j(composerK, 0).p();
                    composerK.U();
                } else {
                    composerK.a0(704703614);
                    composerK.U();
                    jS2 = colorC.B();
                }
                composerK.U();
            } else {
                composerK.a0(371045647);
                jS2 = ComposeColorsKt.j(composerK, 0).s();
                composerK.U();
            }
            long j4 = jS2;
            ImageVector imageVectorB = composeDropdownItem.b();
            if (imageVectorB == null) {
                composerK.a0(371115427);
                composerK.U();
                companion = companion2;
            } else {
                composerK.a0(371115428);
                companion = companion2;
                IconKt.b(imageVectorB, null, PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(16), 0.0f, 11, null), j4, composerK, 432, 0);
                composerK.U();
            }
            androidx.compose.material.TextKt.c(composeDropdownItem.g(), RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), j3, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 0, 0, 65528);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.k7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeDropdownKt.u(composeDropdownItem, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(ComposeDropdownItem composeDropdownItem, int i3, Composer composer, int i4) {
        t(composeDropdownItem, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
