package cz.mobilesoft.coreblock.scene.chatbot.chatbot;

import android.content.Context;
import android.webkit.WebView;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavHostController;
import com.google.accompanist.systemuicontroller.SystemUiController;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import com.google.accompanist.web.WebViewKt;
import com.google.accompanist.web.WebViewState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackActivity;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ChatBotScreenKt {
    public static final void h(NavHostController navHostController, String str, ContactReason contactReason, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        final NavHostController navHostController2 = navHostController;
        final String entrances = str;
        final ContactReason contactReason2 = contactReason;
        Intrinsics.checkNotNullParameter(navHostController2, "navHostController");
        Intrinsics.checkNotNullParameter(entrances, "entrances");
        Intrinsics.checkNotNullParameter(contactReason2, "contactReason");
        Composer composerK = composer.k(-1104070251);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(navHostController2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(entrances) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.e(contactReason2.ordinal()) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1104070251, i4, -1, "cz.mobilesoft.coreblock.scene.chatbot.chatbot.ChatBotScreen (ChatBotScreen.kt:46)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            final long jE = ComposeColorsKt.j(composerK, 0).e();
            final WebViewState webViewStateI = WebViewKt.i("file:///android_asset/chatbase_chatbot.html", null, composerK, 6, 2);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            final SystemUiController systemUiControllerE = SystemUiControllerKt.e(null, composerK, 0, 1);
            boolean Z = composerK.Z(systemUiControllerE) | composerK.f(jE);
            Object objG2 = composerK.G();
            if (Z || objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.chatbot.chatbot.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatBotScreenKt.k(systemUiControllerE, jE, (DisposableEffectScope) obj);
                    }
                };
                composerK.w(objG2);
            }
            EffectsKt.c(systemUiControllerE, (Function1) objG2, composerK, 0);
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG3);
            }
            final MutableState mutableState2 = (MutableState) objG3;
            Unit unit = Unit.f139807a;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = new ChatBotScreenKt$ChatBotScreen$2$1(30000L, mutableState2, null);
                composerK.w(objG4);
            }
            EffectsKt.g(unit, (Function2) objG4, composerK, 6);
            Modifier modifierF = SizeKt.f(Modifier.b8, 0.0f, 1, null);
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(-832867878, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.chatbot.chatbot.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatBotScreenKt.n(navHostController2, context, contactReason2, entrances, mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54);
            entrances = str;
            contactReason2 = contactReason;
            composer2 = composerK;
            navHostController2 = navHostController;
            ScaffoldKt.a(modifierF, null, composableLambdaE, null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(2014068563, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.chatbot.chatbot.c
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ChatBotScreenKt.q(webViewStateI, context, entrances, contactReason2, mutableState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 390, 12582912, 131066);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.chatbot.chatbot.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatBotScreenKt.i(navHostController2, entrances, contactReason2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(NavHostController navHostController, String str, ContactReason contactReason, int i3, Composer composer, int i4) {
        h(navHostController, str, contactReason, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void j(MutableState mutableState, WebView webView) {
        mutableState.setValue(webView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult k(final SystemUiController systemUiController, final long j3, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        SystemUiController.b(systemUiController, Color.f25715b.a(), false, null, 6, null);
        return new DisposableEffectResult() { // from class: cz.mobilesoft.coreblock.scene.chatbot.chatbot.ChatBotScreenKt$ChatBotScreen$lambda$3$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                SystemUiController.b(systemUiController, j3, false, null, 6, null);
            }
        };
    }

    private static final boolean l(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(final NavHostController navHostController, final Context context, final ContactReason contactReason, final String str, MutableState mutableState, Composer composer, int i3) throws XmlPullParserException, IOException {
        Composer composer2;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-832867878, i3, -1, "cz.mobilesoft.coreblock.scene.chatbot.chatbot.ChatBotScreen.<anonymous> (ChatBotScreen.kt:79)");
            }
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierD = BackgroundKt.d(SizeKt.h(SizeKt.i(companion, Dp.g(56)), 0.0f, 1, null), Color.f25715b.a(), null, 2, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), verticalI, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierD);
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
            Modifier modifierM = PaddingKt.m(companion, Dp.g(6), 0.0f, 0.0f, 0.0f, 14, null);
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            String strB = StringResources_androidKt.b(R.string.Re, composer, 0);
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.chatbot.chatbot.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ChatBotScreenKt.o(navHostController);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(modifierM, imageVectorB, null, false, 0.0f, 0.0f, 0L, strB, (Function0) objG, composer, 6, 124);
            SpacerKt.a(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
            if (l(mutableState)) {
                composer.a0(-832255222);
                Modifier modifierM2 = PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(8), 0.0f, 11, null);
                String strB2 = StringResources_androidKt.b(R.string.i8, composer, 0);
                boolean zI2 = composer.I(context) | composer.e(contactReason.ordinal()) | composer.Z(str);
                Object objG2 = composer.G();
                if (zI2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.chatbot.chatbot.f
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ChatBotScreenKt.p(context, contactReason, str);
                        }
                    };
                    composer.w(objG2);
                }
                composer2 = composer;
                ComposeButtonsKt.c0(strB2, modifierM2, false, 0L, null, 0.0f, null, (Function0) objG2, composer2, 48, 124);
            } else {
                composer2 = composer;
                composer2.a0(-836337116);
            }
            composer2.U();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(NavHostController navHostController) {
        navHostController.R();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Context context, ContactReason contactReason, String str) {
        context.startActivity(FeedbackActivity.Companion.b(FeedbackActivity.f102045f, context, contactReason, null, null, str, "unknown url for chatbase", false, 76, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(WebViewState webViewState, Context context, String str, ContactReason contactReason, final MutableState mutableState, PaddingValues padding, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(padding, "padding");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(padding) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2014068563, i4, -1, "cz.mobilesoft.coreblock.scene.chatbot.chatbot.ChatBotScreen.<anonymous> (ChatBotScreen.kt:114)");
            }
            Modifier modifierF = SizeKt.f(PaddingKt.h(Modifier.b8, padding), 0.0f, 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
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
            Updater.e(composerA, modifierF2, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.chatbot.chatbot.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChatBotScreenKt.r(mutableState, (WebView) obj);
                    }
                };
                composer.w(objG);
            }
            WebViewKt.a(webViewState, null, false, null, (Function1) objG, null, new ChatBotWebViewClient(), new ChatBotChromeClient(context, str, contactReason), null, composer, (ChatBotWebViewClient.f99041d << 18) | 24576, 302);
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
    public static final Unit r(MutableState mutableState, WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        j(mutableState, webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setBackgroundColor(-16777216);
        return Unit.f139807a;
    }
}
