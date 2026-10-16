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
public final class SubSequence<T> implements Sequence<T>, DropTakeSequence<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Sequence f140422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f140423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f140424c;

    /* JADX INFO: renamed from: kotlin.sequences.SubSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator f140425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f140426b;

        AnonymousClass1() {
            this.f140425a = SubSequence.this.f140422a.iterator();
        }

        private final void a() {
            while (this.f140426b < SubSequence.this.f140423b && this.f140425a.hasNext()) {
                this.f140425a.next();
                this.f140426b++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f140426b < SubSequence.this.f140424c && this.f140425a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (this.f140426b >= SubSequence.this.f140424c) {
                throw new NoSuchElementException();
            }
            this.f140426b++;
            return this.f140425a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public SubSequence(Sequence sequence, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.f140422a = sequence;
        this.f140423b = i3;
        this.f140424c = i4;
        if (i3 < 0) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i3).toString());
        }
        if (i4 < 0) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i4).toString());
        }
        if (i4 >= i3) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i4 + " < " + i3).toString());
    }

    private final int f() {
        return this.f140424c - this.f140423b;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence a(int i3) {
        return i3 >= f() ? SequencesKt__SequencesKt.g() : new SubSequence(this.f140422a, this.f140423b + i3, this.f140424c);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence b(int i3) {
        if (i3 >= f()) {
            return this;
        }
        Sequence sequence = this.f140422a;
        int i4 = this.f140423b;
        return new SubSequence(sequence, i4, i3 + i4);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new AnonymousClass1();
    }
}
