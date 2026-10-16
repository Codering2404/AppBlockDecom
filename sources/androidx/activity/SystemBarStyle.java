package androidx.activity;

import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class SystemBarStyle {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f419e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f423d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ SystemBarStyle b(Companion companion, int i3, int i4, Function1 function1, int i5, Object obj) {
            if ((i5 & 4) != 0) {
                function1 = new Function1<Resources, Boolean>() { // from class: androidx.activity.SystemBarStyle$Companion$auto$1
                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final Boolean invoke(Resources resources) {
                        Intrinsics.checkNotNullParameter(resources, "resources");
                        return Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
                    }
                };
            }
            return companion.a(i3, i4, function1);
        }

        public final SystemBarStyle a(int i3, int i4, Function1 detectDarkMode) {
            Intrinsics.checkNotNullParameter(detectDarkMode, "detectDarkMode");
            return new SystemBarStyle(i3, i4, 0, detectDarkMode, null);
        }

        public final SystemBarStyle c(int i3) {
            return new SystemBarStyle(i3, i3, 2, new Function1<Resources, Boolean>() { // from class: androidx.activity.SystemBarStyle$Companion$dark$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(Resources resources) {
                    Intrinsics.checkNotNullParameter(resources, "<anonymous parameter 0>");
                    return Boolean.TRUE;
                }
            }, null);
        }

        public final SystemBarStyle d(int i3, int i4) {
            return new SystemBarStyle(i3, i4, 1, new Function1<Resources, Boolean>() { // from class: androidx.activity.SystemBarStyle$Companion$light$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(Resources resources) {
                    Intrinsics.checkNotNullParameter(resources, "<anonymous parameter 0>");
                    return Boolean.FALSE;
                }
            }, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SystemBarStyle(int i3, int i4, int i5, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, i5, function1);
    }

    public final int a() {
        return this.f421b;
    }

    public final Function1 b() {
        return this.f423d;
    }

    public final int c() {
        return this.f422c;
    }

    public final int d(boolean z2) {
        return z2 ? this.f421b : this.f420a;
    }

    public final int e(boolean z2) {
        if (this.f422c == 0) {
            return 0;
        }
        return z2 ? this.f421b : this.f420a;
    }

    private SystemBarStyle(int i3, int i4, int i5, Function1 function1) {
        this.f420a = i3;
        this.f421b = i4;
        this.f422c = i5;
        this.f423d = function1;
    }
}
