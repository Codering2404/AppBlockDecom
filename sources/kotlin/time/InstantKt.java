package kotlin.time;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.experimental.kJ.HcgZcEUYo;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class InstantKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f140656a = {1, 10, 100, 1000, ColorExtractionConstants.MAX_PIXEL_SAMPLES, 100000, 1000000, 10000000, 100000000, 1000000000};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f140657b = {1, 2, 4, 5, 7, 8, 10, 11, 13, 14};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f140658c = {3, 6};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f140659d = {1, 2, 4, 5, 7, 8};

    private static final void c(Appendable appendable, StringBuilder sb, int i3) throws IOException {
        if (i3 < 10) {
            appendable.append('0');
        }
        sb.append(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(Instant instant) throws IOException {
        int[] iArr;
        StringBuilder sb = new StringBuilder();
        UnboundLocalDateTime unboundLocalDateTimeA = UnboundLocalDateTime.f140671h.a(instant);
        int iG = unboundLocalDateTimeA.g();
        int i3 = 0;
        if (Math.abs(iG) < 1000) {
            StringBuilder sb2 = new StringBuilder();
            String str = HcgZcEUYo.awUeJcXg;
            if (iG >= 0) {
                sb2.append(iG + ColorExtractionConstants.MAX_PIXEL_SAMPLES);
                Intrinsics.checkNotNullExpressionValue(sb2.deleteCharAt(0), str);
            } else {
                sb2.append(iG - ColorExtractionConstants.MAX_PIXEL_SAMPLES);
                Intrinsics.checkNotNullExpressionValue(sb2.deleteCharAt(1), str);
            }
            sb.append((CharSequence) sb2);
        } else {
            if (iG >= 10000) {
                sb.append('+');
            }
            sb.append(iG);
        }
        sb.append('-');
        c(sb, sb, unboundLocalDateTimeA.d());
        sb.append('-');
        c(sb, sb, unboundLocalDateTimeA.a());
        sb.append('T');
        c(sb, sb, unboundLocalDateTimeA.b());
        sb.append(':');
        c(sb, sb, unboundLocalDateTimeA.c());
        sb.append(':');
        c(sb, sb, unboundLocalDateTimeA.f());
        if (unboundLocalDateTimeA.e() != 0) {
            sb.append('.');
            while (true) {
                int iE = unboundLocalDateTimeA.e();
                iArr = f140656a;
                int i4 = i3 + 1;
                if (iE % iArr[i4] != 0) {
                    break;
                }
                i3 = i4;
            }
            int i5 = i3 - (i3 % 3);
            String strValueOf = String.valueOf((unboundLocalDateTimeA.e() / iArr[i5]) + iArr[9 - i5]);
            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = strValueOf.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            sb.append(strSubstring);
        }
        sb.append('Z');
        return sb.toString();
    }
}
