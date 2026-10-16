package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class FlatteningSequence<T, R, E> implements Sequence<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Sequence f140312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f140313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f140314c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class State {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final State f140315a = new State();

        private State() {
        }
    }

    /* JADX INFO: renamed from: kotlin.sequences.FlatteningSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<E>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator f140316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Iterator f140317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f140318c;

        AnonymousClass1() {
            this.f140316a = FlatteningSequence.this.f140312a.iterator();
        }

        private final boolean a() {
            Iterator it = this.f140317b;
            if (it != null && it.hasNext()) {
                this.f140318c = 1;
                return true;
            }
            while (this.f140316a.hasNext()) {
                Iterator it2 = (Iterator) FlatteningSequence.this.f140314c.invoke(FlatteningSequence.this.f140313b.invoke(this.f140316a.next()));
                if (it2.hasNext()) {
                    this.f140317b = it2;
                    this.f140318c = 1;
                    return true;
                }
            }
            this.f140318c = 2;
            this.f140317b = null;
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i3 = this.f140318c;
            if (i3 == 1) {
                return true;
            }
            if (i3 == 2) {
                return false;
            }
            return a();
        }

        @Override // java.util.Iterator
        public Object next() {
            int i3 = this.f140318c;
            if (i3 == 2) {
                throw new NoSuchElementException();
            }
            if (i3 == 0 && !a()) {
                throw new NoSuchElementException();
            }
            this.f140318c = 0;
            Iterator it = this.f140317b;
            Intrinsics.checkNotNull(it);
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public FlatteningSequence(Sequence sequence, Function1 transformer, Function1 iterator) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        this.f140312a = sequence;
        this.f140313b = transformer;
        this.f140314c = iterator;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new AnonymousClass1();
    }
}
