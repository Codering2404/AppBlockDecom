package cz.mobilesoft.coreblock.scene.more.haf;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.ImageKt;
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
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.AppBarKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextFieldDefaults;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.facebook.appevents.AppEventsConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.dto.CategoryDTO;
import cz.mobilesoft.coreblock.dto.HaFQuestionResponse;
import cz.mobilesoft.coreblock.dto.QuestionDTO;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesSectionKt;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackActivity;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackScreenKt;
import cz.mobilesoft.coreblock.scene.more.haf.HaFActivity;
import cz.mobilesoft.coreblock.scene.more.haf.HaFViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.detail.ConflictingSchedulesExplanationActivity;
import cz.mobilesoft.coreblock.scene.schedule.detail.DetailScreenKt;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeTextFieldsKt;
import cz.mobilesoft.coreblock.view.compose.SectionedItemKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.scope.Scope;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class HaFActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f107547f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f107548g = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, QuestionDTO questionDTO, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                questionDTO = null;
            }
            return companion.a(context, questionDTO);
        }

        public final Intent a(Context context, QuestionDTO questionDTO) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) HaFActivity.class);
            intent.putExtra("HAF_PRESELECTED_QUESTION", questionDTO);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LinkWebViewClient extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f107552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function1 f107553b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final HaFViewState f107554c;

        public LinkWebViewClient(Context context, Function1 onEvent, HaFViewState viewState) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(onEvent, "onEvent");
            Intrinsics.checkNotNullParameter(viewState, "viewState");
            this.f107552a = context;
            this.f107553b = onEvent;
            this.f107554c = viewState;
        }

        private final boolean b(String str) {
            if (!StringsKt.a0(str, "faq-in-app-feedback", false, 2, null) && !StringsKt.a0(str, "appblock.app/contact", false, 2, null)) {
                if (!StringsKt.a0(str, "appblock.app/", false, 2, null)) {
                    ExternalLinksHelper.f127866a.d(this.f107552a, str);
                    return true;
                }
                QuestionDTO questionDTOK = this.f107554c.k(c(str));
                if (questionDTOK != null) {
                    this.f107553b.invoke(new HaFViewEvent.OnQuestionSelected(questionDTOK, this.f107554c.f()));
                    return true;
                }
                Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
                builderBuildUpon.appendQueryParameter("inapp", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                ExternalLinksHelper externalLinksHelper = ExternalLinksHelper.f127866a;
                Context context = this.f107552a;
                String string = builderBuildUpon.build().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                externalLinksHelper.d(context, string);
                return true;
            }
            if (this.f107554c.n()) {
                Context context2 = this.f107552a;
                context2.startActivity(FeedbackActivity.Companion.b(FeedbackActivity.f102045f, context2, null, null, null, "question_detail", null, false, 110, null));
                return true;
            }
            ContactReason contactReason = StringsKt.a0(str, "reason=premium", false, 2, null) ? ContactReason.ProblemsWithPremium : StringsKt.a0(str, "reason=blocking-problem", false, 2, null) ? ContactReason.ProblemsWithBlocking : StringsKt.a0(str, "reason=unlock-code", false, 2, null) ? ContactReason.EmergencyUnblocking : StringsKt.a0(str, "reason=feature_suggestion", false, 2, null) ? ContactReason.FeatureSuggestion : ContactReason.Other;
            Context context3 = this.f107552a;
            FeedbackActivity.Companion companion = FeedbackActivity.f102045f;
            HaFQuestionResponse haFQuestionResponseE = this.f107554c.e();
            Integer numValueOf = haFQuestionResponseE != null ? Integer.valueOf(haFQuestionResponseE.b()) : null;
            QuestionDTO questionDTOF = this.f107554c.f();
            context3.startActivity(FeedbackActivity.Companion.b(companion, context3, contactReason, numValueOf, questionDTOF != null ? questionDTOF.b() : null, "question_detail", null, false, 96, null));
            if (this.f107554c.h() == null) {
                return true;
            }
            this.f107553b.invoke(HaFViewEvent.OnResetPresetQuestion.f107599a);
            Context context4 = this.f107552a;
            Intrinsics.checkNotNull(context4, "null cannot be cast to non-null type cz.mobilesoft.coreblock.scene.more.haf.HaFActivity");
            ((HaFActivity) context4).finish();
            return true;
        }

        private final String c(String str) {
            return (String) CollectionsKt.firstOrNull(CollectionsKt.drop(SequencesKt.S(SequencesKt.G(Regex.g(new Regex("https://appblock\\.app/([\\w-]*)/?"), str, 0, 2, null), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.haf.w0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HaFActivity.LinkWebViewClient.d((MatchResult) obj);
                }
            })), 1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Iterable d(MatchResult it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.b();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return b(String.valueOf(webResourceRequest != null ? webResourceRequest.getUrl() : null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A1(Function1 function1, MutableState mutableState) {
        s1(mutableState, "");
        function1.invoke(new HaFViewEvent.OnSearchQueryChanged(""));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B1(List list, LazyItemScope item, Composer composer, int i3) {
        String strB;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1860104862, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.MainContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HaFActivity.kt:305)");
            }
            if (list.isEmpty()) {
                composer.a0(854380134);
                strB = StringResources_androidKt.b(R.string.el, composer, 0);
                composer.U();
            } else {
                composer.a0(-816742225);
                composer.U();
                strB = "Results";
            }
            TextKt.c(strB, PaddingKt.m(Modifier.b8, Dp.g(8), 0.0f, 0.0f, 0.0f, 14, null), ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 48, 0, 65528);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C1(List list, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-718623275, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.MainContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HaFActivity.kt:313)");
            }
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Function3 function3 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.g0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return HaFActivity.D1((QuestionDTO) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.haf.h0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return HaFActivity.E1(function1, (QuestionDTO) obj, ((Integer) obj2).intValue());
                    }
                };
                composer.w(objG);
            }
            SectionedItemKt.f0(list, function3, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, null, null, 0L, null, null, 0L, null, null, (Function2) objG, composer, 0, 0, 0, 16777214);
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
    public static final String D1(QuestionDTO it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-1772515783);
        if (ComposerKt.M()) {
            ComposerKt.U(-1772515783, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.MainContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HaFActivity.kt:318)");
        }
        String strC = it.c();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E1(Function1 function1, QuestionDTO item, int i3) {
        Intrinsics.checkNotNullParameter(item, "item");
        function1.invoke(new HaFViewEvent.OnQuestionSelected(item, null, 2, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F1(HaFViewState haFViewState, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-449594307, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.MainContent.<anonymous>.<anonymous>.<anonymous> (HaFActivity.kt:337)");
            }
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            List listC = haFViewState.c();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listC) {
                if (!((CategoryDTO) obj).c().isEmpty()) {
                    arrayList.add(obj);
                }
            }
            Function3 function3 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.m0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return HaFActivity.G1((CategoryDTO) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            };
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.haf.n0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return HaFActivity.H1(function1, (CategoryDTO) obj2, ((Integer) obj3).intValue());
                    }
                };
                composer.w(objG);
            }
            SectionedItemKt.f0(arrayList, function3, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, null, null, 0L, null, null, 0L, null, null, (Function2) objG, composer, 0, 0, 0, 16777214);
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
    public static final String G1(CategoryDTO it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-1117813951);
        if (ComposerKt.M()) {
            ComposerKt.U(-1117813951, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.MainContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HaFActivity.kt:342)");
        }
        String strO = StringsKt.a0(it.b(), "&amp;", false, 2, null) ? StringsKt.O(it.b(), "&amp;", "&", false, 4, null) : it.b();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H1(Function1 function1, CategoryDTO item, int i3) {
        Intrinsics.checkNotNullParameter(item, "item");
        function1.invoke(new HaFViewEvent.OnCategorySelected(item));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I1(final Function1 function1, LazyItemScope item, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-640706921, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.MainContent.<anonymous>.<anonymous>.<anonymous> (HaFActivity.kt:350)");
            }
            String strB = StringResources_androidKt.b(R.string.i8, composer, 0);
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.t2, composer, 6);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.haf.i0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HaFActivity.J1(function1);
                    }
                };
                composer.w(objG);
            }
            SectionedItemKt.G(null, strB, null, null, null, null, imageVectorB, null, null, false, 0L, 0L, null, false, (Function0) objG, false, null, 0L, composer, 0, 3072, 237501);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J1(Function1 function1) {
        function1.invoke(HaFViewEvent.OnContactSupportClicked.f107596a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K1(final HaFActivity haFActivity, LazyItemScope item, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(541525814, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.MainContent.<anonymous>.<anonymous>.<anonymous> (HaFActivity.kt:359)");
            }
            String strB = StringResources_androidKt.b(R.string.Di, composer, 0);
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.w5, composer, 6);
            boolean zI = composer.I(haFActivity);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.haf.f0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HaFActivity.L1(this.f107650a);
                    }
                };
                composer.w(objG);
            }
            SectionedItemKt.G(null, strB, null, null, null, null, imageVectorB, null, null, false, 0L, 0L, null, false, (Function0) objG, false, null, 0L, composer, 0, 3072, 237501);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L1(HaFActivity haFActivity) {
        haFActivity.startActivity(new Intent(haFActivity, (Class<?>) ConflictingSchedulesExplanationActivity.class));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M1(HaFActivity haFActivity, PaddingValues paddingValues, HaFViewState haFViewState, Function1 function1, int i3, Composer composer, int i4) {
        haFActivity.q1(paddingValues, haFViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder N1(HaFActivity haFActivity) {
        return ParametersHolderKt.b(haFActivity.Y1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O1(HaFViewState haFViewState, Function1 function1, HaFActivity haFActivity) {
        if (haFViewState.e() != null) {
            if (haFViewState.i() != null) {
                function1.invoke(new HaFViewEvent.OnCategorySelected(null));
                function1.invoke(HaFViewEvent.OnResetPresetQuestion.f107599a);
                haFActivity.finish();
            } else {
                function1.invoke(new HaFViewEvent.OnQuestionSelected(null, null, 2, null));
            }
        } else if (haFViewState.d() != null) {
            function1.invoke(new HaFViewEvent.OnCategorySelected(null));
        } else {
            function1.invoke(HaFViewEvent.ClearSearchQuery.f107593a);
            function1.invoke(HaFViewEvent.OnResetPresetQuestion.f107599a);
            haFActivity.finish();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P1(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q1(HaFViewState haFViewState, HaFActivity haFActivity, Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1906005403, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.RootCompose.<anonymous> (HaFActivity.kt:141)");
            }
            if (Intrinsics.areEqual(haFViewState.g(), Loading.f127895a)) {
                composer.a0(-1955595409);
                DetailScreenKt.L0(true, composer, 6, 0);
                composer.U();
            } else {
                composer.a0(-1955500084);
                haFActivity.l1(function0, composer, 0);
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
    public static final Unit R1(HaFViewState haFViewState, final Function1 function1, Composer composer, int i3) {
        Composer composer2;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1633569116, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.RootCompose.<anonymous> (HaFActivity.kt:181)");
            }
            if (Intrinsics.areEqual(haFViewState.g(), new FailedWithError(null, null, null, null, 15, null))) {
                composer.a0(-616804303);
                float f3 = 16;
                Modifier modifierJ = PaddingKt.j(Modifier.b8, Dp.g(f3), Dp.g(f3));
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                int iA = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU = composer.u();
                Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
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
                ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Ks, composer, 0), 0.0f, 11, null);
                ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
                boolean Z = composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.haf.n
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HaFActivity.S1(function1);
                        }
                    };
                    composer.w(objG);
                }
                composer2 = composer;
                ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composer2, 0, 1);
                composer2.y();
            } else {
                composer2 = composer;
                composer2.a0(-625013754);
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S1(Function1 function1) {
        function1.invoke(HaFViewEvent.OnRetryClicked.f107600a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T1(HaFViewState haFViewState, HaFActivity haFActivity, Function1 function1, PaddingValues innerPaddingValues, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(innerPaddingValues, "innerPaddingValues");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(innerPaddingValues) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(118734676, i4, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.RootCompose.<anonymous> (HaFActivity.kt:150)");
            }
            if (Intrinsics.areEqual(haFViewState.g(), Loading.f127895a)) {
                composer.a0(-1828204300);
                SchedulesSectionKt.D(0.0f, 5, composer, 48, 1);
                composer.U();
            } else if (Intrinsics.areEqual(haFViewState.g(), new FailedWithError(null, null, null, null, 15, null))) {
                composer.a0(-1828042356);
                FeedbackScreenKt.r0(true, composer, 6);
                composer.U();
            } else if (haFViewState.h() != null) {
                composer.a0(-1827883078);
                haFActivity.h1(haFViewState.h(), function1, haFViewState, composer, 0);
                composer.U();
            } else if (haFViewState.e() != null) {
                composer.a0(-1827675750);
                haFActivity.h1(haFViewState.e(), function1, haFViewState, composer, 0);
                composer.U();
            } else if (haFViewState.d() != null) {
                composer.a0(-1827463710);
                haFActivity.Y0(innerPaddingValues, haFViewState.d(), function1, composer, (i4 & 14) | (CategoryDTO.f96915a << 3));
                composer.U();
            } else {
                composer.a0(-1827131669);
                FeedbackScreenKt.r0(true, composer, 6);
                haFActivity.q1(innerPaddingValues, haFViewState, function1, composer, i4 & 14);
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
    public static final Unit U1(HaFActivity haFActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        haFActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void Y0(final PaddingValues paddingValues, final CategoryDTO categoryDTO, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-1480960557);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(categoryDTO) : composerK.I(categoryDTO) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1480960557, i4, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.CategoryDetail (HaFActivity.kt:385)");
            }
            Modifier modifierF = SizeKt.f(PaddingKt.k(PaddingKt.h(BackgroundKt.d(Modifier.b8, ComposeColorsKt.j(composerK, 0).e(), null, 2, null), paddingValues), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), 0.0f, 1, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(16));
            boolean z2 = ((i4 & 112) == 32 || ((i4 & 64) != 0 && composerK.I(categoryDTO))) | ((i4 & 896) == 256);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.haf.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HaFActivity.Z0(categoryDTO, function1, (LazyListScope) obj);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            LazyDslKt.b(modifierF, null, null, false, horizontalOrVerticalO, null, null, false, null, (Function1) objG, composer2, 24576, 494);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.haf.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HaFActivity.e1(this.f107680a, paddingValues, categoryDTO, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(final CategoryDTO categoryDTO, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(-234305442, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.a0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return HaFActivity.a1(categoryDTO, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(-440329913, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.b0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return HaFActivity.b1(categoryDTO, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.c(LazyColumn, null, null, ComposableSingletons$HaFActivityKt.f107538a.p(), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(CategoryDTO categoryDTO, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-234305442, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.CategoryDetail.<anonymous>.<anonymous>.<anonymous> (HaFActivity.kt:395)");
            }
            TextKt.c(StringsKt.a0(categoryDTO.b(), "&amp;", false, 2, null) ? StringsKt.O(categoryDTO.b(), "&amp;", "&", false, 4, null) : categoryDTO.b(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 0, 0, 65534);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(CategoryDTO categoryDTO, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-440329913, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.CategoryDetail.<anonymous>.<anonymous>.<anonymous> (HaFActivity.kt:402)");
            }
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            List listC = categoryDTO.c();
            Function3 function3 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.c0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return HaFActivity.c1((QuestionDTO) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.haf.d0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return HaFActivity.d1(function1, (QuestionDTO) obj, ((Integer) obj2).intValue());
                    }
                };
                composer.w(objG);
            }
            SectionedItemKt.f0(listC, function3, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, null, null, 0L, null, null, 0L, null, null, (Function2) objG, composer, 0, 0, 0, 16777214);
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
    public static final String c1(QuestionDTO it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(1053991011);
        if (ComposerKt.M()) {
            ComposerKt.U(1053991011, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.CategoryDetail.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HaFActivity.kt:407)");
        }
        String strC = it.c();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(Function1 function1, QuestionDTO item, int i3) {
        Intrinsics.checkNotNullParameter(item, "item");
        function1.invoke(new HaFViewEvent.OnQuestionSelected(item, null, 2, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(HaFActivity haFActivity, PaddingValues paddingValues, CategoryDTO categoryDTO, Function1 function1, int i3, Composer composer, int i4) {
        haFActivity.Y0(paddingValues, categoryDTO, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(HaFActivity haFActivity, HaFViewModel haFViewModel, int i3, Composer composer, int i4) {
        haFActivity.f1(haFViewModel, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebView i1(Function1 function1, HaFViewState haFViewState, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WebView webView = new WebView(context);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new LinkWebViewClient(context, function1, haFViewState));
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        return webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j1(HaFActivity haFActivity, HaFQuestionResponse haFQuestionResponse, boolean z2, WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        HaFRequestHelper haFRequestHelper = HaFRequestHelper.f107559a;
        Context applicationContext = haFActivity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        webView.loadDataWithBaseURL(null, haFRequestHelper.n(applicationContext, haFQuestionResponse.a(), haFQuestionResponse.c(), z2), "text/html", "utf-8", null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(HaFActivity haFActivity, HaFQuestionResponse haFQuestionResponse, Function1 function1, HaFViewState haFViewState, int i3, Composer composer, int i4) {
        haFActivity.h1(haFQuestionResponse, function1, haFViewState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1272475653, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.HaFToolbar.<anonymous> (HaFActivity.kt:460)");
            }
            ComposeButtonsKt.q0(null, VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.G0, composer, 6), null, false, 0.0f, 0.0f, 0L, StringResources_androidKt.b(R.string.Re, composer, 0), function0, composer, 0, 125);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(HaFActivity haFActivity, Function0 function0, int i3, Composer composer, int i4) {
        haFActivity.l1(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void o1(Composer composer, final int i3) {
        Composer composer2;
        Composer composerK = composer.k(1611464246);
        int i4 = i3 & 1;
        if (composerK.r(i4 != 0, i4)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1611464246, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.Header (HaFActivity.kt:423)");
            }
            float f3 = 8;
            Modifier modifierM = PaddingKt.m(SizeKt.h(Modifier.b8, 0.0f, 1, null), 0.0f, PrimitiveResources_androidKt.a(R.dimen.f95468b, composerK, 0), Dp.g(f3), Dp.g(f3), 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.e(), Alignment.f25072a.l(), composerK, 54);
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composer2 = composerK;
            TextKt.c(StringResources_androidKt.b(R.string.mf, composerK, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).f(), composer2, 0, 0, 65534);
            ImageKt.a(PainterResources_androidKt.c(R.drawable.p7, composer2, 0), "", null, null, null, 0.0f, null, composer2, 48, 124);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.haf.j0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HaFActivity.p1(this.f107659a, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(HaFActivity haFActivity, int i3, Composer composer, int i4) {
        haFActivity.o1(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void q1(final PaddingValues paddingValues, final HaFViewState haFViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(2001671556);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(haFViewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(this) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2001671556, i4, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.MainContent (HaFActivity.kt:218)");
            }
            boolean Z = composerK.Z(haFViewState.j());
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(haFViewState.j(), null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);
                composerK.w(objG2);
            }
            MutableState mutableState2 = (MutableState) objG2;
            String strR1 = r1(mutableState);
            int i5 = i4 & 896;
            boolean Z2 = (i5 == 256) | composerK.Z(mutableState);
            Object objG3 = composerK.G();
            if (Z2 || objG3 == companion.a()) {
                objG3 = new HaFActivity$MainContent$1$1(function1, mutableState2, mutableState, null);
                composerK.w(objG3);
            }
            EffectsKt.g(strR1, (Function2) objG3, composerK, 0);
            Modifier modifierF = SizeKt.f(PaddingKt.k(PaddingKt.h(BackgroundKt.d(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composerK, 6)), ComposeColorsKt.j(composerK, 0).e(), null, 2, null), paddingValues), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), 0.0f, 1, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(16));
            boolean zI = (i5 == 256) | composerK.I(this) | composerK.Z(mutableState) | ((i4 & 112) == 32);
            Object objG4 = composerK.G();
            if (zI || objG4 == companion.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.haf.v0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HaFActivity.v1(haFViewState, this, mutableState, function1, (LazyListScope) obj);
                    }
                };
                composerK.w(objG4);
            }
            composer2 = composerK;
            LazyDslKt.b(modifierF, null, null, false, horizontalOrVerticalO, null, null, false, null, (Function1) objG4, composer2, 24576, 494);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.haf.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HaFActivity.M1(this.f107654a, paddingValues, haFViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String r1(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    private static final void s1(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t1(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v1(final HaFViewState haFViewState, final HaFActivity haFActivity, final MutableState mutableState, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(1998499535, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.s
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return HaFActivity.w1(this.f107695a, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(-1822939656, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.u
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return HaFActivity.x1(mutableState, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        if (Intrinsics.areEqual(haFViewState.l(), Loading.f127895a)) {
            LazyListScope.c(LazyColumn, null, null, ComposableSingletons$HaFActivityKt.f107538a.j(), 3, null);
        } else {
            final List listM = haFViewState.m();
            if (listM != null) {
                LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(1860104862, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.v
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return HaFActivity.B1(listM, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }), 3, null);
                LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(-718623275, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.w
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return HaFActivity.C1(listM, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }), 3, null);
                ComposableSingletons$HaFActivityKt composableSingletons$HaFActivityKt = ComposableSingletons$HaFActivityKt.f107538a;
                LazyListScope.c(LazyColumn, null, null, composableSingletons$HaFActivityKt.i(), 3, null);
                LazyListScope.c(LazyColumn, null, null, composableSingletons$HaFActivityKt.k(), 3, null);
            }
        }
        if (r1(mutableState).length() < 3) {
            LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(-449594307, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.x
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return HaFActivity.F1(haFViewState, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(-640706921, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.y
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return HaFActivity.I1(function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(541525814, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.z
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return HaFActivity.K1(this.f107718a, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.c(LazyColumn, null, null, ComposableSingletons$HaFActivityKt.f107538a.o(), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w1(HaFActivity haFActivity, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1998499535, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.MainContent.<anonymous>.<anonymous>.<anonymous> (HaFActivity.kt:245)");
            }
            haFActivity.o1(composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x1(final MutableState mutableState, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1822939656, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.MainContent.<anonymous>.<anonymous>.<anonymous> (HaFActivity.kt:249)");
            }
            String strR1 = r1(mutableState);
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, null, 0, ImeAction.f29348b.b(), null, null, null, 119, null);
            PaddingValues paddingValuesS = TextFieldDefaults.s(TextFieldDefaults.f14636a, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierC = BackgroundKt.c(SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).N(), RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composer, 0)));
            boolean Z = composer.Z(mutableState);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.haf.k0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HaFActivity.y1(mutableState, (String) obj);
                    }
                };
                composer.w(objG);
            }
            ComposableSingletons$HaFActivityKt composableSingletons$HaFActivityKt = ComposableSingletons$HaFActivityKt.f107538a;
            ComposeTextFieldsKt.h(strR1, (Function1) objG, modifierC, false, false, false, null, null, composableSingletons$HaFActivityKt.n(), composableSingletons$HaFActivityKt.l(), ComposableLambdaKt.e(1615250632, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.haf.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HaFActivity.z1(mutableState, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), false, null, keyboardOptions, null, false, 0, null, null, paddingValuesS, null, 0L, 0.0f, 0.0f, composer, 906166272, 3078, 0, 16242904);
            SpacerKt.a(SizeKt.i(companion, Dp.g(16)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y1(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        s1(mutableState, it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z1(final MutableState mutableState, final Function1 function1, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1615250632, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.MainContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HaFActivity.kt:270)");
            }
            if (r1(mutableState).length() > 0) {
                composer.a0(-881931295);
                ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
                long jM = ComposeColorsKt.j(composer, 0).M();
                boolean Z = composer.Z(mutableState) | composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.haf.o0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HaFActivity.A1(function1, mutableState);
                        }
                    };
                    composer.w(objG);
                }
                ComposeButtonsKt.q0(null, imageVectorB, null, false, 0.0f, 0.0f, jM, null, (Function0) objG, composer, 0, 189);
            } else {
                composer.a0(-893504742);
            }
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final QuestionDTO Y1() {
        Object serializableExtra;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        if (Build.VERSION.SDK_INT >= 33) {
            serializableExtra = intent.getSerializableExtra("HAF_PRESELECTED_QUESTION", QuestionDTO.class);
        } else {
            Object serializableExtra2 = intent.getSerializableExtra("HAF_PRESELECTED_QUESTION");
            if (!(serializableExtra2 instanceof QuestionDTO)) {
                serializableExtra2 = null;
            }
            serializableExtra = (QuestionDTO) serializableExtra2;
        }
        return (QuestionDTO) serializableExtra;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(740828694);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(740828694, i4, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.RootCompose (HaFActivity.kt:104)");
            }
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.haf.t
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HaFActivity.N1(this.f107699a);
                    }
                };
                composerK.w(objG);
            }
            Function0 function0 = (Function0) objG;
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
            KClass kClassB = Reflection.b(HaFViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            HaFViewModel haFViewModel = (HaFViewModel) viewModelA;
            final HaFViewState haFViewState = (HaFViewState) FlowExtKt.m(haFViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(haFViewModel, composerK, 0);
            boolean Z = composerK.Z(haFViewState) | composerK.Z(function1N) | composerK.I(this);
            Object objG2 = composerK.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.haf.e0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HaFActivity.O1(haFViewState, function1N, this);
                    }
                };
                composerK.w(objG2);
            }
            final Function0 function02 = (Function0) objG2;
            boolean Z2 = composerK.Z(function02);
            Object objG3 = composerK.G();
            if (Z2 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.haf.p0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HaFActivity.P1(function02);
                    }
                };
                composerK.w(objG3);
            }
            BackHandlerKt.a(false, (Function0) objG3, composerK, 0, 1);
            f1(haFViewModel, composerK, i4 & 112);
            composer2 = composerK;
            ScaffoldKt.a(null, null, ComposableLambdaKt.e(1906005403, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.haf.q0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HaFActivity.Q1(haFViewState, this, function02, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(1633569116, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.haf.r0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HaFActivity.R1(haFViewState, function1N, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(118734676, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.s0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return HaFActivity.T1(haFViewState, this, function1N, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 3456, 12582912, 131059);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.haf.t0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HaFActivity.U1(this.f107700a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void f1(HaFViewModel viewModel, Composer composer, final int i3) {
        int i4;
        final HaFViewModel haFViewModel;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer composerK = composer.k(-307584141);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(viewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(this) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-307584141, i4, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.CommandProcessor (HaFActivity.kt:202)");
            }
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new HaFActivity$CommandProcessor$1$1(this, null);
                composerK.w(objG);
            }
            haFViewModel = viewModel;
            FlowExtKt.g(haFViewModel, null, (Function2) objG, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            haFViewModel = viewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.haf.u0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HaFActivity.g1(this.f107705a, haFViewModel, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void h1(final HaFQuestionResponse question, final Function1 onEvent, final HaFViewState viewState, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Composer composerK = composer.k(-1627696063);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(question) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(viewState) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(this) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1627696063, i4, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.CustomWebView (HaFActivity.kt:471)");
            }
            final boolean zA = DarkThemeKt.a(composerK, 0);
            Modifier modifierF = SizeKt.f(Modifier.b8, 0.0f, 1, null);
            boolean z2 = ((i4 & 112) == 32) | ((i4 & 896) == 256);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.haf.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HaFActivity.i1(onEvent, viewState, (Context) obj);
                    }
                };
                composerK.w(objG);
            }
            Function1 function1 = (Function1) objG;
            boolean zI = composerK.I(this) | ((i4 & 14) == 4) | composerK.b(zA);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.haf.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HaFActivity.j1(this.f107664a, question, zA, (WebView) obj);
                    }
                };
                composerK.w(objG2);
            }
            AndroidView_androidKt.a(function1, modifierF, (Function1) objG2, composerK, 48, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.haf.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HaFActivity.k1(this.f107669a, question, onEvent, viewState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void l1(final Function0 onHomeButtonClick, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onHomeButtonClick, "onHomeButtonClick");
        Composer composerK = composer.k(-744960331);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onHomeButtonClick) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-744960331, i4, -1, "cz.mobilesoft.coreblock.scene.more.haf.HaFActivity.HaFToolbar (HaFActivity.kt:450)");
            }
            AppBarKt.g(ComposableSingletons$HaFActivityKt.f107538a.m(), BackgroundKt.d(SizeKt.i(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(56)), ComposeColorsKt.j(composerK, 0).e(), null, 2, null), ComposableLambdaKt.e(-1272475653, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.haf.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HaFActivity.m1(onHomeButtonClick, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, ComposeColorsKt.j(composerK, 0).e(), 0L, Dp.g(0), composerK, 1573254, 40);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.haf.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HaFActivity.n1(this.f107690a, onHomeButtonClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
