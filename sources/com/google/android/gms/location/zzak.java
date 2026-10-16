package com.google.android.gms.location;

import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.core.location.LocationCompat;
import com.google.android.gms.internal.location.zzeo;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DecimalFormat f73002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final DecimalFormat f73003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final StringBuilder f73004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f73005d = 0;

    static {
        Locale locale = Locale.ROOT;
        f73002a = new DecimalFormat(".000000", DecimalFormatSymbols.getInstance(locale));
        DecimalFormat decimalFormat = new DecimalFormat(".##", DecimalFormatSymbols.getInstance(locale));
        f73003b = decimalFormat;
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        f73004c = new StringBuilder();
    }

    public static StringBuilder a(Location location, StringBuilder sb) {
        sb.ensureCapacity(100);
        if (location == null) {
            sb.append((String) null);
            return sb;
        }
        sb.append("{");
        sb.append(location.getProvider());
        sb.append(", ");
        if (LocationCompat.h(location)) {
            sb.append("mock, ");
        }
        DecimalFormat decimalFormat = f73002a;
        sb.append(decimalFormat.format(location.getLatitude()));
        sb.append(",");
        sb.append(decimalFormat.format(location.getLongitude()));
        if (location.hasAccuracy()) {
            sb.append("±");
            sb.append(f73003b.format(location.getAccuracy()));
            sb.append("m");
        }
        if (location.hasAltitude()) {
            sb.append(", alt=");
            DecimalFormat decimalFormat2 = f73003b;
            sb.append(decimalFormat2.format(location.getAltitude()));
            if (LocationCompat.g(location)) {
                sb.append("±");
                sb.append(decimalFormat2.format(LocationCompat.d(location)));
            }
            sb.append("m");
        }
        if (location.hasSpeed()) {
            sb.append(", spd=");
            DecimalFormat decimalFormat3 = f73003b;
            sb.append(decimalFormat3.format(location.getSpeed()));
            if (LocationCompat.f(location)) {
                sb.append("±");
                sb.append(decimalFormat3.format(LocationCompat.c(location)));
            }
            sb.append("m/s");
        }
        if (location.hasBearing()) {
            sb.append(", brg=");
            DecimalFormat decimalFormat4 = f73003b;
            sb.append(decimalFormat4.format(location.getBearing()));
            if (LocationCompat.e(location)) {
                sb.append("±");
                sb.append(decimalFormat4.format(LocationCompat.a(location)));
            }
            sb.append("°");
        }
        Bundle extras = location.getExtras();
        String string = extras != null ? extras.getString("floorLabel") : null;
        if (string != null) {
            sb.append(", fl=");
            sb.append(string);
        }
        Bundle extras2 = location.getExtras();
        String string2 = extras2 != null ? extras2.getString("levelId") : null;
        if (string2 != null) {
            sb.append(", lv=");
            sb.append(string2);
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        sb.append(", ert=");
        sb.append(zzeo.zza(LocationCompat.b(location) + jCurrentTimeMillis));
        sb.append('}');
        return sb;
    }
}
