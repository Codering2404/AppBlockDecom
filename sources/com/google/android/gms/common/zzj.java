package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzj extends com.google.android.gms.common.internal.zzw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72325a;

    protected zzj(byte[] bArr) {
        Preconditions.a(bArr.length == 25);
        this.f72325a = Arrays.hashCode(bArr);
    }

    protected static byte[] i5(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e3) {
            throw new AssertionError(e3);
        }
    }

    public final boolean equals(Object obj) {
        IObjectWrapper iObjectWrapperZzd;
        if (!(obj instanceof com.google.android.gms.common.internal.zzx)) {
            return false;
        }
        try {
            com.google.android.gms.common.internal.zzx zzxVar = (com.google.android.gms.common.internal.zzx) obj;
            if (zzxVar.zze() == this.f72325a && (iObjectWrapperZzd = zzxVar.zzd()) != null) {
                return Arrays.equals(h5(), (byte[]) ObjectWrapper.h5(iObjectWrapperZzd));
            }
            return false;
        } catch (RemoteException e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            return false;
        }
    }

    abstract byte[] h5();

    public final int hashCode() {
        return this.f72325a;
    }

    @Override // com.google.android.gms.common.internal.zzx
    public final IObjectWrapper zzd() {
        return ObjectWrapper.i5(h5());
    }

    @Override // com.google.android.gms.common.internal.zzx
    public final int zze() {
        return this.f72325a;
    }
}
