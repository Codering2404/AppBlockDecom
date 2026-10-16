package okhttp3.internal.ws;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.internal.Util;

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
public final class WebSocketExtensions {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f144916g = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f144917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f144918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f144919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f144920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f144921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f144922f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WebSocketExtensions a(Headers responseHeaders) {
            Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
            int size = responseHeaders.size();
            int i3 = 0;
            boolean z2 = false;
            Integer numU = null;
            boolean z3 = false;
            Integer numU2 = null;
            boolean z4 = false;
            boolean z5 = false;
            while (i3 < size) {
                int i4 = i3 + 1;
                if (StringsKt.F(responseHeaders.d(i3), "Sec-WebSocket-Extensions", true)) {
                    String strH = responseHeaders.h(i3);
                    int i5 = 0;
                    while (i5 < strH.length()) {
                        int i6 = i5;
                        int iR = Util.r(strH, ',', i6, 0, 4, null);
                        int iP = Util.p(strH, ';', i6, iR);
                        String strZ = Util.Z(strH, i6, iP);
                        int i7 = iP + 1;
                        if (StringsKt.F(strZ, "permessage-deflate", true)) {
                            if (!z2) {
                                z5 = true;
                                while (i7 < iR) {
                                    int iP2 = Util.p(strH, ';', i7, iR);
                                    int iP3 = Util.p(strH, '=', i7, iP2);
                                    String strZ2 = Util.Z(strH, i7, iP3);
                                    String strM0 = iP3 < iP2 ? StringsKt.M0(Util.Z(strH, iP3 + 1, iP2), "\"") : null;
                                    int i8 = iP2 + 1;
                                    if (StringsKt.F(strZ2, "client_max_window_bits", true)) {
                                        if (numU != null) {
                                            z5 = true;
                                        }
                                        numU = strM0 == null ? null : StringsKt.u(strM0);
                                        i7 = numU == null ? i8 : i8;
                                    } else if (StringsKt.F(strZ2, "client_no_context_takeover", true)) {
                                        if (z3) {
                                            z5 = true;
                                        }
                                        if (strM0 != null) {
                                            z5 = true;
                                        }
                                        i7 = i8;
                                        z3 = true;
                                    } else {
                                        if (StringsKt.F(strZ2, "server_max_window_bits", true)) {
                                            if (numU2 != null) {
                                                z5 = true;
                                            }
                                            numU2 = strM0 == null ? null : StringsKt.u(strM0);
                                            if (numU2 == null) {
                                            }
                                        } else if (StringsKt.F(strZ2, "server_no_context_takeover", true)) {
                                            if (z4) {
                                                z5 = true;
                                            }
                                            if (strM0 != null) {
                                                z5 = true;
                                            }
                                            i7 = i8;
                                            z4 = true;
                                        }
                                    }
                                }
                                i5 = i7;
                                z2 = true;
                            }
                            z5 = true;
                        } else {
                            i5 = i7;
                            z5 = true;
                        }
                    }
                }
                i3 = i4;
            }
            return new WebSocketExtensions(z2, numU, z3, numU2, z4, z5);
        }

        private Companion() {
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public final boolean a(boolean z2) {
        return z2 ? this.f144919c : this.f144921e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.f144917a == webSocketExtensions.f144917a && Intrinsics.areEqual(this.f144918b, webSocketExtensions.f144918b) && this.f144919c == webSocketExtensions.f144919c && Intrinsics.areEqual(this.f144920d, webSocketExtensions.f144920d) && this.f144921e == webSocketExtensions.f144921e && this.f144922f == webSocketExtensions.f144922f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z2 = this.f144917a;
        ?? r02 = z2;
        if (z2) {
            r02 = 1;
        }
        int i3 = r02 * 31;
        Integer num = this.f144918b;
        int iHashCode = (i3 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z3 = this.f144919c;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i4 = (iHashCode + r2) * 31;
        Integer num2 = this.f144920d;
        int iHashCode2 = (i4 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z4 = this.f144921e;
        ?? r22 = z4;
        if (z4) {
            r22 = 1;
        }
        int i5 = (iHashCode2 + r22) * 31;
        boolean z5 = this.f144922f;
        return i5 + (z5 ? 1 : z5);
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.f144917a + ", clientMaxWindowBits=" + this.f144918b + ", clientNoContextTakeover=" + this.f144919c + ", serverMaxWindowBits=" + this.f144920d + ", serverNoContextTakeover=" + this.f144921e + ", unknownValues=" + this.f144922f + ')';
    }

    public WebSocketExtensions(boolean z2, Integer num, boolean z3, Integer num2, boolean z4, boolean z5) {
        this.f144917a = z2;
        this.f144918b = num;
        this.f144919c = z3;
        this.f144920d = num2;
        this.f144921e = z4;
        this.f144922f = z5;
    }

    public /* synthetic */ WebSocketExtensions(boolean z2, Integer num, boolean z3, Integer num2, boolean z4, boolean z5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? false : z3, (i3 & 8) != 0 ? null : num2, (i3 & 16) != 0 ? false : z4, (i3 & 32) != 0 ? false : z5);
    }
}
