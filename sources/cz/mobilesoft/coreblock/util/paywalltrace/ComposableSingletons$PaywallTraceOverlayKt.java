package cz.mobilesoft.coreblock.util.paywalltrace;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.AnalyticsEvents;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.paywalltrace.ComposableSingletons$PaywallTraceOverlayKt;
import cz.mobilesoft.coreblock.util.paywalltrace.PaywallTrace;
import dev.doubledot.doki.api.extensions.ConstantsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$PaywallTraceOverlayKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$PaywallTraceOverlayKt f128965a = new ComposableSingletons$PaywallTraceOverlayKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f128966b = ComposableLambdaKt.c(1529744216, false, new Function2() { // from class: i2.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PaywallTraceOverlayKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f128967c = ComposableLambdaKt.c(1204503321, false, new Function2() { // from class: i2.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PaywallTraceOverlayKt.f((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1204503321, i3, -1, "cz.mobilesoft.coreblock.util.paywalltrace.ComposableSingletons$PaywallTraceOverlayKt.lambda$1204503321.<anonymous> (PaywallTraceOverlay.kt:449)");
            }
            Modifier modifierD = BackgroundKt.d(Modifier.b8, Color.f25715b.e(), null, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierD);
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
            CollapsedTrace collapsedTrace = new CollapsedTrace(new PaywallTrace(0L, PaywallTrace.Stage.EngineSelection, "Native paywall on discount20", "discount20", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, "first_discount_offer", null, CollectionsKt.listOf((Object[]) new RuleOutcome[]{new RuleOutcome("dev override", "not set", false, 4, null), new RuleOutcome("android_paywall_<placement>", "rc_hosted", false, 4, null), new RuleOutcome("offering.hasPaywall", "false - stepping down to native", true)}), MapsKt.mapOf(TuplesKt.a("android_paywall_general", "rc_hosted"), TuplesKt.a("android_paywall_limitScreen", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)), null, 2, 576, null), 3);
            PaywallTrace.Stage stage = PaywallTrace.Stage.OfferingResolution;
            Boolean bool = Boolean.TRUE;
            List listListOf = CollectionsKt.listOf((Object[]) new TraceGroup[]{new TraceGroup(2, CollectionsKt.listOf((Object[]) new CollapsedTrace[]{collapsedTrace, new CollapsedTrace(new PaywallTrace(0L, stage, "first_discount_offer for discount20", "discount20", null, "first_discount_offer", bool, CollectionsKt.listOf((Object[]) new RuleOutcome[]{new RuleOutcome("pinned discount", IntegrityManager.INTEGRITY_TYPE_NONE, false, 4, null), new RuleOutcome("placement resolution", "resolved through placement", true), new RuleOutcome("requested from", "PurchaseScreen", false, 4, null)}), null, null, 2, 784, null), 1)})), new TraceGroup(0, CollectionsKt.listOf(new CollapsedTrace(new PaywallTrace(0L, stage, "default_offer for general", ConstantsKt.DONT_KILL_MY_APP_FALLBACK_MANUFACTURER, null, "default_offer", bool, CollectionsKt.listOf(new RuleOutcome("requested from", "TrialCheck", false, 4, null)), null, null, 0, 1808, null), 1)))});
            Object objG = composer.G();
            Composer.Companion companion2 = Composer.f23746a;
            if (objG == companion2.a()) {
                objG = new Function0() { // from class: i2.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$PaywallTraceOverlayKt.g();
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == companion2.a()) {
                objG2 = new Function0() { // from class: i2.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$PaywallTraceOverlayKt.h();
                    }
                };
                composer.w(objG2);
            }
            PaywallTraceOverlayKt.h0(listListOf, function0, (Function0) objG2, composer, 432);
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
    public static final String g() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1529744216, i3, -1, "cz.mobilesoft.coreblock.util.paywalltrace.ComposableSingletons$PaywallTraceOverlayKt.lambda$1529744216.<anonymous> (PaywallTraceOverlay.kt:165)");
            }
            IconKt.d(CloseKt.a(Icons.f15145a.a()), "Close", null, ComposeColorsKt.j(composer, 0).q(), composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 e() {
        return f128966b;
    }
}
