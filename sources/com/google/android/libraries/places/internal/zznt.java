package com.google.android.libraries.places.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.facebook.share.HKJ.pnxuebdT;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.common.base.Preconditions;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zznt {
    public static Status b(Intent intent) {
        try {
            Preconditions.u(intent, "Intent must not be null.");
            Status status = (Status) intent.getParcelableExtra("places/status");
            Preconditions.u(status, "Intent expected to contain a Status, but doesn't.");
            return status;
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    public static zznq c(Intent intent) {
        return (zznq) Preconditions.t((zznq) intent.getParcelableExtra("places/AutocompleteOptions"));
    }

    public static String d(Context context, int i3) {
        Object objD = ConfigurationCompat.a(context.getResources().getConfiguration()).d(0);
        if (objD == null) {
            objD = Locale.getDefault();
        }
        Locale localeD = Places.c() ? Places.f().d() : objD;
        if (localeD.equals(objD)) {
            return context.getString(i3);
        }
        LocaleListCompat localeListCompatC = LocaleListCompat.c(localeD.toLanguageTag());
        Configuration configuration = context.getResources().getConfiguration();
        ConfigurationCompat.b(configuration, localeListCompatC);
        return context.createConfigurationContext(configuration).getString(i3);
    }

    public static Place a(Intent intent) {
        try {
            Preconditions.u(intent, "Intent must not be null.");
            Place place = (Place) intent.getParcelableExtra(pnxuebdT.AyCEWajQA);
            Preconditions.u(place, "Intent expected to contain a Place, but doesn't.");
            return place;
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }
}
