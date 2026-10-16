package androidx.media3.exoplayer.upstream;

import android.content.Context;
import android.os.Handler;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BackgroundExecutor;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ImmutableList f45500r = ImmutableList.D(4300000L, 3200000L, 2400000L, 1700000L, 860000L);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ImmutableList f45501s = ImmutableList.D(1500000L, 980000L, 750000L, 520000L, 290000L);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ImmutableList f45502t = ImmutableList.D(2000000L, 1300000L, 1000000L, 860000L, 610000L);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ImmutableList f45503u = ImmutableList.D(2500000L, 1700000L, 1200000L, 970000L, 680000L);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ImmutableList f45504v = ImmutableList.D(4700000L, 2800000L, 2100000L, 1700000L, 980000L);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ImmutableList f45505w = ImmutableList.D(2700000L, 2000000L, 1600000L, 1300000L, 1000000L);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static DefaultBandwidthMeter f45506x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f45507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImmutableMap f45508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BandwidthMeter.EventListener.EventDispatcher f45509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Clock f45510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f45511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SlidingPercentile f45512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f45513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f45514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f45515i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f45516j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f45517k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f45518l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f45519m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f45520n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f45521o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f45522p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f45523q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f45524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f45525b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f45526c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Clock f45527d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f45528e;

        public Builder(Context context) {
            this.f45524a = context == null ? null : context.getApplicationContext();
            this.f45526c = AdError.SERVER_ERROR_CODE;
            this.f45527d = Clock.f41485a;
            this.f45528e = true;
            HashMap map = new HashMap(8);
            this.f45525b = map;
            map.put(0, 1000000L);
            map.put(2, -9223372036854775807L);
            map.put(3, -9223372036854775807L);
            map.put(4, -9223372036854775807L);
            map.put(5, -9223372036854775807L);
            map.put(10, -9223372036854775807L);
            map.put(9, -9223372036854775807L);
            map.put(7, -9223372036854775807L);
        }

        public DefaultBandwidthMeter a() {
            return new DefaultBandwidthMeter(this.f45524a, this.f45525b, this.f45526c, this.f45527d, this.f45528e);
        }
    }

    private static int[] i(String str) {
        str.getClass();
        byte b3 = -1;
        switch (str.hashCode()) {
            case 2083:
                if (str.equals("AD")) {
                    b3 = 0;
                }
                break;
            case 2084:
                if (str.equals("AE")) {
                    b3 = 1;
                }
                break;
            case 2085:
                if (str.equals("AF")) {
                    b3 = 2;
                }
                break;
            case 2086:
                if (str.equals("AG")) {
                    b3 = 3;
                }
                break;
            case 2088:
                if (str.equals("AI")) {
                    b3 = 4;
                }
                break;
            case 2091:
                if (str.equals("AL")) {
                    b3 = 5;
                }
                break;
            case 2092:
                if (str.equals("AM")) {
                    b3 = 6;
                }
                break;
            case 2094:
                if (str.equals("AO")) {
                    b3 = 7;
                }
                break;
            case 2096:
                if (str.equals("AQ")) {
                    b3 = 8;
                }
                break;
            case 2097:
                if (str.equals("AR")) {
                    b3 = 9;
                }
                break;
            case 2098:
                if (str.equals("AS")) {
                    b3 = 10;
                }
                break;
            case 2099:
                if (str.equals("AT")) {
                    b3 = Ascii.VT;
                }
                break;
            case AdError.BROKEN_MEDIA_ERROR_CODE /* 2100 */:
                if (str.equals("AU")) {
                    b3 = Ascii.FF;
                }
                break;
            case 2102:
                if (str.equals("AW")) {
                    b3 = Ascii.CR;
                }
                break;
            case 2103:
                if (str.equals("AX")) {
                    b3 = Ascii.SO;
                }
                break;
            case 2105:
                if (str.equals("AZ")) {
                    b3 = Ascii.SI;
                }
                break;
            case 2111:
                if (str.equals("BA")) {
                    b3 = Ascii.DLE;
                }
                break;
            case 2112:
                if (str.equals("BB")) {
                    b3 = 17;
                }
                break;
            case 2114:
                if (str.equals("BD")) {
                    b3 = Ascii.DC2;
                }
                break;
            case 2115:
                if (str.equals("BE")) {
                    b3 = 19;
                }
                break;
            case 2116:
                if (str.equals("BF")) {
                    b3 = Ascii.DC4;
                }
                break;
            case 2117:
                if (str.equals("BG")) {
                    b3 = Ascii.NAK;
                }
                break;
            case 2118:
                if (str.equals("BH")) {
                    b3 = Ascii.SYN;
                }
                break;
            case 2119:
                if (str.equals("BI")) {
                    b3 = Ascii.ETB;
                }
                break;
            case 2120:
                if (str.equals("BJ")) {
                    b3 = Ascii.CAN;
                }
                break;
            case 2122:
                if (str.equals("BL")) {
                    b3 = Ascii.EM;
                }
                break;
            case 2123:
                if (str.equals("BM")) {
                    b3 = Ascii.SUB;
                }
                break;
            case 2124:
                if (str.equals("BN")) {
                    b3 = Ascii.ESC;
                }
                break;
            case 2125:
                if (str.equals("BO")) {
                    b3 = Ascii.FS;
                }
                break;
            case 2127:
                if (str.equals("BQ")) {
                    b3 = Ascii.GS;
                }
                break;
            case 2128:
                if (str.equals("BR")) {
                    b3 = Ascii.RS;
                }
                break;
            case 2129:
                if (str.equals("BS")) {
                    b3 = Ascii.US;
                }
                break;
            case 2130:
                if (str.equals("BT")) {
                    b3 = 32;
                }
                break;
            case 2133:
                if (str.equals("BW")) {
                    b3 = Framer.ENTER_FRAME_PREFIX;
                }
                break;
            case 2135:
                if (str.equals("BY")) {
                    b3 = 34;
                }
                break;
            case 2136:
                if (str.equals("BZ")) {
                    b3 = 35;
                }
                break;
            case 2142:
                if (str.equals("CA")) {
                    b3 = 36;
                }
                break;
            case 2145:
                if (str.equals("CD")) {
                    b3 = 37;
                }
                break;
            case 2147:
                if (str.equals("CF")) {
                    b3 = 38;
                }
                break;
            case 2148:
                if (str.equals("CG")) {
                    b3 = 39;
                }
                break;
            case 2149:
                if (str.equals("CH")) {
                    b3 = 40;
                }
                break;
            case 2150:
                if (str.equals("CI")) {
                    b3 = 41;
                }
                break;
            case 2152:
                if (str.equals("CK")) {
                    b3 = 42;
                }
                break;
            case 2153:
                if (str.equals("CL")) {
                    b3 = 43;
                }
                break;
            case 2154:
                if (str.equals("CM")) {
                    b3 = 44;
                }
                break;
            case 2155:
                if (str.equals("CN")) {
                    b3 = Framer.STDIN_FRAME_PREFIX;
                }
                break;
            case 2156:
                if (str.equals("CO")) {
                    b3 = 46;
                }
                break;
            case 2159:
                if (str.equals("CR")) {
                    b3 = 47;
                }
                break;
            case 2162:
                if (str.equals("CU")) {
                    b3 = 48;
                }
                break;
            case 2163:
                if (str.equals("CV")) {
                    b3 = Framer.STDOUT_FRAME_PREFIX;
                }
                break;
            case 2164:
                if (str.equals("CW")) {
                    b3 = Framer.STDERR_FRAME_PREFIX;
                }
                break;
            case 2165:
                if (str.equals("CX")) {
                    b3 = 51;
                }
                break;
            case 2166:
                if (str.equals("CY")) {
                    b3 = 52;
                }
                break;
            case 2167:
                if (str.equals("CZ")) {
                    b3 = 53;
                }
                break;
            case 2177:
                if (str.equals("DE")) {
                    b3 = 54;
                }
                break;
            case 2182:
                if (str.equals("DJ")) {
                    b3 = 55;
                }
                break;
            case 2183:
                if (str.equals("DK")) {
                    b3 = 56;
                }
                break;
            case 2185:
                if (str.equals("DM")) {
                    b3 = 57;
                }
                break;
            case 2187:
                if (str.equals("DO")) {
                    b3 = 58;
                }
                break;
            case 2198:
                if (str.equals("DZ")) {
                    b3 = 59;
                }
                break;
            case 2206:
                if (str.equals("EC")) {
                    b3 = 60;
                }
                break;
            case 2208:
                if (str.equals("EE")) {
                    b3 = 61;
                }
                break;
            case 2210:
                if (str.equals("EG")) {
                    b3 = 62;
                }
                break;
            case 2221:
                if (str.equals("ER")) {
                    b3 = 63;
                }
                break;
            case 2222:
                if (str.equals("ES")) {
                    b3 = 64;
                }
                break;
            case 2223:
                if (str.equals("ET")) {
                    b3 = 65;
                }
                break;
            case 2243:
                if (str.equals("FI")) {
                    b3 = 66;
                }
                break;
            case 2244:
                if (str.equals("FJ")) {
                    b3 = 67;
                }
                break;
            case 2245:
                if (str.equals("FK")) {
                    b3 = 68;
                }
                break;
            case 2247:
                if (str.equals("FM")) {
                    b3 = 69;
                }
                break;
            case 2249:
                if (str.equals("FO")) {
                    b3 = 70;
                }
                break;
            case 2252:
                if (str.equals("FR")) {
                    b3 = 71;
                }
                break;
            case 2266:
                if (str.equals("GA")) {
                    b3 = 72;
                }
                break;
            case 2267:
                if (str.equals("GB")) {
                    b3 = 73;
                }
                break;
            case 2269:
                if (str.equals("GD")) {
                    b3 = 74;
                }
                break;
            case 2270:
                if (str.equals("GE")) {
                    b3 = 75;
                }
                break;
            case 2271:
                if (str.equals("GF")) {
                    b3 = 76;
                }
                break;
            case 2272:
                if (str.equals("GG")) {
                    b3 = 77;
                }
                break;
            case 2273:
                if (str.equals("GH")) {
                    b3 = 78;
                }
                break;
            case 2274:
                if (str.equals("GI")) {
                    b3 = 79;
                }
                break;
            case 2277:
                if (str.equals("GL")) {
                    b3 = 80;
                }
                break;
            case 2278:
                if (str.equals("GM")) {
                    b3 = 81;
                }
                break;
            case 2279:
                if (str.equals("GN")) {
                    b3 = 82;
                }
                break;
            case 2281:
                if (str.equals("GP")) {
                    b3 = 83;
                }
                break;
            case 2282:
                if (str.equals("GQ")) {
                    b3 = 84;
                }
                break;
            case 2283:
                if (str.equals("GR")) {
                    b3 = 85;
                }
                break;
            case 2285:
                if (str.equals("GT")) {
                    b3 = 86;
                }
                break;
            case 2286:
                if (str.equals("GU")) {
                    b3 = 87;
                }
                break;
            case 2288:
                if (str.equals("GW")) {
                    b3 = 88;
                }
                break;
            case 2290:
                if (str.equals("GY")) {
                    b3 = 89;
                }
                break;
            case 2307:
                if (str.equals("HK")) {
                    b3 = 90;
                }
                break;
            case 2314:
                if (str.equals("HR")) {
                    b3 = 91;
                }
                break;
            case 2316:
                if (str.equals("HT")) {
                    b3 = 92;
                }
                break;
            case 2317:
                if (str.equals("HU")) {
                    b3 = 93;
                }
                break;
            case 2331:
                if (str.equals("ID")) {
                    b3 = 94;
                }
                break;
            case 2332:
                if (str.equals("IE")) {
                    b3 = Framer.STDIN_REQUEST_FRAME_PREFIX;
                }
                break;
            case 2339:
                if (str.equals("IL")) {
                    b3 = 96;
                }
                break;
            case 2340:
                if (str.equals("IM")) {
                    b3 = 97;
                }
                break;
            case 2341:
                if (str.equals("IN")) {
                    b3 = 98;
                }
                break;
            case 2342:
                if (str.equals("IO")) {
                    b3 = 99;
                }
                break;
            case 2344:
                if (str.equals("IQ")) {
                    b3 = 100;
                }
                break;
            case 2345:
                if (str.equals("IR")) {
                    b3 = 101;
                }
                break;
            case 2346:
                if (str.equals("IS")) {
                    b3 = 102;
                }
                break;
            case 2347:
                if (str.equals("IT")) {
                    b3 = 103;
                }
                break;
            case 2363:
                if (str.equals("JE")) {
                    b3 = 104;
                }
                break;
            case 2371:
                if (str.equals("JM")) {
                    b3 = 105;
                }
                break;
            case 2373:
                if (str.equals("JO")) {
                    b3 = 106;
                }
                break;
            case 2374:
                if (str.equals("JP")) {
                    b3 = 107;
                }
                break;
            case 2394:
                if (str.equals("KE")) {
                    b3 = 108;
                }
                break;
            case 2396:
                if (str.equals("KG")) {
                    b3 = 109;
                }
                break;
            case 2397:
                if (str.equals("KH")) {
                    b3 = 110;
                }
                break;
            case 2398:
                if (str.equals("KI")) {
                    b3 = 111;
                }
                break;
            case 2402:
                if (str.equals("KM")) {
                    b3 = 112;
                }
                break;
            case 2403:
                if (str.equals("KN")) {
                    b3 = 113;
                }
                break;
            case 2407:
                if (str.equals("KR")) {
                    b3 = 114;
                }
                break;
            case 2412:
                if (str.equals("KW")) {
                    b3 = 115;
                }
                break;
            case 2414:
                if (str.equals("KY")) {
                    b3 = 116;
                }
                break;
            case 2415:
                if (str.equals(sKeKFMqmvNzY.rzAdoPbzsHQ)) {
                    b3 = 117;
                }
                break;
            case 2421:
                if (str.equals("LA")) {
                    b3 = 118;
                }
                break;
            case 2422:
                if (str.equals("LB")) {
                    b3 = 119;
                }
                break;
            case 2423:
                if (str.equals("LC")) {
                    b3 = Framer.EXIT_FRAME_PREFIX;
                }
                break;
            case 2429:
                if (str.equals("LI")) {
                    b3 = 121;
                }
                break;
            case 2431:
                if (str.equals("LK")) {
                    b3 = 122;
                }
                break;
            case 2438:
                if (str.equals("LR")) {
                    b3 = 123;
                }
                break;
            case 2439:
                if (str.equals("LS")) {
                    b3 = 124;
                }
                break;
            case 2440:
                if (str.equals("LT")) {
                    b3 = 125;
                }
                break;
            case 2441:
                if (str.equals("LU")) {
                    b3 = 126;
                }
                break;
            case 2442:
                if (str.equals("LV")) {
                    b3 = Ascii.DEL;
                }
                break;
            case 2445:
                if (str.equals("LY")) {
                    b3 = 128;
                }
                break;
            case 2452:
                if (str.equals("MA")) {
                    b3 = 129;
                }
                break;
            case 2454:
                if (str.equals("MC")) {
                    b3 = 130;
                }
                break;
            case 2455:
                if (str.equals("MD")) {
                    b3 = 131;
                }
                break;
            case 2456:
                if (str.equals("ME")) {
                    b3 = 132;
                }
                break;
            case 2457:
                if (str.equals("MF")) {
                    b3 = 133;
                }
                break;
            case 2458:
                if (str.equals("MG")) {
                    b3 = 134;
                }
                break;
            case 2459:
                if (str.equals("MH")) {
                    b3 = 135;
                }
                break;
            case 2462:
                if (str.equals("MK")) {
                    b3 = 136;
                }
                break;
            case 2463:
                if (str.equals("ML")) {
                    b3 = 137;
                }
                break;
            case 2464:
                if (str.equals("MM")) {
                    b3 = 138;
                }
                break;
            case 2465:
                if (str.equals("MN")) {
                    b3 = 139;
                }
                break;
            case 2466:
                if (str.equals("MO")) {
                    b3 = 140;
                }
                break;
            case 2467:
                if (str.equals("MP")) {
                    b3 = 141;
                }
                break;
            case 2468:
                if (str.equals("MQ")) {
                    b3 = 142;
                }
                break;
            case 2469:
                if (str.equals("MR")) {
                    b3 = 143;
                }
                break;
            case 2470:
                if (str.equals("MS")) {
                    b3 = 144;
                }
                break;
            case 2471:
                if (str.equals("MT")) {
                    b3 = 145;
                }
                break;
            case 2472:
                if (str.equals("MU")) {
                    b3 = 146;
                }
                break;
            case 2473:
                if (str.equals("MV")) {
                    b3 = 147;
                }
                break;
            case 2474:
                if (str.equals("MW")) {
                    b3 = 148;
                }
                break;
            case 2475:
                if (str.equals("MX")) {
                    b3 = 149;
                }
                break;
            case 2476:
                if (str.equals("MY")) {
                    b3 = 150;
                }
                break;
            case 2477:
                if (str.equals("MZ")) {
                    b3 = 151;
                }
                break;
            case 2483:
                if (str.equals("NA")) {
                    b3 = 152;
                }
                break;
            case 2485:
                if (str.equals("NC")) {
                    b3 = 153;
                }
                break;
            case 2487:
                if (str.equals("NE")) {
                    b3 = 154;
                }
                break;
            case 2488:
                if (str.equals("NF")) {
                    b3 = 155;
                }
                break;
            case 2489:
                if (str.equals("NG")) {
                    b3 = 156;
                }
                break;
            case 2491:
                if (str.equals("NI")) {
                    b3 = 157;
                }
                break;
            case 2494:
                if (str.equals("NL")) {
                    b3 = 158;
                }
                break;
            case 2497:
                if (str.equals("NO")) {
                    b3 = 159;
                }
                break;
            case 2498:
                if (str.equals("NP")) {
                    b3 = 160;
                }
                break;
            case 2500:
                if (str.equals("NR")) {
                    b3 = 161;
                }
                break;
            case 2503:
                if (str.equals("NU")) {
                    b3 = 162;
                }
                break;
            case 2508:
                if (str.equals("NZ")) {
                    b3 = 163;
                }
                break;
            case 2526:
                if (str.equals("OM")) {
                    b3 = 164;
                }
                break;
            case 2545:
                if (str.equals("PA")) {
                    b3 = 165;
                }
                break;
            case 2549:
                if (str.equals("PE")) {
                    b3 = 166;
                }
                break;
            case 2550:
                if (str.equals("PF")) {
                    b3 = 167;
                }
                break;
            case 2551:
                if (str.equals("PG")) {
                    b3 = 168;
                }
                break;
            case 2552:
                if (str.equals("PH")) {
                    b3 = 169;
                }
                break;
            case 2555:
                if (str.equals("PK")) {
                    b3 = 170;
                }
                break;
            case 2556:
                if (str.equals("PL")) {
                    b3 = 171;
                }
                break;
            case 2557:
                if (str.equals("PM")) {
                    b3 = 172;
                }
                break;
            case 2562:
                if (str.equals("PR")) {
                    b3 = 173;
                }
                break;
            case 2563:
                if (str.equals("PS")) {
                    b3 = 174;
                }
                break;
            case 2564:
                if (str.equals("PT")) {
                    b3 = 175;
                }
                break;
            case 2567:
                if (str.equals("PW")) {
                    b3 = 176;
                }
                break;
            case 2569:
                if (str.equals("PY")) {
                    b3 = 177;
                }
                break;
            case 2576:
                if (str.equals("QA")) {
                    b3 = 178;
                }
                break;
            case 2611:
                if (str.equals("RE")) {
                    b3 = 179;
                }
                break;
            case 2621:
                if (str.equals("RO")) {
                    b3 = 180;
                }
                break;
            case 2625:
                if (str.equals("RS")) {
                    b3 = 181;
                }
                break;
            case 2627:
                if (str.equals("RU")) {
                    b3 = 182;
                }
                break;
            case 2629:
                if (str.equals("RW")) {
                    b3 = 183;
                }
                break;
            case 2638:
                if (str.equals("SA")) {
                    b3 = 184;
                }
                break;
            case 2639:
                if (str.equals("SB")) {
                    b3 = 185;
                }
                break;
            case 2640:
                if (str.equals("SC")) {
                    b3 = 186;
                }
                break;
            case 2641:
                if (str.equals("SD")) {
                    b3 = 187;
                }
                break;
            case 2642:
                if (str.equals("SE")) {
                    b3 = 188;
                }
                break;
            case 2644:
                if (str.equals("SG")) {
                    b3 = 189;
                }
                break;
            case 2645:
                if (str.equals("SH")) {
                    b3 = 190;
                }
                break;
            case 2646:
                if (str.equals("SI")) {
                    b3 = 191;
                }
                break;
            case 2647:
                if (str.equals("SJ")) {
                    b3 = 192;
                }
                break;
            case 2648:
                if (str.equals("SK")) {
                    b3 = 193;
                }
                break;
            case 2649:
                if (str.equals("SL")) {
                    b3 = 194;
                }
                break;
            case 2650:
                if (str.equals("SM")) {
                    b3 = 195;
                }
                break;
            case 2651:
                if (str.equals("SN")) {
                    b3 = 196;
                }
                break;
            case 2652:
                if (str.equals("SO")) {
                    b3 = 197;
                }
                break;
            case 2655:
                if (str.equals("SR")) {
                    b3 = 198;
                }
                break;
            case 2656:
                if (str.equals("SS")) {
                    b3 = 199;
                }
                break;
            case 2657:
                if (str.equals("ST")) {
                    b3 = 200;
                }
                break;
            case 2659:
                if (str.equals("SV")) {
                    b3 = 201;
                }
                break;
            case 2661:
                if (str.equals("SX")) {
                    b3 = 202;
                }
                break;
            case 2662:
                if (str.equals("SY")) {
                    b3 = 203;
                }
                break;
            case 2663:
                if (str.equals("SZ")) {
                    b3 = 204;
                }
                break;
            case 2671:
                if (str.equals("TC")) {
                    b3 = 205;
                }
                break;
            case 2672:
                if (str.equals("TD")) {
                    b3 = 206;
                }
                break;
            case 2675:
                if (str.equals("TG")) {
                    b3 = 207;
                }
                break;
            case 2676:
                if (str.equals("TH")) {
                    b3 = 208;
                }
                break;
            case 2678:
                if (str.equals("TJ")) {
                    b3 = 209;
                }
                break;
            case 2680:
                if (str.equals("TL")) {
                    b3 = 210;
                }
                break;
            case 2681:
                if (str.equals("TM")) {
                    b3 = 211;
                }
                break;
            case 2682:
                if (str.equals("TN")) {
                    b3 = 212;
                }
                break;
            case 2683:
                if (str.equals("TO")) {
                    b3 = 213;
                }
                break;
            case 2686:
                if (str.equals("TR")) {
                    b3 = 214;
                }
                break;
            case 2688:
                if (str.equals("TT")) {
                    b3 = 215;
                }
                break;
            case 2690:
                if (str.equals("TV")) {
                    b3 = 216;
                }
                break;
            case 2691:
                if (str.equals("TW")) {
                    b3 = 217;
                }
                break;
            case 2694:
                if (str.equals("TZ")) {
                    b3 = 218;
                }
                break;
            case 2700:
                if (str.equals("UA")) {
                    b3 = 219;
                }
                break;
            case 2706:
                if (str.equals("UG")) {
                    b3 = 220;
                }
                break;
            case 2718:
                if (str.equals("US")) {
                    b3 = 221;
                }
                break;
            case 2724:
                if (str.equals("UY")) {
                    b3 = 222;
                }
                break;
            case 2725:
                if (str.equals("UZ")) {
                    b3 = 223;
                }
                break;
            case 2731:
                if (str.equals("VA")) {
                    b3 = 224;
                }
                break;
            case 2733:
                if (str.equals("VC")) {
                    b3 = 225;
                }
                break;
            case 2735:
                if (str.equals("VE")) {
                    b3 = 226;
                }
                break;
            case 2737:
                if (str.equals("VG")) {
                    b3 = 227;
                }
                break;
            case 2739:
                if (str.equals("VI")) {
                    b3 = 228;
                }
                break;
            case 2744:
                if (str.equals("VN")) {
                    b3 = 229;
                }
                break;
            case 2751:
                if (str.equals("VU")) {
                    b3 = 230;
                }
                break;
            case 2767:
                if (str.equals("WF")) {
                    b3 = 231;
                }
                break;
            case 2780:
                if (str.equals("WS")) {
                    b3 = 232;
                }
                break;
            case 2803:
                if (str.equals("XK")) {
                    b3 = 233;
                }
                break;
            case 2828:
                if (str.equals("YE")) {
                    b3 = 234;
                }
                break;
            case 2843:
                if (str.equals("YT")) {
                    b3 = 235;
                }
                break;
            case 2855:
                if (str.equals("ZA")) {
                    b3 = 236;
                }
                break;
            case 2867:
                if (str.equals("ZM")) {
                    b3 = 237;
                }
                break;
            case 2877:
                if (str.equals("ZW")) {
                    b3 = 238;
                }
                break;
        }
        switch (b3) {
            case 0:
            case 4:
            case 17:
            case 29:
            case 50:
            case 57:
            case 113:
            case 116:
            case 202:
            case 225:
                return new int[]{1, 2, 0, 0, 2, 2};
            case 1:
                return new int[]{1, 4, 2, 3, 4, 1};
            case 2:
            case 204:
                return new int[]{4, 4, 3, 4, 2, 2};
            case 3:
            case 41:
                return new int[]{2, 4, 3, 4, 2, 2};
            case 5:
                return new int[]{1, 1, 1, 2, 2, 2};
            case 6:
            case 165:
                return new int[]{2, 3, 2, 3, 2, 2};
            case 7:
                return new int[]{3, 4, 4, 3, 2, 2};
            case 8:
            case 63:
            case 162:
            case 186:
            case FacebookRequestErrorClassification.EC_INVALID_TOKEN /* 190 */:
                return new int[]{4, 2, 2, 2, 2, 2};
            case 9:
                return new int[]{2, 2, 2, 2, 1, 2};
            case 10:
                return new int[]{2, 2, 3, 3, 2, 2};
            case 11:
            case 61:
            case 93:
            case 102:
            case 127:
            case 145:
            case 188:
                return new int[]{0, 0, 0, 0, 0, 2};
            case 12:
                return new int[]{0, 3, 1, 1, 3, 0};
            case 13:
                return new int[]{2, 2, 3, 4, 2, 2};
            case 14:
            case 51:
            case 121:
            case 144:
            case 172:
            case 195:
            case 224:
                return new int[]{0, 2, 2, 2, 2, 2};
            case 15:
            case 55:
            case ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD /* 128 */:
            case 194:
                return new int[]{4, 2, 3, 3, 2, 2};
            case 16:
            case 106:
            case 214:
                return new int[]{1, 1, 1, 1, 2, 2};
            case 18:
                return new int[]{2, 1, 3, 2, 4, 2};
            case 19:
                return new int[]{0, 0, 1, 0, 1, 2};
            case 20:
            case 187:
            case 203:
            case 206:
                return new int[]{4, 3, 4, 4, 2, 2};
            case 21:
            case 175:
            case 191:
                return new int[]{0, 0, 0, 0, 1, 2};
            case 22:
                return new int[]{1, 3, 1, 3, 4, 2};
            case 23:
            case 84:
            case 92:
            case 154:
            case 226:
            case 234:
                return new int[]{4, 4, 4, 4, 2, 2};
            case 24:
                return new int[]{4, 4, 2, 3, 2, 2};
            case 25:
            case 141:
            case 177:
                return new int[]{1, 2, 2, 2, 2, 2};
            case 26:
                return new int[]{0, 2, 0, 0, 2, 2};
            case 27:
                return new int[]{3, 2, 0, 0, 2, 2};
            case 28:
                return new int[]{1, 2, 4, 4, 2, 2};
            case 30:
                return new int[]{1, 1, 1, 1, 2, 4};
            case 31:
                return new int[]{3, 2, 1, 1, 2, 2};
            case 32:
                return new int[]{3, 1, 2, 2, 3, 2};
            case 33:
                return new int[]{3, 2, 1, 0, 2, 2};
            case 34:
                return new int[]{1, 2, 3, 3, 2, 2};
            case 35:
            case 42:
                return new int[]{2, 2, 2, 1, 2, 2};
            case 36:
            case 219:
                return new int[]{0, 2, 1, 2, 3, 3};
            case 37:
            case 137:
                return new int[]{3, 3, 2, 2, 2, 2};
            case 38:
                return new int[]{4, 2, 4, 2, 2, 2};
            case 39:
            case 62:
            case 134:
                return new int[]{3, 4, 3, 3, 2, 2};
            case 40:
                return new int[]{0, 1, 0, 0, 0, 2};
            case 43:
            case 208:
                return new int[]{0, 1, 2, 2, 2, 2};
            case 44:
            case 143:
                return new int[]{4, 3, 3, 4, 2, 2};
            case 45:
                return new int[]{2, 0, 1, 1, 3, 1};
            case 46:
                return new int[]{2, 3, 3, 2, 2, 2};
            case 47:
            case 157:
                return new int[]{2, 4, 4, 4, 2, 2};
            case 48:
            case 111:
            case 161:
            case 210:
                return new int[]{4, 2, 4, 4, 2, 2};
            case 49:
                return new int[]{2, 3, 0, 1, 2, 2};
            case 52:
                return new int[]{1, 0, 1, 0, 0, 2};
            case 53:
                return new int[]{0, 0, 2, 0, 1, 2};
            case 54:
                return new int[]{0, 1, 4, 2, 2, 1};
            case 56:
                return new int[]{0, 0, 2, 0, 0, 2};
            case 58:
            case 123:
                return new int[]{3, 4, 4, 4, 2, 2};
            case 59:
            case 209:
                return new int[]{3, 3, 4, 4, 2, 2};
            case 60:
                return new int[]{1, 3, 2, 1, 2, 2};
            case 64:
                return new int[]{0, 0, 0, 0, 1, 0};
            case 65:
                return new int[]{4, 3, 4, 4, 4, 2};
            case 66:
                return new int[]{0, 0, 0, 1, 0, 2};
            case 67:
                return new int[]{3, 2, 2, 3, 2, 2};
            case 68:
            case ModuleDescriptor.MODULE_VERSION /* 155 */:
            case 192:
                return new int[]{3, 2, 2, 2, 2, 2};
            case 69:
                return new int[]{4, 2, 4, 0, 2, 2};
            case 70:
                return new int[]{0, 2, 2, 0, 2, 2};
            case 71:
                return new int[]{1, 1, 1, 1, 0, 2};
            case 72:
                return new int[]{3, 4, 0, 0, 2, 2};
            case 73:
                return new int[]{1, 1, 3, 2, 2, 2};
            case 74:
                return new int[]{2, 2, 0, 0, 2, 2};
            case 75:
                return new int[]{1, 1, 0, 2, 2, 2};
            case 76:
                return new int[]{3, 2, 3, 3, 2, 2};
            case 77:
                return new int[]{0, 2, 1, 1, 2, 2};
            case 78:
                return new int[]{3, 3, 3, 2, 2, 2};
            case 79:
            case 97:
            case 104:
                return new int[]{0, 2, 0, 1, 2, 2};
            case 80:
            case 130:
                return new int[]{1, 2, 2, 0, 2, 2};
            case 81:
            case 199:
                return new int[]{4, 3, 2, 4, 2, 2};
            case 82:
                return new int[]{3, 4, 4, 2, 2, 2};
            case 83:
                return new int[]{2, 1, 1, 3, 2, 2};
            case 85:
                return new int[]{1, 0, 0, 0, 1, 2};
            case 86:
                return new int[]{2, 1, 2, 1, 2, 2};
            case 87:
                return new int[]{2, 2, 4, 3, 3, 2};
            case 88:
                return new int[]{4, 4, 1, 2, 2, 2};
            case 89:
                return new int[]{3, 1, 1, 3, 2, 2};
            case 90:
                return new int[]{0, 1, 0, 1, 1, 0};
            case 91:
            case 115:
                return new int[]{1, 0, 0, 0, 0, 2};
            case 94:
                return new int[]{3, 1, 3, 3, 2, 4};
            case 95:
                return new int[]{1, 1, 1, 1, 1, 2};
            case 96:
                return new int[]{1, 2, 2, 3, 4, 2};
            case 98:
                return new int[]{1, 1, 3, 2, 2, 3};
            case 99:
                return new int[]{3, 2, 2, 0, 2, 2};
            case 100:
                return new int[]{3, 2, 3, 2, 2, 2};
            case 101:
                return new int[]{4, 2, 3, 3, 4, 3};
            case 103:
                return new int[]{0, 1, 1, 2, 1, 2};
            case 105:
                return new int[]{2, 4, 3, 1, 2, 2};
            case 107:
                return new int[]{0, 3, 2, 3, 4, 2};
            case 108:
                return new int[]{3, 2, 1, 1, 1, 2};
            case 109:
                return new int[]{2, 1, 1, 2, 2, 2};
            case 110:
                return new int[]{1, 0, 4, 2, 2, 2};
            case 112:
            case 230:
                return new int[]{4, 3, 3, 2, 2, 2};
            case 114:
                return new int[]{0, 2, 2, 4, 4, 4};
            case 117:
                return new int[]{2, 1, 2, 2, 3, 2};
            case 118:
                return new int[]{1, 2, 1, 3, 2, 2};
            case 119:
                return new int[]{3, 1, 1, 2, 2, 2};
            case 120:
                return new int[]{2, 2, 1, 1, 2, 2};
            case 122:
            case 138:
                return new int[]{3, 2, 3, 3, 4, 2};
            case 124:
            case 168:
                return new int[]{4, 3, 3, 3, 2, 2};
            case 125:
                return new int[]{0, 1, 0, 1, 0, 2};
            case 126:
                return new int[]{4, 0, 3, 2, 1, 3};
            case 129:
                return new int[]{3, 3, 1, 1, 2, 2};
            case 131:
                return new int[]{1, 0, 0, 0, 2, 2};
            case 132:
                return new int[]{2, 0, 0, 1, 3, 2};
            case 133:
                return new int[]{1, 2, 2, 3, 2, 2};
            case 135:
            case 211:
            case 216:
            case 231:
                return new int[]{4, 2, 2, 4, 2, 2};
            case 136:
                return new int[]{1, 0, 0, 1, 3, 2};
            case 139:
                return new int[]{2, 0, 2, 2, 2, 2};
            case 140:
                return new int[]{0, 2, 4, 4, 3, 1};
            case 142:
                return new int[]{2, 1, 2, 3, 2, 2};
            case 146:
                return new int[]{3, 1, 0, 2, 2, 2};
            case 147:
                return new int[]{3, 2, 1, 3, 4, 2};
            case 148:
                return new int[]{3, 2, 2, 1, 2, 2};
            case 149:
                return new int[]{2, 4, 4, 4, 3, 2};
            case 150:
                return new int[]{1, 0, 4, 1, 1, 0};
            case 151:
            case 232:
                return new int[]{3, 1, 2, 2, 2, 2};
            case 152:
                return new int[]{3, 4, 3, 2, 2, 2};
            case 153:
            case 235:
                return new int[]{2, 3, 3, 4, 2, 2};
            case 156:
                return new int[]{3, 4, 2, 1, 2, 2};
            case 158:
                return new int[]{2, 1, 4, 3, 0, 4};
            case 159:
                return new int[]{0, 0, 3, 0, 0, 2};
            case 160:
                return new int[]{2, 2, 4, 3, 2, 2};
            case 163:
                return new int[]{0, 0, 1, 2, 4, 2};
            case 164:
                return new int[]{2, 3, 1, 2, 4, 2};
            case 166:
                return new int[]{1, 2, 4, 4, 3, 2};
            case 167:
                return new int[]{2, 2, 3, 1, 2, 2};
            case 169:
                return new int[]{2, 1, 2, 3, 2, 1};
            case 170:
                return new int[]{3, 3, 3, 3, 2, 2};
            case 171:
                return new int[]{1, 0, 2, 2, 4, 4};
            case 173:
                return new int[]{2, 0, 2, 1, 2, 0};
            case 174:
                return new int[]{3, 4, 1, 3, 2, 2};
            case 176:
                return new int[]{2, 2, 4, 1, 2, 2};
            case 178:
                return new int[]{1, 4, 4, 4, 4, 2};
            case 179:
                return new int[]{0, 3, 2, 3, 1, 2};
            case SensibleDefaults.X_OFFSET /* 180 */:
                return new int[]{0, 0, 1, 1, 3, 2};
            case 181:
                return new int[]{1, 0, 0, 1, 2, 2};
            case 182:
                return new int[]{1, 0, 0, 1, 3, 3};
            case 183:
                return new int[]{3, 3, 2, 0, 2, 2};
            case 184:
                return new int[]{3, 1, 1, 2, 2, 0};
            case 185:
            case 238:
                return new int[]{4, 2, 4, 3, 2, 2};
            case 189:
                return new int[]{2, 3, 3, 3, 1, 1};
            case 193:
                return new int[]{0, 1, 1, 1, 2, 2};
            case 196:
                return new int[]{4, 4, 3, 2, 2, 2};
            case 197:
                return new int[]{2, 2, 3, 4, 4, 2};
            case 198:
                return new int[]{2, 4, 4, 1, 2, 2};
            case 200:
                return new int[]{2, 2, 1, 2, 2, 2};
            case RCHTTPStatusCodes.CREATED /* 201 */:
                return new int[]{2, 3, 2, 1, 2, 2};
            case 205:
                return new int[]{3, 2, 1, 2, 2, 2};
            case 207:
                return new int[]{3, 4, 1, 0, 2, 2};
            case 212:
                return new int[]{3, 1, 1, 1, 2, 2};
            case 213:
                return new int[]{3, 2, 4, 3, 2, 2};
            case 215:
                return new int[]{2, 4, 1, 0, 2, 2};
            case 217:
                return new int[]{0, 0, 0, 0, 0, 0};
            case 218:
                return new int[]{3, 4, 2, 1, 3, 2};
            case 220:
                return new int[]{3, 3, 2, 3, 4, 2};
            case 221:
                return new int[]{2, 2, 4, 1, 3, 1};
            case 222:
                return new int[]{2, 1, 1, 2, 1, 2};
            case 223:
                return new int[]{1, 2, 3, 4, 3, 2};
            case 227:
                return new int[]{2, 2, 1, 1, 2, 4};
            case 228:
                return new int[]{0, 2, 1, 2, 2, 2};
            case 229:
                return new int[]{0, 0, 1, 2, 2, 2};
            case 233:
                return new int[]{1, 2, 1, 1, 2, 2};
            case 236:
                return new int[]{2, 4, 2, 1, 1, 2};
            case 237:
                return new int[]{4, 4, 4, 3, 2, 2};
            default:
                return new int[]{2, 2, 2, 2, 2, 2};
        }
    }

    private long j(int i3) {
        Long lValueOf = (Long) this.f45508b.get(Integer.valueOf(i3));
        if (lValueOf == null) {
            lValueOf = (Long) this.f45508b.get(0);
        } else if (lValueOf.longValue() == -9223372036854775807L) {
            lValueOf = Long.valueOf(k(this.f45523q, i3));
        }
        if (lValueOf == null) {
            lValueOf = 1000000L;
        }
        return lValueOf.longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static long k(String str, int i3) {
        int[] iArrI = i(Strings.e(str));
        if (i3 != 2) {
            if (i3 == 3) {
                return ((Long) f45501s.get(iArrI[1])).longValue();
            }
            if (i3 == 4) {
                return ((Long) f45502t.get(iArrI[2])).longValue();
            }
            if (i3 == 5) {
                return ((Long) f45503u.get(iArrI[3])).longValue();
            }
            if (i3 != 7) {
                if (i3 == 9) {
                    return ((Long) f45505w.get(iArrI[5])).longValue();
                }
                if (i3 != 10) {
                    return 1000000L;
                }
                return ((Long) f45504v.get(iArrI[4])).longValue();
            }
        }
        return ((Long) f45500r.get(iArrI[0])).longValue();
    }

    public static synchronized DefaultBandwidthMeter l(Context context) {
        try {
            if (f45506x == null) {
                f45506x = new Builder(context).a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f45506x;
    }

    private static boolean m(DataSpec dataSpec, boolean z2) {
        return z2 && !dataSpec.d(8);
    }

    private void n(int i3, long j3, long j4) {
        if (i3 == 0 && j3 == 0 && j4 == this.f45519m) {
            return;
        }
        this.f45519m = j4;
        this.f45509c.c(i3, j3, j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o(int i3) throws Throwable {
        Throwable th;
        try {
            try {
                int i4 = this.f45520n;
                if (i4 != 0) {
                    try {
                        if (!this.f45511e) {
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (this.f45521o) {
                    i3 = this.f45522p;
                }
                if (i4 != i3 || this.f45523q == null) {
                    this.f45520n = i3;
                    if (i3 == 1 || i3 == 0 || i3 == 8) {
                        return;
                    }
                    if (this.f45523q == null) {
                        this.f45523q = Util.V(this.f45507a);
                    }
                    this.f45518l = j(i3);
                    long jA = this.f45510d.a();
                    n(this.f45513g > 0 ? (int) (jA - this.f45514h) : 0, this.f45515i, this.f45518l);
                    this.f45514h = jA;
                    this.f45515i = 0L;
                    this.f45517k = 0L;
                    this.f45516j = 0L;
                    this.f45512f.g();
                    return;
                }
                return;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        th = th;
        throw th;
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
    public void a(BandwidthMeter.EventListener eventListener) {
        this.f45509c.d(eventListener);
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
    public void b(Handler handler, BandwidthMeter.EventListener eventListener) {
        Assertions.e(handler);
        Assertions.e(eventListener);
        this.f45509c.b(handler, eventListener);
    }

    @Override // androidx.media3.datasource.TransferListener
    public synchronized void c(DataSource dataSource, DataSpec dataSpec, boolean z2, int i3) {
        if (m(dataSpec, z2)) {
            this.f45515i += (long) i3;
        }
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
    public TransferListener d() {
        return this;
    }

    @Override // androidx.media3.datasource.TransferListener
    public synchronized void e(DataSource dataSource, DataSpec dataSpec, boolean z2) {
        try {
            if (m(dataSpec, z2)) {
                if (this.f45513g == 0) {
                    this.f45514h = this.f45510d.a();
                }
                this.f45513g++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0055 A[Catch: all -> 0x0072, TRY_ENTER, TryCatch #1 {all -> 0x0072, blocks: (B:3:0x0001, B:7:0x0009, B:11:0x0011, B:13:0x002e, B:23:0x0060, B:22:0x0055), top: B:38:0x0001 }] */
    @Override // androidx.media3.datasource.TransferListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void f(androidx.media3.datasource.DataSource r11, androidx.media3.datasource.DataSpec r12, boolean r13) throws java.lang.Throwable {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r11 = m(r12, r13)     // Catch: java.lang.Throwable -> L72
            if (r11 != 0) goto L9
            monitor-exit(r10)
            return
        L9:
            int r11 = r10.f45513g     // Catch: java.lang.Throwable -> L72
            r12 = 1
            if (r11 <= 0) goto L10
            r11 = r12
            goto L11
        L10:
            r11 = 0
        L11:
            androidx.media3.common.util.Assertions.g(r11)     // Catch: java.lang.Throwable -> L72
            androidx.media3.common.util.Clock r11 = r10.f45510d     // Catch: java.lang.Throwable -> L72
            long r0 = r11.a()     // Catch: java.lang.Throwable -> L72
            long r2 = r10.f45514h     // Catch: java.lang.Throwable -> L72
            long r2 = r0 - r2
            int r5 = (int) r2     // Catch: java.lang.Throwable -> L72
            long r2 = r10.f45516j     // Catch: java.lang.Throwable -> L72
            long r6 = (long) r5     // Catch: java.lang.Throwable -> L72
            long r2 = r2 + r6
            r10.f45516j = r2     // Catch: java.lang.Throwable -> L72
            long r2 = r10.f45517k     // Catch: java.lang.Throwable -> L72
            long r6 = r10.f45515i     // Catch: java.lang.Throwable -> L72
            long r2 = r2 + r6
            r10.f45517k = r2     // Catch: java.lang.Throwable -> L72
            if (r5 <= 0) goto L75
            float r11 = (float) r6     // Catch: java.lang.Throwable -> L72
            r13 = 1174011904(0x45fa0000, float:8000.0)
            float r11 = r11 * r13
            float r13 = (float) r5     // Catch: java.lang.Throwable -> L72
            float r11 = r11 / r13
            androidx.media3.exoplayer.upstream.SlidingPercentile r13 = r10.f45512f     // Catch: java.lang.Throwable -> L72
            double r2 = (double) r6     // Catch: java.lang.Throwable -> L72
            double r2 = java.lang.Math.sqrt(r2)     // Catch: java.lang.Throwable -> L72
            int r2 = (int) r2     // Catch: java.lang.Throwable -> L72
            r13.c(r2, r11)     // Catch: java.lang.Throwable -> L72
            long r2 = r10.f45516j     // Catch: java.lang.Throwable -> L72
            r6 = 2000(0x7d0, double:9.88E-321)
            int r11 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r11 >= 0) goto L55
            long r2 = r10.f45517k     // Catch: java.lang.Throwable -> L51
            r6 = 524288(0x80000, double:2.590327E-318)
            int r11 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r11 < 0) goto L60
            goto L55
        L51:
            r0 = move-exception
            r11 = r0
            r4 = r10
            goto L7d
        L55:
            androidx.media3.exoplayer.upstream.SlidingPercentile r11 = r10.f45512f     // Catch: java.lang.Throwable -> L72
            r13 = 1056964608(0x3f000000, float:0.5)
            float r11 = r11.f(r13)     // Catch: java.lang.Throwable -> L72
            long r2 = (long) r11     // Catch: java.lang.Throwable -> L72
            r10.f45518l = r2     // Catch: java.lang.Throwable -> L72
        L60:
            long r6 = r10.f45515i     // Catch: java.lang.Throwable -> L72
            long r8 = r10.f45518l     // Catch: java.lang.Throwable -> L72
            r4 = r10
            r4.n(r5, r6, r8)     // Catch: java.lang.Throwable -> L6f
            r4.f45514h = r0     // Catch: java.lang.Throwable -> L6f
            r0 = 0
            r4.f45515i = r0     // Catch: java.lang.Throwable -> L6f
            goto L76
        L6f:
            r0 = move-exception
        L70:
            r11 = r0
            goto L7d
        L72:
            r0 = move-exception
            r4 = r10
            goto L70
        L75:
            r4 = r10
        L76:
            int r11 = r4.f45513g     // Catch: java.lang.Throwable -> L6f
            int r11 = r11 - r12
            r4.f45513g = r11     // Catch: java.lang.Throwable -> L6f
            monitor-exit(r10)
            return
        L7d:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L6f
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.upstream.DefaultBandwidthMeter.f(androidx.media3.datasource.DataSource, androidx.media3.datasource.DataSpec, boolean):void");
    }

    @Override // androidx.media3.datasource.TransferListener
    public void g(DataSource dataSource, DataSpec dataSpec, boolean z2) {
    }

    private DefaultBandwidthMeter(Context context, Map map, int i3, Clock clock, boolean z2) {
        this.f45507a = context == null ? null : context.getApplicationContext();
        this.f45508b = ImmutableMap.e(map);
        this.f45509c = new BandwidthMeter.EventListener.EventDispatcher();
        this.f45512f = new SlidingPercentile(i3);
        this.f45510d = clock;
        this.f45511e = z2;
        if (context == null) {
            this.f45520n = 0;
            this.f45518l = 1000000L;
            return;
        }
        NetworkTypeObserver networkTypeObserverE = NetworkTypeObserver.e(context);
        int iG = networkTypeObserverE.g();
        this.f45520n = iG;
        this.f45518l = j(iG);
        networkTypeObserverE.k(new NetworkTypeObserver.Listener() { // from class: androidx.media3.exoplayer.upstream.b
            @Override // androidx.media3.common.util.NetworkTypeObserver.Listener
            public final void a(int i4) throws Throwable {
                this.f45576a.o(i4);
            }
        }, BackgroundExecutor.a());
    }
}
