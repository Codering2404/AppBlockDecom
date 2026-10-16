package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public class PersistentHashMap<K, V> extends AbstractMap<K, V> implements PersistentMap<K, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f24457c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f24458d = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final PersistentHashMap f24459f = new PersistentHashMap(TrieNode.f24482e.a(), 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TrieNode f24460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24461b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PersistentHashMap a() {
            PersistentHashMap persistentHashMap = PersistentHashMap.f24459f;
            Intrinsics.checkNotNull(persistentHashMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf>");
            return persistentHashMap;
        }

        private Companion() {
        }
    }

    public PersistentHashMap(TrieNode trieNode, int i3) {
        this.f24460a = trieNode;
        this.f24461b = i3;
    }

    private final ImmutableSet e() {
        return new PersistentHashMapEntries(this);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f24460a.k(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public PersistentHashMapBuilder builder() {
        return new PersistentHashMapBuilder(this);
    }

    @Override // kotlin.collections.AbstractMap
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public ImmutableSet getKeys() {
        return new PersistentHashMapKeys(this);
    }

    public final TrieNode g() {
        return this.f24460a;
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public Object get(Object obj) {
        return this.f24460a.o(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // kotlin.collections.AbstractMap
    public final Set getEntries() {
        return e();
    }

    @Override // kotlin.collections.AbstractMap
    public int getSize() {
        return this.f24461b;
    }

    @Override // kotlin.collections.AbstractMap
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection getValues() {
        return new PersistentHashMapValues(this);
    }

    public PersistentHashMap i(Object obj, Object obj2) {
        TrieNode.ModificationResult modificationResultP = this.f24460a.P(obj != null ? obj.hashCode() : 0, obj, obj2, 0);
        return modificationResultP == null ? this : new PersistentHashMap(modificationResultP.a(), size() + modificationResultP.b());
    }

    public PersistentHashMap j(Object obj) {
        TrieNode trieNodeQ = this.f24460a.Q(obj != null ? obj.hashCode() : 0, obj, 0);
        return this.f24460a == trieNodeQ ? this : trieNodeQ == null ? f24457c.a() : new PersistentHashMap(trieNodeQ, size() - 1);
    }
}
