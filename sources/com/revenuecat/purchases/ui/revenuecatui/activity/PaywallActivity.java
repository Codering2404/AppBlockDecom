package com.revenuecat.purchases.ui.revenuecatui.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.compose.ComponentActivityKt;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.AndroidFontKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.googlefonts.GoogleFont;
import androidx.compose.ui.text.googlefonts.GoogleFontKt;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.PaywallKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.fonts.FontProvider;
import com.revenuecat.purchases.ui.revenuecatui.fonts.GoogleFontProvider;
import com.revenuecat.purchases.ui.revenuecatui.fonts.PaywallFont;
import com.revenuecat.purchases.ui.revenuecatui.fonts.PaywallFontFamily;
import com.revenuecat.purchases.ui.revenuecatui.fonts.TypographyType;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.SdkConfigurationStateKt;
import com.revenuecat.purchases.ui.revenuecatui.utils.Resumable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

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
public final class PaywallActivity extends ComponentActivity {
    public static final String ARGS_EXTRA = "paywall_args";
    public static final String RESULT_EXTRA = "paywall_result";
    private final ActivityResultLauncher<PaywallActivityArgs> exitOfferLauncher = registerForActivityResult(new PaywallContract(), new ActivityResultCallback() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.a
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            PaywallActivity.exitOfferLauncher$lambda$0(this.f92319a, (PaywallResult) obj);
        }
    });
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent createResultIntent(PaywallResult paywallResult) {
        Intent intentPutExtra = new Intent().putExtra(RESULT_EXTRA, paywallResult);
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(RESULT_EXTRA, result)");
        return intentPutExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exitOfferLauncher$lambda$0(PaywallActivity paywallActivity, PaywallResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        paywallActivity.setResult(-1, paywallActivity.createResultIntent(result));
        paywallActivity.finish();
    }

    private final PaywallActivityArgs getArgs() {
        return Build.VERSION.SDK_INT >= 33 ? (PaywallActivityArgs) getIntent().getParcelableExtra(ARGS_EXTRA, PaywallActivityArgs.class) : (PaywallActivityArgs) getIntent().getParcelableExtra(ARGS_EXTRA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FontProvider getFontProvider() {
        Map<TypographyType, PaywallFontFamily> fonts;
        ArrayList arrayList;
        List<PaywallFont> fonts2;
        Font fontA;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        PaywallActivityArgs args = getArgs();
        if (args == null || (fonts = args.getFonts()) == null) {
            return null;
        }
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(fonts.size()));
        Iterator<T> it = fonts.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            PaywallFontFamily paywallFontFamily = (PaywallFontFamily) entry.getValue();
            if (paywallFontFamily == null || (fonts2 = paywallFontFamily.getFonts()) == null) {
                arrayList = null;
            } else {
                List<PaywallFont> list = fonts2;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (PaywallFont paywallFont : list) {
                    if (paywallFont instanceof PaywallFont.ResourceFont) {
                        PaywallFont.ResourceFont resourceFont = (PaywallFont.ResourceFont) paywallFont;
                        fontA = FontKt.b(resourceFont.getResourceId(), resourceFont.getFontWeight(), FontStyle.d(resourceFont.getFontStyle()), 0, 8, null);
                    } else if (paywallFont instanceof PaywallFont.AssetFont) {
                        PaywallFont.AssetFont assetFont = (PaywallFont.AssetFont) paywallFont;
                        String path = assetFont.getPath();
                        AssetManager assets = getAssets();
                        Intrinsics.checkNotNullExpressionValue(assets, "assets");
                        fontA = AndroidFontKt.d(path, assets, assetFont.getFontWeight(), FontStyle.d(assetFont.getFontStyle()), null, 16, null);
                    } else {
                        if (!(paywallFont instanceof PaywallFont.GoogleFont)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        PaywallFont.GoogleFont googleFont = (PaywallFont.GoogleFont) paywallFont;
                        GoogleFontProvider fontProvider = googleFont.getFontProvider();
                        Object googleProvider = linkedHashMap.get(fontProvider);
                        if (googleProvider == null) {
                            googleProvider = fontProvider.toGoogleProvider();
                            linkedHashMap.put(fontProvider, googleProvider);
                        }
                        fontA = GoogleFontKt.a(new GoogleFont(googleFont.getFontName(), false, 2, null), (GoogleFont.Provider) googleProvider, googleFont.getFontWeight(), FontStyle.d(googleFont.getFontStyle()));
                    }
                    arrayList.add(fontA);
                }
            }
            linkedHashMap2.put(key, arrayList != null ? FontFamilyKt.b(arrayList) : null);
        }
        return new FontProvider() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity.getFontProvider.1
            @Override // com.revenuecat.purchases.ui.revenuecatui.fonts.FontProvider
            public FontFamily getFont(TypographyType type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return linkedHashMap2.get(type);
            }
        };
    }

    private final void launchExitOfferActivity(Offering offering) {
        PaywallActivityArgs args = getArgs();
        if (args == null) {
            finish();
        } else {
            this.exitOfferLauncher.b(PaywallActivityArgs.copy$default(args, null, new OfferingSelection.IdAndPresentedOfferingContext(offering.getIdentifier(), null), null, false, false, false, null, null, 253, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDismissRequest(Offering offering, PaywallResult paywallResult) {
        if (paywallResult != null) {
            setResult(-1, createResultIntent(paywallResult));
        }
        if (offering != null) {
            launchExitOfferActivity(offering);
        } else {
            finish();
        }
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity$onCreate$compositeListener$1] */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Integer nonSerializableArgsKey;
        requestWindowFeature(1);
        super.onCreate(bundle);
        SdkConfigurationStateKt.restoreSdkConfigurationIfNeeded(this, bundle);
        final PaywallActivityArgs args = getArgs();
        boolean z2 = false;
        if (!(args != null ? args.getWasLaunchedThroughSDK() : false) && !Purchases.Companion.isConfigured()) {
            Logger.INSTANCE.e("PaywallActivity was launched incorrectly. Please use PaywallActivityLauncher, or Paywall/PaywallDialog/PaywallFooter composables to display the Paywall.");
            finish();
            return;
        }
        PaywallActivityNonSerializableArgs paywallActivityNonSerializableArgs = (args == null || (nonSerializableArgsKey = args.getNonSerializableArgsKey()) == null) ? null : PaywallActivityNonSerializableArgsStore.INSTANCE.get(nonSerializableArgsKey.intValue());
        if ((args != null ? args.getNonSerializableArgsKey() : null) != null && paywallActivityNonSerializableArgs == null) {
            Logger.INSTANCE.w("PaywallActivity was recreated after process death causing PurchaseLogic and/or PaywallListener to be lost. Finishing activity.");
            setResult(-1, createResultIntent(PaywallResult.Cancelled.INSTANCE));
            finish();
            return;
        }
        final PaywallListener listener = paywallActivityNonSerializableArgs != null ? paywallActivityNonSerializableArgs.getListener() : null;
        final PaywallPurchaseLogic purchaseLogic = paywallActivityNonSerializableArgs != null ? paywallActivityNonSerializableArgs.getPurchaseLogic() : null;
        final ?? r5 = new PaywallListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity$onCreate$compositeListener$1
            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseCancelled() {
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseCancelled();
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseCompleted(CustomerInfo customerInfo, StoreTransaction storeTransaction) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseCompleted(customerInfo, storeTransaction);
                }
                PaywallActivity paywallActivity = this;
                paywallActivity.setResult(-1, paywallActivity.createResultIntent(new PaywallResult.Purchased(customerInfo)));
                this.finish();
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseError(error);
                }
                PaywallResult error2 = error.getCode() == PurchasesErrorCode.PurchaseCancelledError ? PaywallResult.Cancelled.INSTANCE : new PaywallResult.Error(error);
                PaywallActivity paywallActivity = this;
                paywallActivity.setResult(-1, paywallActivity.createResultIntent(error2));
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchasePackageInitiated(Package rcPackage, Resumable resume) {
                Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                Intrinsics.checkNotNullParameter(resume, "resume");
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onPurchasePackageInitiated(rcPackage, resume);
                } else {
                    Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseStarted(Package rcPackage) {
                Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseStarted(rcPackage);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreCompleted(CustomerInfo customerInfo) {
                String requiredEntitlementIdentifier;
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreCompleted(customerInfo);
                }
                PaywallActivity paywallActivity = this;
                paywallActivity.setResult(-1, paywallActivity.createResultIntent(new PaywallResult.Restored(customerInfo)));
                PaywallActivityArgs paywallActivityArgs = args;
                if (paywallActivityArgs == null || (requiredEntitlementIdentifier = paywallActivityArgs.getRequiredEntitlementIdentifier()) == null || !customerInfo.getEntitlements().getActive().containsKey(requiredEntitlementIdentifier)) {
                    return;
                }
                this.finish();
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreError(error);
                }
                PaywallActivity paywallActivity = this;
                paywallActivity.setResult(-1, paywallActivity.createResultIntent(new PaywallResult.Error(error)));
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreInitiated(Resumable resume) {
                Intrinsics.checkNotNullParameter(resume, "resume");
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreInitiated(resume);
                } else {
                    Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreStarted() {
                PaywallListener paywallListener = listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreStarted();
                }
            }
        };
        if (args != null && args.getEdgeToEdge()) {
            z2 = true;
        }
        if (z2) {
            EdgeToEdge.b(this, null, null, 3, null);
        }
        final OfferingSelection.IdAndPresentedOfferingContext offeringIdAndPresentedOfferingContext = args != null ? args.getOfferingIdAndPresentedOfferingContext() : null;
        ComponentActivityKt.b(this, null, ComposableLambdaKt.c(2032214180, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity.onCreate.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer, int i3) {
                if ((i3 & 3) == 2 && composer.l()) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(2032214180, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity.onCreate.<anonymous> (PaywallActivity.kt:202)");
                }
                final OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext = offeringIdAndPresentedOfferingContext;
                final PaywallActivity paywallActivity = this;
                final PaywallActivityArgs paywallActivityArgs = args;
                final PaywallActivity$onCreate$compositeListener$1 paywallActivity$onCreate$compositeListener$1 = r5;
                final PaywallPurchaseLogic paywallPurchaseLogic = purchaseLogic;
                MaterialThemeKt.b(null, null, null, ComposableLambdaKt.e(-588670640, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity.onCreate.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer2, int i4) {
                        if ((i4 & 3) == 2 && composer2.l()) {
                            composer2.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(-588670640, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity.onCreate.<anonymous>.<anonymous> (PaywallActivity.kt:205)");
                        }
                        WindowInsets windowInsetsA = WindowInsetsKt.a(0, 0, 0, 0);
                        final OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext2 = idAndPresentedOfferingContext;
                        final PaywallActivity paywallActivity2 = paywallActivity;
                        final PaywallActivityArgs paywallActivityArgs2 = paywallActivityArgs;
                        final PaywallActivity$onCreate$compositeListener$1 paywallActivity$onCreate$compositeListener$12 = paywallActivity$onCreate$compositeListener$1;
                        final PaywallPurchaseLogic paywallPurchaseLogic2 = paywallPurchaseLogic;
                        ScaffoldKt.a(null, null, null, null, null, 0, 0L, 0L, windowInsetsA, ComposableLambdaKt.e(2025926559, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity.onCreate.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((PaddingValues) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(PaddingValues anonymous$parameter$0$, Composer composer3, int i5) {
                                Map<String, CustomVariableValue> mapEmptyMap;
                                Intrinsics.checkNotNullParameter(anonymous$parameter$0$, "$anonymous$parameter$0$");
                                if ((i5 & 17) == 16 && composer3.l()) {
                                    composer3.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(2025926559, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (PaywallActivity.kt:208)");
                                }
                                Modifier modifierF = SizeKt.f(Modifier.b8, 0.0f, 1, null);
                                OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext3 = idAndPresentedOfferingContext2;
                                PaywallActivity paywallActivity3 = paywallActivity2;
                                PaywallActivityArgs paywallActivityArgs3 = paywallActivityArgs2;
                                PaywallActivity$onCreate$compositeListener$1 paywallActivity$onCreate$compositeListener$13 = paywallActivity$onCreate$compositeListener$12;
                                PaywallPurchaseLogic paywallPurchaseLogic3 = paywallPurchaseLogic2;
                                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                                int iA = ComposablesKt.a(composer3, 0);
                                CompositionLocalMap compositionLocalMapU = composer3.u();
                                Modifier modifierF2 = ComposedModifierKt.f(composer3, modifierF);
                                ComposeUiNode.Companion companion = ComposeUiNode.f8;
                                Function0 function0A = companion.a();
                                if (composer3.m() == null) {
                                    ComposablesKt.c();
                                }
                                composer3.L();
                                if (composer3.i()) {
                                    composer3.P(function0A);
                                } else {
                                    composer3.v();
                                }
                                Composer composerA = Updater.a(composer3);
                                Updater.e(composerA, measurePolicyG, companion.e());
                                Updater.e(composerA, compositionLocalMapU, companion.g());
                                Function2 function2B = companion.b();
                                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                                    composerA.w(Integer.valueOf(iA));
                                    composerA.p(Integer.valueOf(iA), function2B);
                                }
                                Updater.e(composerA, modifierF2, companion.f());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                                PaywallOptions.Builder purchaseLogic2 = new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity$onCreate$1$1$1$1$paywallOptions$1
                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m695invoke() {
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m695invoke();
                                        return Unit.f139807a;
                                    }
                                }).setOfferingSelection$revenuecatui_defaultsBc8Release((OfferingSelection) idAndPresentedOfferingContext3).setFontProvider(paywallActivity3.getFontProvider()).setShouldDisplayDismissButton(paywallActivityArgs3 != null ? paywallActivityArgs3.getShouldDisplayDismissButton() : true).setListener(paywallActivity$onCreate$compositeListener$13).setPurchaseLogic(paywallPurchaseLogic3);
                                composer3.a0(1035114476);
                                boolean zI = composer3.I(paywallActivity3);
                                Object objG = composer3.G();
                                if (zI || objG == Composer.f23746a.a()) {
                                    objG = new PaywallActivity$onCreate$1$1$1$1$paywallOptions$2$1(paywallActivity3);
                                    composer3.w(objG);
                                }
                                composer3.U();
                                PaywallOptions.Builder dismissRequestWithExitOffering$revenuecatui_defaultsBc8Release = purchaseLogic2.setDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release((Function2<? super Offering, ? super PaywallResult, Unit>) ((KFunction) objG));
                                if (paywallActivityArgs3 == null || (mapEmptyMap = paywallActivityArgs3.getCustomVariables()) == null) {
                                    mapEmptyMap = MapsKt.emptyMap();
                                }
                                PaywallOptions paywallOptionsBuild = dismissRequestWithExitOffering$revenuecatui_defaultsBc8Release.setCustomVariables(mapEmptyMap).build();
                                PaywallViewModel paywallViewModel = InternalPaywallKt.getPaywallViewModel(paywallOptionsBuild, null, composer3, 0, 2);
                                Unit unit = Unit.f139807a;
                                composer3.a0(1035122993);
                                boolean Z = composer3.Z(paywallViewModel);
                                Object objG2 = composer3.G();
                                if (Z || objG2 == Composer.f23746a.a()) {
                                    objG2 = new PaywallActivity$onCreate$1$1$1$1$1$1(paywallViewModel, null);
                                    composer3.w(objG2);
                                }
                                composer3.U();
                                EffectsKt.g(unit, (Function2) objG2, composer3, 6);
                                PaywallKt.Paywall(paywallOptionsBuild, composer3, 0);
                                composer3.y();
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        }, composer2, 54), composer2, 805306368, 255);
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }, composer, 54), composer, 3072, 7);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }), 1, null);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        SdkConfigurationStateKt.saveSdkConfiguration(outState);
        super.onSaveInstanceState(outState);
    }
}
