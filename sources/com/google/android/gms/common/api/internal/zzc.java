package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.common.zzg;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f71872a = Collections.synchronizedMap(new ArrayMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f71873b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f71874c;

    zzc() {
    }

    final LifecycleCallback a(String str, Class cls) {
        return (LifecycleCallback) cls.cast(this.f71872a.get(str));
    }

    final void b(String str, LifecycleCallback lifecycleCallback) {
        Map map = this.f71872a;
        if (map.containsKey(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
            sb.append("LifecycleCallback with tag ");
            sb.append(str);
            sb.append(" already added to this fragment.");
            throw new IllegalArgumentException(sb.toString());
        }
        map.put(str, lifecycleCallback);
        if (this.f71873b > 0) {
            new zzg(Looper.getMainLooper()).post(new zzb(this, lifecycleCallback, str));
        }
    }

    final void c(Bundle bundle) {
        this.f71873b = 1;
        this.f71874c = bundle;
        for (Map.Entry entry : this.f71872a.entrySet()) {
            ((LifecycleCallback) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    final void d() {
        this.f71873b = 2;
        Iterator it = this.f71872a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).onStart();
        }
    }

    final void e() {
        this.f71873b = 3;
        Iterator it = this.f71872a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).onResume();
        }
    }

    final void f(int i3, int i4, Intent intent) {
        Iterator it = this.f71872a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).onActivityResult(i3, i4, intent);
        }
    }

    final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f71872a.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).onSaveInstanceState(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    final void h() {
        this.f71873b = 4;
        Iterator it = this.f71872a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).onStop();
        }
    }

    final void i() {
        this.f71873b = 5;
        Iterator it = this.f71872a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).onDestroy();
        }
    }

    final void j(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Iterator it = this.f71872a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    final /* synthetic */ int k() {
        return this.f71873b;
    }

    final /* synthetic */ Bundle l() {
        return this.f71874c;
    }
}
