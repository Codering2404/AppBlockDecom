package coil.request;

import android.graphics.drawable.Drawable;
import coil.decode.DataSource;
import coil.memory.MemoryCache;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class SuccessResult extends ImageResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Drawable f56139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImageRequest f56140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DataSource f56141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MemoryCache.Key f56142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f56143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f56144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f56145g;

    public /* synthetic */ SuccessResult(Drawable drawable, ImageRequest imageRequest, DataSource dataSource, MemoryCache.Key key, String str, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, imageRequest, dataSource, (i3 & 8) != 0 ? null : key, (i3 & 16) != 0 ? null : str, (i3 & 32) != 0 ? false : z2, (i3 & 64) != 0 ? false : z3);
    }

    @Override // coil.request.ImageResult
    public Drawable a() {
        return this.f56139a;
    }

    @Override // coil.request.ImageResult
    public ImageRequest b() {
        return this.f56140b;
    }

    public final DataSource c() {
        return this.f56141c;
    }

    public final boolean d() {
        return this.f56145g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuccessResult)) {
            return false;
        }
        SuccessResult successResult = (SuccessResult) obj;
        return Intrinsics.areEqual(a(), successResult.a()) && Intrinsics.areEqual(b(), successResult.b()) && this.f56141c == successResult.f56141c && Intrinsics.areEqual(this.f56142d, successResult.f56142d) && Intrinsics.areEqual(this.f56143e, successResult.f56143e) && this.f56144f == successResult.f56144f && this.f56145g == successResult.f56145g;
    }

    public int hashCode() {
        int iHashCode = ((((a().hashCode() * 31) + b().hashCode()) * 31) + this.f56141c.hashCode()) * 31;
        MemoryCache.Key key = this.f56142d;
        int iHashCode2 = (iHashCode + (key != null ? key.hashCode() : 0)) * 31;
        String str = this.f56143e;
        return ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.f56144f)) * 31) + Boolean.hashCode(this.f56145g);
    }

    public SuccessResult(Drawable drawable, ImageRequest imageRequest, DataSource dataSource, MemoryCache.Key key, String str, boolean z2, boolean z3) {
        super(null);
        this.f56139a = drawable;
        this.f56140b = imageRequest;
        this.f56141c = dataSource;
        this.f56142d = key;
        this.f56143e = str;
        this.f56144f = z2;
        this.f56145g = z3;
    }
}
