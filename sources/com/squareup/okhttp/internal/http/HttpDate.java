package com.squareup.okhttp.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class HttpDate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TimeZone f93365a = TimeZone.getTimeZone("GMT");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f93366b = new ThreadLocal<DateFormat>() { // from class: com.squareup.okhttp.internal.http.HttpDate.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(HttpDate.f93365a);
            return simpleDateFormat;
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f93367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final DateFormat[] f93368d;

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f93367c = strArr;
        f93368d = new DateFormat[strArr.length];
    }

    public static Date b(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = ((DateFormat) f93366b.get()).parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return date;
        }
        String[] strArr = f93367c;
        synchronized (strArr) {
            try {
                int length = strArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    DateFormat[] dateFormatArr = f93368d;
                    DateFormat simpleDateFormat = dateFormatArr[i3];
                    if (simpleDateFormat == null) {
                        simpleDateFormat = new SimpleDateFormat(f93367c[i3], Locale.US);
                        simpleDateFormat.setTimeZone(f93365a);
                        dateFormatArr[i3] = simpleDateFormat;
                    }
                    parsePosition.setIndex(0);
                    Date date2 = simpleDateFormat.parse(str, parsePosition);
                    if (parsePosition.getIndex() != 0) {
                        return date2;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
