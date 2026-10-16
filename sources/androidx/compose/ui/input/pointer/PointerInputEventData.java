package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PointerInputEventData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f26880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f26881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f26882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f26883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f26884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f26885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f26886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f26887h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f26888i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f26889j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f26890k;

    public /* synthetic */ PointerInputEventData(long j3, long j4, long j5, long j6, boolean z2, float f3, int i3, boolean z3, List list, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, z2, f3, i3, z3, list, j7, j8);
    }

    public final boolean a() {
        return this.f26887h;
    }

    public final boolean b() {
        return this.f26884e;
    }

    public final List c() {
        return this.f26888i;
    }

    public final long d() {
        return this.f26880a;
    }

    public final long e() {
        return this.f26890k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointerInputEventData)) {
            return false;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
        return PointerId.c(this.f26880a, pointerInputEventData.f26880a) && this.f26881b == pointerInputEventData.f26881b && Offset.j(this.f26882c, pointerInputEventData.f26882c) && Offset.j(this.f26883d, pointerInputEventData.f26883d) && this.f26884e == pointerInputEventData.f26884e && Float.compare(this.f26885f, pointerInputEventData.f26885f) == 0 && PointerType.h(this.f26886g, pointerInputEventData.f26886g) && this.f26887h == pointerInputEventData.f26887h && Intrinsics.areEqual(this.f26888i, pointerInputEventData.f26888i) && Offset.j(this.f26889j, pointerInputEventData.f26889j) && Offset.j(this.f26890k, pointerInputEventData.f26890k);
    }

    public final long f() {
        return this.f26883d;
    }

    public final long g() {
        return this.f26882c;
    }

    public final float h() {
        return this.f26885f;
    }

    public int hashCode() {
        return (((((((((((((((((((PointerId.d(this.f26880a) * 31) + Long.hashCode(this.f26881b)) * 31) + Offset.o(this.f26882c)) * 31) + Offset.o(this.f26883d)) * 31) + Boolean.hashCode(this.f26884e)) * 31) + Float.hashCode(this.f26885f)) * 31) + PointerType.i(this.f26886g)) * 31) + Boolean.hashCode(this.f26887h)) * 31) + this.f26888i.hashCode()) * 31) + Offset.o(this.f26889j)) * 31) + Offset.o(this.f26890k);
    }

    public final long i() {
        return this.f26889j;
    }

    public final int j() {
        return this.f26886g;
    }

    public final long k() {
        return this.f26881b;
    }

    public String toString() {
        return "PointerInputEventData(id=" + ((Object) PointerId.e(this.f26880a)) + ", uptime=" + this.f26881b + ", positionOnScreen=" + ((Object) Offset.s(this.f26882c)) + ", position=" + ((Object) Offset.s(this.f26883d)) + ", down=" + this.f26884e + ", pressure=" + this.f26885f + ", type=" + ((Object) PointerType.j(this.f26886g)) + ", activeHover=" + this.f26887h + ", historical=" + this.f26888i + ", scrollDelta=" + ((Object) Offset.s(this.f26889j)) + ", originalEventPosition=" + ((Object) Offset.s(this.f26890k)) + ')';
    }

    private PointerInputEventData(long j3, long j4, long j5, long j6, boolean z2, float f3, int i3, boolean z3, List list, long j7, long j8) {
        this.f26880a = j3;
        this.f26881b = j4;
        this.f26882c = j5;
        this.f26883d = j6;
        this.f26884e = z2;
        this.f26885f = f3;
        this.f26886g = i3;
        this.f26887h = z3;
        this.f26888i = list;
        this.f26889j = j7;
        this.f26890k = j8;
    }
}
