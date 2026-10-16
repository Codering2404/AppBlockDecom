package com.revenuecat.purchases.ui.revenuecatui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
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
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.PaywallFooterKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.fonts.FontProvider;
import com.revenuecat.purchases.ui.revenuecatui.utils.Resumable;
import com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView;
import com.revenuecat.purchases.ui.revenuecatui.views.PaywallViewAttributesReader;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
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
public class OriginalTemplatePaywallFooterView extends FrameLayout {
    public static final int $stable = 8;
    private Function0<Unit> dismissHandler;
    private boolean initialCondensed;
    private FontProvider initialFontProvider;
    private OfferingSelection.IdAndPresentedOfferingContext initialOfferingInfo;
    private PaywallListener internalListener;
    private PaywallListener listener;
    private final MutableState<PaywallOptions> paywallOptionsState;

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView$init$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass2 extends CompatComposeView {
        final /* synthetic */ OriginalTemplatePaywallFooterView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, OriginalTemplatePaywallFooterView originalTemplatePaywallFooterView) {
            super(context, null, 0, 6, null);
            this.this$0 = originalTemplatePaywallFooterView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final PaywallOptions Content$lambda$1(MutableState<PaywallOptions> mutableState) {
            return (PaywallOptions) mutableState.getValue();
        }

        @Override // androidx.compose.ui.platform.AbstractComposeView
        public void Content(Composer composer, int i3) {
            composer.a0(951143030);
            if (ComposerKt.M()) {
                ComposerKt.U(951143030, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView.init.<no name provided>.Content (OriginalTemplatePaywallFooterView.kt:192)");
            }
            composer.a0(-704718066);
            OriginalTemplatePaywallFooterView originalTemplatePaywallFooterView = this.this$0;
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = originalTemplatePaywallFooterView.paywallOptionsState;
                composer.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            composer.U();
            final OriginalTemplatePaywallFooterView originalTemplatePaywallFooterView2 = this.this$0;
            RevenueCatThemeKt.RevenueCatTheme(ComposableLambdaKt.e(-1757622246, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView$init$2$Content$1
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
                        ComposerKt.U(-1757622246, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView.init.<no name provided>.Content.<anonymous> (OriginalTemplatePaywallFooterView.kt:197)");
                    }
                    PaywallFooterKt.OriginalTemplatePaywallFooter(OriginalTemplatePaywallFooterView.AnonymousClass2.Content$lambda$1(mutableState), originalTemplatePaywallFooterView2.initialCondensed, null, composer2, 0, 4);
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
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OriginalTemplatePaywallFooterView(Context context) {
        this(context, null, null, null, false, null, 62, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final PaywallOptions getPaywallOptions() {
        return (PaywallOptions) this.paywallOptionsState.getValue();
    }

    private final void init(Context context, AttributeSet attributeSet) {
        parseAttributes(context, attributeSet);
        setPaywallOptions(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView.init.1
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m1236invoke() {
                Function0 function0 = OriginalTemplatePaywallFooterView.this.dismissHandler;
                if (function0 != null) {
                    function0.invoke();
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m1236invoke();
                return Unit.f139807a;
            }
        }).setListener(this.internalListener).setFontProvider(this.initialFontProvider).setOfferingIdAndPresentedOfferingContext$revenuecatui_defaultsBc8Release(this.initialOfferingInfo).build());
        addView(new AnonymousClass2(context, this));
    }

    private final void parseAttributes(Context context, AttributeSet attributeSet) {
        PaywallViewAttributesReader.Companion companion = PaywallViewAttributesReader.Companion;
        int[] PaywallFooterView = R.styleable.PaywallFooterView;
        Intrinsics.checkNotNullExpressionValue(PaywallFooterView, "PaywallFooterView");
        PaywallViewAttributesReader.PaywallViewAttributes attributes = companion.parseAttributes(context, attributeSet, PaywallFooterView);
        if (attributes == null) {
            return;
        }
        String strComponent1 = attributes.component1();
        FontProvider fontProviderComponent2 = attributes.component2();
        Boolean boolComponent4 = attributes.component4();
        this.initialOfferingInfo = strComponent1 != null ? new OfferingSelection.IdAndPresentedOfferingContext(strComponent1, null) : null;
        this.initialFontProvider = fontProviderComponent2;
        if (boolComponent4 != null) {
            this.initialCondensed = boolComponent4.booleanValue();
        }
    }

    private final void setPaywallOptions(PaywallOptions paywallOptions) {
        this.paywallOptionsState.setValue(paywallOptions);
    }

    public final void setDismissHandler(Function0<Unit> function0) {
        this.dismissHandler = function0;
    }

    public final void setFontProvider(FontProvider fontProvider) {
        setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), null, false, fontProvider, null, null, null, null, null, null, 507, null));
    }

    @Deprecated
    public final void setOfferingId(String str) {
        setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), str == null ? OfferingSelection.None.INSTANCE : new OfferingSelection.IdAndPresentedOfferingContext(str, null), false, null, null, null, null, null, null, null, 510, null));
    }

    public final void setOfferingIdAndPresentedOfferingContext(String str, PresentedOfferingContext presentedOfferingContext) {
        if (str == null) {
            setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), OfferingSelection.None.INSTANCE, false, null, null, null, null, null, null, null, 510, null));
        } else {
            setPaywallOptions(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(getPaywallOptions(), new OfferingSelection.IdAndPresentedOfferingContext(str, presentedOfferingContext), false, null, null, null, null, null, null, null, 510, null));
        }
    }

    public final void setPaywallListener(PaywallListener paywallListener) {
        this.listener = paywallListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OriginalTemplatePaywallFooterView(Context context, Offering offering) {
        this(context, offering, null, null, false, null, 60, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OriginalTemplatePaywallFooterView(Context context, Offering offering, PaywallListener paywallListener) {
        this(context, offering, paywallListener, null, false, null, 56, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OriginalTemplatePaywallFooterView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider) {
        this(context, offering, paywallListener, fontProvider, false, null, 48, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OriginalTemplatePaywallFooterView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider, boolean z2) {
        this(context, offering, paywallListener, fontProvider, z2, null, 32, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OriginalTemplatePaywallFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paywallOptionsState = SnapshotStateKt__SnapshotStateKt.e(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView$paywallOptionsState$1
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m1237invoke() {
                Function0 function0 = this.this$0.dismissHandler;
                if (function0 != null) {
                    function0.invoke();
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m1237invoke();
                return Unit.f139807a;
            }
        }).build(), null, 2, null);
        this.internalListener = new PaywallListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView$internalListener$1
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
            public void onPurchasePackageInitiated(Package r12, Resumable resumable) {
                PaywallListener.DefaultImpls.onPurchasePackageInitiated(this, r12, resumable);
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
    public OriginalTemplatePaywallFooterView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paywallOptionsState = SnapshotStateKt__SnapshotStateKt.e(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView$paywallOptionsState$1
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m1237invoke() {
                Function0 function0 = this.this$0.dismissHandler;
                if (function0 != null) {
                    function0.invoke();
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m1237invoke();
                return Unit.f139807a;
            }
        }).build(), null, 2, null);
        this.internalListener = new PaywallListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView$internalListener$1
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
            public void onPurchasePackageInitiated(Package r12, Resumable resumable) {
                PaywallListener.DefaultImpls.onPurchasePackageInitiated(this, r12, resumable);
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

    public /* synthetic */ OriginalTemplatePaywallFooterView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider, boolean z2, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : offering, (i3 & 4) != 0 ? null : paywallListener, (i3 & 8) != 0 ? null : fontProvider, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? null : function0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OriginalTemplatePaywallFooterView(Context context, Offering offering, PaywallListener paywallListener, FontProvider fontProvider, boolean z2, Function0<Unit> function0) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paywallOptionsState = SnapshotStateKt__SnapshotStateKt.e(new PaywallOptions.Builder(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView$paywallOptionsState$1
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m1237invoke() {
                Function0 function02 = this.this$0.dismissHandler;
                if (function02 != null) {
                    function02.invoke();
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m1237invoke();
                return Unit.f139807a;
            }
        }).build(), null, 2, null);
        this.internalListener = new PaywallListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.OriginalTemplatePaywallFooterView$internalListener$1
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
            public void onPurchasePackageInitiated(Package r12, Resumable resumable) {
                PaywallListener.DefaultImpls.onPurchasePackageInitiated(this, r12, resumable);
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
        setOfferingId(offering != null ? offering.getIdentifier() : null);
        this.initialFontProvider = fontProvider;
        this.initialCondensed = z2;
        init(context, null);
    }
}
