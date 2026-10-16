package com.borax12.materialdaterangepicker.date;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.borax12.materialdaterangepicker.R;
import com.borax12.materialdaterangepicker.date.MonthAdapter;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class MonthView extends View {
    protected static int M = 32;
    protected static int N = 10;
    protected static int O = 1;
    protected static int P;
    protected static int Q;
    protected static int R;
    protected static int S;
    protected static int T;
    private final MonthViewTouchHelper A;
    protected int B;
    protected OnDayClickListener C;
    private boolean D;
    protected int E;
    protected int F;
    protected int G;
    protected int H;
    protected int I;
    protected int J;
    protected int K;
    private int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected DatePickerController f65838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f65839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Paint f65840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Paint f65841d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Paint f65842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected Paint f65843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Formatter f65844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final StringBuilder f65845i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f65846j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f65847k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f65848l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected int f65849m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f65850n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected int f65851o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f65852p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected boolean f65853q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected int f65854r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected int f65855s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected int f65856t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected int f65857u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected int f65858v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected int f65859w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int f65860x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Calendar f65861y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected final Calendar f65862z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected class MonthViewTouchHelper extends ExploreByTouchHelper {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final Rect f65863q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final Calendar f65864r;

        public MonthViewTouchHelper(View view) {
            super(view);
            this.f65863q = new Rect();
            this.f65864r = Calendar.getInstance();
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int C(float f3, float f4) {
            int iH = MonthView.this.h(f3, f4);
            if (iH >= 0) {
                return iH;
            }
            return Integer.MIN_VALUE;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void D(List list) {
            for (int i3 = 1; i3 <= MonthView.this.f65858v; i3++) {
                list.add(Integer.valueOf(i3));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean N(int i3, int i4, Bundle bundle) {
            if (i4 != 16) {
                return false;
            }
            MonthView.this.p(i3);
            return true;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void P(int i3, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(b0(i3));
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void R(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            a0(i3, this.f65863q);
            accessibilityNodeInfoCompat.m0(b0(i3));
            accessibilityNodeInfoCompat.d0(this.f65863q);
            accessibilityNodeInfoCompat.a(16);
            if (i3 == MonthView.this.f65854r) {
                accessibilityNodeInfoCompat.L0(true);
            }
        }

        protected void a0(int i3, Rect rect) {
            MonthView monthView = MonthView.this;
            int i4 = monthView.f65839b;
            int monthHeaderSize = monthView.getMonthHeaderSize();
            MonthView monthView2 = MonthView.this;
            int i5 = monthView2.f65852p;
            int i6 = (monthView2.f65851o - (monthView2.f65839b * 2)) / monthView2.f65857u;
            int iG = (i3 - 1) + monthView2.g();
            int i7 = MonthView.this.f65857u;
            int i8 = i4 + ((iG % i7) * i6);
            int i9 = monthHeaderSize + ((iG / i7) * i5);
            rect.set(i8, i9, i6 + i8, i5 + i9);
        }

        protected CharSequence b0(int i3) {
            Calendar calendar = this.f65864r;
            MonthView monthView = MonthView.this;
            calendar.set(monthView.f65850n, monthView.f65849m, i3);
            CharSequence charSequence = DateFormat.format("dd MMMM yyyy", this.f65864r.getTimeInMillis());
            MonthView monthView2 = MonthView.this;
            return i3 == monthView2.f65854r ? monthView2.getContext().getString(R.string.f65736h, charSequence) : charSequence;
        }

        public void c0(int i3) {
            b(MonthView.this).f(i3, 64, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnDayClickListener {
        void a(MonthView monthView, MonthAdapter.CalendarDay calendarDay);
    }

    public MonthView(Context context, AttributeSet attributeSet, DatePickerController datePickerController) {
        super(context, attributeSet);
        this.f65839b = 0;
        this.f65846j = -1;
        this.f65847k = -1;
        this.f65848l = -1;
        this.f65852p = M;
        this.f65853q = false;
        this.f65854r = -1;
        this.f65855s = -1;
        this.f65856t = 1;
        this.f65857u = 7;
        this.f65858v = 7;
        this.f65859w = -1;
        this.f65860x = -1;
        this.B = 6;
        this.L = 0;
        this.f65838a = datePickerController;
        Resources resources = context.getResources();
        this.f65862z = Calendar.getInstance();
        this.f65861y = Calendar.getInstance();
        DatePickerController datePickerController2 = this.f65838a;
        if (datePickerController2 == null || !datePickerController2.b()) {
            this.E = resources.getColor(R.color.f65681o);
            this.G = resources.getColor(R.color.f65675i);
            this.J = resources.getColor(R.color.f65677k);
            this.I = resources.getColor(R.color.f65679m);
        } else {
            this.E = resources.getColor(R.color.f65682p);
            this.G = resources.getColor(R.color.f65676j);
            this.J = resources.getColor(R.color.f65678l);
            this.I = resources.getColor(R.color.f65680n);
        }
        int i3 = R.color.f65689w;
        this.F = resources.getColor(i3);
        this.H = resources.getColor(R.color.f65667a);
        this.K = resources.getColor(i3);
        StringBuilder sb = new StringBuilder(50);
        this.f65845i = sb;
        this.f65844h = new Formatter(sb, Locale.getDefault());
        P = resources.getDimensionPixelSize(R.dimen.f65692c);
        Q = resources.getDimensionPixelSize(R.dimen.f65694e);
        R = resources.getDimensionPixelSize(R.dimen.f65693d);
        S = resources.getDimensionPixelOffset(R.dimen.f65695f);
        T = resources.getDimensionPixelSize(R.dimen.f65691b);
        this.f65852p = (resources.getDimensionPixelOffset(R.dimen.f65690a) - getMonthHeaderSize()) / 6;
        MonthViewTouchHelper monthViewTouchHelper = getMonthViewTouchHelper();
        this.A = monthViewTouchHelper;
        ViewCompat.m0(this, monthViewTouchHelper);
        ViewCompat.w0(this, 1);
        this.D = true;
        j();
    }

    private int b() {
        int iG = g();
        int i3 = this.f65858v;
        int i4 = this.f65857u;
        return ((iG + i3) / i4) + ((iG + i3) % i4 > 0 ? 1 : 0);
    }

    private String getMonthAndYearString() {
        this.f65845i.setLength(0);
        long timeInMillis = this.f65861y.getTimeInMillis();
        return DateUtils.formatDateRange(getContext(), this.f65844h, timeInMillis, timeInMillis, 52, null).toString();
    }

    private boolean k(int i3, int i4, int i5) {
        Calendar calendarA;
        DatePickerController datePickerController = this.f65838a;
        if (datePickerController == null || (calendarA = datePickerController.a()) == null) {
            return false;
        }
        if (i3 > calendarA.get(1)) {
            return true;
        }
        if (i3 < calendarA.get(1)) {
            return false;
        }
        if (i4 > calendarA.get(2)) {
            return true;
        }
        return i4 >= calendarA.get(2) && i5 > calendarA.get(5);
    }

    private boolean l(int i3, int i4, int i5) {
        Calendar calendarC;
        DatePickerController datePickerController = this.f65838a;
        if (datePickerController == null || (calendarC = datePickerController.c()) == null) {
            return false;
        }
        if (i3 < calendarC.get(1)) {
            return true;
        }
        if (i3 > calendarC.get(1)) {
            return false;
        }
        if (i4 < calendarC.get(2)) {
            return true;
        }
        return i4 <= calendarC.get(2) && i5 < calendarC.get(5);
    }

    private boolean o(int i3, int i4, int i5) {
        for (Calendar calendar : this.f65838a.i()) {
            if (i3 < calendar.get(1)) {
                break;
            }
            if (i3 <= calendar.get(1)) {
                if (i4 < calendar.get(2)) {
                    break;
                }
                if (i4 > calendar.get(2)) {
                    continue;
                } else {
                    if (i5 < calendar.get(5)) {
                        break;
                    }
                    if (i5 <= calendar.get(5)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i3) {
        if (n(this.f65850n, this.f65849m, i3)) {
            return;
        }
        OnDayClickListener onDayClickListener = this.C;
        if (onDayClickListener != null) {
            onDayClickListener.a(this, new MonthAdapter.CalendarDay(this.f65850n, this.f65849m, i3));
        }
        this.A.Y(i3, 1);
    }

    private boolean s(int i3, Calendar calendar) {
        return this.f65850n == calendar.get(1) && this.f65849m == calendar.get(2) && i3 == calendar.get(5);
    }

    public abstract void c(Canvas canvas, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11);

    protected void d(Canvas canvas) {
        int monthHeaderSize = getMonthHeaderSize() - (R / 2);
        int i3 = (this.f65851o - (this.f65839b * 2)) / (this.f65857u * 2);
        int i4 = 0;
        while (true) {
            int i5 = this.f65857u;
            if (i4 >= i5) {
                return;
            }
            int i6 = (((i4 * 2) + 1) * i3) + this.f65839b;
            this.f65862z.set(7, (this.f65856t + i4) % i5);
            Locale locale = Locale.getDefault();
            String displayName = this.f65862z.getDisplayName(7, 1, locale);
            String strSubstring = displayName.toUpperCase(locale).substring(0, 1);
            if (locale.equals(Locale.CHINA) || locale.equals(Locale.CHINESE) || locale.equals(Locale.SIMPLIFIED_CHINESE) || locale.equals(Locale.TRADITIONAL_CHINESE)) {
                int length = displayName.length();
                strSubstring = displayName.substring(length - 1, length);
            }
            if (locale.getLanguage().equals("he") || locale.getLanguage().equals("iw")) {
                if (this.f65862z.get(7) != 7) {
                    int length2 = displayName.length();
                    strSubstring = displayName.substring(length2 - 2, length2 - 1);
                } else {
                    strSubstring = displayName.toUpperCase(locale).substring(0, 1);
                }
            }
            canvas.drawText(strSubstring, i6, monthHeaderSize, this.f65843g);
            i4++;
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.A.v(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    protected void e(Canvas canvas) {
        float f3 = (this.f65851o - (this.f65839b * 2)) / (this.f65857u * 2.0f);
        int monthHeaderSize = (((this.f65852p + P) / 2) - O) + getMonthHeaderSize();
        int iG = g();
        for (int i3 = 1; i3 <= this.f65858v; i3++) {
            int i4 = (int) ((((iG * 2) + 1) * f3) + this.f65839b);
            int i5 = this.f65852p;
            float f4 = i4;
            int i6 = monthHeaderSize - (((P + i5) / 2) - O);
            c(canvas, this.f65850n, this.f65849m, i3, i4, monthHeaderSize, (int) (f4 - f3), (int) (f4 + f3), i6, i6 + i5);
            iG++;
            if (iG == this.f65857u) {
                monthHeaderSize += this.f65852p;
                iG = 0;
            }
        }
    }

    protected void f(Canvas canvas) {
        canvas.drawText(getMonthAndYearString(), (this.f65851o + (this.f65839b * 2)) / 2, (getMonthHeaderSize() - R) / 2, this.f65841d);
    }

    protected int g() {
        int i3 = this.L;
        int i4 = this.f65856t;
        if (i3 < i4) {
            i3 += this.f65857u;
        }
        return i3 - i4;
    }

    public MonthAdapter.CalendarDay getAccessibilityFocus() {
        int iA = this.A.A();
        if (iA >= 0) {
            return new MonthAdapter.CalendarDay(this.f65850n, this.f65849m, iA);
        }
        return null;
    }

    public int getMonth() {
        return this.f65849m;
    }

    protected int getMonthHeaderSize() {
        return S;
    }

    protected MonthViewTouchHelper getMonthViewTouchHelper() {
        return new MonthViewTouchHelper(this);
    }

    public int getYear() {
        return this.f65850n;
    }

    public int h(float f3, float f4) {
        int i3 = i(f3, f4);
        if (i3 < 1 || i3 > this.f65858v) {
            return -1;
        }
        return i3;
    }

    protected int i(float f3, float f4) {
        float f5 = this.f65839b;
        if (f3 < f5 || f3 > this.f65851o - r0) {
            return -1;
        }
        return (((int) (((f3 - f5) * this.f65857u) / ((this.f65851o - r0) - this.f65839b))) - g()) + 1 + ((((int) (f4 - getMonthHeaderSize())) / this.f65852p) * this.f65857u);
    }

    protected void j() {
        Paint paint = new Paint();
        this.f65841d = paint;
        paint.setFakeBoldText(true);
        this.f65841d.setAntiAlias(true);
        this.f65841d.setTextSize(Q);
        Paint paint2 = this.f65841d;
        Context context = getContext();
        int i3 = R.font.f65698a;
        paint2.setTypeface(ResourcesCompat.i(context, i3));
        this.f65841d.setColor(this.E);
        Paint paint3 = this.f65841d;
        Paint.Align align = Paint.Align.CENTER;
        paint3.setTextAlign(align);
        Paint paint4 = this.f65841d;
        Paint.Style style = Paint.Style.FILL;
        paint4.setStyle(style);
        Paint paint5 = new Paint();
        this.f65842f = paint5;
        paint5.setFakeBoldText(true);
        this.f65842f.setAntiAlias(true);
        this.f65842f.setColor(this.H);
        this.f65842f.setTextAlign(align);
        this.f65842f.setStyle(style);
        this.f65842f.setAlpha(255);
        Paint paint6 = new Paint();
        this.f65843g = paint6;
        paint6.setAntiAlias(true);
        this.f65843g.setTextSize(R);
        this.f65843g.setColor(this.G);
        this.f65843g.setTypeface(ResourcesCompat.i(getContext(), i3));
        this.f65843g.setStyle(style);
        this.f65843g.setTextAlign(align);
        this.f65843g.setFakeBoldText(true);
        Paint paint7 = new Paint();
        this.f65840c = paint7;
        paint7.setAntiAlias(true);
        this.f65840c.setTextSize(P);
        this.f65840c.setStyle(style);
        this.f65840c.setTextAlign(align);
        this.f65840c.setFakeBoldText(false);
    }

    protected boolean m(int i3, int i4, int i5) {
        Calendar[] calendarArrJ = this.f65838a.j();
        if (calendarArrJ == null) {
            return false;
        }
        for (Calendar calendar : calendarArrJ) {
            if (i3 < calendar.get(1)) {
                break;
            }
            if (i3 <= calendar.get(1)) {
                if (i4 < calendar.get(2)) {
                    break;
                }
                if (i4 > calendar.get(2)) {
                    continue;
                } else {
                    if (i5 < calendar.get(5)) {
                        break;
                    }
                    if (i5 <= calendar.get(5)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    protected boolean n(int i3, int i4, int i5) {
        return this.f65838a.i() != null ? !o(i3, i4, i5) : l(i3, i4, i5) || k(i3, i4, i5);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        f(canvas);
        d(canvas);
        e(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        setMeasuredDimension(View.MeasureSpec.getSize(i3), (this.f65852p * this.B) + getMonthHeaderSize() + 5);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        this.f65851o = i3;
        this.A.F();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int iH;
        if (motionEvent.getAction() == 1 && (iH = h(motionEvent.getX(), motionEvent.getY())) >= 0) {
            p(iH);
        }
        return true;
    }

    public boolean q(MonthAdapter.CalendarDay calendarDay) {
        int i3;
        if (calendarDay.f65835b != this.f65850n || calendarDay.f65836c != this.f65849m || (i3 = calendarDay.f65837d) > this.f65858v) {
            return false;
        }
        this.A.c0(i3);
        return true;
    }

    public void r() {
        this.B = 6;
        requestLayout();
    }

    public void setAccentColor(int i3) {
        this.H = i3;
        this.f65842f.setColor(i3);
    }

    @Override // android.view.View
    public void setAccessibilityDelegate(View.AccessibilityDelegate accessibilityDelegate) {
        if (this.D) {
            return;
        }
        super.setAccessibilityDelegate(accessibilityDelegate);
    }

    public void setDatePickerController(DatePickerController datePickerController) {
        this.f65838a = datePickerController;
    }

    public void setMonthParams(HashMap<String, Integer> map) {
        if (!map.containsKey("month") && !map.containsKey("year")) {
            throw new InvalidParameterException("You must specify month and year for this view");
        }
        setTag(map);
        if (map.containsKey(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
            int iIntValue = map.get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY).intValue();
            this.f65852p = iIntValue;
            int i3 = N;
            if (iIntValue < i3) {
                this.f65852p = i3;
            }
        }
        if (map.containsKey("selected_day")) {
            this.f65854r = map.get("selected_day").intValue();
        }
        this.f65849m = map.get("month").intValue();
        this.f65850n = map.get("year").intValue();
        Calendar calendar = Calendar.getInstance();
        int i4 = 0;
        this.f65853q = false;
        this.f65855s = -1;
        this.f65861y.set(2, this.f65849m);
        this.f65861y.set(1, this.f65850n);
        this.f65861y.set(5, 1);
        this.L = this.f65861y.get(7);
        if (map.containsKey("week_start")) {
            this.f65856t = map.get("week_start").intValue();
        } else {
            this.f65856t = this.f65861y.getFirstDayOfWeek();
        }
        this.f65858v = this.f65861y.getActualMaximum(5);
        while (i4 < this.f65858v) {
            i4++;
            if (s(i4, calendar)) {
                this.f65853q = true;
                this.f65855s = i4;
            }
        }
        this.B = b();
        this.A.F();
    }

    public void setOnDayClickListener(OnDayClickListener onDayClickListener) {
        this.C = onDayClickListener;
    }

    public void setSelectedDay(int i3) {
        this.f65854r = i3;
    }
}
