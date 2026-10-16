package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public final class TakeSequence<T> implements Sequence<T>, DropTakeSequence<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Sequence f140428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f140429b;

    /* JADX INFO: renamed from: kotlin.sequences.TakeSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f140430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Iterator f140431b;

        AnonymousClass1(TakeSequence takeSequence) {
            this.f140430a = takeSequence.f140429b;
            this.f140431b = takeSequence.f140428a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f140430a > 0 && this.f140431b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            int i3 = this.f140430a;
            if (i3 == 0) {
                throw new NoSuchElementException();
            }
            this.f140430a = i3 - 1;
            return this.f140431b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public TakeSequence(Sequence sequence, int i3) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.f140428a = sequence;
        this.f140429b = i3;
        if (i3 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i3 + '.').toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence a(int i3) {
        int i4 = this.f140429b;
        return i3 >= i4 ? SequencesKt__SequencesKt.g() : new SubSequence(this.f140428a, i3, i4);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence b(int i3) {
        return i3 >= this.f140429b ? this : new TakeSequence(this.f140428a, i3);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new AnonymousClass1(this);
    }
}
