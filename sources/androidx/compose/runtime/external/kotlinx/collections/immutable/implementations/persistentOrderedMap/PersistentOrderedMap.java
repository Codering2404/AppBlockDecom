package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMap;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class PersistentOrderedMap<K, V> extends AbstractMap<K, V> implements PersistentMap<K, V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f24526d = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f24527f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final PersistentOrderedMap f24528g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f24529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f24530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PersistentHashMap f24531c;

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
        EndOfChain endOfChain = EndOfChain.f24577a;
        f24528g = new PersistentOrderedMap(endOfChain, endOfChain, PersistentHashMap.f24457c.a());
    }

    public PersistentOrderedMap(Object obj, Object obj2, PersistentHashMap persistentHashMap) {
        this.f24529a = obj;
        this.f24530b = obj2;
        this.f24531c = persistentHashMap;
    }

    private final ImmutableSet c() {
        return new PersistentOrderedMapEntries(this);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public PersistentMap.Builder builder() {
        return new PersistentOrderedMapBuilder(this);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f24531c.containsKey(obj);
    }

    public final Object d() {
        return this.f24529a;
    }

    public final PersistentHashMap e() {
        return this.f24531c;
    }

    @Override // kotlin.collections.AbstractMap
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public ImmutableSet getKeys() {
        return new PersistentOrderedMapKeys(this);
    }

    public final Object g() {
        return this.f24530b;
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public Object get(Object obj) {
        LinkedValue linkedValue = (LinkedValue) this.f24531c.get(obj);
        if (linkedValue != null) {
            return linkedValue.e();
        }
        return null;
    }

    @Override // kotlin.collections.AbstractMap
    public final Set getEntries() {
        return c();
    }

    @Override // kotlin.collections.AbstractMap
    public int getSize() {
        return this.f24531c.size();
    }

    @Override // kotlin.collections.AbstractMap
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection getValues() {
        return new PersistentOrderedMapValues(this);
    }
}
