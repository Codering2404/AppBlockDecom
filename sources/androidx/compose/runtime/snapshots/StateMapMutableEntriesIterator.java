package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;

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
final class StateMapMutableEntriesIterator<K, V> extends StateMapMutableIterator<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.StateMapMutableEntriesIterator$next$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements Map.Entry<K, V>, KMutableMap.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f25018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Object f25019b;

        AnonymousClass1() {
            Map.Entry entryD = StateMapMutableEntriesIterator.this.d();
            Intrinsics.checkNotNull(entryD);
            this.f25018a = entryD.getKey();
            Map.Entry entryD2 = StateMapMutableEntriesIterator.this.d();
            Intrinsics.checkNotNull(entryD2);
            this.f25019b = entryD2.getValue();
        }

        public void a(Object obj) {
            this.f25019b = obj;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f25018a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f25019b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            StateMapMutableEntriesIterator stateMapMutableEntriesIterator = StateMapMutableEntriesIterator.this;
            if (stateMapMutableEntriesIterator.e().f() != ((StateMapMutableIterator) stateMapMutableEntriesIterator).f25023c) {
                throw new ConcurrentModificationException();
            }
            Object value = getValue();
            stateMapMutableEntriesIterator.e().put(getKey(), obj);
            a(obj);
            return value;
        }
    }

    public StateMapMutableEntriesIterator(SnapshotStateMap snapshotStateMap, Iterator it) {
        super(snapshotStateMap, it);
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        c();
        if (d() != null) {
            return new AnonymousClass1();
        }
        throw new IllegalStateException();
    }
}
