package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class SharedPreferencesQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f89457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f89458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f89459c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f89461e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ArrayDeque f89460d = new ArrayDeque();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f89462f = false;

    private SharedPreferencesQueue(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f89457a = sharedPreferences;
        this.f89458b = str;
        this.f89459c = str2;
        this.f89461e = executor;
    }

    private boolean b(boolean z2) {
        if (z2 && !this.f89462f) {
            i();
        }
        return z2;
    }

    static SharedPreferencesQueue c(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        SharedPreferencesQueue sharedPreferencesQueue = new SharedPreferencesQueue(sharedPreferences, str, str2, executor);
        sharedPreferencesQueue.d();
        return sharedPreferencesQueue;
    }

    private void d() {
        synchronized (this.f89460d) {
            try {
                this.f89460d.clear();
                String string = this.f89457a.getString(this.f89458b, "");
                if (!TextUtils.isEmpty(string) && string.contains(this.f89459c)) {
                    String[] strArrSplit = string.split(this.f89459c, -1);
                    if (strArrSplit.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str : strArrSplit) {
                        if (!TextUtils.isEmpty(str)) {
                            this.f89460d.add(str);
                        }
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        synchronized (this.f89460d) {
            this.f89457a.edit().putString(this.f89458b, g()).commit();
        }
    }

    private void i() {
        this.f89461e.execute(new Runnable() { // from class: com.google.firebase.messaging.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f89515a.h();
            }
        });
    }

    public String e() {
        String str;
        synchronized (this.f89460d) {
            str = (String) this.f89460d.peek();
        }
        return str;
    }

    public boolean f(Object obj) {
        boolean zB;
        synchronized (this.f89460d) {
            zB = b(this.f89460d.remove(obj));
        }
        return zB;
    }

    public String g() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.f89460d.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(this.f89459c);
        }
        return sb.toString();
    }
}
