package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgpa implements zzgox {
    private final zzgqh zza;
    private final long zzb;

    zzgpa(zzgcn zzgcnVar, zzgqh zzgqhVar, long j3) {
        this.zza = zzgqhVar;
        this.zzb = j3;
    }

    private static boolean zzc(zzgfq zzgfqVar) {
        int iZza = zzgfqVar.zzb().zza().zza();
        int iZzb = zzgfqVar.zzb().zza().zzb();
        byte[] versionArray = zzava.zza();
        Intrinsics.checkNotNullParameter(versionArray, "versionArray");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(6);
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putShort((short) iZza);
        byteBufferAllocate.putInt(iZzb);
        byte[] bArrArray = byteBufferAllocate.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return Arrays.equals(bArrArray, versionArray);
    }

    @Override // com.google.android.gms.internal.ads.zzgox
    public final boolean zza(zzgfq zzgfqVar) {
        if (zzgfqVar == null || zzgfqVar.equals(zzgfq.zzh())) {
            this.zza.zzb(20202);
            return true;
        }
        if (!zzc(zzgfqVar)) {
            this.zza.zzb(20205);
            return true;
        }
        boolean z2 = zzgfqVar.zzb().zzc() - System.currentTimeMillis() <= this.zzb;
        if (z2) {
            this.zza.zzb(20203);
        }
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzgox
    public final boolean zzb(zzgfq zzgfqVar) {
        if (zzgfqVar == null || zzgfqVar.equals(zzgfq.zzh())) {
            this.zza.zzb(20204);
            return false;
        }
        if (zzc(zzgfqVar)) {
            return true;
        }
        this.zza.zzb(20206);
        return false;
    }
}
