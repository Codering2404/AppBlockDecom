package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.audio.MediaCodecAudioRenderer;
import androidx.media3.exoplayer.image.ImageDecoder;
import androidx.media3.exoplayer.image.ImageRenderer;
import androidx.media3.exoplayer.mediacodec.DefaultMediaCodecAdapterFactory;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.metadata.MetadataOutput;
import androidx.media3.exoplayer.metadata.MetadataRenderer;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.text.TextRenderer;
import androidx.media3.exoplayer.video.MediaCodecVideoRenderer;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.spherical.CameraMotionRenderer;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultRenderersFactory implements RenderersFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f42933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DefaultMediaCodecAdapterFactory f42934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f42935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f42936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f42937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MediaCodecSelector f42938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f42939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f42940h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f42941i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f42942j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f42943k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExtensionRendererMode {
    }

    @Override // androidx.media3.exoplayer.RenderersFactory
    public Renderer a(Renderer renderer, Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        if (renderer.g() == 2) {
            return i(renderer, this.f42933a, this.f42935c, this.f42938f, this.f42937e, handler, videoRendererEventListener, this.f42936d);
        }
        return null;
    }

    @Override // androidx.media3.exoplayer.RenderersFactory
    public Renderer[] b(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        Handler handler2;
        ArrayList arrayList = new ArrayList();
        k(this.f42933a, this.f42935c, this.f42938f, this.f42937e, handler, videoRendererEventListener, this.f42936d, arrayList);
        AudioSink audioSinkD = d(this.f42933a, this.f42939g, this.f42940h);
        if (audioSinkD != null) {
            handler2 = handler;
            c(this.f42933a, this.f42935c, this.f42938f, this.f42937e, audioSinkD, handler2, audioRendererEventListener, arrayList);
        } else {
            handler2 = handler;
        }
        j(this.f42933a, textOutput, handler2.getLooper(), this.f42935c, arrayList);
        g(this.f42933a, metadataOutput, handler2.getLooper(), this.f42935c, arrayList);
        e(this.f42933a, this.f42935c, arrayList);
        f(arrayList);
        h(this.f42933a, handler2, this.f42935c, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    protected AudioSink d(Context context, boolean z2, boolean z3) {
        return new DefaultAudioSink.Builder(context).l(z2).k(z3).j();
    }

    protected void e(Context context, int i3, ArrayList arrayList) {
        arrayList.add(new CameraMotionRenderer());
    }

    protected void f(ArrayList arrayList) {
        arrayList.add(new ImageRenderer(m(), null));
    }

    protected void g(Context context, MetadataOutput metadataOutput, Looper looper, int i3, ArrayList arrayList) {
        arrayList.add(new MetadataRenderer(metadataOutput, looper));
        arrayList.add(new MetadataRenderer(metadataOutput, looper));
    }

    protected void h(Context context, Handler handler, int i3, ArrayList arrayList) {
    }

    protected Renderer i(Renderer renderer, Context context, int i3, MediaCodecSelector mediaCodecSelector, boolean z2, Handler handler, VideoRendererEventListener videoRendererEventListener, long j3) {
        if (this.f42941i && renderer.getClass() == MediaCodecVideoRenderer.class) {
            return new MediaCodecVideoRenderer.Builder(context).r(l()).w(mediaCodecSelector).p(j3).s(z2).t(handler).u(videoRendererEventListener).v(50).o(this.f42942j).n(this.f42943k).m();
        }
        return null;
    }

    protected void j(Context context, TextOutput textOutput, Looper looper, int i3, ArrayList arrayList) {
        arrayList.add(new TextRenderer(textOutput, looper));
    }

    protected void k(Context context, int i3, MediaCodecSelector mediaCodecSelector, boolean z2, Handler handler, VideoRendererEventListener videoRendererEventListener, long j3, ArrayList arrayList) {
        int i4;
        int i5;
        Class cls = Integer.TYPE;
        Class cls2 = Long.TYPE;
        arrayList.add(new MediaCodecVideoRenderer.Builder(context).r(l()).w(mediaCodecSelector).p(j3).s(z2).t(handler).u(videoRendererEventListener).v(50).o(this.f42942j).n(this.f42943k).m());
        if (i3 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i3 == 2) {
            size--;
        }
        try {
            try {
                i4 = size + 1;
            } catch (ClassNotFoundException unused) {
            }
            try {
                arrayList.add(size, (Renderer) Class.forName("androidx.media3.decoder.vp9.LibvpxVideoRenderer").getConstructor(cls2, Handler.class, VideoRendererEventListener.class, cls).newInstance(Long.valueOf(j3), handler, videoRendererEventListener, 50));
                Log.g("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
            } catch (ClassNotFoundException unused2) {
                size = i4;
                i4 = size;
            }
            try {
                try {
                    i5 = i4 + 1;
                    try {
                        arrayList.add(i4, (Renderer) Class.forName("androidx.media3.decoder.av1.Libgav1VideoRenderer").getConstructor(cls2, Handler.class, VideoRendererEventListener.class, cls).newInstance(Long.valueOf(j3), handler, videoRendererEventListener, 50));
                        Log.g("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
                    } catch (ClassNotFoundException unused3) {
                        i4 = i5;
                        i5 = i4;
                    }
                } catch (Exception e3) {
                    throw new IllegalStateException("Error instantiating AV1 extension", e3);
                }
            } catch (ClassNotFoundException unused4) {
            }
            try {
                arrayList.add(i5, (Renderer) Class.forName("androidx.media3.decoder.ffmpeg.ExperimentalFfmpegVideoRenderer").getConstructor(cls2, Handler.class, VideoRendererEventListener.class, cls).newInstance(Long.valueOf(j3), handler, videoRendererEventListener, 50));
                Log.g("DefaultRenderersFactory", "Loaded FfmpegVideoRenderer.");
            } catch (ClassNotFoundException unused5) {
            } catch (Exception e4) {
                throw new IllegalStateException("Error instantiating FFmpeg extension", e4);
            }
        } catch (Exception e5) {
            throw new IllegalStateException("Error instantiating VP9 extension", e5);
        }
    }

    protected MediaCodecAdapter.Factory l() {
        return this.f42934b;
    }

    protected ImageDecoder.Factory m() {
        return ImageDecoder.Factory.f44157a;
    }

    protected void c(Context context, int i3, MediaCodecSelector mediaCodecSelector, boolean z2, AudioSink audioSink, Handler handler, AudioRendererEventListener audioRendererEventListener, ArrayList arrayList) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        arrayList.add(new MediaCodecAudioRenderer(context, l(), mediaCodecSelector, z2, handler, audioRendererEventListener, audioSink));
        if (i3 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i3 == 2) {
            size--;
        }
        try {
            try {
                i4 = size + 1;
            } catch (ClassNotFoundException unused) {
            }
            try {
                arrayList.add(size, (Renderer) Class.forName("androidx.media3.decoder.midi.MidiRenderer").getConstructor(Context.class, Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(context, handler, audioRendererEventListener, audioSink));
                Log.g("DefaultRenderersFactory", "Loaded MidiRenderer.");
            } catch (ClassNotFoundException unused2) {
                size = i4;
                i4 = size;
            }
            try {
                try {
                    i5 = i4 + 1;
                    try {
                        arrayList.add(i4, (Renderer) Class.forName("androidx.media3.decoder.opus.LibopusAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                        Log.g("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                    } catch (ClassNotFoundException unused3) {
                        i4 = i5;
                        i5 = i4;
                    }
                } catch (ClassNotFoundException unused4) {
                }
                try {
                    try {
                        i6 = i5 + 1;
                    } catch (ClassNotFoundException unused5) {
                    }
                    try {
                        arrayList.add(i5, (Renderer) Class.forName("androidx.media3.decoder.flac.LibflacAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                        Log.g("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                    } catch (ClassNotFoundException unused6) {
                        i5 = i6;
                        i6 = i5;
                    }
                    try {
                        try {
                            i7 = i6 + 1;
                            try {
                                arrayList.add(i6, (Renderer) Class.forName("androidx.media3.decoder.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                                Log.g("DefaultRenderersFactory", KrzujOtzIk.lqrfujlJZyHvfrH);
                            } catch (ClassNotFoundException unused7) {
                                i6 = i7;
                                i7 = i6;
                            }
                        } catch (ClassNotFoundException unused8) {
                        }
                        try {
                            try {
                                i8 = i7 + 1;
                            } catch (ClassNotFoundException unused9) {
                            }
                            try {
                                arrayList.add(i7, (Renderer) Class.forName("androidx.media3.decoder.iamf.LibiamfAudioRenderer").getConstructor(Context.class, Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(context, handler, audioRendererEventListener, audioSink));
                                Log.g("DefaultRenderersFactory", "Loaded LibiamfAudioRenderer.");
                            } catch (ClassNotFoundException unused10) {
                                i7 = i8;
                                i8 = i7;
                            }
                            try {
                                arrayList.add(i8, (Renderer) Class.forName("androidx.media3.decoder.mpegh.MpeghAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                                Log.g("DefaultRenderersFactory", "Loaded MpeghAudioRenderer.");
                            } catch (ClassNotFoundException unused11) {
                            } catch (Exception e3) {
                                throw new IllegalStateException("Error instantiating MPEG-H extension", e3);
                            }
                        } catch (Exception e4) {
                            throw new IllegalStateException("Error instantiating IAMF extension", e4);
                        }
                    } catch (Exception e5) {
                        throw new IllegalStateException("Error instantiating FFmpeg extension", e5);
                    }
                } catch (Exception e6) {
                    throw new IllegalStateException("Error instantiating FLAC extension", e6);
                }
            } catch (Exception e7) {
                throw new IllegalStateException("Error instantiating Opus extension", e7);
            }
        } catch (Exception e8) {
            throw new IllegalStateException("Error instantiating MIDI extension", e8);
        }
    }
}
