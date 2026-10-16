package cz.mobilesoft.coreblock.scene.chatbot.intro;

import android.content.Context;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ScaffoldKt;
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
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavController;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.scene.chatbot.NavChatBot;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackActivity;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
public final class IntroChatBotScreenKt {
    public static final void h(final NavController navController, final IntroChatBotViewState viewState, final Function0 onClose, final String entrances, final ContactReason contactReason, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Intrinsics.checkNotNullParameter(entrances, "entrances");
        Intrinsics.checkNotNullParameter(contactReason, "contactReason");
        Composer composerK = composer.k(981223041);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(navController) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onClose) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(entrances) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.e(contactReason.ordinal()) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(981223041, i4, -1, "cz.mobilesoft.coreblock.scene.chatbot.intro.IntroChatbotScreen (IntroChatBotScreen.kt:44)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean z2 = (i4 & 896) == 256;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.chatbot.intro.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return IntroChatBotScreenKt.i(onClose);
                    }
                };
                composerK.w(objG);
            }
            BackHandlerKt.a(false, (Function0) objG, composerK, 0, 1);
            composer2 = composerK;
            ScaffoldKt.a(SizeKt.f(Modifier.b8, 0.0f, 1, null), null, ComposableLambdaKt.e(2523206, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.chatbot.intro.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroChatBotScreenKt.j(onClose, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(2146007367, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.chatbot.intro.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroChatBotScreenKt.l(navController, viewState, context, contactReason, entrances, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableSingletons$IntroChatBotScreenKt.f99063a.d(), composer2, 3462, 12582912, 131058);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.chatbot.intro.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroChatBotScreenKt.o(navController, viewState, onClose, entrances, contactReason, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(final Function0 function0, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2523206, i3, -1, "cz.mobilesoft.coreblock.scene.chatbot.intro.IntroChatbotScreen.<anonymous> (IntroChatBotScreen.kt:54)");
            }
            Modifier modifierM = PaddingKt.m(SizeKt.i(Modifier.b8, Dp.g(56)), Dp.g(6), 0.0f, 0.0f, 0.0f, 14, null);
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            String strB = StringResources_androidKt.b(R.string.Re, composer, 0);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.chatbot.intro.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return IntroChatBotScreenKt.k(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(modifierM, imageVectorB, null, false, 0.0f, 0.0f, 0L, strB, (Function0) objG, composer, 6, 124);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(final NavController navController, IntroChatBotViewState introChatBotViewState, final Context context, final ContactReason contactReason, final String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2146007367, i3, -1, "cz.mobilesoft.coreblock.scene.chatbot.intro.IntroChatbotScreen.<anonymous> (IntroChatBotScreen.kt:66)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(12));
            Modifier modifierM = PaddingKt.m(PaddingKt.k(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(16), 7, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, Alignment.f25072a.k(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.l8, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean zI = composer.I(navController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.chatbot.intro.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return IntroChatBotScreenKt.m(navController);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composer, 0, 1);
            if (introChatBotViewState.b()) {
                composer.a0(-782283473);
                ButtonType.Big big2 = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.wx, composer, 0), 0.0f, 11, null);
                ButtonColor.Surface surface = new ButtonColor.Surface(false, null, false, null, null, 31, null);
                boolean zI2 = composer.I(context) | composer.e(contactReason.ordinal()) | composer.Z(str);
                Object objG2 = composer.G();
                if (zI2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.chatbot.intro.i
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return IntroChatBotScreenKt.n(context, contactReason, str);
                        }
                    };
                    composer.w(objG2);
                }
                ComposeButtonsKt.i0(null, big2, surface, (Function0) objG2, composer, 0, 1);
            } else {
                composer.a0(-785764091);
            }
            composer.U();
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
    public static final Unit m(NavController navController) {
        AnswersHelper.f128199a.q1();
        NavController.O(navController, NavChatBot.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Context context, ContactReason contactReason, String str) {
        AnswersHelper.f128199a.r1();
        context.startActivity(FeedbackActivity.Companion.b(FeedbackActivity.f102045f, context, contactReason, null, null, str, null, false, 108, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(NavController navController, IntroChatBotViewState introChatBotViewState, Function0 function0, String str, ContactReason contactReason, int i3, Composer composer, int i4) {
        h(navController, introChatBotViewState, function0, str, contactReason, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
