package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.PatternSyntaxException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeeb {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final Executor zzc;
    private final AtomicReference zzd = new AtomicReference("");

    zzeeb(Context context, VersionInfoParcel versionInfoParcel, Executor executor) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = executor;
    }

    private final String zzc() {
        String name;
        VersionInfoParcel versionInfoParcel = this.zzb;
        String strZzd = null;
        if (versionInfoParcel.f70152d) {
            name = zzclf.class.getName();
        } else {
            try {
                name = (String) new JSONObject(zzd((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpM))).get(Integer.toString(versionInfoParcel.f70151c));
            } catch (ClassCastException | IllegalArgumentException | NullPointerException | JSONException e3) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpL)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.l().zzg(e3, "SdkIE");
                }
                name = null;
            }
        }
        if (TextUtils.isEmpty(name)) {
            return "2";
        }
        try {
            strZzd = zzd((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpN));
        } catch (IllegalArgumentException e4) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpL)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.l().zzg(e4, "SdkIE");
            }
        }
        if (TextUtils.isEmpty(strZzd)) {
            return "3";
        }
        try {
            for (Method method : this.zza.getClassLoader().loadClass(name).getDeclaredMethods()) {
                if (method.getName().matches(strZzd)) {
                    return AppEventsConstants.EVENT_PARAM_VALUE_YES;
                }
            }
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } catch (ClassNotFoundException unused) {
            return "4";
        } catch (NoClassDefFoundError unused2) {
            return "6";
        } catch (SecurityException unused3) {
            return "7";
        } catch (PatternSyntaxException unused4) {
            return "5";
        }
    }

    private static final String zzd(String str) throws IllegalArgumentException {
        String str2 = new String(Base64.decode((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpO), 10), StandardCharsets.UTF_8);
        String str3 = new String(Base64.decode(str, 0));
        zzgam zzgamVar = com.google.android.gms.ads.internal.util.zzs.f70374l;
        char[] charArray = str3.toCharArray();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            charArray[i3] = (char) (charArray[i3] ^ str2.charAt(i3 % str2.length()));
        }
        return new String(charArray);
    }

    public final String zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpK)).booleanValue()) {
            if (!((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpM)).isEmpty()) {
                if (!((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpN)).isEmpty()) {
                    if (!((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpO)).isEmpty()) {
                        String str = (String) this.zzd.get();
                        if (!str.isEmpty()) {
                            return str;
                        }
                        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeea
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zzb();
                            }
                        });
                        return null;
                    }
                }
            }
        }
        return null;
    }

    final /* synthetic */ void zzb() {
        AtomicReference atomicReference = this.zzd;
        synchronized (atomicReference) {
            try {
                if (((String) atomicReference.get()).isEmpty()) {
                    atomicReference.set(zzc());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
