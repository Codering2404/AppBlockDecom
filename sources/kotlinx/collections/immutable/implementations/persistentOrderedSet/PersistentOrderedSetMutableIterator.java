package kotlinx.collections.immutable.implementations.persistentOrderedSet;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class PersistentOrderedSetMutableIterator<E> extends PersistentOrderedSetIterator<E> implements Iterator<E>, KMutableIterator {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PersistentOrderedSetBuilder f140861d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f140862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f140863g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f140864h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentOrderedSetMutableIterator(PersistentOrderedSetBuilder builder) {
        super(builder.a(), builder.b());
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f140861d = builder;
        this.f140864h = builder.b().b();
    }

    private final void d() {
        if (this.f140861d.b().b() != this.f140864h) {
            throw new ConcurrentModificationException();
        }
    }

    private final void e() {
        if (!this.f140863g) {
            throw new IllegalStateException();
        }
    }

    @Override // kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetIterator, java.util.Iterator
    public Object next() {
        d();
        Object next = super.next();
        this.f140862f = next;
        this.f140863g = true;
        return next;
    }

    @Override // kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetIterator, java.util.Iterator
    public void remove() {
        e();
        this.f140861d.remove(this.f140862f);
        this.f140862f = null;
        this.f140863g = false;
        this.f140864h = this.f140861d.b().b();
        c(b() - 1);
    }
}
