package com.google.firebase.encoders;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface ObjectEncoderContext {
    ObjectEncoderContext b(FieldDescriptor fieldDescriptor, boolean z2);

    ObjectEncoderContext c(FieldDescriptor fieldDescriptor, long j3);

    ObjectEncoderContext d(FieldDescriptor fieldDescriptor, int i3);

    ObjectEncoderContext e(FieldDescriptor fieldDescriptor, double d3);

    ObjectEncoderContext f(FieldDescriptor fieldDescriptor, Object obj);
}
