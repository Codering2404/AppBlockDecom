package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class KotlinVersion implements Comparable<KotlinVersion> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f139753f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final KotlinVersion f139754g = KotlinVersionCurrentValue.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f139755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f139756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f139757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f139758d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public KotlinVersion(int i3, int i4, int i5) {
        this.f139755a = i3;
        this.f139756b = i4;
        this.f139757c = i5;
        this.f139758d = b(i3, i4, i5);
    }

    private final int b(int i3, int i4, int i5) {
        if (i3 >= 0 && i3 < 256 && i4 >= 0 && i4 < 256 && i5 >= 0 && i5 < 256) {
            return (i3 << 16) + (i4 << 8) + i5;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i3 + '.' + i4 + '.' + i5).toString());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(KotlinVersion other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.f139758d - other.f139758d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        KotlinVersion kotlinVersion = obj instanceof KotlinVersion ? (KotlinVersion) obj : null;
        return kotlinVersion != null && this.f139758d == kotlinVersion.f139758d;
    }

    public int hashCode() {
        return this.f139758d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f139755a);
        sb.append('.');
        sb.append(this.f139756b);
        sb.append('.');
        sb.append(this.f139757c);
        return sb.toString();
    }
}
