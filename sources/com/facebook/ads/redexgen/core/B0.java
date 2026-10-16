package com.facebook.ads.redexgen.core;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.util.Pair;
import android.view.Surface;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public interface B0 {
    @MetaExoPlayerCustomization("No longer in upstream exo")
    void A58(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i3, Object obj);

    int A5s();

    int A5u(MediaCodec.BufferInfo bufferInfo);

    ByteBuffer A8J(int i3);

    ByteBuffer A8e(int i3);

    MediaFormat A8f();

    @MetaExoPlayerCustomization("Added in D39791066")
    Pair<Long, Integer> A8j();

    @MetaExoPlayerCustomization("Added in D39791066")
    int A9K();

    void AHI(int i3, int i4, int i5, long j3, int i6);

    void AHK(int i3, int i4, C04855z c04855z, long j3, int i5);

    void AHb();

    void AHh(int i3, long j3);

    void AHi(int i3, boolean z2);

    void AJa(InterfaceC0599Az interfaceC0599Az, Handler handler);

    void AJb(Surface surface);

    void AJs(int i3);

    void flush();

    @MetaExoPlayerCustomization("No longer in upstream exo")
    @Deprecated
    void reset();

    @MetaExoPlayerCustomization("No longer in upstream exo")
    void start();

    @MetaExoPlayerCustomization("No longer in upstream exo")
    @Deprecated
    void stop();
}
