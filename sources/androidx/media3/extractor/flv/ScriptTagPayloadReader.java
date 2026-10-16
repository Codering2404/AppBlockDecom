package androidx.media3.extractor.flv;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.DiscardingTrackOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ScriptTagPayloadReader extends TagPayloadReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f46375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f46376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long[] f46377d;

    public ScriptTagPayloadReader() {
        super(new DiscardingTrackOutput());
        this.f46375b = -9223372036854775807L;
        this.f46376c = new long[0];
        this.f46377d = new long[0];
    }

    private static Boolean g(ParsableByteArray parsableByteArray) {
        return Boolean.valueOf(parsableByteArray.H() == 1);
    }

    private static Object h(ParsableByteArray parsableByteArray, int i3) {
        if (i3 == 0) {
            return j(parsableByteArray);
        }
        if (i3 == 1) {
            return g(parsableByteArray);
        }
        if (i3 == 2) {
            return n(parsableByteArray);
        }
        if (i3 == 3) {
            return l(parsableByteArray);
        }
        if (i3 == 8) {
            return k(parsableByteArray);
        }
        if (i3 == 10) {
            return m(parsableByteArray);
        }
        if (i3 != 11) {
            return null;
        }
        return i(parsableByteArray);
    }

    private static Date i(ParsableByteArray parsableByteArray) {
        Date date = new Date((long) j(parsableByteArray).doubleValue());
        parsableByteArray.X(2);
        return date;
    }

    private static Double j(ParsableByteArray parsableByteArray) {
        return Double.valueOf(Double.longBitsToDouble(parsableByteArray.A()));
    }

    private static HashMap k(ParsableByteArray parsableByteArray) {
        int iL = parsableByteArray.L();
        HashMap map = new HashMap(iL);
        for (int i3 = 0; i3 < iL; i3++) {
            String strN = n(parsableByteArray);
            Object objH = h(parsableByteArray, o(parsableByteArray));
            if (objH != null) {
                map.put(strN, objH);
            }
        }
        return map;
    }

    private static HashMap l(ParsableByteArray parsableByteArray) {
        HashMap map = new HashMap();
        while (true) {
            String strN = n(parsableByteArray);
            int iO = o(parsableByteArray);
            if (iO == 9) {
                return map;
            }
            Object objH = h(parsableByteArray, iO);
            if (objH != null) {
                map.put(strN, objH);
            }
        }
    }

    private static ArrayList m(ParsableByteArray parsableByteArray) {
        int iL = parsableByteArray.L();
        ArrayList arrayList = new ArrayList(iL);
        for (int i3 = 0; i3 < iL; i3++) {
            Object objH = h(parsableByteArray, o(parsableByteArray));
            if (objH != null) {
                arrayList.add(objH);
            }
        }
        return arrayList;
    }

    private static String n(ParsableByteArray parsableByteArray) {
        int iP = parsableByteArray.P();
        int iF = parsableByteArray.f();
        parsableByteArray.X(iP);
        return new String(parsableByteArray.e(), iF, iP);
    }

    private static int o(ParsableByteArray parsableByteArray) {
        return parsableByteArray.H();
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    protected boolean b(ParsableByteArray parsableByteArray) {
        return true;
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    protected boolean c(ParsableByteArray parsableByteArray, long j3) {
        if (o(parsableByteArray) != 2 || !"onMetaData".equals(n(parsableByteArray)) || parsableByteArray.a() == 0 || o(parsableByteArray) != 8) {
            return false;
        }
        HashMap mapK = k(parsableByteArray);
        Object obj = mapK.get("duration");
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.f46375b = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapK.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f46376c = new long[size];
                this.f46377d = new long[size];
                for (int i3 = 0; i3 < size; i3++) {
                    Object obj5 = list.get(i3);
                    Object obj6 = list2.get(i3);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.f46376c = new long[0];
                        this.f46377d = new long[0];
                        break;
                    }
                    this.f46376c[i3] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.f46377d[i3] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }

    public long d() {
        return this.f46375b;
    }

    public long[] e() {
        return this.f46377d;
    }

    public long[] f() {
        return this.f46376c;
    }
}
