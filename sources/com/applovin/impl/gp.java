package com.applovin.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.applovin.impl.a5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class gp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f60029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f60030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f60031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f60032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f60033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final jp f60034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String[] f60035g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f60036h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f60037i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final gp f60038j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final HashMap f60039k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final HashMap f60040l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private List f60041m;

    private gp(String str, String str2, long j3, long j4, jp jpVar, String[] strArr, String str3, String str4, gp gpVar) {
        this.f60029a = str;
        this.f60030b = str2;
        this.f60037i = str4;
        this.f60034f = jpVar;
        this.f60035g = strArr;
        this.f60031c = str2 != null;
        this.f60032d = j3;
        this.f60033e = j4;
        this.f60036h = (String) b1.a((Object) str3);
        this.f60038j = gpVar;
        this.f60039k = new HashMap();
        this.f60040l = new HashMap();
    }

    public void a(gp gpVar) {
        if (this.f60041m == null) {
            this.f60041m = new ArrayList();
        }
        this.f60041m.add(gpVar);
    }

    public long[] b() {
        TreeSet treeSet = new TreeSet();
        int i3 = 0;
        a(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i3] = ((Long) it.next()).longValue();
            i3++;
        }
        return jArr;
    }

    public String[] c() {
        return this.f60035g;
    }

    private void a(Map map, a5.b bVar, int i3, int i4, int i5) {
        jp jpVarA = ip.a(this.f60034f, this.f60035g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) bVar.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            bVar.a(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (jpVarA != null) {
            ip.a(spannableStringBuilder2, i3, i4, jpVarA, this.f60038j, map, i5);
            if ("p".equals(this.f60029a)) {
                if (jpVarA.j() != Float.MAX_VALUE) {
                    bVar.c((jpVarA.j() * (-90.0f)) / 100.0f);
                }
                if (jpVarA.l() != null) {
                    bVar.b(jpVarA.l());
                }
                if (jpVarA.g() != null) {
                    bVar.a(jpVarA.g());
                }
            }
        }
    }

    private static void a(SpannableStringBuilder spannableStringBuilder) {
        for (n6 n6Var : (n6[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), n6.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(n6Var), spannableStringBuilder.getSpanEnd(n6Var), "");
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

    public gp a(int i3) {
        List list = this.f60041m;
        if (list != null) {
            return (gp) list.get(i3);
        }
        throw new IndexOutOfBoundsException();
    }

    public int a() {
        List list = this.f60041m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    private void a(TreeSet treeSet, boolean z2) {
        boolean zEquals = "p".equals(this.f60029a);
        boolean zEquals2 = "div".equals(this.f60029a);
        if (z2 || zEquals || (zEquals2 && this.f60037i != null)) {
            long j3 = this.f60032d;
            if (j3 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j3));
            }
            long j4 = this.f60033e;
            if (j4 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j4));
            }
        }
        if (this.f60041m == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f60041m.size(); i3++) {
            ((gp) this.f60041m.get(i3)).a(treeSet, z2 || zEquals);
        }
    }

    private static SpannableStringBuilder a(String str, Map map) {
        if (!map.containsKey(str)) {
            a5.b bVar = new a5.b();
            bVar.a(new SpannableStringBuilder());
            map.put(str, bVar);
        }
        return (SpannableStringBuilder) b1.a(((a5.b) map.get(str)).e());
    }

    public boolean a(long j3) {
        long j4 = this.f60032d;
        if (j4 == -9223372036854775807L && this.f60033e == -9223372036854775807L) {
            return true;
        }
        if (j4 <= j3 && this.f60033e == -9223372036854775807L) {
            return true;
        }
        if (j4 != -9223372036854775807L || j3 >= this.f60033e) {
            return j4 <= j3 && j3 < this.f60033e;
        }
        return true;
    }

    private void a(long j3, String str, List list) {
        if (!"".equals(this.f60036h)) {
            str = this.f60036h;
        }
        if (a(j3) && "div".equals(this.f60029a) && this.f60037i != null) {
            list.add(new Pair(str, this.f60037i));
            return;
        }
        for (int i3 = 0; i3 < a(); i3++) {
            a(i3).a(j3, str, list);
        }
    }

    private void a(long j3, Map map, Map map2, String str, Map map3) {
        if (a(j3)) {
            String str2 = "".equals(this.f60036h) ? str : this.f60036h;
            Iterator it = this.f60040l.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str3 = (String) entry.getKey();
                int iIntValue = this.f60039k.containsKey(str3) ? ((Integer) this.f60039k.get(str3)).intValue() : 0;
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (iIntValue != iIntValue2) {
                    a(map, (a5.b) b1.a((a5.b) map3.get(str3)), iIntValue, iIntValue2, ((hp) b1.a((hp) map2.get(str2))).f60242j);
                }
            }
            for (int i3 = 0; i3 < a(); i3++) {
                a(i3).a(j3, map, map2, str2, map3);
            }
        }
    }

    private void a(long j3, boolean z2, String str, Map map) {
        boolean z3;
        Map map2;
        long j4;
        this.f60039k.clear();
        this.f60040l.clear();
        if ("metadata".equals(this.f60029a)) {
            return;
        }
        if (!"".equals(this.f60036h)) {
            str = this.f60036h;
        }
        String str2 = str;
        if (this.f60031c && z2) {
            a(str2, map).append((CharSequence) b1.a((Object) this.f60030b));
            return;
        }
        if ("br".equals(this.f60029a) && z2) {
            a(str2, map).append('\n');
            return;
        }
        if (a(j3)) {
            for (Map.Entry entry : map.entrySet()) {
                this.f60039k.put((String) entry.getKey(), Integer.valueOf(((CharSequence) b1.a(((a5.b) entry.getValue()).e())).length()));
            }
            boolean zEquals = "p".equals(this.f60029a);
            int i3 = 0;
            while (i3 < a()) {
                gp gpVarA = a(i3);
                if (z2 || zEquals) {
                    z3 = true;
                    map2 = map;
                    j4 = j3;
                } else {
                    z3 = false;
                    j4 = j3;
                    map2 = map;
                }
                gpVarA.a(j4, z3, str2, map2);
                i3++;
                j3 = j4;
                map = map2;
            }
            Map map3 = map;
            if (zEquals) {
                ip.a(a(str2, map3));
            }
            for (Map.Entry entry2 : map3.entrySet()) {
                this.f60040l.put((String) entry2.getKey(), Integer.valueOf(((CharSequence) b1.a(((a5.b) entry2.getValue()).e())).length()));
            }
        }
    }

    public static gp a(String str) {
        return new gp(null, ip.a(str), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static gp a(String str, long j3, long j4, jp jpVar, String[] strArr, String str2, String str3, gp gpVar) {
        return new gp(str, null, j3, j4, jpVar, strArr, str2, str3, gpVar);
    }

    public List a(long j3, Map map, Map map2, Map map3) {
        ArrayList arrayList = new ArrayList();
        a(j3, this.f60036h, arrayList);
        TreeMap treeMap = new TreeMap();
        a(j3, false, this.f60036h, (Map) treeMap);
        a(j3, map, map2, this.f60036h, treeMap);
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
                hp hpVar = (hp) b1.a((hp) map2.get(pair.first));
                arrayList2.add(new a5.b().a(bitmapDecodeByteArray).b(hpVar.f60234b).b(0).a(hpVar.f60235c, 0).a(hpVar.f60237e).d(hpVar.f60238f).a(hpVar.f60239g).c(hpVar.f60242j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            hp hpVar2 = (hp) b1.a((hp) map2.get(entry.getKey()));
            a5.b bVar = (a5.b) entry.getValue();
            a((SpannableStringBuilder) b1.a(bVar.e()));
            bVar.a(hpVar2.f60235c, hpVar2.f60236d);
            bVar.a(hpVar2.f60237e);
            bVar.b(hpVar2.f60234b);
            bVar.d(hpVar2.f60238f);
            bVar.b(hpVar2.f60241i, hpVar2.f60240h);
            bVar.c(hpVar2.f60242j);
            arrayList2.add(bVar.a());
        }
        return arrayList2;
    }
}
