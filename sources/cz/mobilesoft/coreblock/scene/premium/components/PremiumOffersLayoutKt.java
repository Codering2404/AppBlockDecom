package cz.mobilesoft.coreblock.scene.premium.components;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.facebook.ads.AdError;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInConfig;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.scene.premium.enums.PremiumOfferSelectionType;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PremiumOffersLayoutKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f112577a;

        static {
            int[] iArr = new int[PremiumOfferSelectionType.values().length];
            try {
                iArr[PremiumOfferSelectionType.Selection.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PremiumOfferSelectionType.BottomSheet.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f112577a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(PremiumOptionDTO premiumOptionDTO, int i3, Composer composer, int i4) {
        z(premiumOptionDTO, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void B(final boolean z2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(2068236214);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.b(z2) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2068236214, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.RestorePurchaseContent (PremiumOffersLayout.kt:305)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.Absolute.f6583a.d(), Alignment.f25072a.i(), composerK, 54);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean zI = ((i4 & 14) == 4) | composerK.I(context);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.components.u2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PremiumOffersLayoutKt.C(z2, context, (ActivityResult) obj);
                    }
                };
                composerK.w(objG);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composerK, 0);
            float f3 = 120;
            float f4 = 8;
            Modifier modifierM = PaddingKt.m(SizeKt.b(companion, Dp.g(f3), 0.0f, 2, null), 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null);
            String strB = StringResources_androidKt.b(R.string.BC, composerK, 0);
            long jQ = ComposeColorsKt.j(composerK, 0).q();
            TextStyle textStyleD = ComposeTypographyKt.g(composerK, 0).d();
            boolean zI2 = composerK.I(context);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.components.v2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PremiumOffersLayoutKt.D(context);
                    }
                };
                composerK.w(objG2);
            }
            ComposeButtonsKt.c0(strB, modifierM, false, jQ, textStyleD, 0.0f, null, (Function0) objG2, composerK, 48, 100);
            Modifier modifierM2 = PaddingKt.m(SizeKt.b(companion, Dp.g(f3), 0.0f, 2, null), 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null);
            String strB2 = StringResources_androidKt.b(R.string.Uo, composerK, 0);
            long jQ2 = ComposeColorsKt.j(composerK, 0).q();
            TextStyle textStyleD2 = ComposeTypographyKt.g(composerK, 0).d();
            boolean zI3 = composerK.I(managedActivityResultLauncherA) | composerK.I(context);
            Object objG3 = composerK.G();
            if (zI3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.components.w2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PremiumOffersLayoutKt.E(managedActivityResultLauncherA, context);
                    }
                };
                composerK.w(objG3);
            }
            ComposeButtonsKt.c0(strB2, modifierM2, false, jQ2, textStyleD2, 0.0f, null, (Function0) objG3, composerK, 48, 100);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.j2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumOffersLayoutKt.F(z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(boolean z2, Context context, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() == -1) {
            if (z2) {
                CoroutinesHelperExtKt.d(new PremiumOffersLayoutKt$RestorePurchaseContent$1$launcher$1$1$1(context, null));
            } else {
                Activity activityB = ContextExtKt.b(context);
                if (activityB != null) {
                    activityB.finish();
                }
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Context context) {
        AnswersHelper.f128199a.f4();
        ExternalLinksHelper externalLinksHelper = ExternalLinksHelper.f127866a;
        Uri uri = Uri.parse(PrefManager.f126839a.t0());
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        externalLinksHelper.c(context, uri);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(ManagedActivityResultLauncher managedActivityResultLauncher, Context context) {
        managedActivityResultLauncher.b(SessionManager.f127910a.r() ? RestorePurchaseActivity.f107825f.a(context) : SignInActivity.f110366h.a(context, new SignInConfig(SignInEntryPoint.RESTORE, null, false, true, false, true, false, false, false, false, null, AdError.INTERNAL_ERROR_2006, null)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(boolean z2, int i3, Composer composer, int i4) {
        B(z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void G(final java.util.List r24, final cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r25, final boolean r26, final boolean r27, final boolean r28, final boolean r29, cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r30, final kotlin.jvm.functions.Function1 r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.components.PremiumOffersLayoutKt.G(java.util.List, cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO, boolean, boolean, boolean, boolean, cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Function1 function1, PremiumOptionDTO premiumOptionDTO) {
        function1.invoke(new PremiumScreenViewEvent.OnOptionSelected(premiumOptionDTO));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(List list, PremiumOptionDTO premiumOptionDTO, boolean z2, boolean z3, boolean z4, boolean z5, PremiumOptionDTO premiumOptionDTO2, Function1 function1, int i3, int i4, Composer composer, int i5) {
        G(list, premiumOptionDTO, z2, z3, z4, z5, premiumOptionDTO2, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void J(final List list, final PremiumOptionDTO premiumOptionDTO, final PremiumOptionDTO premiumOptionDTO2, final boolean z2, final boolean z3, final boolean z4, final boolean z5, final Function1 function1, Composer composer, final int i3) {
        List list2;
        int i4;
        PremiumOptionDTO premiumOptionDTO3;
        boolean z6;
        boolean z7;
        boolean z8;
        Composer composerK = composer.k(-1967655814);
        if ((i3 & 6) == 0) {
            list2 = list;
            i4 = (composerK.I(list2) ? 4 : 2) | i3;
        } else {
            list2 = list;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            premiumOptionDTO3 = premiumOptionDTO;
            i4 |= composerK.Z(premiumOptionDTO3) ? 32 : 16;
        } else {
            premiumOptionDTO3 = premiumOptionDTO;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(premiumOptionDTO2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            z6 = z2;
            i4 |= composerK.b(z6) ? 2048 : 1024;
        } else {
            z6 = z2;
        }
        if ((i3 & 24576) == 0) {
            z7 = z3;
            i4 |= composerK.b(z7) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            z7 = z3;
        }
        if ((196608 & i3) == 0) {
            z8 = z4;
            i4 |= composerK.b(z8) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            z8 = z4;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.b(z5) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.I(function1) ? 8388608 : 4194304;
        }
        if (composerK.r((4793491 & i4) != 4793490, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1967655814, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.SelectionVariant (PremiumOffersLayout.kt:107)");
            }
            String strB = StringResources_androidKt.b(R.string.D7, composerK, 0);
            if (premiumOptionDTO2 == null) {
                composerK.a0(-720207032);
                float f3 = 24;
                TextKt.c(strB, PaddingKt.m(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(f3), 0.0f, Dp.g(f3), Dp.g(16), 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).f(), composerK, 48, 0, 65020);
            } else {
                composerK.a0(-725147192);
            }
            composerK.U();
            int i5 = i4 >> 3;
            G(list2, premiumOptionDTO3, z7, z6, z8, z5, premiumOptionDTO2, function1, composerK, (i4 & 126) | ((i4 >> 6) & 896) | (i4 & 7168) | (57344 & i5) | (i5 & 458752) | ((i4 << 12) & 3670016) | (i4 & 29360128), 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.t2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumOffersLayoutKt.K(list, premiumOptionDTO, premiumOptionDTO2, z2, z3, z4, z5, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(List list, PremiumOptionDTO premiumOptionDTO, PremiumOptionDTO premiumOptionDTO2, boolean z2, boolean z3, boolean z4, boolean z5, Function1 function1, int i3, Composer composer, int i4) {
        J(list, premiumOptionDTO, premiumOptionDTO2, z2, z3, z4, z5, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void p(final cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState r26, final cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r27, cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r28, boolean r29, final boolean r30, final kotlin.jvm.functions.Function1 r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.components.PremiumOffersLayoutKt.p(cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState, cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO, cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(PremiumScreenViewState premiumScreenViewState, PremiumOptionDTO premiumOptionDTO, PremiumOptionDTO premiumOptionDTO2, boolean z2, boolean z3, Function1 function1, int i3, int i4, Composer composer, int i5) {
        p(premiumScreenViewState, premiumOptionDTO, premiumOptionDTO2, z2, z3, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(CoroutineScope coroutineScope, Function1 function1) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new PremiumOffersLayoutKt$BottomSheetVariant$2$1$1(function1, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(PremiumScreenViewState premiumScreenViewState, PremiumOptionDTO premiumOptionDTO, PremiumOptionDTO premiumOptionDTO2, boolean z2, boolean z3, Function1 function1, int i3, int i4, Composer composer, int i5) {
        p(premiumScreenViewState, premiumOptionDTO, premiumOptionDTO2, z2, z3, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x039a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void t(final kotlinx.collections.immutable.ImmutableList r41, cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r42, final java.lang.String r43, final boolean r44, final boolean r45, final boolean r46, final boolean r47, final boolean r48, final kotlin.jvm.functions.Function1 r49, androidx.compose.runtime.Composer r50, final int r51) {
        /*
            Method dump skipped, instruction units count: 965
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.components.PremiumOffersLayoutKt.t(kotlinx.collections.immutable.ImmutableList, cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO, java.lang.String, boolean, boolean, boolean, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Context context, Function1 function1, PremiumOptionDTO premiumOptionDTO) {
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            function1.invoke(new PremiumScreenViewEvent.OnPurchase(activityB, premiumOptionDTO));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(ImmutableList immutableList, PremiumOptionDTO premiumOptionDTO, String str, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Function1 function1, int i3, Composer composer, int i4) {
        t(immutableList, premiumOptionDTO, str, z2, z3, z4, z5, z6, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void w(final cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState r23, cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r24, cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r25, boolean r26, final boolean r27, final kotlin.jvm.functions.Function1 r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.components.PremiumOffersLayoutKt.w(cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState, cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO, cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(PremiumScreenViewState premiumScreenViewState, PremiumOptionDTO premiumOptionDTO, PremiumOptionDTO premiumOptionDTO2, boolean z2, boolean z3, Function1 function1, int i3, int i4, Composer composer, int i5) {
        w(premiumScreenViewState, premiumOptionDTO, premiumOptionDTO2, z2, z3, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(PremiumScreenViewState premiumScreenViewState, PremiumOptionDTO premiumOptionDTO, PremiumOptionDTO premiumOptionDTO2, boolean z2, boolean z3, Function1 function1, int i3, int i4, Composer composer, int i5) {
        w(premiumScreenViewState, premiumOptionDTO, premiumOptionDTO2, z2, z3, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void z(final PremiumOptionDTO optionDTO, Composer composer, final int i3) {
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(optionDTO, "optionDTO");
        Composer composerK = composer.k(-1963128015);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(optionDTO) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1963128015, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.PremiumOptionExplanationText (PremiumOffersLayout.kt:217)");
            }
            String strE = optionDTO.e((Context) composerK.q(AndroidCompositionLocals_androidKt.g()));
            if (strE == null) {
                composerK.a0(1023128311);
                composerK.U();
                i5 = 6;
            } else {
                composerK.a0(1023128312);
                SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(16)), composerK, 6);
                i5 = 6;
                TextKt.c(strE, null, ComposeColorsKt.j(composerK, 0).s(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composerK, 0, 0, 65018);
                composerK = composerK;
                composerK.U();
            }
            SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(24)), composerK, i5);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.i2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumOffersLayoutKt.A(optionDTO, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
