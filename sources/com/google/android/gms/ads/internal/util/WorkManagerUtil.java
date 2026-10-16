package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.offline.buffering.OfflineNotificationPoster;
import com.google.android.gms.ads.internal.offline.buffering.OfflinePingSender;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class WorkManagerUtil extends zzbn {
    private static void x3(Context context) {
        try {
            WorkManager.l(context.getApplicationContext(), new Configuration.Builder().a());
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzbo
    public final boolean zze(IObjectWrapper iObjectWrapper, String str, String str2) {
        return zzg(iObjectWrapper, new com.google.android.gms.ads.internal.offline.buffering.zza(str, str2, ""));
    }

    @Override // com.google.android.gms.ads.internal.util.zzbo
    public final void zzf(IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.h5(iObjectWrapper);
        x3(context);
        try {
            WorkManager workManagerH = WorkManager.h(context);
            workManagerH.a("offline_ping_sender_work");
            workManagerH.c((OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(OfflinePingSender.class).i(new Constraints.Builder().b(NetworkType.CONNECTED).a())).a("offline_ping_sender_work")).b());
        } catch (IllegalStateException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to instantiate WorkManager.", e3);
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzbo
    public final boolean zzg(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza zzaVar) throws Throwable {
        Context context = (Context) ObjectWrapper.h5(iObjectWrapper);
        x3(context);
        Constraints constraintsA = new Constraints.Builder().b(NetworkType.CONNECTED).a();
        try {
            WorkManager.h(context).c((OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(OfflineNotificationPoster.class).i(constraintsA)).l(new Data.Builder().e(ShareConstants.MEDIA_URI, zzaVar.f70037a).e("gws_query_id", zzaVar.f70038b).e("image_url", zzaVar.f70039c).a())).a("offline_notification_work")).b());
            return true;
        } catch (IllegalStateException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to instantiate WorkManager.", e3);
            return false;
        }
    }
}
