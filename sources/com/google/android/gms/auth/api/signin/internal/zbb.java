package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbb implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Logger f71246c = new Logger("RevokeAccessOperation", new String[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f71247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StatusPendingResult f71248b = new StatusPendingResult(null);

    public zbb(String str) {
        this.f71247a = Preconditions.g(str);
    }

    public static PendingResult a(String str) {
        if (str == null) {
            return PendingResults.a(new Status(4), null);
        }
        zbb zbbVar = new zbb(str);
        new Thread(zbbVar).start();
        return zbbVar.f71248b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Status status = Status.f71539i;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/revoke?token=" + this.f71247a).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.f71537g;
            } else {
                f71246c.c("Unable to revoke access!", new Object[0]);
            }
            f71246c.a("Response Code: " + responseCode, new Object[0]);
        } catch (IOException e3) {
            f71246c.c("IOException when revoking access: ".concat(String.valueOf(e3.toString())), new Object[0]);
        } catch (Exception e4) {
            f71246c.c("Exception when revoking access: ".concat(String.valueOf(e4.toString())), new Object[0]);
        }
        this.f71248b.setResult(status);
    }
}
