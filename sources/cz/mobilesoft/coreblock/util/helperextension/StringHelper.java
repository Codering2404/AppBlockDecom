package cz.mobilesoft.coreblock.util.helperextension;

import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.text.Spanned;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.common.Constants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.profile.IntervalsHelper;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class StringHelper implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StringHelper f128649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f128650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f128651c;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final StringHelper stringHelper = new StringHelper();
        f128649a = stringHelper;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f128650b = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.util.helperextension.StringHelper$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = stringHelper;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), qualifier, objArr);
            }
        });
        f128651c = 8;
    }

    private StringHelper() {
    }

    public static final String a(String str, double d3) {
        try {
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.getDefault());
            currencyInstance.setCurrency(Currency.getInstance(str));
            String str2 = currencyInstance.format(d3);
            Intrinsics.checkNotNull(str2);
            return str2;
        } catch (Exception e3) {
            CrashHelper.j(e3);
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            String str3 = String.format(Locale.getDefault(), "%s %.2f", Arrays.copyOf(new Object[]{str, Double.valueOf(d3)}, 2));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            return str3;
        }
    }

    public static final String b(String str, int i3) {
        try {
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.getDefault());
            currencyInstance.setMaximumFractionDigits(0);
            currencyInstance.setCurrency(Currency.getInstance(str));
            String str2 = currencyInstance.format(Integer.valueOf(i3));
            Intrinsics.checkNotNull(str2);
            return str2;
        } catch (Exception e3) {
            CrashHelper.j(e3);
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            String str3 = String.format(Locale.getDefault(), "%s %d", Arrays.copyOf(new Object[]{str, Integer.valueOf(i3)}, 2));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            return str3;
        }
    }

    public static final String c(PackageManager packageManager, String packageName) {
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        try {
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, Utility.DEFAULT_STREAM_BUFFER_SIZE)).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return packageName;
        }
    }

    public static final String f(Context context, long j3) {
        long j4;
        long j5;
        Intrinsics.checkNotNullParameter(context, "context");
        if (j3 > 0) {
            long j6 = j3 / 3600000;
            j5 = j6 % 24;
            j4 = (j3 - (j6 * 3600000)) / 60000;
        } else {
            j4 = 0;
            j5 = 0;
        }
        if (j5 == 0) {
            String string = context.getString(R.string.yk, Long.valueOf(j4));
            Intrinsics.checkNotNull(string);
            return string;
        }
        String string2 = context.getString(R.string.xk, Long.valueOf(j5), Long.valueOf(j4));
        Intrinsics.checkNotNull(string2);
        return string2;
    }

    public static final Spanned g(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        return h(context.getString(i3));
    }

    public static final Spanned h(String str) {
        return i(str, 0);
    }

    public static final Spanned i(String str, int i3) {
        Spanned spannedFromHtml = Html.fromHtml(str, i3);
        Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(...)");
        return spannedFromHtml;
    }

    public static final String l(Context context, int i3, UsageLimit.PeriodType periodType) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z2 = periodType == UsageLimit.PeriodType.HOURLY;
        if (i3 <= 0) {
            if (z2) {
                String string = context.getString(R.string.Rk);
                Intrinsics.checkNotNull(string);
                return string;
            }
            String string2 = context.getString(R.string.Xk);
            Intrinsics.checkNotNull(string2);
            return string2;
        }
        if (z2) {
            String quantityString = context.getResources().getQuantityString(R.plurals.f95751l, i3, Integer.valueOf(i3));
            Intrinsics.checkNotNull(quantityString);
            return quantityString;
        }
        String quantityString2 = context.getResources().getQuantityString(R.plurals.f95753n, i3, Integer.valueOf(i3));
        Intrinsics.checkNotNull(quantityString2);
        return quantityString2;
    }

    public static final String m(long j3, boolean z2) {
        long j4;
        long j5;
        long j6;
        if (j3 > 0) {
            long j7 = j3 / 3600000;
            j6 = z2 ? j7 % 24 : j7;
            long j8 = j3 - (j7 * 3600000);
            j5 = j8 / 60000;
            j4 = (j8 - (60000 * j5)) / 1000;
        } else {
            j4 = 0;
            j5 = 0;
            j6 = 0;
        }
        List listListOf = CollectionsKt.listOf((Object[]) new Long[]{Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4)});
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        for (Object obj : listListOf) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            long jLongValue = ((Number) obj).longValue();
            if (i4 > 0 || jLongValue > 0) {
                arrayList.add(obj);
            }
            i4 = i5;
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj2 = arrayList.get(i6);
            i6++;
            int i7 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            long jLongValue2 = ((Number) obj2).longValue();
            arrayList2.add(i3 > 0 ? StringsKt.C0(String.valueOf(jLongValue2), 2, '0') : String.valueOf(jLongValue2));
            i3 = i7;
        }
        String strS = StringHelperExtKt.s(arrayList2, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, null, 2, null);
        return strS.length() == 0 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : strS;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object n(android.content.Context r12, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            boolean r0 = r14 instanceof cz.mobilesoft.coreblock.util.helperextension.StringHelper$getRemainingUsageLimitString$1
            if (r0 == 0) goto L13
            r0 = r14
            cz.mobilesoft.coreblock.util.helperextension.StringHelper$getRemainingUsageLimitString$1 r0 = (cz.mobilesoft.coreblock.util.helperextension.StringHelper$getRemainingUsageLimitString$1) r0
            int r1 = r0.f128656f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f128656f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.helperextension.StringHelper$getRemainingUsageLimitString$1 r0 = new cz.mobilesoft.coreblock.util.helperextension.StringHelper$getRemainingUsageLimitString$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.f128655d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f128656f
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r12 = r0.f128654c
            cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit$PeriodType r12 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit.PeriodType) r12
            java.lang.Object r13 = r0.f128653b
            cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit r13 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit) r13
            java.lang.Object r0 = r0.f128652a
            android.content.Context r0 = (android.content.Context) r0
            kotlin.ResultKt.b(r14)
            r11 = r12
            r2 = r0
            goto L64
        L37:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3f:
            kotlin.ResultKt.b(r14)
            if (r13 == 0) goto L4a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit$PeriodType r14 = r13.k()
            if (r14 != 0) goto L4c
        L4a:
            cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit$PeriodType r14 = cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit.PeriodType.DAILY
        L4c:
            cz.mobilesoft.coreblock.util.helperextension.StringHelper r2 = cz.mobilesoft.coreblock.util.helperextension.StringHelper.f128649a
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r2 = r2.d()
            r0.f128652a = r12
            r0.f128653b = r13
            r0.f128654c = r14
            r0.f128656f = r3
            java.lang.Object r0 = r2.h0(r14, r0)
            if (r0 != r1) goto L61
            return r1
        L61:
            r2 = r12
            r11 = r14
            r14 = r0
        L64:
            java.lang.Number r14 = (java.lang.Number) r14
            long r3 = r14.longValue()
            if (r13 != 0) goto L77
            r7 = 0
            r9 = 0
            r5 = 0
            java.lang.String r12 = o(r2, r3, r5, r7, r9, r11)
            return r12
        L77:
            long r5 = r13.h()
            long r7 = r13.f()
            long r0 = r13.f()
            long r12 = r13.m()
            long r9 = r0 - r12
            java.lang.String r12 = o(r2, r3, r5, r7, r9, r11)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.helperextension.StringHelper.n(android.content.Context, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final String o(Context context, long j3, long j4, long j5, long j6, UsageLimit.PeriodType periodType) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (periodType == null) {
            periodType = UsageLimit.PeriodType.DAILY;
        }
        if (j4 >= j3) {
            j5 = j6;
        }
        return p(context, j5, periodType);
    }

    public static final String p(Context context, long j3, UsageLimit.PeriodType periodType) {
        long j4;
        long j5;
        long j6;
        Intrinsics.checkNotNullParameter(context, "context");
        if (j3 > 0) {
            long j7 = j3 / 3600000;
            j6 = j7 % 24;
            long j8 = j3 - (j7 * 3600000);
            j5 = j8 / 60000;
            j4 = (j8 - (60000 * j5)) / 1000;
        } else {
            j4 = 0;
            j5 = 0;
            j6 = 0;
        }
        if (j3 <= 0) {
            if (periodType == UsageLimit.PeriodType.HOURLY) {
                String string = context.getString(R.string.L0);
                Intrinsics.checkNotNull(string);
                return string;
            }
            String string2 = context.getString(R.string.M0);
            Intrinsics.checkNotNull(string2);
            return string2;
        }
        if (j6 == 0 && j5 == 0) {
            String string3 = context.getString(R.string.N0, Long.valueOf(j4));
            Intrinsics.checkNotNull(string3);
            return string3;
        }
        if (j6 == 0) {
            String string4 = context.getString(R.string.K0, Long.valueOf(j5), Long.valueOf(j4));
            Intrinsics.checkNotNull(string4);
            return string4;
        }
        String string5 = context.getString(R.string.J0, Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4));
        Intrinsics.checkNotNull(string5);
        return string5;
    }

    public static final String r(Context context, Interval nextActiveInterval, Interval interval) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nextActiveInterval, "nextActiveInterval");
        String strA = IntervalsHelper.a(context, nextActiveInterval.b());
        if (interval != null) {
            String string = context.getString(R.string.Du, strA);
            Intrinsics.checkNotNull(string);
            return string;
        }
        String string2 = context.getString(R.string.Eu, strA);
        Intrinsics.checkNotNull(string2);
        return string2;
    }

    public static final String s(Context context, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        long jC = j3 - ((TimeHelperExt.c() / 60000) * 60000);
        long j4 = jC / 3600000;
        long j5 = j4 % 24;
        long j6 = j4 / 24;
        long j7 = (jC - (j4 * 3600000)) / 60000;
        if (j6 != 0) {
            String string = context.getString(R.string.D, Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j7));
            Intrinsics.checkNotNull(string);
            return string;
        }
        if (j5 != 0) {
            String string2 = context.getString(R.string.E, Long.valueOf(j5), Long.valueOf(j7));
            Intrinsics.checkNotNull(string2);
            return string2;
        }
        String string3 = context.getString(R.string.F, Long.valueOf(j7));
        Intrinsics.checkNotNull(string3);
        return string3;
    }

    public static final Spanned t(Context context, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        String quantityString = context.getResources().getQuantityString(R.plurals.f95761v, DateHelper.n(Long.valueOf(j3))[2], "#" + Integer.toHexString(ContextCompat.getColor(context, R.color.f95455j) & 16777215), DateHelper.d(Long.valueOf(j3 / ((long) 1000)), -1));
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        Spanned spannedFromHtml = Html.fromHtml(quantityString, 63);
        Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(...)");
        return spannedFromHtml;
    }

    public static final String u(String str) {
        String strNormalize = Normalizer.normalize(str, Normalizer.Form.NFD);
        Intrinsics.checkNotNullExpressionValue(strNormalize, "normalize(...)");
        String strReplace = new Regex("\\p{InCombiningDiacriticalMarks}+").replace(strNormalize, "");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = strReplace.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private static final String v(String str) {
        String strGroup = null;
        if (str == null) {
            return null;
        }
        Pattern patternCompile = Pattern.compile("((.*:)//)?(www\\.)?([A-Za-z0-9\\-]+(\\.[A-Za-z0-9\\-]+)+)(:[0-9]+)?(.*)");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Matcher matcher = patternCompile.matcher(lowerCase);
        return (matcher.find() && (strGroup = matcher.group(4)) == null) ? str : strGroup;
    }

    public static final String w(String ssid) {
        Intrinsics.checkNotNullParameter(ssid, "ssid");
        if (StringsKt.U(ssid, "\"", false, 2, null)) {
            ssid = ssid.substring(1);
            Intrinsics.checkNotNullExpressionValue(ssid, "substring(...)");
        }
        if (StringsKt.E(ssid, "\"", false, 2, null)) {
            ssid = ssid.substring(0, ssid.length() - 1);
            Intrinsics.checkNotNullExpressionValue(ssid, "substring(...)");
        }
        return StringsKt.t1(ssid).toString();
    }

    public static final String x(String str) {
        String strV = v(str);
        if (strV == null) {
            return null;
        }
        String[] strArr = (String[]) StringsKt.V0(strV, new String[]{"\\."}, false, 0, 6, null).toArray(new String[0]);
        if (strArr.length <= 2 || strArr[strArr.length - 3].length() >= 3) {
            return strV;
        }
        return strArr[strArr.length - 2] + "." + strArr[strArr.length - 1];
    }

    public final CoreMultiProcessDataStore d() {
        return (CoreMultiProcessDataStore) f128650b.getValue();
    }

    public final String e(Context context) {
        String currencyCode;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("phone");
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        String simCountryIso = telephonyManager != null ? telephonyManager.getSimCountryIso() : null;
        String networkCountryIso = telephonyManager != null ? telephonyManager.getNetworkCountryIso() : null;
        if (simCountryIso == null) {
            simCountryIso = networkCountryIso == null ? Locale.getDefault().getCountry() : networkCountryIso;
        }
        try {
            Currency currency = Currency.getInstance(new Locale("", simCountryIso));
            if (currency == null || (currencyCode = currency.getCurrencyCode()) == null) {
                currencyCode = Currency.getInstance(Locale.getDefault()).getCurrencyCode();
            }
            Intrinsics.checkNotNull(currencyCode);
            return currencyCode;
        } catch (IllegalArgumentException unused) {
            String currencyCode2 = Currency.getInstance(Locale.getDefault()).getCurrencyCode();
            Intrinsics.checkNotNull(currencyCode2);
            return currencyCode2;
        }
    }

    public final String j(Context context, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        DateFormat dateFormatI = j3 - TimeHelperExt.c() > 86400000 ? DateHelperExtKt.i(context, true, true) : DateHelperExtKt.i(context, false, true);
        String string = context.getString(R.string.Bn);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(R.string.vF, dateFormatI.format(new Date(j3)));
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        if (string2.length() > 0) {
            char upperCase = Character.toUpperCase(string2.charAt(0));
            String strSubstring = string2.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            string2 = upperCase + strSubstring;
        }
        return StringHelperExtKt.p(string, string2, " • ");
    }

    public final String k(String processName) {
        int i3;
        Intrinsics.checkNotNullParameter(processName, "processName");
        int iN0 = StringsKt.n0(processName, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, 0, false, 6, null);
        if (iN0 == -1 || (i3 = iN0 + 1) > processName.length()) {
            return "";
        }
        String strSubstring = processName.substring(i3);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String q(Context context, ConditionDTO.UsageLimitDTO usageLimitDTO) {
        Intrinsics.checkNotNullParameter(context, "context");
        return usageLimitDTO != null ? p(context, usageLimitDTO.e(), usageLimitDTO.g()) : "";
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public final String y(String url, String pattern) {
        String strGroup;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Matcher matcher = Pattern.compile(pattern).matcher(url);
        return (!matcher.find() || (strGroup = matcher.group(4)) == null) ? url : strGroup;
    }
}
