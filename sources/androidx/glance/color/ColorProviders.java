package androidx.glance.color;

import androidx.glance.unit.ColorProvider;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class ColorProviders {
    public static final int A = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ColorProvider f39387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorProvider f39388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ColorProvider f39389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ColorProvider f39390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ColorProvider f39391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ColorProvider f39392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ColorProvider f39393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ColorProvider f39394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ColorProvider f39395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ColorProvider f39396j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ColorProvider f39397k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ColorProvider f39398l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ColorProvider f39399m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ColorProvider f39400n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ColorProvider f39401o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ColorProvider f39402p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ColorProvider f39403q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final ColorProvider f39404r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ColorProvider f39405s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ColorProvider f39406t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final ColorProvider f39407u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final ColorProvider f39408v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final ColorProvider f39409w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final ColorProvider f39410x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final ColorProvider f39411y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final ColorProvider f39412z;

    public /* synthetic */ ColorProviders(ColorProvider colorProvider, ColorProvider colorProvider2, ColorProvider colorProvider3, ColorProvider colorProvider4, ColorProvider colorProvider5, ColorProvider colorProvider6, ColorProvider colorProvider7, ColorProvider colorProvider8, ColorProvider colorProvider9, ColorProvider colorProvider10, ColorProvider colorProvider11, ColorProvider colorProvider12, ColorProvider colorProvider13, ColorProvider colorProvider14, ColorProvider colorProvider15, ColorProvider colorProvider16, ColorProvider colorProvider17, ColorProvider colorProvider18, ColorProvider colorProvider19, ColorProvider colorProvider20, ColorProvider colorProvider21, ColorProvider colorProvider22, ColorProvider colorProvider23, ColorProvider colorProvider24, ColorProvider colorProvider25, ColorProvider colorProvider26, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorProvider, colorProvider2, colorProvider3, colorProvider4, colorProvider5, colorProvider6, colorProvider7, colorProvider8, colorProvider9, colorProvider10, colorProvider11, colorProvider12, colorProvider13, colorProvider14, colorProvider15, colorProvider16, colorProvider17, colorProvider18, colorProvider19, colorProvider20, colorProvider21, colorProvider22, colorProvider23, colorProvider24, colorProvider25, colorProvider26);
    }

    public final ColorProvider a() {
        return this.f39403q;
    }

    public final ColorProvider b() {
        return this.f39404r;
    }

    public final ColorProvider c() {
        return this.f39388b;
    }

    public final ColorProvider d() {
        return this.f39406t;
    }

    public final ColorProvider e() {
        return this.f39408v;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.glance.color.ColorProviders");
        ColorProviders colorProviders = (ColorProviders) obj;
        return Intrinsics.areEqual(this.f39387a, colorProviders.f39387a) && Intrinsics.areEqual(this.f39388b, colorProviders.f39388b) && Intrinsics.areEqual(this.f39389c, colorProviders.f39389c) && Intrinsics.areEqual(this.f39390d, colorProviders.f39390d) && Intrinsics.areEqual(this.f39391e, colorProviders.f39391e) && Intrinsics.areEqual(this.f39392f, colorProviders.f39392f) && Intrinsics.areEqual(this.f39393g, colorProviders.f39393g) && Intrinsics.areEqual(this.f39394h, colorProviders.f39394h) && Intrinsics.areEqual(this.f39395i, colorProviders.f39395i) && Intrinsics.areEqual(this.f39396j, colorProviders.f39396j) && Intrinsics.areEqual(this.f39397k, colorProviders.f39397k) && Intrinsics.areEqual(this.f39398l, colorProviders.f39398l) && Intrinsics.areEqual(this.f39399m, colorProviders.f39399m) && Intrinsics.areEqual(this.f39400n, colorProviders.f39400n) && Intrinsics.areEqual(this.f39401o, colorProviders.f39401o) && Intrinsics.areEqual(this.f39402p, colorProviders.f39402p) && Intrinsics.areEqual(this.f39403q, colorProviders.f39403q) && Intrinsics.areEqual(this.f39404r, colorProviders.f39404r) && Intrinsics.areEqual(this.f39405s, colorProviders.f39405s) && Intrinsics.areEqual(this.f39406t, colorProviders.f39406t) && Intrinsics.areEqual(this.f39407u, colorProviders.f39407u) && Intrinsics.areEqual(this.f39408v, colorProviders.f39408v) && Intrinsics.areEqual(this.f39409w, colorProviders.f39409w) && Intrinsics.areEqual(this.f39410x, colorProviders.f39410x) && Intrinsics.areEqual(this.f39411y, colorProviders.f39411y) && Intrinsics.areEqual(this.f39412z, colorProviders.f39412z);
    }

    public final ColorProvider f() {
        return this.f39409w;
    }

    public final ColorProvider g() {
        return this.f39387a;
    }

    public final ColorProvider h() {
        return this.f39391e;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((this.f39387a.hashCode() * 31) + this.f39388b.hashCode()) * 31) + this.f39389c.hashCode()) * 31) + this.f39390d.hashCode()) * 31) + this.f39391e.hashCode()) * 31) + this.f39392f.hashCode()) * 31) + this.f39393g.hashCode()) * 31) + this.f39394h.hashCode()) * 31) + this.f39395i.hashCode()) * 31) + this.f39396j.hashCode()) * 31) + this.f39397k.hashCode()) * 31) + this.f39398l.hashCode()) * 31) + this.f39399m.hashCode()) * 31) + this.f39400n.hashCode()) * 31) + this.f39401o.hashCode()) * 31) + this.f39402p.hashCode()) * 31) + this.f39403q.hashCode()) * 31) + this.f39404r.hashCode()) * 31) + this.f39405s.hashCode()) * 31) + this.f39406t.hashCode()) * 31) + this.f39407u.hashCode()) * 31) + this.f39408v.hashCode()) * 31) + this.f39409w.hashCode()) * 31) + this.f39410x.hashCode()) * 31) + this.f39411y.hashCode()) * 31) + this.f39412z.hashCode();
    }

    public final ColorProvider i() {
        return this.f39393g;
    }

    public final ColorProvider j() {
        return this.f39405s;
    }

    public final ColorProvider k() {
        return this.f39407u;
    }

    public final ColorProvider l() {
        return this.f39395i;
    }

    public String toString() {
        return "ColorProviders(primary=" + this.f39387a + ", onPrimary=" + this.f39388b + ", primaryContainer=" + this.f39389c + ", onPrimaryContainer=" + this.f39390d + ", secondary=" + this.f39391e + ", onSecondary=" + this.f39392f + ", secondaryContainer=" + this.f39393g + ", onSecondaryContainer=" + this.f39394h + ", tertiary=" + this.f39395i + ", onTertiary=" + this.f39396j + ", tertiaryContainer=" + this.f39397k + ", onTertiaryContainer=" + this.f39398l + ", error=" + this.f39399m + ", errorContainer=" + this.f39400n + ", onError=" + this.f39401o + ", onErrorContainer=" + this.f39402p + ", background=" + this.f39403q + ", onBackground=" + this.f39404r + ", surface=" + this.f39405s + ", onSurface=" + this.f39406t + ", surfaceVariant=" + this.f39407u + ", onSurfaceVariant=" + this.f39408v + ", outline=" + this.f39409w + ", inverseOnSurface=" + this.f39410x + ", inverseSurface=" + this.f39411y + ", inversePrimary=" + this.f39412z + ')';
    }

    private ColorProviders(ColorProvider colorProvider, ColorProvider colorProvider2, ColorProvider colorProvider3, ColorProvider colorProvider4, ColorProvider colorProvider5, ColorProvider colorProvider6, ColorProvider colorProvider7, ColorProvider colorProvider8, ColorProvider colorProvider9, ColorProvider colorProvider10, ColorProvider colorProvider11, ColorProvider colorProvider12, ColorProvider colorProvider13, ColorProvider colorProvider14, ColorProvider colorProvider15, ColorProvider colorProvider16, ColorProvider colorProvider17, ColorProvider colorProvider18, ColorProvider colorProvider19, ColorProvider colorProvider20, ColorProvider colorProvider21, ColorProvider colorProvider22, ColorProvider colorProvider23, ColorProvider colorProvider24, ColorProvider colorProvider25, ColorProvider colorProvider26) {
        this.f39387a = colorProvider;
        this.f39388b = colorProvider2;
        this.f39389c = colorProvider3;
        this.f39390d = colorProvider4;
        this.f39391e = colorProvider5;
        this.f39392f = colorProvider6;
        this.f39393g = colorProvider7;
        this.f39394h = colorProvider8;
        this.f39395i = colorProvider9;
        this.f39396j = colorProvider10;
        this.f39397k = colorProvider11;
        this.f39398l = colorProvider12;
        this.f39399m = colorProvider13;
        this.f39400n = colorProvider14;
        this.f39401o = colorProvider15;
        this.f39402p = colorProvider16;
        this.f39403q = colorProvider17;
        this.f39404r = colorProvider18;
        this.f39405s = colorProvider19;
        this.f39406t = colorProvider20;
        this.f39407u = colorProvider21;
        this.f39408v = colorProvider22;
        this.f39409w = colorProvider23;
        this.f39410x = colorProvider24;
        this.f39411y = colorProvider25;
        this.f39412z = colorProvider26;
    }
}
