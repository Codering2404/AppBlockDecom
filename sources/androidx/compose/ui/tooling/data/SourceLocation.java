package androidx.compose.ui.tooling.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SourceLocation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f29949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f29950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f29951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f29952e;

    public SourceLocation(int i3, int i4, int i5, String str, int i6) {
        this.f29948a = i3;
        this.f29949b = i4;
        this.f29950c = i5;
        this.f29951d = str;
        this.f29952e = i6;
    }

    public final int a() {
        return this.f29950c;
    }

    public final int b() {
        return this.f29948a;
    }

    public final int c() {
        return this.f29949b;
    }

    public final String d() {
        return this.f29951d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceLocation)) {
            return false;
        }
        SourceLocation sourceLocation = (SourceLocation) obj;
        return this.f29948a == sourceLocation.f29948a && this.f29949b == sourceLocation.f29949b && this.f29950c == sourceLocation.f29950c && Intrinsics.areEqual(this.f29951d, sourceLocation.f29951d) && this.f29952e == sourceLocation.f29952e;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.f29948a) * 31) + Integer.hashCode(this.f29949b)) * 31) + Integer.hashCode(this.f29950c)) * 31;
        String str = this.f29951d;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.f29952e);
    }

    public String toString() {
        return "SourceLocation(lineNumber=" + this.f29948a + ", offset=" + this.f29949b + ", length=" + this.f29950c + ", sourceFile=" + this.f29951d + ", packageHash=" + this.f29952e + ')';
    }
}
