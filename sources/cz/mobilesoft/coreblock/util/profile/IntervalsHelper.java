package cz.mobilesoft.coreblock.util.profile;

import android.content.Context;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class IntervalsHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IntervalsHelper f129240a = new IntervalsHelper();

    private IntervalsHelper() {
    }

    public static final String a(Context context, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(context);
        timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(timeFormat.getTimeZone());
        long j4 = 60;
        int i3 = (int) (j3 / j4);
        int i4 = (int) (j3 % j4);
        calendar.set(0, 0, 0, i3, i4);
        String str = timeFormat.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        calendar.set(0, 0, 0, i3, i4);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str2 = String.format("%s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public final Pair c(Context context, long j3, long j4) {
        Intrinsics.checkNotNullParameter(context, "context");
        DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(context);
        timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(timeFormat.getTimeZone());
        long j5 = 60;
        calendar.set(0, 0, 0, (int) (j3 / j5), (int) (j3 % j5));
        String str = timeFormat.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        calendar.set(0, 0, 0, (int) (j4 / j5), (int) (j4 % j5));
        String str2 = timeFormat.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return TuplesKt.a(str, str2);
    }

    public final String b(Context context, long j3, long j4) {
        Intrinsics.checkNotNullParameter(context, qRMDmh.tTjFTJTASImphz);
        Pair pairC = c(context, j3, j4);
        return pairC.e() + " – " + pairC.f();
    }
}
