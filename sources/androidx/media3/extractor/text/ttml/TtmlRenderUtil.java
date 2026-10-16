package androidx.media3.extractor.text.ttml;

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
import androidx.media3.common.text.HorizontalTextInVerticalContextSpan;
import androidx.media3.common.text.RubySpan;
import androidx.media3.common.text.SpanUtil;
import androidx.media3.common.text.TextEmphasisSpan;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import java.util.ArrayDeque;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
final class TtmlRenderUtil {
    static String b(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    static void c(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    private static TtmlNode d(TtmlNode ttmlNode, Map map) {
        while (ttmlNode != null) {
            TtmlStyle ttmlStyleF = f(ttmlNode.f47196f, ttmlNode.l(), map);
            if (ttmlStyleF != null && ttmlStyleF.l() == 1) {
                return ttmlNode;
            }
            ttmlNode = ttmlNode.f47200j;
        }
        return null;
    }

    private static TtmlNode e(TtmlNode ttmlNode, Map map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(ttmlNode);
        while (!arrayDeque.isEmpty()) {
            TtmlNode ttmlNode2 = (TtmlNode) arrayDeque.pop();
            TtmlStyle ttmlStyleF = f(ttmlNode2.f47196f, ttmlNode2.l(), map);
            if (ttmlStyleF != null && ttmlStyleF.l() == 3) {
                return ttmlNode2;
            }
            for (int iG = ttmlNode2.g() - 1; iG >= 0; iG--) {
                arrayDeque.push(ttmlNode2.f(iG));
            }
        }
        return null;
    }

    public static TtmlStyle f(TtmlStyle ttmlStyle, String[] strArr, Map map) {
        int i3 = 0;
        if (ttmlStyle == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return (TtmlStyle) map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                TtmlStyle ttmlStyle2 = new TtmlStyle();
                int length = strArr.length;
                while (i3 < length) {
                    ttmlStyle2.a((TtmlStyle) map.get(strArr[i3]));
                    i3++;
                }
                return ttmlStyle2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                return ttmlStyle.a((TtmlStyle) map.get(strArr[0]));
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i3 < length2) {
                    ttmlStyle.a((TtmlStyle) map.get(strArr[i3]));
                    i3++;
                }
            }
        }
        return ttmlStyle;
    }

    public static void a(Spannable spannable, int i3, int i4, TtmlStyle ttmlStyle, TtmlNode ttmlNode, Map map, int i5) {
        TtmlNode ttmlNodeE;
        int iK;
        TtmlStyle ttmlStyleF;
        int i6;
        if (ttmlStyle.n() != -1) {
            spannable.setSpan(new StyleSpan(ttmlStyle.n()), i3, i4, 33);
        }
        if (ttmlStyle.u()) {
            spannable.setSpan(new StrikethroughSpan(), i3, i4, 33);
        }
        if (ttmlStyle.v()) {
            spannable.setSpan(new UnderlineSpan(), i3, i4, 33);
        }
        if (ttmlStyle.s()) {
            SpanUtil.b(spannable, new ForegroundColorSpan(ttmlStyle.d()), i3, i4, 33);
        }
        if (ttmlStyle.r()) {
            SpanUtil.b(spannable, new BackgroundColorSpan(ttmlStyle.b()), i3, i4, 33);
        }
        if (ttmlStyle.e() != null) {
            SpanUtil.b(spannable, new TypefaceSpan(ttmlStyle.e()), i3, i4, 33);
        }
        if (ttmlStyle.q() != null) {
            TextEmphasis textEmphasis = (TextEmphasis) Assertions.e(ttmlStyle.q());
            int i7 = textEmphasis.f47188a;
            if (i7 == -1) {
                if (i5 != 2 && i5 != 1) {
                    i7 = 1;
                } else {
                    i7 = 3;
                }
                i6 = 1;
            } else {
                i6 = textEmphasis.f47189b;
            }
            int i8 = textEmphasis.f47190c;
            if (i8 == -2) {
                i8 = 1;
            }
            SpanUtil.b(spannable, new TextEmphasisSpan(i7, i6, i8), i3, i4, 33);
        }
        int iL = ttmlStyle.l();
        if (iL != 2) {
            if (iL == 3 || iL == 4) {
                spannable.setSpan(new DeleteTextSpan(), i3, i4, 33);
            }
        } else {
            TtmlNode ttmlNodeD = d(ttmlNode, map);
            if (ttmlNodeD != null && (ttmlNodeE = e(ttmlNodeD, map)) != null) {
                if (ttmlNodeE.g() == 1 && ttmlNodeE.f(0).f47192b != null) {
                    String str = (String) Util.k(ttmlNodeE.f(0).f47192b);
                    TtmlStyle ttmlStyleF2 = f(ttmlNodeE.f47196f, ttmlNodeE.l(), map);
                    if (ttmlStyleF2 != null) {
                        iK = ttmlStyleF2.k();
                    } else {
                        iK = -1;
                    }
                    if (iK == -1 && (ttmlStyleF = f(ttmlNodeD.f47196f, ttmlNodeD.l(), map)) != null) {
                        iK = ttmlStyleF.k();
                    }
                    spannable.setSpan(new RubySpan(str, iK), i3, i4, 33);
                } else {
                    Log.g("TtmlRenderUtil", wgbAZXYjrv.BVwEqfb);
                }
            }
        }
        if (ttmlStyle.p()) {
            SpanUtil.b(spannable, new HorizontalTextInVerticalContextSpan(), i3, i4, 33);
        }
        int iG = ttmlStyle.g();
        if (iG != 1) {
            if (iG != 2) {
                if (iG != 3) {
                    return;
                }
                SpanUtil.a(spannable, ttmlStyle.f() / 100.0f, i3, i4, 33);
                return;
            }
            SpanUtil.b(spannable, new RelativeSizeSpan(ttmlStyle.f()), i3, i4, 33);
            return;
        }
        SpanUtil.b(spannable, new AbsoluteSizeSpan((int) ttmlStyle.f(), true), i3, i4, 33);
    }
}
