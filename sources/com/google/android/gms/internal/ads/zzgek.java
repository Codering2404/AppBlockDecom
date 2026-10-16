package com.google.android.gms.internal.ads;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.facebook.GraphRequest;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgek implements zzgee {
    private final ExecutorService zza;
    private final String zzb;
    private final long zzc;

    public zzgek(ExecutorService executorService, String str, long j3) {
        this.zza = executorService;
        this.zzb = str;
        this.zzc = j3;
    }

    private final ListenableFuture zze(final String str, final boolean z2, final byte[] bArr, final String str2) {
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: com.google.android.gms.internal.ads.zzgeh
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final /* synthetic */ Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.zza.zzc(str, z2, str2, bArr, completer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void zzd(String str, CallbackToFutureAdapter.Completer completer, boolean z2, String str2, byte[] bArr) {
        Throwable th;
        SocketTimeoutException e3;
        final HttpURLConnection httpURLConnection;
        byte[] byteArray;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) URI.create(str).toURL().openConnection();
                try {
                    Objects.requireNonNull(httpURLConnection);
                    completer.a(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgei
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            httpURLConnection.disconnect();
                        }
                    }, this.zza);
                    httpURLConnection.setRequestProperty(GraphRequest.USER_AGENT_HEADER, this.zzb);
                    int i3 = (int) this.zzc;
                    httpURLConnection.setConnectTimeout(i3);
                    httpURLConnection.setReadTimeout(i3);
                    if (z2) {
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setRequestMethod("POST");
                        if (str2 != null) {
                            httpURLConnection.setRequestProperty("Content-Type", str2);
                        }
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                        try {
                            bufferedOutputStream.write(bArr);
                            bufferedOutputStream.close();
                        } finally {
                        }
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    InputStream inputStream = responseCode < 400 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            if (inputStream == null) {
                                byteArray = new byte[0];
                                byteArrayOutputStream.close();
                            } else {
                                byte[] bArr2 = new byte[4096];
                                while (true) {
                                    int i4 = inputStream.read(bArr2);
                                    if (i4 == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr2, 0, i4);
                                    }
                                }
                                byteArray = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                inputStream.close();
                            }
                            completer.c(new zzgej(responseCode, byteArray));
                        } finally {
                        }
                    } finally {
                    }
                } catch (SocketTimeoutException e4) {
                    e3 = e4;
                    httpURLConnection2 = httpURLConnection;
                    String message = e3.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 9);
                    sb.append("Timeout: ");
                    sb.append(message);
                    completer.f(new TimeoutException(sb.toString()));
                    httpURLConnection = httpURLConnection2;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    completer.f(th);
                    httpURLConnection = httpURLConnection2;
                }
            } finally {
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            }
        } catch (SocketTimeoutException e5) {
            e3 = e5;
        } catch (Throwable th3) {
            th = th3;
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgee
    public final ListenableFuture zza(String str) {
        return zze(str, false, new byte[0], null);
    }

    @Override // com.google.android.gms.internal.ads.zzgee
    public final ListenableFuture zzb(String str, byte[] bArr, String str2) {
        return zze(str, true, bArr, "application/x-protobuf");
    }

    final /* synthetic */ Object zzc(final String str, final boolean z2, final String str2, final byte[] bArr, final CallbackToFutureAdapter.Completer completer) {
        this.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgeg
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzd(str, completer, z2, str2, bArr);
            }
        });
        return "";
    }
}
