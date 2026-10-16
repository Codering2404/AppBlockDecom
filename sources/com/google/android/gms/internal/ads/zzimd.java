package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzimd extends zzimb implements zzaup {
    private int zzg;

    protected zzimd(String str) {
        super("mvhd");
    }

    public final int zzg() {
        if (!this.zzb) {
            zzf();
        }
        return this.zzg;
    }

    protected final long zzh(ByteBuffer byteBuffer) {
        this.zzg = zzauo.zzc(byteBuffer.get());
        zzauo.zzb(byteBuffer);
        byteBuffer.get();
        return 4L;
    }
}
