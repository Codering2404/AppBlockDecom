package com.applovin.exoplayer2.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import com.applovin.exoplayer2.ui.f;
import com.applovin.impl.b1;
import com.applovin.impl.fb;
import com.applovin.impl.oa;
import com.applovin.impl.xp;
import com.applovin.impl.yn;
import com.applovin.impl.zi;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f58081a = Pattern.compile("(&#13;)?&#10;");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f58082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f58083b;

        private b(String str, Map map) {
            this.f58082a = str;
            this.f58083b = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Comparator f58084e = new Comparator() { // from class: com.applovin.exoplayer2.ui.o
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return f.c.a((f.c) obj, (f.c) obj2);
            }
        };

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Comparator f58085f = new Comparator() { // from class: com.applovin.exoplayer2.ui.p
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return f.c.b((f.c) obj, (f.c) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f58086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f58087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f58088c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f58089d;

        private c(int i3, int i4, String str, String str2) {
            this.f58086a = i3;
            this.f58087b = i4;
            this.f58088c = str;
            this.f58089d = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int a(c cVar, c cVar2) {
            int iCompare = Integer.compare(cVar2.f58087b, cVar.f58087b);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = cVar.f58088c.compareTo(cVar2.f58088c);
            return iCompareTo != 0 ? iCompareTo : cVar.f58089d.compareTo(cVar2.f58089d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int b(c cVar, c cVar2) {
            int iCompare = Integer.compare(cVar2.f58086a, cVar.f58086a);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = cVar2.f58088c.compareTo(cVar.f58088c);
            return iCompareTo != 0 ? iCompareTo : cVar2.f58089d.compareTo(cVar.f58089d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f58090a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f58091b = new ArrayList();
    }

    public static b a(CharSequence charSequence, float f3) {
        if (charSequence == null) {
            return new b("", fb.h());
        }
        if (!(charSequence instanceof Spanned)) {
            return new b(a(charSequence), fb.h());
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet hashSet = new HashSet();
        int i3 = 0;
        for (BackgroundColorSpan backgroundColorSpan : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColorSpan.getBackgroundColor()));
        }
        HashMap map = new HashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            map.put(com.applovin.exoplayer2.ui.c.a("bg_" + iIntValue), xp.a("background-color:%s;", com.applovin.exoplayer2.ui.c.a(iIntValue)));
        }
        SparseArray sparseArrayA = a(spanned, f3);
        StringBuilder sb = new StringBuilder(spanned.length());
        int i4 = 0;
        while (i3 < sparseArrayA.size()) {
            int iKeyAt = sparseArrayA.keyAt(i3);
            sb.append(a(spanned.subSequence(i4, iKeyAt)));
            d dVar = (d) sparseArrayA.get(iKeyAt);
            Collections.sort(dVar.f58091b, c.f58085f);
            Iterator it2 = dVar.f58091b.iterator();
            while (it2.hasNext()) {
                sb.append(((c) it2.next()).f58089d);
            }
            Collections.sort(dVar.f58090a, c.f58084e);
            Iterator it3 = dVar.f58090a.iterator();
            while (it3.hasNext()) {
                sb.append(((c) it3.next()).f58088c);
            }
            i3++;
            i4 = iKeyAt;
        }
        sb.append(a(spanned.subSequence(i4, spanned.length())));
        return new b(sb.toString(), map);
    }

    private static SparseArray a(Spanned spanned, float f3) {
        SparseArray sparseArray = new SparseArray();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String strA = a(obj, f3);
            String strA2 = a(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (strA != null) {
                b1.a((Object) strA2);
                c cVar = new c(spanStart, spanEnd, strA, strA2);
                a(sparseArray, spanStart).f58090a.add(cVar);
                a(sparseArray, spanEnd).f58091b.add(cVar);
            }
        }
        return sparseArray;
    }

    private static String a(Object obj, float f3) {
        float size;
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return xp.a("<span style='color:%s;'>", com.applovin.exoplayer2.ui.c.a(((ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof BackgroundColorSpan) {
            return xp.a("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof oa) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (obj instanceof AbsoluteSizeSpan) {
            AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
            if (absoluteSizeSpan.getDip()) {
                size = absoluteSizeSpan.getSize();
            } else {
                size = absoluteSizeSpan.getSize() / f3;
            }
            return xp.a("<span style='font-size:%.2fpx;'>", Float.valueOf(size));
        }
        if (obj instanceof RelativeSizeSpan) {
            return xp.a("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        }
        if (obj instanceof TypefaceSpan) {
            String family = ((TypefaceSpan) obj).getFamily();
            if (family != null) {
                return xp.a("<span style='font-family:\"%s\";'>", family);
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "<b>";
            }
            if (style == 2) {
                return "<i>";
            }
            if (style != 3) {
                return null;
            }
            return "<b><i>";
        }
        if (obj instanceof zi) {
            int i3 = ((zi) obj).f65441b;
            if (i3 == -1) {
                return "<ruby style='ruby-position:unset;'>";
            }
            if (i3 == 1) {
                return "<ruby style='ruby-position:over;'>";
            }
            if (i3 != 2) {
                return null;
            }
            return "<ruby style='ruby-position:under;'>";
        }
        if (obj instanceof UnderlineSpan) {
            return "<u>";
        }
        if (!(obj instanceof yn)) {
            return null;
        }
        yn ynVar = (yn) obj;
        return xp.a("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", a(ynVar.f65239a, ynVar.f65240b), a(ynVar.f65241c));
    }

    private static String a(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof oa) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof yn)) {
            return "</span>";
        }
        if (obj instanceof TypefaceSpan) {
            if (((TypefaceSpan) obj).getFamily() != null) {
                return "</span>";
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "</b>";
            }
            if (style == 2) {
                return "</i>";
            }
            if (style == 3) {
                return "</i></b>";
            }
        } else {
            if (obj instanceof zi) {
                return "<rt>" + a((CharSequence) ((zi) obj).f65440a) + "</rt></ruby>";
            }
            if (obj instanceof UnderlineSpan) {
                return "</u>";
            }
        }
        return null;
    }

    private static String a(int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        if (i4 == 1) {
            sb.append("filled ");
        } else if (i4 == 2) {
            sb.append("open ");
        }
        if (i3 == 0) {
            sb.append(IntegrityManager.INTEGRITY_TYPE_NONE);
        } else if (i3 == 1) {
            sb.append("circle");
        } else if (i3 == 2) {
            sb.append("dot");
        } else if (i3 != 3) {
            sb.append("unset");
        } else {
            sb.append("sesame");
        }
        return sb.toString();
    }

    private static String a(int i3) {
        if (i3 != 2) {
            return "over right";
        }
        return "under left";
    }

    private static d a(SparseArray sparseArray, int i3) {
        d dVar = (d) sparseArray.get(i3);
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d();
        sparseArray.put(i3, dVar2);
        return dVar2;
    }

    private static String a(CharSequence charSequence) {
        return f58081a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }
}
