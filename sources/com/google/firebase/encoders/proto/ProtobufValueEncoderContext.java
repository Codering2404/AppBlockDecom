package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class ProtobufValueEncoderContext implements ValueEncoderContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f89177a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f89178b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FieldDescriptor f89179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ProtobufDataEncoderContext f89180d;

    ProtobufValueEncoderContext(ProtobufDataEncoderContext protobufDataEncoderContext) {
        this.f89180d = protobufDataEncoderContext;
    }

    private void b() {
        if (this.f89177a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f89177a = true;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext a(String str) {
        b();
        this.f89180d.i(this.f89179c, str, this.f89178b);
        return this;
    }

    void c(FieldDescriptor fieldDescriptor, boolean z2) {
        this.f89177a = false;
        this.f89179c = fieldDescriptor;
        this.f89178b = z2;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext g(boolean z2) {
        b();
        this.f89180d.o(this.f89179c, z2, this.f89178b);
        return this;
    }
}
