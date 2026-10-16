package kotlinx.serialization.json.internal;

import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;

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
final class JsonIteratorArrayWrapped<T> implements Iterator<T>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Json f143086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReaderJsonLexer f143087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DeserializationStrategy f143088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f143089d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f143090f;

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f143090f) {
            return false;
        }
        if (this.f143087b.H() != 9) {
            if (this.f143087b.E() || this.f143090f) {
                return true;
            }
            AbstractJsonLexer.z(this.f143087b, (byte) 9, false, 2, null);
            throw new KotlinNothingValueException();
        }
        this.f143090f = true;
        this.f143087b.k((byte) 9);
        if (this.f143087b.E()) {
            if (this.f143087b.H() == 8) {
                AbstractJsonLexer.x(this.f143087b, "There is a start of the new array after the one parsed to sequence. ARRAY_WRAPPED mode doesn't merge consecutive arrays.\nIf you need to parse a stream of arrays, please use WHITESPACE_SEPARATED mode instead.", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            this.f143087b.v();
        }
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (this.f143089d) {
            this.f143089d = false;
        } else {
            this.f143087b.l(',');
        }
        return new StreamingJsonDecoder(this.f143086a, WriteMode.f143170c, this.f143087b, this.f143088c.getDescriptor(), null).G(this.f143088c);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
