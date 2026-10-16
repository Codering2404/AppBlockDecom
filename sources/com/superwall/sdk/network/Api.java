package com.superwall.sdk.network;

import com.superwall.sdk.config.options.SuperwallOptions;
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
public final class Api {
    public static final Companion Companion = new Companion(null);
    public static final String scheme = "https";
    public static final String subscriptionsv1 = "/subscriptions-api/public/v1/";
    public static final String version1 = "/api/v1/";
    private final Base base;
    private final Collector collector;
    private final Enrichment enrichment;
    private final String hostDomain;
    private final Subscriptions subscription;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Base {
        private final SuperwallOptions.NetworkEnvironment networkEnvironment;

        public Base(SuperwallOptions.NetworkEnvironment networkEnvironment) {
            Intrinsics.checkNotNullParameter(networkEnvironment, "networkEnvironment");
            this.networkEnvironment = networkEnvironment;
        }

        private final SuperwallOptions.NetworkEnvironment component1() {
            return this.networkEnvironment;
        }

        public static /* synthetic */ Base copy$default(Base base, SuperwallOptions.NetworkEnvironment networkEnvironment, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                networkEnvironment = base.networkEnvironment;
            }
            return base.copy(networkEnvironment);
        }

        public final Base copy(SuperwallOptions.NetworkEnvironment networkEnvironment) {
            Intrinsics.checkNotNullParameter(networkEnvironment, "networkEnvironment");
            return new Base(networkEnvironment);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Base) && Intrinsics.areEqual(this.networkEnvironment, ((Base) obj).networkEnvironment);
        }

        public final String getHost() {
            return this.networkEnvironment.getBaseHost();
        }

        public int hashCode() {
            return this.networkEnvironment.hashCode();
        }

        public String toString() {
            return "Base(networkEnvironment=" + this.networkEnvironment + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Collector {
        private final SuperwallOptions.NetworkEnvironment networkEnvironment;

        public Collector(SuperwallOptions.NetworkEnvironment networkEnvironment) {
            Intrinsics.checkNotNullParameter(networkEnvironment, "networkEnvironment");
            this.networkEnvironment = networkEnvironment;
        }

        private final SuperwallOptions.NetworkEnvironment component1() {
            return this.networkEnvironment;
        }

        public static /* synthetic */ Collector copy$default(Collector collector, SuperwallOptions.NetworkEnvironment networkEnvironment, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                networkEnvironment = collector.networkEnvironment;
            }
            return collector.copy(networkEnvironment);
        }

        public final Collector copy(SuperwallOptions.NetworkEnvironment networkEnvironment) {
            Intrinsics.checkNotNullParameter(networkEnvironment, "networkEnvironment");
            return new Collector(networkEnvironment);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Collector) && Intrinsics.areEqual(this.networkEnvironment, ((Collector) obj).networkEnvironment);
        }

        public final String getHost() {
            return this.networkEnvironment.getCollectorHost();
        }

        public int hashCode() {
            return this.networkEnvironment.hashCode();
        }

        public String toString() {
            return "Collector(networkEnvironment=" + this.networkEnvironment + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Enrichment {
        private final SuperwallOptions.NetworkEnvironment networkEnvironment;

        public Enrichment(SuperwallOptions.NetworkEnvironment networkEnvironment) {
            Intrinsics.checkNotNullParameter(networkEnvironment, "networkEnvironment");
            this.networkEnvironment = networkEnvironment;
        }

        private final SuperwallOptions.NetworkEnvironment component1() {
            return this.networkEnvironment;
        }

        public static /* synthetic */ Enrichment copy$default(Enrichment enrichment, SuperwallOptions.NetworkEnvironment networkEnvironment, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                networkEnvironment = enrichment.networkEnvironment;
            }
            return enrichment.copy(networkEnvironment);
        }

        public final Enrichment copy(SuperwallOptions.NetworkEnvironment networkEnvironment) {
            Intrinsics.checkNotNullParameter(networkEnvironment, "networkEnvironment");
            return new Enrichment(networkEnvironment);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Enrichment) && Intrinsics.areEqual(this.networkEnvironment, ((Enrichment) obj).networkEnvironment);
        }

        public final String getHost() {
            return this.networkEnvironment.getEnrichmentHost();
        }

        public int hashCode() {
            return this.networkEnvironment.hashCode();
        }

        public String toString() {
            return "Enrichment(networkEnvironment=" + this.networkEnvironment + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Subscriptions {
        private final SuperwallOptions.NetworkEnvironment networkEnvironment;

        public Subscriptions(SuperwallOptions.NetworkEnvironment networkEnvironment) {
            Intrinsics.checkNotNullParameter(networkEnvironment, "networkEnvironment");
            this.networkEnvironment = networkEnvironment;
        }

        private final SuperwallOptions.NetworkEnvironment component1() {
            return this.networkEnvironment;
        }

        public static /* synthetic */ Subscriptions copy$default(Subscriptions subscriptions, SuperwallOptions.NetworkEnvironment networkEnvironment, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                networkEnvironment = subscriptions.networkEnvironment;
            }
            return subscriptions.copy(networkEnvironment);
        }

        public final Subscriptions copy(SuperwallOptions.NetworkEnvironment networkEnvironment) {
            Intrinsics.checkNotNullParameter(networkEnvironment, "networkEnvironment");
            return new Subscriptions(networkEnvironment);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Subscriptions) && Intrinsics.areEqual(this.networkEnvironment, ((Subscriptions) obj).networkEnvironment);
        }

        public final String getHost() {
            return this.networkEnvironment.getSubscriptionHost();
        }

        public int hashCode() {
            return this.networkEnvironment.hashCode();
        }

        public String toString() {
            return "Subscriptions(networkEnvironment=" + this.networkEnvironment + ")";
        }
    }

    public Api(String hostDomain, Base base, Collector collector, Enrichment enrichment, Subscriptions subscription) {
        Intrinsics.checkNotNullParameter(hostDomain, "hostDomain");
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(collector, "collector");
        Intrinsics.checkNotNullParameter(enrichment, "enrichment");
        Intrinsics.checkNotNullParameter(subscription, "subscription");
        this.hostDomain = hostDomain;
        this.base = base;
        this.collector = collector;
        this.enrichment = enrichment;
        this.subscription = subscription;
    }

    public static /* synthetic */ Api copy$default(Api api, String str, Base base, Collector collector, Enrichment enrichment, Subscriptions subscriptions, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = api.hostDomain;
        }
        if ((i3 & 2) != 0) {
            base = api.base;
        }
        if ((i3 & 4) != 0) {
            collector = api.collector;
        }
        if ((i3 & 8) != 0) {
            enrichment = api.enrichment;
        }
        if ((i3 & 16) != 0) {
            subscriptions = api.subscription;
        }
        Subscriptions subscriptions2 = subscriptions;
        Collector collector2 = collector;
        return api.copy(str, base, collector2, enrichment, subscriptions2);
    }

    public final String component1() {
        return this.hostDomain;
    }

    public final Base component2() {
        return this.base;
    }

    public final Collector component3() {
        return this.collector;
    }

    public final Enrichment component4() {
        return this.enrichment;
    }

    public final Subscriptions component5() {
        return this.subscription;
    }

    public final Api copy(String hostDomain, Base base, Collector collector, Enrichment enrichment, Subscriptions subscription) {
        Intrinsics.checkNotNullParameter(hostDomain, "hostDomain");
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(collector, "collector");
        Intrinsics.checkNotNullParameter(enrichment, "enrichment");
        Intrinsics.checkNotNullParameter(subscription, "subscription");
        return new Api(hostDomain, base, collector, enrichment, subscription);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Api)) {
            return false;
        }
        Api api = (Api) obj;
        return Intrinsics.areEqual(this.hostDomain, api.hostDomain) && Intrinsics.areEqual(this.base, api.base) && Intrinsics.areEqual(this.collector, api.collector) && Intrinsics.areEqual(this.enrichment, api.enrichment) && Intrinsics.areEqual(this.subscription, api.subscription);
    }

    public final Base getBase() {
        return this.base;
    }

    public final Collector getCollector() {
        return this.collector;
    }

    public final Enrichment getEnrichment() {
        return this.enrichment;
    }

    public final String getHostDomain() {
        return this.hostDomain;
    }

    public final Subscriptions getSubscription() {
        return this.subscription;
    }

    public int hashCode() {
        return (((((((this.hostDomain.hashCode() * 31) + this.base.hashCode()) * 31) + this.collector.hashCode()) * 31) + this.enrichment.hashCode()) * 31) + this.subscription.hashCode();
    }

    public String toString() {
        return "Api(hostDomain=" + this.hostDomain + ", base=" + this.base + ", collector=" + this.collector + ", enrichment=" + this.enrichment + ", subscription=" + this.subscription + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Api(SuperwallOptions.NetworkEnvironment networkEnvironment) {
        this(networkEnvironment.getHostDomain(), new Base(networkEnvironment), new Collector(networkEnvironment), new Enrichment(networkEnvironment), new Subscriptions(networkEnvironment));
        Intrinsics.checkNotNullParameter(networkEnvironment, "networkEnvironment");
    }
}
