package com.superwall.sdk.config.options;

import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.store.testmode.TestModeBehavior;
import java.util.EnumSet;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class SuperwallOptions {
    private boolean enableExperimentalDeviceVariables;
    private EventTrackingBehavior eventTrackingBehavior;
    private boolean isGameControllerEnabled;
    private String localeIdentifier;
    private Logging logging;
    private NetworkEnvironment networkEnvironment;
    private boolean passIdentifiersToPlayStore;
    private PaywallOptions paywalls;
    private boolean shouldObservePurchases;
    private TestModeBehavior testModeBehavior;
    private boolean useMockReviews;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class NetworkEnvironment {
        private final String hostDomain;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Custom extends NetworkEnvironment {
            private final String baseHost;
            private final String collectorHost;
            private final Integer port;
            private final String scheme;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Custom(String baseHost, String collectorHost, String scheme, Integer num) {
                super(baseHost);
                Intrinsics.checkNotNullParameter(baseHost, "baseHost");
                Intrinsics.checkNotNullParameter(collectorHost, "collectorHost");
                Intrinsics.checkNotNullParameter(scheme, "scheme");
                this.baseHost = baseHost;
                this.collectorHost = collectorHost;
                this.scheme = scheme;
                this.port = num;
            }

            @Override // com.superwall.sdk.config.options.SuperwallOptions.NetworkEnvironment
            public String getBaseHost() {
                return this.baseHost;
            }

            @Override // com.superwall.sdk.config.options.SuperwallOptions.NetworkEnvironment
            public String getCollectorHost() {
                return this.collectorHost;
            }

            @Override // com.superwall.sdk.config.options.SuperwallOptions.NetworkEnvironment
            public Integer getPort() {
                return this.port;
            }

            @Override // com.superwall.sdk.config.options.SuperwallOptions.NetworkEnvironment
            public String getScheme() {
                return this.scheme;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Developer extends NetworkEnvironment {
            public Developer() {
                super("superwall.dev");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Release extends NetworkEnvironment {
            public Release() {
                super("superwall.me");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ReleaseCandidate extends NetworkEnvironment {
            public ReleaseCandidate() {
                super("superwallcanary.com");
            }
        }

        public NetworkEnvironment(String hostDomain) {
            Intrinsics.checkNotNullParameter(hostDomain, "hostDomain");
            this.hostDomain = hostDomain;
        }

        public String getBaseHost() {
            return "api." + getHostDomain();
        }

        public String getCollectorHost() {
            return "collector." + getHostDomain();
        }

        public String getEnrichmentHost() {
            return this instanceof Release ? "enrichment-api.superwall.com" : "enrichment-api.superwall.dev";
        }

        public String getHostDomain() {
            return this.hostDomain;
        }

        public Integer getPort() {
            return null;
        }

        public String getScheme() {
            return "https";
        }

        public String getSubscriptionHost() {
            return this instanceof Release ? "subscriptions-api.superwall.com" : "subscriptions-api.superwall.dev";
        }
    }

    public SuperwallOptions() {
        this.paywalls = new PaywallOptions();
        this.networkEnvironment = new NetworkEnvironment.Release();
        this.eventTrackingBehavior = EventTrackingBehavior.ALL;
        this.logging = new Logging();
        this.testModeBehavior = TestModeBehavior.AUTOMATIC;
    }

    public final boolean getEnableExperimentalDeviceVariables() {
        return this.enableExperimentalDeviceVariables;
    }

    public final EventTrackingBehavior getEventTrackingBehavior() {
        return this.eventTrackingBehavior;
    }

    public final String getLocaleIdentifier() {
        return this.localeIdentifier;
    }

    public final Logging getLogging() {
        return this.logging;
    }

    public final NetworkEnvironment getNetworkEnvironment() {
        return this.networkEnvironment;
    }

    public final boolean getPassIdentifiersToPlayStore() {
        return this.passIdentifiersToPlayStore;
    }

    public final PaywallOptions getPaywalls() {
        return this.paywalls;
    }

    public final boolean getShouldObservePurchases() {
        return this.shouldObservePurchases;
    }

    public final TestModeBehavior getTestModeBehavior() {
        return this.testModeBehavior;
    }

    public final boolean getUseMockReviews() {
        return this.useMockReviews;
    }

    public final boolean isExternalDataCollectionEnabled() {
        return this.eventTrackingBehavior == EventTrackingBehavior.ALL;
    }

    public final boolean isGameControllerEnabled() {
        return this.isGameControllerEnabled;
    }

    public final void setEnableExperimentalDeviceVariables(boolean z2) {
        this.enableExperimentalDeviceVariables = z2;
    }

    public final void setEventTrackingBehavior(EventTrackingBehavior eventTrackingBehavior) {
        Intrinsics.checkNotNullParameter(eventTrackingBehavior, "<set-?>");
        this.eventTrackingBehavior = eventTrackingBehavior;
    }

    public final void setExternalDataCollectionEnabled(boolean z2) {
        EventTrackingBehavior eventTrackingBehavior;
        if (z2) {
            eventTrackingBehavior = EventTrackingBehavior.ALL;
        } else {
            eventTrackingBehavior = this.eventTrackingBehavior;
            if (eventTrackingBehavior != EventTrackingBehavior.NONE) {
                eventTrackingBehavior = EventTrackingBehavior.SUPERWALL_ONLY;
            }
        }
        this.eventTrackingBehavior = eventTrackingBehavior;
    }

    public final void setGameControllerEnabled(boolean z2) {
        this.isGameControllerEnabled = z2;
    }

    public final void setLocaleIdentifier(String str) {
        this.localeIdentifier = str;
    }

    public final void setLogging(Logging logging) {
        Intrinsics.checkNotNullParameter(logging, "<set-?>");
        this.logging = logging;
    }

    public final void setNetworkEnvironment(NetworkEnvironment networkEnvironment) {
        Intrinsics.checkNotNullParameter(networkEnvironment, "<set-?>");
        this.networkEnvironment = networkEnvironment;
    }

    public final void setPassIdentifiersToPlayStore(boolean z2) {
        this.passIdentifiersToPlayStore = z2;
    }

    public final void setPaywalls(PaywallOptions paywallOptions) {
        Intrinsics.checkNotNullParameter(paywallOptions, "<set-?>");
        this.paywalls = paywallOptions;
    }

    public final void setShouldObservePurchases(boolean z2) {
        this.shouldObservePurchases = z2;
    }

    public final void setTestModeBehavior(TestModeBehavior testModeBehavior) {
        Intrinsics.checkNotNullParameter(testModeBehavior, "<set-?>");
        this.testModeBehavior = testModeBehavior;
    }

    public final void setUseMockReviews(boolean z2) {
        this.useMockReviews = z2;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Logging {
        private LogLevel level;
        private EnumSet<LogScope> scopes;

        public Logging() {
            this.level = LogLevel.warn;
            EnumSet<LogScope> enumSetOf = EnumSet.of(LogScope.all);
            Intrinsics.checkNotNullExpressionValue(enumSetOf, "of(...)");
            this.scopes = enumSetOf;
        }

        public final LogLevel getLevel() {
            return this.level;
        }

        public final EnumSet<LogScope> getScopes() {
            return this.scopes;
        }

        public final void setLevel(LogLevel logLevel) {
            Intrinsics.checkNotNullParameter(logLevel, "<set-?>");
            this.level = logLevel;
        }

        public final void setScopes(EnumSet<LogScope> enumSet) {
            Intrinsics.checkNotNullParameter(enumSet, "<set-?>");
            this.scopes = enumSet;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Logging(Function1<? super Logging, Unit> definition) {
            this();
            Intrinsics.checkNotNullParameter(definition, "definition");
            definition.invoke(this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SuperwallOptions(Function1<? super SuperwallOptions, Unit> definition) {
        this();
        Intrinsics.checkNotNullParameter(definition, "definition");
        definition.invoke(this);
    }

    @Deprecated
    public static /* synthetic */ void isExternalDataCollectionEnabled$annotations() {
    }
}
