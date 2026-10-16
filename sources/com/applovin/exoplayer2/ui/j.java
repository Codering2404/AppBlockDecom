package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.applovin.exoplayer2.ui.SubtitleView;
import com.applovin.impl.a5;
import com.applovin.impl.x2;
import com.applovin.impl.xp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class j extends FrameLayout implements SubtitleView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.exoplayer2.ui.a f58118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WebView f58119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f58120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private x2 f58121d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f58122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f58123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f58124h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends WebView {
        a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.webkit.WebView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            super.performClick();
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f58126a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f58126a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f58126a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f58126a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public j(Context context) {
        this(context, null);
    }

    private static int a(int i3) {
        if (i3 != 1) {
            return i3 != 2 ? 0 : -100;
        }
        return -50;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            Method dump skipped, instruction units count: 618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.ui.j.b():void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        if (!z2 || this.f58120c.isEmpty()) {
            return;
        }
        b();
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f58120c = Collections.EMPTY_LIST;
        this.f58121d = x2.f64786g;
        this.f58122f = 0.0533f;
        this.f58123g = 0;
        this.f58124h = 0.08f;
        com.applovin.exoplayer2.ui.a aVar = new com.applovin.exoplayer2.ui.a(context, attributeSet);
        this.f58118a = aVar;
        a aVar2 = new a(context, attributeSet);
        this.f58119b = aVar2;
        aVar2.setBackgroundColor(0);
        addView(aVar);
        addView(aVar2);
    }

    private static String a(x2 x2Var) {
        int i3 = x2Var.f64790d;
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? "unset" : xp.a("-0.05em -0.05em 0.15em %s", c.a(x2Var.f64791e)) : xp.a("0.06em 0.08em 0.15em %s", c.a(x2Var.f64791e)) : xp.a("0.1em 0.12em 0.15em %s", c.a(x2Var.f64791e)) : xp.a("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", c.a(x2Var.f64791e));
    }

    private static String a(a5 a5Var) {
        String str;
        float f3 = a5Var.f58189r;
        if (f3 != 0.0f) {
            int i3 = a5Var.f58188q;
            if (i3 != 2 && i3 != 1) {
                str = "skewX";
            } else {
                str = "skewY";
            }
            return xp.a("%s(%.2fdeg)", str, Float.valueOf(f3));
        }
        return "";
    }

    @Override // com.applovin.exoplayer2.ui.SubtitleView.a
    public void a(List list, x2 x2Var, float f3, int i3, float f4) {
        this.f58121d = x2Var;
        this.f58122f = f3;
        this.f58123g = i3;
        this.f58124h = f4;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            a5 a5Var = (a5) list.get(i4);
            if (a5Var.f58176d != null) {
                arrayList.add(a5Var);
            } else {
                arrayList2.add(a5Var);
            }
        }
        if (!this.f58120c.isEmpty() || !arrayList2.isEmpty()) {
            this.f58120c = arrayList2;
            b();
        }
        this.f58118a.a(arrayList, x2Var, f3, i3, f4);
        invalidate();
    }

    public void a() {
        this.f58119b.destroy();
    }

    private String a(int i3, float f3) {
        float fA = h.a(i3, f3, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (fA == -3.4028235E38f) {
            return "unset";
        }
        return xp.a("%.2fpx", Float.valueOf(fA / getContext().getResources().getDisplayMetrics().density));
    }

    private static String a(Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i3 = b.f58126a[alignment.ordinal()];
        if (i3 != 1) {
            return i3 != 2 ? "center" : "end";
        }
        return "start";
    }

    private static String b(int i3) {
        if (i3 == 1) {
            return "vertical-rl";
        }
        if (i3 != 2) {
            return "horizontal-tb";
        }
        return "vertical-lr";
    }
}
