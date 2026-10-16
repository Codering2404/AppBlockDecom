package coil.request;

import coil.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class Parameters implements Iterable<Pair<? extends String, ? extends Entry>>, KMappedMarker {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f56130b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Parameters f56131c = new Parameters();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f56132a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f56133a;

        public Builder(Parameters parameters) {
            this.f56133a = MapsKt.toMutableMap(parameters.f56132a);
        }

        public final Parameters a() {
            return new Parameters(Collections.b(this.f56133a), null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f56134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f56135b;

        public final String a() {
            return this.f56135b;
        }

        public final Object b() {
            return this.f56134a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return Intrinsics.areEqual(this.f56134a, entry.f56134a) && Intrinsics.areEqual(this.f56135b, entry.f56135b);
        }

        public int hashCode() {
            Object obj = this.f56134a;
            int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
            String str = this.f56135b;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Entry(value=" + this.f56134a + ", memoryCacheKey=" + this.f56135b + ')';
        }
    }

    public /* synthetic */ Parameters(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    public final Map b() {
        if (isEmpty()) {
            return MapsKt.emptyMap();
        }
        Map map = this.f56132a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            String strA = ((Entry) entry.getValue()).a();
            if (strA != null) {
                linkedHashMap.put(entry.getKey(), strA);
            }
        }
        return linkedHashMap;
    }

    public final Builder d() {
        return new Builder(this);
    }

    public final Object e(String str) {
        Entry entry = (Entry) this.f56132a.get(str);
        if (entry != null) {
            return entry.b();
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Parameters) && Intrinsics.areEqual(this.f56132a, ((Parameters) obj).f56132a);
    }

    public int hashCode() {
        return this.f56132a.hashCode();
    }

    public final boolean isEmpty() {
        return this.f56132a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends Entry>> iterator() {
        Map map = this.f56132a;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(TuplesKt.a((String) entry.getKey(), (Entry) entry.getValue()));
        }
        return arrayList.iterator();
    }

    public String toString() {
        return "Parameters(entries=" + this.f56132a + ')';
    }

    private Parameters(Map map) {
        this.f56132a = map;
    }

    public Parameters() {
        this(MapsKt.emptyMap());
    }
}
