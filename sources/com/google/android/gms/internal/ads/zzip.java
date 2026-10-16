package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzip extends zzhh {
    private final byte[] zza;
    private final DatagramPacket zzb;
    private Uri zzc;
    private DatagramSocket zzd;
    private MulticastSocket zze;
    private InetAddress zzf;
    private boolean zzg;
    private int zzh;

    public zzip() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i3, int i4) throws zzio {
        if (i4 == 0) {
            return 0;
        }
        if (this.zzh == 0) {
            try {
                DatagramSocket datagramSocket = this.zzd;
                if (datagramSocket == null) {
                    throw null;
                }
                DatagramPacket datagramPacket = this.zzb;
                datagramSocket.receive(datagramPacket);
                int length = datagramPacket.getLength();
                this.zzh = length;
                zzh(length);
            } catch (SocketTimeoutException e3) {
                throw new zzio(e3, AdError.CACHE_ERROR_CODE);
            } catch (IOException e4) {
                throw new zzio(e4, AdError.INTERNAL_ERROR_CODE);
            }
        }
        int length2 = this.zzb.getLength();
        int i5 = this.zzh;
        int iMin = Math.min(i5, i4);
        System.arraycopy(this.zza, length2 - i5, bArr, i3, iMin);
        this.zzh -= iMin;
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final long zzb(zzht zzhtVar) throws zzio {
        Uri uri = zzhtVar.zza;
        this.zzc = uri;
        String host = uri.getHost();
        host.getClass();
        int port = this.zzc.getPort();
        zzf(zzhtVar);
        try {
            this.zzf = InetAddress.getByName(host);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.zzf, port);
            if (this.zzf.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.zze = multicastSocket;
                multicastSocket.joinGroup(this.zzf);
                this.zzd = this.zze;
            } else {
                this.zzd = new DatagramSocket(inetSocketAddress);
            }
            this.zzd.setSoTimeout(8000);
            this.zzg = true;
            zzg(zzhtVar);
            return -1L;
        } catch (IOException e3) {
            throw new zzio(e3, AdError.INTERNAL_ERROR_CODE);
        } catch (SecurityException e4) {
            throw new zzio(e4, AdError.INTERNAL_ERROR_2006);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() {
        InetAddress inetAddress;
        this.zzc = null;
        MulticastSocket multicastSocket = this.zze;
        if (multicastSocket != null) {
            try {
                inetAddress = this.zzf;
            } catch (IOException unused) {
            }
            if (inetAddress == null) {
                throw null;
            }
            multicastSocket.leaveGroup(inetAddress);
            this.zze = null;
        }
        DatagramSocket datagramSocket = this.zzd;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.zzd = null;
        }
        this.zzf = null;
        this.zzh = 0;
        if (this.zzg) {
            this.zzg = false;
            zzi();
        }
    }

    public zzip(int i3) {
        super(true);
        byte[] bArr = new byte[AdError.SERVER_ERROR_CODE];
        this.zza = bArr;
        this.zzb = new DatagramPacket(bArr, 0, AdError.SERVER_ERROR_CODE);
    }
}
