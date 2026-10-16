package kotlinx.serialization.descriptors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.CachedNames;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptorKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class SerialDescriptorImpl implements SerialDescriptor, CachedNames {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f142733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SerialKind f142734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f142735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f142736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f142737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String[] f142738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SerialDescriptor[] f142739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List[] f142740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean[] f142741i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f142742j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final SerialDescriptor[] f142743k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f142744l;

    public SerialDescriptorImpl(String serialName, SerialKind kind, int i3, List typeParameters, ClassSerialDescriptorBuilder builder) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f142733a = serialName;
        this.f142734b = kind;
        this.f142735c = i3;
        this.f142736d = builder.c();
        this.f142737e = CollectionsKt.toHashSet(builder.f());
        String[] strArr = (String[]) builder.f().toArray(new String[0]);
        this.f142738f = strArr;
        this.f142739g = Platform_commonKt.b(builder.e());
        this.f142740h = (List[]) builder.d().toArray(new List[0]);
        this.f142741i = CollectionsKt.toBooleanArray(builder.g());
        Iterable<IndexedValue> iterableWithIndex = ArraysKt.withIndex(strArr);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableWithIndex, 10));
        for (IndexedValue indexedValue : iterableWithIndex) {
            arrayList.add(TuplesKt.a(indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex())));
        }
        this.f142742j = MapsKt.toMap(arrayList);
        this.f142743k = Platform_commonKt.b(typeParameters);
        this.f142744l = LazyKt.b(new Function0() { // from class: kotlinx.serialization.descriptors.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(SerialDescriptorImpl.m(this.f142759a));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m(SerialDescriptorImpl serialDescriptorImpl) {
        return PluginGeneratedSerialDescriptorKt.a(serialDescriptorImpl, serialDescriptorImpl.f142743k);
    }

    private final int n() {
        return ((Number) this.f142744l.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence o(SerialDescriptorImpl serialDescriptorImpl, int i3) {
        return serialDescriptorImpl.f(i3) + ": " + serialDescriptorImpl.h(i3).i();
    }

    @Override // kotlinx.serialization.internal.CachedNames
    public Set a() {
        return this.f142737e;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return SerialDescriptor.DefaultImpls.c(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer num = (Integer) this.f142742j.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind d() {
        return this.f142734b;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int e() {
        return this.f142735c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SerialDescriptorImpl)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
        if (!Intrinsics.areEqual(i(), serialDescriptor.i()) || !Arrays.equals(this.f142743k, ((SerialDescriptorImpl) obj).f142743k) || e() != serialDescriptor.e()) {
            return false;
        }
        int iE = e();
        for (int i3 = 0; i3 < iE; i3++) {
            if (!Intrinsics.areEqual(h(i3).i(), serialDescriptor.h(i3).i()) || !Intrinsics.areEqual(h(i3).d(), serialDescriptor.h(i3).d())) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String f(int i3) {
        return this.f142738f[i3];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List g(int i3) {
        return this.f142740h[i3];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List getAnnotations() {
        return this.f142736d;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i3) {
        return this.f142739g[i3];
    }

    public int hashCode() {
        return n();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String i() {
        return this.f142733a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.b(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean j(int i3) {
        return this.f142741i[i3];
    }

    public String toString() {
        return CollectionsKt.joinToString$default(RangesKt.B(0, e()), ", ", i() + '(', ")", 0, null, new Function1() { // from class: kotlinx.serialization.descriptors.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SerialDescriptorImpl.o(this.f142760a, ((Integer) obj).intValue());
            }
        }, 24, null);
    }
}
