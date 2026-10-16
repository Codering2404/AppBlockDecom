package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SavedStateDecoder extends AbstractDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f53056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SavedStateConfiguration f53057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f53058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f53059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SerializersModule f53060e;

    public SavedStateDecoder(Bundle savedState, SavedStateConfiguration configuration) {
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.f53056a = savedState;
        this.f53057b = configuration;
        this.f53058c = "";
        this.f53060e = configuration.c();
    }

    private final boolean[] K() {
        return SavedStateReader.h(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    private final char[] L() {
        return SavedStateReader.k(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    private final double[] M() {
        return SavedStateReader.p(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    private static final boolean N(SerialDescriptor serialDescriptor, int i3) {
        return serialDescriptor.j(i3);
    }

    private static final boolean O(SavedStateDecoder savedStateDecoder, SerialDescriptor serialDescriptor, int i3) {
        return SavedStateReader.b(SavedStateReader.a(savedStateDecoder.f53056a), serialDescriptor.f(i3));
    }

    private final float[] P() {
        return SavedStateReader.r(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    private final Object Q(DeserializationStrategy deserializationStrategy) {
        Object objA = SavedStateDecoder_androidKt.a(this, deserializationStrategy);
        if (objA != null) {
            return objA;
        }
        SerialDescriptor descriptor = deserializationStrategy.getDescriptor();
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.f())) {
            return S();
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.i())) {
            return V();
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.a())) {
            return K();
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.b())) {
            return L();
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.c())) {
            return M();
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.d())) {
            return P();
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.e())) {
            return R();
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.g())) {
            return T();
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.h())) {
            return U();
        }
        return null;
    }

    private final int[] R() {
        return SavedStateReader.t(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    private final List S() {
        return SavedStateReader.u(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    private final long[] T() {
        return SavedStateReader.x(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    private final String[] U() {
        return SavedStateReader.K(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    private final List V() {
        return SavedStateReader.L(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public boolean D() {
        return !SavedStateReader.P(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public byte H() {
        return (byte) SavedStateReader.s(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    public final String W() {
        return this.f53058c;
    }

    public final Bundle X() {
        return this.f53056a;
    }

    @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule a() {
        return this.f53060e;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder b(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return Intrinsics.areEqual(this.f53058c, "") ? this : new SavedStateDecoder(SavedStateReader.C(SavedStateReader.a(this.f53056a), this.f53058c), this.f53057b);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int e(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return SavedStateReader.s(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int h() {
        return SavedStateReader.s(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public long l() {
        return SavedStateReader.w(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int o(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int iQ = (Intrinsics.areEqual(descriptor.d(), StructureKind.LIST.f142754a) || Intrinsics.areEqual(descriptor.d(), StructureKind.MAP.f142755a)) ? SavedStateReader.Q(SavedStateReader.a(this.f53056a)) : descriptor.e();
        while (true) {
            int i3 = this.f53059d;
            if (i3 >= iQ || !N(descriptor, i3) || O(this, descriptor, this.f53059d)) {
                break;
            }
            this.f53059d++;
        }
        int i4 = this.f53059d;
        if (i4 >= iQ) {
            return -1;
        }
        this.f53058c = descriptor.f(i4);
        int i5 = this.f53059d;
        this.f53059d = i5 + 1;
        return i5;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public short s() {
        return (short) SavedStateReader.s(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public float t() {
        return SavedStateReader.q(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public double v() {
        return SavedStateReader.o(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public boolean w() {
        return SavedStateReader.g(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public char x() {
        return SavedStateReader.j(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public String z() {
        return SavedStateReader.J(SavedStateReader.a(this.f53056a), this.f53058c);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public Object G(DeserializationStrategy deserializationStrategy) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, SbbqvQlxi.qbwhFhWsYWCVKI);
        Object objQ = Q(deserializationStrategy);
        return objQ == null ? super.G(deserializationStrategy) : objQ;
    }
}
