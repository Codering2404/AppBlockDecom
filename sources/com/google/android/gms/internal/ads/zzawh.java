package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzawh {
    public final zzavc zza;
    public final zzawd zzb;
    public final zzawa zzc;
    public final zzavv zzd;

    public zzawh(zzavc zzavcVar, zzawd zzawdVar, zzavv zzavvVar) {
        int[] iArr = {343945053, 300943123, 276960570, 1098387973, 1376531620, 1545514151, 271059426, 857490000, 454333378};
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        int i7 = iArr[4];
        int i8 = iArr[5];
        int i9 = iArr[6];
        int i10 = iArr[7];
        this.zza = zzavcVar;
        this.zzb = zzawdVar;
        this.zzd = zzavvVar;
        this.zzc = new zzawa((i9 + ((((i4 & (~i3)) | i5) + ((i3 & i6) | i7)) - i8)) ^ (i10 % 454333378));
    }

    public final Optional zza() {
        zzauw zzauwVar;
        try {
            ArrayDeque arrayDeque = this.zzc.zza;
            if (arrayDeque.isEmpty()) {
                throw new zzavz();
            }
            zzavx zzavxVar = (zzavx) arrayDeque.pop();
            long j3 = zzavxVar.zza;
            long j4 = zzavxVar.zzb;
            long j5 = zzavxVar.zzc;
            zzawd zzawdVar = this.zzb;
            if (zzawdVar.zzb < j4) {
                return Optional.of(zzauw.zzG);
            }
            this.zzd.zza(j3);
            if (j5 == 0) {
                while (zzawdVar.zzb > j4) {
                    zzawdVar.zzc();
                }
            }
            return Optional.empty();
        } catch (zzavt e3) {
            e = e3;
            throw new AssertionError(zzavo.zza("CEiv6BFfPnitUE+D"), e);
        } catch (zzavu e4) {
            e = e4;
            throw new AssertionError(zzavo.zza("CEiv6BFfPnitUE+D"), e);
        } catch (zzavz unused) {
            zzauwVar = zzauw.zzw;
            return Optional.of(zzauwVar);
        } catch (zzawb unused2) {
            zzauwVar = zzauw.zzG;
            return Optional.of(zzauwVar);
        }
    }
}
