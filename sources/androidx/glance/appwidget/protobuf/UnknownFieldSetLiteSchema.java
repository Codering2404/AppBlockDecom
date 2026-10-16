package androidx.glance.appwidget.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
    UnknownFieldSetLiteSchema() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public UnknownFieldSetLite g(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public int h(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public int i(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public UnknownFieldSetLite k(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        return UnknownFieldSetLite.c().equals(unknownFieldSetLite2) ? unknownFieldSetLite : UnknownFieldSetLite.c().equals(unknownFieldSetLite) ? UnknownFieldSetLite.j(unknownFieldSetLite, unknownFieldSetLite2) : unknownFieldSetLite.i(unknownFieldSetLite2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public UnknownFieldSetLite n() {
        return UnknownFieldSetLite.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public void o(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        p(obj, unknownFieldSetLite);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void p(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        ((GeneratedMessageLite) obj).unknownFields = unknownFieldSetLite;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public UnknownFieldSetLite r(UnknownFieldSetLite unknownFieldSetLite) {
        unknownFieldSetLite.h();
        return unknownFieldSetLite;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public void s(UnknownFieldSetLite unknownFieldSetLite, Writer writer) {
        unknownFieldSetLite.p(writer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(UnknownFieldSetLite unknownFieldSetLite, Writer writer) {
        unknownFieldSetLite.r(writer);
    }

    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    void j(Object obj) {
        g(obj).h();
    }

    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    boolean q(Reader reader) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(UnknownFieldSetLite unknownFieldSetLite, int i3, int i4) {
        unknownFieldSetLite.n(WireFormat.c(i3, 5), Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(UnknownFieldSetLite unknownFieldSetLite, int i3, long j3) {
        unknownFieldSetLite.n(WireFormat.c(i3, 1), Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(UnknownFieldSetLite unknownFieldSetLite, int i3, UnknownFieldSetLite unknownFieldSetLite2) {
        unknownFieldSetLite.n(WireFormat.c(i3, 3), unknownFieldSetLite2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void d(UnknownFieldSetLite unknownFieldSetLite, int i3, ByteString byteString) {
        unknownFieldSetLite.n(WireFormat.c(i3, 2), byteString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(UnknownFieldSetLite unknownFieldSetLite, int i3, long j3) {
        unknownFieldSetLite.n(WireFormat.c(i3, 0), Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.glance.appwidget.protobuf.UnknownFieldSchema
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public UnknownFieldSetLite f(Object obj) {
        UnknownFieldSetLite unknownFieldSetLiteG = g(obj);
        if (unknownFieldSetLiteG != UnknownFieldSetLite.c()) {
            return unknownFieldSetLiteG;
        }
        UnknownFieldSetLite unknownFieldSetLiteK = UnknownFieldSetLite.k();
        p(obj, unknownFieldSetLiteK);
        return unknownFieldSetLiteK;
    }
}
