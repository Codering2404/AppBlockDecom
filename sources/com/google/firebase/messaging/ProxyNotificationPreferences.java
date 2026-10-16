package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.OnSuccessListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ProxyNotificationPreferences {
    private static SharedPreferences b(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return context.getSharedPreferences("com.google.firebase.messaging", 0);
    }

    static boolean c(Context context) {
        return b(context).getBoolean("proxy_notification_initialized", false);
    }

    static boolean d(SharedPreferences sharedPreferences, boolean z2) {
        return sharedPreferences.contains("proxy_retention") && sharedPreferences.getBoolean("proxy_retention", false) == z2;
    }

    static void e(Context context, boolean z2) {
        SharedPreferences.Editor editorEdit = b(context).edit();
        editorEdit.putBoolean("proxy_notification_initialized", z2);
        editorEdit.apply();
    }

    static void f(final Context context, GmsRpc gmsRpc, final boolean z2) {
        if (PlatformVersion.g() && !d(b(context), z2)) {
            gmsRpc.j(z2).addOnSuccessListener(new androidx.credentials.c(), new OnSuccessListener() { // from class: com.google.firebase.messaging.y
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    ProxyNotificationPreferences.g(context, z2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(Context context, boolean z2) {
        SharedPreferences.Editor editorEdit = b(context).edit();
        editorEdit.putBoolean("proxy_retention", z2);
        editorEdit.apply();
    }
}
