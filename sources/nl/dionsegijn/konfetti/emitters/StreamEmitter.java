package nl.dionsegijn.konfetti.emitters;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

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
public final class StreamEmitter extends Emitter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f143752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f143753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f143754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f143755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f143756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f143757g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f143751i = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f143750h = -2;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void e() {
        if (g()) {
            return;
        }
        this.f143753c++;
        Function0 function0B = b();
        if (function0B != null) {
        }
    }

    private final boolean f() {
        long j3 = this.f143754d;
        return (j3 == 0 || j3 == f143750h || this.f143755e < ((float) j3)) ? false : true;
    }

    private final boolean g() {
        int i3 = this.f143753c;
        int i4 = this.f143752b;
        return 1 <= i4 && i3 >= i4;
    }

    @Override // nl.dionsegijn.konfetti.emitters.Emitter
    public void a(float f3) {
        float f4 = this.f143757g + f3;
        this.f143757g = f4;
        if (f4 >= this.f143756f && !f()) {
            Iterator<Integer> it = new IntRange(1, (int) (this.f143757g / this.f143756f)).iterator();
            while (it.hasNext()) {
                ((IntIterator) it).nextInt();
                e();
            }
            this.f143757g %= this.f143756f;
        }
        this.f143755e += f3 * 1000;
    }

    @Override // nl.dionsegijn.konfetti.emitters.Emitter
    public boolean c() {
        long j3 = this.f143754d;
        return j3 > 0 ? this.f143755e >= ((float) j3) : j3 != f143750h && this.f143753c >= this.f143752b;
    }
}
