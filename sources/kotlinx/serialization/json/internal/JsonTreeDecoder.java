package kotlinx.serialization.json.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNamingStrategy;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonSchemaCacheKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
class JsonTreeDecoder extends AbstractJsonTreeDecoder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final JsonObject f143111g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SerialDescriptor f143112h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f143113i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f143114j;

    public /* synthetic */ JsonTreeDecoder(Json json, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonObject, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : serialDescriptor);
    }

    private final boolean F0(SerialDescriptor serialDescriptor, int i3) {
        boolean z2 = (d().f().j() || serialDescriptor.j(i3) || !serialDescriptor.h(i3).b()) ? false : true;
        this.f143114j = z2;
        return z2;
    }

    private final boolean G0(SerialDescriptor serialDescriptor, int i3, String str) {
        Json jsonD = d();
        boolean zJ = serialDescriptor.j(i3);
        SerialDescriptor serialDescriptorH = serialDescriptor.h(i3);
        if (zJ && !serialDescriptorH.b() && (n0(str) instanceof JsonNull)) {
            return true;
        }
        if (!Intrinsics.areEqual(serialDescriptorH.d(), SerialKind.ENUM.f142752a) || (serialDescriptorH.b() && (n0(str) instanceof JsonNull))) {
            return false;
        }
        JsonElement jsonElementN0 = n0(str);
        JsonPrimitive jsonPrimitive = jsonElementN0 instanceof JsonPrimitive ? (JsonPrimitive) jsonElementN0 : null;
        String strG = jsonPrimitive != null ? JsonElementKt.g(jsonPrimitive) : null;
        if (strG == null) {
            return false;
        }
        return JsonNamesMapKt.j(serialDescriptorH, jsonD, strG) == -3 && (zJ || (!jsonD.f().j() && serialDescriptorH.b()));
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public boolean D() {
        return !this.f143114j && super.D();
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    /* JADX INFO: renamed from: H0 */
    public JsonObject C0() {
        return this.f143111g;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder b(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (descriptor != this.f143112h) {
            return super.b(descriptor);
        }
        Json jsonD = d();
        JsonElement jsonElementO0 = o0();
        String strI = this.f143112h.i();
        if (jsonElementO0 instanceof JsonObject) {
            return new JsonTreeDecoder(jsonD, (JsonObject) jsonElementO0, B0(), this.f143112h);
        }
        throw JsonExceptionsKt.f(-1, "Expected " + Reflection.b(JsonObject.class).m() + ", but had " + Reflection.b(jsonElementO0.getClass()).m() + " as the serialized body of " + strI + " at element: " + k0(), jsonElementO0.toString());
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void c(SerialDescriptor descriptor) {
        Set setPlus;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.f143042f.k() || (descriptor.d() instanceof PolymorphicKind)) {
            return;
        }
        JsonNamingStrategy jsonNamingStrategyN = JsonNamesMapKt.n(descriptor, d());
        if (jsonNamingStrategyN == null && !this.f143042f.o()) {
            setPlus = JsonInternalDependenciesKt.a(descriptor);
        } else if (jsonNamingStrategyN != null) {
            setPlus = JsonNamesMapKt.f(d(), descriptor).keySet();
        } else {
            Set setA = JsonInternalDependenciesKt.a(descriptor);
            Map map = (Map) JsonSchemaCacheKt.a(d()).a(descriptor, JsonNamesMapKt.h());
            Set setKeySet = map != null ? map.keySet() : null;
            if (setKeySet == null) {
                setKeySet = SetsKt.emptySet();
            }
            setPlus = SetsKt.plus(setA, (Iterable) setKeySet);
        }
        for (String str : C0().keySet()) {
            if (!setPlus.contains(str) && !Intrinsics.areEqual(str, B0())) {
                throw JsonExceptionsKt.g(str, C0().toString());
            }
        }
    }

    @Override // kotlinx.serialization.internal.NamedValueDecoder
    protected String h0(SerialDescriptor descriptor, int i3) {
        Object next;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        JsonNamingStrategy jsonNamingStrategyN = JsonNamesMapKt.n(descriptor, d());
        String strF = descriptor.f(i3);
        if (jsonNamingStrategyN != null || (this.f143042f.o() && !C0().keySet().contains(strF))) {
            Map mapF = JsonNamesMapKt.f(d(), descriptor);
            Iterator<T> it = C0().keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                Integer num = (Integer) mapF.get((String) next);
                if (num != null && num.intValue() == i3) {
                    break;
                }
            }
            String str = (String) next;
            if (str != null) {
                return str;
            }
            String strA = jsonNamingStrategyN != null ? jsonNamingStrategyN.a(descriptor, i3, strF) : null;
            if (strA != null) {
                return strA;
            }
        }
        return strF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public JsonElement n0(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return (JsonElement) MapsKt.getValue(C0(), tag);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int o(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        while (this.f143113i < descriptor.e()) {
            int i3 = this.f143113i;
            this.f143113i = i3 + 1;
            String strB0 = b0(descriptor, i3);
            int i4 = this.f143113i - 1;
            this.f143114j = false;
            if (C0().containsKey(strB0) || F0(descriptor, i4)) {
                if (!this.f143042f.g() || !G0(descriptor, i4, strB0)) {
                    return i4;
                }
            }
        }
        return -1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeDecoder(Json json, JsonObject value, String str, SerialDescriptor serialDescriptor) {
        super(json, value, str, null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f143111g = value;
        this.f143112h = serialDescriptor;
    }
}
