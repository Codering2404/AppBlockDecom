package com.appsflyer.internal;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AFa1zSDK {
    private static Object AppsFlyer2dXConversionCallback = null;
    public static byte[] afWarnLog = null;
    public static int init = 0;
    public static byte[] onAppOpenAttributionNative = null;
    public static final int onAttributionFailureNative = 0;
    private static int onDeepLinkingNative = 0;
    private static Object onInstallConversionDataLoadedNative = null;
    public static long onInstallConversionFailureNative = 0;
    public static final byte[] onResponseErrorNative = null;
    private static int onResponseNative = 1;

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0038  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003e -> B:11:0x004f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String $$c(short r7, byte r8, short r9) {
        /*
            int r0 = com.appsflyer.internal.AFa1zSDK.onResponseNative
            r1 = r0 & 105(0x69, float:1.47E-43)
            r0 = r0 | 105(0x69, float:1.47E-43)
            int r1 = r1 + r0
            int r1 = r1 % 128
            com.appsflyer.internal.AFa1zSDK.onDeepLinkingNative = r1
            byte[] r0 = com.appsflyer.internal.AFa1zSDK.onResponseErrorNative
            int r7 = -r7
            r2 = r7 ^ 1063(0x427, float:1.49E-42)
            r7 = r7 & 1063(0x427, float:1.49E-42)
            int r7 = r7 << 1
            int r2 = r2 + r7
            int r7 = 119 - r9
            int r8 = r8 + 1
            byte[] r9 = new byte[r8]
            int r3 = ~r8
            int r8 = r8 << 1
            int r3 = r3 + r8
            r8 = 0
            if (r0 != 0) goto L32
            int r1 = r1 + 19
            int r1 = r1 % 128
            com.appsflyer.internal.AFa1zSDK.onResponseNative = r1
            int r1 = r1 + 5
            int r1 = r1 % 128
            com.appsflyer.internal.AFa1zSDK.onDeepLinkingNative = r1
            r4 = r7
            r1 = r8
            r7 = r3
            goto L4f
        L32:
            r1 = r8
        L33:
            byte r4 = (byte) r7
            r9[r1] = r4
            if (r1 != r3) goto L3e
            java.lang.String r7 = new java.lang.String
            r7.<init>(r9, r8)
            return r7
        L3e:
            r4 = r0[r2]
            int r1 = r1 + 1
            int r5 = com.appsflyer.internal.AFa1zSDK.onDeepLinkingNative
            r6 = r5 | 111(0x6f, float:1.56E-43)
            int r6 = r6 << 1
            r5 = r5 ^ 111(0x6f, float:1.56E-43)
            int r6 = r6 - r5
            int r6 = r6 % 128
            com.appsflyer.internal.AFa1zSDK.onResponseNative = r6
        L4f:
            int r2 = r2 + 1
            r5 = r7 & r4
            r7 = r7 | r4
            int r5 = r5 + r7
            r7 = r5 & (-3)
            r4 = r5 | (-3)
            int r7 = r7 + r4
            int r4 = com.appsflyer.internal.AFa1zSDK.onResponseNative
            int r4 = r4 + 71
            int r4 = r4 % 128
            com.appsflyer.internal.AFa1zSDK.onDeepLinkingNative = r4
            goto L33
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1zSDK.$$c(short, byte, short):java.lang.String");
    }

    /*  JADX ERROR: Type inference failed with stack overflow
        jadx.core.utils.exceptions.JadxOverflowException
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    static {
        /*
            Method dump skipped, instruction units count: 6054
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1zSDK.<clinit>():void");
    }

    private AFa1zSDK() {
    }

    public static int AFInAppEventParameterName(Object obj) throws Throwable {
        int i3 = onDeepLinkingNative;
        Object obj2 = onInstallConversionDataLoadedNative;
        onResponseNative = (i3 + 21) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        try {
            byte[] bArr = onResponseErrorNative;
            int iIntValue = ((Integer) Class.forName($$c((short) 141, bArr[496], bArr[384]), true, (ClassLoader) AppsFlyer2dXConversionCallback).getMethod($$c((short) 274, bArr[69], bArr[26]), Object.class).invoke(obj2, obj)).intValue();
            int i4 = onResponseNative;
            onDeepLinkingNative = ((i4 ^ 119) + ((i4 & 119) << 1)) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            return iIntValue;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static int AFKeystoreWrapper(int i3) throws Throwable {
        int i4 = onDeepLinkingNative;
        int i5 = i4 + 15;
        onResponseNative = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i5 % 2 == 0) {
            throw null;
        }
        Object obj = onInstallConversionDataLoadedNative;
        int i6 = (((i4 | 99) << 1) - (i4 ^ 99)) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        onResponseNative = i6;
        onDeepLinkingNative = (((i6 | 31) << 1) - (i6 ^ 31)) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        try {
            Object[] objArr = {Integer.valueOf(i3)};
            byte[] bArr = onResponseErrorNative;
            int iIntValue = ((Integer) Class.forName($$c((short) 141, bArr[496], bArr[384]), true, (ClassLoader) AppsFlyer2dXConversionCallback).getMethod($$c((short) 740, bArr[29], bArr[12]), Integer.TYPE).invoke(obj, objArr)).intValue();
            int i7 = onResponseNative + 71;
            onDeepLinkingNative = i7 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i7 % 2 == 0) {
                return iIntValue;
            }
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    static void init$0() {
        int i3;
        int i4 = onDeepLinkingNative;
        int i5 = ((i4 | 89) << 1) - (i4 ^ 89);
        onResponseNative = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i5 % 2 == 0) {
            byte[] bArr = new byte[1081];
            System.arraycopy("$W]Ìú\u0018îÐ>\tÂ\u00176ô\u0003\u0002\u0010ö\u0002è(\u0005\b\u0002â$\u0001öÿ\u000fú\u0018îÐAø\u0010üÊ()ý\u0004ô\u000b\u0015\u0000\u0003ö\f\tÐ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002\u0001\u0012Ü%ø\b\u0000\u0006ÿ\u0010Þ\u001b\u0012ðõ$ð\u0016ôë\u0017\u0015û\u0010ù\u0011\u0000ýþÍD\u0007¾%%\u0000÷\u0005\u0011\u0003ú\u0018îÐCþ\tÂ\u0017:þôà6ô\u0003\u0002\u0010\u0010ù\u0011\u0000ýþÍD\u0007¾\u00176÷\u0006ûÃ5ò\u0010\u0004ù\t\u0002ú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÓ(\u0005\b\u0002â$\u0001öÿ\u000f\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u001e(â\u001b\u000b\u0005\u0006\nÎ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010öÿ\u0006å2ú\u0003\u0010\u0001\u0012Õ&\u0006ü\u0011Ô(\f\bù\u0004\u0016Ú\u001aþú\u000eô\u0001\u0012Ò!\u0005\b\u0000â(\föÿ\u0006\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0019$\u0016Ñ&\u0006ü\u000fø\u0004ý\u0007\u0001\u0005\b\u0000\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0017\"\u0015õâ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010\u0001\u0012Ò/ø\u0004á!\u0005\b\u0000â(\f\tøø\b\u0006(Ö2\u0003Ø4ò\f\tã(úøî\nì\u000bI\u0004´Iþ\u000e\u0003ù\u0002\u0005\u000b\u000b°Oü\u0004\u0011¸î\tí\u000bî\u0007ï\u000bî\u000bë\u000b\b\u0006(Ö2\u0003Ø4ò\f\tß\u0014\u0014ò\u000fû\u0012ô\u0010ß\u0016\u000fûú\u0018îÐAø\u0010üÊ\u0018,ø\u0015\u0003Ü&õ\u0006\u0004\u0010\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u00162\u0003Ú(\u0006ö\u0002\u000e\n\u0001\u0012Ô6ÿô\u0010ÿö\u000eê$þ\u0006ò\t\u0001â(\fö\u0001\u0014þ\u0006\n7\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ6Îú\u0018îÐ>\tÂ\u0019 \u0016ðë(\u0005\b\u0002â$\u0001öÿ\u000f\u0006õ\u0006ã$\u0016\u0010ù\u0011\u0000ýþÍKöÿ\u0015º \u001d\u0017Ï4ò\f\tú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÙ)\u0002ÿ\b\u0002â$\u0001öÿ\u000f\u0010ù\u0011\u0000ýþÍD\u0007¾\u001a,\u000bö\f\u0000\u0002\u0002û\f\tû\u0001\n\u0001\u0012Ò,ø\u0015\u0003Ü&õ\u0006\u0004\u00108\u0000\u0016ðÑ8\u0000\u0016ðÑ\u0004\nü\u0012ô\u0001\u0012Õ\u0001ô\n\u0017í\b\tö\u0016ø\u0010òê ü\u0013ò\u0014\nÚ\u0014\u0016÷à*ü\u000bû\f\t\u0002\f\u0006\u0007õ\u0001\u0012ã\u0017\röÿ\u0006ï%ú\t\u0006ú\u000e\b7\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ5Ï\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\u0015\b\u001eÓLÜô\nÜBú\u0018îÐ>\tÂIü\u0006÷\b\f\u0001\u0012ß%\u0000\u0004ø\u0010\u0005\b\u0001\u0012Ð$\u0014ÿ\u0000\f\u0002ôî\u0014\u0016÷\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u0016%\u0014ø\u0010ö\u000e\bÞ\u0017\röÿ\u0006î\u000e\fóí\u001aú\u0018îÐ>\tÂ\u001b&\u0006üí)\u0002ÿ\b\u0002â$\u0001öÿ\u000f\u0001\u0010ì\u001eú\u000eôú\u0018îÐ>\tÂ\u001e\tù6î\u0005\u000e\u0007ø\t\u0002\u0010ù\u0011\u0000ýþÍIô\u0016ÿ½)\u0014\u0016ÿä\"ø\u0006\nô\u0016÷ç \r\u0004\u0001\u0012Ø(þ\u000eøû\u000eØ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002ú\u0018îÐ>\tÂ\u001b&\u0006üî\u0006ð\u000b\u0015\u0000\u0003ö\f\tã\u0018\u0007ûë\u001f\u0006\u0003\u0000\r\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010¿>\b\tô\u0010ÿö\u000eÅ\u0016\b\u001eÓKÝô\nÜ\u0003ú\u0018îÐ>\tÂ\u001b&\u0006üâ$\u0011ó\u0012ú\n\u0007þ\u0006þÖ:þôß4\u0003ò\u001b\u0006õ\u0006â,ø\u0015\u0003\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\u0015\b\u001eÓKÝô\nÜ\u0003\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010þò\u0012ö\u0016ø\u0010òê ü\u0013ò\u0014\nÎ(\fö\u0001\u0014þ\u0006úÿ\u0011ú\u0018îÐ>\tÂ\u001e(\u0005\b\u0002â$\u0001öÿ\u000f".getBytes("ISO-8859-1"), 0, bArr, 0, 1081);
            onResponseErrorNative = bArr;
            i3 = 4709;
        } else {
            byte[] bArr2 = new byte[1081];
            System.arraycopy("$W]Ìú\u0018îÐ>\tÂ\u00176ô\u0003\u0002\u0010ö\u0002è(\u0005\b\u0002â$\u0001öÿ\u000fú\u0018îÐAø\u0010üÊ()ý\u0004ô\u000b\u0015\u0000\u0003ö\f\tÐ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002\u0001\u0012Ü%ø\b\u0000\u0006ÿ\u0010Þ\u001b\u0012ðõ$ð\u0016ôë\u0017\u0015û\u0010ù\u0011\u0000ýþÍD\u0007¾%%\u0000÷\u0005\u0011\u0003ú\u0018îÐCþ\tÂ\u0017:þôà6ô\u0003\u0002\u0010\u0010ù\u0011\u0000ýþÍD\u0007¾\u00176÷\u0006ûÃ5ò\u0010\u0004ù\t\u0002ú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÓ(\u0005\b\u0002â$\u0001öÿ\u000f\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u001e(â\u001b\u000b\u0005\u0006\nÎ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010öÿ\u0006å2ú\u0003\u0010\u0001\u0012Õ&\u0006ü\u0011Ô(\f\bù\u0004\u0016Ú\u001aþú\u000eô\u0001\u0012Ò!\u0005\b\u0000â(\föÿ\u0006\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0019$\u0016Ñ&\u0006ü\u000fø\u0004ý\u0007\u0001\u0005\b\u0000\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0017\"\u0015õâ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010\u0001\u0012Ò/ø\u0004á!\u0005\b\u0000â(\f\tøø\b\u0006(Ö2\u0003Ø4ò\f\tã(úøî\nì\u000bI\u0004´Iþ\u000e\u0003ù\u0002\u0005\u000b\u000b°Oü\u0004\u0011¸î\tí\u000bî\u0007ï\u000bî\u000bë\u000b\b\u0006(Ö2\u0003Ø4ò\f\tß\u0014\u0014ò\u000fû\u0012ô\u0010ß\u0016\u000fûú\u0018îÐAø\u0010üÊ\u0018,ø\u0015\u0003Ü&õ\u0006\u0004\u0010\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u00162\u0003Ú(\u0006ö\u0002\u000e\n\u0001\u0012Ô6ÿô\u0010ÿö\u000eê$þ\u0006ò\t\u0001â(\fö\u0001\u0014þ\u0006\n7\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ6Îú\u0018îÐ>\tÂ\u0019 \u0016ðë(\u0005\b\u0002â$\u0001öÿ\u000f\u0006õ\u0006ã$\u0016\u0010ù\u0011\u0000ýþÍKöÿ\u0015º \u001d\u0017Ï4ò\f\tú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÙ)\u0002ÿ\b\u0002â$\u0001öÿ\u000f\u0010ù\u0011\u0000ýþÍD\u0007¾\u001a,\u000bö\f\u0000\u0002\u0002û\f\tû\u0001\n\u0001\u0012Ò,ø\u0015\u0003Ü&õ\u0006\u0004\u00108\u0000\u0016ðÑ8\u0000\u0016ðÑ\u0004\nü\u0012ô\u0001\u0012Õ\u0001ô\n\u0017í\b\tö\u0016ø\u0010òê ü\u0013ò\u0014\nÚ\u0014\u0016÷à*ü\u000bû\f\t\u0002\f\u0006\u0007õ\u0001\u0012ã\u0017\röÿ\u0006ï%ú\t\u0006ú\u000e\b7\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ5Ï\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\u0015\b\u001eÓLÜô\nÜBú\u0018îÐ>\tÂIü\u0006÷\b\f\u0001\u0012ß%\u0000\u0004ø\u0010\u0005\b\u0001\u0012Ð$\u0014ÿ\u0000\f\u0002ôî\u0014\u0016÷\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u0016%\u0014ø\u0010ö\u000e\bÞ\u0017\röÿ\u0006î\u000e\fóí\u001aú\u0018îÐ>\tÂ\u001b&\u0006üí)\u0002ÿ\b\u0002â$\u0001öÿ\u000f\u0001\u0010ì\u001eú\u000eôú\u0018îÐ>\tÂ\u001e\tù6î\u0005\u000e\u0007ø\t\u0002\u0010ù\u0011\u0000ýþÍIô\u0016ÿ½)\u0014\u0016ÿä\"ø\u0006\nô\u0016÷ç \r\u0004\u0001\u0012Ø(þ\u000eøû\u000eØ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002ú\u0018îÐ>\tÂ\u001b&\u0006üî\u0006ð\u000b\u0015\u0000\u0003ö\f\tã\u0018\u0007ûë\u001f\u0006\u0003\u0000\r\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010¿>\b\tô\u0010ÿö\u000eÅ\u0016\b\u001eÓKÝô\nÜ\u0003ú\u0018îÐ>\tÂ\u001b&\u0006üâ$\u0011ó\u0012ú\n\u0007þ\u0006þÖ:þôß4\u0003ò\u001b\u0006õ\u0006â,ø\u0015\u0003\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\u0015\b\u001eÓKÝô\nÜ\u0003\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010þò\u0012ö\u0016ø\u0010òê ü\u0013ò\u0014\nÎ(\fö\u0001\u0014þ\u0006úÿ\u0011ú\u0018îÐ>\tÂ\u001e(\u0005\b\u0002â$\u0001öÿ\u000f".getBytes("ISO-8859-1"), 0, bArr2, 0, 1081);
            onResponseErrorNative = bArr2;
            i3 = 204;
        }
        onAttributionFailureNative = i3;
        int i6 = onResponseNative + 75;
        onDeepLinkingNative = i6 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i6 % 2 != 0) {
            throw null;
        }
    }

    public static Object AFKeystoreWrapper(char c3, int i3, int i4) throws Throwable {
        int i5 = onDeepLinkingNative + 47;
        onResponseNative = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i5 % 2 == 0) {
            throw null;
        }
        Object obj = onInstallConversionDataLoadedNative;
        try {
            Object[] objArr = {Character.valueOf(c3), Integer.valueOf(i3), Integer.valueOf(i4)};
            byte[] bArr = onResponseErrorNative;
            Class<?> cls = Class.forName($$c((short) 141, bArr[496], bArr[384]), true, (ClassLoader) AppsFlyer2dXConversionCallback);
            String str$$c = $$c((short) 274, bArr[69], bArr[26]);
            Class cls2 = Character.TYPE;
            Class cls3 = Integer.TYPE;
            Object objInvoke = cls.getMethod(str$$c, cls2, cls3, cls3).invoke(obj, objArr);
            int i6 = onDeepLinkingNative;
            int i7 = ((i6 | 5) << 1) - (i6 ^ 5);
            onResponseNative = i7 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i7 % 2 != 0) {
                return objInvoke;
            }
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
