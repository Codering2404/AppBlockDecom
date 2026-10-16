package androidx.media3.transformer;

import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.transformer.Codec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class CapturingDecoderFactory implements Codec.DecoderFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Codec.DecoderFactory f47962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f47963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f47964c;

    public CapturingDecoderFactory(Codec.DecoderFactory decoderFactory) {
        this.f47962a = decoderFactory;
    }

    @Override // androidx.media3.transformer.Codec.DecoderFactory
    public Codec a(Format format) {
        Codec codecA = this.f47962a.a(format);
        this.f47963b = codecA.getName();
        return codecA;
    }

    @Override // androidx.media3.transformer.Codec.DecoderFactory
    public Codec b(Format format, Surface surface, boolean z2) {
        Codec codecB = this.f47962a.b(format, surface, z2);
        this.f47964c = codecB.getName();
        return codecB;
    }

    public String c() {
        return this.f47963b;
    }

    public String d() {
        return this.f47964c;
    }
}
