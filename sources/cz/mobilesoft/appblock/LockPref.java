package cz.mobilesoft.appblock;

import android.content.Context;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class LockPref {
    public static long a(Context context) {
        return context.getSharedPreferences("LOCK_PREF", 0).getLong("PREF_LAST_SCREEN_CHANGE", 0L);
    }

    public static int b(Context context) {
        return Math.round((new Date().getTime() - a(context)) / 1000);
    }

    public static void c(Context context) {
        context.getSharedPreferences("LOCK_PREF", 0).edit().putLong(jTYhJgqLBN.ciyVeAKfqBIoM, new Date().getTime()).commit();
    }
}
