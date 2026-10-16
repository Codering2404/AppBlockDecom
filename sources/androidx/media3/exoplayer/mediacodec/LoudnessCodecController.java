package androidx.media3.exoplayer.mediacodec;

import android.media.LoudnessCodecController$OnLoudnessCodecUpdateListener;
import android.media.MediaCodec;
import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.mediacodec.LoudnessCodecController;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class LoudnessCodecController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashSet f44249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LoudnessParameterUpdateListener f44250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.media.LoudnessCodecController f44251c;

    public LoudnessCodecController() {
        this(LoudnessParameterUpdateListener.f44253a);
    }

    public void b(MediaCodec mediaCodec) {
        android.media.LoudnessCodecController loudnessCodecController = this.f44251c;
        if (loudnessCodecController == null || loudnessCodecController.addMediaCodec(mediaCodec)) {
            Assertions.g(this.f44249a.add(mediaCodec));
        }
    }

    public void c() {
        this.f44249a.clear();
        android.media.LoudnessCodecController loudnessCodecController = this.f44251c;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
        }
    }

    public void d(MediaCodec mediaCodec) {
        android.media.LoudnessCodecController loudnessCodecController;
        if (!this.f44249a.remove(mediaCodec) || (loudnessCodecController = this.f44251c) == null) {
            return;
        }
        loudnessCodecController.removeMediaCodec(mediaCodec);
    }

    public void e(int i3) {
        android.media.LoudnessCodecController loudnessCodecController = this.f44251c;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
            this.f44251c = null;
        }
        android.media.LoudnessCodecController loudnessCodecControllerCreate = android.media.LoudnessCodecController.create(i3, MoreExecutors.a(), new LoudnessCodecController$OnLoudnessCodecUpdateListener() { // from class: androidx.media3.exoplayer.mediacodec.LoudnessCodecController.1
            public Bundle onLoudnessCodecUpdate(MediaCodec mediaCodec, Bundle bundle) {
                return LoudnessCodecController.this.f44250b.a(bundle);
            }
        });
        this.f44251c = loudnessCodecControllerCreate;
        Iterator it = this.f44249a.iterator();
        while (it.hasNext()) {
            if (!loudnessCodecControllerCreate.addMediaCodec((MediaCodec) it.next())) {
                it.remove();
            }
        }
    }

    public LoudnessCodecController(LoudnessParameterUpdateListener loudnessParameterUpdateListener) {
        this.f44249a = new HashSet();
        this.f44250b = loudnessParameterUpdateListener;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface LoudnessParameterUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LoudnessParameterUpdateListener f44253a = new LoudnessParameterUpdateListener() { // from class: androidx.media3.exoplayer.mediacodec.j
            @Override // androidx.media3.exoplayer.mediacodec.LoudnessCodecController.LoudnessParameterUpdateListener
            public final Bundle a(Bundle bundle) {
                return LoudnessCodecController.LoudnessParameterUpdateListener.b(bundle);
            }
        };

        Bundle a(Bundle bundle);

        static /* synthetic */ Bundle b(Bundle bundle) {
            return bundle;
        }
    }
}
