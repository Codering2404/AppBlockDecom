package androidx.navigation;

import android.net.Uri;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public class NavDeepLinkRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f48857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f48858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f48859c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Companion f48860d = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Uri f48861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f48862b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f48863c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Builder a(Uri uri) {
                Intrinsics.checkNotNullParameter(uri, "uri");
                Builder builder = new Builder(null);
                builder.b(uri);
                return builder;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Builder(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavDeepLinkRequest a() {
            return new NavDeepLinkRequest(this.f48861a, this.f48862b, this.f48863c);
        }

        public final Builder b(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.f48861a = uri;
            return this;
        }

        private Builder() {
        }
    }

    public NavDeepLinkRequest(Uri uri, String str, String str2) {
        this.f48857a = uri;
        this.f48858b = str;
        this.f48859c = str2;
    }

    public String a() {
        return this.f48858b;
    }

    public String b() {
        return this.f48859c;
    }

    public Uri c() {
        return this.f48857a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NavDeepLinkRequest");
        sb.append("{");
        if (c() != null) {
            sb.append(" uri=");
            sb.append(String.valueOf(c()));
        }
        if (a() != null) {
            sb.append(" action=");
            sb.append(a());
        }
        if (b() != null) {
            sb.append(" mimetype=");
            sb.append(b());
        }
        sb.append(" }");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
