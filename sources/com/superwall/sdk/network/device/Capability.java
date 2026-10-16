package com.superwall.sdk.network.device;

import com.superwall.sdk.analytics.superwall.SuperwallEvents;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public abstract class Capability {
    private final String name;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ConfigCaching extends Capability {
        public static final ConfigCaching INSTANCE = new ConfigCaching();

        private ConfigCaching() {
            super("config_caching", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MultiplePaywallUrls extends Capability {
        public static final MultiplePaywallUrls INSTANCE = new MultiplePaywallUrls();

        private MultiplePaywallUrls() {
            super("multiple_paywall_urls", null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallEventReceiver extends Capability {
        private final List<String> eventNames;

        public PaywallEventReceiver() {
            super("paywall_event_receiver", null);
            List listListOf = CollectionsKt.listOf((Object[]) new SuperwallEvents[]{SuperwallEvents.TransactionStart, SuperwallEvents.TransactionRestore, SuperwallEvents.TransactionComplete, SuperwallEvents.RestoreStart, SuperwallEvents.RestoreFail, SuperwallEvents.RestoreComplete, SuperwallEvents.TransactionFail, SuperwallEvents.TransactionAbandon, SuperwallEvents.TransactionTimeout, SuperwallEvents.PaywallOpen, SuperwallEvents.PaywallClose});
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                arrayList.add(((SuperwallEvents) it.next()).getRawName());
            }
            this.eventNames = arrayList;
        }

        public final List<String> getEventNames() {
            return this.eventNames;
        }
    }

    public /* synthetic */ Capability(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String getName() {
        return this.name;
    }

    private Capability(String str) {
        this.name = str;
    }
}
