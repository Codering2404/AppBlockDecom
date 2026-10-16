package androidx.media3.transformer;

import android.content.Context;
import android.media.MediaCodec;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.video.PlaceholderSurface;
import androidx.media3.transformer.Codec;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ExperimentalAnalyzerModeFactory {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DroppingEncoder implements Codec {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Format f48168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ByteBuffer f48169b = ByteBuffer.allocateDirect(8196).order(ByteOrder.nativeOrder());

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Surface f48170c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f48171d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Factory implements Codec.EncoderFactory {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Context f48172a;

            @Override // androidx.media3.transformer.Codec.EncoderFactory
            public Codec b(Format format) {
                return new DroppingEncoder(this.f48172a, format);
            }

            @Override // androidx.media3.transformer.Codec.EncoderFactory
            public Codec c(Format format) {
                return new DroppingEncoder(this.f48172a, format);
            }
        }

        public DroppingEncoder(Context context, Format format) {
            this.f48168a = format;
            this.f48170c = PlaceholderSurface.d(context, false);
        }

        @Override // androidx.media3.transformer.Codec
        public Surface a() {
            return this.f48170c;
        }

        @Override // androidx.media3.transformer.Codec
        public boolean b() {
            return this.f48171d;
        }

        @Override // androidx.media3.transformer.Codec
        public Format c() {
            return this.f48168a;
        }

        @Override // androidx.media3.transformer.Codec
        public void d(DecoderInputBuffer decoderInputBuffer) {
            Assertions.h(!this.f48171d, "Input buffer can not be queued after the input stream has ended.");
            if (decoderInputBuffer.i()) {
                this.f48171d = true;
            }
            decoderInputBuffer.f();
            decoderInputBuffer.f42138d = null;
        }

        @Override // androidx.media3.transformer.Codec
        public Format e() {
            return this.f48168a;
        }

        @Override // androidx.media3.transformer.Codec
        public MediaCodec.BufferInfo g() {
            return null;
        }

        @Override // androidx.media3.transformer.Codec
        public String getName() {
            return "DroppingEncoder";
        }

        @Override // androidx.media3.transformer.Codec
        public void i() {
            this.f48171d = true;
        }

        @Override // androidx.media3.transformer.Codec
        public ByteBuffer j() {
            return null;
        }

        @Override // androidx.media3.transformer.Codec
        public boolean l(DecoderInputBuffer decoderInputBuffer) {
            if (this.f48171d) {
                return false;
            }
            decoderInputBuffer.f42138d = this.f48169b;
            return true;
        }

        @Override // androidx.media3.transformer.Codec
        public Format m() {
            return this.f48168a;
        }

        @Override // androidx.media3.transformer.Codec
        public void release() {
            this.f48170c.release();
        }

        @Override // androidx.media3.transformer.Codec
        public void f(long j3) {
        }

        @Override // androidx.media3.transformer.Codec
        public void h(boolean z2) {
        }
    }
}
