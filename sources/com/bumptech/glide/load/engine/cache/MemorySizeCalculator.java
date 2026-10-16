package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class MemorySizeCalculator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f66608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f66609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f66610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f66611d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final int f66612i = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f66613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ActivityManager f66614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ScreenDimensions f66615c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f66617e;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f66616d = 2.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float f66618f = 0.4f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f66619g = 0.33f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f66620h = 4194304;

        public Builder(Context context) {
            this.f66617e = f66612i;
            this.f66613a = context;
            this.f66614b = (ActivityManager) context.getSystemService("activity");
            this.f66615c = new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics());
            if (MemorySizeCalculator.e(this.f66614b)) {
                this.f66617e = 0.0f;
            }
        }

        public MemorySizeCalculator a() {
            return new MemorySizeCalculator(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DisplayMetricsScreenDimensions implements ScreenDimensions {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DisplayMetrics f66621a;

        DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.f66621a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int a() {
            return this.f66621a.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int b() {
            return this.f66621a.widthPixels;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface ScreenDimensions {
        int a();

        int b();
    }

    MemorySizeCalculator(Builder builder) {
        this.f66610c = builder.f66613a;
        int i3 = e(builder.f66614b) ? builder.f66620h / 2 : builder.f66620h;
        this.f66611d = i3;
        int iC = c(builder.f66614b, builder.f66618f, builder.f66619g);
        float fB = builder.f66615c.b() * builder.f66615c.a() * 4;
        int iRound = Math.round(builder.f66617e * fB);
        int iRound2 = Math.round(fB * builder.f66616d);
        int i4 = iC - i3;
        int i5 = iRound2 + iRound;
        if (i5 <= i4) {
            this.f66609b = iRound2;
            this.f66608a = iRound;
        } else {
            float f3 = i4;
            float f4 = builder.f66617e;
            float f5 = builder.f66616d;
            float f6 = f3 / (f4 + f5);
            this.f66609b = Math.round(f5 * f6);
            this.f66608a = Math.round(f6 * builder.f66617e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.f66609b));
            sb.append(", pool size: ");
            sb.append(f(this.f66608a));
            sb.append(", byte array size: ");
            sb.append(f(i3));
            sb.append(", memory class limited? ");
            sb.append(i5 > iC);
            sb.append(", max size: ");
            sb.append(f(iC));
            sb.append(", memoryClass: ");
            sb.append(builder.f66614b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(builder.f66614b));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f3, float f4) {
        float memoryClass = activityManager.getMemoryClass() * 1048576;
        if (e(activityManager)) {
            f3 = f4;
        }
        return Math.round(memoryClass * f3);
    }

    static boolean e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String f(int i3) {
        return Formatter.formatFileSize(this.f66610c, i3);
    }

    public int a() {
        return this.f66611d;
    }

    public int b() {
        return this.f66608a;
    }

    public int d() {
        return this.f66609b;
    }
}
