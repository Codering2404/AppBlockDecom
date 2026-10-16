package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class DropWhileSequence<T> implements Sequence<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Sequence f140298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f140299b;

    /* JADX INFO: renamed from: kotlin.sequences.DropWhileSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator f140300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f140301b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f140302c;

        AnonymousClass1() {
            this.f140300a = DropWhileSequence.this.f140298a.iterator();
        }

        private final void a() {
            while (this.f140300a.hasNext()) {
                Object next = this.f140300a.next();
                if (!((Boolean) DropWhileSequence.this.f140299b.invoke(next)).booleanValue()) {
                    this.f140302c = next;
                    this.f140301b = 1;
                    return;
                }
            }
            this.f140301b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f140301b == -1) {
                a();
            }
            return this.f140301b == 1 || this.f140300a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f140301b == -1) {
                a();
            }
            if (this.f140301b != 1) {
                return this.f140300a.next();
            }
            Object obj = this.f140302c;
            this.f140302c = null;
            this.f140301b = 0;
            return obj;
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
