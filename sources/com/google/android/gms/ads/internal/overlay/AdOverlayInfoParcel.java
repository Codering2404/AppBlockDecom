package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbog;
import com.google.android.gms.internal.ads.zzboi;
import com.google.android.gms.internal.ads.zzbyu;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzcku;
import com.google.android.gms.internal.ads.zzdde;
import com.google.android.gms.internal.ads.zzdky;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzc f70041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zza f70042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zzr f70043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzcku f70044d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zzboi f70045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f70046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f70047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f70048i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final zzad f70049j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f70050k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f70051l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f70052m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final VersionInfoParcel f70053n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f70054o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.zzl f70055p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final zzbog f70056q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f70057r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f70058s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f70059t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final zzdde f70060u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final zzdky f70061v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final zzbyu f70062w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f70063x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f70064y;
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzo();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final AtomicLong f70040z = new AtomicLong(0);
    private static final ConcurrentHashMap A = new ConcurrentHashMap();

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzr zzrVar, zzbog zzbogVar, zzboi zzboiVar, zzad zzadVar, zzcku zzckuVar, boolean z2, int i3, String str, VersionInfoParcel versionInfoParcel, zzdky zzdkyVar, zzbyu zzbyuVar, boolean z3) {
        this.f70041a = null;
        this.f70042b = zzaVar;
        this.f70043c = zzrVar;
        this.f70044d = zzckuVar;
        this.f70056q = zzbogVar;
        this.f70045f = zzboiVar;
        this.f70046g = null;
        this.f70047h = z2;
        this.f70048i = null;
        this.f70049j = zzadVar;
        this.f70050k = i3;
        this.f70051l = 3;
        this.f70052m = str;
        this.f70053n = versionInfoParcel;
        this.f70054o = null;
        this.f70055p = null;
        this.f70057r = null;
        this.f70058s = null;
        this.f70059t = null;
        this.f70060u = null;
        this.f70061v = zzdkyVar;
        this.f70062w = zzbyuVar;
        this.f70063x = z3;
        this.f70064y = f70040z.getAndIncrement();
    }

    public static AdOverlayInfoParcel M(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e3) {
            if (!((Boolean) zzba.c().zzd(zzbiq.zzou)).booleanValue()) {
                return null;
            }
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "AdOverlayInfoParcel.getFromIntent");
            return null;
        }
    }

    private static final IBinder O(Object obj) {
        if (((Boolean) zzba.c().zzd(zzbiq.zzou)).booleanValue()) {
            return null;
        }
        return ObjectWrapper.i5(obj).asBinder();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 2, this.f70041a, i3, false);
        com.google.android.gms.ads.internal.client.zza zzaVar = this.f70042b;
        SafeParcelWriter.t(parcel, 3, O(zzaVar), false);
        zzr zzrVar = this.f70043c;
        SafeParcelWriter.t(parcel, 4, O(zzrVar), false);
        zzcku zzckuVar = this.f70044d;
        SafeParcelWriter.t(parcel, 5, O(zzckuVar), false);
        zzboi zzboiVar = this.f70045f;
        SafeParcelWriter.t(parcel, 6, O(zzboiVar), false);
        SafeParcelWriter.G(parcel, 7, this.f70046g, false);
        SafeParcelWriter.g(parcel, 8, this.f70047h);
        SafeParcelWriter.G(parcel, 9, this.f70048i, false);
        zzad zzadVar = this.f70049j;
        SafeParcelWriter.t(parcel, 10, O(zzadVar), false);
        SafeParcelWriter.u(parcel, 11, this.f70050k);
        SafeParcelWriter.u(parcel, 12, this.f70051l);
        SafeParcelWriter.G(parcel, 13, this.f70052m, false);
        SafeParcelWriter.E(parcel, 14, this.f70053n, i3, false);
        SafeParcelWriter.G(parcel, 16, this.f70054o, false);
        SafeParcelWriter.E(parcel, 17, this.f70055p, i3, false);
        zzbog zzbogVar = this.f70056q;
        SafeParcelWriter.t(parcel, 18, O(zzbogVar), false);
        SafeParcelWriter.G(parcel, 19, this.f70057r, false);
        SafeParcelWriter.G(parcel, 24, this.f70058s, false);
        SafeParcelWriter.G(parcel, 25, this.f70059t, false);
        zzdde zzddeVar = this.f70060u;
        SafeParcelWriter.t(parcel, 26, O(zzddeVar), false);
        zzdky zzdkyVar = this.f70061v;
        SafeParcelWriter.t(parcel, 27, O(zzdkyVar), false);
        zzbyu zzbyuVar = this.f70062w;
        SafeParcelWriter.t(parcel, 28, O(zzbyuVar), false);
        SafeParcelWriter.g(parcel, 29, this.f70063x);
        long j3 = this.f70064y;
        SafeParcelWriter.z(parcel, 30, j3);
        SafeParcelWriter.b(parcel, iA);
        if (((Boolean) zzba.c().zzd(zzbiq.zzou)).booleanValue()) {
            A.put(Long.valueOf(j3), new zzp(zzaVar, zzrVar, zzckuVar, zzbogVar, zzboiVar, zzadVar, zzddeVar, zzdkyVar, zzbyuVar, zzcfr.zzd.schedule(new zzq(j3), ((Integer) zzba.c().zzd(zzbiq.zzow)).intValue(), TimeUnit.SECONDS)));
        }
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzr zzrVar, zzbog zzbogVar, zzboi zzboiVar, zzad zzadVar, zzcku zzckuVar, boolean z2, int i3, String str, String str2, VersionInfoParcel versionInfoParcel, zzdky zzdkyVar, zzbyu zzbyuVar) {
        this.f70041a = null;
        this.f70042b = zzaVar;
        this.f70043c = zzrVar;
        this.f70044d = zzckuVar;
        this.f70056q = zzbogVar;
        this.f70045f = zzboiVar;
        this.f70046g = str2;
        this.f70047h = z2;
        this.f70048i = str;
        this.f70049j = zzadVar;
        this.f70050k = i3;
        this.f70051l = 3;
        this.f70052m = null;
        this.f70053n = versionInfoParcel;
        this.f70054o = null;
        this.f70055p = null;
        this.f70057r = null;
        this.f70058s = null;
        this.f70059t = null;
        this.f70060u = null;
        this.f70061v = zzdkyVar;
        this.f70062w = zzbyuVar;
        this.f70063x = false;
        this.f70064y = f70040z.getAndIncrement();
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzr zzrVar, zzad zzadVar, zzcku zzckuVar, int i3, VersionInfoParcel versionInfoParcel, String str, com.google.android.gms.ads.internal.zzl zzlVar, String str2, String str3, String str4, zzdde zzddeVar, zzbyu zzbyuVar, String str5) {
        this.f70041a = null;
        this.f70042b = null;
        this.f70043c = zzrVar;
        this.f70044d = zzckuVar;
        this.f70056q = null;
        this.f70045f = null;
        this.f70047h = false;
        if (((Boolean) zzba.c().zzd(zzbiq.zzbu)).booleanValue()) {
            this.f70046g = null;
            this.f70048i = null;
        } else {
            this.f70046g = str2;
            this.f70048i = str3;
        }
        this.f70049j = null;
        this.f70050k = i3;
        this.f70051l = 1;
        this.f70052m = null;
        this.f70053n = versionInfoParcel;
        this.f70054o = str;
        this.f70055p = zzlVar;
        this.f70057r = str5;
        this.f70058s = null;
        this.f70059t = str4;
        this.f70060u = zzddeVar;
        this.f70061v = null;
        this.f70062w = zzbyuVar;
        this.f70063x = false;
        this.f70064y = f70040z.getAndIncrement();
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzr zzrVar, zzad zzadVar, zzcku zzckuVar, boolean z2, int i3, VersionInfoParcel versionInfoParcel, zzdky zzdkyVar, zzbyu zzbyuVar) {
        this.f70041a = null;
        this.f70042b = zzaVar;
        this.f70043c = zzrVar;
        this.f70044d = zzckuVar;
        this.f70056q = null;
        this.f70045f = null;
        this.f70046g = null;
        this.f70047h = z2;
        this.f70048i = null;
        this.f70049j = zzadVar;
        this.f70050k = i3;
        this.f70051l = 2;
        this.f70052m = null;
        this.f70053n = versionInfoParcel;
        this.f70054o = null;
        this.f70055p = null;
        this.f70057r = null;
        this.f70058s = null;
        this.f70059t = null;
        this.f70060u = null;
        this.f70061v = zzdkyVar;
        this.f70062w = zzbyuVar;
        this.f70063x = false;
        this.f70064y = f70040z.getAndIncrement();
    }

    AdOverlayInfoParcel(zzc zzcVar, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z2, String str2, IBinder iBinder5, int i3, int i4, String str3, VersionInfoParcel versionInfoParcel, String str4, com.google.android.gms.ads.internal.zzl zzlVar, IBinder iBinder6, String str5, String str6, String str7, IBinder iBinder7, IBinder iBinder8, IBinder iBinder9, boolean z3, long j3) {
        this.f70041a = zzcVar;
        this.f70046g = str;
        this.f70047h = z2;
        this.f70048i = str2;
        this.f70050k = i3;
        this.f70051l = i4;
        this.f70052m = str3;
        this.f70053n = versionInfoParcel;
        this.f70054o = str4;
        this.f70055p = zzlVar;
        this.f70057r = str5;
        this.f70058s = str6;
        this.f70059t = str7;
        this.f70063x = z3;
        this.f70064y = j3;
        if (((Boolean) zzba.c().zzd(zzbiq.zzou)).booleanValue()) {
            zzp zzpVar = (zzp) A.remove(Long.valueOf(j3));
            if (zzpVar != null) {
                this.f70042b = zzpVar.a();
                this.f70043c = zzpVar.b();
                this.f70044d = zzpVar.c();
                this.f70056q = zzpVar.d();
                this.f70045f = zzpVar.e();
                this.f70060u = zzpVar.g();
                this.f70061v = zzpVar.h();
                this.f70062w = zzpVar.i();
                this.f70049j = zzpVar.f();
                zzpVar.j().cancel(false);
                return;
            }
            throw new NullPointerException("AdOverlayObjects is null");
        }
        this.f70042b = (com.google.android.gms.ads.internal.client.zza) ObjectWrapper.h5(IObjectWrapper.Stub.x3(iBinder));
        this.f70043c = (zzr) ObjectWrapper.h5(IObjectWrapper.Stub.x3(iBinder2));
        this.f70044d = (zzcku) ObjectWrapper.h5(IObjectWrapper.Stub.x3(iBinder3));
        this.f70056q = (zzbog) ObjectWrapper.h5(IObjectWrapper.Stub.x3(iBinder6));
        this.f70045f = (zzboi) ObjectWrapper.h5(IObjectWrapper.Stub.x3(iBinder4));
        this.f70049j = (zzad) ObjectWrapper.h5(IObjectWrapper.Stub.x3(iBinder5));
        this.f70060u = (zzdde) ObjectWrapper.h5(IObjectWrapper.Stub.x3(iBinder7));
        this.f70061v = (zzdky) ObjectWrapper.h5(IObjectWrapper.Stub.x3(iBinder8));
        this.f70062w = (zzbyu) ObjectWrapper.h5(IObjectWrapper.Stub.x3(iBinder9));
    }

    public AdOverlayInfoParcel(zzc zzcVar, com.google.android.gms.ads.internal.client.zza zzaVar, zzr zzrVar, zzad zzadVar, VersionInfoParcel versionInfoParcel, zzcku zzckuVar, zzdky zzdkyVar, String str) {
        this.f70041a = zzcVar;
        this.f70042b = zzaVar;
        this.f70043c = zzrVar;
        this.f70044d = zzckuVar;
        this.f70056q = null;
        this.f70045f = null;
        this.f70046g = null;
        this.f70047h = false;
        this.f70048i = null;
        this.f70049j = zzadVar;
        this.f70050k = -1;
        this.f70051l = 4;
        this.f70052m = null;
        this.f70053n = versionInfoParcel;
        this.f70054o = null;
        this.f70055p = null;
        this.f70057r = str;
        this.f70058s = null;
        this.f70059t = null;
        this.f70060u = null;
        this.f70061v = zzdkyVar;
        this.f70062w = null;
        this.f70063x = false;
        this.f70064y = f70040z.getAndIncrement();
    }

    public AdOverlayInfoParcel(zzr zzrVar, zzcku zzckuVar, int i3, VersionInfoParcel versionInfoParcel) {
        this.f70043c = zzrVar;
        this.f70044d = zzckuVar;
        this.f70050k = 1;
        this.f70053n = versionInfoParcel;
        this.f70041a = null;
        this.f70042b = null;
        this.f70056q = null;
        this.f70045f = null;
        this.f70046g = null;
        this.f70047h = false;
        this.f70048i = null;
        this.f70049j = null;
        this.f70051l = 1;
        this.f70052m = null;
        this.f70054o = null;
        this.f70055p = null;
        this.f70057r = null;
        this.f70058s = null;
        this.f70059t = null;
        this.f70060u = null;
        this.f70061v = null;
        this.f70062w = null;
        this.f70063x = false;
        this.f70064y = f70040z.getAndIncrement();
    }

    public AdOverlayInfoParcel(zzcku zzckuVar, VersionInfoParcel versionInfoParcel, String str, String str2, int i3, zzbyu zzbyuVar) {
        this.f70041a = null;
        this.f70042b = null;
        this.f70043c = null;
        this.f70044d = zzckuVar;
        this.f70056q = null;
        this.f70045f = null;
        this.f70046g = null;
        this.f70047h = false;
        this.f70048i = null;
        this.f70049j = null;
        this.f70050k = 14;
        this.f70051l = 5;
        this.f70052m = null;
        this.f70053n = versionInfoParcel;
        this.f70054o = null;
        this.f70055p = null;
        this.f70057r = str;
        this.f70058s = str2;
        this.f70059t = null;
        this.f70060u = null;
        this.f70061v = null;
        this.f70062w = zzbyuVar;
        this.f70063x = false;
        this.f70064y = f70040z.getAndIncrement();
    }
}
