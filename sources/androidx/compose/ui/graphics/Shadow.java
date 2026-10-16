package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class Shadow {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f25903d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Shadow f25904e = new Shadow(0, 0, 0.0f, 7, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f25905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f25906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f25907c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Shadow a() {
            return Shadow.f25904e;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Shadow(long j3, long j4, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, f3);
    }

    public final float b() {
        return this.f25907c;
    }

    public final long c() {
        return this.f25905a;
    }

    public final long d() {
        return this.f25906b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shadow)) {
            return false;
        }
        Shadow shadow = (Shadow) obj;
        return Color.t(this.f25905a, shadow.f25905a) && Offset.j(this.f25906b, shadow.f25906b) && this.f25907c == shadow.f25907c;
    }

    public int hashCode() {
        return (((Color.z(this.f25905a) * 31) + Offset.o(this.f25906b)) * 31) + Float.hashCode(this.f25907c);
    }

    public String toString() {
        return "Shadow(color=" + ((Object) Color.A(this.f25905a)) + ", offset=" + ((Object) Offset.s(this.f25906b)) + ", blurRadius=" + this.f25907c + ')';
    }

    private Shadow(long j3, long j4, float f3) {
        this.f25905a = j3;
        this.f25906b = j4;
        this.f25907c = f3;
    }

    public /* synthetic */ Shadow(long j3, long j4, float f3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ColorKt.d(4278190080L) : j3, (i3 & 2) != 0 ? Offset.f25596b.c() : j4, (i3 & 4) != 0 ? 0.0f : f3, null);
    }
}
