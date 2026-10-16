package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f72135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GmsLogger f72136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f72137d;

    public Logger(String str, String... strArr) {
        String string;
        if (strArr.length == 0) {
            string = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str2 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str2);
            }
            sb.append("] ");
            string = sb.toString();
        }
        this.f72135b = string;
        this.f72134a = str;
        this.f72136c = new GmsLogger(str);
        int i3 = 2;
        while (i3 <= 7 && !Log.isLoggable(this.f72134a, i3)) {
            i3++;
        }
        this.f72137d = i3;
    }

    public void a(String str, Object... objArr) {
        if (f(3)) {
            Log.d(this.f72134a, d(str, objArr));
        }
    }

    public void b(String str, Throwable th, Object... objArr) {
        Log.e(this.f72134a, d(str, objArr), th);
    }

    public void c(String str, Object... objArr) {
        Log.e(this.f72134a, d(str, objArr));
    }

    protected String d(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f72135b.concat(str);
    }

    public void e(String str, Object... objArr) {
        Log.i(this.f72134a, d(str, objArr));
    }

    public boolean f(int i3) {
        return this.f72137d <= i3;
    }

    public void g(String str, Object... objArr) {
        if (f(2)) {
            Log.v(this.f72134a, d(str, objArr));
        }
    }

    public void h(String str, Object... objArr) {
        Log.w(this.f72134a, d(str, objArr));
    }

    public void i(String str, Throwable th, Object... objArr) {
        Log.wtf(this.f72134a, d(str, objArr), th);
    }

    public void j(Throwable th) {
        Log.wtf(this.f72134a, th);
    }
}
