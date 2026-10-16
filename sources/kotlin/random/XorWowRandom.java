package kotlin.random;

import java.io.InvalidObjectException;
import java.io.Serializable;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class XorWowRandom extends Random implements Serializable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Companion f140185j = new Companion(null);
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f140186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f140187d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f140188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f140189g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f140190h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f140191i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public XorWowRandom(int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f140186c = i3;
        this.f140187d = i4;
        this.f140188f = i5;
        this.f140189g = i6;
        this.f140190h = i7;
        this.f140191i = i8;
        n();
        for (int i9 = 0; i9 < 64; i9++) {
            i();
        }
    }

    private final void n() {
        if ((this.f140186c | this.f140187d | this.f140188f | this.f140189g | this.f140190h) == 0) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.");
        }
    }

    private final Object readResolve() throws Throwable {
        try {
            n();
            return this;
        } catch (Throwable th) {
            Throwable thInitCause = new InvalidObjectException(th.getMessage()).initCause(th);
            Intrinsics.checkNotNullExpressionValue(thInitCause, "initCause(...)");
            throw thInitCause;
        }
    }

    @Override // kotlin.random.Random
    public int b(int i3) {
        return RandomKt.i(i(), i3);
    }

    @Override // kotlin.random.Random
    public int i() {
        int i3 = this.f140186c;
        int i4 = i3 ^ (i3 >>> 2);
        this.f140186c = this.f140187d;
        this.f140187d = this.f140188f;
        this.f140188f = this.f140189g;
        int i5 = this.f140190h;
        this.f140189g = i5;
        int i6 = ((i4 ^ (i4 << 1)) ^ i5) ^ (i5 << 4);
        this.f140190h = i6;
        int i7 = this.f140191i + 362437;
        this.f140191i = i7;
        return i6 + i7;
    }

    public XorWowRandom(int i3, int i4) {
        this(i3, i4, 0, 0, ~i3, (i3 << 10) ^ (i4 >>> 4));
    }
}
