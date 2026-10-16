package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class HardwareConfigState {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f66876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f66877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final File f66878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile HardwareConfigState f66879h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f66881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f66882c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f66883d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f66880a = 20000;

    static {
        f66876e = Build.VERSION.SDK_INT < 29;
        f66877f = true;
        f66878g = new File("/proc/self/fd");
    }

    HardwareConfigState() {
    }

    private boolean a() {
        return f66876e && !this.f66883d.get();
    }

    public static HardwareConfigState b() {
        if (f66879h == null) {
            synchronized (HardwareConfigState.class) {
                try {
                    if (f66879h == null) {
                        f66879h = new HardwareConfigState();
                    }
                } finally {
                }
            }
        }
        return f66879h;
    }

    private int c() {
        if (e()) {
            return 500;
        }
        return this.f66880a;
    }

    private synchronized boolean d() {
        try {
            boolean z2 = true;
            int i3 = this.f66881b + 1;
            this.f66881b = i3;
            if (i3 >= 50) {
                this.f66881b = 0;
                int length = f66878g.list().length;
                long jC = c();
                if (length >= jC) {
                    z2 = false;
                }
                this.f66882c = z2;
                if (!z2 && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + jC);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f66882c;
    }

    private static boolean e() {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        Iterator it = Arrays.asList("GM1900", "GM1901", "GM1903", "GM1911", "GM1915", "ONEPLUS A3000", "ONEPLUS A3010", "ONEPLUS A5010", "ONEPLUS A5000", "ONEPLUS A3003", "ONEPLUS A6000", "ONEPLUS A6003", "ONEPLUS A6010", "ONEPLUS A6013").iterator();
        while (it.hasNext()) {
            if (Build.MODEL.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean f(int i3, int i4, boolean z2, boolean z3) {
        if (!z2) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!f66877f) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (a()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z3) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        if (i3 < 0 || i4 < 0) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because of invalid dimensions");
            }
            return false;
        }
        if (d()) {
            return true;
        }
        if (Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
        }
        return false;
    }

    boolean g(int i3, int i4, BitmapFactory.Options options, boolean z2, boolean z3) {
        boolean zF = f(i3, i4, z2, z3);
        if (zF) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zF;
    }

    public void h() {
        Util.b();
        this.f66883d.set(true);
    }
}
