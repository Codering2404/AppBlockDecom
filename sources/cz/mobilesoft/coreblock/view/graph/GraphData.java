package cz.mobilesoft.coreblock.view.graph;

import android.content.Context;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class GraphData {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f132767h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f132768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f132769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Integer f132770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Float f132771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f132772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f132773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f132774g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AxisData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f132775a;

        public AxisData(String label) {
            Intrinsics.checkNotNullParameter(label, "label");
            this.f132775a = label;
        }

        public final String a() {
            return this.f132775a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AxisData) && Intrinsics.areEqual(this.f132775a, ((AxisData) obj).f132775a);
        }

        public int hashCode() {
            return this.f132775a.hashCode();
        }

        public String toString() {
            return "AxisData(label=" + this.f132775a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GraphValueData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f132776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f132777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f132778c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f132779d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f132780e;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class GraphValueSection {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final float f132781a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final AppDistractionType f132782b;

            public GraphValueSection(float f3, AppDistractionType appDistractionType) {
                Intrinsics.checkNotNullParameter(appDistractionType, "appDistractionType");
                this.f132781a = f3;
                this.f132782b = appDistractionType;
            }

            public final AppDistractionType a() {
                return this.f132782b;
            }

            public final float b() {
                return this.f132781a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof GraphValueSection)) {
                    return false;
                }
                GraphValueSection graphValueSection = (GraphValueSection) obj;
                return Float.compare(this.f132781a, graphValueSection.f132781a) == 0 && this.f132782b == graphValueSection.f132782b;
            }

            public int hashCode() {
                return (Float.hashCode(this.f132781a) * 31) + this.f132782b.hashCode();
            }

            public String toString() {
                return "GraphValueSection(value=" + this.f132781a + ", appDistractionType=" + this.f132782b + ")";
            }
        }

        public GraphValueData(long j3, String label, String fullLabel, List values) {
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(fullLabel, "fullLabel");
            Intrinsics.checkNotNullParameter(values, "values");
            this.f132776a = j3;
            this.f132777b = label;
            this.f132778c = fullLabel;
            this.f132779d = values;
            this.f132780e = DateHelperExtKt.f((long) (e() * 60), false, false, false, 14, null);
        }

        public final String a() {
            return this.f132780e;
        }

        public final String b() {
            return this.f132778c;
        }

        public final long c() {
            return this.f132776a;
        }

        public final String d() {
            return this.f132777b;
        }

        public final float e() {
            Iterator it = this.f132779d.iterator();
            double dB = 0.0d;
            while (it.hasNext()) {
                dB += (double) ((GraphValueSection) it.next()).b();
            }
            return (float) dB;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GraphValueData)) {
                return false;
            }
            GraphValueData graphValueData = (GraphValueData) obj;
            return this.f132776a == graphValueData.f132776a && Intrinsics.areEqual(this.f132777b, graphValueData.f132777b) && Intrinsics.areEqual(this.f132778c, graphValueData.f132778c) && Intrinsics.areEqual(this.f132779d, graphValueData.f132779d);
        }

        public final List f() {
            return this.f132779d;
        }

        public int hashCode() {
            return (((((Long.hashCode(this.f132776a) * 31) + this.f132777b.hashCode()) * 31) + this.f132778c.hashCode()) * 31) + this.f132779d.hashCode();
        }

        public String toString() {
            return "GraphValueData(intervalStart=" + this.f132776a + ", label=" + this.f132777b + ", fullLabel=" + this.f132778c + ", values=" + this.f132779d + ")";
        }
    }

    public GraphData(Context context, List graphValues, Integer num, Float f3, int i3, float f4, float f5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(graphValues, "graphValues");
        this.f132768a = context;
        this.f132769b = graphValues;
        this.f132770c = num;
        this.f132771d = f3;
        this.f132772e = i3;
        this.f132773f = f4;
        this.f132774g = f5;
    }

    public final Float a() {
        return this.f132771d;
    }

    public final List b() {
        return this.f132769b;
    }

    public final int c() {
        return this.f132772e;
    }

    public final float d() {
        return this.f132774g;
    }

    public final Integer e() {
        Object next;
        Iterator it = CollectionsKt.withIndex(this.f132769b).iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                float fE = ((GraphValueData) ((IndexedValue) next).getValue()).e();
                do {
                    Object next2 = it.next();
                    float fE2 = ((GraphValueData) ((IndexedValue) next2).getValue()).e();
                    if (Float.compare(fE, fE2) < 0) {
                        next = next2;
                        fE = fE2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        IndexedValue indexedValue = (IndexedValue) next;
        if (indexedValue != null) {
            return Integer.valueOf(indexedValue.getIndex());
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GraphData)) {
            return false;
        }
        GraphData graphData = (GraphData) obj;
        return Intrinsics.areEqual(this.f132768a, graphData.f132768a) && Intrinsics.areEqual(this.f132769b, graphData.f132769b) && Intrinsics.areEqual(this.f132770c, graphData.f132770c) && Intrinsics.areEqual((Object) this.f132771d, (Object) graphData.f132771d) && this.f132772e == graphData.f132772e && Float.compare(this.f132773f, graphData.f132773f) == 0 && Float.compare(this.f132774g, graphData.f132774g) == 0;
    }

    public final Integer f() {
        return this.f132770c;
    }

    public final GraphValueData g() {
        Integer num = this.f132770c;
        if (num == null) {
            return null;
        }
        return (GraphValueData) CollectionsKt.getOrNull(this.f132769b, num.intValue());
    }

    public final List h() {
        int i3 = this.f132772e;
        if (i3 < 0) {
            return CollectionsKt.emptyList();
        }
        float f3 = i3 > 0 ? this.f132774g / i3 : 0.0f;
        int i4 = i3 + 1;
        ArrayList arrayList = new ArrayList(i4);
        for (int i5 = 0; i5 < i4; i5++) {
            String strK = DateHelper.k(this.f132768a, (long) ((this.f132772e - i5) * f3 * 60 * 1000));
            Intrinsics.checkNotNullExpressionValue(strK, "getRemainingTimeOnlyString(...)");
            arrayList.add(new AxisData(strK));
        }
        return arrayList;
    }

    public int hashCode() {
        int iHashCode = ((this.f132768a.hashCode() * 31) + this.f132769b.hashCode()) * 31;
        Integer num = this.f132770c;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Float f3 = this.f132771d;
        return ((((((iHashCode2 + (f3 != null ? f3.hashCode() : 0)) * 31) + Integer.hashCode(this.f132772e)) * 31) + Float.hashCode(this.f132773f)) * 31) + Float.hashCode(this.f132774g);
    }

    public final void i(float f3) {
        this.f132774g = f3;
    }

    public final void j(Integer num) {
        this.f132770c = num;
    }

    public String toString() {
        return "GraphData(context=" + this.f132768a + ", graphValues=" + this.f132769b + ", selectedGraphValueIndex=" + this.f132770c + ", averageGraphValue=" + this.f132771d + ", horizontalAxisCount=" + this.f132772e + ", maximumGraphValue=" + this.f132773f + ", maximumChartValue=" + this.f132774g + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GraphData(Context context, List list, Integer num, Float f3, int i3, float f4, float f5, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        Float fValueOf = null;
        num = (i4 & 4) != 0 ? null : num;
        f3 = (i4 & 8) != 0 ? null : f3;
        i3 = (i4 & 16) != 0 ? 3 : i3;
        if ((i4 & 32) != 0) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                float fE = ((GraphValueData) it.next()).e();
                while (it.hasNext()) {
                    fE = Math.max(fE, ((GraphValueData) it.next()).e());
                }
                fValueOf = Float.valueOf(fE);
            }
            f4 = fValueOf != null ? fValueOf.floatValue() : 0.0f;
        }
        if ((i4 & 64) != 0) {
            if (i3 <= 0) {
                f5 = 0.0f;
            } else {
                f5 = ((float) Math.ceil(((f4 / r9) * 1.1f) / r11)) * 20 * i3;
            }
        }
        this(context, list, num, f3, i3, f4, f5);
    }
}
