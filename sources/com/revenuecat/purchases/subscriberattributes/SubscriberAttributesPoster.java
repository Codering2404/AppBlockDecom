package com.revenuecat.purchases.subscriberattributes;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.SubscriberAttributeError;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class SubscriberAttributesPoster {
    private final BackendHelper backendHelper;

    public SubscriberAttributesPoster(BackendHelper backendHelper) {
        Intrinsics.checkNotNullParameter(backendHelper, "backendHelper");
        this.backendHelper = backendHelper;
    }

    public final void postSubscriberAttributes(Map<String, ? extends Map<String, ? extends Object>> attributes, String appUserID, final Function0<Unit> onSuccessHandler, final Function3<? super PurchasesError, ? super Boolean, ? super List<SubscriberAttributeError>, Unit> onErrorHandler) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        this.backendHelper.performRequest(new Endpoint.PostAttributes(appUserID), MapsKt.mapOf(TuplesKt.a("attributes", attributes)), null, Delay.DEFAULT, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster.postSubscriberAttributes.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.f139807a;
            }

            public final void invoke(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onErrorHandler.invoke(error, Boolean.FALSE, CollectionsKt.emptyList());
            }
        }, new Function3<PurchasesError, Integer, JSONObject, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster.postSubscriberAttributes.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) throws JSONException {
                invoke((PurchasesError) obj, ((Number) obj2).intValue(), (JSONObject) obj3);
                return Unit.f139807a;
            }

            public final void invoke(PurchasesError purchasesError, int i3, JSONObject body) throws JSONException {
                Unit unit;
                Intrinsics.checkNotNullParameter(body, "body");
                if (purchasesError != null) {
                    Function3<PurchasesError, Boolean, List<SubscriberAttributeError>, Unit> function3 = onErrorHandler;
                    boolean zIsServerError = RCHTTPStatusCodes.INSTANCE.isServerError(i3);
                    boolean z2 = false;
                    boolean z3 = i3 == 404;
                    if (!zIsServerError && !z3) {
                        z2 = true;
                    }
                    List<SubscriberAttributeError> listEmptyList = CollectionsKt.emptyList();
                    if (purchasesError.getCode() == PurchasesErrorCode.InvalidSubscriberAttributesError) {
                        listEmptyList = BackendHelpersKt.getAttributeErrors(body);
                    }
                    function3.invoke(purchasesError, Boolean.valueOf(z2), listEmptyList);
                    unit = Unit.f139807a;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    onSuccessHandler.invoke();
                }
            }
        });
    }
}
