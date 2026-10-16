package com.revenuecat.purchases.ui.revenuecatui.views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableKeyValidator;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.PaywallKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.fonts.FontProvider;
import com.revenuecat.purchases.ui.revenuecatui.utils.Resumable;
import com.revenuecat.purchases.ui.revenuecatui.views.PaywallViewAttributesReader;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class PaywallView extends CompatComposeView {
    public static final int $stable = 8;
    private Function0<Unit> dismissHandler;
    private FontProvider initialFontProvider;
    private OfferingSelection.IdAndPresentedOfferingContext initialOfferingInfo;
    private PaywallListener internalListener;
    private PaywallListener listener;
    private final MutableState<PaywallOptions> paywallOptionsState;
    private PaywallPurchaseLogic purchaseLogic;
    private Boolean shouldDisplayDismissButton;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context) {
        this(context, null, null, null, null, null, null, 126, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaywallOptions Content$lambda$4(MutableState<PaywallOptions> mutableState) {
        return (PaywallOptions) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismiss() {
        Function0<Unit> function0 = this.dismissHandler;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final PaywallOptions getPaywallOptions() {
        return (PaywallOptions) this.paywallOptionsState.getValue();
    }

    private final void init(Context context, AttributeSet attributeSet) {
        parseAttributes(context, attributeSet);
        PaywallOptions.Builder offeringIdAndPresentedOfferingContext$revenuecatui_defaultsBc8Release = new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.PaywallView.init.1
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m1238invoke() {
                PaywallView.this.dismiss();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m1238invoke();
                return Unit.f139807a;
            }
        }).setListener(this.internalListener).setFontProvider(this.initialFontProvider).setOfferingIdAndPresentedOfferingContext$revenuecatui_defaultsBc8Release(this.initialOfferingInfo);
        Boolean bool = this.shouldDisplayDismissButton;
        setPaywallOptions(offeringIdAndPresentedOfferingContext$revenuecatui_defaultsBc8Release.setShouldDisplayDismissButton(bool != null ? bool.booleanValue() : false).setPurchaseLogic(this.purchaseLogic).build());
    }

    private final void parseAttributes(Context context, AttributeSet attributeSet) {
        PaywallViewAttributesReader.Companion companion = PaywallViewAttributesReader.Companion;
        int[] PaywallView = R.styleable.PaywallView;
        Intrinsics.checkNotNullExpressionValue(PaywallView, "PaywallView");
        PaywallViewAttributesReader.PaywallViewAttributes attributes = companion.parseAttributes(context, attributeSet, PaywallView);
        if (attributes == null) {
            return;
        }
        String strComponent1 = attributes.component1();
        FontProvider fontProviderComponent2 = attributes.component2();
        Boolean boolComponent3 = attributes.component3();
        this.initialOfferingInfo = strComponent1 != null ? new OfferingSelection.IdAndPresentedOfferingContext(strComponent1, null) : null;
        this.initialFontProvider = fontProviderComponent2;
        this.shouldDisplayDismissButton = boolComponent3;
    }

    public static /* synthetic */ void setOfferingId$default(PaywallView paywallView, String str, PresentedOfferingContext presentedOfferingContext, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            presentedOfferingContext = null;
        }
        paywallView.setOfferingId(str, presentedOfferingContext);
    }

    private final void setPaywallOptions(PaywallOptions paywallOptions) {
        this.paywallOptionsState.setValue(paywallOptions);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer composer, int i3) {
        composer.a0(1456977972);
        if (ComposerKt.M()) {
            ComposerKt.U(1456977972, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.views.PaywallView.Content (PaywallView.kt:228)");
        }
        composer.a0(502098637);
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = this.paywallOptionsState;
            composer.w(objG);
        }
        final MutableState mutableState = (MutableState) objG;
        composer.U();
        RevenueCatThemeKt.RevenueCatTheme(ComposableLambdaKt.e(226220304, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.PaywallView.Content.1
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
                    ComposerKt.U(226220304, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.views.PaywallView.Content.<anonymous> (PaywallView.kt:233)");
                }
                PaywallKt.Paywall(PaywallView.Content$lambda$4(mutableState), composer2, 0);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }, composer, 54), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.views.CompatComposeView
    public void onBackPressed() {
        Unit unit;
        if (this.dismissHandler != null) {
            dismiss();
            unit = Unit.f139807a;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.onBackPressed();
        }
    }

    public final void setCustomVariables(Map<String, ? extends CustomVariableValue> variables) {
        Intrinsics.checkNotNullParameter(variables, "variables");
        setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), null, false, null, null, null, null, null, null, CustomVariableKeyValidator.INSTANCE.validateAndFilter(variables), 255, null));
    }

    public final void setDismissHandler(Function0<Unit> function0) {
        this.dismissHandler = function0;
    }

    public final void setDisplayDismissButton(boolean z2) {
        setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), null, z2, null, null, null, null, null, null, null, 509, null));
    }

    public final void setFontProvider(FontProvider fontProvider) {
        setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), null, false, fontProvider, null, null, null, null, null, null, 507, null));
    }

    public final void setOfferingId(String str) {
        setOfferingId$default(this, str, null, 2, null);
    }

    public final void setPaywallListener(PaywallListener paywallListener) {
        this.listener = paywallListener;
    }

    public final void setPurchaseLogic(PaywallPurchaseLogic paywallPurchaseLogic) {
        this.purchaseLogic = paywallPurchaseLogic;
        setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), null, false, null, null, paywallPurchaseLogic, null, null, null, null, 495, null));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, Offering offering) {
        this(context, offering, null, null, null, null, null, 124, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setOfferingId(String str, PresentedOfferingContext presentedOfferingContext) {
        setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), str == null ? OfferingSelection.None.INSTANCE : new OfferingSelection.IdAndPresentedOfferingContext(str, presentedOfferingContext), false, null, null, null, null, null, null, null, 510, null));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, Offering offering, PaywallListener paywallListener) {
        this(context, offering, paywallListener, null, null, null, null, 120, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider) {
        this(context, offering, paywallListener, fontProvider, null, null, null, 112, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider, Boolean bool) {
        this(context, offering, paywallListener, fontProvider, bool, null, null, 96, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider, Boolean bool, PaywallPurchaseLogic paywallPurchaseLogic) {
        this(context, offering, paywallListener, fontProvider, bool, paywallPurchaseLogic, null, 64, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paywallOptionsState = SnapshotStateKt__SnapshotStateKt.e(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.PaywallView$paywallOptionsState$1
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m1239invoke() {
                this.this$0.dismiss();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m1239invoke();
                return Unit.f139807a;
            }
        }).build(), null, 2, null);
        this.internalListener = new PaywallListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.PaywallView$internalListener$1
            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseCancelled() {
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseCancelled();
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseCompleted(CustomerInfo customerInfo, StoreTransaction storeTransaction) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseCompleted(customerInfo, storeTransaction);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseError(error);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchasePackageInitiated(Package rcPackage, Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                Intrinsics.checkNotNullParameter(resume, "resume");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchasePackageInitiated(rcPackage, resume);
                    unit = Unit.f139807a;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseStarted(Package rcPackage) {
                Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseStarted(rcPackage);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreCompleted(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreCompleted(customerInfo);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreError(error);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreInitiated(Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(resume, "resume");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreInitiated(resume);
                    unit = Unit.f139807a;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreStarted() {
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreStarted();
                }
            }
        };
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paywallOptionsState = SnapshotStateKt__SnapshotStateKt.e(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.PaywallView$paywallOptionsState$1
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m1239invoke() {
                this.this$0.dismiss();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m1239invoke();
                return Unit.f139807a;
            }
        }).build(), null, 2, null);
        this.internalListener = new PaywallListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.PaywallView$internalListener$1
            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseCancelled() {
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseCancelled();
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseCompleted(CustomerInfo customerInfo, StoreTransaction storeTransaction) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseCompleted(customerInfo, storeTransaction);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseError(error);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchasePackageInitiated(Package rcPackage, Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                Intrinsics.checkNotNullParameter(resume, "resume");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchasePackageInitiated(rcPackage, resume);
                    unit = Unit.f139807a;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseStarted(Package rcPackage) {
                Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onPurchaseStarted(rcPackage);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreCompleted(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreCompleted(customerInfo);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreError(error);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreInitiated(Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(resume, "resume");
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreInitiated(resume);
                    unit = Unit.f139807a;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreStarted() {
                PaywallListener paywallListener = this.this$0.listener;
                if (paywallListener != null) {
                    paywallListener.onRestoreStarted();
                }
            }
        };
        init(context, attributeSet);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider, Boolean bool, Function0<Unit> function0) {
        this(context, offering, paywallListener, fontProvider, bool, null, function0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PaywallView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider, Boolean bool, PaywallPurchaseLogic paywallPurchaseLogic, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : offering, (i3 & 4) != 0 ? null : paywallListener, (i3 & 8) != 0 ? null : fontProvider, (i3 & 16) != 0 ? null : bool, (i3 & 32) != 0 ? null : paywallPurchaseLogic, (i3 & 64) != 0 ? null : function0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaywallView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider, Boolean bool, PaywallPurchaseLogic paywallPurchaseLogic, Function0<Unit> function0) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paywallOptionsState = SnapshotStateKt__SnapshotStateKt.e(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.PaywallView$paywallOptionsState$1
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m1239invoke() {
                this.this$0.dismiss();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m1239invoke();
                return Unit.f139807a;
            }
        }).build(), null, 2, null);
        this.internalListener = new PaywallListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.PaywallView$internalListener$1
            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseCancelled() {
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onPurchaseCancelled();
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseCompleted(CustomerInfo customerInfo, StoreTransaction storeTransaction) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onPurchaseCompleted(customerInfo, storeTransaction);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onPurchaseError(error);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchasePackageInitiated(Package rcPackage, Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                Intrinsics.checkNotNullParameter(resume, "resume");
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onPurchasePackageInitiated(rcPackage, resume);
                    unit = Unit.f139807a;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onPurchaseStarted(Package rcPackage) {
                Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onPurchaseStarted(rcPackage);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreCompleted(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onRestoreCompleted(customerInfo);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onRestoreError(error);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreInitiated(Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(resume, "resume");
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onRestoreInitiated(resume);
                    unit = Unit.f139807a;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.DefaultImpls.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallListener
            public void onRestoreStarted() {
                PaywallListener paywallListener2 = this.this$0.listener;
                if (paywallListener2 != null) {
                    paywallListener2.onRestoreStarted();
                }
            }
        };
        setPaywallListener(paywallListener);
        setDismissHandler(function0);
        setPurchaseLogic(paywallPurchaseLogic);
        if (offering != null) {
            String identifier = offering.getIdentifier();
            Package r9 = (Package) CollectionsKt.firstOrNull((List) offering.getAvailablePackages());
            setOfferingId(identifier, r9 != null ? r9.getPresentedOfferingContext() : null);
        }
        this.shouldDisplayDismissButton = bool;
        this.initialFontProvider = fontProvider;
        init(context, null);
    }
}
