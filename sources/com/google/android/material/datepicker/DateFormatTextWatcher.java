package com.google.android.material.datepicker;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class DateFormatTextWatcher extends TextWatcherAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextInputLayout f80772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f80773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DateFormat f80774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CalendarConstraints f80775d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f80776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Runnable f80777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Runnable f80778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f80779i = 0;

    DateFormatTextWatcher(final String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f80773b = str;
        this.f80774c = dateFormat;
        this.f80772a = textInputLayout;
        this.f80775d = calendarConstraints;
        this.f80776f = textInputLayout.getContext().getString(R.string.P);
        this.f80777g = new Runnable() { // from class: com.google.android.material.datepicker.a
            @Override // java.lang.Runnable
            public final void run() {
                DateFormatTextWatcher.b(this.f80921a, str);
            }
        };
    }

    public static /* synthetic */ void a(DateFormatTextWatcher dateFormatTextWatcher, long j3) {
        dateFormatTextWatcher.getClass();
        dateFormatTextWatcher.f80772a.setError(String.format(dateFormatTextWatcher.f80776f, dateFormatTextWatcher.g(DateStrings.c(j3))));
        dateFormatTextWatcher.d();
    }

    public static /* synthetic */ void b(DateFormatTextWatcher dateFormatTextWatcher, String str) {
        TextInputLayout textInputLayout = dateFormatTextWatcher.f80772a;
        DateFormat dateFormat = dateFormatTextWatcher.f80774c;
        Context context = textInputLayout.getContext();
        textInputLayout.setError(context.getString(R.string.J) + "\n" + String.format(context.getString(R.string.L), dateFormatTextWatcher.g(str)) + "\n" + String.format(context.getString(R.string.K), dateFormatTextWatcher.g(dateFormat.format(new Date(UtcDates.k().getTimeInMillis())))));
        dateFormatTextWatcher.d();
    }

    private Runnable c(final long j3) {
        return new Runnable() { // from class: com.google.android.material.datepicker.b
            @Override // java.lang.Runnable
            public final void run() {
                DateFormatTextWatcher.a(this.f80923a, j3);
            }
        };
    }

    private String g(String str) {
        return str.replace(' ', (char) 160);
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (!Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) && editable.length() != 0 && editable.length() < this.f80773b.length() && editable.length() >= this.f80779i) {
            char cCharAt = this.f80773b.charAt(editable.length());
            if (Character.isLetterOrDigit(cCharAt)) {
                return;
            }
            editable.append(cCharAt);
        }
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        this.f80779i = charSequence.length();
    }

    abstract void e(Long l3);

    public void f(View view, Runnable runnable) {
        view.post(runnable);
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        this.f80772a.removeCallbacks(this.f80777g);
        this.f80772a.removeCallbacks(this.f80778h);
        this.f80772a.setError(null);
        e(null);
        if (TextUtils.isEmpty(charSequence) || charSequence.length() < this.f80773b.length()) {
            return;
        }
        try {
            Date date = this.f80774c.parse(charSequence.toString());
            this.f80772a.setError(null);
            long time = date.getTime();
            if (this.f80775d.h().O0(time) && this.f80775d.o(time)) {
                e(Long.valueOf(date.getTime()));
                return;
            }
            Runnable runnableC = c(time);
            this.f80778h = runnableC;
            f(this.f80772a, runnableC);
        } catch (ParseException unused) {
            f(this.f80772a, this.f80777g);
        }
    }

    void d() {
    }
}
