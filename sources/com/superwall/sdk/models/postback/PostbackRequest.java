package com.superwall.sdk.models.postback;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
@Serializable
public final class PostbackRequest {
    private final Integer delay;
    private final List<PostbackProductIdentifier> products;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(PostbackProductIdentifier$$serializer.INSTANCE), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PostbackRequest> serializer() {
            return PostbackRequest$$serializer.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final PostbackRequest stub() {
            return new PostbackRequest(CollectionsKt.listOf(new PostbackProductIdentifier("123", "ios")), (Integer) null, 2, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        private Companion() {
        }
    }

    public /* synthetic */ PostbackRequest(int i3, List list, Integer num, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, PostbackRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.products = list;
        if ((i3 & 2) == 0) {
            this.delay = null;
        } else {
            this.delay = num;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PostbackRequest copy$default(PostbackRequest postbackRequest, List list, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = postbackRequest.products;
        }
        if ((i3 & 2) != 0) {
            num = postbackRequest.delay;
        }
        return postbackRequest.copy(list, num);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(PostbackRequest postbackRequest, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], postbackRequest.products);
        if (!compositeEncoder.z(serialDescriptor, 1) && postbackRequest.delay == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 1, IntSerializer.f142823a, postbackRequest.delay);
    }

    public final List<PostbackProductIdentifier> component1() {
        return this.products;
    }

    public final Integer component2() {
        return this.delay;
    }

    public final PostbackRequest copy(List<PostbackProductIdentifier> products, Integer num) {
        Intrinsics.checkNotNullParameter(products, "products");
        return new PostbackRequest(products, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostbackRequest)) {
            return false;
        }
        PostbackRequest postbackRequest = (PostbackRequest) obj;
        return Intrinsics.areEqual(this.products, postbackRequest.products) && Intrinsics.areEqual(this.delay, postbackRequest.delay);
    }

    public final Integer getDelay() {
        return this.delay;
    }

    public final double getPostbackDelay() {
        Integer num = this.delay;
        return num != null ? ((double) num.intValue()) / ((double) 1000) : Random.f140182a.g(2.0d, 10.0d);
    }

    public final List<PostbackProductIdentifier> getProducts() {
        return this.products;
    }

    public final List<PostbackProductIdentifier> getProductsToPostBack() {
        List<PostbackProductIdentifier> list = this.products;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((PostbackProductIdentifier) obj).getIsiOS()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public int hashCode() {
        int iHashCode = this.products.hashCode() * 31;
        Integer num = this.delay;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "PostbackRequest(products=" + this.products + ", delay=" + this.delay + ")";
    }

    public PostbackRequest(List<PostbackProductIdentifier> products, Integer num) {
        Intrinsics.checkNotNullParameter(products, "products");
        this.products = products;
        this.delay = num;
    }

    public /* synthetic */ PostbackRequest(List list, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i3 & 2) != 0 ? null : num);
    }

    @SerialName
    public static /* synthetic */ void getDelay$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getProducts$annotations() {
    }
}
