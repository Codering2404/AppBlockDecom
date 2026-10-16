package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzidy;
import com.google.android.gms.internal.ads.zziee;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzidy<MessageType extends zziee<MessageType, BuilderType>, BuilderType extends zzidy<MessageType, BuilderType>> extends zzici<MessageType, BuilderType> {
    protected MessageType zza;
    private final MessageType zzb;

    protected zzidy(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzaX()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = (MessageType) zza();
    }

    private MessageType zza() {
        return (MessageType) this.zzb.zzbg();
    }

    private static <MessageType> void zzb(MessageType messagetype, MessageType messagetype2) {
        zzifz.zza().zzb(messagetype.getClass()).zzd(messagetype, messagetype2);
    }

    @Override // com.google.android.gms.internal.ads.zzici
    /* JADX INFO: renamed from: zzaE */
    public /* bridge */ /* synthetic */ zzici zzbd(zzide zzideVar, zzido zzidoVar) throws IOException {
        zzbr(zzideVar, zzidoVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzici
    /* JADX INFO: renamed from: zzaI */
    public /* bridge */ /* synthetic */ zzici zzaZ(byte[] bArr, int i3, int i4) throws zziet {
        zzbq(bArr, i3, i4);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzici
    /* JADX INFO: renamed from: zzaK */
    public /* bridge */ /* synthetic */ zzici zzaX(byte[] bArr, int i3, int i4, zzido zzidoVar) throws zziet {
        zzbp(bArr, i3, i4, zzidoVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzici
    protected /* bridge */ /* synthetic */ zzici zzaQ(zzicj zzicjVar) {
        zzbn((zziee) zzicjVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzici
    public /* bridge */ /* synthetic */ zzifo zzaX(byte[] bArr, int i3, int i4, zzido zzidoVar) throws zziet {
        zzbp(bArr, i3, i4, zzidoVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzici
    public /* bridge */ /* synthetic */ zzifo zzaZ(byte[] bArr, int i3, int i4) throws zziet {
        zzbq(bArr, i3, i4);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzici
    public /* bridge */ /* synthetic */ zzifo zzbd(zzide zzideVar, zzido zzidoVar) throws IOException {
        zzbr(zzideVar, zzidoVar);
        return this;
    }

    protected final void zzbg() {
        if (this.zza.zzaX()) {
            return;
        }
        zzbh();
    }

    protected void zzbh() {
        MessageType messagetype = (MessageType) zza();
        zzb(messagetype, this.zza);
        this.zza = messagetype;
    }

    @Override // com.google.android.gms.internal.ads.zzifq
    public final boolean zzbi() {
        return zziee.zzg(this.zza, false);
    }

    public final BuilderType zzbj() {
        if (this.zzb.zzaX()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = (MessageType) zza();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzici
    /* JADX INFO: renamed from: zzbk, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public BuilderType zzbf() {
        BuilderType buildertype = (BuilderType) zzbw().zzcY();
        buildertype.zza = (MessageType) zzbt();
        return buildertype;
    }

    @Override // com.google.android.gms.internal.ads.zzifo
    /* JADX INFO: renamed from: zzbl, reason: merged with bridge method [inline-methods] */
    public MessageType zzbt() {
        if (!this.zza.zzaX()) {
            return this.zza;
        }
        this.zza.zzbm();
        return this.zza;
    }

    /* JADX INFO: renamed from: zzbm, reason: merged with bridge method [inline-methods] */
    public final MessageType zzbu() {
        MessageType messagetype = (MessageType) zzbt();
        if (messagetype.zzbi()) {
            return messagetype;
        }
        throw zzici.zzaR(messagetype);
    }

    protected BuilderType zzbn(MessageType messagetype) {
        zzbo(messagetype);
        return this;
    }

    public BuilderType zzbo(MessageType messagetype) {
        if (zzbw().equals(messagetype)) {
            return this;
        }
        zzbg();
        zzb(this.zza, messagetype);
        return this;
    }

    public BuilderType zzbp(byte[] bArr, int i3, int i4, zzido zzidoVar) throws zziet {
        zzbg();
        try {
            zzifz.zza().zzb(this.zza.getClass()).zzj(this.zza, bArr, i3, i3 + i4, new zzico(zzidoVar));
            return this;
        } catch (zziet e3) {
            throw e3;
        } catch (IOException e4) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e4);
        } catch (IndexOutOfBoundsException unused) {
            throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public BuilderType zzbq(byte[] bArr, int i3, int i4) throws zziet {
        int i5 = zzido.zzb;
        int i6 = zzicn.zza;
        zzbp(bArr, i3, i4, zzido.zza);
        return this;
    }

    public BuilderType zzbr(zzide zzideVar, zzido zzidoVar) throws IOException {
        zzbg();
        try {
            zzifz.zza().zzb(this.zza.getClass()).zzg(this.zza, zzidf.zza(zzideVar), zzidoVar);
            return this;
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof IOException) {
                throw ((IOException) e3.getCause());
            }
            throw e3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzifq
    /* JADX INFO: renamed from: zzbs, reason: merged with bridge method [inline-methods] */
    public MessageType zzbw() {
        return this.zzb;
    }

    public /* bridge */ /* synthetic */ zzifo zzbv() {
        zzbj();
        return this;
    }
}
