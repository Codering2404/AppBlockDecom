package kotlin.reflect;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class KTypeProjection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f140261c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final KTypeProjection f140262d = new KTypeProjection(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KVariance f140263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final KType f140264b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f140265a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.f140266a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.f140267b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.f140268c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f140265a = iArr;
        }
    }

    public KTypeProjection(KVariance kVariance, KType kType) {
        String str;
        this.f140263a = kVariance;
        this.f140264b = kType;
        if ((kVariance == null) == (kType == null)) {
            return;
        }
        if (kVariance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + kVariance + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public final KVariance a() {
        return this.f140263a;
    }

    public final KType b() {
        return this.f140264b;
    }

    public final KType c() {
        return this.f140264b;
    }

    public final KVariance d() {
        return this.f140263a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KTypeProjection)) {
            return false;
        }
        KTypeProjection kTypeProjection = (KTypeProjection) obj;
        return this.f140263a == kTypeProjection.f140263a && Intrinsics.areEqual(this.f140264b, kTypeProjection.f140264b);
    }

    public int hashCode() {
        KVariance kVariance = this.f140263a;
        int iHashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        KType kType = this.f140264b;
        return iHashCode + (kType != null ? kType.hashCode() : 0);
    }

    public String toString() {
        KVariance kVariance = this.f140263a;
        int i3 = kVariance == null ? -1 : WhenMappings.f140265a[kVariance.ordinal()];
        if (i3 == -1) {
            return "*";
        }
        if (i3 == 1) {
            return String.valueOf(this.f140264b);
        }
        if (i3 == 2) {
            return "in " + this.f140264b;
        }
        if (i3 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "out " + this.f140264b;
    }
}
