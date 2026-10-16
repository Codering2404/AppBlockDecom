package androidx.media3.extractor.text.ttml;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TtmlNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f47192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f47193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f47194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f47195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TtmlStyle f47196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String[] f47197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f47198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f47199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TtmlNode f47200j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final HashMap f47201k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final HashMap f47202l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private List f47203m;

    private TtmlNode(String str, String str2, long j3, long j4, TtmlStyle ttmlStyle, String[] strArr, String str3, String str4, TtmlNode ttmlNode) {
        this.f47191a = str;
        this.f47192b = str2;
        this.f47199i = str4;
        this.f47196f = ttmlStyle;
        this.f47197g = strArr;
        this.f47193c = str2 != null;
        this.f47194d = j3;
        this.f47195e = j4;
        this.f47198h = (String) Assertions.e(str3);
        this.f47200j = ttmlNode;
        this.f47201k = new HashMap();
        this.f47202l = new HashMap();
    }

    private void b(Map map, Cue.Builder builder, int i3, int i4, int i5) {
        TtmlStyle ttmlStyleF = TtmlRenderUtil.f(this.f47196f, this.f47197g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) builder.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            builder.o(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (ttmlStyleF != null) {
            TtmlRenderUtil.a(spannableStringBuilder2, i3, i4, ttmlStyleF, this.f47200j, map, i5);
            if ("p".equals(this.f47191a)) {
                if (ttmlStyleF.m() != Float.MAX_VALUE) {
                    builder.m((ttmlStyleF.m() * (-90.0f)) / 100.0f);
                }
                if (ttmlStyleF.o() != null) {
                    builder.p(ttmlStyleF.o());
                }
                if (ttmlStyleF.i() != null) {
                    builder.j(ttmlStyleF.i());
                }
            }
        }
    }

    public static TtmlNode c(String str, long j3, long j4, TtmlStyle ttmlStyle, String[] strArr, String str2, String str3, TtmlNode ttmlNode) {
        return new TtmlNode(str, null, j3, j4, ttmlStyle, strArr, str2, str3, ttmlNode);
    }

    public static TtmlNode d(String str) {
        return new TtmlNode(null, TtmlRenderUtil.b(str), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    private static void e(SpannableStringBuilder spannableStringBuilder) {
        for (DeleteTextSpan deleteTextSpan : (DeleteTextSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), DeleteTextSpan.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(deleteTextSpan), spannableStringBuilder.getSpanEnd(deleteTextSpan), "");
        }
        for (int i3 = 0; i3 < spannableStringBuilder.length(); i3++) {
            if (spannableStringBuilder.charAt(i3) == ' ') {
                int i4 = i3 + 1;
                int i5 = i4;
                while (i5 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i5) == ' ') {
                    i5++;
                }
                int i6 = i5 - i4;
                if (i6 > 0) {
                    spannableStringBuilder.delete(i3, i6 + i3);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i7 = 0; i7 < spannableStringBuilder.length() - 1; i7++) {
            if (spannableStringBuilder.charAt(i7) == '\n') {
                int i8 = i7 + 1;
                if (spannableStringBuilder.charAt(i8) == ' ') {
                    spannableStringBuilder.delete(i8, i7 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i9 = 0; i9 < spannableStringBuilder.length() - 1; i9++) {
            if (spannableStringBuilder.charAt(i9) == ' ') {
                int i10 = i9 + 1;
                if (spannableStringBuilder.charAt(i10) == '\n') {
                    spannableStringBuilder.delete(i9, i10);
                }
            }
        }
        if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != '\n') {
            return;
        }
        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
    }

    private void i(TreeSet treeSet, boolean z2) {
        boolean zEquals = "p".equals(this.f47191a);
        boolean zEquals2 = "div".equals(this.f47191a);
        if (z2 || zEquals || (zEquals2 && this.f47199i != null)) {
            long j3 = this.f47194d;
            if (j3 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j3));
            }
            long j4 = this.f47195e;
            if (j4 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j4));
            }
        }
        if (this.f47203m == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f47203m.size(); i3++) {
            ((TtmlNode) this.f47203m.get(i3)).i(treeSet, z2 || zEquals);
        }
    }

    private static SpannableStringBuilder k(String str, Map map) {
        if (!map.containsKey(str)) {
            Cue.Builder builder = new Cue.Builder();
            builder.o(new SpannableStringBuilder());
            map.put(str, builder);
        }
        return (SpannableStringBuilder) Assertions.e(((Cue.Builder) map.get(str)).e());
    }

    private void n(long j3, String str, List list) {
        if (!"".equals(this.f47198h)) {
            str = this.f47198h;
        }
        if (m(j3) && "div".equals(this.f47191a) && this.f47199i != null) {
            list.add(new Pair(str, this.f47199i));
            return;
        }
        for (int i3 = 0; i3 < g(); i3++) {
            f(i3).n(j3, str, list);
        }
    }

    private void o(long j3, Map map, Map map2, String str, Map map3) {
        if (m(j3)) {
            String str2 = "".equals(this.f47198h) ? str : this.f47198h;
            Iterator it = this.f47202l.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str3 = (String) entry.getKey();
                int iIntValue = this.f47201k.containsKey(str3) ? ((Integer) this.f47201k.get(str3)).intValue() : 0;
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (iIntValue != iIntValue2) {
                    b(map, (Cue.Builder) Assertions.e((Cue.Builder) map3.get(str3)), iIntValue, iIntValue2, ((TtmlRegion) Assertions.e((TtmlRegion) map2.get(str2))).f47227j);
                }
            }
            for (int i3 = 0; i3 < g(); i3++) {
                f(i3).o(j3, map, map2, str2, map3);
            }
        }
    }

    private void p(long j3, boolean z2, String str, Map map) {
        boolean z3;
        Map map2;
        long j4;
        this.f47201k.clear();
        this.f47202l.clear();
        if ("metadata".equals(this.f47191a)) {
            return;
        }
        if (!"".equals(this.f47198h)) {
            str = this.f47198h;
        }
        String str2 = str;
        if (this.f47193c && z2) {
            k(str2, map).append((CharSequence) Assertions.e(this.f47192b));
            return;
        }
        if ("br".equals(this.f47191a) && z2) {
            k(str2, map).append('\n');
            return;
        }
        if (m(j3)) {
            for (Map.Entry entry : map.entrySet()) {
                this.f47201k.put((String) entry.getKey(), Integer.valueOf(((CharSequence) Assertions.e(((Cue.Builder) entry.getValue()).e())).length()));
            }
            boolean zEquals = "p".equals(this.f47191a);
            int i3 = 0;
            while (i3 < g()) {
                TtmlNode ttmlNodeF = f(i3);
                if (z2 || zEquals) {
                    z3 = true;
                    map2 = map;
                    j4 = j3;
                } else {
                    z3 = false;
                    j4 = j3;
                    map2 = map;
                }
                ttmlNodeF.p(j4, z3, str2, map2);
                i3++;
                j3 = j4;
                map = map2;
            }
            Map map3 = map;
            if (zEquals) {
                TtmlRenderUtil.c(k(str2, map3));
            }
            for (Map.Entry entry2 : map3.entrySet()) {
                this.f47202l.put((String) entry2.getKey(), Integer.valueOf(((CharSequence) Assertions.e(((Cue.Builder) entry2.getValue()).e())).length()));
            }
        }
    }

    public void a(TtmlNode ttmlNode) {
        if (this.f47203m == null) {
            this.f47203m = new ArrayList();
        }
        this.f47203m.add(ttmlNode);
    }

    public TtmlNode f(int i3) {
        List list = this.f47203m;
        if (list != null) {
            return (TtmlNode) list.get(i3);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List list = this.f47203m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List h(long j3, Map map, Map map2, Map map3) {
        ArrayList arrayList = new ArrayList();
        n(j3, this.f47198h, arrayList);
        TreeMap treeMap = new TreeMap();
        p(j3, false, this.f47198h, treeMap);
        o(j3, map, map2, this.f47198h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Pair pair = (Pair) obj;
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                TtmlRegion ttmlRegion = (TtmlRegion) Assertions.e((TtmlRegion) map2.get(pair.first));
                arrayList2.add(new Cue.Builder().f(bitmapDecodeByteArray).k(ttmlRegion.f47219b).l(0).h(ttmlRegion.f47220c, 0).i(ttmlRegion.f47222e).n(ttmlRegion.f47223f).g(ttmlRegion.f47224g).r(ttmlRegion.f47227j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion2 = (TtmlRegion) Assertions.e((TtmlRegion) map2.get(entry.getKey()));
            Cue.Builder builder = (Cue.Builder) entry.getValue();
            e((SpannableStringBuilder) Assertions.e(builder.e()));
            builder.h(ttmlRegion2.f47220c, ttmlRegion2.f47221d);
            builder.i(ttmlRegion2.f47222e);
            builder.k(ttmlRegion2.f47219b);
            builder.n(ttmlRegion2.f47223f);
            builder.q(ttmlRegion2.f47226i, ttmlRegion2.f47225h);
            builder.r(ttmlRegion2.f47227j);
            arrayList2.add(builder.a());
        }
        return arrayList2;
    }

    public long[] j() {
        TreeSet treeSet = new TreeSet();
        int i3 = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i3] = ((Long) it.next()).longValue();
            i3++;
        }
        return jArr;
    }

    public String[] l() {
        return this.f47197g;
    }

    public boolean m(long j3) {
        long j4 = this.f47194d;
        if (j4 == -9223372036854775807L && this.f47195e == -9223372036854775807L) {
            return true;
        }
        if (j4 <= j3 && this.f47195e == -9223372036854775807L) {
            return true;
        }
        if (j4 != -9223372036854775807L || j3 >= this.f47195e) {
            return j4 <= j3 && j3 < this.f47195e;
        }
        return true;
    }
}
