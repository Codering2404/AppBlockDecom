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
public final class TakeWhileSequence<T> implements Sequence<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Sequence f140432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f140433b;

    /* JADX INFO: renamed from: kotlin.sequences.TakeWhileSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator f140434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f140435b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f140436c;

        AnonymousClass1() {
            this.f140434a = TakeWhileSequence.this.f140432a.iterator();
        }

        private final void a() {
            if (this.f140434a.hasNext()) {
                Object next = this.f140434a.next();
                if (((Boolean) TakeWhileSequence.this.f140433b.invoke(next)).booleanValue()) {
                    this.f140435b = 1;
                    this.f140436c = next;
                    return;
                }
            }
            this.f140435b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f140435b == -1) {
                a();
            }
            return this.f140435b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f140435b == -1) {
                a();
            }
            if (this.f140435b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.f140436c;
            this.f140436c = null;
            this.f140435b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public TakeWhileSequence(Sequence sequence, Function1 predicate) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        this.f140432a = sequence;
        this.f140433b = predicate;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new AnonymousClass1();
    }
}
