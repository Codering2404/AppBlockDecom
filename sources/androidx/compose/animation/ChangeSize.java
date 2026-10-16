package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
public final class ChangeSize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Alignment f3431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f3432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FiniteAnimationSpec f3433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f3434d;

    /* JADX INFO: renamed from: androidx.compose.animation.ChangeSize$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function1<IntSize, IntSize> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f3435a = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        public final long c(long j3) {
            long j4 = 0;
            return IntSize.c((j4 & 4294967295L) | (j4 << 32));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntSize.b(c(((IntSize) obj).j()));
        }
    }

    public ChangeSize(Alignment alignment, Function1 function1, FiniteAnimationSpec finiteAnimationSpec, boolean z2) {
        this.f3431a = alignment;
        this.f3432b = function1;
        this.f3433c = finiteAnimationSpec;
        this.f3434d = z2;
    }

    public final Alignment a() {
        return this.f3431a;
    }

    public final FiniteAnimationSpec b() {
        return this.f3433c;
    }

    public final boolean c() {
        return this.f3434d;
    }

    public final Function1 d() {
        return this.f3432b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangeSize)) {
            return false;
        }
        ChangeSize changeSize = (ChangeSize) obj;
        return Intrinsics.areEqual(this.f3431a, changeSize.f3431a) && Intrinsics.areEqual(this.f3432b, changeSize.f3432b) && Intrinsics.areEqual(this.f3433c, changeSize.f3433c) && this.f3434d == changeSize.f3434d;
    }

    public int hashCode() {
        return (((((this.f3431a.hashCode() * 31) + this.f3432b.hashCode()) * 31) + this.f3433c.hashCode()) * 31) + Boolean.hashCode(this.f3434d);
    }

    public String toString() {
        return "ChangeSize(alignment=" + this.f3431a + ", size=" + this.f3432b + ", animationSpec=" + this.f3433c + ", clip=" + this.f3434d + ')';
    }
}
