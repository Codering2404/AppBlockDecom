package com.evernote.android.job.work;

import android.os.Bundle;
import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class TransientBundleHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SparseArray f68007a = new SparseArray();

    public static synchronized void a(int i3) {
        f68007a.remove(i3);
    }

    public static synchronized Bundle b(int i3) {
        return (Bundle) f68007a.get(i3);
    }

    public static synchronized void c(int i3, Bundle bundle) {
        f68007a.put(i3, bundle);
    }
}
