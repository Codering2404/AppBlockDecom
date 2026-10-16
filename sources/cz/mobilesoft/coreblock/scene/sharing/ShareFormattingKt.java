package cz.mobilesoft.coreblock.scene.sharing;

import android.content.Context;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ShareFormattingKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f119324a;

        static {
            int[] iArr = new int[SocialsSharePayload.PeriodType.values().length];
            try {
                iArr[SocialsSharePayload.PeriodType.Day.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SocialsSharePayload.PeriodType.Week.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SocialsSharePayload.PeriodType.WeeklyReport.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SocialsSharePayload.PeriodType.Trend.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f119324a = iArr;
        }
    }

    public static final String a(SocialsSharePayload socialsSharePayload) {
        Intrinsics.checkNotNullParameter(socialsSharePayload, "<this>");
        Long lG = socialsSharePayload.g();
        if (lG == null) {
            return "";
        }
        long jLongValue = lG.longValue();
        return jLongValue == 0 ? "" : DateHelperExtKt.f(jLongValue, false, false, false, 12, null);
    }

    public static final String b(SocialsSharePayload socialsSharePayload, Context context) {
        Intrinsics.checkNotNullParameter(socialsSharePayload, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        long jM = socialsSharePayload.m();
        long jL = socialsSharePayload.l();
        if (jM <= 0) {
            return "";
        }
        int i3 = WhenMappings.f119324a[socialsSharePayload.n().ordinal()];
        if (i3 == 1) {
            return DateHelperExtKt.l(context, jM, true);
        }
        if (i3 != 2 && i3 != 3) {
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            String strP = socialsSharePayload.p();
            return strP == null ? "" : strP;
        }
        if (jL <= 0) {
            return DateHelperExtKt.l(context, jM, true);
        }
        return DateHelperExtKt.l(context, jM, true) + " - " + DateHelperExtKt.l(context, jL, true);
    }
}
