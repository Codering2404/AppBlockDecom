package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;

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
public final class MergingSequence<T1, T2, V> implements Sequence<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Sequence f140328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Sequence f140329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function2 f140330c;

    /* JADX INFO: renamed from: kotlin.sequences.MergingSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<V>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator f140331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Iterator f140332b;

        AnonymousClass1() {
            this.f140331a = MergingSequence.this.f140328a.iterator();
            this.f140332b = MergingSequence.this.f140329b.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f140331a.hasNext() && this.f140332b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return MergingSequence.this.f140330c.invoke(this.f140331a.next(), this.f140332b.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new AnonymousClass1();
    }
}
