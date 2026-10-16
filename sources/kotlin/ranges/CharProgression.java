package kotlin.ranges;

import com.facebook.FacebookContentProvider;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.internal.ProgressionUtilKt;
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
public class CharProgression implements Iterable<Character>, KMappedMarker {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f140192d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f140193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char f140194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f140195c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public CharProgression(char c3, char c4, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f140193a = c3;
        this.f140194b = (char) ProgressionUtilKt.c(c3, c4, i3);
        this.f140195c = i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CharProgression)) {
            return false;
        }
        if (isEmpty() && ((CharProgression) obj).isEmpty()) {
            return true;
        }
        CharProgression charProgression = (CharProgression) obj;
        return this.f140193a == charProgression.f140193a && this.f140194b == charProgression.f140194b && this.f140195c == charProgression.f140195c;
    }

    public final char g() {
        return this.f140193a;
    }

    public final char h() {
        return this.f140194b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f140193a * 31) + this.f140194b) * 31) + this.f140195c;
    }

    public boolean isEmpty() {
        return this.f140195c > 0 ? Intrinsics.compare((int) this.f140193a, (int) this.f140194b) > 0 : Intrinsics.compare((int) this.f140193a, (int) this.f140194b) < 0;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public CharIterator iterator() {
        return new CharProgressionIterator(this.f140193a, this.f140194b, this.f140195c);
    }

    public String toString() {
        StringBuilder sb;
        int i3;
        if (this.f140195c > 0) {
            sb = new StringBuilder();
            sb.append(this.f140193a);
            sb.append(FacebookContentProvider.INVALID_FILE_NAME);
            sb.append(this.f140194b);
            sb.append(" step ");
            i3 = this.f140195c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f140193a);
            sb.append(" downTo ");
            sb.append(this.f140194b);
            sb.append(" step ");
            i3 = -this.f140195c;
        }
        sb.append(i3);
        return sb.toString();
    }
}
