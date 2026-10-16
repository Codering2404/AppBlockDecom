package cz.mobilesoft.coreblock.scene.more.settings;

import android.content.Context;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.ads.AdError;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity;
import cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareFlowScenario;
import cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseActivity;
import cz.mobilesoft.coreblock.scene.more.settings.PremiumSettingsScreenKt;
import cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewState;
import cz.mobilesoft.coreblock.scene.more.signin.SignInActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInConfig;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.view.compose.SectionedItemKt;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PremiumSettingsScreenKt {
    public static final void m(final boolean z2, final Function0 onFinish, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        Composer composerK = composer.k(1902074459);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onFinish) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1902074459, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.PremiumSettingsScreen (PremiumSettingsScreen.kt:37)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            composer2 = composerK;
            ScaffoldKt.a(null, null, null, null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(779103837, true, new Function3() { // from class: c1.s
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PremiumSettingsScreenKt.n(context, onFinish, z2, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 0, 12582912, 131071);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: c1.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumSettingsScreenKt.y(z2, onFinish, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(final Context context, final Function0 function0, final boolean z2, PaddingValues padding, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        Intrinsics.checkNotNullParameter(padding, "padding");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(padding) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(779103837, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.PremiumSettingsScreen.<anonymous> (PremiumSettingsScreen.kt:41)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(PaddingKt.h(ScrollKt.g(companion, ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), padding), Dp.g(f3));
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
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.Me, composer, 0);
            ImageVector.Companion companion3 = ImageVector.f26323k;
            ImageVector imageVectorB = VectorResources_androidKt.b(companion3, R.drawable.t4, composer, 6);
            boolean zI = composer.I(context) | composer.Z(function0);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: c1.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PremiumSettingsScreenKt.o(context, function0);
                    }
                };
                composer.w(objG);
            }
            SectionedItemKt.G(null, strB, null, null, null, null, imageVectorB, null, null, false, 0L, 0L, null, false, (Function0) objG, false, null, 0L, composer, 0, 0, 245693);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            String strB2 = StringResources_androidKt.b(R.string.Uo, composer, 0);
            ImageVector imageVectorB2 = VectorResources_androidKt.b(companion3, R.drawable.M4, composer, 6);
            boolean zI2 = composer.I(context);
            Object objG2 = composer.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: c1.x
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PremiumSettingsScreenKt.p(context);
                    }
                };
                composer.w(objG2);
            }
            GeneralSettingsViewState.SettingsItem settingsItem = new GeneralSettingsViewState.SettingsItem(strB2, null, null, null, imageVectorB2, false, false, (Function0) objG2, 110, null);
            String strB3 = StringResources_androidKt.b(R.string.Ye, composer, 0);
            ImageVector imageVectorB3 = VectorResources_androidKt.b(companion3, R.drawable.P2, composer, 6);
            boolean zB = composer.b(z2) | composer.I(context);
            Object objG3 = composer.G();
            if (zB || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: c1.y
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PremiumSettingsScreenKt.q(z2, context);
                    }
                };
                composer.w(objG3);
            }
            GeneralSettingsViewState.SettingsItem settingsItem2 = new GeneralSettingsViewState.SettingsItem(strB3, null, null, null, imageVectorB3, false, false, (Function0) objG3, 110, null);
            String strB4 = StringResources_androidKt.b(R.string.Oe, composer, 0);
            ImageVector imageVectorB4 = VectorResources_androidKt.b(companion3, R.drawable.d5, composer, 6);
            boolean zI3 = composer.I(context);
            Object objG4 = composer.G();
            if (zI3 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function0() { // from class: c1.z
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PremiumSettingsScreenKt.r(context);
                    }
                };
                composer.w(objG4);
            }
            List listMutableListOf = CollectionsKt.mutableListOf(settingsItem, settingsItem2, new GeneralSettingsViewState.SettingsItem(strB4, null, null, null, imageVectorB4, false, false, (Function0) objG4, 110, null));
            Function3 function3 = new Function3() { // from class: c1.a0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PremiumSettingsScreenKt.s((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function32 = new Function3() { // from class: c1.b0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PremiumSettingsScreenKt.t((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function33 = new Function3() { // from class: c1.c0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PremiumSettingsScreenKt.u((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function34 = new Function3() { // from class: c1.d0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PremiumSettingsScreenKt.v((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function35 = new Function3() { // from class: c1.t
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PremiumSettingsScreenKt.w((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Object objG5 = composer.G();
            if (objG5 == Composer.f23746a.a()) {
                objG5 = new Function2() { // from class: c1.u
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PremiumSettingsScreenKt.x((GeneralSettingsViewState.SettingsItem) obj, ((Integer) obj2).intValue());
                    }
                };
                composer.w(objG5);
            }
            SectionedItemKt.f0(listMutableListOf, function3, function32, function33, function34, null, null, function35, null, null, null, null, null, false, true, false, 0L, null, null, 0L, null, null, 0L, null, null, (Function2) objG5, composer, 0, 24576, 196608, 16768944);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
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
    public static final Unit o(Context context, Function0 function0) {
        context.startActivity(Paywall.c(Paywall.f113165a, context, PaywallTarget.Generic.INSTANCE, "profile_tab", "premium", false, false, false, null, 240, null));
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Context context) {
        if (SessionManager.f127910a.r()) {
            context.startActivity(RestorePurchaseActivity.f107825f.a(context));
        } else {
            context.startActivity(SignInActivity.f110366h.a(context, new SignInConfig(SignInEntryPoint.RESTORE, null, false, true, false, true, false, false, false, false, null, AdError.INTERNAL_ERROR_2006, null)));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(boolean z2, Context context) {
        context.startActivity(GuestPassShareActivity.f107428g.a(context, z2 ? GuestPassShareFlowScenario.EligibleGuestPassShare : GuestPassShareFlowScenario.ShareOnly));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Context context) {
        ExternalLinksHelper.f127866a.d(context, "https://appblock.app/gift-card/cart/");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String s(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(1474690764);
        if (ComposerKt.M()) {
            ComposerKt.U(1474690764, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.PremiumSettingsScreen.<anonymous>.<anonymous>.<anonymous> (PremiumSettingsScreen.kt:106)");
        }
        String strE = it.e();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String t(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(2133073643);
        if (ComposerKt.M()) {
            ComposerKt.U(2133073643, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.PremiumSettingsScreen.<anonymous>.<anonymous>.<anonymous> (PremiumSettingsScreen.kt:107)");
        }
        String strD = it.d();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String u(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-1503510774);
        if (ComposerKt.M()) {
            ComposerKt.U(-1503510774, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.PremiumSettingsScreen.<anonymous>.<anonymous>.<anonymous> (PremiumSettingsScreen.kt:108)");
        }
        String strA = it.a();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageVector v(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(505110476);
        if (ComposerKt.M()) {
            ComposerKt.U(505110476, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.PremiumSettingsScreen.<anonymous>.<anonymous>.<anonymous> (PremiumSettingsScreen.kt:111)");
        }
        ImageVector imageVectorB = it.b();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return imageVectorB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean w(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-1139772609);
        if (ComposerKt.M()) {
            ComposerKt.U(-1139772609, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.PremiumSettingsScreen.<anonymous>.<anonymous>.<anonymous> (PremiumSettingsScreen.kt:110)");
        }
        Boolean boolG = it.g();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return boolG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(GeneralSettingsViewState.SettingsItem item, int i3) {
        Intrinsics.checkNotNullParameter(item, "item");
        item.c().invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(boolean z2, Function0 function0, int i3, Composer composer, int i4) {
        m(z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
