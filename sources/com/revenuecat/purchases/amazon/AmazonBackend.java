package com.revenuecat.purchases.amazon;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.networking.Endpoint;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AmazonBackend {
    private final BackendHelper backendHelper;
    private volatile Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>>>> postAmazonReceiptCallbacks;

    public AmazonBackend(BackendHelper backendHelper) {
        Intrinsics.checkNotNullParameter(backendHelper, "backendHelper");
        this.backendHelper = backendHelper;
        this.postAmazonReceiptCallbacks = new LinkedHashMap();
    }

    public final void getAmazonReceiptData(final String receiptId, final String storeUserID, Function1<? super JSONObject, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(receiptId, "receiptId");
        Intrinsics.checkNotNullParameter(storeUserID, "storeUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final List<String> listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new String[]{receiptId, storeUserID});
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBackend$getAmazonReceiptData$call$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m520invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m520invoke() {
                BackendHelper backendHelper = this.this$0.backendHelper;
                Endpoint.GetAmazonReceipt getAmazonReceipt = new Endpoint.GetAmazonReceipt(storeUserID, receiptId);
                Delay delay = Delay.NONE;
                final AmazonBackend amazonBackend = this.this$0;
                final List<String> list = listListOfNotNull;
                Function1<PurchasesError, Unit> function1 = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBackend$getAmazonReceiptData$call$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((PurchasesError) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(PurchasesError error) {
                        List<Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                        Intrinsics.checkNotNullParameter(error, "error");
                        AmazonBackend amazonBackend2 = amazonBackend;
                        List<String> list2 = list;
                        synchronized (amazonBackend2) {
                            listRemove = amazonBackend2.getPostAmazonReceiptCallbacks().remove(list2);
                        }
                        if (listRemove != null) {
                            Iterator<T> it = listRemove.iterator();
                            while (it.hasNext()) {
                                ((Function1) ((Pair) it.next()).b()).invoke(error);
                            }
                        }
                    }
                };
                final AmazonBackend amazonBackend2 = this.this$0;
                final List<String> list2 = listListOfNotNull;
                backendHelper.performRequest(getAmazonReceipt, null, null, delay, function1, new Function3<PurchasesError, Integer, JSONObject, Unit>() { // from class: com.revenuecat.purchases.amazon.AmazonBackend$getAmazonReceiptData$call$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((PurchasesError) obj, ((Number) obj2).intValue(), (JSONObject) obj3);
                        return Unit.f139807a;
                    }

                    public final void invoke(PurchasesError purchasesError, int i3, JSONObject body) {
                        List<Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>>> listRemove;
                        Intrinsics.checkNotNullParameter(body, "body");
                        AmazonBackend amazonBackend3 = amazonBackend2;
                        List<String> list3 = list2;
                        synchronized (amazonBackend3) {
                            listRemove = amazonBackend3.getPostAmazonReceiptCallbacks().remove(list3);
                        }
                        if (listRemove != null) {
                            Iterator<T> it = listRemove.iterator();
                            while (it.hasNext()) {
                                Pair pair = (Pair) it.next();
                                Function1 function12 = (Function1) pair.a();
                                Function1 function13 = (Function1) pair.b();
                                if (purchasesError != null) {
                                    function13.invoke(purchasesError);
                                } else {
                                    function12.invoke(body);
                                }
                            }
                        }
                    }
                });
            }
        };
        Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>> pairA = TuplesKt.a(onSuccess, onError);
        synchronized (this) {
            try {
                if (this.postAmazonReceiptCallbacks.containsKey(listListOfNotNull)) {
                    List<Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>>> list = this.postAmazonReceiptCallbacks.get(listListOfNotNull);
                    Intrinsics.checkNotNull(list);
                    list.add(pairA);
                } else {
                    this.postAmazonReceiptCallbacks.put(listListOfNotNull, CollectionsKt.mutableListOf(pairA));
                    function0.invoke();
                    Unit unit = Unit.f139807a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>>>> getPostAmazonReceiptCallbacks() {
        return this.postAmazonReceiptCallbacks;
    }

    public final synchronized void setPostAmazonReceiptCallbacks(Map<List<String>, List<Pair<Function1<JSONObject, Unit>, Function1<PurchasesError, Unit>>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.postAmazonReceiptCallbacks = map;
    }
}
