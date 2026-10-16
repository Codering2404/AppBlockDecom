package com.google.android.libraries.places.internal;

import android.content.Context;
import android.os.Build;
import android.os.DropBoxManager;
import android.util.Log;
import com.google.common.base.Splitter;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zznb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static DropBoxManager f78237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LinkedHashMap f78238b = new zzna(16, 0.75f, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f78239c;

    public static synchronized void a(Context context) {
        if (f78237a == null) {
            f78237a = (DropBoxManager) context.getApplicationContext().getSystemService("dropbox");
            f78239c = "com.google.android.libraries.places";
        }
    }

    public static synchronized void b(Throwable th) {
        try {
            long id = Thread.currentThread().getId();
            int iHashCode = th.hashCode();
            Integer num = (Integer) f78238b.get(Long.valueOf(id));
            if (num == null || num.intValue() != iHashCode) {
                DropBoxManager dropBoxManager = f78237a;
                if (dropBoxManager != null && dropBoxManager.isTagEnabled("system_app_crash")) {
                    DropBoxManager dropBoxManager2 = f78237a;
                    StringBuilder sb = new StringBuilder();
                    String str = f78239c;
                    List listL = Splitter.f('.').l("5.1.1");
                    long j3 = -1;
                    if (listL.size() == 3) {
                        long j4 = 0;
                        for (int i3 = 0; i3 < listL.size(); i3++) {
                            try {
                                j4 = (j4 * 100) + ((long) Integer.parseInt((String) listL.get(i3)));
                            } catch (NumberFormatException unused) {
                            }
                        }
                        j3 = j4;
                    }
                    sb.append(String.format("Package: %s v%d (%s)\n", str, Long.valueOf(j3), "5.1.1"));
                    sb.append(String.format("Build: %s\n", Build.FINGERPRINT));
                    sb.append("\n");
                    sb.append(Log.getStackTraceString(th));
                    dropBoxManager2.addText("system_app_crash", sb.toString());
                    f78238b.put(Long.valueOf(id), Integer.valueOf(iHashCode));
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
