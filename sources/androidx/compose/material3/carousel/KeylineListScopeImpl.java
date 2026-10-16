package androidx.compose.material3.carousel;

import androidx.compose.material3.carousel.CarouselAlignment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

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
final class KeylineListScopeImpl implements KeylineListScope {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f21728b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f21730d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f21727a = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f21729c = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f21731e = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class TmpKeyline {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f21732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f21733b;

        public TmpKeyline(float f3, boolean z2) {
            this.f21732a = f3;
            this.f21733b = z2;
        }

        public final float a() {
            return this.f21732a;
        }

        public final boolean b() {
            return this.f21733b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TmpKeyline)) {
                return false;
            }
            TmpKeyline tmpKeyline = (TmpKeyline) obj;
            return Float.compare(this.f21732a, tmpKeyline.f21732a) == 0 && this.f21733b == tmpKeyline.f21733b;
        }

        public int hashCode() {
            return (Float.hashCode(this.f21732a) * 31) + Boolean.hashCode(this.f21733b);
        }

        public String toString() {
            return "TmpKeyline(size=" + this.f21732a + ", isAnchor=" + this.f21733b + ')';
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List c(int r28, float r29, int r30, int r31, float r32, float r33, float r34, java.util.List r35) {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.KeylineListScopeImpl.c(int, float, int, int, float, float, float, java.util.List):java.util.List");
    }

    private final int f() {
        int i3 = this.f21727a;
        while (i3 < CollectionsKt.getLastIndex(this.f21731e)) {
            int i4 = i3 + 1;
            if (((TmpKeyline) this.f21731e.get(i4)).a() != this.f21728b) {
                break;
            }
            i3 = i4;
        }
        return i3;
    }

    private final boolean g(float f3, float f4) {
        float f5 = f3 / 2;
        return f4 - f5 < 0.0f && f4 + f5 > 0.0f;
    }

    private final boolean h(float f3, float f4, float f5) {
        float f6 = f3 / 2;
        return f4 - f6 < f5 && f4 + f6 > f5;
    }

    @Override // androidx.compose.material3.carousel.KeylineListScope
    public void b(float f3, boolean z2) {
        this.f21731e.add(new TmpKeyline(f3, z2));
        if (f3 > this.f21728b) {
            this.f21727a = CollectionsKt.getLastIndex(this.f21731e);
            this.f21728b = f3;
        }
    }

    public final KeylineList d(float f3, float f4, int i3) {
        float f5;
        int iF = f();
        int i4 = this.f21727a;
        int i5 = iF - i4;
        this.f21729c = i4;
        CarouselAlignment.Companion companion = CarouselAlignment.f21611b;
        if (CarouselAlignment.f(i3, companion.a())) {
            float f6 = 0.0f;
            if (f4 != 0.0f) {
                int i6 = i5 % 2;
                if (i6 + ((((i6 ^ 2) & ((-i6) | i6)) >> 31) & 2) != 0) {
                    f6 = f4 / 2.0f;
                }
            }
            float f7 = 2;
            f5 = ((f3 / f7) - ((this.f21728b / f7) * i5)) - f6;
        } else {
            f5 = CarouselAlignment.f(i3, companion.b()) ? f3 - (this.f21728b / 2) : this.f21728b / 2;
        }
        this.f21730d = f5;
        return new KeylineList(c(this.f21729c, f5, this.f21727a, iF, this.f21728b, f3, f4, this.f21731e));
    }

    public final KeylineList e(float f3, float f4, int i3, float f5) {
        return new KeylineList(c(i3, f5, this.f21727a, f(), this.f21728b, f3, f4, this.f21731e));
    }
}
