package com.squareup.okhttp.internal.framed;

import okio.BufferedSink;
import okio.BufferedSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public interface Variant {
    FrameReader a(BufferedSource bufferedSource, boolean z2);

    FrameWriter b(BufferedSink bufferedSink, boolean z2);
}
