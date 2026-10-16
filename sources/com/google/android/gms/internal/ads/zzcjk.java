package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Objects;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcjk extends SSLSocketFactory {
    final SSLSocketFactory zza;
    final /* synthetic */ zzcjl zzb;

    zzcjk(zzcjl zzcjlVar) {
        Objects.requireNonNull(zzcjlVar);
        this.zzb = zzcjlVar;
        this.zza = (SSLSocketFactory) SSLSocketFactory.getDefault();
    }

    private final Socket zza(Socket socket) throws SocketException {
        zzcjl zzcjlVar = this.zzb;
        if (zzcjlVar.zzm() > 0) {
            socket.setReceiveBufferSize(zzcjlVar.zzm());
        }
        zzcjlVar.zzl(socket);
        return socket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i3) throws IOException {
        Socket socketCreateSocket = this.zza.createSocket(str, i3);
        zza(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.zza.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.zza.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i3, InetAddress inetAddress, int i4) throws IOException {
        Socket socketCreateSocket = this.zza.createSocket(str, i3, inetAddress, i4);
        zza(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i3) throws IOException {
        Socket socketCreateSocket = this.zza.createSocket(inetAddress, i3);
        zza(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i3, InetAddress inetAddress2, int i4) throws IOException {
        Socket socketCreateSocket = this.zza.createSocket(inetAddress, i3, inetAddress2, i4);
        zza(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i3, boolean z2) throws IOException {
        Socket socketCreateSocket = this.zza.createSocket(socket, str, i3, z2);
        zza(socketCreateSocket);
        return socketCreateSocket;
    }
}
