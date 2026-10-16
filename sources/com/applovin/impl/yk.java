package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class yk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f65226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f65227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f65228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f65229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f65230e;

    private yk(int i3, int i4, int i5, int i6, int i7) {
        this.f65226a = i3;
        this.f65227b = i4;
        this.f65228c = i5;
        this.f65229d = i6;
        this.f65230e = i7;
    }

    public static yk a(String str) {
        b1.a(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        for (int i7 = 0; i7 < strArrSplit.length; i7++) {
            String lowerCase = Ascii.toLowerCase(strArrSplit[i7].trim());
            lowerCase.getClass();
            switch (lowerCase) {
                case "end":
                    i4 = i7;
                    break;
                case "text":
                    i6 = i7;
                    break;
                case "start":
                    i3 = i7;
                    break;
                case "style":
                    i5 = i7;
                    break;
            }
        }
        if (i3 == -1 || i4 == -1 || i6 == -1) {
            return null;
        }
        return new yk(i3, i4, i5, i6, strArrSplit.length);
    }
}
