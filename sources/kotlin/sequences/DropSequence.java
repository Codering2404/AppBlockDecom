package kotlin.sequences;

import java.util.Iterator;
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
public final class DropSequence<T> implements Sequence<T>, DropTakeSequence<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Sequence f140294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f140295b;

    /* JADX INFO: renamed from: kotlin.sequences.DropSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator f140296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f140297b;

        AnonymousClass1(DropSequence dropSequence) {
            this.f140296a = dropSequence.f140294a.iterator();
            this.f140297b = dropSequence.f140295b;
        }

        private final void a() {
            while (this.f140297b > 0 && this.f140296a.hasNext()) {
                this.f140296a.next();
                this.f140297b--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f140296a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            return this.f140296a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public DropSequence(Sequence sequence, int i3) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.f140294a = sequence;
        this.f140295b = i3;
        if (i3 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i3 + '.').toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence a(int i3) {
        int i4 = this.f140295b + i3;
        return i4 < 0 ? new DropSequence(this, i3) : new DropSequence(this.f140294a, i4);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence b(int i3) {
        int i4 = this.f140295b;
        int i5 = i4 + i3;
        return i5 < 0 ? new TakeSequence(this, i3) : new SubSequence(this.f140294a, i4, i5);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new AnonymousClass1(this);
    }
}
