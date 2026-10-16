package androidx.media3.exoplayer.mediacodec;

import android.content.Context;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecAdapter;
import com.google.common.base.Supplier;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultMediaCodecAdapterFactory implements MediaCodecAdapter.Factory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f44244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Supplier f44245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Supplier f44246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f44247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f44248f;

    public DefaultMediaCodecAdapterFactory() {
        this.f44247e = 0;
        this.f44248f = false;
        this.f44244b = null;
        this.f44245c = null;
        this.f44246d = null;
    }

    private boolean c() {
        int i3 = Util.f41609a;
        if (i3 >= 31) {
            return true;
        }
        Context context = this.f44244b;
        return context != null && i3 >= 28 && context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen");
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.Factory
    public MediaCodecAdapter b(MediaCodecAdapter.Configuration configuration) {
        int i3;
        Supplier supplier;
        if (Util.f41609a < 23 || !((i3 = this.f44247e) == 1 || (i3 == 0 && c()))) {
            return new SynchronousMediaCodecAdapter.Factory().b(configuration);
        }
        int iK = MimeTypes.k(configuration.f44256c.f40632o);
        Log.g("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + Util.s0(iK));
        Supplier supplier2 = this.f44245c;
        AsynchronousMediaCodecAdapter.Factory factory = (supplier2 == null || (supplier = this.f44246d) == null) ? new AsynchronousMediaCodecAdapter.Factory(iK) : new AsynchronousMediaCodecAdapter.Factory(supplier2, supplier);
        factory.f(this.f44248f);
        return factory.b(configuration);
    }

    public DefaultMediaCodecAdapterFactory(Context context) {
        this(context, null, null);
    }

    public DefaultMediaCodecAdapterFactory(Context context, Supplier supplier, Supplier supplier2) {
        this.f44244b = context;
        this.f44247e = 0;
        this.f44248f = false;
        this.f44245c = supplier;
        this.f44246d = supplier2;
    }
}
