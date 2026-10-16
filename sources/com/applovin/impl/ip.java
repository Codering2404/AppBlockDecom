package com.applovin.impl;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayDeque;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class ip {
    public static void a(Spannable spannable, int i3, int i4, jp jpVar, gp gpVar, Map map, int i5) {
        gp gpVarB;
        jp jpVarA;
        int i6;
        if (jpVar.k() != -1) {
            spannable.setSpan(new StyleSpan(jpVar.k()), i3, i4, 33);
        }
        if (jpVar.q()) {
            spannable.setSpan(new StrikethroughSpan(), i3, i4, 33);
        }
        if (jpVar.r()) {
            spannable.setSpan(new UnderlineSpan(), i3, i4, 33);
        }
        if (jpVar.p()) {
            pk.a(spannable, new ForegroundColorSpan(jpVar.b()), i3, i4, 33);
        }
        if (jpVar.o()) {
            pk.a(spannable, new BackgroundColorSpan(jpVar.a()), i3, i4, 33);
        }
        if (jpVar.c() != null) {
            pk.a(spannable, new TypefaceSpan(jpVar.c()), i3, i4, 33);
        }
        if (jpVar.n() != null) {
            xn xnVar = (xn) b1.a(jpVar.n());
            int i7 = xnVar.f65024a;
            if (i7 == -1) {
                i7 = (i5 == 2 || i5 == 1) ? 3 : 1;
                i6 = 1;
            } else {
                i6 = xnVar.f65025b;
            }
            int i8 = xnVar.f65026c;
            if (i8 == -2) {
                i8 = 1;
            }
            pk.a(spannable, new yn(i7, i6, i8), i3, i4, 33);
        }
        int i9 = jpVar.i();
        if (i9 == 2) {
            gp gpVarA = a(gpVar, map);
            if (gpVarA != null && (gpVarB = b(gpVarA, map)) != null) {
                if (gpVarB.a() != 1 || gpVarB.a(0).f60030b == null) {
                    oc.c("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                } else {
                    String str = (String) xp.a((Object) gpVarB.a(0).f60030b);
                    jp jpVarA2 = a(gpVarB.f60034f, gpVarB.c(), map);
                    int iH = jpVarA2 != null ? jpVarA2.h() : -1;
                    if (iH == -1 && (jpVarA = a(gpVarA.f60034f, gpVarA.c(), map)) != null) {
                        iH = jpVarA.h();
                    }
                    spannable.setSpan(new zi(str, iH), i3, i4, 33);
                }
            }
        } else if (i9 == 3 || i9 == 4) {
            spannable.setSpan(new n6(), i3, i4, 33);
        }
        if (jpVar.m()) {
            pk.a(spannable, new oa(), i3, i4, 33);
        }
        int iE = jpVar.e();
        if (iE == 1) {
            pk.a(spannable, new AbsoluteSizeSpan((int) jpVar.d(), true), i3, i4, 33);
        } else if (iE == 2) {
            pk.a(spannable, new RelativeSizeSpan(jpVar.d()), i3, i4, 33);
        } else {
            if (iE != 3) {
                return;
            }
            pk.a(spannable, new RelativeSizeSpan(jpVar.d() / 100.0f), i3, i4, 33);
        }
    }

    private static gp b(gp gpVar, Map map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gpVar);
        while (!arrayDeque.isEmpty()) {
            gp gpVar2 = (gp) arrayDeque.pop();
            jp jpVarA = a(gpVar2.f60034f, gpVar2.c(), map);
            if (jpVarA != null && jpVarA.i() == 3) {
                return gpVar2;
            }
            for (int iA = gpVar2.a() - 1; iA >= 0; iA--) {
                arrayDeque.push(gpVar2.a(iA));
            }
        }
        return null;
    }

    static String a(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    static void a(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    private static gp a(gp gpVar, Map map) {
        while (gpVar != null) {
            jp jpVarA = a(gpVar.f60034f, gpVar.c(), map);
            if (jpVarA != null && jpVarA.i() == 1) {
                return gpVar;
            }
            gpVar = gpVar.f60038j;
        }
        return null;
    }

    public static jp a(jp jpVar, String[] strArr, Map map) {
        int i3 = 0;
        if (jpVar == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return (jp) map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                jp jpVar2 = new jp();
                int length = strArr.length;
                while (i3 < length) {
                    jpVar2.a((jp) map.get(strArr[i3]));
                    i3++;
                }
                return jpVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                return jpVar.a((jp) map.get(strArr[0]));
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i3 < length2) {
                    jpVar.a((jp) map.get(strArr[i3]));
                    i3++;
                }
            }
        }
        return jpVar;
    }
}
