package com.google.zxing.client.result;

import com.facebook.UserSettingsManager;
import java.text.DateFormat;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class CalendarParsedResult extends ParsedResult {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f91692j = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long[] f91693k = {UserSettingsManager.TIMEOUT_7D, 86400000, 3600000, 60000, 1000};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Pattern f91694l = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f91695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f91696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f91697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f91698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f91699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f91700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f91701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String[] f91702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f91703i;

    private static String d(boolean z2, long j3) {
        if (j3 < 0) {
            return null;
        }
        return (z2 ? DateFormat.getDateInstance(2) : DateFormat.getDateTimeInstance(2, 2)).format(Long.valueOf(j3));
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        ParsedResult.b(this.f91695a, sb);
        ParsedResult.b(d(this.f91697c, this.f91696b), sb);
        ParsedResult.b(d(this.f91699e, this.f91698d), sb);
        ParsedResult.b(this.f91700f, sb);
        ParsedResult.b(this.f91701g, sb);
        ParsedResult.c(this.f91702h, sb);
        ParsedResult.b(this.f91703i, sb);
        return sb.toString();
    }
}
