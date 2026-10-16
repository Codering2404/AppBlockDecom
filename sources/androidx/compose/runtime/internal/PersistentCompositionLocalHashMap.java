package androidx.compose.runtime.internal;

import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMapKt;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.ValueHolder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import kotlin.Metadata;
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
public final class PersistentCompositionLocalHashMap extends PersistentHashMap<CompositionLocal<Object>, ValueHolder<Object>> implements PersistentCompositionLocalMap {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f24813g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final PersistentCompositionLocalHashMap f24814h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder extends PersistentHashMapBuilder<CompositionLocal<Object>, ValueHolder<Object>> implements PersistentCompositionLocalMap.Builder {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private PersistentCompositionLocalHashMap f24815h;

        public Builder(PersistentCompositionLocalHashMap persistentCompositionLocalHashMap) {
            super(persistentCompositionLocalHashMap);
            this.f24815h = persistentCompositionLocalHashMap;
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof CompositionLocal) {
                return j((CompositionLocal) obj);
            }
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof ValueHolder) {
                return k((ValueHolder) obj);
            }
            return false;
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof CompositionLocal) {
                return l((CompositionLocal) obj);
            }
            return null;
        }

        @Override // java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof CompositionLocal) ? obj2 : m((CompositionLocal) obj, (ValueHolder) obj2);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public PersistentCompositionLocalHashMap build() {
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMap;
            if (c() == this.f24815h.g()) {
                persistentCompositionLocalHashMap = this.f24815h;
            } else {
                g(new MutabilityOwnership());
                persistentCompositionLocalHashMap = new PersistentCompositionLocalHashMap(c(), size());
            }
            this.f24815h = persistentCompositionLocalHashMap;
            return persistentCompositionLocalHashMap;
        }

        public /* bridge */ boolean j(CompositionLocal compositionLocal) {
            return super.containsKey(compositionLocal);
        }

        public /* bridge */ boolean k(ValueHolder valueHolder) {
            return super.containsValue(valueHolder);
        }

        public /* bridge */ ValueHolder l(CompositionLocal compositionLocal) {
            return (ValueHolder) super.get(compositionLocal);
        }

        public /* bridge */ ValueHolder m(CompositionLocal compositionLocal, ValueHolder valueHolder) {
            return (ValueHolder) super.getOrDefault(compositionLocal, valueHolder);
        }

        public /* bridge */ ValueHolder n(CompositionLocal compositionLocal) {
            return (ValueHolder) super.remove(compositionLocal);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof CompositionLocal) {
                return n((CompositionLocal) obj);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PersistentCompositionLocalHashMap a() {
            return PersistentCompositionLocalHashMap.f24814h;
        }

        private Companion() {
        }
    }

    static {
        TrieNode trieNodeA = TrieNode.f24482e.a();
        Intrinsics.checkNotNull(trieNodeA, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.ValueHolder<kotlin.Any?>>");
        f24814h = new PersistentCompositionLocalHashMap(trieNodeA, 0);
    }

    public PersistentCompositionLocalHashMap(TrieNode trieNode, int i3) {
        super(trieNode, i3);
    }

    @Override // androidx.compose.runtime.PersistentCompositionLocalMap
    public PersistentCompositionLocalMap V(CompositionLocal compositionLocal, ValueHolder valueHolder) {
        TrieNode.ModificationResult modificationResultP = g().P(compositionLocal.hashCode(), compositionLocal, valueHolder, 0);
        return modificationResultP == null ? this : new PersistentCompositionLocalHashMap(modificationResultP.a(), size() + modificationResultP.b());
    }

    @Override // androidx.compose.runtime.CompositionLocalMap
    public Object a(CompositionLocal compositionLocal) {
        return CompositionLocalMapKt.b(this, compositionLocal);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof CompositionLocal) {
            return m((CompositionLocal) obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof ValueHolder) {
            return n((ValueHolder) obj);
        }
        return false;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof CompositionLocal) {
            return o((CompositionLocal) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof CompositionLocal) ? obj2 : p((CompositionLocal) obj, (ValueHolder) obj2);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public Builder builder() {
        return new Builder(this);
    }

    public /* bridge */ boolean m(CompositionLocal compositionLocal) {
        return super.containsKey(compositionLocal);
    }

    public /* bridge */ boolean n(ValueHolder valueHolder) {
        return super.containsValue(valueHolder);
    }

    public /* bridge */ ValueHolder o(CompositionLocal compositionLocal) {
        return (ValueHolder) super.get(compositionLocal);
    }

    public /* bridge */ ValueHolder p(CompositionLocal compositionLocal, ValueHolder valueHolder) {
        return (ValueHolder) super.getOrDefault(compositionLocal, valueHolder);
    }
}
