package androidx.paging;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class ViewportHint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f50714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f50715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f50716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f50717d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Access extends ViewportHint {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f50718e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f50719f;

        public Access(int i3, int i4, int i5, int i6, int i7, int i8) {
            super(i5, i6, i7, i8, null);
            this.f50718e = i3;
            this.f50719f = i4;
        }

        @Override // androidx.paging.ViewportHint
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Access)) {
                return false;
            }
            Access access = (Access) obj;
            return this.f50718e == access.f50718e && this.f50719f == access.f50719f && d() == access.d() && c() == access.c() && a() == access.a() && b() == access.b();
        }

        public final int f() {
            return this.f50719f;
        }

        public final int g() {
            return this.f50718e;
        }

        @Override // androidx.paging.ViewportHint
        public int hashCode() {
            return super.hashCode() + Integer.hashCode(this.f50718e) + Integer.hashCode(this.f50719f);
        }

        public String toString() {
            return StringsKt.p("ViewportHint.Access(\n            |    pageOffset=" + this.f50718e + ",\n            |    indexInPage=" + this.f50719f + ",\n            |    presentedItemsBefore=" + d() + ",\n            |    presentedItemsAfter=" + c() + ",\n            |    originalPageOffsetFirst=" + a() + ",\n            |    originalPageOffsetLast=" + b() + ",\n            |)", null, 1, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Initial extends ViewportHint {
        public Initial(int i3, int i4, int i5, int i6) {
            super(i3, i4, i5, i6, null);
        }

        public String toString() {
            return StringsKt.p("ViewportHint.Initial(\n            |    presentedItemsBefore=" + d() + ",\n            |    presentedItemsAfter=" + c() + ",\n            |    originalPageOffsetFirst=" + a() + ",\n            |    originalPageOffsetLast=" + b() + ",\n            |)", null, 1, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f50720a;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.PREPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f50720a = iArr;
        }
    }

    public /* synthetic */ ViewportHint(int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, i5, i6);
    }

    public final int a() {
        return this.f50716c;
    }

    public final int b() {
        return this.f50717d;
    }

    public final int c() {
        return this.f50715b;
    }

    public final int d() {
        return this.f50714a;
    }

    public final int e(LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i3 = WhenMappings.f50720a[loadType.ordinal()];
        if (i3 == 1) {
            throw new IllegalArgumentException("Cannot get presentedItems for loadType: REFRESH");
        }
        if (i3 == 2) {
            return this.f50714a;
        }
        if (i3 == 3) {
            return this.f50715b;
        }
        throw new NoWhenBranchMatchedException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewportHint)) {
            return false;
        }
        ViewportHint viewportHint = (ViewportHint) obj;
        return this.f50714a == viewportHint.f50714a && this.f50715b == viewportHint.f50715b && this.f50716c == viewportHint.f50716c && this.f50717d == viewportHint.f50717d;
    }

    public int hashCode() {
        return Integer.hashCode(this.f50714a) + Integer.hashCode(this.f50715b) + Integer.hashCode(this.f50716c) + Integer.hashCode(this.f50717d);
    }

    private ViewportHint(int i3, int i4, int i5, int i6) {
        this.f50714a = i3;
        this.f50715b = i4;
        this.f50716c = i5;
        this.f50717d = i6;
    }
}
