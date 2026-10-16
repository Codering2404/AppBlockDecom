package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.TrackOutput;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TrueHdSampleRechunker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f46231a = new byte[10];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f46232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f46233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f46234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f46235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f46236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f46237g;

    public void a(TrackOutput trackOutput, TrackOutput.CryptoData cryptoData) {
        if (this.f46233c > 0) {
            trackOutput.g(this.f46234d, this.f46235e, this.f46236f, this.f46237g, cryptoData);
            this.f46233c = 0;
        }
    }

    public void b() {
        this.f46232b = false;
        this.f46233c = 0;
    }

    public void c(TrackOutput trackOutput, long j3, int i3, int i4, int i5, TrackOutput.CryptoData cryptoData) {
        Assertions.h(this.f46237g <= i4 + i5, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.f46232b) {
            int i6 = this.f46233c;
            int i7 = i6 + 1;
            this.f46233c = i7;
            if (i6 == 0) {
                this.f46234d = j3;
                this.f46235e = i3;
                this.f46236f = 0;
            }
            this.f46236f += i4;
            this.f46237g = i5;
            if (i7 >= 16) {
                a(trackOutput, cryptoData);
            }
        }
    }

    public void d(ExtractorInput extractorInput) {
        if (this.f46232b) {
            return;
        }
        extractorInput.m(this.f46231a, 0, 10);
        extractorInput.f();
        if (Ac3Util.j(this.f46231a) == 0) {
            return;
        }
        this.f46232b = true;
    }
}
