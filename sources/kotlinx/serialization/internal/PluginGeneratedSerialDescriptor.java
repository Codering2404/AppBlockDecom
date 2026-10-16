package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

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
public class PluginGeneratedSerialDescriptor implements SerialDescriptor, CachedNames {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f142863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GeneratedSerializer f142864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f142865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f142866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String[] f142867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List[] f142868f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f142869g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean[] f142870h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map f142871i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f142872j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f142873k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f142874l;

    public PluginGeneratedSerialDescriptor(String serialName, GeneratedSerializer generatedSerializer, int i3) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        this.f142863a = serialName;
        this.f142864b = generatedSerializer;
        this.f142865c = i3;
        this.f142866d = -1;
        String[] strArr = new String[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            strArr[i4] = "[UNINITIALIZED]";
        }
        this.f142867e = strArr;
        int i5 = this.f142865c;
        this.f142868f = new List[i5];
        this.f142870h = new boolean[i5];
        this.f142871i = MapsKt.emptyMap();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139762b;
        this.f142872j = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: kotlinx.serialization.internal.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PluginGeneratedSerialDescriptor.s(this.f142938a);
            }
        });
        this.f142873k = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: kotlinx.serialization.internal.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PluginGeneratedSerialDescriptor.z(this.f142939a);
            }
        });
        this.f142874l = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: kotlinx.serialization.internal.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(PluginGeneratedSerialDescriptor.o(this.f142940a));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        return PluginGeneratedSerialDescriptorKt.a(pluginGeneratedSerialDescriptor, pluginGeneratedSerialDescriptor.u());
    }

    public static /* synthetic */ void q(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, String str, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
        }
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        pluginGeneratedSerialDescriptor.p(str, z2);
    }

    private final Map r() {
        HashMap map = new HashMap();
        int length = this.f142867e.length;
        for (int i3 = 0; i3 < length; i3++) {
            map.put(this.f142867e[i3], Integer.valueOf(i3));
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer[] s(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        KSerializer[] kSerializerArrChildSerializers;
        GeneratedSerializer generatedSerializer = pluginGeneratedSerialDescriptor.f142864b;
        return (generatedSerializer == null || (kSerializerArrChildSerializers = generatedSerializer.childSerializers()) == null) ? PluginHelperInterfacesKt.f142875a : kSerializerArrChildSerializers;
    }

    private final KSerializer[] t() {
        return (KSerializer[]) this.f142872j.getValue();
    }

    private final int v() {
        return ((Number) this.f142874l.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence y(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, int i3) {
        return pluginGeneratedSerialDescriptor.f(i3) + ": " + pluginGeneratedSerialDescriptor.h(i3).i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor[] z(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        ArrayList arrayList;
        KSerializer[] kSerializerArrTypeParametersSerializers;
        GeneratedSerializer generatedSerializer = pluginGeneratedSerialDescriptor.f142864b;
        if (generatedSerializer == null || (kSerializerArrTypeParametersSerializers = generatedSerializer.typeParametersSerializers()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(kSerializerArrTypeParametersSerializers.length);
            for (KSerializer kSerializer : kSerializerArrTypeParametersSerializers) {
                arrayList.add(kSerializer.getDescriptor());
            }
        }
        return Platform_commonKt.b(arrayList);
    }

    @Override // kotlinx.serialization.internal.CachedNames
    public Set a() {
        return this.f142871i.keySet();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return SerialDescriptor.DefaultImpls.c(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer num = (Integer) this.f142871i.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind d() {
        return StructureKind.CLASS.f142753a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int e() {
        return this.f142865c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PluginGeneratedSerialDescriptor)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
        if (!Intrinsics.areEqual(i(), serialDescriptor.i()) || !Arrays.equals(u(), ((PluginGeneratedSerialDescriptor) obj).u()) || e() != serialDescriptor.e()) {
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
        return this.f142867e[i3];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List g(int i3) {
        List list = this.f142868f[i3];
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List getAnnotations() {
        List list = this.f142869g;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i3) {
        return t()[i3].getDescriptor();
    }

    public int hashCode() {
        return v();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String i() {
        return this.f142863a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.b(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean j(int i3) {
        return this.f142870h[i3];
    }

    public final void p(String name, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        String[] strArr = this.f142867e;
        int i3 = this.f142866d + 1;
        this.f142866d = i3;
        strArr[i3] = name;
        this.f142870h[i3] = z2;
        this.f142868f[i3] = null;
        if (i3 == this.f142865c - 1) {
            this.f142871i = r();
        }
    }

    public String toString() {
        return CollectionsKt.joinToString$default(RangesKt.B(0, this.f142865c), ", ", i() + '(', ")", 0, null, new Function1() { // from class: kotlinx.serialization.internal.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PluginGeneratedSerialDescriptor.y(this.f142937a, ((Integer) obj).intValue());
            }
        }, 24, null);
    }

    public final SerialDescriptor[] u() {
        return (SerialDescriptor[]) this.f142873k.getValue();
    }

    public final void w(Annotation annotation) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        List arrayList = this.f142868f[this.f142866d];
        if (arrayList == null) {
            arrayList = new ArrayList(1);
            this.f142868f[this.f142866d] = arrayList;
        }
        arrayList.add(annotation);
    }

    public final void x(Annotation a3) {
        Intrinsics.checkNotNullParameter(a3, "a");
        if (this.f142869g == null) {
            this.f142869g = new ArrayList(1);
        }
        List list = this.f142869g;
        Intrinsics.checkNotNull(list);
        list.add(a3);
    }

    public /* synthetic */ PluginGeneratedSerialDescriptor(String str, GeneratedSerializer generatedSerializer, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i4 & 2) != 0 ? null : generatedSerializer, i3);
    }
}
