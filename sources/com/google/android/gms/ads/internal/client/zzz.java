package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdSize[] f70033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f70034b;

    public zzz(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.f69674a);
        String string = typedArrayObtainAttributes.getString(R.styleable.f69675b);
        String string2 = typedArrayObtainAttributes.getString(R.styleable.f69676c);
        boolean zIsEmpty = TextUtils.isEmpty(string);
        boolean zIsEmpty2 = TextUtils.isEmpty(string2);
        if (!zIsEmpty && zIsEmpty2) {
            this.f70033a = c(string);
        } else {
            if (!zIsEmpty || zIsEmpty2) {
                if (zIsEmpty) {
                    typedArrayObtainAttributes.recycle();
                    throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
                }
                typedArrayObtainAttributes.recycle();
                throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
            }
            this.f70033a = c(string2);
        }
        String string3 = typedArrayObtainAttributes.getString(R.styleable.f69677d);
        this.f70034b = string3;
        typedArrayObtainAttributes.recycle();
        if (TextUtils.isEmpty(string3)) {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
    }

    private static AdSize[] c(String str) {
        String[] strArrSplit = str.split("\\s*,\\s*");
        int length = strArrSplit.length;
        AdSize[] adSizeArr = new AdSize[length];
        for (int i3 = 0; i3 < strArrSplit.length; i3++) {
            String strTrim = strArrSplit[i3].trim();
            if (strTrim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] strArrSplit2 = strTrim.split("[xX]");
                strArrSplit2[0] = strArrSplit2[0].trim();
                strArrSplit2[1] = strArrSplit2[1].trim();
                try {
                    String str2 = strArrSplit2[0];
                    int i4 = "FULL_WIDTH".equals(str2) ? -1 : Integer.parseInt(str2);
                    String str3 = strArrSplit2[1];
                    adSizeArr[i3] = new AdSize(i4, "AUTO_HEIGHT".equals(str3) ? -2 : Integer.parseInt(str3));
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": ".concat(strTrim));
                }
            } else if ("BANNER".equals(strTrim)) {
                adSizeArr[i3] = AdSize.f69645j;
            } else if ("LARGE_BANNER".equals(strTrim)) {
                adSizeArr[i3] = AdSize.f69647l;
            } else if ("FULL_BANNER".equals(strTrim)) {
                adSizeArr[i3] = AdSize.f69646k;
            } else if ("LEADERBOARD".equals(strTrim)) {
                adSizeArr[i3] = AdSize.f69648m;
            } else if ("MEDIUM_RECTANGLE".equals(strTrim)) {
                adSizeArr[i3] = AdSize.f69649n;
            } else if ("SMART_BANNER".equals(strTrim)) {
                adSizeArr[i3] = AdSize.f69651p;
            } else if ("WIDE_SKYSCRAPER".equals(strTrim)) {
                adSizeArr[i3] = AdSize.f69650o;
            } else if ("FLUID".equals(strTrim)) {
                adSizeArr[i3] = AdSize.f69652q;
            } else {
                if (!"ICON".equals(strTrim)) {
                    throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": ".concat(strTrim));
                }
                adSizeArr[i3] = AdSize.f69654s;
            }
        }
        if (length != 0) {
            return adSizeArr;
        }
        throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": ".concat(str));
    }

    public final AdSize[] a(boolean z2) {
        if (z2 || this.f70033a.length == 1) {
            return this.f70033a;
        }
        throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    }

    public final String b() {
        return this.f70034b;
    }
}
