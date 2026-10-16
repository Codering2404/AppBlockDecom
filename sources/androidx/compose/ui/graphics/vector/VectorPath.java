package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
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
public final class VectorPath extends VectorNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f26551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f26552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f26553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Brush f26554d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f26555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Brush f26556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f26557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f26558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f26559j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f26560k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final float f26561l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final float f26562m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final float f26563n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final float f26564o;

    public /* synthetic */ VectorPath(String str, List list, int i3, Brush brush, float f3, Brush brush2, float f4, float f5, int i4, int i5, float f6, float f7, float f8, float f9, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, i3, brush, f3, brush2, f4, f5, i4, i5, f6, f7, f8, f9);
    }

    public final Brush a() {
        return this.f26554d;
    }

    public final float b() {
        return this.f26555f;
    }

    public final String d() {
        return this.f26551a;
    }

    public final List e() {
        return this.f26552b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && VectorPath.class == obj.getClass()) {
            VectorPath vectorPath = (VectorPath) obj;
            return Intrinsics.areEqual(this.f26551a, vectorPath.f26551a) && Intrinsics.areEqual(this.f26554d, vectorPath.f26554d) && this.f26555f == vectorPath.f26555f && Intrinsics.areEqual(this.f26556g, vectorPath.f26556g) && this.f26557h == vectorPath.f26557h && this.f26558i == vectorPath.f26558i && StrokeCap.g(this.f26559j, vectorPath.f26559j) && StrokeJoin.g(this.f26560k, vectorPath.f26560k) && this.f26561l == vectorPath.f26561l && this.f26562m == vectorPath.f26562m && this.f26563n == vectorPath.f26563n && this.f26564o == vectorPath.f26564o && PathFillType.f(this.f26553c, vectorPath.f26553c) && Intrinsics.areEqual(this.f26552b, vectorPath.f26552b);
        }
        return false;
    }

    public final int f() {
        return this.f26553c;
    }

    public final Brush g() {
        return this.f26556g;
    }

    public final float h() {
        return this.f26557h;
    }

    public int hashCode() {
        int iHashCode = ((this.f26551a.hashCode() * 31) + this.f26552b.hashCode()) * 31;
        Brush brush = this.f26554d;
        int iHashCode2 = (((iHashCode + (brush != null ? brush.hashCode() : 0)) * 31) + Float.hashCode(this.f26555f)) * 31;
        Brush brush2 = this.f26556g;
        return ((((((((((((((((((iHashCode2 + (brush2 != null ? brush2.hashCode() : 0)) * 31) + Float.hashCode(this.f26557h)) * 31) + Float.hashCode(this.f26558i)) * 31) + StrokeCap.h(this.f26559j)) * 31) + StrokeJoin.h(this.f26560k)) * 31) + Float.hashCode(this.f26561l)) * 31) + Float.hashCode(this.f26562m)) * 31) + Float.hashCode(this.f26563n)) * 31) + Float.hashCode(this.f26564o)) * 31) + PathFillType.g(this.f26553c);
    }

    public final int l() {
        return this.f26559j;
    }

    public final int n() {
        return this.f26560k;
    }

    public final float o() {
        return this.f26561l;
    }

    public final float p() {
        return this.f26558i;
    }

    public final float q() {
        return this.f26563n;
    }

    public final float s() {
        return this.f26564o;
    }

    public final float t() {
        return this.f26562m;
    }

    private VectorPath(String str, List list, int i3, Brush brush, float f3, Brush brush2, float f4, float f5, int i4, int i5, float f6, float f7, float f8, float f9) {
        super(null);
        this.f26551a = str;
        this.f26552b = list;
        this.f26553c = i3;
        this.f26554d = brush;
        this.f26555f = f3;
        this.f26556g = brush2;
        this.f26557h = f4;
        this.f26558i = f5;
        this.f26559j = i4;
        this.f26560k = i5;
        this.f26561l = f6;
        this.f26562m = f7;
        this.f26563n = f8;
        this.f26564o = f9;
    }
}
