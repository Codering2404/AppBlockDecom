package okhttp3;

import java.io.IOException;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f144198b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f144206a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Protocol a(String protocol) throws IOException {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            Protocol protocol2 = Protocol.HTTP_1_0;
            if (Intrinsics.areEqual(protocol, protocol2.f144206a)) {
                return protocol2;
            }
            Protocol protocol3 = Protocol.HTTP_1_1;
            if (Intrinsics.areEqual(protocol, protocol3.f144206a)) {
                return protocol3;
            }
            Protocol protocol4 = Protocol.H2_PRIOR_KNOWLEDGE;
            if (Intrinsics.areEqual(protocol, protocol4.f144206a)) {
                return protocol4;
            }
            Protocol protocol5 = Protocol.HTTP_2;
            if (Intrinsics.areEqual(protocol, protocol5.f144206a)) {
                return protocol5;
            }
            Protocol protocol6 = Protocol.SPDY_3;
            if (Intrinsics.areEqual(protocol, protocol6.f144206a)) {
                return protocol6;
            }
            Protocol protocol7 = Protocol.QUIC;
            if (Intrinsics.areEqual(protocol, protocol7.f144206a)) {
                return protocol7;
            }
            throw new IOException(Intrinsics.stringPlus("Unexpected protocol: ", protocol));
        }

        private Companion() {
        }
    }

    Protocol(String str) {
        this.f144206a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f144206a;
    }
}
