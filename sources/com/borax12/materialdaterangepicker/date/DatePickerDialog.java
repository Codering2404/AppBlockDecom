package com.borax12.materialdaterangepicker.date;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.borax12.materialdaterangepicker.HapticFeedbackController;
import com.borax12.materialdaterangepicker.R;
import com.borax12.materialdaterangepicker.Utils;
import com.borax12.materialdaterangepicker.date.MonthAdapter;
import com.facebook.ads.AdError;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import net.yanzm.mth.MaterialTabHost;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DatePickerDialog extends DialogFragment implements View.OnClickListener, DatePickerController {
    private static SimpleDateFormat W = new SimpleDateFormat("yyyy", Locale.getDefault());
    private static SimpleDateFormat X = new SimpleDateFormat("dd", Locale.getDefault());
    private Calendar A;
    private Calendar[] B;
    private Calendar[] C;
    private boolean D;
    private boolean F;
    private boolean G;
    private HapticFeedbackController H;
    private String J;
    private String K;
    private String L;
    private String M;
    private MaterialTabHost N;
    private LinearLayout O;
    private TextView P;
    private TextView Q;
    private TextView R;
    private SimpleDayPickerView S;
    private YearPickerView T;
    private AccessibleDateAnimator U;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OnDateSetListener f65782c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DialogInterface.OnCancelListener f65784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private DialogInterface.OnDismissListener f65785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AccessibleDateAnimator f65786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f65787i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private LinearLayout f65788j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f65789k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f65790l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextView f65791m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private DayPickerView f65792n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private YearPickerView f65793o;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Calendar f65800v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Calendar f65801w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Calendar[] f65802x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Calendar[] f65803y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Calendar f65804z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Calendar f65780a = Calendar.getInstance();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Calendar f65781b = Calendar.getInstance();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HashSet f65783d = new HashSet();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f65794p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f65795q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f65796r = this.f65780a.getFirstDayOfWeek();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f65797s = this.f65781b.getFirstDayOfWeek();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f65798t = 1900;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f65799u = AdError.BROKEN_MEDIA_ERROR_CODE;
    private int E = -1;
    private boolean I = true;
    private int V = 1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnDateChangedListener {
        void a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnDateSetListener {
        void a(DatePickerDialog datePickerDialog, int i3, int i4, int i5, int i6, int i7, int i8);
    }

    private void s(Calendar calendar) {
        int i3 = calendar.get(5);
        int actualMaximum = calendar.getActualMaximum(5);
        if (i3 > actualMaximum) {
            calendar.set(5, actualMaximum);
        }
    }

    private void t(int i3) {
        long timeInMillis = this.f65780a.getTimeInMillis();
        long timeInMillis2 = this.f65781b.getTimeInMillis();
        if (i3 == 0) {
            ObjectAnimator objectAnimatorC = Utils.c(this.f65788j, 0.9f, 1.05f);
            ObjectAnimator objectAnimatorC2 = Utils.c(this.O, 0.9f, 1.05f);
            if (this.I) {
                objectAnimatorC.setStartDelay(500L);
                objectAnimatorC2.setStartDelay(500L);
                this.I = false;
            }
            this.f65792n.a();
            if (this.f65794p != i3) {
                this.f65788j.setSelected(true);
                this.O.setSelected(true);
                this.f65791m.setSelected(false);
                this.R.setSelected(false);
                this.f65786h.setDisplayedChild(0);
                this.U.setDisplayedChild(0);
                this.f65794p = i3;
            }
            objectAnimatorC.start();
            objectAnimatorC2.start();
            String dateTime = DateUtils.formatDateTime(getActivity(), timeInMillis, 16);
            String dateTime2 = DateUtils.formatDateTime(getActivity(), timeInMillis2, 16);
            this.f65786h.setContentDescription(this.J + ": " + dateTime);
            this.U.setContentDescription(this.J + ": " + dateTime2);
            Utils.e(this.f65786h, this.K);
            Utils.e(this.U, this.K);
            return;
        }
        if (i3 != 1) {
            return;
        }
        ObjectAnimator objectAnimatorC3 = Utils.c(this.f65791m, 0.85f, 1.1f);
        ObjectAnimator objectAnimatorC4 = Utils.c(this.R, 0.85f, 1.1f);
        if (this.I) {
            objectAnimatorC3.setStartDelay(500L);
            objectAnimatorC4.setStartDelay(500L);
            this.I = false;
        }
        this.f65793o.a();
        this.T.a();
        if (this.f65794p != i3) {
            this.f65788j.setSelected(false);
            this.f65791m.setSelected(true);
            this.f65786h.setDisplayedChild(1);
            this.f65794p = i3;
            this.O.setSelected(false);
            this.R.setSelected(true);
            this.U.setDisplayedChild(1);
            this.f65795q = i3;
        }
        objectAnimatorC3.start();
        objectAnimatorC4.start();
        String str = W.format(Long.valueOf(timeInMillis));
        String str2 = W.format(Long.valueOf(timeInMillis2));
        this.f65786h.setContentDescription(this.L + ": " + ((Object) str));
        this.U.setContentDescription(this.L + ": " + ((Object) str2));
        Utils.e(this.f65786h, this.M);
        Utils.e(this.U, this.M);
    }

    private void u(boolean z2) {
        TextView textView = this.f65787i;
        if (textView != null) {
            textView.setText(this.f65780a.getDisplayName(7, 2, Locale.getDefault()).toUpperCase(Locale.getDefault()));
        }
        this.f65789k.setText(this.f65780a.getDisplayName(2, 1, Locale.getDefault()).toUpperCase(Locale.getDefault()));
        this.P.setText(this.f65781b.getDisplayName(2, 1, Locale.getDefault()).toUpperCase(Locale.getDefault()));
        this.f65790l.setText(X.format(this.f65780a.getTime()));
        this.Q.setText(X.format(this.f65781b.getTime()));
        this.f65791m.setText(W.format(this.f65780a.getTime()));
        this.R.setText(W.format(this.f65781b.getTime()));
        long timeInMillis = this.f65780a.getTimeInMillis();
        long timeInMillis2 = this.f65781b.getTimeInMillis();
        this.f65786h.setDateMillis(timeInMillis);
        this.U.setDateMillis(timeInMillis2);
        String dateTime = DateUtils.formatDateTime(getActivity(), timeInMillis, 24);
        String dateTime2 = DateUtils.formatDateTime(getActivity(), timeInMillis2, 24);
        this.f65788j.setContentDescription(dateTime);
        this.O.setContentDescription(dateTime2);
        if (z2) {
            String dateTime3 = DateUtils.formatDateTime(getActivity(), timeInMillis, 20);
            String dateTime4 = DateUtils.formatDateTime(getActivity(), timeInMillis2, 20);
            Utils.e(this.f65786h, dateTime3);
            Utils.e(this.U, dateTime4);
        }
    }

    private void v() {
        Iterator it = this.f65783d.iterator();
        while (it.hasNext()) {
            ((OnDateChangedListener) it.next()).a();
        }
    }

    @Override // com.borax12.materialdaterangepicker.date.DatePickerController
    public Calendar a() {
        return this.f65801w;
    }

    @Override // com.borax12.materialdaterangepicker.date.DatePickerController
    public boolean b() {
        return this.D;
    }

    @Override // com.borax12.materialdaterangepicker.date.DatePickerController
    public Calendar c() {
        return this.f65800v;
    }

    @Override // com.borax12.materialdaterangepicker.date.DatePickerController
    public MonthAdapter.CalendarDay d() {
        return new MonthAdapter.CalendarDay(this.f65780a);
    }

    @Override // com.borax12.materialdaterangepicker.date.DatePickerController
    public int e() {
        return this.f65796r;
    }

    @Override // com.borax12.materialdaterangepicker.date.DatePickerController
    public void f(OnDateChangedListener onDateChangedListener) {
        this.f65783d.add(onDateChangedListener);
    }

    @Override // com.borax12.materialdaterangepicker.date.DatePickerController
    public void g(int i3, int i4, int i5) {
        if (this.N.getCurrentTab() == 0) {
            this.f65780a.set(1, i3);
            this.f65780a.set(2, i4);
            this.f65780a.set(5, i5);
        } else {
            this.f65781b.set(1, i3);
            this.f65781b.set(2, i4);
            this.f65781b.set(5, i5);
        }
        v();
        u(true);
    }

    @Override // com.borax12.materialdaterangepicker.date.DatePickerController
    public void h() {
        if (this.F) {
            this.H.h();
        }
    }

    @Override // com.borax12.materialdaterangepicker.date.DatePickerController
    public Calendar[] i() {
        return this.f65803y;
    }

    @Override // com.borax12.materialdaterangepicker.date.DatePickerController
    public Calendar[] j() {
        return this.f65802x;
    }

    @Override // com.borax12.materialdaterangepicker.date.DatePickerController
    public void k(int i3) {
        s(this.f65780a);
        s(this.f65781b);
        if (this.N.getCurrentTab() == 0) {
            this.f65780a.set(1, i3);
        } else {
            this.f65781b.set(1, i3);
        }
        v();
        t(0);
        u(true);
    }

    @Override // com.borax12.materialdaterangepicker.date.DatePickerController
    public int l() {
        Calendar[] calendarArr = this.f65803y;
        if (calendarArr != null) {
            return calendarArr[calendarArr.length - 1].get(1);
        }
        Calendar calendar = this.f65801w;
        return (calendar == null || calendar.get(1) >= this.f65799u) ? this.f65799u : this.f65801w.get(1);
    }

    @Override // com.borax12.materialdaterangepicker.date.DatePickerController
    public int m() {
        Calendar[] calendarArr = this.f65803y;
        if (calendarArr != null) {
            return calendarArr[0].get(1);
        }
        Calendar calendar = this.f65800v;
        return (calendar == null || calendar.get(1) <= this.f65798t) ? this.f65798t : this.f65800v.get(1);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        DialogInterface.OnCancelListener onCancelListener = this.f65784f;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h();
        if (view.getId() == R.id.f65713o || view.getId() == R.id.f65714p) {
            t(1);
        } else if (view.getId() == R.id.f65710l || view.getId() == R.id.f65711m) {
            t(0);
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getActivity().getWindow().setSoftInputMode(3);
        if (bundle != null) {
            this.f65780a.set(1, bundle.getInt("year"));
            this.f65780a.set(2, bundle.getInt("month"));
            this.f65780a.set(5, bundle.getInt("day"));
            this.f65781b.set(1, bundle.getInt("year_end"));
            this.f65781b.set(2, bundle.getInt("month_end"));
            this.f65781b.set(5, bundle.getInt("day_end"));
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int iB;
        Log.d("DatePickerDialog", "onCreateView: ");
        getDialog().getWindow().requestFeature(1);
        View viewInflate = layoutInflater.inflate(R.layout.f65725a, (ViewGroup) null);
        Typeface typefaceI = ResourcesCompat.i(getActivity(), R.font.f65698a);
        int i10 = R.id.F;
        MaterialTabHost materialTabHost = (MaterialTabHost) viewInflate.findViewById(i10);
        this.N = materialTabHost;
        materialTabHost.findViewById(i10);
        this.N.setup();
        this.N.setType(MaterialTabHost.Type.FullScreenWidth);
        TabHost.TabSpec tabSpecNewTabSpec = this.N.newTabSpec("start");
        tabSpecNewTabSpec.setContent(R.id.E);
        tabSpecNewTabSpec.setIndicator("FROM");
        TabHost.TabSpec tabSpecNewTabSpec2 = this.N.newTabSpec("end");
        tabSpecNewTabSpec2.setContent(R.id.f65717s);
        tabSpecNewTabSpec2.setIndicator("TO");
        this.N.addTab(tabSpecNewTabSpec);
        this.N.addTab(tabSpecNewTabSpec2);
        this.f65787i = (TextView) viewInflate.findViewById(R.id.f65708j);
        this.f65788j = (LinearLayout) viewInflate.findViewById(R.id.f65710l);
        this.O = (LinearLayout) viewInflate.findViewById(R.id.f65711m);
        this.f65788j.setOnClickListener(this);
        this.O.setOnClickListener(this);
        this.f65789k = (TextView) viewInflate.findViewById(R.id.f65709k);
        this.P = (TextView) viewInflate.findViewById(R.id.f65712n);
        this.f65790l = (TextView) viewInflate.findViewById(R.id.f65706h);
        this.Q = (TextView) viewInflate.findViewById(R.id.f65707i);
        this.f65791m = (TextView) viewInflate.findViewById(R.id.f65713o);
        this.R = (TextView) viewInflate.findViewById(R.id.f65714p);
        this.f65791m.setOnClickListener(this);
        this.R.setOnClickListener(this);
        if (bundle != null) {
            this.f65796r = bundle.getInt("week_start");
            this.f65797s = bundle.getInt("week_start_end");
            this.f65798t = bundle.getInt("year_start");
            this.f65799u = bundle.getInt("year_end");
            i3 = bundle.getInt("current_view");
            i4 = bundle.getInt("current_view_end");
            i5 = bundle.getInt("list_position");
            i6 = bundle.getInt("list_position_offset");
            i7 = bundle.getInt("list_position_end");
            i8 = bundle.getInt("list_position_offset_end");
            this.f65800v = (Calendar) bundle.getSerializable("min_date");
            this.f65801w = (Calendar) bundle.getSerializable("max_date");
            this.f65804z = (Calendar) bundle.getSerializable("min_date_end");
            this.A = (Calendar) bundle.getSerializable("max_date_end");
            this.f65802x = (Calendar[]) bundle.getSerializable("highlighted_days");
            this.f65803y = (Calendar[]) bundle.getSerializable("selectable_days");
            this.B = (Calendar[]) bundle.getSerializable("highlighted_days_end");
            this.C = (Calendar[]) bundle.getSerializable("selectable_days_end");
            this.D = bundle.getBoolean("theme_dark");
            this.E = bundle.getInt("accent");
            this.F = bundle.getBoolean("vibrate");
            this.G = bundle.getBoolean("dismiss");
        } else {
            i3 = 0;
            i4 = 0;
            i5 = -1;
            i6 = 0;
            i7 = -1;
            i8 = 0;
        }
        Activity activity = getActivity();
        this.f65792n = new SimpleDayPickerView(activity, this);
        this.f65793o = new YearPickerView(activity, this);
        this.S = new SimpleDayPickerView(activity, this);
        this.T = new YearPickerView(activity, this);
        Resources resources = getResources();
        this.J = resources.getString(R.string.f65733e);
        this.K = resources.getString(R.string.f65741m);
        this.L = resources.getString(R.string.f65750v);
        this.M = resources.getString(R.string.f65744p);
        viewInflate.setBackgroundColor(activity.getResources().getColor(this.D ? R.color.f65684r : R.color.f65683q));
        this.f65786h = (AccessibleDateAnimator) viewInflate.findViewById(R.id.f65703e);
        this.U = (AccessibleDateAnimator) viewInflate.findViewById(R.id.f65704f);
        this.f65786h.addView(this.f65792n);
        this.f65786h.addView(this.f65793o);
        this.f65786h.setDateMillis(this.f65780a.getTimeInMillis());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        int i11 = i3;
        alphaAnimation.setDuration(300L);
        this.f65786h.setInAnimation(alphaAnimation);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(300L);
        this.f65786h.setOutAnimation(alphaAnimation2);
        this.U.addView(this.S);
        this.U.addView(this.T);
        this.U.setDateMillis(this.f65781b.getTimeInMillis());
        new AlphaAnimation(0.0f, 1.0f).setDuration(300L);
        this.U.setInAnimation(alphaAnimation);
        new AlphaAnimation(1.0f, 0.0f).setDuration(300L);
        this.U.setOutAnimation(alphaAnimation2);
        Button button = (Button) viewInflate.findViewById(R.id.B);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.borax12.materialdaterangepicker.date.DatePickerDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatePickerDialog.this.h();
                if (DatePickerDialog.this.f65782c != null) {
                    OnDateSetListener onDateSetListener = DatePickerDialog.this.f65782c;
                    DatePickerDialog datePickerDialog = DatePickerDialog.this;
                    onDateSetListener.a(datePickerDialog, datePickerDialog.f65780a.get(1), DatePickerDialog.this.f65780a.get(2), DatePickerDialog.this.f65780a.get(5), DatePickerDialog.this.f65781b.get(1), DatePickerDialog.this.f65781b.get(2), DatePickerDialog.this.f65781b.get(5));
                }
                DatePickerDialog.this.dismiss();
            }
        });
        button.setTypeface(typefaceI);
        Button button2 = (Button) viewInflate.findViewById(R.id.f65705g);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.borax12.materialdaterangepicker.date.DatePickerDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatePickerDialog.this.h();
                if (DatePickerDialog.this.getDialog() != null) {
                    DatePickerDialog.this.getDialog().cancel();
                }
            }
        });
        button2.setTypeface(typefaceI);
        button2.setVisibility(isCancelable() ? 0 : 8);
        if (this.E == -1 && (iB = Utils.b(getActivity())) != -1) {
            this.E = iB;
        }
        int i12 = this.E;
        if (i12 != -1) {
            TextView textView = this.f65787i;
            if (textView != null) {
                textView.setBackgroundColor(Utils.a(i12));
            }
            viewInflate.findViewById(R.id.f65715q).setBackgroundColor(this.E);
            viewInflate.findViewById(R.id.f65716r).setBackgroundColor(this.E);
            button.setTextColor(this.E);
            button2.setTextColor(this.E);
            this.f65793o.setAccentColor(this.E);
            this.f65792n.setAccentColor(this.E);
            this.T.setAccentColor(this.E);
            this.S.setAccentColor(this.E);
        }
        u(false);
        t(i11);
        if (i5 == -1) {
            i9 = 1;
        } else if (i11 == 0) {
            this.f65792n.g(i5);
            i9 = 1;
        } else {
            i9 = 1;
            if (i11 == 1) {
                this.f65793o.i(i5, i6);
            }
        }
        if (i7 != -1) {
            if (i4 == 0) {
                this.S.g(i7);
            } else if (i4 == i9) {
                this.T.i(i7, i8);
            }
        }
        this.H = new HapticFeedbackController(activity);
        this.N.setOnTabChangedListener(new TabHost.OnTabChangeListener() { // from class: com.borax12.materialdaterangepicker.date.DatePickerDialog.3
            @Override // android.widget.TabHost.OnTabChangeListener
            public void onTabChanged(String str) {
                if (str == "start") {
                    DatePickerDialog.this.f65792n.e(new MonthAdapter.CalendarDay(DatePickerDialog.this.f65780a.getTimeInMillis()), true, true, false);
                } else {
                    DatePickerDialog.this.S.e(new MonthAdapter.CalendarDay(DatePickerDialog.this.f65781b.getTimeInMillis()), true, true, false);
                }
            }
        });
        return viewInflate;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.f65785g;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.H.g();
        if (this.G) {
            dismiss();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.H.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.Serializable, java.util.Calendar[]] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.Serializable, java.util.Calendar[]] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.Serializable, java.util.Calendar[]] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.Serializable, java.util.Calendar[]] */
    @Override // android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        int mostVisiblePosition;
        int mostVisiblePosition2;
        int i3;
        super.onSaveInstanceState(bundle);
        bundle.putInt("year", this.f65780a.get(1));
        bundle.putInt("month", this.f65780a.get(2));
        bundle.putInt("day", this.f65780a.get(5));
        bundle.putInt("week_start", this.f65796r);
        bundle.putInt("year_start", this.f65798t);
        bundle.putInt("year_end", this.f65799u);
        bundle.putInt("current_view", this.f65794p);
        bundle.putInt("year_end", this.f65781b.get(1));
        bundle.putInt("month_end", this.f65781b.get(2));
        bundle.putInt("day_end", this.f65781b.get(5));
        bundle.putInt("week_start_end", this.f65797s);
        bundle.putInt("year_start_end", this.f65798t);
        bundle.putInt("year_end_end", this.f65799u);
        bundle.putInt("current_view_end", this.f65795q);
        int i4 = this.f65794p;
        if (i4 == 0 || (i3 = this.f65795q) == 0) {
            mostVisiblePosition = this.f65792n.getMostVisiblePosition();
            mostVisiblePosition2 = this.S.getMostVisiblePosition();
        } else if (i4 == 1 || i3 == 1) {
            mostVisiblePosition = this.f65793o.getFirstVisiblePosition();
            mostVisiblePosition2 = this.T.getFirstVisiblePosition();
            bundle.putInt("list_position_offset", this.f65793o.getFirstPositionOffset());
            bundle.putInt("list_position_offset_end", this.T.getFirstPositionOffset());
        } else {
            mostVisiblePosition = -1;
            mostVisiblePosition2 = -1;
        }
        bundle.putInt("list_position", mostVisiblePosition);
        bundle.putInt("list_position_end", mostVisiblePosition2);
        bundle.putSerializable("min_date", this.f65800v);
        bundle.putSerializable("max_date", this.f65801w);
        bundle.putSerializable("min_date_end", this.f65804z);
        bundle.putSerializable("max_date_end", this.A);
        bundle.putSerializable("highlighted_days", this.f65802x);
        bundle.putSerializable("selectable_days", this.f65803y);
        bundle.putSerializable("highlighted_days_end", this.B);
        bundle.putSerializable("selectable_days_end", this.C);
        bundle.putBoolean("theme_dark", this.D);
        bundle.putInt("accent", this.E);
        bundle.putBoolean("vibrate", this.F);
        bundle.putBoolean("dismiss", this.G);
    }
}
