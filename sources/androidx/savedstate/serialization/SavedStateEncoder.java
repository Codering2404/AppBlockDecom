package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.modules.SerializersModule;

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
public final class SavedStateEncoder extends AbstractEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f53061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SavedStateConfiguration f53062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f53063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SerializersModule f53064d;

    public SavedStateEncoder(Bundle savedState, SavedStateConfiguration configuration) {
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.f53061a = savedState;
        this.f53062b = configuration;
        this.f53063c = "";
        this.f53064d = configuration.c();
    }

    private final void K(Bundle bundle, String str) {
        if (this.f53062b.a() == 1) {
            boolean zB = SavedStateReader.b(SavedStateReader.a(bundle), "type");
            boolean zAreEqual = Intrinsics.areEqual(str, "type");
            if (zB && zAreEqual) {
                throw new IllegalArgumentException("SavedStateEncoder for " + SavedStateReader.J(SavedStateReader.a(bundle), "type") + " has property '" + str + "' that conflicts with the class discriminator. You can rename a property with @SerialName annotation.");
            }
        }
    }

    private final void L(boolean[] zArr) {
        SavedStateWriter.g(SavedStateWriter.a(this.f53061a), this.f53063c, zArr);
    }

    private final void M(char[] cArr) {
        SavedStateWriter.i(SavedStateWriter.a(this.f53061a), this.f53063c, cArr);
    }

    private final void N(double[] dArr) {
        SavedStateWriter.n(SavedStateWriter.a(this.f53061a), this.f53063c, dArr);
    }

    private final void O(float[] fArr) {
        SavedStateWriter.p(SavedStateWriter.a(this.f53061a), this.f53063c, fArr);
    }

    private final boolean P(SerializationStrategy serializationStrategy, Object obj) {
        if (SavedStateEncoder_androidKt.a(this, serializationStrategy, obj)) {
            return true;
        }
        SerialDescriptor descriptor = serializationStrategy.getDescriptor();
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.f())) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>");
            R((List) obj);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.i())) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            U((List) obj);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.a())) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.BooleanArray");
            L((boolean[]) obj);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.b())) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.CharArray");
            M((char[]) obj);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.c())) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.DoubleArray");
            N((double[]) obj);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.d())) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.FloatArray");
            O((float[]) obj);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.e())) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.IntArray");
            Q((int[]) obj);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.g())) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.LongArray");
            S((long[]) obj);
            return true;
        }
        if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.h())) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        T((String[]) obj);
        return true;
    }

    private final void Q(int[] iArr) {
        SavedStateWriter.r(SavedStateWriter.a(this.f53061a), this.f53063c, iArr);
    }

    private final void R(List list) {
        SavedStateWriter.s(SavedStateWriter.a(this.f53061a), this.f53063c, list);
    }

    private final void S(long[] jArr) {
        SavedStateWriter.v(SavedStateWriter.a(this.f53061a), this.f53063c, jArr);
    }

    private final void T(String[] strArr) {
        SavedStateWriter.G(SavedStateWriter.a(this.f53061a), this.f53063c, strArr);
    }

    private final void U(List list) {
        SavedStateWriter.H(SavedStateWriter.a(this.f53061a), this.f53063c, list);
    }

    private final void X(SavedStateConfiguration savedStateConfiguration, SerialDescriptor serialDescriptor, Bundle bundle) {
        if (savedStateConfiguration.a() == 1 && !SavedStateReader.b(SavedStateReader.a(bundle), "type")) {
            if (Intrinsics.areEqual(serialDescriptor.d(), StructureKind.CLASS.f142753a) || Intrinsics.areEqual(serialDescriptor.d(), StructureKind.OBJECT.f142756a)) {
                SavedStateWriter.F(SavedStateWriter.a(bundle), "type", serialDescriptor.i());
            }
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void B(int i3) {
        SavedStateWriter.q(SavedStateWriter.a(this.f53061a), this.f53063c, i3);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void G(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        SavedStateWriter.F(SavedStateWriter.a(this.f53061a), this.f53063c, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public boolean H(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        String strF = descriptor.f(i3);
        this.f53063c = strF;
        K(this.f53061a, strF);
        return true;
    }

    public final String V() {
        return this.f53063c;
    }

    public final Bundle W() {
        return this.f53061a;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public SerializersModule a() {
        return this.f53064d;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public CompositeEncoder b(SerialDescriptor descriptor) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (Intrinsics.areEqual(this.f53063c, "")) {
            X(this.f53062b, descriptor, this.f53061a);
            return this;
        }
        Map mapEmptyMap = MapsKt.emptyMap();
        if (mapEmptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(mapEmptyMap.size());
            for (Map.Entry entry : mapEmptyMap.entrySet()) {
                arrayList.add(TuplesKt.a((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleB = BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.a(bundleB);
        SavedStateWriter.A(SavedStateWriter.a(this.f53061a), this.f53063c, bundleB);
        X(this.f53062b, descriptor, bundleB);
        return new SavedStateEncoder(bundleB, this.f53062b);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void e(SerializationStrategy serializer, Object obj) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (P(serializer, obj)) {
            return;
        }
        super.e(serializer, obj);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void g(double d3) {
        SavedStateWriter.m(SavedStateWriter.a(this.f53061a), this.f53063c, d3);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void h(byte b3) {
        SavedStateWriter.q(SavedStateWriter.a(this.f53061a), this.f53063c, b3);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void k(SerialDescriptor enumDescriptor, int i3) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        SavedStateWriter.q(SavedStateWriter.a(this.f53061a), this.f53063c, i3);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void m(long j3) {
        SavedStateWriter.u(SavedStateWriter.a(this.f53061a), this.f53063c, j3);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void o() {
        SavedStateWriter.w(SavedStateWriter.a(this.f53061a), this.f53063c);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void q(short s2) {
        SavedStateWriter.q(SavedStateWriter.a(this.f53061a), this.f53063c, s2);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void r(boolean z2) {
        SavedStateWriter.f(SavedStateWriter.a(this.f53061a), this.f53063c, z2);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void t(float f3) {
        SavedStateWriter.o(SavedStateWriter.a(this.f53061a), this.f53063c, f3);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void u(char c3) {
        SavedStateWriter.h(SavedStateWriter.a(this.f53061a), this.f53063c, c3);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public boolean z(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.f53062b.b();
    }
}
