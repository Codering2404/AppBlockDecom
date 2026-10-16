package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
final class LinesIterator implements Iterator<String>, KMappedMarker {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final State f140558g = new State(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f140559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f140560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f140561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f140562d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f140563f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class State {
        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private State() {
        }
    }

    public LinesIterator(CharSequence string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.f140559a = string;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f140560b = 0;
        int i3 = this.f140562d;
        int i4 = this.f140561c;
        this.f140561c = this.f140563f + i3;
        return this.f140559a.subSequence(i4, i3).toString();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i3;
        int i4;
        int i5 = this.f140560b;
        if (i5 != 0) {
            return i5 == 1;
        }
        if (this.f140563f < 0) {
            this.f140560b = 2;
            return false;
        }
        int length = this.f140559a.length();
        int length2 = this.f140559a.length();
        for (int i6 = this.f140561c; i6 < length2; i6++) {
            char cCharAt = this.f140559a.charAt(i6);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i3 = (cCharAt == '\r' && (i4 = i6 + 1) < this.f140559a.length() && this.f140559a.charAt(i4) == '\n') ? 2 : 1;
                length = i6;
                this.f140560b = 1;
                this.f140563f = i3;
                this.f140562d = length;
                return true;
            }
        }
        i3 = -1;
        this.f140560b = 1;
        this.f140563f = i3;
        this.f140562d = length;
        return true;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
