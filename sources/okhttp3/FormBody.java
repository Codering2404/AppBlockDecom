package okhttp3;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

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
public final class FormBody extends RequestBody {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f144067d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final MediaType f144068e = MediaType.f144108e.a("application/x-www-form-urlencoded");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f144069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f144070c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Charset f144071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f144072b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f144073c;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final Builder a(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            List list = this.f144072b;
            HttpUrl.Companion companion = HttpUrl.f144085k;
            list.add(HttpUrl.Companion.b(companion, name, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.f144071a, 91, null));
            this.f144073c.add(HttpUrl.Companion.b(companion, value, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.f144071a, 91, null));
            return this;
        }

        public final Builder b(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            List list = this.f144072b;
            HttpUrl.Companion companion = HttpUrl.f144085k;
            list.add(HttpUrl.Companion.b(companion, name, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.f144071a, 83, null));
            this.f144073c.add(HttpUrl.Companion.b(companion, value, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.f144071a, 83, null));
            return this;
        }

        public final FormBody c() {
            return new FormBody(this.f144072b, this.f144073c);
        }

        public Builder(Charset charset) {
            this.f144071a = charset;
            this.f144072b = new ArrayList();
            this.f144073c = new ArrayList();
        }

        public /* synthetic */ Builder(Charset charset, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : charset);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FormBody(List encodedNames, List encodedValues) {
        Intrinsics.checkNotNullParameter(encodedNames, "encodedNames");
        Intrinsics.checkNotNullParameter(encodedValues, "encodedValues");
        this.f144069b = Util.V(encodedNames);
        this.f144070c = Util.V(encodedValues);
    }

    private final long h(BufferedSink bufferedSink, boolean z2) throws EOFException {
        Buffer bufferU;
        if (z2) {
            bufferU = new Buffer();
        } else {
            Intrinsics.checkNotNull(bufferedSink);
            bufferU = bufferedSink.u();
        }
        int size = this.f144069b.size();
        int i3 = 0;
        while (i3 < size) {
            int i4 = i3 + 1;
            if (i3 > 0) {
                bufferU.writeByte(38);
            }
            bufferU.C0((String) this.f144069b.get(i3));
            bufferU.writeByte(61);
            bufferU.C0((String) this.f144070c.get(i3));
            i3 = i4;
        }
        if (!z2) {
            return 0L;
        }
        long size2 = bufferU.size();
        bufferU.a();
        return size2;
    }

    @Override // okhttp3.RequestBody
    public long a() {
        return h(null, true);
    }

    @Override // okhttp3.RequestBody
    public MediaType b() {
        return f144068e;
    }

    @Override // okhttp3.RequestBody
    public void g(BufferedSink sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        h(sink, false);
    }
}
