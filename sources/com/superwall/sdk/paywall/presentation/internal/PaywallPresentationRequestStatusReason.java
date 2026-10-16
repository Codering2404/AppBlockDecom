package com.superwall.sdk.paywall.presentation.internal;

import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import com.superwall.sdk.models.triggers.Experiment;
import kotlin.Metadata;
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
public abstract class PaywallPresentationRequestStatusReason extends Throwable {
    private final String description;
    private final String info;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DebuggerPresented extends PaywallPresentationRequestStatusReason {
        public DebuggerPresented() {
            super("debugger_presented", "The paywall debugger is currently presented. Dismiss it before presenting a paywall.", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Holdout extends PaywallPresentationRequestStatusReason {
        private final Experiment experiment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Holdout(Experiment experiment) {
            super("holdout", "The user is in a holdout group for experiment '" + experiment.getId() + "'.", null);
            Intrinsics.checkNotNullParameter(experiment, "experiment");
            this.experiment = experiment;
        }

        public static /* synthetic */ Holdout copy$default(Holdout holdout, Experiment experiment, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                experiment = holdout.experiment;
            }
            return holdout.copy(experiment);
        }

        public final Experiment component1() {
            return this.experiment;
        }

        public final Holdout copy(Experiment experiment) {
            Intrinsics.checkNotNullParameter(experiment, "experiment");
            return new Holdout(experiment);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Holdout) && Intrinsics.areEqual(this.experiment, ((Holdout) obj).experiment);
        }

        public final Experiment getExperiment() {
            return this.experiment;
        }

        public int hashCode() {
            return this.experiment.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "Holdout(experiment=" + this.experiment + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NoAudienceMatch extends PaywallPresentationRequestStatusReason {
        public NoAudienceMatch() {
            super("no_rule_match", "The user did not match any rules configured for this placement.", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NoConfig extends PaywallPresentationRequestStatusReason {
        public NoConfig() {
            super("no_config", "The Superwall config could not be retrieved in time. Check your network connection and that your API key is correct.", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NoPaywallView extends PaywallPresentationRequestStatusReason {
        /* JADX WARN: Multi-variable type inference failed */
        public NoPaywallView() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public /* synthetic */ NoPaywallView(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "The paywall view could not be created. Check that the Android System WebView is enabled on the device." : str);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoPaywallView(String reason) {
            super(wgbAZXYjrv.vNfrP, reason, null);
            Intrinsics.checkNotNullParameter(reason, "reason");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NoPresenter extends PaywallPresentationRequestStatusReason {
        public NoPresenter() {
            super("no_presenter", "There is no Activity to present the paywall on. Make sure an Activity is visible before registering a placement.", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallAlreadyPresented extends PaywallPresentationRequestStatusReason {
        public PaywallAlreadyPresented() {
            super("paywall_already_presented", "A paywall is already being presented. Dismiss it before presenting another one.", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PlacementNotFound extends PaywallPresentationRequestStatusReason {
        public PlacementNotFound() {
            super("event_not_found", tDEtWsFLJfe.BmYqUW, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SubscriptionStatusTimeout extends PaywallPresentationRequestStatusReason {
        /* JADX WARN: Multi-variable type inference failed */
        public SubscriptionStatusTimeout() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public /* synthetic */ SubscriptionStatusTimeout(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "The entitlement status stayed 'unknown' for over 5 seconds.  Ensure that Google Play Billing is available and if you're using a custom purchase controller, ensure you're setting the entitlement status on time." : str);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubscriptionStatusTimeout(String reason) {
            super("subscription_status_timeout", reason, null);
            Intrinsics.checkNotNullParameter(reason, "reason");
        }
    }

    public /* synthetic */ PaywallPresentationRequestStatusReason(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getInfo() {
        return this.info;
    }

    private PaywallPresentationRequestStatusReason(String str, String str2) {
        this.description = str;
        this.info = str2;
    }
}
