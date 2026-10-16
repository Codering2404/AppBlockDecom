package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzhq extends IOException {
    public final int zza;

    public zzhq(int i3) {
        this.zza = i3;
    }

    public zzhq(String str, int i3) {
        super(str);
        this.zza = i3;
    }

    public zzhq(String str, Throwable th, int i3) {
        super(str, th);
        this.zza = i3;
    }

    public zzhq(Throwable th, int i3) {
        super(th);
        this.zza = i3;
    }
}
