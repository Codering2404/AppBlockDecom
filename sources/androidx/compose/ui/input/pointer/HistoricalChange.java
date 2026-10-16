package androidx.compose.ui.input.pointer;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class HistoricalChange {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f26783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f26784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f26785c;

    public /* synthetic */ HistoricalChange(long j3, long j4, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5);
    }

    public final long a() {
        return this.f26785c;
    }

    public final long b() {
        return this.f26784b;
    }

    public final long c() {
        return this.f26783a;
    }

    public String toString() {
        return "HistoricalChange(uptimeMillis=" + this.f26783a + ", position=" + ((Object) Offset.s(this.f26784b)) + ')';
    }

    public /* synthetic */ HistoricalChange(long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4);
    }

    private HistoricalChange(long j3, long j4) {
        this.f26783a = j3;
        this.f26784b = j4;
        this.f26785c = Offset.f25596b.c();
    }

    private HistoricalChange(long j3, long j4, long j5) {
        this(j3, j4, (DefaultConstructorMarker) null);
        this.f26785c = j5;
    }
}
