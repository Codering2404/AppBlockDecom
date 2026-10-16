package androidx.core.content.pm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ShortcutManagerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ShortcutInfoCompatSaver f33872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile List f33873b;

    /* JADX INFO: renamed from: androidx.core.content.pm.ShortcutManagerCompat$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IntentSender f33874a;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                this.f33874a.sendIntent(context, 0, null, null, null);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api25Impl {
        static String a(List list) {
            Iterator it = list.iterator();
            int rank = -1;
            String id = null;
            while (it.hasNext()) {
                ShortcutInfo shortcutInfo = (ShortcutInfo) it.next();
                if (shortcutInfo.getRank() > rank) {
                    id = shortcutInfo.getId();
                    rank = shortcutInfo.getRank();
                }
            }
            return id;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShortcutMatchFlags {
    }

    public static boolean a(Context context, List list) {
        List listL = l(list, 1);
        if (Build.VERSION.SDK_INT <= 29) {
            c(context, listL);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = listL.iterator();
        while (it.hasNext()) {
            arrayList.add(((ShortcutInfoCompat) it.next()).h());
        }
        if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).addDynamicShortcuts(arrayList)) {
            return false;
        }
        j(context).a(listL);
        Iterator it2 = i(context).iterator();
        while (it2.hasNext()) {
            ((ShortcutInfoChangeListener) it2.next()).b(list);
        }
        return true;
    }

    static boolean b(Context context, ShortcutInfoCompat shortcutInfoCompat) {
        Bitmap bitmapDecodeStream;
        IconCompat iconCompat = shortcutInfoCompat.f33849i;
        if (iconCompat == null) {
            return false;
        }
        int i3 = iconCompat.f34017a;
        if (i3 != 6 && i3 != 4) {
            return true;
        }
        InputStream inputStreamK = iconCompat.k(context);
        if (inputStreamK == null || (bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamK)) == null) {
            return false;
        }
        shortcutInfoCompat.f33849i = i3 == 6 ? IconCompat.b(bitmapDecodeStream) : IconCompat.c(bitmapDecodeStream);
        return true;
    }

    static void c(Context context, List list) {
        ArrayList arrayList = new ArrayList(list);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ShortcutInfoCompat shortcutInfoCompat = (ShortcutInfoCompat) obj;
            if (!b(context, shortcutInfoCompat)) {
                list.remove(shortcutInfoCompat);
            }
        }
    }

    public static void d(Context context, List list, CharSequence charSequence) {
        ((ShortcutManager) context.getSystemService(ShortcutManager.class)).disableShortcuts(list, charSequence);
        j(context).d(list);
        Iterator it = i(context).iterator();
        while (it.hasNext()) {
            ((ShortcutInfoChangeListener) it.next()).c(list);
        }
    }

    public static void e(Context context, List list) {
        List listL = l(list, 1);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = listL.iterator();
        while (it.hasNext()) {
            arrayList.add(((ShortcutInfoCompat) it.next()).f33842b);
        }
        ((ShortcutManager) context.getSystemService(ShortcutManager.class)).enableShortcuts(arrayList);
        j(context).a(listL);
        Iterator it2 = i(context).iterator();
        while (it2.hasNext()) {
            ((ShortcutInfoChangeListener) it2.next()).b(list);
        }
    }

    public static List f(Context context) {
        List<ShortcutInfo> dynamicShortcuts = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
        ArrayList arrayList = new ArrayList(dynamicShortcuts.size());
        Iterator<ShortcutInfo> it = dynamicShortcuts.iterator();
        while (it.hasNext()) {
            arrayList.add(new ShortcutInfoCompat.Builder(context, it.next()).a());
        }
        return arrayList;
    }

    public static int g(Context context) {
        Preconditions.h(context);
        return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
    }

    private static String h(List list) {
        Iterator it = list.iterator();
        int iF = -1;
        String strB = null;
        while (it.hasNext()) {
            ShortcutInfoCompat shortcutInfoCompat = (ShortcutInfoCompat) it.next();
            if (shortcutInfoCompat.f() > iF) {
                strB = shortcutInfoCompat.b();
                iF = shortcutInfoCompat.f();
            }
        }
        return strB;
    }

    private static List i(Context context) {
        Bundle bundle;
        String string;
        if (f33873b == null) {
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("androidx.core.content.pm.SHORTCUT_LISTENER");
            intent.setPackage(context.getPackageName());
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD).iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && (bundle = activityInfo.metaData) != null && (string = bundle.getString("androidx.core.content.pm.shortcut_listener_impl")) != null) {
                    try {
                        arrayList.add((ShortcutInfoChangeListener) Class.forName(string, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context));
                    } catch (Exception unused) {
                    }
                }
            }
            if (f33873b == null) {
                f33873b = arrayList;
            }
        }
        return f33873b;
    }

    private static ShortcutInfoCompatSaver j(Context context) {
        if (f33872a == null) {
            try {
                f33872a = (ShortcutInfoCompatSaver) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context);
            } catch (Exception unused) {
            }
            if (f33872a == null) {
                f33872a = new ShortcutInfoCompatSaver.NoopImpl();
            }
        }
        return f33872a;
    }

    public static boolean k(Context context, ShortcutInfoCompat shortcutInfoCompat) {
        Preconditions.h(context);
        Preconditions.h(shortcutInfoCompat);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 32 && shortcutInfoCompat.g(1)) {
            Iterator it = i(context).iterator();
            while (it.hasNext()) {
                ((ShortcutInfoChangeListener) it.next()).b(Collections.singletonList(shortcutInfoCompat));
            }
            return true;
        }
        int iG = g(context);
        if (iG == 0) {
            return false;
        }
        if (i3 <= 29) {
            b(context, shortcutInfoCompat);
        }
        if (i3 >= 30) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).pushDynamicShortcut(shortcutInfoCompat.h());
        } else {
            ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
            if (shortcutManager.isRateLimitingActive()) {
                return false;
            }
            List<ShortcutInfo> dynamicShortcuts = shortcutManager.getDynamicShortcuts();
            if (dynamicShortcuts.size() >= iG) {
                shortcutManager.removeDynamicShortcuts(Arrays.asList(Api25Impl.a(dynamicShortcuts)));
            }
            shortcutManager.addDynamicShortcuts(Arrays.asList(shortcutInfoCompat.h()));
        }
        ShortcutInfoCompatSaver shortcutInfoCompatSaverJ = j(context);
        try {
            List listB = shortcutInfoCompatSaverJ.b();
            if (listB.size() >= iG) {
                shortcutInfoCompatSaverJ.d(Arrays.asList(h(listB)));
            }
            shortcutInfoCompatSaverJ.a(Arrays.asList(shortcutInfoCompat));
            Iterator it2 = i(context).iterator();
            while (it2.hasNext()) {
                ((ShortcutInfoChangeListener) it2.next()).b(Collections.singletonList(shortcutInfoCompat));
            }
            m(context, shortcutInfoCompat.b());
            return true;
        } catch (Exception unused) {
            Iterator it3 = i(context).iterator();
            while (it3.hasNext()) {
                ((ShortcutInfoChangeListener) it3.next()).b(Collections.singletonList(shortcutInfoCompat));
            }
            m(context, shortcutInfoCompat.b());
            return false;
        } catch (Throwable th) {
            Iterator it4 = i(context).iterator();
            while (it4.hasNext()) {
                ((ShortcutInfoChangeListener) it4.next()).b(Collections.singletonList(shortcutInfoCompat));
            }
            m(context, shortcutInfoCompat.b());
            throw th;
        }
    }

    private static List l(List list, int i3) {
        Objects.requireNonNull(list);
        if (Build.VERSION.SDK_INT > 32) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ShortcutInfoCompat shortcutInfoCompat = (ShortcutInfoCompat) it.next();
            if (shortcutInfoCompat.g(i3)) {
                arrayList.remove(shortcutInfoCompat);
            }
        }
        return arrayList;
    }

    public static void m(Context context, String str) {
        Preconditions.h(context);
        Preconditions.h(str);
        ((ShortcutManager) context.getSystemService(ShortcutManager.class)).reportShortcutUsed(str);
        Iterator it = i(context).iterator();
        while (it.hasNext()) {
            ((ShortcutInfoChangeListener) it.next()).d(Collections.singletonList(str));
        }
    }

    public static boolean n(Context context, List list) {
        Preconditions.h(context);
        Preconditions.h(list);
        List listL = l(list, 1);
        ArrayList arrayList = new ArrayList(listL.size());
        Iterator it = listL.iterator();
        while (it.hasNext()) {
            arrayList.add(((ShortcutInfoCompat) it.next()).h());
        }
        if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).setDynamicShortcuts(arrayList)) {
            return false;
        }
        j(context).c();
        j(context).a(listL);
        for (ShortcutInfoChangeListener shortcutInfoChangeListener : i(context)) {
            shortcutInfoChangeListener.a();
            shortcutInfoChangeListener.b(list);
        }
        return true;
    }
}
