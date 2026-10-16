package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.ProductData;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MessagingAnalytics {
    static void A(String str, Bundle bundle) {
        try {
            FirebaseApp.m();
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = new Bundle();
            String strD = d(bundle);
            if (strD != null) {
                bundle2.putString("_nmid", strD);
            }
            String strE = e(bundle);
            if (strE != null) {
                bundle2.putString("_nmn", strE);
            }
            String strI = i(bundle);
            if (!TextUtils.isEmpty(strI)) {
                bundle2.putString("label", strI);
            }
            String strG = g(bundle);
            if (!TextUtils.isEmpty(strG)) {
                bundle2.putString("message_channel", strG);
            }
            String strR = r(bundle);
            if (strR != null) {
                bundle2.putString("_nt", strR);
            }
            String strL = l(bundle);
            if (strL != null) {
                try {
                    bundle2.putInt("_nmt", Integer.parseInt(strL));
                } catch (NumberFormatException e3) {
                    Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e3);
                }
            }
            String strT = t(bundle);
            if (strT != null) {
                try {
                    bundle2.putInt("_ndt", Integer.parseInt(strT));
                } catch (NumberFormatException e4) {
                    Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e4);
                }
            }
            String strN = n(bundle);
            if ("_nr".equals(str) || "_nf".equals(str)) {
                bundle2.putString("_nmc", strN);
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Logging to scion event=" + str + " scionPayload=" + bundle2);
            }
            AnalyticsConnector analyticsConnector = (AnalyticsConnector) FirebaseApp.m().j(AnalyticsConnector.class);
            if (analyticsConnector != null) {
                analyticsConnector.b("fcm", str, bundle2);
            } else {
                Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
            }
        } catch (IllegalStateException unused) {
            Log.e("FirebaseMessaging", "Default FirebaseApp has not been initialized. Skip logging event to GA.");
        }
    }

    private static void B(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (!AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(bundle.getString("google.c.a.tc"))) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
                return;
            }
            return;
        }
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) FirebaseApp.m().j(AnalyticsConnector.class);
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
        }
        if (analyticsConnector == null) {
            Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
            return;
        }
        String string = bundle.getString("google.c.a.c_id");
        analyticsConnector.c("fcm", "_ln", string);
        Bundle bundle2 = new Bundle();
        bundle2.putString("source", "Firebase");
        bundle2.putString("medium", "notification");
        bundle2.putString("campaign", string);
        analyticsConnector.b("fcm", "_cmp", bundle2);
    }

    public static boolean C(Intent intent) {
        if (intent == null || u(intent)) {
            return false;
        }
        return a();
    }

    public static boolean D(Intent intent) {
        if (intent == null || u(intent)) {
            return false;
        }
        return E(intent.getExtras());
    }

    public static boolean E(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(bundle.getString("google.c.a.e"));
    }

    static boolean a() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            FirebaseApp.m();
            Context contextL = FirebaseApp.m().l();
            SharedPreferences sharedPreferences = contextL.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("export_to_big_query")) {
                return sharedPreferences.getBoolean("export_to_big_query", false);
            }
            try {
                PackageManager packageManager = contextL.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(contextL.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("delivery_metrics_exported_to_big_query_enabled")) {
                    return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        } catch (IllegalStateException unused2) {
            Log.i("FirebaseMessaging", "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query");
            return false;
        }
    }

    static MessagingClientEvent b(MessagingClientEvent.Event event, Intent intent) {
        if (intent == null) {
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = Bundle.EMPTY;
        }
        MessagingClientEvent.Builder builderJ = MessagingClientEvent.p().n(s(extras)).e(event).f(f(extras)).i(o()).l(MessagingClientEvent.SDKPlatform.ANDROID).h(m(extras)).j(k(extras));
        String strH = h(extras);
        if (strH != null) {
            builderJ.g(strH);
        }
        String strR = r(extras);
        if (strR != null) {
            builderJ.m(strR);
        }
        String strC = c(extras);
        if (strC != null) {
            builderJ.c(strC);
        }
        String strI = i(extras);
        if (strI != null) {
            builderJ.b(strI);
        }
        String strE = e(extras);
        if (strE != null) {
            builderJ.d(strE);
        }
        long jQ = q(extras);
        if (jQ > 0) {
            builderJ.k(jQ);
        }
        return builderJ.a();
    }

    static String c(Bundle bundle) {
        return bundle.getString("collapse_key");
    }

    static String d(Bundle bundle) {
        return bundle.getString("google.c.a.c_id");
    }

    static String e(Bundle bundle) {
        return bundle.getString("google.c.a.c_l");
    }

    static String f(Bundle bundle) {
        String string = bundle.getString("google.to");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            return (String) Tasks.await(FirebaseInstallations.q(FirebaseApp.m()).getId());
        } catch (InterruptedException | ExecutionException e3) {
            throw new RuntimeException(e3);
        }
    }

    static String g(Bundle bundle) {
        return bundle.getString("google.c.a.m_c");
    }

    static String h(Bundle bundle) {
        String string = bundle.getString("google.message_id");
        return string == null ? bundle.getString("message_id") : string;
    }

    static String i(Bundle bundle) {
        return bundle.getString("google.c.a.m_l");
    }

    private static int j(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    static int k(Bundle bundle) {
        int iP = p(bundle);
        if (iP == 2) {
            return 5;
        }
        return iP == 1 ? 10 : 0;
    }

    static String l(Bundle bundle) {
        return bundle.getString("google.c.a.ts");
    }

    static MessagingClientEvent.MessageType m(Bundle bundle) {
        return (bundle == null || !NotificationParams.t(bundle)) ? MessagingClientEvent.MessageType.DATA_MESSAGE : MessagingClientEvent.MessageType.DISPLAY_NOTIFICATION;
    }

    static String n(Bundle bundle) {
        return (bundle == null || !NotificationParams.t(bundle)) ? "data" : ServerProtocol.DIALOG_PARAM_DISPLAY;
    }

    static String o() {
        return FirebaseApp.m().l().getPackageName();
    }

    static int p(Bundle bundle) {
        String string = bundle.getString("google.delivered_priority");
        if (string == null) {
            if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(bundle.getString("google.priority_reduced"))) {
                return 2;
            }
            string = bundle.getString("google.priority");
        }
        return j(string);
    }

    static long q(Bundle bundle) {
        if (bundle.containsKey("google.c.sender.id")) {
            try {
                return Long.parseLong(bundle.getString("google.c.sender.id"));
            } catch (NumberFormatException e3) {
                Log.w("FirebaseMessaging", "error parsing project number", e3);
            }
        }
        FirebaseApp firebaseAppM = FirebaseApp.m();
        String strD = firebaseAppM.p().d();
        if (strD != null) {
            try {
                return Long.parseLong(strD);
            } catch (NumberFormatException e4) {
                Log.w("FirebaseMessaging", "error parsing sender ID", e4);
            }
        }
        String strC = firebaseAppM.p().c();
        if (strC.startsWith("1:")) {
            String[] strArrSplit = strC.split(com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            if (strArrSplit.length < 2) {
                return 0L;
            }
            String str = strArrSplit[1];
            if (str.isEmpty()) {
                return 0L;
            }
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e5) {
                Log.w("FirebaseMessaging", "error parsing app ID", e5);
            }
        } else {
            try {
                return Long.parseLong(strC);
            } catch (NumberFormatException e6) {
                Log.w("FirebaseMessaging", "error parsing app ID", e6);
            }
        }
        return 0L;
    }

    static String r(Bundle bundle) {
        String string = bundle.getString("from");
        if (string == null || !string.startsWith("/topics/")) {
            return null;
        }
        return string;
    }

    static int s(Bundle bundle) {
        Object obj = bundle.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("FirebaseMessaging", "Invalid TTL: " + obj);
            return 0;
        }
    }

    static String t(Bundle bundle) {
        if (bundle.containsKey("google.c.a.udt")) {
            return bundle.getString("google.c.a.udt");
        }
        return null;
    }

    private static boolean u(Intent intent) {
        return "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction());
    }

    public static void v(Intent intent) {
        A("_nd", intent.getExtras());
    }

    public static void w(Intent intent) {
        A("_nf", intent.getExtras());
    }

    public static void x(Bundle bundle) {
        B(bundle);
        A("_no", bundle);
    }

    public static void y(Intent intent) {
        if (D(intent)) {
            A("_nr", intent.getExtras());
        }
        if (C(intent)) {
            z(MessagingClientEvent.Event.MESSAGE_DELIVERED, intent, FirebaseMessaging.s());
        }
    }

    private static void z(MessagingClientEvent.Event event, Intent intent, TransportFactory transportFactory) {
        if (transportFactory == null) {
            Log.e("FirebaseMessaging", "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
            return;
        }
        MessagingClientEvent messagingClientEventB = b(event, intent);
        if (messagingClientEventB == null) {
            return;
        }
        try {
            transportFactory.a("FCM_CLIENT_EVENT_LOGGING", MessagingClientEventExtension.class, Encoding.b("proto"), new Transformer() { // from class: com.google.firebase.messaging.u
                @Override // com.google.android.datatransport.Transformer
                public final Object apply(Object obj) {
                    return ((MessagingClientEventExtension) obj).c();
                }
            }).b(Event.g(MessagingClientEventExtension.b().b(messagingClientEventB).a(), ProductData.b(Integer.valueOf(intent.getIntExtra("google.product_id", 111881503)))));
        } catch (RuntimeException e3) {
            Log.w("FirebaseMessaging", "Failed to send big query analytics payload.", e3);
        }
    }
}
