package com.superwall.sdk.network;

import com.superwall.sdk.misc.Either;
import com.superwall.sdk.models.assignment.Assignment;
import com.superwall.sdk.models.assignment.AssignmentPostback;
import com.superwall.sdk.models.config.Config;
import com.superwall.sdk.models.enrichment.Enrichment;
import com.superwall.sdk.models.enrichment.EnrichmentRequest;
import com.superwall.sdk.models.entitlements.Redeemable;
import com.superwall.sdk.models.entitlements.TransactionReceipt;
import com.superwall.sdk.models.entitlements.WebEntitlements;
import com.superwall.sdk.models.events.EventData;
import com.superwall.sdk.models.events.EventsRequest;
import com.superwall.sdk.models.internal.DeviceVendorId;
import com.superwall.sdk.models.internal.WebRedemptionResponse;
import com.superwall.sdk.models.paywall.Paywall;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.json.JsonElement;

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
public interface SuperwallAPI {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static /* synthetic */ Object getPaywall$default(SuperwallAPI superwallAPI, String str, EventData eventData, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPaywall");
            }
            if ((i3 & 1) != 0) {
                str = null;
            }
            if ((i3 & 2) != 0) {
                eventData = null;
            }
            return superwallAPI.getPaywall(str, eventData, continuation);
        }

        public static /* synthetic */ Object getPaywalls$default(SuperwallAPI superwallAPI, boolean z2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPaywalls");
            }
            if ((i3 & 1) != 0) {
                z2 = false;
            }
            return superwallAPI.getPaywalls(z2, continuation);
        }
    }

    Object confirmAssignments(AssignmentPostback assignmentPostback, Continuation<? super Either<Unit, NetworkError>> continuation);

    Object getAssignments(Continuation<? super Either<? extends List<Assignment>, NetworkError>> continuation);

    Object getConfig(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Either<Config, NetworkError>> continuation);

    /* JADX INFO: renamed from: getEnrichment-exY8QGI */
    Object mo1310getEnrichmentexY8QGI(EnrichmentRequest enrichmentRequest, int i3, long j3, Continuation<? super Either<Enrichment, NetworkError>> continuation);

    Object getPaywall(String str, EventData eventData, Continuation<? super Either<Paywall, NetworkError>> continuation);

    Object getPaywalls(boolean z2, Continuation<? super Either<? extends List<Paywall>, NetworkError>> continuation);

    /* JADX INFO: renamed from: redeemToken-Jf2YlNw */
    Object mo1311redeemTokenJf2YlNw(List<Redeemable> list, String str, String str2, DeviceVendorId deviceVendorId, List<TransactionReceipt> list2, String str3, Map<String, ? extends JsonElement> map, Continuation<? super Either<WebRedemptionResponse, NetworkError>> continuation);

    Object sendEvents(EventsRequest eventsRequest, Continuation<? super Either<Unit, NetworkError>> continuation);

    Object webEntitlementsByDeviceID(DeviceVendorId deviceVendorId, Continuation<? super Either<WebEntitlements, NetworkError>> continuation);

    /* JADX INFO: renamed from: webEntitlementsByUserId-5PBZuVg */
    Object mo1312webEntitlementsByUserId5PBZuVg(String str, DeviceVendorId deviceVendorId, Continuation<? super Either<WebEntitlements, NetworkError>> continuation);
}
