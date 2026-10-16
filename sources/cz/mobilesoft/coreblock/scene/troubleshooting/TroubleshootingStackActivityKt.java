package cz.mobilesoft.coreblock.scene.troubleshooting;

import android.content.Context;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MaterialTheme;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.facebook.AuthenticationToken;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.HelpItem;
import cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewEvent;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarButtonType;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
import org.xmlpull.v1.XmlPullParserException;

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
public final class TroubleshootingStackActivityKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function1 function1) {
        function1.invoke(TroubleshootingStackViewEvent.OnCloseClicked.f122985a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(TroubleshootingStackViewState troubleshootingStackViewState, Function1 function1, int i3, Composer composer, int i4) {
        x(troubleshootingStackViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final TroubleshootingStackViewState troubleshootingStackViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1454609028);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(troubleshootingStackViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1454609028, i4, -1, "cz.mobilesoft.coreblock.scene.troubleshooting.Content (TroubleshootingStackActivity.kt:197)");
            }
            Modifier modifierK = PaddingKt.k(SizeKt.f(Modifier.b8, 0.0f, 1, null), Dp.g(16), 0.0f, 2, null);
            boolean z2 = ((i4 & 14) == 4) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TroubleshootingStackActivityKt.n(troubleshootingStackViewState, function1, (LazyListScope) obj);
                    }
                };
                composerK.w(objG);
            }
            LazyDslKt.b(modifierK, null, null, false, null, null, null, false, null, (Function1) objG, composerK, 6, 510);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TroubleshootingStackActivityKt.p(troubleshootingStackViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(TroubleshootingStackViewState troubleshootingStackViewState, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        ComposableSingletons$TroubleshootingStackActivityKt composableSingletons$TroubleshootingStackActivityKt = ComposableSingletons$TroubleshootingStackActivityKt.f122959a;
        LazyListScope.c(LazyColumn, "toolbar_spacer", null, composableSingletons$TroubleshootingStackActivityKt.g(), 2, null);
        LazyListScope.c(LazyColumn, AuthenticationToken.HEADER_KEY, null, composableSingletons$TroubleshootingStackActivityKt.f(), 2, null);
        final ImmutableList immutableListC = troubleshootingStackViewState.c();
        final Function1 function12 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TroubleshootingStackActivityKt.o((TroubleshootingStackItem) obj);
            }
        };
        final TroubleshootingStackActivityKt$Content$lambda$0$0$$inlined$items$default$1 troubleshootingStackActivityKt$Content$lambda$0$0$$inlined$items$default$1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackActivityKt$Content$lambda$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Object obj) {
                return null;
            }
        };
        LazyColumn.h(immutableListC.size(), new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackActivityKt$Content$lambda$0$0$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i3) {
                return function12.invoke(immutableListC.get(i3));
            }
        }, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackActivityKt$Content$lambda$0$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i3) {
                return troubleshootingStackActivityKt$Content$lambda$0$0$$inlined$items$default$1.invoke(immutableListC.get(i3));
            }
        }, ComposableLambdaKt.c(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackActivityKt$Content$lambda$0$0$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) throws XmlPullParserException, IOException {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.f139807a;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
                int i5;
                if ((i4 & 6) == 0) {
                    i5 = (composer.Z(lazyItemScope) ? 4 : 2) | i4;
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
                TroubleshootingStackItem troubleshootingStackItem = (TroubleshootingStackItem) immutableListC.get(i3);
                composer.a0(-887016163);
                if (troubleshootingStackItem.d()) {
                    composer.a0(-886986280);
                    Alignment alignmentE = Alignment.f25072a.e();
                    Modifier modifierK = PaddingKt.k(SizeKt.h(Modifier.b8, 0.0f, 1, null), 0.0f, Dp.g(16), 1, null);
                    MeasurePolicy measurePolicyG = BoxKt.g(alignmentE, false);
                    int iA = ComposablesKt.a(composer, 0);
                    CompositionLocalMap compositionLocalMapU = composer.u();
                    Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
                    ComposeUiNode.Companion companion = ComposeUiNode.f8;
                    Function0 function0A = companion.a();
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
                    Updater.e(composerA, measurePolicyG, companion.e());
                    Updater.e(composerA, compositionLocalMapU, companion.g());
                    Function2 function2B = companion.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    ComposeCommonsKt.g(null, 0.0f, composer, 0, 3);
                    composer.y();
                    composer.U();
                } else {
                    composer.a0(-886676931);
                    TroubleshootingStackActivityKt.s(troubleshootingStackItem.c(), function1, composer, 0);
                    SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(8)), composer, 6);
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
    public static final Object o(TroubleshootingStackItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.c().name();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(TroubleshootingStackViewState troubleshootingStackViewState, Function1 function1, int i3, Composer composer, int i4) {
        m(troubleshootingStackViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Composer composer, final int i3) {
        Composer composerK = composer.k(1225452731);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1225452731, i3, -1, "cz.mobilesoft.coreblock.scene.troubleshooting.Header (TroubleshootingStackActivity.kt:283)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            ImageKt.a(PainterResources_androidKt.c(R.drawable.h4, composerK, 0), null, null, null, null, 0.0f, null, composerK, 48, 124);
            float f3 = 16;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            CardsKt.k(SizeKt.I(SizeKt.E(companion, null, false, 3, null), null, false, 3, null), ComposeColorsKt.j(composerK, 0).o0(), 0.0f, RoundedCornerShapeKt.g(), null, ComposableSingletons$TroubleshootingStackActivityKt.f122959a.h(), composerK, 196614, 20);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.Vn, composerK, 0), null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composerK, MaterialTheme.f13092b).f(), composerK, 0, 0, 65022);
            composerK = composerK;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TroubleshootingStackActivityKt.r(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(int i3, Composer composer, int i4) {
        q(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void s(final HelpItem item, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(62996216);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(item.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(62996216, i4, -1, "cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackItemCard (TroubleshootingStackActivity.kt:241)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean z2 = ((i4 & 112) == 32) | ((i4 & 14) == 4);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TroubleshootingStackActivityKt.t(onEvent, item);
                    }
                };
                composerK.w(objG);
            }
            CardsKt.j(null, 0L, 0.0f, false, null, (Function0) objG, ComposableLambdaKt.e(1444591900, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.o
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TroubleshootingStackActivityKt.u(item, context, onEvent, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 1572864, 31);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TroubleshootingStackActivityKt.w(item, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Function1 function1, HelpItem helpItem) {
        function1.invoke(new TroubleshootingStackViewEvent.OnHelpItemClicked(helpItem));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(final HelpItem helpItem, Context context, final Function1 function1, ColumnScope BaseCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1444591900, i3, -1, "cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackItemCard.<anonymous> (TroubleshootingStackActivity.kt:249)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            String strB = StringResources_androidKt.b(helpItem.getTitleResId(), composer, 0);
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i4 = MaterialTheme.f13092b;
            TextKt.c(strB, null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.c(composer, i4).i(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer, 6);
            TextKt.c(helpItem.getDescription(context), null, ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.c(composer, i4).b(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            ButtonType.MediumRound mediumRound = new ButtonType.MediumRound(null, null, StringResources_androidKt.b(R.string.md, composer, 0), null, false, 27, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean Z = composer.Z(function1) | composer.e(helpItem.ordinal());
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TroubleshootingStackActivityKt.v(function1, helpItem);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(null, mediumRound, accent, (Function0) objG, composer, 0, 1);
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
    public static final Unit v(Function1 function1, HelpItem helpItem) {
        function1.invoke(new TroubleshootingStackViewEvent.OnHelpItemClicked(helpItem));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(HelpItem helpItem, Function1 function1, int i3, Composer composer, int i4) {
        s(helpItem, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final TroubleshootingStackViewState troubleshootingStackViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1553017735);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(troubleshootingStackViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1553017735, i4, -1, "cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackScreen (TroubleshootingStackActivity.kt:171)");
            }
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(2043837831, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.v
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TroubleshootingStackActivityKt.y(troubleshootingStackViewState, function1, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TroubleshootingStackActivityKt.B(troubleshootingStackViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(final TroubleshootingStackViewState troubleshootingStackViewState, final Function1 function1, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2043837831, i3, -1, "cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackScreen.<anonymous> (TroubleshootingStackActivity.kt:173)");
            }
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.b(WindowInsets.f7172a, composer, 6)), null, null, null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(1215783689, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TroubleshootingStackActivityKt.z(troubleshootingStackViewState, function1, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 0, 12779520, 98302);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(TroubleshootingStackViewState troubleshootingStackViewState, final Function1 function1, PaddingValues paddingValues, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(paddingValues) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1215783689, i4, -1, "cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackScreen.<anonymous>.<anonymous> (TroubleshootingStackActivity.kt:177)");
            }
            Modifier modifierH = PaddingKt.h(Modifier.b8, paddingValues);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            m(troubleshootingStackViewState, function1, composer, 0);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.troubleshooting.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TroubleshootingStackActivityKt.A(function1);
                    }
                };
                composer.w(objG);
            }
            ToolbarKt.e(null, (Function0) objG, null, true, ToolbarButtonType.Close, false, false, null, null, composer, 27648, 485);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
