package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzakp implements zzaol {
    private final zzakn zza;

    private zzakp(zzakn zzaknVar) {
        zzakn zzaknVar2 = (zzakn) zzalh.zza(zzaknVar, "output");
        this.zza = zzaknVar2;
        zzaknVar2.zza = this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final int zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzb(int i3, List<Double> list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzaks)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzb(i3, list.get(i4).doubleValue());
                    i4++;
                }
                return;
            }
            this.zza.zzj(i3, 2);
            int iZza = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZza += zzakn.zza(list.get(i5).doubleValue());
            }
            this.zza.zzm(iZza);
            while (i4 < list.size()) {
                this.zza.zzb(list.get(i4).doubleValue());
                i4++;
            }
            return;
        }
        zzaks zzaksVar = (zzaks) list;
        if (!z2) {
            while (i4 < zzaksVar.size()) {
                this.zza.zzb(i3, zzaksVar.zzb(i4));
                i4++;
            }
            return;
        }
        this.zza.zzj(i3, 2);
        int iZza2 = 0;
        for (int i6 = 0; i6 < zzaksVar.size(); i6++) {
            iZza2 += zzakn.zza(zzaksVar.zzb(i6));
        }
        this.zza.zzm(iZza2);
        while (i4 < zzaksVar.size()) {
            this.zza.zzb(zzaksVar.zzb(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzc(int i3, List<Integer> list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzali)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzh(i3, list.get(i4).intValue());
                    i4++;
                }
                return;
            }
            this.zza.zzj(i3, 2);
            int iZza = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZza += zzakn.zza(list.get(i5).intValue());
            }
            this.zza.zzm(iZza);
            while (i4 < list.size()) {
                this.zza.zzk(list.get(i4).intValue());
                i4++;
            }
            return;
        }
        zzali zzaliVar = (zzali) list;
        if (!z2) {
            while (i4 < zzaliVar.size()) {
                this.zza.zzh(i3, zzaliVar.zzb(i4));
                i4++;
            }
            return;
        }
        this.zza.zzj(i3, 2);
        int iZza2 = 0;
        for (int i6 = 0; i6 < zzaliVar.size(); i6++) {
            iZza2 += zzakn.zza(zzaliVar.zzb(i6));
        }
        this.zza.zzm(iZza2);
        while (i4 < zzaliVar.size()) {
            this.zza.zzk(zzaliVar.zzb(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzd(int i3, List<Integer> list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzali)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzg(i3, list.get(i4).intValue());
                    i4++;
                }
                return;
            }
            this.zza.zzj(i3, 2);
            int iZzb = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzb += zzakn.zzb(list.get(i5).intValue());
            }
            this.zza.zzm(iZzb);
            while (i4 < list.size()) {
                this.zza.zzj(list.get(i4).intValue());
                i4++;
            }
            return;
        }
        zzali zzaliVar = (zzali) list;
        if (!z2) {
            while (i4 < zzaliVar.size()) {
                this.zza.zzg(i3, zzaliVar.zzb(i4));
                i4++;
            }
            return;
        }
        this.zza.zzj(i3, 2);
        int iZzb2 = 0;
        for (int i6 = 0; i6 < zzaliVar.size(); i6++) {
            iZzb2 += zzakn.zzb(zzaliVar.zzb(i6));
        }
        this.zza.zzm(iZzb2);
        while (i4 < zzaliVar.size()) {
            this.zza.zzj(zzaliVar.zzb(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zze(int i3, List<Long> list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzalx)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzf(i3, list.get(i4).longValue());
                    i4++;
                }
                return;
            }
            this.zza.zzj(i3, 2);
            int iZza = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZza += zzakn.zza(list.get(i5).longValue());
            }
            this.zza.zzm(iZza);
            while (i4 < list.size()) {
                this.zza.zzf(list.get(i4).longValue());
                i4++;
            }
            return;
        }
        zzalx zzalxVar = (zzalx) list;
        if (!z2) {
            while (i4 < zzalxVar.size()) {
                this.zza.zzf(i3, zzalxVar.zzb(i4));
                i4++;
            }
            return;
        }
        this.zza.zzj(i3, 2);
        int iZza2 = 0;
        for (int i6 = 0; i6 < zzalxVar.size(); i6++) {
            iZza2 += zzakn.zza(zzalxVar.zzb(i6));
        }
        this.zza.zzm(iZza2);
        while (i4 < zzalxVar.size()) {
            this.zza.zzf(zzalxVar.zzb(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzf(int i3, List<Float> list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzald)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzb(i3, list.get(i4).floatValue());
                    i4++;
                }
                return;
            }
            this.zza.zzj(i3, 2);
            int iZza = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZza += zzakn.zza(list.get(i5).floatValue());
            }
            this.zza.zzm(iZza);
            while (i4 < list.size()) {
                this.zza.zzb(list.get(i4).floatValue());
                i4++;
            }
            return;
        }
        zzald zzaldVar = (zzald) list;
        if (!z2) {
            while (i4 < zzaldVar.size()) {
                this.zza.zzb(i3, zzaldVar.zzb(i4));
                i4++;
            }
            return;
        }
        this.zza.zzj(i3, 2);
        int iZza2 = 0;
        for (int i6 = 0; i6 < zzaldVar.size(); i6++) {
            iZza2 += zzakn.zza(zzaldVar.zzb(i6));
        }
        this.zza.zzm(iZza2);
        while (i4 < zzaldVar.size()) {
            this.zza.zzb(zzaldVar.zzb(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzg(int i3, List<Integer> list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzali)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzh(i3, list.get(i4).intValue());
                    i4++;
                }
                return;
            }
            this.zza.zzj(i3, 2);
            int iZzc = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzc += zzakn.zzc(list.get(i5).intValue());
            }
            this.zza.zzm(iZzc);
            while (i4 < list.size()) {
                this.zza.zzk(list.get(i4).intValue());
                i4++;
            }
            return;
        }
        zzali zzaliVar = (zzali) list;
        if (!z2) {
            while (i4 < zzaliVar.size()) {
                this.zza.zzh(i3, zzaliVar.zzb(i4));
                i4++;
            }
            return;
        }
        this.zza.zzj(i3, 2);
        int iZzc2 = 0;
        for (int i6 = 0; i6 < zzaliVar.size(); i6++) {
            iZzc2 += zzakn.zzc(zzaliVar.zzb(i6));
        }
        this.zza.zzm(iZzc2);
        while (i4 < zzaliVar.size()) {
            this.zza.zzk(zzaliVar.zzb(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzh(int i3, List<Long> list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzalx)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzh(i3, list.get(i4).longValue());
                    i4++;
                }
                return;
            }
            this.zza.zzj(i3, 2);
            int iZzb = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzb += zzakn.zzb(list.get(i5).longValue());
            }
            this.zza.zzm(iZzb);
            while (i4 < list.size()) {
                this.zza.zzh(list.get(i4).longValue());
                i4++;
            }
            return;
        }
        zzalx zzalxVar = (zzalx) list;
        if (!z2) {
            while (i4 < zzalxVar.size()) {
                this.zza.zzh(i3, zzalxVar.zzb(i4));
                i4++;
            }
            return;
        }
        this.zza.zzj(i3, 2);
        int iZzb2 = 0;
        for (int i6 = 0; i6 < zzalxVar.size(); i6++) {
            iZzb2 += zzakn.zzb(zzalxVar.zzb(i6));
        }
        this.zza.zzm(iZzb2);
        while (i4 < zzalxVar.size()) {
            this.zza.zzh(zzalxVar.zzb(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzi(int i3, List<Integer> list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzali)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzg(i3, list.get(i4).intValue());
                    i4++;
                }
                return;
            }
            this.zza.zzj(i3, 2);
            int iZzf = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzf += zzakn.zzf(list.get(i5).intValue());
            }
            this.zza.zzm(iZzf);
            while (i4 < list.size()) {
                this.zza.zzj(list.get(i4).intValue());
                i4++;
            }
            return;
        }
        zzali zzaliVar = (zzali) list;
        if (!z2) {
            while (i4 < zzaliVar.size()) {
                this.zza.zzg(i3, zzaliVar.zzb(i4));
                i4++;
            }
            return;
        }
        this.zza.zzj(i3, 2);
        int iZzf2 = 0;
        for (int i6 = 0; i6 < zzaliVar.size(); i6++) {
            iZzf2 += zzakn.zzf(zzaliVar.zzb(i6));
        }
        this.zza.zzm(iZzf2);
        while (i4 < zzaliVar.size()) {
            this.zza.zzj(zzaliVar.zzb(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzj(int i3, List<Long> list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzalx)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzf(i3, list.get(i4).longValue());
                    i4++;
                }
                return;
            }
            this.zza.zzj(i3, 2);
            int iZzc = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzc += zzakn.zzc(list.get(i5).longValue());
            }
            this.zza.zzm(iZzc);
            while (i4 < list.size()) {
                this.zza.zzf(list.get(i4).longValue());
                i4++;
            }
            return;
        }
        zzalx zzalxVar = (zzalx) list;
        if (!z2) {
            while (i4 < zzalxVar.size()) {
                this.zza.zzf(i3, zzalxVar.zzb(i4));
                i4++;
            }
            return;
        }
        this.zza.zzj(i3, 2);
        int iZzc2 = 0;
        for (int i6 = 0; i6 < zzalxVar.size(); i6++) {
            iZzc2 += zzakn.zzc(zzalxVar.zzb(i6));
        }
        this.zza.zzm(iZzc2);
        while (i4 < zzalxVar.size()) {
            this.zza.zzf(zzalxVar.zzb(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzk(int i3, List<Integer> list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzali)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzi(i3, list.get(i4).intValue());
                    i4++;
                }
                return;
            }
            this.zza.zzj(i3, 2);
            int iZzg = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzg += zzakn.zzg(list.get(i5).intValue());
            }
            this.zza.zzm(iZzg);
            while (i4 < list.size()) {
                this.zza.zzl(list.get(i4).intValue());
                i4++;
            }
            return;
        }
        zzali zzaliVar = (zzali) list;
        if (!z2) {
            while (i4 < zzaliVar.size()) {
                this.zza.zzi(i3, zzaliVar.zzb(i4));
                i4++;
            }
            return;
        }
        this.zza.zzj(i3, 2);
        int iZzg2 = 0;
        for (int i6 = 0; i6 < zzaliVar.size(); i6++) {
            iZzg2 += zzakn.zzg(zzaliVar.zzb(i6));
        }
        this.zza.zzm(iZzg2);
        while (i4 < zzaliVar.size()) {
            this.zza.zzl(zzaliVar.zzb(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzl(int i3, List<Long> list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzalx)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzg(i3, list.get(i4).longValue());
                    i4++;
                }
                return;
            }
            this.zza.zzj(i3, 2);
            int iZzd = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzd += zzakn.zzd(list.get(i5).longValue());
            }
            this.zza.zzm(iZzd);
            while (i4 < list.size()) {
                this.zza.zzg(list.get(i4).longValue());
                i4++;
            }
            return;
        }
        zzalx zzalxVar = (zzalx) list;
        if (!z2) {
            while (i4 < zzalxVar.size()) {
                this.zza.zzg(i3, zzalxVar.zzb(i4));
                i4++;
            }
            return;
        }
        this.zza.zzj(i3, 2);
        int iZzd2 = 0;
        for (int i6 = 0; i6 < zzalxVar.size(); i6++) {
            iZzd2 += zzakn.zzd(zzalxVar.zzb(i6));
        }
        this.zza.zzm(iZzd2);
        while (i4 < zzalxVar.size()) {
            this.zza.zzg(zzalxVar.zzb(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzm(int i3, List<Integer> list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzali)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzk(i3, list.get(i4).intValue());
                    i4++;
                }
                return;
            }
            this.zza.zzj(i3, 2);
            int iZzi = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZzi += zzakn.zzi(list.get(i5).intValue());
            }
            this.zza.zzm(iZzi);
            while (i4 < list.size()) {
                this.zza.zzm(list.get(i4).intValue());
                i4++;
            }
            return;
        }
        zzali zzaliVar = (zzali) list;
        if (!z2) {
            while (i4 < zzaliVar.size()) {
                this.zza.zzk(i3, zzaliVar.zzb(i4));
                i4++;
            }
            return;
        }
        this.zza.zzj(i3, 2);
        int iZzi2 = 0;
        for (int i6 = 0; i6 < zzaliVar.size(); i6++) {
            iZzi2 += zzakn.zzi(zzaliVar.zzb(i6));
        }
        this.zza.zzm(iZzi2);
        while (i4 < zzaliVar.size()) {
            this.zza.zzm(zzaliVar.zzb(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzn(int i3, List<Long> list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzalx)) {
            if (!z2) {
                while (i4 < list.size()) {
                    this.zza.zzh(i3, list.get(i4).longValue());
                    i4++;
                }
                return;
            }
            this.zza.zzj(i3, 2);
            int iZze = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                iZze += zzakn.zze(list.get(i5).longValue());
            }
            this.zza.zzm(iZze);
            while (i4 < list.size()) {
                this.zza.zzh(list.get(i4).longValue());
                i4++;
            }
            return;
        }
        zzalx zzalxVar = (zzalx) list;
        if (!z2) {
            while (i4 < zzalxVar.size()) {
                this.zza.zzh(i3, zzalxVar.zzb(i4));
                i4++;
            }
            return;
        }
        this.zza.zzj(i3, 2);
        int iZze2 = 0;
        for (int i6 = 0; i6 < zzalxVar.size(); i6++) {
            iZze2 += zzakn.zze(zzalxVar.zzb(i6));
        }
        this.zza.zzm(iZze2);
        while (i4 < zzalxVar.size()) {
            this.zza.zzh(zzalxVar.zzb(i4));
            i4++;
        }
    }

    public static zzakp zza(zzakn zzaknVar) {
        zzakp zzakpVar = zzaknVar.zza;
        return zzakpVar != null ? zzakpVar : new zzakp(zzaknVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zza(int i3, boolean z2) throws IOException {
        this.zza.zzb(i3, z2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zza(int i3, List<Boolean> list, boolean z2) throws IOException {
        int i4 = 0;
        if (!(list instanceof zzajt)) {
            if (z2) {
                this.zza.zzj(i3, 2);
                int iZza = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    iZza += zzakn.zza(list.get(i5).booleanValue());
                }
                this.zza.zzm(iZza);
                while (i4 < list.size()) {
                    this.zza.zzb(list.get(i4).booleanValue());
                    i4++;
                }
                return;
            }
            while (i4 < list.size()) {
                this.zza.zzb(i3, list.get(i4).booleanValue());
                i4++;
            }
            return;
        }
        zzajt zzajtVar = (zzajt) list;
        if (z2) {
            this.zza.zzj(i3, 2);
            int iZza2 = 0;
            for (int i6 = 0; i6 < zzajtVar.size(); i6++) {
                iZza2 += zzakn.zza(zzajtVar.zzb(i6));
            }
            this.zza.zzm(iZza2);
            while (i4 < zzajtVar.size()) {
                this.zza.zzb(zzajtVar.zzb(i4));
                i4++;
            }
            return;
        }
        while (i4 < zzajtVar.size()) {
            this.zza.zzb(i3, zzajtVar.zzb(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzb(int i3, int i4) throws IOException {
        this.zza.zzg(i3, i4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzd(int i3, int i4) throws IOException {
        this.zza.zzg(i3, i4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zze(int i3, int i4) throws IOException {
        this.zza.zzi(i3, i4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzf(int i3, int i4) throws IOException {
        this.zza.zzk(i3, i4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzb(int i3, long j3) throws IOException {
        this.zza.zzh(i3, j3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zze(int i3, long j3) throws IOException {
        this.zza.zzh(i3, j3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzd(int i3, long j3) throws IOException {
        this.zza.zzg(i3, j3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzb(int i3, Object obj, zzanb zzanbVar) throws IOException {
        zzajm zzajmVar = (zzajm) obj;
        this.zza.zzj(i3, 2);
        this.zza.zzm(zzajmVar.zza(zzanbVar));
        zzanbVar.zza(zzajmVar, this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zza(int i3, zzajv zzajvVar) throws IOException {
        this.zza.zzc(i3, zzajvVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzc(int i3, int i4) throws IOException {
        this.zza.zzh(i3, i4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zza(int i3, List<zzajv> list) throws IOException {
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.zza.zzc(i3, list.get(i4));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzc(int i3, long j3) throws IOException {
        this.zza.zzf(i3, j3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zza(int i3, double d3) throws IOException {
        this.zza.zzb(i3, d3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzb(int i3, List<?> list, zzanb zzanbVar) throws IOException {
        for (int i4 = 0; i4 < list.size(); i4++) {
            zzb(i3, list.get(i4), zzanbVar);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    @Deprecated
    public final void zza(int i3) throws IOException {
        this.zza.zzj(i3, 4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zza(int i3, int i4) throws IOException {
        this.zza.zzh(i3, i4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    @Deprecated
    public final void zzb(int i3) throws IOException {
        this.zza.zzj(i3, 3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zzb(int i3, List<String> list) throws IOException {
        int i4 = 0;
        if (list instanceof zzalt) {
            zzalt zzaltVar = (zzalt) list;
            while (i4 < list.size()) {
                Object objZza = zzaltVar.zza(i4);
                if (objZza instanceof String) {
                    this.zza.zzb(i3, (String) objZza);
                } else {
                    this.zza.zzc(i3, (zzajv) objZza);
                }
                i4++;
            }
            return;
        }
        while (i4 < list.size()) {
            this.zza.zzb(i3, list.get(i4));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zza(int i3, long j3) throws IOException {
        this.zza.zzf(i3, j3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zza(int i3, float f3) throws IOException {
        this.zza.zzb(i3, f3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zza(int i3, Object obj, zzanb zzanbVar) throws IOException {
        this.zza.zzj(i3, 3);
        zzanbVar.zza((zzajm) obj, this);
        this.zza.zzj(i3, 4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zza(int i3, List<?> list, zzanb zzanbVar) throws IOException {
        for (int i4 = 0; i4 < list.size(); i4++) {
            zza(i3, list.get(i4), zzanbVar);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final <K, V> void zza(int i3, zzamd<K, V> zzamdVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zza.zzj(i3, 2);
            this.zza.zzm(zzame.zza(zzamdVar, entry.getKey(), entry.getValue()));
            zzame.zza(this.zza, zzamdVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zza(int i3, Object obj) throws IOException {
        if (obj instanceof zzajv) {
            this.zza.zzd(i3, (zzajv) obj);
        } else {
            this.zza.zzb(i3, (zzamm) obj);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaol
    public final void zza(int i3, String str) throws IOException {
        this.zza.zzb(i3, str);
    }
}
