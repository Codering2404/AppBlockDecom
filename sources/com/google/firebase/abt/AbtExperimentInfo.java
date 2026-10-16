package com.google.firebase.abt;

import android.text.TextUtils;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class AbtExperimentInfo {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f87625g = {"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final DateFormat f87626h = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f87627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f87628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f87629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Date f87630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f87631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f87632f;

    public AbtExperimentInfo(String str, String str2, String str3, Date date, long j3, long j4) {
        this.f87627a = str;
        this.f87628b = str2;
        this.f87629c = str3;
        this.f87630d = date;
        this.f87631e = j3;
        this.f87632f = j4;
    }

    static AbtExperimentInfo a(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        String str = conditionalUserProperty.f87660d;
        if (str == null) {
            str = "";
        }
        return new AbtExperimentInfo(conditionalUserProperty.f87658b, String.valueOf(conditionalUserProperty.f87659c), str, new Date(conditionalUserProperty.f87669m), conditionalUserProperty.f87661e, conditionalUserProperty.f87666j);
    }

    static AbtExperimentInfo b(Map map) throws AbtException {
        g(map);
        try {
            return new AbtExperimentInfo((String) map.get("experimentId"), (String) map.get("variantId"), map.containsKey("triggerEvent") ? (String) map.get("triggerEvent") : "", f87626h.parse((String) map.get("experimentStartTime")), Long.parseLong((String) map.get("triggerTimeoutMillis")), Long.parseLong((String) map.get("timeToLiveMillis")));
        } catch (NumberFormatException e3) {
            throw new AbtException("Could not process experiment: one of the durations could not be converted into a long.", e3);
        } catch (ParseException e4) {
            throw new AbtException("Could not process experiment: parsing experiment start time failed.", e4);
        }
    }

    private static void g(Map map) throws AbtException {
        ArrayList arrayList = new ArrayList();
        for (String str : f87625g) {
            if (!map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new AbtException(String.format("The following keys are missing from the experiment info map: %s", arrayList));
        }
    }

    String c() {
        return this.f87627a;
    }

    long d() {
        return this.f87630d.getTime();
    }

    String e() {
        return this.f87628b;
    }

    AnalyticsConnector.ConditionalUserProperty f(String str) {
        AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
        conditionalUserProperty.f87657a = str;
        conditionalUserProperty.f87669m = d();
        conditionalUserProperty.f87658b = this.f87627a;
        conditionalUserProperty.f87659c = this.f87628b;
        conditionalUserProperty.f87660d = TextUtils.isEmpty(this.f87629c) ? null : this.f87629c;
        conditionalUserProperty.f87661e = this.f87631e;
        conditionalUserProperty.f87666j = this.f87632f;
        return conditionalUserProperty;
    }
}
