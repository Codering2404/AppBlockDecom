package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
final class OfferingsFactory$getStoreProductsById$1$1$1 extends Lambda implements Function1<List<? extends StoreProduct>, Unit> {
    final /* synthetic */ Function1<Map<String, ? extends List<? extends StoreProduct>>, Unit> $onCompleted;
    final /* synthetic */ Map<String, List<StoreProduct>> $productsById;
    final /* synthetic */ OfferingsFactory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    OfferingsFactory$getStoreProductsById$1$1$1(OfferingsFactory offeringsFactory, Map<String, List<StoreProduct>> map, Function1<? super Map<String, ? extends List<? extends StoreProduct>>, Unit> function1) {
        super(1);
        this.this$0 = offeringsFactory;
        this.$productsById = map;
        this.$onCompleted = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(Map map, List list, Function1 function1) {
        List<StoreProduct> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (StoreProduct storeProduct : list2) {
            arrayList.add(TuplesKt.a(storeProduct.getPurchasingData().getProductId(), CollectionsKt.listOf(storeProduct)));
        }
        MapsKt.putAll(map, arrayList);
        function1.invoke(map);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) obj);
        return Unit.f139807a;
    }

    public final void invoke(final List<? extends StoreProduct> inAppProducts) {
        Intrinsics.checkNotNullParameter(inAppProducts, "inAppProducts");
        Dispatcher dispatcher = this.this$0.dispatcher;
        final Map<String, List<StoreProduct>> map = this.$productsById;
        final Function1<Map<String, ? extends List<? extends StoreProduct>>, Unit> function1 = this.$onCompleted;
        Dispatcher.enqueue$default(dispatcher, new Runnable() { // from class: com.revenuecat.purchases.common.offerings.b
            @Override // java.lang.Runnable
            public final void run() {
                OfferingsFactory$getStoreProductsById$1$1$1.invoke$lambda$1(map, inAppProducts, function1);
            }
        }, null, 2, null);
    }
}
