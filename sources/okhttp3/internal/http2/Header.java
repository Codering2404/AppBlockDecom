package okhttp3.internal.http2;

import com.revenuecat.purchases.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

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
public final class Header {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f144585d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteString f144586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ByteString f144587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ByteString f144588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ByteString f144589h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ByteString f144590i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ByteString f144591j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteString f144592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteString f144593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f144594c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        ByteString.Companion companion = ByteString.f144997d;
        f144586e = companion.d(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        f144587f = companion.d(":status");
        f144588g = companion.d(":method");
        f144589h = companion.d(":path");
        f144590i = companion.d(":scheme");
        f144591j = companion.d(":authority");
    }

    public Header(ByteString name, ByteString value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f144592a = name;
        this.f144593b = value;
        this.f144594c = name.C() + 32 + value.C();
    }

    public final ByteString a() {
        return this.f144592a;
    }

    public final ByteString b() {
        return this.f144593b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return Intrinsics.areEqual(this.f144592a, header.f144592a) && Intrinsics.areEqual(this.f144593b, header.f144593b);
    }

    public int hashCode() {
        return (this.f144592a.hashCode() * 31) + this.f144593b.hashCode();
    }

    public String toString() {
        return this.f144592a.I() + ": " + this.f144593b.I();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Header(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        ByteString.Companion companion = ByteString.f144997d;
        this(companion.d(name), companion.d(value));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(ByteString name, String value) {
        this(name, ByteString.f144997d.d(value));
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
    }
}
