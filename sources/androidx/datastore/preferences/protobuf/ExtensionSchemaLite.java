package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class ExtensionSchemaLite extends ExtensionSchema<GeneratedMessageLite.ExtensionDescriptor> {

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.ExtensionSchemaLite$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f36290a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f36290a = iArr;
            try {
                iArr[WireFormat.FieldType.f36688c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36290a[WireFormat.FieldType.f36689d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36290a[WireFormat.FieldType.f36690f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36290a[WireFormat.FieldType.f36691g.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36290a[WireFormat.FieldType.f36692h.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f36290a[WireFormat.FieldType.f36693i.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36290a[WireFormat.FieldType.f36694j.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f36290a[WireFormat.FieldType.f36695k.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f36290a[WireFormat.FieldType.f36700p.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f36290a[WireFormat.FieldType.f36702r.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f36290a[WireFormat.FieldType.f36703s.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f36290a[WireFormat.FieldType.f36704t.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f36290a[WireFormat.FieldType.f36705u.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f36290a[WireFormat.FieldType.f36701q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f36290a[WireFormat.FieldType.f36699o.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f36290a[WireFormat.FieldType.f36696l.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f36290a[WireFormat.FieldType.f36697m.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f36290a[WireFormat.FieldType.f36698n.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    ExtensionSchemaLite() {
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    int a(Map.Entry entry) {
        return ((GeneratedMessageLite.ExtensionDescriptor) entry.getKey()).J();
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    Object b(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i3) {
        return extensionRegistryLite.a(messageLite, i3);
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    FieldSet c(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).extensions;
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    FieldSet d(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).W();
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    boolean e(MessageLite messageLite) {
        return messageLite instanceof GeneratedMessageLite.ExtendableMessage;
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    void f(Object obj) {
        c(obj).u();
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    Object g(Object obj, Reader reader, Object obj2, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet, Object obj3, UnknownFieldSchema unknownFieldSchema) {
        Object objValueOf;
        Object objI;
        ArrayList arrayList;
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj2;
        int iC = generatedExtension.c();
        if (generatedExtension.f36406d.K() && generatedExtension.f36406d.N()) {
            switch (AnonymousClass1.f36290a[generatedExtension.a().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    reader.G(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    reader.C(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    reader.i(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    reader.g(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    reader.w(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    reader.q(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    reader.x(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    reader.m(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    reader.t(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    reader.b(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    reader.v(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    reader.r(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    reader.d(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    reader.j(arrayList);
                    obj3 = SchemaUtil.z(obj, iC, arrayList, generatedExtension.f36406d.b(), obj3, unknownFieldSchema);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + generatedExtension.f36406d.L());
            }
            fieldSet.y(generatedExtension.f36406d, arrayList);
            return obj3;
        }
        if (generatedExtension.a() != WireFormat.FieldType.f36701q) {
            switch (AnonymousClass1.f36290a[generatedExtension.a().ordinal()]) {
                case 1:
                    objValueOf = Double.valueOf(reader.readDouble());
                    break;
                case 2:
                    objValueOf = Float.valueOf(reader.readFloat());
                    break;
                case 3:
                    objValueOf = Long.valueOf(reader.H());
                    break;
                case 4:
                    objValueOf = Long.valueOf(reader.s());
                    break;
                case 5:
                    objValueOf = Integer.valueOf(reader.p());
                    break;
                case 6:
                    objValueOf = Long.valueOf(reader.a());
                    break;
                case 7:
                    objValueOf = Integer.valueOf(reader.u());
                    break;
                case 8:
                    objValueOf = Boolean.valueOf(reader.e());
                    break;
                case 9:
                    objValueOf = Integer.valueOf(reader.h());
                    break;
                case 10:
                    objValueOf = Integer.valueOf(reader.E());
                    break;
                case 11:
                    objValueOf = Long.valueOf(reader.f());
                    break;
                case 12:
                    objValueOf = Integer.valueOf(reader.l());
                    break;
                case 13:
                    objValueOf = Long.valueOf(reader.y());
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    objValueOf = reader.o();
                    break;
                case 16:
                    objValueOf = reader.z();
                    break;
                case 17:
                    if (!generatedExtension.d()) {
                        Object objI2 = fieldSet.i(generatedExtension.f36406d);
                        if (objI2 instanceof GeneratedMessageLite) {
                            Schema schemaD = Protobuf.a().d(objI2);
                            if (!((GeneratedMessageLite) objI2).I()) {
                                Object objNewInstance = schemaD.newInstance();
                                schemaD.a(objNewInstance, objI2);
                                fieldSet.y(generatedExtension.f36406d, objNewInstance);
                                objI2 = objNewInstance;
                            }
                            reader.O(objI2, schemaD, extensionRegistryLite);
                            return obj3;
                        }
                    }
                    objValueOf = reader.M(generatedExtension.b().getClass(), extensionRegistryLite);
                    break;
                case 18:
                    if (!generatedExtension.d()) {
                        Object objI3 = fieldSet.i(generatedExtension.f36406d);
                        if (objI3 instanceof GeneratedMessageLite) {
                            Schema schemaD2 = Protobuf.a().d(objI3);
                            if (!((GeneratedMessageLite) objI3).I()) {
                                Object objNewInstance2 = schemaD2.newInstance();
                                schemaD2.a(objNewInstance2, objI3);
                                fieldSet.y(generatedExtension.f36406d, objNewInstance2);
                                objI3 = objNewInstance2;
                            }
                            reader.J(objI3, schemaD2, extensionRegistryLite);
                            return obj3;
                        }
                    }
                    objValueOf = reader.L(generatedExtension.b().getClass(), extensionRegistryLite);
                    break;
                default:
                    objValueOf = null;
                    break;
            }
        } else {
            int iP = reader.p();
            if (generatedExtension.f36406d.b().a(iP) == null) {
                return SchemaUtil.J(obj, iC, iP, obj3, unknownFieldSchema);
            }
            objValueOf = Integer.valueOf(iP);
        }
        if (generatedExtension.d()) {
            fieldSet.a(generatedExtension.f36406d, objValueOf);
            return obj3;
        }
        int i3 = AnonymousClass1.f36290a[generatedExtension.a().ordinal()];
        if ((i3 == 17 || i3 == 18) && (objI = fieldSet.i(generatedExtension.f36406d)) != null) {
            objValueOf = Internal.h(objI, objValueOf);
        }
        fieldSet.y(generatedExtension.f36406d, objValueOf);
        return obj3;
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    void h(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet) {
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        fieldSet.y(generatedExtension.f36406d, reader.L(generatedExtension.b().getClass(), extensionRegistryLite));
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    void i(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet) {
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        MessageLite.Builder builderE = generatedExtension.b().e();
        CodedInputStream codedInputStreamB = byteString.B();
        builderE.r(codedInputStreamB, extensionRegistryLite);
        fieldSet.y(generatedExtension.f36406d, builderE.f());
        codedInputStreamB.a(0);
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    void j(Writer writer, Map.Entry entry) {
        GeneratedMessageLite.ExtensionDescriptor extensionDescriptor = (GeneratedMessageLite.ExtensionDescriptor) entry.getKey();
        if (!extensionDescriptor.K()) {
            switch (AnonymousClass1.f36290a[extensionDescriptor.L().ordinal()]) {
                case 1:
                    writer.p(extensionDescriptor.J(), ((Double) entry.getValue()).doubleValue());
                    break;
                case 2:
                    writer.C(extensionDescriptor.J(), ((Float) entry.getValue()).floatValue());
                    break;
                case 3:
                    writer.v(extensionDescriptor.J(), ((Long) entry.getValue()).longValue());
                    break;
                case 4:
                    writer.f(extensionDescriptor.J(), ((Long) entry.getValue()).longValue());
                    break;
                case 5:
                    writer.h(extensionDescriptor.J(), ((Integer) entry.getValue()).intValue());
                    break;
                case 6:
                    writer.s(extensionDescriptor.J(), ((Long) entry.getValue()).longValue());
                    break;
                case 7:
                    writer.c(extensionDescriptor.J(), ((Integer) entry.getValue()).intValue());
                    break;
                case 8:
                    writer.w(extensionDescriptor.J(), ((Boolean) entry.getValue()).booleanValue());
                    break;
                case 9:
                    writer.o(extensionDescriptor.J(), ((Integer) entry.getValue()).intValue());
                    break;
                case 10:
                    writer.x(extensionDescriptor.J(), ((Integer) entry.getValue()).intValue());
                    break;
                case 11:
                    writer.i(extensionDescriptor.J(), ((Long) entry.getValue()).longValue());
                    break;
                case 12:
                    writer.I(extensionDescriptor.J(), ((Integer) entry.getValue()).intValue());
                    break;
                case 13:
                    writer.m(extensionDescriptor.J(), ((Long) entry.getValue()).longValue());
                    break;
                case 14:
                    writer.h(extensionDescriptor.J(), ((Integer) entry.getValue()).intValue());
                    break;
                case 15:
                    writer.L(extensionDescriptor.J(), (ByteString) entry.getValue());
                    break;
                case 16:
                    writer.e(extensionDescriptor.J(), (String) entry.getValue());
                    break;
                case 17:
                    writer.O(extensionDescriptor.J(), entry.getValue(), Protobuf.a().c(entry.getValue().getClass()));
                    break;
                case 18:
                    writer.M(extensionDescriptor.J(), entry.getValue(), Protobuf.a().c(entry.getValue().getClass()));
                    break;
            }
        }
        switch (AnonymousClass1.f36290a[extensionDescriptor.L().ordinal()]) {
            case 1:
                SchemaUtil.O(extensionDescriptor.J(), (List) entry.getValue(), writer, extensionDescriptor.N());
                break;
            case 2:
                SchemaUtil.S(extensionDescriptor.J(), (List) entry.getValue(), writer, extensionDescriptor.N());
                break;
            case 3:
                SchemaUtil.V(extensionDescriptor.J(), (List) entry.getValue(), writer, extensionDescriptor.N());
                break;
            case 4:
                SchemaUtil.d0(extensionDescriptor.J(), (List) entry.getValue(), writer, extensionDescriptor.N());
                break;
            case 5:
                SchemaUtil.U(extensionDescriptor.J(), (List) entry.getValue(), writer, extensionDescriptor.N());
                break;
            case 6:
                SchemaUtil.R(extensionDescriptor.J(), (List) entry.getValue(), writer, extensionDescriptor.N());
                break;
            case 7:
                SchemaUtil.Q(extensionDescriptor.J(), (List) entry.getValue(), writer, extensionDescriptor.N());
                break;
            case 8:
                SchemaUtil.M(extensionDescriptor.J(), (List) entry.getValue(), writer, extensionDescriptor.N());
                break;
            case 9:
                SchemaUtil.c0(extensionDescriptor.J(), (List) entry.getValue(), writer, extensionDescriptor.N());
                break;
            case 10:
                SchemaUtil.X(extensionDescriptor.J(), (List) entry.getValue(), writer, extensionDescriptor.N());
                break;
            case 11:
                SchemaUtil.Y(extensionDescriptor.J(), (List) entry.getValue(), writer, extensionDescriptor.N());
                break;
            case 12:
                SchemaUtil.Z(extensionDescriptor.J(), (List) entry.getValue(), writer, extensionDescriptor.N());
                break;
            case 13:
                SchemaUtil.a0(extensionDescriptor.J(), (List) entry.getValue(), writer, extensionDescriptor.N());
                break;
            case 14:
                SchemaUtil.U(extensionDescriptor.J(), (List) entry.getValue(), writer, extensionDescriptor.N());
                break;
            case 15:
                SchemaUtil.N(extensionDescriptor.J(), (List) entry.getValue(), writer);
                break;
            case 16:
                SchemaUtil.b0(extensionDescriptor.J(), (List) entry.getValue(), writer);
                break;
            case 17:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    SchemaUtil.T(extensionDescriptor.J(), (List) entry.getValue(), writer, Protobuf.a().c(list.get(0).getClass()));
                    break;
                }
                break;
            case 18:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    SchemaUtil.W(extensionDescriptor.J(), (List) entry.getValue(), writer, Protobuf.a().c(list2.get(0).getClass()));
                    break;
                }
                break;
        }
    }
}
