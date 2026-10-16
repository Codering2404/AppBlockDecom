package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.ConstraintSetForInlineDsl;
import androidx.constraintlayout.compose.Measurer;
import androidx.constraintlayout.compose.ToolingUtilsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.valentinilk.shimmer.Shimmer;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemEvent;
import cz.mobilesoft.coreblock.view.compose.skeleton.SkeletonPresets;
import cz.mobilesoft.coreblock.view.compose.skeleton.StructuredSkeletonKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SchedulesSectionKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        z(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void B(Modifier modifier, final Function1 onEvent, Composer composer, final int i3, final int i4) {
        final Modifier modifier2;
        int i5;
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(1112758332);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = i3 | (composerK.Z(modifier2) ? 4 : 2);
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(onEvent) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            Modifier modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(1112758332, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesHeader (SchedulesSection.kt:105)");
            }
            Modifier modifierM = PaddingKt.m(BackgroundKt.d(SizeKt.h(modifier3, 0.0f, 1, null), Color.f25715b.j(), null, 2, null), 0.0f, Dp.g(8), 0.0f, Dp.g(12), 5, null);
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier.Companion companion3 = Modifier.b8;
            Modifier modifier4 = modifier3;
            TextKt.c(StringResources_androidKt.b(R.string.j4, composerK, 0), boxScopeInstance.f(companion3, companion.h()), ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).g(), composerK, 0, 0, 65528);
            composerK = composerK;
            n(boxScopeInstance.f(companion3, companion.f()), onEvent, composerK, i5 & 112);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier4;
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.r1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulesSectionKt.C(modifier2, onEvent, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Modifier modifier, Function1 function1, int i3, int i4, Composer composer, int i5) {
        B(modifier, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void D(final float f3, final int i3, Composer composer, final int i4, final int i5) {
        int i6;
        Composer composerK = composer.k(-1003027927);
        int i7 = i5 & 1;
        if (i7 != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i6 = (composerK.c(f3) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i8 = i5 & 2;
        if (i8 != 0) {
            i6 |= 48;
        } else if ((i4 & 48) == 0) {
            i6 |= composerK.e(i3) ? 32 : 16;
        }
        if (composerK.r((i6 & 19) != 18, i6 & 1)) {
            if (i7 != 0) {
                f3 = Dp.g(24);
            }
            if (i8 != 0) {
                i3 = 4;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1003027927, i6, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesShimmer (SchedulesSection.kt:153)");
            }
            Modifier.Companion companion = Modifier.b8;
            int i9 = R.dimen.f95467a;
            Modifier modifierL = PaddingKt.l(companion, PrimitiveResources_androidKt.a(i9, composerK, 0), f3, PrimitiveResources_androidKt.a(i9, composerK, 0), Dp.g(8));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierL);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            StructuredSkeletonKt.E(true, SkeletonPresets.f131964a.c(i3), null, false, null, ComposableSingletons$SchedulesSectionKt.f99940a.h(), composerK, 196614, 28);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.q1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulesSectionKt.E(f3, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(float f3, int i3, int i4, int i5, Composer composer, int i6) {
        D(f3, i3, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    private static final void n(final Modifier modifier, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-106906039);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-106906039, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.AddProfileButton (SchedulesSection.kt:283)");
            }
            boolean z2 = (i4 & 112) == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.v1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SchedulesSectionKt.o(function1);
                    }
                };
                composerK.w(objG);
            }
            m(modifier, (Function0) objG, composerK, i4 & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.w1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulesSectionKt.p(modifier, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Function1 function1) {
        function1.invoke(ProfileItemEvent.OnCreateProfile.f131660a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Modifier modifier, Function1 function1, int i3, Composer composer, int i4) {
        n(modifier, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Modifier modifier, Function0 function0, int i3, Composer composer, int i4) {
        m(modifier, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0222  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void r(com.valentinilk.shimmer.Shimmer r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 569
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesSectionKt.r(com.valentinilk.shimmer.Shimmer, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Shimmer shimmer, int i3, int i4, Composer composer, int i5) {
        r(shimmer, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void t(Modifier modifier, final List profileTypes, final Function1 onEvent, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(profileTypes, "profileTypes");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(435630683);
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
            i5 |= composerK.I(profileTypes) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(onEvent) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(435630683, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesEmptyContent (SchedulesSection.kt:207)");
            }
            LazyListState lazyListStateB = LazyListStateKt.b(0, 0, composerK, 0, 3);
            Modifier modifierD = BackgroundKt.d(SizeKt.h(modifier3, 0.0f, 1, null), Color.f25715b.j(), null, 2, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(8));
            PaddingValues paddingValuesC = PaddingKt.c(PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null);
            boolean zI = composerK.I(profileTypes) | ((i5 & 896) == 256);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.s1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SchedulesSectionKt.u(profileTypes, onEvent, (LazyListScope) obj);
                    }
                };
                composerK.w(objG);
            }
            LazyDslKt.e(modifierD, lazyListStateB, paddingValuesC, false, horizontalOrVerticalO, null, null, false, null, (Function1) objG, composerK, 24576, 488);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.t1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulesSectionKt.y(modifier3, profileTypes, onEvent, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(List list, final Function1 function1, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final ProfileType profileType = (ProfileType) it.next();
            LazyListScope.c(LazyRow, null, null, ComposableLambdaKt.c(1218498666, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.u1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SchedulesSectionKt.v(function1, profileType, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(final Function1 function1, final ProfileType profileType, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1218498666, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesEmptyContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SchedulesSection.kt:220)");
            }
            CardType.Surface surface = new CardType.Surface(null, null, null, 7, null);
            Modifier modifierB = SizeKt.b(SizeKt.A(Modifier.b8, Dp.g(110)), 0.0f, Dp.g(80), 1, null);
            boolean Z = composer.Z(function1) | composer.e(profileType.ordinal());
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.o1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SchedulesSectionKt.w(function1, profileType);
                    }
                };
                composer.w(objG);
            }
            ComposeCardsKt.m(modifierB, surface, (Function0) objG, ComposableLambdaKt.e(434392165, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.p1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulesSectionKt.x(profileType, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 3078, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function1 function1, ProfileType profileType) {
        function1.invoke(new ProfileItemEvent.OnCreateProfileWithCondition(profileType));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(final ProfileType profileType, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(434392165, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesEmptyContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SchedulesSection.kt:229)");
            }
            Modifier modifierI = PaddingKt.i(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(8));
            composer.a0(-1003410150);
            composer.a0(212064437);
            composer.U();
            Density density = (Density) composer.q(CompositionLocalsKt.f());
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Measurer(density);
                composer.w(objG);
            }
            final Measurer measurer = (Measurer) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new ConstraintLayoutScope();
                composer.w(objG2);
            }
            final ConstraintLayoutScope constraintLayoutScope = (ConstraintLayoutScope) objG2;
            Object objG3 = composer.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composer.w(objG3);
            }
            final MutableState mutableState = (MutableState) objG3;
            Object objG4 = composer.G();
            if (objG4 == companion.a()) {
                objG4 = new ConstraintSetForInlineDsl(constraintLayoutScope);
                composer.w(objG4);
            }
            final ConstraintSetForInlineDsl constraintSetForInlineDsl = (ConstraintSetForInlineDsl) objG4;
            Object objG5 = composer.G();
            if (objG5 == companion.a()) {
                objG5 = SnapshotStateKt.i(Unit.f139807a, SnapshotStateKt.k());
                composer.w(objG5);
            }
            final MutableState mutableState2 = (MutableState) objG5;
            final int i4 = 257;
            boolean zI = composer.I(measurer) | composer.e(257);
            Object objG6 = composer.G();
            if (zI || objG6 == companion.a()) {
                Object obj = new MeasurePolicy() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesSectionKt$SchedulesEmptyContent$lambda$0$0$0$0$1$$inlined$ConstraintLayout$2
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo10measure3p2s80s(MeasureScope measureScope, final List list, long j3) {
                        mutableState2.getValue();
                        long jX = measurer.x(j3, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i4);
                        mutableState.getValue();
                        int iG = IntSize.g(jX);
                        int iF = IntSize.f(jX);
                        final Measurer measurer2 = measurer;
                        return MeasureScope.B0(measureScope, iG, iF, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesSectionKt$SchedulesEmptyContent$lambda$0$0$0$0$1$$inlined$ConstraintLayout$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((Placeable.PlacementScope) obj2);
                                return Unit.f139807a;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                measurer2.w(placementScope, list);
                            }
                        }, 4, null);
                    }
                };
                composer.w(obj);
                objG6 = obj;
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objG6;
            Object objG7 = composer.G();
            if (objG7 == companion.a()) {
                objG7 = new Function0<Unit>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesSectionKt$SchedulesEmptyContent$lambda$0$0$0$0$1$$inlined$ConstraintLayout$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1360invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m1360invoke() {
                        mutableState.setValue(Boolean.valueOf(!((Boolean) r0.getValue()).booleanValue()));
                        constraintSetForInlineDsl.m(true);
                    }
                };
                composer.w(objG7);
            }
            final Function0 function0 = (Function0) objG7;
            boolean zI2 = composer.I(measurer);
            Object objG8 = composer.G();
            if (zI2 || objG8 == companion.a()) {
                objG8 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesSectionKt$SchedulesEmptyContent$lambda$0$0$0$0$1$$inlined$ConstraintLayout$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((SemanticsPropertyReceiver) obj2);
                        return Unit.f139807a;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        ToolingUtilsKt.a(semanticsPropertyReceiver, measurer);
                    }
                };
                composer.w(objG8);
            }
            LayoutKt.a(SemanticsModifierKt.f(modifierI, false, (Function1) objG8, 1, null), ComposableLambdaKt.e(1200550679, true, new Function2<Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesSectionKt$SchedulesEmptyContent$lambda$0$0$0$0$1$$inlined$ConstraintLayout$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    String strB;
                    if ((i5 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1200550679, i5, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:454)");
                    }
                    mutableState2.setValue(Unit.f139807a);
                    int i6 = constraintLayoutScope.i();
                    constraintLayoutScope.j();
                    ConstraintLayoutScope constraintLayoutScope2 = constraintLayoutScope;
                    composer2.a0(-1939907227);
                    ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesN = constraintLayoutScope2.n();
                    ConstrainedLayoutReference constrainedLayoutReferenceA = constrainedLayoutReferencesN.a();
                    ConstrainedLayoutReference constrainedLayoutReferenceB = constrainedLayoutReferencesN.b();
                    ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchorF = constraintLayoutScope2.f(Dp.g(32));
                    Modifier.Companion companion2 = Modifier.b8;
                    Modifier modifierV = SizeKt.v(companion2, Dp.g(24));
                    boolean Z = composer2.Z(horizontalAnchorF);
                    Object objG9 = composer2.G();
                    if (Z || objG9 == Composer.f23746a.a()) {
                        objG9 = new SchedulesSectionKt$SchedulesEmptyContent$1$1$1$1$2$1$1$1(horizontalAnchorF);
                        composer2.w(objG9);
                    }
                    IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, profileType.getAlternativeScheduleIconResId(), composer2, 6), null, constraintLayoutScope2.l(modifierV, constrainedLayoutReferenceA, (Function1) objG9), ComposeColorsKt.j(composer2, 0).p(), composer2, 48, 0);
                    boolean Z2 = composer2.Z(horizontalAnchorF);
                    Object objG10 = composer2.G();
                    if (Z2 || objG10 == Composer.f23746a.a()) {
                        objG10 = new SchedulesSectionKt$SchedulesEmptyContent$1$1$1$1$2$1$2$1(horizontalAnchorF);
                        composer2.w(objG10);
                    }
                    Modifier modifierL = constraintLayoutScope2.l(companion2, constrainedLayoutReferenceB, (Function1) objG10);
                    Integer titleResId = profileType.getTitleResId();
                    if (titleResId == null) {
                        composer2.a0(-1938600858);
                        composer2.U();
                        strB = null;
                    } else {
                        composer2.a0(-1938600857);
                        strB = StringResources_androidKt.b(titleResId.intValue(), composer2, 0);
                        composer2.U();
                    }
                    if (strB == null) {
                        strB = "";
                    }
                    TextKt.c(strB, modifierL, ComposeColorsKt.j(composer2, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer2, 0).j(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(16), null, null, null, 0, 0, null, 16646143, null), composer2, 0, 0, 65016);
                    composer2.U();
                    if (constraintLayoutScope.i() != i6) {
                        EffectsKt.j(function0, composer2, 6);
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composer, 54), measurePolicy, composer, 48, 0);
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Modifier modifier, List list, Function1 function1, int i3, int i4, Composer composer, int i5) {
        t(modifier, list, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void z(Modifier modifier, Composer composer, final int i3, final int i4) {
        final Modifier modifier2;
        int i5;
        Composer composer2;
        Composer composerK = composer.k(-589107462);
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
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            Modifier modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-589107462, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesEmptyHeader (SchedulesSection.kt:128)");
            }
            Modifier modifierM = PaddingKt.m(BackgroundKt.d(SizeKt.h(modifier3, 0.0f, 1, null), Color.f25715b.j(), null, 2, null), 0.0f, Dp.g(8), 0.0f, Dp.g(12), 5, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.o(Dp.g(4)), Alignment.f25072a.k(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            Modifier modifier4 = modifier3;
            composer2 = composerK;
            TextKt.c(StringResources_androidKt.b(R.string.g4, composerK, 0), null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).g(), composer2, 0, 0, 65530);
            TextKt.c(StringResources_androidKt.b(R.string.Fk, composer2, 0), null, ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer2, 0, 0, 65530);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier4;
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.n1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulesSectionKt.A(modifier2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void m(final Modifier modifier, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(function0, MrGIhy.ZimwFQ);
        Composer composerK = composer.k(-1314824214);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(modifier) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1314824214, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.AddProfileButton (SchedulesSection.kt:288)");
            }
            float f3 = 12;
            composer2 = composerK;
            FlatButtonsKt.u(SizeKt.I(modifier, null, false, 3, null), Dp.g(32), Dp.g(f3), PaddingKt.c(Dp.g(f3), 0.0f, 2, null), FlatButtonColors.b(FlatButtonColors.Secondary.f131167a, Color.n(ComposeColorsKt.j(composerK, 0).b()), null, 2, null), null, StringResources_androidKt.b(R.string.M, composerK, 0), null, 0L, Integer.valueOf(R.drawable.f95554q0), null, false, false, function0, composer2, 3504, ((i4 << 6) & 7168) | 384, 3488);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.y1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulesSectionKt.q(modifier, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
