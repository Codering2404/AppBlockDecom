package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization("Exo does not declare this as public but we need to as Hero's CacheDataSink refers to this")
public final class C0895Mo extends BufferedOutputStream {
    public boolean A00;

    public C0895Mo(OutputStream outputStream) {
        super(outputStream);
    }

    public C0895Mo(OutputStream outputStream, int i3) {
        super(outputStream, i3);
    }

    public final void A00(OutputStream outputStream) {
        AbstractC04323y.A08(this.A00);
        this.out = outputStream;
        this.count = 0;
        this.A00 = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        this.A00 = true;
        Throwable e3 = null;
        try {
            flush();
        } catch (Throwable th) {
            e3 = th;
        }
        try {
            this.out.close();
        } catch (Throwable thrown) {
            if (e3 == null) {
                e3 = thrown;
            }
        }
        if (e3 != null) {
            C5C.A11(e3);
            throw null;
        }
    }
}
