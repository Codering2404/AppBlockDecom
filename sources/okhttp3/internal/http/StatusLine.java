package okhttp3.internal.http;

import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Protocol;

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
public final class StatusLine {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f144536d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Protocol f144537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f144538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f144539c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StatusLine a(String statusLine) throws ProtocolException {
            Protocol protocol;
            int i3;
            String strSubstring;
            Intrinsics.checkNotNullParameter(statusLine, "statusLine");
            if (StringsKt.U(statusLine, "HTTP/1.", false, 2, null)) {
                i3 = 9;
                if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                    throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", statusLine));
                }
                int iCharAt = statusLine.charAt(7) - '0';
                if (iCharAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else {
                    if (iCharAt != 1) {
                        throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", statusLine));
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else {
                if (!StringsKt.U(statusLine, "ICY ", false, 2, null)) {
                    throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", statusLine));
                }
                protocol = Protocol.HTTP_1_0;
                i3 = 4;
            }
            int i4 = i3 + 3;
            if (statusLine.length() < i4) {
                throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", statusLine));
            }
            try {
                String strSubstring2 = statusLine.substring(i3, i4);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                int i5 = Integer.parseInt(strSubstring2);
                if (statusLine.length() <= i4) {
                    strSubstring = "";
                } else {
                    if (statusLine.charAt(i4) != ' ') {
                        throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", statusLine));
                    }
                    strSubstring = statusLine.substring(i3 + 4);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                }
                return new StatusLine(protocol, i5, strSubstring);
            } catch (NumberFormatException unused) {
                throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", statusLine));
            }
        }

        private Companion() {
        }
    }

    public StatusLine(Protocol protocol, int i3, String message) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        this.f144537a = protocol;
        this.f144538b = i3;
        this.f144539c = message;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f144537a == Protocol.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.f144538b);
        sb.append(' ');
        sb.append(this.f144539c);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
