package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.ads.AdError;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfl {
    public static final String zza;
    public static final byte[] zzb;
    private static final Pattern zzc;
    private static HashMap zzd;
    private static final String[] zze;
    private static final String[] zzf;
    private static final int[] zzg;
    private static final int[] zzh;
    private static final int[] zzi;

    public static zzv zzA(int i3, int i4, int i5) {
        zzt zztVar = new zzt();
        zztVar.zzo("audio/raw");
        zztVar.zzG(i4);
        zztVar.zzH(i5);
        zztVar.zzI(i3);
        return zztVar.zzO();
    }

    public static int zzB(int i3, ByteOrder byteOrder) {
        if (i3 == 8) {
            return 3;
        }
        if (i3 == 16) {
            return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 2 : 268435456;
        }
        if (i3 == 24) {
            return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 21 : 1342177280;
        }
        if (i3 != 32) {
            return 0;
        }
        return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 22 : 1610612736;
    }

    public static int zzC(int i3) {
        if (i3 != 32) {
            return i3 != 64 ? 0 : 1879048192;
        }
        return 4;
    }

    public static boolean zzD(int i3) {
        return i3 == 3 || i3 == 2 || i3 == 268435456 || i3 == 21 || i3 == 1342177280 || i3 == 22 || i3 == 1610612736 || i3 == 4 || i3 == 1879048192;
    }

    public static int zzE(int i3) {
        int i4;
        int i5 = 6396;
        if (i3 != 10) {
            if (i3 == 16) {
                i4 = 205215996;
            } else if (i3 != 24) {
                switch (i3) {
                    case 1:
                        return 4;
                    case 2:
                        return 12;
                    case 3:
                        return 28;
                    case 4:
                        return 204;
                    case 5:
                        return 220;
                    case 6:
                        return 252;
                    case 7:
                        return 1276;
                    case 8:
                        return 6396;
                    default:
                        switch (i3) {
                            case 12:
                                return 743676;
                            case 13:
                                i4 = 30136348;
                                break;
                            case 14:
                                i4 = 202070268;
                                break;
                            default:
                                return 0;
                        }
                        break;
                }
            } else {
                i4 = 67108860;
            }
            i5 = 0;
        } else {
            i4 = 737532;
        }
        return Build.VERSION.SDK_INT >= 32 ? i4 : i5;
    }

    public static int zzF(int i3) {
        switch (i3) {
            case 2:
            case 3:
                return 3;
            case 4:
            case 5:
            case 6:
                return 21;
            case 7:
            case 8:
                return 23;
            case 9:
            case 10:
            case 11:
            case 12:
            case 15:
            case 16:
            case 17:
            case 18:
                return 28;
            case 13:
            case 19:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            default:
                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
            case 14:
                return 25;
            case 20:
                return 30;
            case 21:
            case 22:
                return 31;
            case 30:
            case 31:
                return 34;
        }
    }

    public static int zzG(int i3) {
        if (i3 != 2) {
            if (i3 == 3) {
                return 1;
            }
            if (i3 != 4) {
                if (i3 != 21) {
                    if (i3 != 22) {
                        if (i3 != 268435456) {
                            if (i3 != 1342177280) {
                                if (i3 != 1610612736) {
                                    if (i3 == 1879048192) {
                                        return 8;
                                    }
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                    }
                }
                return 3;
            }
            return 4;
        }
        return 2;
    }

    public static int zzH(int i3) {
        if (i3 == 2 || i3 == 4) {
            return 6005;
        }
        if (i3 == 10) {
            return 6004;
        }
        if (i3 == 7) {
            return 6005;
        }
        if (i3 == 8) {
            return AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE;
        }
        switch (i3) {
            case 15:
                return AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE;
            case 16:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i3) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return AdError.ICONVIEW_MISSING_ERROR_CODE;
                    default:
                        return 6006;
                }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zzI(android.net.Uri r6) {
        /*
            java.lang.String r0 = r6.getScheme()
            if (r0 == 0) goto L18
            java.lang.String r1 = "rtsp"
            boolean r1 = com.google.android.gms.internal.ads.zzgss.zze(r1, r0)
            if (r1 != 0) goto L16
            java.lang.String r1 = "rtspt"
            boolean r0 = com.google.android.gms.internal.ads.zzgss.zze(r1, r0)
            if (r0 == 0) goto L18
        L16:
            r6 = 3
            return r6
        L18:
            java.lang.String r0 = r6.getLastPathSegment()
            r1 = 4
            if (r0 != 0) goto L20
            return r1
        L20:
            r2 = 46
            int r2 = r0.lastIndexOf(r2)
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 < 0) goto L68
            int r2 = r2 + r5
            java.lang.String r0 = r0.substring(r2)
            java.lang.String r0 = com.google.android.gms.internal.ads.zzgss.zza(r0)
            int r2 = r0.hashCode()
            switch(r2) {
                case 104579: goto L59;
                case 108321: goto L4f;
                case 3242057: goto L46;
                case 3299913: goto L3c;
                default: goto L3b;
            }
        L3b:
            goto L63
        L3c:
            java.lang.String r2 = "m3u8"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L63
            r0 = r4
            goto L64
        L46:
            java.lang.String r2 = "isml"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L63
            goto L61
        L4f:
            java.lang.String r2 = "mpd"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L63
            r0 = r3
            goto L64
        L59:
            java.lang.String r2 = "ism"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L63
        L61:
            r0 = r5
            goto L64
        L63:
            r0 = r1
        L64:
            if (r0 != r1) goto L67
            goto L68
        L67:
            return r0
        L68:
            java.util.regex.Pattern r0 = com.google.android.gms.internal.ads.zzfl.zzc
            java.lang.String r6 = r6.getPath()
            r6.getClass()
            java.util.regex.Matcher r6 = r0.matcher(r6)
            boolean r0 = r6.matches()
            if (r0 == 0) goto L94
            java.lang.String r6 = r6.group(r4)
            if (r6 == 0) goto L93
            java.lang.String r0 = "format=mpd-time-csf"
            boolean r0 = r6.contains(r0)
            if (r0 == 0) goto L8a
            return r3
        L8a:
            java.lang.String r0 = "format=m3u8-aapl"
            boolean r6 = r6.contains(r0)
            if (r6 == 0) goto L93
            return r4
        L93:
            return r5
        L94:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfl.zzI(android.net.Uri):int");
    }

    public static int zzJ(byte[] bArr, int i3, int i4, int i5) {
        while (i3 < i4) {
            i5 = zzg[(i5 >>> 24) ^ (bArr[i3] & 255)] ^ (i5 << 8);
            i3++;
        }
        return i5;
    }

    public static int zzK(byte[] bArr, int i3, int i4, int i5) {
        int iZzW = 65535;
        for (int i6 = 0; i6 < i4; i6++) {
            int unsignedInt = Byte.toUnsignedInt(bArr[i6]);
            iZzW = zzW(unsignedInt & 15, zzW(unsignedInt >> 4, iZzW));
        }
        return iZzW;
    }

    public static int zzL(byte[] bArr, int i3, int i4, int i5) {
        int i6 = 0;
        while (i3 < i4) {
            i6 = zzi[i6 ^ (bArr[i3] & 255)];
            i3++;
        }
        return i6;
    }

    public static int zzM(ByteBuffer byteBuffer, int i3) {
        int i4 = byteBuffer.getInt(i3);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i4 : Integer.reverseBytes(i4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
    
        r4.zzf(r3);
        r1 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean zzN(com.google.android.gms.internal.ads.zzet r3, com.google.android.gms.internal.ads.zzet r4, java.util.zip.Inflater r5) {
        /*
            int r0 = r3.zzd()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            int r0 = r4.zzj()
            int r2 = r3.zzd()
            if (r0 >= r2) goto L1a
            int r0 = r3.zzd()
            int r0 = r0 + r0
            r4.zzc(r0)
        L1a:
            if (r5 != 0) goto L21
            java.util.zip.Inflater r5 = new java.util.zip.Inflater
            r5.<init>()
        L21:
            byte[] r0 = r3.zzi()
            int r2 = r3.zzg()
            int r3 = r3.zzd()
            r5.setInput(r0, r2, r3)
            r3 = r1
        L31:
            byte[] r0 = r4.zzi()     // Catch: java.lang.Throwable -> L4a java.util.zip.DataFormatException -> L6c
            int r2 = r4.zzj()     // Catch: java.lang.Throwable -> L4a java.util.zip.DataFormatException -> L6c
            int r2 = r2 - r3
            int r0 = r5.inflate(r0, r3, r2)     // Catch: java.lang.Throwable -> L4a java.util.zip.DataFormatException -> L6c
            int r3 = r3 + r0
            boolean r0 = r5.finished()     // Catch: java.lang.Throwable -> L4a java.util.zip.DataFormatException -> L6c
            if (r0 == 0) goto L4c
            r4.zzf(r3)     // Catch: java.lang.Throwable -> L4a java.util.zip.DataFormatException -> L6c
            r1 = 1
            goto L6c
        L4a:
            r3 = move-exception
            goto L68
        L4c:
            boolean r0 = r5.needsDictionary()     // Catch: java.lang.Throwable -> L4a java.util.zip.DataFormatException -> L6c
            if (r0 != 0) goto L6c
            boolean r0 = r5.needsInput()     // Catch: java.lang.Throwable -> L4a java.util.zip.DataFormatException -> L6c
            if (r0 == 0) goto L59
            goto L6c
        L59:
            int r0 = r4.zzj()     // Catch: java.lang.Throwable -> L4a java.util.zip.DataFormatException -> L6c
            if (r3 != r0) goto L31
            int r0 = r4.zzj()     // Catch: java.lang.Throwable -> L4a java.util.zip.DataFormatException -> L6c
            int r0 = r0 + r0
            r4.zzc(r0)     // Catch: java.lang.Throwable -> L4a java.util.zip.DataFormatException -> L6c
            goto L31
        L68:
            r5.reset()
            throw r3
        L6c:
            r5.reset()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfl.zzN(com.google.android.gms.internal.ads.zzet, com.google.android.gms.internal.ads.zzet, java.util.zip.Inflater):boolean");
    }

    public static boolean zzO(zzet zzetVar, zzet zzetVar2, Inflater inflater) {
        return zzetVar.zzd() > 0 && zzetVar.zzn() == 120 && zzN(zzetVar, zzetVar2, inflater);
    }

    public static boolean zzP(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static boolean zzQ(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    public static Point zzR(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
        Display display = displayManager != null ? displayManager.getDisplay(0) : null;
        if (display == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getClass();
            display = windowManager.getDefaultDisplay();
        }
        if (display.getDisplayId() == 0 && zzP(context)) {
            String strZzX = zzX("vendor.display-size");
            if (!TextUtils.isEmpty(strZzX)) {
                try {
                    String[] strArrSplit = strZzX.trim().split("x", -1);
                    if (strArrSplit.length == 2) {
                        int i3 = Integer.parseInt(strArrSplit[0]);
                        int i4 = Integer.parseInt(strArrSplit[1]);
                        if (i3 > 0 && i4 > 0) {
                            return new Point(i3, i4);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                zzeg.zze("Util", "Invalid display size: ".concat(String.valueOf(strZzX)));
            }
            if ("Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
        return point;
    }

    public static String zzS(int i3) {
        switch (i3) {
            case -2:
                return IntegrityManager.INTEGRITY_TYPE_NONE;
            case -1:
                return "unknown";
            case 0:
                return "default";
            case 1:
                return "audio";
            case 2:
                return AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO;
            case 3:
                return "text";
            case 4:
                return "image";
            case 5:
                return "metadata";
            default:
                return "camera motion";
        }
    }

    public static int zzT(String str) {
        String[] strArrSplit;
        int length;
        if (str == null || (length = (strArrSplit = str.split("_", -1)).length) < 2) {
            return 0;
        }
        String str2 = strArrSplit[length - 1];
        boolean z2 = length >= 3 && "neg".equals(strArrSplit[length + (-2)]);
        try {
            if (str2 == null) {
                throw null;
            }
            int i3 = Integer.parseInt(str2);
            return z2 ? -i3 : i3;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static boolean zzU(Context context) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 29 || context.getApplicationInfo().targetSdkVersion < 29) {
            return true;
        }
        if (i3 == 30) {
            String str = Build.MODEL;
            if (zzgss.zze(str, "moto g(20)") || zzgss.zze(str, "rmx3231")) {
                return true;
            }
        }
        return i3 == 34 && zzgss.zze(Build.MODEL, "sm-x200");
    }

    private static long zzV(long j3, long j4, long j5, RoundingMode roundingMode) {
        long jZzc = zzhab.zzc(j3, j4);
        if (jZzc != Long.MAX_VALUE && jZzc != Long.MIN_VALUE) {
            return zzhab.zza(jZzc, j5, roundingMode);
        }
        long jZzb = zzhab.zzb(Math.abs(j4), Math.abs(j5));
        RoundingMode roundingMode2 = RoundingMode.UNNECESSARY;
        long jZza = zzhab.zza(j4, jZzb, roundingMode2);
        long jZza2 = zzhab.zza(j5, jZzb, roundingMode2);
        long jZzb2 = zzhab.zzb(Math.abs(j3), Math.abs(jZza2));
        long jZza3 = zzhab.zza(j3, jZzb2, roundingMode2);
        long jZza4 = zzhab.zza(jZza2, jZzb2, roundingMode2);
        long jZzc2 = zzhab.zzc(jZza3, jZza);
        if (jZzc2 != Long.MAX_VALUE && jZzc2 != Long.MIN_VALUE) {
            return zzhab.zza(jZzc2, jZza4, roundingMode);
        }
        double d3 = jZza3 * (jZza / jZza4);
        if (d3 > 9.223372036854776E18d) {
            return Long.MAX_VALUE;
        }
        if (d3 < -9.223372036854776E18d) {
            return Long.MIN_VALUE;
        }
        return zzgzw.zza(d3, roundingMode);
    }

    private static int zzW(int i3, int i4) {
        return (char) (zzh[(i3 ^ (i4 >> 12)) & 255] ^ ((char) (i4 << 4)));
    }

    private static String zzX(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e3) {
            zzeg.zzf("Util", "Failed to read system property ".concat(str), e3);
            return null;
        }
    }

    private static HashMap zzY() {
        String[] iSOLanguages = Locale.getISOLanguages();
        int length = iSOLanguages.length;
        int length2 = zze.length;
        HashMap map = new HashMap(length + 88);
        int i3 = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    map.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = zze;
            int length3 = strArr.length;
            if (i3 >= 88) {
                return map;
            }
            map.put(strArr[i3], strArr[i3 + 1]);
            i3 += 2;
        }
    }

    public static boolean zza(SparseArray sparseArray, int i3) {
        return sparseArray.indexOfKey(i3) >= 0;
    }

    public static Object[] zzb(Object[] objArr, int i3) {
        zzgtj.zza(i3 <= objArr.length);
        return Arrays.copyOf(objArr, i3);
    }

    public static void zzc(List list, Object[] objArr) {
        zzgtj.zzi(list.size() == objArr.length);
        list.toArray(objArr);
    }

    public static Handler zzd(Handler.Callback callback) {
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        return new Handler(looperMyLooper, null);
    }

    public static boolean zze(Handler handler, Runnable runnable) {
        Looper looper = handler.getLooper();
        if (!looper.getThread().isAlive()) {
            return false;
        }
        if (looper != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static Looper zzf() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    public static ExecutorService zzg(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.google.android.gms.internal.ads.zzfk
            @Override // java.util.concurrent.ThreadFactory
            public final /* synthetic */ Thread newThread(Runnable runnable) {
                String str2 = zzfl.zza;
                return new Thread(runnable, str);
            }
        });
    }

    public static ScheduledExecutorService zzh(String str) {
        final String str2 = "ExoPlayer:AudioTrackReleaseThread";
        return Executors.newSingleThreadScheduledExecutor(new ThreadFactory(str2) { // from class: com.google.android.gms.internal.ads.zzfj
            @Override // java.util.concurrent.ThreadFactory
            public final /* synthetic */ Thread newThread(Runnable runnable) {
                String str3 = zzfl.zza;
                return new Thread(runnable, "ExoPlayer:AudioTrackReleaseThread");
            }
        });
    }

    public static String zzi(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace('_', '-');
        if (!strReplace.isEmpty() && !strReplace.equals("und")) {
            str = strReplace;
        }
        String strZza = zzgss.zza(str);
        int i3 = 0;
        String str2 = strZza.split("-", 2)[0];
        if (zzd == null) {
            zzd = zzY();
        }
        String str3 = (String) zzd.get(str2);
        if (str3 != null) {
            strZza = str3.concat(String.valueOf(strZza.substring(str2.length())));
            str2 = str3;
        }
        if ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) {
            while (true) {
                String[] strArr = zzf;
                int length = strArr.length;
                if (i3 >= 18) {
                    break;
                }
                if (strZza.startsWith(strArr[i3])) {
                    return String.valueOf(strArr[i3 + 1]).concat(String.valueOf(strZza.substring(strArr[i3].length())));
                }
                i3 += 2;
            }
        }
        return strZza;
    }

    public static String zzj(byte[] bArr) {
        return new String(bArr, StandardCharsets.UTF_8);
    }

    public static String zzk(byte[] bArr, int i3, int i4) {
        return new String(bArr, i3, i4, StandardCharsets.UTF_8);
    }

    public static boolean zzl(int i3) {
        return i3 == 10 || i3 == 13;
    }

    public static double zzm(double d3, double d4, double d5) {
        return Math.max(-1.0d, Math.min(d3, 1.0d));
    }

    public static int zzn(int[] iArr, int i3, boolean z2, boolean z3) {
        int i4;
        int i5;
        int iBinarySearch = Arrays.binarySearch(iArr, i3);
        if (iBinarySearch < 0) {
            i5 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i4 = iBinarySearch - 1;
                if (i4 < 0 || iArr[i4] != i3) {
                    break;
                }
                iBinarySearch = i4;
            }
            i5 = z2 ? iBinarySearch : i4;
        }
        return z3 ? Math.max(0, i5) : i5;
    }

    public static int zzo(long[] jArr, long j3, boolean z2, boolean z3) {
        int i3;
        int iBinarySearch = Arrays.binarySearch(jArr, j3);
        if (iBinarySearch < 0) {
            i3 = -(iBinarySearch + 2);
        } else {
            while (true) {
                int i4 = iBinarySearch - 1;
                if (i4 < 0 || jArr[i4] != j3) {
                    break;
                }
                iBinarySearch = i4;
            }
            i3 = iBinarySearch;
        }
        return z3 ? Math.max(0, i3) : i3;
    }

    public static int zzp(zzeh zzehVar, long j3, boolean z2, boolean z3) {
        int iZzd = zzehVar.zzd() - 1;
        int i3 = 0;
        while (i3 <= iZzd) {
            int i4 = (i3 + iZzd) >>> 1;
            if (zzehVar.zzc(i4) < j3) {
                i3 = i4 + 1;
            } else {
                iZzd = i4 - 1;
            }
        }
        int i5 = iZzd + 1;
        if (i5 < zzehVar.zzd() && zzehVar.zzc(i5) == j3) {
            return i5;
        }
        if (iZzd == -1) {
            return 0;
        }
        return iZzd;
    }

    public static int zzq(long[] jArr, long j3, boolean z2, boolean z3) {
        int i3;
        int iBinarySearch = Arrays.binarySearch(jArr, j3);
        if (iBinarySearch < 0) {
            return ~iBinarySearch;
        }
        while (true) {
            i3 = iBinarySearch + 1;
            if (i3 >= jArr.length || jArr[i3] != j3) {
                break;
            }
            iBinarySearch = i3;
        }
        return !z2 ? i3 : iBinarySearch;
    }

    public static long zzr(long j3) {
        return (j3 == -9223372036854775807L || j3 == Long.MIN_VALUE) ? j3 : j3 / 1000;
    }

    public static long zzs(long j3) {
        return (j3 == -9223372036854775807L || j3 == Long.MIN_VALUE) ? j3 : j3 * 1000;
    }

    public static long zzt(long j3, int i3) {
        return zzv(j3, 1000000L, i3, RoundingMode.DOWN);
    }

    public static long zzu(long j3, int i3) {
        return zzv(j3, i3, 1000000L, RoundingMode.UP);
    }

    public static long zzv(long j3, long j4, long j5, RoundingMode roundingMode) {
        if (j3 == 0 || j4 == 0) {
            return 0L;
        }
        return (j5 < j4 || j5 % j4 != 0) ? (j5 >= j4 || j4 % j5 != 0) ? (j5 < j3 || j5 % j3 != 0) ? (j5 >= j3 || j3 % j5 != 0) ? zzV(j3, j4, j5, roundingMode) : zzhab.zzc(j4, zzhab.zza(j3, j5, RoundingMode.UNNECESSARY)) : zzhab.zza(j4, zzhab.zza(j5, j3, RoundingMode.UNNECESSARY), roundingMode) : zzhab.zzc(j3, zzhab.zza(j4, j5, RoundingMode.UNNECESSARY)) : zzhab.zza(j3, zzhab.zza(j5, j4, RoundingMode.UNNECESSARY), roundingMode);
    }

    public static void zzw(long[] jArr, long j3, long j4) {
        long j5;
        RoundingMode roundingMode = RoundingMode.DOWN;
        int i3 = 0;
        if (j4 >= 1000000 && j4 % 1000000 == 0) {
            long jZza = zzhab.zza(j4, 1000000L, RoundingMode.UNNECESSARY);
            while (i3 < jArr.length) {
                jArr[i3] = zzhab.zza(jArr[i3], jZza, roundingMode);
                i3++;
            }
            return;
        }
        if (j4 < 1000000 && 1000000 % j4 == 0) {
            long jZza2 = zzhab.zza(1000000L, j4, RoundingMode.UNNECESSARY);
            while (i3 < jArr.length) {
                jArr[i3] = zzhab.zzc(jArr[i3], jZza2);
                i3++;
            }
            return;
        }
        int i4 = 0;
        while (i4 < jArr.length) {
            long j6 = jArr[i4];
            if (j6 != 0) {
                if (j4 >= j6 && j4 % j6 == 0) {
                    jArr[i4] = zzhab.zza(1000000L, zzhab.zza(j4, j6, RoundingMode.UNNECESSARY), roundingMode);
                } else if (j4 >= j6 || j6 % j4 != 0) {
                    j5 = j4;
                    jArr[i4] = zzV(j6, 1000000L, j5, roundingMode);
                } else {
                    jArr[i4] = zzhab.zzc(1000000L, zzhab.zza(j6, j4, RoundingMode.UNNECESSARY));
                }
                j5 = j4;
            } else {
                j5 = j4;
            }
            i4++;
            j4 = j5;
        }
    }

    public static long zzx(long j3, float f3) {
        return f3 == 1.0f ? j3 : Math.round(j3 * ((double) f3));
    }

    public static long zzy(long j3, float f3) {
        return f3 == 1.0f ? j3 : Math.round(j3 / ((double) f3));
    }

    public static String zzz(int i3) {
        return new String(new byte[]{(byte) (i3 >> 24), (byte) (i3 >> 16), (byte) (i3 >> 8), (byte) i3}, StandardCharsets.US_ASCII);
    }

    static {
        String str = Build.DEVICE;
        String str2 = Build.MODEL;
        String str3 = Build.MANUFACTURER;
        int i3 = Build.VERSION.SDK_INT;
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 2 + String.valueOf(str2).length() + 2 + String.valueOf(str3).length() + 2 + String.valueOf(i3).length());
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(i3);
        zza = sb.toString();
        zzb = new byte[0];
        zzc = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        zze = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", wgbAZXYjrv.hbyZS, "zh-nan", "hsn", "zh-hsn"};
        zzf = new String[]{"i-lux", "lb", MrGIhy.KRMwChdJ, "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        zzg = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        zzh = new int[]{0, 4129, 8258, 12387, 16516, 20645, 24774, 28903, 33032, 37161, 41290, 45419, 49548, 53677, 57806, 61935};
        zzi = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, SensibleDefaults.X_OFFSET, 179, 186, 189, 199, 192, RCHTTPStatusCodes.CREATED, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, 135, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 149, 146, ModuleDescriptor.MODULE_VERSION, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};
    }
}
