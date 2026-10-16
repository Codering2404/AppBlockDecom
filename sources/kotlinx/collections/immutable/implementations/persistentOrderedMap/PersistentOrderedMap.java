package kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableCollection;
import kotlinx.collections.immutable.ImmutableSet;
import kotlinx.collections.immutable.PersistentMap;
import kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import kotlinx.collections.immutable.internal.EndOfChain;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class PersistentOrderedMap<K, V> extends AbstractMap<K, V> implements PersistentMap<K, V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f140806d = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final PersistentOrderedMap f140807f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f140808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f140809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PersistentHashMap f140810c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        EndOfChain endOfChain = EndOfChain.f140866a;
        f140807f = new PersistentOrderedMap(endOfChain, endOfChain, PersistentHashMap.f140735c.a());
    }

    public PersistentOrderedMap(Object obj, Object obj2, PersistentHashMap hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "hashMap");
        this.f140808a = obj;
        this.f140809b = obj2;
        this.f140810c = hashMap;
    }

    private final ImmutableSet c() {
        return new PersistentOrderedMapEntries(this);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f140810c.containsKey(obj);
    }

    public final Object d() {
        return this.f140808a;
    }

    public final PersistentHashMap e() {
        return this.f140810c;
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        return map instanceof PersistentOrderedMap ? this.f140810c.g().k(((PersistentOrderedMap) obj).f140810c.g(), new Function2<LinkedValue<V>, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap.equals.1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(LinkedValue a3, LinkedValue b3) {
                Intrinsics.checkNotNullParameter(a3, "a");
                Intrinsics.checkNotNullParameter(b3, "b");
                return Boolean.valueOf(Intrinsics.areEqual(a3.e(), b3.e()));
            }
        }) : map instanceof PersistentOrderedMapBuilder ? this.f140810c.g().k(((PersistentOrderedMapBuilder) obj).b().c(), new Function2<LinkedValue<V>, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap.equals.2
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(LinkedValue a3, LinkedValue b3) {
                Intrinsics.checkNotNullParameter(a3, "a");
                Intrinsics.checkNotNullParameter(b3, "b");
                return Boolean.valueOf(Intrinsics.areEqual(a3.e(), b3.e()));
            }
        }) : map instanceof PersistentHashMap ? this.f140810c.g().k(((PersistentHashMap) obj).g(), new Function2<LinkedValue<V>, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap.equals.3
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(LinkedValue a3, Object obj2) {
                Intrinsics.checkNotNullParameter(a3, "a");
                return Boolean.valueOf(Intrinsics.areEqual(a3.e(), obj2));
            }
        }) : map instanceof PersistentHashMapBuilder ? this.f140810c.g().k(((PersistentHashMapBuilder) obj).c(), new Function2<LinkedValue<V>, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap.equals.4
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(LinkedValue a3, Object obj2) {
                Intrinsics.checkNotNullParameter(a3, "a");
                return Boolean.valueOf(Intrinsics.areEqual(a3.e(), obj2));
            }
        }) : super.equals(obj);
    }

    @Override // kotlin.collections.AbstractMap
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public ImmutableSet getKeys() {
        return new PersistentOrderedMapKeys(this);
    }

    @Override // kotlin.collections.AbstractMap
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection getValues() {
        return new PersistentOrderedMapValues(this);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public Object get(Object obj) {
        LinkedValue linkedValue = (LinkedValue) this.f140810c.get(obj);
        if (linkedValue == null) {
            return null;
        }
        return linkedValue.e();
    }

    @Override // kotlin.collections.AbstractMap
    public final Set getEntries() {
        return c();
    }

    @Override // kotlin.collections.AbstractMap
    public int getSize() {
        return this.f140810c.size();
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public int hashCode() {
        return super.hashCode();
    }
}
