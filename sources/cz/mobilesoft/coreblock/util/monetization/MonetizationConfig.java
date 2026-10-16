package cz.mobilesoft.coreblock.util.monetization;

import cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt;
import cz.mobilesoft.coreblock.util.CrashHelper;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class MonetizationConfig {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f128870c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f128871d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Json f128872e = JsonKt.b(null, new Function1() { // from class: cz.mobilesoft.coreblock.util.monetization.a
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MonetizationConfig.e((JsonBuilder) obj);
        }
    }, 1, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f128873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f128874b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map b(String str) {
            if (str == null || StringsKt.p0(str)) {
                return MapsKt.emptyMap();
            }
            try {
                Json json = MonetizationConfig.f128872e;
                json.a();
                StringSerializer stringSerializer = StringSerializer.f142891a;
                Map map = (Map) json.d(new LinkedHashMapSerializer(stringSerializer, stringSerializer), str);
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = (String) entry.getKey();
                    PaywallEngine paywallEngineA = PaywallEngine.Companion.a((String) entry.getValue());
                    Pair pairA = paywallEngineA != null ? TuplesKt.a(StringsKt.t1(str2).toString(), paywallEngineA) : null;
                    if (pairA != null) {
                        arrayList.add(pairA);
                    }
                }
                return MapsKt.toMap(arrayList);
            } catch (Exception e3) {
                d(DataStoreKeysKt.c2().a(), e3);
                return MapsKt.emptyMap();
            }
        }

        private final Map c(String str) {
            if (str == null || StringsKt.p0(str)) {
                return MapsKt.emptyMap();
            }
            try {
                Json json = MonetizationConfig.f128872e;
                json.a();
                StringSerializer stringSerializer = StringSerializer.f142891a;
                return (Map) json.d(new LinkedHashMapSerializer(stringSerializer, stringSerializer), str);
            } catch (Exception e3) {
                d(DataStoreKeysKt.L1().a(), e3);
                return MapsKt.emptyMap();
            }
        }

        private final void d(String str, Throwable th) {
            CrashHelper.f127788a.h("Unreadable persisted " + str + ", falling back to the bundled paywall defaults", th);
        }

        public final MonetizationConfig a(String str, String str2) {
            return new MonetizationConfig(b(str), c(str2));
        }

        private Companion() {
        }
    }

    public MonetizationConfig(Map engines, Map values) {
        Intrinsics.checkNotNullParameter(engines, "engines");
        Intrinsics.checkNotNullParameter(values, "values");
        this.f128873a = engines;
        this.f128874b = values;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.h(true);
        Json.i(true);
        return Unit.f139807a;
    }

    public final PaywallEngine c(String str) {
        if (str != null) {
            return (PaywallEngine) this.f128873a.get(str);
        }
        return null;
    }

    public final Map d() {
        return this.f128874b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MonetizationConfig)) {
            return false;
        }
        MonetizationConfig monetizationConfig = (MonetizationConfig) obj;
        return Intrinsics.areEqual(this.f128873a, monetizationConfig.f128873a) && Intrinsics.areEqual(this.f128874b, monetizationConfig.f128874b);
    }

    public int hashCode() {
        return (this.f128873a.hashCode() * 31) + this.f128874b.hashCode();
    }

    public String toString() {
        return "MonetizationConfig(engines=" + this.f128873a + ", values=" + this.f128874b + ")";
    }
}
