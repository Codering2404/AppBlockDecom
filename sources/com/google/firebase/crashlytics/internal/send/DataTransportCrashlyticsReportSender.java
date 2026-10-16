package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import com.facebook.GraphRequest;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class DataTransportCrashlyticsReportSender {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CrashlyticsReportJsonTransform f89021c = new CrashlyticsReportJsonTransform();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f89022d = d("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f89023e = d("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Transformer f89024f = new Transformer() { // from class: com.google.firebase.crashlytics.internal.send.a
        @Override // com.google.android.datatransport.Transformer
        public final Object apply(Object obj) {
            return DataTransportCrashlyticsReportSender.f89021c.M((CrashlyticsReport) obj).getBytes(Charset.forName(Utf8Charset.NAME));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ReportQueue f89025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Transformer f89026b;

    DataTransportCrashlyticsReportSender(ReportQueue reportQueue, Transformer transformer) {
        this.f89025a = reportQueue;
        this.f89026b = transformer;
    }

    public static DataTransportCrashlyticsReportSender b(Context context, SettingsProvider settingsProvider, OnDemandCounter onDemandCounter) {
        TransportRuntime.f(context);
        TransportFactory transportFactoryG = TransportRuntime.c().g(new CCTDestination(f89022d, f89023e));
        Encoding encodingB = Encoding.b(GraphRequest.FORMAT_JSON);
        Transformer transformer = f89024f;
        return new DataTransportCrashlyticsReportSender(new ReportQueue(transportFactoryG.a("FIREBASE_CRASHLYTICS_REPORT", CrashlyticsReport.class, encodingB, transformer), settingsProvider.b(), onDemandCounter), transformer);
    }

    private static String d(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length());
        for (int i3 = 0; i3 < str.length(); i3++) {
            sb.append(str.charAt(i3));
            if (str2.length() > i3) {
                sb.append(str2.charAt(i3));
            }
        }
        return sb.toString();
    }

    public Task c(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, boolean z2) {
        return this.f89025a.i(crashlyticsReportWithSessionId, z2).getTask();
    }
}
