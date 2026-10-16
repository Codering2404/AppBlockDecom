package okhttp3.internal.http;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class RealResponseBody extends ResponseBody {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f144530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f144531d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BufferedSource f144532f;

    public RealResponseBody(String str, long j3, BufferedSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f144530c = str;
        this.f144531d = j3;
        this.f144532f = source;
    }

    @Override // okhttp3.ResponseBody
    public long f() {
        return this.f144531d;
    }

    @Override // okhttp3.ResponseBody
    public MediaType i() {
        String str = this.f144530c;
        if (str == null) {
            return null;
        }
        return MediaType.f144108e.b(str);
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource k() {
        return this.f144532f;
    }
}
