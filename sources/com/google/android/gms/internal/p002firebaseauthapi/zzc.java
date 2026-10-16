package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzc extends zza {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zza
    public final URLConnection zza(URL url, String str) throws IOException {
        return url.openConnection();
    }

    private zzc() {
    }
}
