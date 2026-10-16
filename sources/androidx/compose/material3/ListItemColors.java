package androidx.compose.material3;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ListItemColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f18035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f18036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f18037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f18038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f18039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f18040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f18041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f18042h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f18043i;

    public /* synthetic */ ListItemColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7, j8, j9, j10, j11);
    }

    public final long a() {
        return this.f18035a;
    }

    public final long b(boolean z2) {
        return z2 ? this.f18036b : this.f18041g;
    }

    public final long c(boolean z2) {
        return z2 ? this.f18037c : this.f18042h;
    }

    public final long d() {
        return this.f18038d;
    }

    public final long e() {
        return this.f18039e;
    }

    public final long f(boolean z2) {
        return z2 ? this.f18040f : this.f18043i;
    }

    private ListItemColors(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11) {
        this.f18035a = j3;
        this.f18036b = j4;
        this.f18037c = j5;
        this.f18038d = j6;
        this.f18039e = j7;
        this.f18040f = j8;
        this.f18041g = j9;
        this.f18042h = j10;
        this.f18043i = j11;
    }
}
