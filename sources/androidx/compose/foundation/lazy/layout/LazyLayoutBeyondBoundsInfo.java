package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LazyLayoutBeyondBoundsInfo {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f8000b = MutableVector.f24388d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableVector f8001a = new MutableVector(new Interval[16], 0);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Interval {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f8003b;

        public Interval(int i3, int i4) {
            this.f8002a = i3;
            this.f8003b = i4;
            if (!(i3 >= 0)) {
                InlineClassHelperKt.a("negative start index");
            }
            if (i4 >= i3) {
                return;
            }
            InlineClassHelperKt.a("end index greater than start");
        }

        public final int a() {
            return this.f8003b;
        }

        public final int b() {
            return this.f8002a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Interval)) {
                return false;
            }
            Interval interval = (Interval) obj;
            return this.f8002a == interval.f8002a && this.f8003b == interval.f8003b;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f8002a) * 31) + Integer.hashCode(this.f8003b);
        }

        public String toString() {
            return "Interval(start=" + this.f8002a + ", end=" + this.f8003b + ')';
        }
    }

    public final Interval a(int i3, int i4) {
        Interval interval = new Interval(i3, i4);
        this.f8001a.b(interval);
        return interval;
    }

    public final int b() {
        int iA = ((Interval) this.f8001a.n()).a();
        MutableVector mutableVector = this.f8001a;
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        for (int i3 = 0; i3 < iO; i3++) {
            Interval interval = (Interval) objArr[i3];
            if (interval.a() > iA) {
                iA = interval.a();
            }
        }
        return iA;
    }

    public final int c() {
        int iB = ((Interval) this.f8001a.n()).b();
        MutableVector mutableVector = this.f8001a;
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        for (int i3 = 0; i3 < iO; i3++) {
            Interval interval = (Interval) objArr[i3];
            if (interval.b() < iB) {
                iB = interval.b();
            }
        }
        if (!(iB >= 0)) {
            InlineClassHelperKt.a("negative minIndex");
        }
        return iB;
    }

    public final boolean d() {
        return this.f8001a.o() != 0;
    }

    public final void e(Interval interval) {
        this.f8001a.s(interval);
    }
}
