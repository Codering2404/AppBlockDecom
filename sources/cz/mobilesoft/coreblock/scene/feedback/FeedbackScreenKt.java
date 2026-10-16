package cz.mobilesoft.coreblock.scene.feedback;

import android.content.Context;
import android.content.Intent;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.IconKt;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material.TextFieldDefaults;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.text.HtmlCompat;
import com.facebook.ads.AdError;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.QuestionDTO;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.scene.chatbot.ChatBotActivity;
import cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockActivity;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackActivity;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewEvent;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState;
import cz.mobilesoft.coreblock.scene.more.haf.HaFActivity;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.CircularProgressWithTextKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDropdownItem;
import cz.mobilesoft.coreblock.view.compose.ComposeDropdownKt;
import cz.mobilesoft.coreblock.view.compose.SectionedItemKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.xmlpull.v1.XmlPullParserException;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class FeedbackScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f102069a;

        static {
            int[] iArr = new int[ContactReason.values().length];
            try {
                iArr[ContactReason.EmergencyUnblocking.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f102069a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(FeedbackViewState feedbackViewState, Function1 function1) {
        if (feedbackViewState.n().contains(FeedbackViewState.FeedbackValidationError.NoInternetConnection)) {
            function1.invoke(FeedbackViewEvent.OnRetryClicked.f102078a);
        } else {
            function1.invoke(FeedbackViewEvent.OnSendClicked.f102079a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(FeedbackViewState feedbackViewState, Function1 function1, ScaffoldState scaffoldState, ScrollState scrollState, BringIntoViewRequester bringIntoViewRequester, PaddingValues it, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(978581200, i4, -1, "cz.mobilesoft.coreblock.scene.feedback.RootCompose.<anonymous> (FeedbackScreen.kt:281)");
            }
            if (feedbackViewState.n().contains(FeedbackViewState.FeedbackValidationError.NoInternetConnection) || feedbackViewState.n().contains(FeedbackViewState.FeedbackValidationError.ApiError)) {
                composer.a0(-1325318628);
                r0(feedbackViewState.n().contains(FeedbackViewState.FeedbackValidationError.ApiError), composer, 0);
                composer.U();
            } else if (feedbackViewState.k()) {
                composer.a0(-1325099210);
                Modifier.Companion companion = Modifier.b8;
                Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
                Alignment.Companion companion2 = Alignment.f25072a;
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
                int iA = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU = composer.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
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
                Updater.e(composerA, modifierF2, companion3.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                if (feedbackViewState.o() > 0) {
                    composer.a0(-1041783461);
                    Alignment.Horizontal horizontalG = companion2.g();
                    Arrangement.HorizontalOrVertical horizontalOrVerticalB = Arrangement.f6574a.b();
                    Modifier modifierF3 = SizeKt.f(companion, 0.0f, 1, null);
                    MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalB, horizontalG, composer, 54);
                    int iA2 = ComposablesKt.a(composer, 0);
                    CompositionLocalMap compositionLocalMapU2 = composer.u();
                    Modifier modifierF4 = ComposedModifierKt.f(composer, modifierF3);
                    Function0 function0A2 = companion3.a();
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
                    Updater.e(composerA2, measurePolicyA, companion3.e());
                    Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                    Function2 function2B2 = companion3.b();
                    if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                        composerA2.w(Integer.valueOf(iA2));
                        composerA2.p(Integer.valueOf(iA2), function2B2);
                    }
                    Updater.e(composerA2, modifierF4, companion3.f());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                    CircularProgressWithTextKt.b(feedbackViewState.o(), 0.0f, 0L, composer, 0, 6);
                    SpacerKt.a(SizeKt.i(companion, Dp.g(16)), composer, 6);
                    TextKt.c(StringResources_androidKt.b(R.string.VF, composer, 0), null, ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65530);
                    composer2 = composer;
                    composer2.y();
                    composer2.U();
                } else {
                    composer.a0(-1040834117);
                    ProgressIndicatorKt.b(boxScopeInstance.f(SizeKt.v(companion, Dp.g(100)), companion2.e()), ComposeColorsKt.j(composer, 0).b(), 0.0f, 0L, 0, composer, 0, 28);
                    composer2 = composer;
                    if (feedbackViewState.g()) {
                        composer2.a0(-1040430466);
                        Modifier modifierF5 = boxScopeInstance.f(companion, companion2.e());
                        MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
                        int iA3 = ComposablesKt.a(composer2, 0);
                        CompositionLocalMap compositionLocalMapU3 = composer2.u();
                        Modifier modifierF6 = ComposedModifierKt.f(composer2, modifierF5);
                        Function0 function0A3 = companion3.a();
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
                        Updater.e(composerA3, measurePolicyG2, companion3.e());
                        Updater.e(composerA3, compositionLocalMapU3, companion3.g());
                        Function2 function2B3 = companion3.b();
                        if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                            composerA3.w(Integer.valueOf(iA3));
                            composerA3.p(Integer.valueOf(iA3), function2B3);
                        }
                        Updater.e(composerA3, modifierF6, companion3.f());
                        ComposeCommonsKt.g(null, Dp.g(130), composer2, 48, 1);
                        composer2.y();
                    } else {
                        composer2.a0(-1053978055);
                    }
                    composer2.U();
                    composer2.U();
                }
                composer2.y();
                composer2.U();
            } else {
                composer.a0(-1323184712);
                U(it, feedbackViewState, function1, scaffoldState, scrollState, bringIntoViewRequester, composer, i4 & 14);
                composer.U();
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
    public static final Unit C0(ScaffoldState scaffoldState, FeedbackViewState feedbackViewState, ScrollState scrollState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        x0(scaffoldState, feedbackViewState, scrollState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void D0(final Function1 onEvent, final boolean z2, final FeedbackViewState viewState, Composer composer, final int i3) {
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Composer composerK = composer.k(1093415771);
        int i4 = 2;
        int i5 = (i3 & 6) == 0 ? (composerK.I(onEvent) ? 4 : 2) | i3 : i3;
        int i6 = 16;
        if ((i3 & 48) == 0) {
            i5 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.Z(viewState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1093415771, i5, -1, "cz.mobilesoft.coreblock.scene.feedback.SelectReasonList (FeedbackScreen.kt:900)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
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
            composerK.a0(1169241951);
            EnumEntries<ContactReason> entries = ContactReason.getEntries();
            ArrayList arrayList = new ArrayList();
            for (ContactReason contactReason : entries) {
                if (contactReason != ContactReason.EmergencyUnblocking || !z2) {
                    arrayList.add(contactReason);
                }
            }
            int size = arrayList.size();
            int i7 = 0;
            while (i7 < size) {
                int i8 = i7 + 1;
                final ContactReason contactReason2 = (ContactReason) arrayList.get(i7);
                Modifier.Companion companion3 = Modifier.b8;
                float f3 = i6;
                Modifier modifierK = PaddingKt.k(companion3, Dp.g(f3), 0.0f, i4, null);
                String strB = StringResources_androidKt.b(contactReason2.getTextResId(), composerK, 0);
                int i9 = i5;
                boolean zE = composerK.e(contactReason2.ordinal()) | ((i5 & 896) == 256) | ((i9 & 14) == 4) | composerK.I(context);
                Object objG = composerK.G();
                if (zE || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.feedback.d0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FeedbackScreenKt.E0(contactReason2, viewState, onEvent, context);
                        }
                    };
                    composerK.w(objG);
                }
                Composer composer2 = composerK;
                SectionedItemKt.G(modifierK, strB, null, null, null, null, null, null, null, false, 0L, 0L, null, false, (Function0) objG, false, null, 0L, composer2, 805306374, 0, 245244);
                composerK = composer2;
                SpacerKt.a(SizeKt.i(companion3, Dp.g(f3)), composerK, 6);
                context = context;
                i7 = i8;
                i6 = 16;
                i4 = 2;
                i5 = i9;
                size = size;
                arrayList = arrayList;
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.e0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeedbackScreenKt.F0(onEvent, z2, viewState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(ContactReason contactReason, FeedbackViewState feedbackViewState, Function1 function1, Context context) {
        if (WhenMappings.f102069a[contactReason.ordinal()] == 1) {
            if (feedbackViewState.m()) {
                function1.invoke(FeedbackViewEvent.SaveEmergencyEntrance.f102080a);
                context.startActivity(new Intent(context, (Class<?>) EmergencyUnblockActivity.class));
            } else {
                function1.invoke(new FeedbackViewEvent.OnReasonSelected(contactReason));
            }
        } else if (feedbackViewState.p()) {
            context.startActivity(ChatBotActivity.f99024h.a(context, "help_screen", contactReason));
        } else {
            context.startActivity(FeedbackActivity.Companion.b(FeedbackActivity.f102045f, context, contactReason, null, null, "help_screen", null, false, 108, null));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(Function1 function1, boolean z2, FeedbackViewState feedbackViewState, int i3, Composer composer, int i4) {
        D0(function1, z2, feedbackViewState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void G0(final ScaffoldState scaffoldState, final FeedbackViewState viewState, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(665305288);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(scaffoldState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onEvent) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(665305288, i4, -1, "cz.mobilesoft.coreblock.scene.feedback.SelectReasonRow (FeedbackScreen.kt:938)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            Color colorN = null;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            if (viewState.n().contains(FeedbackViewState.FeedbackValidationError.MissingSelectedReason)) {
                composerK.a0(-591734928);
                long jK = ComposeColorsKt.j(composerK, 0).k();
                composerK.U();
                colorN = Color.n(jK);
            } else {
                composerK.a0(-1163899819);
                composerK.U();
            }
            CardType.Surface surface = new CardType.Surface(colorN, null, null, 6, null);
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(Modifier.b8, Dp.g(f3), Dp.g(f3), Dp.g(f3), 0.0f, 8, null);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.feedback.g0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FeedbackScreenKt.H0(mutableState);
                    }
                };
                composerK.w(objG2);
            }
            ComposeCardsKt.m(modifierM, surface, (Function0) objG2, ComposableLambdaKt.e(1089333293, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.h0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeedbackScreenKt.I0(viewState, mutableState, scaffoldState, onEvent, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 3456, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeedbackScreenKt.L0(scaffoldState, viewState, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(FeedbackViewState feedbackViewState, final MutableState mutableState, ScaffoldState scaffoldState, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1089333293, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.SelectReasonRow.<anonymous> (FeedbackScreen.kt:950)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Vertical verticalI = companion.i();
            Modifier.Companion companion2 = Modifier.b8;
            String strB = null;
            Modifier modifierH = SizeKt.h(PaddingKt.k(SizeKt.k(companion2, Dp.g(56), 0.0f, 2, null), Dp.g(16), 0.0f, 2, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), verticalI, composer, 48);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            ContactReason contactReasonJ = feedbackViewState.j();
            if (contactReasonJ == null) {
                composer.a0(1966881551);
            } else {
                composer.a0(1966881552);
                strB = StringResources_androidKt.b(contactReasonJ.getTextResId(), composer, 0);
            }
            composer.U();
            if (strB == null) {
                composer.a0(-2014760748);
                strB = StringResources_androidKt.b(R.string.Mv, composer, 0);
            } else {
                composer.a0(-2014763166);
            }
            composer.U();
            TextKt.c(strB, RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65528);
            MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, companion2);
            Function0 function0A2 = companion3.a();
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
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Painter painterC = PainterResources_androidKt.c(R.drawable.R2, composer, 0);
            long jS = ComposeColorsKt.j(composer, 0).s();
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.feedback.j0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FeedbackScreenKt.J0(mutableState);
                    }
                };
                composer.w(objG);
            }
            IconKt.a(painterC, null, ClickableKt.f(companion2, false, null, null, (Function0) objG, 7, null), jS, composer, 48, 0);
            composer.a0(-599931477);
            EnumEntries<ContactReason> entries = ContactReason.getEntries();
            ArrayList arrayList = new ArrayList();
            for (ContactReason contactReason : entries) {
                if (contactReason != ContactReason.EmergencyUnblocking || !feedbackViewState.h()) {
                    arrayList.add(contactReason);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                final ContactReason contactReason2 = (ContactReason) obj;
                String strB2 = StringResources_androidKt.b(contactReason2.getTextResId(), composer, 0);
                boolean Z = composer.Z(function1) | composer.e(contactReason2.ordinal());
                Object objG2 = composer.G();
                if (Z || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.feedback.k0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FeedbackScreenKt.K0(mutableState, function1, contactReason2);
                        }
                    };
                    composer.w(objG2);
                }
                arrayList2.add(new ComposeDropdownItem(strB2, null, null, false, null, null, null, null, (Function0) objG2, 254, null));
            }
            composer.U();
            ComposeDropdownKt.j(mutableState, scaffoldState, arrayList2, composer, 6);
            composer.y();
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
    public static final Unit J0(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(MutableState mutableState, Function1 function1, ContactReason contactReason) {
        mutableState.setValue(Boolean.FALSE);
        function1.invoke(new FeedbackViewEvent.OnReasonSelected(contactReason));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(ScaffoldState scaffoldState, FeedbackViewState feedbackViewState, Function1 function1, int i3, Composer composer, int i4) {
        G0(scaffoldState, feedbackViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void M0(final Function0 function0, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        Composer composerK = composer.k(-320293262);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function0) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-320293262, i4, -1, "cz.mobilesoft.coreblock.scene.feedback.Toolbar (FeedbackScreen.kt:399)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierD = BackgroundKt.d(SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).e(), null, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
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
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.G0, composerK, 6);
            String strB = StringResources_androidKt.b(R.string.Re, composerK, 0);
            Modifier modifierM = PaddingKt.m(companion, 0.0f, Dp.g(6), 0.0f, 0.0f, 13, null);
            boolean z2 = (i4 & 14) == 4;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.feedback.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FeedbackScreenKt.N0(function0);
                    }
                };
                composerK.w(objG);
            }
            ComposeButtonsKt.q0(modifierM, imageVectorB, null, false, 0.0f, 0.0f, 0L, strB, (Function0) objG, composerK, 6, 124);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeedbackScreenKt.O0(function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void N(Modifier modifier, final FeedbackViewState.FreshdeskAttachment attachment, final Function1 onEvent, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        Intrinsics.checkNotNullParameter(attachment, "attachment");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(219508046);
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
            i5 |= composerK.Z(attachment) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(onEvent) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (i6 != 0) {
                modifier2 = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(219508046, i5, -1, "cz.mobilesoft.coreblock.scene.feedback.AttachmentRow (FeedbackScreen.kt:715)");
            }
            CardType.Surface surface = new CardType.Surface(null, null, null, 7, null);
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.feedback.m0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FeedbackScreenKt.O();
                    }
                };
                composerK.w(objG);
            }
            ComposeCardsKt.m(modifier2, surface, (Function0) objG, ComposableLambdaKt.e(-1082950967, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.n0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeedbackScreenKt.P(attachment, onEvent, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, (i5 & 14) | 3456, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        final Modifier modifier3 = modifier2;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.o0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeedbackScreenKt.R(modifier3, attachment, onEvent, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(Function0 function0, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        M0(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(final FeedbackViewState.FreshdeskAttachment freshdeskAttachment, final Function1 function1, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1082950967, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.AttachmentRow.<anonymous> (FeedbackScreen.kt:722)");
            }
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            Modifier.Companion companion = Modifier.b8;
            float f3 = 12;
            Modifier modifierH = SizeKt.h(PaddingKt.m(SizeKt.k(companion, Dp.g(56), 0.0f, 2, null), Dp.g(f3), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), verticalI, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            IconKt.a(PainterResources_androidKt.c(R.drawable.J0, composer, 0), null, null, ComposeColorsKt.j(composer, 0).b(), composer, 48, 4);
            TextKt.c(freshdeskAttachment.a(), PaddingKt.m(companion, Dp.g(f3), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.f29661b.b(), false, 1, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 48, 3120, 55292);
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            String str = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(freshdeskAttachment.b() / ((double) 1000000))}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            TextKt.c("(" + str + " MB)", PaddingKt.m(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), Dp.g(4), 0.0f, 0.0f, 0.0f, 14, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer, 0).d(), 0L, TextUnitKt.i(12), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), composer, 0, 0, 65528);
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            long jQ = ComposeColorsKt.j(composer, 0).q();
            boolean Z = composer.Z(function1) | composer.Z(freshdeskAttachment);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.feedback.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FeedbackScreenKt.Q(function1, freshdeskAttachment);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(null, imageVectorB, null, false, 0.0f, 0.0f, jQ, null, (Function0) objG, composer, 0, 189);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void P0(final androidx.compose.foundation.layout.ColumnScope r32, final java.lang.String r33, androidx.compose.ui.Modifier r34, long r35, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.feedback.FeedbackScreenKt.P0(androidx.compose.foundation.layout.ColumnScope, java.lang.String, androidx.compose.ui.Modifier, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(Function1 function1, FeedbackViewState.FreshdeskAttachment freshdeskAttachment) {
        function1.invoke(new FeedbackViewEvent.OnAttachmentRemoved(freshdeskAttachment));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(ColumnScope columnScope, String str, Modifier modifier, long j3, int i3, int i4, Composer composer, int i5) {
        P0(columnScope, str, modifier, j3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(Modifier modifier, FeedbackViewState.FreshdeskAttachment freshdeskAttachment, Function1 function1, int i3, int i4, Composer composer, int i5) {
        N(modifier, freshdeskAttachment, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void S(final CoroutineScope coroutineScope, final ScaffoldState scaffoldState, FeedbackViewModel feedbackViewModel, final Function0 function0, Composer composer, final int i3) {
        int i4;
        FeedbackViewModel feedbackViewModel2;
        Composer composerK = composer.k(-750157358);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(coroutineScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(feedbackViewModel) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function0) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-750157358, i4, -1, "cz.mobilesoft.coreblock.scene.feedback.CommandProcessor (FeedbackScreen.kt:381)");
            }
            boolean zI = composerK.I(coroutineScope) | ((i4 & 112) == 32) | ((i4 & 7168) == 2048);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new FeedbackScreenKt$CommandProcessor$1$1(coroutineScope, function0, scaffoldState, null);
                composerK.w(objG);
            }
            feedbackViewModel2 = feedbackViewModel;
            FlowExtKt.g(feedbackViewModel2, null, (Function2) objG, composerK, (i4 >> 6) & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            feedbackViewModel2 = feedbackViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final FeedbackViewModel feedbackViewModel3 = feedbackViewModel2;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeedbackScreenKt.T(coroutineScope, scaffoldState, feedbackViewModel3, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final TextFieldColors S0(boolean z2, Composer composer, int i3, int i4) {
        long jB;
        long j3;
        boolean z3 = (i4 & 1) != 0 ? false : z2;
        if (ComposerKt.M()) {
            ComposerKt.U(179233920, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.feedbackTextFieldColors (FeedbackScreen.kt:888)");
        }
        boolean z4 = z3;
        TextFieldDefaults textFieldDefaults = TextFieldDefaults.f14636a;
        long jP = ComposeColorsKt.j(composer, 0).p();
        long jL0 = ComposeColorsKt.j(composer, 0).l0();
        if (z4) {
            composer.a0(445113192);
            jB = ComposeColorsKt.j(composer, 0).k();
        } else {
            composer.a0(445113862);
            jB = ComposeColorsKt.j(composer, 0).b();
        }
        composer.U();
        long j4 = jB;
        if (z4) {
            composer.a0(445115912);
            j3 = ComposeColorsKt.j(composer, 0).k();
            composer.U();
        } else {
            composer.a0(445116555);
            composer.U();
            j3 = Color.f25715b.j();
        }
        TextFieldColors textFieldColorsO = textFieldDefaults.o(jP, 0L, jL0, 0L, 0L, j4, j3, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, 0, 48, 2097050);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return textFieldColorsO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(CoroutineScope coroutineScope, ScaffoldState scaffoldState, FeedbackViewModel feedbackViewModel, Function0 function0, int i3, Composer composer, int i4) {
        S(coroutineScope, scaffoldState, feedbackViewModel, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void U(final PaddingValues paddingValues, final FeedbackViewState feedbackViewState, final Function1 function1, final ScaffoldState scaffoldState, final ScrollState scrollState, final BringIntoViewRequester bringIntoViewRequester, Composer composer, final int i3) {
        int i4;
        ScrollState scrollState2;
        Composer composer2;
        int i5;
        ColumnScopeInstance columnScopeInstance;
        Unit unit;
        Composer composerK = composer.k(-213171261);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(feedbackViewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            scrollState2 = scrollState;
            i4 |= composerK.Z(scrollState2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            scrollState2 = scrollState;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(bringIntoViewRequester) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (composerK.r((74899 & i4) != 74898, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-213171261, i4, -1, "cz.mobilesoft.coreblock.scene.feedback.Content (FeedbackScreen.kt:426)");
            }
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            int i6 = i4 & 896;
            boolean z2 = i6 == 256;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FeedbackScreenKt.V(function1, (ActivityResult) obj);
                    }
                };
                composerK.w(objG);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composerK, 0);
            boolean Z = composerK.Z(feedbackViewState.i());
            Object objG2 = composerK.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(feedbackViewState.i(), null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState = (MutableState) objG2;
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierG = ScrollKt.g(PaddingKt.h(BackgroundKt.d(SizeKt.f(companion, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).e(), null, 2, null), paddingValues), scrollState2, false, null, false, 14, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion2.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierG);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            int i7 = i4;
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.f6666a;
            float f3 = 16;
            int i8 = i6;
            TextKt.c(StringResources_androidKt.b(R.string.i8, composerK, 0), SizeKt.h(PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).e(), composerK, 48, 0, 65532);
            Composer composer3 = composerK;
            if (feedbackViewState.j() == null) {
                composer3.a0(-1621856484);
                composer2 = composer3;
                TextKt.c(StringResources_androidKt.b(R.string.Mv, composer3, 0), SizeKt.h(PaddingKt.l(companion, Dp.g(f3), Dp.g(20), Dp.g(f3), Dp.g(4)), 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer3, 0).h(), composer2, 0, 0, 65532);
                D0(function1, feedbackViewState.h(), feedbackViewState, composer2, (14 & (i7 >> 6)) | ((i7 << 3) & 896));
                composer2.U();
            } else {
                composer3.a0(-1621069611);
                G0(scaffoldState, feedbackViewState, function1, composer3, ((i7 >> 9) & 14) | (i7 & 112) | i8);
                if (feedbackViewState.j() == ContactReason.EmergencyUnblocking && feedbackViewState.m()) {
                    composer3.a0(-1621075346);
                    Modifier modifierI = PaddingKt.i(companion, Dp.g(f3));
                    MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.k(), composer3, 0);
                    int iA2 = ComposablesKt.a(composer3, 0);
                    CompositionLocalMap compositionLocalMapU2 = composer3.u();
                    Modifier modifierF2 = ComposedModifierKt.f(composer3, modifierI);
                    Function0 function0A2 = companion3.a();
                    if (composer3.m() == null) {
                        ComposablesKt.c();
                    }
                    composer3.L();
                    if (composer3.i()) {
                        composer3.P(function0A2);
                    } else {
                        composer3.v();
                    }
                    Composer composerA2 = Updater.a(composer3);
                    Updater.e(composerA2, measurePolicyA2, companion3.e());
                    Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                    Function2 function2B2 = companion3.b();
                    if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                        composerA2.w(Integer.valueOf(iA2));
                        composerA2.p(Integer.valueOf(iA2), function2B2);
                    }
                    Updater.e(composerA2, modifierF2, companion3.f());
                    Modifier modifierC = BackgroundKt.c(companion, ComposeColorsKt.j(composer3, 0).X(), RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composer3, 0)));
                    MeasurePolicy measurePolicyA3 = ColumnKt.a(arrangement.h(), companion2.k(), composer3, 0);
                    int iA3 = ComposablesKt.a(composer3, 0);
                    CompositionLocalMap compositionLocalMapU3 = composer3.u();
                    Modifier modifierF3 = ComposedModifierKt.f(composer3, modifierC);
                    Function0 function0A3 = companion3.a();
                    if (composer3.m() == null) {
                        ComposablesKt.c();
                    }
                    composer3.L();
                    if (composer3.i()) {
                        composer3.P(function0A3);
                    } else {
                        composer3.v();
                    }
                    Composer composerA3 = Updater.a(composer3);
                    Updater.e(composerA3, measurePolicyA3, companion3.e());
                    Updater.e(composerA3, compositionLocalMapU3, companion3.g());
                    Function2 function2B3 = companion3.b();
                    if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                        composerA3.w(Integer.valueOf(iA3));
                        composerA3.p(Integer.valueOf(iA3), function2B3);
                    }
                    Updater.e(composerA3, modifierF3, companion3.f());
                    float f4 = 24;
                    SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer3, 6);
                    IconKt.a(PainterResources_androidKt.c(R.drawable.Xa, composer3, 0), null, columnScopeInstance2.c(companion, companion2.g()), Color.f25715b.k(), composer3, 3120, 0);
                    SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer3, 6);
                    String strB = StringResources_androidKt.b(R.string.Bk, composer3, 0);
                    TextStyle textStyleG = ComposeTypographyKt.g(composer3, 0).g();
                    long jP = ComposeColorsKt.j(composer3, 0).p();
                    TextAlign.Companion companion4 = TextAlign.f29616b;
                    TextKt.c(strB, columnScopeInstance2.c(PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), companion2.g()), jP, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleG, composer3, 0, 0, 65016);
                    SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer3, 6);
                    TextKt.c(StringResources_androidKt.b(R.string.vC, composer3, 0), columnScopeInstance2.c(PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), companion2.g()), ComposeColorsKt.j(composer3, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer3, 0).a(), composer3, 0, 0, 65016);
                    SpacerKt.a(SizeKt.i(companion, Dp.g(32)), composer3, 6);
                    Modifier modifierK = PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null);
                    MeasurePolicy measurePolicyA4 = ColumnKt.a(arrangement.h(), companion2.k(), composer3, 0);
                    int iA4 = ComposablesKt.a(composer3, 0);
                    CompositionLocalMap compositionLocalMapU4 = composer3.u();
                    Modifier modifierF4 = ComposedModifierKt.f(composer3, modifierK);
                    Function0 function0A4 = companion3.a();
                    if (composer3.m() == null) {
                        ComposablesKt.c();
                    }
                    composer3.L();
                    if (composer3.i()) {
                        composer3.P(function0A4);
                    } else {
                        composer3.v();
                    }
                    Composer composerA4 = Updater.a(composer3);
                    Updater.e(composerA4, measurePolicyA4, companion3.e());
                    Updater.e(composerA4, compositionLocalMapU4, companion3.g());
                    Function2 function2B4 = companion3.b();
                    if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                        composerA4.w(Integer.valueOf(iA4));
                        composerA4.p(Integer.valueOf(iA4), function2B4);
                    }
                    Updater.e(composerA4, modifierF4, companion3.f());
                    ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.oF, composer3, 0), 0.0f, 11, null);
                    ButtonColor.Custom custom = new ButtonColor.Custom(false, null, false, Color.n(ComposeColorsKt.j(composer3, 0).p0()), null, null, 55, null);
                    boolean zI = composer3.I(context) | (i8 == 256);
                    Object objG3 = composer3.G();
                    if (zI || objG3 == Composer.f23746a.a()) {
                        objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.feedback.v
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FeedbackScreenKt.Y(function1, context);
                            }
                        };
                        composer3.w(objG3);
                    }
                    ComposeButtonsKt.i0(null, big, custom, (Function0) objG3, composer3, 0, 1);
                    composer3.y();
                    SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer3, 6);
                    composer3.y();
                    P0(columnScopeInstance2, StringResources_androidKt.b(R.string.ke, composer3, 0), PaddingKt.k(companion, 0.0f, Dp.g(f3), 1, null), ComposeColorsKt.j(composer3, 0).s(), composer3, 390, 0);
                    composer3.y();
                    composer3.U();
                    composer2 = composer3;
                } else {
                    ColumnScopeInstance columnScopeInstance3 = columnScopeInstance2;
                    composer3.a0(-1617559388);
                    if (feedbackViewState.j() == ContactReason.Other) {
                        composer3.a0(-1617698020);
                        i5 = 20;
                        P0(columnScopeInstance3, StringResources_androidKt.b(R.string.h8, composer3, 0), PaddingKt.j(companion, Dp.g(f3), Dp.g(8)), 0L, composer3, 390, 4);
                        composer3 = composer3;
                    } else {
                        i5 = 20;
                        composer3.a0(-1640972727);
                    }
                    composer3.U();
                    List listL = feedbackViewState.l();
                    if (listL == null) {
                        composer3.a0(-1617360803);
                        composer3.U();
                        columnScopeInstance = columnScopeInstance3;
                        unit = null;
                    } else {
                        composer3.a0(-1617360802);
                        final Context context2 = (Context) composer3.q(AndroidCompositionLocals_androidKt.g());
                        Modifier modifierM = PaddingKt.m(companion, 0.0f, Dp.g(14), 0.0f, 0.0f, 13, null);
                        MeasurePolicy measurePolicyA5 = ColumnKt.a(arrangement.h(), companion2.k(), composer3, 0);
                        int iA5 = ComposablesKt.a(composer3, 0);
                        CompositionLocalMap compositionLocalMapU5 = composer3.u();
                        Modifier modifierF5 = ComposedModifierKt.f(composer3, modifierM);
                        Function0 function0A5 = companion3.a();
                        if (composer3.m() == null) {
                            ComposablesKt.c();
                        }
                        composer3.L();
                        if (composer3.i()) {
                            composer3.P(function0A5);
                        } else {
                            composer3.v();
                        }
                        Composer composerA5 = Updater.a(composer3);
                        Updater.e(composerA5, measurePolicyA5, companion3.e());
                        Updater.e(composerA5, compositionLocalMapU5, companion3.g());
                        Function2 function2B5 = companion3.b();
                        if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                            composerA5.w(Integer.valueOf(iA5));
                            composerA5.p(Integer.valueOf(iA5), function2B5);
                        }
                        Updater.e(composerA5, modifierF5, companion3.f());
                        composer3.a0(1493318542);
                        Iterator it = listL.iterator();
                        while (it.hasNext()) {
                            final QuestionDTO questionDTO = (QuestionDTO) it.next();
                            Modifier.Companion companion5 = Modifier.b8;
                            Modifier modifierH = SizeKt.h(companion5, 0.0f, 1, null);
                            boolean zI2 = composer3.I(context2) | composer3.Z(questionDTO);
                            Object objG4 = composer3.G();
                            if (zI2 || objG4 == Composer.f23746a.a()) {
                                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.feedback.w
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FeedbackScreenKt.Z(context2, questionDTO);
                                    }
                                };
                                composer3.w(objG4);
                            }
                            Modifier modifierF6 = ClickableKt.f(modifierH, false, null, null, (Function0) objG4, 7, null);
                            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                            int iA6 = ComposablesKt.a(composer3, 0);
                            CompositionLocalMap compositionLocalMapU6 = composer3.u();
                            Modifier modifierF7 = ComposedModifierKt.f(composer3, modifierF6);
                            ComposeUiNode.Companion companion6 = ComposeUiNode.f8;
                            Iterator it2 = it;
                            Function0 function0A6 = companion6.a();
                            if (composer3.m() == null) {
                                ComposablesKt.c();
                            }
                            composer3.L();
                            if (composer3.i()) {
                                composer3.P(function0A6);
                            } else {
                                composer3.v();
                            }
                            Composer composerA6 = Updater.a(composer3);
                            Updater.e(composerA6, measurePolicyG, companion6.e());
                            Updater.e(composerA6, compositionLocalMapU6, companion6.g());
                            Function2 function2B6 = companion6.b();
                            if (composerA6.i() || !Intrinsics.areEqual(composerA6.G(), Integer.valueOf(iA6))) {
                                composerA6.w(Integer.valueOf(iA6));
                                composerA6.p(Integer.valueOf(iA6), function2B6);
                            }
                            Updater.e(composerA6, modifierF7, companion6.f());
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                            float f5 = 8;
                            Composer composer4 = composer3;
                            TextKt.c(questionDTO.c(), PaddingKt.l(companion5, Dp.g(f3), Dp.g(f5), Dp.g(f3), Dp.g(f5)), ComposeColorsKt.j(composer3, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer3, 0).d(), composer4, 0, 0, 65528);
                            composer3 = composer4;
                            composer3.y();
                            columnScopeInstance3 = columnScopeInstance3;
                            context2 = context2;
                            it = it2;
                        }
                        columnScopeInstance = columnScopeInstance3;
                        composer3.U();
                        composer3.y();
                        Unit unit2 = Unit.f139807a;
                        composer3.U();
                        unit = Unit.f139807a;
                    }
                    if (unit == null) {
                        composer3.a0(1194790274);
                        SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(f3)), composer3, 6);
                        composer3.U();
                    } else {
                        composer3.a0(1194752361);
                        composer3.U();
                    }
                    String strB2 = StringResources_androidKt.b(R.string.Nf, composer3, 0);
                    TextStyle textStyleH = ComposeTypographyKt.g(composer3, 0).h();
                    Modifier.Companion companion7 = Modifier.b8;
                    Composer composer5 = composer3;
                    TextKt.c(strB2, SizeKt.h(PaddingKt.m(companion7, Dp.g(f3), Dp.g(f3), Dp.g(f3), 0.0f, 8, null), 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleH, composer5, 0, 0, 65532);
                    String strW = W(mutableState);
                    float f6 = 8;
                    Modifier modifierK2 = SizeKt.k(PaddingKt.j(companion7, Dp.g(f3), Dp.g(f6)), Dp.g(100), 0.0f, 2, null);
                    long jL0 = ComposeColorsKt.j(composer5, 0).l0();
                    int i9 = R.dimen.f95478l;
                    Modifier modifierC2 = BackgroundKt.c(modifierK2, jL0, RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i9, composer5, 0)));
                    Alignment.Companion companion8 = Alignment.f25072a;
                    Modifier modifierH2 = SizeKt.h(columnScopeInstance.c(modifierC2, companion8.g()), 0.0f, 1, null);
                    RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i9, composer5, 0));
                    TextFieldColors textFieldColorsS0 = S0(feedbackViewState.n().contains(FeedbackViewState.FeedbackValidationError.MessageIsEmpty), composer5, 0, 0);
                    boolean Z2 = composer5.Z(mutableState) | (i8 == 256);
                    Object objG5 = composer5.G();
                    if (Z2 || objG5 == Composer.f23746a.a()) {
                        objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.x
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FeedbackScreenKt.a0(function1, mutableState, (String) obj);
                            }
                        };
                        composer5.w(objG5);
                    }
                    OutlinedTextFieldKt.c(strW, (Function1) objG5, modifierH2, false, false, null, null, ComposableSingletons$FeedbackScreenKt.f102040a.c(), null, null, false, null, null, null, false, 0, 0, null, roundedCornerShapeD, textFieldColorsS0, composer5, 12582912, 0, 262008);
                    Set setN = feedbackViewState.n();
                    FeedbackViewState.FeedbackValidationError feedbackValidationError = FeedbackViewState.FeedbackValidationError.EmailsDoNotMatch;
                    boolean z3 = setN.contains(feedbackValidationError) || feedbackViewState.n().contains(FeedbackViewState.FeedbackValidationError.EmailIsInvalid);
                    String strF = feedbackViewState.f();
                    String strB3 = StringResources_androidKt.b(R.string.Rc, composer5, 0);
                    Modifier modifierJ = PaddingKt.j(companion7, Dp.g(f3), Dp.g(f6));
                    boolean z4 = i8 == 256;
                    Object objG6 = composer5.G();
                    if (z4 || objG6 == Composer.f23746a.a()) {
                        objG6 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.y
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FeedbackScreenKt.b0(function1, (String) obj);
                            }
                        };
                        composer5.w(objG6);
                    }
                    boolean z5 = z3;
                    f0(modifierJ, strF, (Function1) objG6, strB3, z5, composer5, 0, 0);
                    String strE = feedbackViewState.e();
                    String strB4 = StringResources_androidKt.b(R.string.e8, composer5, 0);
                    Modifier modifierB = BringIntoViewRequesterKt.b(PaddingKt.j(companion7, Dp.g(f3), Dp.g(f6)), bringIntoViewRequester);
                    boolean z6 = i8 == 256;
                    Object objG7 = composer5.G();
                    if (z6 || objG7 == Composer.f23746a.a()) {
                        objG7 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.z
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FeedbackScreenKt.c0(function1, (String) obj);
                            }
                        };
                        composer5.w(objG7);
                    }
                    f0(modifierB, strE, (Function1) objG7, strB4, z5, composer5, 0, 0);
                    Composer composer6 = composer5;
                    if (z5) {
                        composer6.a0(-1613257890);
                        TextKt.c(StringResources_androidKt.b(feedbackViewState.n().contains(feedbackValidationError) ? R.string.yd : R.string.zd, composer6, 0), columnScopeInstance.c(PaddingKt.m(SizeKt.h(companion7, 0.0f, 1, null), 0.0f, 0.0f, Dp.g(f3), 0.0f, 11, null), companion8.j()), ComposeColorsKt.j(composer6, 0).k(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.b()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer6, 0).d(), composer6, 0, 0, 65016);
                        composer6 = composer6;
                    } else {
                        composer6.a0(-1640972727);
                    }
                    composer6.U();
                    Composer composer7 = composer6;
                    TextKt.c(StringResources_androidKt.b(R.string.S1, composer6, 0), SizeKt.h(PaddingKt.m(companion7, Dp.g(f3), Dp.g(f3), Dp.g(f3), 0.0f, 8, null), 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer6, 0).h(), composer7, 0, 0, 65532);
                    Composer composer8 = composer7;
                    if (feedbackViewState.n().contains(FeedbackViewState.FeedbackValidationError.AttachmentSizeExceeded)) {
                        composer8.a0(-1612226272);
                        TextKt.c(StringResources_androidKt.c(R.string.Hj, new Object[]{Integer.valueOf(i5)}, composer8, 0), SizeKt.h(PaddingKt.m(companion7, Dp.g(f3), 0.0f, Dp.g(f3), 0.0f, 10, null), 0.0f, 1, null), ComposeColorsKt.j(composer8, 0).k(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer8, 0).d(), composer8, 48, 0, 65528);
                        composer8 = composer8;
                    } else {
                        composer8.a0(-1640972727);
                    }
                    composer8.U();
                    ButtonType.TinyRound tinyRound = new ButtonType.TinyRound(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95554q0, composer8, 6), Color.n(ComposeColorsKt.j(composer8, 0).b()), StringResources_androidKt.b(R.string.M, composer8, 0), null);
                    ButtonColor.Surface surface = new ButtonColor.Surface(false, Color.n(ComposeColorsKt.j(composer8, 0).l0()), false, null, Color.n(ComposeColorsKt.j(composer8, 0).b()), 13, null);
                    Modifier modifierC3 = columnScopeInstance.c(PaddingKt.l(companion7, Dp.g(f3), Dp.g(f3), Dp.g(f3), Dp.g(f3)), companion8.k());
                    boolean zI3 = composer8.I(managedActivityResultLauncherA);
                    Object objG8 = composer8.G();
                    if (zI3 || objG8 == Composer.f23746a.a()) {
                        objG8 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.feedback.a0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FeedbackScreenKt.d0(managedActivityResultLauncherA);
                            }
                        };
                        composer8.w(objG8);
                    }
                    ComposeButtonsKt.i0(modifierC3, tinyRound, surface, (Function0) objG8, composer8, 0, 0);
                    composer2 = composer8;
                    Iterator<E> it3 = feedbackViewState.d().iterator();
                    while (it3.hasNext()) {
                        N(PaddingKt.m(Modifier.b8, Dp.g(f3), 0.0f, Dp.g(f3), Dp.g(f3), 2, null), (FeedbackViewState.FreshdeskAttachment) it3.next(), function1, composer2, i8 | 6, 0);
                        f3 = f3;
                        i8 = i8;
                    }
                    composer2.U();
                }
                composer2.U();
            }
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeedbackScreenKt.e0(paddingValues, feedbackViewState, function1, scaffoldState, scrollState, bringIntoViewRequester, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() == -1) {
            Intent intentC = it.c();
            function1.invoke(new FeedbackViewEvent.OnAddAttachmentClicked(intentC != null ? intentC.getData() : null));
        }
        return Unit.f139807a;
    }

    private static final String W(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    private static final void X(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(Function1 function1, Context context) {
        function1.invoke(FeedbackViewEvent.SaveEmergencyEntrance.f102080a);
        context.startActivity(new Intent(context, (Class<?>) EmergencyUnblockActivity.class));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(Context context, QuestionDTO questionDTO) {
        context.startActivity(HaFActivity.f107547f.a(context, questionDTO));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(Function1 function1, MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        X(mutableState, it);
        function1.invoke(new FeedbackViewEvent.OnMessageChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new FeedbackViewEvent.OnEmailChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new FeedbackViewEvent.OnEmailConfirmedChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(ManagedActivityResultLauncher managedActivityResultLauncher) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        managedActivityResultLauncher.b(intent);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(PaddingValues paddingValues, FeedbackViewState feedbackViewState, Function1 function1, ScaffoldState scaffoldState, ScrollState scrollState, BringIntoViewRequester bringIntoViewRequester, int i3, Composer composer, int i4) {
        U(paddingValues, feedbackViewState, function1, scaffoldState, scrollState, bringIntoViewRequester, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void f0(Modifier modifier, final String textValue, final Function1 onTextChanged, final String placeholderText, final boolean z2, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        boolean z3;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(textValue, "textValue");
        Intrinsics.checkNotNullParameter(onTextChanged, "onTextChanged");
        Intrinsics.checkNotNullParameter(placeholderText, "placeholderText");
        Composer composerK = composer.k(689936128);
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
            i5 |= composerK.Z(textValue) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(onTextChanged) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.Z(placeholderText) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            z3 = z2;
            i5 |= composerK.b(z3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            z3 = z2;
        }
        if (composerK.r((i5 & 9363) != 9362, i5 & 1)) {
            final Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(689936128, i5, -1, "cz.mobilesoft.coreblock.scene.feedback.EmailTextField (FeedbackScreen.kt:844)");
            }
            boolean z4 = (i5 & 112) == 32;
            Object objG = composerK.G();
            if (z4 || objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(textValue, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            final boolean z5 = z3;
            CompositionLocalKt.b(CompositionLocalsKt.r().d(EmptyTextToolbar.f102043a), ComposableLambdaKt.e(416676416, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeedbackScreenKt.i0(modifier4, z5, mutableState, onTextChanged, placeholderText, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, ProvidedValue.f24012i | 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier4;
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeedbackScreenKt.m0(modifier3, textValue, onTextChanged, placeholderText, z2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String g0(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    private static final void h0(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(Modifier modifier, final boolean z2, final MutableState mutableState, final Function1 function1, final String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(416676416, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.EmailTextField.<anonymous> (FeedbackScreen.kt:851)");
            }
            String strG0 = g0(mutableState);
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, null, KeyboardType.f29379b.c(), 0, null, null, null, 123, null);
            long jL0 = ComposeColorsKt.j(composer, 0).l0();
            int i4 = R.dimen.f95480n;
            Modifier modifierH = SizeKt.h(BackgroundKt.c(modifier, jL0, RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i4, composer, 0))), 0.0f, 1, null);
            RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i4, composer, 0));
            TextFieldColors textFieldColorsS0 = S0(z2, composer, 0, 0);
            boolean Z = composer.Z(mutableState) | composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.p0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FeedbackScreenKt.j0(function1, mutableState, (String) obj);
                    }
                };
                composer.w(objG);
            }
            OutlinedTextFieldKt.c(strG0, (Function1) objG, modifierH, false, false, null, null, ComposableLambdaKt.e(-318871705, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.q0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeedbackScreenKt.k0(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableLambdaKt.e(-195967768, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.r0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeedbackScreenKt.l0(z2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, false, null, keyboardOptions, null, true, 1, 0, null, roundedCornerShapeD, textFieldColorsS0, composer, 113246208, 221568, 208504);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(Function1 function1, MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        h0(mutableState, it);
        function1.invoke(it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-318871705, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.EmailTextField.<anonymous>.<anonymous> (FeedbackScreen.kt:873)");
            }
            TextKt.c(str, null, ComposeColorsKt.j(composer, 0).s(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(boolean z2, Composer composer, int i3) {
        long jS;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-195967768, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.EmailTextField.<anonymous>.<anonymous> (FeedbackScreen.kt:865)");
            }
            Painter painterC = PainterResources_androidKt.c(R.drawable.G3, composer, 0);
            if (z2) {
                composer.a0(653543600);
                jS = ComposeColorsKt.j(composer, 0).k();
            } else {
                composer.a0(653544277);
                jS = ComposeColorsKt.j(composer, 0).s();
            }
            composer.U();
            IconKt.a(painterC, null, null, jS, composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(Modifier modifier, String str, Function1 function1, String str2, boolean z2, int i3, int i4, Composer composer, int i5) {
        f0(modifier, str, function1, str2, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void n0(final cz.mobilesoft.coreblock.enums.ContactReason r23, boolean r24, boolean r25, final kotlin.jvm.functions.Function0 r26, final java.lang.String r27, final java.lang.String r28, final kotlin.jvm.functions.Function0 r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 589
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.feedback.FeedbackScreenKt.n0(cz.mobilesoft.coreblock.enums.ContactReason, boolean, boolean, kotlin.jvm.functions.Function0, java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder o0(ContactReason contactReason, boolean z2, boolean z3, String str, String str2) {
        return ParametersHolderKt.b(contactReason, Boolean.valueOf(z2), Boolean.valueOf(z3), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(ContactReason contactReason, boolean z2, boolean z3, Function0 function0, String str, String str2, Function0 function02, int i3, int i4, Composer composer, int i5) {
        n0(contactReason, z2, z3, function0, str, str2, function02, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [cz.mobilesoft.coreblock.scene.feedback.FeedbackScreenKt$InternetApiErrorContent$uriHandler$1] */
    public static final void r0(final boolean z2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1884243213);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1884243213, i4, -1, "cz.mobilesoft.coreblock.scene.feedback.InternetApiErrorContent (FeedbackScreen.kt:764)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            final ?? r02 = new UriHandler() { // from class: cz.mobilesoft.coreblock.scene.feedback.FeedbackScreenKt$InternetApiErrorContent$uriHandler$1
                @Override // androidx.compose.ui.platform.UriHandler
                public void openUri(String uri) {
                    Intrinsics.checkNotNullParameter(uri, "uri");
                    RunnabilityHelper.V(context, 0, null, true, null, false, "feedback", 54, null);
                }
            };
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            Boolean boolValueOf = Boolean.valueOf(s0(mutableState));
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new FeedbackScreenKt$InternetApiErrorContent$1$1(mutableState, null);
                composerK.w(objG2);
            }
            EffectsKt.g(boolValueOf, (Function2) objG2, composerK, 0);
            AnimatedVisibilityKt.j(s0(mutableState), null, EnterExitTransitionKt.o(AnimationSpecKt.n(AdError.SERVER_ERROR_CODE, 0, null, 6, null), 0.0f, 2, null), EnterExitTransitionKt.q(AnimationSpecKt.n(AdError.SERVER_ERROR_CODE, 0, null, 6, null), 0.0f, 2, null), null, ComposableLambdaKt.e(-382326501, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.feedback.b0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FeedbackScreenKt.u0(z2, r02, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 200064, 18);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeedbackScreenKt.w0(z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean s0(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(boolean z2, final FeedbackScreenKt$InternetApiErrorContent$uriHandler$1 feedbackScreenKt$InternetApiErrorContent$uriHandler$1, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(-382326501, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.InternetApiErrorContent.<anonymous> (FeedbackScreen.kt:786)");
        }
        Modifier.Companion companion = Modifier.b8;
        Modifier modifierD = BackgroundKt.d(SizeKt.f(companion, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).e(), null, 2, null);
        Alignment.Companion companion2 = Alignment.f25072a;
        MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
        int iA = ComposablesKt.a(composer, 0);
        CompositionLocalMap compositionLocalMapU = composer.u();
        Modifier modifierF = ComposedModifierKt.f(composer, modifierD);
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
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
        Modifier modifierF2 = boxScopeInstance.f(companion, companion2.m());
        MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.k(), composer, 0);
        int iA2 = ComposablesKt.a(composer, 0);
        CompositionLocalMap compositionLocalMapU2 = composer.u();
        Modifier modifierF3 = ComposedModifierKt.f(composer, modifierF2);
        Function0 function0A2 = companion3.a();
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
        Updater.e(composerA2, measurePolicyA, companion3.e());
        Updater.e(composerA2, compositionLocalMapU2, companion3.g());
        Function2 function2B2 = companion3.b();
        if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
            composerA2.w(Integer.valueOf(iA2));
            composerA2.p(Integer.valueOf(iA2), function2B2);
        }
        Updater.e(composerA2, modifierF3, companion3.f());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
        float f3 = 16;
        TextKt.c(StringResources_androidKt.b(z2 ? R.string.Rv : R.string.Vk, composer, 0), SizeKt.h(PaddingKt.m(companion, Dp.g(f3), 0.0f, Dp.g(f3), Dp.g(12), 2, null), 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 48, 0, 65020);
        int i4 = z2 ? R.string.KE : R.string.w7;
        String strK1 = PrefManager.f126839a.k1();
        if (strK1 == null) {
            strK1 = "";
        }
        final String string = HtmlCompat.a(StringResources_androidKt.c(i4, new Object[]{strK1}, composer, 0), 63).toString();
        CompositionLocalKt.b(CompositionLocalsKt.s().d(feedbackScreenKt$InternetApiErrorContent$uriHandler$1), ComposableLambdaKt.e(448325087, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.o
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FeedbackScreenKt.v0(string, feedbackScreenKt$InternetApiErrorContent$uriHandler$1, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), composer, ProvidedValue.f24012i | 48);
        composer.y();
        ImageKt.a(PainterResources_androidKt.c(z2 ? R.drawable.f95520h2 : R.drawable.S3, composer, 0), null, boxScopeInstance.f(companion, companion2.e()), null, null, 0.0f, null, composer, 48, 120);
        composer.y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(String str, FeedbackScreenKt$InternetApiErrorContent$uriHandler$1 feedbackScreenKt$InternetApiErrorContent$uriHandler$1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(448325087, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.InternetApiErrorContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FeedbackScreen.kt:812)");
            }
            cz.mobilesoft.coreblock.view.TextKt.h(str, SizeKt.h(PaddingKt.k(Modifier.b8, Dp.g(16), 0.0f, 2, null), 0.0f, 1, null), ComposeTypographyKt.g(composer, 0).a(), ComposeColorsKt.j(composer, 0).q(), TextAlign.h(TextAlign.f29616b.a()), 0, null, null, new SpanStyle(ComposeColorsKt.j(composer, 0).b(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null), feedbackScreenKt$InternetApiErrorContent$uriHandler$1, composer, 48, 224);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(boolean z2, int i3, Composer composer, int i4) {
        r0(z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void x0(final ScaffoldState scaffoldState, final FeedbackViewState feedbackViewState, final ScrollState scrollState, final Function1 function1, final Function0 function0, Composer composer, final int i3) {
        int i4;
        ScrollState scrollState2;
        Composer composer2;
        Composer composerK = composer.k(-1524725554);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(scaffoldState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(feedbackViewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            scrollState2 = scrollState;
            i4 |= composerK.Z(scrollState2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            scrollState2 = scrollState;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        int i5 = i4;
        if (composerK.r((i5 & 9363) != 9362, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1524725554, i5, -1, "cz.mobilesoft.coreblock.scene.feedback.RootCompose (FeedbackScreen.kt:256)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = BringIntoViewRequesterKt.a();
                composerK.w(objG2);
            }
            final BringIntoViewRequester bringIntoViewRequester = (BringIntoViewRequester) objG2;
            Set setN = feedbackViewState.n();
            boolean zI = ((i5 & 112) == 32) | composerK.I(coroutineScope) | composerK.I(bringIntoViewRequester);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                objG3 = new FeedbackScreenKt$RootCompose$1$1(feedbackViewState, coroutineScope, bringIntoViewRequester, null);
                composerK.w(objG3);
            }
            EffectsKt.g(setN, (Function2) objG3, composerK, 0);
            final ScrollState scrollState3 = scrollState2;
            composer2 = composerK;
            ScaffoldKt.a(PaddingKt.k(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composerK, 6)), PrimitiveResources_androidKt.a(R.dimen.f95486t, composerK, 0), 0.0f, 2, null), scaffoldState, ComposableLambdaKt.e(-1828895959, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeedbackScreenKt.y0(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(-1574506552, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeedbackScreenKt.z0(feedbackViewState, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableSingletons$FeedbackScreenKt.f102040a.d(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(978581200, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.feedback.l
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FeedbackScreenKt.B0(feedbackViewState, function1, scaffoldState, scrollState3, bringIntoViewRequester, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, ((i5 << 3) & 112) | 28032, 12582912, 131040);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.feedback.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeedbackScreenKt.C0(scaffoldState, feedbackViewState, scrollState, function1, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(Function0 function0, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1828895959, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.RootCompose.<anonymous> (FeedbackScreen.kt:278)");
            }
            M0(function0, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(final FeedbackViewState feedbackViewState, final Function1 function1, Composer composer, int i3) {
        int i4;
        Composer composer2 = composer;
        if (composer2.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1574506552, i3, -1, "cz.mobilesoft.coreblock.scene.feedback.RootCompose.<anonymous> (FeedbackScreen.kt:333)");
            }
            if (feedbackViewState.k() || feedbackViewState.j() == null) {
                composer2.a0(-801303462);
            } else {
                composer2.a0(-786699362);
                Modifier.Companion companion = Modifier.b8;
                float f3 = 16;
                Modifier modifierI = PaddingKt.i(companion, Dp.g(f3));
                MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer2, 0);
                int iA = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU = composer2.u();
                Modifier modifierF = ComposedModifierKt.f(composer2, modifierI);
                ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                Function0 function0A = companion2.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A);
                } else {
                    composer2.v();
                }
                Composer composerA = Updater.a(composer2);
                Updater.e(composerA, measurePolicyA, companion2.e());
                Updater.e(composerA, compositionLocalMapU, companion2.g());
                Function2 function2B = companion2.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion2.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                if (feedbackViewState.j() != ContactReason.FeatureSuggestion) {
                    composer2.a0(-84737473);
                    i4 = -99572213;
                    TextKt.c(StringResources_androidKt.b(R.string.le, composer2, 0), PaddingKt.m(SizeKt.h(companion, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null), ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).d(), composer, 48, 0, 65016);
                    composer2 = composer;
                } else {
                    i4 = -99572213;
                    composer2.a0(-99572213);
                }
                composer2.U();
                int i5 = (feedbackViewState.n().contains(FeedbackViewState.FeedbackValidationError.NoInternetConnection) || feedbackViewState.n().contains(FeedbackViewState.FeedbackValidationError.ApiError)) ? R.string.Ks : R.string.Pv;
                if (feedbackViewState.j() == ContactReason.EmergencyUnblocking && feedbackViewState.m()) {
                    composer2.a0(i4);
                } else {
                    composer2.a0(-83746961);
                    ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(i5, composer2, 0), 0.0f, 11, null);
                    ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
                    boolean Z = composer2.Z(feedbackViewState) | composer2.Z(function1);
                    Object objG = composer2.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.feedback.r
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FeedbackScreenKt.A0(feedbackViewState, function1);
                            }
                        };
                        composer2.w(objG);
                    }
                    ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composer2, 0, 1);
                }
                composer2.U();
                composer2.y();
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }
}
