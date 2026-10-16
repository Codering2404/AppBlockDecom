package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import androidx.window.layout.FoldingFeature;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class HardwareFoldingFeature implements FoldingFeature {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f54329d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bounds f54330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f54331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FoldingFeature.State f54332c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Bounds bounds) {
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            if (bounds.d() == 0 && bounds.a() == 0) {
                throw new IllegalArgumentException("Bounds must be non zero");
            }
            if (bounds.b() != 0 && bounds.c() != 0) {
                throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features");
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Type {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f54333b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Type f54334c = new Type("FOLD");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Type f54335d = new Type("HINGE");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f54336a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Type a() {
                return Type.f54334c;
            }

            public final Type b() {
                return Type.f54335d;
            }

            private Companion() {
            }
        }

        private Type(String str) {
            this.f54336a = str;
        }

        public String toString() {
            return this.f54336a;
        }
    }

    public HardwareFoldingFeature(Bounds featureBounds, Type type, FoldingFeature.State state) {
        Intrinsics.checkNotNullParameter(featureBounds, "featureBounds");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(state, "state");
        this.f54330a = featureBounds;
        this.f54331b = type;
        this.f54332c = state;
        f54329d.a(featureBounds);
    }

    @Override // androidx.window.layout.FoldingFeature
    public boolean a() {
        Type type = this.f54331b;
        Type.Companion companion = Type.f54333b;
        if (Intrinsics.areEqual(type, companion.b())) {
            return true;
        }
        return Intrinsics.areEqual(this.f54331b, companion.a()) && Intrinsics.areEqual(getState(), FoldingFeature.State.f54327d);
    }

    @Override // androidx.window.layout.FoldingFeature
    public FoldingFeature.OcclusionType b() {
        return (this.f54330a.d() == 0 || this.f54330a.a() == 0) ? FoldingFeature.OcclusionType.f54318c : FoldingFeature.OcclusionType.f54319d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(HardwareFoldingFeature.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        HardwareFoldingFeature hardwareFoldingFeature = (HardwareFoldingFeature) obj;
        return Intrinsics.areEqual(this.f54330a, hardwareFoldingFeature.f54330a) && Intrinsics.areEqual(this.f54331b, hardwareFoldingFeature.f54331b) && Intrinsics.areEqual(getState(), hardwareFoldingFeature.getState());
    }

    @Override // androidx.window.layout.DisplayFeature
    public Rect getBounds() {
        return this.f54330a.f();
    }

    @Override // androidx.window.layout.FoldingFeature
    public FoldingFeature.Orientation getOrientation() {
        return this.f54330a.d() > this.f54330a.a() ? FoldingFeature.Orientation.f54323d : FoldingFeature.Orientation.f54322c;
    }

    @Override // androidx.window.layout.FoldingFeature
    public FoldingFeature.State getState() {
        return this.f54332c;
    }

    public int hashCode() {
        return (((this.f54330a.hashCode() * 31) + this.f54331b.hashCode()) * 31) + getState().hashCode();
    }

    public String toString() {
        return HardwareFoldingFeature.class.getSimpleName() + " { " + this.f54330a + ", type=" + this.f54331b + ", state=" + getState() + " }";
    }
}
