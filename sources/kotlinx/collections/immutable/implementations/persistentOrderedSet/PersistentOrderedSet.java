package kotlinx.collections.immutable.implementations.persistentOrderedSet;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentSet;
import kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
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
public final class PersistentOrderedSet<E> extends AbstractSet<E> implements PersistentSet<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f140845d = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final PersistentOrderedSet f140846f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f140847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f140848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PersistentHashMap f140849c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PersistentSet a() {
            return PersistentOrderedSet.f140846f;
        }

        private Companion() {
        }
    }

    static {
        EndOfChain endOfChain = EndOfChain.f140866a;
        f140846f = new PersistentOrderedSet(endOfChain, endOfChain, PersistentHashMap.f140735c.a());
    }

    public PersistentOrderedSet(Object obj, Object obj2, PersistentHashMap hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "hashMap");
        this.f140847a = obj;
        this.f140848b = obj2;
        this.f140849c = hashMap;
    }

    @Override // java.util.Collection, java.util.Set, kotlinx.collections.immutable.PersistentSet
    public PersistentSet addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentSet.Builder builder = builder();
        builder.addAll(elements);
        return builder.build();
    }

    @Override // kotlinx.collections.immutable.PersistentSet
    public PersistentSet.Builder builder() {
        return new PersistentOrderedSetBuilder(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.f140849c.containsKey(obj);
    }

    public final Object d() {
        return this.f140847a;
    }

    public final PersistentHashMap e() {
        return this.f140849c;
    }

    @Override // kotlin.collections.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        return set instanceof PersistentOrderedSet ? this.f140849c.g().k(((PersistentOrderedSet) obj).f140849c.g(), new Function2<Links, Links, Boolean>() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet.equals.1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Links noName_0, Links noName_1) {
                Intrinsics.checkNotNullParameter(noName_0, "$noName_0");
                Intrinsics.checkNotNullParameter(noName_1, "$noName_1");
                return Boolean.TRUE;
            }
        }) : set instanceof PersistentOrderedSetBuilder ? this.f140849c.g().k(((PersistentOrderedSetBuilder) obj).b().c(), new Function2<Links, Links, Boolean>() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet.equals.2
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Links noName_0, Links noName_1) {
                Intrinsics.checkNotNullParameter(noName_0, "$noName_0");
                Intrinsics.checkNotNullParameter(noName_1, "$noName_1");
                return Boolean.TRUE;
            }
        }) : super.equals(obj);
    }

    public final Object f() {
        return this.f140848b;
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f140849c.size();
    }

    @Override // kotlin.collections.AbstractSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return super.hashCode();
    }

    @Override // kotlin.collections.AbstractSet, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new PersistentOrderedSetIterator(this.f140847a, this.f140849c);
    }
}
