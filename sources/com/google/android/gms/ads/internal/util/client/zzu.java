package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import android.net.TrafficStats;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbzy;
import com.google.android.gms.internal.ads.zzfzr;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzu implements zze {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f70197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f70198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f70199c;

    public zzu(Context context, String str) {
        this.f70197a = context;
        this.f70198b = str;
    }

    private final URL c(String str) {
        URL urlD = null;
        try {
            urlD = new URI(str).toURL();
        } catch (IllegalArgumentException e3) {
            e = e3;
            e(str, e);
        } catch (MalformedURLException e4) {
            e = e4;
            e(str, e);
        } catch (URISyntaxException e5) {
            e(str, e5);
            if (((Boolean) zzba.c().zzd(zzbiq.zzf)).booleanValue()) {
                urlD = d(str);
            }
        }
        if (urlD != null) {
            return urlD;
        }
        StringBuilder sb = new StringBuilder(str.length() + 47);
        sb.append("Falling back to direct new URL(\"");
        sb.append(str);
        sb.append("\") constructor.");
        zzo.a(sb.toString());
        return new URL(str);
    }

    private final URL d(String str) {
        URL url;
        URI uri;
        try {
            zzo.a("Attempting to parse components, encode, and reconstruct URI.");
            URL url2 = new URL(str);
            uri = new URI(url2.getProtocol(), url2.getUserInfo(), url2.getHost(), url2.getPort(), url2.getPath(), url2.getQuery(), url2.getRef());
            url = uri.toURL();
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException e3) {
            e = e3;
            url = null;
        }
        try {
            String string = uri.toString();
            StringBuilder sb = new StringBuilder(str.length() + 114 + string.length());
            sb.append("Successfully constructed URL after component encoding via new URI(parts).toURL() for original: \"");
            sb.append(str);
            sb.append("\" -> encoded URI: ");
            sb.append(string);
            zzo.a(sb.toString());
            return url;
        } catch (IllegalArgumentException e4) {
            e = e4;
            e(str, e);
            return url;
        } catch (MalformedURLException e5) {
            e = e5;
            e(str, e);
            return url;
        } catch (URISyntaxException e6) {
            e = e6;
            e(str, e);
            return url;
        }
    }

    private final void e(String str, Throwable th) {
        String message = th.getMessage();
        StringBuilder sb = new StringBuilder(str.length() + 32 + String.valueOf(message).length());
        sb.append("Error while parsing ping URL: ");
        sb.append(str);
        sb.append(". ");
        sb.append(message);
        zzo.f(sb.toString());
        zzbzy.zza(this.f70197a).zzi(th, "HttpUrlPinger.pingUrl", ((Integer) zzba.c().zzd(zzbiq.zzoj)).intValue() / 100.0f);
    }

    public final String a() {
        return this.f70199c;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zze
    public final zzt zza(String str) {
        return b(str, null);
    }

    public final zzt b(String str, Map map) {
        zzt zztVar = zzt.PERMANENT_FAILURE;
        if (str != null) {
            if (!((Boolean) zzba.c().zzd(zzbiq.zzg)).booleanValue() || !str.isEmpty()) {
                if (!((Boolean) zzba.c().zzd(zzbiq.zzdi)).booleanValue() || !zzay.e()) {
                    try {
                        try {
                            if (ClientLibraryUtils.a()) {
                                TrafficStats.setThreadStatsTag(263);
                            }
                            StringBuilder sb = new StringBuilder(str.length() + 13);
                            sb.append("Pinging URL: ");
                            sb.append(str);
                            zzo.a(sb.toString());
                            URL urlC = c(str);
                            int i3 = zzfzr.zzb;
                            HttpURLConnection httpURLConnection = (HttpURLConnection) urlC.openConnection();
                            try {
                                zzay.a();
                                String str2 = this.f70198b;
                                httpURLConnection.setConnectTimeout(60000);
                                httpURLConnection.setInstanceFollowRedirects(true);
                                httpURLConnection.setReadTimeout(60000);
                                if (str2 != null) {
                                    httpURLConnection.setRequestProperty(SbbqvQlxi.dJjjvjyTOuH, str2);
                                }
                                httpURLConnection.setUseCaches(false);
                                if (map != null) {
                                    for (Map.Entry entry : map.entrySet()) {
                                        httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                                    }
                                }
                                zzl zzlVar = new zzl(null);
                                zzlVar.a(httpURLConnection, null);
                                int responseCode = httpURLConnection.getResponseCode();
                                zzlVar.c(httpURLConnection, responseCode);
                                if (responseCode < 200 || responseCode >= 300) {
                                    StringBuilder sb2 = new StringBuilder(String.valueOf(responseCode).length() + 54 + str.length());
                                    sb2.append("Received non-success response code ");
                                    sb2.append(responseCode);
                                    sb2.append(" from pinging URL: ");
                                    sb2.append(str);
                                    zzo.f(sb2.toString());
                                    if (responseCode == 502) {
                                        zztVar = zzt.RETRIABLE_FAILURE;
                                    }
                                } else {
                                    if (((Boolean) zzba.c().zzd(zzbiq.zziY)).booleanValue()) {
                                        this.f70199c = httpURLConnection.getHeaderField("X-Afma-Ad-Event-Value");
                                    }
                                    zztVar = zzt.SUCCESS;
                                }
                                httpURLConnection.disconnect();
                                if (!ClientLibraryUtils.a()) {
                                    return zztVar;
                                }
                            } catch (Throwable th) {
                                httpURLConnection.disconnect();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            if (ClientLibraryUtils.a()) {
                                TrafficStats.clearThreadStatsTag();
                            }
                            throw th2;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        String message = e.getMessage();
                        StringBuilder sb3 = new StringBuilder(str.length() + 27 + String.valueOf(message).length());
                        sb3.append("Error while pinging URL: ");
                        sb3.append(str);
                        sb3.append(". ");
                        sb3.append(message);
                        zzo.f(sb3.toString());
                        zztVar = zzt.RETRIABLE_FAILURE;
                        if (ClientLibraryUtils.a()) {
                        }
                        return zztVar;
                    } catch (IndexOutOfBoundsException e4) {
                        e = e4;
                        e(str, e);
                        if (ClientLibraryUtils.a()) {
                        }
                        return zztVar;
                    } catch (RuntimeException e5) {
                        e = e5;
                        String message2 = e.getMessage();
                        StringBuilder sb32 = new StringBuilder(str.length() + 27 + String.valueOf(message2).length());
                        sb32.append("Error while pinging URL: ");
                        sb32.append(str);
                        sb32.append(". ");
                        sb32.append(message2);
                        zzo.f(sb32.toString());
                        zztVar = zzt.RETRIABLE_FAILURE;
                        if (ClientLibraryUtils.a()) {
                        }
                        return zztVar;
                    } catch (MalformedURLException e6) {
                        e = e6;
                        e(str, e);
                        if (ClientLibraryUtils.a()) {
                        }
                        return zztVar;
                    }
                    TrafficStats.clearThreadStatsTag();
                    return zztVar;
                }
            }
        }
        return zztVar;
    }
}
