package com.applovin.impl;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.impl.a5;
import com.applovin.impl.zk;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class xk extends ek {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Pattern f64996t = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f64997o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final yk f64998p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Map f64999q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f65000r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f65001s;

    public xk(List list) {
        super("SsaDecoder");
        this.f65000r = -3.4028235E38f;
        this.f65001s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.f64997o = false;
            this.f64998p = null;
            return;
        }
        this.f64997o = true;
        String strA = xp.a((byte[]) list.get(0));
        b1.a(strA.startsWith("Format:"));
        this.f64998p = (yk) b1.a(yk.a(strA));
        a(new ah((byte[]) list.get(1)));
    }

    private static int a(long j3, List list, List list2) {
        int i3;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i3 = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j3) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j3) {
                i3 = size + 1;
                break;
            }
            size--;
        }
        list.add(i3, Long.valueOf(j3));
        list2.add(i3, i3 == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i3 - 1)));
        return i3;
    }

    private static float b(int i3) {
        if (i3 == 0) {
            return 0.05f;
        }
        if (i3 != 1) {
            return i3 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static int c(int i3) {
        switch (i3) {
            case -1:
                break;
            case 0:
            default:
                oc.d("SsaDecoder", "Unknown alignment: " + i3);
                break;
            case 1:
            case 2:
            case 3:
                break;
            case 4:
            case 5:
            case 6:
                break;
            case 7:
            case 8:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    private static int d(int i3) {
        switch (i3) {
            case -1:
                break;
            case 0:
            default:
                oc.d("SsaDecoder", "Unknown alignment: " + i3);
                break;
            case 1:
            case 4:
            case 7:
                break;
            case 2:
            case 5:
            case 8:
                break;
            case 3:
            case 6:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    private static Layout.Alignment e(int i3) {
        switch (i3) {
            case -1:
                return null;
            case 0:
            default:
                oc.d("SsaDecoder", "Unknown alignment: " + i3);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    private void b(ah ahVar) {
        while (true) {
            String strL = ahVar.l();
            if (strL == null) {
                return;
            }
            if (ahVar.a() != 0 && ahVar.g() == 91) {
                return;
            }
            String[] strArrSplit = strL.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            if (strArrSplit.length == 2) {
                String lowerCase = Ascii.toLowerCase(strArrSplit[0].trim());
                lowerCase.getClass();
                if (lowerCase.equals("playresx")) {
                    this.f65000r = Float.parseFloat(strArrSplit[1].trim());
                } else if (lowerCase.equals("playresy")) {
                    try {
                        this.f65001s = Float.parseFloat(strArrSplit[1].trim());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }

    private static Map c(ah ahVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        zk.a aVarA = null;
        while (true) {
            String strL = ahVar.l();
            if (strL == null || (ahVar.a() != 0 && ahVar.g() == 91)) {
                break;
            }
            if (strL.startsWith("Format:")) {
                aVarA = zk.a.a(strL);
            } else if (strL.startsWith("Style:")) {
                if (aVarA == null) {
                    oc.d("SsaDecoder", "Skipping 'Style:' line before 'Format:' line: " + strL);
                } else {
                    zk zkVarA = zk.a(strL, aVarA);
                    if (zkVarA != null) {
                        linkedHashMap.put(zkVarA.f65442a, zkVarA);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static a5 a(String str, zk zkVar, zk.b bVar, float f3, float f4) {
        SpannableString spannableString = new SpannableString(str);
        a5.b bVarA = new a5.b().a(spannableString);
        if (zkVar != null) {
            if (zkVar.f65444c != null) {
                spannableString.setSpan(new ForegroundColorSpan(zkVar.f65444c.intValue()), 0, spannableString.length(), 33);
            }
            float f5 = zkVar.f65445d;
            if (f5 != -3.4028235E38f && f4 != -3.4028235E38f) {
                bVarA.b(f5 / f4, 1);
            }
            boolean z2 = zkVar.f65446e;
            if (z2 && zkVar.f65447f) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z2) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (zkVar.f65447f) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (zkVar.f65448g) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (zkVar.f65449h) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i3 = bVar.f65463a;
        if (i3 == -1) {
            i3 = zkVar != null ? zkVar.f65443b : -1;
        }
        bVarA.b(e(i3)).b(d(i3)).a(c(i3));
        PointF pointF = bVar.f65464b;
        if (pointF != null && f4 != -3.4028235E38f && f3 != -3.4028235E38f) {
            bVarA.b(pointF.x / f3);
            bVarA.a(bVar.f65464b.y / f4, 0);
        } else {
            bVarA.b(b(bVarA.d()));
            bVarA.a(b(bVarA.c()), 0);
        }
        return bVarA.a();
    }

    @Override // com.applovin.impl.ek
    protected nl a(byte[] bArr, int i3, boolean z2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ah ahVar = new ah(bArr, i3);
        if (!this.f64997o) {
            a(ahVar);
        }
        a(ahVar, arrayList, arrayList2);
        return new al(arrayList, arrayList2);
    }

    private void a(String str, yk ykVar, List list, List list2) {
        int i3;
        b1.a(str.startsWith("Dialogue:"));
        String[] strArrSplit = str.substring(9).split(",", ykVar.f65230e);
        if (strArrSplit.length != ykVar.f65230e) {
            oc.d("SsaDecoder", "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long jA = a(strArrSplit[ykVar.f65226a]);
        if (jA == -9223372036854775807L) {
            oc.d("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        long jA2 = a(strArrSplit[ykVar.f65227b]);
        if (jA2 == -9223372036854775807L) {
            oc.d("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        Map map = this.f64999q;
        zk zkVar = (map == null || (i3 = ykVar.f65228c) == -1) ? null : (zk) map.get(strArrSplit[i3].trim());
        String str2 = strArrSplit[ykVar.f65229d];
        a5 a5VarA = a(zk.b.d(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), zkVar, zk.b.b(str2), this.f65000r, this.f65001s);
        int iA = a(jA2, list2, list);
        for (int iA2 = a(jA, list2, list); iA2 < iA; iA2++) {
            ((List) list.get(iA2)).add(a5VarA);
        }
    }

    private void a(ah ahVar, List list, List list2) {
        yk ykVarA = this.f64997o ? this.f64998p : null;
        while (true) {
            String strL = ahVar.l();
            if (strL == null) {
                return;
            }
            if (strL.startsWith("Format:")) {
                ykVarA = yk.a(strL);
            } else if (strL.startsWith("Dialogue:")) {
                if (ykVarA == null) {
                    oc.d("SsaDecoder", "Skipping dialogue line before complete format: " + strL);
                } else {
                    a(strL, ykVarA, list, list2);
                }
            }
        }
    }

    private void a(ah ahVar) {
        while (true) {
            String strL = ahVar.l();
            if (strL == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strL)) {
                b(ahVar);
            } else if ("[V4+ Styles]".equalsIgnoreCase(strL)) {
                this.f64999q = c(ahVar);
            } else if ("[V4 Styles]".equalsIgnoreCase(strL)) {
                oc.c("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strL)) {
                return;
            }
        }
    }

    private static long a(String str) {
        Matcher matcher = f64996t.matcher(str.trim());
        if (matcher.matches()) {
            return (Long.parseLong((String) xp.a((Object) matcher.group(1))) * 3600000000L) + (Long.parseLong((String) xp.a((Object) matcher.group(2))) * 60000000) + (Long.parseLong((String) xp.a((Object) matcher.group(3))) * 1000000) + (Long.parseLong((String) xp.a((Object) matcher.group(4))) * 10000);
        }
        return -9223372036854775807L;
    }
}
