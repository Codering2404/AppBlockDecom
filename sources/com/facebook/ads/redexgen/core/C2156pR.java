package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.facebook.ads.androidx.media3.common.text.Cue;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2156pR implements AnonymousClass24 {
    public final long A00;

    @MetaExoPlayerCustomization("Oculus does not work well with Google Guava")
    public final List<C2158pT> A01;
    public static final C2156pR A03 = new C2156pR(MetaExoPlayerCustomizedCollections.A01(), 0);
    public static final String A04 = C5C.A0h(0);
    public static final String A05 = C5C.A0h(1);
    public static final AnonymousClass23<C2156pR> A02 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.pS
        @Override // com.facebook.ads.redexgen.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return C2156pR.A00(bundle);
        }
    };

    @MetaExoPlayerCustomization("Oculus does not work well with Google Guava")
    public C2156pR(List<C2158pT> list, long j3) {
        this.A01 = MetaExoPlayerCustomizedCollections.A03((C2158pT[]) list.toArray(new C2158pT[0]));
        this.A00 = j3;
    }

    public static final C2156pR A00(Bundle bundle) {
        List listA01;
        List<Cue> cues = bundle.getParcelableArrayList(A04);
        if (cues == null) {
            listA01 = MetaExoPlayerCustomizedCollections.A01();
        } else {
            listA01 = AnonymousClass44.A01(C2158pT.A0I, cues);
        }
        return new C2156pR(listA01, bundle.getLong(A05));
    }
}
