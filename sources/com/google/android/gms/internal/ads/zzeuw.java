package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.graphics.Insets;
import com.facebook.GraphRequest;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeuw implements zzfci {
    public final com.google.android.gms.ads.internal.client.zzr zza;
    public final String zzb;
    public final boolean zzc;
    public final String zzd;
    public final float zze;
    public final int zzf;
    public final int zzg;
    public final String zzh;
    public final int zzi;
    public final boolean zzj;
    public final Insets zzk;
    public final zzeut zzl;

    public zzeuw(com.google.android.gms.ads.internal.client.zzr zzrVar, String str, boolean z2, String str2, float f3, int i3, int i4, String str3, int i5, boolean z3, Insets insets, zzeut zzeutVar) {
        Preconditions.n(zzrVar, "the adSize must not be null");
        this.zza = zzrVar;
        this.zzb = str;
        this.zzc = z2;
        this.zzd = str2;
        this.zze = f3;
        this.zzf = i3;
        this.zzg = i4;
        this.zzh = str3;
        this.zzi = i5;
        this.zzj = z3;
        this.zzk = insets;
        this.zzl = zzeutVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.client.zzr zzrVar = this.zza;
        Bundle bundle = (Bundle) obj;
        int i3 = zzrVar.f70008f;
        zzfln.zzb(bundle, "smart_w", "full", i3 == -1);
        int i4 = zzrVar.f70005b;
        zzfln.zzb(bundle, "smart_h", "auto", i4 == -2);
        zzfln.zzd(bundle, "ene", true, zzrVar.f70013k);
        zzfln.zzb(bundle, "rafmt", "102", zzrVar.f70016n);
        zzfln.zzb(bundle, "rafmt", "108", zzrVar.f70019q);
        zzfln.zzb(bundle, "rafmt", "103", zzrVar.f70017o);
        zzfln.zzb(bundle, "rafmt", "105", zzrVar.f70018p);
        zzfln.zzd(bundle, "inline_adaptive_slot", true, this.zzj);
        zzfln.zzd(bundle, "interscroller_slot", true, zzrVar.f70018p);
        zzfln.zze(bundle, GraphRequest.FORMAT_PARAM, this.zzb);
        zzfln.zzb(bundle, "fluid", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.zzc);
        zzfln.zzb(bundle, "sz", this.zzd, !TextUtils.isEmpty(r6));
        bundle.putFloat("u_sd", this.zze);
        bundle.putInt("sw", this.zzf);
        bundle.putInt(YznnJpHcAmeoW.hCmjofgRUDSOGu, this.zzg);
        String str = this.zzh;
        zzfln.zzb(bundle, "sc", str, true ^ TextUtils.isEmpty(str));
        int i5 = this.zzi;
        if (i5 != -1) {
            bundle.putInt("u_mso", i5);
        }
        Insets insets = this.zzk;
        if (insets != null) {
            bundle.putInt("sam_t", insets.f33965b);
            bundle.putInt("sam_b", insets.f33967d);
            bundle.putInt("sam_l", insets.f33964a);
            bundle.putInt("sam_r", insets.f33966c);
        }
        zzeut zzeutVar = this.zzl;
        if (zzeutVar != null) {
            bundle.putInt("rc_tl", zzeutVar.zza);
            bundle.putInt("rc_tr", zzeutVar.zzb);
            bundle.putInt("rc_bl", zzeutVar.zzc);
            bundle.putInt("rc_br", zzeutVar.zzd);
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        com.google.android.gms.ads.internal.client.zzr[] zzrVarArr = zzrVar.f70010h;
        if (zzrVarArr == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i4);
            bundle2.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i3);
            bundle2.putBoolean("is_fluid_height", zzrVar.f70012j);
            arrayList.add(bundle2);
        } else {
            for (com.google.android.gms.ads.internal.client.zzr zzrVar2 : zzrVarArr) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("is_fluid_height", zzrVar2.f70012j);
                bundle3.putInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, zzrVar2.f70005b);
                bundle3.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, zzrVar2.f70008f);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
