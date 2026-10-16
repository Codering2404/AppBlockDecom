package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LogPrinter;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzg implements zzt {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f70895b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LogPrinter f70896a = new LogPrinter(4, "GA/LogCatTransport");

    static {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(ShareConstants.MEDIA_URI);
        builder.authority("local");
        f70895b = builder.build();
    }

    @Override // com.google.android.gms.analytics.zzt
    public final void a(zzh zzhVar) {
        ArrayList arrayList = new ArrayList(zzhVar.e());
        Collections.sort(arrayList, new zzf(this));
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            String string = ((zzj) arrayList.get(i3)).toString();
            if (!TextUtils.isEmpty(string)) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(string);
            }
        }
        this.f70896a.println(sb.toString());
    }

    @Override // com.google.android.gms.analytics.zzt
    public final Uri zzb() {
        return f70895b;
    }
}
