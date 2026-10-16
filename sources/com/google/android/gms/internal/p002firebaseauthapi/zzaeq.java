package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzao;
import com.google.firebase.inject.Provider;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaeq extends AsyncTask<Void, Void, zzaep> {
    private static final Logger zza = new Logger("FirebaseAuth", "GetAuthDomainTask");
    private final String zzb;
    private final String zzc;
    private final WeakReference<zzaes> zzd;
    private final Uri.Builder zze;
    private final String zzf;
    private final FirebaseApp zzg;

    public zzaeq(String str, String str2, Intent intent, FirebaseApp firebaseApp, zzaes zzaesVar) {
        this.zzb = Preconditions.g(str);
        this.zzg = (FirebaseApp) Preconditions.m(firebaseApp);
        Preconditions.g(str2);
        Preconditions.m(intent);
        String strG = Preconditions.g(intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY"));
        Uri.Builder builderBuildUpon = Uri.parse(zzaesVar.zza(strG)).buildUpon();
        builderBuildUpon.appendPath("getProjectConfig").appendQueryParameter("key", strG).appendQueryParameter("androidPackageName", str).appendQueryParameter("sha1Cert", (String) Preconditions.m(str2));
        this.zzc = builderBuildUpon.build().toString();
        this.zzd = new WeakReference<>(zzaesVar);
        this.zze = zzaesVar.zza(intent, str, str2);
        this.zzf = intent.getStringExtra("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzaep doInBackground(Void... voidArr) {
        try {
            URL url = new URL(this.zzc);
            zzaes zzaesVar = this.zzd.get();
            HttpURLConnection httpURLConnectionZza = zzaesVar.zza(url);
            httpURLConnectionZza.addRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpURLConnectionZza.setConnectTimeout(60000);
            new zzafe(zzaesVar.zza(), this.zzg, zzafc.zza().zzb()).zza(httpURLConnectionZza);
            int responseCode = httpURLConnectionZza.getResponseCode();
            if (responseCode != 200) {
                String strZza = zza(httpURLConnectionZza);
                zza.c(String.format("Error getting project config. Failed with %s %s", strZza, Integer.valueOf(responseCode)), new Object[0]);
                return zzaep.zzb(strZza);
            }
            zzahq zzahqVar = new zzahq();
            zzahqVar.zza(new String(zza(httpURLConnectionZza.getInputStream(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)));
            if (!TextUtils.isEmpty(this.zzf)) {
                return !zzahqVar.zza().contains(this.zzf) ? zzaep.zzb("UNAUTHORIZED_DOMAIN") : zzaep.zza(this.zzf);
            }
            for (String str : zzahqVar.zza()) {
                if (zza(str)) {
                    return zzaep.zza(str);
                }
            }
            return null;
        } catch (zzacn e3) {
            zza.c("ConversionException encountered: " + e3.getMessage(), new Object[0]);
            return null;
        } catch (IOException e4) {
            zza.c("IOException occurred: " + e4.getMessage(), new Object[0]);
            return null;
        } catch (NullPointerException e5) {
            zza.c("Null pointer encountered: " + e5.getMessage(), new Object[0]);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onCancelled(zzaep zzaepVar) {
        onPostExecute((zzaep) null);
    }

    private static String zza(HttpURLConnection httpURLConnection) throws zzacn {
        try {
            if (httpURLConnection.getResponseCode() < 400) {
                return null;
            }
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream == null) {
                return "WEB_INTERNAL_ERROR:Could not retrieve the authDomain for this project but did not receive an error response from the network request. Please try again.";
            }
            return (String) zzaex.zza(new String(zza(errorStream, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)), String.class);
        } catch (IOException e3) {
            zza.h("Error parsing error message from response body in getErrorMessageFromBody. " + String.valueOf(e3), new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final void onPostExecute(zzaep zzaepVar) {
        String strZza;
        String strZzb;
        Uri.Builder builder;
        zzaes zzaesVar = this.zzd.get();
        if (zzaepVar != null) {
            strZza = zzaepVar.zza();
            strZzb = zzaepVar.zzb();
        } else {
            strZza = null;
            strZzb = null;
        }
        if (zzaesVar == null) {
            zza.c("An error has occurred: the handler reference has returned null.", new Object[0]);
        } else if (!TextUtils.isEmpty(strZza) && (builder = this.zze) != null) {
            builder.authority(strZza);
            zzaesVar.zza(this.zze.build(), this.zzb, (Provider<InteropAppCheckTokenProvider>) FirebaseAuth.getInstance(this.zzg).M());
        } else {
            zzaesVar.zza(this.zzb, zzao.a(strZzb));
        }
    }

    private static boolean zza(String str) {
        try {
            String host = new URI("https://" + str).getHost();
            if (host != null) {
                if (host.endsWith("firebaseapp.com")) {
                    return true;
                }
                if (host.endsWith("web.app")) {
                    return true;
                }
            }
        } catch (URISyntaxException e3) {
            zza.c("Error parsing URL for auth domain check: " + str + ". " + e3.getMessage(), new Object[0]);
        }
        return false;
    }

    private static byte[] zza(InputStream inputStream, int i3) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];
            while (true) {
                int i4 = inputStream.read(bArr);
                if (i4 != -1) {
                    byteArrayOutputStream.write(bArr, 0, i4);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            byteArrayOutputStream.close();
            throw th;
        }
    }
}
