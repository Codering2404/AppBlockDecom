package com.appsflyer.internal;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AFb1mSDK {
    public static byte[] AppsFlyerLib = null;
    public static byte[] getInstance = null;
    private static int getOutOfStore = 0;
    private static Object setAndroidIdData = null;
    public static final byte[] setDebugLog = null;
    public static long setImeiData = 0;
    public static byte setOaidData = 0;
    private static int setPhoneNumber = 1;
    private static Object updateServerUninstallToken;
    public static final int waitForCustomerUserId = 0;

    private static String $$c(short s2, byte b3, int i3) {
        int i4 = (setPhoneNumber + 93) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        getOutOfStore = i4;
        int i5 = i3 + 1;
        int i6 = -b3;
        int i7 = (i6 ^ 119) + ((i6 & 119) << 1);
        byte[] bArr = setDebugLog;
        int i8 = 1071 - s2;
        byte[] bArr2 = new byte[i5];
        int i9 = (i5 ^ 121) + ((i5 & 121) << 1);
        int i10 = ((i9 | (-122)) << 1) - (i9 ^ (-122));
        int i11 = -1;
        if (bArr == null) {
            setPhoneNumber = (((i4 | 3) << 1) - (i4 ^ 3)) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            int i12 = -(-i8);
            int i13 = (i7 & i12) + (i12 | i7);
            int i14 = (i8 ^ 59) + ((i8 & 59) << 1);
            i8 = (i14 | (-58)) + (i14 & (-58));
            i7 = (i13 | (-3)) + (i13 & (-3));
            int i15 = setPhoneNumber;
            getOutOfStore = ((i15 & 39) + (i15 | 39)) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            bArr = bArr;
        }
        while (true) {
            int i16 = (i11 ^ 1) + ((i11 & 1) << 1);
            bArr2[i16] = (byte) i7;
            if (i16 == i10) {
                break;
            }
            byte b4 = bArr[i8];
            byte[] bArr3 = bArr;
            int i17 = i8;
            i11 = i16;
            int i18 = -(-b4);
            int i19 = (i7 & i18) + (i18 | i7);
            int i20 = (i17 ^ 59) + ((i17 & 59) << 1);
            i8 = (i20 | (-58)) + (i20 & (-58));
            i7 = (i19 | (-3)) + (i19 & (-3));
            int i21 = setPhoneNumber;
            getOutOfStore = ((i21 & 39) + (i21 | 39)) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            bArr = bArr3;
        }
        String str = new String(bArr2, 0);
        int i22 = getOutOfStore;
        int i23 = (i22 ^ 103) + ((i22 & 103) << 1);
        setPhoneNumber = i23 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i23 % 2 == 0) {
            int i24 = 39 / 0;
        }
        return str;
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [boolean, byte[]], vars: [r38v0 ??, r38v2 ??, r38v4 ??, r38v3 ??, r38v7 ??, r38v5 ??, r38v9 ??, r38v12 ??, r38v28 ??, r38v22 ??, r38v40 ??, r38v14 ??, r38v15 ??, r38v19 ??, r38v43 ??, r38v31 ??, r38v39 ??, r38v38 ??, r38v41 ??, r38v1 ??, r38v26 ??, r38v21 ??, r38v23 ??, r38v27 ??, r38v42 ??, r38v44 ??, r38v6 ??, r38v45 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.rerun(InitCodeVariables.java:36)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:818)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        */
    static {
        /*
            Method dump skipped, instruction units count: 5732
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1mSDK.<clinit>():void");
    }

    private AFb1mSDK() {
    }

    public static int AFInAppEventParameterName(int i3) throws Throwable {
        int i4 = getOutOfStore;
        int i5 = ((i4 | 73) << 1) - (i4 ^ 73);
        setPhoneNumber = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i5 % 2 == 0) {
            throw null;
        }
        Object obj = setAndroidIdData;
        setPhoneNumber = ((i4 ^ 71) + ((i4 & 71) << 1)) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        try {
            Object[] objArr = {Integer.valueOf(i3)};
            byte[] bArr = setDebugLog;
            int iIntValue = ((Integer) Class.forName($$c((short) 783, bArr[509], bArr[521]), true, (ClassLoader) updateServerUninstallToken).getMethod($$c((short) 465, bArr[6], bArr[46]), Integer.TYPE).invoke(obj, objArr)).intValue();
            int i6 = getOutOfStore + 1;
            setPhoneNumber = i6 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i6 % 2 != 0) {
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
        setPhoneNumber = (getOutOfStore + 79) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        byte[] bArr = new byte[1089];
        System.arraycopy("uÅ\u008c¸7\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ8Ìú\u0018îÐ>\tÂ\u00176ô\u0003\u0002\u0010ö\u0002è(\u0005\b\u0002â$\u0001öÿ\u000fö\u0011ÿ\u0000\ròí$ô\u0005\t\u000e\bú\u0018îÐAø\u0010üÊ()ý\u0004ô\u000b\u0015\u0000\u0003ö\f\tÐ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002\u0010ù\u0011\u0000ýþÍ<\u000eò\u0012û\u0004ý\u0013¾9\u0011ò\u0019í\u0004\rüÌ\u00191ò\u0019í\u0004\rü\u0010ù\u0011\u0000ýþÍD\u0007¾%%\u0000÷\u0005\u0011\u0003ú\u0018îÐCþ\tÂ\u0017:þôà6ô\u0003\u0002\u0010\u0010ù\u0011\u0000ýþÍD\u0007¾\u00176÷\u0006ûÃ5ò\u0010\u0004ù\t\u0002ú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÓ(\u0005\b\u0002â$\u0001öÿ\u000f\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u001e(â\u001b\u000b\u0005\u0006\nÎ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010öÿ\u0006å2ú\u0003\u0010\u0001\u0012Õ&\u0006ü\u0011Ô(\fþú\u000eô\u0001\u0012Ò!\u0005\b\u0000â(\föÿ\u0006\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010¿>\b\tô\u0010ÿö\u000eÅ\u0016\b\u001fÒCåô\nÜ\u0003\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0019$\u0016Ñ&\u0006ü\u000fø\u0004ý\u0007\u0001\u0005\b\u0000\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0017\"\u0015õâ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010\u0001\u0012Ò/ø\u0004á!\u0005\b\u0000â(\f\b\u0006(Ö2\u0003Ø4ò\f\tã(úø\tøøî\nì\u000bI\u0004´Iþ\u000e\u0003ù\u0002\u0005\u000b\u000b°Oü\u0004\u0011¸î\tí\u000bî\u0007ï\u000bî\u000bë\u000bú\u0018îÐAø\u0010üÊ\u0018,ø\u0015\u0003Ü&õ\u0006\u0004\u0010\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u00162\u0003Ú(\u0006ö\u0002\u000e\n\u0001\u0012Ô6ÿô\u0010ÿö\u000eê$þ\u0006ò\t\u0001â(\fö\u0001\u0014þ\u0006\nú\u0018îÐ>\tÂ\u0019 \u0016ðë(\u0005\b\u0002â$\u0001öÿ\u000f\u0006õ\u0006ã$\u0016ú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÙ)\u0002ÿ\b\u0002â$\u0001öÿ\u000f\u0010ù\u0011\u0000ýþÍD\u0007¾\u001a,\u000bö\f\u0000\u0002\u0002û\f\t\u0001\u0012Ô*ø\u0012\u0006õ\u0002â0\bâ\u0018\u0007ûî\u000e\fó\u0011\u0001\u0012Þ\u001a\u0003\u0010õ\u0012Ñ&\u0004\f\u0006öû\u0001\n\u0001\u0012Ò,ø\u0015\u0003Ü&õ\u0006\u0004\u00108\u0000\u0016ðÑ8\u0000\u0016ðÑ\u0004\nü\u0012ô\u0001\u0012Õ\u0001\b\b\u001d\u0017ý\u0004þ\u0006öõ\u001eò\u0012\u0003ø\u0010ô\n\u0017í\b\t\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\u0015\b\u001fÒ?éô\nÜP\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\u0015\b\u001fÒCåô\nÜ\u0003ö\u0016ø\u0010òê ü\u0013ò\u0014\nÚ\u0014\u0016÷à*ü\u000bû\f\t\u0002\f\u0006\u0007õ7\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ7Íú\u0018îÐ>\tÂIü\u0006÷\b\f\u0001\u0012ß%\u0000\u0004ø\u0010\u0005\b\u0001\u0012Ð$\u0014ÿ\u0000\f\u0002ôî\u0014\u0016÷\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u0016%\u0014ø\u0010ö\u000e\bÞ\u0017\röÿ\u0006î\u000e\fóí\u001aú\u0018îÐ>\tÂ\u001b&\u0006üí)\u0002ÿ\b\u0002â$\u0001öÿ\u000f\u0001\u0010ì\u001eú\u000eôú\u0018îÐ>\tÂ\u001e\tù6î\u0005\u000e\u0007ø\t\u0002\u0010ù\u0011\u0000ýþÍIô\u0016ÿ½)\u0014\u0016ÿä\"ø\u0006\nô\u0016÷ç \r\u0004\u0001\u0012Ø(þ\u000eøû\u000eØ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002ú\u0018îÐ>\tÂ\u001b&\u0006üî\u0006ð\u000b\u0015\u0000\u0003ö\f\tã\u0018\u0007ûë\u001f\u0006\u0003\u0000\rú\u0018îÐ>\tÂ\u001b&\u0006üâ$\u0011ó\u0012ú\n\u0007þ\u0006þÖ:þôß4\u0003ò\u001b\u0006õ\u0006â,ø\u0015\u0003\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010þò\u0012ö\u0016ø\u0010òê ü\u0013ò\u0014\nÎ(\fö\u0001\u0014þ\u0006úÿ\u0011ú\u0018îÐ>\tÂ\u001e(\u0005\b\u0002â$\u0001öÿ\u000f".getBytes("ISO-8859-1"), 0, bArr, 0, 1089);
        setDebugLog = bArr;
        waitForCustomerUserId = 170;
        getOutOfStore = (setPhoneNumber + 49) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    public static int valueOf(Object obj) throws Throwable {
        int i3 = (getOutOfStore + 33) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        Object obj2 = setAndroidIdData;
        int i4 = (i3 + 43) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        getOutOfStore = i4;
        setPhoneNumber = (i4 + 3) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        try {
            byte[] bArr = setDebugLog;
            int iIntValue = ((Integer) Class.forName($$c((short) 783, bArr[509], bArr[521]), true, (ClassLoader) updateServerUninstallToken).getMethod($$c((short) 210, bArr[6], bArr[11]), Object.class).invoke(obj2, obj)).intValue();
            setPhoneNumber = (getOutOfStore + 23) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            return iIntValue;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static Object values(int i3, char c3, int i4) throws Throwable {
        Object obj;
        int i5 = setPhoneNumber + 57;
        int i6 = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        getOutOfStore = i6;
        if (i5 % 2 != 0) {
            obj = setAndroidIdData;
            int i7 = 51 / 0;
        } else {
            obj = setAndroidIdData;
        }
        setPhoneNumber = (((i6 | 89) << 1) - (i6 ^ 89)) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        try {
            Object[] objArr = {Integer.valueOf(i3), Character.valueOf(c3), Integer.valueOf(i4)};
            byte[] bArr = setDebugLog;
            Class<?> cls = Class.forName($$c((short) 783, bArr[509], bArr[521]), true, (ClassLoader) updateServerUninstallToken);
            String str$$c = $$c((short) 411, bArr[37], bArr[14]);
            Class cls2 = Integer.TYPE;
            return cls.getMethod(str$$c, cls2, Character.TYPE, cls2).invoke(obj, objArr);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
