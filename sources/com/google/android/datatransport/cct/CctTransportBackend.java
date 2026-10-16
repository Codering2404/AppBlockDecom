package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.GraphRequest;
import com.facebook.appevents.UserDataStore;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.ComplianceData;
import com.google.android.datatransport.cct.internal.ExperimentIds;
import com.google.android.datatransport.cct.internal.ExternalPRequestContext;
import com.google.android.datatransport.cct.internal.ExternalPrivacyContext;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.LogResponse;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Function;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.retries.RetryStrategy;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class CctTransportBackend implements TransportBackend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataEncoder f69069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConnectivityManager f69070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f69071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final URL f69072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Clock f69073e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Clock f69074f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f69075g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class HttpRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final URL f69076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BatchedLogRequest f69077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f69078c;

        HttpRequest(URL url, BatchedLogRequest batchedLogRequest, String str) {
            this.f69076a = url;
            this.f69077b = batchedLogRequest;
            this.f69078c = str;
        }

        HttpRequest a(URL url) {
            return new HttpRequest(url, this.f69077b, this.f69078c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class HttpResponse {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f69079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final URL f69080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f69081c;

        HttpResponse(int i3, URL url, long j3) {
            this.f69079a = i3;
            this.f69080b = url;
            this.f69081c = j3;
        }
    }

    CctTransportBackend(Context context, Clock clock, Clock clock2, int i3) {
        this.f69069a = BatchedLogRequest.b();
        this.f69071c = context;
        this.f69070b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f69072d = n(CCTDestination.f69061c);
        this.f69073e = clock2;
        this.f69074f = clock;
        this.f69075g = i3;
    }

    public static /* synthetic */ HttpRequest d(HttpRequest httpRequest, HttpResponse httpResponse) {
        URL url = httpResponse.f69080b;
        if (url == null) {
            return null;
        }
        Logging.a("CctTransportBackend", "Following redirect to: %s", url);
        return httpRequest.a(httpResponse.f69080b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpResponse e(HttpRequest httpRequest) throws IOException {
        Logging.e("CctTransportBackend", "Making request to: %s", httpRequest.f69076a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpRequest.f69076a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f69075g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty(GraphRequest.USER_AGENT_HEADER, String.format("datatransport/%s android/", "3.3.0"));
        httpURLConnection.setRequestProperty(GraphRequest.CONTENT_ENCODING_HEADER, "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = httpRequest.f69078c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f69069a.a(httpRequest.f69077b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Logging.e("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
                    Logging.a("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    Logging.a("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField(GraphRequest.CONTENT_ENCODING_HEADER));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new HttpResponse(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new HttpResponse(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream inputStreamM = m(inputStream, httpURLConnection.getHeaderField(GraphRequest.CONTENT_ENCODING_HEADER));
                        try {
                            HttpResponse httpResponse = new HttpResponse(responseCode, null, LogResponse.b(new BufferedReader(new InputStreamReader(inputStreamM))).c());
                            if (inputStreamM != null) {
                                inputStreamM.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return httpResponse;
                        } finally {
                        }
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } finally {
                }
            } catch (Throwable th3) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (EncodingException e3) {
            e = e3;
            Logging.c("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new HttpResponse(RCHTTPStatusCodes.BAD_REQUEST, null, 0L);
        } catch (ConnectException e4) {
            e = e4;
            Logging.c("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new HttpResponse(500, null, 0L);
        } catch (UnknownHostException e5) {
            e = e5;
            Logging.c("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new HttpResponse(500, null, 0L);
        } catch (IOException e6) {
            e = e6;
            Logging.c("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new HttpResponse(RCHTTPStatusCodes.BAD_REQUEST, null, 0L);
        }
    }

    private static String f(Context context) {
        String simOperator = k(context).getSimOperator();
        return simOperator != null ? simOperator : "";
    }

    private static int g(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.b();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return NetworkConnectionInfo.MobileSubtype.COMBINED.b();
        }
        if (NetworkConnectionInfo.MobileSubtype.a(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    private static int h(NetworkInfo networkInfo) {
        return networkInfo == null ? NetworkConnectionInfo.NetworkType.NONE.b() : networkInfo.getType();
    }

    private static int i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e3) {
            Logging.c("CctTransportBackend", "Unable to find version code for package", e3);
            return -1;
        }
    }

    private BatchedLogRequest j(BackendRequest backendRequest) {
        LogEvent.Builder builderL;
        HashMap map = new HashMap();
        for (EventInternal eventInternal : backendRequest.b()) {
            String strN = eventInternal.n();
            if (map.containsKey(strN)) {
                ((List) map.get(strN)).add(eventInternal);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(eventInternal);
                map.put(strN, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            EventInternal eventInternal2 = (EventInternal) ((List) entry.getValue()).get(0);
            LogRequest.Builder builderB = LogRequest.a().f(QosTier.DEFAULT).g(this.f69074f.a()).h(this.f69073e.a()).b(ClientInfo.a().c(ClientInfo.ClientType.ANDROID_FIREBASE).b(AndroidClientInfo.a().m(Integer.valueOf(eventInternal2.i("sdk-version"))).j(eventInternal2.b(DeviceRequestsHelper.DEVICE_INFO_MODEL)).f(eventInternal2.b("hardware")).d(eventInternal2.b(DeviceRequestsHelper.DEVICE_INFO_DEVICE)).l(eventInternal2.b(AppLovinEventTypes.USER_VIEWED_PRODUCT)).k(eventInternal2.b("os-uild")).h(eventInternal2.b("manufacturer")).e(eventInternal2.b("fingerprint")).c(eventInternal2.b(UserDataStore.COUNTRY)).g(eventInternal2.b("locale")).i(eventInternal2.b("mcc_mnc")).b(eventInternal2.b("application_build")).a()).a());
            try {
                builderB.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                builderB.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (EventInternal eventInternal3 : (List) entry.getValue()) {
                EncodedPayload encodedPayloadE = eventInternal3.e();
                Encoding encodingB = encodedPayloadE.b();
                if (encodingB.equals(Encoding.b("proto"))) {
                    builderL = LogEvent.l(encodedPayloadE.a());
                } else if (encodingB.equals(Encoding.b(GraphRequest.FORMAT_JSON))) {
                    builderL = LogEvent.k(new String(encodedPayloadE.a(), Charset.forName(Utf8Charset.NAME)));
                } else {
                    Logging.f("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", encodingB);
                }
                builderL.d(eventInternal3.f()).e(eventInternal3.o()).j(eventInternal3.j("tz-offset")).g(NetworkConnectionInfo.a().c(NetworkConnectionInfo.NetworkType.a(eventInternal3.i("net-type"))).b(NetworkConnectionInfo.MobileSubtype.a(eventInternal3.i("mobile-subtype"))).a());
                if (eventInternal3.d() != null) {
                    builderL.c(eventInternal3.d());
                }
                if (eventInternal3.l() != null) {
                    builderL.b(ComplianceData.a().b(ExternalPrivacyContext.a().b(ExternalPRequestContext.a().b(eventInternal3.l()).a()).a()).c(ComplianceData.ProductIdOrigin.EVENT_OVERRIDE).a());
                }
                if (eventInternal3.g() != null || eventInternal3.h() != null) {
                    ExperimentIds.Builder builderA = ExperimentIds.a();
                    if (eventInternal3.g() != null) {
                        builderA.b(eventInternal3.g());
                    }
                    if (eventInternal3.h() != null) {
                        builderA.c(eventInternal3.h());
                    }
                    builderL.f(builderA.a());
                }
                arrayList3.add(builderL.a());
            }
            builderB.c(arrayList3);
            arrayList2.add(builderB.a());
        }
        return BatchedLogRequest.a(arrayList2);
    }

    private static TelephonyManager k(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    static long l() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    private static InputStream m(InputStream inputStream, String str) {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    private static URL n(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e3) {
            throw new IllegalArgumentException("Invalid url: " + str, e3);
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    public EventInternal a(EventInternal eventInternal) {
        NetworkInfo activeNetworkInfo = this.f69070b.getActiveNetworkInfo();
        return eventInternal.p().a("sdk-version", Build.VERSION.SDK_INT).c(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL).c("hardware", Build.HARDWARE).c(DeviceRequestsHelper.DEVICE_INFO_DEVICE, Build.DEVICE).c(AppLovinEventTypes.USER_VIEWED_PRODUCT, Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", l()).a("net-type", h(activeNetworkInfo)).a("mobile-subtype", g(activeNetworkInfo)).c(UserDataStore.COUNTRY, Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", f(this.f69071c)).c("application_build", Integer.toString(i(this.f69071c))).d();
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    public BackendResponse b(BackendRequest backendRequest) {
        BatchedLogRequest batchedLogRequestJ = j(backendRequest);
        URL urlN = this.f69072d;
        if (backendRequest.c() != null) {
            try {
                CCTDestination cCTDestinationC = CCTDestination.c(backendRequest.c());
                strD = cCTDestinationC.d() != null ? cCTDestinationC.d() : null;
                if (cCTDestinationC.e() != null) {
                    urlN = n(cCTDestinationC.e());
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.a();
            }
        }
        try {
            HttpResponse httpResponse = (HttpResponse) Retries.a(5, new HttpRequest(urlN, batchedLogRequestJ, strD), new Function() { // from class: com.google.android.datatransport.cct.a
                @Override // com.google.android.datatransport.runtime.retries.Function
                public final Object apply(Object obj) {
                    return this.f69082a.e((CctTransportBackend.HttpRequest) obj);
                }
            }, new RetryStrategy() { // from class: com.google.android.datatransport.cct.b
                @Override // com.google.android.datatransport.runtime.retries.RetryStrategy
                public final Object a(Object obj, Object obj2) {
                    return CctTransportBackend.d((CctTransportBackend.HttpRequest) obj, (CctTransportBackend.HttpResponse) obj2);
                }
            });
            int i3 = httpResponse.f69079a;
            if (i3 == 200) {
                return BackendResponse.e(httpResponse.f69081c);
            }
            if (i3 < 500 && i3 != 404) {
                return i3 == 400 ? BackendResponse.d() : BackendResponse.a();
            }
            return BackendResponse.f();
        } catch (IOException e3) {
            Logging.c("CctTransportBackend", "Could not make request to the backend", e3);
            return BackendResponse.f();
        }
    }

    CctTransportBackend(Context context, Clock clock, Clock clock2) {
        this(context, clock, clock2, 130000);
    }
}
