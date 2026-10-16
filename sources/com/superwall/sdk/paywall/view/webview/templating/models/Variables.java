package com.superwall.sdk.paywall.view.webview.templating.models;

import com.superwall.sdk.models.product.ProductVariable;
import com.superwall.sdk.models.product.ProductVariableSerializer;
import com.superwall.sdk.models.serialization.AnySerializer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
public final class Variables {
    private static final KSerializer<Object>[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final Map<String, Object> device;
    private final Map<String, Object> params;
    private Map<String, ? extends Object> primary;
    private List<ProductVariable> products;
    private Map<String, ? extends Object> secondary;
    private Map<String, ? extends Object> tertiary;
    private final Map<String, Object> user;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<Variables> serializer() {
            return Variables$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        AnySerializer anySerializer = AnySerializer.INSTANCE;
        $childSerializers = new KSerializer[]{new LinkedHashMapSerializer(stringSerializer, BuiltinSerializersKt.u(anySerializer)), new LinkedHashMapSerializer(stringSerializer, BuiltinSerializersKt.u(anySerializer)), new LinkedHashMapSerializer(stringSerializer, BuiltinSerializersKt.u(anySerializer)), new ArrayListSerializer(ProductVariableSerializer.INSTANCE), new LinkedHashMapSerializer(stringSerializer, BuiltinSerializersKt.u(anySerializer)), new LinkedHashMapSerializer(stringSerializer, BuiltinSerializersKt.u(anySerializer)), new LinkedHashMapSerializer(stringSerializer, BuiltinSerializersKt.u(anySerializer))};
    }

    public /* synthetic */ Variables(int i3, Map map, Map map2, Map map3, List list, Map map4, Map map5, Map map6, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i3 & 7)) {
            PluginExceptionsKt.b(i3, 7, Variables$$serializer.INSTANCE.getDescriptor());
        }
        this.user = map;
        this.device = map2;
        this.params = map3;
        if ((i3 & 8) == 0) {
            this.products = CollectionsKt.emptyList();
        } else {
            this.products = list;
        }
        if ((i3 & 16) == 0) {
            this.primary = MapsKt.emptyMap();
        } else {
            this.primary = map4;
        }
        if ((i3 & 32) == 0) {
            this.secondary = MapsKt.emptyMap();
        } else {
            this.secondary = map5;
        }
        if ((i3 & 64) == 0) {
            this.tertiary = MapsKt.emptyMap();
        } else {
            this.tertiary = map6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Variables copy$default(Variables variables, Map map, Map map2, Map map3, List list, Map map4, Map map5, Map map6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = variables.user;
        }
        if ((i3 & 2) != 0) {
            map2 = variables.device;
        }
        if ((i3 & 4) != 0) {
            map3 = variables.params;
        }
        if ((i3 & 8) != 0) {
            list = variables.products;
        }
        if ((i3 & 16) != 0) {
            map4 = variables.primary;
        }
        if ((i3 & 32) != 0) {
            map5 = variables.secondary;
        }
        if ((i3 & 64) != 0) {
            map6 = variables.tertiary;
        }
        Map map7 = map5;
        Map map8 = map6;
        Map map9 = map4;
        Map map10 = map3;
        return variables.copy(map, map2, map10, list, map9, map7, map8);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(Variables variables, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], variables.user);
        compositeEncoder.C(serialDescriptor, 1, kSerializerArr[1], variables.device);
        compositeEncoder.C(serialDescriptor, 2, kSerializerArr[2], variables.params);
        if (compositeEncoder.z(serialDescriptor, 3) || !Intrinsics.areEqual(variables.products, CollectionsKt.emptyList())) {
            compositeEncoder.C(serialDescriptor, 3, kSerializerArr[3], variables.products);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || !Intrinsics.areEqual(variables.primary, MapsKt.emptyMap())) {
            compositeEncoder.C(serialDescriptor, 4, kSerializerArr[4], variables.primary);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || !Intrinsics.areEqual(variables.secondary, MapsKt.emptyMap())) {
            compositeEncoder.C(serialDescriptor, 5, kSerializerArr[5], variables.secondary);
        }
        if (!compositeEncoder.z(serialDescriptor, 6) && Intrinsics.areEqual(variables.tertiary, MapsKt.emptyMap())) {
            return;
        }
        compositeEncoder.C(serialDescriptor, 6, kSerializerArr[6], variables.tertiary);
    }

    public final Map<String, Object> component1() {
        return this.user;
    }

    public final Map<String, Object> component2() {
        return this.device;
    }

    public final Map<String, Object> component3() {
        return this.params;
    }

    public final List<ProductVariable> component4() {
        return this.products;
    }

    public final Map<String, Object> component5() {
        return this.primary;
    }

    public final Map<String, Object> component6() {
        return this.secondary;
    }

    public final Map<String, Object> component7() {
        return this.tertiary;
    }

    public final Variables copy(Map<String, ? extends Object> user, Map<String, ? extends Object> device, Map<String, ? extends Object> params, List<ProductVariable> products, Map<String, ? extends Object> primary, Map<String, ? extends Object> secondary, Map<String, ? extends Object> tertiary) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(primary, "primary");
        Intrinsics.checkNotNullParameter(secondary, "secondary");
        Intrinsics.checkNotNullParameter(tertiary, "tertiary");
        return new Variables(user, device, params, products, primary, secondary, tertiary);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Variables)) {
            return false;
        }
        Variables variables = (Variables) obj;
        return Intrinsics.areEqual(this.user, variables.user) && Intrinsics.areEqual(this.device, variables.device) && Intrinsics.areEqual(this.params, variables.params) && Intrinsics.areEqual(this.products, variables.products) && Intrinsics.areEqual(this.primary, variables.primary) && Intrinsics.areEqual(this.secondary, variables.secondary) && Intrinsics.areEqual(this.tertiary, variables.tertiary);
    }

    public final Map<String, Object> getDevice() {
        return this.device;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final Map<String, Object> getPrimary() {
        return this.primary;
    }

    public final List<ProductVariable> getProducts() {
        return this.products;
    }

    public final Map<String, Object> getSecondary() {
        return this.secondary;
    }

    public final Map<String, Object> getTertiary() {
        return this.tertiary;
    }

    public final Map<String, Object> getUser() {
        return this.user;
    }

    public int hashCode() {
        return (((((((((((this.user.hashCode() * 31) + this.device.hashCode()) * 31) + this.params.hashCode()) * 31) + this.products.hashCode()) * 31) + this.primary.hashCode()) * 31) + this.secondary.hashCode()) * 31) + this.tertiary.hashCode();
    }

    public final void setPrimary(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.primary = map;
    }

    public final void setProducts(List<ProductVariable> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.products = list;
    }

    public final void setSecondary(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.secondary = map;
    }

    public final void setTertiary(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.tertiary = map;
    }

    public final JsonVariables templated() {
        return new JsonVariables("template_variables", this);
    }

    public String toString() {
        return "Variables(user=" + this.user + ", device=" + this.device + ", params=" + this.params + ", products=" + this.products + ", primary=" + this.primary + ", secondary=" + this.secondary + ", tertiary=" + this.tertiary + ")";
    }

    public Variables(Map<String, ? extends Object> user, Map<String, ? extends Object> device, Map<String, ? extends Object> params, List<ProductVariable> products, Map<String, ? extends Object> primary, Map<String, ? extends Object> secondary, Map<String, ? extends Object> tertiary) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(primary, "primary");
        Intrinsics.checkNotNullParameter(secondary, "secondary");
        Intrinsics.checkNotNullParameter(tertiary, "tertiary");
        this.user = user;
        this.device = device;
        this.params = params;
        this.products = products;
        this.primary = primary;
        this.secondary = secondary;
        this.tertiary = tertiary;
    }

    public /* synthetic */ Variables(Map map, Map map2, Map map3, List list, Map map4, Map map5, Map map6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, map2, map3, (i3 & 8) != 0 ? CollectionsKt.emptyList() : list, (i3 & 16) != 0 ? MapsKt.emptyMap() : map4, (i3 & 32) != 0 ? MapsKt.emptyMap() : map5, (i3 & 64) != 0 ? MapsKt.emptyMap() : map6);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Variables(List<ProductVariable> list, Map<String, ? extends Object> map, Map<String, ? extends Object> userAttributes, Map<String, ? extends Object> map2) {
        this(userAttributes, map2 == null ? MapsKt.emptyMap() : map2, map == null ? MapsKt.emptyMap() : map, (List) null, (Map) null, (Map) null, (Map) null, 120, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(userAttributes, "userAttributes");
        if (list != null) {
            for (ProductVariable productVariable : list) {
                String name = productVariable.getName();
                int iHashCode = name.hashCode();
                if (iHashCode != -1174796206) {
                    if (iHashCode != -817598092) {
                        if (iHashCode == -314765822 && name.equals("primary")) {
                            this.primary = productVariable.getAttributes();
                        }
                    } else if (name.equals("secondary")) {
                        this.secondary = productVariable.getAttributes();
                    }
                } else if (name.equals("tertiary")) {
                    this.tertiary = productVariable.getAttributes();
                }
            }
        }
        if (list != null) {
            this.products = list;
        }
    }
}
