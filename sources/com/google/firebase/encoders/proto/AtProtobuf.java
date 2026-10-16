package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AtProtobuf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f89151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Protobuf.IntEncoding f89152b = Protobuf.IntEncoding.DEFAULT;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ProtobufImpl implements Protobuf {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f89153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Protobuf.IntEncoding f89154d;

        ProtobufImpl(int i3, Protobuf.IntEncoding intEncoding) {
            this.f89153c = i3;
            this.f89154d = intEncoding;
        }

        @Override // java.lang.annotation.Annotation
        public Class annotationType() {
            return Protobuf.class;
        }

        @Override // java.lang.annotation.Annotation
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Protobuf)) {
                return false;
            }
            Protobuf protobuf = (Protobuf) obj;
            return this.f89153c == protobuf.tag() && this.f89154d.equals(protobuf.intEncoding());
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (14552422 ^ this.f89153c) + (this.f89154d.hashCode() ^ 2041407134);
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public Protobuf.IntEncoding intEncoding() {
            return this.f89154d;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public int tag() {
            return this.f89153c;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f89153c + "intEncoding=" + this.f89154d + ')';
        }
    }

    public static AtProtobuf b() {
        return new AtProtobuf();
    }

    public Protobuf a() {
        return new ProtobufImpl(this.f89151a, this.f89152b);
    }

    public AtProtobuf c(int i3) {
        this.f89151a = i3;
        return this;
    }
}
