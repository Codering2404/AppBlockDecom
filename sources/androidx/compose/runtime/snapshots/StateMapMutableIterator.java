package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
abstract class StateMapMutableIterator<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SnapshotStateMap f25021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Iterator f25022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f25023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map.Entry f25024d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map.Entry f25025f;

    public StateMapMutableIterator(SnapshotStateMap snapshotStateMap, Iterator it) {
        this.f25021a = snapshotStateMap;
        this.f25022b = it;
        this.f25023c = snapshotStateMap.f();
        c();
    }

    protected final void c() {
        this.f25024d = this.f25025f;
        this.f25025f = this.f25022b.hasNext() ? (Map.Entry) this.f25022b.next() : null;
    }

    protected final Map.Entry d() {
        return this.f25024d;
    }

    public final SnapshotStateMap e() {
        return this.f25021a;
    }

    protected final Map.Entry f() {
        return this.f25025f;
    }

    public final boolean hasNext() {
        return this.f25025f != null;
    }

    public final void remove() {
        if (e().f() != this.f25023c) {
            throw new ConcurrentModificationException();
        }
        Map.Entry entry = this.f25024d;
        if (entry == null) {
            throw new IllegalStateException();
        }
        this.f25021a.remove(entry.getKey());
        this.f25024d = null;
        Unit unit = Unit.f139807a;
        this.f25023c = e().f();
    }
}
