package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

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
public final class PersistentOrderedSetMutableIterator<E> extends PersistentOrderedSetIterator<E> implements Iterator<E>, KMutableIterator {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PersistentOrderedSetBuilder f24572d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f24573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f24574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f24575h;

    public PersistentOrderedSetMutableIterator(PersistentOrderedSetBuilder persistentOrderedSetBuilder) {
        super(persistentOrderedSetBuilder.a(), persistentOrderedSetBuilder.b());
        this.f24572d = persistentOrderedSetBuilder;
        this.f24575h = persistentOrderedSetBuilder.b().b();
    }

    private final void d() {
        if (this.f24572d.b().b() != this.f24575h) {
            throw new ConcurrentModificationException();
        }
    }

    private final void e() {
        if (!this.f24574g) {
            throw new IllegalStateException();
        }
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetIterator, java.util.Iterator
    public Object next() {
        d();
        Object next = super.next();
        this.f24573f = next;
        this.f24574g = true;
        return next;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetIterator, java.util.Iterator
    public void remove() {
        e();
        TypeIntrinsics.a(this.f24572d).remove(this.f24573f);
        this.f24573f = null;
        this.f24574g = false;
        this.f24575h = this.f24572d.b().b();
        c(b() - 1);
    }
}
