package cz.mobilesoft.coreblock.scene.dev_events;

import android.os.Bundle;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.ChipColors;
import androidx.compose.material.ChipDefaults;
import androidx.compose.material.ChipKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.dev_events.DevEventsViewEvent;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeThemesKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.scope.Scope;

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
public final class DevEventsActivity extends BaseComposeActivity {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(Function1 function1) {
        function1.invoke(new DevEventsViewEvent.OnConfirmRowButtonClicked(false));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(DevEventsViewState devEventsViewState, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final List listC = devEventsViewState.c();
        final DevEventsActivity$Content$lambda$0$0$0$2$0$$inlined$items$default$1 devEventsActivity$Content$lambda$0$0$0$2$0$$inlined$items$default$1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dev_events.DevEventsActivity$Content$lambda$0$0$0$2$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Object obj) {
                return null;
            }
        };
        LazyColumn.h(listC.size(), null, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.dev_events.DevEventsActivity$Content$lambda$0$0$0$2$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i3) {
                return devEventsActivity$Content$lambda$0$0$0$2$0$$inlined$items$default$1.invoke(listC.get(i3));
            }
        }, ComposableLambdaKt.c(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.dev_events.DevEventsActivity$Content$lambda$0$0$0$2$0$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.f139807a;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer, int i4) {
                int i5;
                if ((i4 & 6) == 0) {
                    i5 = i4 | (composer.Z(lazyItemScope) ? 4 : 2);
                } else {
                    i5 = i4;
                }
                if ((i4 & 48) == 0) {
                    i5 |= composer.e(i3) ? 32 : 16;
                }
                if (!composer.r((i5 & 147) != 146, i5 & 1)) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-632812321, i5, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final AnswersHelper.Event event = (AnswersHelper.Event) listC.get(i3);
                composer.a0(1827756532);
                String strB = event.b();
                final Map mapC = event.c();
                Modifier.Companion companion = Modifier.b8;
                MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.l(), composer, 0);
                int iA = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU = composer.u();
                Modifier modifierF = ComposedModifierKt.f(composer, companion);
                ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                Function0 function0A = companion2.a();
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
                Updater.e(composerA, measurePolicyB, companion2.e());
                Updater.e(composerA, compositionLocalMapU, companion2.g());
                Function2 function2B = companion2.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion2.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                float f3 = 4;
                TextKt.c(strB, PaddingKt.k(companion, 0.0f, Dp.g(f3), 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 48, 0, 131068);
                SpacerKt.a(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
                boolean Z = composer.Z(function1) | composer.I(event);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    final Function1 function12 = function1;
                    objG = new Function0<Unit>() { // from class: cz.mobilesoft.coreblock.scene.dev_events.DevEventsActivity$Content$1$1$1$3$1$1$1$1$1
                        public final void c() {
                            function12.invoke(new DevEventsViewEvent.CopyEventToClipboard(event));
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            c();
                            return Unit.f139807a;
                        }
                    };
                    composer.w(objG);
                }
                IconButtonKt.a((Function0) objG, null, false, null, ComposableSingletons$DevEventsActivityKt.f101641a.e(), composer, 24576, 14);
                composer.y();
                if (mapC == null) {
                    composer.a0(1828616625);
                    composer.U();
                } else {
                    composer.a0(1828616626);
                    FlowLayoutKt.d(PaddingKt.m(companion, Dp.g(f3), 0.0f, 0.0f, Dp.g(f3), 6, null), null, null, null, 0, 0, ComposableLambdaKt.e(-1156648602, true, new Function3<FlowRowScope, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.dev_events.DevEventsActivity$Content$1$1$1$3$1$1$2$1
                        public final void c(FlowRowScope FlowRow, Composer composer2, int i6) {
                            Composer composer3 = composer2;
                            Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
                            int i7 = 0;
                            boolean z2 = true;
                            if (!composer3.r((i6 & 17) != 16, i6 & 1)) {
                                composer2.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(-1156648602, i6, -1, "cz.mobilesoft.coreblock.scene.dev_events.DevEventsActivity.Content.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DevEventsActivity.kt:168)");
                            }
                            for (Map.Entry entry : mapC.entrySet()) {
                                final String str = (String) entry.getKey();
                                final String str2 = (String) entry.getValue();
                                Modifier modifierI = PaddingKt.i(SizeKt.k(Modifier.b8, Dp.g(24), 0.0f, 2, null), Dp.g(2));
                                int i8 = i7;
                                ChipColors chipColorsA = ChipDefaults.f12397a.a(ComposeColorsKt.j(composer3, i7).b(), ComposeColorsKt.j(composer3, i7).q0(), 0L, 0L, 0L, 0L, composer3, ChipDefaults.f12402f << 18, 60);
                                Object objG2 = composer3.G();
                                if (objG2 == Composer.f23746a.a()) {
                                    objG2 = new Function0<Unit>() { // from class: cz.mobilesoft.coreblock.scene.dev_events.DevEventsActivity$Content$1$1$1$3$1$1$2$1$1$1$1
                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Object invoke() {
                                            c();
                                            return Unit.f139807a;
                                        }

                                        public final void c() {
                                        }
                                    };
                                    composer3.w(objG2);
                                }
                                ChipKt.a((Function0) objG2, modifierI, false, null, null, null, chipColorsA, null, ComposableLambdaKt.e(-691856246, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.dev_events.DevEventsActivity$Content$1$1$1$3$1$1$2$1$1$2
                                    public final void c(RowScope Chip, Composer composer4, int i9) {
                                        Intrinsics.checkNotNullParameter(Chip, "$this$Chip");
                                        if (!composer4.r((i9 & 17) != 16, i9 & 1)) {
                                            composer4.Q();
                                            return;
                                        }
                                        if (ComposerKt.M()) {
                                            ComposerKt.U(-691856246, i9, -1, "cz.mobilesoft.coreblock.scene.dev_events.DevEventsActivity.Content.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DevEventsActivity.kt:179)");
                                        }
                                        TextKt.c(str + ": " + str2, null, ComposeColorsKt.j(composer4, 0).q0(), 0L, null, FontWeight.f29233b.b(), null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer4, 0).d(), composer4, 196608, 0, 65498);
                                        if (ComposerKt.M()) {
                                            ComposerKt.T();
                                        }
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        c((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.f139807a;
                                    }
                                }, composer3, 54), composer3, 100663350, 188);
                                composer3 = composer2;
                                z2 = true;
                                i7 = i8;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            c((FlowRowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.f139807a;
                        }
                    }, composer, 54), composer, 1572870, 62);
                    composer.U();
                }
                composer.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(DevEventsActivity devEventsActivity, DevEventsViewState devEventsViewState, Function1 function1, int i3, Composer composer, int i4) {
        devEventsActivity.u0(devEventsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(DevEventsActivity devEventsActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        devEventsActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(final DevEventsViewState devEventsViewState, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-410233587, i3, -1, "cz.mobilesoft.coreblock.scene.dev_events.DevEventsActivity.Content.<anonymous> (DevEventsActivity.kt:63)");
            }
            ScaffoldKt.a(null, null, null, null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(560521291, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dev_events.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DevEventsActivity.w0(devEventsViewState, function1, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 0, 12582912, 131071);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(final DevEventsViewState devEventsViewState, final Function1 function1, PaddingValues it, Composer composer, int i3) {
        int i4;
        Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(560521291, i4, -1, "cz.mobilesoft.coreblock.scene.dev_events.DevEventsActivity.Content.<anonymous>.<anonymous> (DevEventsActivity.kt:64)");
            }
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierH = PaddingKt.h(companion2, it);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion3.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
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
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f3 = 16;
            Modifier modifierK = PaddingKt.k(BackgroundKt.d(companion2, ComposeColorsKt.j(composer, 0).e(), null, 2, null), Dp.g(f3), 0.0f, 2, null);
            float f4 = 48;
            Modifier modifierI = SizeKt.i(modifierK, Dp.g(f4));
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion3.i(), composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierI);
            Function0 function0A2 = companion4.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyB, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            TextKt.c(StringResources_androidKt.b(R.string.q9, composer, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 131070);
            Composer composer2 = composer;
            SpacerKt.a(RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null), composer2, 0);
            boolean Z = composer2.Z(function1);
            Object objG = composer2.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dev_events.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DevEventsActivity.x0(function1);
                    }
                };
                composer2.w(objG);
            }
            ComposableSingletons$DevEventsActivityKt composableSingletons$DevEventsActivityKt = ComposableSingletons$DevEventsActivityKt.f101641a;
            IconButtonKt.a((Function0) objG, null, false, null, composableSingletons$DevEventsActivityKt.f(), composer2, 24576, 14);
            boolean Z2 = composer2.Z(function1);
            Object objG2 = composer2.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dev_events.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DevEventsActivity.y0(function1);
                    }
                };
                composer2.w(objG2);
            }
            IconButtonKt.a((Function0) objG2, null, false, null, composableSingletons$DevEventsActivityKt.d(), composer2, 24576, 14);
            composer2.y();
            if (devEventsViewState.d()) {
                composer2.a0(-11046360);
                Modifier modifierI2 = SizeKt.i(PaddingKt.k(BackgroundKt.d(companion2, ComposeColorsKt.j(composer2, 0).e(), null, 2, null), Dp.g(f3), 0.0f, 2, null), Dp.g(f4));
                MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), companion3.i(), composer2, 48);
                int iA3 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU3 = composer2.u();
                Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierI2);
                Function0 function0A3 = companion4.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A3);
                } else {
                    composer2.v();
                }
                Composer composerA3 = Updater.a(composer2);
                Updater.e(composerA3, measurePolicyB2, companion4.e());
                Updater.e(composerA3, compositionLocalMapU3, companion4.g());
                Function2 function2B3 = companion4.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion4.f());
                TextKt.c(StringResources_androidKt.b(R.string.Q1, composer2, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 131070);
                SpacerKt.a(RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null), composer, 0);
                float f5 = 4;
                Modifier modifierI3 = PaddingKt.i(companion2, Dp.g(f5));
                boolean Z3 = composer.Z(function1);
                Object objG3 = composer.G();
                if (Z3 || objG3 == Composer.f23746a.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dev_events.j
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DevEventsActivity.z0(function1);
                        }
                    };
                    composer.w(objG3);
                }
                companion = companion2;
                TextKt.c(StringResources_androidKt.b(R.string.uH, composer, 0), ClickableKt.f(modifierI3, false, null, null, (Function0) objG3, 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 131068);
                SpacerKt.a(SizeKt.A(companion, Dp.g(f3)), composer, 6);
                Modifier modifierI4 = PaddingKt.i(companion, Dp.g(f5));
                boolean Z4 = composer.Z(function1);
                Object objG4 = composer.G();
                if (Z4 || objG4 == Composer.f23746a.a()) {
                    objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dev_events.k
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DevEventsActivity.A0(function1);
                        }
                    };
                    composer.w(objG4);
                }
                TextKt.c(StringResources_androidKt.b(R.string.Ik, composer, 0), ClickableKt.f(modifierI4, false, null, null, (Function0) objG4, 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 131068);
                composer2 = composer;
                composer2.y();
            } else {
                companion = companion2;
                composer2.a0(-15266111);
            }
            composer2.U();
            Modifier modifierI5 = PaddingKt.i(BackgroundKt.d(SizeKt.f(companion, 0.0f, 1, null), ComposeColorsKt.j(composer2, 0).l0(), null, 2, null), Dp.g(f3));
            boolean Z5 = composer2.Z(devEventsViewState) | composer2.Z(function1);
            Object objG5 = composer2.G();
            if (Z5 || objG5 == Composer.f23746a.a()) {
                objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dev_events.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DevEventsActivity.B0(devEventsViewState, function1, (LazyListScope) obj);
                    }
                };
                composer2.w(objG5);
            }
            LazyDslKt.b(modifierI5, null, null, false, null, null, null, false, null, (Function1) objG5, composer, 0, 510);
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
    public static final Unit x0(Function1 function1) {
        function1.invoke(DevEventsViewEvent.CopyEventsToClipboard.f101659a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(Function1 function1) {
        function1.invoke(DevEventsViewEvent.ShowConfirmRow.f101661a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(Function1 function1) {
        function1.invoke(new DevEventsViewEvent.OnConfirmRowButtonClicked(true));
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(1988897251);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1988897251, i4, -1, "cz.mobilesoft.coreblock.scene.dev_events.DevEventsActivity.RootCompose (DevEventsActivity.kt:45)");
            }
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            CreationExtras creationExtrasA2 = null;
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            if (navBackStackEntry != null && (bundleB = navBackStackEntry.b()) != null) {
                creationExtrasA2 = BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            }
            KClass kClassB = Reflection.b(DevEventsViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            DevEventsViewModel devEventsViewModel = (DevEventsViewModel) viewModelA;
            u0((DevEventsViewState) FlowExtKt.m(devEventsViewModel, composerK, 0), FlowExtKt.n(devEventsViewModel, composerK, 0), composerK, (i4 << 3) & 896);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dev_events.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DevEventsActivity.D0(this.f101667a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void u0(final DevEventsViewState viewState, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-282464290);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-282464290, i4, -1, "cz.mobilesoft.coreblock.scene.dev_events.DevEventsActivity.Content (DevEventsActivity.kt:61)");
            }
            ComposeThemesKt.b(null, ComposableLambdaKt.e(-410233587, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dev_events.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DevEventsActivity.v0(viewState, onEvent, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 48, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dev_events.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DevEventsActivity.C0(this.f101672a, viewState, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
