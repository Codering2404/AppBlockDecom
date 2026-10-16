package com.applovin.impl;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f61077a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f61078b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Collection f61079c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f61080d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static a f61081e = null;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f61082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f61083b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private EnumC0107a f61084c = EnumC0107a.NOT_SET;

        /* JADX INFO: renamed from: com.applovin.impl.l0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum EnumC0107a {
            NOT_SET("dnt_not_set"),
            ON("dnt_on"),
            OFF("dnt_off");


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f61089a;

            EnumC0107a(String str) {
                this.f61089a = str;
            }

            public String b() {
                return this.f61089a;
            }
        }

        protected boolean a(Object obj) {
            return obj instanceof a;
        }

        public EnumC0107a b() {
            return this.f61084c;
        }

        public boolean c() {
            return this.f61082a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.a(this) || c() != aVar.c()) {
                return false;
            }
            String strA = a();
            String strA2 = aVar.a();
            if (strA != null ? !strA.equals(strA2) : strA2 != null) {
                return false;
            }
            EnumC0107a enumC0107aB = b();
            EnumC0107a enumC0107aB2 = aVar.b();
            return enumC0107aB != null ? enumC0107aB.equals(enumC0107aB2) : enumC0107aB2 == null;
        }

        public int hashCode() {
            int i3 = c() ? 79 : 97;
            String strA = a();
            int iHashCode = ((i3 + 59) * 59) + (strA == null ? 43 : strA.hashCode());
            EnumC0107a enumC0107aB = b();
            return (iHashCode * 59) + (enumC0107aB != null ? enumC0107aB.hashCode() : 43);
        }

        public String toString() {
            return "AdvertisingInfoCollector.AdvertisingIdInformation(adTrackingLimited=" + c() + ", advertisingId=" + a() + ", dntCode=" + b() + ")";
        }

        public String a() {
            return this.f61083b;
        }

        public void a(boolean z2) {
            this.f61082a = z2;
        }

        public void a(String str) {
            this.f61083b = str;
        }

        public void a(EnumC0107a enumC0107a) {
            this.f61084c = enumC0107a;
        }
    }

    private static a a(Context context) {
        a aVar;
        HashSet hashSet;
        yp.a();
        Object obj = f61078b;
        synchronized (obj) {
            try {
                if (f61080d) {
                    return f61081e;
                }
                Collection collection = f61079c;
                boolean zIsEmpty = collection.isEmpty();
                CountDownLatch countDownLatch = new CountDownLatch(1);
                collection.add(countDownLatch);
                if (zIsEmpty) {
                    a aVarC = c(context);
                    synchronized (obj) {
                        f61080d = true;
                        f61081e = aVarC;
                        hashSet = new HashSet(collection);
                        collection.clear();
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        ((CountDownLatch) it.next()).countDown();
                    }
                }
                try {
                    if (!countDownLatch.await(60L, TimeUnit.SECONDS)) {
                        com.applovin.impl.sdk.n.h("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }: collection timeout");
                    }
                } catch (InterruptedException e3) {
                    com.applovin.impl.sdk.n.c("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", e3);
                }
                synchronized (f61078b) {
                    aVar = f61081e;
                }
                return aVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static a b(Context context) {
        return a(context);
    }

    private static a c(Context context) {
        a aVarCollectGoogleAdvertisingInfo = collectGoogleAdvertisingInfo(context);
        if (aVarCollectGoogleAdvertisingInfo == null) {
            aVarCollectGoogleAdvertisingInfo = collectFireOSAdvertisingInfo(context);
        }
        return aVarCollectGoogleAdvertisingInfo == null ? new a() : aVarCollectGoogleAdvertisingInfo;
    }

    private static a collectFireOSAdvertisingInfo(Context context) {
        if (f61077a) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                a aVar = new a();
                aVar.a(StringUtils.emptyIfNull(Settings.Secure.getString(contentResolver, "advertising_id")));
                boolean z2 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 0;
                aVar.a(z2);
                aVar.a(z2 ? a.EnumC0107a.ON : a.EnumC0107a.OFF);
                return aVar;
            } catch (Settings.SettingNotFoundException e3) {
                com.applovin.impl.sdk.n.c("DataCollector", "Unable to determine if Fire OS limited ad tracking is turned on", e3);
            } catch (Throwable th) {
                com.applovin.impl.sdk.n.c("DataCollector", "Unable to collect Fire OS IDFA", th);
            }
        }
        f61077a = false;
        return null;
    }

    private static a collectGoogleAdvertisingInfo(Context context) {
        yp.a();
        if (!a()) {
            if (AppLovinSdkUtils.isFireOS(context)) {
                return null;
            }
            com.applovin.impl.sdk.n.h("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }");
            return null;
        }
        try {
            a aVar = new a();
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            boolean zIsLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
            aVar.a(zIsLimitAdTrackingEnabled);
            aVar.a(zIsLimitAdTrackingEnabled ? a.EnumC0107a.ON : a.EnumC0107a.OFF);
            aVar.a(advertisingIdInfo.getId());
            return aVar;
        } catch (Throwable th) {
            if (AppLovinSdkUtils.isFireOS(context)) {
                return null;
            }
            com.applovin.impl.sdk.n.c("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", th);
            return null;
        }
    }

    public static boolean a() {
        return yp.a("com.google.android.gms.ads.identifier.AdvertisingIdClient");
    }
}
