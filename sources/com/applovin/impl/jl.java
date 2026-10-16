package com.applovin.impl;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class jl extends ek {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Pattern f60773q = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Pattern f60774r = Pattern.compile("\\{\\\\.*?\\}");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final StringBuilder f60775o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ArrayList f60776p;

    public jl() {
        super("SubripDecoder");
        this.f60775o = new StringBuilder();
        this.f60776p = new ArrayList();
    }

    private static long a(Matcher matcher, int i3) {
        String strGroup = matcher.group(i3 + 1);
        long j3 = (strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L) + (Long.parseLong((String) b1.a((Object) matcher.group(i3 + 2))) * 60000) + (Long.parseLong((String) b1.a((Object) matcher.group(i3 + 3))) * 1000);
        String strGroup2 = matcher.group(i3 + 4);
        if (strGroup2 != null) {
            j3 += Long.parseLong(strGroup2);
        }
        return j3 * 1000;
    }

    static float b(int i3) {
        if (i3 == 0) {
            return 0.08f;
        }
        if (i3 == 1) {
            return 0.5f;
        }
        if (i3 == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    private String a(String str, ArrayList arrayList) {
        String strTrim = str.trim();
        StringBuilder sb = new StringBuilder(strTrim);
        Matcher matcher = f60774r.matcher(strTrim);
        int i3 = 0;
        while (matcher.find()) {
            String strGroup = matcher.group();
            arrayList.add(strGroup);
            int iStart = matcher.start() - i3;
            int length = strGroup.length();
            sb.replace(iStart, iStart + length, "");
            i3 += length;
        }
        return sb.toString();
    }

    @Override // com.applovin.impl.ek
    protected nl a(byte[] bArr, int i3, boolean z2) {
        String str;
        ArrayList arrayList = new ArrayList();
        qc qcVar = new qc();
        ah ahVar = new ah(bArr, i3);
        while (true) {
            String strL = ahVar.l();
            int i4 = 0;
            if (strL == null) {
                break;
            }
            if (strL.length() != 0) {
                try {
                    Integer.parseInt(strL);
                    String strL2 = ahVar.l();
                    if (strL2 == null) {
                        oc.d("SubripDecoder", "Unexpected end");
                        break;
                    }
                    Matcher matcher = f60773q.matcher(strL2);
                    if (!matcher.matches()) {
                        oc.d("SubripDecoder", "Skipping invalid timing: " + strL2);
                    } else {
                        qcVar.a(a(matcher, 1));
                        qcVar.a(a(matcher, 6));
                        this.f60775o.setLength(0);
                        this.f60776p.clear();
                        for (String strL3 = ahVar.l(); !TextUtils.isEmpty(strL3); strL3 = ahVar.l()) {
                            if (this.f60775o.length() > 0) {
                                this.f60775o.append("<br>");
                            }
                            this.f60775o.append(a(strL3, this.f60776p));
                        }
                        Spanned spannedFromHtml = Html.fromHtml(this.f60775o.toString());
                        while (true) {
                            if (i4 >= this.f60776p.size()) {
                                str = null;
                                break;
                            }
                            str = (String) this.f60776p.get(i4);
                            if (str.matches("\\{\\\\an[1-9]\\}")) {
                                break;
                            }
                            i4++;
                        }
                        arrayList.add(a(spannedFromHtml, str));
                        arrayList.add(a5.f58171s);
                    }
                } catch (NumberFormatException unused) {
                    oc.d("SubripDecoder", "Skipping invalid index: " + strL);
                }
            }
        }
        return new kl((a5[]) arrayList.toArray(new a5[0]), qcVar.b());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.applovin.impl.a5 a(android.text.Spanned r14, java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.jl.a(android.text.Spanned, java.lang.String):com.applovin.impl.a5");
    }
}
