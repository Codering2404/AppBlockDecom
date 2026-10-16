package kotlinx.collections.immutable.implementations.immutableMap;

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
import kotlinx.collections.immutable.implementations.persistentOrderedMap.LinkedValue;
import kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap;
import kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder;

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
public final class PersistentHashMap<K, V> extends AbstractMap<K, V> implements PersistentMap<K, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f140735c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final PersistentHashMap f140736d = new PersistentHashMap(TrieNode.f140767e.a(), 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TrieNode f140737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f140738b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PersistentHashMap a() {
            return PersistentHashMap.f140736d;
        }

        private Companion() {
        }
    }

    public PersistentHashMap(TrieNode node, int i3) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.f140737a = node;
        this.f140738b = i3;
    }

    private final ImmutableSet e() {
        return new PersistentHashMapEntries(this);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f140737a.g(obj == null ? 0 : obj.hashCode(), obj, 0);
    }

    public PersistentHashMapBuilder d() {
        return new PersistentHashMapBuilder(this);
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
        return map instanceof PersistentOrderedMap ? this.f140737a.k(((PersistentOrderedMap) obj).e().f140737a, new Function2<V, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.equals.1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Object obj2, LinkedValue b3) {
                Intrinsics.checkNotNullParameter(b3, "b");
                return Boolean.valueOf(Intrinsics.areEqual(obj2, b3.e()));
            }
        }) : map instanceof PersistentOrderedMapBuilder ? this.f140737a.k(((PersistentOrderedMapBuilder) obj).b().c(), new Function2<V, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.equals.2
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Object obj2, LinkedValue b3) {
                Intrinsics.checkNotNullParameter(b3, "b");
                return Boolean.valueOf(Intrinsics.areEqual(obj2, b3.e()));
            }
        }) : map instanceof PersistentHashMap ? this.f140737a.k(((PersistentHashMap) obj).f140737a, new Function2<V, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.equals.3
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Object obj2, Object obj3) {
                return Boolean.valueOf(Intrinsics.areEqual(obj2, obj3));
            }
        }) : map instanceof PersistentHashMapBuilder ? this.f140737a.k(((PersistentHashMapBuilder) obj).c(), new Function2<V, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.equals.4
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Object obj2, Object obj3) {
                return Boolean.valueOf(Intrinsics.areEqual(obj2, obj3));
            }
        }) : super.equals(obj);
    }

    @Override // kotlin.collections.AbstractMap
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public ImmutableSet getKeys() {
        return new PersistentHashMapKeys(this);
    }

    public final TrieNode g() {
        return this.f140737a;
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public Object get(Object obj) {
        return this.f140737a.l(obj == null ? 0 : obj.hashCode(), obj, 0);
    }

    @Override // kotlin.collections.AbstractMap
    public final Set getEntries() {
        return e();
    }

    @Override // kotlin.collections.AbstractMap
    public int getSize() {
        return this.f140738b;
    }

    @Override // kotlin.collections.AbstractMap
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection getValues() {
        return new PersistentHashMapValues(this);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public int hashCode() {
        return super.hashCode();
    }
}
