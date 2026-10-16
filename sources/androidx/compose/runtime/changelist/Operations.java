package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.changelist.Operation;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class Operations extends OperationsDebugStringFormattable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f24373b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f24375d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f24377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f24378g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Operation[] f24372a = new Operation[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f24374c = new int[16];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object[] f24376e = new Object[16];

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class OpIterator implements OperationArgContainer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f24379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f24380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f24381c;

        public OpIterator() {
        }

        @Override // androidx.compose.runtime.changelist.OperationArgContainer
        public Object a(int i3) {
            return Operations.this.f24376e[this.f24381c + i3];
        }

        public final Operation b() {
            return Operations.this.f24372a[this.f24379a];
        }

        public final boolean c() {
            if (this.f24379a >= Operations.this.f24373b) {
                return false;
            }
            Operation operationB = b();
            this.f24380b += operationB.b();
            this.f24381c += operationB.d();
            int i3 = this.f24379a + 1;
            this.f24379a = i3;
            return i3 < Operations.this.f24373b;
        }

        @Override // androidx.compose.runtime.changelist.OperationArgContainer
        public int getInt(int i3) {
            return Operations.this.f24374c[this.f24380b + i3];
        }
    }

    private final String d(OpIterator opIterator, String str) {
        Operation operationB = opIterator.b();
        if (operationB.b() == 0 && operationB.d() == 0) {
            return operationB.c();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(operationB.c());
        sb.append('(');
        String strJ = j(str);
        int iB = operationB.b();
        boolean z2 = true;
        for (int i3 = 0; i3 < iB; i3++) {
            String strE = operationB.e(i3);
            if (z2) {
                z2 = false;
            } else {
                sb.append(", ");
            }
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(strJ);
            sb.append(strE);
            sb.append(" = ");
            sb.append(opIterator.getInt(i3));
        }
        int iD = operationB.d();
        for (int i4 = 0; i4 < iD; i4++) {
            int iA = Operation.ObjectParameter.a(i4);
            String strF = operationB.f(iA);
            if (z2) {
                z2 = false;
            } else {
                sb.append(", ");
            }
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(strJ);
            sb.append(strF);
            sb.append(" = ");
            sb.append(h(opIterator.a(iA), strJ));
        }
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append(str);
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final int e(int i3, int i4) {
        return RangesKt.f(i3 + RangesKt.k(i3, 1024), i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h(Object obj, String str) {
        return obj == null ? "null" : obj instanceof Object[] ? s(ArraysKt.asIterable((Object[]) obj), str) : obj instanceof int[] ? s(ArraysKt.asIterable((int[]) obj), str) : obj instanceof long[] ? s(ArraysKt.asIterable((long[]) obj), str) : obj instanceof float[] ? s(ArraysKt.asIterable((float[]) obj), str) : obj instanceof double[] ? s(ArraysKt.asIterable((double[]) obj), str) : obj instanceof Iterable ? s((Iterable) obj, str) : obj instanceof OperationsDebugStringFormattable ? ((OperationsDebugStringFormattable) obj).a(str) : obj.toString();
    }

    private final String j(String str) {
        return str + "    ";
    }

    private final void p(int i3, int i4) {
        int[] iArr = new int[e(i3, i4)];
        ArraysKt.copyInto(this.f24374c, iArr, 0, 0, i3);
        this.f24374c = iArr;
    }

    private final void q(int i3, int i4) {
        Object[] objArr = new Object[e(i3, i4)];
        System.arraycopy(this.f24376e, 0, objArr, 0, i3);
        this.f24376e = objArr;
    }

    private final void r() {
        int iK = RangesKt.k(this.f24373b, 1024);
        int i3 = this.f24373b;
        Operation[] operationArr = new Operation[iK + i3];
        System.arraycopy(this.f24372a, 0, operationArr, 0, i3);
        this.f24372a = operationArr;
    }

    private final String s(Iterable iterable, final String str) {
        return CollectionsKt.joinToString$default(iterable, ", ", "[", "]", 0, null, new Function1<Object, CharSequence>() { // from class: androidx.compose.runtime.changelist.Operations$toCollectionString$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(Object obj) {
                return this.f24384a.h(obj, str);
            }
        }, 24, null);
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        if (l()) {
            OpIterator opIterator = new OpIterator();
            int i3 = 0;
            while (true) {
                sb.append(str);
                int i4 = i3 + 1;
                sb.append(i3);
                sb.append(". ");
                sb.append(d(opIterator, str));
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
                sb.append('\n');
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
                if (!opIterator.c()) {
                    break;
                }
                i3 = i4;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void c() {
        this.f24373b = 0;
        this.f24375d = 0;
        ArraysKt.fill(this.f24376e, (Object) null, 0, this.f24377f);
        this.f24377f = 0;
    }

    public final void f(Operation operation) {
        int i3 = this.f24378g;
        int iB = operation.b();
        if (i3 == ((iB == 0 ? 0 : -1) >>> (32 - iB))) {
            operation.d();
        }
    }

    public final void g(Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
        if (l()) {
            OpIterator opIterator = new OpIterator();
            do {
                opIterator.b().a(opIterator, applier, slotWriter, rememberManager);
            } while (opIterator.c());
        }
        c();
    }

    public final int i() {
        return this.f24373b;
    }

    public final boolean k() {
        return i() == 0;
    }

    public final boolean l() {
        return i() != 0;
    }

    public final void m(Operations operations) {
        Operation[] operationArr = this.f24372a;
        int i3 = this.f24373b - 1;
        this.f24373b = i3;
        Operation operation = operationArr[i3];
        operationArr[i3] = null;
        operations.o(operation);
        Object[] objArr = this.f24376e;
        Object[] objArr2 = operations.f24376e;
        int iD = operations.f24377f - operation.d();
        int iD2 = this.f24377f - operation.d();
        System.arraycopy(objArr, iD2, objArr2, iD, this.f24377f - iD2);
        ArraysKt.fill(this.f24376e, (Object) null, this.f24377f - operation.d(), this.f24377f);
        ArraysKt.copyInto(this.f24374c, operations.f24374c, operations.f24375d - operation.b(), this.f24375d - operation.b(), this.f24375d);
        this.f24377f -= operation.d();
        this.f24375d -= operation.b();
    }

    public final void n(Operation operation) {
        o(operation);
    }

    public final void o(Operation operation) {
        if (this.f24373b == this.f24372a.length) {
            r();
        }
        int iB = this.f24375d + operation.b();
        int length = this.f24374c.length;
        if (iB > length) {
            p(length, iB);
        }
        int iD = this.f24377f + operation.d();
        int length2 = this.f24376e.length;
        if (iD > length2) {
            q(length2, iD);
        }
        Operation[] operationArr = this.f24372a;
        int i3 = this.f24373b;
        this.f24373b = i3 + 1;
        operationArr[i3] = operation;
        this.f24375d += operation.b();
        this.f24377f += operation.d();
    }

    public String toString() {
        return super.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class WriteScope {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Operations f24383a;

        public static boolean b(Operations operations, Object obj) {
            return (obj instanceof WriteScope) && Intrinsics.areEqual(operations, ((WriteScope) obj).i());
        }

        public static int c(Operations operations) {
            return operations.hashCode();
        }

        public static final void d(Operations operations, int i3, Object obj) {
            operations.f24376e[(operations.f24377f - operations.f24372a[operations.f24373b - 1].d()) + i3] = obj;
        }

        public static final void e(Operations operations, int i3, Object obj, int i4, Object obj2) {
            int iD = operations.f24377f - operations.f24372a[operations.f24373b - 1].d();
            Object[] objArr = operations.f24376e;
            objArr[i3 + iD] = obj;
            objArr[iD + i4] = obj2;
        }

        public static final void f(Operations operations, int i3, Object obj, int i4, Object obj2, int i5, Object obj3, int i6, Object obj4) {
            int iD = operations.f24377f - operations.f24372a[operations.f24373b - 1].d();
            Object[] objArr = operations.f24376e;
            objArr[i3 + iD] = obj;
            objArr[i4 + iD] = obj2;
            objArr[i5 + iD] = obj3;
            objArr[iD + i6] = obj4;
        }

        public static final void g(Operations operations, int i3, Object obj, int i4, Object obj2, int i5, Object obj3) {
            int iD = operations.f24377f - operations.f24372a[operations.f24373b - 1].d();
            Object[] objArr = operations.f24376e;
            objArr[i3 + iD] = obj;
            objArr[i4 + iD] = obj2;
            objArr[iD + i5] = obj3;
        }

        public static String h(Operations operations) {
            return "WriteScope(stack=" + operations + ')';
        }

        public boolean equals(Object obj) {
            return b(this.f24383a, obj);
        }

        public int hashCode() {
            return c(this.f24383a);
        }

        public final /* synthetic */ Operations i() {
            return this.f24383a;
        }

        public String toString() {
            return h(this.f24383a);
        }

        public static Operations a(Operations operations) {
            return operations;
        }
    }
}
