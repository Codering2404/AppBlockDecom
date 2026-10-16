package com.google.android.gms.internal.measurement;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzah implements zzao {
    private final Double zza;

    public zzah(Double d3) {
        if (d3 == null) {
            this.zza = Double.valueOf(Double.NaN);
        } else {
            this.zza = d3;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzah) {
            return this.zza.equals(((zzah) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return zzc();
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        Double d3 = this.zza;
        if (Double.isNaN(d3.doubleValue())) {
            return "NaN";
        }
        if (Double.isInfinite(d3.doubleValue())) {
            return d3.doubleValue() > 0.0d ? "Infinity" : "-Infinity";
        }
        BigDecimal bigDecimalA = a.a(BigDecimal.valueOf(d3.doubleValue()));
        DecimalFormat decimalFormat = new DecimalFormat("0E0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.setMinimumFractionDigits((bigDecimalA.scale() > 0 ? bigDecimalA.precision() : bigDecimalA.scale()) - 1);
        String str = decimalFormat.format(bigDecimalA);
        int iIndexOf = str.indexOf("E");
        if (iIndexOf <= 0) {
            return str;
        }
        int i3 = Integer.parseInt(str.substring(iIndexOf + 1));
        return ((i3 >= 0 || i3 <= -7) && (i3 < 0 || i3 >= 21)) ? str.replace("E-", "e-").replace("E", "e+") : bigDecimalA.toPlainString();
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzcA(String str, zzg zzgVar, List list) {
        if (InAppPurchaseConstants.METHOD_TO_STRING.equals(str)) {
            return new zzas(zzc());
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", zzc(), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        Double d3 = this.zza;
        boolean z2 = false;
        if (!Double.isNaN(d3.doubleValue()) && d3.doubleValue() != 0.0d) {
            z2 = true;
        }
        return Boolean.valueOf(z2);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        return new zzah(this.zza);
    }
}
