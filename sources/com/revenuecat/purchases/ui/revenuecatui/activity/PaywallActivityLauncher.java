package com.revenuecat.purchases.ui.revenuecatui.activity;

import android.app.Activity;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLaunchIfNeededOptions;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLaunchOptions;
import com.revenuecat.purchases.ui.revenuecatui.fonts.ParcelizableFontProvider;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
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
public final class PaywallActivityLauncher {
    public static final int $stable = 8;
    private final ActivityResultLauncher<PaywallActivityArgs> activityResultLauncher;
    private Integer currentNonSerializableArgsKey;
    private final WeakReference<Activity> weakActivity;
    private final WeakReference<Fragment> weakFragment;

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallActivityLauncher(ActivityResultCaller resultCaller, final PaywallResultHandler resultHandler) {
        Intrinsics.checkNotNullParameter(resultCaller, "resultCaller");
        Intrinsics.checkNotNullParameter(resultHandler, "resultHandler");
        this.weakActivity = new WeakReference<>(resultCaller instanceof Activity ? (Activity) resultCaller : null);
        this.weakFragment = new WeakReference<>(resultCaller instanceof Fragment ? (Fragment) resultCaller : null);
        this.activityResultLauncher = resultCaller.registerForActivityResult(new PaywallContract(), new PaywallResultHandler() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLauncher$wrappedHandler$1
            @Override // com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResultHandler, androidx.activity.result.ActivityResultCallback
            public void onActivityResult(PaywallResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Integer num = this.this$0.currentNonSerializableArgsKey;
                if (num != null) {
                    PaywallActivityLauncher paywallActivityLauncher = this.this$0;
                    PaywallActivityNonSerializableArgsStore.INSTANCE.remove(num.intValue());
                    paywallActivityLauncher.currentNonSerializableArgsKey = null;
                }
                resultHandler.onActivityResult(result);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean isActivityFinishing() {
        /*
            r4 = this;
            java.lang.ref.WeakReference<android.app.Activity> r0 = r4.weakActivity
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            java.lang.ref.WeakReference<androidx.fragment.app.Fragment> r1 = r4.weakFragment
            java.lang.Object r1 = r1.get()
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            r2 = 1
            if (r0 != 0) goto L1d
            if (r1 == 0) goto L1a
            androidx.fragment.app.FragmentActivity r3 = r1.getActivity()
            goto L1b
        L1a:
            r3 = 0
        L1b:
            if (r3 == 0) goto L34
        L1d:
            if (r0 == 0) goto L26
            boolean r0 = r0.isFinishing()
            if (r0 != r2) goto L26
            goto L34
        L26:
            if (r1 == 0) goto L35
            androidx.fragment.app.FragmentActivity r0 = r1.getActivity()
            if (r0 == 0) goto L35
            boolean r0 = r0.isFinishing()
            if (r0 != r2) goto L35
        L34:
            return r2
        L35:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLauncher.isActivityFinishing():boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void launch$default(PaywallActivityLauncher paywallActivityLauncher, Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            offering = null;
        }
        if ((i3 & 2) != 0) {
            parcelizableFontProvider = null;
        }
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        if ((i3 & 8) != 0) {
            z3 = PaywallActivityArgsKt.getDefaultEdgeToEdge();
        }
        if ((i3 & 16) != 0) {
            map = MapsKt.emptyMap();
        }
        paywallActivityLauncher.launch(offering, parcelizableFontProvider, z2, z3, map);
    }

    public static /* synthetic */ void launchIfNeeded$default(PaywallActivityLauncher paywallActivityLauncher, String str, Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3, PaywallDisplayCallback paywallDisplayCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            offering = null;
        }
        if ((i3 & 4) != 0) {
            parcelizableFontProvider = null;
        }
        if ((i3 & 8) != 0) {
            z2 = true;
        }
        if ((i3 & 16) != 0) {
            z3 = PaywallActivityArgsKt.getDefaultEdgeToEdge();
        }
        if ((i3 & 32) != 0) {
            paywallDisplayCallback = null;
        }
        paywallActivityLauncher.launchIfNeeded(str, offering, parcelizableFontProvider, z2, z3, paywallDisplayCallback);
    }

    public static /* synthetic */ void launchIfNeededWithOfferingId$default(PaywallActivityLauncher paywallActivityLauncher, String str, String str2, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3, PaywallDisplayCallback paywallDisplayCallback, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            parcelizableFontProvider = null;
        }
        if ((i3 & 16) != 0) {
            z2 = true;
        }
        if ((i3 & 32) != 0) {
            z3 = PaywallActivityArgsKt.getDefaultEdgeToEdge();
        }
        if ((i3 & 64) != 0) {
            paywallDisplayCallback = null;
        }
        paywallActivityLauncher.launchIfNeededWithOfferingId(str, str2, presentedOfferingContext, parcelizableFontProvider, z2, z3, paywallDisplayCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchPaywallWithArgs(PaywallActivityArgs paywallActivityArgs) {
        if (isActivityFinishing()) {
            Logger.INSTANCE.e("Not displaying paywall because activity/fragment is finishing or has finished.");
        } else {
            this.activityResultLauncher.b(paywallActivityArgs);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void launchWithOfferingId$default(PaywallActivityLauncher paywallActivityLauncher, String str, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            parcelizableFontProvider = null;
        }
        ParcelizableFontProvider parcelizableFontProvider2 = parcelizableFontProvider;
        if ((i3 & 8) != 0) {
            z2 = true;
        }
        boolean z4 = z2;
        if ((i3 & 16) != 0) {
            z3 = PaywallActivityArgsKt.getDefaultEdgeToEdge();
        }
        boolean z5 = z3;
        if ((i3 & 32) != 0) {
            map = MapsKt.emptyMap();
        }
        paywallActivityLauncher.launchWithOfferingId(str, presentedOfferingContext, parcelizableFontProvider2, z4, z5, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer storeNonSerializableArgsIfNeeded(PaywallPurchaseLogic paywallPurchaseLogic, PaywallListener paywallListener) {
        if (paywallPurchaseLogic == null && paywallListener == null) {
            return null;
        }
        int iStore = PaywallActivityNonSerializableArgsStore.INSTANCE.store(new PaywallActivityNonSerializableArgs(paywallPurchaseLogic, paywallListener));
        this.currentNonSerializableArgsKey = Integer.valueOf(iStore);
        return Integer.valueOf(iStore);
    }

    public final void launch() {
        launch$default(this, null, null, false, false, null, 31, null);
    }

    public final void launchIfNeeded(Offering offering, ParcelizableFontProvider parcelizableFontProvider, Function1<? super CustomerInfo, Boolean> shouldDisplayBlock) {
        Intrinsics.checkNotNullParameter(shouldDisplayBlock, "shouldDisplayBlock");
        launchIfNeeded$default(this, offering, parcelizableFontProvider, false, false, shouldDisplayBlock, 12, null);
    }

    @Deprecated
    public final void launchIfNeededWithOfferingId(String requiredEntitlementIdentifier, String offeringIdentifier, PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchIfNeededWithOfferingId$default(this, requiredEntitlementIdentifier, offeringIdentifier, presentedOfferingContext, null, false, false, null, 120, null);
    }

    public final void launchIfNeededWithOptions(final PaywallActivityLaunchIfNeededOptions options) {
        Function1<CustomerInfo, Boolean> shouldDisplayBlock$revenuecatui_defaultsBc8Release;
        Intrinsics.checkNotNullParameter(options, "options");
        if (options.getRequiredEntitlementIdentifier$revenuecatui_defaultsBc8Release() != null) {
            shouldDisplayBlock$revenuecatui_defaultsBc8Release = HelperFunctionsKt.shouldDisplayBlockForEntitlementIdentifier(options.getRequiredEntitlementIdentifier$revenuecatui_defaultsBc8Release());
        } else {
            shouldDisplayBlock$revenuecatui_defaultsBc8Release = options.getShouldDisplayBlock$revenuecatui_defaultsBc8Release();
            Intrinsics.checkNotNull(shouldDisplayBlock$revenuecatui_defaultsBc8Release);
        }
        HelperFunctionsKt.shouldDisplayPaywall(shouldDisplayBlock$revenuecatui_defaultsBc8Release, new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLauncher.launchIfNeededWithOptions.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.f139807a;
            }

            public final void invoke(boolean z2) {
                PaywallDisplayCallback paywallDisplayCallback$revenuecatui_defaultsBc8Release = options.getPaywallDisplayCallback$revenuecatui_defaultsBc8Release();
                if (paywallDisplayCallback$revenuecatui_defaultsBc8Release != null) {
                    paywallDisplayCallback$revenuecatui_defaultsBc8Release.onPaywallDisplayResult(z2);
                }
                if (z2) {
                    this.launchPaywallWithArgs(new PaywallActivityArgs(options.getRequiredEntitlementIdentifier$revenuecatui_defaultsBc8Release(), options.toOfferingSelection$revenuecatui_defaultsBc8Release(), options.getFontProvider$revenuecatui_defaultsBc8Release(), options.getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release(), options.getEdgeToEdge$revenuecatui_defaultsBc8Release(), false, (Map) options.getCustomVariables$revenuecatui_defaultsBc8Release(), this.storeNonSerializableArgsIfNeeded(options.getPurchaseLogic$revenuecatui_defaultsBc8Release(), options.getListener$revenuecatui_defaultsBc8Release()), 32, (DefaultConstructorMarker) null));
                }
            }
        });
    }

    @Deprecated
    public final void launchWithOfferingId(String offeringIdentifier, PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchWithOfferingId$default(this, offeringIdentifier, presentedOfferingContext, null, false, false, null, 60, null);
    }

    public final void launchWithOptions(PaywallActivityLaunchOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.activityResultLauncher.b(new PaywallActivityArgs((String) null, options.toOfferingSelection$revenuecatui_defaultsBc8Release(), options.getFontProvider$revenuecatui_defaultsBc8Release(), options.getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release(), options.getEdgeToEdge$revenuecatui_defaultsBc8Release(), false, (Map) options.getCustomVariables$revenuecatui_defaultsBc8Release(), storeNonSerializableArgsIfNeeded(options.getPurchaseLogic$revenuecatui_defaultsBc8Release(), options.getListener$revenuecatui_defaultsBc8Release()), 33, (DefaultConstructorMarker) null));
    }

    public final void launch(Offering offering) {
        launch$default(this, offering, null, false, false, null, 30, null);
    }

    public final void launchIfNeeded(Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z2, Function1<? super CustomerInfo, Boolean> shouldDisplayBlock) {
        Intrinsics.checkNotNullParameter(shouldDisplayBlock, "shouldDisplayBlock");
        launchIfNeeded$default(this, offering, parcelizableFontProvider, z2, false, shouldDisplayBlock, 8, null);
    }

    @Deprecated
    public final void launchIfNeededWithOfferingId(String requiredEntitlementIdentifier, String offeringIdentifier, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchIfNeededWithOfferingId$default(this, requiredEntitlementIdentifier, offeringIdentifier, presentedOfferingContext, parcelizableFontProvider, false, false, null, 112, null);
    }

    @Deprecated
    public final void launchWithOfferingId(String offeringIdentifier, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider) {
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchWithOfferingId$default(this, offeringIdentifier, presentedOfferingContext, parcelizableFontProvider, false, false, null, 56, null);
    }

    public static /* synthetic */ void launchIfNeeded$default(PaywallActivityLauncher paywallActivityLauncher, String str, String str2, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3, PaywallDisplayCallback paywallDisplayCallback, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            parcelizableFontProvider = null;
        }
        if ((i3 & 8) != 0) {
            z2 = true;
        }
        if ((i3 & 16) != 0) {
            z3 = PaywallActivityArgsKt.getDefaultEdgeToEdge();
        }
        if ((i3 & 32) != 0) {
            paywallDisplayCallback = null;
        }
        paywallActivityLauncher.launchIfNeeded(str, str2, parcelizableFontProvider, z2, z3, paywallDisplayCallback);
    }

    public final void launch(Offering offering, ParcelizableFontProvider parcelizableFontProvider) {
        launch$default(this, offering, parcelizableFontProvider, false, false, null, 28, null);
    }

    public final void launchIfNeeded(Offering offering, Function1<? super CustomerInfo, Boolean> shouldDisplayBlock) {
        Intrinsics.checkNotNullParameter(shouldDisplayBlock, "shouldDisplayBlock");
        launchIfNeeded$default(this, offering, null, false, false, shouldDisplayBlock, 14, null);
    }

    @Deprecated
    public final void launchIfNeededWithOfferingId(String requiredEntitlementIdentifier, String offeringIdentifier, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z2) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchIfNeededWithOfferingId$default(this, requiredEntitlementIdentifier, offeringIdentifier, presentedOfferingContext, parcelizableFontProvider, z2, false, null, 96, null);
    }

    @Deprecated
    public final void launchWithOfferingId(String offeringIdentifier, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z2) {
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchWithOfferingId$default(this, offeringIdentifier, presentedOfferingContext, parcelizableFontProvider, z2, false, null, 48, null);
    }

    public static /* synthetic */ void launch$default(PaywallActivityLauncher paywallActivityLauncher, String str, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            parcelizableFontProvider = null;
        }
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        if ((i3 & 8) != 0) {
            z3 = PaywallActivityArgsKt.getDefaultEdgeToEdge();
        }
        paywallActivityLauncher.launch(str, parcelizableFontProvider, z2, z3);
    }

    public final void launch(Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z2) {
        launch$default(this, offering, parcelizableFontProvider, z2, false, null, 24, null);
    }

    public final void launchIfNeeded(String requiredEntitlementIdentifier) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        launchIfNeeded$default(this, requiredEntitlementIdentifier, (Offering) null, (ParcelizableFontProvider) null, false, false, (PaywallDisplayCallback) null, 62, (Object) null);
    }

    @Deprecated
    public final void launchIfNeededWithOfferingId(String requiredEntitlementIdentifier, String offeringIdentifier, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchIfNeededWithOfferingId$default(this, requiredEntitlementIdentifier, offeringIdentifier, presentedOfferingContext, parcelizableFontProvider, z2, z3, null, 64, null);
    }

    @Deprecated
    public final void launchWithOfferingId(String str, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, FptyjHFU.rUFMuyAVdmM);
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchWithOfferingId$default(this, str, presentedOfferingContext, parcelizableFontProvider, z2, z3, null, 32, null);
    }

    public static /* synthetic */ void launchIfNeeded$default(PaywallActivityLauncher paywallActivityLauncher, Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            offering = null;
        }
        if ((i3 & 2) != 0) {
            parcelizableFontProvider = null;
        }
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        if ((i3 & 8) != 0) {
            z3 = PaywallActivityArgsKt.getDefaultEdgeToEdge();
        }
        paywallActivityLauncher.launchIfNeeded(offering, parcelizableFontProvider, z2, z3, (Function1<? super CustomerInfo, Boolean>) function1);
    }

    public final void launch(Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3) {
        launch$default(this, offering, parcelizableFontProvider, z2, z3, null, 16, null);
    }

    public final void launchIfNeeded(String requiredEntitlementIdentifier, Offering offering) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        launchIfNeeded$default(this, requiredEntitlementIdentifier, offering, (ParcelizableFontProvider) null, false, false, (PaywallDisplayCallback) null, 60, (Object) null);
    }

    @Deprecated
    public final void launchIfNeededWithOfferingId(String requiredEntitlementIdentifier, String offeringIdentifier, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3, PaywallDisplayCallback paywallDisplayCallback) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        launchIfNeededWithOptions(new PaywallActivityLaunchIfNeededOptions.Builder().setRequiredEntitlementIdentifier(requiredEntitlementIdentifier).setOfferingIdentifier(offeringIdentifier, presentedOfferingContext).setFontProvider(parcelizableFontProvider).setShouldDisplayDismissButton(z2).setEdgeToEdge(z3).setPaywallDisplayCallback(paywallDisplayCallback).build());
    }

    @Deprecated
    public final void launchWithOfferingId(String offeringIdentifier, PresentedOfferingContext presentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3, Map<String, ? extends CustomVariableValue> customVariables) {
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        launchWithOptions(new PaywallActivityLaunchOptions.Builder().setOfferingIdentifier(offeringIdentifier, presentedOfferingContext).setFontProvider(parcelizableFontProvider).setShouldDisplayDismissButton(z2).setEdgeToEdge(z3).setCustomVariables(customVariables).build());
    }

    public final void launch(Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3, Map<String, ? extends CustomVariableValue> customVariables) {
        OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext;
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        ActivityResultLauncher<PaywallActivityArgs> activityResultLauncher = this.activityResultLauncher;
        if (offering != null) {
            String identifier = offering.getIdentifier();
            Package r13 = (Package) CollectionsKt.firstOrNull((List) offering.getAvailablePackages());
            idAndPresentedOfferingContext = new OfferingSelection.IdAndPresentedOfferingContext(identifier, r13 != null ? r13.getPresentedOfferingContext() : null);
        } else {
            idAndPresentedOfferingContext = null;
        }
        activityResultLauncher.b(new PaywallActivityArgs((String) null, idAndPresentedOfferingContext, parcelizableFontProvider, z2, z3, false, (Map) customVariables, (Integer) null, 161, (DefaultConstructorMarker) null));
    }

    public final void launchIfNeeded(String requiredEntitlementIdentifier, Offering offering, ParcelizableFontProvider parcelizableFontProvider) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        launchIfNeeded$default(this, requiredEntitlementIdentifier, offering, parcelizableFontProvider, false, false, (PaywallDisplayCallback) null, 56, (Object) null);
    }

    public final void launchIfNeeded(String requiredEntitlementIdentifier, Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z2) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        launchIfNeeded$default(this, requiredEntitlementIdentifier, offering, parcelizableFontProvider, z2, false, (PaywallDisplayCallback) null, 48, (Object) null);
    }

    public final void launchIfNeeded(String requiredEntitlementIdentifier, Offering offering, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        launchIfNeeded$default(this, requiredEntitlementIdentifier, offering, parcelizableFontProvider, z2, z3, (PaywallDisplayCallback) null, 32, (Object) null);
    }

    public final void launchIfNeeded(Function1<? super CustomerInfo, Boolean> shouldDisplayBlock) {
        Intrinsics.checkNotNullParameter(shouldDisplayBlock, "shouldDisplayBlock");
        launchIfNeeded$default(this, null, null, false, false, shouldDisplayBlock, 15, null);
    }

    public final void launchIfNeeded(final String requiredEntitlementIdentifier, final Offering offering, final ParcelizableFontProvider parcelizableFontProvider, final boolean z2, final boolean z3, final PaywallDisplayCallback paywallDisplayCallback) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        HelperFunctionsKt.shouldDisplayPaywall(HelperFunctionsKt.shouldDisplayBlockForEntitlementIdentifier(requiredEntitlementIdentifier), new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLauncher.launchIfNeeded.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.f139807a;
            }

            public final void invoke(boolean z4) {
                PaywallDisplayCallback paywallDisplayCallback2 = paywallDisplayCallback;
                if (paywallDisplayCallback2 != null) {
                    paywallDisplayCallback2.onPaywallDisplayResult(z4);
                }
                if (z4) {
                    PaywallActivityLauncher paywallActivityLauncher = this;
                    String str = requiredEntitlementIdentifier;
                    Offering offering2 = offering;
                    OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext = null;
                    if (offering2 != null) {
                        String identifier = offering2.getIdentifier();
                        Package r02 = (Package) CollectionsKt.firstOrNull((List) offering2.getAvailablePackages());
                        idAndPresentedOfferingContext = new OfferingSelection.IdAndPresentedOfferingContext(identifier, r02 != null ? r02.getPresentedOfferingContext() : null);
                    }
                    paywallActivityLauncher.launchPaywallWithArgs(new PaywallActivityArgs(str, idAndPresentedOfferingContext, parcelizableFontProvider, z2, z3, false, (Map) null, (Integer) null, 224, (DefaultConstructorMarker) null));
                }
            }
        });
    }

    @Deprecated
    public final /* synthetic */ void launchIfNeeded(final String requiredEntitlementIdentifier, final String offeringIdentifier, final ParcelizableFontProvider parcelizableFontProvider, final boolean z2, final boolean z3, final PaywallDisplayCallback paywallDisplayCallback) {
        Intrinsics.checkNotNullParameter(requiredEntitlementIdentifier, "requiredEntitlementIdentifier");
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        HelperFunctionsKt.shouldDisplayPaywall(HelperFunctionsKt.shouldDisplayBlockForEntitlementIdentifier(requiredEntitlementIdentifier), new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLauncher.launchIfNeeded.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.f139807a;
            }

            public final void invoke(boolean z4) {
                PaywallDisplayCallback paywallDisplayCallback2 = paywallDisplayCallback;
                if (paywallDisplayCallback2 != null) {
                    paywallDisplayCallback2.onPaywallDisplayResult(z4);
                }
                if (z4) {
                    this.launchPaywallWithArgs(new PaywallActivityArgs(requiredEntitlementIdentifier, new OfferingSelection.IdAndPresentedOfferingContext(offeringIdentifier, null), parcelizableFontProvider, z2, z3, false, (Map) null, (Integer) null, 224, (DefaultConstructorMarker) null));
                }
            }
        });
    }

    @Deprecated
    public final /* synthetic */ void launch(String offeringIdentifier, ParcelizableFontProvider parcelizableFontProvider, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        this.activityResultLauncher.b(new PaywallActivityArgs((String) null, new OfferingSelection.IdAndPresentedOfferingContext(offeringIdentifier, null), parcelizableFontProvider, z2, z3, false, (Map) null, (Integer) null, 225, (DefaultConstructorMarker) null));
    }

    public final void launchIfNeeded(final Offering offering, final ParcelizableFontProvider parcelizableFontProvider, final boolean z2, final boolean z3, Function1<? super CustomerInfo, Boolean> shouldDisplayBlock) {
        Intrinsics.checkNotNullParameter(shouldDisplayBlock, "shouldDisplayBlock");
        HelperFunctionsKt.shouldDisplayPaywall(shouldDisplayBlock, new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityLauncher.launchIfNeeded.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.f139807a;
            }

            public final void invoke(boolean z4) {
                OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext;
                if (z4) {
                    PaywallActivityLauncher paywallActivityLauncher = PaywallActivityLauncher.this;
                    Offering offering2 = offering;
                    if (offering2 != null) {
                        String identifier = offering2.getIdentifier();
                        Package r2 = (Package) CollectionsKt.firstOrNull((List) offering2.getAvailablePackages());
                        idAndPresentedOfferingContext = new OfferingSelection.IdAndPresentedOfferingContext(identifier, r2 != null ? r2.getPresentedOfferingContext() : null);
                    } else {
                        idAndPresentedOfferingContext = null;
                    }
                    paywallActivityLauncher.launchPaywallWithArgs(new PaywallActivityArgs((String) null, idAndPresentedOfferingContext, parcelizableFontProvider, z2, z3, false, (Map) null, (Integer) null, 225, (DefaultConstructorMarker) null));
                }
            }
        });
    }
}
