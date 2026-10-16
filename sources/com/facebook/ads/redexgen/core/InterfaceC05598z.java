package com.facebook.ads.redexgen.core;

import android.media.AudioDeviceInfo;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8z, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public interface InterfaceC05598z {
    void A59(C2208qI c2208qI, int i3, int[] iArr) throws C05548s;

    void A5z();

    void A6M();

    void A6T();

    long A7f(boolean z2);

    C2187px A8m();

    boolean A9e(ByteBuffer byteBuffer, long j3, int i3) throws C05588y, C05558t;

    void A9h();

    boolean A9o();

    boolean AAP();

    void AH0();

    void AH2() throws C05588y;

    void AJG(C2214qQ c2214qQ);

    void AJH(int i3);

    void AJI(AnonymousClass21 anonymousClass21);

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "Enable Retry Audio Track")
    void AJQ(boolean z2);

    void AJV(InterfaceC05568v interfaceC05568v);

    void AJd(C2187px c2187px);

    void AJg(C8O c8o);

    void AJi(AudioDeviceInfo audioDeviceInfo);

    void AJo(boolean z2);

    boolean AKN(C2208qI c2208qI);

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Old API that can be removed when we move to MediaCodecRenderer2")
    boolean AKP(int i3, int i4);

    void flush();

    void pause();

    void setVolume(float f3);
}
