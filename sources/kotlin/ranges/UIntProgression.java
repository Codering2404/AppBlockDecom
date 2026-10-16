package kotlin.ranges;

import com.facebook.FacebookContentProvider;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public class UIntProgression implements Iterable<UInt>, KMappedMarker {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f140234d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f140235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f140236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f140237c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ UIntProgression(int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UIntProgression)) {
            return false;
        }
        if (isEmpty() && ((UIntProgression) obj).isEmpty()) {
            return true;
        }
        UIntProgression uIntProgression = (UIntProgression) obj;
        return this.f140235a == uIntProgression.f140235a && this.f140236b == uIntProgression.f140236b && this.f140237c == uIntProgression.f140237c;
    }

    public final int g() {
        return this.f140235a;
    }

    public final int h() {
        return this.f140236b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f140235a * 31) + this.f140236b) * 31) + this.f140237c;
    }

    public boolean isEmpty() {
        return this.f140237c > 0 ? Integer.compareUnsigned(this.f140235a, this.f140236b) > 0 : Integer.compareUnsigned(this.f140235a, this.f140236b) < 0;
    }

    @Override // java.lang.Iterable
    public final Iterator<UInt> iterator() {
        return new UIntProgressionIterator(this.f140235a, this.f140236b, this.f140237c, null);
    }

    public String toString() {
        StringBuilder sb;
        int i3;
        if (this.f140237c > 0) {
            sb = new StringBuilder();
            sb.append((Object) UInt.e(this.f140235a));
            sb.append(FacebookContentProvider.INVALID_FILE_NAME);
            sb.append((Object) UInt.e(this.f140236b));
            sb.append(" step ");
            i3 = this.f140237c;
        } else {
            sb = new StringBuilder();
            sb.append((Object) UInt.e(this.f140235a));
            sb.append(" downTo ");
            sb.append((Object) UInt.e(this.f140236b));
            sb.append(" step ");
            i3 = -this.f140237c;
        }
        sb.append(i3);
        return sb.toString();
    }

    private UIntProgression(int i3, int i4, int i5) {
        if (i5 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i5 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f140235a = i3;
        this.f140236b = UProgressionUtilKt.d(i3, i4, i5);
        this.f140237c = i5;
    }
}
