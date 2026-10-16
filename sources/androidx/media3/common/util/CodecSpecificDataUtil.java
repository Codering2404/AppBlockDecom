package androidx.media3.common.util;

import android.util.Pair;
import androidx.glance.session.ecY.lisODU;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.common.collect.ImmutableList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public final class CodecSpecificDataUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f41486a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f41487b = {"", "A", "B", "C"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f41488c = Pattern.compile("^\\D?(\\d+)$");

    private static int a(int i3) {
        switch (i3) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            case 8:
                return Function.MAX_NARGS;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return Utility.DEFAULT_STREAM_BUFFER_SIZE;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    private static int b(int i3) {
        switch (i3) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i3) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                    default:
                        switch (i3) {
                            case 30:
                                return Function.MAX_NARGS;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i3) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return Utility.DEFAULT_STREAM_BUFFER_SIZE;
                                    default:
                                        switch (i3) {
                                            case 50:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    private static int c(int i3) {
        if (i3 == 66) {
            return 1;
        }
        if (i3 == 77) {
            return 2;
        }
        if (i3 == 88) {
            return 4;
        }
        if (i3 == 100) {
            return 8;
        }
        if (i3 == 110) {
            return 16;
        }
        if (i3 != 122) {
            return i3 != 244 ? -1 : 64;
        }
        return 32;
    }

    public static String d(int i3, int i4, int i5) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static List e(boolean z2) {
        return Collections.singletonList(z2 ? new byte[]{1} : new byte[]{0});
    }

    public static String f(int i3, int i4) {
        return Util.J("s263.%d.%d", Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public static String g(int i3, boolean z2, int i4, int i5, int[] iArr, int i6) {
        StringBuilder sb = new StringBuilder(Util.J("hvc1.%s%d.%X.%c%d", f41487b[i3], Integer.valueOf(i4), Integer.valueOf(i5), Character.valueOf(z2 ? 'H' : 'L'), Integer.valueOf(i6)));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i7 = 0; i7 < length; i7++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i7])));
        }
        return sb.toString();
    }

    public static byte[] h(byte[] bArr, int i3, int i4) {
        byte[] bArr2 = f41486a;
        byte[] bArr3 = new byte[bArr2.length + i4];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i3, bArr3, bArr2.length, i4);
        return bArr3;
    }

    public static ImmutableList i(byte b3, byte b4, byte b5, byte b6) {
        return ImmutableList.z(new byte[]{1, 1, b3, 2, 1, b4, 3, 1, b5, 4, 1, b6});
    }

    private static Integer j(String str) {
        if (str == null) {
            return null;
        }
        byte b3 = -1;
        switch (str.hashCode()) {
            case 1537:
                if (str.equals("01")) {
                    b3 = 0;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    b3 = 1;
                }
                break;
            case 1539:
                if (str.equals(CbYNFSEGaQj.gByMtSCudJLfWoy)) {
                    b3 = 2;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    b3 = 3;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    b3 = 4;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    b3 = 5;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    b3 = 6;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    b3 = 7;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    b3 = 8;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    b3 = 9;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    b3 = 10;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    b3 = Ascii.VT;
                }
                break;
            case 1570:
                if (str.equals("13")) {
                    b3 = Ascii.FF;
                }
                break;
        }
        switch (b3) {
        }
        return null;
    }

    private static Integer k(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    private static Pair l(String str, String[] strArr) {
        int iU;
        if (strArr.length != 3) {
            Log.i("CodecSpecificDataUtil", "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(MimeTypes.g(Integer.parseInt(strArr[1], 16))) && (iU = u(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair(Integer.valueOf(iU), 0);
            }
        } catch (NumberFormatException unused) {
            Log.i("CodecSpecificDataUtil", "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    private static Pair m(String str, String[] strArr, ColorInfo colorInfo) {
        int i3;
        if (strArr.length < 4) {
            Log.i("CodecSpecificDataUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        try {
            int i4 = Integer.parseInt(strArr[1]);
            int i5 = Integer.parseInt(strArr[2].substring(0, 2));
            int i6 = Integer.parseInt(strArr[3]);
            if (i4 != 0) {
                Log.i("CodecSpecificDataUtil", "Unknown AV1 profile: " + i4);
                return null;
            }
            if (i6 != 8 && i6 != 10) {
                Log.i("CodecSpecificDataUtil", "Unknown AV1 bit depth: " + i6);
                return null;
            }
            int i7 = i6 != 8 ? (colorInfo == null || !(colorInfo.f40557d != null || (i3 = colorInfo.f40556c) == 7 || i3 == 6)) ? 2 : 4096 : 1;
            int iA = a(i5);
            if (iA != -1) {
                return new Pair(Integer.valueOf(i7), Integer.valueOf(iA));
            }
            Log.i("CodecSpecificDataUtil", "Unknown AV1 level: " + i5);
            return null;
        } catch (NumberFormatException unused) {
            Log.i("CodecSpecificDataUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    private static Pair n(String str, String[] strArr) {
        int i3;
        int i4;
        if (strArr.length < 2) {
            Log.i("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i4 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i3 = Integer.parseInt(strArr[1].substring(4), 16);
            } else {
                if (strArr.length < 3) {
                    Log.i("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str);
                    return null;
                }
                int i5 = Integer.parseInt(strArr[1]);
                i3 = Integer.parseInt(strArr[2]);
                i4 = i5;
            }
            int iC = c(i4);
            if (iC == -1) {
                Log.i("CodecSpecificDataUtil", "Unknown AVC profile: " + i4);
                return null;
            }
            int iB = b(i3);
            if (iB != -1) {
                return new Pair(Integer.valueOf(iC), Integer.valueOf(iB));
            }
            Log.i("CodecSpecificDataUtil", "Unknown AVC level: " + i3);
            return null;
        } catch (NumberFormatException unused) {
            Log.i("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    public static Pair o(Format format) {
        String str = format.f40628k;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        if ("video/dolby-vision".equals(format.f40632o)) {
            return p(format.f40628k, strArrSplit);
        }
        String str2 = strArrSplit[0];
        str2.getClass();
        switch (str2) {
            case "av01":
                return m(format.f40628k, strArrSplit, format.C);
            case "avc1":
            case "avc2":
                return n(format.f40628k, strArrSplit);
            case "hev1":
            case "hvc1":
                return r(format.f40628k, strArrSplit, format.C);
            case "mp4a":
                return l(format.f40628k, strArrSplit);
            case "s263":
                return q(format.f40628k, strArrSplit);
            case "vp09":
                return s(format.f40628k, strArrSplit);
            default:
                return null;
        }
    }

    private static Pair p(String str, String[] strArr) {
        if (strArr.length < 3) {
            Log.i("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = f41488c.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.i("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        Integer numK = k(strGroup);
        if (numK == null) {
            Log.i("CodecSpecificDataUtil", "Unknown Dolby Vision profile string: " + strGroup);
            return null;
        }
        String str2 = strArr[2];
        Integer numJ = j(str2);
        if (numJ != null) {
            return new Pair(numK, numJ);
        }
        Log.i("CodecSpecificDataUtil", "Unknown Dolby Vision level string: " + str2);
        return null;
    }

    private static Pair q(String str, String[] strArr) {
        Pair pair = new Pair(1, 1);
        if (strArr.length < 3) {
            Log.i("CodecSpecificDataUtil", "Ignoring malformed H263 codec string: " + str);
            return pair;
        }
        try {
            return new Pair(Integer.valueOf(Integer.parseInt(strArr[1])), Integer.valueOf(Integer.parseInt(strArr[2])));
        } catch (NumberFormatException unused) {
            Log.i("CodecSpecificDataUtil", "Ignoring malformed H263 codec string: " + str);
            return pair;
        }
    }

    public static Pair r(String str, String[] strArr, ColorInfo colorInfo) {
        if (strArr.length < 4) {
            Log.i("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i3 = 1;
        Matcher matcher = f41488c.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.i("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        if (!AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(strGroup)) {
            i3 = 6;
            if ("2".equals(strGroup)) {
                i3 = (colorInfo == null || colorInfo.f40556c != 6) ? 2 : 4096;
            } else if (!"6".equals(strGroup)) {
                Log.i("CodecSpecificDataUtil", "Unknown HEVC profile string: " + strGroup);
                return null;
            }
        }
        String str2 = strArr[3];
        Integer numT = t(str2);
        if (numT != null) {
            return new Pair(Integer.valueOf(i3), numT);
        }
        Log.i("CodecSpecificDataUtil", "Unknown HEVC level string: " + str2);
        return null;
    }

    private static Pair s(String str, String[] strArr) {
        if (strArr.length < 3) {
            Log.i("CodecSpecificDataUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int i3 = Integer.parseInt(strArr[1]);
            int i4 = Integer.parseInt(strArr[2]);
            int iY = y(i3);
            if (iY == -1) {
                Log.i("CodecSpecificDataUtil", "Unknown VP9 profile: " + i3);
                return null;
            }
            int iX = x(i4);
            if (iX != -1) {
                return new Pair(Integer.valueOf(iY), Integer.valueOf(iX));
            }
            Log.i("CodecSpecificDataUtil", "Unknown VP9 level: " + i4);
            return null;
        } catch (NumberFormatException unused) {
            Log.i("CodecSpecificDataUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }

    private static Integer t(String str) {
        if (str == null) {
            return null;
        }
        byte b3 = -1;
        switch (str.hashCode()) {
            case 70821:
                if (str.equals("H30")) {
                    b3 = 0;
                }
                break;
            case 70914:
                if (str.equals("H60")) {
                    b3 = 1;
                }
                break;
            case 70917:
                if (str.equals("H63")) {
                    b3 = 2;
                }
                break;
            case 71007:
                if (str.equals("H90")) {
                    b3 = 3;
                }
                break;
            case 71010:
                if (str.equals("H93")) {
                    b3 = 4;
                }
                break;
            case 74665:
                if (str.equals("L30")) {
                    b3 = 5;
                }
                break;
            case 74758:
                if (str.equals("L60")) {
                    b3 = 6;
                }
                break;
            case 74761:
                if (str.equals("L63")) {
                    b3 = 7;
                }
                break;
            case 74851:
                if (str.equals("L90")) {
                    b3 = 8;
                }
                break;
            case 74854:
                if (str.equals("L93")) {
                    b3 = 9;
                }
                break;
            case 2193639:
                if (str.equals("H120")) {
                    b3 = 10;
                }
                break;
            case 2193642:
                if (str.equals("H123")) {
                    b3 = Ascii.VT;
                }
                break;
            case 2193732:
                if (str.equals("H150")) {
                    b3 = Ascii.FF;
                }
                break;
            case 2193735:
                if (str.equals("H153")) {
                    b3 = Ascii.CR;
                }
                break;
            case 2193738:
                if (str.equals("H156")) {
                    b3 = Ascii.SO;
                }
                break;
            case 2193825:
                if (str.equals("H180")) {
                    b3 = Ascii.SI;
                }
                break;
            case 2193828:
                if (str.equals("H183")) {
                    b3 = 16;
                }
                break;
            case 2193831:
                if (str.equals("H186")) {
                    b3 = 17;
                }
                break;
            case 2312803:
                if (str.equals("L120")) {
                    b3 = Ascii.DC2;
                }
                break;
            case 2312806:
                if (str.equals("L123")) {
                    b3 = 19;
                }
                break;
            case 2312896:
                if (str.equals("L150")) {
                    b3 = Ascii.DC4;
                }
                break;
            case 2312899:
                if (str.equals(lisODU.dTIXxgaxRu)) {
                    b3 = Ascii.NAK;
                }
                break;
            case 2312902:
                if (str.equals("L156")) {
                    b3 = Ascii.SYN;
                }
                break;
            case 2312989:
                if (str.equals("L180")) {
                    b3 = Ascii.ETB;
                }
                break;
            case 2312992:
                if (str.equals("L183")) {
                    b3 = Ascii.CAN;
                }
                break;
            case 2312995:
                if (str.equals("L186")) {
                    b3 = Ascii.EM;
                }
                break;
        }
        switch (b3) {
        }
        return null;
    }

    private static int u(int i3) {
        int i4 = 17;
        if (i3 != 17) {
            i4 = 20;
            if (i3 != 20) {
                i4 = 23;
                if (i3 != 23) {
                    i4 = 29;
                    if (i3 != 29) {
                        i4 = 39;
                        if (i3 != 39) {
                            i4 = 42;
                            if (i3 != 42) {
                                switch (i3) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i4;
    }

    public static Pair v(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        parsableByteArray.W(9);
        int iH = parsableByteArray.H();
        parsableByteArray.W(20);
        return Pair.create(Integer.valueOf(parsableByteArray.L()), Integer.valueOf(iH));
    }

    public static boolean w(List list) {
        return list.size() == 1 && ((byte[]) list.get(0)).length == 1 && ((byte[]) list.get(0))[0] == 1;
    }

    private static int x(int i3) {
        if (i3 == 10) {
            return 1;
        }
        if (i3 == 11) {
            return 2;
        }
        if (i3 == 20) {
            return 4;
        }
        if (i3 == 21) {
            return 8;
        }
        if (i3 == 30) {
            return 16;
        }
        if (i3 == 31) {
            return 32;
        }
        if (i3 == 40) {
            return 64;
        }
        if (i3 == 41) {
            return ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (i3 == 50) {
            return Function.MAX_NARGS;
        }
        if (i3 == 51) {
            return 512;
        }
        switch (i3) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return Utility.DEFAULT_STREAM_BUFFER_SIZE;
            default:
                return -1;
        }
    }

    private static int y(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 2;
        }
        if (i3 != 2) {
            return i3 != 3 ? -1 : 8;
        }
        return 4;
    }
}
