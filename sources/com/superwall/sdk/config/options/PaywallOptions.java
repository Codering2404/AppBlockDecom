package com.superwall.sdk.config.options;

import com.superwall.sdk.analytics.Tier;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

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
public final class PaywallOptions {
    private boolean automaticallyDismiss;
    private boolean isHapticFeedbackEnabled;
    private Integer loadingColor;
    private Function1<? super PaywallInfo, Boolean> onBackPressed;
    private boolean optimisticLoading;
    private Map<String, String> overrideProductsByName;
    private Map<Tier, Boolean> preloadDeviceOverrides;
    private RestoreFailed restoreFailed;
    private boolean shouldPreload;
    private boolean shouldShowPurchaseFailureAlert;
    private Duration timeoutAfter;
    private TransactionBackgroundView transactionBackgroundView;
    private boolean useCachedTemplates;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TransactionBackgroundView {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TransactionBackgroundView[] $VALUES;
        public static final TransactionBackgroundView SPINNER = new TransactionBackgroundView("SPINNER", 0);

        private static final /* synthetic */ TransactionBackgroundView[] $values() {
            return new TransactionBackgroundView[]{SPINNER};
        }

        static {
            TransactionBackgroundView[] transactionBackgroundViewArr$values = $values();
            $VALUES = transactionBackgroundViewArr$values;
            $ENTRIES = EnumEntriesKt.a(transactionBackgroundViewArr$values);
        }

        private TransactionBackgroundView(String str, int i3) {
        }

        public static EnumEntries<TransactionBackgroundView> getEntries() {
            return $ENTRIES;
        }

        public static TransactionBackgroundView valueOf(String str) {
            return (TransactionBackgroundView) Enum.valueOf(TransactionBackgroundView.class, str);
        }

        public static TransactionBackgroundView[] values() {
            return (TransactionBackgroundView[]) $VALUES.clone();
        }
    }

    public PaywallOptions() {
        this.isHapticFeedbackEnabled = true;
        this.restoreFailed = new RestoreFailed();
        this.shouldShowPurchaseFailureAlert = true;
        this.shouldPreload = true;
        this.preloadDeviceOverrides = MapsKt.emptyMap();
        this.automaticallyDismiss = true;
        this.overrideProductsByName = MapsKt.emptyMap();
        this.transactionBackgroundView = TransactionBackgroundView.SPINNER;
    }

    public final boolean getAutomaticallyDismiss() {
        return this.automaticallyDismiss;
    }

    public final Integer getLoadingColor() {
        return this.loadingColor;
    }

    public final Function1<PaywallInfo, Boolean> getOnBackPressed() {
        return this.onBackPressed;
    }

    public final boolean getOptimisticLoading() {
        return this.optimisticLoading;
    }

    public final Map<String, String> getOverrideProductsByName() {
        return this.overrideProductsByName;
    }

    public final Map<Tier, Boolean> getPreloadDeviceOverrides() {
        return this.preloadDeviceOverrides;
    }

    public final RestoreFailed getRestoreFailed() {
        return this.restoreFailed;
    }

    public final boolean getShouldPreload() {
        return this.shouldPreload;
    }

    public final boolean getShouldShowPurchaseFailureAlert() {
        return this.shouldShowPurchaseFailureAlert;
    }

    /* JADX INFO: renamed from: getTimeoutAfter-FghU774, reason: not valid java name */
    public final Duration m1263getTimeoutAfterFghU774() {
        return this.timeoutAfter;
    }

    public final TransactionBackgroundView getTransactionBackgroundView() {
        return this.transactionBackgroundView;
    }

    public final boolean getUseCachedTemplates() {
        return this.useCachedTemplates;
    }

    public final boolean isHapticFeedbackEnabled() {
        return this.isHapticFeedbackEnabled;
    }

    public final void setAutomaticallyDismiss(boolean z2) {
        this.automaticallyDismiss = z2;
    }

    public final void setHapticFeedbackEnabled(boolean z2) {
        this.isHapticFeedbackEnabled = z2;
    }

    public final void setLoadingColor(Integer num) {
        this.loadingColor = num;
    }

    public final void setOnBackPressed(Function1<? super PaywallInfo, Boolean> function1) {
        this.onBackPressed = function1;
    }

    public final void setOptimisticLoading(boolean z2) {
        this.optimisticLoading = z2;
    }

    public final void setOverrideProductsByName(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.overrideProductsByName = map;
    }

    public final void setPreloadDeviceOverrides(Map<Tier, Boolean> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.preloadDeviceOverrides = map;
    }

    public final void setRestoreFailed(RestoreFailed restoreFailed) {
        Intrinsics.checkNotNullParameter(restoreFailed, "<set-?>");
        this.restoreFailed = restoreFailed;
    }

    public final void setShouldPreload(boolean z2) {
        this.shouldPreload = z2;
    }

    public final void setShouldShowPurchaseFailureAlert(boolean z2) {
        this.shouldShowPurchaseFailureAlert = z2;
    }

    /* JADX INFO: renamed from: setTimeoutAfter-BwNAW2A, reason: not valid java name */
    public final void m1264setTimeoutAfterBwNAW2A(Duration duration) {
        this.timeoutAfter = duration;
    }

    public final void setTransactionBackgroundView(TransactionBackgroundView transactionBackgroundView) {
        this.transactionBackgroundView = transactionBackgroundView;
    }

    public final void setUseCachedTemplates(boolean z2) {
        this.useCachedTemplates = z2;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RestoreFailed {
        private String closeButtonTitle;
        private String message;
        private String title;

        public RestoreFailed() {
            this.title = "No Subscription Found";
            this.message = "We couldn't find an active subscription for your account.";
            this.closeButtonTitle = "Okay";
        }

        public final String getCloseButtonTitle() {
            return this.closeButtonTitle;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setCloseButtonTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.closeButtonTitle = str;
        }

        public final void setMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.message = str;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RestoreFailed(Function1<? super RestoreFailed, Unit> definition) {
            this();
            Intrinsics.checkNotNullParameter(definition, "definition");
            definition.invoke(this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaywallOptions(Function1<? super PaywallOptions, Unit> definition) {
        this();
        Intrinsics.checkNotNullParameter(definition, "definition");
        definition.invoke(this);
    }
}
