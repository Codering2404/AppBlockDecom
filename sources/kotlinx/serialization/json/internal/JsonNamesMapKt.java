package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonNames;
import kotlinx.serialization.json.JsonNamingStrategy;
import kotlinx.serialization.json.JsonSchemaCacheKt;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;

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
public final class JsonNamesMapKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DescriptorSchemaCache.Key f143095a = new DescriptorSchemaCache.Key();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final DescriptorSchemaCache.Key f143096b = new DescriptorSchemaCache.Key();

    private static final Map c(SerialDescriptor serialDescriptor, Json json) {
        String strA;
        String[] strArrNames;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean zE = e(json, serialDescriptor);
        JsonNamingStrategy jsonNamingStrategyN = n(serialDescriptor, json);
        int iE = serialDescriptor.e();
        for (int i3 = 0; i3 < iE; i3++) {
            List listG = serialDescriptor.g(i3);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listG) {
                if (obj instanceof JsonNames) {
                    arrayList.add(obj);
                }
            }
            JsonNames jsonNames = (JsonNames) CollectionsKt.singleOrNull((List) arrayList);
            if (jsonNames != null && (strArrNames = jsonNames.names()) != null) {
                for (String lowerCase : strArrNames) {
                    if (zE) {
                        lowerCase = lowerCase.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    }
                    d(linkedHashMap, serialDescriptor, lowerCase, i3);
                }
            }
            if (zE) {
                strA = serialDescriptor.f(i3).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(strA, "toLowerCase(...)");
            } else {
                strA = jsonNamingStrategyN != null ? jsonNamingStrategyN.a(serialDescriptor, i3, serialDescriptor.f(i3)) : null;
            }
            if (strA != null) {
                d(linkedHashMap, serialDescriptor, strA, i3);
            }
        }
        return linkedHashMap.isEmpty() ? MapsKt.emptyMap() : linkedHashMap;
    }

    private static final void d(Map map, SerialDescriptor serialDescriptor, String str, int i3) {
        String str2 = Intrinsics.areEqual(serialDescriptor.d(), SerialKind.ENUM.f142752a) ? "enum value" : "property";
        if (!map.containsKey(str)) {
            map.put(str, Integer.valueOf(i3));
            return;
        }
        throw new JsonException("The suggested name '" + str + "' for " + str2 + ' ' + serialDescriptor.f(i3) + " is already one of the names for " + str2 + ' ' + serialDescriptor.f(((Number) MapsKt.getValue(map, str)).intValue()) + " in " + serialDescriptor);
    }

    private static final boolean e(Json json, SerialDescriptor serialDescriptor) {
        return json.f().h() && Intrinsics.areEqual(serialDescriptor.d(), SerialKind.ENUM.f142752a);
    }

    public static final Map f(final Json json, final SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return (Map) JsonSchemaCacheKt.a(json).b(descriptor, f143095a, new Function0() { // from class: kotlinx.serialization.json.internal.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return JsonNamesMapKt.g(descriptor, json);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map g(SerialDescriptor serialDescriptor, Json json) {
        return c(serialDescriptor, json);
    }

    public static final DescriptorSchemaCache.Key h() {
        return f143095a;
    }

    public static final String i(SerialDescriptor serialDescriptor, Json json, int i3) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        JsonNamingStrategy jsonNamingStrategyN = n(serialDescriptor, json);
        return jsonNamingStrategyN == null ? serialDescriptor.f(i3) : o(serialDescriptor, json, jsonNamingStrategyN)[i3];
    }

    public static final int j(SerialDescriptor serialDescriptor, Json json, String name) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(name, "name");
        if (e(json, serialDescriptor)) {
            String lowerCase = name.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return m(serialDescriptor, json, lowerCase);
        }
        if (n(serialDescriptor, json) != null) {
            return m(serialDescriptor, json, name);
        }
        int iC = serialDescriptor.c(name);
        return (iC == -3 && json.f().o()) ? m(serialDescriptor, json, name) : iC;
    }

    public static final int k(SerialDescriptor serialDescriptor, Json json, String name, String suffix) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        int iJ = j(serialDescriptor, json, name);
        if (iJ != -3) {
            return iJ;
        }
        throw new SerializationException(serialDescriptor.i() + " does not contain element with name '" + name + '\'' + suffix);
    }

    public static /* synthetic */ int l(SerialDescriptor serialDescriptor, Json json, String str, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        return k(serialDescriptor, json, str, str2);
    }

    private static final int m(SerialDescriptor serialDescriptor, Json json, String str) {
        Integer num = (Integer) f(json, serialDescriptor).get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final JsonNamingStrategy n(SerialDescriptor serialDescriptor, Json json) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        if (Intrinsics.areEqual(serialDescriptor.d(), StructureKind.CLASS.f142753a)) {
            return json.f().l();
        }
        return null;
    }

    public static final String[] o(final SerialDescriptor serialDescriptor, Json json, final JsonNamingStrategy strategy) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        return (String[]) JsonSchemaCacheKt.a(json).b(serialDescriptor, f143096b, new Function0() { // from class: kotlinx.serialization.json.internal.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return JsonNamesMapKt.p(serialDescriptor, strategy);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String[] p(SerialDescriptor serialDescriptor, JsonNamingStrategy jsonNamingStrategy) {
        int iE = serialDescriptor.e();
        String[] strArr = new String[iE];
        for (int i3 = 0; i3 < iE; i3++) {
            strArr[i3] = jsonNamingStrategy.a(serialDescriptor, i3, serialDescriptor.f(i3));
        }
        return strArr;
    }
}
