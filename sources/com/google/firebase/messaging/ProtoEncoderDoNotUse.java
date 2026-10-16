package com.google.firebase.messaging;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Encodable
public abstract class ProtoEncoderDoNotUse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProtobufEncoder f89419a = ProtobufEncoder.a().d(AutoProtoEncoderDoNotUseEncoder.f89346a).c();

    public static byte[] a(Object obj) {
        return f89419a.c(obj);
    }

    public abstract MessagingClientEventExtension b();
}
