package com.google.android.libraries.places.api;

import android.content.Context;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.internal.zzme;
import com.google.android.libraries.places.internal.zzmm;
import com.google.android.libraries.places.internal.zzmp;
import com.google.android.libraries.places.internal.zzmz;
import com.google.android.libraries.places.internal.zznb;
import com.google.common.base.Preconditions;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Places {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final zzmp f74902a = new zzmp();

    public static synchronized PlacesClient a(Context context) {
        try {
            Preconditions.u(context, "Context must not be null.");
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
        return e(context, zzmz.d(context).d());
    }

    public static void b(Context context, String str) {
        try {
            d(context, str, null, true);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    public static synchronized boolean c() {
        try {
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
        return f74902a.b();
    }

    public static synchronized void d(Context context, String str, Locale locale, boolean z2) {
        try {
            Preconditions.u(context, "Application context must not be null.");
            Preconditions.u(str, "API Key must not be null.");
            Preconditions.e(!str.isEmpty(), "API Key must not be empty.");
            zznb.a(context.getApplicationContext());
            f74902a.a(str, locale, z2);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    public static synchronized PlacesClient e(Context context, zzmz zzmzVar) {
        zzmm zzmmVarA;
        try {
            Preconditions.u(context, "Context must not be null.");
            Preconditions.u(zzmzVar, "ClientProfile must not be null.");
            Preconditions.A(c(), "Places must be initialized first.");
            zzmmVarA = zzme.a();
            zzmmVarA.zzd(context);
            zzmmVarA.b(f74902a);
            zzmmVarA.a(zzmzVar);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
        return zzmmVarA.zza().zzc();
    }

    public static synchronized zzmp f() {
        return f74902a;
    }
}
