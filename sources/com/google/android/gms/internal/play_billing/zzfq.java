package com.google.android.gms.internal.play_billing;

import androidx.legacy.content.Werj.QgXempTBEfV;
import com.google.android.gms.internal.play_billing.zzfq;
import com.google.android.gms.internal.play_billing.zzfu;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzfq<MessageType extends zzfu<MessageType, BuilderType>, BuilderType extends zzfq<MessageType, BuilderType>> extends zzef<MessageType, BuilderType> {
    protected zzfu zza;
    private final zzfu zzb;

    private static void zza(Object obj, Object obj2) {
        zzhi.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzef
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzfq clone() {
        zzfq zzfqVar = (zzfq) this.zzb.zzd(5, null, null);
        zzfqVar.zza = zzk();
        return zzfqVar;
    }

    public final zzfq zzh(zzfu zzfuVar) {
        if (!this.zzb.equals(zzfuVar)) {
            if (!this.zza.zzF()) {
                zzn();
            }
            zza(this.zza, zzfuVar);
        }
        return this;
    }

    public final MessageType zzi() {
        MessageType messagetype = (MessageType) zzk();
        if (messagetype.zzo()) {
            return messagetype;
        }
        throw new zzia(messagetype);
    }

    @Override // com.google.android.gms.internal.play_billing.zzha
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public MessageType zzk() {
        if (!this.zza.zzF()) {
            return (MessageType) this.zza;
        }
        this.zza.zzz();
        return (MessageType) this.zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhc
    public final /* bridge */ /* synthetic */ zzhb zzl() {
        throw null;
    }

    protected final void zzm() {
        if (this.zza.zzF()) {
            return;
        }
        zzn();
    }

    protected void zzn() {
        zzfu zzfuVarZzs = this.zzb.zzs();
        zza(zzfuVarZzs, this.zza);
        this.zza = zzfuVarZzs;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhc
    public final boolean zzo() {
        return zzfu.zzc(this.zza, false);
    }

    protected zzfq(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzF()) {
            this.zza = messagetype.zzs();
            return;
        }
        throw new IllegalArgumentException(QgXempTBEfV.nSytotlaTrc);
    }
}
