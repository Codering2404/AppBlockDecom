package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MaterialCalendar<S> extends PickerFragment<S> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final Object f80786p = "MONTHS_VIEW_GROUP_TAG";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final Object f80787q = "NAVIGATION_PREV_TAG";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final Object f80788r = "NAVIGATION_NEXT_TAG";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final Object f80789s = "SELECTOR_TOGGLE_TAG";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f80790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DateSelector f80791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CalendarConstraints f80792d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DayViewDecorator f80793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Month f80794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CalendarSelector f80795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CalendarStyle f80796i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private RecyclerView f80797j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private RecyclerView f80798k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f80799l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f80800m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private View f80801n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private View f80802o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum CalendarSelector {
        DAY,
        YEAR
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface OnDayClickListener {
        void a(long j3);
    }

    private void F(View view, final MonthsPagerAdapter monthsPagerAdapter) {
        final MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.F);
        materialButton.setTag(f80789s);
        ViewCompat.m0(materialButton, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialCalendar.6
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view2, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.v0(MaterialCalendar.this.f80802o.getVisibility() == 0 ? MaterialCalendar.this.getString(R.string.f79702c0) : MaterialCalendar.this.getString(R.string.f79698a0));
            }
        });
        View viewFindViewById = view.findViewById(R.id.H);
        this.f80799l = viewFindViewById;
        viewFindViewById.setTag(f80787q);
        View viewFindViewById2 = view.findViewById(R.id.G);
        this.f80800m = viewFindViewById2;
        viewFindViewById2.setTag(f80788r);
        this.f80801n = view.findViewById(R.id.P);
        this.f80802o = view.findViewById(R.id.K);
        S(CalendarSelector.DAY);
        materialButton.setText(this.f80794g.i());
        this.f80798k.n(new RecyclerView.OnScrollListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void a(RecyclerView recyclerView, int i3) {
                if (i3 == 0) {
                    recyclerView.announceForAccessibility(materialButton.getText());
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void b(RecyclerView recyclerView, int i3, int i4) {
                int iD2 = i3 < 0 ? MaterialCalendar.this.O().d2() : MaterialCalendar.this.O().f2();
                MaterialCalendar.this.f80794g = monthsPagerAdapter.h(iD2);
                materialButton.setText(monthsPagerAdapter.i(iD2));
            }
        });
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MaterialCalendar.this.U();
            }
        });
        this.f80800m.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int iD2 = MaterialCalendar.this.O().d2() + 1;
                if (iD2 < MaterialCalendar.this.f80798k.getAdapter().getItemCount()) {
                    MaterialCalendar.this.R(monthsPagerAdapter.h(iD2));
                }
            }
        });
        this.f80799l.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int iF2 = MaterialCalendar.this.O().f2() - 1;
                if (iF2 >= 0) {
                    MaterialCalendar.this.R(monthsPagerAdapter.h(iF2));
                }
            }
        });
    }

    private RecyclerView.ItemDecoration G() {
        return new RecyclerView.ItemDecoration() { // from class: com.google.android.material.datepicker.MaterialCalendar.5

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Calendar f80810a = UtcDates.m();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Calendar f80811b = UtcDates.m();

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
                if ((recyclerView.getAdapter() instanceof YearGridAdapter) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                    YearGridAdapter yearGridAdapter = (YearGridAdapter) recyclerView.getAdapter();
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                    for (Pair pair : MaterialCalendar.this.f80791c.w1()) {
                        Object obj = pair.f34340a;
                        if (obj != null && pair.f34341b != null) {
                            this.f80810a.setTimeInMillis(((Long) obj).longValue());
                            this.f80811b.setTimeInMillis(((Long) pair.f34341b).longValue());
                            int i3 = yearGridAdapter.i(this.f80810a.get(1));
                            int i4 = yearGridAdapter.i(this.f80811b.get(1));
                            View viewI = gridLayoutManager.I(i3);
                            View viewI2 = gridLayoutManager.I(i4);
                            int iZ2 = i3 / gridLayoutManager.Z2();
                            int iZ22 = i4 / gridLayoutManager.Z2();
                            int i5 = iZ2;
                            while (i5 <= iZ22) {
                                if (gridLayoutManager.I(gridLayoutManager.Z2() * i5) != null) {
                                    canvas.drawRect((i5 != iZ2 || viewI == null) ? 0 : viewI.getLeft() + (viewI.getWidth() / 2), r9.getTop() + MaterialCalendar.this.f80796i.f80763d.c(), (i5 != iZ22 || viewI2 == null) ? recyclerView.getWidth() : viewI2.getLeft() + (viewI2.getWidth() / 2), r9.getBottom() - MaterialCalendar.this.f80796i.f80763d.b(), MaterialCalendar.this.f80796i.f80767h);
                                }
                                i5++;
                            }
                        }
                    }
                }
            }
        };
    }

    static int M(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.f79581n0);
    }

    private static int N(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f79597v0) + resources.getDimensionPixelOffset(R.dimen.f79599w0) + resources.getDimensionPixelOffset(R.dimen.f79595u0);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.f79585p0);
        int i3 = MonthAdapter.f80872h;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R.dimen.f79581n0) * i3) + ((i3 - 1) * resources.getDimensionPixelOffset(R.dimen.f79593t0)) + resources.getDimensionPixelOffset(R.dimen.f79577l0);
    }

    public static MaterialCalendar P(DateSelector dateSelector, int i3, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        MaterialCalendar materialCalendar = new MaterialCalendar();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i3);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", dayViewDecorator);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.l());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    private void Q(final int i3) {
        this.f80798k.post(new Runnable() { // from class: com.google.android.material.datepicker.MaterialCalendar.11
            @Override // java.lang.Runnable
            public void run() {
                MaterialCalendar.this.f80798k.D1(i3);
            }
        });
    }

    private void T() {
        ViewCompat.m0(this.f80798k, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialCalendar.4
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.K0(false);
            }
        });
    }

    CalendarConstraints H() {
        return this.f80792d;
    }

    CalendarStyle I() {
        return this.f80796i;
    }

    Month J() {
        return this.f80794g;
    }

    public DateSelector L() {
        return this.f80791c;
    }

    LinearLayoutManager O() {
        return (LinearLayoutManager) this.f80798k.getLayoutManager();
    }

    void R(Month month) {
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.f80798k.getAdapter();
        int iJ = monthsPagerAdapter.j(month);
        int iJ2 = iJ - monthsPagerAdapter.j(this.f80794g);
        boolean z2 = Math.abs(iJ2) > 3;
        boolean z3 = iJ2 > 0;
        this.f80794g = month;
        if (z2 && z3) {
            this.f80798k.u1(iJ - 3);
            Q(iJ);
        } else if (!z2) {
            Q(iJ);
        } else {
            this.f80798k.u1(iJ + 3);
            Q(iJ);
        }
    }

    void S(CalendarSelector calendarSelector) {
        this.f80795h = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.f80797j.getLayoutManager().C1(((YearGridAdapter) this.f80797j.getAdapter()).i(this.f80794g.f80867c));
            this.f80801n.setVisibility(0);
            this.f80802o.setVisibility(8);
            this.f80799l.setVisibility(8);
            this.f80800m.setVisibility(8);
            return;
        }
        if (calendarSelector == CalendarSelector.DAY) {
            this.f80801n.setVisibility(8);
            this.f80802o.setVisibility(0);
            this.f80799l.setVisibility(0);
            this.f80800m.setVisibility(0);
            R(this.f80794g);
        }
    }

    void U() {
        CalendarSelector calendarSelector = this.f80795h;
        CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
        if (calendarSelector == calendarSelector2) {
            S(CalendarSelector.DAY);
        } else if (calendarSelector == CalendarSelector.DAY) {
            S(calendarSelector2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f80790b = bundle.getInt("THEME_RES_ID_KEY");
        this.f80791c = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f80792d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f80793f = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f80794g = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i3;
        final int i4;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f80790b);
        this.f80796i = new CalendarStyle(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month monthM = this.f80792d.m();
        if (MaterialDatePicker.O(contextThemeWrapper)) {
            i3 = R.layout.f79695z;
            i4 = 1;
        } else {
            i3 = R.layout.f79693x;
            i4 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i3, viewGroup, false);
        viewInflate.setMinimumHeight(N(requireContext()));
        GridView gridView = (GridView) viewInflate.findViewById(R.id.L);
        ViewCompat.m0(gridView, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialCalendar.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.k0(null);
            }
        });
        int iJ = this.f80792d.j();
        gridView.setAdapter((ListAdapter) (iJ > 0 ? new DaysOfWeekAdapter(iJ) : new DaysOfWeekAdapter()));
        gridView.setNumColumns(monthM.f80868d);
        gridView.setEnabled(false);
        this.f80798k = (RecyclerView) viewInflate.findViewById(R.id.O);
        this.f80798k.setLayoutManager(new SmoothCalendarLayoutManager(getContext(), i4, false) { // from class: com.google.android.material.datepicker.MaterialCalendar.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager
            protected void R1(RecyclerView.State state, int[] iArr) {
                if (i4 == 0) {
                    iArr[0] = MaterialCalendar.this.f80798k.getWidth();
                    iArr[1] = MaterialCalendar.this.f80798k.getWidth();
                } else {
                    iArr[0] = MaterialCalendar.this.f80798k.getHeight();
                    iArr[1] = MaterialCalendar.this.f80798k.getHeight();
                }
            }
        });
        this.f80798k.setTag(f80786p);
        MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.f80791c, this.f80792d, this.f80793f, new OnDayClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.3
            @Override // com.google.android.material.datepicker.MaterialCalendar.OnDayClickListener
            public void a(long j3) {
                if (MaterialCalendar.this.f80792d.h().O0(j3)) {
                    MaterialCalendar.this.f80791c.z2(j3);
                    Iterator it = MaterialCalendar.this.f80889a.iterator();
                    while (it.hasNext()) {
                        ((OnSelectionChangedListener) it.next()).b(MaterialCalendar.this.f80791c.r2());
                    }
                    MaterialCalendar.this.f80798k.getAdapter().notifyDataSetChanged();
                    if (MaterialCalendar.this.f80797j != null) {
                        MaterialCalendar.this.f80797j.getAdapter().notifyDataSetChanged();
                    }
                }
            }
        });
        this.f80798k.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.f79669c);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.P);
        this.f80797j = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f80797j.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f80797j.setAdapter(new YearGridAdapter(this));
            this.f80797j.j(G());
        }
        if (viewInflate.findViewById(R.id.F) != null) {
            F(viewInflate, monthsPagerAdapter);
        }
        if (!MaterialDatePicker.O(contextThemeWrapper)) {
            new PagerSnapHelper().b(this.f80798k);
        }
        this.f80798k.u1(monthsPagerAdapter.j(this.f80794g));
        T();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f80790b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f80791c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f80792d);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f80793f);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f80794g);
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public boolean w(OnSelectionChangedListener onSelectionChangedListener) {
        return super.w(onSelectionChangedListener);
    }
}
