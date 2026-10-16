package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.util.Base64;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import com.revenuecat.purchases.common.Constants;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdsi {
    private final com.google.android.gms.ads.internal.util.zzbl zza;
    private final Clock zzb;
    private final Executor zzc;

    public zzdsi(com.google.android.gms.ads.internal.util.zzbl zzblVar, Clock clock, Executor executor) {
        this.zza = zzblVar;
        this.zzb = clock;
        this.zzc = executor;
    }

    private final Bitmap zzd(byte[] bArr, double d3, boolean z2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (d3 * 160.0d);
        if (!z2) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhd)).booleanValue()) {
            options.inJustDecodeBounds = true;
            zze(bArr, options);
            options.inJustDecodeBounds = false;
            int i3 = options.outWidth * options.outHeight;
            if (i3 > 0) {
                options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros((i3 - 1) / ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhe)).intValue())) / 2);
            }
        }
        return zze(bArr, options);
    }

    private final Bitmap zze(byte[] bArr, BitmapFactory.Options options) {
        Clock clock = this.zzb;
        long jA = clock.a();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        long jA2 = clock.a();
        if (bitmapDecodeByteArray != null) {
            long j3 = jA2 - jA;
            int width = bitmapDecodeByteArray.getWidth();
            int height = bitmapDecodeByteArray.getHeight();
            int allocationByteCount = bitmapDecodeByteArray.getAllocationByteCount();
            boolean z2 = Looper.getMainLooper().getThread() == Thread.currentThread();
            StringBuilder sb = new StringBuilder(String.valueOf(width).length() + 20 + String.valueOf(height).length() + 8 + String.valueOf(allocationByteCount).length() + 7 + String.valueOf(j3).length() + 15 + String.valueOf(z2).length());
            sb.append("Decoded image w: ");
            sb.append(width);
            sb.append(" h:");
            sb.append(height);
            sb.append(" bytes: ");
            sb.append(allocationByteCount);
            sb.append(" time: ");
            sb.append(j3);
            sb.append(" on ui thread: ");
            sb.append(z2);
            com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        }
        return bitmapDecodeByteArray;
    }

    public final ListenableFuture zza(final String str, final double d3, final boolean z2) {
        return (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhf)).booleanValue() && str != null && str.startsWith("data:")) ? zzhbw.zzd(new Callable() { // from class: com.google.android.gms.internal.ads.zzdsg
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc(str, d3, z2);
            }
        }, this.zzc) : zzhbw.zzk(this.zza.a(str), new zzgta() { // from class: com.google.android.gms.internal.ads.zzdsh
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzb(d3, z2, (zzata) obj);
            }
        }, this.zzc);
    }

    final /* synthetic */ Bitmap zzb(double d3, boolean z2, zzata zzataVar) {
        return zzd(zzataVar.zzb, d3, z2);
    }

    final /* synthetic */ Bitmap zzc(String str, double d3, boolean z2) {
        int iIndexOf = str.indexOf(",");
        if (iIndexOf == -1) {
            throw new IllegalArgumentException("Bad data URL: no ',' found for base64 data");
        }
        if (!str.substring(0, iIndexOf).endsWith(";base64")) {
            throw new IllegalArgumentException("Bad data URL: only base64 is supported");
        }
        int iIndexOf2 = str.indexOf(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        int iIndexOf3 = str.indexOf(";");
        if (iIndexOf2 == -1 || !str.substring(iIndexOf2 + 1, iIndexOf3).startsWith("image/")) {
            throw new IllegalArgumentException("Bad data URL: only image media is supported");
        }
        return zzd(Base64.decode(str.substring(iIndexOf + 1), 0), d3, z2);
    }
}
