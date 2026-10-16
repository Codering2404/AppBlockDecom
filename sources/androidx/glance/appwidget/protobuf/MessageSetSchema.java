package androidx.glance.appwidget.protobuf;

import androidx.glance.appwidget.protobuf.FieldSet;
import androidx.glance.appwidget.protobuf.LazyField;
import androidx.glance.appwidget.protobuf.WireFormat;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class MessageSetSchema<T> implements Schema<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MessageLite f39178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final UnknownFieldSchema f39179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f39180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ExtensionSchema f39181d;

    private MessageSetSchema(UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MessageLite messageLite) {
        this.f39179b = unknownFieldSchema;
        this.f39180c = extensionSchema.e(messageLite);
        this.f39181d = extensionSchema;
        this.f39178a = messageLite;
    }

    private int j(UnknownFieldSchema unknownFieldSchema, Object obj) {
        return unknownFieldSchema.i(unknownFieldSchema.g(obj));
    }

    private void k(UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, Object obj, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        UnknownFieldSchema unknownFieldSchema2;
        Object objF = unknownFieldSchema.f(obj);
        FieldSet fieldSetD = extensionSchema.d(obj);
        while (reader.A() != Integer.MAX_VALUE) {
            try {
                unknownFieldSchema2 = unknownFieldSchema;
                ExtensionSchema extensionSchema2 = extensionSchema;
                Reader reader2 = reader;
                ExtensionRegistryLite extensionRegistryLite2 = extensionRegistryLite;
                try {
                    if (!m(reader2, extensionRegistryLite2, extensionSchema2, fieldSetD, unknownFieldSchema2, objF)) {
                        unknownFieldSchema2.o(obj, objF);
                        return;
                    }
                    reader = reader2;
                    extensionRegistryLite = extensionRegistryLite2;
                    extensionSchema = extensionSchema2;
                    unknownFieldSchema = unknownFieldSchema2;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    unknownFieldSchema2.o(obj, objF);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                unknownFieldSchema2 = unknownFieldSchema;
            }
        }
        unknownFieldSchema.o(obj, objF);
    }

    static MessageSetSchema l(UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MessageLite messageLite) {
        return new MessageSetSchema(unknownFieldSchema, extensionSchema, messageLite);
    }

    private boolean m(Reader reader, ExtensionRegistryLite extensionRegistryLite, ExtensionSchema extensionSchema, FieldSet fieldSet, UnknownFieldSchema unknownFieldSchema, Object obj) throws InvalidProtocolBufferException {
        int iC = reader.c();
        if (iC != WireFormat.f39324a) {
            if (WireFormat.b(iC) != 2) {
                return reader.D();
            }
            Object objB = extensionSchema.b(extensionRegistryLite, this.f39178a, WireFormat.a(iC));
            if (objB == null) {
                return unknownFieldSchema.m(obj, reader);
            }
            extensionSchema.h(reader, objB, extensionRegistryLite, fieldSet);
            return true;
        }
        Object objB2 = null;
        int iH = 0;
        ByteString byteStringO = null;
        while (reader.A() != Integer.MAX_VALUE) {
            int iC2 = reader.c();
            if (iC2 == WireFormat.f39326c) {
                iH = reader.h();
                objB2 = extensionSchema.b(extensionRegistryLite, this.f39178a, iH);
            } else if (iC2 == WireFormat.f39327d) {
                if (objB2 != null) {
                    extensionSchema.h(reader, objB2, extensionRegistryLite, fieldSet);
                } else {
                    byteStringO = reader.o();
                }
            } else if (!reader.D()) {
                break;
            }
        }
        if (reader.c() != WireFormat.f39325b) {
            throw InvalidProtocolBufferException.b();
        }
        if (byteStringO != null) {
            if (objB2 != null) {
                extensionSchema.i(byteStringO, objB2, extensionRegistryLite, fieldSet);
            } else {
                unknownFieldSchema.d(obj, iH, byteStringO);
            }
        }
        return true;
    }

    private void n(UnknownFieldSchema unknownFieldSchema, Object obj, Writer writer) {
        unknownFieldSchema.s(unknownFieldSchema.g(obj), writer);
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public void a(Object obj, Object obj2) {
        SchemaUtil.G(this.f39179b, obj, obj2);
        if (this.f39180c) {
            SchemaUtil.E(this.f39181d, obj, obj2);
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public void b(Object obj) {
        this.f39179b.j(obj);
        this.f39181d.f(obj);
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public final boolean c(Object obj) {
        return this.f39181d.c(obj).p();
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public int d(Object obj) {
        int iJ = j(this.f39179b, obj);
        return this.f39180c ? iJ + this.f39181d.c(obj).j() : iJ;
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public int e(Object obj) {
        int iHashCode = this.f39179b.g(obj).hashCode();
        return this.f39180c ? (iHashCode * 53) + this.f39181d.c(obj).hashCode() : iHashCode;
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public boolean f(Object obj, Object obj2) {
        if (!this.f39179b.g(obj).equals(this.f39179b.g(obj2))) {
            return false;
        }
        if (this.f39180c) {
            return this.f39181d.c(obj).equals(this.f39181d.c(obj2));
        }
        return true;
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public void g(Object obj, Writer writer) {
        Iterator itT = this.f39181d.c(obj).t();
        while (itT.hasNext()) {
            Map.Entry entry = (Map.Entry) itT.next();
            FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite) entry.getKey();
            if (fieldDescriptorLite.M() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.K() || fieldDescriptorLite.N()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof LazyField.LazyEntry) {
                writer.b(fieldDescriptorLite.J(), ((LazyField.LazyEntry) entry).a().e());
            } else {
                writer.b(fieldDescriptorLite.J(), entry.getValue());
            }
        }
        n(this.f39179b, obj, writer);
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public void h(Object obj, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        k(this.f39179b, this.f39181d, obj, reader, extensionRegistryLite);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cf A[EDGE_INSN: B:62:0x00cf->B:34:0x00cf BREAK  A[LOOP:1: B:17:0x006f->B:65:0x006f], SYNTHETIC] */
    @Override // androidx.glance.appwidget.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i(java.lang.Object r11, byte[] r12, int r13, int r14, androidx.glance.appwidget.protobuf.ArrayDecoders.Registers r15) throws androidx.glance.appwidget.protobuf.InvalidProtocolBufferException {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.MessageSetSchema.i(java.lang.Object, byte[], int, int, androidx.glance.appwidget.protobuf.ArrayDecoders$Registers):void");
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public Object newInstance() {
        MessageLite messageLite = this.f39178a;
        return messageLite instanceof GeneratedMessageLite ? ((GeneratedMessageLite) messageLite).N() : messageLite.e().f();
    }
}
