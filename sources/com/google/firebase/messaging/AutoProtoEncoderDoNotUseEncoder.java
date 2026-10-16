package com.google.firebase.messaging;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Configurator f89346a = new AutoProtoEncoderDoNotUseEncoder();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MessagingClientEventEncoder implements ObjectEncoder<MessagingClientEvent> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final MessagingClientEventEncoder f89347a = new MessagingClientEventEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f89348b = FieldDescriptor.a("projectNumber").b(AtProtobuf.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f89349c = FieldDescriptor.a("messageId").b(AtProtobuf.b().c(2).a()).a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f89350d = FieldDescriptor.a("instanceId").b(AtProtobuf.b().c(3).a()).a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f89351e = FieldDescriptor.a("messageType").b(AtProtobuf.b().c(4).a()).a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f89352f = FieldDescriptor.a("sdkPlatform").b(AtProtobuf.b().c(5).a()).a();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f89353g = FieldDescriptor.a("packageName").b(AtProtobuf.b().c(6).a()).a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final FieldDescriptor f89354h = FieldDescriptor.a("collapseKey").b(AtProtobuf.b().c(7).a()).a();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final FieldDescriptor f89355i = FieldDescriptor.a("priority").b(AtProtobuf.b().c(8).a()).a();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final FieldDescriptor f89356j = FieldDescriptor.a("ttl").b(AtProtobuf.b().c(9).a()).a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final FieldDescriptor f89357k = FieldDescriptor.a("topic").b(AtProtobuf.b().c(10).a()).a();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final FieldDescriptor f89358l = FieldDescriptor.a("bulkId").b(AtProtobuf.b().c(11).a()).a();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final FieldDescriptor f89359m = FieldDescriptor.a("event").b(AtProtobuf.b().c(12).a()).a();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final FieldDescriptor f89360n = FieldDescriptor.a("analyticsLabel").b(AtProtobuf.b().c(13).a()).a();

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final FieldDescriptor f89361o = FieldDescriptor.a("campaignId").b(AtProtobuf.b().c(14).a()).a();

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final FieldDescriptor f89362p = FieldDescriptor.a("composerLabel").b(AtProtobuf.b().c(15).a()).a();

        private MessagingClientEventEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MessagingClientEvent messagingClientEvent, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.c(f89348b, messagingClientEvent.l());
            objectEncoderContext.f(f89349c, messagingClientEvent.h());
            objectEncoderContext.f(f89350d, messagingClientEvent.g());
            objectEncoderContext.f(f89351e, messagingClientEvent.i());
            objectEncoderContext.f(f89352f, messagingClientEvent.m());
            objectEncoderContext.f(f89353g, messagingClientEvent.j());
            objectEncoderContext.f(f89354h, messagingClientEvent.d());
            objectEncoderContext.d(f89355i, messagingClientEvent.k());
            objectEncoderContext.d(f89356j, messagingClientEvent.o());
            objectEncoderContext.f(f89357k, messagingClientEvent.n());
            objectEncoderContext.c(f89358l, messagingClientEvent.b());
            objectEncoderContext.f(f89359m, messagingClientEvent.f());
            objectEncoderContext.f(f89360n, messagingClientEvent.a());
            objectEncoderContext.c(f89361o, messagingClientEvent.c());
            objectEncoderContext.f(f89362p, messagingClientEvent.e());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MessagingClientEventExtensionEncoder implements ObjectEncoder<MessagingClientEventExtension> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final MessagingClientEventExtensionEncoder f89363a = new MessagingClientEventExtensionEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f89364b = FieldDescriptor.a("messagingClientEvent").b(AtProtobuf.b().c(1).a()).a();

        private MessagingClientEventExtensionEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MessagingClientEventExtension messagingClientEventExtension, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f89364b, messagingClientEventExtension.a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ProtoEncoderDoNotUseEncoder implements ObjectEncoder<ProtoEncoderDoNotUse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ProtoEncoderDoNotUseEncoder f89365a = new ProtoEncoderDoNotUseEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f89366b = FieldDescriptor.d("messagingClientEventExtension");

        private ProtoEncoderDoNotUseEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ProtoEncoderDoNotUse protoEncoderDoNotUse, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.f(f89366b, protoEncoderDoNotUse.b());
        }
    }

    private AutoProtoEncoderDoNotUseEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void a(EncoderConfig encoderConfig) {
        encoderConfig.a(ProtoEncoderDoNotUse.class, ProtoEncoderDoNotUseEncoder.f89365a);
        encoderConfig.a(MessagingClientEventExtension.class, MessagingClientEventExtensionEncoder.f89363a);
        encoderConfig.a(MessagingClientEvent.class, MessagingClientEventEncoder.f89347a);
    }
}
