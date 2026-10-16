package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public abstract class CardType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Color f130346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Dp f130347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Dp f130348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Dp f130349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Alignment.Vertical f130350e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Bordered extends CardType {
        public /* synthetic */ Bordered(Dp dp, Color color, DefaultConstructorMarker defaultConstructorMarker) {
            this(dp, color);
        }

        public /* synthetic */ Bordered(Dp dp, Color color, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : dp, (i3 & 2) != 0 ? null : color, null);
        }

        private Bordered(Dp dp, Color color) {
            super(color, Dp.d(Dp.g(0)), null, dp, null, 20, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Critical extends CardType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Custom extends CardType {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f130351f;

        public /* synthetic */ Custom(long j3, Color color, Dp dp, Dp dp2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, color, dp, dp2);
        }

        public final long f() {
            return this.f130351f;
        }

        private Custom(long j3, Color color, Dp dp, Dp dp2) {
            super(color, dp, dp2, null, null, 24, null);
            this.f130351f = j3;
        }

        public /* synthetic */ Custom(long j3, Color color, Dp dp, Dp dp2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, (i3 & 2) != 0 ? null : color, (i3 & 4) != 0 ? null : dp, (i3 & 8) != 0 ? null : dp2, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Dashed extends CardType {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Dashed f130352f = new Dashed();

        private Dashed() {
            super(null, Dp.d(Dp.g(0)), null, null, null, 29, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Dashed);
        }

        public int hashCode() {
            return 104672091;
        }

        public String toString() {
            return "Dashed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Disabled extends CardType {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Color f130353f;

        public /* synthetic */ Disabled(Color color, Alignment.Vertical vertical, DefaultConstructorMarker defaultConstructorMarker) {
            this(color, vertical);
        }

        public final Color f() {
            return this.f130353f;
        }

        public /* synthetic */ Disabled(Color color, Alignment.Vertical vertical, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : color, (i3 & 2) != 0 ? null : vertical, null);
        }

        private Disabled(Color color, Alignment.Vertical vertical) {
            super(null, Dp.d(Dp.g(0)), null, null, vertical, 13, null);
            this.f130353f = color;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Surface extends CardType {
        public /* synthetic */ Surface(Color color, Dp dp, Alignment.Vertical vertical, DefaultConstructorMarker defaultConstructorMarker) {
            this(color, dp, vertical);
        }

        private Surface(Color color, Dp dp, Alignment.Vertical vertical) {
            super(color, dp, null, null, vertical, 12, null);
        }

        public /* synthetic */ Surface(Color color, Dp dp, Alignment.Vertical vertical, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : color, (i3 & 2) != 0 ? null : dp, (i3 & 4) != 0 ? null : vertical, null);
        }
    }

    public /* synthetic */ CardType(Color color, Dp dp, Dp dp2, Dp dp3, Alignment.Vertical vertical, DefaultConstructorMarker defaultConstructorMarker) {
        this(color, dp, dp2, dp3, vertical);
    }

    public final Color a() {
        return this.f130346a;
    }

    public final Dp b() {
        return this.f130348c;
    }

    public final Dp c() {
        return this.f130349d;
    }

    public final Dp d() {
        return this.f130347b;
    }

    public final Alignment.Vertical e() {
        return this.f130350e;
    }

    private CardType(Color color, Dp dp, Dp dp2, Dp dp3, Alignment.Vertical vertical) {
        this.f130346a = color;
        this.f130347b = dp;
        this.f130348c = dp2;
        this.f130349d = dp3;
        this.f130350e = vertical;
    }

    public /* synthetic */ CardType(Color color, Dp dp, Dp dp2, Dp dp3, Alignment.Vertical vertical, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : color, dp, (i3 & 4) != 0 ? null : dp2, (i3 & 8) != 0 ? null : dp3, (i3 & 16) != 0 ? null : vertical, null);
    }
}
