package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfta extends zzfub {
    public zzfta(ClientApi clientApi, Context context, int i3, zzflu zzfluVar, com.google.android.gms.ads.internal.client.zzfp zzfpVar, com.google.android.gms.ads.internal.client.zzcb zzcbVar, ScheduledExecutorService scheduledExecutorService, zzfoo zzfooVar, zzfsw zzfswVar, Clock clock) {
        super(clientApi, context, i3, zzfluVar, zzfpVar, zzcbVar, scheduledExecutorService, zzfooVar, zzfswVar, clock);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    @Override // com.google.android.gms.internal.ads.zzfub
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.google.common.util.concurrent.ListenableFuture zza(android.content.Context r15) {
        /*
            r14 = this;
            com.google.android.gms.internal.ads.zzflu r0 = r14.zzd
            com.google.android.gms.internal.ads.zzbvc r5 = r0.zzd()
            java.lang.String r0 = "Failed to create an interstitial ad manager."
            r7 = 1
            if (r5 != 0) goto L15
            com.google.android.gms.internal.ads.zzfso r15 = new com.google.android.gms.internal.ads.zzfso
            r15.<init>(r7, r0)
            com.google.common.util.concurrent.ListenableFuture r15 = com.google.android.gms.internal.ads.zzhbw.zzc(r15)
            return r15
        L15:
            com.google.android.gms.ads.internal.ClientApi r1 = r14.zza
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.i5(r15)
            com.google.android.gms.ads.internal.client.zzr r3 = new com.google.android.gms.ads.internal.client.zzr
            r3.<init>()
            java.util.concurrent.atomic.AtomicReference r15 = r14.zze
            java.lang.Object r15 = r15.get()
            com.google.android.gms.ads.internal.client.zzfp r15 = (com.google.android.gms.ads.internal.client.zzfp) r15
            java.lang.String r4 = r15.f69947a
            int r6 = r14.zzc
            com.google.android.gms.ads.internal.client.zzbu r15 = r1.M3(r2, r3, r4, r5, r6)
            com.google.android.gms.internal.ads.zzetk r15 = (com.google.android.gms.internal.ads.zzetk) r15
            if (r15 != 0) goto L3e
            com.google.android.gms.internal.ads.zzfso r15 = new com.google.android.gms.internal.ads.zzfso
            r15.<init>(r7, r0)
            com.google.common.util.concurrent.ListenableFuture r15 = com.google.android.gms.internal.ads.zzhbw.zzc(r15)
            return r15
        L3e:
            com.google.android.gms.internal.ads.zzhcp r0 = com.google.android.gms.internal.ads.zzhcp.zze()
            java.util.concurrent.atomic.AtomicReference r1 = r14.zze     // Catch: android.os.RemoteException -> L84
            java.lang.Object r1 = r1.get()     // Catch: android.os.RemoteException -> L84
            com.google.android.gms.ads.internal.client.zzfp r1 = (com.google.android.gms.ads.internal.client.zzfp) r1     // Catch: android.os.RemoteException -> L84
            com.google.android.gms.ads.internal.client.zzm r1 = r1.f69949c     // Catch: android.os.RemoteException -> L84
            r14.zzB(r1)     // Catch: android.os.RemoteException -> L84
            com.google.android.gms.internal.ads.zzfsn r9 = r14.zzf     // Catch: android.os.RemoteException -> L84
            if (r9 == 0) goto L87
            com.google.android.gms.internal.ads.zzbih r1 = com.google.android.gms.internal.ads.zzbiq.zzT     // Catch: android.os.RemoteException -> L84
            com.google.android.gms.internal.ads.zzbio r2 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: android.os.RemoteException -> L84
            java.lang.Object r1 = r2.zzd(r1)     // Catch: android.os.RemoteException -> L84
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: android.os.RemoteException -> L84
            boolean r1 = r1.booleanValue()     // Catch: android.os.RemoteException -> L84
            if (r1 == 0) goto L87
            com.google.android.gms.internal.ads.zzfsy r8 = new com.google.android.gms.internal.ads.zzfsy     // Catch: android.os.RemoteException -> L84
            java.util.concurrent.ScheduledExecutorService r10 = r14.zzi     // Catch: android.os.RemoteException -> L84
            com.google.android.gms.internal.ads.zzbih r1 = com.google.android.gms.internal.ads.zzbiq.zzU     // Catch: android.os.RemoteException -> L84
            com.google.android.gms.internal.ads.zzbio r2 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: android.os.RemoteException -> L84
            java.lang.Object r1 = r2.zzd(r1)     // Catch: android.os.RemoteException -> L84
            java.lang.Long r1 = (java.lang.Long) r1     // Catch: android.os.RemoteException -> L84
            long r11 = r1.longValue()     // Catch: android.os.RemoteException -> L84
            r13 = r14
            r8.<init>(r9, r10, r11, r13)     // Catch: android.os.RemoteException -> L81
            r15.zzL(r8)     // Catch: android.os.RemoteException -> L81
            goto L88
        L81:
            r0 = move-exception
        L82:
            r15 = r0
            goto Laa
        L84:
            r0 = move-exception
            r13 = r14
            goto L82
        L87:
            r13 = r14
        L88:
            java.util.concurrent.atomic.AtomicReference r1 = r13.zze     // Catch: android.os.RemoteException -> L81
            java.lang.Object r1 = r1.get()     // Catch: android.os.RemoteException -> L81
            com.google.android.gms.ads.internal.client.zzfp r1 = (com.google.android.gms.ads.internal.client.zzfp) r1     // Catch: android.os.RemoteException -> L81
            com.google.android.gms.ads.internal.client.zzm r1 = r1.f69949c     // Catch: android.os.RemoteException -> L81
            com.google.android.gms.internal.ads.zzfsz r2 = new com.google.android.gms.internal.ads.zzfsz     // Catch: android.os.RemoteException -> L81
            com.google.android.gms.internal.ads.zzfto r3 = new com.google.android.gms.internal.ads.zzfto     // Catch: android.os.RemoteException -> L81
            r3.<init>(r14, r0)     // Catch: android.os.RemoteException -> L81
            java.util.concurrent.atomic.AtomicReference r4 = r13.zze     // Catch: android.os.RemoteException -> L81
            java.lang.Object r4 = r4.get()     // Catch: android.os.RemoteException -> L81
            com.google.android.gms.ads.internal.client.zzfp r4 = (com.google.android.gms.ads.internal.client.zzfp) r4     // Catch: android.os.RemoteException -> L81
            java.lang.String r4 = r4.f69947a     // Catch: android.os.RemoteException -> L81
            r2.<init>(r15, r3, r4)     // Catch: android.os.RemoteException -> L81
            r15.zzQ(r1, r2)     // Catch: android.os.RemoteException -> L81
            return r0
        Laa:
            java.lang.String r0 = "Failed to load interstitial ad."
            com.google.android.gms.ads.internal.util.client.zzo.g(r0, r15)
            com.google.android.gms.internal.ads.zzfso r15 = new com.google.android.gms.internal.ads.zzfso
            java.lang.String r0 = "remote exception"
            r15.<init>(r7, r0)
            com.google.common.util.concurrent.ListenableFuture r15 = com.google.android.gms.internal.ads.zzhbw.zzc(r15)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfta.zza(android.content.Context):com.google.common.util.concurrent.ListenableFuture");
    }

    @Override // com.google.android.gms.internal.ads.zzfub
    protected final long zzb() {
        return ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzQ)).longValue();
    }

    @Override // com.google.android.gms.internal.ads.zzfub
    protected final /* bridge */ /* synthetic */ com.google.android.gms.ads.internal.client.zzdx zzc(Object obj) {
        try {
            return ((com.google.android.gms.ads.internal.client.zzbu) obj).zzt();
        } catch (RemoteException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.b("Failed to get response info for  the interstitial ad.", e3);
            return null;
        }
    }

    public zzfta(String str, ClientApi clientApi, Context context, int i3, zzflu zzfluVar, com.google.android.gms.ads.internal.client.zzfp zzfpVar, com.google.android.gms.ads.internal.client.zzce zzceVar, ScheduledExecutorService scheduledExecutorService, zzfoo zzfooVar, zzfsw zzfswVar, Clock clock, zzfsn zzfsnVar) {
        super(str, clientApi, context, i3, zzfluVar, zzfpVar, zzceVar, scheduledExecutorService, zzfooVar, zzfswVar, clock, zzfsnVar);
    }
}
