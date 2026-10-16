package com.superwall.sdk.models.product;

import com.applovin.sdk.AppLovinEventTypes;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.superwall.sdk.models.product.ProductItem;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

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
public final class StoreProductSerializer implements KSerializer<ProductItem.StoreProductType> {
    public static final StoreProductSerializer INSTANCE = new StoreProductSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.e("StoreProduct", new SerialDescriptor[0], null, 4, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Store.values().length];
            try {
                iArr[Store.PLAY_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Store.APP_STORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Store.STRIPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Store.PADDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Store.CUSTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Store.SUPERWALL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Store.OTHER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private StoreProductSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ProductItem.StoreProductType deserialize(Decoder decoder) {
        JsonObject jsonObjectO;
        JsonElement jsonElement;
        JsonPrimitive jsonPrimitiveP;
        String strA;
        Store storeFromValue;
        JsonPrimitive jsonPrimitiveP2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new SerializationException("This class can be loaded only by Json");
        }
        JsonObject jsonObjectO2 = JsonElementKt.o(jsonDecoder.g());
        JsonElement jsonElement2 = (JsonElement) jsonObjectO2.get(ProductResponseJsonKeys.STORE);
        if (jsonElement2 == null || (jsonPrimitiveP2 = JsonElementKt.p(jsonElement2)) == null || (strA = jsonPrimitiveP2.a()) == null) {
            JsonElement jsonElement3 = (JsonElement) jsonObjectO2.get(AppLovinEventTypes.USER_VIEWED_PRODUCT);
            if (jsonElement3 == null || (jsonObjectO = JsonElementKt.o(jsonElement3)) == null || (jsonElement = (JsonElement) jsonObjectO.get(ProductResponseJsonKeys.STORE)) == null || (jsonPrimitiveP = JsonElementKt.p(jsonElement)) == null) {
                throw new SerializationException("Store is missing");
            }
            strA = jsonPrimitiveP.a();
        }
        try {
            storeFromValue = Store.Companion.fromValue(strA);
        } catch (Throwable unused) {
            storeFromValue = Store.PLAY_STORE;
        }
        Json jsonD = jsonDecoder.d();
        switch (WhenMappings.$EnumSwitchMapping$0[storeFromValue.ordinal()]) {
            case 1:
                return new ProductItem.StoreProductType.PlayStore((PlayStoreProduct) jsonD.c(PlayStoreProductSerializer.INSTANCE, jsonObjectO2));
            case 2:
                return new ProductItem.StoreProductType.AppStore((AppStoreProduct) jsonD.c(AppStoreProduct.Companion.serializer(), jsonObjectO2));
            case 3:
                return new ProductItem.StoreProductType.Stripe((StripeProduct) jsonD.c(StripeProduct.Companion.serializer(), jsonObjectO2));
            case 4:
                return new ProductItem.StoreProductType.Paddle((PaddleProduct) jsonD.c(PaddleProduct.Companion.serializer(), jsonObjectO2));
            case 5:
                return new ProductItem.StoreProductType.Custom((CustomStoreProduct) jsonD.c(CustomStoreProduct.Companion.serializer(), jsonObjectO2));
            case 6:
                return new ProductItem.StoreProductType.Other((UnknownStoreProduct) jsonD.c(UnknownStoreProduct.Companion.serializer(), jsonObjectO2));
            case 7:
                try {
                    return new ProductItem.StoreProductType.Custom((CustomStoreProduct) jsonD.c(CustomStoreProduct.Companion.serializer(), jsonObjectO2));
                } catch (SerializationException unused2) {
                    return new ProductItem.StoreProductType.Other((UnknownStoreProduct) jsonD.c(UnknownStoreProduct.Companion.serializer(), jsonObjectO2));
                }
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ProductItem.StoreProductType value) {
        JsonElement jsonElementE;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonEncoder jsonEncoder = encoder instanceof JsonEncoder ? (JsonEncoder) encoder : null;
        if (jsonEncoder == null) {
            throw new SerializationException("This class can be saved only by Json");
        }
        if (value instanceof ProductItem.StoreProductType.PlayStore) {
            jsonElementE = jsonEncoder.d().e(PlayStoreProductSerializer.INSTANCE, ((ProductItem.StoreProductType.PlayStore) value).getProduct());
        } else if (value instanceof ProductItem.StoreProductType.AppStore) {
            jsonElementE = jsonEncoder.d().e(AppStoreProduct.Companion.serializer(), ((ProductItem.StoreProductType.AppStore) value).getProduct());
        } else if (value instanceof ProductItem.StoreProductType.Stripe) {
            jsonElementE = jsonEncoder.d().e(StripeProduct.Companion.serializer(), ((ProductItem.StoreProductType.Stripe) value).getProduct());
        } else if (value instanceof ProductItem.StoreProductType.Paddle) {
            jsonElementE = jsonEncoder.d().e(PaddleProduct.Companion.serializer(), ((ProductItem.StoreProductType.Paddle) value).getProduct());
        } else if (value instanceof ProductItem.StoreProductType.Custom) {
            jsonElementE = jsonEncoder.d().e(CustomStoreProduct.Companion.serializer(), ((ProductItem.StoreProductType.Custom) value).getProduct());
        } else {
            if (!(value instanceof ProductItem.StoreProductType.Other)) {
                throw new NoWhenBranchMatchedException();
            }
            jsonElementE = jsonEncoder.d().e(UnknownStoreProduct.Companion.serializer(), ((ProductItem.StoreProductType.Other) value).getProduct());
        }
        jsonEncoder.A(jsonElementE);
    }
}
