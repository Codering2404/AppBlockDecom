package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class JsonPath {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object[] f143098a = new Object[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f143099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f143100c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Tombstone {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Tombstone f143101a = new Tombstone();

        private Tombstone() {
        }
    }

    public JsonPath() {
        int[] iArr = new int[8];
        for (int i3 = 0; i3 < 8; i3++) {
            iArr[i3] = -1;
        }
        this.f143099b = iArr;
        this.f143100c = -1;
    }

    private final void e() {
        int i3 = this.f143100c * 2;
        Object[] objArrCopyOf = Arrays.copyOf(this.f143098a, i3);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        this.f143098a = objArrCopyOf;
        int[] iArrCopyOf = Arrays.copyOf(this.f143099b, i3);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        this.f143099b = iArrCopyOf;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("$");
        int i3 = this.f143100c + 1;
        for (int i4 = 0; i4 < i3; i4++) {
            Object obj = this.f143098a[i4];
            if (obj instanceof SerialDescriptor) {
                SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
                if (!Intrinsics.areEqual(serialDescriptor.d(), StructureKind.LIST.f142754a)) {
                    int i5 = this.f143099b[i4];
                    if (i5 >= 0) {
                        sb.append(".");
                        sb.append(serialDescriptor.f(i5));
                    }
                } else if (this.f143099b[i4] != -1) {
                    sb.append("[");
                    sb.append(this.f143099b[i4]);
                    sb.append("]");
                }
            } else if (obj != Tombstone.f143101a) {
                sb.append("[");
                sb.append("'");
                sb.append(obj);
                sb.append("'");
                sb.append("]");
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void b() {
        int i3 = this.f143100c;
        int[] iArr = this.f143099b;
        if (iArr[i3] == -2) {
            iArr[i3] = -1;
            this.f143100c = i3 - 1;
        }
        int i4 = this.f143100c;
        if (i4 != -1) {
            this.f143100c = i4 - 1;
        }
    }

    public final void c(SerialDescriptor sd) {
        Intrinsics.checkNotNullParameter(sd, "sd");
        int i3 = this.f143100c + 1;
        this.f143100c = i3;
        if (i3 == this.f143098a.length) {
            e();
        }
        this.f143098a[i3] = sd;
    }

    public final void d() {
        int[] iArr = this.f143099b;
        int i3 = this.f143100c;
        if (iArr[i3] == -2) {
            this.f143098a[i3] = Tombstone.f143101a;
        }
    }

    public final void f(Object obj) {
        int[] iArr = this.f143099b;
        int i3 = this.f143100c;
        if (iArr[i3] != -2) {
            int i4 = i3 + 1;
            this.f143100c = i4;
            if (i4 == this.f143098a.length) {
                e();
            }
        }
        Object[] objArr = this.f143098a;
        int i5 = this.f143100c;
        objArr[i5] = obj;
        this.f143099b[i5] = -2;
    }

    public final void g(int i3) {
        this.f143099b[this.f143100c] = i3;
    }

    public String toString() {
        return a();
    }
}
