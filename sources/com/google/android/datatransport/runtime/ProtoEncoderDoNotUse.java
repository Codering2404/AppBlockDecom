package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.ProtobufEncoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Encodable
public abstract class ProtoEncoderDoNotUse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProtobufEncoder f69351a = ProtobufEncoder.a().d(AutoProtoEncoderDoNotUseEncoder.f69275a).c();

    public static byte[] a(Object obj) {
        return f69351a.c(obj);
    }

    public abstract ClientMetrics b();
}
