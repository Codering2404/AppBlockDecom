package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfug extends zzfub {
    public zzfug(ClientApi clientApi, Context context, int i3, zzflu zzfluVar, com.google.android.gms.ads.internal.client.zzfp zzfpVar, com.google.android.gms.ads.internal.client.zzcb zzcbVar, ScheduledExecutorService scheduledExecutorService, zzfoo zzfooVar, zzfsw zzfswVar, Clock clock) {
        super(clientApi, context, i3, zzfluVar, zzfpVar, zzcbVar, scheduledExecutorService, zzfooVar, zzfswVar, clock);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
    @Override // com.google.android.gms.internal.ads.zzfub
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.google.common.util.concurrent.ListenableFuture zza(android.content.Context r10) {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzflu r0 = r9.zzd
            com.google.android.gms.internal.ads.zzbvc r0 = r0.zzd()
            java.lang.String r1 = "Failed to create a rewarded ad."
            r2 = 1
            if (r0 != 0) goto L15
            com.google.android.gms.internal.ads.zzfso r10 = new com.google.android.gms.internal.ads.zzfso
            r10.<init>(r2, r1)
            com.google.common.util.concurrent.ListenableFuture r10 = com.google.android.gms.internal.ads.zzhbw.zzc(r10)
            return r10
        L15:
            com.google.android.gms.ads.internal.ClientApi r3 = r9.zza
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.i5(r10)
            java.util.concurrent.atomic.AtomicReference r4 = r9.zze
            java.lang.Object r4 = r4.get()
            com.google.android.gms.ads.internal.client.zzfp r4 = (com.google.android.gms.ads.internal.client.zzfp) r4
            java.lang.String r4 = r4.f69947a
            int r5 = r9.zzc
            com.google.android.gms.internal.ads.zzcci r10 = r3.J4(r10, r4, r0, r5)
            com.google.android.gms.internal.ads.zzfjw r10 = (com.google.android.gms.internal.ads.zzfjw) r10
            if (r10 != 0) goto L39
            com.google.android.gms.internal.ads.zzfso r10 = new com.google.android.gms.internal.ads.zzfso
            r10.<init>(r2, r1)
            com.google.common.util.concurrent.ListenableFuture r10 = com.google.android.gms.internal.ads.zzhbw.zzc(r10)
            return r10
        L39:
            com.google.android.gms.internal.ads.zzhcp r0 = com.google.android.gms.internal.ads.zzhcp.zze()
            java.util.concurrent.atomic.AtomicReference r1 = r9.zze     // Catch: android.os.RemoteException -> L7c
            java.lang.Object r1 = r1.get()     // Catch: android.os.RemoteException -> L7c
            com.google.android.gms.ads.internal.client.zzfp r1 = (com.google.android.gms.ads.internal.client.zzfp) r1     // Catch: android.os.RemoteException -> L7c
            com.google.android.gms.ads.internal.client.zzm r1 = r1.f69949c     // Catch: android.os.RemoteException -> L7c
            r9.zzB(r1)     // Catch: android.os.RemoteException -> L7c
            com.google.android.gms.internal.ads.zzfsn r4 = r9.zzf     // Catch: android.os.RemoteException -> L7c
            if (r4 == 0) goto L7e
            com.google.android.gms.internal.ads.zzbih r1 = com.google.android.gms.internal.ads.zzbiq.zzT     // Catch: android.os.RemoteException -> L7c
            com.google.android.gms.internal.ads.zzbio r3 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: android.os.RemoteException -> L7c
            java.lang.Object r1 = r3.zzd(r1)     // Catch: android.os.RemoteException -> L7c
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: android.os.RemoteException -> L7c
            boolean r1 = r1.booleanValue()     // Catch: android.os.RemoteException -> L7c
            if (r1 == 0) goto L7e
            com.google.android.gms.internal.ads.zzfsy r3 = new com.google.android.gms.internal.ads.zzfsy     // Catch: android.os.RemoteException -> L7c
            java.util.concurrent.ScheduledExecutorService r5 = r9.zzi     // Catch: android.os.RemoteException -> L7c
            com.google.android.gms.internal.ads.zzbih r1 = com.google.android.gms.internal.ads.zzbiq.zzV     // Catch: android.os.RemoteException -> L7c
            com.google.android.gms.internal.ads.zzbio r6 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: android.os.RemoteException -> L7c
            java.lang.Object r1 = r6.zzd(r1)     // Catch: android.os.RemoteException -> L7c
            java.lang.Long r1 = (java.lang.Long) r1     // Catch: android.os.RemoteException -> L7c
            long r6 = r1.longValue()     // Catch: android.os.RemoteException -> L7c
            r8 = r9
            r3.<init>(r4, r5, r6, r8)     // Catch: android.os.RemoteException -> La1
            r10.zzu(r3)     // Catch: android.os.RemoteException -> La1
            goto L7f
        L7c:
            r8 = r9
            goto La1
        L7e:
            r8 = r9
        L7f:
            java.util.concurrent.atomic.AtomicReference r1 = r8.zze     // Catch: android.os.RemoteException -> La1
            java.lang.Object r1 = r1.get()     // Catch: android.os.RemoteException -> La1
            com.google.android.gms.ads.internal.client.zzfp r1 = (com.google.android.gms.ads.internal.client.zzfp) r1     // Catch: android.os.RemoteException -> La1
            com.google.android.gms.ads.internal.client.zzm r1 = r1.f69949c     // Catch: android.os.RemoteException -> La1
            com.google.android.gms.internal.ads.zzfuf r3 = new com.google.android.gms.internal.ads.zzfuf     // Catch: android.os.RemoteException -> La1
            com.google.android.gms.internal.ads.zzfto r4 = new com.google.android.gms.internal.ads.zzfto     // Catch: android.os.RemoteException -> La1
            r4.<init>(r9, r0)     // Catch: android.os.RemoteException -> La1
            java.util.concurrent.atomic.AtomicReference r5 = r8.zze     // Catch: android.os.RemoteException -> La1
            java.lang.Object r5 = r5.get()     // Catch: android.os.RemoteException -> La1
            com.google.android.gms.ads.internal.client.zzfp r5 = (com.google.android.gms.ads.internal.client.zzfp) r5     // Catch: android.os.RemoteException -> La1
            java.lang.String r5 = r5.f69947a     // Catch: android.os.RemoteException -> La1
            r3.<init>(r10, r4, r5)     // Catch: android.os.RemoteException -> La1
            r10.zzc(r1, r3)     // Catch: android.os.RemoteException -> La1
            return r0
        La1:
            java.lang.String r10 = "Failed to load rewarded ad."
            com.google.android.gms.ads.internal.util.client.zzo.f(r10)
            com.google.android.gms.internal.ads.zzfso r10 = new com.google.android.gms.internal.ads.zzfso
            java.lang.String r0 = "remote exception"
            r10.<init>(r2, r0)
            com.google.common.util.concurrent.ListenableFuture r10 = com.google.android.gms.internal.ads.zzhbw.zzc(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfug.zza(android.content.Context):com.google.common.util.concurrent.ListenableFuture");
    }

    @Override // com.google.android.gms.internal.ads.zzfub
    protected final long zzb() {
        return ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzR)).longValue();
    }

    @Override // com.google.android.gms.internal.ads.zzfub
    protected final /* bridge */ /* synthetic */ com.google.android.gms.ads.internal.client.zzdx zzc(Object obj) {
        try {
            return ((zzcci) obj).zzm();
        } catch (RemoteException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.b("Failed to get response info for the rewarded ad.", e3);
            return null;
        }
    }

    public zzfug(String str, ClientApi clientApi, Context context, int i3, zzflu zzfluVar, com.google.android.gms.ads.internal.client.zzfp zzfpVar, com.google.android.gms.ads.internal.client.zzce zzceVar, ScheduledExecutorService scheduledExecutorService, zzfoo zzfooVar, zzfsw zzfswVar, Clock clock, zzfsn zzfsnVar) {
        super(str, clientApi, context, i3, zzfluVar, zzfpVar, zzceVar, scheduledExecutorService, zzfooVar, zzfswVar, clock, zzfsnVar);
    }
}
