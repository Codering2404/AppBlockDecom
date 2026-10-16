package com.google.android.gms.measurement.internal;

import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzba extends zzjf {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f73462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f73463d;

    zzba(zzic zzicVar) {
        super(zzicVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    protected final boolean i() {
        Calendar calendar = Calendar.getInstance();
        this.f73462c = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append("-");
        sb.append(lowerCase2);
        this.f73463d = sb.toString();
        return false;
    }

    public final long o() {
        l();
        return this.f73462c;
    }

    public final String p() {
        l();
        return this.f73463d;
    }
}
